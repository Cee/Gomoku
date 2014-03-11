package gomoku.language;

import gomoku.theme.Theme;

/**
 * 
 * @author luck & cee
 *@version 2013/3/31
 *存取游戏中的字符
 *便于设置语言功能的实现
 */
public class Language {
	private static String getTheme;
	private static String setLanguage;
	
	public static String CHOOSEMODEL;
	public static String SINGLEPLAYER;
	public static String DOUBLEPLAYER;

/**
 * Gomoku
 */	
	public static String TITLE;
	public static String VERSION = "beta"; 
	
/**
 * Menu
 */
	public static String QUICK;
	public static String CAREER;
	public static String SINGLE;
	public static String DOUBLE;
	public static String NET;
	public static String REVIEW;
	public static String HELP;
	public static String INFORMATION;
	public static String OPTION;
	public static String FINALPHASE;
	public static String THEME;
	public static String QUIT;
	public static String SOUND;
	public static String CHESSBOARD;
	public static String LANGUAGE;
	
	/**
	 * GamePanel
	 */
	
	public static String START;
	public static String GIVEUP;
	public static String RETRACT;
	public static String RETURN;
	public static String NEXT;
	public static String LAST;
	public static String ANIMATION;
	
	
	public static String CHOOSE;
	public static String WHITEWIN;
	public static String BLACKWIN;
	public static String CHOOSEBLACK;
	public static String CHOOSEWHITE;
	public static String DOMORE;
	public static String DontGiveUp;
	public static String LaoCao;
	public static String MakeSureToGiveUp;
	public static String GiveUpTitle;
	public static String Praise;
	public static String PraiseSentence;
	public static String BadPhenomenon;
	public static String Disappointment;
	public static String PLAYER;
	public static String CHOOSEWHOFIRST;
	public static String RULE;
	public static String IFBREAKRULE;
	public static String ERROR;
	public static String REDWIN;
	public static String EXIT;
	
	/**
	 * Dialog
	 */
	public static String OK;
	public static String saveGame;
	public static String CANCEL;
	public static String RULEINFORMATION;
	public static String SPECIALMODEL;
	
	/**
	 * Waiting Panel
	 */
	public static String SETROOM;
	public static String ENTERROOM;
	public static String NETRETURN;
	
	/**
	 * Option Panel
	 */
	public static String CHOOSETHEME;
	public static String CHOOSELANGUAGE;
	public static String CHOOSEMUSIC;
	public static String SAVECHOOSE;
	
	/**
	 * SingleMovablePanel
	 */
	public static String WHITE;
	public static String BLACK;
	public static String THREEPLAYER;
	public static String INPUTIP;
	public static String INFOINTRODUCE;
	public static String SPECIALINTRODUCE;
	public static String BACKTOHELP;
	
	/**
	 * CareerPanel
	 */
	public static String NEWJOURNEY;
	public static String OLDMEMORY;
	public static String SPECIALMODE;
	public static String CAREERRETURN;
	
	/**
	 * SpecialPanel
	 */
	public static String NOLIGHT;
	public static String FOG;
	public static String NONEW;
	public static String STARMOVE;
	public static String DRYOUT;
	public static String NOHEAD;
	public static String FINALFIGHT;
	public static String SPECIALRETURN;
	
	public static void loadEnglish() {
		getTheme = Theme.theme;
		setLanguage = "ENG-";
		
		INPUTIP = "Please input the ip";
		/**
		 * GOMOKU
		 */
			
			TITLE = "Gobang version:"+VERSION+" ----Produced by EXcalibur";
		/**
		 * MENU
		 */
			QUICK = "png/"+getTheme+"/"+setLanguage+"quickStart.png";
			NET = "png/"+getTheme+"/"+setLanguage+"net.png";
			CAREER = "png/"+getTheme+"/"+setLanguage+"career.png";
			SINGLE = "png/"+getTheme+"/"+setLanguage+"single.png";
			DOUBLE = "png/"+getTheme+"/"+setLanguage+"double.png";
			REVIEW = "png/"+getTheme+"/"+setLanguage+"review.png";
			HELP = "png/"+getTheme+"/"+setLanguage+"help.png";
			INFORMATION = "png/"+getTheme+"/"+setLanguage+"info.png";
			OPTION = "png/"+getTheme+"/"+setLanguage+"option.png" ;
			LANGUAGE = "Language";		
			QUIT = 		"Quit";
			FINALPHASE = "Load final phase";
			THEME =	"Theme";
			SOUND = "Sound";
			CHESSBOARD = "Chessboard";	
			CHOOSEMODEL = "Please choose the model.";
			SINGLEPLAYER = "Single game";
			DOUBLEPLAYER = "Double game";
			
		/**
		 * GamePanel	
		 */			
			EXIT = "png/"+getTheme+"/"+setLanguage+"exit.png";
			START = "png/"+getTheme+"/"+setLanguage+"start.png" ;
			GIVEUP = "png/"+getTheme+"/"+setLanguage+"giveUp.png" ;
			RETRACT = "png/"+getTheme+"/"+setLanguage+"retract.png" ;
			RETURN = "png/"+getTheme+"/"+setLanguage+"return.png" ;
			NEXT = "png/"+getTheme+"/"+setLanguage+"next.png" ;
			ANIMATION = "png/"+getTheme+"/"+setLanguage+"animation.png" ;
			LAST ="png/"+getTheme+"/"+setLanguage+"last.png" ;
			BadPhenomenon = "Bad Phenomenon!";
			Disappointment = "Too disappointing!";
			PraiseSentence = "Good Student!~Never Give up and Never Give in!";
			Praise ="Praise";
			MakeSureToGiveUp = "Are you sure to give up?";
			GiveUpTitle = "Give up";
			DontGiveUp = "Don't Give Up!";
			LaoCao = "Mr.Cao has said:";
			WHITEWIN = "Winner! White";
			BLACKWIN = "Winner! Black";
			PLAYER = "player";
			REDWIN = "Winner! Red";
			/**
		 * Player	
		 */
			DOMORE = "two more";
			CHOOSEBLACK= "black";
			CHOOSEWHITE= "white";
			CHOOSE = "please chooose swap.";
			CHOOSEWHOFIRST = "Please choose who first";
			RULE = "Rule";
			IFBREAKRULE = "Don't break the rule";
			ERROR = "Error!";
		/**
		 * Dialog	
		 */
			OK = "png/"+getTheme+"/"+setLanguage+"okButton.png";
			saveGame="Save the Game";
			CANCEL = "png/"+getTheme+"/"+setLanguage+"cancelButton.png";
		/**
		 * HelpPanel
		 */
			RULEINFORMATION = "png/"+getTheme+"/"+setLanguage+"rule.png";
			SPECIALMODEL = "png/"+getTheme+"/"+setLanguage+"special.png";
		
		/**
		 * Waiting Panel
		 */
			SETROOM = "png/"+getTheme+"/"+setLanguage+"setRoom.png";
			ENTERROOM = "png/"+getTheme+"/"+setLanguage+"enterRoom.png";
			NETRETURN = "png/"+getTheme+"/"+setLanguage+"netReturn.png";
			
		/**
		 * Option Panel
		 */
			CHOOSETHEME = "png/"+getTheme+"/"+setLanguage+"theme.png";
			CHOOSELANGUAGE = "png/"+getTheme+"/"+setLanguage+"language.png";
			CHOOSEMUSIC = "png/"+getTheme+"/"+setLanguage+"music.png";
			SAVECHOOSE = "png/"+getTheme+"/"+setLanguage+"saveChoose.png";
			
		/**
		 * SingleMovablePanel
		 */
			WHITE = "png/"+getTheme+"/"+setLanguage+"whitePlayer.png";
			BLACK = "png/"+getTheme+"/"+setLanguage+"blackPlayer.png";
			
		/**
		 * HelpPanel
		 */
			RULEINFORMATION = "png/"+getTheme+"/"+setLanguage+"rule.png";
			SPECIALMODEL = "png/"+getTheme+"/"+setLanguage+"special.png";			
			THREEPLAYER = "Three Players Game";
			
		/**
		 * CareerPanel
		 */
			NEWJOURNEY = "png/"+getTheme+"/"+setLanguage+"newJourney.png";
			OLDMEMORY = "png/"+getTheme+"/"+setLanguage+"oldMemo.png";
			SPECIALMODE = "png/"+getTheme+"/"+setLanguage+"specialMode.png";
			CAREERRETURN = "png/"+getTheme+"/"+setLanguage+"careerReturn.png";
			
		/**
		 * SpecialPanel
		 */
			NOLIGHT = "png/"+getTheme+"/"+setLanguage+"noLight.png";
			FOG = "png/"+getTheme+"/"+setLanguage+"fog.png";
			NONEW = "png/"+getTheme+"/"+setLanguage+"noNew.png";
			STARMOVE = "png/"+getTheme+"/"+setLanguage+"starMove.png";
			DRYOUT = "png/"+getTheme+"/"+setLanguage+"dryOut.png";
			NOHEAD = "png/"+getTheme+"/"+setLanguage+"noHead.png";
			FINALFIGHT = "png/"+getTheme+"/"+setLanguage+"finalFight.png";
			SPECIALRETURN = "png/"+getTheme+"/"+setLanguage+"specialReturn.png";
		/**
		 * HelpPanel
		 */
			BACKTOHELP = "png/"+getTheme+"/"+setLanguage+"backToHelp.png";
			INFOINTRODUCE = "png/"+getTheme+"/"+setLanguage+"ruleIntroduction.png";
			SPECIALINTRODUCE = "png/"+getTheme+"/"+setLanguage+"specialMode.png";
	}
			
	public static void loadChinese(){
		getTheme = Theme.theme;
		setLanguage = "CHN-";
		
		INPUTIP = "请输入主机地址";
	/**
	 * GOMOKU
	 */
		
		TITLE = "五子棋 version:"+VERSION+" ----produced by EX咖喱棒";
	/**
	 * MENU
	 */
		QUICK = "png/"+getTheme+"/"+setLanguage+"quickStart.png";
		NET = "png/"+getTheme+"/"+setLanguage+"net.png";
		CAREER = "png/"+getTheme+"/"+setLanguage+"career.png";
		SINGLE = "png/"+getTheme+"/"+setLanguage+"single.png";
		DOUBLE = "png/"+getTheme+"/"+setLanguage+"double.png";
		REVIEW = "png/"+getTheme+"/"+setLanguage+"review.png";
		HELP = "png/"+getTheme+"/"+setLanguage+"help.png";
		INFORMATION = "png/"+getTheme+"/"+setLanguage+"info.png";
		OPTION = "png/"+getTheme+"/"+setLanguage+"option.png" ;
		LANGUAGE = "语言";		
		QUIT = 		"退出";
		FINALPHASE = "残局闯关";
		THEME =	"主题";
		SOUND = "音效";
		CHESSBOARD = "棋盘";
		
	/**
	 * GamePanel	
	 */
		EXIT = "png/"+getTheme+"/"+setLanguage+"exit.png";
		START = "png/"+getTheme+"/"+setLanguage+"start.png" ;
		GIVEUP = "png/"+getTheme+"/"+setLanguage+"giveUp.png" ;
		RETRACT = "png/"+getTheme+"/"+setLanguage+"retract.png" ;
		RETURN = "png/"+getTheme+"/"+setLanguage+"return.png" ;
		NEXT = "png/"+getTheme+"/"+setLanguage+"next.png" ;
		ANIMATION = "png/"+getTheme+"/"+setLanguage+"animation.png" ;
		LAST ="png/"+getTheme+"/"+setLanguage+"last.png" ;
		REDWIN = "红方获胜";
		BadPhenomenon = "不好现象";
		Disappointment = "太让我失望了!";
		PraiseSentence = "这才是新时代的好学生！";
		Praise ="表扬";
		MakeSureToGiveUp = "你确定要放弃吗？";
		GiveUpTitle = "放弃";
		DontGiveUp = "千万不要放弃！";
		LaoCao = "老曹金口玉言：";
		WHITEWIN = "白方获胜！";
		BLACKWIN = "黑方获胜！";
		PLAYER = "玩家";
		CHOOSEMODEL = "请选择游戏模式";
		SINGLEPLAYER = "单人游戏";
		DOUBLEPLAYER = "双人游戏";
	/**
	 * Player	
	 */
		DOMORE = "再下两手";
		CHOOSEBLACK= "执黑";
		CHOOSEWHITE= "执白";
		CHOOSE = "请进行swap选择";
		CHOOSEWHOFIRST = "请选择假先手";
		RULE = "规则";
		IFBREAKRULE = "代码君：喂喂喂不选假先手是犯规的！不要为难我！";
		ERROR = "犯规这种事代码君是不允许的";
		/**
		 * Dialog	
		 */
			OK = "png/"+getTheme+"/"+setLanguage+"okButton.png";
			saveGame="保存棋局";
			CANCEL = "png/"+getTheme+"/"+setLanguage+"cancelButton.png";
	/**
	 * Waiting Panel
	 */
			SETROOM = "png/"+getTheme+"/"+setLanguage+"setRoom.png";
			ENTERROOM = "png/"+getTheme+"/"+setLanguage+"enterRoom.png";
			NETRETURN = "png/"+getTheme+"/"+setLanguage+"netReturn.png";
			
	/**
	 * Option Panel
	 */
			CHOOSETHEME = "png/"+getTheme+"/"+setLanguage+"theme.png";
			CHOOSELANGUAGE = "png/"+getTheme+"/"+setLanguage+"language.png";
			CHOOSEMUSIC = "png/"+getTheme+"/"+setLanguage+"music.png";
			SAVECHOOSE = "png/"+getTheme+"/"+setLanguage+"saveChoose.png";
		
	/**
	 * SingleMovablePanel
	 */
			WHITE = "png/"+getTheme+"/"+setLanguage+"whitePlayer.png";
			BLACK = "png/"+getTheme+"/"+setLanguage+"blackPlayer.png";


	/**
	 * HelpPanel
	 */
			RULEINFORMATION = "png/"+getTheme+"/"+setLanguage+"rule.png";
			SPECIALMODEL = "png/"+getTheme+"/"+setLanguage+"special.png";
			/**
			 * HelpPanel
			 */
				BACKTOHELP = "png/"+getTheme+"/"+setLanguage+"backToHelp.png";
				INFOINTRODUCE = "png/"+getTheme+"/"+setLanguage+"ruleIntroduction.png";
				SPECIALINTRODUCE = "png/"+getTheme+"/"+setLanguage+"specialMode.png";		
			THREEPLAYER = "三人游戏";

	/**
	 * CareerPanel
	 */
			NEWJOURNEY = "png/"+getTheme+"/"+setLanguage+"newJourney.png";
			OLDMEMORY = "png/"+getTheme+"/"+setLanguage+"oldMemo.png";
			SPECIALMODE = "png/"+getTheme+"/"+setLanguage+"specialMode.png";
			CAREERRETURN = "png/"+getTheme+"/"+setLanguage+"careerReturn.png";	
			
	/**
	 * SpecialPanel
	 */
			NOLIGHT = "png/"+getTheme+"/"+setLanguage+"noLight.png";
			FOG = "png/"+getTheme+"/"+setLanguage+"fog.png";
			NONEW = "png/"+getTheme+"/"+setLanguage+"noNew.png";
			STARMOVE = "png/"+getTheme+"/"+setLanguage+"starMove.png";
			DRYOUT = "png/"+getTheme+"/"+setLanguage+"dryOut.png";
			NOHEAD = "png/"+getTheme+"/"+setLanguage+"noHead.png";
			FINALFIGHT = "png/"+getTheme+"/"+setLanguage+"finalFight.png";
			SPECIALRETURN = "png/"+getTheme+"/"+setLanguage+"specialReturn.png";
	}	
	
	public static void loadJapanese() {
		getTheme = Theme.theme;
		setLanguage = "JPN-";
	/**
	 * GOMOKU
	 */
		
		TITLE = "五目並べ version:"+VERSION+" ----制作:EXカレー棒";
	/**
	 * MENU
	 */
		QUICK = "png/"+getTheme+"/"+setLanguage+"quickStart.png";
		NET = "png/"+getTheme+"/"+setLanguage+"net.png";
		CAREER = "png/"+getTheme+"/"+setLanguage+"career.png";
		SINGLE = "png/"+getTheme+"/"+setLanguage+"single.png";
		DOUBLE = "png/"+getTheme+"/"+setLanguage+"double.png";
		REVIEW = "png/"+getTheme+"/"+setLanguage+"review.png";
		HELP = "png/"+getTheme+"/"+setLanguage+"help.png";
		INFORMATION = "png/"+getTheme+"/"+setLanguage+"info.png";
		OPTION = "png/"+getTheme+"/"+setLanguage+"option.png" ;
		LANGUAGE = "言語";		
		QUIT = 	"おわる";
		FINALPHASE = "ロード";
		THEME =	"テーマ";
		SOUND = "サウンド";
		CHESSBOARD = "碁盤";		
	/**
	 * GamePanel	
	 */
		EXIT = "png/"+getTheme+"/"+setLanguage+"exit.png";
		START = "png/"+getTheme+"/"+setLanguage+"start.png" ;
		GIVEUP = "png/"+getTheme+"/"+setLanguage+"giveUp.png" ;
		RETRACT = "png/"+getTheme+"/"+setLanguage+"retract.png" ;
		RETURN = "png/"+getTheme+"/"+setLanguage+"return.png" ;
		NEXT = "png/"+getTheme+"/"+setLanguage+"next.png" ;
		ANIMATION = "png/"+getTheme+"/"+setLanguage+"animation.png" ;
		LAST ="png/"+getTheme+"/"+setLanguage+"last.png" ;	
		BadPhenomenon = "悪い現象";
		Disappointment = "私はとてもがっかりしている！";
		PraiseSentence = "これこそ新たな時代の優秀な生徒です！";
		Praise ="凄い！";
		MakeSureToGiveUp = "本当にあきらめたいですか？";
		GiveUpTitle = "あきらめる";
		DontGiveUp = "あきらめてはいけない！";
		LaoCao = "曹先生は言う";
		WHITEWIN = "白方の勝ち！";
		BLACKWIN = "黒方の勝ち！";
		PLAYER = "プレーヤー";
		REDWIN = "赤方の勝ち！";
	/**
	 * Player	
	 */
		
		DOMORE = "再び両手";
		CHOOSEBLACK= "黑を選ぶ";
		CHOOSEWHITE= "白を選ぶ";
		CHOOSE = "スワップを選択してください";
		CHOOSEWHOFIRST="偽先手を選択してください";
		RULE="ルール";
		IFBREAKRULE="ファウルしないでください";
		ERROR="ああ、ファウルできない";
		
		/**
		 * Dialog	
		 */
		OK = "png/"+getTheme+"/"+setLanguage+"okButton.png";
		CANCEL = "png/"+getTheme+"/"+setLanguage+"cancelButton.png";
	/**
	 * Waiting Panel
	 */
		SETROOM = "png/"+getTheme+"/"+setLanguage+"setRoom.png";
		ENTERROOM = "png/"+getTheme+"/"+setLanguage+"enterRoom.png";
		NETRETURN = "png/"+getTheme+"/"+setLanguage+"netReturn.png";
		
	/**
	 * Option Panel
	 */
		CHOOSETHEME = "png/"+getTheme+"/"+setLanguage+"theme.png";
		CHOOSELANGUAGE = "png/"+getTheme+"/"+setLanguage+"language.png";
		CHOOSEMUSIC = "png/"+getTheme+"/"+setLanguage+"music.png";
		SAVECHOOSE = "png/"+getTheme+"/"+setLanguage+"saveChoose.png";
		
	/**
	 * SingleMovablePanel
	 */
		WHITE = "png/"+getTheme+"/"+setLanguage+"whitePlayer.png";
		BLACK = "png/"+getTheme+"/"+setLanguage+"blackPlayer.png";
		

		/**
		 * HelpPanel
		 */
		RULEINFORMATION = "png/"+getTheme+"/"+setLanguage+"rule.png";
		SPECIALMODEL = "png/"+getTheme+"/"+setLanguage+"special.png";
		
		
		/**
		 * 
		 * SpecialModel
		 */
		THREEPLAYER="";
		
		/**
		 * CareerPanel
		 */
		NEWJOURNEY = "png/"+getTheme+"/"+setLanguage+"newJourney.png";
		OLDMEMORY = "png/"+getTheme+"/"+setLanguage+"oldMemo.png";
		SPECIALMODE = "png/"+getTheme+"/"+setLanguage+"specialMode.png";
		CAREERRETURN = "png/"+getTheme+"/"+setLanguage+"careerReturn.png";
		
		/**
		 * SpecialPanel
		 */
		NOLIGHT = "png/"+getTheme+"/"+setLanguage+"noLight.png";
		FOG = "png/"+getTheme+"/"+setLanguage+"fog.png";
		NONEW = "png/"+getTheme+"/"+setLanguage+"noNew.png";
		STARMOVE = "png/"+getTheme+"/"+setLanguage+"starMove.png";
		DRYOUT = "png/"+getTheme+"/"+setLanguage+"dryOut.png";
		NOHEAD = "png/"+getTheme+"/"+setLanguage+"noHead.png";
		FINALFIGHT = "png/"+getTheme+"/"+setLanguage+"finalFight.png";
		SPECIALRETURN = "png/"+getTheme+"/"+setLanguage+"specialReturn.png";
		/**
		 * HelpPanel
		 */
			BACKTOHELP = "png/"+getTheme+"/"+setLanguage+"backToHelp.png";
			INFOINTRODUCE = "png/"+getTheme+"/"+setLanguage+"ruleIntroduction.png";
			SPECIALINTRODUCE = "png/"+getTheme+"/"+setLanguage+"specialMode.png";
	}
	
	public static void load(String Language){
		switch(Language) {
		case "English": loadEnglish();
						break;	
		case "Chinese": loadChinese();
						break;
		case "Japanese": loadJapanese();
						break;
						
		}
	}
}

