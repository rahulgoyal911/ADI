import java.lang.*;
import java.util.*;

class Points {
    int xCord[];
    int yCord[];
}
class Versions extends Points {
    public int verNo;
    Versions() { this.verNo = 1; }
    Versions(int verNo) {
        this.verNo = verNo;
    }
    public void changeVer(int verNo) {
        this.verNo = verNo;
    }
}
class Line extends Versions {
    Line() {
        xCord = new int[] {1, 2, 3, 4};
        yCord = new int[] {1, 1, 1, 1};
    }
    public void changeVer(int verNo) {
        super.changeVer(verNo);
        int tempVar;
        for(int i = 0;i<xCord.length;i++) {
            tempVar = xCord[i];
            xCord[i] = yCord[i];
            yCord[i] = tempVar;
        }
    }
}

class Square extends Versions {
    Square() {
        xCord = new int[] {1, 1, 2, 2};
        yCord = new int[] {1, 2, 1, 2};
    }
    public void changeVer(int verNo) {
        super.changeVer(verNo);
    }
}

class T extends Versions {
    int tempVar[] = new int[4];
    T() {
        xCord = new int[] {1, 1, 1, 2};
        yCord = new int[] {1, 2, 3, 2};
    }
    public void changeVer(int verNo) {
        super.changeVer(verNo);
        int length = yCord.length;
        if(verNo == 1) { // 4 -> 1
            for (int i = 0; i<length; i++) {
                tempVar[i] = xCord[i];
                xCord[i] = yCord[i];
            }
            for(int i = 0;i<length - 1;i++) {
                yCord[i] = tempVar[length - (i+2)];
            }
            yCord[length - 1] = xCord[length - 1];
        } else if(verNo == 2) { // 1 -> 2
            int max = -32768;
            for (int i = 0; i<length; i++) {
                xCord[i] = yCord[i];
                max = max > yCord[i] ? max : yCord[i];
            }
            for(int i = 0;i<length - 1;i++) {
                yCord[i] = max;
            }
            yCord[length - 1] = xCord[length - 1];
        } else if(verNo == 3) { // 2 -> 3
            for (int i = 0; i<length; i++) {
                tempVar[i] = xCord[i];
                xCord[i] = yCord[i];
            }
            for(int i = 0;i<length - 1;i++) {
                yCord[i] = tempVar[length - (i+2)];
            yCord[length - 1] = xCord[length - 1];
            }
            yCord[length - 1] = xCord[length - 1];
        } else if(verNo == 4) { // 3 -> 4
            int min = 32768;
            for (int i = 0; i<length; i++) {
                xCord[i] = yCord[i];
                min = min < yCord[i] ? min : yCord[i];
            }
            for(int i = 0;i<length - 1;i++) {
                yCord[i] = min;
            }
            yCord[length - 1] = xCord[length - 1];
        }
    }
}

class L extends Versions {
    L() {
        xCord = new int[] {1, 2, 3, 3};
        yCord = new int[] {1, 1, 1, 2};
    }
    public void changeVer(int verNo) {
        super.changeVer(verNo);
        int length = yCord.length;
        if(verNo == 1) { // 4 -> 1
            int min = 32768;
            for (int i = 0; i<length ; i++) {
                min = min < xCord[i] ? min : xCord[i];
                xCord[i] = yCord[i];
            }
            for(int i = 0; i<length - 1; i++) {
                yCord[i] = min;
            }
            yCord[length - 1] = min + 1;
        } else if(verNo == 2) { // 1 -> 2
            int max = -32768;
            for (int i = 0; i<length ; i++) {
                max = max > xCord[i] ? max : xCord[i];
                xCord[i] = yCord[i];
            }
            max++;
            for(int i = 0; i<length - 1; i++) {
                yCord[i] = max--;
            }
            yCord[length - 1] = max + 1;
        } else if(verNo == 3) { // 2 -> 3
            int max = -32768;
            for (int i = 0; i<length ; i++) {
                max = max > xCord[i] ? max : xCord[i];
                xCord[i] = yCord[i];
            }
            for(int i = 0; i<length - 1; i++) {
                yCord[i] = max;
            }
            yCord[length - 1] = max - 1;
        } else if(verNo == 4) { // 3 -> 4
            int min = 32768;
            for (int i = 0; i<length ; i++) {
                min = min < xCord[i] ? min : xCord[i];
                xCord[i] = yCord[i];
            }
            min--;
            for(int i = 0; i<length - 1; i++) {
                yCord[i] = min++;
            }
            yCord[length - 1] = min - 1;
        }
    }
}

class Z extends Versions{
    int tempVar[] = new int[4];
    Z() {
        xCord = new int[] {1, 2, 2, 3};
        yCord = new int[] {1, 1, 2, 2};
    }
    public void changeVer(int verNo) {
        super.changeVer(verNo);
        int length = yCord.length;
        if(verNo == 1) { //4 -> 1
            for (int i = 0; i<length ; i++) {
                tempVar[i] = xCord[i];
                xCord[i] = yCord[i] - 1;
            }
            for(int i = 0;i<length;i++) {
                yCord[i] = tempVar[i];
            }
        } else if(verNo == 2) { // 1 -> 2
            for (int i = 0; i<length ; i++) {
                tempVar[i] = xCord[i];
                xCord[i] = yCord[i];
            }
            for(int i = 0;i<length;i++) {
                yCord[i] = tempVar[i];
            }
        } else if(verNo == 3) { // 2 -> 3
            for (int i = 0; i<length ; i++) {
                tempVar[i] = xCord[i];
                xCord[i] = yCord[i] + 1;
            }
            for(int i = 0;i<length;i++) {
                yCord[i] = tempVar[i];
            }
        } else if(verNo == 4) { // 3 -> 4
            for (int i = 0; i<length ; i++) {
                tempVar[i] = xCord[i];
                xCord[i] = yCord[i];
            }
            for(int i = 0;i<length;i++) {
                yCord[i] = tempVar[i];
            }
        }
    }
}

public class Tetris {
    public static char board[][] = new char[30][30];
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lets Start!!!");
        Line line = new Line();
        Square square = new Square();
        T t = new T();
        L l = new L();
        Z z = new Z();
        Versions currentShape = new Versions();
        char dir;
        int currentVer = 1, currentShapeNo = 3;
        while(true) {
            // currentShapeNo = (int)(Math.random() * 5) + 1;
            clearBoard();
            currentShape = currentShapeNo == 1 ? line : currentShapeNo == 2 ? square : currentShapeNo == 3 ? t : currentShapeNo == 4 ? l : z;
            drawOnBoard(currentShape);
            displayBoard();
            dir = scanner.next().charAt(0);
            if (dir == 'r') {
                currentVer++;
                if(currentVer > 4)
                    currentVer = 1;
                currentShape.changeVer(currentVer);
            } else if(dir == 'a') {
                moveLeft(currentShape);
            } else if(dir == 'd') {
                moveRight(currentShape);
            } else if(dir == 's') {
                moveDown(currentShape);
            }
            // System.out.print("\033[H\033[2J");
            // System.out.flush();
        }
    }
    public static void clearBoard() {
        for(int i = 0;i<board.length;i++) {
            for(int j = 0;j<board[i].length;j++) {
                if(i == 0 || j == 0 || i == board.length - 1 || j == board.length - 1 )
                    board[i][j] = '*';
                else
                    board[i][j] = ' ';
            }
        }
    }
    public static void drawOnBoard(Versions V) {
        for(int i = 0;i<V.xCord.length;i++) {
            board[V.xCord[i]][V.yCord[i]] = '#';
        }
    } 
    public static void displayBoard() {
        for(char arr[]:board) {
            for(char a:arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    public static void moveDown(Versions V) {
        if(V.xCord[0] == 28 || V.xCord[1] == 28 || V.xCord[2] == 28 || V.xCord[3] == 28)
                return;
        for(int i = 0;i<V.xCord.length;i++) {
                V.xCord[i]++;
        }
    }
    public static void moveLeft(Versions V) {
        if(V.yCord[0] == 1 || V.yCord[1] == 1 || V.yCord[2] == 1 || V.yCord[3] == 1)
            return;
        for(int i = 0;i<V.xCord.length;i++) {
                V.yCord[i]--;
        }
    }
    public static void moveRight(Versions V) {
        if(V.yCord[0] == 28 || V.yCord[1] == 28 || V.yCord[2] == 28 || V.yCord[3] == 28)
            return;
        for(int i = 0;i<V.xCord.length;i++) {
                V.yCord[i]++;
        }
    }
}
        