package design.parklot;

public interface ParkLotInf {

	public  int DefMiddleSpots = 4;
	public  int DefSmallSpots = 5;
	public  int DefLargeSpots = 6;
	
	boolean acceptableSize(Car c);
	boolean availableSpot(Size s);
	boolean enqueue(Car c);
	Car dequeue(Car c);

}
