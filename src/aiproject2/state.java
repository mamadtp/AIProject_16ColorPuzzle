package aiproject2;

import static java.lang.Math.abs;

public class state {

    int tbl[][] = {{-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}};
    int g = 0;
    int goal[][] = {{1, 2, 3, 4}, {2, 3, 4, 3}, {3, 4, 3, 2}, {4, 3, 2, 0}};

    state parent = null;
    state next = null;

    public int h() {
        int temp = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tbl[i][j] == 1) {
                    temp += i + j;
                } else if (tbl[i][j] == 2) {
                    int d[] = new int[4];
                    int minimum = 999999999;
                    d[0] = abs(i - 0) + abs(j - 1);
                    d[1] = abs(i - 1) + abs(j - 0);
                    d[2] = abs(i - 2) + abs(j - 3);
                    d[3] = abs(i - 3) + abs(j - 2);
                    for (int k = 0; k < 4; k++) {
                        if (d[k] < minimum) {
                            minimum = d[k];
                        }
                    }
                    temp += minimum;
                } else if (tbl[i][j] == 3) {
                    int d[] = new int[6];
                    int minimum = 999999999;
                    d[0] = abs(i - 2) + abs(j - 0);
                    d[1] = abs(i - 1) + abs(j - 1);
                    d[2] = abs(i - 0) + abs(j - 2);
                    d[3] = abs(i - 3) + abs(j - 1);
                    d[4] = abs(i - 2) + abs(j - 2);
                    d[5] = abs(i - 1) + abs(j - 3);
                    for (int k = 0; k < 6; k++) {
                        if (d[k] < minimum) {
                            minimum = d[k];
                        }
                    }
                    temp += minimum;
                } else if (tbl[i][j] == 4) {
                    int d[] = new int[4];
                    int minimum = 999999999;
                    d[0] = abs(i - 0) + abs(j - 3);
                    d[1] = abs(i - 1) + abs(j - 2);
                    d[2] = abs(i - 2) + abs(j - 1);
                    d[3] = abs(i - 3) + abs(j - 0);
                    for (int k = 0; k < 4; k++) {
                        if (d[k] < minimum) {
                            minimum = d[k];
                        }
                    }
                    temp += minimum;
                }
            }
        }
        return temp;
    }

    public int f() {
        return h() + g;
    }

    public state() {
        if (parent != null) {
            g = parent.g + 1;
        }
    }

    public state(int s[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tbl[i][j] = s[i][j];
            }
        }
        if (parent != null) {
            g = parent.g + 1;
        }
    }
}
