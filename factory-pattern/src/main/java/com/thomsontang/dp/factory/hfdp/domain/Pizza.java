package com.thomsontang.dp.factory.hfdp.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Pizza.
 *
 * @author Thomson Tang
 */
public abstract class Pizza {
    private static final Logger logger = LoggerFactory.getLogger(Pizza.class);

    public void prepare() {
        logger.info("prepare...");
    }

    public void bake() {
        logger.info("bake...");
    }

    public void cut() {
        logger.info("cut...");
    }

    public void box() {
        logger.info("box...");
    }
}
