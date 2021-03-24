package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;

/**
 * @author wangminghui
 * @since 2020-01-13
 */
public abstract class AbstractEqualityOperator implements Filter {
    protected String key;
    protected String value;


    protected AbstractEqualityOperator(JsonNode jsonNode) {
        if (jsonNode.size() < 3) {
            throw new RuntimeException("EqualityOperator expression must have 3 elements");
        }
        key = jsonNode.get(1).asText();
        if (Strings.isNullOrEmpty(key)) {
            throw new RuntimeException("EqualityOperator expression key must be a string");
        }
        value = jsonNode.get(2).asText().trim();
    }

    protected boolean equalsKey(Object object) {
        if (object == null) {
            throw new RuntimeException("object can not be null");
        } else if (object instanceof String) {
            return value.equals(object);
        } else if (object instanceof Integer) {
            return value.equals(String.valueOf(object));
        } else if (object instanceof Short) {
            return value.equals(String.valueOf(object));
        } else if (object instanceof Float) {
            return value.equals(String.valueOf(object));
        } else if (object instanceof Double) {
            return value.equals(String.valueOf(object));
        }
        return false;
    }
}
