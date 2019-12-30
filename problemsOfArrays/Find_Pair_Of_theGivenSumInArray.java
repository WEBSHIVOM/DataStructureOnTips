package problemsOfArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Find_Pair_Of_theGivenSumInArray {

	//naive approach
	BiFunction<int[], Integer, String> naiveTechnique = (e1, e2) -> {
		for (int i = 0; i < e1.length; i++) {
			for (int j = i + 1; j < e1.length; j++) {
				if (e1[i] + e1[j] == e2) {
					return "Pair found at index" + i + " & " + j;
				}
			}
		}
		return "No Pair found ";

	};
	//use sorting and reduce complexity to O(nlogn)
	BiFunction<int[], Integer, Optional<String>> secondApproachViaSorting = (e1, e2) -> {
		Optional<String> res=Optional.empty();
		Arrays.sort(e1);
		int low=0;
		int high=e1.length-1;
		if(e1[low]+e1[high]==e2) {
			res= Optional.of("Pair found at index" + low + " & " + high);
			return res;
		}
		
		if ((e1[low] + e1[high]) < e2)
			low++;
		else
			high--;
		return res = Optional.of("Pair found at index" + low + " & " + high);
	};
	//you can use hashing also 
	BiFunction<int[], Integer, Optional<String>> thirdApproachViaHashing = (e1, e2) -> {
		Optional<String> res=Optional.empty();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<e1.length;i++) {
		if(map.containsKey(e2-e1[i])) {
			res=Optional.of("Pair found at index" + map.get(e2-e1[i]) + " & " + i);
		}
		map.put(e1[i], i);
		}
		return res;
	};
}
