// File:    GameInfo.java
// Project: PL Project
// Author:  Schneider Campfort Jean-Pierre 

import java.util.ArrayList;

public class GameInfo {
	
			// The private variables are initiated.
	
			// Name of Game
			private String name;
			// Players of Game
			private String players;
			// Total Rounds
			private int tRounds;
			// overall winner of the round
			private String winner;
			// total winners (in case there is more than one winner)
			private int totalW; 
			// array of players in the game
			private ArrayList<String> pArray = new ArrayList<String>();
			// winners of each round
			private ArrayList<String> roundT = new ArrayList<String>();
			// points per player each round [reset each round]
			private ArrayList<Double> roundP = new ArrayList<Double>();
			
			
			//Constructor is set with arguments passed in
			
			GameInfo(String iName, String iPlayers, int iTRounds){
				name = iName;
				players = iPlayers;
				setpArray(pArray);
				settRounds(iTRounds);
				winner = "";
			}

			// Default constructor is set.
			GameInfo (){
				name = "No Input";
				players = "No Input";
				settRounds(0);
				winner = "";
			}
			
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
			
			public String getPlayers() {
				return players;
			}

			public void setPlayers(String players) {
				this.players = players;
			}

			public ArrayList<String> getpArray() {
				return pArray;
			}

			public void setpArray(ArrayList<String> pArray) {
				
				players.replace(" ", "");

				String addVal = "";
				
				int i = 0;
					
				while (i != (players.length()-1))
				{	
					if (players.charAt(i) == ',')
					{
						if (addVal != "")
						{
							pArray.add(addVal);
							addVal = "";
						}
					}
					else
					{
						addVal = addVal + players.charAt(i);
					}
					
					i++;
				}
				
				addVal = addVal + players.charAt(i);
				pArray.add(addVal);
				addVal = "";
				
			}
				

			public int gettRounds() {
				
				return tRounds;
			}

			public void settRounds(int tRounds) {
				
				if (tRounds > 0)
				{
					for (int i = 0; i < pArray.size(); i++ )
					{
						roundP.add(0.0);
					}
				}
				
				
				this.tRounds = tRounds;
			}

			public String getWinner() {
				
				ArrayList<Integer> Scores = new ArrayList<Integer>();
				ArrayList<String> roundTN = new ArrayList<String>();
				ArrayList<String> TWinners = new ArrayList<String>();
				String roundNames = "";
				String addVal = "";
				int newVal = 0;
				int wScore = 0;
				
				for (int i = 0; i < pArray.size(); i++ )
				{
					Scores.add(0);
				}
				
				for (int m = 0; m < roundT.size(); m++)
				{
					roundNames = roundT.get(m);
					int p = 0;
					while (p != (roundNames.length()-1))
					{	
						if (roundNames.charAt(p) == ',')
						{
							if (addVal != "")
							{
								roundTN.add(addVal);		
								addVal = "";
								
							}
						}
						else
						{
							addVal = addVal + roundNames.charAt(p);
						}
						
						p++;
					}
					
					addVal = addVal + players.charAt(p);
					roundTN.add(addVal);
					addVal = "";
					
					for (int v = 0; v < roundTN.size(); v++)
					{
						for (int s = 0; s < pArray.size(); s++)
						{
							if ((roundTN.get(v)).equals(pArray.get(s)))
							{
								newVal = Scores.get(s);
								newVal++;
								Scores.set(s, newVal);
							}
						}
							
					}
				}
				
				for (int i = 0; i < Scores.size(); i++)
				{
					if (Scores.get(i) > wScore)
					{
						wScore = Scores.get(i);
					}
				}
				
				for (int p = 0; p < Scores.size(); p++)
				{
					if (Scores.get(p) == wScore)
					{
						TWinners.add(pArray.get(p));
						
					}
				}
				
				if (TWinners.size() == 1)
				{
					winner = TWinners.get(0);
					totalW = 1;
				}
				else
				{
					for (int h = 0; h < TWinners.size(); h++)
					{
						if (h == 0)
						{
							winner = TWinners.get(h);
							totalW = 1;
						}
						else
						{
							winner = winner + "," + TWinners.get(h);
							totalW = totalW + 1;
						}
					}
				}
				
				return winner;
				
				
				
			}

			public void setWinner(String winner) {
				this.winner = winner;
			}
			
			public void addPoints(String name, double points )
			{
				int i = 0;
				int val = -1;
				
				while (i < pArray.size())
				{
					if ((pArray.get(i)).equals(name))
					{
						val = i;
						break;
					}
					
					i++;
				}
				
				
				
				if (val > -1)
				{
					points = points + roundP.get(val);
					roundP.set(val, points);
				}
				
				System.out.println(pArray.get(val) + " now has a total of " + points);
				System.out.println("");
				
			}
			
			public void endRound()
			{
				double wScore = 0.0;
				String addVal = "";
				ArrayList<String> wNames = new ArrayList<String>();
				
				for (int i = 0; i < roundP.size(); i++)
				{
					if (roundP.get(i) > wScore)
					{
						wScore = roundP.get(i);
					}
				}
				
				for (int p = 0; p < roundP.size(); p++)
				{
					if (roundP.get(p) == wScore)
					{
						wNames.add(pArray.get(p));
						
					}
				}
				
				for (int t = 0; t < wNames.size(); t++)
				{
					if (addVal == "")
					{
						addVal = addVal + wNames.get(t);
					}
					else
					{
						addVal = addVal + "," + wNames.get(t);
					}
				}
				
				roundT.add(addVal);
				roundP.clear();
				wNames.clear();
				tRounds--;
				
				if (tRounds != 0)
				{
					for (int i = 0; i < pArray.size(); i++ )
					{
						roundP.add(0.0);
					}
				}
			}

			public int getTotalW() {
				return totalW;
			}
}
