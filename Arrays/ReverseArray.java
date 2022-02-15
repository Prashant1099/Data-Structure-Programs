/* Write a function that reverses a array.

You must do this by modifying the input array in-place with O(1) extra memory.
*/

class ReverseArray {
    public int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }
}