package logic;

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

    public static void SortShell(int[] arr) {
        //кол-во проходов (Н. Вирт)
        final int t = (int)(Math.log(arr.length) / Math.log(2)) - 1;

        //шаги (h[t-1] = 1; h[k-1] = 2h[k] + 1)
        int[] steps = new int[t];
        steps[t - 1] = 1;
        for (int i = t - 2; i >= 0; i--) {
            steps[i] = 2*steps[i+1] + 1;
        }

        for(int k = 0; k < steps.length; k++) {
            int i, j;
            int step = steps[k];
            for (i = step; i < arr.length; i++) {
                int value = arr[i];
                for (j = i - step; (j >= 0) && (arr[j] > value); j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = value;
            }
        }
    }

    public static void LinearSort(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] += 1;
        }
        
        int index = 0;
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }
}