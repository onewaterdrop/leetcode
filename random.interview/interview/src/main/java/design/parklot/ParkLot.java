package design.parklot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ParkLot implements ParkLotInf {
	
	private static ParkLot p=null;
	
	private LinkedList<Car> pool = new LinkedList<Car>();
	
	private HashMap<Size,Boolean> acceptSize = new HashMap<Size,Boolean>();
	private HashMap<Size,Integer> account = new HashMap<Size,Integer>();	
	
	private ParkLot(){
		account.put(Size.LARGE, 4);
		account.put(Size.MIDDLE, 5);
		account.put(Size.SMALL, 6);
		acceptSize.put(Size.LARGE, true);
		acceptSize.put(Size.MIDDLE, true);
		acceptSize.put(Size.SMALL, true);
	}
	
	public static ParkLot getInstance(){
		if(p==null){
			p = new ParkLot();
		}
		
		return p;
	}
	

	public boolean acceptableSize(Car c) {
		// TODO Auto-generated method stub
		if(acceptSize.containsKey(c.getSize()))return true;
		else{
			return false;
		}
	}

	public boolean availableSpot(Size s) {
		// TODO Auto-generated method stub
		if(account.get(s)>0){
			return true;
		}else{
			return false;	
		}

	}

	public boolean enqueue(Car c) {
		// TODO Auto-generated method stub
		if(acceptableSize(c) && availableSpot(c.getSize())){
			account.put(c.getSize(),account.get(c.getSize())-1);
			pool.add(c);
			return true;
			
		}
		
		return false;
	}

	public Car dequeue(Car c) {
		// TODO Auto-generated method stub
		if(acceptableSize(c) && IsParked(c) ){
			removeFromFool(c);
			
			account.put(c.getSize(),account.get(c.getSize())+1);

			return c;
		}
		return null;
	}

	private boolean IsParked(Car c) {
		// TODO Auto-generated method stub
		if(pool.contains(c)){
			return true;
		}else{
			return false;
		}
	}
	
	public String checkCapacity(){
		return account.toString() + " " + pool.toString();
	}

	private Car removeFromFool(Car c){
		pool.remove(c);
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkLot p = ParkLot.getInstance();
		
		ArrayList<Car> small = new ArrayList<Car>();
		ArrayList<Car> middle = new ArrayList<Car>();
		ArrayList<Car> large = new ArrayList<Car>();
		
		for(int i=0;i<6;i++){
			RealCar car1=new RealCar();
			car1.setId(i);
			car1.setSize(Size.SMALL);
			small.add(car1);
			
		}
		
		for(int i=0;i<5;i++){
			RealCar car1=new RealCar();
			car1.setId(i);
			car1.setSize(Size.MIDDLE);
			middle.add(car1);
			
		}
		for(int i=0;i<5;i++){
			RealCar car1=new RealCar();
			car1.setId(i);
			car1.setSize(Size.LARGE);
			large.add(car1);
			
		}
		
		RealCar xlarge = new RealCar(Size.XLARGE,1);
		
		p.checkCapacity();
		
		for(int i=0;i<small.size();i++){
			p.enqueue(small.get(i));
			System.out.println(p.checkCapacity());
		}
		for(int i=0;i<middle.size();i++){
			p.enqueue(middle.get(i));
			System.out.println(p.checkCapacity());
		}
		for(int i=0;i<large.size();i++){
			p.enqueue(large.get(i));
			System.out.println(p.checkCapacity());
		}

		for(int i=0;i<small.size();i++){
			p.dequeue(small.get(i));
			System.out.println(p.checkCapacity());
		}
		for(int i=0;i<middle.size();i++){
			p.dequeue(middle.get(i));
			System.out.println(p.checkCapacity());
		}
		for(int i=0;i<large.size();i++){
			p.dequeue(large.get(i));
			System.out.println(p.checkCapacity());
		}
		
		System.out.println(p.acceptableSize(xlarge));
		

	}
	
	

}
