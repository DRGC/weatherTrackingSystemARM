package DAO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 29/05/15.
 */
public class dataDAOTest {
    dataDAO dao = new dataDAO();

    @Test
    public void testTemperatureGenerator() throws Exception {
        System.out.print(dao.temperatureGenerator());
    }

    @Test
    public void testHumidityGenerator() throws Exception {

    }

    @Test
    public void testLightGenerator() throws Exception {

    }
}