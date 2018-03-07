package com.facebook.pages.identity.contextitems;

import android.os.Bundle;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;

/* compiled from: pitchEnabled */
public class PageContextItemsAddPhotoMenuHandler {
    private final FbUriIntentHandler f3801a;

    @Inject
    public PageContextItemsAddPhotoMenuHandler(FbUriIntentHandler fbUriIntentHandler) {
        this.f3801a = fbUriIntentHandler;
    }

    public final void m4764a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", pageContextItemHandlingData.i);
        this.f3801a.a(view.getContext(), StringFormatUtil.a(FBLinks.dr, new Object[]{Long.valueOf(pageContextItemHandlingData.a)}), bundle);
    }
}
