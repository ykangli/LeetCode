package July2022.day30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/30 9:52    22. 括号生成
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder("");
        dfs(path);
        return result;
    }

    public static void dfs(StringBuilder path) {




    }
}
