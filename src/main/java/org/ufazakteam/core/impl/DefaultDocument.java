package org.ufazakteam.core.impl;

import org.ufazakteam.core.api.Document;
import org.ufazakteam.utils.StringUtils;
import org.ufazakteam.utils.enums.DocumentForm;
import org.ufazakteam.utils.enums.Lang;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Toktar on 14.04.2018.
 */
public class DefaultDocument implements Document {

    private Lang lang = null;
    private String title = null;
    private DocumentForm documentForm = null;
    private Date approvalDate = null;
    private Date registrationDate = null;
    private String approvalNumber = null;
    private int registrationNumber = 0;

    private String mainText = null;

    public DefaultDocument(String text) {
        mainText = text;
    }

    public void run() {
        setLang();
        setTitle();
        setDocumentForm();
    }

    public Lang getLang() {
        return lang;
    }

    private void setLang() {
        Pattern p = Pattern.compile(StringUtils.METAINFO_IN_RU);
        Matcher m = p.matcher(mainText);
        if (m.find()) setLang(Lang.RUS);
        else {
            p = Pattern.compile(StringUtils.METAINFO_IN_KZ);
            m = p.matcher(mainText);
            if (m.find()) setLang(Lang.KAZ);
        }
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle() {
        Pattern p = null;
             if (getLang() == Lang.RUS) p = Pattern.compile(StringUtils.METAINFO_IN_RU);
        else if (getLang() == Lang.KAZ) p = Pattern.compile(StringUtils.METAINFO_IN_KZ);
             if (Objects.nonNull(p)) {
                 Matcher m = p.matcher(mainText);
                 setTitle(mainText.substring(m.start(), m.end()).trim());
             }

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DocumentForm getDocumentForm() {
        return documentForm;
    }

    private void setDocumentForm() {

    }

    public void setDocumentForm(DocumentForm documentForm) {
        this.documentForm = documentForm;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
