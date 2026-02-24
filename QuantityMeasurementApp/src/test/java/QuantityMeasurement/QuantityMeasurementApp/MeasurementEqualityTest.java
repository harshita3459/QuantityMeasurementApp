package QuantityMeasurement.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementEqualityTest {

    // UC1 - Feet Tests
    @Test
    void testFeetEquality_SameValue() {
        UC1FeetMeasurement.Feet f1 = new UC1FeetMeasurement.Feet(1.0);
        UC1FeetMeasurement.Feet f2 = new UC1FeetMeasurement.Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(
            new UC1FeetMeasurement.Feet(1.0)
                .equals(new UC1FeetMeasurement.Feet(2.0))
        );
    }

    @Test
    void testFeetEquality_Null() {
        assertFalse(new UC1FeetMeasurement.Feet(1.0).equals(null));
    }

    @Test
    void testFeetEquality_TypeMismatch() {
        assertFalse(new UC1FeetMeasurement.Feet(1.0).equals("abc"));
    }

    @Test
    void testFeetEquality_SameReference() {
        UC1FeetMeasurement.Feet f = new UC1FeetMeasurement.Feet(1.0);
        assertTrue(f.equals(f));
    }

    // UC2 - Inch Tests
    @Test
    void testInchEquality_SameValue() {
        assertTrue(
            new UC1FeetMeasurement.Inches(5.0)
                .equals(new UC1FeetMeasurement.Inches(5.0))
        );
    }

    @Test
    void testInchEquality_DifferentValue() {
        assertFalse(
            new UC1FeetMeasurement.Inches(5.0)
                .equals(new UC1FeetMeasurement.Inches(6.0))
        );
    }

    @Test
    void testInchEquality_Null() {
        assertFalse(new UC1FeetMeasurement.Inches(5.0).equals(null));
    }

    @Test
    void testInchEquality_TypeMismatch() {
        assertFalse(new UC1FeetMeasurement.Inches(5.0)
                .equals(new UC1FeetMeasurement.Feet(5.0)));
    }

    @Test
    void testInchEquality_SameReference() {
        UC1FeetMeasurement.Inches i = new UC1FeetMeasurement.Inches(5.0);
        assertTrue(i.equals(i));
    }
}
