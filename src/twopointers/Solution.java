package twopointers;

import java.util.Arrays;

public class Solution {

    /**
     * Calculates the minimum number of days required to schedule all meetings
     * without overlap on the same day.
     *
     * @param intervals Array of meeting time intervals [start, end]
     * @return Minimum number of days needed
     */
    public static int getMinimumMeetingDays(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int totalMeetings = intervals.length;
        int[] startTimes = new int[totalMeetings];
        int[] endTimes = new int[totalMeetings];

        // Extract start and end times
        for (int i = 0; i < totalMeetings; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // Sort both arrays to use two-pointer technique
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0;
        int endPointer = 0;
        int currentOverlap = 0;
        int maxOverlap = 0;

        // Traverse the sorted arrays
        while (startPointer < totalMeetings) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                // New meeting overlaps with an ongoing one
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                startPointer++;
            } else {
                // A meeting has ended, reduce overlap count
                currentOverlap--;
                endPointer++;
            }
        }

        return maxOverlap;
    }

    public static void main(String[] args) {

        int[][][] testCases = {
                {{0, 30}, {5, 10}, {15, 20}},         // Example 1
                {{7, 10}, {2, 4}},                    // Example 2
                {{1, 5}, {8, 9}, {8, 9}},             // Example 3
                {{1, 4}, {2, 5}, {3, 6}},             // Example 4
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}}      // Example 5
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = getMinimumMeetingDays(testCases[i]);
            System.out.println("Example " + (i + 1) + ": Minimum number of days = " + result);
        }
    }
}
