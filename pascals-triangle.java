// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


// In Pascal's triangle, each number is the sum of the two numbers directly above it.

// Example:

// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList();
        if (numRows <= 0) {
            return r;
        }
        
        List<Integer> first = new ArrayList();
        first.add(1);
        r.add(first);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> line = new ArrayList();
            line.add(1);
            for (int j = 1; j < i; j++) {
                line.add(r.get(i-1).get(j-1) + r.get(i-1).get(j));
            }
            line.add(1);
            r.add(line);
        }
        
        return r;
    }
}