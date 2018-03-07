package com.facebook.feedplugins.musicpreview;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.attachments.angora.actionbutton.SaveButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipPlayerListener;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipState;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: composer_save_session */
public class MusicPreviewView extends CustomFrameLayout implements OnClickListener, SongClipPlayerListener {
    public static final CallerContext f8105r = CallerContext.a(MusicPreviewView.class, "unknown");
    public FbDraweeView f8106a;
    public TextView f8107b;
    public TextView f8108c;
    public TextView f8109d;
    public FbDraweeView f8110e;
    public String f8111f;
    public MusicButton f8112g;
    protected Uri f8113h;
    public String f8114i;
    public String f8115j;
    public ViewGroup f8116k;
    public Optional<SaveButton> f8117l;
    public Optional<View> f8118m;
    public Optional<ImageView> f8119n = Absent.INSTANCE;
    public String f8120o;
    public String f8121p;
    public ArrayNode f8122q;
    private SongClipPlayer f8123s;
    public MusicPreviewLogger f8124t;
    public FeedImageLoader f8125u;
    public Provider<FbDraweeControllerBuilder> f8126v;
    public MusicPreviewPopupManager f8127w;
    public boolean f8128x = true;
    public GraphQLMedia f8129y;
    public final boolean f8130z;

    /* compiled from: composer_save_session */
    public class C10131 implements Runnable {
        final /* synthetic */ MusicPreviewView f8103a;

        public C10131(MusicPreviewView musicPreviewView) {
            this.f8103a = musicPreviewView;
        }

        public void run() {
            MusicPreviewView musicPreviewView = this.f8103a;
            if (musicPreviewView.f8128x && musicPreviewView.f8129y != null) {
                GraphQLImage a;
                musicPreviewView.f8128x = false;
                if (musicPreviewView.f8114i == null || !musicPreviewView.f8114i.equals("com.nttdocomo.android.selection")) {
                    a = musicPreviewView.f8125u.a(musicPreviewView.f8129y, musicPreviewView.getHeight(), FeedImageType.MusicPreviewCover);
                } else {
                    a = musicPreviewView.f8129y.S();
                }
                if (a != null) {
                    musicPreviewView.f8106a.setController(((FbDraweeControllerBuilder) musicPreviewView.f8126v.get()).a(MusicPreviewView.f8105r).b(ImageUtil.a(a)).s());
                }
            }
        }
    }

    public static void m9135a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MusicPreviewView) obj).m9134a(SongClipPlayer.m9319a(injectorLike), MusicPreviewLogger.m9098a(injectorLike), FeedImageLoader.a(injectorLike), IdBasedProvider.a(injectorLike, 1117), new MusicPreviewPopupManager(PlatformPackageUtilities.b(injectorLike), MusicPreviewLogger.m9098a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GooglePlayIntentHelper.b(injectorLike)));
    }

    @Inject
    private void m9134a(SongClipPlayer songClipPlayer, MusicPreviewLogger musicPreviewLogger, FeedImageLoader feedImageLoader, Provider<FbDraweeControllerBuilder> provider, MusicPreviewPopupManager musicPreviewPopupManager) {
        this.f8123s = songClipPlayer;
        this.f8124t = musicPreviewLogger;
        this.f8125u = feedImageLoader;
        this.f8126v = provider;
        this.f8127w = musicPreviewPopupManager;
    }

    public MusicPreviewView(Context context, boolean z) {
        super(context);
        this.f8130z = z;
        Class cls = MusicPreviewView.class;
        m9135a((Object) this, getContext());
        setContentView(this.f8130z ? 2130905365 : 2130905364);
        this.f8106a = (FbDraweeView) c(2131564028);
        this.f8107b = (TextView) c(2131564030);
        this.f8108c = (TextView) c(2131564031);
        this.f8109d = (TextView) c(2131564034);
        this.f8110e = (FbDraweeView) c(2131564033);
        this.f8112g = (MusicButton) c(2131564029);
        this.f8119n = d(2131564035);
        this.f8116k = (ViewGroup) c(2131564032);
        this.f8117l = d(2131564038);
        this.f8118m = d(2131564037);
        setOnClickListener(this);
        this.f8116k.setOnClickListener(this);
        Resources resources = getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = resources.getDrawable(2131362786);
        this.f8106a.setHierarchy(genericDraweeHierarchyBuilder.f(new GradientOverlay(resources)).u());
        this.f8106a.setAspectRatio(1.0f);
        this.f8112g.setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -276583401);
        if (view == this.f8112g) {
            this.f8123s.m9335b(this.f8113h, this);
        } else if (this.f8114i != null) {
            MusicPreviewLogger musicPreviewLogger = this.f8124t;
            String str = this.f8120o;
            String str2 = this.f8121p;
            ArrayNode arrayNode = this.f8122q;
            musicPreviewLogger.f8057a.a(new HoneyClientEvent("music_preview_action_sheet").b("og_song_id", str).b("og_object_id", str2).a("tracking_codes", arrayNode).b("provider_name", this.f8111f));
            this.f8127w.m9122a(getContext(), this.f8114i, this.f8115j, this.f8111f, this.f8120o, this.f8121p, this.f8122q);
        }
        LogUtils.a(-274121112, a);
    }

    public final void mo231a(int i, int i2) {
        this.f8112g.setProgress(((float) i2) / ((float) i));
    }

    public final void mo233a(Uri uri, SongClipState songClipState) {
        switch (songClipState) {
            case PLAYING:
                MusicPreviewLogger musicPreviewLogger = this.f8124t;
                String str = this.f8120o;
                String str2 = this.f8121p;
                ArrayNode arrayNode = this.f8122q;
                musicPreviewLogger.f8057a.a(new HoneyClientEvent("music_preview_play").b("og_song_id", str).b("og_object_id", str2).a("tracking_codes", arrayNode).b("provider_name", this.f8111f));
                this.f8112g.setPlayingStatus(PlayingStatus.PLAYING);
                return;
            case PAUSED:
                this.f8112g.setPlayingStatus(PlayingStatus.PAUSED);
                return;
            case STOPPED:
                this.f8112g.setProgress(0.0f);
                this.f8112g.setPlayingStatus(PlayingStatus.STOPPED);
                return;
            case BUFFERING:
                this.f8112g.setProgress(0.0f);
                this.f8112g.setPlayingStatus(PlayingStatus.BUFFERING);
                return;
            default:
                return;
        }
    }

    public final void mo234a(Uri uri, String str) {
        this.f8124t.m9102a(uri == null ? "" : uri.toString(), this.f8120o, this.f8121p, this.f8122q, this.f8111f, str);
    }

    public final void mo232a(Uri uri, int i, int i2) {
        this.f8124t.m9101a(this.f8120o, this.f8121p, this.f8122q, this.f8111f, uri == null ? "" : uri.toString(), i, i2);
    }

    protected void onMeasure(int i, int i2) {
        int size = (int) ((this.f8130z ? 0.3f : 1.0f) * ((float) ((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight())));
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((getPaddingTop() + size) + getPaddingBottom(), 1073741824);
        size = (int) (((float) size) * 0.3f);
        this.f8112g.getLayoutParams().height = size;
        this.f8112g.getLayoutParams().width = size;
        super.onMeasure(i, makeMeasureSpec);
    }
}
