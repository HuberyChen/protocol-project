package protostuff;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author hubery.chen
 */
public class FullProduct implements Serializable {

    private int productId;

    private String url;

    private Integer groupId;

    private List<ProductDescription> productDescriptions;

    private Map<Integer, ReviewRating> reviewRatings;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<ProductDescription> getProductDescriptions() {
        return productDescriptions;
    }

    public Map<Integer, ReviewRating> getReviewRatings() {
        return reviewRatings;
    }

    public void setProductDescriptions(List<ProductDescription> productDescriptions) {
        this.productDescriptions = productDescriptions;
    }

    public void setReviewRatings(Map<Integer, ReviewRating> reviewRatings) {
        this.reviewRatings = reviewRatings;
    }
}
