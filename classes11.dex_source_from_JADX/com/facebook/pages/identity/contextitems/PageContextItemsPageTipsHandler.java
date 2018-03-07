package com.facebook.pages.identity.contextitems;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityPageTipView;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.reaction.action.PagesReactionManager;
import javax.inject.Inject;

/* compiled from: phone_acquisition_embedded */
public class PageContextItemsPageTipsHandler {
    private final PagesReactionManager f3851a;
    private final Context f3852b;
    private final FbUriIntentHandler f3853c;

    @Inject
    public PageContextItemsPageTipsHandler(Context context, PagesReactionManager pagesReactionManager, FbUriIntentHandler fbUriIntentHandler) {
        this.f3852b = context;
        this.f3851a = pagesReactionManager;
        this.f3853c = fbUriIntentHandler;
    }

    public final void m4784a(PageContextItemHandlingData pageContextItemHandlingData) {
        String uuid = SafeUUIDGenerator.a().toString();
        Surface surface = Surface.ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_CONTEXT_ITEM;
        long j = pageContextItemHandlingData.a;
        this.f3851a.a(surface, j, uuid);
        Bundle a = PageIdentityPageTipView.m3869a(this.f3852b, uuid, j);
        this.f3853c.a(this.f3852b, StringFormatUtil.a(FBLinks.ao, new Object[]{Long.valueOf(j)}), a);
    }
}
