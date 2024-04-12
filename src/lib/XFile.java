/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

// import Lab.Dog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Anh Trinh
 */
public class XFile {
    public static void writeFile(String path) {
        File f = new File(path);
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(f);
            byte[] arr = {123};
            fos.write(arr);
            fos.close();
            
        }catch(FileNotFoundException e){
            System.err.println("Not Found");
            
        } catch (IOException ex) {
            System.err.println("Failed");
        }
    }
    public static void readFile(String path) {
         File f = new File(path);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            int fileSize = (int) f.length();
            byte[] arr = new byte[fileSize];
            fis.read(arr);
            for(int i = 0 ; i <fileSize ; i++){
                System.out.println(arr[i]+" ");
            }
            fis.close();
            
        }catch(FileNotFoundException e){
            System.err.println("Not Found");
            
        } catch (IOException ex) {
            System.err.println("Failed");
        }
        
    } 
    public static void writeDataFile(String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(5);
            dos.writeUTF("Trinh");
            dos.writeDouble(8.7);
            dos.close();
        }
        catch(IOException e){
            System.err.println("Failed");
        }
    }
    public static void readDataFile(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readInt()+ dis.readUTF()+dis.readDouble());
            
            dis.close();
            
        }
        catch(IOException e){
            System.err.println("Failed");
        } 
    }
    public static void writeBuffer(String path,String text){
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        }
        catch(IOException e){
            System.out.println("Failed");
        }
    }
    public static String readBuffer(String path){
        StringBuilder sb = new StringBuilder();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String firstLine = br.readLine();
            while(firstLine!=null){
                sb.append(firstLine);
                firstLine = br.readLine();
                if(firstLine!=null)sb.append("\n");

            }
        }catch(IOException e){
            System.out.println("Failed");
        }
//        System.out.println(sb.toString());
return sb.toString();
    }
    public static void writeObject(String path, Object o){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                            new FileOutputStream(path)
            ) 
            ;
            oos.writeObject(o);
            oos.close();
        }
        catch(IOException e){
            System.out.println("Failed");
        }
    }
    public static Object readObject(String path){
        try{
            ObjectInputStream ois = new ObjectInputStream(
                            new FileInputStream(path)
            ) 
            ;
//            oos.writeObject(o);
        Object o = ois.readObject();
            ois.close();
            return o;
        }
        catch(IOException e){
            System.out.println("Failed");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
//        String filePath ="./src/lib/testfile.dat";
//        writeFile(filePath);
//        readFile(filePath);
//        String newfile = "./src/lib/testData.dat";
//        writeDataFile(newfile);
//        readDataFile(newfile);
        // String newfile3 = "./src/lib/testData4.dat";
//        writeBuffer(newfile3, "nguyễn anh trinh \n trần đức bo");
//        readBuffer(newfile3);
//        String[] cat = {"meo muop","meo anh"};
        // List<Dog> doglist = new ArrayList<>();
        // doglist.add(new Dog("ma", "trinh", "gauagu",10, 10.0, true));
        //         doglist.add(new Dog("ma", "kiquaqua", "gauagu",10, 13.0, true));

        // writeObject(newfile3, doglist);
        // for (Dog d : doglist) {
        //     double w = d.getWeight();
        //     System.out.println(w);
        // }
        // List<Dog> readlist = (List<Dog>) readObject(newfile3);
        // for (Dog d : readlist) {
        //     System.out.println(d.getWeight());
            
        // }
//        System.out.println(readObject(newfile3));

        
    }
}
