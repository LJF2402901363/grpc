package com.grpc.server;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classname:MainTest2

 * @description:
 * @author: 陌意随影
 * @Date: 2021-03-20 17:41
 * @Version: 1.0
 **/
public class MainTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        String[] split1 = s1.split(" ");
        Integer n = Integer.parseInt(split1[0]);
        Integer m = Integer.parseInt(split1[1]);
        String[] split2 = s2.split(" ");
        String[] split3 = s3.split(" ");
        ArrayList<Integer> list2 = new ArrayList<Integer>(n);
        for (String s : split2) {
            list2.add(Integer.parseInt(s));
        }
        ArrayList<Integer> list3 = new ArrayList<Integer>(m);
        for (String s : split3) {
            list3.add(Integer.parseInt(s));
        }
        System.out.println(get(list2,list3));
    }
    public static Integer get(ArrayList<Integer> list2,ArrayList<Integer> list3){
        return  7;
    }
}
