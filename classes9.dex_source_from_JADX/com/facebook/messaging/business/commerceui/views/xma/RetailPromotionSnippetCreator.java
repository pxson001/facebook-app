package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: no callback */
public class RetailPromotionSnippetCreator implements SnippetCreator {
    private final Context f8670a;

    @Inject
    public RetailPromotionSnippetCreator(Context context) {
        this.f8670a = context;
    }

    public final String m8882a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null) {
            return "";
        }
        String bk = snippetCreatorParams.b.c().k().bk();
        if (!Strings.isNullOrEmpty(bk)) {
            return bk;
        }
        return this.f8670a.getString(2131240727, new Object[]{snippetCreatorParams.a});
    }
}
