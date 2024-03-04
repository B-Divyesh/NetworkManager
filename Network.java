package Main;
import java.io.BufferedReader;


import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;

import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
public class Network {
	NetworkInterface networkDetails;
	
	public Network() {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				
				if (!ni.isLoopback() && ni.isUp()) {
					networkDetails = ni;
					break;
				}
			}
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public String getInterfaceName() {
		if (networkDetails !=null) {
			return networkDetails.getName();
		}
		else {
			return null;
		}
	}
	public String getExternalIp() throws Exception{
		URI externalIp = new URI("http://checkip.amazonaws.com");
		URL url = externalIp.toURL(); 
		String message;
		String networkMessage = "check network interfaces";
		try {
			
			if (networkDetails !=null) {
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String ip = in.readLine();
				return ip;
			}
			else {
				return networkMessage;
			}
			
		}
		catch (MalformedURLException e) {
			 message = "unable to process request";
			 return message;
		}
		
	}
	

	public String hostDetails() throws UnknownHostException {
		String address = null;
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			address = localHost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}	
		return address;
	}
	
}
