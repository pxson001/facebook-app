package com.facebook.katana.activity.contactpoints;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.growth.logging.GrowthAnalyticsLogger;
import com.facebook.growth.logging.GrowthLoggingEventType;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.FbInjector;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;

@UriMatchPatterns
@Deprecated
/* compiled from: VideoHubPermalinkFragment */
public class AddContactpointFacewebActivity extends FbFragmentActivity implements ActionReceiver {
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager f10393p;
    @Inject
    public GrowthAnalyticsLogger f10394q;
    private SelfRegistrableReceiverImpl f10395r;

    private static <T extends Context> void m10788a(Class<T> cls, T t) {
        m10789a((Object) t, (Context) t);
    }

    public static void m10789a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AddContactpointFacewebActivity addContactpointFacewebActivity = (AddContactpointFacewebActivity) obj;
        BaseFbBroadcastManager baseFbBroadcastManager = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector);
        GrowthAnalyticsLogger b = GrowthAnalyticsLogger.b(fbInjector);
        addContactpointFacewebActivity.f10393p = baseFbBroadcastManager;
        addContactpointFacewebActivity.f10394q = b;
    }

    public final void m10792b(Bundle bundle) {
        super.b(bundle);
        Class cls = AddContactpointFacewebActivity.class;
        m10789a((Object) this, (Context) this);
        setContentView(2130903158);
        FbTitleBarUtil.b(this);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("/phoneacquire?source=%s&state=%s", "phone_acquisition_embedded", "1");
        FacewebFragment facewebFragment = new FacewebFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("mobile_page", formatStrLocaleSafe);
        bundle2.putBoolean("faceweb_modal", false);
        bundle2.putBoolean("titlebar_with_modal_done", false);
        facewebFragment.g(bundle2);
        kO_().a().a(2131558429, facewebFragment).b();
        m10790i();
        HoneyClientEventFast a = this.f10394q.a.a(GrowthLoggingEventType.FACEWEB_ADD_CONTACTPOINT_FLOW_ENTER.getAnalyticsName(), true);
        if (a.a()) {
            a.a("growth");
            a.b();
        }
    }

    private void m10790i() {
        this.f10395r = this.f10393p.a().a("action_background_contactpoint_confirmed", this).a();
        this.f10395r.b();
    }

    private void m10791j() {
        if (this.f10395r != null) {
            this.f10395r.c();
            this.f10395r = null;
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -597877421);
        m10791j();
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 510547628, a);
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 642548271);
        FacewebFragment facewebFragment = (FacewebFragment) kO_().a(2131558429);
        if (facewebFragment == null || facewebFragment.an == null) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 806258162, a);
            return;
        }
        String str;
        facewebFragment.an.a(StringFormatUtil.formatStrLocaleSafe("/phoneacquire?source=%s&state=%s", "phone_acquisition_embedded", "3"), true);
        Contactpoint contactpoint = (Contactpoint) intent.getParcelableExtra("extra_background_confirmed_contactpoint");
        GrowthAnalyticsLogger growthAnalyticsLogger = this.f10394q;
        if (contactpoint == null) {
            str = "";
        } else {
            str = contactpoint.normalized;
        }
        HoneyClientEventFast a2 = growthAnalyticsLogger.a.a(GrowthLoggingEventType.FACEWEB_ADD_CONTACTPOINT_CONFIRMED.getAnalyticsName(), true);
        if (a2.a()) {
            a2.a("growth");
            a2.a("phone_number_added", str);
            a2.b();
        }
        m10791j();
        LogUtils.e(-1645564235, a);
    }
}
