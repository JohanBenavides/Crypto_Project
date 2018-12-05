//this project consists of encrypting and decrypting a text
package Cryptographer;
import java.io.*;
/**
 *
 * @Johan Benavides Arias
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Main p_f = new Main();//principal_functions to use main classes
    static Cryp c_f = new Cryp();//Cryptography functions methods
    static String Green = "\033[32m";//method to use colors in the letters
    static String Default = "\033[39m";//method to use colors in the letters
    
    static int pass;//encryption and decryption key
    
    public String text ()throws IOException//to not use try catch I used this method throws IOException
     {//"text" function to request text and pass
         bw.write("\nINGRESE TEXTO:\n\n");
         bw.flush();
         String text = br.readLine();//text request             
                                       
         int i=0;         
         while(text.charAt(i)!='.'){//the key is all the text that is before the first point 
            i++;                       
         }
         pass=Math.abs(Integer.parseInt(text.substring(0,i)));//pass
         //bw.write("\nClave: "+pass+"\n");bw.flush();//test
         text=text.substring(i+1, text.length()); //extracted text        
         //bw.write("\ntexto para codificar: "+text+"\n");bw.flush();//test               
         return text.toLowerCase();//text return
     }          
    public String replacevowels (String text)
     {      
            text=text.toLowerCase();//Converts all of the characters in this String to lower case            
            //replacement of vowels by numbers
            text = text.replace('a','4'); 
            text = text.replace('e','3');
            text = text.replace('i','1');
            text = text.replace('o','0');
            text = text.replace('u','9');
            
            return text;//this function returns the modified string
     } 
    public String replacenumbers (String text)
     {
            //replacement of numbers by vowels
            text = text.replace('4','a'); 
            text = text.replace('3','e');
            text = text.replace('1','i');
            text = text.replace('0','o');
            text = text.replace('9','u');
            
            return text;//this function returns the modified string
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option;
        String text;
        String letters ="abcdefghijklmnopqrstuvwxyz";//letters for encryption
        String numbers ="0123456789";//numbers for encryption
        String decrypletters ="zyxwvutsrqponmlkjihgfedcba";//letters for decryption
        String decrypnumbers ="9876543210";//numbers for decryption               
        try{
            do 
            {//use the "do while" cycle, to repeat the menu until you decide to exit it with option 3   
                bw.write(".: ENCRIPTADO Y DESENCRIPTADO :.\n\n");//menu
                bw.write("1. Encriptar texto\n");
                bw.write("2. Desencriptar texto\n");                
                bw.write("3. Salir\n");
                bw.write("\nOpción: ");
                bw.flush();
                
                String op = br.readLine();//option request
                option = Integer.parseInt(op);
                
                switch (option){//Switch case is a control structure, It is used to streamline multiple decision making
                    
                    case 1:
                    {
                        bw.write("\n.:ENCRIPTADO:.\n");
                        bw.flush();
                        text=p_f.text();//text request                                             
                        text=p_f.replacevowels(text);//replacement of vowels by numbers
                        bw.write("\nVocales cambiadas:                   "+text);bw.flush();                        
                        text=c_f.cryptletters(text,letters,pass);//encryption of letters
                        bw.write("\nLetras encriptadas:                  "+text);bw.flush();
                        text=c_f.cryptnumbers(text,numbers,pass);//encrypted of numbers
                        bw.write("\nNúmeros encriptados:                 "+text);bw.flush();
                        bw.write("\n\nEl Texto encriptado es el siguiente: "+Green+""+text+"\n\n"+Default);                                           
                    }
                    break;//the use of this statement breaks the iteration of said loop
                    
                    case 2:
                    {
                        bw.write("\n.:DESENCRIPTADO:.\n");
                        bw.flush();
                        text=p_f.text();//text request
                        text=c_f.cryptnumbers(text,decrypnumbers,pass);//decryption of numbers
                        bw.write("\nNúmeros desencriptados:                 "+text);bw.flush();
                        text=c_f.cryptletters(text,decrypletters,pass);//decryption of letters
                        bw.write("\nLetras desencriptadas:                  "+text);bw.flush();                        
                        text=p_f.replacenumbers(text);//replacement of numbers by vowels
                        bw.write("\nNúmeros cambiados:                      "+text);bw.flush();
                        bw.write("\n\nEl Texto desencriptado es el siguiente: "+Green+""+text+"\n\n"+Default); 
                                              
                    }
                    break;//the use of this statement breaks the iteration of said loop                   
                                        
                    default: if(option!=3){//if the default case is different from 3 the option is not valid
                        bw.write("\n¡OPCIÓN NO VALIDA!\n");
                    }         
                }                        
                
            }while (option!=3);//condition of the "do while" cycle
            bw.flush();
        }catch (IOException ex){}
    }
    
}
