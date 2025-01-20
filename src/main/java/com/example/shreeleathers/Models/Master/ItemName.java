package com.example.shreeleathers.Models.Master;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemName
{
    private final SimpleIntegerProperty slNo;
    private final SimpleIntegerProperty catId;
    private final SimpleStringProperty itemName;
    private final SimpleIntegerProperty sizeId;
    private final SimpleStringProperty szFrom;
    private final SimpleStringProperty szUpto;

    public ItemName(int slNo, int catId, String itemName, int sizeId, String szFrom, String szUpto)
    {
        this.slNo = new SimpleIntegerProperty(this, "Sl Number", slNo);
        this.catId = new SimpleIntegerProperty(this, "Category Id", catId);
        this.itemName = new SimpleStringProperty(this, "Item Name", itemName);
        this.sizeId = new SimpleIntegerProperty(this, "Size Id", sizeId);
        this.szFrom = new SimpleStringProperty(this, "Size From", szFrom);
        this.szUpto = new SimpleStringProperty(this, "Size Upto", szUpto);
    }

    public SimpleIntegerProperty slNoProperty(){return slNo;}
    public int getSlNo(){return slNo.get();}
    public void setSlNo(int slNo){this.slNo.set(slNo);}

    public SimpleIntegerProperty catIdProperty(){return catId;}
    public int getCatId(){return catId.get();}
    public void setCatId(int catId){this.catId.set(catId);}

    public SimpleStringProperty itemNameProperty(){return itemName;}
    public String getItemName(){return itemName.get();}
    public void setItemName(String itemName){this.itemName.set(itemName);}

    public SimpleIntegerProperty sizeIdProperty(){return sizeId;}
    public int getSizeId(){return sizeId.get();}
    public void setSizeId(int sizeId){this.sizeId.set(sizeId);}

    public SimpleStringProperty szFromProperty(){return szFrom;}
    public String getSzFrom(){return szFrom.get();}
    public void setSzFrom(String szFrom){this.szFrom.set(szFrom);}

    public SimpleStringProperty szUptoProperty(){return szUpto;}
    public String getSzUpto(){return szUpto.get();}
    public void setSzUpto(String szUpto){this.szUpto.set(szUpto);}
}
