/*
 * Question was Alice,Bob,John & Sarah were out on camping 
 *  & they were doing budget spending. 
 *  Question 1 a.Alice did spend 400 on everyone. 
 *           1 b. Sarah did spend 200 on Bob & John.
 *        Display balance for all after 1 & 2 transactions.    
 *   Question 2.Calculate total number of transactions required to 
 *              equate their balance(Something similar, as time-limit got exceeded.)
 *              
 *  But in below function i am trying to address Q1.
 */
public class CampingProblem {

	public static void main(String[] args) {
		Map<String, Long> m=new HashMap<String, Long>();
		m.put("Alice", 0L);
		m.put("Bob", 0L);
		m.put("John", 0L);
		m.put("Sarah", 0L);
		System.out.println(m);
		Map<String, Long> m2=getBal(m, 400, m.keySet(), "Alice");	
		System.out.println(m2);
		Set<String> s=new HashSet<String>();
		s.add("Bob");
		s.add("John");
		System.out.println(getBal(m2, 200,s,"Sarah"));
	}	
	public static Map<String, Long> getBal(Map<String, Long> m,long spendBal,Set<String> l,String n1){		
		Map<String, Long> m1=new HashMap<String, Long>();
		m1.putAll(m);
		Map<String, Long> m2=null;
		if(!m1.keySet().retainAll(l)) {
			long a=m1.get(n1)-spendBal;
			m1.put(n1, a);		
			m2=m1.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e->e.getValue()+spendBal/l.size()));
			return m2;
		}
		else {
			long b=m.get(n1)-spendBal;
			m.put(n1, b);
			m2=m.entrySet().stream().filter(x->l.contains(x.getKey())).collect(Collectors.toMap(Map.Entry::getKey,e->e.getValue()+spendBal/l.size()));
			m.putAll(m2);
			return m;
		}
	}
}
