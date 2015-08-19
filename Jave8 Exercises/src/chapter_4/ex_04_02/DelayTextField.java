package chapter_4.ex_04_02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;

public class DelayTextField extends Control{
    private String text = "";
    private StringProperty textProperty = null;

    public final StringProperty textProperty() {
        if (textProperty == null)
            textProperty = new SimpleStringProperty(text);
        return textProperty;
    }
    public final void setText(String text) {
        if (textProperty != null)
            textProperty.set(text);
        else
            this.text = text;
    }
    public final String getText() {
        if(textProperty != null)
            return textProperty.get();
        else
            return text;
    }
}
