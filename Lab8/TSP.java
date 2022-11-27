package Lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TSP 
{
    private final Map<String, Map<String, Integer>> distances;
    public TSP(Map<String, Map<String, Integer>> distances) 
    {
        this.distances = distances;
    }
 
    public static <T> void swap(T[] arr, int one, int two) 
    {
        T temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    
    private static <T> void allPermutationsHelper(T[] permutation, List<T[]> permutations, int n) 
    {
        if (n <= 0) 
        {
            permutations.add(permutation);
            return;
        }
        
        T[] tempPermutation = Arrays.copyOf(permutation, permutation.length);
        for (int i = 0; i < n; i++) 
        {
            swap(tempPermutation, i, n - 1); 
            allPermutationsHelper(tempPermutation, permutations, n - 1);
            swap(tempPermutation, i, n - 1);
        }
    }
    
    private static <T> List<T[]> permutations(T[] original) 
    {
        List<T[]> permutations = new ArrayList<>();
        allPermutationsHelper(original, permutations, original.length);
     
        return permutations;
    }

	public int pathDistance(String[] path)	{
        String last = path[0];
        int distance = 0;
        for (String next : Arrays.copyOfRange(path, 1, path.length)) 
        {
            distance += distances.get(last).get(next);
            last = next;
        }
        return distance;
    }
 
    public String[] findShortestPath()     {
        String[] cities = distances.keySet().toArray(String[]::new);
        List<String[]> paths = permutations(cities);
        String[] shortestPath = null;
        
        int minDistance = Integer.MAX_VALUE; 
        for (String[] path : paths)  {
            int distance = pathDistance(path);
            distance += distances.get(path[path.length - 1]).get(path[0]);
            
            if (distance < minDistance) {
                minDistance = distance;
                shortestPath = path;
            }
        }
        shortestPath = Arrays.copyOf(shortestPath, shortestPath.length + 1);
        shortestPath[shortestPath.length - 1] = shortestPath[0];
        
        return shortestPath;
    }
 
    public static void main(String[] args) 
    {
        Map<String, Map<String, Integer>> vtDistances = Map.of(
                "Delhi", Map.of(
                        "Kolkota", 1469,
                        "Mumbai", 1436,
                        "Hyderabad", 1255,
                        "Chennai", 2183),
                "Kolkota", Map.of(
                        "Delhi", 1469,
                        "Mumbai", 1972,
                        "Hyderabad", 1530,
                        "Chennai", 153),
                "Mumbai", Map.of(
                        "Delhi", 1436,
                        "Kolkota", 1972,
                        "Hyderabad", 709,
                        "Chennai", 1706),
                "Hyderabad", Map.of(
                        "Delhi", 1255,
                        "Kolkota", 1530,
                        "Mumbai", 709,
                        "Chennai", 625),
                "Chennai", Map.of(
                        "Delhi", 2183,
                        "Kolkota", 1706,
                        "Mumbai", 625,
                        "Hyderabad", 625));
        
        TSP tsp = new TSP(vtDistances);
        String[] shortestPath = tsp.findShortestPath();
        int distance = tsp.pathDistance(shortestPath);
        System.out.println("The shortest path is " + Arrays.toString(shortestPath) + " in " +  distance + " miles.");
    }
}