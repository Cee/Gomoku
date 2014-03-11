package gomoku.achievement;
 /**
  * 
  * @author luck
  * @version 2013.4.3 15:09
  * 记录玩的次数
  *
  */
  public class PlayTimes {
	  private static int PlayTimes=0 ;

	/**
	 * @return playTimes
	 */
	public static int getPlayTimes() {
		return PlayTimes;
	}

	/**
	 * @param playTimes 要设置的 playTimes
	 */
	public static void setPlayTimes(int playTimes) {
		PlayTimes = playTimes;
	}	
	public static void addPlayTimes() {
		PlayTimes++;
	}

}
