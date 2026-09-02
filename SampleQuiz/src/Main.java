import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 100;
        nums[1] = 1;
        nums[2] = 50;
        nums[3] = 45;
        nums[4] = -48;

        int searchNum = 50;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == searchNum) {
                index = i;
                break;
            }
        }
    }
}
