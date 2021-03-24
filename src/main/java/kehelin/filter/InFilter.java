package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

/**
 * @author wangminghui
 * @since 2020-01-14
 */
public class InFilter extends AbstractSetOperator {
    public InFilter(JsonNode jsonNode) {
        super(jsonNode);
    }

    @Override
    public boolean operate(Map<String, Object> properties) {
        return in(properties);
    }


}
