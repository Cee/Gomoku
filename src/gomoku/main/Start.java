package 
gomoku.main;

import gomoku.language.Language;
import gomoku.option.Load;
import gomoku.option.Set;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.io.IOException;
/**
 * 
 * @author luck
 * @version 2013.4.1 0:08
 *  1. ��ȡ��Ϸ���� 2�� ��ȡ��Ϸ���� 3�� �������� ���� ��Ч... �������
 * 
 */
public class Start {
	public static Gomoku gomoku;
	public static void main(String[] args) throws ClassNotFoundException, IOException{
//		Data.set();
//		Data.load();
		Load.read();
//		Set.setLanguage("Chinese");
//		Set.setTheme("StarNight");
		Theme.load(Set.getTheme());
		Language.load(Set.getLanguage());
		Sound.load(Set.getBGM());
		Media.playBGM(Sound.BGM);	
		gomoku = new Gomoku();
		gomoku.add();
	}
}