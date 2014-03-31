package org.lukedowell.exampleapp.shared.net;

import java.util.LinkedList;

import org.lukedowell.exampleapp.shared.entities.Entity;
import org.lukedowell.exampleapp.shared.entities.Report;
import org.lukedowell.exampleapp.shared.entities.ReportEntry;
import org.lukedowell.exampleapp.shared.net.message.LoginRequest;
import org.lukedowell.exampleapp.shared.net.message.LoginResponse;
import org.lukedowell.exampleapp.shared.net.message.ReportRequest;
import org.lukedowell.exampleapp.shared.net.message.ReportResponse;

import com.esotericsoftware.kryo.Kryo;

/**
 * Just a class I use to hold a lot of the constant information
 * about our network. Also I use it to register the classes I'm going 
 * to be sending over the network with Kryo
 * 
 * @author Luke Dowell
 *
 */
public class Network {

	/** What port we are going to listen to */
	public static final int PORT = 54555;
	
	/**
	 * Registers all our classes for use with Kryonet
	 * @param k
	 * 		The kryo serialization object we are going to register with
	 */
	public static void register(Kryo k) {
		
		k.register(Entity.class);
		k.register(Report.class);
		k.register(ReportEntry.class);
		
		k.register(LoginRequest.class);
		k.register(LoginResponse.class);
		k.register(ReportRequest.class);
		k.register(ReportResponse.class);
		k.register(LinkedList.class);
	}
}
