package com.mysql;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MySQLAccess dao = new MySQLAccess();
		String test = dao.readDataBase();
		System.out.println(test);
	}

}
