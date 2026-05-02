# Social Network Graph - README

## **Project Overview**
This project simulates a social network system using Java. It models users as vertices in a graph and their connections (friendships) as edges. The project supports operations such as adding/removing users, creating connections, traversing the graph, and recommending friends based on shared interests.

## **Project Structure**
The following files constitute the project:

### **1. `Names.java`**
- **Purpose:** Provides random data generation for user attributes like first names, last names, cities, and interests.
- **Key Methods:**
  - `randFirstName(boolean gender)`: Generates a random first name based on gender.
  - `randLastName(boolean gender)`: Generates a random last name.
  - `randCity()`: Returns a random city name.
  - `randAge()`: Returns a random age.
  - `randInterests()`: Generates a random list of user interests.

---

### **2. `Users.java`**
- **Purpose:** Represents a user in the network.
- **Attributes:**
  - `firstName`, `lastName`, `city`, `age`, `height`, `gender`, and `interests`.
- **Key Methods:**
  - `getFirstName()`, `setFirstName()`, etc.
  - `addInterest()`, `removeInterest()`: Manage user interests.
  - `toString()`: Returns a string representation of the user.

---

### **3. `Vertex.java`**
- **Purpose:** Represents a node (user) in the graph.
- **Attributes:**
  - `user` (an instance of `Users`).
  - `edges` (connections to other vertices).
- **Key Methods:**
  - `addEdge(Vertex)`: Adds a connection.
  - `removeConnectedUsers(Vertex)`: Removes a connection.
  - `getData()`: Returns the `Users` object.

---

### **4. `Edge.java`**
- **Purpose:** Represents an edge (friendship) between two vertices.
- **Attributes:**
  - `start`: The start vertex.
  - `end`: The end vertex.
- **Key Methods:**
  - `getStart()`, `getEnd()`: Retrieve the vertices connected by this edge.

---

### **5. `Graph.java`**
- **Purpose:** Represents the entire social network graph.
- **Attributes:**
  - `vertices`: A list of `Vertex` instances.
  - `userMap`: A map of user IDs to vertices.
  - `isDirected`: Indicates if the graph is directed.
- **Key Methods:**
  - `addUser(Users)`: Adds a user to the graph.
  - `addConnection(Vertex, Vertex)`: Adds a connection (friendship).
  - `removeConnectedUsers(Vertex, Vertex)`: Removes a connection.
  - `generateRecommendations(Vertex)`: Recommends friends based on shared interests.

---

### **6. `Node.java`**
- **Purpose:** Represents a node in a linked list.
- **Attributes:**
  - `data`: A `Vertex` instance.
  - `next`: A reference to the next `Node`.
- **Key Methods:**
  - `getNextNode()`, `setNextNode()`: Manage the next node reference.

---

### **7. `LinkedList.java`**
- **Purpose:** A simple linked list implementation for vertices.
- **Attributes:**
  - `head`: The first node in the list.
- **Key Methods:**
  - `addToHead(Vertex)`, `addToTail(Vertex)`: Add vertices to the list.
  - `removeHead()`: Remove the first vertex in the list.

---

### **8. `GraphTraverser.java`**
- **Purpose:** Implements graph traversal algorithms.
- **Key Methods:**
  - `depthFirstTraversal(Vertex, ArrayList<Vertex>)`: Depth-first traversal.
  - `breadthFirstSearch(Vertex, ArrayList<Vertex>)`: Breadth-first search.

---

### **9. `Testing.java`**
- **Purpose:** Contains the main method for running and testing the graph operations.
- **Key Functionalities:**
  - Adds sample users to the network.
  - Tests connections and shared interests.
  - Runs the recommendation system.

## **How to Run the Project**
1. Compile all Java files using `javac *.java`.
2. Run the `Testing` class using `java Testing`.
3. Observe the printed output showing graph traversal, connections, and recommendations.

## **Key Features**
- **User Creation:** Automatic generation of users with random names, ages, interests, etc.
- **Friendship Management:** Add and remove connections between users.
- **Recommendations:** Suggests friends based on shared interests.
- **Graph Traversal:** Supports DFS and BFS for exploring the social network.

## **Future Enhancements**
- Add GUI support for visualizing the social network.
- Improve performance for large graphs.
- Add weight to edges to represent strength of relationships.

## **Dependencies**
- Java 8 or higher.

## **Contributors**
Feel free to add your name if you contribute to the project.

---
This README file summarizes the structure and purpose of each component in the project for easier understanding and navigation.

