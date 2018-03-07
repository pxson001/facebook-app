package com.facebook.katana.app.module;

import android.content.Context;
import com.facebook.inject.AbstractProvider;

/* compiled from: hugePictureSize */
public class String_ApiConnectionTypeMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return MainProcessModule.c((Context) getInstance(Context.class));
    }
}
