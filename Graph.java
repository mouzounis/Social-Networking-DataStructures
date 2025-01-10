import java.util.ArrayList;
import java.util.Arrays;

public class Graph extends Names {

    private ArrayList<Vertex> vertices;
    private boolean isDirected;

    public Graph(boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isDirected = inputIsDirected;
    }

    public Vertex addUser(Users user) {
        Vertex newVertex = new Vertex(user);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addConnection(Vertex user1ID, Vertex user2ID) {
        user1ID.addEdge(user2ID);
        if (!this.isDirected) {
            user2ID.addEdge(user1ID);
        }
    }

    public void removeConnectedUsers(Vertex user1ID, Vertex user2ID) {
        user1ID.removeConnectedUsers(user2ID);
        if (!this.isDirected) {
            user2ID.removeConnectedUsers(user1ID);
        }
    }

    public void removeUser(Vertex userID) {
        this.vertices.remove(userID);
    }

    public ArrayList<Users> getUsers() {
        ArrayList<Users> users = new ArrayList<>();
        for (Vertex vertex : vertices) {
            users.add(vertex.getData());
        }
        return users;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public static ArrayList<String> getSharedInterests(Vertex user1, Vertex user2) {
        ArrayList<String> sharedInterests = new ArrayList<>();

        for (String interest : user1.getData().getInterestsArrayList()) {
            if (user2.getData().getInterestsArrayList().contains(interest)) {
                sharedInterests.add(interest);
            }
        }

        return sharedInterests;
    }

    public void print() {
        for (Vertex v : vertices) {
            v.prints();
        }
    }

    public ArrayList<Vertex> generateRecommendations(Vertex userID) {
        ArrayList<Vertex> recommendations = new ArrayList<>();
        ArrayList<Integer> pointsList = new ArrayList<>();
        Users user = userID.getData();
        ArrayList<String> userInterests = user.getInterestsArrayList();
        boolean userGender = user.getGender();

        for (Vertex v : this.vertices) {
            Users otherUser = v.getData();
            if (otherUser.getGender() != userGender) {
                ArrayList<String> otherUserInterests = otherUser.getInterestsArrayList();
                int points = 0;
                for (String interest : userInterests) {
                    if (otherUserInterests.contains(interest)) {
                        points++;
                    }
                }
                recommendations.add(v);
                pointsList.add(points);
            }
        }

        // Sort recommendations based on points in descending order
        for (int i = 0; i < pointsList.size() - 1; i++) {
            for (int j = 0; j < pointsList.size() - i - 1; j++) {
                if (pointsList.get(j) < pointsList.get(j + 1)) {
                    int tempPoints = pointsList.get(j);
                    pointsList.set(j, pointsList.get(j + 1));
                    pointsList.set(j + 1, tempPoints);

                    Vertex tempVertex = recommendations.get(j);
                    recommendations.set(j, recommendations.get(j + 1));
                    recommendations.set(j + 1, tempVertex);
                }
            }
        }

        // Limit to top 10 matches
        if (recommendations.size() > 10) {
            recommendations = new ArrayList<>(recommendations.subList(0, 10));
        }

        return recommendations;
    }

    public static void main(String[] args) {

        Graph userNetwork = new Graph(true);
        Vertex user1 = null;
        Vertex user2 = null;
        Vertex user3 = null;
        Vertex user4 = null;

        String maleFirstName = Names.randFirstName(true);
        String maleLastName = Names.randLastName(true);
        ArrayList<String> interests1 = Names.randInterests();
        String city1 = Names.randCity();
        Integer age1 = Names.randAge();
        Integer height1 = Names.randHeight();
        user1 = userNetwork.addUser(new Users(maleFirstName, maleLastName, city1, age1, height1, true, interests1));

        String maleFirstName1 = Names.randFirstName(false);
        String maleLastName1 = Names.randLastName(false);
        ArrayList<String> interests2 = Names.randInterests();
        String city11 = Names.randCity();
        Integer age11 = Names.randAge();
        Integer height11 = Names.randHeight();
        user2 = userNetwork.addUser(new Users(maleFirstName1, maleLastName1, city11, age11, height11, false, interests2));

        String maleFirstName2 = Names.randFirstName(true);
        String maleLastName2 = Names.randLastName(true);
        ArrayList<String> interests3 = Names.randInterests();
        String city13 = Names.randCity();
        Integer age13 = Names.randAge();
        Integer height13 = Names.randHeight();
        user3 = userNetwork.addUser(new Users(maleFirstName2, maleLastName2, city13, age13, height13, true, interests3));

        String maleFirstName4 = Names.randFirstName(false);
        String maleLastName4 = Names.randLastName(false);
        ArrayList<String> interests4 = Names.randInterests();
        String city14 = Names.randCity();
        Integer age14 = Names.randAge();
        Integer height14 = Names.randHeight();
        user4 = userNetwork.addUser(new Users(maleFirstName4, maleLastName4, city14, age14, height14, false, interests4));

        userNetwork.addConnection(user1, user2);
        userNetwork.addConnection(user1, user3);
        userNetwork.addConnection(user1, user4);

        System.out.println(user3.getData().getInterestsArrayList().toString() + "Interests of user 3");
        
        System.out.println(user3.getData().getInterestsArrayList().toString() + "Interests of user 3");

        // System.out.println(getSharedInterests(user1, user2).toString()+ " Shared
        // Interests");

        // for(int i=0; i<20; i++){
        // String maleFirstName = Names.randFirstName(true);
        // String maleLastName = Names.randLastName(true);
        // ArrayList<String> interests1 = Names.randInterests();
        // String city1 = Names.randCity();
        // Integer age1 = Names.randAge();
        // Integer height1 = Names.randHeight();
        // user1 = userNetwork.addUser(new Users(maleFirstName, maleLastName, city1,
        // age1, height1, true, interests1));
        // String femaleFirstName = Names.randFirstName(false);
        // String femaleLastName = Names.randFirstName(false);
        // ArrayList<String> interests2 = Names.randInterests();
        // String city2 = Names.randCity();
        // Integer age2 = Names.randAge();
        // Integer height2 = Names.randHeight();
        // user2 = userNetwork.addUser(new Users(femaleFirstName,femaleLastName, city2,
        // age2, height2, false, interests2));
        // //userNetwork.addConnection(user1, user2);
        // }
        // //userNetwork.print();
        // ArrayList<Vertex> recommend = userNetwork.generateRecommendations(user1);
        // for(int j=0;j<recommend.size();j++){
        // //recommend.get(j).getData();
        // System.out.println(recommend.get(j).getData());
        // }

    }

}