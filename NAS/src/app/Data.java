package app;
import networktools.NetworkDevice;

public class Data {
	
	private String username;
	private String password;
	private String ip_address;
	private String mac_address;
	private NetworkDevice networkDevice;
	
	public Data() {
		load_data();
	}
	
	public void load_data() {
		username 	= "Max";
		password 	= "25603";
		ip_address 	= "192.168.178.104";
		mac_address = "00:23:24:9c:b9:7e";
		
		networkDevice = new NetworkDevice(mac_address, ip_address);
	}
	
	// Setter
	
	// Getter
	public NetworkDevice get_network_device() {
		return networkDevice;
	}

	public String get_username() {
		return username;
	}

	public String get_password() {
		return password;
	}

	public String get_ip_address() {
		return ip_address;
	}

	public String get_mac_address() {
		return mac_address;
	}
	
	public int get_ping_timeout() {
		return 1000;
	}
}
