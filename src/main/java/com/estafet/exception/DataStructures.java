package com.estafet.exception;

import java.util.*;



public class DataStructures {

    public static void main(String[] args) {


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.set(0,2);
        numbers.get(0);
        numbers.remove(0);


        LinkedList<String> linkedL = new LinkedList<String>();
        linkedL.add("BB");
        linkedL.add("BBz");
        linkedL.remove(1);


        HashSet<String> set = new HashSet();
        set.add("a");
        set.add("e");
        set.add("c");

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(4234);
        treeSet.remove(4234);


        HashMap<String, Integer> map = new HashMap<>();
        map.put(null, 10);
        map.put("str1", null);
        map.put("str3", null);

        TreeMap<Integer,String > mapTree = new TreeMap<>();

    }
}
