package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-13
 */
public class LessThanFilter extends AbstractBinaryOperator {
    public LessThanFilter(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public boolean operate(Map<String, Object> propreties) {
        return propreties.containsKey(key) && (compare(propreties.get(key)) > 0);
    }
}
