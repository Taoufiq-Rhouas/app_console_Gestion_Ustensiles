
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AssietteRonde extends Assiette{
	
	Conection con = new Conection();

	private int id;
	private double rayon;
	
	public AssietteRonde() {}
	public AssietteRonde(int Id,double Rayon,int Anne_de_fabrication) {
		super (Anne_de_fabrication);
		this.id = Id;
		this.rayon = Rayon;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRayon() {
		return rayon;
	}
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	@Override
	public String toString() {
		return  "\n \t ---------------- \n \t Rayon    : " + this.rayon ;
	}
	
	
	/*
	
	//insert
	
	public void create_data(String nom ,String description ,String cin) {
		//First f = new First();
		con.Connect();
		PreparedStatement ps = null;
		try {
			if(nom.length()<11 && description.length()<31 && cin.length()<9) {
				//System.out.println("kayen >9");
				String query="INSERT INTO `youcode_test`(`Name`, `Description`, `CIN`) VALUES (?,?,?)";
				ps=con.conn.prepareStatement(query);
				ps.setString(1, nom);
				ps.setString(2, description);
				ps.setString(3, cin);
				ps.executeUpdate();
			}else{
				if(nom.length() > 10) {
					System.out.println("\n nom est pas valide !");
				}else if(description.length() > 30) {
					System.out.println("\n description est pas valide !");
				}else if(cin.length() > 8) {
					System.out.println("\n cin est pas valide !");
				}
				//System.out.println("makayen >9");
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	 */
	//insert
	public void create_data(double rayon,int anne_de_fabrication) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query="INSERT INTO `assietteronde`(`rayon` , `anne_de_fabrication`) VALUES (?,?)";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, rayon);
			ps.setDouble(2, anne_de_fabrication);
			ps.executeUpdate();
			System.out.println(" \n AssietteRonde Ajoute Avec Succes ");
		}catch (Exception e) {
			System.out.print(e);
		}
	}
	
	//select
	public void read_data() throws SQLException {
		//First f = new First();
		con.Connect();
		con.stat = con.conn.createStatement();
		con.rs = con.stat.executeQuery("SELECT * FROM `assietteronde`");
		while(con.rs.next()) {
			System.out.println(" -------> ID:  " + "\t" +con.rs.getInt("id") + "\n \t Rayon: " + con.rs.getDouble("rayon") + " \n \t Anne De Fabrication: " + con.rs.getInt("anne_de_fabrication"));
		}
	}
	

	//update
	public void update_data(int id ,double rayon ,int anne_de_fabrication) {
		//First f = new First();
		con.Connect();
		
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE `assietteronde` SET `rayon`=?,`anne_de_fabrication`=? WHERE `id`=?";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, rayon);
			ps.setInt(2, anne_de_fabrication);
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");

			
		}catch (Exception e){
			
		}
	}
	
	
	
}
