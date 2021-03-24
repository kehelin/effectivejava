package kehelin.filter;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-13
 */
public interface Filter {
    boolean operate(Map<String, Object> propreties);
}
