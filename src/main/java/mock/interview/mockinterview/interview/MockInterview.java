package mock.interview.mockinterview.interview;

import java.util.ArrayList;
import java.util.Random;

public class MockInterview {

    public static void main(String[] args) {
        startToEnd(1, 50);
        startToEnd(5, 10);
        ArrayList<Integer> returnedNumbers = startToEnd(6, 12);
        System.out.println(returnedNumbers);
        returnedNumbers = randomNumberList(10, 3);
        System.out.println(returnedNumbers);
        System.out.println(uniqueNumber(returnedNumbers));
    }

    private static ArrayList<Integer> startToEnd(int start, int end) {
        ArrayList<Integer> storedNumbers = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            storedNumbers.add(i);
        }
        return storedNumbers;
    }

    private static ArrayList<Integer> randomNumberList(int size, int duplications) {
        Random rand = new Random();
        int notDuplicatedIndex = rand.nextInt(size) + 1;
        ArrayList<Integer> storedNumbers = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
//            storedNumbers.add(Math.random() * size);
            int randomNumber = rand.nextInt(size) + 1;
            if(i == notDuplicatedIndex) {
                storedNumbers.add(randomNumber);
            } else {
                for(int j = 0; j < duplications; j++){
                    storedNumbers.add(randomNumber);
                }
            }
        }
        return storedNumbers;
    }


    private static int uniqueNumber(ArrayList<Integer> list) {
        int size = list.size();
        for(int i = 0; i < size; i++) {
            if (i != (size - 1) && isDuplicated(list.get(i), list.get(i+1))) {
                i+= amountOfDuplications(list, i);
            } else {
                return list.get(i);
            }
        }
        return 0;
    }

    private static boolean isDuplicated(int prev, int next) {
        return prev == next;
    }

    private static int amountOfDuplications(ArrayList<Integer> list, int startingIndex) {
        int indexChange = 2;
        for(int i = startingIndex; i < list.size(); i++){
            if(isDuplicated(i, i+1)) {
                indexChange++;
            } else {
                return indexChange;
            }
        }
        return indexChange;
    }
}
