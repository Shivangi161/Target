package content.analysis.Controller;

import content.analysis.Service.ModerateCommentService;
import content.analysis.Service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPageController {

    private static final String OBJECTIONABLE_COMMENT = "This comment looks like an ojectionable comment and hence has been sent for verification.";

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private ModerateCommentService moderateCommentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String addComment(@RequestParam("comment") String comment,@RequestParam("productId") long productId) {
        if (comment == null || comment.isEmpty()) {
            throw new RuntimeException("Comment should not be empty. Please provide a valid comment.");
        }
        boolean isObjectionableComment = validatorService.isObjectionableComment(comment);
        if(isObjectionableComment){
            moderateCommentService.addComment(productId,comment);
            return OBJECTIONABLE_COMMENT ;
        }
        return comment;
    }
}
