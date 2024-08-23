package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();

        logger.trace("traceメッセージ");
        logger.debug("debugメッセージ");
        logger.info("infoメッセージ");
        logger.warn("warnメッセージ");
        logger.error("errorメッセージ");
    }
}