/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author SKings
 */
public class TestCaseReader {
    int[][] graph;
    int[] final_state;
    int start_state;
    
     public  TestCaseReader(String path) {
        try {
            // TODO code application logic here
            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);
            int n = new Integer(br.readLine());
            int m = new Integer(br.readLine());

            graph = new int[m][n];

            br.readLine();

            String[] help;
            for (int i = 0; i < m; i++) {
                help = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = new Integer(help[j]) - 1;
                }
            }

            br.readLine();

            help = br.readLine().split(" ");

            final_state = new int[help.length];

            for (int i = 0; i < help.length; i++) {
                final_state[i] = new Integer(help[i]) - 1;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (Exception ex) {
            System.out.println("format of file is wrong");
        }

    }
}
