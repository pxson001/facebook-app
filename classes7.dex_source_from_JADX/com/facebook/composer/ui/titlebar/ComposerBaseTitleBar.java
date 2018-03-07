package com.facebook.composer.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Strings;
import java.util.List;

@Deprecated
/* compiled from: tapped_message_button */
public abstract class ComposerBaseTitleBar extends CustomLinearLayout implements FbTitleBar {
    public LayoutInflater f2077a;
    public TitleBarButtonSpec f2078b;
    private final OnClickListener f2079c = new C02131(this);
    public OnToolbarButtonListener f2080d;
    public AbstractFbErrorReporter f2081e;
    public Lazy<NavigationLogger> f2082f;

    /* compiled from: tapped_message_button */
    class C02131 implements OnClickListener {
        final /* synthetic */ ComposerBaseTitleBar f2072a;

        C02131(ComposerBaseTitleBar composerBaseTitleBar) {
            this.f2072a = composerBaseTitleBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 180374880);
            if (!(this.f2072a.f2078b == null || this.f2072a.f2080d == null)) {
                ((NavigationLogger) this.f2072a.f2082f.get()).a("tap_composer_post");
                this.f2072a.f2080d.a(view, this.f2072a.f2078b);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -2077180663, a);
        }
    }

    public static void m2056a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) obj;
        LayoutInflater b = LayoutInflaterMethodAutoProvider.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 137);
        composerBaseTitleBar.f2077a = b;
        composerBaseTitleBar.f2081e = abstractFbErrorReporter;
        composerBaseTitleBar.f2082f = b2;
    }

    public abstract View getPrimaryButtonDivider();

    public abstract SimpleVariableTextLayoutView getPrimaryTextButton();

    protected abstract View getSecondaryButton();

    protected abstract SimpleVariableTextLayoutView getTitleTextView();

    public ComposerBaseTitleBar(Context context) {
        super(context);
        m2057b();
    }

    public ComposerBaseTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2057b();
    }

    private void m2057b() {
        setOrientation(1);
        Class cls = ComposerBaseTitleBar.class;
        m2056a(this, getContext());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -323074532);
        super.onSizeChanged(i, i2, i3, i4);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1322695051, a);
    }

    public void setTitle(String str) {
        final SimpleVariableTextLayoutView titleTextView = getTitleTextView();
        titleTextView.setText(str);
        titleTextView.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ ComposerBaseTitleBar f2074b;

            public boolean onLongClick(View view) {
                SimpleVariableTextLayoutView simpleVariableTextLayoutView = titleTextView;
                int i = 0;
                if (simpleVariableTextLayoutView.q != null && simpleVariableTextLayoutView.q.getLineCount() > 0 && simpleVariableTextLayoutView.q.getEllipsisCount(0) > 0) {
                    i = 1;
                }
                if (i == 0) {
                    return false;
                }
                Toast makeText = Toast.makeText(this.f2074b.getContext(), (CharSequence) titleTextView.c, 1);
                makeText.setGravity(48, 0, 0);
                makeText.show();
                return true;
            }
        });
    }

    public void setTitle(int i) {
        setTitle((String) getContext().getResources().getText(i));
    }

    public void setHasBackButton(boolean z) {
        if (!z) {
            this.f2081e.a(getClass().getName() + "#setHasBackButton", "All composer title has back button.");
        }
    }

    public void setHasFbLogo(boolean z) {
    }

    public final void m2058a(OnClickListener onClickListener) {
    }

    public void setTitlebarAsModal(OnClickListener onClickListener) {
    }

    public void setCustomTitleView(View view) {
        this.f2081e.a(getClass().getName() + "#setCustomTitleView", "method not supported");
    }

    public final View f_(int i) {
        this.f2081e.a(getClass().getName() + "#setCustomTitleView", "method not supported");
        return null;
    }

    public final boolean m2060a() {
        return false;
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        if (list.isEmpty()) {
            this.f2078b = null;
        } else {
            this.f2078b = (TitleBarButtonSpec) list.get(0);
        }
        getPrimaryTextButton().setVisibility(8);
        getPrimaryButtonDivider().setVisibility(8);
        if (this.f2078b != null && this.f2078b != TitleBarButtonSpec.b) {
            if (!Strings.isNullOrEmpty(this.f2078b.i)) {
                getPrimaryTextButton().setText(this.f2078b.i);
                getPrimaryTextButton().setVisibility(0);
                getPrimaryButtonDivider().setVisibility(0);
            }
            if (this.f2078b.k != null) {
                getPrimaryTextButton().setContentDescription(this.f2078b.k);
            }
            getPrimaryTextButton().setEnabled(this.f2078b.t);
        }
    }

    public void setOnToolbarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        this.f2080d = onToolbarButtonListener;
        getPrimaryTextButton().setOnClickListener(this.f2079c);
    }

    public void setOnBackPressedListener(final OnBackPressedListener onBackPressedListener) {
        getSecondaryButton().setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposerBaseTitleBar f2076b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1241740633);
                ((NavigationLogger) this.f2076b.f2082f.get()).a("tap_top_left_nav");
                onBackPressedListener.a();
                Logger.a(2, EntryType.UI_INPUT_END, 1725519031, a);
            }
        });
    }

    public void setShowDividers(boolean z) {
    }

    public void mo94a(HarrisonPlusIconType harrisonPlusIconType) {
    }
}
