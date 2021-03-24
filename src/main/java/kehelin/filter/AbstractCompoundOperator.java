package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangminghui
 * @since 2020-01-14
 */
public abstract class AbstractCompoundOperator implements Filter {
    protected List<Filter> filterList;

    protected AbstractCompoundOperator(JsonNode jsonNode) {
        if (jsonNode.size() < 2) {
            throw new RuntimeException("CompoundOperator expression must have at least 2 elements");
        }
        filterList = new ArrayList<>();
        for (int i = 1; i < jsonNode.size(); i++) {
            filterList.add(FilterConvert.convertFilters(jsonNode.get(i)));
        }
    }
}
