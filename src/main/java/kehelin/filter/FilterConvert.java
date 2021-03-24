package kehelin.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;

/**
 * @author kehelin
 * @since 2020-01-13
 */
public class FilterConvert {

    public static Filter convertFilters(JsonNode jsonNode) {
        if (jsonNode == null) {
            throw new RuntimeException("filter expression is empty");
        }
        if (!jsonNode.isArray()) {
            throw new RuntimeException("filter expression must be an array");
        }
        if ((jsonNode.size()) < 1) {
            throw new RuntimeException("filter expression must have at least 1 element");
        }
        String operate = jsonNode.get(0).asText();
        if (Strings.isNullOrEmpty(operate)) {
            throw new RuntimeException("filter operator must be a string");
        }

        switch (operate) {
            case "all":
                return new AllFilter();
            case "==":
                return new EqualsFilter(jsonNode);
            case "!=":
                return new NotEqualsFilter(jsonNode);
            case ">":
                return new GreaterThanFilter(jsonNode);
            case ">=":
                return new GreaterThanEqualsFilter(jsonNode);
            case "<":
                return new LessThanFilter(jsonNode);
            case "<=":
                return new LessThanEqualsFilter(jsonNode);
            case "in":
                return new InFilter(jsonNode);
            case "!in":
                return new NotInFilter(jsonNode);
            case "and":
                return new AndFilter(jsonNode);
            case "or":
                return new OrFilter(jsonNode);
            case "not":
                return new NotFilter(jsonNode);
//            case "envelopeintersects":
//                return convertGeoFilter < GeoEnvelopeIntersectsFilter > (value,error);
            default:
                throw new RuntimeException("(filter operator must be one of \"==\", \"!=\", \">\", \">=\", \"<\", \"<=\", \"in\", \"!in\", \"and\", \"or\", \"not\")");


        }
    }


}
