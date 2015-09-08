package heap;

public class Heap<T>  {

	int N =0;
	private Comparable<T>[] pq;
	Heap(int N){
		pq = new Comparable[N];
		this.N = N;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	<T> void insert(T x){
		pq[++N] = (Comparable) x;
		swim(N);
	}
	
	void swim(int k){
		while(k<1 && less(k/2,k)){
			exch(k,k/2);
			k = k/2;
		}
	}
	private void exch(int k, int i) {
		// TODO Auto-generated method stub
		Comparable<T> tmp = pq[k];
		pq[k] = pq[i];
		pq[i] = tmp;
		
		
	}
	private boolean less(int i, int k) {
		// TODO Auto-generated method stub
		return pq[i].compareTo((T) pq[k]) < 0;
	}
	
	private void sink(int k)
	{
	 while (2*k <= N)
	 {
	 int j = 2*k;
	 if (j < N && less(j, j+1)) j++;
	 if (!less(k, j)) break;
	 exch(k, j);
	 k = j;
	 }
	}
	
	public T delMax()
	{
	 T max = (T) pq[1];
	 exch(1, N--);
	 sink(1);
	 pq[N+1] = null;
	 return max;
	} 


	
}
