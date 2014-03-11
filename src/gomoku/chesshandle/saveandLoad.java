package gomoku.chesshandle;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class saveandLoad {
	
	public static void Save(ArrayList<Integer[]> history, String fileName) {		
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName+".dat"));
			for (Integer[] eachstep: history) {
				output.writeInt(eachstep[0]);
				output.writeInt(eachstep[1]);
				output.writeInt(eachstep[2]);
				output.writeInt(eachstep[3]);
			}
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
