package com.facebook.resources;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: value for setEnum call should not be null */
public class Resources_BaseResourcesMethodAutoProvider extends AbstractProvider<Resources> {
    public static Resources m2599b(InjectorLike injectorLike) {
        return FbResourcesModule.m2603a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return FbResourcesModule.m2603a((Context) getInstance(Context.class));
    }
}
