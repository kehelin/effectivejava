package kehelin.filter;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author wangminghui
 * @since 2020-01-14
 */
@Data
@Builder
@ToString
public class LayerFilter {
    String layer;

    boolean visibility;

    Filter filter;

    int minLevel;

    int maxLevel;

}
