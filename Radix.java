import java.util.*;
import java.lang.*;

public class Radix{
  public static int nth(int n, int col){
    int answer = (int)(n/(Math.pow(10, col)));
    return Math.abs(answer % 10);
  }

  public static int length(int n){
    if (n == 0){
      return 0;
    }
    else{
      return (int)Math.floor(Math.log10(Math.abs(n)))+1;
    }
  }

  public static void merge(MyLinkedList original, MyLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      if (buckets[i] != null){
        original.extend(buckets[i]);
      }
    }
  }


  public static void main(String[] args){

  }

}
/*

3
This requires your MyLinkedList file to be present locally, but please do not commit this extra file.
public static void merge(MyLinkedList original,MyLinkedList[]buckets)
Merge all of the linked lists in the bucket array into your original linked list. The original may have elements, and those should be kept.
This is O(buckets.length) which should be 10 when we use this later.
The bucket[0] list will be merged first, then the bucket[1] etc.
Write and thoroughly test these methods!


*/
