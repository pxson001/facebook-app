package com.facebook.katana.activity;

import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$34 implements OnActionButtonClickListener {
    final /* synthetic */ FbMainTabActivity f24220a;

    FbMainTabActivity$34(FbMainTabActivity fbMainTabActivity) {
        this.f24220a = fbMainTabActivity;
    }

    public final void m25509a(View view) {
        ((SecureContextHelper) this.f24220a.C.get()).b(((Fb4aUriIntentMapper) this.f24220a.s.get()).a(this.f24220a.ba, FBLinks.O), this.f24220a.ba);
    }
}
