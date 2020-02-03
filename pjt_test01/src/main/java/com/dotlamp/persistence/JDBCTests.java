package com.dotlamp.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	/* JDBC 드라이버만 구현하여 DB 연결여부 테스트 */

	static {
		try {
			Class.forName("oracle.jdbc.drvier.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "book_ex", "book_ex")){
			log.info(con);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
