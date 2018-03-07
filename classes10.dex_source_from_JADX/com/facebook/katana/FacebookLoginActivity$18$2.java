package com.facebook.katana;

import com.facebook.katana.FacebookLoginActivity.18;

/* compiled from: SECTION_SPLITTER */
class FacebookLoginActivity$18$2 implements Runnable {
    final /* synthetic */ String f24193a;
    final /* synthetic */ String f24194b;
    final /* synthetic */ 18 f24195c;

    FacebookLoginActivity$18$2(18 18, String str, String str2) {
        this.f24195c = 18;
        this.f24193a = str;
        this.f24194b = str2;
    }

    public void run() {
        this.f24195c.a.ba.setEnabled(true);
        FacebookLoginActivity.a(this.f24195c.a, this.f24193a, this.f24194b);
    }
}
