/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k10server;

import java.awt.Frame;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class K10Server extends Frame implements Runnable {
BufferedReader br;
int OldX,OldY;
	public K10Server() {
		// TODO Auto-generated constructor stub
		try {
			ServerSocket ss = new ServerSocket(9999);
                        
                        System.out.println("waiting for connection from android");
			Socket s= ss.accept();
                        System.out.println("got a connection");
			InputStream is = s.getInputStream();  
			InputStreamReader isr = new InputStreamReader(is); 
			br= new BufferedReader(isr);
                        
                        setSize(500, 500);
                       setVisible(true);
			
			Thread t= new Thread( this);
			t.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		Graphics g = getGraphics();
		while(true)
		{
			String str;
			try {
				str = br.readLine();
				String sArr[] = str.split(",");
				int x = Integer.parseInt(sArr[0]);
				int y = Integer.parseInt(sArr[1]);
                                
                                //String IsVld = sArr[2].toString();
                                //if( IsVld.compareTo("T")>1)
                                //{
                                    g.drawLine(OldX, OldY, x, y);
                                    OldX = x;
                                    OldY= y;
                               // }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            K10Server k = new K10Server();
            
	}

}

