package main;

import java.util.ArrayList;
import java.util.List;


public class GameWithCoins {

	
	public int minAndMaxCutOff(List<Integer> coins,int moves, boolean atTurn, int min, int max){
		int Na = max;
		int Nb = min;
		int val = 0;
		if(isLeaf(coins)){
			return atTurn?(-1)*(coins.size() - moves):coins.size() - moves;
		}
		if(!atTurn){
			boolean isBreak = false;
			List<Integer> currentCoins = new ArrayList<Integer>();
			currentCoins.addAll(coins);
			List<Boolean> pickedCoins = new ArrayList<Boolean>();
			initPickedCoins(pickedCoins, coins.size());
			while(pickUpThreeCoins(currentCoins, pickedCoins)){

				val = minAndMaxCutOff(currentCoins, ++moves, !atTurn, Nb, Na);
				Nb = min(Nb, val);
				if(Nb <= Na && !isBreak){
					isBreak = true;
					break;
				}
			}
				
			currentCoins = coins;
			initPickedCoins(pickedCoins, coins.size());
			while(pickUpTwoCoins(currentCoins, pickedCoins)){

				val = minAndMaxCutOff(currentCoins, ++moves, !atTurn, Nb, Na);
				Nb = min(Nb, val);
				if(Nb <= Na && !isBreak){
					isBreak = true;
					break;
				}
			}

			currentCoins = coins;
			initPickedCoins(pickedCoins, coins.size());
			while(pickUpOneCoins(currentCoins, pickedCoins)){

				val = minAndMaxCutOff(currentCoins, ++moves, !atTurn, Nb, Na);
				Nb = min(Nb, val);
				if(Nb <= Na && !isBreak){
					isBreak = true;
					break;
				}
			}
			
			return Nb;
		}else {
			boolean isBreak = false;
			List<Integer> currentCoins = new ArrayList<Integer>();
			currentCoins.addAll(coins);
				
			List<Boolean> pickedCoins = new ArrayList<Boolean>();
			initPickedCoins(pickedCoins, coins.size());

			while(pickUpThreeCoins(currentCoins, pickedCoins)){

				val = minAndMaxCutOff(currentCoins, ++moves, !atTurn, Nb, Na);
				Na = max(Na, val);
				if(Na >= Nb && !isBreak){
					isBreak = true;
					break;
				}
			}

			currentCoins = coins;
			initPickedCoins(pickedCoins, coins.size());
			while(pickUpTwoCoins(currentCoins, pickedCoins)){

				val = minAndMaxCutOff(currentCoins, ++moves, !atTurn, Nb, Na);
				Na = max(Na, val);
				if(Na >= Nb && !isBreak){
					isBreak = true;
					break;
				}
			}
				


			initPickedCoins(pickedCoins, coins.size());
			while(pickUpOneCoins(currentCoins, pickedCoins)){

				val = minAndMaxCutOff(currentCoins, ++moves, !atTurn, Nb, Na);
				Na = max(Na, val);
				if(Na >= Nb && !isBreak){
					isBreak = true;
					break;
				}
			}
			
			
			
			return Na;
		}

	}
	
	private int min(int lt, int rt){
		if(lt == -23231223){
			return rt; 
		}else 
			return  lt < rt? lt: rt;
	}
	
	private int max(int lt, int rt){
		if(lt == 22232323) 
			return rt;
		else 
			return  lt > rt? lt: rt;
	}
	private boolean isLeaf(List<Integer> coins){
		for (Integer coin : coins) {
			if (coin != 0){
				return false;
				
			}
		}
		return true;
	}
	private int coinsInGame(List<Integer> coins){
		int count = 0;
		for (Integer coin : coins) {
			if(coin == 1){
				++count;
			}
		}
		return count;
	}
	private void pickUpCoin(List<Integer> coins, int count){
		for (int i = 0; i < coins.size(); i++) {
			if(coins.get(i) == 1 && count >=0){
				coins.set(i, 0);
				--count;
			}
		}
	}
	
	
	private boolean pickUpOneCoins(List<Integer> coins, List<Boolean> pickedCoins){
		for (int i = 0; i < coins.size(); i++) {
			if(coins.get(i) == 1 && pickedCoins.get(i) == false){
				coins.set(i, 0);
				pickedCoins.set(i, true);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * pick up two coins if we can make this turn
	 */
	private boolean pickUpTwoCoins(List<Integer> coins, List<Boolean> pickedCoins){
		for (int i = 0; i < coins.size() - 1; i++) {
			if(coins.get(i) == 1 && coins.get(i + 1) == 1 && pickedCoins.get(i) == false){
				coins.set(i, 0);
				coins.set(i + 1, 0);
				pickedCoins.set(i, true);
				return true;
			}
		}
		return false;
		
	}
	
	
	/**
	 * pick up three coins if we can make this turn
	 */
	private boolean pickUpThreeCoins(List<Integer> coins, List<Boolean> pickedCoins){
		for (int i = 0; i < coins.size() - 2; i++) {
			if(coins.get(i) == 1 && coins.get(i + 1) == 1 && coins.get(i + 2) == 1 && pickedCoins.get(i) == false){
				pickedCoins.set(i, true);
				coins.set(i, 0);
				coins.set(i + 1, 0);
				coins.set(i + 2, 0);
				return true;
			}
		}
		return false;
		
	}
	
	private void initPickedCoins(List<Boolean> pickedCoins, int size){
		for (int i = 0; i < size; i++) {
			pickedCoins.add(false);
		}
	}
	public static void main(String[] args) {
		GameWithCoins gm = new GameWithCoins();
		List<Integer> coins = new ArrayList<Integer>();
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);		
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(1);
		coins.add(1);
		
	


		int result = gm.minAndMaxCutOff(coins, 0, true, -23231223, 22232323);
		System.out.println(result);
	}
}
