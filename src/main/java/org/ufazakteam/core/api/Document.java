package org.ufazakteam.core.api;

import org.ufazakteam.utils.enums.DocumentForm;
import org.ufazakteam.utils.enums.Lang;

import java.util.Date;

/**
 * Created by Toktar on 14.04.2018.
 */
public interface Document {
    void init();

    public Lang getLang();

    public void setLang(Lang lang);

    public String getTitle();

    public void setTitle(String title);

    public DocumentForm getDocumentForm();

    public void setDocumentForm(DocumentForm documentForm);

    public Date getApprovalDate();

    public void setApprovalDate(Date approvalDate);

    public Date getRegistrationDate();

    public void setRegistrationDate(Date registrationDate);

    public String getApprovalNumber();

    public void setApprovalNumber(String approvalNumber);

    public int getRegistrationNumber();

    public void setRegistrationNumber(int registrationNumber);
}
