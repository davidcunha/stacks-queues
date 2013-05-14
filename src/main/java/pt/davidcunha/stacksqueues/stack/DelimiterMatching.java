/**
 * Stack and Queues - Match brackets for parsing code
 */
package pt.davidcunha.stacksqueues.stack;

/**
 *
 * @author David Cunha <davidgoncalvescunha AT gmail DOT pt>
 */
public class DelimiterMatching {

    /**
     * Check code
     *
     * @param code string to be reversed
     * @return string with checkin process result
     */
    public static String checkCode(String code) {
        StackImpl stack = new StackImpl(code.length());
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                case ')':
                case ']':
                    char chx = stack.pop();
                    if ((ch == '}' && chx != '{') || (ch == ')' && chx != '(') || (ch == ']' && chx != '[')) {
                        return "Error missing left delimeter for " + ch + " at " + i;
                    }
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            char chx = stack.pop();
            return "Error missing right delimeter for " + chx;
        }
        return "Code Complete!";
    }
}
