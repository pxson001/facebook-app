package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: normalized_date DESC LIMIT  */
public class CommerceBubbleShipmentTrackingSnippetCreator implements SnippetCreator {
    private final Context f8657a;

    @Inject
    public CommerceBubbleShipmentTrackingSnippetCreator(Context context) {
        this.f8657a = context;
    }

    public final String m8870a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null || snippetCreatorParams.b.c().k().H() == null) {
            return "";
        }
        StoryAttachmentTargetFragmentModel k = snippetCreatorParams.b.c().k();
        return this.f8657a.getString(2131240717, new Object[]{snippetCreatorParams.a, k.H().G()});
    }
}
