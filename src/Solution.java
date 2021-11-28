public class Solution {
    public static void BubbleSort(int[] arr) {
        int last = arr.length - 1;

        while(last > 0) {
            int barrier = 0;
            for (int i = 0; i < last; i++) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    barrier = i;
                }
            }
            last = barrier;
        }
    }
    
    public static void BubbleSortBidirectional(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean swapOnStep = true;

        while(swapOnStep) {
            swapOnStep = false;
            for (int i = left; i < right; i++) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapOnStep = true;
                }
            }
            right--;

            for (int i = right; i >= left; i--) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapOnStep = true;
                }
            }
            left++;
        }
    }

    public static void selectionSort(int[] arr) {
        int right = arr.length - 1;

        for (int i = 0; i <= right; i++) {
            int minIndex = i;
            int maxIndex = right;

            for (int j = i; j <= right; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = 0;

            if(minIndex != right || maxIndex != i) {
                tmp = arr[right];
                arr[right] = arr[maxIndex];
                arr[maxIndex] = tmp;
                
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;

            } else {
                tmp = arr[right];
                arr[right] = arr[i];
                arr[i] = tmp;
            }

            right--;
        }
    }

    public static void SortByInserts(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int first = arr[0];
            arr[0] = value;
            int index = i;
            
            while(arr[index - 1] > value) {
                arr[index] = arr[index - 1];
                index--;
            }
            if(first > value) {
                arr[0] = value;
                arr[index] = first;
            } else {
                arr[0] = first;
                arr[index] = value;
            }
        }
    }
}

// public static void sortLinear(int[] arr, int start, int end) {

//     for(int i = start + 1; i < end; i++) {
//         int value = arr[i];
//         int index = i;
//         while((index > 0) && (arr[index - 1] > value)) {
//             arr[index] = arr[index - 1];
//             index--;
//         }
//         arr[index] = value;
//     }

// }
