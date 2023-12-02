package model;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Expense {

    @Id
    private ObjectId id;
    private float amount;
    private Group group;

    // Constructors

    // Getter methods
    public ObjectId getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public Group getGroup() {
        return group;
    }

    // Setter methods
    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}


