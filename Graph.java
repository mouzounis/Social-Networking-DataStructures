import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph extends Names {

    private static ArrayList<Vertex> vertices;
    private boolean isDirected;
    private static Map<String, Vertex> userMap = new HashMap<>();

    public Graph(boolean inputIsDirected) {
        vertices = new ArrayList<Vertex>();
        this.isDirected = inputIsDirected;
    }

    public Vertex addUser(Users user) {
        Vertex newVertex = new Vertex(user);
        vertices.add(newVertex);
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
        vertices.remove(userID);
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

    public static ArrayList<Vertex> generateRecommendations(Vertex userID) {
        ArrayList<Vertex> recommendations = new ArrayList<>();
        ArrayList<Integer> pointsList = new ArrayList<>();
        Users user = userID.getData();
        ArrayList<String> userInterests = user.getInterestsArrayList();
        boolean userGender = user.getGender();

        for (Map.Entry<String, Vertex> entry : userMap.entrySet()) {
            Vertex v = entry.getValue();
            Users otherUser = v.getData();
            //if (otherUser.getGender() != userGender) {
                ArrayList<String> otherUserInterests = otherUser.getInterestsArrayList();
                int points = 0;
                for (String interest : userInterests) {
                    if (otherUserInterests.contains(interest)) {
                        points++;
                    }
                }
                recommendations.add(v);
                pointsList.add(points);
            //}
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

    public static void addUserToMap(String userID, Vertex vertex) {
        userMap.put(userID, vertex);
    }

    public static Map<String, Vertex> getUserMap() {
        return userMap;
    }

    public static void main(String[] args) {
        // Declaring the Network
        Graph userNetwork = new Graph(true);

        // Creating the users
        Vertex user1 = userNetwork
                .addUser(new Users(Names.randFirstName(true), Names.randLastName(true), Names.randCity(),
                        Names.randAge(), Names.randHeight(), true, Names.randInterests()));
        Vertex user2 = userNetwork
                .addUser(new Users(Names.randFirstName(true), Names.randLastName(true), Names.randCity(),
                        Names.randAge(), Names.randHeight(), true, Names.randInterests()));
        Vertex user3 = userNetwork
                .addUser(new Users(Names.randFirstName(true), Names.randLastName(true), Names.randCity(),
                        Names.randAge(), Names.randHeight(), true, Names.randInterests()));
        Vertex user4 = userNetwork
                .addUser(new Users(Names.randFirstName(true), Names.randLastName(true), Names.randCity(),
                        Names.randAge(), Names.randHeight(), true, Names.randInterests()));
        Vertex user5 = userNetwork
                .addUser(new Users(Names.randFirstName(true), Names.randLastName(true), Names.randCity(),
                        Names.randAge(), Names.randHeight(), true, Names.randInterests()));
    }

}