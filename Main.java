import java.lang.Math;

public class Main {

  public static int[][] M;
  public static int count = 0;



  public static void main(String[] args) {
    int x = Integer.parseInt(args[0])/2;
    int y = x;
    M = new int[x][y];
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        M[i][j] = -1;
      }
    }
    M[0][0] = count;
    count = count + 1;
    square(0, 0, x, y);
    toStringM();
  }

  public static void square(int startX, int startY, int endX, int endY) {
    toStringM();
    if (Math.abs(startX-endX) == 2) {
      for (int i = startX; i < endX; i++) {
        for (int j = startY; j < endY; j++) {
          if (M[i][j] == -1) {
            M[i][j] = count;
          }
        }
      }
      count = count + 1;
      return;
    }

    int adjustX = 0;
    int adjustY = 0;
    int[] L = new int[2];
    System.out.println("startX: " + startX);
    System.out.println("startY: " + startY);
    System.out.println("endX: " + endX);
    System.out.println("endY: " + endY);
    int midX = Math.abs((startX+endX)/2);
    int midY = Math.abs((startY+endY)/2);
    if (M[startX][startY] != -1) {
      M[midX][midY-1] = count;
      M[midX][midY] = count;
      M[midX-1][midY] = count;
    }
    else if (M[endX-1][startY] != -1) {
      M[midX-1][midY-1] = count;
      M[midX-1][midY] = count;
      M[midX][midY] = count;
    }
    else if (M[endX-1][endY-1] != -1) {
      M[midX-1][midY] = count;
      M[midX-1][midY-1] = count;
      M[midX][midY-1] = count;
    }
    else if (M[startX][endY-1] != -1) {
      M[midX][midY] = count;
      M[midX][midY-1] = count;
      M[midX-1][midY-1] = count;
    }
    int mid = Math.abs((startX-endX)/2);
    count = count + 1;
    System.out.println("mid:" + mid);
    System.out.println("startX: " + startX);
    System.out.println("startY: " + startY);
    System.out.println("endX: " + endX);
    System.out.println("endY: " + endY);
    square(startX,startY,endX-mid,endY-mid);

    square(startX+mid,startY+mid,endX,endY);

    square(startX+mid,startY,endX,endY-mid);

    square(startX,startY+mid,endX-mid,endY);
  }

  public static void toStringM() {
    for (int i = 0; i < M.length; i++) {
      System.out.print("|");
      for (int j = 0; j < M.length; j++) {
        if (M[i][j] < 10)
          System.out.print(" " + M[i][j] + " ");
        else
          System.out.print("" + M[i][j] + " ");
      }
      System.out.print("|");
      System.out.print("\n");
    }
    System.out.print("\n");
  }
}
