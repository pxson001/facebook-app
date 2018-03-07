package com.facebook.auth.login.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.base.fragment.AbstractNavigableFragmentController;

/* compiled from: profile cannot be null */
public class AuthNavigationController extends AbstractNavigableFragmentController {
    private boolean f7376a;

    public final void m10486b(Intent intent) {
        this.f7376a = true;
        super.b(intent);
    }

    public final void m10485a(Fragment fragment) {
        super.a(fragment);
        this.f7376a = false;
    }
}
