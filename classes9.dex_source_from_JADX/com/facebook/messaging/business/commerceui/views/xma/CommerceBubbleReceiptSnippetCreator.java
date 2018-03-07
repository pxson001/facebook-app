package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: not current */
public class CommerceBubbleReceiptSnippetCreator implements SnippetCreator {
    private final Context f8653a;

    @Inject
    public CommerceBubbleReceiptSnippetCreator(Context context) {
        this.f8653a = context;
    }

    public final String m8865a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null) {
            return "";
        }
        StoryAttachmentTargetFragmentModel k = snippetCreatorParams.b.c().k();
        return this.f8653a.getString(2131240714, new Object[]{snippetCreatorParams.a, k.aD_()});
    }
}
