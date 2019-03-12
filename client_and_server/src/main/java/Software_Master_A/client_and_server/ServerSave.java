package Software_Master_A.client_and_server;

public class ServerSave extends Thread{

	Server server;
	long time = 2000;
	public ServerSave(Server server) {
		// TODO Auto-generated constructor stub
		this.server = server;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
			server.save();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}


	/**
	 * @param server the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}


	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	
	
}
