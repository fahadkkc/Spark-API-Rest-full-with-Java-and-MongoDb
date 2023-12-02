package shop;

import java.util.ArrayList;
import java.util.List;

import model.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class UserService {

	
	MongoClient client = new MongoClient("localhost", 27017); //connect to mongodb
	Datastore datastore = new Morphia().createDatastore(client, "splitwise-collection");
	
	public String addUser(User user){
		datastore.save(user);
		return "User added";
	}
	
	public List<User> getAllUsers(){
		List<User> list = datastore.find(User.class).asList();
		if(list != null){
			return list;
		}
		return null;
	}

	public List<UserBalance> showUsersBalance(){
		List<User> users = datastore.find(User.class).asList();
		List<UserBalance> userBalances = new ArrayList<>();

		for (User user : users) {
			UserBalance userBalance = new UserBalance(user.getName(), user.getExpense());
			userBalances.add(userBalance);
		}

		return userBalances;
	}
	
}
