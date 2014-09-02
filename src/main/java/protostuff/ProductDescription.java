package protostuff;

import java.io.Serializable;

/**
 * @author hubery.chen
 */
public class ProductDescription implements Serializable {

    private String tabTitle;
    private int displayOrder;

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
