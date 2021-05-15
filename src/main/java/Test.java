import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Test {
    static int length = 3;
    static List a = Arrays.asList(1, 2, 3, 5, 4, 3, 2, 4);
    static Map<String, Integer> numMap = new HashMap<>();

    public static void main(String[] args) {
        getIpList(a, 0, a.size() - 1, 4).stream()
                .forEach(node -> {
                    LinkNode next = (LinkNode) node;
                    while (next != null) {
                        System.out.print(next.value + ":");
                        next = next.next;
                    }

                    System.out.print("\n");
                });
    }

    static List<LinkNode> getIpList(List<Integer> a, int start, int end, int num) {
        if (start > end || end - start + 1 < num) {
            return Collections.emptyList();
        }
        if (end - start + 1 == num) {
            LinkNode current = new LinkNode(a.get(end), null);
            for (int i = end - 1; i < start; i++) {
                current = new LinkNode(a.get(i), current);
            }
            return Arrays.asList(current);
        }
        if (num == 1) {
            Integer temp = getNumber(a, start, end);
            if (temp >= 256) {
                return Collections.emptyList();
            } else {
                return Arrays.asList(new LinkNode(temp, null));
            }
        } else {
            List<LinkNode> result = new ArrayList<>();
            for (int i = start; i < end; i++) {
                Integer temp = getNumber(a, start, i);
                if (temp == null || temp >= 256) {
                    break;
                }
                getIpList(a, i + 1, end, num - 1).stream().forEach(o -> {
                    result.add(new LinkNode(temp, o));
                });
            }
            return result;
        }
    }

    static Integer getNumber(List<Integer> a, int start, int end) {
        if (start > end) {
            return null;
        }
        if (numMap.containsKey(start + "," + end)) {
            return numMap.get(start + "," + end);
        }
        int result = 0;
        for (; start <= end; start++) {
            result = result * 10 + a.get(start);
        }
        numMap.put(start + "," + end, result);
        return result;
    }
}

class LinkNode {
    LinkNode(Integer value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    Integer value;
    LinkNode next;
}