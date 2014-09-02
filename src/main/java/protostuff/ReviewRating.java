package protostuff;

import java.math.BigDecimal;

/**
 * @author hubery.chen
 */
public class ReviewRating {

    public int TotalCount;

    public BigDecimal AverageRating;

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    public BigDecimal getAverageRating() {
        return AverageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        AverageRating = averageRating;
    }
}
