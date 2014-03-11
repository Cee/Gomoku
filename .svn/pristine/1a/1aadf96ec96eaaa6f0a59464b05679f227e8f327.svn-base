package gomoku.option;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Load {
	public static void read() throws ClassNotFoundException, IOException {
		DataInputStream inputStream = new DataInputStream(new FileInputStream("option.dat"));
		Set.setTheme(inputStream.readUTF());
		Set.setLanguage(inputStream.readUTF());
		Set.setBGM(inputStream.readUTF());
		inputStream.close();
	}
}
