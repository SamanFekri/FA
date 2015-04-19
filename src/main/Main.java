/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author SKings
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("choose N for normal and S for subscription acceptor : ");
        String choose = sc.nextLine();
        if (choose.equalsIgnoreCase("N")) {
            int[][] g = null;
            int[] f = null;

            System.out.print("insert graph file path : ");
            TestCaseReader tcr = new TestCaseReader(sc.nextLine());
            g = tcr.graph;
            f = tcr.final_state;
            Normal_Acceptor na = new Normal_Acceptor(g, 0, f);

            System.out.println("ex (1000110001)");
            System.out.print("insert string you want test it : ");
            System.out.println("answer : " + na.solve(sc.nextLine()));

        } else if (choose.equalsIgnoreCase("S")) {
            int[][] g1 = null, g2 = null;
            int[] f1 = null, f2 = null;

            System.out.print("insert graph file path : ");
            TestCaseReader tcr = new TestCaseReader(sc.nextLine());
            g1 = tcr.graph;
            f1 = tcr.final_state;

            System.out.print("insert graph file path : ");
            tcr = new TestCaseReader(sc.nextLine());
            g2 = tcr.graph;
            f2 = tcr.final_state;
            
            Subscription_Acceptor sa = new Subscription_Acceptor(g1, 0, f1, g2, 0, f2);

            System.out.println("ex : 1000110001");
            System.out.print("insert string you want test it : ");
            System.out.println("answer : " + sa.solve(sc.nextLine()));

        }
    }

}
