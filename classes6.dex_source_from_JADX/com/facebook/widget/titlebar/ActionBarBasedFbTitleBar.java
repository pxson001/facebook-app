package com.facebook.widget.titlebar;

import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: reaction_story_id */
public class ActionBarBasedFbTitleBar implements FbTitleBar {
    private final Optional<FragmentManagerHost> f6220a;
    private final ActionBar f6221b;
    private final FbTitleBarMenuHelper f6222c;
    private ImmutableList<TitleBarButtonSpec> f6223d;
    private OnToolbarButtonListener f6224e;
    private FbTitleBar$OnBackPressedListener f6225f;

    public ActionBarBasedFbTitleBar(FragmentManagerHost fragmentManagerHost, ActionBar actionBar) {
        this(Optional.of(fragmentManagerHost), actionBar);
    }

    private ActionBarBasedFbTitleBar(Optional<FragmentManagerHost> optional, ActionBar actionBar) {
        this.f6223d = RegularImmutableList.a;
        this.f6220a = optional;
        this.f6221b = actionBar;
        this.f6222c = new FbTitleBarMenuHelper();
    }

    public void setTitle(String str) {
        this.f6221b.a(10, 26);
        this.f6221b.a(str);
    }

    public void setTitle(int i) {
        this.f6221b.a(10, 26);
        this.f6221b.b(i);
    }

    public void setHasBackButton(boolean z) {
        int i = 0;
        int i2 = z ? 2 : 0;
        ActionBar actionBar = this.f6221b;
        if (z) {
            i = 4;
        }
        actionBar.a(i | i2, i2 | 4);
    }

    public void setCustomTitleView(View view) {
        this.f6221b.a(18, 26);
        this.f6221b.a(view);
    }

    public final View f_(int i) {
        View inflate = LayoutInflater.from(this.f6221b.e()).inflate(i, null, false);
        setCustomTitleView(inflate);
        return inflate;
    }

    public final boolean m8770a() {
        return true;
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        this.f6223d = ImmutableList.copyOf(list);
        if (this.f6220a.isPresent()) {
            ((FragmentManagerHost) this.f6220a.get()).gE_();
        }
    }

    public void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        this.f6224e = onToolbarButtonListener;
    }

    public void setOnBackPressedListener(FbTitleBar$OnBackPressedListener fbTitleBar$OnBackPressedListener) {
        this.f6225f = fbTitleBar$OnBackPressedListener;
    }

    public void setShowDividers(boolean z) {
    }

    public void setHasFbLogo(boolean z) {
    }

    public final void m8769a(OnClickListener onClickListener) {
    }

    public void setTitlebarAsModal(OnClickListener onClickListener) {
    }

    public final void m8768a(Menu menu) {
        FbTitleBarMenuHelper.m8793a(menu, this.f6223d);
        this.f6222c.m8795a(menu, this.f6223d, this.f6224e);
    }

    public final boolean m8771a(MenuItem menuItem) {
        Object obj;
        FbTitleBar$OnBackPressedListener fbTitleBar$OnBackPressedListener = this.f6225f;
        if (menuItem.getItemId() != 16908332 || fbTitleBar$OnBackPressedListener == null) {
            obj = null;
        } else {
            fbTitleBar$OnBackPressedListener.mo450a();
            obj = 1;
        }
        if (obj != null) {
            return true;
        }
        if (this.f6224e == null) {
            return false;
        }
        return FbTitleBarMenuHelper.m8794a(menuItem, this.f6223d, this.f6224e);
    }
}
