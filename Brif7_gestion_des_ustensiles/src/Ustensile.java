

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ustensile {
	
	Conection con = new Conection();
	
	//private int count;
	private int id;
	
	private int anne_de_fabrication;
	public Ustensile(){}
	public Ustensile(int Id,int Anne_de_fabrication){
		this.id = Id;
		this.anne_de_fabrication = Anne_de_fabrication;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnne_de_fabrication() {
		return anne_de_fabrication;
	}
	public void setAnne_de_fabrication(int anne_de_fabrication) {
		this.anne_de_fabrication = anne_de_fabrication;
	}
	
	@Override
	public String toString() {
		return  "\n \t ---------------- \n \t Anne de Fabrication    : " + this.anne_de_fabrication ;
	}
	
	//m�thode afficherValeurTotale
	public void afficherValeurTotale(int choix) throws SQLException {
		int yearNow = Calendar.getInstance().get(Calendar.YEAR);
		int yearUstentile = 0;
		int Calculvaut = 0;
		int vaut = 0;
		//int vaut2 = 0;
		if(choix == 1 ) {
			//SELECT anne_de_fabrication FROM cuillere 
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT anne_de_fabrication FROM cuillere");
			
			while(con.rs.next()) {
				yearUstentile = con.rs.getInt("anne_de_fabrication");
				Calculvaut = yearNow - yearUstentile;
				if (Calculvaut > 50) {
					vaut = vaut + (Calculvaut - 50);
				}
			}
			System.out.println(" -------> Valeur Totale De Cuillere:  " + "\t" + vaut + "DH");
		}else if(choix == 2) {
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT anne_de_fabrication FROM assietteronde");
			
			while(con.rs.next()) {
				yearUstentile = con.rs.getInt("anne_de_fabrication");
				Calculvaut = yearNow - yearUstentile;
				if (Calculvaut > 50) {
					vaut = vaut + (Calculvaut - 50);
				}
			}
			System.out.println(" -------> Valeur Totale De AssietteRonde:  " + "\t" + vaut + "DH");
		}else if(choix == 3) {
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT anne_de_fabrication FROM assiettecarree");
			
			while(con.rs.next()) {
				yearUstentile = con.rs.getInt("anne_de_fabrication");
				Calculvaut = yearNow - yearUstentile;
				if (Calculvaut > 50) {
					//vaut2 =  (Calculvaut - 50) * 5;
					vaut = vaut + ((Calculvaut - 50) * 5);
				}
			}
			System.out.println(" -------> Valeur Totale De AssietteCarree:  " + "\t" + vaut + "DH");
		}
	}
	
	
	
	

}
