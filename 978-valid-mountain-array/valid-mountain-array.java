class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;

        int peek = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] || i + 1 == arr.length || arr[0] > arr[1])
                return false;

            if (arr[i] > arr[i + 1]) {
                // found the peek
                peek = i;
                break;
            }
        }
        for (int j = peek; j < arr.length - 1; j++) {
            if (arr[j] == arr[j + 1] || arr[j] < arr[j + 1])
                return false;
        }

        return true;

    }
}