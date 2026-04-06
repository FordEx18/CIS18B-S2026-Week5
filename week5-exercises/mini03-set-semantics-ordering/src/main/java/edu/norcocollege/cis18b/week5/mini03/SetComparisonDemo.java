package edu.norcocollege.cis18b.week5.mini03;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetComparisonDemo {

    public static void main(String[] args) {
        List<String> tags = List.of("queue", "stack", "map", "set", "stack", "Queue");

        Set<String> hashSet = new HashSet<>(tags);
        Set<String> linkedHashSet = new LinkedHashSet<>(tags);
        Set<String> treeSet = new TreeSet<>(tags);

        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);

        Set<String> caseInsensitive = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        caseInsensitive.addAll(tags);
        System.out.println("TreeSet (case-insensitive): " + caseInsensitive);

        // Custom comparator: first by length, then alphabetically
        Comparator<String> bylength = Comparator.comparingInt(String::length);
        Comparator<String> alphabetical = String::compareTo;

        Set<String> customOrder = new TreeSet<>(bylength.thenComparing(alphabetical));
        customOrder.addAll(tags);
        System.out.println("TreeSet (custom comparator): " + customOrder);
    }
}