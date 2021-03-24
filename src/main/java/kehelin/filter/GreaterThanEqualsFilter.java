package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-14
 */
public class GreaterThanEqualsFilter extends AbstractBinaryOperator {
    public GreaterThanEqualsFilter(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public boolean operate(Map<String, Object> propreties) {
        return propreties.containsKey(key) && (compare(propreties.get(key)) <= 0);
    }
}
