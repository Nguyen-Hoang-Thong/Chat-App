/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class MessageTransmistter extends Thread{
	String message;
	InetAddress hostname;
	int port;

	public MessageTransmistter(String message, InetAddress hostname, int port) {
		this.message = message;
		this.hostname = hostname;
		this.port = port;
		
	}
	
	public MessageTransmistter(){
		
	}

	@Override
	public void run() {
		try {
			Socket s = new Socket(hostname, port);
			s.getOutputStream().write(message.getBytes());
			s.close();
		} catch (IOException ex) {
			Logger.getLogger(MessageTransmistter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
}
