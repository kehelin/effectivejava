package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-13
 */
public class NotEqualsFilter extends AbstractEqualityOperator {
    public NotEqualsFilter(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public boolean operate(Map<String, Object> properties) {
        return !properties.containsKey(key) || !equalsKey(properties.get(key));
    }
}
