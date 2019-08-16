import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String l[] = br.readLine().split(" ");
            int R = Integer.parseInt(l[0]);
            int C = Integer.parseInt(l[1]);
            int text[][] = new int[R][C];
            for (int i = 0; i < R; i++) {
                String n = br.readLine();
                for (int j = 0; j < C; j++) {
                    text[i][j] = Integer.parseInt(n.charAt(j) + "");
                }
            }
            l = br.readLine().split(" ");
            int r = Integer.parseInt(l[0]);
            int c = Integer.parseInt(l[1]);
            int pat[][] = new int[R][C];
            for (int i = 0; i < r; i++) {
                String n = br.readLine();
                for (int j = 0; j < c; j++) {
                    pat[i][j] = Integer.parseInt(n.charAt(j) + "");
                }
            }
            boolean result = false;
            for (int i = 0; i <= R - r; i++) {
                for (int j = 0; j <= C - c; j++) {
                    if (text[i][j] == pat[0][0]) {
                        result = checkForPattern(text, pat, i, j, r, c);
                        if (result) {
                            break;
                        }
                    }
                }
                if (result) {
                    break;
                }
            }
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean checkForPattern(int text[][], int pat[][], int i, int j, int r, int c) {
        boolean result = true;
        int m = -1;
        int n;
        for (int k = i; k < i + r; k++) {
            m++;
            n = 0;
            for (int l = j; l < j + c; l++) {
                if (text[k][l] == pat[m][n]) {
                    n++;
                    continue;
                } else {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }
}