import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class FileWriter {

	private static File file;
	private static FileOutputStream outputStream;
	private static OutputStreamWriter outputStreamWriter;
	private static Writer out;

	private static void init() {
		try {
			file = new File("test.txt");
			outputStream = new FileOutputStream(file);
			outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
			out = new BufferedWriter(outputStreamWriter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void write(String text, String url, Double price, Long year) {
		if (outputStream == null) {
			init();
		}
		try {
			
//			for (String token : text.split(" ")) {
//				System.out.println(token);
//			}
			
			out.write(text + "\n" + url + "\n" + price + "\n" + year);
			out.write("\n------------\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
