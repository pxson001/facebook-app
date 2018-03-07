package com.facebook.adsexperiencetool;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;

/* compiled from: errorData */
public class AdsInjectConfirmationActivity extends FbFragmentActivity {

    /* compiled from: errorData */
    class C20111 implements OnClickListener {
        final /* synthetic */ AdsInjectConfirmationActivity f14417a;

        C20111(AdsInjectConfirmationActivity adsInjectConfirmationActivity) {
            this.f14417a = adsInjectConfirmationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 186211592);
            this.f14417a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 2008318628, a);
        }
    }

    protected final void m14503b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903193);
        m14502i();
        kO_().a().a(2131559446, new AdsInjectConfirmationFragment()).b();
    }

    private void m14502i() {
        if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
            fbTitleBar.setHasBackButton(true);
            fbTitleBar.setTitle(2131241785);
            fbTitleBar.a(new C20111(this));
        }
    }
}
