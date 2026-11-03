public class Main
{
    public static void main(String[] args)
    {

        int[] group = {10, 24, 35, 47, 59, 67, 78, 81, 99};
        int targetNum = 67;

        int index = binarySearch.search(group, targetNum);

        if (index != -1)
        {
            System.out.println(targetNum + " is at index " + index + ".");
        }
        else
        {
            System.out.println(targetNum + " is not in the array.");
        }

    }
}
