package com.hdl;

/**
 * 用于逻辑判断
 * Created by huangdongliang on 2018/9/14.
 */
public class BitUseInGame {


    //检查state的第pos位是否为1
    int bitCheck(int state, int pos) {
        return state & 1 << pos - 1;
    }

    //将state的第pos位的值设为1
    int bitAdd(int state, int pos) {
        return state | (1 << (pos - 1));
    }

    //将state的第pos位的值设为0
    int bitDel(int state, int pos) {
        return state & (~(1 << (pos - 1)));
    }
}
