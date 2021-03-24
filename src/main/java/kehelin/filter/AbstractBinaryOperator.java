package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;

import java.math.BigDecimal;

/**
 * @author wangminghui
 * @since 2020-01-13
 */
public abstract class AbstractBinaryOperator implements Filter {

    protected String key;
    protected BigDecimal value;

    protected AbstractBinaryOperator(JsonNode jsonNode) {
        if (jsonNode.size() < 3) {
            throw new RuntimeException("BinaryOperator expression must have 3 elements");
        }

        key = jsonNode.get(1).asText();
        if (Strings.isNullOrEmpty(key)) {
            throw new RuntimeException("BinaryOperator expression key must be a string");
        }
        value = new BigDecimal(jsonNode.get(2).asText());
    }

    protected int compare(Object object) {
        if (object == null) {
            throw new RuntimeException("object can not be null");
        }
        BigDecimal compareValue;
        if (object instanceof Short) {
            compareValue = new BigDecimal((Short) object);
        } else if (object instanceof Integer) {
            compareValue = new BigDecimal((Integer) object);
        } else if (object instanceof Float) {
            compareValue = new BigDecimal((Float) object);
        } else if (object instanceof Double) {
            compareValue = new BigDecimal((Double) object);
        } else {
            throw new RuntimeException("compare operation only supports numbers");
        }
        return value.compareTo(compareValue);
    }
}
