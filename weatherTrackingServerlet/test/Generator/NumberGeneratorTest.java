package Generator;

import DAO.dataDAO;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import sun.jvm.hotspot.utilities.AssertionFailure;

import static org.junit.Assert.*;

/**
 * Created by David on 4/06/15.
 */
public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();
    private final static int TemperatureIndex = 0;
    private final static int HumidityIndex = 1;
    private final static int LightIndex = 2;

    @Test
    public void testGenerator() throws Exception {
        boolean[] setSensors = new boolean[3];
        setSensors[0] = true;
        setSensors[1] = true;
        setSensors[2] = true;

        System.out.println(setSensors[0]);
        System.out.println(setSensors[1]);
        System.out.println(setSensors[2]);

        numberGenerator.enableTemperature(setSensors[TemperatureIndex]);
        numberGenerator.enableHumidity(setSensors[HumidityIndex]);
        numberGenerator.enableLight(setSensors[LightIndex]);

        System.out.println("");
        System.out.println(numberGenerator.temperatureGenerator());
        System.out.println(numberGenerator.humidityGenerator());
        System.out.println(numberGenerator.lightGenerator());

        if (setSensors[0] == false && numberGenerator.temperatureGenerator() != -1) {
            fail("Temperature test failed, Sensor is off but still generating values");
        } else if (setSensors[0] == true && numberGenerator.temperatureGenerator() != -1
                && numberGenerator.temperatureGenerator() < 16
                && numberGenerator.temperatureGenerator() > 38) {
            fail("Temperature test failed, Sensor is on but generating incorrect values");
            }
        if (setSensors[1] == false && numberGenerator.humidityGenerator() != -1) {
            fail("Humidity test failed, Sensor is off but still generating values");
        } else if (setSensors[1] == true && numberGenerator.humidityGenerator() != -1
                && numberGenerator.humidityGenerator() < 10
                && numberGenerator.humidityGenerator() > 90) {
            fail("Humidity test failed, Sensor is on but generating incorrect values");
        }
        if (setSensors[2] == false && numberGenerator.lightGenerator() != -1) {
            fail("Light test failed, Sensor is off but still generating values");
        } else if (setSensors[2] == true && numberGenerator.lightGenerator() != -1
                && numberGenerator.lightGenerator() < 0
                && numberGenerator.lightGenerator() > 100) {
            fail("Light test failed, Sensor is on but generating incorrect values");
        }
    }
}