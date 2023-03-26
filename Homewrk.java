package homework2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Random;


public class Homewrk {

	public static void main(String[] args) {
		File f = new File("odev2.txt");							
		try {
			int x=8;
			int y = x;	
			int w =x;
			Stack stc1= new Stack(x);
			Stack stc2= new Stack(x);
			Stack stc3= new Stack(x);
			Stack stc4= new Stack(x);
			Stack tempstack = new Stack(x);
			Stack tempstack2 = new Stack(x);
			Stack scorstack = new Stack(10);
			Stack namestack = new Stack(10);
			Stack templescorstack = new Stack(10);
			Stack templenamestack = new Stack(10);
			BufferedReader br = new BufferedReader(new InputStreamReader(
               new FileInputStream(f), "UTF8"));
			int i = 0;
			while (br.readLine()!=null) {				
				i++;
			}    
			Stack fruitstack= new Stack(i);
			Stack templefruitstack= new Stack(i);
			br.close();
			File z = new File("odev2.txt");
			BufferedReader as = new BufferedReader(new InputStreamReader(
					new FileInputStream(z), "UTF8"));	
			for(int k =0; k<i;k++) {
				fruitstack.push(as.readLine());
			}		
			System.out.println("Fruit Stack:");
			while (! (fruitstack.isEmpty())) {
				System.out.print(fruitstack.peek()+" ");
				templefruitstack.push(fruitstack.pop());
			}
			
			while (! (templefruitstack.isEmpty()))
				fruitstack.push(templefruitstack.pop());

			System.out.println("\n");
			
			
			Random r=new Random();
			for(int h=0;h<x;h++) {
				int a=r.nextInt(w);
				for(int d =0;d<a;d++) {
					tempstack.push(fruitstack.pop());															
				}
				stc1.push(fruitstack.pop());
				for(int d =0;d<a;d++) {
					fruitstack.push(tempstack.pop());															
				}	
				w--;
			}		
			for(int h=0;h<x;h++) {
				tempstack.push(stc1.peek());
				tempstack2.push(stc1.pop());
			}		
			
			for(int h=0;h<x;h++) {
				stc1.push(tempstack.pop());
			}
			for(int h=0;h<x;h++) {
				int a=r.nextInt(y);
				for(int d =0;d<a;d++) {
					tempstack.push(tempstack2.pop());															
				}
				stc2.push(tempstack2.pop());
				for(int d =0;d<a;d++) {
					tempstack2.push(tempstack.pop());															
				}
				y--;
			}		
			
			
			
			//score
			int score =0;
			int step =1;
			while(!stc1.isEmpty()) {
				int ý=r.nextInt(x);
				int p=r.nextInt(x);
				System.out.print("Stack1: ");
				while (! (stc1.isEmpty())) {
					System.out.print(stc1.peek()+" ");						
					tempstack.push(stc1.pop());
				}
				System.out.println(" ");
				while (! (tempstack.isEmpty()))
					stc1.push(tempstack.pop());	
				System.out.print("Stack2: ");
				while (! (stc2.isEmpty())) {
					System.out.print(stc2.peek()+" ");						
					tempstack2.push(stc2.pop());
				}
				System.out.println(" ");
				while (! (tempstack2.isEmpty()))
					stc2.push(tempstack2.pop());				
												
							
				for(int o =0;o<ý;o++) {
					stc3.push(stc1.pop());				
				}				
				for(int o =0;o<p;o++) {
					stc4.push(stc2.pop());				
				}				
				if(stc1.peek()!=null && stc2.peek()!=null) {
					if(stc1.peek().equals(stc2.peek())) {
						score += 20;
						stc1.pop();
						stc2.pop();
						for(int s =0;s<ý;s++) {
							stc1.push(stc3.pop());
						}
						for(int s =0;s<p;s++) {
							stc2.push(stc4.pop());
						}
						x--;
					}
					else {
						score -= 1;
						for(int s =0;s<ý;s++) {
							stc1.push(stc3.pop());
						}
						for(int s =0;s<p;s++) {
							stc2.push(stc4.pop());
						}
					}
				}
				else {
					for(int s =0;s<ý;s++) {
						stc1.push(stc3.pop());
					}
					for(int s =0;s<p;s++) {
						stc2.push(stc4.pop());
					}
				}
				System.out.println("Randomly generated numbers:"+ý +"-"+ p+"                "+"Step= " + step);
				System.out.println("                                              Score= " + score+"\n");
				step++;
			}
			System.out.println("Stack1: ");
			System.out.println("Stack2: ");
			
			System.out.println(" ");
			System.out.println("Game Over!!!");		
			as.close();
			
			String name = "You";
			File g = new File("scor.txt");
			BufferedReader file = new BufferedReader(new InputStreamReader(
		               new FileInputStream(g), "UTF8"));
			for(int k =0; k<10;k++) {
				namestack.push(file.readLine());
				scorstack.push(file.readLine());
			}
			file.close();
			while(Integer.parseInt((String)scorstack.peek())<=score) {
				templescorstack.push(scorstack.pop());
				templenamestack.push(namestack.pop());
			}
			String score1 = String.valueOf(score);
			scorstack.push(score1);
			namestack.push(name);
			while(!scorstack.isFull()) {
				scorstack.push(templescorstack.pop());
				namestack.push(templenamestack.pop());
			}
			templescorstack.pop();
			templenamestack.pop();
			
			while(!scorstack.isEmpty()) {
				templescorstack.push(scorstack.pop());
				templenamestack.push(namestack.pop());
			}
			
			while (! (templescorstack.isEmpty())) {
				System.out.println(templenamestack.peek()+" "+ templescorstack.peek());				
				scorstack.push(templescorstack.pop());
				namestack.push(templenamestack.pop());
			}
			while (! (scorstack.isEmpty())) {
				templescorstack.push(scorstack.pop());
				templenamestack.push(namestack.pop());
			}
			
			File af = new File("scor.txt");
			FileWriter fw = new FileWriter(af, false);
			BufferedWriter writer = new BufferedWriter(fw);
			while(!templescorstack.isEmpty()) {
				writer.write((String)templenamestack.pop()+"\n");
				writer.write((String)templescorstack.pop()+"\n");
			}			
			writer.close();								
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
