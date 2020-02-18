
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int palyer2points = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
		if (isNormal())
			score = getLiteral(player1Points) + "-" + getLiteral(palyer2points);
      
		if (isTie())
			score =getLiteral(player1Points)+ "-All";
		
		if (isDuce())
			score = "Deuce";
        
		if (isAdvantage( player1Points,  palyer2points))
            score = "Advantage player1";
        
        if (isAdvantage( palyer2points,  player1Points))
            score = "Advantage player2";
        score = win(score);
        return score;
    }

	private boolean isDuce() {
		return player1Points==palyer2points && player1Points>=3;
	}

	private boolean isNormal() {
		return player1Points !=palyer2points;
	}
    



	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==0)
			result = "Love";
	
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
		if (playerPoints==3)
			result = "Forty";
		return result;
	}


	private boolean isTie() {
		return player1Points == palyer2points && player1Points < 4;
	}

	private String win(String score) {
		if (player1Points>=4 && palyer2points>=0 && (player1Points-palyer2points)>=2)
        {
            score = "Win for player1";
        }
        if (palyer2points>=4 && player1Points>=0 && (palyer2points-player1Points)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}



	private boolean isAdvantage(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        palyer2points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}