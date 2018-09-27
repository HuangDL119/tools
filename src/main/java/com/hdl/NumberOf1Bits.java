package com.hdl;

/**
 * Created by huangdongliang on 2018/9/14.
 */
public class NumberOf1Bits {

    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    public int hammingWeight2(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    public static void main(String args[]){
        NumberOf1Bits test=new NumberOf1Bits();

        System.out.println(test.hammingWeight1(1));
        System.out.println(test.hammingWeight2(1));
        System.out.println(test.hammingWeight1(3));
        System.out.println(test.hammingWeight2(3));
        System.out.println(test.hammingWeight1(11));
        System.out.println(test.hammingWeight2(11));
        System.out.println(test.hammingWeight1(37));
        System.out.println(test.hammingWeight2(37));
    }
}
