package com.facebook.rtc.fbwebrtcnew;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.WebrtcConfigHandler;
import com.facebook.rtc.fbwebrtcnew.FbWebrtcCallModel.CallDirection;
import com.facebook.rtc.fbwebrtcnew.FbWebrtcCallModel.CallProtocol;
import com.facebook.rtc.fbwebrtcnew.FbWebrtcCallModel.CallType;
import com.facebook.webrtc.ConferenceCall;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcUiInterface;
import com.facebook.webrtc.WebrtcManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: application/vnd.wv.csp.cir */
public class FbWebrtcEngine implements Listener, IWebrtcUiInterface {
    private static final String f19697a = FbWebrtcEngine.class.getName();
    private static final Object f19698i = new Object();
    private final QeAccessor f19699b;
    private final GatekeeperStoreImpl f19700c;
    private final WebrtcConfigHandler f19701d;
    private DefaultAndroidThreadUtil f19702e;
    public FbWebrtcCallProperties f19703f;
    private ConferenceCall f19704g;
    public List<Object> f19705h = new ArrayList();

    private static FbWebrtcEngine m19510b(InjectorLike injectorLike) {
        return new FbWebrtcEngine((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), WebrtcConfigHandler.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public FbWebrtcEngine(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, WebrtcConfigHandler webrtcConfigHandler, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f19699b = qeAccessor;
        this.f19700c = gatekeeperStoreImpl;
        this.f19701d = webrtcConfigHandler;
        this.f19705h = new ArrayList();
        this.f19702e = defaultAndroidThreadUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.rtc.fbwebrtcnew.FbWebrtcEngine m19507a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f19698i;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m19510b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f19698i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtcnew.FbWebrtcEngine) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.rtc.fbwebrtcnew.FbWebrtcEngine) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f19698i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtcnew.FbWebrtcEngine) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtcnew.FbWebrtcEngine.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtcnew.FbWebrtcEngine");
    }

    public void webRTCControlRPC_StartOutgoingCall(long j, boolean z) {
    }

    public void webRTCControlRPC_AcceptIncomingCall(long j) {
    }

    public void webRTCControlRPC_EnableVideo() {
    }

    public void webRTCControlRPC_DisableVideo() {
    }

    public void webRTCControlRPC_ToggleSpeakerPhone() {
    }

    public void webRTCControlRPC_VolumeUp() {
    }

    public void webRTCControlRPC_VolumeDown() {
    }

    public void forceStarRating() {
    }

    public void handleError(int i) {
    }

    public void initializeCall(long j, long j2, boolean z) {
    }

    public void switchToContactingUI() {
    }

    public void switchToRingingUI() {
    }

    public void switchToIncomingCallUI(long j, long j2, boolean z, boolean z2, String str) {
    }

    public void switchToStreamingUI(boolean z, String str) {
    }

    public void showConnectionDetails(boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4) {
    }

    public void hideCallUI(int i, long j, boolean z, String str) {
    }

    public void localMediaStateChanged(boolean z, boolean z2, boolean z3) {
    }

    public void remoteMediaStateChanged(boolean z, boolean z2, boolean z3) {
    }

    public void updateStatesAndCallDuration() {
    }

    public void onIncomingMissedCall(long j, long j2) {
    }

    public void onPingAckMessageReceived(long j, long j2) {
    }

    public void onDataReceived(String str) {
    }

    public void updateRemoteVideoSupport(boolean z, long j) {
    }

    public void addRemoteVideoTrack(String str, String str2, long j) {
    }

    public void removeRemoteVideoTrack(String str, String str2, long j) {
    }

    public void onEscalationRequest(boolean z) {
    }

    public void onEscalationResponse(boolean z) {
    }

    public void onEscalationSuccess() {
    }

    public void onEscalationTimeout() {
    }

    public void onRemoteVideoSizeChanged(int i, int i2) {
    }

    public void onIncomingCall(ConferenceCall conferenceCall, String str, String[] strArr, int i) {
        FbWebrtcCallState fbWebrtcCallState;
        boolean z = true;
        long callId = conferenceCall.callId();
        FbWebrtcCallPropertiesBuilder fbWebrtcCallPropertiesBuilder = new FbWebrtcCallPropertiesBuilder();
        fbWebrtcCallPropertiesBuilder.f19673a = callId;
        fbWebrtcCallPropertiesBuilder = fbWebrtcCallPropertiesBuilder;
        fbWebrtcCallPropertiesBuilder.f19684l = true;
        fbWebrtcCallPropertiesBuilder = fbWebrtcCallPropertiesBuilder;
        fbWebrtcCallPropertiesBuilder.f19690r = FbWebrtcCallState.FbWebRTCCallStateInit;
        this.f19703f = new FbWebrtcCallProperties(fbWebrtcCallPropertiesBuilder);
        this.f19703f.f19659e = CallDirection.INBOUND;
        this.f19703f.f19660f = CallProtocol.MULTIWAY;
        this.f19703f.f19661g = conferenceCall.conferenceName();
        switch (i) {
            case 0:
                this.f19703f.f19658d = CallType.CONFERENCE_VOICE;
                break;
            case 1:
                this.f19703f.f19658d = CallType.DIRECT_VIDEO;
                break;
            case 2:
                this.f19703f.f19658d = CallType.VOICE;
                break;
            case 3:
                this.f19703f.f19658d = CallType.CONFERENCE_VIDEO;
                break;
            default:
                BLog.b(f19697a, "Invalid incoming conference call type %d", new Object[]{Integer.valueOf(i)});
                return;
        }
        if (strArr != null) {
            ImmutableList copyOf = ImmutableList.copyOf(strArr);
            this.f19703f.f19656b = copyOf;
            m19509a(copyOf);
        } else {
            this.f19703f.f19656b = RegularImmutableList.a;
        }
        if (CallType.isConferenceCall(this.f19703f.f19658d)) {
            FbWebrtcCallProperties fbWebrtcCallProperties = this.f19703f;
            if (!(this.f19701d.shouldEnableVideo() && this.f19700c.a(1105, false))) {
                z = false;
            }
            fbWebrtcCallProperties.f19667m = z;
        } else {
            this.f19703f.f19667m = this.f19701d.shouldEnableVideo();
        }
        if (CallType.isNonInstantVideoCall(this.f19703f.f19658d) && this.f19703f.f19667m) {
            fbWebrtcCallState = FbWebrtcCallState.FbWebRTCCallStateInitInboundDirectVideo;
        } else {
            fbWebrtcCallState = FbWebrtcCallState.FbWebRTCCallStateInitInbound;
        }
        this.f19704g = conferenceCall;
        m19508a(fbWebrtcCallState);
    }

    public void onCallJoined(ConferenceCall conferenceCall, String[] strArr) {
    }

    public void OnUserStateUpdate(ConferenceCall conferenceCall, String[] strArr, int[] iArr) {
    }

    public void onMediaConnectionUpdate(ConferenceCall conferenceCall, boolean z) {
    }

    public void onMediaStatusUpdate(ConferenceCall conferenceCall, long[] jArr, String[] strArr, String[] strArr2, int[] iArr, boolean[] zArr) {
    }

    public void onDominantSpeakerUpdate(ConferenceCall conferenceCall, String str, String str2) {
    }

    public void onDataMessage(ConferenceCall conferenceCall, String str, String str2, byte[] bArr) {
    }

    public void onCallEnded(ConferenceCall conferenceCall, int i, String str) {
    }

    public void onActiveAudioLevels(String[] strArr, int[] iArr) {
    }

    public void onSnakeGameUpdate(byte[] bArr) {
    }

    public void setWebrtcManager(WebrtcManager webrtcManager) {
    }

    public void onAudioLevel(int i, int i2) {
    }

    private void m19509a(ImmutableList<String> immutableList) {
        if (immutableList == null) {
            BLog.b(f19697a, "initConferenceUserStates encounters null user list");
            this.f19703f.f19657c = RegularImmutableBiMap.a;
            return;
        }
        Builder builder = ImmutableMap.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            if (!StringUtil.a(str)) {
                builder.b(str, FbWebrtcConferenceUserState.UNKNOWN);
            }
        }
        this.f19703f.f19657c = builder.b();
    }

    private void m19508a(FbWebrtcCallState fbWebrtcCallState) {
        if (this.f19703f.f19672r == fbWebrtcCallState) {
            return;
        }
        if (FbWebrtcCallState.validateStateTransition(this.f19703f.f19672r, fbWebrtcCallState)) {
            this.f19703f.f19672r = fbWebrtcCallState;
            FbWebrtcCallModel fbWebrtcCallModel = new FbWebrtcCallModel(this.f19703f);
            Iterator it = this.f19705h.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        BLog.c(f19697a, "Invalid state transition from %s to %d", new Object[]{this.f19703f.f19672r.name(), fbWebrtcCallState.name()});
    }
}
