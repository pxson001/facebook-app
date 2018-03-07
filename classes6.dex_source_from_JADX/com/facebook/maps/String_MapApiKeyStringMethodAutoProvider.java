package com.facebook.maps;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;

/* compiled from: wallpaperColor */
public class String_MapApiKeyStringMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return MapsModule.m280a((FbAppType) getInstance(FbAppType.class));
    }
}
