package com.facebook.video.creativeediting;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.TimeConversions;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.ipc.videoeditgallery.VideoEditFeature;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentController.C11703;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentController.C11714;
import com.facebook.video.creativeediting.abtest.ExperimentsForVideoCreativeEditingAbtestModule;
import com.facebook.video.creativeediting.analytics.TrimmerLoggingParams;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger.CreativeToolsParams;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger.Params;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.trimmer.StripHandleController;
import com.facebook.video.creativeediting.trimmer.StripHandleController.HandlePosition;
import com.facebook.video.creativeediting.trimmer.StripHandleTouchListener;
import com.facebook.video.creativeediting.trimmer.StripScrubberController;
import com.facebook.video.creativeediting.trimmer.StripScrubberController.C11881;
import com.facebook.video.creativeediting.trimmer.StripScrubberTouchListener;
import com.facebook.video.creativeediting.trimmer.StripSlidingController;
import com.facebook.video.creativeediting.trimmer.StripSlidingControllerProvider;
import com.facebook.video.creativeediting.trimmer.StripZoomingController;
import com.facebook.video.creativeediting.trimmer.StripZoomingControllerProvider;
import com.facebook.video.creativeediting.trimmer.VideoStripController;
import com.facebook.video.creativeediting.trimmer.VideoStripControllerProvider;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverter;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverterProvider;
import com.facebook.video.creativeediting.utilities.TrimmedVideoLengthChecker;
import com.facebook.video.creativeediting.utilities.VideoMetadataExtractHelper;
import com.facebook.video.creativeediting.utilities.ZoomPositionConverter;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
public class VideoTrimmingController implements VideoEditFeatureController {
    private ViewStub f15488A;
    private View f15489B;
    public ImageView f15490C;
    public VideoEditGalleryTrimmerFilmstripView f15491D;
    public ZoomableDraweeStripView f15492E;
    private View f15493F;
    private View f15494G;
    private View f15495H;
    public View f15496I;
    public Tooltip f15497J;
    public Tooltip f15498K;
    public Tooltip f15499L;
    private VideoTrimParams f15500M;
    private long f15501N;
    public boolean f15502O;
    public final TrimmerLoggingParams f15503P = new TrimmerLoggingParams();
    private final Context f15504a;
    public final VideoEditGalleryFragmentController f15505b;
    public final VideoEditGalleryFragmentController f15506c;
    private final QeAccessor f15507d;
    private final Uri f15508e;
    private final String f15509f;
    private final boolean f15510g;
    private final boolean f15511h;
    public final boolean f15512i;
    private final int f15513j;
    private final int f15514k;
    private final int f15515l;
    private final int f15516m;
    private final ZoomPositionConverter f15517n;
    public final StripViewVideoTimeConverter f15518o;
    private final TrimmedVideoLengthChecker f15519p;
    public final StripHandleController f15520q;
    public final StripScrubberController f15521r;
    private final StripSlidingController f15522s;
    public final StripZoomingController f15523t;
    private final VideoStripController f15524u;
    private final VideoCreativeEditingLogger f15525v;
    private final VideoEditingGalleryEntryPoint f15526w;
    private final int f15527x;
    private final int f15528y;
    private final int f15529z;

    /* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
    class C11781 implements OnPreDrawListener {
        boolean f15476a = false;
        final /* synthetic */ VideoTrimmingController f15477b;

        C11781(VideoTrimmingController videoTrimmingController) {
            this.f15477b = videoTrimmingController;
        }

        public boolean onPreDraw() {
            if (this.f15476a) {
                this.f15477b.f15491D.setVisibility(0);
                this.f15477b.f15491D.getViewTreeObserver().removeOnPreDrawListener(this);
                VideoTrimmingController.m19523q(this.f15477b);
                VideoTrimmingController.m19528w(this.f15477b);
                VideoTrimmingController.m19527u(this.f15477b);
            } else {
                this.f15476a = true;
                this.f15477b.f15491D.invalidate();
                VideoTrimmingController.m19522p(this.f15477b);
                VideoEditGalleryFragmentController videoEditGalleryFragmentController = this.f15477b.f15505b;
                Fb4aTitleBar fb4aTitleBar = videoEditGalleryFragmentController.f15419f.av;
                Builder a = TitleBarButtonSpec.a();
                a.g = videoEditGalleryFragmentController.f15419f.b(2131234500);
                Object a2 = a.a();
                fb4aTitleBar.a(new C11703(videoEditGalleryFragmentController));
                int i = videoEditGalleryFragmentController.f15419f.ao.f6212l;
                if (i != -1) {
                    a = TitleBarButtonSpec.a();
                    a.g = videoEditGalleryFragmentController.f15422i.getTransformation(videoEditGalleryFragmentController.f15419f.b(i), null).toString();
                    a2 = a.a();
                }
                fb4aTitleBar.setButtonSpecs(ImmutableList.of(a2));
                fb4aTitleBar.setOnToolbarButtonListener(new C11714(videoEditGalleryFragmentController));
                videoEditGalleryFragmentController.f15421h.f15445a.b(9175041, (short) 2);
                int i2 = videoEditGalleryFragmentController.f15419f.ao.f6211k;
                if (i2 != 0) {
                    videoEditGalleryFragmentController.f15419f.as().m19497a(i2);
                }
            }
            return false;
        }
    }

    /* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
    public class C11792 {
        final /* synthetic */ VideoTrimmingController f15478a;

        C11792(VideoTrimmingController videoTrimmingController) {
            this.f15478a = videoTrimmingController;
        }

        public final int m19503a() {
            return this.f15478a.f15492E.getZoomedInLeftOffset();
        }
    }

    /* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
    public class C11803 implements OnClickListener {
        final /* synthetic */ VideoTrimmingController f15479a;

        public C11803(VideoTrimmingController videoTrimmingController) {
            this.f15479a = videoTrimmingController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1686503085);
            VideoEditGalleryFragmentController videoEditGalleryFragmentController = this.f15479a.f15505b;
            videoEditGalleryFragmentController.f15436w.f15413c = true;
            videoEditGalleryFragmentController.f15419f.as().m19499b();
            Logger.a(2, EntryType.UI_INPUT_END, 947438366, a);
        }
    }

    /* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
    public class C11836 {
        public final /* synthetic */ VideoTrimmingController f15485a;

        C11836(VideoTrimmingController videoTrimmingController) {
            this.f15485a = videoTrimmingController;
        }
    }

    /* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
    public class C11847 {
        public final /* synthetic */ VideoTrimmingController f15486a;

        C11847(VideoTrimmingController videoTrimmingController) {
            this.f15486a = videoTrimmingController;
        }
    }

    /* compiled from: e1dfef2b47c02fa08ad57cc126437d61 */
    public class C11858 {
        public final /* synthetic */ VideoTrimmingController f15487a;

        C11858(VideoTrimmingController videoTrimmingController) {
            this.f15487a = videoTrimmingController;
        }
    }

    @Inject
    public VideoTrimmingController(Context context, VideoStripControllerProvider videoStripControllerProvider, ZoomPositionConverter zoomPositionConverter, StripViewVideoTimeConverterProvider stripViewVideoTimeConverterProvider, StripSlidingControllerProvider stripSlidingControllerProvider, StripZoomingControllerProvider stripZoomingControllerProvider, VideoCreativeEditingLogger videoCreativeEditingLogger, QeAccessor qeAccessor, @Assisted Uri uri, @Assisted Uri uri2, @Assisted VideoMirroringMode videoMirroringMode, @Assisted String str, @Assisted ViewStub viewStub, @Assisted VideoTrimParams videoTrimParams, @Assisted VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration, @Assisted VideoEditGalleryTrimmerFilmstripView videoEditGalleryTrimmerFilmstripView, @Assisted VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint, @Assisted VideoEditGalleryFragmentController videoEditGalleryFragmentController, @Assisted VideoEditGalleryFragmentController videoEditGalleryFragmentController2) {
        this.f15504a = context;
        this.f15506c = videoEditGalleryFragmentController;
        this.f15505b = videoEditGalleryFragmentController2;
        this.f15525v = videoCreativeEditingLogger;
        this.f15526w = videoEditingGalleryEntryPoint;
        this.f15507d = qeAccessor;
        this.f15508e = uri;
        this.f15509f = str;
        this.f15488A = viewStub;
        this.f15511h = videoEditGalleryLaunchConfiguration.m8072h();
        this.f15513j = videoEditGalleryLaunchConfiguration.m8073i();
        this.f15514k = videoEditGalleryLaunchConfiguration.m8074j();
        this.f15510g = videoEditGalleryLaunchConfiguration.m8070e();
        this.f15491D = videoEditGalleryTrimmerFilmstripView;
        this.f15500M = videoTrimParams;
        this.f15515l = this.f15504a.getResources().getDimensionPixelSize(2131429602);
        this.f15527x = this.f15504a.getResources().getDimensionPixelSize(2131429603);
        this.f15528y = this.f15504a.getResources().getDimensionPixelSize(2131429600);
        this.f15529z = this.f15504a.getResources().getDimensionPixelSize(2131429601);
        this.f15516m = this.f15515l * 2;
        this.f15512i = videoEditGalleryLaunchConfiguration.m8069d();
        this.f15524u = videoStripControllerProvider.m19589a(this.f15508e, uri2, videoEditGalleryLaunchConfiguration.m8071g(), videoMirroringMode);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.f15504a, this.f15508e);
        this.f15501N = VideoMetadataExtractHelper.m19609a(mediaMetadataRetriever);
        mediaMetadataRetriever.release();
        this.f15502O = false;
        this.f15517n = zoomPositionConverter;
        this.f15518o = StripViewVideoTimeConverterProvider.m19606a(this.f15517n);
        this.f15519p = new TrimmedVideoLengthChecker(this.f15513j, this.f15514k);
        this.f15520q = new StripHandleController(this.f15515l, this.f15516m);
        this.f15521r = new StripScrubberController(m19524r(), this.f15518o, this.f15506c, this.f15520q);
        this.f15522s = stripSlidingControllerProvider.m19568a(this.f15518o, this.f15520q, this.f15519p, m19525s());
        this.f15523t = stripZoomingControllerProvider.m19572a(this.f15517n, this.f15520q, this.f15521r, m19526t());
    }

    public final String mo559a() {
        return this.f15504a.getString(2131234511);
    }

    public final void mo564b() {
    }

    public final void mo565c() {
    }

    public final boolean mo566d() {
        this.f15521r.m19563c();
        return true;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo568f() {
        if (this.f15492E.getZoomedOutWidth() != 0) {
            m19528w(this);
            m19527u(this);
        }
    }

    public final void mo569g() {
        this.f15524u.m19587a();
        this.f15521r.m19563c();
    }

    public final void mo570h() {
        if (this.f15489B == null) {
            this.f15488A.setLayoutResource(2130907668);
            this.f15489B = this.f15488A.inflate();
        }
        if (this.f15510g) {
            View view = this.f15489B;
            if (this.f15490C == null) {
                this.f15490C = (ImageView) view.findViewById(2131568323);
                this.f15490C.setOnClickListener(new C11803(this));
            }
            this.f15490C.setVisibility(0);
        }
        this.f15492E = this.f15491D.f15448a;
        this.f15493F = this.f15491D.f15449b;
        this.f15494G = this.f15491D.f15450c;
        this.f15495H = this.f15491D.f15453f;
        this.f15496I = this.f15491D.f15454g;
        this.f15491D.getViewTreeObserver().addOnPreDrawListener(new C11781(this));
        if (this.f15507d.a(ExperimentsForVideoCreativeEditingAbtestModule.e, false)) {
            this.f15497J = new Tooltip(this.f15504a, 2);
            this.f15497J.t = -1;
            this.f15497J.c(this.f15493F);
            this.f15497J.a(Position.ABOVE);
            this.f15498K = new Tooltip(this.f15504a, 2);
            this.f15498K.t = -1;
            this.f15498K.c(this.f15494G);
            this.f15498K.a(Position.ABOVE);
            this.f15499L = new Tooltip(this.f15504a, 1);
            this.f15499L.t = -1;
            this.f15499L.c(this.f15496I);
            this.f15499L.a(Position.ABOVE);
        }
    }

    public final void mo571i() {
        this.f15521r.m19563c();
        if (this.f15490C != null) {
            this.f15490C.setVisibility(8);
        }
    }

    public final Object mo572j() {
        return VideoEditFeature.TRIM;
    }

    public final void mo1194k() {
        VideoCreativeEditingLogger videoCreativeEditingLogger = this.f15525v;
        String uri = this.f15508e.toString();
        String str = this.f15509f;
        VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint = this.f15526w;
        TrimmerLoggingParams trimmerLoggingParams = this.f15503P;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("video_editing_handle_interactions");
        honeyClientEvent.c = "video_editing_module";
        videoCreativeEditingLogger.f15536a.a(honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), uri).b(Params.SESSION_ID.getParamKey(), str).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).a(CreativeToolsParams.LEFT_HANDLE_MOVES.getParamKey(), trimmerLoggingParams.m19544c(HandlePosition.LEFT)).a(CreativeToolsParams.RIGHT_HANDLE_MOVES.getParamKey(), trimmerLoggingParams.m19544c(HandlePosition.RIGHT)));
        honeyClientEvent = new HoneyClientEvent("video_editing_zoom_interactions");
        honeyClientEvent.c = "video_editing_module";
        videoCreativeEditingLogger.f15536a.a(honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), uri).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).a(CreativeToolsParams.LEFT_HANDLE_ZOOM_INS.getParamKey(), trimmerLoggingParams.m19545d(HandlePosition.LEFT)).a(CreativeToolsParams.RIGHT_HANDLE_ZOOM_INS.getParamKey(), trimmerLoggingParams.m19545d(HandlePosition.RIGHT)));
        honeyClientEvent = new HoneyClientEvent("video_editing_scrubber_interactions");
        honeyClientEvent.c = "video_editing_module";
        videoCreativeEditingLogger.f15536a.a(honeyClientEvent.b(Params.VIDEO_ITEM_IDENTIFIER.getParamKey(), uri).b(Params.SESSION_ID.getParamKey(), str).b(Params.ENTRY_POINT.getParamKey(), videoEditingGalleryEntryPoint.getParamKey()).a(CreativeToolsParams.SCRUBBER_MOVES.getParamKey(), trimmerLoggingParams.f15535e));
    }

    public static void m19522p(VideoTrimmingController videoTrimmingController) {
        videoTrimmingController.f15524u.m19588a(videoTrimmingController.f15492E, videoTrimmingController.f15516m, videoTrimmingController.f15516m);
        ZoomPositionConverter zoomPositionConverter = videoTrimmingController.f15517n;
        int zoomedInStripContentWidth = videoTrimmingController.f15492E.getZoomedInStripContentWidth();
        int zoomedOutStripContentWidth = videoTrimmingController.f15492E.getZoomedOutStripContentWidth();
        int i = videoTrimmingController.f15516m;
        C11792 c11792 = new C11792(videoTrimmingController);
        zoomPositionConverter.f15654a = zoomedInStripContentWidth;
        zoomPositionConverter.f15655b = zoomedOutStripContentWidth;
        zoomPositionConverter.f15656c = i;
        zoomPositionConverter.f15657d = c11792;
        StripViewVideoTimeConverter stripViewVideoTimeConverter = videoTrimmingController.f15518o;
        zoomedInStripContentWidth = (int) videoTrimmingController.f15501N;
        zoomedOutStripContentWidth = videoTrimmingController.f15492E.getZoomedOutStripContentWidth();
        i = videoTrimmingController.f15516m;
        stripViewVideoTimeConverter.f15649b = zoomedInStripContentWidth;
        stripViewVideoTimeConverter.f15650c = zoomedOutStripContentWidth;
        stripViewVideoTimeConverter.f15651d = i;
        StripHandleController stripHandleController = videoTrimmingController.f15520q;
        ZoomableDraweeStripView zoomableDraweeStripView = videoTrimmingController.f15492E;
        VideoEditGalleryTrimmerFilmstripView videoEditGalleryTrimmerFilmstripView = videoTrimmingController.f15491D;
        stripHandleController.f15539c = zoomableDraweeStripView;
        stripHandleController.f15540d = videoEditGalleryTrimmerFilmstripView.f15449b;
        stripHandleController.f15541e = videoEditGalleryTrimmerFilmstripView.f15450c;
        stripHandleController.f15542f = videoEditGalleryTrimmerFilmstripView.f15451d;
        stripHandleController.f15543g = videoEditGalleryTrimmerFilmstripView.f15452e;
        stripHandleController.f15544h = videoEditGalleryTrimmerFilmstripView.f15453f;
        videoTrimmingController.f15521r.f15565c = videoTrimmingController.f15496I;
        videoTrimmingController.f15522s.f15579f = videoTrimmingController.f15492E;
        videoTrimmingController.f15523t.f15590f = videoTrimmingController.f15492E;
        videoTrimmingController.f15493F.setOnTouchListener(videoTrimmingController.m19517a(HandlePosition.LEFT));
        videoTrimmingController.f15494G.setOnTouchListener(videoTrimmingController.m19517a(HandlePosition.RIGHT));
        View view = videoTrimmingController.f15495H;
        final boolean z = videoTrimmingController.f15511h;
        view.setOnTouchListener(new StripScrubberTouchListener(videoTrimmingController) {
            final /* synthetic */ VideoTrimmingController f15482b;

            public final int mo1198a() {
                return this.f15482b.f15520q.m19553a();
            }

            public final int mo1200b() {
                return this.f15482b.f15520q.m19557b();
            }

            public final void mo1199a(int i) {
                this.f15482b.f15521r.m19561a(i);
                if (this.f15482b.f15499L != null) {
                    this.f15482b.f15499L.b(VideoTrimmingController.m19516A(this.f15482b));
                    this.f15482b.f15499L.d();
                }
            }

            public final void mo1201b(int i) {
                if (z) {
                    this.f15482b.f15521r.m19563c();
                    StripHandleController stripHandleController = this.f15482b.f15520q;
                    int i2 = i - this.f15480a;
                    if (stripHandleController.f15540d.getLeft() + i2 >= 0 && stripHandleController.f15541e.getRight() + i2 <= stripHandleController.f15539c.getZoomedOutWidth()) {
                        stripHandleController.m19556a(stripHandleController.m19553a() + i2, false);
                        stripHandleController.m19559b(stripHandleController.m19557b() + i2, false);
                        return;
                    }
                    return;
                }
                this.f15482b.f15521r.m19561a(i);
                if (this.f15482b.f15499L != null) {
                    this.f15482b.f15499L.b(VideoTrimmingController.m19516A(this.f15482b));
                    this.f15482b.f15499L.d();
                }
            }

            public final void mo1202c() {
                TrimmerLoggingParams trimmerLoggingParams = this.f15482b.f15503P;
                trimmerLoggingParams.f15535e++;
                if (z) {
                    VideoTrimmingController.m19527u(this.f15482b);
                    return;
                }
                VideoTrimmingController.m19529y(this.f15482b);
                if (this.f15482b.f15499L != null) {
                    this.f15482b.f15499L.l();
                }
            }
        });
        videoTrimmingController.f15502O = true;
    }

    public static void m19523q(VideoTrimmingController videoTrimmingController) {
        if (videoTrimmingController.f15500M == null || !videoTrimmingController.f15500M.isTrimSpecified || videoTrimmingController.f15501N == 0) {
            videoTrimmingController.f15495H.setLeft(videoTrimmingController.f15492E.getLeft() + videoTrimmingController.f15515l);
            int i = (int) videoTrimmingController.f15501N;
            if (videoTrimmingController.f15514k > 0 && i > videoTrimmingController.f15514k) {
                i = videoTrimmingController.f15514k;
            }
            videoTrimmingController.m19521d(videoTrimmingController.f15518o.m19603a(i), false);
            return;
        }
        videoTrimmingController.m19520c(videoTrimmingController.f15518o.m19603a(videoTrimmingController.f15500M.videoTrimStartTimeMs), false);
        videoTrimmingController.m19521d(videoTrimmingController.f15518o.m19603a(videoTrimmingController.f15500M.videoTrimEndTimeMs), false);
    }

    public static void m19518a(VideoTrimmingController videoTrimmingController, int i, boolean z) {
        videoTrimmingController.m19520c(i, z);
        videoTrimmingController.f15505b.m19474a(videoTrimmingController.f15518o.m19604a(i, z));
    }

    public static void m19519b(VideoTrimmingController videoTrimmingController, int i, boolean z) {
        videoTrimmingController.m19521d(i, z);
        videoTrimmingController.f15505b.m19474a(videoTrimmingController.f15518o.m19604a(videoTrimmingController.f15520q.m19557b(), z));
    }

    private void m19520c(int i, boolean z) {
        this.f15521r.m19563c();
        this.f15520q.m19556a(i, z);
    }

    private void m19521d(int i, boolean z) {
        this.f15521r.m19563c();
        this.f15520q.m19559b(i, z);
    }

    public final int m19542m() {
        return this.f15518o.m19604a(this.f15520q.m19553a(), false);
    }

    private OnTouchListener m19517a(final HandlePosition handlePosition) {
        return new StripHandleTouchListener(this.f15520q, this.f15523t, this.f15522s, this.f15518o, this.f15521r, this.f15519p, this.f15529z, this.f15527x, this.f15528y, this.f15492E, this.f15493F, this.f15494G, handlePosition, new Object(this) {
            final /* synthetic */ VideoTrimmingController f15484b;

            public final void m19515a(boolean z) {
                if (handlePosition == HandlePosition.LEFT) {
                    VideoTrimmingController.m19527u(this.f15484b);
                    if (this.f15484b.f15497J != null) {
                        this.f15484b.f15497J.l();
                    }
                } else {
                    VideoTrimmingController videoTrimmingController = this.f15484b;
                    videoTrimmingController.f15521r.m19563c();
                    videoTrimmingController.f15521r.m19561a(videoTrimmingController.f15518o.m19603a(videoTrimmingController.f15518o.m19604a(videoTrimmingController.f15520q.m19557b(), false) - 1000) - videoTrimmingController.f15496I.getWidth());
                    VideoTrimmingController.m19529y(videoTrimmingController);
                    if (this.f15484b.f15498K != null) {
                        this.f15484b.f15498K.l();
                    }
                }
                if (z) {
                    TrimmerLoggingParams trimmerLoggingParams = this.f15484b.f15503P;
                    if (handlePosition == HandlePosition.LEFT) {
                        trimmerLoggingParams.f15531a++;
                    } else {
                        trimmerLoggingParams.f15532b++;
                    }
                }
            }

            public final void m19514a(int i) {
                if (handlePosition == HandlePosition.LEFT) {
                    VideoTrimmingController.m19518a(this.f15484b, this.f15484b.f15520q.m19553a() + i, this.f15484b.f15523t.f15592h);
                    if (this.f15484b.f15497J != null) {
                        this.f15484b.f15497J.b(VideoTrimmingController.m19530z(this.f15484b));
                        this.f15484b.f15497J.d();
                        return;
                    }
                    return;
                }
                VideoTrimmingController.m19519b(this.f15484b, this.f15484b.f15520q.m19557b() + i, this.f15484b.f15523t.f15592h);
                if (this.f15484b.f15498K != null) {
                    this.f15484b.f15498K.b(VideoTrimmingController.m19530z(this.f15484b));
                    this.f15484b.f15498K.d();
                }
            }
        });
    }

    private C11836 m19524r() {
        return new C11836(this);
    }

    private C11847 m19525s() {
        return new C11847(this);
    }

    private C11858 m19526t() {
        return new C11858(this);
    }

    public static void m19527u(VideoTrimmingController videoTrimmingController) {
        videoTrimmingController.f15521r.m19563c();
        videoTrimmingController.f15521r.m19561a(videoTrimmingController.f15520q.m19553a());
        m19529y(videoTrimmingController);
    }

    public static void m19528w(VideoTrimmingController videoTrimmingController) {
        Object obj;
        if (videoTrimmingController.f15521r.f15563a != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            StripScrubberController stripScrubberController = videoTrimmingController.f15521r;
            stripScrubberController.f15563a = new C11881(stripScrubberController, (int) ((3 * videoTrimmingController.f15501N) / ((long) videoTrimmingController.f15492E.getZoomedOutStripContentWidth())));
        }
    }

    public static void m19529y(VideoTrimmingController videoTrimmingController) {
        videoTrimmingController.f15505b.f15419f.as().m19500c();
        videoTrimmingController.f15521r.m19562b();
    }

    public static String m19530z(VideoTrimmingController videoTrimmingController) {
        long a = (long) videoTrimmingController.f15518o.m19605a(videoTrimmingController.f15523t.f15592h, videoTrimmingController.f15520q.m19553a(), videoTrimmingController.f15520q.m19557b());
        return videoTrimmingController.f15504a.getResources().getString(2131234516, new Object[]{DateUtils.formatElapsedTime(Math.round(TimeConversions.n(a)))});
    }

    public static String m19516A(VideoTrimmingController videoTrimmingController) {
        return DateUtils.formatElapsedTime(Math.round(TimeConversions.n((long) (videoTrimmingController.f15518o.m19604a(videoTrimmingController.f15521r.m19565e(), videoTrimmingController.f15523t.f15592h) - videoTrimmingController.f15518o.m19604a(videoTrimmingController.f15520q.m19553a(), videoTrimmingController.f15523t.f15592h)))));
    }
}
