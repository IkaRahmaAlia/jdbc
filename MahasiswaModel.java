/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.project;

import db.DBHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */

public class MahasiswaModel {
    private final Connection CONN;

    public MahasiswaModel() {
        this.CONN = DBHelper.getConnection();
    }

    public void addMahasiswa(Mahasiswa mhs){
        String insert = "INSERT INTO mhs VALUES ("
                +mhs.getNpm() + ",'"+ mhs.getNama()
                +"');";
        
        
        try {
            if (CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("berhasil memasukkan data");
            }else{
                System.out.println("gagal memasukkan data");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("gagal memasukkan data");
        }
        
        //        System.out.println(insert);
    }
    
    public ArrayList<Mahasiswa> getMahasiswa(){
        String query = "SELECT * FROM mhs";
        ArrayList<Mahasiswa> mhs= new ArrayList<Mahasiswa>();
             
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Mahasiswa temp = new Mahasiswa(rs.getString("npm"), rs.getString("nama"));
                mhs.add(temp);
            }
            System.out.println("berhasil mengambil data");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("gagal mengambil data");
        }
        return mhs;
    }

    public void updateMahasiswa(Mahasiswa mhs) {
        String update ="UPDATE mhs SET nama = '"+ mhs.getNama() + "'WHERE npm = '"+mhs.getNpm()+"'";

        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("berhasil mengubah data");
            } else {
                System.out.println("gagal mengubah data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("gagal mengubah data ");
        }

    }

    public void deleteMahasiswa(Mahasiswa mhs) {
        String delete = "DELETE FROM mhs WHERE npm = '" + mhs.getNpm() + "'";

        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("berhasil menghapus data");
            } else {
                System.out.println("gagal menghapus data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("gagal menghapus data ");
        }
    }
}
