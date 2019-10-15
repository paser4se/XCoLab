package org.xcolab.view.pages.contenteditor;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.client.content.IContentClient;
import org.xcolab.client.content.exceptions.ContentNotFoundException;
import org.xcolab.client.content.pojo.IContentArticle;
import org.xcolab.client.content.pojo.IContentArticleVersion;
import org.xcolab.client.content.pojo.IContentFolder;
import org.xcolab.client.content.pojo.IContentPage;
import org.xcolab.client.user.IPermissionClient;
import org.xcolab.client.user.pojo.wrapper.UserWrapper;
import org.xcolab.view.errors.AccessDeniedPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ContentFileUploadController extends BaseContentEditor{

    @Autowired
    private IContentClient contentClient;

    @Autowired
    private IPermissionClient permissionClient;

    @GetMapping("/content-editor/fileUpload")
    public String handleRenderRequest(HttpServletRequest request, HttpServletResponse response,
            Model model, UserWrapper member) {
        System.out.println("In the method");
        if (!permissionClient.canAdminAll(member)) {
            return new AccessDeniedPage(member).toViewName(response);
        }
        return "contenteditor/fileUpload";
    }

/*    @GetMapping("/content-editor/fileUploaderListFiles")
    public void contentEditorListFolder(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(required = false) String node) throws IOException {
//        List<IContentPage> pages = contentClient.getContentPages(null);
        // get files
        //List<IContentPage> pages =
        JSONArray responseArray = new JSONArray();
        for (IContentPage cp : files) {
            responseArray.put(articleNode(cp.getTitle(), cp.getId()));
        }
        response.getOutputStream().write(responseArray.toString().getBytes());
    }*/
}
