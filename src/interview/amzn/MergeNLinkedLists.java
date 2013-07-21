package interview.amzn;

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
import java.util.*;


public class MergeNLinkedLists {

    public LinkedList[] divideIntoTwo(LinkedList[] list) 
    {
        LinkedList[] linkedListA = new LinkedList[list.length/2];
        LinkedList[] linkedListB = new LinkedList[list.length - linkedListA.length];
        System.arraycopy(list, 0, linkedListA, 0, linkedListA.length);
        System.arraycopy(list, linkedListA.length, linkedListB, 0, linkedListB.length);
        return new LinkedList[][]{ linkedListA, linkedListB};
    }
    
    public LinkedList mergeLists(LinkedList[] list)
    {
        if (list.length == 1) {
            return list[0];
        } else if (list.length == 2) {
            return mergedLinkedList = mergeLinkedList(list[0], list[1]);
        } else {
            LinkedList[] biggerLinkedList = divideIntoTwo(list);
            return mergeLinkedList(mergeLists[biggerLinkedList[0], biggerLinkedList[1]));
        }
    }
    
    public LinkedList mergeLinkedList(LinkedList linkedListA, LinkedList linkedListB) 
    {
        LinkedList resultLinkedList = new LinkedList();
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
    }
}
 */
