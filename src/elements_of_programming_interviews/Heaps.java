package elements_of_programming_interviews;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Heaps {
    /*
     * Compute the k closest stars
     * Input: ~10^12 star coordinates in a file
     * Output: return the k stars closest to Earth
     * Earth's coordinates are at (0, 0, 0).
     *
     * Questions: duplicate distances? (assume yes, and if can only store one- store any star of the same distance).
     *
     * Solution: Use a max heap to store k stars. Each time find a star at a distance less than the priority, remove
     *  the priority and add the new star, then re-sort. Also need a Star class to store it's coordinates and distance.
     *  Need a
     * Time complexity:
     * Space complexity:
     */
    public Object[] findKClosestStars(List<Star> stars, int k) {
        // Create a max heap with a custom comparator to store the furthest of the k closest stars as the priority.
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, new Comparator<Star>() {
            public int compare(Star a, Star b) {
                if (a.distance < b.distance) {
                    return 1;
                } else if (a.distance > b.distance) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // Add k stars to max heap.
        if (k > stars.size()) {
            k = stars.size();
        }

        int index = 0;

        while (index < k) {
            maxHeap.add(stars.get(index));
            index++;
        }

        // Loop through remaining stars and add a star if its distance from Earth is less than the priority's distance.
        for (int i = index; i < stars.size(); i++) {
            if (stars.get(i).distance >= maxHeap.peek().distance) {
                continue;
            }

            maxHeap.poll();
            maxHeap.add(stars.get(i));
        }

        return maxHeap.toArray();
    }
}