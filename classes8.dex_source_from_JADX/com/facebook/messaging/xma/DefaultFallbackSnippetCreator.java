package com.facebook.messaging.xma;

import android.content.Context;
import javax.inject.Inject;

/* compiled from: toLeftOf */
public class DefaultFallbackSnippetCreator implements SnippetCreator {
    private final Context f1552a;

    @Inject
    public DefaultFallbackSnippetCreator(Context context) {
        this.f1552a = context;
    }

    public final String mo68a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.m1737a()) {
            return this.f1552a.getString(2131239184);
        }
        return this.f1552a.getString(2131239185, new Object[]{snippetCreatorParams.f1558a});
    }
}
