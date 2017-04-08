package rabinkarp;

public class RK {
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	
	public char[] buffer;
	public int hash;
	public int counter;
	public final int prevMultiplier;

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		this.buffer = new char[m];
		this.hash = 0;
		this.counter = 0;
		int ans = 1;
		for (int i=0; i < m; i++){
			ans = ((ans%511)*31)%511;
		}
		this.prevMultiplier = ans;
	}
	

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		int previous = buffer[counter];
		hash = ((((hash%511)*31)%511) - (prevMultiplier*previous)%511 + d)%511;
		if (hash < 0){
			hash = hash +511;
		}
		buffer[counter] = d;
		if (counter + 1 == buffer.length){
			counter = 0;
		}
		else {
			counter++;
		}
		
		return hash;
	}
	public static void main(String[] args) {
		RK r = new RK(4);
		int a = r.nextCh('a');
		int b = r.nextCh('a');
		int c = r.nextCh('b');
		int d = r.nextCh('a');
		int e = r.nextCh('a');
		int f = r.nextCh('c');
		int g = r.nextCh('a');
		int h = r.nextCh('a');
		int i = r.nextCh('d');
		int j = r.nextCh('a');
		int k = r.nextCh('a');
		int l = r.nextCh('b');
		int m = r.nextCh('a');
		int n = r.nextCh('a');
		int o = r.nextCh('b');
		int p = r.nextCh('a');
		int q = r.nextCh('a');
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);
		System.out.println(n);
		System.out.println(o);
		System.out.println(p);
		System.out.println(q);
		
	}
}

