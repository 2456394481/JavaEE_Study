package com.tyb.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static DataSource dataSource = new ComboPooledDataSource();
	
	private DataSourceUtils() {
		
	}
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);		
	}
}
