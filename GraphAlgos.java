import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * The graphAlgos class is used
 * to create methods to search,
 * assemble, analyze, and organize
 * data into graphs and other
 * representations.
 */
public class GraphAlgos {

    /**
     * The int count is used
     * int findZeroVertices and
     * edit distanceOne to keep
     * track as a simple counter
     * and/or pointer.
     */
    private int count;

    /**
     * The int sum1 is used
     * in calculate weight as
     * a simple sum to compare
     * to sum2.
     */
    private int sum1;

    /**
     * The int sum2 is used
     * in calculate weight as
     * a simple sum to compare
     * to sum1.
     */
    private int sum2;

    /**
     * The int index is used
     * to return the index value
     * from the getIndex utility
     * method.
     */
    private int index;

    /**
     * The int pathWeight is
     * used in mst to keep track
     * of the total path weight.
     */
    private int pathWeight;

    /**
     * The int edgesAdded is used
     * to keep track of the number
     * of edges added to the mst in
     * the mst method.
     */
    private int edgesAdded;

    /**
     * The int minWeight is used
     * to keep track of the minimum
     * weight for the mst creation in
     * the mst method.
     */
    private int minWeight;

    /**
     * The int minWeightMove is used
     * to keep track of the minimum
     * weight move in the mst for
     * the mst method.
     */
    private int minWeightMove;

    /**
     * The int h is used
     * in editDistanceOne to keep
     * track as a simple counter
     * and/or pointer.
     */
    private int h;

    /**
     * The int i is used
     * in  addItemToEnd and
     * editDistanceOne to keep
     * track as a simple counter
     * and/or pointer.
     */
    private int i;

    /**
     * The int j is used
     * in editDistanceOne to keep
     * track as a simple counter
     * and/or pointer.
     */
    private int j;

    /**
     * The int k is used
     * in bfs, dfs, mst and
     * editDistanceOne to keep
     * track as a simple counter
     * and/or pointer.
     */
    private int k;

    /**
     * The int max is used to
     * keep track of the maximum
     * number of vertices a word
     * has.
     */
    private int max;

    /**
     * The 2d int array weighted is
     * used in the makeWeighted method
     * to keep track of all the weights
     * of edges.
     */
    private int[][]weighted;

    /**
     * The double sum is used
     * in the avgNumVertices
     * method to keep more
     * precision on the return.
     */
    private double sum;

    /**
     * The vertexName string is used
     * to hold the name of the min
     * vertex move temporarily in
     * the mst method.
     */
    private String vertexName;

    /**
     * The saveVertexName string is used
     * to hold the name of the min
     * vertex move in the mst method.
     */
    private String savedVertexName;

    /**
     * The string s is used in dfs and
     * bfs to hold the names of vertices
     * temporarily.
     */
    private String s;

    /**
     * The string r is used in dfs and
     * bfs to hold the names of vertices
     * temporarily.
     */
    private String r;

    /**
     * The string array dataReturn is used
     * in the loadStrData method to hold
     * the data from the resources file.
     */
    private String[]dataReturn;

    /**
     * The maxItems string array is used
     * in the maxNumVertices method
     * to hold the vertices that the
     * max has.
     */
    private String[]maxItems;

    /**
     * The string array workList is
     * used in the addItemToEnd method
     * as temp storage for the lists.
     */
    private String[]workList;

    /**
     * The retStr array is used to hold
     * the return list for dfs and bfs
     * methods.
     */
    private String[]retStr;

    /**
     * The rawData string array is used
     * in the createStrAdjList method and
     * is used to load the the raw list of
     * words.
     */
    private String[]rawData;

    /**
     * The adjList is the representation
     * of the adjacency list used in
     * createStrAdjList and passed to
     * mst, bfs, and dfs.
     */
    private String[][]adjList;

    /**
     * The HashMap visited is used in
     * dfs, bfs, and mst to keep track
     * of visited vertices.
     */
    private HashMap<String,Boolean>visited;

    /**
     * The largestSet arrayList is used in
     * the bfs and dfs methods that keep
     * track of the largest set.
     */
    private ArrayList<String>largestSet;

    /**
     * The inMST arrayList is used to
     * keep track of all the vertices
     * connected already.
     */
    private ArrayList<String>inMST;

    /**
     * The data ArrayList is used in
     * loadStrData to hold the data
     * loaded into the program.
     */
    private ArrayList<String>data;

    /**
     * The queue is used in bfs to
     * queue the vertices to visit.
     * (FIFO) queue used from algorithm
     * implementation.
     */
    private Queue<String>queue;

    /**
     * The stack is used in dfs to
     * stack the vertices to visit.
     * (LIFO) stack used from algorithm
     * implementation.
     */
    private Stack<String>stack;

    /**
     * The findZeroVertices is used
     * to find the words with no
     * connected vertices.
     *
     * @param adjList The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     * @return The return is the number of words
     *         with 0 vertices.
     */
    private int findZeroVertices(String[][]adjList){
        count=0;
        for(int i=0;i<adjList.length;i++){
            if(numVertices(adjList,i)==0){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param adjList The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     * @param index The index is used to pass the
     *              position in the adjList
     *              to look at.
     * @return The return is the number
     *         of vertices teh word has.
     */
    private int numVertices(String[][]adjList, int index){
        return adjList[index].length-1;
    }

    /**
     * The calculateWeight method
     * is used to calculate the
     * weight between 2 words.
     *
     * @param s1 The s1 param is used to
     *           pass the first string
     *           to compare.
     * @param s2 The s2 param is used to
     *           pass the second string
     *           to compare.
     * @return The return is the value
     *         representing the weight
     *         of the edge between the 2
     *         words.
     */
    private int calculateWeight(String s1, String s2){
        sum1=0;
        sum2=0;
        for(int i=0;i<s1.length();i++){
            sum1=sum1+Character.getNumericValue(s1.charAt(i));
            sum2=sum2+Character.getNumericValue(s2.charAt(i));
        }
        return Math.min(sum1,sum2);
    }

    /**
     * The getIndex method is used to find
     * the index of the given word in a list.
     * @param s The param s is the string
     *          to find in the list.
     * @param vertices The param vertices is
     *                 the list of vertices to
     *                 search through.
     * @return The return is the index of the
     *         given string in the list.
     */
    private int getIndex(String s, String[]vertices){
        index=-1;
        for(int i=0;i<vertices.length;i++){
            if(s.equals(vertices[i])){
                index=i;
            }
        }
        return index;
    }

    /**
     * The mst method is used to assemble a
     * minimum spanning tree of the passed
     * list of vertices. This method uses a
     * brute force form of prim's algorithm.
     * The runtime does take upward of 3 minutes
     * to return the total weight on my personal
     * machine.
     *
     * @param vertices The param vertices is the list
     *                 of interconnected vertices.
     * @param start The start string is where in
     *              the list to start the MST at.
     * @param weights The weights param is a 2d array
     *                of ints that represents the weights
     *                of moves.
     * @return The return is the total weight of the MST.
     */
    private int mst(String[]vertices, String start,int[][]weights){
        visited=new HashMap<>();
        inMST=new ArrayList<>();
        vertexName=null;
        savedVertexName=null;
        pathWeight=0;
        edgesAdded=0;

        for(int i=0;i<vertices.length;i++){
            visited.put(vertices[i],false);
        }
        visited.put(start,true);
        inMST.add(start);


        while(edgesAdded<vertices.length-1) {
            minWeightMove = 1000;
            for (int j=0;j<inMST.size();j++) {
                k = getIndex(inMST.get(j), vertices);
                for (int i=0;i<weights[k].length;i++) {
                    if (weights[k][i] < minWeightMove && weights[k][i] < 1000){
                        vertexName = vertices[i];
                        if(!visited.get(vertexName)) {
                            minWeightMove = weights[k][i];
                            savedVertexName=vertices[i];
                        }
                    }
                }
            }
            if (minWeightMove < 1000) {
                inMST.add(savedVertexName);
                pathWeight+=minWeightMove;
                visited.replace(savedVertexName,false,true);
                edgesAdded++;
            }
        }
        return pathWeight;
    }

    /**
     * The makeWeighted method takes a
     * string of vertices to create a
     * list of weights between the words.
     *
     * @param vertices The vertices parameter is
     *                 used to pass the list of
     *                 vertices.
     * @return The return is the 2d int array of
     *         weighted values.
     */
    private int[][]makeWeighted(String[]vertices){
        weighted=new int[vertices.length][vertices.length];
        for(int i=0;i<weighted.length;i++){
            Arrays.fill(weighted[i],1000);
        }
        for(int i=0;i<vertices.length;i++){
            for(int j=0;j<vertices.length;j++){
                if(editDistOne(vertices[i],vertices[j])){
                    int t=calculateWeight(vertices[i],vertices[j]);
                    weighted[i][j]=t;
                }
            }
        }
        return weighted;
    }

    /**
     * The avgNumVertices method is used to
     * find the average number of vertices in
     * the adjacency list.
     *
     * @param adjList The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     * @return The return is the double
     *         value representing the average
     *         umber of vertices in the
     *         adjacency list.
     */
    private double avgNumVertices(String[][]adjList){
        sum=0;
        for(int i=0;i<adjList.length;i++){
            sum=sum+adjList[i].length-1;
        }
        return (sum/adjList.length);
    }

    /**
     * The loadStrData is used to
     * load the words from the file
     * as a list strings.
     *
     * @param filePath The filepath param is
     *                 used to find the file
     *                 to load in from.
     * @return The return is the string array
     *         of the strings loaded into the
     *         program.
     * @throws IOException The IOException is
     *                     thrown when the file
     *                     cant be found.
     */
    private String[]loadStrData(String filePath)throws IOException {
        data = new ArrayList<>(1);
        File file = new File(getClass().getResource(filePath).getFile());
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\\n");
        while (scan.hasNext()) {
            data.add(scan.next());
        }
        scan.close();
        dataReturn = new String[data.size()];
        for (int i = 0; i < dataReturn.length; i++) {
            dataReturn[i] = data.get(i);
        }
        return dataReturn;
    }

    /**
     * The itemsWithMostVertices method
     * is used to find the items with the
     * largest number of vertices in the
     * adjacency list.
     *
     * @param adjList The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     * @return The return is the string list of items
     *         with the most number of vertices.
     */
    private String[]itemsWithMostVertices(String[][]adjList){
        maxItems=new String[1];
        max=0;
        for(int i=0;i<adjList.length;i++){
            if(max<numVertices(adjList,i)){
                maxItems=new String[1];
                maxItems[0]=adjList[i][0];
                max=numVertices(adjList,i);
            }else if(max==numVertices(adjList,i)){
                maxItems=addItemToEnd(maxItems,adjList[i][0]);
            }
        }
        System.out.println("Number of Vertices max has: "+(max));
        return maxItems;
    }

    /**
     * The addItemToEnd method is used
     * to add an item to the end of an
     * array.
     *
     * @param list The list param is used
     *             to pass the list to add
     *             to.
     * @param add The add string is used
     *            to pass the string to be
     *            added to the list.
     * @return The return is the list with
     *         the added string at the end.
     */
    private String[]addItemToEnd(String[]list,String add){
        workList=new String[list.length+1];
        i=0;
        for(i=0;i<list.length;i++){
            workList[i]=list[i];
        }
        workList[i]=add;
        return workList;
    }

    /**
     * The bfs method is used to run a breadth
     * first search on the adjacency list.
     *
     * @param adj     The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     * @param vertices The vertices param is used to
     *                 pass the list of vertices.
     * @param start The start param is used to
     *              pass where to start in the
     *              list.
     * @return The return is the list of elements
     *         discovered in the bfs.
     */
    private String[]bfs(String[][]adj,String[]vertices, String start){
        visited=new HashMap<String,Boolean>();
        queue=new LinkedList<>();
        largestSet=new ArrayList<String>();
        retStr=new String[1];
        retStr[0]=start;
        queue.add(start);
        for(int i=0;i<vertices.length;i++){
            visited.put(vertices[i],false);
        }
        visited.put(start,true);

        while(!queue.isEmpty()){
            s = queue.poll();
            k = getIndex(s,vertices);
            largestSet.add(s);

            for(int i=1;i<adj[k].length;i++){
                r =adj[k][i];
                if (!visited.get(r)){
                    queue.add(r);
                    visited.replace(r,true);
                }
            }
        }

        for (int i=1;i<largestSet.size();i++){
            retStr=addItemToEnd(retStr,largestSet.get(i));
        }

        return retStr;
    }

    /**
     *
     * @param adj     The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     * @param vertices The vertices param is used to
     *                 pass the list of vertices.
     * @param start The start param is used to
     *              pass where to start in the list.
     * @return The return is the list of elements
     *         discovered in the dfs.
     */
    private String[]dfs(String[][]adj,String[]vertices, String start){
        visited=new HashMap<>();
        stack=new Stack<>();
        largestSet=new ArrayList<>();
        retStr=new String[1];
        retStr[0]=start;
        stack.push(start);
        for(int i=0;i<vertices.length;i++){
            visited.put(vertices[i],false);
        }
        visited.put(start,true);


        while(!stack.isEmpty()){
            s = stack.pop();
            k = getIndex(s,vertices);
            largestSet.add(s);

            for(int i=1;i<adj[k].length;i++){
                r=adj[k][i];
                if (!visited.get(r)){
                    stack.push(r);
                    visited.replace(r,true);
                }
            }
        }
        for (int i=1;i<largestSet.size();i++){
            retStr=addItemToEnd(retStr,largestSet.get(i));
        }

        return retStr;
    }

    /**
     * The createStrAdjList is used to
     * create and analyze the list with
     * dfs, bfs, and mst.
     *
     * @return The return is the adjacency
     *         list representation of the
     *         data.
     */
    public String[][]createStrAdjList(){
        try {
            rawData = loadStrData("words.dat");
        }catch(IOException e){
            System.out.println("Error Getting File.");
        }
        if (rawData != null) {
            adjList=new String[rawData.length][1];
            for(int i=0;i<rawData.length;i++){
                adjList[i][0]=rawData[i];
            }
            for(int j=0;j<adjList.length;j++){
                for(int k=0;k<rawData.length;k++){
                    if(editDistOne(adjList[j][0],rawData[k])){
                        adjList[j]=addItemToEnd(adjList[j],rawData[k]);
                    }
                }
            }
        }

        analyzeAdjList(adjList);
        String[]bfs=bfs(adjList,rawData,"yodel");
        String[]dfs=dfs(adjList,rawData,"yodel");

        System.out.print("BFS: [");
        for(int i=0;i<13;i++){
            System.out.print(bfs[i]+", ");
        }
        System.out.println("...]");
        System.out.print("DFS: [");
        for(int i=0;i<13;i++){
            System.out.print(dfs[i]+", ");
        }
        System.out.println("...]");
        System.out.println("Size of Largest Connected Set: "+bfs.length);
        System.out.println("Contents of Largest Set:");
        System.out.print("[");
        for(int i=1;i<dfs.length+1;i++){
            System.out.print(dfs[i-1]+", ");
            if(i%21==0){
                System.out.println();
            }
        }
        System.out.print("]");
        System.out.println();
        minWeight=mst(bfs,"pills",makeWeighted(bfs));
        System.out.println("Minimum Spanning Tree Weight: "+minWeight);
        return adjList;
    }

    /**
     * The editDistanceOne method is used
     * to determine if two strings have
     * edit distance one.
     *
     * @param string1 The string1 param is used to
     *                pass the first string to compare.
     * @param string2 The string2 param is used to
     *                pass the second string to compare.
     * @return The return is true if the edit distance is
     *         one, false otherwise.
     */
    private boolean editDistOne(String string1, String string2){
        h=string1.length();
        i=string2.length();
        j=0;
        k=0;
        count=0;
        while(j<h && k<i){
            if(string1.charAt(j)!=string2.charAt(k)){
                count++;
                if(2<=count){
                    return false;
                }else{
                    j++;
                    k++;
                }
            }else{
                j++;
                k++;
            }
        }
        if(count==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param adjList The adjList param is used
     *                to hold the adjacency list
     *                representation of the set.
     */
    private void analyzeAdjList(String[][]adjList){
        maxItems=itemsWithMostVertices(adjList);
        System.out.println("Number of Vertices with 0 items: "+findZeroVertices(adjList));
        System.out.println("Average Number of Vertices: "+avgNumVertices(adjList));
        System.out.print("Items with the most Vertices: ");
        for(int i=0;i<maxItems.length;i++){
            System.out.print(maxItems[i]+", ");
        }
        System.out.println();
    }

}
