import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
		
	public BufferedReader br;
	public BufferedWriter bw;
	public static int  towerA;
	public static int  towerB;
	public static int  towerC;
	
	public Main() throws IOException {
		
		br = new BufferedReader(new FileReader("data/Hanoi_input.txt"));
		bw = new BufferedWriter(new FileWriter("data/output.txt"));
	}
	
	public static void main(String[] args) throws IOException {
		
		Main app = new Main();
			
		int amount = Integer.parseInt(app.br.readLine());
		
		int [] cases = new int[amount];
		for(int i=0;i < amount;i++) {
			
			cases[i] = Integer.parseInt(app.br.readLine());
			
			}
		for(int i=0; i < cases.length;i++) {
			towerA = cases[i];
			towerB = 0;
			towerC = 0;
			app.bw.write(towerA + " " + towerB + " " + towerC + "\n");
			app.hanoi(cases[i],1, 2,3);
			app.bw.write("\n");

		}
		app.bw.close();
		app.br.close();
		}
		
	
	public void hanoi(int cases,int o, int a,int e) throws IOException{
		
		if (cases==1) {
			if(o==1 && e==3) {
				towerA--;
				towerC++;
	        }else if(o==1 && e==2) {
	        	towerA--;
	        	towerB++;
	        }else if(o==2 && e==1) {
	        	towerA++;
	        	towerB--;
	        }else if(o==2 && e==3) {
	        	towerC++;
	        	towerB--;
	        }else if(o==3 && e==1) {
	        	towerC--;
	            towerA++;
	        }else if(o==3 && e==2) {
	        	towerC--;
	        	towerB++;
	        }
			bw.write(towerA+" "+towerB+" "+towerC+"\n");
			return;
		}
		hanoi(cases-1, o, e, a);
		if(o==1 && e==3) {
			towerA--;
			towerC++;
        }else if(o==1 && e==2) {
        	towerA--;
        	towerB++;
        }else if(o==2 && e==1) {
        	towerA++;
        	towerB--;
        }else if(o==2 && e==3) {
        	towerC++;
        	towerB--;
        }else if(o==3 && e==1) {
        	towerC--;
            towerA++;
        }else if(o==3 && e==2) {
        	towerC--;
        	towerB++;
        }
		
		bw.write(towerA+" "+towerB+" "+towerC+"\n");
		
		hanoi(cases-1, a, o, e);
		
		
	}	
}
