package gomoku.sound;
import java.io.File;

import saint.media.MidiPlayer;
import saint.media.SimplePlayer;
/**
 * 
 * @author 小Y
 * 感谢小Y的热心帮助
 * saint包以及Media类为小Y友情提供
 * 用于音乐的播放
 *
 */

public class Media{
	private static SimplePlayer bgmPlayer = null;
	private static SimplePlayer soundPlayer = null;
	private static MidiPlayer midiPlayer = null;
	
	public static void playBGM(String name) {
		if (bgmPlayer!=null){
			bgmPlayer.stop();
			bgmPlayer=new SimplePlayer();
		}
		else{
			bgmPlayer=new SimplePlayer();
		}
	
		try{
			bgmPlayer.open(new File("sound/"+name+".mp3"));
			bgmPlayer.setLoop(true);
			bgmPlayer.setLoopCount(1000);
		}catch (Exception e) {
			System.err.println("文件无法加载");
			return;
		}

		try{
			bgmPlayer.play();	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void playSound(String name){
		soundPlayer=new SimplePlayer();
		
		try{
			soundPlayer.open(new File("sound/"+name+".mp3"));
			soundPlayer.setLoop(false);
		}catch (Exception e) {
			System.err.println("文件无法加载");
			return;
		}

		try{
			soundPlayer.play();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void playMidi(String name){
		midiPlayer=new MidiPlayer();
		
		try{
			midiPlayer.open(new File("sound/"+name+".mid"));
			midiPlayer.setLoop(false);
		}catch (Exception e) {
			System.err.println("文件如法加载");
			return;
		}

		try{
			midiPlayer.play();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stopBGM(String name){
		bgmPlayer.setVolume(0);
	}
	
	public static void stopSound(String name){
		soundPlayer.setVolume(0);
	}
	
	public static void stopMidi(String name){
		midiPlayer.setVolume(0);
	}
	
}