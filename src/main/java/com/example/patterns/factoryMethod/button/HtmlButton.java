package com.example.patterns.factoryMethod.button;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlButton implements Button {
    @Override
    public void render() {
      log.info("<button>Test button</button>");
    }

    @Override
    public void onClick() {
        log.info("Click on HTML button!");
    }
}
