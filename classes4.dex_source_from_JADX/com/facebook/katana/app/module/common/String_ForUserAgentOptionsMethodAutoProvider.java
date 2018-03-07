package com.facebook.katana.app.module.common;

import android.content.Context;
import com.facebook.common.android.ApplicationInfoMethodAutoProvider;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: withTaggingRank */
public class String_ForUserAgentOptionsMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return CommonProcessModule.a((Context) getInstance(Context.class), ProcessNameMethodAutoProvider.b(this), ApplicationInfoMethodAutoProvider.b(this));
    }
}
