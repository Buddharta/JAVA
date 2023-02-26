import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private  final WeightedQuickUnionUF percolator;
    private final int dim;
    private final boolean[][] grid;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if( n <= 0) {
            throw new IllegalArgumentException(Integer.toString(n));
        }
        this.dim = n;
        this.grid = new boolean[n][n];
        int count = (n*n)+2;
        this.percolator = new WeightedQuickUnionUF(count);
        for (int i = 1; i < n ; i++){
            this.percolator.union(0,i + 1);
            this.percolator.union(count - 1,count - i - 1);
        }
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if( row <= 0 ||col <= 0 || row >= this.dim || col >= this.dim ) {
            throw new IllegalArgumentException(row +" and " + col);
        }
        int realrow = row - 1;//asigment convention is dumb
        int realcol = col - 1;//asigment convention is dumb
        if(!(this.grid[realrow][realcol])){
            this.grid[realrow][realcol] = true;
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if( row <= 0 ||col <= 0 || row >= this.dim || col >= this.dim ) {
            throw new IllegalArgumentException(row +" and " + col);
        }
        int realrow = row - 1;//asigment convention is dumb
        int realcol = col - 1;//asigment convention is dumb
        return this.grid[realrow][realcol];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if( row <= 0 ||col <= 0 || row >= this.dim || col >= this.dim ) {
            throw new IllegalArgumentException(row +" and " + col);
        }
        int realrow = row - 1;//asigment convention is dumb
        int realcol = col - 1;//asigment convention is dumb
        int position = realrow * this.dim + realcol + 1;
        if(this.grid[realrow][realcol]) {
            return (this.percolator.find(position) == 0);
        } else {
            return !this.grid[realrow][realcol];
        }
    }
    // returns the number of open sites
    public int numberOfOpenSites(){
        int counter = 0;
        for (int i=0; i < this.dim; i++){
            for (int j = 0; j < this.dim; j++){
                if(this.grid[i][j]){
                    counter++;
                }
            }
        }
        return counter;
    }
    // does the system percolate?
    public boolean percolates(){
        int borderUp;
        int borderDown;
        int borderLeft;
        int borderRight;
        int position;
        int neighborUp;
        int neighborDown;
        int neighborLeft;
        int neighborRight;
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++){
                position = i * this.dim + j + 1;
                neighborUp= (i - 1)*this.dim + j + 1;
                neighborDown = (i + 1)*this.dim + j + 1;
                neighborLeft = i * this.dim + j ;
                neighborRight = i * this.dim + j + 2 ;
                borderUp = (i - 1 < 0)? 1 : 0;
                borderRight = (j + 1 >= this.dim)? 1 : 0;
                borderDown = (i + 1>= this.dim)? 1 : 0;
                borderLeft = (j - 1 < 0)? 1 : 0;
                int borderCase = 8*borderLeft + 4*borderDown + 2*borderRight + borderUp;
                if (this.grid[i][j]){
                    switch (borderCase){
                        case 1:if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        } if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 2:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 3:if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 4:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        } if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        }
                            break;
                        case 5:if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        }
                            break;
                        case 6:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }
                            break;
                        case 7:if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }
                            break;
                        case 8:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        } if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 9:if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        } if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 10:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 11:if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                        }
                            break;
                        case 12:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        }
                            break;
                        case 13:if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        }
                            break;
                        case 14:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }
                            break;
                        case 15: continue;

                        default:if (this.isOpen(i,j+1)&&this.isFull(i,j+1)) {
                            percolator.union(position, neighborUp);
                        }if (this.isOpen(i+1,j)&&this.isFull(i+1,j)) {
                            percolator.union(position, neighborLeft);
                        }if (this.isOpen(i+1,j+2)&&this.isFull(i+1,j+2)) {
                            percolator.union(position, neighborRight);
                        }if (this.isOpen(i+2,j)&&this.isFull(i+1,j+1)) {
                            percolator.union(position, neighborDown);
                            break;
                        }
                    }
                }
            }
        }
        return (percolator.find((this.dim * this.dim) + 1)) == percolator.find(0);
    }

    // test client (optional)
    public static void main(String[] args)
    {
        Percolation perc = new Percolation(3);
        perc.open(1,1);
        perc.open(1,2);
        perc.open(0,0);
        perc.open(2,2);
        perc.open(0,1);
        System.out.println(perc.percolates());
    }
}
