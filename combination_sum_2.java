package xyz.yhngo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vegeta on 9/25/16.
 */
public class CombineSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();

        dfs(candidates, res, path, 0, target);
        return res;
    }

    public void dfs(int[] cand, ArrayList<List<Integer>> res, ArrayList<Integer> path, int pos, int dest) {
        if (dest == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        if (dest < 0) {
            return;
        }

        for (int i = pos; i < cand.length; i++) {
            if (i > pos && cand[i] == cand[i-1]) {
                continue;
            }
            path.add(cand[i]);
            dfs(cand, res, path, i+1, dest-cand[i]);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        CombineSum cs = new CombineSum();
        int[] cand = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = cs.combinationSum2(cand, 8);

        for (Iterator<List<Integer>> iter = res.iterator(); iter.hasNext();) {
            for (Iterator<Integer> iter2 = iter.next().iterator(); iter2.hasNext();) {
                System.out.print(iter2.next() + " ");
            }
            System.out.println();
        }
    }
}
