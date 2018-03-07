package com.facebook.video.player.plugins;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbButton;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPFirstPlayEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: picSquareUrls */
public class VideoVRCastPlugin extends RichVideoPlayerPlugin {
    private static final String f4774d = VideoVRCastPlugin.class.getSimpleName();
    @Inject
    public Video360PlayerConfig f4775a;
    @Inject
    public SecureContextHelper f4776b;
    @Inject
    public VideoLoggingUtils f4777c;
    public FbButton f4778l;
    public String f4779m;
    @Nullable
    public String f4780n;
    @Nullable
    public String f4781o;
    public String f4782p;
    public OnClickListener f4783q;
    public TriState f4784r;
    public PlayerType f4785s;
    public PlayerStateChangedEventSubscriber f4786t;
    public FirstPlayEventSubscriber f4787u;
    public String f4788v;

    /* compiled from: picSquareUrls */
    public class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoVRCastPlugin f4789a;

        public PlayerStateChangedEventSubscriber(VideoVRCastPlugin videoVRCastPlugin) {
            this.f4789a = videoVRCastPlugin;
        }

        public final void m5242b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).f14079b == State.PLAYBACK_COMPLETE) {
                this.f4789a.f4778l.setVisibility(8);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m5241a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: picSquareUrls */
    public class FirstPlayEventSubscriber extends RichVideoPlayerEventSubscriber<RVPFirstPlayEvent> {
        final /* synthetic */ VideoVRCastPlugin f4790a;

        public FirstPlayEventSubscriber(VideoVRCastPlugin videoVRCastPlugin) {
            this.f4790a = videoVRCastPlugin;
        }

        public final void m5244b(FbEvent fbEvent) {
            if (this.f4790a.f4783q != null && this.f4790a.f4775a.i) {
                this.f4790a.f4778l.setVisibility(0);
                this.f4790a.f4778l.postDelayed(new 1(this), 5000);
            }
        }

        public final Class<RVPFirstPlayEvent> m5243a() {
            return RVPFirstPlayEvent.class;
        }
    }

    public static void m5234a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoVRCastPlugin videoVRCastPlugin = (VideoVRCastPlugin) obj;
        Video360PlayerConfig b = Video360PlayerConfig.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        VideoLoggingUtils a = VideoLoggingUtils.a(fbInjector);
        videoVRCastPlugin.f4775a = b;
        videoVRCastPlugin.f4776b = secureContextHelper;
        videoVRCastPlugin.f4777c = a;
    }

    public VideoVRCastPlugin(Context context) {
        this(context, null);
    }

    private VideoVRCastPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoVRCastPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4784r = TriState.UNSET;
        this.f4785s = PlayerType.OTHERS;
        Class cls = VideoVRCastPlugin.class;
        m5234a((Object) this, getContext());
        setContentView(2130907759);
        this.f4778l = (FbButton) m14861a(2131568496);
        this.f4786t = new PlayerStateChangedEventSubscriber(this);
        this.f14094f.add(this.f4786t);
        this.f4787u = new FirstPlayEventSubscriber(this);
        this.f14094f.add(this.f4787u);
    }

    protected final void mo378c() {
        super.mo378c();
        this.f4778l.setOnClickListener(null);
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (this.f4783q != null) {
            this.f4778l.setOnClickListener(this.f4783q);
        }
        VideoPlayerParams videoPlayerParams = richVideoPlayerParams.f4962a;
        VideoDataSource videoDataSource = (VideoDataSource) videoPlayerParams.f4832a.get(0);
        String str = "";
        if (richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("Video360CastTitle")) {
            str = (String) richVideoPlayerParams.f4963b.get("Video360CastTitle");
        }
        m5237b((videoDataSource.f4817c != null ? videoDataSource.f4817c : videoDataSource.f4816b).toString(), videoDataSource.f4818d != null ? videoDataSource.f4818d.toString() : "", videoDataSource.f4820f, str, videoPlayerParams.f4833b, PlayerType.INLINE_PLAYER);
    }

    public static boolean m5235a(PackageManager packageManager) {
        Intent intent = new Intent();
        intent.setAction("com.oculus.cinema.action.CAST");
        intent.setType("video/vr");
        return packageManager.resolveActivity(intent, 65536) != null;
    }

    public final boolean m5239a(String str, @Nullable String str2, @Nullable String str3, String str4, String str5, PlayerType playerType) {
        this.f14094f.remove(this.f4786t);
        this.f14094f.remove(this.f4787u);
        if (this.f14095g != null) {
            this.f14095g.b(this.f4786t);
            this.f14095g.b(this.f4787u);
        }
        if (this.f4775a.i) {
            this.f4778l.setVisibility(0);
        }
        return m5237b(str, str2, str3, str4, str5, playerType);
    }

    private boolean m5237b(String str, @Nullable String str2, @Nullable String str3, String str4, String str5, PlayerType playerType) {
        if (this.f4775a.i) {
            PackageManager packageManager = getContext().getPackageManager();
            if (this.f4784r == TriState.UNSET) {
                this.f4784r = m5235a(packageManager) ? TriState.YES : TriState.NO;
            }
            if (this.f4784r.asBoolean(false)) {
                this.f4779m = str;
                this.f4780n = str2;
                this.f4781o = str3;
                Object[] objArr = new Object[6];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = str5;
                objArr[4] = playerType;
                objArr[5] = !TextUtils.isEmpty(str3) ? "available" : "n/a";
                this.f4782p = str4;
                if (this.f4783q == null) {
                    this.f4783q = new 1(this);
                }
                this.f4778l.setOnClickListener(this.f4783q);
                this.f4785s = playerType;
                this.f4788v = str5;
                return true;
            }
        }
        this.f4778l.setVisibility(8);
        mo394b();
        return false;
    }

    public static Intent m5232a(String str, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            BLog.a(f4774d, new Exception(), "should not run on UI thread", new Object[0]);
        }
        Intent intent = new Intent();
        intent.setAction("com.oculus.cinema.action.CAST");
        intent.setType("video/vr");
        if (!URLUtil.isNetworkUrl(str + "&vrcast=1&streamingtype=remote&videolayout=cubemap_32&title=" + str5)) {
            BLog.a(f4774d, new Exception(), "playableUri is not a network Url", new Object[0]);
        }
        intent.putExtra("EXTRA_VR_VIDEO_URL", str + "&vrcast=1&streamingtype=remote&videolayout=cubemap_32&title=" + str5);
        intent.putExtra("EXTRA_VR_VIDEO_ID", str2);
        if (!TextUtils.isEmpty(str4)) {
            try {
                m5233a((long) str4.length(), true);
                byte[] a = m5236a(str4);
                m5233a((long) a.length, true);
                intent.putExtra("EXTRA_VR_DASH_MANIFEST", a);
            } catch (Exception e) {
            }
        }
        return intent;
    }

    private static String m5233a(long j, boolean z) {
        int i = z ? 1000 : 1024;
        if (j < ((long) i)) {
            return j + " B";
        }
        String str = (z ? "kMGTPE" : "KMGTPE").charAt(((int) (Math.log((double) j) / Math.log((double) i))) - 1) + (z ? "" : "i");
        return String.format("%.1f %sB", new Object[]{Double.valueOf(((double) j) / Math.pow((double) i, (double) ((int) (Math.log((double) j) / Math.log((double) i))))), str});
    }

    private static byte[] m5236a(String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty());
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
