package algorithm;


import java.util.List;

class Solution {


    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(1);
        ListNode node15 = new ListNode(2);
        ListNode node16 = new ListNode(3);
        ListNode node17 = new ListNode(1);
        ListNode node18 = new ListNode(2);
        ListNode node19 = new ListNode(3);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node17.next = node18;
        node18.next = node19;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(1);
        ListNode node25 = new ListNode(2);
        ListNode node26 = new ListNode(3);
        ListNode node27 = new ListNode(1);
        ListNode node28 = new ListNode(2);
        ListNode node29 = new ListNode(3);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node27;
        node27.next = node28;
        node28.next = node29;

        ListNode start = start(node11, node21);
        printNode(start);


    }

    public static ListNode start(ListNode l1, ListNode l2) {
        return run(l1, l2, 0);
    }


    public static ListNode run(ListNode l1, ListNode l2, int num) {
        if (l1 == null && l2 == null && num == 0) {
            return null;
        }
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + num;
        ListNode l3 = new ListNode(sum % 10);
        l3.next = run(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return l3;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }


    ListNode dfs(ListNode l, ListNode r, int i) {
        if (l == null && r == null && i == 0) return null;
        int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
        return node;
    }


    public static void printNode(ListNode node) {
        StringBuffer buffer = new StringBuffer();
        while (node != null) {
            buffer.append(node.val + "");
            node = node.next;
        }
        System.out.println(buffer.toString());

    }
}