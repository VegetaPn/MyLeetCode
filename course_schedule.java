class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] courses = new ArrayList[numCourses];
        boolean[] marked = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courses, marked)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List[] courses, boolean[] marked) {
        if (marked[course]) {
            return false;
        } else {
            marked[course] = true;
        }

        for (int i = 0; i < courses[course].size(); i++) {
            if (!dfs((int)courses[course].get(i), courses, marked)) {
                return false;
            }
        }

        marked[course] = false;
        return true;
    }
}
