package com.yaoren.common.framework.util;

import java.util.Random;

public class MyMath {
    public static int random(int a){
        Random random=new Random();
        int salt=random.nextInt(a);
        return salt;
    }
}
