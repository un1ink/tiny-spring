package cn.un1ink.springframework.beans;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/5/1
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
