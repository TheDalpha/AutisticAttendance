/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author ollie
 */
public class DataBaseConnector
{
    private SQLServerDataSource dataSource = new SQLServerDataSource();

    /*
    * sets the database sources.
    */
    public DataBaseConnector()
    {;
        dataSource.setServerName("EASV-DB2");
        dataSource.setPortNumber(1433);
        dataSource.setDatabaseName("AutisticAttendance");
        dataSource.setUser("CS2017A_27");
        dataSource.setPassword("Donttype12398");
    }
    
    /*
    * gets the connection to the database
    */
    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }
    
}
