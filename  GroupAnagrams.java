import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Check if the input is null or empty
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // A map to store sorted strings as keys and their anagrams as values
        Map<String, List<String>> anagramMap = new HashMap<>();

        // Iterate through the input array
        for (String str : strs) {
            // Convert the string to a character array, sort it, and convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add the original string to the map under the key of its sorted version
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }

        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        // Test case
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Get the grouped anagrams
        List<List<String>> result = groupAnagrams(strs);

        // Print the result
        System.out.println("Grouped Anagrams: " + result);
    }
}
