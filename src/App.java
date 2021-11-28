public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{29,68,52,12,66,89,57,20,97,21};
        Solution.SortByInserts(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for(int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
