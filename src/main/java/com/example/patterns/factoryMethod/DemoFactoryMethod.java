package com.example.patterns.factoryMethod;

import com.example.patterns.factoryMethod.dialog.DesktopDialog;
import com.example.patterns.factoryMethod.dialog.Dialog;
import com.example.patterns.factoryMethod.dialog.HtmlDialog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoFactoryMethod {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * Create fabric depends on OS
     */
    private static void configure() {
        if (System.getProperty("os.name").equals("Windows 10") ||
                System.getProperty("os.name").equals("Linux")) {
            dialog =  new DesktopDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }

    private static void runBusinessLogic() {
        dialog.renderWindow();
    }

}
