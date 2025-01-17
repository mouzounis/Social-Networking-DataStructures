import java.util.HashMap;

public class Testing extends Graph {

    public Testing(boolean inputIsDirected) {
        super(inputIsDirected);
    }

    public static void main(String[] args) {

        int numUsers = 1000;

        // Declaring the Network
        Graph userNetwork = new Graph(true);

        // Creating Users.
        // boolean gender1 = Names.randGender();
        // Vertex user1 = userNetwork
        //         .addUser(new Users(Names.randFirstName(gender1), Names.randLastName(gender1), Names.randCity(),
        //                 Names.randAge(), Names.randHeight(), gender1, Names.randInterests()));

        // boolean gender2 = Names.randGender();
        // Vertex user2 = userNetwork
        //         .addUser(new Users(Names.randFirstName(gender2), Names.randLastName(gender2), Names.randCity(),
        //                 Names.randAge(), Names.randHeight(), gender2, Names.randInterests()));

        // boolean gender3 = Names.randGender();
        // Vertex user3 = userNetwork
        //         .addUser(new Users(Names.randFirstName(gender3), Names.randLastName(gender3), Names.randCity(),
        //                 Names.randAge(), Names.randHeight(), gender3, Names.randInterests()));

        // boolean gender4 = Names.randGender();
        // Vertex user4 = userNetwork
        //         .addUser(new Users(Names.randFirstName(gender4), Names.randLastName(gender4), Names.randCity(),
        //                 Names.randAge(), Names.randHeight(), gender4, Names.randInterests()));

        // boolean gender5 = Names.randGender();
        // Vertex user5 = userNetwork
        //         .addUser(new Users(Names.randFirstName(gender5), Names.randLastName(gender5), Names.randCity(),
        //                 Names.randAge(), Names.randHeight(), gender5, Names.randInterests()));

        // Adding connections between users (Friendships)
        // userNetwork.addConnection(user1, user2);
        // userNetwork.addConnection(user1, user3);
        // userNetwork.addConnection(user1, user4);
        // userNetwork.addConnection(user2, user4);
        // userNetwork.addConnection(user4, user5);

        // Returns all Connections between all users
        // userNetwork.print();

        // System.out.println(user1.getData().printFullName());
        // System.out.println("\n");
        // System.out.println(user1.getData().toString());

        // Removing connection between user1 and user2
        //userNetwork.removeConnectedUsers(user1, user2);

        // printing what interests user 1 and user 2 has and then what interests they share
        // System.out.println(user1.getData().getInterestsArrayList().toString() +
        // "Interests of user 1");
        // System.out.println(user2.getData().getInterestsArrayList().toString() +
        // "Interests of user 2");
        // System.out.println(getSharedInterests(user1, user2).toString() + " Shared
        // Interests");

        // Testing the generateRecommendations method with 100 users;

        long start = System.currentTimeMillis();

        //Genarates Users

        for (int i = 0; i <= numUsers; i++) {
            boolean gender = randGender();
            Vertex userID = userNetwork
                    .addUser(new Users(Names.randFirstName(gender), Names.randLastName(gender), Names.randCity(), Names.randAge(), Names.randHeight(), gender, Names.randInterestsFixedSize()));
            Graph.addUserToMap("user" + i, userID);
            //System.out.println(getUserMap().get("user" + i).getData().printFullName());
        }

        long end = System.currentTimeMillis();
        
        
        Vertex user = getUserMap().get("user1");
        //Returns user1 Age, height and Interests
        //System.out.println(user.getData().getAge().toString() + " " + user.getData().getHeight());
        // System.out.println(user.getData().getInterestsArrayList().toString());
    

        //Printing the Recommendation List with the users First and Last name as well their match score
        HashMap<Vertex, Integer> map = generateRecommendations(user);
        map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry -> { //In help with AI
            Vertex v = entry.getKey();
            Integer score = entry.getValue();
            System.out.println(v.getData().printFullName() + " - Recommendation Score: " + score + "\n");
        });

        //Printing the Runtime in ms
        System.out.println(numUsers + " Users " + (end - start) + " ms");
    }

}
