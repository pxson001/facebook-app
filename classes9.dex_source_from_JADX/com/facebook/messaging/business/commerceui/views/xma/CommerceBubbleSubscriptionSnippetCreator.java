package com.facebook.messaging.business.commerceui.views.xma;

import android.content.Context;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceProductSubscriptionBubbleModel.SubscribedItemModel.NodesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import javax.inject.Inject;

/* compiled from: non_existing_account_label */
public class CommerceBubbleSubscriptionSnippetCreator implements SnippetCreator {
    private final Context f8667a;

    @Inject
    public CommerceBubbleSubscriptionSnippetCreator(Context context) {
        this.f8667a = context;
    }

    public final String m8877a(SnippetCreatorParams snippetCreatorParams) {
        if (snippetCreatorParams.a() || snippetCreatorParams.b == null || snippetCreatorParams.b.c() == null || snippetCreatorParams.b.c().k() == null || snippetCreatorParams.b.c().k().t() == null) {
            return "";
        }
        StoryAttachmentTargetFragmentModel k = snippetCreatorParams.b.c().k();
        return this.f8667a.getString(2131240718, new Object[]{snippetCreatorParams.a, ((NodesModel) k.t().a().get(0)).g()});
    }
}
