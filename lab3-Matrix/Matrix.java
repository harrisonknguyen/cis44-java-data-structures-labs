public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols){
        data = new int[rows][cols];
    }

    public Matrix(int[][] data){
        this.data = data;
    }

    public void populateRandom(){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                data[i][j]=(int)(Math.random() * 10) + 1;
            }
        }
    }

    public Matrix add(Matrix other){
        if (data.length != other.data.length){
            throw new IllegalArgumentException();
        } else if(data[0].length != other.data[0].length){
            throw new IllegalArgumentException();
        }

        Matrix result = new Matrix(data.length, data[0].length);

        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++) {
                result.data[i][j]=data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other){
        if (data[0].length != other.data.length){
            throw new IllegalArgumentException();
        }

        Matrix result = new Matrix(data.length, other.data[0].length);

        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < other.data[0].length; j++){
                for (int k = 0; k < data[0].length; k++){
                    result.data[i][j]+=data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                result += data[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
