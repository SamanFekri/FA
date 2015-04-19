/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author SKings
 */
public class Normal_Acceptor {

    private int[][] graph;
    private int start_state;
    private int[] final_states;

    public Normal_Acceptor(int[][] graph, int start_state, int[] final_states) {
        this.graph = graph;
        this.start_state = start_state;
        this.final_states = final_states;
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
