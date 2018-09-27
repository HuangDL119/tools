package com.hdl.mudium;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
 * Max Increase to Keep City Skyline
 *
 * Example:
 Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 Output: 35
 Explanation:
 The grid is:
 [ [3, 0, 8, 4],
 [2, 4, 5, 7],
 [9, 2, 6, 3],
 [0, 3, 1, 0] ]

 The skyline viewed from top or bottom is: [9, 4, 8, 7]
 The skyline viewed from left or right is: [8, 7, 9, 3]

 The grid after increasing the height of buildings without affecting skylines is:
 gridNew = [ [8, 4, 8, 7],
 [7, 4, 7, 7],
 [9, 4, 8, 7],
 [3, 3, 3, 3] ]
 */
class SkyLineSolution {
    /**
     * 思路,每个数字的增加值小于 该数字所在行列的最小值
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        System.out.println("input:"+Arrays.toString(grid));
        int rowNum=grid.length;
        int colNum=grid[0].length;
        System.out.println("rowNum = "+rowNum);
        System.out.println("colNum = "+colNum);

        //计算每列中最大的元素组成的一行,包含列数个元素
        int[] maxCols=new int[colNum];
        for(int col=0;col<maxCols.length;col++){
            //查找这一列的最大值
            for(int row=0;row<rowNum;row++){
                if(grid[row][col]>maxCols[col]){
                    maxCols[col]=grid[row][col];
                }
            }
        }
        System.out.println("maxCols:"+Arrays.toString(maxCols));

        //计算每行中最大的元素组成的一列,包含行数个元素
        int[] maxRows=new int[rowNum];
        for(int row=0;row<maxRows.length;row++){
            //查找这一列的最大值
            for(int col=0;col<colNum;col++){
                if(grid[row][col]>maxRows[row]){
                    maxRows[row]=grid[row][col];
                }
            }
        }
        System.out.println("maxRows:"+Arrays.toString(maxRows));

        int maxIncreaseKeepingSkyline=0;
        for(int row =0;row<rowNum;row++){
            for (int col=0;col<colNum;col++){
                //不能超过所在行与所在列的最大值
                int limit=maxCols[col];
                if(limit>maxRows[row]){
                    limit=maxRows[row];
                }
                if(grid[row][col]<limit){
                    //有增长空间
                    maxIncreaseKeepingSkyline+=limit-grid[row][col];
                }
            }
        }
        System.out.println("maxIncreaseKeepingSkyline = "+maxIncreaseKeepingSkyline);
        return maxIncreaseKeepingSkyline;
    }
    public static void main(String args[]){
//        int[][] grid={{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0},{2,3,3,2}};
        int[][] grid={{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        new SkyLineSolution().maxIncreaseKeepingSkyline(grid);
    }
}