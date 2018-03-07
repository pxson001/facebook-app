package com.facebook.rtc.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import com.facebook.rtc.fbwebrtc.adapters.VoipGroupCallingListAdapter;
import com.facebook.rtc.fbwebrtc.adapters.VoipGroupCallingListAdapterProvider;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.models.RtcCalleeInfo;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceListenerDefault;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.UserKey;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: audio/mpeg3 */
public class WebrtcGroupDialogBuilder {
    public final Context f19349a;
    public final RtcCallHandler f19350b;
    private final RtcPresenceHandler f19351c;
    private final VoipGroupCallingListAdapterProvider f19352d;
    private final WebrtcLoggingHandler f19353e;
    public AlertDialog f19354f;
    public VoipGroupCallingListAdapter f19355g;
    public RtcPresenceListenerDefault f19356h;

    /* compiled from: audio/mpeg3 */
    class C22952 implements OnDismissListener {
        final /* synthetic */ WebrtcGroupDialogBuilder f19344a;

        C22952(WebrtcGroupDialogBuilder webrtcGroupDialogBuilder) {
            this.f19344a = webrtcGroupDialogBuilder;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f19344a.f19354f = null;
        }
    }

    /* compiled from: audio/mpeg3 */
    public class C22963 extends RtcPresenceListenerDefault {
        final /* synthetic */ WebrtcGroupDialogBuilder f19345a;

        public C22963(WebrtcGroupDialogBuilder webrtcGroupDialogBuilder) {
            this.f19345a = webrtcGroupDialogBuilder;
        }

        public final void m19344a() {
            WebrtcGroupDialogBuilder.m19347b(this.f19345a);
        }

        public final void m19345b() {
            WebrtcGroupDialogBuilder.m19347b(this.f19345a);
        }
    }

    /* compiled from: audio/mpeg3 */
    public class GroupCallingListener {
        public final String f19346a;
        public final String f19347b;
        public final /* synthetic */ WebrtcGroupDialogBuilder f19348c;

        public GroupCallingListener(WebrtcGroupDialogBuilder webrtcGroupDialogBuilder, String str, String str2) {
            this.f19348c = webrtcGroupDialogBuilder;
            this.f19346a = str;
            this.f19347b = str2;
        }
    }

    public static WebrtcGroupDialogBuilder m19346b(InjectorLike injectorLike) {
        return new WebrtcGroupDialogBuilder((Context) injectorLike.getInstance(Context.class), RtcCallHandler.a(injectorLike), RtcPresenceHandler.b(injectorLike), (VoipGroupCallingListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VoipGroupCallingListAdapterProvider.class), WebrtcLoggingHandler.a(injectorLike));
    }

    @Inject
    public WebrtcGroupDialogBuilder(Context context, RtcCallHandler rtcCallHandler, RtcPresenceHandler rtcPresenceHandler, VoipGroupCallingListAdapterProvider voipGroupCallingListAdapterProvider, WebrtcLoggingHandler webrtcLoggingHandler) {
        this.f19349a = context;
        this.f19350b = rtcCallHandler;
        this.f19351c = rtcPresenceHandler;
        this.f19352d = voipGroupCallingListAdapterProvider;
        this.f19353e = webrtcLoggingHandler;
    }

    public final void m19348a(Map<UserKey, RtcCalleeInfo> map, String str, final String str2, String str3) {
        this.f19353e.logCallAction(0, 0, str, "1");
        this.f19355g = this.f19352d.m19504a(new GroupCallingListener(this, str2, str3), new ArrayList(map.values()));
        this.f19354f = new FbAlertDialogBuilder(this.f19349a).a(2131232093).a(this.f19355g, new OnClickListener(this) {
            final /* synthetic */ WebrtcGroupDialogBuilder f19343b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f19343b.f19350b.a(this.f19343b.f19349a, ((RtcCalleeInfo) this.f19343b.f19355g.getItem(i)).f19832b, str2);
            }
        }).a();
        this.f19354f.setOnDismissListener(new C22952(this));
        this.f19354f.show();
        if (this.f19356h == null) {
            this.f19356h = new C22963(this);
        }
        this.f19351c.a(map.keySet(), this.f19356h);
    }

    public static void m19347b(WebrtcGroupDialogBuilder webrtcGroupDialogBuilder) {
        if (webrtcGroupDialogBuilder.f19355g != null) {
            AdapterDetour.a(webrtcGroupDialogBuilder.f19355g, -997739218);
        }
    }
}
