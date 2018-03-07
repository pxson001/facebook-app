package com.facebook.zero.onboarding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.zero.onboarding.fragment.InviteLinkSharingFragment;
import javax.inject.Inject;

/* compiled from: modelName */
public class FbLinkIncentiveActivity extends FbFragmentActivity {
    @Inject
    public FunnelLoggerImpl f5348p;
    public Fb4aTitleBar f5349q;
    private String f5350r;

    private static <T extends Context> void m6592a(Class<T> cls, T t) {
        m6593a((Object) t, (Context) t);
    }

    public static void m6593a(Object obj, Context context) {
        ((FbLinkIncentiveActivity) obj).f5348p = FunnelLoggerImpl.a(FbInjector.get(context));
    }

    protected final void m6595b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903295);
        Class cls = FbLinkIncentiveActivity.class;
        m6593a((Object) this, (Context) this);
        this.f5348p.a(FunnelRegistry.F);
        m6594j();
        this.f5349q = (Fb4aTitleBar) a(2131558563);
        this.f5349q.setTitle(2131241765);
        String str = this.f5350r;
        InviteLinkSharingFragment inviteLinkSharingFragment = new InviteLinkSharingFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("amount", str);
        inviteLinkSharingFragment.g(bundle2);
        Fragment fragment = inviteLinkSharingFragment;
        FragmentTransaction a = kO_().a();
        a.b(2131558429, fragment);
        a.b();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 506340467);
        this.f5348p.b(FunnelRegistry.F);
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -782796949, a);
    }

    public final Fb4aTitleBar m6596i() {
        return this.f5349q;
    }

    private void m6594j() {
        Intent intent = getIntent();
        if (!(intent == null || intent.getExtras() == null)) {
            this.f5350r = Uri.parse(intent.getExtras().getString("extra_launch_uri")).getQueryParameter("amount");
        }
        this.f5348p.a(FunnelRegistry.F, "top_up_amount", this.f5350r);
    }
}
