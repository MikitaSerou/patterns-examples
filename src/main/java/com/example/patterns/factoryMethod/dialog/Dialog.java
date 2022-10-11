package com.example.patterns.factoryMethod.dialog;

import com.example.patterns.factoryMethod.button.Button;

/**
 * This is the class for fabric method
 */
public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method to create specific
     * product objects, different for each factory.
     */
    protected abstract Button createButton();
}
