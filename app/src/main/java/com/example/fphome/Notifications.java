package com.example.fphome;

import java.text.DateFormat;
import java.util.Calendar;

public class Notifications {
    Calendar calendar = Calendar.getInstance();
    private String date = DateFormat.getDateInstance().format(calendar.getTime());
    private String title;
    private String label;
    private  String pdfurl;
    private  String pdfimg;
    private  String pdfname;
    public Notifications(){}



    public Notifications(String date, String title, String label, String pdfText, String pdfurl, String pdfname, String pdfimg) {
        this.date = date;
        this.title = title;
        this.label = label;
        this.pdfurl = pdfurl;
        this.pdfimg = pdfimg;
        this.pdfname = pdfname;

    }

    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }

    public String getPdfName() { return pdfname; }

    public void setPdfName(String pdfname) { this.pdfname = pdfname; }

    public String getPdfimg() { return pdfimg; }

    public void setPdfimg(String pdfimg) { this.pdfimg = pdfimg; }


}
