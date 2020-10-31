package app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.json.JSONException;
import org.json.JSONObject;

import networktools.IpAddress;
import networktools.MacAddress;
import networktools.NetworkDevice;

public class Data {
	
	private final String USERNAME_KEY = "username";
	private final String PASSWORD_KEY = "password";
	private final String IP_ADDRESS_KEY = "ipAddress";
	private final String MAC_ADDRESS_KEY = "macAddress";
	private final String PING_TIMEOUT_KEY = "pingTimeout";
	
	private final String X_KEY = "x";
	private final String Y_KEY = "y";
	
	private boolean empty_settings;
	
	private File root_dir;
	private File settings_file;
	private File position_file;
	
	private JSONObject position_obj;
	private JSONObject settings_obj;
	
	private NetworkDevice networkDevice;
	
	public Data() {
		check_read_paths();
		
		networkDevice 	= new NetworkDevice(get_mac_address(), get_ip_address());
	}
	
	public boolean are_settings_empty() {
		return empty_settings;
	}
	
	public void exit(int x, int y) {
		// letzte Position speichern
		write_position(x, y);
	}
	
	public boolean is_windows() {
		return System.getProperty("os.name").toLowerCase().contains("win");
	}
	
	// Getter
	public int get_x() {
		try {
			return position_obj.getInt(X_KEY);
		} catch (JSONException e) {
			return 100;
		}
	}
	
	public int get_y() {
		try {
			return position_obj.getInt(Y_KEY);
		} catch (JSONException e) {
			return 100;
		}
	}
	
	public NetworkDevice get_network_device() {
		return networkDevice;
	}
	
	public String get_username() {
		try {
			return settings_obj.getString(USERNAME_KEY);
		} catch (JSONException e) {
			return "";
		}
	}

	public String get_password() {
		try {
			return settings_obj.getString(PASSWORD_KEY);
		} catch (JSONException e) {
			return "";
		}
	}

	public String get_ip_address() {
		try {
			return settings_obj.getString(IP_ADDRESS_KEY);
		} catch (JSONException e) {
			return "";
		}
	}

	public String get_mac_address() {
		try {
			return settings_obj.getString(MAC_ADDRESS_KEY);
		} catch (JSONException e) {
			return "";
		}
	}
	
	public int get_ping_timeout() {
		try {
			return Integer.parseInt(settings_obj.getString(PING_TIMEOUT_KEY));
		} catch (JSONException e) {
			return NetworkDevice.TIMEOUT;
		}
	}
	
	private void check_read_paths() {
		root_dir = new File(System.getProperty("user.dir") + File.separator + ".nas");
		if(!root_dir.exists()) {
			root_dir.mkdir();
		}
		
		settings_file = new File(root_dir.toString() + File.separator + "settings.json");
		if(!settings_file.exists()) {
			try {
				settings_file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		position_file = new File(root_dir.toString() + File.separator + "position.json");
		if(!position_file.exists()) {
			try {
				position_file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		read_position();
		read_settings();
	}
	
	private void read_position() {
		String result = null;
		try {
			BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(position_file) ) );
			result = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			write_empty_position();
		}
		
		if(result != null) {
			try {
				position_obj = new JSONObject(result);
				position_obj.getInt(X_KEY);
				position_obj.getInt(Y_KEY);

			} catch(Exception e) {
				e.printStackTrace();
				write_empty_position();
			}
		} else {
			write_empty_position();
		}
	}
	
	private void write_empty_position() {
		write_position(0, 0);
	}
	
	public void write_position(int x, int y) {
		try {
			position_obj = new JSONObject();
			position_obj.put(X_KEY, x);
			position_obj.put(Y_KEY, y);
			
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(position_file) ) );
			bw.write(position_obj.toString());
			bw.flush();
			bw.close();
		} catch (Exception e) {}
	}
	
	private void read_settings() {
		String result = null;
		try {
			BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(settings_file) ) );
			result = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			write_empty_settings();
		}
		
		if(result != null) {
			try {
				settings_obj = new JSONObject(result);
				String username = settings_obj.getString(USERNAME_KEY);
				String password = settings_obj.getString(PASSWORD_KEY);
				String ipAddress = settings_obj.getString(IP_ADDRESS_KEY);
				String macAddress = settings_obj.getString(MAC_ADDRESS_KEY);
				int pingTimeout = settings_obj.getInt(PING_TIMEOUT_KEY);
				
				empty_settings = !( !username.equals("") 
									&& !password.equals("")
									&& IpAddress.is_ipv4_address_valid(ipAddress)
									&& MacAddress.is_mac_address_valid(macAddress)
									&& pingTimeout > 0 );
			} catch(Exception e) {
				e.printStackTrace();
				write_empty_settings();
			}
		} else {
			write_empty_settings();
		}
	}
	
	private void write_empty_settings() {
		write_settings("", "", "", "", NetworkDevice.TIMEOUT);
	}
	
	public void write_settings(String username, String password, String ipAddress, String macAddress, int pingTimeout) {
		try {
			settings_obj = new JSONObject();
			settings_obj.put(USERNAME_KEY, username);
			settings_obj.put(PASSWORD_KEY, password);
			settings_obj.put(IP_ADDRESS_KEY, ipAddress);
			settings_obj.put(MAC_ADDRESS_KEY, macAddress);
			settings_obj.put(PING_TIMEOUT_KEY, pingTimeout);
			
			empty_settings = !( !username.equals("")
								&& !password.equals("")
								&& IpAddress.is_ipv4_address_valid(ipAddress)
								&& MacAddress.is_mac_address_valid(macAddress)
								&& pingTimeout > 0);
			
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(settings_file) ) );
			bw.write(settings_obj.toString());
			bw.flush();
			bw.close();
		} catch (Exception e) {}
	}
}
