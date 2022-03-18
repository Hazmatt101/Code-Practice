package com.main.recursion;

//It's important that the input list is sorted!
//Problems that involve searching sorted lists are candidates for this!
public class BinarySearchRecursive {
    //assume that the list is sorted.
    public static void main(String[] args) {
        BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();

        int[] sortedInputArr = {-1, 2, 3, 3, 5, 7, 8, 9};
        int searchElement = 7;
        int position = binarySearchRecursive.binarySearchGetPositionOfSearchedElement(sortedInputArr, searchElement, 0, sortedInputArr.length - 1);
        if (position > -1) {
            System.out.println("Found element '" + searchElement + "' at position: " + position);
        } else {
            System.out.println("Element '" + searchElement + "' does not exist in input array.");
        }
    }

    private int binarySearchGetPositionOfSearchedElement(int[] sortedInputArr, int searchElement, int left, int right) {
        if (sortedInputArr.length == 0) {
            System.out.println("sortedInputArr is empty");
            return -1;
        }

        if (sortedInputArr.length == 1) {
            return sortedInputArr[0];
        }

        //base case; means that searchElement doesn't exist in sortedInputArr
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (sortedInputArr[middle] == searchElement) {
            return middle;
        }

        if (searchElement > sortedInputArr[middle]) {
            //discard left subarray
            return binarySearchGetPositionOfSearchedElement(sortedInputArr, searchElement, middle + 1, right);
        } else {
            //discard right subarray
            return binarySearchGetPositionOfSearchedElement(sortedInputArr, searchElement, left, middle - 1);
        }
    }
}
