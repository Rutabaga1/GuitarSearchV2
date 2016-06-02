package guitar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import javax.sql.DataSource;

import guitar.model.GuitarSpec;
import guitar.model.Inventory;


public class IGuitarDAOImpl implements IGuitarDAO{
	private DataSource datasource;
	public IGuitarDAOImpl(DataSource datasource){
		this.datasource=datasource;
	}
	
	
	@Override
	public Inventory getGuitars() {
		Connection conn=null;
		PreparedStatement stmt=null;
		SQLException ex=null;
		Inventory inventory=null;
		try{
			conn=datasource.getConnection();
			stmt=conn.prepareStatement("SELECT serialNumber,type,price,numStrings,color,builder FROM Guitar where inventoryNum!=0");
			/*stmt.setString(1, admin.getCname());
			stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			inventory = new Inventory();
			while(rs.next()){
			    inventory.addGuitar(rs.getString("serialNumber"), Double.valueOf(rs.getString("price")), 
			    		new GuitarSpec(rs.getString("builder"),rs.getString("type"),rs.getString("numStrings"),rs.getString("color")));
				
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return inventory;
	}
}
