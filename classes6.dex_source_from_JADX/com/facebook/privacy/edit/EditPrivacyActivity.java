package com.facebook.privacy.edit;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: fetchCreationStory */
public final class EditPrivacyActivity extends FbFragmentActivity {

    /* compiled from: fetchCreationStory */
    class C10071 implements OnClickListener {
        final /* synthetic */ EditPrivacyActivity f15005a;

        C10071(EditPrivacyActivity editPrivacyActivity) {
            this.f15005a = editPrivacyActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1949229567);
            this.f15005a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 320418936, a);
        }
    }

    public final void m22588b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903952);
        if (FbTitleBarUtil.m8799b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
            fbTitleBar.setTitle(getString(2131234234));
            fbTitleBar.a(new C10071(this));
        }
        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            EditPrivacyFragment editPrivacyFragment = new EditPrivacyFragment();
            editPrivacyFragment.g(extras);
            kO_().a().b(2131558429, editPrivacyFragment).b();
        }
    }
}
