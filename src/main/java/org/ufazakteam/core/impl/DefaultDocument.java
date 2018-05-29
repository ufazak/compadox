package org.ufazakteam.core.impl;

import org.ufazakteam.core.api.BaseElement;
import org.ufazakteam.core.api.Document;
import org.ufazakteam.core.impl.structure.DocumentTree;
import org.ufazakteam.utils.StringUtils;
import org.ufazakteam.utils.enums.DocumentForm;
import org.ufazakteam.utils.enums.Lang;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Toktar on 14.04.2018.
 */
public class DefaultDocument implements Document {

    private Lang lang;
    private String title;
    private DocumentForm documentForm;
    private Date approvalDate;
    private Date registrationDate;
    private String approvalNumber;
    private int registrationNumber;

    private BaseElement documentTree;

    private String mainText;
    private String description;

    public DefaultDocument(String text) {
        mainText = text;
    }

    public void init() {
        describeYourself();
        createDocumentTree();
    }

    private void createDocumentTree() {
        documentTree = new DocumentTree();
    }

    private void describeYourself() {
        setLang();
        setTitle();
        setDescription();
        setDocumentForm();
        setApprovalDate();
        setApprovalNumber();
    }

    public Lang getLang() {
        return lang;
    }

    // TODO: сменить логику при добавлении иных форм актов, кроме закона и кодекса
    private void setLang() {
        Pattern p = Pattern.compile(StringUtils.DESC_RU);
        Matcher m = p.matcher(mainText);
        if (m.find())
            setLang(Lang.RUS);
        else {
            p = Pattern.compile(StringUtils.DESC_KZ);
            m = p.matcher(mainText);
            if (m.find())
                setLang(Lang.KAZ);
        }
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription() {
        Pattern p = null;
        if (getLang() == Lang.RUS)
            p = Pattern.compile(StringUtils.DESC_RU);
        else if (getLang() == Lang.KAZ)
            p = Pattern.compile(StringUtils.DESC_KZ);
        if (Objects.nonNull(p)) {
            Matcher m = p.matcher(mainText);
            if (m.find())
                setDescription(mainText.substring(m.start(), m.end()));
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle() {
        Pattern p = null;
        if (getLang() == Lang.RUS)
            p = Pattern.compile(StringUtils.DESC_RU);
        else if (getLang() == Lang.KAZ)
            p = Pattern.compile(StringUtils.DESC_KZ);
        if (Objects.nonNull(p)) {
            Matcher m = p.matcher(mainText);
            if (m.find())
                setTitle(mainText.substring(0, m.start()).trim());
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DocumentForm getDocumentForm() {
        return documentForm;
    }

    private void setDocumentForm() {
        if (getLang() == Lang.RUS) {
            if (getDescription().contains("Закон"))
                setDocumentForm(DocumentForm.LAW);
            else if (getDescription().contains("Кодекс"))
                setDocumentForm(DocumentForm.CODE);
        } else if (getLang() == Lang.KAZ) {
            if (getDescription().contains("Заң"))
                setDocumentForm(DocumentForm.LAW);
            else if (getDescription().contains("Кодекс"))
                setDocumentForm(DocumentForm.CODE);
        }
    }

    public void setDocumentForm(DocumentForm documentForm) {
        this.documentForm = documentForm;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    private void setApprovalDate() {
        Pattern p; Matcher m;
        if (getLang() == Lang.RUS) {
            p = Pattern.compile("[0-3]?\\d .{2,7}[ая]{1} \\d\\d\\d\\d");
            m = p.matcher(getDescription());
            if (m.find()) {
                String[] substr = m.group().split("\\s");
                int year, month, day;
                day = substr[0].charAt(0) == '0' ? Character.getNumericValue(substr[0].charAt(1)) : Integer.parseInt(substr[0]);
                switch (substr[1]) {
                    case "января"   : month = 0;  break;
                    case "февраля"  : month = 1;  break;
                    case "марта"    : month = 2;  break;
                    case "апреля"   : month = 3;  break;
                    case "мая"      : month = 4;  break;
                    case "июня"     : month = 5;  break;
                    case "июля"     : month = 6;  break;
                    case "августа"  : month = 7;  break;
                    case "сентября" : month = 8;  break;
                    case "октября"  : month = 9;  break;
                    case "ноября"   : month = 10; break;
                    case "декабря"  : month = 11; break;
                    default: month = -1;
                }
                year = Integer.parseInt(substr[2]);
                setApprovalDate(new GregorianCalendar(year, month, day).getTime());
            }
        } else if (getLang() == Lang.KAZ) {
            p = Pattern.compile("\\d\\d\\d\\d жылғы [0-3]?\\d .{5,9}(дағы|дегі)");
            m = p.matcher(getDescription());
            if (m.find()) {
                String[] substr = m.group().split("\\s");
                int year, month, day;
                day = substr[2].charAt(0) == '0' ? Character.getNumericValue(substr[2].charAt(1)) : Integer.parseInt(substr[2]);
                switch (substr[3]) {
                    case "қаңтардағы"    : month = 0;  break;
                    case "ақпандағы"     : month = 1;  break;
                    case "наурыздағы"    : month = 2;  break;
                    case "сәуірдегі"     : month = 3;  break;
                    case "мамырдағы"     : month = 4;  break;
                    case "маусымдағы"    : month = 5;  break;
                    case "шілдедегі"     : month = 6;  break;
                    case "тамыздағы"     : month = 7;  break;
                    case "қыркүйектегі"  : month = 8;  break;
                    case "қазандағы"     : month = 9;  break;
                    case "қарашадағы"    : month = 10; break;
                    case "желтоқсандағы" : month = 11; break;
                    default: month = -1;
                }
                year = Integer.parseInt(substr[0]);
                setApprovalDate(new GregorianCalendar(year, month, day).getTime());
            }
        }
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

    private void setApprovalNumber() {
        Pattern p; Matcher m; String result = null;
        if (getLang() == Lang.RUS) {
            p = Pattern.compile("[N№] \\d+(-[\\w-І]+ ЗРК|-[\\w-І]+)?\\.");
            m = p.matcher(getDescription());
            if (m.find()) {
                String[] substr = m.group().split("\\s");
                result = (substr.length == 2) ? substr[1].substring(0, substr[1].length() - 1) : substr[1];
            }
        } else if (getLang() == Lang.KAZ) {
            p = Pattern.compile("[N№] \\d+(-[\\w-І]+)?\\s?(Заңы|Кодексі|ҚРЗ)?\\.");
            m = p.matcher(getDescription());
            if (m.find()) {
                String[] substr = m.group().split("\\s");
                result = (substr.length == 2) ? substr[1].substring(0, substr[1].length() - 1) : substr[1];
            }
        }
        if (Objects.nonNull(result)) setApprovalNumber(result);
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
