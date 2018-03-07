package com.facebook.proxygen.utils;

/* compiled from: publish_mode_selector_nux */
public class GLogHandler {
    private BLogHandler handler;
    private final GLogSeverity[] severities = GLogSeverity.values();

    /* compiled from: publish_mode_selector_nux */
    public enum GLogSeverity {
        INFO,
        WARNING,
        ERROR,
        FATAL
    }

    public GLogHandler(BLogHandler bLogHandler) {
        this.handler = bLogHandler;
    }

    public void log(int i, String str) {
        if (i >= 0 && i < this.severities.length) {
            this.handler.log(this.severities[i], str);
        }
    }
}
