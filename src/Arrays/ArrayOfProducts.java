package Arrays;

public class ArrayOfProducts {
    // O(n) time | O(n) space
    // where n is the length of the input array
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] products = new int[array.length];

        int leftRunningProduct = 1;
        for (int count = 0; count < array.length; count++) {
            products[count] = leftRunningProduct;
            leftRunningProduct *= array[count];
        }

        int rightRunningProduct = 1;
        for (int count = array.length -1; count >= 0; count--) {
            products[count] *=rightRunningProduct;
            rightRunningProduct *= array[count];
        }

        return products;
    }
}
