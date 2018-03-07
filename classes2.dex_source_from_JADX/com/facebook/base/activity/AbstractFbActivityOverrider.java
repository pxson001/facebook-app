package com.facebook.base.activity;

import android.app.Activity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.activitylistener.FbActivityListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: suggested_friend_id */
public class AbstractFbActivityOverrider extends AbstractFbActivityListener implements FbActivityListener {
    public void m6428a(Activity activity, FbActivitySuper fbActivitySuper) {
    }

    public MenuInflater m6434c() {
        return null;
    }

    public boolean m6432b(int i) {
        return false;
    }

    public Optional<Boolean> m6427a(Activity activity, FbActivitySuper fbActivitySuper, int i, MenuItem menuItem) {
        return Absent.INSTANCE;
    }

    public final Optional<Boolean> m6436e() {
        return Absent.INSTANCE;
    }

    public final Optional<Boolean> m6437f() {
        return Absent.INSTANCE;
    }

    public boolean m6429a(View view) {
        return false;
    }

    public boolean m6430a(View view, LayoutParams layoutParams) {
        return false;
    }

    public boolean m6433b(View view, LayoutParams layoutParams) {
        return false;
    }

    public boolean m6431a(FbActivitySuper fbActivitySuper) {
        return false;
    }

    public final Optional<View> m6435d() {
        return null;
    }
}
