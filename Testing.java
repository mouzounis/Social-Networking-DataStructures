public class Testing extends Graph {

    public Testing(boolean inputIsDirected) {
        super(inputIsDirected);
    }

    public static void main(String[] args) {

        // Declaring the Network
        Graph userNetwork = new Graph(true);

        //Creating Users.
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


        // Adding connections between users (Friendships)
        userNetwork.addConnection(user1, user2);
        userNetwork.addConnection(user1, user3);
        userNetwork.addConnection(user1, user4);
        userNetwork.addConnection(user2, user4);
        userNetwork.addConnection(user4, user5);

        //userNetwork.print();

        System.out.println(user1.getData().printFullName());
        System.out.println("\n");
        System.out.println(user1.getData().toString());

        // Removing connection between user1 and user2
        userNetwork.removeConnectedUsers(user1, user2);


        // printing what interests user 1 and user 2 has and then what interests they share

        // System.out.println(user1.getData().getInterestsArrayList().toString() +
        // "Interests of user 1");
        // System.out.println(user2.getData().getInterestsArrayList().toString() +
        // "Interests of user 2");
        // System.out.println(getSharedInterests(user1, user2).toString() + " Shared
        // Interests");

        //Testing the generateRecommendations method with 100 users;
        for(int i = 0 ; i<101; i++){ // we can use HashMap
            Vertex userID = userNetwork
            .addUser(new Users(Names.randFirstName(true), Names.randLastName(true), Names.randCity(),
                Names.randAge(), Names.randHeight(), true, Names.randInterests()));
            Graph.addUserToMap("user"+ i, userID);
        }
        System.out.println(Graph.getUserMap());
    }

}
