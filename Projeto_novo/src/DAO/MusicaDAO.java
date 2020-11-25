/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DTO.MusicaDTO;
import DTO.GeneroDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MusicaDAO {
    
Connection con;
PreparedStatement pstm;
ArrayList<MusicaDTO> lista = new ArrayList<>();
    /*
    public void cadastrarMusica (MusicaDTO objmusicadto){
        
        String sql = "insert into musicas (nome_Musica) values (?)";      
        con = new ConexaoDAO().conectaBD();
        
        
            try {
                pstm = con.prepareStatement(sql);
                pstm.setString(1,  objmusicadto.getNome_musica());
                
               

                pstm.execute();
                pstm.close();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir a musica" + erro);
            }
     } 
    */

   public ArrayList<MusicaDTO> puxarMusica(){
       
       String sql = " select * from musicas ";
        con = new ConexaoDAO().conectaBD();
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                MusicaDTO objmusicadto = new MusicaDTO();
                objmusicadto.setMusicId(rs.getInt("musicId"));
                objmusicadto.setNome_musica(rs.getString("nome_Musica"));
                
                lista.add(objmusicadto);
            }
        }
       
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao puxa a musica do banco: " + erro );
        }
       
       
       
       return lista;      
    }  
}
