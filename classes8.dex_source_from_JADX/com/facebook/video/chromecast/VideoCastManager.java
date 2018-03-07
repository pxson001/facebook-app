package com.facebook.video.chromecast;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.MediaRouteButton;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteInfo;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.chromecast.BaseCastManager.ReconnectionStatus;
import com.facebook.video.chromecast.callbacks.VideoCastConsumerAdapter;
import com.facebook.video.chromecast.callbacks.VideoCastConsumerCallback;
import com.facebook.video.chromecast.graphql.FBVideoCastPayloadQuery;
import com.facebook.video.chromecast.graphql.FBVideoCastPayloadQuery.FBVideoCastPayloadQueryString;
import com.facebook.video.chromecast.graphql.FBVideoCastPayloadQueryModels.FBVideoCastPayloadQueryModel;
import com.facebook.video.chromecast.logging.VideoCastLoggingUtils;
import com.facebook.video.chromecast.notification.NotificationHelper;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.server.VideoServer;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.CastOptions.Builder;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass17;
import com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass18;
import com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass23;
import com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult;
import com.google.android.gms.cast.RemoteMediaPlayer.OnMetadataUpdatedListener;
import com.google.android.gms.cast.RemoteMediaPlayer.OnStatusUpdatedListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.images.WebImage;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: mAppAttribution */
public class VideoCastManager extends BaseCastManager {
    private static volatile VideoCastManager f9631O;
    public static final PrefKey f9632u = ((PrefKey) BaseCastManager.f9582c.a("video-id"));
    public static final PrefKey f9633v = ((PrefKey) BaseCastManager.f9582c.a("video-title"));
    public static final PrefKey f9634w = ((PrefKey) BaseCastManager.f9582c.a("video-covImg"));
    public static final Class<?> f9635x = VideoCastManager.class;
    private NewAppCallback f9636A;
    private String f9637B;
    public String f9638C;
    public MediaStatus f9639D;
    public Set<VideoCastConsumerCallback> f9640E = new CopyOnWriteArraySet();
    public NotificationHelper f9641F;
    private final GraphQLQueryExecutor f9642G;
    private final QeAccessor f9643H;
    public final SystemClock f9644I;
    public final VideoCastLoggingUtils f9645J;
    public boolean f9646K;
    public VideoCastParams f9647L;
    public VideoCastParams f9648M;
    public String f9649N;
    public RemoteMediaPlayer f9650y;
    public FBAppPlayer f9651z;

    /* compiled from: mAppAttribution */
    class C10072 implements ResultCallback<MediaChannelResult> {
        final /* synthetic */ VideoCastManager f9609a;

        C10072(VideoCastManager videoCastManager) {
            this.f9609a = videoCastManager;
        }

        public final void m11295a(Result result) {
            MediaChannelResult mediaChannelResult = (MediaChannelResult) result;
            this.f9609a.f9649N = null;
            if (mediaChannelResult.cp_().e()) {
                Class cls = VideoCastManager.f9635x;
                mediaChannelResult.toString();
                this.f9609a.m11378v();
                return;
            }
            Object obj;
            cls = VideoCastManager.f9635x;
            mediaChannelResult.toString();
            BaseCastManager baseCastManager = this.f9609a;
            baseCastManager.f9602t.a(SoftError.a("CHROMECAST_LOAD_ERROR", "loadMedia() : Failed to load Video :" + mediaChannelResult.cp_().h).g());
            VideoCastParams videoCastParams = baseCastManager.f9648M;
            videoCastParams.f9680p++;
            if (videoCastParams.f9680p < videoCastParams.f9677m.size()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                baseCastManager.mo618u();
                return;
            }
            baseCastManager.f9647L = null;
            baseCastManager.f9602t.a(SoftError.a("CHROMECAST_LOAD_ERROR", "loadMedia() : Failed to load Video from all the sources").g());
        }
    }

    /* compiled from: mAppAttribution */
    class C10083 implements ResultCallback<MediaChannelResult> {
        final /* synthetic */ VideoCastManager f9610a;

        C10083(VideoCastManager videoCastManager) {
            this.f9610a = videoCastManager;
        }

        public final void m11296a(Result result) {
            MediaChannelResult mediaChannelResult = (MediaChannelResult) result;
            if (!mediaChannelResult.cp_().e()) {
                this.f9610a.m11365a(mediaChannelResult.cp_());
            }
        }
    }

    /* compiled from: mAppAttribution */
    class C10094 implements OnStatusUpdatedListener {
        final /* synthetic */ VideoCastManager f9611a;

        C10094(VideoCastManager videoCastManager) {
            this.f9611a = videoCastManager;
        }

        public final void mo599a() {
            this.f9611a.mo621z();
        }
    }

    /* compiled from: mAppAttribution */
    class C10105 implements OnMetadataUpdatedListener {
        final /* synthetic */ VideoCastManager f9612a;

        C10105(VideoCastManager videoCastManager) {
            this.f9612a = videoCastManager;
        }

        public final void mo600a() {
            VideoCastManager videoCastManager = this.f9612a;
        }
    }

    /* compiled from: mAppAttribution */
    class C10116 implements ResultCallback<MediaChannelResult> {
        final /* synthetic */ VideoCastManager f9613a;

        C10116(VideoCastManager videoCastManager) {
            this.f9613a = videoCastManager;
        }

        public final void m11301a(Result result) {
            MediaChannelResult mediaChannelResult = (MediaChannelResult) result;
            if (mediaChannelResult.cp_().e()) {
                this.f9613a.mo619x();
            } else {
                this.f9613a.m11365a(mediaChannelResult.cp_());
            }
        }
    }

    /* compiled from: mAppAttribution */
    class C10127 implements ResultCallback<MediaChannelResult> {
        final /* synthetic */ VideoCastManager f9614a;

        C10127(VideoCastManager videoCastManager) {
            this.f9614a = videoCastManager;
        }

        public final void m11302a(Result result) {
            MediaChannelResult mediaChannelResult = (MediaChannelResult) result;
            if (!mediaChannelResult.cp_().e()) {
                this.f9614a.m11365a(mediaChannelResult.cp_());
            }
        }
    }

    /* compiled from: mAppAttribution */
    class C10138 implements ResultCallback<MediaChannelResult> {
        final /* synthetic */ VideoCastManager f9615a;

        C10138(VideoCastManager videoCastManager) {
            this.f9615a = videoCastManager;
        }

        public final void m11303a(Result result) {
            MediaChannelResult mediaChannelResult = (MediaChannelResult) result;
            if (!mediaChannelResult.cp_().e()) {
                this.f9615a.m11365a(mediaChannelResult.cp_());
            }
        }
    }

    /* compiled from: mAppAttribution */
    class CastListener extends Listener {
        final /* synthetic */ VideoCastManager f9616a;

        CastListener(VideoCastManager videoCastManager) {
            this.f9616a = videoCastManager;
        }

        public final void mo602a(int i) {
            BaseCastManager baseCastManager = this.f9616a;
            baseCastManager.f9645J.m11436a(String.valueOf(i), baseCastManager.f9647L, baseCastManager.f9646K, baseCastManager.mo620y());
            baseCastManager.mo608a(null);
        }

        public final void mo601a() {
        }

        public final void mo603b() {
        }
    }

    /* compiled from: mAppAttribution */
    public class FBAppPlayer {
        private final String f9624a;
        public final VideoCastManager f9625b;
        private int f9626c = 1;
        public State f9627d = State.OFF;
        private String f9628e = "";
        public double f9629f = 0.0d;

        /* compiled from: mAppAttribution */
        class C10141 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9617a;

            C10141(FBAppPlayer fBAppPlayer) {
                this.f9617a = fBAppPlayer;
            }

            public final void m11310a(Result result) {
                Status status = (Status) result;
                Class cls = VideoCastManager.f9635x;
                status.toString();
                cls = VideoCastManager.f9635x;
                String str = status.cp_().h;
                if (!status.cp_().e()) {
                    this.f9617a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        class C10152 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9618a;

            C10152(FBAppPlayer fBAppPlayer) {
                this.f9618a = fBAppPlayer;
            }

            public final void m11311a(Result result) {
                Status status = (Status) result;
                Class cls = VideoCastManager.f9635x;
                status.toString();
                cls = VideoCastManager.f9635x;
                String str = status.cp_().h;
                if (!status.cp_().e()) {
                    this.f9618a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        class C10163 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9619a;

            C10163(FBAppPlayer fBAppPlayer) {
                this.f9619a = fBAppPlayer;
            }

            public final void m11312a(Result result) {
                Status status = (Status) result;
                Class cls = VideoCastManager.f9635x;
                status.toString();
                if (!status.cp_().e()) {
                    this.f9619a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        class C10174 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9620a;

            C10174(FBAppPlayer fBAppPlayer) {
                this.f9620a = fBAppPlayer;
            }

            public final void m11313a(Result result) {
                Status status = (Status) result;
                Class cls = VideoCastManager.f9635x;
                status.toString();
                cls = VideoCastManager.f9635x;
                String str = status.cp_().h;
                if (status.cp_().e()) {
                    this.f9620a.f9625b.m11378v();
                } else {
                    this.f9620a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        class C10185 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9621a;

            C10185(FBAppPlayer fBAppPlayer) {
                this.f9621a = fBAppPlayer;
            }

            public final void m11314a(Result result) {
                Status status = (Status) result;
                if (!status.cp_().e()) {
                    this.f9621a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        class C10196 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9622a;

            C10196(FBAppPlayer fBAppPlayer) {
                this.f9622a = fBAppPlayer;
            }

            public final void m11315a(Result result) {
                Status status = (Status) result;
                if (!status.cp_().e()) {
                    this.f9622a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        class C10207 implements ResultCallback<Status> {
            final /* synthetic */ FBAppPlayer f9623a;

            C10207(FBAppPlayer fBAppPlayer) {
                this.f9623a = fBAppPlayer;
            }

            public final void m11316a(Result result) {
                Status status = (Status) result;
                if (!status.cp_().e()) {
                    this.f9623a.f9625b.m11365a(status.cp_());
                }
            }
        }

        /* compiled from: mAppAttribution */
        public enum State {
            OFF,
            VERSION_CHECK,
            LAUNCHING_EXPERIENCE,
            IDLE,
            SCHEDULING_PLAY,
            PLAYING,
            PAUSED
        }

        public FBAppPlayer(VideoCastManager videoCastManager, String str) {
            this.f9625b = videoCastManager;
            this.f9624a = str;
        }

        private PendingResult<Status> m11317a(String str, String str2, String str3) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str3);
            } catch (Throwable e) {
                BLog.b(VideoCastManager.f9635x, "Wrong JSON payload", e);
                jSONObject = null;
            }
            return m11318a(str, str2, jSONObject);
        }

        private PendingResult<Status> m11318a(String str, String str2, JSONObject jSONObject) {
            String jSONObject2;
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", str);
                jSONObject3.put("target", str2);
                int i = this.f9626c;
                this.f9626c = i + 1;
                jSONObject3.put("num", i);
                jSONObject3.put("timestamp", this.f9625b.f9644I.a());
                jSONObject3.putOpt("data", jSONObject);
                jSONObject2 = jSONObject3.toString();
            } catch (Throwable e) {
                BLog.b(VideoCastManager.f9635x, "JSON exception", e);
                jSONObject2 = "{}";
            }
            VideoCastManager.f9635x;
            return Cast.f9969b.mo629a(this.f9625b.f9601s, this.f9624a, jSONObject2);
        }

        public final boolean m11323a() {
            return this.f9628e.equals("play");
        }

        public final void m11325d() {
            if (this.f9627d.equals(State.OFF)) {
                this.f9627d = State.VERSION_CHECK;
                m11317a("version_request", "version", "{\"version\":\"1\"}").a(new C10141(this));
                return;
            }
            BLog.b(VideoCastManager.f9635x, "Wrong state (OFF expected):%s", new Object[]{this.f9627d.toString()});
        }

        public final void m11326e() {
            if (this.f9627d.equals(State.VERSION_CHECK)) {
                this.f9627d = State.LAUNCHING_EXPERIENCE;
                m11317a("launch", "experience", "{\"name\":\"SimpleVideo\"}").a(new C10152(this));
                return;
            }
            BLog.b(VideoCastManager.f9635x, "Wrong state (VERSION_CHECK expected):%s", new Object[]{this.f9627d.toString()});
        }

        public final void m11327f() {
            if (this.f9627d.equals(State.LAUNCHING_EXPERIENCE)) {
                this.f9627d = State.IDLE;
                this.f9625b.m11351E();
                return;
            }
            BLog.b(VideoCastManager.f9635x, "Wrong state (LAUNCHING_EXPERIENCE expected):%s", new Object[]{this.f9627d.toString()});
        }

        public final void m11321a(JSONObject jSONObject) {
            if (this.f9627d.equals(State.PLAYING)) {
                Class cls = VideoCastManager.f9635x;
            } else if (!this.f9627d.equals(State.IDLE)) {
                BLog.b(VideoCastManager.f9635x, "Wrong state (IDLE expected):%s", new Object[]{this.f9627d.toString()});
                return;
            }
            this.f9627d = State.SCHEDULING_PLAY;
            m11318a("experience_command", this.f9625b.f9638C, jSONObject).a(new C10163(this));
        }

        private void m11319j() {
            this.f9627d = State.PLAYING;
            m11317a("experience_command", this.f9625b.f9638C, "{\"cmd\":\"play_video\"}").a(new C10174(this));
        }

        public final void m11328h() {
            if (this.f9627d.equals(State.PLAYING)) {
                m11317a("experience_command", this.f9625b.f9638C, "{\"cmd\":\"pause_video\"}").a(new C10185(this));
                return;
            }
            BLog.b(VideoCastManager.f9635x, "Wrong state (PLAYING expected): %s", new Object[]{this.f9627d.toString()});
        }

        public final void m11320a(double d) {
            Throwable e;
            if (this.f9627d.equals(State.PLAYING)) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cmd", "seek_video");
                        jSONObject.put("position", d);
                    } catch (JSONException e2) {
                        e = e2;
                        BLog.b(VideoCastManager.f9635x, "JSON exception", e);
                        m11318a("experience_command", this.f9625b.f9638C, jSONObject).a(new C10196(this));
                        return;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    jSONObject = null;
                    e = th;
                    BLog.b(VideoCastManager.f9635x, "JSON exception", e);
                    m11318a("experience_command", this.f9625b.f9638C, jSONObject).a(new C10196(this));
                    return;
                }
                m11318a("experience_command", this.f9625b.f9638C, jSONObject).a(new C10196(this));
                return;
            }
            BLog.b(VideoCastManager.f9635x, "Wrong state (PLAYING expected): %s", new Object[]{this.f9627d.toString()});
        }

        public final void m11329i() {
            if (this.f9627d.equals(State.PLAYING) || this.f9627d.equals(State.PAUSED) || this.f9627d.equals(State.SCHEDULING_PLAY)) {
                m11317a("experience_command", this.f9625b.f9638C, "{\"cmd\":\"skip_video\"}").a(new C10207(this));
                return;
            }
            BLog.b(VideoCastManager.f9635x, "Wrong state (PLAYING,PAUSED,SCHEDULING_PLAY expected): %s", new Object[]{this.f9627d.toString()});
        }

        public final void m11322a(boolean z) {
            if (this.f9627d.equals(State.SCHEDULING_PLAY) && z) {
                m11319j();
            }
        }

        public final void m11324b(JSONObject jSONObject) {
            try {
                if (jSONObject.has("state")) {
                    this.f9628e = jSONObject.getString("state");
                } else {
                    this.f9628e = "";
                }
                if (jSONObject.has("position")) {
                    this.f9629f = jSONObject.getDouble("position");
                } else {
                    this.f9629f = 0.0d;
                }
                VideoCastManager.f9635x;
                this.f9625b.mo621z();
            } catch (Throwable e) {
                BLog.b(VideoCastManager.f9635x, "JSON exception", e);
            }
        }
    }

    /* compiled from: mAppAttribution */
    class NewAppCallback implements MessageReceivedCallback {
        final /* synthetic */ VideoCastManager f9630a;

        public NewAppCallback(VideoCastManager videoCastManager) {
            this.f9630a = videoCastManager;
        }

        public final void mo604a(String str, String str2) {
            VideoCastManager.f9635x;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String string = jSONObject.getString("type");
                if ("version_response".equals(string)) {
                    if (jSONObject2.getBoolean("success")) {
                        this.f9630a.f9651z.m11326e();
                    }
                } else if ("launch_response".equals(string)) {
                    if (jSONObject2.getBoolean("success")) {
                        this.f9630a.f9638C = jSONObject2.getString("target");
                        this.f9630a.f9651z.m11327f();
                    }
                } else if ("command_result".equals(string)) {
                    jSONObject.getInt("response_num");
                    this.f9630a.f9651z.m11322a(jSONObject2.getBoolean("success"));
                } else if ("status_update".equals(string)) {
                    this.f9630a.f9651z.m11324b(jSONObject2);
                }
            } catch (Throwable e) {
                BLog.b(VideoCastManager.f9635x, "JSON exception", e);
            }
        }
    }

    public static com.facebook.video.chromecast.VideoCastManager m11337a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9631O;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.chromecast.VideoCastManager.class;
        monitor-enter(r1);
        r0 = f9631O;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11342b(r0);	 Catch:{ all -> 0x0035 }
        f9631O = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9631O;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.chromecast.VideoCastManager.a(com.facebook.inject.InjectorLike):com.facebook.video.chromecast.VideoCastManager");
    }

    private static VideoCastManager m11342b(InjectorLike injectorLike) {
        return new VideoCastManager((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbNetworkManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike), VideoCastLoggingUtils.m11428a(injectorLike));
    }

    @Inject
    protected VideoCastManager(Context context, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, FbNetworkManager fbNetworkManager, BaseFbBroadcastManager baseFbBroadcastManager, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor, SystemClock systemClock, VideoCastLoggingUtils videoCastLoggingUtils) {
        super(context, abstractFbErrorReporter, qeAccessor.a(ExperimentsForVideoAbTestModule.ai, "DE8535E3"), fbSharedPreferences, fbNetworkManager, baseFbBroadcastManager);
        this.f9641F = new NotificationHelper(context);
        this.f9642G = graphQLQueryExecutor;
        this.f9643H = qeAccessor;
        this.f9644I = systemClock;
        this.f9645J = videoCastLoggingUtils;
    }

    protected final Builder mo612d() {
        return new Builder(this.f9596n, new CastListener(this));
    }

    public final void m11360a(MediaRouteButton mediaRouteButton) {
        mediaRouteButton.setRouteSelector(this.f9594l);
    }

    protected final void mo614g() {
        this.f9589g.edit().a(f9632u).commit();
        this.f9589g.edit().a(f9633v).commit();
        this.f9589g.edit().a(f9634w).commit();
    }

    protected final void mo615k() {
        this.f9602t.a(SoftError.a("CHROMECAST_APPLICATION_CONNECTION_ERROR", "Application Stop Failed!").g());
    }

    protected final void mo616l() {
        m11336Z();
    }

    protected final void mo617m() {
        for (VideoCastConsumerAdapter f : this.f9640E) {
            f.f();
        }
        ac();
    }

    protected final void mo607a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        boolean z2;
        applicationMetadata.toString();
        if (applicationMetadata != null) {
            Object obj;
            String a = this.f9643H.a(ExperimentsForVideoAbTestModule.aj, "urn:x-cast:com.facebook.fb");
            if (applicationMetadata.f9944d == null || !applicationMetadata.f9944d.contains(a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f9637B = a;
            }
        }
        if (this.f9587a == ReconnectionStatus.IN_PROGRESS) {
            this.f9647L = m11333W();
            List<RouteInfo> a2 = MediaRouter.a();
            if (a2 != null) {
                String a3 = this.f9589g.a(BaseCastManager.f9585f, null);
                if (a3 != null) {
                    for (RouteInfo routeInfo : a2) {
                        if (a3.equals(routeInfo.c)) {
                            this.a = ReconnectionStatus.FINALIZED;
                            MediaRouter.a(routeInfo);
                            z2 = true;
                            break;
                        }
                    }
                }
            }
            z2 = true;
        } else {
            z2 = false;
        }
        this.r = str2;
        this.f9589g.edit().a(BaseCastManager.f9583d, str2).commit();
        m11334X();
        if (this.f9650y != null) {
            RemoteMediaPlayer remoteMediaPlayer = this.f9650y;
            GoogleApiClient googleApiClient = this.f9601s;
            googleApiClient.b(new AnonymousClass23(remoteMediaPlayer, googleApiClient, googleApiClient)).a(new ResultCallback<MediaChannelResult>(this) {
                final /* synthetic */ VideoCastManager f9608b;

                public final void m11294a(Result result) {
                    MediaChannelResult mediaChannelResult = (MediaChannelResult) result;
                    Class cls;
                    if (!mediaChannelResult.cp_().e()) {
                        cls = VideoCastManager.f9635x;
                        mediaChannelResult.toString();
                        this.f9608b.m11365a(mediaChannelResult.cp_());
                    } else if (z2) {
                        cls = VideoCastManager.f9635x;
                        mediaChannelResult.toString();
                        if (!this.f9608b.m11357O()) {
                            this.f9608b.f9647L = null;
                        }
                    } else {
                        cls = VideoCastManager.f9635x;
                        mediaChannelResult.toString();
                        this.f9608b.mo618u();
                    }
                }
            });
        }
        if (z2) {
            VideoCastLoggingUtils videoCastLoggingUtils = this.f9645J;
            VideoCastParams videoCastParams = this.f9647L;
            if (videoCastParams != null) {
                videoCastLoggingUtils.f9702b.a(VideoCastLoggingUtils.f9699d, videoCastParams.f9665a);
                return;
            } else {
                videoCastLoggingUtils.f9703c.a(SoftError.a("CHROMECAST_LOGGING_ERROR", "logCastAppReconnected() : VideoCastParams is null when trying to reconnect").g());
                return;
            }
        }
        this.f9645J.m11433a(this.f9648M);
    }

    public final void mo618u() {
        if (this.f9648M == null) {
            this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "No media to Load!").g());
            return;
        }
        Uri uri;
        MediaInfo mediaInfo;
        VideoCastParams videoCastParams = this.f9648M;
        if (videoCastParams.f9680p < 0 || videoCastParams.f9680p >= videoCastParams.f9677m.size()) {
            uri = null;
        } else {
            VideoDataSource videoDataSource = (VideoDataSource) videoCastParams.f9677m.get(videoCastParams.f9680p);
            uri = VideoServer.e(videoDataSource.c != null ? videoDataSource.c : videoDataSource.b);
        }
        Uri uri2 = uri;
        if (uri2 == null) {
            mediaInfo = null;
        } else {
            MediaMetadata mediaMetadata = new MediaMetadata(1);
            mediaMetadata.m11785a("com.google.android.gms.cast.metadata.TITLE", videoCastParams.f9666b);
            if (!(videoCastParams.f9667c == null || videoCastParams.f9667c.isEmpty())) {
                mediaMetadata.m11785a("com.google.android.gms.cast.metadata.SUBTITLE", videoCastParams.f9667c);
            }
            if (!(videoCastParams.f9668d == null || videoCastParams.f9668d.isEmpty())) {
                mediaMetadata.m11785a("com.google.android.gms.cast.metadata.STUDIO", videoCastParams.f9668d);
            }
            if (videoCastParams.f9675k != null) {
                mediaMetadata.f10002c.add(new WebImage(videoCastParams.f9675k.c));
            }
            MediaInfo.Builder builder = new MediaInfo.Builder(uri2.toString());
            builder.f9988a.m11772a("video/mp4");
            MediaInfo.Builder builder2 = builder;
            builder2.f9988a.m11771a(1);
            builder2 = builder2;
            builder2.f9988a.f9992d = mediaMetadata;
            builder2 = builder2;
            builder2.f9988a.m11773b();
            mediaInfo = builder2.f9988a;
        }
        m11338a(mediaInfo, true, this.f9648M.f9678n);
    }

    private void m11338a(MediaInfo mediaInfo, boolean z, int i) {
        m11339a(mediaInfo, z, i, null);
    }

    private void m11339a(MediaInfo mediaInfo, boolean z, int i, JSONObject jSONObject) {
        m11340a(mediaInfo, null, z, i, jSONObject);
    }

    private void m11340a(MediaInfo mediaInfo, long[] jArr, boolean z, int i, JSONObject jSONObject) {
        if (m11285h() && m11335Y() && mediaInfo != null) {
            mediaInfo.toString();
            if (this.f9650y != null) {
                this.f9650y.m11848a(this.f9601s, mediaInfo, z, (long) i, jArr, jSONObject).a(new C10072(this));
            }
            this.f9649N = this.f9648M.f9665a;
        }
    }

    public final void m11378v() {
        VideoCastParams videoCastParams = this.f9647L;
        this.f9647L = this.f9648M;
        this.f9648M = videoCastParams;
        VideoCastParams videoCastParams2 = this.f9647L;
        if (videoCastParams2 != null) {
            this.f9589g.edit().a(f9632u, videoCastParams2.f9665a).commit();
            this.f9589g.edit().a(f9633v, videoCastParams2.f9666b).commit();
            if (videoCastParams2.f9675k != null) {
                this.f9589g.edit().a(f9634w, videoCastParams2.f9675k.c.toString()).commit();
            }
        }
        this.f9645J.m11434a(this.f9647L, mo620y());
        for (VideoCastConsumerAdapter b : this.f9640E) {
            b.b();
        }
    }

    private VideoCastParams m11333W() {
        ImageRequest imageRequest = null;
        String a = this.f9589g.a(f9632u, null);
        String a2 = this.f9589g.a(f9633v, null);
        String a3 = this.f9589g.a(f9634w, null);
        if (a == null || a.isEmpty()) {
            return null;
        }
        if (!(a3 == null || a3.isEmpty())) {
            imageRequest = ImageRequest.a(a3);
        }
        VideoCastParams.Builder builder = new VideoCastParams.Builder();
        if (a != null) {
            builder.f9652a = a;
        }
        VideoCastParams.Builder a4 = builder.m11383a(a2);
        a4.f9661j = imageRequest;
        return a4.m11384a();
    }

    public final void mo619x() {
        for (VideoCastConsumerAdapter c : this.f9640E) {
            c.c();
        }
        ac();
    }

    public final void m11359a(long j) {
        if (!m11285h() || !m11335Y()) {
            return;
        }
        if (this.f9650y != null) {
            this.f9650y.m11847a(this.f9601s, j, 0).a(new C10083(this));
        } else {
            this.f9651z.m11320a(((double) j) / 1000.0d);
        }
    }

    public final int mo620y() {
        if (!m11285h() || !m11335Y()) {
            return 0;
        }
        if (this.f9650y == null) {
            return (int) (this.f9651z.f9629f * 1000.0d);
        }
        return (int) this.f9650y.m11846a();
    }

    protected final void m11365a(Status status) {
        this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Remote Media Player failed with " + status.h).g());
    }

    protected final void mo621z() {
        if (m11285h() && m11335Y()) {
            boolean z;
            if (this.f9650y != null) {
                this.f9639D = this.f9650y.m11852b();
                this.f9645J.m11435a(this.f9647L, mo620y(), this.f9639D, this.f9646K);
            }
            for (VideoCastConsumerAdapter a : this.f9640E) {
                a.a();
            }
            if (!(this.f9639D == null || this.f9647L == null)) {
                if (this.f9639D.f10022e == 2) {
                    this.f9647L.f9679o = mo620y();
                } else if (this.f9639D.f10022e == 1) {
                    ac();
                }
            }
            MediaStatus mediaStatus = this.f9639D;
            if (mediaStatus == null || mediaStatus.f10022e != 2) {
                z = false;
            } else {
                z = true;
            }
            this.f9646K = z;
        }
    }

    public final int mo605A() {
        if (this.f9639D == null) {
            return (this.f9651z == null || !this.f9651z.m11323a()) ? 1 : 2;
        } else {
            return this.f9639D.f10022e;
        }
    }

    private void m11334X() {
        Throwable e;
        if (this.f9650y == null && this.f9643H.a(ExperimentsForVideoAbTestModule.ak, false)) {
            this.f9650y = new RemoteMediaPlayer();
            this.f9650y.m11850a(new C10094(this));
            this.f9650y.m11849a(new C10105(this));
        }
        try {
            if (this.f9643H.a(ExperimentsForVideoAbTestModule.ak, false)) {
                if (this.f9637B != null) {
                    Cast.f9969b.mo632a(this.f9601s, this.f9637B, this.f9650y);
                }
            } else if (this.f9637B != null) {
                this.f9636A = new NewAppCallback(this);
                Cast.f9969b.mo632a(this.f9601s, this.f9637B, this.f9636A);
                this.f9651z = new FBAppPlayer(this, this.f9637B);
                this.f9650y = null;
                this.f9651z.m11325d();
            }
        } catch (IOException e2) {
            e = e2;
            this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Unable to Attach Media Channel").a(e).g());
        } catch (IllegalStateException e3) {
            e = e3;
            this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Unable to Attach Media Channel").a(e).g());
        }
    }

    private boolean m11335Y() {
        if (this.f9650y != null || this.f9651z != null) {
            return true;
        }
        this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "stop() : RemoterMediaPlayer and FBAppPlayer are null").g());
        return false;
    }

    private void m11336Z() {
        Throwable e;
        if (this.f9650y != null) {
            try {
                Cast.f9969b.mo634b(this.f9601s, this.f9650y.m11854c());
            } catch (IOException e2) {
                e = e2;
                this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Unable to Detach Media Channel").a(e).g());
                this.f9650y = null;
                return;
            } catch (IllegalStateException e3) {
                e = e3;
                this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Unable to Detach Media Channel").a(e).g());
                this.f9650y = null;
                return;
            }
            this.f9650y = null;
            return;
        }
        try {
            if (this.f9637B != null) {
                Cast.f9969b.mo634b(this.f9601s, this.f9637B);
            }
        } catch (IOException e4) {
            e = e4;
            this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Unable to Detach Media Channel").a(e).g());
            this.f9636A = null;
            this.f9651z = null;
        } catch (IllegalStateException e5) {
            e = e5;
            this.f9602t.a(SoftError.a("CHROMECAST_MEDIA_ERROR", "Unable to Detach Media Channel").a(e).g());
            this.f9636A = null;
            this.f9651z = null;
        }
        this.f9636A = null;
        this.f9651z = null;
    }

    protected final void mo611c(int i) {
        this.f9602t.a(SoftError.a("CHROMECAST_APP_CONNECTION_ERROR", "Application connection Failed").g());
        if (this.f9587a != ReconnectionStatus.IN_PROGRESS) {
            mo608a(null);
            if (this.f9593k != null) {
                MediaRouter.a(MediaRouter.b());
            }
        } else if (i == 2005) {
            this.a = ReconnectionStatus.IN_ACTIVE;
            mo608a(null);
        }
    }

    public final void mo610b(boolean z) {
        for (VideoCastConsumerAdapter a : this.f9640E) {
            a.a(z);
        }
    }

    public final void m11348B() {
        if (m11285h() && m11335Y()) {
            switch (mo605A()) {
                case 1:
                    mo618u();
                    return;
                case 2:
                    m11350D();
                    return;
                case 3:
                    m11351E();
                    return;
                default:
                    return;
            }
        }
    }

    public final void m11349C() {
        m11341a(null);
    }

    private void m11341a(JSONObject jSONObject) {
        if (!m11285h() || !m11335Y()) {
            return;
        }
        if (this.f9650y != null) {
            RemoteMediaPlayer remoteMediaPlayer = this.f9650y;
            GoogleApiClient googleApiClient = this.f9601s;
            googleApiClient.b(new AnonymousClass18(remoteMediaPlayer, googleApiClient, googleApiClient, jSONObject)).a(new C10116(this));
            return;
        }
        this.f9651z.m11328h();
    }

    public final void m11350D() {
        m11344b(null);
    }

    private void m11344b(JSONObject jSONObject) {
        if (!m11285h() || !m11335Y()) {
            return;
        }
        if (this.f9650y != null) {
            RemoteMediaPlayer remoteMediaPlayer = this.f9650y;
            GoogleApiClient googleApiClient = this.f9601s;
            googleApiClient.b(new AnonymousClass17(remoteMediaPlayer, googleApiClient, googleApiClient, jSONObject)).a(new C10127(this));
            return;
        }
        this.f9651z.m11328h();
    }

    public final void m11351E() {
        m11345c(null);
    }

    private void m11345c(JSONObject jSONObject) {
        if (!m11285h() || !m11335Y()) {
            return;
        }
        if (this.f9650y != null) {
            this.f9650y.m11853c(this.f9601s, jSONObject).a(new C10138(this));
        } else if (this.f9648M == null) {
            BLog.b(f9635x, "Video parameters were not retrieved");
        } else {
            FBVideoCastPayloadQueryString a = FBVideoCastPayloadQuery.m11418a();
            a.a("targetID", this.f9648M.m11389h());
            try {
                GraphQLResult graphQLResult = (GraphQLResult) FutureDetour.a(this.f9642G.a(GraphQLRequest.a(a)), 715047531);
                if (graphQLResult != null && graphQLResult.d() != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cmd", "next_video");
                    if (this.f9648M != null) {
                        jSONObject2.putOpt("payload", ((FBVideoCastPayloadQueryModel) graphQLResult.d()).m11426j());
                    }
                    this.f9651z.m11321a(jSONObject2);
                }
            } catch (Throwable e) {
                BLog.b(f9635x, "Graphql call failed", e);
            } catch (Throwable e2) {
                BLog.b(f9635x, "Graphql call failed", e2);
            } catch (Throwable e22) {
                BLog.b(f9635x, "Cannot create JSON", e22);
            }
        }
    }

    private void ab() {
        if (m11285h() && m11335Y() && this.f9650y == null) {
            this.f9651z.m11329i();
        }
    }

    public final void m11352F() {
        if (m11285h() && m11335Y() && this.f9650y == null) {
            m11351E();
            ab();
        }
    }

    private void ac() {
        if (this.f9649N == null) {
            this.f9647L = null;
        }
        m11353G();
    }

    public final void m11361a(VideoCastConsumerAdapter videoCastConsumerAdapter) {
        this.f9640E.add(videoCastConsumerAdapter);
    }

    public final void m11367b(VideoCastConsumerAdapter videoCastConsumerAdapter) {
        this.f9640E.remove(videoCastConsumerAdapter);
    }

    public final void mo606a(int i) {
        super.mo606a(i);
        for (VideoCastConsumerAdapter e : this.f9640E) {
            e.e();
        }
    }

    public final void mo609a(ConnectionResult connectionResult) {
        super.mo609a(connectionResult);
        for (VideoCastConsumerAdapter d : this.f9640E) {
            d.d();
        }
    }

    public final void m11353G() {
        this.f9641F.f9705a.cancel(1);
    }

    public final void m11354H() {
        NotificationHelper notificationHelper = this.f9641F;
        if (notificationHelper.f9708e) {
            notificationHelper.f9705a.notify(1, notificationHelper.f9707d.c());
        } else {
            BLog.b(NotificationHelper.f9704b, "Cast notification updated without being set");
        }
    }

    public final boolean m11355K() {
        if (this.f9650y != null) {
            if (this.f9639D == null) {
                this.f9639D = this.f9650y.m11852b();
            }
            if (this.f9639D == null || this.f9639D.f10022e != 2) {
                return false;
            }
            return true;
        } else if (this.f9651z == null || !this.f9651z.m11323a()) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean m11356M() {
        if (this.f9650y == null) {
            return false;
        }
        if (this.f9639D == null) {
            this.f9639D = this.f9650y.m11852b();
        }
        if (this.f9639D != null && this.f9639D.f10022e == 1 && this.f9639D.f10023f == 1) {
            return true;
        }
        return false;
    }

    public final boolean m11357O() {
        if (this.f9650y != null) {
            if (this.f9639D == null) {
                this.f9639D = this.f9650y.m11852b();
            }
            if (this.f9639D == null || !m11346d(this.f9639D.f10022e)) {
                return false;
            }
            return true;
        } else if (this.f9651z == null) {
            return false;
        } else {
            FBAppPlayer fBAppPlayer = this.f9651z;
            boolean z = State.IDLE.equals(fBAppPlayer.f9627d) || State.SCHEDULING_PLAY.equals(fBAppPlayer.f9627d) || State.PLAYING.equals(fBAppPlayer.f9627d) || State.PAUSED.equals(fBAppPlayer.f9627d);
            return z;
        }
    }

    public static boolean m11346d(int i) {
        return i == 2 || i == 4 || i == 3;
    }

    public final boolean m11366a(String str) {
        return m11285h() && m11357O() && m11369b(str);
    }

    public final boolean m11369b(String str) {
        if (this.f9649N != null) {
            return this.f9649N.equals(str);
        }
        if (this.f9647L == null || !this.f9647L.f9665a.equals(str)) {
            return false;
        }
        return true;
    }

    public final void mo608a(CastDevice castDevice) {
        super.mo608a(castDevice);
        if (castDevice != null) {
            for (VideoCastConsumerAdapter videoCastConsumerAdapter : this.f9640E) {
                String str = castDevice.f9975e;
                videoCastConsumerAdapter.g();
            }
        }
    }

    public final void mo613f() {
        for (VideoCastConsumerAdapter h : this.f9640E) {
            h.h();
        }
    }
}
