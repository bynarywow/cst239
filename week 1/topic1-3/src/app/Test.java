package app;

/**
 * driver for car class
 * @author michael melichar
 * 
 */

public class Test
{
	public static void main(String[] args)
	{
		//default constructor car
		Car car = new Car();

		//constructor with good enough psi for tires
		Car lightning = new Car(34, "Lightning McQueen");
		
		//constructor with low psi tires
		Car mater = new Car(20, "Mater the Tow Truck");
		
		//honestly interested in how to fix this so that despite
		//a silly naming convention, I could do this in less lines.
		Car[] cars = new Car[3];
		cars[0] = car;
		cars[1] = lightning;
		cars[2] = mater;
		
		System.out.println("Racers, start your engines!");
		
		for(int i = 0; i < 3; i++)
		{
			//START METHOD USE
			//expected behavior: Accepts first two cars (car and lightning) rejects third for low psi tires(mater)
			cars[i].startEngine();
		}
		
		System.out.println("Uh-oh! Looks like " + mater.getName() + "'s having some trouble getting started!");
		System.out.println();
		
		//instantiating a pseudo race timer that won't end where we want it to,
		//since the things that this program will be doing won't be complicated enough
		//to consume tangible amounts of time, it's more for show.
		long[] raceTimes = new long[3];
		long fastest=9999;
		int index = 4;
		int addTime = 0;
		
		for(int i = 0; i < 3; i++)
		{
			long startTime = System.currentTimeMillis();
			//check engine state
			if(cars[i].getIsRunning())
			{
				while(cars[i].getSpeed() < cars[i].MAX_SPEED)
				{
					//accelerate method use
					cars[i].accelerate();
					//lightning mcqueen is a cheater
					if(cars[i].getName() != "Lightning McQueen")
					{
						addTime += 1;
					}
				}
			}
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime + addTime;
			raceTimes[i] = totalTime;
			System.out.println(cars[i].getName() + ": " + totalTime + " seconds");
			addTime = 0;
		}
		for(int i = 0; i < 3; i++)
		{
			if(raceTimes[i] < fastest)
			{
				fastest = raceTimes[i];
				index = i;
			}
		}
		System.out.println("We have a winner! " + cars[index].getName() + " won with a time of " + fastest + " seconds!");
		
		System.out.println();
		System.out.println("Slowing down:");
		for(int i = 0; i < 3; i++)
		{
			//check engine state
			if(cars[i].getIsRunning())
			{
				while(cars[i].getSpeed() > cars[i].MIN_SPEED)
				{
					//DECELERATE METHOD USE
					cars[i].decelerate();
				}
				System.out.println(cars[i].getName() + ": " + cars[i].getSpeed() + " mph");
			}
		}
	}
}