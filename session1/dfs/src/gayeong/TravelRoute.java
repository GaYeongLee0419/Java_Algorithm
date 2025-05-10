package gayeong;

import java.util.*;

public class TravelRoute {
    private List<String> bestRoute = null;
    private String[][] tickets;
    private boolean[] used;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.used = new boolean[tickets.length];

        List<String> route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", route, 0);

        return bestRoute.toArray(new String[0]);
    }

    private void dfs(String current, List<String> route, int depth) {
        if (depth == tickets.length) {
            if (bestRoute == null || compareRoutes(route, bestRoute) < 0) {
                bestRoute = new ArrayList<>(route);
            }

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);

                dfs(tickets[i][1], route, depth + 1);

                used[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }

    private int compareRoutes(List<String> a, List<String> b) {
        for (int i = 0; i < a.size(); i++) {
            int result = a.get(i).compareTo(b.get(i));
            if (result != 0) return result;
        }

        return 0;
    }
}
