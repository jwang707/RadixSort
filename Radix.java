import java.util.*;
import java.lang.*;

public class Radix{
  public static int nth(int n, int col){
    int answer = (int)(n/(Math.pow(10, col)));
    return Math.abs(answer % 10);
  }

  public static int length(int n){
    if (n == 0){
      return 1;
    }
    else{
      return (int)Math.floor(Math.log10(Math.abs(n)))+1;
    }
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
        original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int largestPlace = 1;
    largestPlace = Math.max(largestPlace, length(data.get(0)));

    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }

    for (int i = 0; i < largestPlace; i++){
      while (data.size() > 0){
        buckets[nth(data.get(0), i)].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList negative = new SortableLinkedList();
    SortableLinkedList negativeRev = new SortableLinkedList();
    SortableLinkedList positive = new SortableLinkedList();

    for (int i = 0; i < data.size(); i++){
      while (data.size() > 0){
        if (data.get(0) > 0){
          positive.add(data.remove(0));
        }
        else{
          negative.add(data.remove(0));
        }
      }
    }

    radixSortSimple(positive);
    radixSortSimple(negative);

    for(int i = negative.size()-1; i >= 0; i--){
      negativeRev.add(negative.remove(0));
    }

    negativeRev.extend(positive);
    data.extend(negativeRev);
  }

}
