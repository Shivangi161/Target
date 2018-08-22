package content.analysis.Controller;

import content.analysis.Service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectionableCommentValidationController {

    @Autowired
    private ValidatorService validatorService;

    @RequestMapping(value = "/validate-comment", method = RequestMethod.GET)
    public boolean isObjectionableComment(@RequestParam("comment") String comment) {
        if (comment == null || comment.isEmpty()) {
            throw new RuntimeException("Comment should not be empty. Please provide a valid comment.");
        }
        return validatorService.isObjectionableComment(comment);
    }
}
