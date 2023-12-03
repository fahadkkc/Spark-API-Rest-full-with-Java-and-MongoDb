package splitwise;

import model.Expense;
import model.Group;
import model.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import java.util.List;

public class GroupService {

    private MongoClient client = new MongoClient("localhost", 27017);
    private Datastore datastore = new Morphia().createDatastore(client, "splitwise-collection");

    public String createGroup(Group group){
        datastore.save(group);
        return "Group created";
    }

    public String addExpense(Expense expense) {

        float expensePerUser = expense.getAmount() / expense.getGroup().getMembers().size();

        for (User member : expense.getGroup().getMembers()) {
            member.setExpense(member.getExpense() + expensePerUser);
            datastore.save(member);
        }

        // Save the updated group with the new expense
        expense.getGroup().getMembers().forEach(datastore::save);
        datastore.save(expense.getGroup());

        // Save the expense
        datastore.save(expense);

        return "Expense added and divided among group members";
    }

    public List<Group> listGroups(){
        return datastore.find(Group.class).asList();
    }

    public List<User> listUsersInGroup(String groupId) {
        Group group = datastore.get(Group.class, groupId);
        if (group != null) {
            return group.getMembers();
        } else {
            return null;
        }
    }
}
