package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Size
{
    private final SimpleIntegerProperty sizeId;
    private final SimpleStringProperty szFrom;
    private final SimpleStringProperty szUpto;
    private final SimpleStringProperty s1;
    private final SimpleStringProperty s2;
    private final SimpleStringProperty s3;
    private final SimpleStringProperty s4;
    private final SimpleStringProperty s5;
    private final SimpleStringProperty s6;
    private final SimpleStringProperty s7;
    private final SimpleStringProperty s8;
    private final SimpleStringProperty s9;
    private final SimpleStringProperty s10;
    private final SimpleStringProperty s11;
    private final SimpleStringProperty s12;
    private final SimpleStringProperty s13;

    public Size(int sizeId, String szFrom, String szUpto, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9,
                String s10, String s11, String s12, String s13)
    {
        this.sizeId = new SimpleIntegerProperty(this, "Size Id", sizeId);
        this.szFrom = new SimpleStringProperty(this, "Size From", szFrom);
        this.szUpto = new SimpleStringProperty(this, "Size Upto", szUpto);
        this.s1 = new SimpleStringProperty(this, "Size 1", s1);
        this.s2 = new SimpleStringProperty(this, "Size 2", s2);
        this.s3 = new SimpleStringProperty(this, "Size 3", s3);
        this.s4 = new SimpleStringProperty(this, "Size 4", s4);
        this.s5 = new SimpleStringProperty(this, "Size 5", s5);
        this.s6 = new SimpleStringProperty(this, "Size 6", s6);
        this.s7 = new SimpleStringProperty(this, "Size 7", s7);
        this.s8 = new SimpleStringProperty(this, "Size 8", s8);
        this.s9 = new SimpleStringProperty(this, "Size 9", s9);
        this.s10 = new SimpleStringProperty(this, "Size 10", s10);
        this.s11 = new SimpleStringProperty(this, "Size 11", s11);
        this.s12 = new SimpleStringProperty(this, "Size 12", s12);
        this.s13 = new SimpleStringProperty(this, "Size 13", s13);
    }

    public SimpleIntegerProperty sizeIdProperty(){return sizeId;}
    public int getSizeId(){return sizeId.get();}
    public void setSizeId(int sizeId){this.sizeId.set(sizeId);}

    public SimpleStringProperty szFromProperty(){return szFrom;}
    public String getSzFrom(){return szFrom.get();}
    public void setSzFrom(String szFrom){this.szFrom.set(szFrom);}

    public SimpleStringProperty szUptoProperty(){return szUpto;}
    public String getSzUpto(){return szUpto.get();}
    public void setSzUpto(String szUpto){this.szUpto.set(szUpto);}

    public SimpleStringProperty s1Property(){return s1;}
    public String getS1(){return s1.get();}
    public void setS1(String s1){this.s1.set(s1);}

    public SimpleStringProperty s2Property(){return s2;}
    public String getS2(){return s2.get();}
    public void setS2(String s2){this.s2.set(s2);}

    public SimpleStringProperty s3Property(){return s3;}
    public String getS3(){return s3.get();}
    public void setS3(String s3){this.s3.set(s3);}

    public SimpleStringProperty s4Property(){return s4;}
    public String getS4(){return s4.get();}
    public void setS4(String s4){this.s4.set(s4);}

    public SimpleStringProperty s5Property(){return s5;}
    public String getS5(){return s5.get();}
    public void setS5(String s5){this.s5.set(s5);}

    public SimpleStringProperty s6Property(){return s6;}
    public String getS6(){return s6.get();}
    public void setS6(String s6){this.s6.set(s6);}

    public SimpleStringProperty s7Property(){return s7;}
    public String getS7(){return s7.get();}
    public void setS7(String s7){this.s7.set(s7);}

    public SimpleStringProperty s8Property(){return s8;}
    public String getS8(){return s8.get();}
    public void setS8(String s8){this.s8.set(s8);}

    public SimpleStringProperty s9Property(){return s9;}
    public String getS9(){return s9.get();}
    public void setS9(String s9){this.s9.set(s9);}

    public SimpleStringProperty s10Property(){return s10;}
    public String getS10(){return s10.get();}
    public void setS10(String s10){this.s10.set(s10);}

    public SimpleStringProperty s11Property(){return s11;}
    public String getS11(){return s11.get();}
    public void setS11(String s11){this.s11.set(s11);}

    public SimpleStringProperty s12Property(){return s12;}
    public String getS12(){return s12.get();}
    public void setS12(String s12){this.s12.set(s12);}

    public SimpleStringProperty s13Property(){return s13;}
    public String getS13(){return s13.get();}
    public void setS13(String s13){this.s13.set(s13);}
}
