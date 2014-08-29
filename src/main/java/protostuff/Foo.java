package protostuff;

import java.io.Serializable;

/**
 * @author hubery.chen
 */
public class Foo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int productId;

    private String url;

    private Integer groupId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
}
