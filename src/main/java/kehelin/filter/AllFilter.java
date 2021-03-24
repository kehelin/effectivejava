package kehelin.filter;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-17
 */
public class AllFilter implements Filter {
    @Override
    public boolean operate(Map<String, Object> propreties) {
        return true;
    }
}
