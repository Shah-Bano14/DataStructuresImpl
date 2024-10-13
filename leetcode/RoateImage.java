package leetcode;

public class RoateImage {

    public static void main(String[] args) {
        int matrix[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int result[][] = new int[matrix.length][matrix.length];
        int l=matrix.length-1;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                result[j][l-i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

}
