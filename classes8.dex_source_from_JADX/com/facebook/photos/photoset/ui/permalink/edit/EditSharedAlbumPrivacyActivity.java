package com.facebook.photos.photoset.ui.permalink.edit;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: clip */
public class EditSharedAlbumPrivacyActivity extends FbFragmentActivity {

    /* compiled from: clip */
    class C19211 implements OnClickListener {
        final /* synthetic */ EditSharedAlbumPrivacyActivity f17876a;

        C19211(EditSharedAlbumPrivacyActivity editSharedAlbumPrivacyActivity) {
            this.f17876a = editSharedAlbumPrivacyActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -909799850);
            this.f17876a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1813539869, a);
        }
    }

    public final void m21846b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903952);
        if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
            fbTitleBar.setTitle(getString(2131234234));
            fbTitleBar.a(new C19211(this));
        }
        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            EditSharedAlbumPrivacyFragment editSharedAlbumPrivacyFragment = new EditSharedAlbumPrivacyFragment();
            editSharedAlbumPrivacyFragment.g(extras);
            kO_().a().b(2131558429, editSharedAlbumPrivacyFragment).b();
        }
    }
}
