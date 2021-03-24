package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-14
 */
public class AndFilter extends AbstractCompoundOperator implements Filter {
    public AndFilter(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public boolean operate(Map<String, Object> propreties) {
        for (Filter filter : filterList) {
            if (!filter.operate(propreties)) {
                return false;
            }
        }
        return true;
    }
}
