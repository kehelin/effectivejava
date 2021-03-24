package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangminghui
 * @since 2020-01-14
 */
public abstract class AbstractSetOperator implements Filter {
    protected String key;
    protected Set<String> value;

    protected AbstractSetOperator(JsonNode jsonNode) {
        if (jsonNode.size() < 3) {
            throw new RuntimeException("filter expression must have 3 elements");
        }
        key = jsonNode.get(1).asText();
        if (Strings.isNullOrEmpty(key)) {
            throw new RuntimeException("filter expression key must be a string");
        }
        value = new HashSet<>();
        for (int i = 2; i < jsonNode.size(); i++) {
            value.add(jsonNode.get(i).asText().trim());
        }

    }

    protected boolean in(Map<String, Object> propreties) {
        return propreties.containsKey(key) && value.contains(getStringFromValue(propreties.get(key)));
    }

    private String getStringFromValue(Object object) {

        if (object == null) {
            throw new RuntimeException("object can not be null");
        } else if (object instanceof String) {
            return (String) object;
        } else if (object instanceof Integer) {
            return String.valueOf(object);
        } else if (object instanceof Short) {
            return String.valueOf(object);
        } else if (object instanceof Float) {
            return String.valueOf(object);
        } else if (object instanceof Double) {
            return String.valueOf(object);
        }
        return null;
    }

}
