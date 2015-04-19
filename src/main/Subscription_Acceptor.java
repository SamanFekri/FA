/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author SKings
 */
public class Subscription_Acceptor {

    private int[][] graph;
    private int start_state;
    private int[] final_states;
    
    public Subscription_Acceptor(int[][] g1, int s1, int[] f1, int[][] g2, int s2, int[] f2) {
        int m = g1.length;
        int n = g2.length;

        int p = 0;
        if (g1.length > 0) {
            p = g1[0].length;
        }

        start_state = s1 * n + s2;
        graph = new int[m * n][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    if (g1[i][k] == -1 || g2[j][k] == -1) {
                        graph[i * n + j][k] = -1;
                    } else {
                        graph[i * n + j][k] = g1[i][k] * n + g2[j][k];
                    }
                }
            }
        }

        final_states = new int[f1.length * f2.length];
        for (int i = 0; i < f1.length; i++) {
            for (int j = 0; j < f2.length; j++) {
                final_states[i * f2.length + j] = f1[i] * n + f2[j];
            }
        }
    }

    public boolean solve(String string) {
        int present_state = start_state;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                present_state = graph[present_state][0];
            } else {
                present_state = graph[present_state][1];
            }
            if (present_state == -1) {
                return false;
            }
        }
        for (int i = 0; i < final_states.length; i++) {
            if (final_states[i] == present_state) {
                return true;
            }
        }
        return false;
    }
}
