import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class TestClass {
    public static void main(String[] args) {

        //Array list
        /*
        (1) The size of the arrays is fixed:
        (2) Inserting a new element in an array of elements is expensive because room has to be created for the new elements and to create room existing elements have to be shifted.
         */

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<Integer> method = (n) -> {System.out.println(n);};
        numbers.forEach(method);

        /*Linked List
            1) Dynamic size
            2) Ease of insertion/deletion

            1) Random access is not allowed. We have to access elements sequentially starting from the first node
            2) Extra memory space for a pointer is required with each element of the list
            3) Arrays have better cache locality that can make a pretty big difference in performance.
            4) It takes a lot of time in traversing and changing the pointers.
            5)  It will be confusing when we work with pointers.
        */
        System.out.println("Linked LIst presentation");
        LinkedList<String> linkedL = new LinkedList<String>();
        linkedL.add("34");
        linkedL.add("BB");
        linkedL.add("SS");
        linkedL.add("RE");
        System.out.println("Element" + linkedL.element());
        Consumer<String> printL = (n) -> {System.out.println(n);};
        linkedL.forEach(printL);
        System.out.println("Removed value for " + linkedL.removeFirst());
        System.out.println("First value is: "+linkedL.peekFirst());
        System.out.println("Removed ElementLast: " + linkedL.removeLast());
        Consumer<String> printL2 = (n) -> {System.out.println(n);};
        linkedL.forEach(printL2);

        System.out.println("HashSet List");
        //Creating HashSet and adding elements
        HashSet<String> set=new HashSet();
        set.add("a");
        set.add("e");
        set.add("c");
        set.add("d");
        set.add("b");

        Iterator<String> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        System.out.println(set);


        System.out.println("HashMap: ");
        HashMap<String, Integer> map = new HashMap<>();

        // Add elements using put method
        map.put(null, 10);
        map.put(null, null);
        map.put("vaibhav", null);

        // Iterate the map using
        // for-each loop
        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());

        //declare and initialize ConcurrentHashMap
        Map<String,String> cCMap = new ConcurrentHashMap<String,String>();
        cCMap.put("1", "10");
        cCMap.put("2", "10");
        cCMap.put("3", "10");
        cCMap.put("4", "10");
        cCMap.put("5", "10");
        cCMap.put("6", "10");
        //print the initial ConcurrentHashMap
        System.out.println("Initial ConcurrentHashMap: "+cCMap);
        //define the iterator over the keys of ConcurrentHashMap
        Iterator<String> it = cCMap.keySet().iterator();
        //change one of the keys using iterator
        while(it.hasNext()){
            String key = it.next();
            if(key.equals("3")) cCMap.put(key+"c_map", "c_map");
        }
        //print the changed ConcurrentHashMap
        System.out.println("\nConcurrentHashMap after iterator: "+cCMap);
    }
}
