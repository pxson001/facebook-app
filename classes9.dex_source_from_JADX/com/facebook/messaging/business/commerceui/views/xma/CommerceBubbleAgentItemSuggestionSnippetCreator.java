package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: notification_resource */
public class CommerceBubbleAgentItemSuggestionSnippetCreator implements SnippetCreator {
    @Inject
    public CommerceBubbleAgentItemSuggestionSnippetCreator(Context context) {
    }

    public final String m8861a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null) {
            return "";
        }
        return snippetCreatorParams.b.c().k().g();
    }
}
