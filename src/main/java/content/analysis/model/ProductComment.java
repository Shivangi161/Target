package content.analysis.model;

public class ProductComment {

    private long productId;
    private String comment;

    public ProductComment(long productId, String comment){
    this.productId = productId;
    this.comment = comment;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return productId+","+comment+"\n";
    }
}
