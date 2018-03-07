package com.facebook.aplacefor.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.aplacefor.fragment.APlaceForFragment;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.facebook.video.channelfeed.ChannelFeedInflater;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseInflator;
import javax.inject.Inject;

/* compiled from: kFBSearchContextSearchFocus */
public class APlaceForActivity extends FbFragmentActivity implements FullScreenVideoPlayerHost {
    @Inject
    public Lazy<ChannelFeedInflater> f10497p;
    @Inject
    public Lazy<FullScreenVideoInflater> f10498q;
    @Inject
    public Lazy<VideoWatchAndBrowseInflator> f10499r;
    @Inject
    public FunnelLoggerImpl f10500s;
    private ImmersiveVideoPlayer f10501t;

    /* compiled from: kFBSearchContextSearchFocus */
    class C11211 implements OnClickListener {
        final /* synthetic */ APlaceForActivity f10496a;

        C11211(APlaceForActivity aPlaceForActivity) {
            this.f10496a = aPlaceForActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1173887226);
            this.f10496a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1340242266, a);
        }
    }

    private static <T extends Context> void m12373a(Class<T> cls, T t) {
        m12374a((Object) t, (Context) t);
    }

    public static void m12374a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        APlaceForActivity aPlaceForActivity = (APlaceForActivity) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 11586);
        Lazy a2 = IdBasedLazy.a(fbInjector, 6077);
        Lazy a3 = IdBasedLazy.a(fbInjector, 11718);
        FunnelLoggerImpl a4 = FunnelLoggerImpl.a(fbInjector);
        aPlaceForActivity.f10497p = a;
        aPlaceForActivity.f10498q = a2;
        aPlaceForActivity.f10499r = a3;
        aPlaceForActivity.f10500s = a4;
    }

    protected final void m12376b(Bundle bundle) {
        super.b(bundle);
        Class cls = APlaceForActivity.class;
        m12374a((Object) this, (Context) this);
        this.f10500s.a(FunnelRegistry.b);
        this.f10500s.a(FunnelRegistry.b, m12375i());
        this.f10500s.b(FunnelRegistry.b, "activity_instantiated");
        setContentView(2130903258);
        View a = a(2131559610);
        a.setOnClickListener(new C11211(this));
        a.setOnTouchListener(new HighlightViewOnTouchListener());
        kO_().a().a(2131559609, new APlaceForFragment(), "chromeless:content:fragment:tag").b();
    }

    private String m12375i() {
        return getIntent().hasExtra("a_place_for_theme") ? getIntent().getStringExtra("a_place_for_theme") : "";
    }

    public void onBackPressed() {
        if (this.f10501t == null || !this.f10501t.b()) {
            super.onBackPressed();
        }
    }

    public final boolean m12377h() {
        return this.f10501t != null && this.f10501t.a();
    }

    public final ImmersiveVideoPlayer m12379l() {
        this.f10501t = ((ChannelFeedInflater) this.f10497p.get()).a(this);
        return this.f10501t;
    }

    public final ImmersiveVideoPlayer m12378k() {
        this.f10501t = ((FullScreenVideoInflater) this.f10498q.get()).a(this);
        return this.f10501t;
    }

    public final ImmersiveVideoPlayer m12380n() {
        this.f10501t = ((VideoWatchAndBrowseInflator) this.f10499r.get()).a(this);
        return this.f10501t;
    }

    public final boolean m12381o() {
        if (this.f10501t == null || !this.f10501t.a()) {
            return false;
        }
        return this.f10501t.b();
    }
}
