package com.facebook.pages.identity.contextitems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: perf_albums_list_fetch */
public class PageContextItemsViewMenuHandler {
    private final PageContextItemsFallbackHandler f3887a;
    private final SecureContextHelper f3888b;
    private final UriIntentMapper f3889c;
    private final Provider<GatekeeperStore> f3890d;

    @Inject
    public PageContextItemsViewMenuHandler(PageContextItemsFallbackHandler pageContextItemsFallbackHandler, Provider<GatekeeperStore> provider, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f3887a = pageContextItemsFallbackHandler;
        this.f3888b = secureContextHelper;
        this.f3889c = uriIntentMapper;
        this.f3890d = provider;
    }

    public final void m4799a(View view, ContextItemFieldsModel contextItemFieldsModel, PageContextItemHandlingData pageContextItemHandlingData) {
        if (pageContextItemHandlingData.b) {
            Intent a = this.f3889c.a(view.getContext(), StringFormatUtil.a(FBLinks.dv, new Object[]{Long.valueOf(pageContextItemHandlingData.a)}));
            if (a != null) {
                this.f3888b.a(a, view.getContext());
            }
        } else if (pageContextItemHandlingData.c && ((GatekeeperStoreImpl) this.f3890d.get()).a(PagesFb4aAbTestGatekeepers.c, false)) {
            Context context = view.getContext();
            Intent a2 = this.f3889c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dw, Long.valueOf(pageContextItemHandlingData.a)));
            a2.putExtra("profile_name", pageContextItemHandlingData.e);
            this.f3888b.a(a2, context);
        } else {
            this.f3887a.m4774a(contextItemFieldsModel);
        }
    }
}
