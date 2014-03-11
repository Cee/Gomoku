package gomoku.option;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save {
	public static void save() throws IOException {
		/*±£´æÐÞ¸Ä*/
			DataOutputStream output = new DataOutputStream(new FileOutputStream("option.dat"));
			output.writeUTF(Set.getTheme());
			output.writeUTF(Set.getLanguage());
			output.writeUTF((Set.getBGM()));
			output.close();
	}
	
}
