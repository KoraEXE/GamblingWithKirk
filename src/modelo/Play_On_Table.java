package modelo;

public class Play_On_Table {
	private String id_table;
	private GameType gametype; //Solo blackJack
	
	public Play_On_Table(String id_table, GameType gametype) {
		this.id_table = id_table;
		this.gametype = gametype;
	}
	
	public Play_On_Table() {
	}
	
	public String getId_table() {
		return id_table;
	}
	public void setId_table(String id_table) {
		this.id_table = id_table;
	}
	public GameType getGametype() {
		return gametype;
	}
	public void setGametype(GameType gametype) {
		this.gametype = gametype;
	}	
}
