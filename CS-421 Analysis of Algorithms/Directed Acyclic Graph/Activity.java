import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author eric miller Represents activity in DAG
 *
 */
public class Activity {
	private Set<Activity> incoming = new HashSet<Activity>();
	private Set<Activity> allPreceding = new HashSet<Activity>();
	private Set<Activity> outgoing = new HashSet<Activity>();
	private int time, earliestTime, latestTime, slackTime, actIndex;
	private String name;

	public Activity(int actIndex, String name) {
		this.actIndex = actIndex;
		this.name = name;
		this.time = time;
		this.earliestTime = -1;
		this.latestTime = -1;
		this.slackTime = -1;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setEarliestTime(int time) {
		this.earliestTime = time;
	}

	public int getEarliestTime() {
		return this.earliestTime;
	}

	public void setLatestTime(int time) {
		this.latestTime = time;
	}

	public int getLatestTime() {
		return this.latestTime;
	}

	public int getSlackTime() {
		return this.latestTime - this.earliestTime;
	}

	public void addIncoming(Activity a) {
		this.incoming.add(a);
		this.allPreceding.add(a);
		for (Activity i : a.getIncoming()) {
			this.allPreceding.add(i);
			for (Activity p : i.getAllPreceding()) {
				this.allPreceding.add(p);
			}
		}
	}

	public void addOutgoing(Activity a) {
		this.outgoing.add(a);
	}

	public void removeOutgoingActivity(Activity a) {
		this.outgoing.remove(a);
	}

	public void clearIncoming() {
		this.incoming.clear();
	}

	public void incrementIndex() {
		this.actIndex++;
	}

	public void updateActivityIndices() {
		if (getOutgoing().isEmpty()) {
			incrementIndex();
		}
		for (Activity o : getOutgoing()) {
			o.updateActivityIndices();
		}
	}

	public int getActIndex() {
		return this.actIndex;
	}

	public Set<Activity> getIncoming() {
		return this.incoming;
	}

	public Set<Activity> getOutgoing() {
		return this.outgoing;
	}

	public Set<Activity> getAllPreceding() {
		return this.allPreceding;
	}

	public int getTime() {
		return this.time;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.actIndex + ": " + this.time;
	}
}
