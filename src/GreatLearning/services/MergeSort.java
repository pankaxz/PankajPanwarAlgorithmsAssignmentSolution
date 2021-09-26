package GreatLearning.services;

public class MergeSort {
    /**
     * Merge Sort implementation
     * @param array : Array of Share price values added by the user.
     * @param left : Left Most Array element.
     * @param right : Right Most Array element.
     * @param ascending : Boolean for sorting order.
     */
    public void Sort(double [] array, int left, int right, boolean ascending){
        if(left < right){
            int mid = (left + right) / 2;
            Sort(array, left, mid, ascending);
            Sort(array, mid + 1, right, ascending);
            Merge(array, left, mid, right, ascending);
        }
    }

    private void Merge(double [] array, int left, int mid , int right, boolean ascending){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double [] leftArray = new double [n1];
        double [] rightArray = new double [n2];

        for(int i = 0; i < n1; i++)
            leftArray[i] = (int) array[left + i];

        for(int i = 0; i < n2; i++)
            rightArray[i] = (int) array[mid + 1 + i];

        int i = 0, j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(ascending) {
                if (leftArray[i] < rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }
            else {
                if (leftArray[i] >= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }
        }

        while(i < n1){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
