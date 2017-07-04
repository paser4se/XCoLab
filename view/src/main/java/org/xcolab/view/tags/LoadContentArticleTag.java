package org.xcolab.view.tags;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import org.xcolab.client.admin.enums.ConfigurationAttributeKey;
import org.xcolab.client.contents.ContentsClient;
import org.xcolab.client.contents.exceptions.ContentNotFoundException;
import org.xcolab.client.contents.pojo.ContentArticle;
import org.xcolab.client.contents.pojo.ContentArticleVersion;
import org.xcolab.view.i18n.I18nUtils;

import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoadContentArticleTag extends BodyTagSupport {

    private long articleId;

    @Override
    public int doStartTag() throws JspException {
        if (articleId > 0) {
            try {
                final ContentArticle contentArticle = ContentsClient
                        .getContentArticle(articleId);

                Locale locale = LocaleContextHolder.getLocale();
                String localeString = "en";
                if(locale.getLanguage()!=null) {
                    localeString = locale.getLanguage();
                }

                final long version = contentArticle.getMaxVersionId();
            //public static ContentArticleVersion getByArticleVersionLanguage(Long contentArticleId, String language) {
                 ContentArticleVersion contentArticleVersion = ContentsClient
                        .getByArticleVersionLanguage(contentArticle.getContentArticleId(), localeString);
                 if(contentArticleVersion == null){
                     contentArticleVersion = ContentsClient
                             .getByArticleVersionLanguage(contentArticle.getContentArticleId(),
                                     I18nUtils.DEFAULT_LOCALE.getLanguage());
                 }

                pageContext.setAttribute("contentArticle", contentArticle);
                pageContext.setAttribute("contentArticleVersion", contentArticleVersion);
            } catch (ContentNotFoundException e) {
                //ignored
            }
        }
        return EVAL_BODY_INCLUDE;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }
}
