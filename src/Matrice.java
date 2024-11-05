import java.util.ArrayList;

public class Matrice {
    public ArrayList<ArrayList<Integer>> aliments = new ArrayList<>();
    private int rows;
    private int cols;

    Matrice(String aliments) {
        String[] rows = aliments.split(";");

        String[] col;

        for (String row : rows) {

            col = row.split(",");

            this.cols = col.length;

            ArrayList<Integer> auxCol = new ArrayList<Integer>(0);

            for (String item : col) {
                auxCol.add(Integer.parseInt(item));
            }

            this.aliments.add(auxCol);
            this.rows++;
        }
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public boolean isSquare() {
        return this.cols == this.rows ? true : false;
    }

    public String size() {
        return "" + this.rows + "x" + this.cols;
    }

    public double determinant() throws Exception {
        double res = 0;

        if (!this.isSquare())
            throw new Exception(" This matrice is not a square");

        if (this.size().equals("2x2")) {
            return this.aliments.get(0).get(0) * this.aliments.get(1).get(1)
                    - this.aliments.get(0).get(1) * this.aliments.get(1).get(0);
        } else {

            System.out.println("To be done");
            
        }
        return res;
    }

    public String plus(Matrice y) throws Exception {
        if (!this.size().equals(y.size()))
            throw new Exception("- Matrices need be of the same size");

        return this.processSumOrSubtraction('+', y);
    }

    public String minus(Matrice y) throws Exception {
        if (!this.size().equals(y.size()))
            throw new Exception("- Matrices need be of the same size");

        return this.processSumOrSubtraction('-', y);
    }

    private String processSumOrSubtraction(char operation, Matrice y) {
        String res = "";

        for (int i = 0; i < this.aliments.size(); i++) {
            for (int j = 0; j < this.aliments.get(i).size(); j++) {
                if (operation == '+')
                    res += (this.aliments.get(i).get(j) + y.aliments.get(i).get(j)) + ",";
                else
                    res += (this.aliments.get(i).get(j) - y.aliments.get(i).get(j)) + ",";

                res = res.substring(0, res.length() - 1);
            }
            res = res.substring(0, res.length() - 1) + (";");
        }
        return res;
    }

    public String times(Matrice y) throws Exception {
        String res = "";

        if (this.getCols() != y.getRows())
            throw new Exception(
                    "Number of columns in first matrice must be equal to the number of rows in second one.");

        for (int row = 0; row < this.getRows(); row++) {
            for (int col = 0; col < y.getCols(); col++) {
                res += this.getTimesRowCol(y, row, col) + ",";  
            }
            res = res.substring(0, res.length()-1) + ";";  
        }
        return res.substring(0, res.length()-1);
    }


    private int getTimesRowCol(Matrice y, int row, int col) {
        int res = 0;

        for ( int i = 0; i < this.getCols() ; i++ ){
            res += this.aliments.get(row).get(i)  * 
                   y.aliments.get(i).get(row);
        }
        return res;
    }

    public String toString() {
        String res = "\r\n";

        for (ArrayList<Integer> rows : this.aliments) {
            for (Integer item : rows) {
                res += item.toString() + ",";
            }
            res = res.substring(0, res.length() - 1) + ("\r\n");
        }
        return res;
    }
}
