package shop;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;
import model.Expense;
import model.Group;
import model.User;
import spark.Spark;

public class Api {

	public static UserService userService = new UserService();
	public static GroupService groupService = new GroupService();

	public static void main(String[] args){

		Spark.port(4567); // Set your desired port number

		Gson gson = new Gson();

		// Add User API
		post("/addUser", (req, res) -> {
			res.type("application/json");
			User user = gson.fromJson(req.body(), User.class);
			return userService.addUser(user);
		}, gson::toJson);


		// List Users API
		get("/listUsers", (req, res) -> {
			res.type("application/json");
			return userService.getAllUsers();
		}, gson::toJson);

		// Create Group API
		post("/createGroup", (req, res) -> {
			res.type("application/json");
			Group group = gson.fromJson(req.body(), Group.class);
			return groupService.createGroup(group);
		}, gson::toJson);

		// Add Expense to Group API
		post("/addExpense", (req, res) -> {
			res.type("application/json");
			Expense expense = gson.fromJson(req.body(), Expense.class);
			return groupService.addExpense(expense);
		}, gson::toJson);

		// List Groups API
		get("/listGroups", (req, res) -> {
			res.type("application/json");
			return groupService.listGroups();
		}, gson::toJson);

		// Show Users Balance API
		get("/showBalance", (req, res) -> {
			res.type("application/json");
			return userService.showUsersBalance();
		}, gson::toJson);

		// List Users in a Group API
		get("/listUsersInGroup/:groupId", (req, res) -> {
			res.type("application/json");
			String groupId = req.params(":groupId");
			return groupService.listUsersInGroup(groupId);
		}, gson::toJson);
		// Start the Spark server
		Spark.awaitInitialization();

	}
}
