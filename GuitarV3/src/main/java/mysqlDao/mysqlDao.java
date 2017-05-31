package mysqlDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dao.GuitarDao;
import model.Builder;
import model.Type;
import model.Wood;
import model.Guitar;
import model.GuitarSpec;
import util.MysqlJDBC;
import util.SqliteJDBC;

public class mysqlDao implements GuitarDao {
	private LinkedList guitars = new LinkedList();
	private String sql;
	private String specSql;
	private PreparedStatement pstmt;
	private PreparedStatement sp;
	private String d_g_sql;
	private String d_gs_sql;

	/**
	 * 通过编码查询吉他
	 * 
	 * @param serialNumber
	 * @return
	 */
	public Guitar getGuitar(String serialNumber) {
		for (Iterator i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	/**
	 * 获取guitar中的所有对象
	 * 
	 * @return
	 */
	public List<Guitar> guitarList() {
		sql = "select * from guitar;";
		specSql = "select * from guitarSpec where spec= ";
		try {
			pstmt = MysqlJDBC.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String serialNumber = rs.getString("serialNumber");
				double price = rs.getDouble("price");
				int id = rs.getInt("spec");
				sp = MysqlJDBC.getConnection().prepareStatement(specSql + id);
				ResultSet spec1 = sp.executeQuery();
				while (spec1.next()) {
					String builder = spec1.getString("builder");
					String model = spec1.getString("model");
					String type = spec1.getString("type");
					String backWood = spec1.getString("backWood");
					String topWood = spec1.getString("topWood");
					int numStrings = spec1.getInt("numStrings");
					GuitarSpec spec = new GuitarSpec(Builder.valueOf(builder.toUpperCase()), model,
							Type.valueOf(type.toUpperCase()), Wood.valueOf(backWood.toUpperCase()),
							Wood.valueOf(topWood.toUpperCase()), numStrings);
					Guitar guitar = new Guitar(serialNumber, price, spec, id);
					guitars.add(guitar);
				}
				sp.close();
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guitars;
	}

	/**
	 * 添加新的吉他
	 * 
	 * @param serialNumber
	 * @param price
	 * @param builder
	 * @param model
	 * @param type
	 * @param backWood
	 * @param topWood
	 */
	public void addGuitar(String serialNumber, double price, GuitarSpec spec, int id) {
		Guitar guitar = new Guitar(serialNumber, price, spec, id);
		guitars.add(guitar);
		try {
			// 添加数据的sql语句
			String gs_sql = "insert into guitarSpec(spec,builder,model,type,backWood,topWood,numStrings)" + " values ("
					+ id + "," + spec.getModel() + "," + spec.getType() + "," + spec.getBackWood() + ","
					+ spec.getTopWood() + "," + spec.getNumStrings() + ")";
			String g_sql = "insert into guitar(serialNumber,price,spec)" + "values(" + serialNumber + "," + price + ","
					+ id + ")";
			// 创建用于执行静态sql语句的Statement对象
			Statement stmt1 = SqliteJDBC.getConnection().createStatement();
			// 执行插入操作的sql语句，并返回插入数据的个数
			stmt1.executeUpdate(sql);
			stmt1.executeUpdate(g_sql);
			// 关闭数据库连接
			stmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除吉他
	 * 
	 */
	public void deleteGuitar(int spec) {
		d_g_sql = "delete from guitar where spec=";
		d_gs_sql = "delete from guitarSpec where spec=";
		try {
			Statement stmt = MysqlJDBC.getConnection().createStatement();
			stmt.executeUpdate(d_g_sql + spec);
			stmt.executeUpdate(d_gs_sql + spec);
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
