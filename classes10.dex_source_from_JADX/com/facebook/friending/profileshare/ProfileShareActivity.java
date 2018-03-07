package com.facebook.friending.profileshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: addAdminsOperation */
public class ProfileShareActivity extends FbFragmentActivity {

    /* compiled from: addAdminsOperation */
    class C28861 implements OnClickListener {
        final /* synthetic */ ProfileShareActivity f20243a;

        C28861(ProfileShareActivity profileShareActivity) {
            this.f20243a = profileShareActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 266940721);
            this.f20243a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 970536077, a);
        }
    }

    protected final void m20532b(@Nullable Bundle bundle) {
        overridePendingTransition(0, 0);
        setContentView(2130906475);
        a(2131566405).setOnClickListener(new C28861(this));
        if (bundle == null) {
            kO_().a().a(2131566405, new ProfileShareFragment()).b();
        }
    }

    public void onBackPressed() {
        Fragment a = kO_().a(2131566405);
        if (!(a instanceof CanHandleBackPressed) || !((CanHandleBackPressed) a).O_()) {
            super.onBackPressed();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
