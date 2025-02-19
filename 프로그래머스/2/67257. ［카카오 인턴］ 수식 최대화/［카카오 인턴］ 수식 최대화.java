import java.util.*;

class Solution {
    static List<Long> numbers = new ArrayList<>();
    static List<Character> operators = new ArrayList<>();
    static char[][] priority = {
        {'+', '-', '*'},
        {'+', '*', '-'},
        {'-', '+', '*'},
        {'-', '*', '+'},
        {'*', '+', '-'},
        {'*', '-', '+'}
    };

    public long solution(String expression) {
        parseExpression(expression);
        long maxResult = 0;

        for (char[] order : priority) {
            maxResult = Math.max(maxResult, Math.abs(calculate(order)));
        }

        return maxResult;
    }

    private void parseExpression(String expression) {
        numbers.clear();
        operators.clear();

        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operators.add(c);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
    }

    private long calculate(char[] order) {
        List<Long> numList = new ArrayList<>(numbers);
        List<Character> opList = new ArrayList<>(operators);

        for (char op : order) {
            for (int i = 0; i < opList.size(); ) {
                if (opList.get(i) == op) {
                    long res = compute(numList.get(i), numList.get(i + 1), op);
                    numList.remove(i + 1);
                    numList.set(i, res);
                    opList.remove(i);
                } else {
                    i++;
                }
            }
        }
        return numList.get(0);
    }

    private long compute(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}
