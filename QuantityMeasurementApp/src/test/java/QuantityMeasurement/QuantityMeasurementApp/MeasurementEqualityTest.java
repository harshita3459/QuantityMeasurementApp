package QuantityMeasurement.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementTest {

    @Test
    void testEquality_SameValue() {
        UC1FeetMeasurement.Feet f1 = new UC1FeetMeasurement.Feet(1.0);
        UC1FeetMeasurement.Feet f2 = new UC1FeetMeasurement.Feet(1.0);

        assertTrue(f1.equals(f2), "1.0 ft should equal 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
        UC1FeetMeasurement.Feet f1 = new UC1FeetMeasurement.Feet(1.0);
        UC1FeetMeasurement.Feet f2 = new UC1FeetMeasurement.Feet(2.0);

        assertFalse(f1.equals(f2), "1.0 ft should not equal 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
        UC1FeetMeasurement.Feet f1 = new UC1FeetMeasurement.Feet(1.0);

        assertFalse(f1.equals(null), "Feet should not equal null");
    }

    @Test
    void testEquality_NonNumericInput() {
        UC1FeetMeasurement.Feet f1 = new UC1FeetMeasurement.Feet(1.0);

        assertFalse(f1.equals("1.0"), "Feet should not equal non-Feet object");
    }

    @Test
    void testEquality_SameReference() {
        UC1FeetMeasurement.Feet f1 = new UC1FeetMeasurement.Feet(1.0);

        assertTrue(f1.equals(f1), "Object must equal itself");
    }
}
