/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc.project;
import db.DBHelper;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class JdbcProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       DBHelper.getConnection();

        MahasiswaModel mhs = new MahasiswaModel();
        
       Mahasiswa mhs1 = new Mahasiswa("2117051023", "Ika Rahma Alia");
       mhs.deleteMahasiswa(mhs1);
        
        ArrayList <Mahasiswa> listMahasiswa= mhs.getMahasiswa();
        
        for(int i= 0; i< listMahasiswa.size(); i++){
            System.out.println("Nama: "+ listMahasiswa.get(i).getNama());
            System.out.println("NPM: "+ listMahasiswa.get(i).getNpm());
            System.out.println(" ");
        
        }
        
        
    }
    
}
