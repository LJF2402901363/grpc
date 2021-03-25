package com.grpc.server;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * Classname:MeiTuanTest

 * @description:
 * @author: 陌意随影
 * @Date: 2021-03-20 16:19
 * @Version: 1.0
 **/
public class MeiTuanTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//        System.out.println(test(s1,s2));
    }
    String s = "abcdefghijklmnopqrstuvwxyz";
    @Test
    public   void   test( ){
      String target = "meituan";
              int start = 0;
                      int sum = 0;
                      String des ="";
                      int i = 0;
//              while (!des.equals(target)){

                      for (; i < target.length(); i++) {
                          char c = target.charAt(i);
                          int i1 = s.indexOf(c);
              if (start < i1){
                  sum += i1 -start -1;
                  des += c;
                  start = i1;
//                  temp =  temp.substring(i1+1);

              }else {
                  if (i1 == start){
                      if (i1 == 0){

                      }else {
                          sum +=s.length() -start;
                          i--;
                          start=0;
                      }
                  }else {
                      sum +=s.length() -start;
                      i--;
                      start=0;
                  }

              }


          }
//      }
        System.out.println(sum);
//              return  sum+1;
    }
//    @Test
    public   int   test( String s,String target){
//        String target = "meituan";
        int start = 0;
        int sum = 0;
        String des ="";
        int i = 0;
//              while (!des.equals(target)){

        for (; i < target.length(); i++) {
            char c = target.charAt(i);
            int i1 = s.indexOf(c);
            if (start < i1){
                sum += i1 -start -1;
                des += c;
                start = i1;
//                  temp =  temp.substring(i1+1);
            }else {
                sum +=s.length() -start;
//                  i = 0;
                i--;
                start=0;
            }


        }
//      }
//        System.out.println(sum);
              return  sum;
    }
}

