package app;


public class Car
{
	//constants
	public int MIN_PSI = 32;
	public int MAX_SPEED = 60;
	public int MIN_SPEED = 1;
	
	//variable declarations	
	private Engine engine;
	private Tire[] tires;
	private int speed;
	private boolean isRunning = false;
	private String name;
	
	/**
	 * default constructor instantiates 4 of the same basic tire
	 * and an engine
	 */
	public Car()
	{
		Tire[] tires = new Tire[4];
		this.tires = tires;
		Engine engine = new Engine();
		this.engine = engine;
		this.name = "Average Phoenix Driver";

		Tire tire = new Tire();
		for(int i = 0; i < 4; i++)
		{
			this.tires[i] = tire;
		}
	}
	/**
	 * Constructor that instantiates 4 of the same specified tire
	 * and an engine
	 * @param tire
	 */
	public Car(int psi, String name)
	{
		Engine engine = new Engine();
		this.engine = engine;
		this.name = name;
		Tire[] tires = new Tire[4];
		this.tires = tires;
		
		Tire tire = new Tire(psi);
		
		for(int i = 0; i < 4; i++)
		{
			this.tires[i] = tire;
		}
	}
	/**
	 * checks if tire pressure is sufficient to start car
	 * @return boolean
	 */
	public boolean checkPsi()
	{
		for(int i = 0; i < 4; i++)
		{
			if(this.tires[i].getPsi() < MIN_PSI)
			{
				return false;
			}
			else
			{
				continue;
			}
		}
		return true;
	}
	
	/**
	 * startEngine implements logic into checking if we can start the engine
	 * then starting it if possible, printing an error to console if not
	 */
	public void startEngine()
	{
		if(checkPsi() && !getIsRunning())
		{
			this.engine.start();
			this.isRunning = true;
		}
		else
		{
			System.out.println("Tire pressure too low or the engine is already running!");
		}
	}
	
	/**
	 * method to check if the car is running or not
	 * @return boolean
	 */
	public boolean getIsRunning()
	{
		return this.isRunning;
	}
	
	/**
	 * accelerate makes sure the car is running,
	 * then increments speed if possible
	 */
	public void accelerate()
	{
		if(getIsRunning() && this.speed < MAX_SPEED)
		{
			this.speed += 1;
		}
		else
		{
			System.out.println("Engine must be turned on or the car is currently at maximum speed.");
		}
	}
	/**
	 * decelerate checks if the speed is less than 1, as we don't want
	 * to deal with negative speeds in this race, no one's going
	 * backward like parzival here.
	 */
	public void decelerate()
	{
		if(this.speed < MIN_SPEED)
		{
			System.out.println("Cannot decelerate, speed is at " + this.speed);
		}
		else
		{
			this.speed -= 1;
		}
	}
	
	/**
	 * stopEngine stops the engine and switches the boolean flag isRunning to false
	 */
	public void stopEngine()
	{
		this.engine.stop();
		this.isRunning = false;
	}
	
	/**
	 * restartEngine stops the engine with stopEngine,
	 * then restarts it with startEngine.
	 */
	public void restartEngine()
	{
		stopEngine();
		startEngine();
	}
	
	public int getSpeed()
	{
		return this.speed;
	}

	public String getName()
	{
		return this.name;
	}

	
	/**
	 * Tire class that has PSI property and
	 * a way to get and set PSI for tires as
	 * well as default and input based constructors
	 * @author michael
	 *
	 */
	public class Tire
	{
		//var
		private int psi;
		
		public Tire()
		{
			this.psi = MIN_PSI;
		}
	
		public Tire(int psi)
		{
			this.psi = psi;
		}
		
		public int getPsi() {
			return psi;
		}
	
		public void setPsi(int psi) {
			this.psi = psi;
		}
		
	}
	
	/**
	 * Engine that can start and stop
	 * @author michael
	 *
	 */
	public class Engine  
	{  
	    public void start()  
	    {  
	    	System.out.println("Engine has started");
	    }  
	    public void stop()  
	    {  
	        System.out.println("Engine has stopped");  
	    }  
	}  
}