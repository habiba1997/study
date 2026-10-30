import java.util.*;

public class MaintenanceWindows {
    /*
     * Exercise: Procore practice, 16 October evening, question 8.
     * Input is non-null, possibly empty and unsorted.
     * Each Window is a half-open interval [start,end), start < end.
     * Merge truly overlapping windows; touching endpoints stay separate.
     * Return windows sorted by start. You may reorder input if documented,
     * or copy it first. Output windows may be newly created.
     * Explain time/extra-space complexity and give two tests.
     * Status: TODO. No implementation supplied.
     */
    static final class Window {
        final int start;
        final int end;
        Window(int start, int end) {
            if (start >= end) throw new IllegalArgumentException("start must be < end");
            this.start = start;
            this.end = end;
        }
        @Override public String toString() {
            return "[" + start + "," + end + ")";
        }
    }

    static List<Window> mergeMaintenance(List<Window> windows) {
        // TODO: implement your solution.
        throw new UnsupportedOperationException("Implement mergeMaintenance");
    }

    public static void main(String[] args) {
        List<Window> input = new ArrayList<>(Arrays.asList(
            new Window(6, 9), new Window(1, 3),
            new Window(2, 5), new Window(9, 11)
        ));
        System.out.println(mergeMaintenance(input));
        // Write your expected output before running.
        // TODO: add two further test cases.
    }
}
// Run: javac MaintenanceWindows.java && java MaintenanceWindows
