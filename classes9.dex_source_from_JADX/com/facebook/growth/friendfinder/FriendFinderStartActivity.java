package com.facebook.growth.friendfinder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.growth.prefs.FriendFinderPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;

/* compiled from: participant_pics */
public class FriendFinderStartActivity extends FbFragmentActivity {
    @Inject
    SecureContextHelper f7278p;
    @Inject
    FbSharedPreferences f7279q;
    @Inject
    @LoggedInUserId
    String f7280r;
    private boolean f7281s = false;

    /* compiled from: participant_pics */
    class C07891 implements OnClickListener {
        final /* synthetic */ FriendFinderStartActivity f7277a;

        C07891(FriendFinderStartActivity friendFinderStartActivity) {
            this.f7277a = friendFinderStartActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2093094874);
            this.f7277a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1344903103, a);
        }
    }

    private static <T extends Context> void m7552a(Class<T> cls, T t) {
        m7553a((Object) t, (Context) t);
    }

    public static void m7553a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendFinderStartActivity) obj).m7551a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector));
    }

    private void m7551a(SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences, String str) {
        this.f7278p = secureContextHelper;
        this.f7279q = fbSharedPreferences;
        this.f7280r = str;
    }

    protected final void m7555b(Bundle bundle) {
        super.b(bundle);
        Class cls = FriendFinderStartActivity.class;
        m7553a((Object) this, (Context) this);
        CIFlow fromSerializable = CIFlow.fromSerializable(getIntent().getSerializableExtra("ci_flow"));
        String stringExtra = getIntent().getStringExtra("ccu_ref");
        this.f7281s = getIntent().getBooleanExtra("force_show_legal_screen", false);
        if (m7554i()) {
            setContentView(2130904469);
            FbTitleBarUtil.b(this);
            FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
            fbTitleBar.setTitle(2131233242);
            fbTitleBar.a(new C07891(this));
            kO_().a().a(2131562241, FriendFinderIntroFragment.m7517b(fromSerializable, stringExtra)).b();
            return;
        }
        Intent intent = new Intent(this, FriendFinderHostingActivity.class);
        intent.putExtra("ci_flow", fromSerializable);
        this.f7278p.a(intent, this);
        finish();
    }

    private boolean m7554i() {
        if (!this.f7281s && this.f7279q.a(FriendFinderPrefKeys.a(this.f7280r, this.f7279q), false)) {
            return false;
        }
        return true;
    }
}
