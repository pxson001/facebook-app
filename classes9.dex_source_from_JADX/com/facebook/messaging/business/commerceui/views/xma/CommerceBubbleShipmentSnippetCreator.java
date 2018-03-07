package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: normalized_date<= */
public class CommerceBubbleShipmentSnippetCreator implements SnippetCreator {
    private final Context f8656a;

    @Inject
    public CommerceBubbleShipmentSnippetCreator(Context context) {
        this.f8656a = context;
    }

    public final String m8868a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null) {
            return "";
        }
        StoryAttachmentTargetFragmentModel k = snippetCreatorParams.b.c().k();
        return this.f8656a.getString(2131240716, new Object[]{snippetCreatorParams.a, k.aD_(), k.G()});
    }
}
