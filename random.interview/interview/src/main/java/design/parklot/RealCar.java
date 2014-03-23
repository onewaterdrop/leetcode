package design.parklot;

public class RealCar extends Car {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	
	public RealCar(){
		super();
		this.id=1;
		this.size=Size.SMALL;
	}
	
	public RealCar(Size s,int id){
		super();
		this.id=id;
		this.size=s;
	}
	
	@Override
	public Size getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String toString(){
		return "\t[Car id=" +id+ ", size=" + size.toString() + "]";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealCar other = (RealCar) obj;
		if (id != other.id)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	

}
