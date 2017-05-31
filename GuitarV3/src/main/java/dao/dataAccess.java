package dao;


public class dataAccess {
	private static String db = "mysql";
	public static GuitarDao createGuitarDao(){
		GuitarDao result = null;	
		switch(db){
		case "sqlite":
			result =new sqliteDao.sqliteDao();
			break;
		case "mysql":
			result =new mysqlDao.mysqlDao();
			break;
		}
	return result;
	}
}
