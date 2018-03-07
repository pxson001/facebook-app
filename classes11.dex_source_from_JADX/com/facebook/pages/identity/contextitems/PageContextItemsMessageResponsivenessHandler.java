package com.facebook.pages.identity.contextitems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.application.Product;
import com.facebook.content.SecureContextHelper;
import com.facebook.ipc.pages.PagesManagerConstants.PopupState;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PagesContextRowsPmaGoToMessagesTabEvent;
import com.facebook.pages.deeplinking.PageAdminUtils;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: phone_confirmation_view_loaded */
public class PageContextItemsMessageResponsivenessHandler {
    private PageAdminUtils f3845a;
    private UriIntentMapper f3846b;
    private SecureContextHelper f3847c;
    private PageEventBus f3848d;
    private Product f3849e;

    @Inject
    public PageContextItemsMessageResponsivenessHandler(PageAdminUtils pageAdminUtils, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, PageEventBus pageEventBus, Product product) {
        this.f3845a = pageAdminUtils;
        this.f3846b = uriIntentMapper;
        this.f3847c = secureContextHelper;
        this.f3848d = pageEventBus;
        this.f3849e = product;
    }

    public final void m4783a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        Preconditions.checkNotNull(Long.valueOf(pageContextItemHandlingData.a));
        if (this.f3849e == Product.PAA) {
            this.f3848d.a(new PagesContextRowsPmaGoToMessagesTabEvent());
            return;
        }
        Intent a = this.f3845a.a(pageContextItemHandlingData.a);
        if (a != null) {
            PageAdminUtils pageAdminUtils = this.f3845a;
            PopupState popupState = PopupState.MESSAGES;
            Context context = view.getContext();
            if (a != null) {
                a.putExtra("popup_state", popupState.toString());
                pageAdminUtils.b.b(a, context);
            }
            return;
        }
        a = this.f3846b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/messages/?pageID=%s", Long.valueOf(pageContextItemHandlingData.a)));
        a.putExtra("uri_unhandled_report_category_name", "PageFacewebUriNotHandled");
        this.f3847c.a(a, view.getContext());
    }
}
