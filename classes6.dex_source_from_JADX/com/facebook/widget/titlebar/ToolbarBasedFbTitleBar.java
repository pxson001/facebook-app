package com.facebook.widget.titlebar;

import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: quick_replies */
public class ToolbarBasedFbTitleBar implements FbTitleBar {
    private static final int f6262a = 2130837524;
    private static final int f6263b = 2130837525;
    private final Toolbar f6264c;
    private final FbTitleBarMenuHelper f6265d;
    public ImmutableList<TitleBarButtonSpec> f6266e = RegularImmutableList.a;
    @Nullable
    private View f6267f;
    @Nullable
    public FbTitleBar$OnBackPressedListener f6268g;
    @Nullable
    public OnToolbarButtonListener f6269h;
    private final OnClickListener f6270i = new C03771(this);
    private final OnMenuItemClickListener f6271j = new C03782(this);

    /* compiled from: quick_replies */
    class C03771 implements OnClickListener {
        final /* synthetic */ ToolbarBasedFbTitleBar f6258a;

        C03771(ToolbarBasedFbTitleBar toolbarBasedFbTitleBar) {
            this.f6258a = toolbarBasedFbTitleBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -750918816);
            if (this.f6258a.f6268g != null) {
                this.f6258a.f6268g.mo450a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -691400030, a);
        }
    }

    /* compiled from: quick_replies */
    class C03782 implements OnMenuItemClickListener {
        final /* synthetic */ ToolbarBasedFbTitleBar f6259a;

        C03782(ToolbarBasedFbTitleBar toolbarBasedFbTitleBar) {
            this.f6259a = toolbarBasedFbTitleBar;
        }

        public final boolean m8810a(MenuItem menuItem) {
            if (this.f6259a.f6269h == null) {
                return false;
            }
            return FbTitleBarMenuHelper.m8794a(menuItem, this.f6259a.f6266e, this.f6259a.f6269h);
        }
    }

    public ToolbarBasedFbTitleBar(Toolbar toolbar) {
        this.f6264c = (Toolbar) Preconditions.checkNotNull(toolbar);
        this.f6265d = new FbTitleBarMenuHelper();
        this.f6264c.setNavigationOnClickListener(this.f6270i);
        this.f6264c.D = this.f6271j;
    }

    public void setTitle(String str) {
        m8812b();
        this.f6264c.setTitle(str);
    }

    public void setTitle(int i) {
        setTitle(this.f6264c.getResources().getString(i));
    }

    public void setHasBackButton(boolean z) {
        if (z) {
            this.f6264c.setNavigationIcon(f6262a);
        } else {
            this.f6264c.setNavigationIcon(null);
        }
    }

    public void setCustomTitleView(View view) {
        this.f6264c.setTitle("");
        m8812b();
        this.f6267f = view;
        this.f6264c.addView(this.f6267f);
    }

    private void m8812b() {
        if (this.f6267f != null) {
            this.f6264c.removeView(this.f6267f);
        }
    }

    public final View f_(int i) {
        View inflate = LayoutInflater.from(this.f6264c.getContext()).inflate(i, this.f6264c, false);
        setCustomTitleView(inflate);
        return inflate;
    }

    public final boolean m8814a() {
        return true;
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        this.f6266e = ImmutableList.copyOf(list);
        Menu menu = this.f6264c.getMenu();
        menu.clear();
        FbTitleBarMenuHelper.m8793a(menu, this.f6266e);
        this.f6265d.m8795a(menu, this.f6266e, this.f6269h);
    }

    public void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        this.f6269h = onToolbarButtonListener;
    }

    public void setOnBackPressedListener(FbTitleBar$OnBackPressedListener fbTitleBar$OnBackPressedListener) {
        this.f6268g = fbTitleBar$OnBackPressedListener;
    }

    public final void m8813a(OnClickListener onClickListener) {
        throw new UnsupportedOperationException("Not supported. Try setHasBackButton().");
    }

    public void setTitlebarAsModal(final OnClickListener onClickListener) {
        setHasBackButton(false);
        this.f6264c.setNavigationIcon(f6263b);
        setOnBackPressedListener(new FbTitleBar$OnBackPressedListener(this) {
            final /* synthetic */ ToolbarBasedFbTitleBar f6261b;

            public final void mo450a() {
                onClickListener.onClick(null);
            }
        });
    }

    public void setShowDividers(boolean z) {
        throw new UnsupportedOperationException("Not supported.");
    }

    public void setHasFbLogo(boolean z) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
