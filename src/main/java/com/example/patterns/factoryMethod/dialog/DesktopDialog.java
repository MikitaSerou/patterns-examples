package com.example.patterns.factoryMethod.dialog;

import com.example.patterns.factoryMethod.button.Button;
import com.example.patterns.factoryMethod.button.DesktopButton;

public class DesktopDialog extends Dialog{

    @Override
    protected Button createButton() {
        return new DesktopButton();
    }
}
