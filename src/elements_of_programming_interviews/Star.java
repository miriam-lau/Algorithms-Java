package elements_of_programming_interviews;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Star {
    public List<Integer> coordinates;
    public int distance;

    public Star(List<Integer> coordinates) {
        this.coordinates = coordinates;
        this.distance = coordinates.get(0) * coordinates.get(1) * coordinates.get(2);
    }

    public static void main(String[] args) {
        List<Integer> coords = new ArrayList<>(Arrays.asList(1, 2, 3 ));
        Star a = new Star(coords);

        System.out.println("COORDINATES");
        System.out.println(a.coordinates);

        System.out.println("DISTANCE");
        System.out.println(a.distance);
    }
}
