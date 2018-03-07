package com.facebook.rtc.activities;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.helpers.RtcCallStartParams;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtcpresence.RtcAbortedCallReasonIds;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: available_audiences */
public class RtcCallPermissionActivity extends FbFragmentActivity {
    public static final String[] f19105t = new String[]{"android.permission.RECORD_AUDIO"};
    public static final String[] f19106u = new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"};
    @Inject
    RtcCallHandler f19107p;
    @Inject
    WebrtcLoggingHandler f19108q;
    @Inject
    ChatHeadsBroadcaster f19109r;
    @Inject
    ActivityRuntimePermissionsManagerProvider f19110s;
    public RtcCallStartParams f19111v;
    public String[] f19112w = null;
    public String[] f19113x = null;
    public String f19114y = null;
    private ActivityRuntimePermissionsManager f19115z;

    private static <T extends Context> void m19098a(Class<T> cls, T t) {
        m19099a((Object) t, (Context) t);
    }

    public static void m19099a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RtcCallPermissionActivity) obj).m19097a(RtcCallHandler.a(fbInjector), WebrtcLoggingHandler.a(fbInjector), ChatHeadsBroadcaster.a(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    protected final void m19106b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = RtcCallPermissionActivity.class;
        m19099a((Object) this, (Context) this);
        this.f19111v = (RtcCallStartParams) getIntent().getParcelableExtra("StartParams");
        if (getIntent().hasExtra("ConferenceParticipants")) {
            this.f19112w = getIntent().getStringArrayExtra("ConferenceParticipants");
        }
        if (getIntent().hasExtra("ConferenceParticipantsToRing")) {
            this.f19113x = getIntent().getStringArrayExtra("ConferenceParticipantsToRing");
        }
        if (getIntent().hasExtra("ConferenceServerInfo")) {
            this.f19114y = getIntent().getStringExtra("ConferenceServerInfo");
        }
        this.f19115z = this.f19110s.a(this);
        m19105i();
    }

    private void m19097a(RtcCallHandler rtcCallHandler, WebrtcLoggingHandler webrtcLoggingHandler, ChatHeadsBroadcaster chatHeadsBroadcaster, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f19107p = rtcCallHandler;
        this.f19108q = webrtcLoggingHandler;
        this.f19109r = chatHeadsBroadcaster;
        this.f19110s = activityRuntimePermissionsManagerProvider;
    }

    private void m19105i() {
        String[] strArr;
        boolean z = this.f19111v.f19782f;
        final String str = this.f19111v.f19783g;
        if (!this.f19115z.a(z ? f19106u : f19105t)) {
            this.f19109r.b();
        }
        ActivityRuntimePermissionsManager activityRuntimePermissionsManager = this.f19115z;
        if (z) {
            strArr = f19106u;
        } else {
            strArr = f19105t;
        }
        activityRuntimePermissionsManager.a(strArr, m19100b(z), m19102c(z), new RuntimePermissionsListener(this) {
            final /* synthetic */ RtcCallPermissionActivity f19104b;

            public final void m19093a() {
                if (StringUtil.a(str)) {
                    this.f19104b.f19107p.b(this.f19104b.f19111v);
                } else {
                    this.f19104b.f19107p.a(this.f19104b.f19111v, this.f19104b.f19112w, this.f19104b.f19113x, this.f19104b.f19114y);
                }
                this.f19104b.finish();
            }

            public final void m19094a(String[] strArr, String[] strArr2) {
                this.f19104b.f19108q.a(String.valueOf(this.f19104b.f19111v.f19777a), this.f19104b.f19111v.f19780d, this.f19104b.f19111v.f19782f, RtcAbortedCallReasonIds.m);
                this.f19104b.finish();
            }

            public final void m19095b() {
                this.f19104b.finish();
            }
        });
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 353983218);
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1104771570, a);
    }

    private String m19100b(boolean z) {
        return getString(z ? 2131232164 : 2131232161, new Object[]{getString(2131230720)});
    }

    private String m19102c(boolean z) {
        return getString(z ? 2131232166 : 2131232163, new Object[]{getString(2131230720)});
    }
}
