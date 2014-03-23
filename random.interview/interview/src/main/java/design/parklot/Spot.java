package design.parklot;

public class Spot extends AbsSpot {

	public Spot(Size s){
		super();
		this.capacity=s;
	}
	
	@Override
	Size getCapacity() {
		// TODO Auto-generated method stub
		return this.capacity;
	}
	
	@Override
	public String toString(){
		return "\t[Spot capacity is " + capacity.toString() + "]"; 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
