package us.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import us.databank.Connectivity;
import us.frames.AdminRoom;
import us.frames.DirectorRoom;
import us.frames.Door;

public class LoginAction implements ActionListener{
	
	String sql;
	ResultSet rs;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Door.frame.dispose();
		String login = Door.loginFLD.getText();
		String password = new String(Door.passWordFLD.getPassword());
		
		searchInEMP(login, password);
		
		
	}
	
	private void searchInEMP(String log, String pass) {

		sql = "SELECT * FROM funcionario";
	
		rs = new Connectivity().search(sql);
		
		try {
			while(rs.next()) {
				String login = rs.getString("login");
				String password  = rs.getString("senha");	
				
				if(login.equals(log) && password.equals(pass)) {
					int dig = rs.getInt("dig");
				
					switch (dig) {
					case 11:{
						DirectorRoom dr = new DirectorRoom(rs.getString("nome"), rs.getString("cpf"));
						break;
						}
					case 13: {
						
					}
					case 17:{
						
					}
					case 19:{
						
					}
					case 0:{
						AdminRoom ar = new AdminRoom(rs.getString("nome"));
						break;
					}
					default:
						
					}
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
