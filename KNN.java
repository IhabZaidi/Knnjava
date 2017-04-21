///////////////////////////////////
// KNN Algorithme with JAVA      //
// Developped by Ihab Zaidi      //
// Thanks To Noureddin Sadawi    //
///////////////////////////////////
import java.util.*;

class KNN
{
	// our Data Base
	static double[][] instances = {
			{6.300000,2.500000,5.000000,1.900000,3.000000},
			{6.900000,3.200000,5.700000,2.300000,3.000000},
			{5.100000,3.800000,1.900000,0.400000,1.000000},
			{6.600000,2.900000,4.600000,1.300000,2.000000},
			{5.700000,4.400000,1.500000,0.400000,1.000000},
			{4.600000,3.400000,1.400000,0.300000,1.000000},
			{4.300000,3.000000,1.100000,0.100000,1.000000},
			{6.900000,3.100000,5.100000,2.300000,3.000000},
			{5.100000,3.700000,1.500000,0.400000,1.000000},
			{6.100000,2.800000,4.700000,1.200000,2.000000},
			{5.800000,2.700000,5.100000,1.900000,3.000000},
			{4.600000,3.100000,1.500000,0.200000,1.000000},
			{6.200000,3.400000,5.400000,2.300000,3.000000},
			{6.700000,3.300000,5.700000,2.100000,3.000000},
			{4.900000,3.000000,1.400000,0.200000,1.000000},
			{7.100000,3.000000,5.900000,2.100000,3.000000},
			{5.000000,3.500000,1.600000,0.600000,1.000000},
			{6.700000,3.100000,5.600000,2.400000,3.000000},
			{4.900000,3.600000,1.400000,0.100000,1.000000},
			{5.900000,3.000000,5.100000,1.800000,3.000000},
			{5.800000,2.600000,4.000000,1.200000,2.000000},
			{6.800000,3.200000,5.900000,2.300000,3.000000},
			{5.400000,3.900000,1.300000,0.400000,1.000000},
			{5.700000,3.000000,4.200000,1.200000,2.000000},
			{6.100000,2.800000,4.000000,1.300000,2.000000},
			{6.100000,3.000000,4.900000,1.800000,3.000000},
			{6.700000,3.100000,4.700000,1.500000,2.000000},
			{5.200000,4.100000,1.500000,0.100000,1.000000},
			{6.500000,3.000000,5.800000,2.200000,3.000000},
			{4.900000,2.500000,4.500000,1.700000,3.000000},
			{5.700000,2.800000,4.100000,1.300000,2.000000},
			{4.800000,3.400000,1.900000,0.200000,1.000000},
			{5.000000,3.300000,1.400000,0.200000,1.000000},
			{5.100000,3.800000,1.600000,0.200000,1.000000},
			{6.700000,3.000000,5.200000,2.300000,3.000000},
			{5.800000,4.000000,1.200000,0.200000,1.000000},
			{5.500000,3.500000,1.300000,0.200000,1.000000},
			{6.700000,3.300000,5.700000,2.500000,3.000000},
			{6.200000,2.800000,4.800000,1.800000,3.000000},
			{6.400000,3.200000,5.300000,2.300000,3.000000},
			{5.000000,3.400000,1.500000,0.200000,1.000000},
			{6.400000,2.800000,5.600000,2.100000,3.000000},
			{5.100000,3.500000,1.400000,0.200000,1.000000},
			{5.100000,3.400000,1.500000,0.200000,1.000000},
			{6.000000,2.200000,4.000000,1.000000,2.000000},
			{5.600000,3.000000,4.500000,1.500000,2.000000},
			{7.200000,3.000000,5.800000,1.600000,3.000000},
			{5.400000,3.000000,4.500000,1.500000,2.000000},
			{7.200000,3.600000,6.100000,2.500000,3.000000},
			{6.400000,2.800000,5.600000,2.200000,3.000000},
			{6.300000,2.800000,5.100000,1.500000,3.000000},
			{5.400000,3.900000,1.700000,0.400000,1.000000},
			{6.000000,3.000000,4.800000,1.800000,3.000000},
			{6.400000,2.900000,4.300000,1.300000,2.000000},
			{6.300000,2.900000,5.600000,1.800000,3.000000},
			{5.500000,2.400000,3.800000,1.100000,2.000000},
			{4.700000,3.200000,1.600000,0.200000,1.000000},
			{6.300000,2.700000,4.900000,1.800000,3.000000},
			{7.700000,2.800000,6.700000,2.000000,3.000000},
			{5.200000,2.700000,3.900000,1.400000,2.000000},
			{5.600000,2.700000,4.200000,1.300000,2.000000},
			{6.000000,3.400000,4.500000,1.600000,2.000000},
			{6.500000,3.000000,5.500000,1.800000,3.000000},
			{4.800000,3.100000,1.600000,0.200000,1.000000},
			{4.400000,3.000000,1.300000,0.200000,1.000000},
			{6.000000,2.900000,4.500000,1.500000,2.000000},
			{6.500000,3.200000,5.100000,2.000000,3.000000},
			{4.900000,3.100000,1.500000,0.200000,1.000000},
			{6.100000,2.600000,5.600000,1.400000,3.000000},
			{5.900000,3.000000,4.200000,1.500000,2.000000},
			{6.500000,3.000000,5.200000,2.000000,3.000000},
			{5.000000,3.000000,1.600000,0.200000,1.000000},
			{5.400000,3.700000,1.500000,0.200000,1.000000},
			{7.400000,2.800000,6.100000,1.900000,3.000000},
			{5.700000,2.800000,4.500000,1.300000,2.000000},
	};
	private static String findMajorityClass(String[] array)
	{
		//add the String array to a HashSet to get unique String values
		Set<String> h = new HashSet<String>(Arrays.asList(array));
		//convert the HashSet back to array
		String[] uniqueValues = h.toArray(new String[0]);
		//counts for unique strings
		int[] counts = new int[uniqueValues.length];
		// loop thru unique strings and count how many times they appear in origianl array   
		for (int i = 0; i < uniqueValues.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[j].equals(uniqueValues[i])){
					counts[i]++;
				}
			}        
		}

		for (int i = 0; i < uniqueValues.length; i++)
			System.out.println(uniqueValues[i]);
		for (int i = 0; i < counts.length; i++)
			System.out.println(counts[i]);


		int max = counts[0];
		for (int counter = 1; counter < counts.length; counter++) {
			if (counts[counter] > max) {
				max = counts[counter];
			}
		}
		System.out.println("max # of occurences: "+max);
		int freq = 0;
		for (int counter = 0; counter < counts.length; counter++) {
			if (counts[counter] == max) {
				freq++;
			}
		}
		int index = -1;
		if(freq==1){
			for (int counter = 0; counter < counts.length; counter++) {
				if (counts[counter] == max) {
					index = counter;
					break;
				}
			}
			//System.out.println("one majority class, index is: "+index);
			return uniqueValues[index];
		} else{//we have multiple modes
			int[] ix = new int[freq];//array of indices of modes
			System.out.println("multiple majority classes: "+freq+" classes");
			int ixi = 0;
			for (int counter = 0; counter < counts.length; counter++) {
				if (counts[counter] == max) {
					ix[ixi] = counter;//save index of each max count value
					ixi++; // increase index of ix array
				}
			}

			for (int counter = 0; counter < ix.length; counter++)         
				System.out.println("class index: "+ix[counter]);       

			//now choose one at random
			Random generator = new Random();        
			//get random number 0 <= rIndex < size of ix
			int rIndex = generator.nextInt(ix.length);
			System.out.println("random index: "+rIndex);
			int nIndex = ix[rIndex];
			//return unique value at that index 
			return uniqueValues[nIndex];
		}

	}


	
	private static double meanOfArray(double[] m) {
		double sum = 0.0;
		for (int j = 0; j < m.length; j++){
			sum += m[j];
		}
		return sum/m.length;
	}



	public static void main(String args[]){ 
		System.out.println("Insert Your Data : "); 
		System.out.println("\n");
		Scanner scan = new Scanner(System.in);
		double insertedInt = scan.nextDouble();
		double insertedInt2 = scan.nextDouble();
		double insertedInt3 = scan.nextDouble();
		double insertedInt4 = scan.nextDouble();
		double insertedInt5 = scan.nextDouble();
		double[] query = {insertedInt, insertedInt2, insertedInt3, insertedInt4, insertedInt5};

		int k = 9;// K : Welaya List Counts  
		List<City> cityList = new ArrayList<City>();
		List<Result> resultList = new ArrayList<Result>();   
		cityList.add(new City(instances[0],"IRIS0"));
		cityList.add(new City(instances[1],"IRIS1"));
		cityList.add(new City(instances[2],"IRIS2"));
		cityList.add(new City(instances[3],"IRIS3"));
		cityList.add(new City(instances[4],"IRIS4"));
		cityList.add(new City(instances[5],"IRIS5"));
		cityList.add(new City(instances[6],"IRIS6"));
		cityList.add(new City(instances[7],"IRIS7"));
		cityList.add(new City(instances[8],"IRIS8"));
		cityList.add(new City(instances[9],"IRIS9"));
		cityList.add(new City(instances[10],"IRIS10"));
		cityList.add(new City(instances[11],"IRIS11"));
		cityList.add(new City(instances[12],"IRIS12"));
		cityList.add(new City(instances[13],"IRIS13"));
		cityList.add(new City(instances[14],"IRIS14"));
		cityList.add(new City(instances[15],"IRIS15"));
		cityList.add(new City(instances[16],"IRIS16"));
		cityList.add(new City(instances[17],"IRIS17"));
		cityList.add(new City(instances[18],"IRIS18"));
		cityList.add(new City(instances[19],"IRIS19"));
		cityList.add(new City(instances[20],"IRIS20"));
		cityList.add(new City(instances[21],"IRIS21"));
		cityList.add(new City(instances[22],"IRIS22"));
		cityList.add(new City(instances[23],"IRIS23"));
		cityList.add(new City(instances[24],"IRIS24"));
		cityList.add(new City(instances[25],"IRIS25"));
		cityList.add(new City(instances[26],"IRIS26"));
		cityList.add(new City(instances[27],"IRIS27"));
		cityList.add(new City(instances[28],"IRIS28"));
		cityList.add(new City(instances[29],"IRIS29"));
		cityList.add(new City(instances[30],"IRIS30"));
		cityList.add(new City(instances[31],"IRIS31"));
		cityList.add(new City(instances[32],"IRIS32"));
		cityList.add(new City(instances[33],"IRIS33"));
		cityList.add(new City(instances[34],"IRIS34"));
		cityList.add(new City(instances[35],"IRIS35"));
		cityList.add(new City(instances[36],"IRIS36"));
		cityList.add(new City(instances[37],"IRIS37"));
		cityList.add(new City(instances[38],"IRIS38"));
		cityList.add(new City(instances[39],"IRIS39"));
		cityList.add(new City(instances[40],"IRIS40"));
		cityList.add(new City(instances[41],"IRIS41"));
		cityList.add(new City(instances[42],"IRIS42"));
		cityList.add(new City(instances[43],"IRIS43"));
		cityList.add(new City(instances[44],"IRIS44"));
		cityList.add(new City(instances[45],"IRIS45"));
		cityList.add(new City(instances[46],"IRIS46"));
		cityList.add(new City(instances[47],"IRIS47"));
		cityList.add(new City(instances[48],"IRIS48"));
		cityList.add(new City(instances[49],"IRIS49"));
		cityList.add(new City(instances[50],"IRIS50"));
		cityList.add(new City(instances[51],"IRIS51"));
		cityList.add(new City(instances[52],"IRIS52"));
		cityList.add(new City(instances[53],"IRIS53"));
		cityList.add(new City(instances[54],"IRIS54"));
		cityList.add(new City(instances[55],"IRIS55"));
		cityList.add(new City(instances[56],"IRIS56"));
		cityList.add(new City(instances[57],"IRIS57"));
		cityList.add(new City(instances[58],"IRIS58"));
		cityList.add(new City(instances[59],"IRIS59"));
		cityList.add(new City(instances[60],"IRIS60"));
		cityList.add(new City(instances[61],"IRIS61"));
		cityList.add(new City(instances[62],"IRIS62"));
		cityList.add(new City(instances[63],"IRIS63"));
		cityList.add(new City(instances[64],"IRIS64"));
		cityList.add(new City(instances[65],"IRIS65"));
		cityList.add(new City(instances[66],"IRIS66"));
		cityList.add(new City(instances[67],"IRIS67"));
		cityList.add(new City(instances[68],"IRIS68"));
		cityList.add(new City(instances[69],"IRIS69"));
		cityList.add(new City(instances[70],"IRIS70"));
		cityList.add(new City(instances[71],"IRIS71"));
		cityList.add(new City(instances[72],"IRIS72"));
		cityList.add(new City(instances[73],"IRIS73"));
		cityList.add(new City(instances[74],"IRIS74"));
		cityList.add(new City(instances[75],"IRIS75"));
		cityList.add(new City(instances[76],"IRIS76"));
		//data about user city
		//double[] query = {1.65,1.78,1.21,1.29,1.58};
		//find distances
		for(City city : cityList){
			double dist = 0.0;  
			for(int j = 0; j < city.cityAttributes.length; j++){    	     
				dist += Math.pow(city.cityAttributes[j] - query[j], 2) ;
				//System.out.print(city.cityAttributes[j]+" ");    	     
			}
			double distance = Math.sqrt( dist );
			resultList.add(new Result(distance,city.cityName));
			//System.out.println(distance);
		} 

		//System.out.println(resultList);
		Collections.sort(resultList, new DistanceComparator());
		String[] ss = new String[k];
		for(int x = 0; x < k; x++){
			System.out.println(resultList.get(x).cityName+ " .... " + resultList.get(x).distance);
			//get classes of k nearest instances (city names) from the list into an array
			ss[x] = resultList.get(x).cityName;
		}
		String majClass = findMajorityClass(ss);
		System.out.println("The Nearest IRIS Class is : "+majClass);                
	}//end main  

	//simple class to model instances (features + class)
	static class City {	
		double[] cityAttributes;
		String cityName;
		public City(double[] cityAttributes, String cityName){
			this.cityName = cityName;
			this.cityAttributes = cityAttributes;	    	    
		}
	}
	//simple class to model results (distance + class)
	static class Result {	
		double distance;
		String cityName;
		public Result(double distance, String cityName){
			this.cityName = cityName;
			this.distance = distance;	    	    
		}
	}
	//simple comparator class used to compare results via distances
	static class DistanceComparator implements Comparator<Result> {
		@Override
		public int compare(Result a, Result b) {
			return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
		}
	}

}
