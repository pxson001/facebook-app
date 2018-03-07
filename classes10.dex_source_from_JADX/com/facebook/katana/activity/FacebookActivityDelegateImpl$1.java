package com.facebook.katana.activity;

import android.view.View;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;

/* compiled from: SEARCH_RADIUS_10 */
public class FacebookActivityDelegateImpl$1 implements OnActionButtonClickListener {
    final /* synthetic */ FacebookActivityDelegateImpl f24207a;

    public FacebookActivityDelegateImpl$1(FacebookActivityDelegateImpl facebookActivityDelegateImpl) {
        this.f24207a = facebookActivityDelegateImpl;
    }

    public final void m25500a(View view) {
        ((BookmarksMenuHost) this.f24207a.e).titleBarPrimaryActionClickHandler(view);
    }
}
