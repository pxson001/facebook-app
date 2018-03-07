package com.facebook.messaging.business.commerceui.views.common;

import android.content.Context;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: null_thread_list_result */
public class RetailItemSnippetCreator implements SnippetCreator {
    private final Context f8444a;

    @Inject
    public RetailItemSnippetCreator(Context context) {
        this.f8444a = context;
    }

    public final String m8707a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null) {
            return "";
        }
        return this.f8444a.getString(2131240726, new Object[]{snippetCreatorParams.a});
    }
}
