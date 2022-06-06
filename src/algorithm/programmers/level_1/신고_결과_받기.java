package algorithm.programmers.level_1;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class 신고_결과_받기 {

    public static void main(String[] args) {
        신고_결과_받기 solution = new 신고_결과_받기();
        String[] ids = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int[] results = solution.solution(ids, report, 2);
        System.out.println(Arrays.toString(results));
    }

    public int[] solution(String[] ids, String[] reports, int k) {
        Map<String, User> userIdAndUserMap = new LinkedHashMap<>();
        for (String id : ids) {
            userIdAndUserMap.put(id, new User(id));
        }

        for (String report : reports) {
            String[] splitReport = report.split(" ");
            String userId = splitReport[0];
            String reportedUserId = splitReport[1];

            User user = userIdAndUserMap.get(userId);
            User reportedUser = userIdAndUserMap.get(reportedUserId);
            user.addReportedUser(reportedUser);
        }

        Collection<User> users = userIdAndUserMap.values();

        Set<User> suspendUsers = users.stream()
                .filter(user -> user.isSuspendedUser(k))
                .collect(toSet());

        for (User user : users) {
            user.computeSuspendedUserCount(suspendUsers);
        }

        return users.stream()
                .mapToInt(User::getSuspendedUserCount)
                .toArray();
    }

    static class User {
        private final String id;
        private final Set<User> reportedUsers = new HashSet<>();
        private int reportedCount;
        private int suspendedUserCount;

        public User(String id) {
            this.id = id;
        }

        public void addReportedUser(User reportedUser) {
            if (this.reportedUsers.contains(reportedUser)) {
                return;
            }

            this.reportedUsers.add(reportedUser);
            reportedUser.addReportedCount();
        }

        public boolean isSuspendedUser(int k) {
            return this.reportedCount >= k;
        }

        public void computeSuspendedUserCount(Set<User> suspendedUsers) {
            this.suspendedUserCount = (int) this.reportedUsers.stream()
                    .filter(suspendedUsers::contains)
                    .count();
        }

        public int getSuspendedUserCount() {
            return this.suspendedUserCount;
        }

        private void addReportedCount() {
            this.reportedCount++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return Objects.equals(id, user.id);
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }
}
