package main.java.System.Util.InvisibleVariables;

public class Variable {
    private Object value;
    private String name;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
