/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listviewsamplecustom;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author gusaros
 */
public class DvModel {

    // private BooleanProperty detected;
    public String onSet;
    public String offSet;
    public String code;
    ////  private StringProperty defectLongDescription;
    // private Defect(boolean invited, String defDeccription, String loc) {

    public DvModel(String onSet, String offSet, String code) {

        //  this.detected = new SimpleBooleanProperty(invited);
        this.onSet = onSet;

        this.offSet = offSet;
        this.code = code;

    }

    public String getOnSet() {
        return onSet;
    }

    public void setOnSet(String ons) {
        this.onSet = ons;
    }

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String ofs) {
        this.offSet = ofs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String c) {
        this.code = c;
    }

}
