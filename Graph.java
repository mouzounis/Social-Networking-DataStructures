import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    public static HashMap<Vertex, Integer> generateRecommendations(Vertex userID) {
        HashMap<Vertex, Integer> recommendations = new HashMap<>();
        Users user = userID.getData();

        HashSet<String> userInterestsSet = new HashSet<>(user.getInterestsArrayList());
        Boolean userGender = user.getGender();

        for (Map.Entry<String, Vertex> entry : userMap.entrySet()) {
            Vertex v = entry.getValue();
            Users otherUser = v.getData();
            
            // Skip the current user
            if (userID.equals(v)) {
                continue;
            }
            
            int points = 0;

            // Check for age similarity
            Integer otherUserAge = otherUser.getAge();
            Integer userAge = user.getAge();
            if (userAge != null && otherUserAge != null) {
                if (Math.abs(userAge - otherUserAge) <= 5) {
                    points++;
                }
            }

            // Check for height similarity
            Integer otherUserHeight = otherUser.getHeight();
            Integer userHeight = user.getHeight();
            if (userHeight != null && otherUserHeight != null) {
                if (Math.abs(userHeight - otherUserHeight) <= 20) {
                    points++;
                }
            }

            // Check for gender difference
            if (!userGender.equals(otherUser.getGender())) {
                HashSet<String> otherUserInterestsSet = new HashSet<>(otherUser.getInterestsArrayList());
                otherUserInterestsSet.retainAll(userInterestsSet);
                points += otherUserInterestsSet.size(); // Size of intersection set
            }

            recommendations.put(v, points);

        }
        return recommendations.entrySet() // with the help of AI
                .stream()
                .sorted(Map.Entry.<Vertex, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), HashMap::putAll);
    }

    public static void addUserToMap(String userID, Vertex vertex) {
        userMap.put(userID, vertex);
    }

    public static Map<String, Vertex> getUserMap() {
        return userMap;
    }

}
