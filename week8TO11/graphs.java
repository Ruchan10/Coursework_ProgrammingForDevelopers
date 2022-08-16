package CourseWork.week8TO11;

import javax.swing.JOptionPane;


public class graphs {
     static String str[] = new String[30];
     static int vertices; // 30
     static int matrix[][];
     static boolean connected[][];
     static String matrix0[][];
     static String nodeName[];
     static String dis[];
     public static String d[] = new String[30];

     public graphs() {

     }

     public static String[][] getPipe() {
          return matrix0;
     }

     public static String getStr(int indx) {
          return str[indx];
     }

     public static String getDis(int in) {
          if (dis[in] != null) {
               return dis[in];
          }
          return null;
     }

     public static void setVertices(int vertice) {
          vertices = vertice;
          str = new String[vertices];
          dis = new String[vertices];
          nodeName = new String[vertices];
          matrix = new int[vertices][vertices];
          matrix0 = new String[vertices][vertices];
          connected = new boolean[vertices][vertices];
          int count=0;
          if(count==0){
              count=-1;
          for (int i = 0; i < vertices; i++) {
               nodeName[i] = "House" + i;
          }}
     }

     public static  int getVertices() {
          return vertices;
     }

     static void setNodeName(int indx, String a) {
          nodeName[indx] = a;
     }

     public static String getNodeName(int a) {
          return nodeName[a];
     }

     static void setDesc(int indx, String a) {
          d[indx] = a;
     }

     public static String getDesc(int i) {
          return d[i];
     }

     public static boolean isConnected(int s, int d) {
          return connected[s][d];
     }

     public static void addEdge(int source, int destination, int weight, String pipeInfo) {
          if (connected[source][destination]) {
               JOptionPane.showMessageDialog(null, "ALREADY CONNECTED");
          }
          if (connected[source][destination] != true) { 
              System.out.println("inside IF");
               matrix[source][destination] = weight;
               matrix[destination][source] = weight;
               matrix0[source][destination] = pipeInfo;
               matrix0[destination][source] = pipeInfo;
               connected[source][destination] = true;
               connected[destination][source] = true;
          } else {
               System.out.println("CONNECTED");
          }
     }

     public static void printAdjVertices() { // matrix[0].length for column length
          int co = -1;
          for (int i = 0; i < vertices; i++) {
               for (int j = 0; j < vertices; j++) {
                    if (matrix[i][j] != 0) {
                         co++;
                         String st = "" + nodeName[i] + " is connected to: " + nodeName[j] + ", " + "";
                         for (int r = 0; r < vertices; r++) {
//                              if (str[co] == null) {
                                if(co<vertices){
                                   str[co] = st;}
//                                   return;
//                              }
                              co++;
                              System.out.println(co);
                         }
                    }
               }
          }
     }

     public LinkedList1 getAdjNodes(int i) {
          LinkedList1 ll = new LinkedList1();
          for (int j = 0; j < vertices; j++) {
               if (matrix[i][j] != 0) {
                    ll.addNode(j);
               }
          }
          ll.printList();
          return ll;
     }
     public static int c = 0;

     public static void shortestDis(int source, int destination) {
          boolean visited[] = new boolean[vertices];
          int distance[] = new int[vertices];
          int prevPath[] = new int[vertices];
          queueExample q = new queueExample(vertices);

          for (int i = 0; i < vertices; i++) {
               distance[i] = Integer.MAX_VALUE;
               prevPath[i] = -1;
          }
          q.enq(source);
          visited[source] = true;
          distance[source] = 0;
          while (!q.isEmpty()) {
               int u = q.deq();
               System.out.println("VERTICES:- " + vertices);
               for (int i = 0; i < vertices; i++) {
                    if (matrix[u][i] != 0 && !visited[i]) {
                         int v = i;
                         distance[u] = distance[u] + 1;
                         if (distance[u] < distance[v]) {
                              distance[v] = distance[u];
                              prevPath[v] = i;
                         }
                         q.enq(v);
                         visited[v] = true;
                    }
               }
          }
          String d = "distance from '" + nodeName[source] + "' to '" + nodeName[destination] + "' is:- "
                    + distance[destination];
          dis[c] = d;
          c++;
     }
}
