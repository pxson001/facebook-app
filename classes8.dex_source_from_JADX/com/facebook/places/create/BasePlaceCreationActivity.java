package com.facebook.places.create;

import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: centered_in_gridline */
public abstract class BasePlaceCreationActivity extends FbFragmentActivity implements HasTitleBar {
    private ComposerBaseTitleBar f18118p;

    /* compiled from: centered_in_gridline */
    class C19581 implements OnBackPressedListener {
        final /* synthetic */ BasePlaceCreationActivity f18117a;

        C19581(BasePlaceCreationActivity basePlaceCreationActivity) {
            this.f18117a = basePlaceCreationActivity;
        }

        public final void m22092a() {
            this.f18117a.onBackPressed();
        }
    }

    protected abstract String mo1087i();

    protected void mo1086b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906247);
        this.f18118p = (ComposerBaseTitleBar) a(2131560528);
        this.f18118p.setOnBackPressedListener(new C19581(this));
        ComposerBaseTitleBar composerBaseTitleBar = this.f18118p;
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.b = TitleBarButtonSpec.b;
        stateBuilder = stateBuilder;
        stateBuilder.a = mo1087i();
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        ComposerTitleBar composerTitleBar = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
    }

    public final void a_(String str) {
        this.f18118p.setTitle(str);
    }

    public final void y_(int i) {
        this.f18118p.setTitle(i);
    }

    public void setCustomTitle(View view) {
    }

    public final View lh_() {
        return null;
    }

    public final void m22094a(TitleBarButtonSpec titleBarButtonSpec) {
        this.f18118p.setButtonSpecs(ImmutableList.of(titleBarButtonSpec));
    }

    public final void m22096b(TitleBarButtonSpec titleBarButtonSpec) {
        this.f18118p.setButtonSpecs(ImmutableList.of(titleBarButtonSpec));
    }

    public final void m22093a(OnToolbarButtonListener onToolbarButtonListener) {
        this.f18118p.setOnToolbarButtonListener(onToolbarButtonListener);
    }

    public final void kg_() {
        this.f18118p.setButtonSpecs(RegularImmutableList.a);
    }

    public final void m22097c(boolean z) {
    }
}
