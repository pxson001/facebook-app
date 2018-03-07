package com.facebook.rtc.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceState;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;

/* compiled from: audio/x-mid */
public class RtcMergedAudioVideoDialogHelper {
    public final Context f19332a;
    public final Resources f19333b;
    public final RtcCallButtonIconProvider f19334c;
    public final RtcPresenceHandler f19335d;
    public final ThreadPresenceManager f19336e;
    public final RtcCallHandler f19337f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19338g = UltralightRuntime.b;
    public AlertDialog f19339h;

    /* compiled from: audio/x-mid */
    class C22911 implements OnClickListener {
        final /* synthetic */ RtcMergedAudioVideoDialogHelper f19328a;

        C22911(RtcMergedAudioVideoDialogHelper rtcMergedAudioVideoDialogHelper) {
            this.f19328a = rtcMergedAudioVideoDialogHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: audio/x-mid */
    class C22933 implements OnDismissListener {
        final /* synthetic */ RtcMergedAudioVideoDialogHelper f19331a;

        C22933(RtcMergedAudioVideoDialogHelper rtcMergedAudioVideoDialogHelper) {
            this.f19331a = rtcMergedAudioVideoDialogHelper;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f19331a.f19339h = null;
        }
    }

    public static RtcMergedAudioVideoDialogHelper m19342b(InjectorLike injectorLike) {
        RtcMergedAudioVideoDialogHelper rtcMergedAudioVideoDialogHelper = new RtcMergedAudioVideoDialogHelper((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), RtcCallButtonIconProvider.m19533b(injectorLike), RtcPresenceHandler.b(injectorLike), ThreadPresenceManager.a(injectorLike), RtcCallHandler.a(injectorLike));
        rtcMergedAudioVideoDialogHelper.f19338g = IdBasedLazy.a(injectorLike, 10375);
        return rtcMergedAudioVideoDialogHelper;
    }

    @Inject
    private RtcMergedAudioVideoDialogHelper(Context context, Resources resources, RtcCallButtonIconProvider rtcCallButtonIconProvider, RtcPresenceHandler rtcPresenceHandler, ThreadPresenceManager threadPresenceManager, RtcCallHandler rtcCallHandler) {
        this.f19332a = context;
        this.f19333b = resources;
        this.f19334c = rtcCallButtonIconProvider;
        this.f19335d = rtcPresenceHandler;
        this.f19336e = threadPresenceManager;
        this.f19337f = rtcCallHandler;
    }

    public final void m19343a(@Nullable final User user) {
        if (this.f19339h == null && user != null) {
            Context context = this.f19332a;
            RtcPresenceState a = this.f19335d.a(user.T);
            String h = user.h();
            RtcMergedAudioVideoDialogItem[] rtcMergedAudioVideoDialogItemArr = new RtcMergedAudioVideoDialogItem[2];
            rtcMergedAudioVideoDialogItemArr[0] = new RtcMergedAudioVideoDialogItem(this.f19334c.m19540a(a), this.f19333b.getString(2131232040, new Object[]{h}));
            rtcMergedAudioVideoDialogItemArr[1] = new RtcMergedAudioVideoDialogItem(this.f19334c.m19543b(a), this.f19333b.getString(2131232041, new Object[]{h}));
            this.f19339h = new FbAlertDialogBuilder(this.f19332a).a(new RtcMergedAudioVideoDialogAdapter(context, rtcMergedAudioVideoDialogItemArr), new OnClickListener(this) {
                final /* synthetic */ RtcMergedAudioVideoDialogHelper f19330b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    RtcMergedAudioVideoDialogHelper rtcMergedAudioVideoDialogHelper;
                    switch (i) {
                        case 0:
                            rtcMergedAudioVideoDialogHelper = this.f19330b;
                            rtcMergedAudioVideoDialogHelper.f19337f.a(rtcMergedAudioVideoDialogHelper.f19332a, user.T, "merged_dialog_audio_call");
                            break;
                        case 1:
                            rtcMergedAudioVideoDialogHelper = this.f19330b;
                            UserKey userKey = user.T;
                            if (((WebrtcUiHandler) rtcMergedAudioVideoDialogHelper.f19338g.get()).m19480l() && rtcMergedAudioVideoDialogHelper.f19336e.d(userKey)) {
                                rtcMergedAudioVideoDialogHelper.f19337f.a(userKey, rtcMergedAudioVideoDialogHelper.f19332a, "merged_dialog_video_call", false);
                            } else {
                                rtcMergedAudioVideoDialogHelper.f19337f.b(rtcMergedAudioVideoDialogHelper.f19332a, userKey, "merged_dialog_video_call");
                            }
                            break;
                    }
                    dialogInterface.dismiss();
                    this.f19330b.f19339h = null;
                }
            }).b(this.f19333b.getString(17039360), new C22911(this)).a();
            this.f19339h.setOnDismissListener(new C22933(this));
            this.f19339h.show();
        }
    }
}
