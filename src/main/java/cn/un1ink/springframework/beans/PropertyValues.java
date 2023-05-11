package cn.un1ink.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();


    public PropertyValues(){

    }

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }


    public PropertyValue getPropertyValue(String propertyName) {
        for(PropertyValue pv : this.propertyValueList) {
            if(pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
