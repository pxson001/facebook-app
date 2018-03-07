package com.facebook.localcontent.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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
import javax.annotation.Nullable;

/* compiled from: ec_config_profile_picture */
public class PhotoMenuUploadActivity extends FbFragmentActivity implements HasTitleBar {
    private PhotoMenuUploadFragment f15015p;
    private ComposerBaseTitleBar f15016q;
    private ComposerTitleBar f15017r;

    /* compiled from: ec_config_profile_picture */
    class C16261 implements OnBackPressedListener {
        final /* synthetic */ PhotoMenuUploadActivity f15014a;

        C16261(PhotoMenuUploadActivity photoMenuUploadActivity) {
            this.f15014a = photoMenuUploadActivity;
        }

        public final void m17451a() {
            this.f15014a.onBackPressed();
        }
    }

    protected final void m17456b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130906197);
        m17452i();
        m17453j();
    }

    private void m17452i() {
        FragmentManager kO_ = kO_();
        this.f15015p = (PhotoMenuUploadFragment) kO_.a(2131558429);
        if (this.f15015p == null) {
            this.f15015p = new PhotoMenuUploadFragment();
            this.f15015p.g(getIntent().getExtras());
        }
        kO_.a().b(2131558429, this.f15015p).b();
    }

    private void m17453j() {
        this.f15016q = (ComposerBaseTitleBar) a(2131560528);
        this.f15016q.setOnBackPressedListener(new C16261(this));
        ComposerBaseTitleBar composerBaseTitleBar = this.f15016q;
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = getResources().getString(2131239098);
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        this.f15017r = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f15015p.m17471b(i, i2, intent);
    }

    public void onBackPressed() {
        this.f15015p.O_();
    }

    public final void a_(String str) {
        ComposerTitleBar composerTitleBar = this.f15017r;
        StateBuilder a = this.f15017r.b.a();
        a.a = str;
        composerTitleBar.a(a.a());
    }

    public final void y_(int i) {
        ComposerTitleBar composerTitleBar = this.f15017r;
        StateBuilder a = this.f15017r.b.a();
        a.a = getString(i);
        composerTitleBar.a(a.a());
    }

    public void setCustomTitle(View view) {
        throw new UnsupportedOperationException();
    }

    public final View lh_() {
        throw new UnsupportedOperationException();
    }

    public final void m17455a(TitleBarButtonSpec titleBarButtonSpec) {
        ComposerTitleBar composerTitleBar = this.f15017r;
        StateBuilder a = this.f15017r.b.a();
        a.b = titleBarButtonSpec;
        composerTitleBar.a(a.a());
    }

    public final void m17457b(TitleBarButtonSpec titleBarButtonSpec) {
        ComposerTitleBar composerTitleBar = this.f15017r;
        StateBuilder a = this.f15017r.b.a();
        a.b = titleBarButtonSpec;
        composerTitleBar.a(a.a());
    }

    public final void m17454a(OnToolbarButtonListener onToolbarButtonListener) {
        ComposerTitleBar composerTitleBar = this.f15017r;
        StateBuilder a = this.f15017r.b.a();
        a.c = onToolbarButtonListener;
        composerTitleBar.a(a.a());
    }

    public final void kg_() {
        throw new UnsupportedOperationException();
    }

    public final void m17458c(boolean z) {
        throw new UnsupportedOperationException();
    }
}
