package sorting;

public class ThreeNumberSort {
    // Solution 1
    /*
    // O(n) time | O(1) space
  public int[] threeNumberSort(int[] array, int[] order) {
    int[] valueCounts = new int[] {0, 0, 0};

		for(int element: array) {
			int orderIdx = getIndex(order, element);
			valueCounts[orderIdx] +=1;
		}

		for (int i =0; i<order.length; i++) {
			int value = order[i];
			int count = valueCounts[i];
			int numElementsBefore = getSum(valueCounts, i);
			for (int n =0; n<count; n++) {
				int currentIdx = numElementsBefore + n;
				array[currentIdx] = value;
			}
		}
    return array;
  }

	public int getSum(int[] array, int end) {
		int sum = 0;
		for (int i=0; i<end; i++) sum+= array[i];
		return sum;
	}

	public int getIndex(int[] array, int element) {
		for (int i=0; i<array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}
     */

    // solution 2
    /*
    // O(n) time | O(1) space
  public int[] threeNumberSort(int[] array, int[] order) {
    int firstValue = order[0];
		int thirdValue = order[2];

		int firstIdx = 0;
		for (int idx = 0; idx < array.length; idx++) {
			if (array[idx] == firstValue) {
				swap(firstIdx, idx, array);
				firstIdx += 1;
			}
		}

		int thirdIdx = array.length - 1;
		for (int idx = array.length - 1; idx >= 0; idx--) {
			if (array[idx] == thirdValue) {
				swap(thirdIdx, idx, array);
				thirdIdx -= 1;
			}
		}

    return array;
  }

	public void swap(int i, int j, int[] array) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
     */

    // solution 3
    // O(n) time | o(1) space
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstValue = order[0];
        int secondValue = order[1];

        // keep track of the indices where the value are sorted
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        while (secondIdx <= thirdIdx) {
            int value = array[secondIdx];
            if (value == firstValue) {
                swap(firstIdx, secondIdx, array);
                firstIdx += 1;
                secondIdx += 1;
            } else if ( value == secondValue) {
                secondIdx += 1;
            } else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx -=1;
            }
        }
        return array;
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
