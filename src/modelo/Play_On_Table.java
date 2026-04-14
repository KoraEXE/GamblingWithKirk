package modelo;

public class Play_On_Table {
	private String id_table;
	private double bet;
	private GameType gametype; //Solo blackJack
	
	public Play_On_Table(String id_table, double bet, GameType gametype) {
		this.id_table = id_table;
		this.bet = bet;
		this.gametype = gametype;
	}
	public String getId_table() {
		return id_table;
	}
	public void setId_table(String id_table) {
		this.id_table = id_table;
	}
	public double getBet() {
		return bet;
	}
	public void setBet(double bet) {
		this.bet = bet;
	}
	public GameType getGametype() {
		return gametype;
	}
	public void setGametype(GameType gametype) {
		this.gametype = gametype;
	}
	
	@Override
	public String toString() {
		return "Play_On_Table [id_table=" + id_table + ", bet=" + bet + ", gametype=" + gametype + "]";
	}
	
	
}
