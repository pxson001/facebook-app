package com.facebook.messaging.threadview.titlebar;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.ToolbarBasedFbTitleBar;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: platform_login_get_calling_package */
public class ChatHeadsThreadViewFbTitleBar implements FbTitleBar {
    private final ToolbarBasedFbTitleBar f4813a;
    public final LayoutInflater f4814b;
    public final ViewGroup f4815c;
    @Nullable
    public OnToolbarButtonListener f4816d;

    public ChatHeadsThreadViewFbTitleBar(Toolbar toolbar) {
        this.f4814b = LayoutInflater.from(toolbar.getContext());
        this.f4813a = new ToolbarBasedFbTitleBar(toolbar);
        this.f4815c = (ViewGroup) this.f4814b.inflate(2130907392, toolbar, false);
        toolbar.addView(this.f4815c);
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        this.f4815c.removeAllViews();
        for (final TitleBarButtonSpec titleBarButtonSpec : list) {
            final TitleBarButton titleBarButton = (TitleBarButton) this.f4814b.inflate(2130907391, this.f4815c, false);
            titleBarButton.m4383a(titleBarButtonSpec);
            titleBarButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ChatHeadsThreadViewFbTitleBar f4812c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1714239256);
                    if (this.f4812c.f4816d != null) {
                        this.f4812c.f4816d.a(titleBarButton, titleBarButtonSpec);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 610868719, a);
                }
            });
            this.f4815c.addView(titleBarButton);
            if (titleBarButtonSpec.j > 0) {
                titleBarButton.getLayoutParams().width = titleBarButtonSpec.j;
            }
        }
    }

    public void setOnToolbarButtonListener(@Nullable OnToolbarButtonListener onToolbarButtonListener) {
        this.f4816d = onToolbarButtonListener;
    }

    public void setTitle(String str) {
        this.f4813a.setTitle(str);
    }

    public void setTitle(int i) {
        this.f4813a.setTitle(i);
    }

    public void setHasBackButton(boolean z) {
        this.f4813a.setHasBackButton(z);
    }

    public void setCustomTitleView(View view) {
        this.f4813a.setCustomTitleView(view);
    }

    public final View f_(int i) {
        return this.f4813a.f_(i);
    }

    public final boolean m4366a() {
        return this.f4813a.a();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.f4813a.setOnBackPressedListener(onBackPressedListener);
    }

    public final void m4365a(OnClickListener onClickListener) {
        this.f4813a.a(onClickListener);
    }

    public void setTitlebarAsModal(OnClickListener onClickListener) {
        this.f4813a.setTitlebarAsModal(onClickListener);
    }

    public void setShowDividers(boolean z) {
        this.f4813a.setShowDividers(z);
    }

    public void setHasFbLogo(boolean z) {
        this.f4813a.setHasFbLogo(z);
    }
}
