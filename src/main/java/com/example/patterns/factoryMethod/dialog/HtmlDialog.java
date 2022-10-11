package com.example.patterns.factoryMethod.dialog;

import com.example.patterns.factoryMethod.button.Button;
import com.example.patterns.factoryMethod.button.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    protected Button createButton() {
        return new HtmlButton();
    }
}
