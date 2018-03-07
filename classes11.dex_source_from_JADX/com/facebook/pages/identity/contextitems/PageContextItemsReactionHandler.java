package com.facebook.pages.identity.contextitems;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.reaction.action.PagesReactionManager;
import javax.inject.Inject;

/* compiled from: personal_update_mutation_failure */
public class PageContextItemsReactionHandler {
    private final PagesReactionManager f3878a;
    private final Context f3879b;
    private final FbUriIntentHandler f3880c;

    @Inject
    public PageContextItemsReactionHandler(Context context, PagesReactionManager pagesReactionManager, FbUriIntentHandler fbUriIntentHandler) {
        this.f3879b = context;
        this.f3878a = pagesReactionManager;
        this.f3880c = fbUriIntentHandler;
    }

    public final void m4796a(ContextItemFieldsModel contextItemFieldsModel, PageContextItemHandlingData pageContextItemHandlingData) {
        GraphQLEntityCardContextItemType d = contextItemFieldsModel.d();
        String uuid = SafeUUIDGenerator.a().toString();
        this.f3878a.a(d, pageContextItemHandlingData.a, uuid);
        Bundle bundle = new Bundle();
        bundle.putString("reaction_session_id", uuid);
        bundle.putString("source_name", pageContextItemHandlingData.e);
        bundle.putString("page_context_item_type", d.toString());
        bundle.putLong("com.facebook.katana.profile.id", pageContextItemHandlingData.a);
        this.f3880c.a(this.f3879b, StringFormatUtil.a(FBLinks.ao, new Object[]{Long.valueOf(pageContextItemHandlingData.a)}), bundle);
    }
}
