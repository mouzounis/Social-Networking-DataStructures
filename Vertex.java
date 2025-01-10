import java.util.ArrayList;

public class Vertex {

	private Users user;
	private ArrayList<Edge> edges;

	public Vertex(Users user) {
		this.user = user;
		this.edges = new ArrayList<Edge>();
	}

	public void addEdge(Vertex endVertex) {
		this.edges.add(new Edge(this, endVertex));
	}

	public void removeConnectedUsers(Vertex endVertex) {
		this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
	}

	public Users getData() {
		return this.user;
	}

	public ArrayList<Users> getConnectedUsers() {
		ArrayList<Users> connectedUsers = new ArrayList<>();
		for (Edge edge : this.edges) {
			connectedUsers.add(edge.getEnd().getData());
		}
		return connectedUsers;
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

	public void prints() {
		String message = "";

		if (this.edges.size() == 0) {
			System.out.println(this.user.toString() + " -->");
			return;
		}

		for (int i = 0; i < this.edges.size(); i++) {
			if (i == 0) {
				message += this.edges.get(i).getStart().user.toString() + " -->  ";
			}

			message += this.edges.get(i).getEnd().user.toString();

			if (i != this.edges.size() - 1) {
				message += ", ";
			}
		}
		System.out.println(message);
	}
}
