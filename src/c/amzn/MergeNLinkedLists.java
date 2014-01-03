package c.amzn;

//merge n linked lists, each linked list is sorted, and length of each linked list is also n.
//get the sorted list in the end.

//Runtime complexity - O(N*N*logN)
//100 Elements space complexity (N*LogN)
/*
  - 50(100)
  - 25(50)
  - 12/13(25 * 2)
  - 6
  - 3 - 2/1
  - 2
  - 1
*/ 
import java.util.LinkedList;


public class MergeNLinkedLists {

    public LinkedList<Integer>[][] divideIntoTwo(LinkedList<Integer>[] list) 
    {
        LinkedList<Integer>[] linkedListA = new LinkedList[list.length/2];
        LinkedList<Integer>[] linkedListB = new LinkedList[list.length - linkedListA.length];
        System.arraycopy(list, 0, linkedListA, 0, linkedListA.length);
        System.arraycopy(list, linkedListA.length, linkedListB, 0, linkedListB.length);
        return new LinkedList[][]{ linkedListA, linkedListB};
    }
    
    public LinkedList<Integer> mergeLists(LinkedList<Integer>[] list)
    {
        if (list.length == 1) {
            return list[0];
        } else if (list.length == 2) {
            return  mergeLinkedList(list[0], list[1]);
        } else {
            LinkedList<Integer>[][] biggerLinkedList = divideIntoTwo(list);
            
            return mergeLinkedList(mergeLists(biggerLinkedList[0]), mergeLists(biggerLinkedList[1]));
        }
    }
    
    public LinkedList<Integer> mergeLinkedList(LinkedList<Integer> linkedListA, LinkedList<Integer> linkedListB) 
    {
        LinkedList<Integer> resultLinkedList = new LinkedList<Integer>();
        while (linkedListA.size() > 0 || linkedListB.size() > 0) {
            if (linkedListA.size() == 0) {
                resultLinkedList.addAll(linkedListB);
                linkedListB.clear();
            } else if (linkedListB.size() == 0) {
                resultLinkedList.addAll(linkedListA);
                linkedListA.clear();
            } else {
                Integer listAValue = (Integer) linkedListA.getFirst();
                Integer listBValue = (Integer) linkedListB.getFirst();
                if (listAValue.intValue() > listBValue.intValue()) {
                    resultLinkedList.add(listAValue);
                    linkedListA.removeFirst();
                } else {
                    resultLinkedList.add(listBValue);
                    linkedListB.removeFirst();
                }
            }
        }
        return resultLinkedList;
    }
}

