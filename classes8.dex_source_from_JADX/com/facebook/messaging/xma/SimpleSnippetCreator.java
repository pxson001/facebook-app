package com.facebook.messaging.xma;

import android.content.Context;

/* compiled from: tmp_image */
public abstract class SimpleSnippetCreator implements SnippetCreator {
    private final Context f1554a;

    protected abstract int m1725a();

    protected abstract int m1727b();

    public SimpleSnippetCreator(Context context) {
        this.f1554a = context;
    }

    public final String mo68a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.m1737a()) {
            return this.f1554a.getString(m1725a());
        }
        return this.f1554a.getString(m1727b(), new Object[]{snippetCreatorParams.f1558a});
    }
}
