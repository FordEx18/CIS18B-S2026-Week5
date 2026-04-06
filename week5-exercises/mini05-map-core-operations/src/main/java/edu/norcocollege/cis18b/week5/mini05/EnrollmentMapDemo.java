package edu.norcocollege.cis18b.week5.mini05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> enrollment = new HashMap<>();

        enrollment.put("SEC-101", 30);
        enrollment.put("SEC-102", 28);
        enrollment.put("SEC-099", 12);

        // Core map lifecycle operations.
        enrollment.put("SEC-101", 32);
        enrollment.remove("SEC-099");

        // Lambda-based updates.
        enrollment.merge("SEC-101", 1, Integer::sum);
        enrollment.compute("SEC-102", (key, value) -> value == null ? 1 : value + 2);
        enrollment.replace("SEC-102", enrollment.get("SEC-102"), 28);

        enrollment.forEach((section, count) -> System.out.println(section + " -> " + count));
        System.out.println("Removed SEC-099");
        System.out.println("Updated with merge/compute operations.");

        Map<String, Integer> defaults = Map.of("retryLimit", 3, "waitlistCap", 10);
        System.out.println("Defaults: " + defaults);

        Map<String, List<String>> departments = new HashMap<>();
        departments.computeIfAbsent("CIS", key -> new java.util.ArrayList<>()).add("SEC-101");
        departments.computeIfAbsent("CIS", key -> new java.util.ArrayList<>()).add("SEC-102");
        System.out.println("Grouped sections: " + departments);

        //Demonstration of Single element array as a mutable key example.
        Map<int[], String> map = new HashMap<>();
        int[] key1 = {1};
        map.put(key1, "Original Value");
        System.out.println("Before mutation: " + map.get(key1)); // Should print "Original Value"
        key1[0] = 2; // Mutating the key
        System.out.println("After mutation: " + map.get(key1)); // May print null
        System.out.println("Map contents: " + map.keySet().stream()
            .map(k -> java.util.Arrays.toString(k))
            .toList());
        //Explanation
        System.out.println("Mutable key hazard: changing a key after insertion can lead to many issues with retrieval and integrity of the map.");
    }
}