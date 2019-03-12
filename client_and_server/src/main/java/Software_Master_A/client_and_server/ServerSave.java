package Software_Master_A.client_and_server;

/**
 * @author liujiang
 * This class is used to help the server to save itself
 */
 
public class ServerSave extends Thread{

	Server server;
	long time = 2000;
	
	
	public ServerSave(Server server) {
		// TODO Auto-generated constructor stub
		this.server = server;
	}
	
	
	
	public ServerSave(Server server, long time) {
		super();
		this.server = server;
		this.time = time;
	}



	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * This function is built to enable server to save itself every 2 minutes
	 */
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
