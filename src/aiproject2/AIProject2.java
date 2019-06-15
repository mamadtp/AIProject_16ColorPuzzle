package aiproject2;

public class AIProject2 {
    public static boolean DebugMode = false;
    public static boolean equal(int one[][], int two[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (one[i][j] != two[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int map[][] = {{1,2,3,4},{2,3,4,3},{3,4,3,2},{4,3,2,0}};

        PriorityList frontier = new PriorityList(map);

        System.out.println("map designed!");

        state initial_state = new state(map);

        frontier.insert(initial_state);

        while (true) {
            if (frontier.size <= 0) {
                System.out.println("No Answer!");
                break;
            }
            state l = frontier.del();

            if (equal(l.tbl, initial_state.goal)) {
                long end = System.currentTimeMillis();
                end = end - start;
                state temp = l;
                

                while (temp != null) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            System.out.print(temp.tbl[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println("_____________________________");
                    temp = temp.parent;
                }

                if (end < 1000) {
                    System.out.println("Time in MiliSeconds:" +  end);
                } else {
                    System.out.println("Time in Seconds:" + (float) end / 1000);
                }
                break;
            }
            int xCurrent = -5, yCurrent = -5;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (l.tbl[i][j] == 0) {
                        xCurrent = i;
                        yCurrent = j;
                    }
                }
            }

            if (xCurrent - 1 >= 0 && xCurrent - 1 < 4) {
                state temp = new state(l.tbl);
                temp.parent = l;
                temp.tbl[xCurrent][yCurrent] = temp.tbl[xCurrent - 1][yCurrent];
                temp.tbl[xCurrent - 1][yCurrent] = 0;
                frontier.insert(temp);
            }
            if (xCurrent + 1 >= 0 && xCurrent + 1 < 4) {
                state temp = new state(l.tbl);
                temp.parent = l;
                temp.tbl[xCurrent][yCurrent] = temp.tbl[xCurrent + 1][yCurrent];
                temp.tbl[xCurrent + 1][yCurrent] = 0;

                frontier.insert(temp);
            }

            if (yCurrent - 1 >= 0 && yCurrent - 1 < 4) {
                state temp = new state(l.tbl);
                temp.parent = l;
                temp.tbl[xCurrent][yCurrent] = temp.tbl[xCurrent][yCurrent - 1];
                temp.tbl[xCurrent][yCurrent - 1] = 0;
                frontier.insert(temp);

            }
            if (yCurrent + 1 >= 0 && yCurrent + 1 < 4) {
                state temp = new state(l.tbl);
                temp.parent = l;
                temp.tbl[xCurrent][yCurrent] = temp.tbl[xCurrent][yCurrent + 1];
                temp.tbl[xCurrent][yCurrent + 1] = 0;
                frontier.insert(temp);

            }
        }
    }
}
