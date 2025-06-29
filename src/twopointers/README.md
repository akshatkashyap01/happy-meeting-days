# Happy Meeting Days

## Problem Statement

Given an array of meeting intervals where `intervals[i] = [start_i, end_i]`, determine the **minimum number of days** required to schedule all meetings such that no two meetings overlap on the same day.

Two meetings `[start_i, end_i]` and `[start_j, end_j]` **overlap** if they share any common time, i.e., `max(start_i, start_j) < min(end_i, end_j)`.

---

## Key Insight

The minimum number of days needed equals the **maximum number of overlapping meetings** at any time.

---

## Approach: Two Pointer Method

1. Extract all start times and end times into separate arrays.
2. Sort both arrays.
3. Use two pointers to iterate through the starts and ends simultaneously:
    - If the current meeting starts before the earliest ending meeting ends, increment the count of active meetings (overlap).
    - Otherwise, a meeting ended, so decrement the active meeting count.
4. Track the maximum active meetings during iteration. This maximum is the minimum number of days required.

---

## Algorithm Steps

- Sort start times and end times.
- Initialize two pointers: `sPtr` (start) and `ePtr` (end).
- Initialize counters: `activeMeetings = 0`, `daysNeeded = 0`.
- While `sPtr < n`:
    - If `starts[sPtr] < ends[ePtr]`, increment `activeMeetings`, update `daysNeeded`, move `sPtr`.
    - Else, decrement `activeMeetings`, move `ePtr`.
- Return `daysNeeded`.

---

## Time and Space Complexity

- **Time:** O(n log n) due to sorting.
- **Space:** O(n) for storing start and end arrays.

---

## Covered Examples and Explanations

| Example | Input                         | Output | Explanation                                                                                 |
|---------|-------------------------------|--------|---------------------------------------------------------------------------------------------|
| 1       | [[0,30],[5,10],[15,20]]       | 2      | Meeting `[0,30]` overlaps with both `[5,10]` and `[15,20]`, so 2 days needed.               |
| 2       | [[7,10],[2,4]]                | 1      | Meetings do not overlap, all fit in a single day.                                          |
| 3       | [[1,5],[8,9],[8,9]]           | 2      | Two `[8,9]` meetings overlap exactly and require separate days.                            |
| 4       | [[1,4],[2,5],[3,6]]           | 3      | All meetings overlap pairwise, each needs its own day.                                     |
| 5       | [[1,2],[2,3],[3,4],[4,5]]     | 1      | Meetings touch boundaries but do not overlap; can all be scheduled on one day.             |

---

## Summary

This two-pointer approach efficiently calculates the minimum number of days needed by finding the peak number of overlapping meetings. It achieves optimal time complexity of O(n log n) and uses O(n) extra space.

---

## Notes

- This approach works best for counting minimum days required.
- For assigning meetings to specific days, a min-heap based approach can be used.
- The algorithm assumes meetings that only touch at endpoints (e.g., end time of one equals start time of another) do **not** overlap.
