package tests;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class memoryTest {
    @Test
    public void testReadFile() {
        try {
            FileWriter fileWriter = new FileWriter("");
            fileWriter.write("TESTTTT");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("BRUHHHH");
        }
    }
}