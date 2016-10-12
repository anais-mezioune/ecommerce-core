package com.formation.services;

import com.formation.exceptions.MetierException;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DBServiceTest {

    @Test
    public void testConfigureWhithEmptyIp() {
        // Given
        DBService.reset();
        String ip = "";
        String dbName = "osef";

        // When
        try {
            DBService.configure(ip, dbName);

            assertFalse(true);
        } catch (MetierException me) {
            // Then
            System.out.println(me.getMessage());
            assertTrue(true);
        }
    }
    @Test
    public void testConfigureWhithEmptyDbName() {
        // Given
        DBService.reset();
        String ip = "osef";
        String dbName = "";

        // When
        try {
            DBService.configure(ip, dbName);

            assertFalse(true);
        } catch (MetierException me) {
            // Then
            System.out.println(me.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testConfigureWhithNullIp() {
        // Given
        DBService.reset();
        String ip = null;
        String dbName = "osef";

        // When
        try {
            DBService.configure(ip, dbName);

            assertFalse(true);
        } catch (MetierException me) {
            // Then
            System.out.println(me.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testConfigureWhithNullDbName() {
        // Given
        DBService.reset();
        String ip = "osef";
        String dbName = null;

        // When
        try {
            DBService.configure(ip, dbName);

            assertFalse(true);
        } catch (MetierException me) {
            // Then
            System.out.println(me.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testConfigureWithGoodIp() {
        // Given
        DBService.reset();
        String ip = "192.168.1.39";
        String dbName = "ecommerce-test";

        // When
        try {
            DBService.configure(ip, dbName);
        } catch (MetierException e) {
            assertTrue(false);
        }

        // Then
        Connection connection = DBService.getInstance().getConnection();
        try {
            assertTrue(connection.getMetaData().getURL().contains(ip));
        } catch (SQLException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testCreateStatement() {
        // Given
        DBService.reset();
        try {
            DBService.configure("192.168.1.39", "ecommerce-test");
        } catch (MetierException e) {
            assertTrue(false);
        }

        // When
        try {
            Statement statement = DBService.getInstance().createStatement();
            // Then
            assertNotNull(statement);
        } catch (SQLException e) {
            assertTrue(false);
        }
    }

}
