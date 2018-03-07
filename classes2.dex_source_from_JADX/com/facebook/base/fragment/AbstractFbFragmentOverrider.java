package com.facebook.base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: offline_supported */
public class AbstractFbFragmentOverrider extends AbstractFbFragmentListener implements FbFragmentListener {
    public void m16671f(Fragment fragment) {
    }

    public Optional<Boolean> m16666a(Fragment fragment, MenuItem menuItem) {
        return Absent.INSTANCE;
    }

    public Optional<View> m16667a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Absent.INSTANCE;
    }

    public final Optional<View> m16669d() {
        return Absent.INSTANCE;
    }

    public boolean m16668a(Fragment fragment, Menu menu) {
        return false;
    }

    public MenuInflater m16670e() {
        return null;
    }
}
