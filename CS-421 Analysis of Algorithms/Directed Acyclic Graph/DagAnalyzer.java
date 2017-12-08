import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * 
 * @author eric miller Analyzes Activity DAG for earliest completion time,
 *         latest completion time, and slack time.
 *
 */
public class DagAnalyzer {
	public static void printUsage() {
		System.out.println("Program requires 1 argument: filename of file containing activity node graph data");
	}

	static void topologicalSort(int v, Boolean visited[], ArrayList<Activity> sortedList, ArrayList<Activity> graph) {
		visited[v] = true;
		Activity a;

		ListIterator<Activity> it = graph.listIterator();
		while (it.hasNext()) {
			a = it.next();
			if (!visited[a.getActIndex()])
				topologicalSort(a.getActIndex(), visited, sortedList, graph);
		}
		sortedList.add(0, graph.get(v));
	}

	public static void main(String[] args) {
		String fileName = "";
		ArrayList<Activity> graph = new ArrayList<Activity>();
		Graph g = new Graph();

		if (args.length != 1) {
			printUsage();
			System.exit(1);
		}
		try {
			fileName = args[0];
		} catch (Exception e) {
			e.printStackTrace();
		}

		String line;
		ArrayList<String> activities = new ArrayList<String>();
		try (Scanner scan = new Scanner(new File(fileName))) {
			line = scan.nextLine();
			line = line.replaceAll("\\s+", "");
			int numActivities = line.length();
			for (int i = 0; i < numActivities; i++) {
				activities.add(line.charAt(i) + "");
			}
			for (int i = 0; i < activities.size(); i++) {
				graph.add(new Activity(i, activities.get(i)));
			}

			int lineNumber = -1;
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				lineNumber++;
				int jNode = 0;
				for (int i = 1; i < line.length(); i++) {
					if ((line.charAt(i) + "").equals("-")) {
						i++;
						jNode++;
					} else if (line.charAt(i) == ' ') {

					} else {
						graph.get(jNode).setTime(Integer.parseInt(line.charAt(i) + ""));
						graph.get(lineNumber).addOutgoing(graph.get(jNode));
						jNode++;
					}
				}
			}
			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Activity> topolOrder = new ArrayList<Activity>();

		Boolean visited[] = new Boolean[activities.size()];
		for (int i = 0; i < activities.size(); i++) {
			visited[i] = false;
		}

		for (int i = 0; i < activities.size(); i++)
			if (visited[i] == false) {
				topologicalSort(i, visited, topolOrder, graph);
			}
		// add incoming
		for (Activity a : topolOrder) {
			for (Activity i : a.getOutgoing()) {
				graph.get(i.getActIndex()).addIncoming(a);
			}
		}

		// add to Graph g
		for (Activity a : topolOrder) {
			g.addActivity(a);
		}

		// add dummies
		ArrayList<Activity> needsDummy = new ArrayList<Activity>();

		for (Activity a : topolOrder) {
			if (a.getIncoming().size() > 1) {
				needsDummy.add(a);
			}
		}
		ArrayList<Activity> newGraph = new ArrayList<Activity>();
		// copy graph to new graph
		for (Activity a : graph) {
			newGraph.add(a);
		}

		// HERE
		for (int i = needsDummy.size() - 1; i >= 0; i--) {
			g.addActivityBefore(new Activity(-1, needsDummy.get(i).getName() + "'"), needsDummy.get(i));
		}

		g.updateEarliestTimes();
		g.updateLatestTimes();
		System.out.println("Activity\tEC\tLC\tSlackTime");
		System.out.println("----------------------------------------");
		ListIterator<Activity> it = g.getIterator();
		Activity act;
		while (it.hasNext()) {
			act = it.next();
			if (!act.getName().contains("'")) {
				System.out.println(act.getName() + "\t\t" + act.getEarliestTime() + "\t" + act.getLatestTime() + "\t"
						+ act.getSlackTime());
			}
			// System.out.println("Incoming: ");
			// for (Activity i : act.getIncoming()) {
			// System.out.print(i.getName() + " (" + i.getTime() + "), ");
			// }
			// System.out.println("\nOutgoing: ");
			// for (Activity o : act.getOutgoing()) {
			// System.out.print(o.getName() + " (" + o.getTime() + "), ");
			// }

		}

	}

}
