package com.facebook.pages.identity.contextitems;

import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;

/* compiled from: phone_line_one_area_code */
public class PageContextItemsMessagePageHandler {
    private final FbUriIntentHandler f3844a;

    @Inject
    public PageContextItemsMessagePageHandler(FbUriIntentHandler fbUriIntentHandler) {
        this.f3844a = fbUriIntentHandler;
    }

    public final void m4782a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        this.f3844a.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(pageContextItemHandlingData.a)));
    }
}
