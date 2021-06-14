/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class DaftarMenu {
    private ArrayList<Menu> daftarMenu;
    
    public DaftarMenu() {
        daftarMenu = new ArrayList<>();
    }
    
    public Menu pilihMenu() {
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.print("Nomor Menu yang dipesan : ");
            int no_menu = input.nextInt();
            
            Menu m = daftarMenu.get(no_menu-1);
            
            if(!m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
            }else{
                System.out.println("(Err) Pesab dulu Menu Ramen");
                return pilhMenu();
            }
        }catch(IndexOutOFBoundsException err) {
            System.out.println("(Err) Pesanan Tidak Tersedia");
            return pilihMenu();
        }catch(InputMismatchExpection err) {
            System.out.println("(Err) Mohon Masukan nomor menu");
            return pilihMenu();
        }
    }
    
    public Menu pilihKuah() {
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.print("Kuah [sesuai nomor menu] : ");
            int no_menu = input.nextInt();
            
            Menu m  = daftarMenu.get(no_menu-1);
            
            if(m.getKategori().equalsIgnorecase("Kuah")){
                return m;
            }else{
                System.out.println("[Err] Bukan Menu Kuah");
                return pilihKuah();
            }
        }catch(IndexOutOfBoundsException err) {
            System.out.println("[Err] Pesanan Tidak Tersedia");
            return pilihKuah();
        }catch(InputMismatchExeption err) {
            System.out.println("[Err] Mohon masukan nomor kuah");
            return pilihKuah();
        }
    }
    public void tambahMenu(Menu menu) { 
        daftarMenu.add(menu);
    }
    
    public void getMenuByKategori(String kategori) {
        System.out.println("==========" + kategori + "==========");
        
        for(int i = 0; i < daftarMenu.size(); i++) {
            Menu m = daftarMenu.get(i);
            if (m.getKategori().equals(kategori)) {
                System.out.println((i + 1) + ". " + m.getNama_menu() + "\t" + m.getHarga());
            }
        }
    }
    
    public void tampilDaftarMenu() { 
        System.out.println("========== VITO RAMEN =========");
        getMenuByKategori("Ramen");
        getMenuByKategori("Kuah");
        getMenuByKategori("Toping");
        getMenuByKategori("Minuman");
    }
}
