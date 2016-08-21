import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> rootNodes = new ArrayList<>();
            rootNodes.add(0);
            return rootNodes;
        }

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int i = 0; i < leaves.size(); i++) {
                int nextNode = adj.get(leaves.get(i)).iterator().next();
                adj.get(nextNode).remove(leaves.get(i));
                if (adj.get(nextNode).size() == 1) {
                    newLeaves.add(nextNode);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
