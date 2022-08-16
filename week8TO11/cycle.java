package CourseWork.week8TO11;

import CourseWork.week8TO11.LinkedList0.Node;
import java.util.Iterator;
import java.util.*;

// adjency list is a square matrix
// getAdjNode:-adjMatrix, adjList"return in LinkedList"

public class cycle {
     static LinkedList0[] arr;
     static int vertices;
	private LinkedList<Integer> adj[];

     cycle(int vertices) {
          this.vertices = vertices;
          arr = new LinkedList0[vertices];
          for (int i = 0; i < vertices; i++) {
               arr[i] = new LinkedList0();
          }
     }

     public static void addEdge(int src, int des) {
          arr[src].addNode(des);
          arr[des].addNode(src);
     }

     public static  int[] getAdjNode(int i) {
          int list[] = new int[arr[i].getSize()];
          Node curr = arr[i].head;
          int indx = 0;
          while (curr != null) {
               list[indx++] = curr.data;
               curr = curr.next;
          }
          return list;
     }

     public static String topoSort() {
          int[] indegree = new int[vertices];
          for (int i = 0; i < vertices; i++) {
               int list[] = getAdjNode(i);
               for (int j = 0; j < list.length; j++) {
                    int adjVal = list[j];
                    indegree[adjVal]++;
               }
          }
          queueExample q = new queueExample(vertices);
          for (int i = 0; i < vertices; i++) {
               if (indegree[i] == 0) {
                    q.enq(i);
               }
          }
          int cnt = 0;
          while (!q.isEmpty()) {
               cnt++;
               int x = q.deq();
               System.out.println(x);
               int[] list = getAdjNode(x);
               for (int i = 0; i < list.length; i++) {
                    int adjVal = list[i];
                    indegree[adjVal]--;
                    if (indegree[adjVal] == 0) {
                         q.enq(adjVal);
                    }
               }
          }
          if (cnt >= vertices) {
               return "ERROR, Cycle detected!!!";
          } 
          return "NO Cycle Detected";
     }

}
