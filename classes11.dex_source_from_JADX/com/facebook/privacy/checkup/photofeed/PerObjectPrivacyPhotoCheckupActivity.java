package com.facebook.privacy.checkup.photofeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: StatusBarHeight */
public final class PerObjectPrivacyPhotoCheckupActivity extends FbFragmentActivity {
    public PerObjectPrivacyPhotoCheckupFragment f10988p;

    /* compiled from: StatusBarHeight */
    class C13021 implements OnClickListener {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupActivity f10986a;

        C13021(PerObjectPrivacyPhotoCheckupActivity perObjectPrivacyPhotoCheckupActivity) {
            this.f10986a = perObjectPrivacyPhotoCheckupActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -708754812);
            this.f10986a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1372635925, a);
        }
    }

    /* compiled from: StatusBarHeight */
    class C13032 extends OnToolbarButtonListener {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupActivity f10987a;

        C13032(PerObjectPrivacyPhotoCheckupActivity perObjectPrivacyPhotoCheckupActivity) {
            this.f10987a = perObjectPrivacyPhotoCheckupActivity;
        }

        public final void m11387a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f10987a.f10988p != null) {
                this.f10987a.f10988p.al.a(new ToastBuilder(2131242324));
            }
            this.f10987a.finish();
        }
    }

    protected final void m11390b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130906188);
        m11389i();
        this.f10988p = (PerObjectPrivacyPhotoCheckupFragment) kO_().a(2131558429);
        if (this.f10988p == null) {
            Intent intent = getIntent();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(intent.getExtras());
            PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment = new PerObjectPrivacyPhotoCheckupFragment();
            perObjectPrivacyPhotoCheckupFragment.g(bundle2);
            this.f10988p = perObjectPrivacyPhotoCheckupFragment;
            kO_().a().b(2131558429, this.f10988p).b();
        }
    }

    private void m11389i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(2131242314);
        fbTitleBar.a(new C13021(this));
        Builder a = TitleBarButtonSpec.a();
        a.g = getResources().getString(2131230752);
        a = a;
        a.j = getResources().getString(2131230752);
        a = a;
        a.d = true;
        TitleBarButtonSpec a2 = a.a();
        fbTitleBar.setOnToolbarButtonListener(new C13032(this));
        fbTitleBar.setButtonSpecs(ImmutableList.of(a2));
    }
}
