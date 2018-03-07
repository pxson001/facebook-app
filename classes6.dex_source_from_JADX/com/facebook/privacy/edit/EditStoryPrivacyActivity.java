package com.facebook.privacy.edit;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: fetch-album */
public final class EditStoryPrivacyActivity extends FbFragmentActivity {
    public EditStoryPrivacyFragment f15042p;

    /* compiled from: fetch-album */
    class C10151 implements OnClickListener {
        final /* synthetic */ EditStoryPrivacyActivity f15040a;

        C10151(EditStoryPrivacyActivity editStoryPrivacyActivity) {
            this.f15040a = editStoryPrivacyActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -360933708);
            this.f15040a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -2022905257, a);
        }
    }

    /* compiled from: fetch-album */
    class C10162 extends OnToolbarButtonListener {
        final /* synthetic */ EditStoryPrivacyActivity f15041a;

        C10162(EditStoryPrivacyActivity editStoryPrivacyActivity) {
            this.f15041a = editStoryPrivacyActivity;
        }

        public final void m22608a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f15041a.f15042p.m22628e();
        }
    }

    public final void m22610b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903958);
        if (FbTitleBarUtil.m8799b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
            fbTitleBar.setShowDividers(true);
            fbTitleBar.setHasBackButton(false);
            fbTitleBar.a(new C10151(this));
            Builder a = TitleBarButtonSpec.a();
            a.g = getString(2131234228);
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
            fbTitleBar.setOnToolbarButtonListener(new C10162(this));
        }
        Bundle extras = getIntent().getExtras();
        EditStoryPrivacyFragment editStoryPrivacyFragment = new EditStoryPrivacyFragment();
        editStoryPrivacyFragment.g(extras);
        this.f15042p = editStoryPrivacyFragment;
        kO_().a().b(2131561138, this.f15042p).b();
    }

    public final void onBackPressed() {
        if (this.f15042p != null) {
            this.f15042p.m22626b();
        } else {
            super.onBackPressed();
        }
    }
}
