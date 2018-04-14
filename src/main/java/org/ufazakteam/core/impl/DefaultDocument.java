package org.ufazakteam.core.impl;

import org.ufazakteam.core.api.Document;
import org.ufazakteam.utils.enums.DocumentForm;
import org.ufazakteam.utils.enums.Lang;

import java.util.Date;

/**
 * Created by Toktar on 14.04.2018.
 */
public class DefaultDocument implements Document {

    private String title = "";
    private Lang lang = null;
    private DocumentForm documentForm = null;
    private Date approvalDate = null;
    private Date registrationDate = null;
    private String approvalNumber = "";
    private int registrationNumber = 0;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public DocumentForm getDocumentForm() {
        return documentForm;
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
