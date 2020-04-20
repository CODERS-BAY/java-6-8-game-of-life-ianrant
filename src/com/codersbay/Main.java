package com.codersbay;

public class Main {


    public static void main(String[] args) {

    /*
    TODO #1: zwei Arrays anlegen - der erste für den aktuellen Status, der zweite zum Bearbeiten; nach dem Bearbeiten
     wird der erste mit dem zweiten überschrieben, ausgegeben, der zweite wird zurückgesetzt

     TODO #2: mit je einer Zeile Abstand von den Rändern

     TODO #3: zwei nested for-Schleifen, die immer wieder über das Array iterieren; Nachbarn werden festgestellt und
      Nachbarwert wird ermittelt, dementsprechend wird mit mehreren if-else-if Verzweigungen und dem aktuellen Status
      entschieden, was mit der Zelle passiert
     */

        int rounds = 10;
        int horizontal = 30;
        int vertical = 10;
        int[][] field = new int[vertical][horizontal];
        int[][] fieldCopy = new int[vertical][horizontal];

        //setInitialValues(field);
        //printArray(horizontal, vertical, field);
        createRandom(horizontal, vertical, field);

        System.out.println();

        for (int i = 1; i <= rounds; i++) {
            checkNeighbors(horizontal, vertical, field, fieldCopy);
            System.out.printf("ROUND #%2d\n", i);
            System.out.println();
            printArray(horizontal, vertical, field);
            System.out.println();
        }
    }

    private static void printArray(int horizontal, int vertical, int[][] field) {
        for (int k = 0; k < vertical; k++) {
            for (int m = 0; m < horizontal; m++) {
                if (field[k][m] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(field[k][m]);
                }
            }
            System.out.println();
        }
    }

    private static void createRandom(int horizontal, int vertical, int[][] field) {
        for (int k = 1; k < vertical - 1; k++) {
            for (int m = 1; m < horizontal - 1; m++) {
                field[k][m] = (int) Math.round(Math.random());
                System.out.print(field[k][m]);
            }
            System.out.println();
        }
    }

    private static void setInitialValues(int[][] field) {
        //field[5][11] = 1;
        field[6][10] = 1;
        field[6][11] = 1;
        field[6][12] = 1;
        //field[7][11] = 1;

        /*field[7][31] = 1;
        field[7][32] = 1;
        field[7][33] = 1;
        field[6][31] = 1;
        field[6][32] = 1;
        field[6][33] = 1;*/
    }

    private static void checkNeighbors(int horizontal, int vertical, int[][] field, int[][] fieldCopy) {

        for (int k = 1; k < vertical - 1; k++) {
            for (int m = 1; m < horizontal - 1; m++) {
                int checkSum = (field[k - 1][m]) + (field[k - 1][m - 1]) + (field[k][m - 1]) +
                        (field[k + 1][m - 1]) + (field[k + 1][m]) + (field[k + 1][m + 1]) +
                        (field[k][m + 1]) + (field[k - 1][m + 1]);

                if ((field[k][m]) == 0 && checkSum == 3) {
                    (fieldCopy[k][m]) = 1; //wirdGeboren
                } else if ((field[k][m]) == 1 && checkSum < 2) {
                    (fieldCopy[k][m]) = 0; //stirbtAnEinsamkeit
                } else if ((field[k][m]) == 1 && (checkSum == 2 || checkSum == 3)) {
                    (fieldCopy[k][m]) = 1; //bleibtAmLeben
                } else if ((field[k][m]) == 1 && checkSum > 3) {
                    (fieldCopy[k][m]) = 0; //stirbtAnÜberbevölkerung
                }
            }
        }
        for (int i = 1; i < vertical - 1; i++) {
            for (int j = 1; j < horizontal - 1; j++) {
                field[i][j] = fieldCopy[i][j];
            }
        }
    }


    //Ende der Klasse
}


