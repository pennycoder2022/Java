package foundational;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class HelloThereTest {
	@Test
	public void test_sayHelloThere()  {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream str = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(str));

		HelloThere.sayHelloThere();
		
		assertEquals("Hello Guys!".trim(), str.toString().trim());

		System.setOut(originalOut);
	}
}
