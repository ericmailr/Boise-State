import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author eric miller Graph of activities in DAG
 */
public class Graph {
	private LinkedList<Activity> graph;

	public Graph() {
		this.graph = new LinkedList<Activity>();
	}

	public void addActivity(Activity a) {
		this.graph.add(a);
	}

	public void addActivityBefore(Activity d, Activity a) {
		ListIterator<Activity> it = this.graph.listIterator();
		Activity temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.equals(a)) {
				d.setTime(0);
				for (Activity i : getActivity(a).getIncoming()) {
					i.addOutgoing(d);
					i.removeOutgoingActivity(a);
					d.addIncoming(i);
				}
				d.addOutgoing(getActivity(a));
				getActivity(a).clearIncoming();
				getActivity(a).addIncoming(d);

				it.previous();
				it.add(d);
				break;
			}
		}
	}

	public Activity getActivity(Activity a) {
		ListIterator<Activity> it = this.graph.listIterator();
		Activity temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.equals(a)) {
				return temp;
			}
		}
		return null;
	}

	public ListIterator<Activity> getIterator() {
		return this.graph.listIterator();
	}

	public void updateEarliestTimes() {
		ListIterator<Activity> it = this.graph.listIterator();
		Activity temp;
		while (it.hasNext()) {
			temp = it.next();
			// if no preceding activities, set earliest finish time to its own
			// completion time
			if (temp.getIncoming().size() == 0) {
				temp.setEarliestTime(temp.getTime());
			} else if (temp.getIncoming().size() == 1) {
				Iterator<Activity> it2 = temp.getIncoming().iterator();
				temp.setEarliestTime(it2.next().getEarliestTime() + temp.getTime());
			} else {
				int max = 0;
				int tempTime;
				Iterator<Activity> it3 = temp.getIncoming().iterator();
				while (it3.hasNext()) {
					tempTime = it3.next().getEarliestTime();
					if (tempTime > max) {
						max = tempTime;
					}
				}
				temp.setEarliestTime(max + temp.getTime());

			}
		}
	}

	public void updateLatestTimes() {
		ListIterator<Activity> it = this.graph.listIterator();
		Activity temp;
		while (it.hasNext()) {
			it.next();
		}
		while (it.hasPrevious()) {
			temp = it.previous();
			// if no succeeding activities, set latest finish time to its own
			// earliest completion time
			if (temp.getOutgoing().size() == 0) {
				temp.setLatestTime(temp.getEarliestTime());
			} else if (temp.getOutgoing().size() == 1) {
				Activity doop;
				Iterator<Activity> it2 = temp.getOutgoing().iterator();
				doop = it2.next();
				temp.setLatestTime(doop.getLatestTime() - doop.getTime());
			} else {
				int min = 10000;
				int tempTime;
				Activity doop;
				Iterator<Activity> it3 = temp.getOutgoing().iterator();
				while (it3.hasNext()) {
					doop = it3.next();
					tempTime = doop.getLatestTime() - doop.getTime();
					if (tempTime < min) {
						min = tempTime;
					}
				}
				temp.setLatestTime(min);

			}
		}
	}

	public String toString() {
		String ret = "";
		for (Activity a : this.graph) {
			ret += (a.getName() + ": " + a.getTime() + "\n");
		}
		return ret;
	}
}
