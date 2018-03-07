package com.facebook.katana;

import com.facebook.katana.FacebookLoginActivity.17;
import com.facebook.katana.FacebookLoginActivity.LoginState;

/* compiled from: SECTION_SPLITTER */
class FacebookLoginActivity$17$1 implements Runnable {
    final /* synthetic */ 17 f24191a;

    FacebookLoginActivity$17$1(17 17) {
        this.f24191a = 17;
    }

    public void run() {
        FacebookLoginActivity.a(this.f24191a.a, LoginState.TRANSIENT_AUTH_TOKEN_ENTRY);
    }
}
