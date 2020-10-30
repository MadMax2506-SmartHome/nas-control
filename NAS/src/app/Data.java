package app;
import networktools.NetworkDevice;

public class Data {
	private NetworkDevice networkDevice;
	
	public Data() {
		networkDevice = new NetworkDevice("00:23:24:9c:b9:7e", "192.168.178.104");
	}
	
	public NetworkDevice get_network_device() {
		return networkDevice;
	}
	
	public int get_ping_timeout() {
		return 1000;
	}
}
