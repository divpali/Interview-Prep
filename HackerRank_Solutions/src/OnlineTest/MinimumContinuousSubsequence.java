package OnlineTest;

/*
Minimum Continuous Subsequence: targetList & availabletTagsList are two lists of string.

Input:

targetList = {"cat", "dog"};
availableTagsList = { "cat", "test", "dog", "get", "spain", "south" };

Output: [0, 2] //'cat' in position 0; 'dog' in position 2

Input:

targetList = {"east", "in", "south"};
availableTagsList = { "east", "test", "east", "in", "east", "get", "spain", "south" };

Output: [2, 6] //'east' in position 2; 'in' in position 3; 'south' in position 6 (east in position 4 is not outputted as it is coming after 'in')

Input:

targetList = {"east", "in", "south"};
availableTagsList = { "east", "test", "south" };

Output: [0] //'in' not present in availableTagsList

Note: targetList will contain Distinct string objects.
*/

public class MinimumContinuousSubsequence {
}
