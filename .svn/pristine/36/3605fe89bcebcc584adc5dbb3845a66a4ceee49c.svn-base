package gomoku.player;


import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
/**
 * 
 * @author luck
 * @version 2013.3.30
 * 
 */
public class Player {
	private String Name;
	public Player(String name){
		Name = name;
	}
	public String getName() {
		return Name;
	}
	public void specialPlay(int cpu){
		
	}
	public void play() {
		
	}
	/**
	 * 
	 * @param Players
	 * @return
	 * 选锟斤拷锟斤拷锟斤拷锟�
	 */
	public String choosefirst(String[] Players) {
		
		String select;
		int selectDialog = DialogCreator.twoButtonDialog(Language.RULE, Language.CHOOSEWHOFIRST,Players[0],Players[1],0);
		while(selectDialog == 0) {
			DialogCreator.oneButtonDialog(Language.ERROR, Language.IFBREAKRULE);
			selectDialog = DialogCreator.twoButtonDialog(Language.RULE, Language.CHOOSEWHOFIRST,Players[0],Players[1],0);
		}
		if(selectDialog == 1){
			select = Players[0];
		}
		else{
			select = Players[1];
		}
		return select;
	}
	/**
	 * 
	 * @return
	 * 锟节讹拷锟斤拷选锟斤拷
	 */
	public String choose() {
		String[] swapChoose = {Language.CHOOSEBLACK,Language.CHOOSEWHITE,Language.DOMORE};
		String selectSwap;
		int selectSwapDialog = DialogCreator.threeButtonDialog("Swap", Name+","+Language.CHOOSE, swapChoose[0], swapChoose[1], swapChoose[2]);
		while (selectSwapDialog == 0){
			DialogCreator.oneButtonDialog(Language.ERROR,  Language.IFBREAKRULE);
			selectSwapDialog = DialogCreator.threeButtonDialog("Swap", Name+","+Language.CHOOSE, swapChoose[0], swapChoose[1], swapChoose[2]);
		}
		if(selectSwapDialog == 1){
			selectSwap = swapChoose[0];
		}
		else if(selectSwapDialog == 2){
			selectSwap = swapChoose[1];
		}
		else{
			selectSwap = swapChoose[2];
		}
		return selectSwap;
	}
	
	public String chooseagain() {
		String[] swapChoose = {Language.CHOOSEBLACK,Language.CHOOSEWHITE};
		String selectSwap;
		int selectSwapDialog= DialogCreator.twoButtonDialog("Swap", Name + "," + Language.CHOOSE, swapChoose[0], swapChoose[1], 0);
		while (selectSwapDialog == 0){
			DialogCreator.oneButtonDialog(Language.ERROR, Language.IFBREAKRULE);
			selectSwapDialog = DialogCreator.twoButtonDialog("Swap", Name + "," + Language.CHOOSE, swapChoose[0], swapChoose[1], 0);
		}
		if(selectSwapDialog == 1){
			selectSwap = swapChoose[0];
		}
		else{
			selectSwap = swapChoose[1];
		}
		return selectSwap;
	}
}

