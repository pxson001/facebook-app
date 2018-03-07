package com.fasterxml.jackson.databind.cfg;

/* compiled from: stickers/ */
public interface ConfigFeature {
    boolean enabledByDefault();

    int getMask();
}
