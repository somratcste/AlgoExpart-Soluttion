package greadyAlgorithm;

import java.util.*;

public class ClassPhotos {
    // O(nlog(n)) time | O(1) space
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        String shirtColorInFirstRow =
                redShirtHeights.get(0) > blueShirtHeights.get(0) ? "RED" : "BLUE";

        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            int redShirtHeight = redShirtHeights.get(idx);
            int blueShirtHeight = blueShirtHeights.get(idx);

            if (shirtColorInFirstRow == "RED") {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            } else {
                if (redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            }
        }
        return true;
    }
}
