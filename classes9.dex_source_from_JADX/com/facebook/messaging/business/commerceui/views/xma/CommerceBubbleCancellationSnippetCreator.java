package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: notification_placeholder */
public class CommerceBubbleCancellationSnippetCreator implements SnippetCreator {
    private final Context f8645a;

    @Inject
    public CommerceBubbleCancellationSnippetCreator(Context context) {
        this.f8645a = context;
    }

    public final String m8862a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null || snippetCreatorParams.b.c().k().q() == null) {
            return "";
        }
        StoryAttachmentTargetFragmentModel k = snippetCreatorParams.b.c().k();
        return this.f8645a.getString(2131240715, new Object[]{snippetCreatorParams.a, k.q().aD_()});
    }
}
