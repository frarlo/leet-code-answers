import java.util.*;

public class Main {

    /* Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.

    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.

    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.

    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists
    when this method is called). Each element must have the same probability of being returned.

    You must implement the functions of the class such that each function works in average O(1) time complexity.

    Example 1:

        Input

        ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
        [[], [1], [2], [2], [], [1], [2], []]

        Output

        [null, true, false, true, 2, true, false, 2]

    Explanation

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

     */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 380 - Insert Delete Get Random in O(1) *** \n");


        RandomizedSet randomSet = new RandomizedSet();

        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());

    }

    static class RandomizedSet {

        // Declaration of our variables (using a HashMap to remove and insert values from the list):
        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        // Initialization of our data structure:
        public RandomizedSet() {

            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();

        }

        // Method to insert a value to the set if it is not already there:
        public boolean insert(int val) {
            // Checking if the value is already there:
            if (map.containsKey(val)) {
                return false;
            }
            // Declaring the position of the new value (it will be all the length of our current list):
            int position = list.size();

            // Adding the actual value to our list and the value and its position to our map:
            list.add(val);
            map.put(val, position);
            return true;
        }

        // Method to delete a value of the set if it exists:
        public boolean remove(int val) {
            // Checking if the value does not exist:
            if (!map.containsKey(val)) {
                return false;
            }

            // Declaring the position of the value we want to remove in our map:
            int position = map.get(val);
            // Declaring the last value of our list:
            int lastValue = list.getLast();

            // Swapping the position of the value and removing it:
            list.set(position, lastValue);
            list.removeLast();

            // Updating the map (value to last and removing it):
            map.put(lastValue, position);
            map.remove(val);

            return true;

        }

        // Method to get a random element from our list:
        public int getRandom() {
            int randomIndex = random.nextInt(list.size());
            return list.get(randomIndex);
        }

    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */

}