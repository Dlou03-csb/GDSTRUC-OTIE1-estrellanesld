public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10];
        nums[0] = 25;
        nums[1] = -3;
        nums[2] = 5;
        nums[3] = 10;
        nums[4] = 38;
        nums[5] = 62;
        nums[6] = 20;
        nums[7] = -8;
        nums[8] = 173;
        nums[9] = 65;

        int[] nums2 = new int[10];
        nums2[0] = 25;
        nums2[1] = -3;
        nums2[2] = 5;
        nums2[3] = 10;
        nums2[4] = 38;
        nums2[5] = 62;
        nums2[6] = 20;
        nums2[7] = -8;
        nums2[8] = 173;
        nums2[9] = 65;

        System.out.println("Before sorting...");
        printArray(nums);

        System.out.println("\nBubble Sort Testing...");
        bubbleSort(nums);
        printArray(nums);

        System.out.println("\n\nBefore sorting...");
        printArray(nums2);

        System.out.println("\nSelection Sort Testing...");
        selectionSort(nums2);
        printArray(nums2);

    }

    private static void bubbleSort(int[] nums) {
        // let n = number of elements in nums array
        // outer for loop -> n - 1 iterations
        // inner for loop -> n - 1 iterations (1st pass)
        // inner for loop -> (n - 1) + (n - 2) + (n - 3) .. 1 -> (n * (n - 1)) / 2 -> (n^2 - n) / 2
        // time complexity -> O(n^2)
        for (int lastUnsortedIndex = nums.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] nums) {
        // let n = number of elements in nums array
        // outer for loop -> n - 1 iterations
        // inner for loop -> n - 1
        // inner for loop -> (n - 1) + (n - 2) + (n - 3) .. 1 -> (n * (n - 1)) / 2 -> (n^2 - n) / 2
        // time complexity -> O(n^2)
        for (int lastUnsortedIndex = nums.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int smallest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (nums[i] < nums[smallest]) {
                    smallest = i;
                }
            }

            if (smallest != lastUnsortedIndex) {
                int temp = nums[smallest];
                nums[smallest] = nums[lastUnsortedIndex];
                nums[lastUnsortedIndex] = temp;
            }
        }
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
