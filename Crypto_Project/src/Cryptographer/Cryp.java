package Cryptographer;

public class Cryp {
    
    public String cryptletters (String text, String letters,int increase)//Parameters: original text, String base for encrypted cesar, key increment
     {//only encrypted letters
        int word=1;//initialized word counter
        int phrase=1;//initialized phrase counter
        String textcryp="";//initialized encrypted phrase   
        
        for(int i = 0;i < text.length();i++){
            if(text.charAt(i)==' '){
                textcryp+=text.charAt(i);
                word+=1;//increment of word counter
             }
            if(text.charAt(i)=='.'){
                textcryp+=text.charAt(i);
                phrase+=1;//Phrase counter increment
                word=1;//restarted word counter
             }
            if(text.charAt(i)=='0'||text.charAt(i)=='1'||text.charAt(i)=='2'||text.charAt(i)=='3'||text.charAt(i)=='4'||
               text.charAt(i)=='5'||text.charAt(i)=='6'||text.charAt(i)=='7'||text.charAt(i)=='8'||text.charAt(i)=='9'){
                textcryp+=text.charAt(i);//ignored of numbers, to only modify letters
            }
            for(int  j= 0;j < letters.length();j++){//writing and concatenation of encrypted String
                //encryption function using the increase the word and the phrase
                int function_latters=(phrase+word+increase);
                
                if(text.charAt(i)==letters.charAt(j)){
                    textcryp+= letters.charAt((Math.abs(j+(function_latters)))%letters.length());//use module in case the size is exceeded                  
                }                                            
            }
        }return textcryp;//returns text 
    }
    public String cryptnumbers (String text, String numbers, int increase )//Parameters: original text, String base for encrypted cesar, key increment
     {//only encrypted numbers
        int word=1;//initialized word counter
        int phrase=1;//initialized phrase counter
        String textcryp="";//initialized encrypted phrase
        
        for(int i = 0;i < text.length();i++){
            if(text.charAt(i)==' '){
                textcryp+=text.charAt(i);
                word+=1;//increment of word counter
             }
            if(text.charAt(i)=='.'){
                textcryp+=text.charAt(i);
                phrase+=1;//Phrase counter increment
                word=1;//restarted word counter
             }
            if(text.charAt(i)=='a'||text.charAt(i)=='b'||text.charAt(i)=='c'||text.charAt(i)=='d'||text.charAt(i)=='e'||
               text.charAt(i)=='f'||text.charAt(i)=='g'||text.charAt(i)=='h'||text.charAt(i)=='i'||text.charAt(i)=='j'||
               text.charAt(i)=='k'||text.charAt(i)=='l'||text.charAt(i)=='m'||text.charAt(i)=='n'||text.charAt(i)=='o'||
               text.charAt(i)=='p'||text.charAt(i)=='q'||text.charAt(i)=='r'||text.charAt(i)=='s'||text.charAt(i)=='t'||
               text.charAt(i)=='u'||text.charAt(i)=='v'||text.charAt(i)=='w'||text.charAt(i)=='x'||text.charAt(i)=='y'||
               text.charAt(i)=='z'){                   
               textcryp+=text.charAt(i);//ignored of latters, to only modify numbers
            }
            for(int  j= 0;j < numbers.length();j++){//writing and concatenation of encrypted String
                //encryption function using the increase the word and the phrase
                int function_numbers=(phrase+word+increase);
                
                if(text.charAt(i)==numbers.charAt(j)){
                    textcryp+= numbers.charAt((Math.abs(j+(function_numbers)))%numbers.length());//use module in case the size is exceeded                   
                }                                            
            }
        }return textcryp;//returns text
    }    
}
//hasta aqui sirve perfectamente
