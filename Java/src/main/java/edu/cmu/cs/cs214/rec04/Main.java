package edu.cmu.cs.cs214.rec04;

public class Main {

    public static void main(String[] args) {


        IntegerList list1 = new InheritanceSortedIntList();
        IntegerList list2 = new InheritanceSortedIntList();

        // Add elements to the first list
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        // Print list1
        System.out.print("List 1: ");
        printList(list1);
        System.out.println("Total Added: " + ((InheritanceSortedIntList) list1).getTotalAdded());

        // Add elements to the second list
        list2.add(3);
        list2.add(0);

        // Merge list1 into list2
        list2.addAll(list1);

        // Print list2
        System.out.print("List 2: ");
        printList(list2);
        System.out.println("Total Added: " + ((InheritanceSortedIntList) list2).getTotalAdded());
    }

    private static void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
