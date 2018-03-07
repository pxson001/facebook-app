package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerFragment.62;
import com.facebook.composer.analytics.PhotoSequences;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerStickersCapability;
import com.facebook.composer.capability.ComposerTextEditCapability;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.underwood.TaggingController.TagsChangedListener;
import com.facebook.composer.ui.underwood.UnderwoodController.AttachmentEventsListener;
import com.facebook.composer.ui.underwood.common.ButtonAnimator;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.ipc.videoeditgallery.VideoEditFeature;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.creativeediting.abtest.IsEligibleForFramePrompts;
import com.facebook.photos.creativeediting.abtest.IsSwipeableFiltersEnabled;
import com.facebook.photos.creativeediting.abtest.IsUnifiedEditGalleryEnabled;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger.Events;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController.OverlayType;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.Listener;
import com.facebook.photos.creativeediting.swipeable.common.FramePrefsManager;
import com.facebook.photos.creativeediting.swipeable.common.FrameShuffler;
import com.facebook.photos.creativeediting.swipeable.common.FramesAggregator;
import com.facebook.photos.creativeediting.swipeable.common.SwipeEventListener;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilder;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.creativeediting.swipeable.composer.BaseGeneratorEventSubscriber;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGenerator$EventSubscriber;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGeneratorImpl;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableViewParentEventSubscriber;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableFilterNuxController;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableFilterNuxControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableFrameNuxController;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableFrameNuxControllerProvider;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.photos.creativeediting.utilities.MediaRotationHelper;
import com.facebook.photos.editgallery.EditGalleryFragmentManager;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.EditGalleryCallback;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.tagging.shared.FaceBoxesView;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbButton;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tagging.graphql.utils.MentionsUtils.MentionChangeListener;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.ultralight.Inject;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.VideoEditGalleryPerformanceLogger;
import com.facebook.video.creativeediting.analytics.ComposerEntryPoint;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.mediareorderview.UnderwoodBitmapWidthHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: comments_shown_ */
public class VerticalAttachmentView<DataProvider extends ProvidesAttachments & ProvidesIsComposerDrawn & ProvidesConfiguration & ProvidesTargetData> extends CustomFrameLayout {
    private static final CallerContext f17273I = CallerContext.b(VerticalAttachmentView.class, "composer");
    public static final RectF f17274J = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public static final String f17275K = VerticalAttachmentView.class.getSimpleName();
    @Inject
    VideoCreativeEditingLogger f17276A;
    @Inject
    VideoEditGalleryPerformanceLogger f17277B;
    @Inject
    FramesAggregator f17278C;
    @Inject
    FrameAssetsLoader f17279D;
    @Inject
    FramePrefsManager f17280E;
    @Inject
    SwipeableParamsListBuilderProvider f17281F;
    @Inject
    UnderwoodVideoTranscodingUtil f17282G;
    protected boolean f17283H;
    public final EditGalleryCallback f17284L = new C14081(this);
    public final VideoEditGalleryCallback f17285M = new C14092(this);
    private final SwipeableDraweeControllerGenerator$EventSubscriber f17286N = new C14103(this);
    private final Runnable f17287O = new C14114(this);
    private final SwipeEventListener f17288P = new C14135(this);
    private final OnTouchListener f17289Q = new C14146(this);
    private final OnClickListener f17290R = new C14157(this);
    public final FrameLayout f17291S;
    private final ImageView f17292T;
    private final LazyView<View> f17293U;
    public final ViewStub f17294V;
    public final MentionsAutoCompleteTextView f17295W;
    @Inject
    public AbstractFbErrorReporter f17296a;
    private int aA = 0;
    private LinearLayout aB;
    public LinearLayout aC;
    private boolean aD;
    private boolean aE;
    public boolean aF;
    public FbButton aG;
    public DataProvider aH;
    private ScrollingAwareScrollView aI;
    public TargetType aJ;
    public Optional<EditGalleryLaunchConfiguration> aK = Absent.withType();
    public Optional<VideoEditGalleryLaunchConfiguration> aL = Absent.withType();
    public ImmutableList<SwipeableParams> aM = ImmutableList.of();
    public boolean aN;
    public CreativeEditingLogger aO;
    private Runnable aP;
    public boolean aQ;
    private final ViewStub aa;
    public final FragmentManager ab;
    public final CreativeEditingPhotoOverlayView ac;
    public final AttachmentEventsListener ad;
    public final EventListener ae;
    public final ComposerAttachmentViewUtility af;
    private final TasksManager<Integer> ag;
    private final int ah;
    public final int ai;
    private final CaptionWatcher aj;
    public final Point ak;
    public final int al;
    public final String am;
    private final boolean an;
    private final boolean ao;
    private final List<SwipeableViewParentEventSubscriber> ap = Lists.a();
    public Optional<CreativeEditingSwipeableController> aq = Absent.INSTANCE;
    public Optional<TaggingController> ar = Absent.withType();
    public ComposerAttachment as;
    public float at;
    public float au;
    public boolean av;
    public ImageFormat aw = ImageFormat.UNKNOWN;
    public int ax;
    public Optional<EditGalleryFragmentManager> ay = Absent.withType();
    public Optional<VideoEditGalleryFragmentManager> az = Absent.withType();
    @Inject
    @ForUiThread
    ExecutorService f17297b;
    @Inject
    UnderwoodBitmapWidthHelper f17298c;
    @Inject
    TaggingControllerProvider f17299d;
    @Inject
    public PhotoSequences f17300e;
    @Inject
    CreativeEditingSwipeableControllerProvider f17301f;
    @Inject
    Provider<CreativeEditingAnalyticsLogger> f17302g;
    @Inject
    ImagePipeline f17303h;
    @Inject
    ComposerStickersCapability f17304i;
    @Inject
    ComposerTextEditCapability f17305j;
    @Inject
    PhotoOverlayController f17306k;
    @Inject
    FaceBoxStore f17307l;
    @Inject
    Lazy<MediaRotationHelper> f17308m;
    @Inject
    Lazy<CreativeEditingImageHelper> f17309n;
    @Inject
    @IsUnifiedEditGalleryEnabled
    Provider<Boolean> f17310o;
    @Inject
    @IsSwipeableFiltersEnabled
    public Provider<Boolean> f17311p;
    @Inject
    @IsEligibleForFramePrompts
    public Provider<Boolean> f17312q;
    @Inject
    Product f17313r;
    @Inject
    Provider<CreativeEditingLogger> f17314s;
    @Inject
    SwipeableParamsHelper f17315t;
    @Inject
    SwipeableDraweeControllerGeneratorImpl f17316u;
    @Inject
    SwipeableFrameNuxControllerProvider f17317v;
    @Inject
    SwipeableFilterNuxControllerProvider f17318w;
    @Inject
    MediaItemFactory f17319x;
    @Inject
    QeAccessor f17320y;
    @Inject
    TaggingProfiles f17321z;

    /* compiled from: comments_shown_ */
    class C14081 implements EditGalleryCallback {
        final /* synthetic */ VerticalAttachmentView f17259a;

        C14081(VerticalAttachmentView verticalAttachmentView) {
            this.f17259a = verticalAttachmentView;
        }

        public final void mo222a(UsageParams usageParams, ExpirationState expirationState, boolean z) {
            Preconditions.checkNotNull(usageParams);
            String mediaIdKey = this.f17259a.as.b().d().toString();
            this.f17259a.ae.mo491a(mediaIdKey, usageParams.f10346a);
            this.f17259a.ae.mo493b(mediaIdKey, usageParams.f10347b);
            this.f17259a.ae.mo494c(mediaIdKey, usageParams.f10349d);
            this.f17259a.ae.mo495d(mediaIdKey, usageParams.f10350e);
        }

        public final void mo221a(CreativeEditingData creativeEditingData) {
            Preconditions.checkNotNull(creativeEditingData);
            this.f17259a.ad.m21137a(this.f17259a.as, this.f17259a.as.b(), creativeEditingData, true, true);
        }

        public final int mo220a(int i) {
            MediaItem b = this.f17259a.as.b();
            this.f17259a.ae.mo496e(b.d().toString(), Math.abs(i - b.g()) % 360);
            MediaRotationHelper mediaRotationHelper = (MediaRotationHelper) this.f17259a.f17308m.get();
            PhotoItem photoItem = (PhotoItem) this.f17259a.as.b();
            Preconditions.checkNotNull(photoItem);
            Preconditions.checkArgument(i >= 0);
            mediaRotationHelper.a.b(photoItem, i);
            Preconditions.checkNotNull(photoItem);
            int size = mediaRotationHelper.b.a(photoItem.f).size();
            mediaRotationHelper.b.d(photoItem);
            int i2 = size;
            Preconditions.checkNotNull(photoItem);
            mediaRotationHelper.c.a(photoItem);
            return i2;
        }
    }

    /* compiled from: comments_shown_ */
    class C14092 implements VideoEditGalleryCallback {
        final /* synthetic */ VerticalAttachmentView f17260a;

        C14092(VerticalAttachmentView verticalAttachmentView) {
            this.f17260a = verticalAttachmentView;
        }

        public final void mo1169a(VideoCreativeEditingData videoCreativeEditingData, int i) {
            Preconditions.checkNotNull(videoCreativeEditingData);
            this.f17260a.ad.m21138a(this.f17260a.as, this.f17260a.as.b(), videoCreativeEditingData);
        }

        public final void mo1168a(int i) {
        }
    }

    /* compiled from: comments_shown_ */
    class C14103 extends BaseGeneratorEventSubscriber {
        final /* synthetic */ VerticalAttachmentView f17261a;

        C14103(VerticalAttachmentView verticalAttachmentView) {
            this.f17261a = verticalAttachmentView;
        }

        public final void mo514a(DraweeSwipeableItem draweeSwipeableItem) {
            PhotoSequences photoSequences = this.f17261a.f17300e;
            String str = this.f17261a.am;
            long c = this.f17261a.as.b().c();
            Optional fromNullable = Optional.fromNullable(photoSequences.b.b(PhotoSequences.a, str));
            if (fromNullable.isPresent()) {
                SequenceLoggerDetour.b((Sequence) fromNullable.get(), "loadPhoto", String.valueOf(c), null, photoSequences.c.now(), 1217105212);
            }
            if (this.f17261a.al == 0) {
                this.f17261a.f17300e.c(this.f17261a.am, this.f17261a.as.b().c());
            }
            if (this.f17261a.ac != null) {
                this.f17261a.ac.setVisibility(0);
            }
            this.f17261a.ad.m21140c(this.f17261a.as);
            this.f17261a.setFaceBoxesAndTags(this.f17261a.aF);
        }

        public final void mo516b(DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3) {
            this.f17261a.invalidate();
        }
    }

    /* compiled from: comments_shown_ */
    class C14114 implements Runnable {
        final /* synthetic */ VerticalAttachmentView f17262a;

        C14114(VerticalAttachmentView verticalAttachmentView) {
            this.f17262a = verticalAttachmentView;
        }

        public void run() {
            if (this.f17262a.as != null) {
                this.f17262a.ad.m21137a(this.f17262a.as, this.f17262a.as.b(), VerticalAttachmentView.m21186C(this.f17262a), false, false);
            }
        }
    }

    /* compiled from: comments_shown_ */
    class C14135 implements SwipeEventListener {
        final /* synthetic */ VerticalAttachmentView f17264a;
        private final Runnable f17265b = new C14121(this);

        /* compiled from: comments_shown_ */
        class C14121 implements Runnable {
            final /* synthetic */ C14135 f17263a;

            C14121(C14135 c14135) {
                this.f17263a = c14135;
            }

            public void run() {
                if (this.f17263a.f17264a.as != null) {
                    this.f17263a.f17264a.ad.m21137a(this.f17263a.f17264a.as, this.f17263a.f17264a.as.b(), VerticalAttachmentView.m21186C(this.f17263a.f17264a), false, false);
                }
            }
        }

        C14135(VerticalAttachmentView verticalAttachmentView) {
            this.f17264a = verticalAttachmentView;
        }

        public final void mo511a(@Nullable SwipeableParams swipeableParams) {
            if (this.f17264a.as != null) {
                this.f17264a.removeCallbacks(this.f17265b);
                this.f17264a.postDelayed(this.f17265b, 500);
                if (swipeableParams != null) {
                    this.f17264a.aO.m11484b(swipeableParams);
                    if (!this.f17264a.aN && swipeableParams.c == SwipeableItemType.FRAME) {
                        this.f17264a.f17280E.m11679b(SystemClock.a.a());
                    }
                }
                this.f17264a.aN = true;
                if (this.f17264a.f17320y.a(ExperimentsForCreativeEditingAbtestModule.g, false)) {
                    RectF rectF;
                    if (this.f17264a.aG.getBackground() instanceof AnimationDrawable) {
                        ((AnimationDrawable) this.f17264a.aG.getBackground()).stop();
                        if (VerticalAttachmentView.m21189G(this.f17264a)) {
                            this.f17264a.aG.setBackgroundResource(2130838476);
                        } else {
                            this.f17264a.aG.setBackgroundResource(2130838474);
                        }
                    }
                    int a = (int) (((float) this.f17264a.ai) / this.f17264a.af.m21073a(this.f17264a.as.b()));
                    this.f17264a.ae.mo490a(this.f17264a.as.b().d().toString());
                    RectF rectF2 = VerticalAttachmentView.f17274J;
                    if (this.f17264a.as.e() == null || this.f17264a.as.e().c() == null) {
                        rectF = rectF2;
                    } else {
                        rectF = this.f17264a.as.e().c();
                    }
                    Builder builder = new Builder((EditGalleryLaunchConfiguration) this.f17264a.aK.get());
                    builder.j = VerticalAttachmentView.m21186C(this.f17264a);
                    ((EditGalleryFragmentManager) this.f17264a.ay.get()).m12201a(this.f17264a.as.c(), this.f17264a.ai, a, builder.a(), this.f17264a.f17284L, ((TaggingController) this.f17264a.ar.get()).m21130b(rectF), AnimationParam.m12362a(this.f17264a.f17291S));
                }
            }
        }

        public final void mo510a() {
        }

        public final void mo512a(boolean z) {
        }
    }

    /* compiled from: comments_shown_ */
    class C14146 implements OnTouchListener {
        final /* synthetic */ VerticalAttachmentView f17266a;

        C14146(VerticalAttachmentView verticalAttachmentView) {
            this.f17266a = verticalAttachmentView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f17266a.ak.set((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
    }

    /* compiled from: comments_shown_ */
    class C14157 implements OnClickListener {
        final /* synthetic */ VerticalAttachmentView f17267a;

        C14157(VerticalAttachmentView verticalAttachmentView) {
            this.f17267a = verticalAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1863661881);
            if (this.f17267a.ar.isPresent()) {
                TaggingController taggingController = (TaggingController) this.f17267a.ar.get();
                PointF pointF = new PointF((float) this.f17267a.ak.x, (float) this.f17267a.ak.y);
                Preconditions.checkNotNull(pointF);
                if (taggingController.f17159d.a(pointF)) {
                    Logger.a(2, EntryType.UI_INPUT_END, -886595011, a);
                    return;
                }
            }
            this.f17267a.ad.m21136a(this.f17267a.as);
            LogUtils.a(-1656848348, a);
        }
    }

    /* compiled from: comments_shown_ */
    public class C14168 {
        public final /* synthetic */ VerticalAttachmentView f17268a;

        C14168(VerticalAttachmentView verticalAttachmentView) {
            this.f17268a = verticalAttachmentView;
        }
    }

    /* compiled from: comments_shown_ */
    class C14179 implements OnClickListener {
        final /* synthetic */ VerticalAttachmentView f17269a;

        C14179(VerticalAttachmentView verticalAttachmentView) {
            this.f17269a = verticalAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 655871356);
            this.f17269a.ad.m21139b(this.f17269a.as);
            ((InputMethodManager) this.f17269a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f17269a.getWindowToken(), 0);
            ((CreativeEditingAnalyticsLogger) this.f17269a.f17302g.get()).m11462a(this.f17269a.am, Events.ATTACHMENT_REMOVED);
            Logger.a(2, EntryType.UI_INPUT_END, 1484599440, a);
        }
    }

    /* compiled from: comments_shown_ */
    class CaptionWatcher implements TextWatcher, MentionChangeListener {
        final /* synthetic */ VerticalAttachmentView f17270a;

        public CaptionWatcher(VerticalAttachmentView verticalAttachmentView) {
            this.f17270a = verticalAttachmentView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int i = 0;
            m21183b();
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) editable.getSpans(0, editable.length(), MetricAffectingSpan.class);
            while (i < characterStyleArr.length) {
                editable.removeSpan(characterStyleArr[i]);
                i++;
            }
        }

        public final void m21184a() {
            m21183b();
        }

        private void m21183b() {
            AttachmentEventsListener attachmentEventsListener = this.f17270a.ad;
            ComposerAttachment composerAttachment = this.f17270a.as;
            GraphQLTextWithEntities a = GraphQLHelper.a(this.f17270a.f17295W.getText().toString(), MentionsUtils.b(this.f17270a.f17295W.getText()), null, null);
            ComposerAttachment.Builder a2 = ComposerAttachment.Builder.a(composerAttachment);
            a2.d = a;
            a2 = a2;
            a2.e = composerAttachment.e();
            ComposerAttachment a3 = a2.a();
            AttachmentsViewEventListener attachmentsViewEventListener = attachmentEventsListener.f17177a.f17183B;
            int indexOf = attachmentEventsListener.f17177a.f17208a.indexOf(composerAttachment);
            ComposerEventOriginator composerEventOriginator = UnderwoodController.f17181d;
            attachmentsViewEventListener.m21063a(indexOf, a3, false, false);
        }
    }

    /* compiled from: comments_shown_ */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C14181();
        @Nullable
        public final EditGalleryLaunchConfiguration f17271a;
        @Nullable
        public final VideoEditGalleryLaunchConfiguration f17272b;

        /* compiled from: comments_shown_ */
        final class C14181 implements Creator<SavedState> {
            C14181() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable, @Nullable EditGalleryLaunchConfiguration editGalleryLaunchConfiguration, @Nullable VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration) {
            super(parcelable);
            this.f17271a = editGalleryLaunchConfiguration;
            this.f17272b = videoEditGalleryLaunchConfiguration;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f17271a = (EditGalleryLaunchConfiguration) parcel.readParcelable(EditGalleryLaunchConfiguration.class.getClassLoader());
            this.f17272b = (VideoEditGalleryLaunchConfiguration) parcel.readParcelable(VideoEditGalleryLaunchConfiguration.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f17271a, i);
            parcel.writeParcelable(this.f17272b, i);
        }
    }

    private static <T extends View> void m21196a(Class<T> cls, T t) {
        m21197a((Object) t, t.getContext());
    }

    private static void m21197a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((VerticalAttachmentView) obj).m21194a((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), UnderwoodBitmapWidthHelper.a(injectorLike), (TaggingControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TaggingControllerProvider.class), PhotoSequences.a(injectorLike), (CreativeEditingSwipeableControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class), IdBasedSingletonScopeProvider.a(injectorLike, 9276), ImagePipelineMethodAutoProvider.a(injectorLike), ComposerStickersCapability.m20734a(injectorLike), ComposerTextEditCapability.m20737a(injectorLike), PhotoOverlayController.m11525a(injectorLike), FaceBoxStore.a(injectorLike), IdBasedLazy.a(injectorLike, 9300), IdBasedLazy.a(injectorLike, 9299), IdBasedProvider.a(injectorLike, 4250), IdBasedProvider.a(injectorLike, 4249), IdBasedProvider.a(injectorLike, 4248), ProductMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 9277), SwipeableParamsHelper.m11708a(injectorLike), SwipeableDraweeControllerGeneratorImpl.m11806a(injectorLike), (SwipeableFrameNuxControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SwipeableFrameNuxControllerProvider.class), (SwipeableFilterNuxControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SwipeableFilterNuxControllerProvider.class), MediaItemFactory.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TaggingProfiles.a(injectorLike), VideoCreativeEditingLogger.m19546a(injectorLike), VideoEditGalleryPerformanceLogger.m19480a(injectorLike), FramesAggregator.a(injectorLike), FrameAssetsLoader.m11662a(injectorLike), FramePrefsManager.m11675a(injectorLike), (SwipeableParamsListBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SwipeableParamsListBuilderProvider.class), UnderwoodVideoTranscodingUtil.m21169a(injectorLike));
    }

    public VerticalAttachmentView(Context context, FragmentManager fragmentManager, AttachmentsEventListener attachmentsEventListener, EventListener eventListener, ComposerAttachmentViewUtility composerAttachmentViewUtility, TasksManager<Integer> tasksManager, int i, int i2, String str, boolean z, boolean z2) {
        super(context);
        m21196a(VerticalAttachmentView.class, (View) this);
        setWillNotDraw(false);
        this.ad = attachmentsEventListener;
        this.ae = eventListener;
        this.ab = fragmentManager;
        this.af = composerAttachmentViewUtility;
        this.ag = tasksManager;
        this.ah = i;
        this.ak = new Point();
        this.aj = new CaptionWatcher(this);
        this.ai = SizeUtil.a(context, (float) this.f17298c.a());
        this.an = z;
        this.ao = z2;
        setContentView(2130907633);
        this.f17291S = (FrameLayout) findViewById(2131568246);
        this.f17292T = (ImageView) findViewById(2131560526);
        this.f17293U = new LazyView((ViewStub) findViewById(2131567238));
        this.f17295W = (MentionsAutoCompleteTextView) findViewById(2131568254);
        this.aa = (ViewStub) findViewById(2131568252);
        this.f17294V = (ViewStub) findViewById(2131568250);
        this.ac = (CreativeEditingPhotoOverlayView) findViewById(2131568249);
        this.ac.setVisibility(4);
        this.ap.add(new C14168(this));
        this.f17292T.setOnClickListener(new C14179(this));
        boolean z3 = !this.an || (this.ao && this.f17320y.a(ExperimentsForComposerAbTestModule.t, false));
        this.f17292T.setVisibility(z3 ? 0 : 8);
        this.al = i2;
        this.am = str;
        this.f17283H = false;
        this.aA = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public final void m21209a(@Nullable ComposerAttachment composerAttachment, @Nullable TagsChangedListener tagsChangedListener, @Nullable DataProvider dataProvider, boolean z, boolean z2, ScrollingAwareScrollView scrollingAwareScrollView) {
        this.as = composerAttachment;
        this.f17283H = z2;
        this.aH = dataProvider;
        this.aI = scrollingAwareScrollView;
        if (composerAttachment == null) {
            this.ag.c(Integer.valueOf(this.ah));
            if (this.aq.isPresent()) {
                ((CreativeEditingSwipeableController) this.aq.get()).m11785f();
            }
            this.at = 0.0f;
            this.as = null;
            this.aw = ImageFormat.UNKNOWN;
            this.aI = null;
            if (this.aD) {
                ((CreativeEditingSwipeableController) this.aq.get()).m11788j();
            }
            this.f17306k.m11532c();
            this.aQ = false;
        } else if (this.as.b() == null) {
            BLog.c(f17275K, "Media item is null");
        } else {
            this.aO = (CreativeEditingLogger) this.f17314s.get();
            this.aO.m11480a(this.am, composerAttachment.b().b().a());
            this.av = this.as.b().m() == MediaType.VIDEO;
            if (this.av && this.as.f() != null && this.as.f().d() != null) {
                this.at = this.af.m21072a(Uri.parse(this.as.f().d()), MediaType.PHOTO);
            } else if (this.as.e() == null || this.as.e().o() == null) {
                this.at = this.af.m21073a(composerAttachment.b());
            } else {
                this.at = this.af.m21072a(this.as.e().o(), MediaType.PHOTO);
            }
            this.ax = Math.round(((float) this.ai) / this.at);
            Preconditions.checkState(composerAttachment.a());
            setScale(1.0f);
            if (this.aw == ImageFormat.UNKNOWN) {
                this.aw = ImageFormatChecker.a(this.as.b().f().getPath());
            }
            m21195a((62) tagsChangedListener, z);
            m21201r();
            m21202t();
            this.f17295W.removeTextChangedListener(this.aj);
            this.f17295W.setMentionChangeListener(null);
            CharSequence a = MentionsSpannableStringBuilder.a(this.as.d(), getResources(), this.f17321z);
            MentionsAutoCompleteTextView mentionsAutoCompleteTextView = this.f17295W;
            if (StringUtil.a(a)) {
                a = "";
            }
            mentionsAutoCompleteTextView.setText(a);
            this.f17295W.addTextChangedListener(this.aj);
            this.f17295W.setMentionChangeListener(this.aj);
            Object obj = (!this.av || MediaItem.a.equals(this.as.b().i())) ? null : 1;
            if (obj != null) {
                this.f17293U.a().setVisibility(0);
            } else {
                this.f17293U.c();
            }
            m21199p();
            m21211e();
            if (this.av) {
                m21205w();
            } else {
                m21208a();
            }
            if (composerAttachment.e() != null) {
                RectF d = ((CreativeEditingSwipeableController) this.aq.get()).m11784d();
                this.f17306k.m11529a(m21186C(this), (int) d.width(), (int) d.height(), composerAttachment.b().g(), this.ac, true, OverlayType.STICKERS, OverlayType.TEXTS, OverlayType.DOODLE);
                this.ac.setOverlayViewEventListener(this.f17306k);
            }
        }
    }

    protected final void m21208a() {
        if (((ProvidesIsComposerDrawn) this.aH).B() && !this.aE) {
            m21206x();
            m21211e();
            this.aE = true;
        }
    }

    public final void m21210b() {
        if (((Boolean) this.f17311p.get()).booleanValue() || ((Boolean) this.f17312q.get()).booleanValue() || this.aM.isEmpty() || ((Boolean) this.f17310o.get()).booleanValue() || MediaItemFactory.a(this.as.c())) {
            CreativeEditingData C = m21186C(this);
            if ((C.m() && !Filter.AE08bit.name().equals(C.a())) || C.n() || C.c() != null || !C.h().isEmpty()) {
                Uri o;
                CreativeEditingImageHelper creativeEditingImageHelper = (CreativeEditingImageHelper) this.f17309n.get();
                if (C.o() != null) {
                    o = C.o();
                } else {
                    o = this.as.c();
                }
                ListenableFuture a = creativeEditingImageHelper.a(0.5f, C, o, true);
                ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.show();
                progressDialog.setContentView(new ProgressBar(getContext()));
                try {
                    m21193a((Uri) FutureDetour.a(a, 1662032744), true, false);
                } catch (Throwable e) {
                    BLog.b(f17275K, "interrupted", e);
                } catch (Throwable e2) {
                    BLog.b(f17275K, "interrupted", e2);
                } finally {
                    progressDialog.dismiss();
                }
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), (EditGalleryLaunchConfiguration) this.aK.orNull(), (VideoEditGalleryLaunchConfiguration) this.aL.orNull());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m21211e();
            this.aK = Optional.fromNullable(savedState.f17271a);
            if (this.aK.isPresent()) {
                this.ay = Optional.of(new EditGalleryFragmentManager(this.ab));
                ((EditGalleryFragmentManager) this.ay.get()).m12202a(this.f17284L);
            }
            this.aL = Optional.fromNullable(savedState.f17272b);
            if (this.aL.isPresent()) {
                this.az = Optional.of(new VideoEditGalleryFragmentManager(this.ab));
                ((VideoEditGalleryFragmentManager) this.az.get()).m19479a(this.f17285M);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    protected final void m21211e() {
        SwipeableFilterNuxController swipeableFilterNuxController = null;
        if (this.aD) {
            m21198o();
            return;
        }
        String a;
        ImmutableList j;
        if (this.as.e() != null) {
            a = this.as.e().a();
        } else {
            a = Filter.PassThrough.name();
        }
        ViewStub viewStub = (ViewStub) findViewById(2131568247);
        if (!(this.aq.isPresent() || this.as.b() == null)) {
            this.aq = Optional.of(this.f17301f.a(this.ae, this.f17316u, getImageUri(), this.as.b().d().toString()));
        }
        CreativeEditingSwipeableLayout creativeEditingSwipeableLayout = (CreativeEditingSwipeableLayout) findViewById(2131567760);
        if (creativeEditingSwipeableLayout == null) {
            creativeEditingSwipeableLayout = (CreativeEditingSwipeableLayout) viewStub.inflate();
        }
        ((CreativeEditingSwipeableController) this.aq.get()).m11774a(creativeEditingSwipeableLayout, this.ai, this.ax, m21200q());
        ((CreativeEditingSwipeableController) this.aq.get()).m11773a(this.f17288P);
        this.f17316u.m11813a(this.f17286N);
        m21198o();
        if (this.as.e() != null) {
            j = this.as.e().j();
        } else {
            j = RegularImmutableList.a;
        }
        ((CreativeEditingSwipeableController) this.aq.get()).m11773a(this.f17288P);
        this.f17316u.m11813a(this.f17286N);
        Object obj = (this.as == null || !MediaItemFactory.a(this.as.c())) ? null : ((((Boolean) this.f17311p.get()).booleanValue() || ((Boolean) this.f17312q.get()).booleanValue()) && (this.as.b() instanceof PhotoItem) && this.aw != ImageFormat.GIF) ? 1 : null;
        if (obj != null) {
            this.aM = this.f17281F.m11726a(this.ai, this.ax).m11723b(j).m11722a(this.f17315t.m11716a()).m11724b();
            ((CreativeEditingSwipeableController) this.aq.get()).m11777a(this.aM, a);
            this.aN = false;
            if (this.al == 0 && this.aM.size() > 1) {
                SwipeableFilterNuxControllerProvider swipeableFilterNuxControllerProvider = this.f17318w;
                swipeableFilterNuxController = new SwipeableFilterNuxController(this.aM, IdBasedLazy.a(swipeableFilterNuxControllerProvider, 9292), TipSeenTracker.b(swipeableFilterNuxControllerProvider));
            }
            if (swipeableFilterNuxController != null) {
                ((CreativeEditingSwipeableController) this.aq.get()).m11775a(ImmutableList.of(swipeableFilterNuxController));
            }
            Futures.a(this.f17278C.a(), new FutureCallback<ImmutableList<FramePack>>(this) {
                final /* synthetic */ VerticalAttachmentView f17251d;
                public SwipeableFrameNuxController f17252e;

                public void onSuccess(@Nullable Object obj) {
                    ImmutableList immutableList = (ImmutableList) obj;
                    if (immutableList != null && !immutableList.isEmpty() && ((CreativeEditingSwipeableController) this.f17251d.aq.get()).m11789k()) {
                        if (!(swipeableFilterNuxController == null || !j.isEmpty() || this.f17251d.aN)) {
                            InjectorLike injectorLike = this.f17251d.f17317v;
                            this.f17252e = new SwipeableFrameNuxController((FramePackModel) immutableList.get(0), IdBasedLazy.a(injectorLike, 9293), FramePrefsManager.m11676b(injectorLike));
                            ((CreativeEditingSwipeableController) this.f17251d.aq.get()).m11775a(ImmutableList.of(swipeableFilterNuxController, this.f17252e));
                        }
                        final ImmutableList immutableList2 = this.f17251d.aM;
                        final List arrayList = new ArrayList();
                        final List arrayList2 = new ArrayList();
                        int size = immutableList.size();
                        for (int i = 0; i < size; i++) {
                            FramePackModel framePackModel = (FramePackModel) immutableList.get(i);
                            final List arrayList3 = new ArrayList();
                            arrayList.add(arrayList3);
                            arrayList2.add(framePackModel.bJ_());
                            this.f17251d.f17279D.m11672a(FrameShuffler.m11680a(ImmutableList.copyOf(framePackModel.c())), new Listener(this) {
                                final /* synthetic */ AnonymousClass10 f17247e;

                                public final void mo509a(FrameModel frameModel) {
                                    if (((CreativeEditingSwipeableController) this.f17247e.f17251d.aq.get()).m11789k()) {
                                        arrayList3.add(frameModel);
                                        SwipeableParamsListBuilder a = this.f17247e.f17251d.f17281F.m11726a(this.f17247e.f17251d.ai, this.f17247e.f17251d.ax);
                                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                                            for (FrameModel a2 : (List) arrayList.get(size)) {
                                                a.m11721a(a2, (String) arrayList2.get(size));
                                            }
                                        }
                                        this.f17247e.f17251d.aM = a.m11722a(immutableList2).m11724b();
                                        ((CreativeEditingSwipeableController) this.f17247e.f17251d.aq.get()).m11777a(this.f17247e.f17251d.aM, !this.f17247e.f17251d.aN ? a : null);
                                        this.f17247e.f17251d.aK = VerticalAttachmentView.m21185A(this.f17247e.f17251d);
                                        if (this.f17247e.f17252e != null) {
                                            SwipeableFrameNuxController swipeableFrameNuxController = this.f17247e.f17252e;
                                            ImmutableList immutableList = this.f17247e.f17251d.aM;
                                            Preconditions.checkNotNull(immutableList);
                                            if (swipeableFrameNuxController.f9955e != null && !swipeableFrameNuxController.f9956f) {
                                                int size2 = immutableList.size();
                                                for (int i = 0; i < size2; i++) {
                                                    if (swipeableFrameNuxController.f9955e.contains(((SwipeableParams) immutableList.get(i)).b)) {
                                                        swipeableFrameNuxController.f9956f = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b(VerticalAttachmentView.f17275K, "Failed to load swipable frames");
                }
            }, this.f17297b);
        } else {
            ((CreativeEditingSwipeableController) this.aq.get()).m11777a(ImmutableList.of(new SwipeableParams(RegularImmutableList.a, Filter.PassThrough.name(), SwipeableItemType.FILTER, this.f17315t.m11718a(Filter.PassThrough.name()))), null);
        }
        if (m21204v()) {
            this.aK = m21185A(this);
        }
        this.aD = true;
        m21198o();
    }

    private void m21198o() {
        if (this.aD && (this.as.b() instanceof PhotoItem) && this.ar.isPresent()) {
            RectF rectF;
            RectF rectF2 = f17274J;
            if (this.as.e() == null || this.as.e().c() == null) {
                rectF = rectF2;
            } else {
                rectF = this.as.e().c();
            }
            List b = ((TaggingController) this.ar.get()).m21130b(rectF);
            if (b != null) {
                ((CreativeEditingSwipeableController) this.aq.get()).m11779a((RectF[]) b.toArray(new RectF[0]));
            }
        }
    }

    private Uri getImageUri() {
        Uri c = (this.as.e() == null || this.as.e().o() == null) ? this.as.c() : Uri.fromFile(new File(this.as.e().o().getPath()));
        if (this.as.b() instanceof VideoItem) {
            if (this.as.f() == null || this.as.f().d() == null) {
                VideoItem videoItem = (VideoItem) this.as.b();
                if (videoItem.s() != null) {
                    c = videoItem.s();
                }
            } else {
                c = Uri.parse(this.as.f().d());
            }
        }
        if (this.as.e() == null || this.as.e().o() == null) {
            return c;
        }
        File file = new File(this.as.e().o().getPath());
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        return c;
    }

    private void m21199p() {
        ImageRequestBuilder a = ImageRequestBuilder.a(getImageUri());
        a.d = new ResizeOptions(this.ai, this.ax);
        this.f17303h.e(a.m(), f17273I);
    }

    public final void m21212f() {
        boolean q = m21200q();
        for (C14168 c14168 : this.ap) {
            if (c14168.f17268a.aq.isPresent()) {
                ((CreativeEditingSwipeableController) c14168.f17268a.aq.get()).m11782b(q);
            }
        }
    }

    private boolean m21200q() {
        if (this.f17291S == null || this.f17291S.getMeasuredHeight() == 0 || this.f17291S.getMeasuredWidth() == 0) {
            return false;
        }
        int[] iArr = new int[]{this.f17291S.getLeft(), this.f17291S.getTop()};
        this.f17291S.getLocationOnScreen(iArr);
        if (iArr[1] + this.f17291S.getMeasuredHeight() < 0 || iArr[1] > this.aA) {
            return false;
        }
        return true;
    }

    private void m21201r() {
        m21211e();
        this.f17300e.a(this.am, this.as.b().c(), this.al, this.ai, this.ax, this.av);
    }

    public void setFaceBoxesAndTags(boolean z) {
        if (this.ar.isPresent() && this.as != null) {
            this.aF = z;
            PhotoItem photoItem = (PhotoItem) this.as.b();
            if (this.f17307l.c((TaggablePhoto) photoItem.f)) {
                RectF rectF = f17274J;
                if (!(this.as.e() == null || this.as.e().c() == null)) {
                    rectF = this.as.e().c();
                }
                if (!(rectF == f17274J && photoItem.g() == 0)) {
                    TaggingController taggingController = (TaggingController) this.ar.get();
                    taggingController.f17162g.m12945a(rectF, taggingController.f17161f.m21043a(taggingController.f17169n), taggingController.f17169n.g());
                    taggingController.f17163h.a(rectF, taggingController.f17169n.g());
                }
                rectF = new RectF(0.0f, 0.0f, (float) this.ai, (float) this.ax);
                if (!this.aq.isPresent()) {
                    this.f17296a.b(f17275K, "SwipableImageController not bound");
                    m21211e();
                }
                ((TaggingController) this.ar.get()).m21129a(this.aF, ((CreativeEditingSwipeableController) this.aq.get()).m11784d(), rectF);
                m21211e();
            }
        }
    }

    private void m21195a(62 62, boolean z) {
        if ((this.as.b() instanceof PhotoItem) && (((PhotoItem) this.as.b()).f instanceof TaggablePhoto)) {
            this.ar = Optional.of(this.f17299d.m21131a(this.f17291S, (FaceBoxesView) findViewById(2131568248), new Object(this) {
                public final /* synthetic */ VerticalAttachmentView f17258a;

                {
                    this.f17258a = r1;
                }
            }, 62));
            ((TaggingController) this.ar.get()).m21128a((PhotoItem) this.as.b());
            this.aF = z;
        }
    }

    private void m21202t() {
        ((CreativeEditingSwipeableController) this.aq.get()).m11772a(this.f17290R);
        ((CreativeEditingSwipeableController) this.aq.get()).f9809L.f9910h = this.f17289Q;
        CreativeEditingSwipeableController creativeEditingSwipeableController = (CreativeEditingSwipeableController) this.aq.get();
        creativeEditingSwipeableController.f9808K = this.aI;
        creativeEditingSwipeableController.f9808K.a = true;
        creativeEditingSwipeableController.f9809L.f9921s = creativeEditingSwipeableController.f9808K;
    }

    private boolean m21203u() {
        if ((m21188F() || m21189G(this) || m21190H()) && MediaItemFactory.a(this.as.c()) && this.as != null) {
            return true;
        }
        return false;
    }

    public static OnClickListener m21192a(VerticalAttachmentView verticalAttachmentView, final ComposerEntryPoint composerEntryPoint) {
        return new OnClickListener(verticalAttachmentView) {
            final /* synthetic */ VerticalAttachmentView f17254b;

            public void onClick(View view) {
                VideoCreativeEditingData a;
                int a2 = Logger.a(2, EntryType.UI_INPUT_START, -1547629137);
                VideoCreativeEditingData f = this.f17254b.as.f();
                if (f == null) {
                    a = new VideoCreativeEditingData.Builder().a();
                } else {
                    a = f;
                }
                VideoEditGalleryLaunchConfiguration.Builder builder = new VideoEditGalleryLaunchConfiguration.Builder((VideoEditGalleryLaunchConfiguration) this.f17254b.aL.get());
                builder.f6191c = a;
                VideoEditGalleryLaunchConfiguration a3 = builder.m8068a();
                this.f17254b.f17276A.m19549a(this.f17254b.as.c().toString(), composerEntryPoint, this.f17254b.am);
                this.f17254b.f17277B.f15445a.b(9175041);
                ((VideoEditGalleryFragmentManager) this.f17254b.az.get()).m19478a(a3, this.f17254b.as.c(), this.f17254b.f17285M, VideoEditingGalleryEntryPoint.COMPOSER, AnimationParam.m12362a(this.f17254b.f17291S));
                Logger.a(2, EntryType.UI_INPUT_END, -411608378, a2);
            }
        };
    }

    private boolean m21204v() {
        if (!m21203u()) {
            return false;
        }
        if (((Boolean) this.f17310o.get()).booleanValue() && this.ay.isPresent() && this.aK.isPresent() && MediaItemFactory.a(this.as.c()) && !((ProvidesConfiguration) this.aH).o().isEdit()) {
            return true;
        }
        return false;
    }

    private void m21205w() {
        if (this.aP == null) {
            this.aP = new Runnable(this) {
                final /* synthetic */ VerticalAttachmentView f17255a;

                {
                    this.f17255a = r1;
                }

                public void run() {
                    this.f17255a.aQ = true;
                    ((CreativeEditingSwipeableController) this.f17255a.aq.get()).m11772a(VerticalAttachmentView.m21192a(this.f17255a, ComposerEntryPoint.TAP_VIDEO));
                    VerticalAttachmentView verticalAttachmentView = this.f17255a;
                    VerticalAttachmentView verticalAttachmentView2 = this.f17255a;
                    VideoEditGalleryLaunchConfiguration.Builder a = new VideoEditGalleryLaunchConfiguration.Builder().m8067a(VideoEditFeature.TRIM);
                    a.f6190b = verticalAttachmentView2.am;
                    a = a;
                    a.f6192d = true;
                    a = a;
                    a.f6193e = true;
                    verticalAttachmentView.aL = Optional.of(a.m8068a());
                    if (this.f17255a.aL.isPresent()) {
                        if (this.f17255a.aC == null) {
                            this.f17255a.aC = (LinearLayout) this.f17255a.f17294V.inflate();
                        }
                        this.f17255a.az = Optional.of(new VideoEditGalleryFragmentManager(this.f17255a.ab));
                        if (this.f17255a.az.isPresent()) {
                            verticalAttachmentView = this.f17255a;
                            if (verticalAttachmentView.aC == null) {
                                verticalAttachmentView.f17296a.a(VerticalAttachmentView.f17275K, "Video Editing Icon not initialized");
                            } else {
                                verticalAttachmentView.aC.setVisibility(0);
                                verticalAttachmentView.aC.setOnClickListener(VerticalAttachmentView.m21192a(verticalAttachmentView, ComposerEntryPoint.CLICK_EDIT_BUTTON));
                            }
                        }
                    }
                }
            };
        }
        this.f17282G.m21171a(this.as, this.aP);
    }

    private void m21206x() {
        if (m21203u()) {
            if (((Boolean) this.f17310o.get()).booleanValue()) {
                this.aK = m21185A(this);
                if (this.aK.isPresent()) {
                    this.ay = Optional.of(new EditGalleryFragmentManager(this.ab));
                }
            }
            if (this.aB == null) {
                this.aB = (LinearLayout) this.aa.inflate();
                if (m21204v()) {
                    ((ViewStub) this.aB.findViewById(2131565898)).inflate();
                    m21207y();
                }
            }
        }
    }

    private void m21207y() {
        if (this.aB == null) {
            this.f17296a.a(f17275K, "Editing Layout not initialized");
            return;
        }
        View findViewById = this.aB.findViewById(2131561124);
        if (findViewById == null) {
            this.f17296a.a(f17275K, "UG Launcher holder view not available");
            return;
        }
        this.aG = (FbButton) findViewById.findViewById(2131561125);
        if (m21189G(this)) {
            this.aG.setBackgroundResource(2130838476);
        } else {
            this.aG.setBackgroundResource(2130838474);
        }
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VerticalAttachmentView f17256a;

            {
                this.f17256a = r1;
            }

            public void onClick(View view) {
                RectF rectF;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1274467660);
                if (this.f17256a.aG.getBackground() instanceof AnimationDrawable) {
                    ((AnimationDrawable) this.f17256a.aG.getBackground()).stop();
                    if (VerticalAttachmentView.m21189G(this.f17256a)) {
                        this.f17256a.aG.setBackgroundResource(2130838476);
                    } else {
                        this.f17256a.aG.setBackgroundResource(2130838474);
                    }
                }
                int a2 = (int) (((float) this.f17256a.ai) / this.f17256a.af.m21073a(this.f17256a.as.b()));
                this.f17256a.ae.mo490a(this.f17256a.as.b().d().toString());
                RectF rectF2 = VerticalAttachmentView.f17274J;
                if (this.f17256a.as.e() == null || this.f17256a.as.e().c() == null) {
                    rectF = rectF2;
                } else {
                    rectF = this.f17256a.as.e().c();
                }
                Builder builder = new Builder((EditGalleryLaunchConfiguration) this.f17256a.aK.get());
                builder.j = VerticalAttachmentView.m21186C(this.f17256a);
                ((EditGalleryFragmentManager) this.f17256a.ay.get()).m12201a(this.f17256a.as.c(), this.f17256a.ai, a2, builder.a(), this.f17256a.f17284L, ((TaggingController) this.f17256a.ar.get()).m21130b(rectF), AnimationParam.m12362a(this.f17256a.f17291S));
                LogUtils.a(-1969926812, a);
            }
        });
        if (this.al == 0) {
            new ButtonAnimator(getDrawablesForAnimation(), this.aG).m2081a();
        }
    }

    public static Optional m21185A(VerticalAttachmentView verticalAttachmentView) {
        EditFeature editFeature;
        EditFeature editFeature2 = null;
        boolean F = verticalAttachmentView.m21188F();
        boolean G = m21189G(verticalAttachmentView);
        boolean H = verticalAttachmentView.m21190H();
        boolean I = verticalAttachmentView.m21191I();
        if (verticalAttachmentView.m21187E()) {
            editFeature = EditFeature.FILTER;
        } else if (G) {
            editFeature = EditFeature.STICKER;
        } else if (F) {
            editFeature = EditFeature.CROP;
        } else if (H) {
            editFeature = EditFeature.TEXT;
        } else if (!I) {
            return Absent.INSTANCE;
        } else {
            editFeature = EditFeature.DOODLE;
        }
        Builder a = new Builder().a(editFeature);
        if (F) {
            editFeature = null;
        } else {
            editFeature = EditFeature.CROP;
        }
        Builder b = a.b(editFeature);
        if (G) {
            editFeature = null;
        } else {
            editFeature = EditFeature.STICKER;
        }
        b = b.b(editFeature);
        if (H) {
            editFeature = null;
        } else {
            editFeature = EditFeature.TEXT;
        }
        b = b.b(editFeature);
        if (verticalAttachmentView.m21191I()) {
            editFeature = null;
        } else {
            editFeature = EditFeature.DOODLE;
        }
        Builder b2 = b.b(editFeature);
        if (!verticalAttachmentView.m21187E()) {
            editFeature2 = EditFeature.FILTER;
        }
        b2 = b2.b(editFeature2).b(verticalAttachmentView.am);
        b2.l = verticalAttachmentView.aM;
        return Optional.of(b2.a());
    }

    private ImmutableList<Drawable> getDrawablesForAnimation() {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (m21188F()) {
            builder.c(getResources().getDrawable(2130838475));
        }
        if (m21190H()) {
            builder.c(getResources().getDrawable(2130838477));
        }
        if (m21189G(this)) {
            builder.c(getResources().getDrawable(2130838476));
        } else {
            builder.c(getResources().getDrawable(2130838474));
        }
        return builder.b();
    }

    public static CreativeEditingData m21186C(VerticalAttachmentView verticalAttachmentView) {
        String name = Filter.PassThrough.name();
        if (verticalAttachmentView.aq.isPresent()) {
            name = ((CreativeEditingSwipeableController) verticalAttachmentView.aq.get()).m11786g();
        } else if (verticalAttachmentView.as.e() != null) {
            name = verticalAttachmentView.as.e().a();
        }
        CreativeEditingData.Builder builder = new CreativeEditingData.Builder();
        if (verticalAttachmentView.as.e() != null) {
            builder = new CreativeEditingData.Builder(verticalAttachmentView.as.e());
        }
        builder.a = name;
        if (verticalAttachmentView.aq.isPresent()) {
            ImmutableList immutableList;
            ImmutableList<PhotoOverlayItem> i = ((CreativeEditingSwipeableController) verticalAttachmentView.aq.get()).m11787i();
            if (i == null) {
                immutableList = null;
            } else {
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                for (PhotoOverlayItem photoOverlayItem : i) {
                    if (photoOverlayItem instanceof StickerParams) {
                        builder2.c((StickerParams) photoOverlayItem);
                    }
                }
                immutableList = builder2.b();
            }
            builder.j = immutableList;
        }
        return builder.a();
    }

    public final void m21213j() {
        UnderwoodAttachmentUtils.m21133a(this.aC == null ? this.aB : this.aC, this.f17291S, this.f17292T);
    }

    public void setScale(float f) {
        this.au = f;
        setScaleX(f);
        setScaleY(f);
        setAlpha(f);
    }

    private boolean m21187E() {
        return this.aM.size() > 1;
    }

    private boolean m21188F() {
        if (this.as == null || this.as.c() == null || !(this.as.b() instanceof PhotoItem)) {
            return false;
        }
        return this.aw == ImageFormat.JPEG || (this.aw == ImageFormat.PNG && this.f17320y.a(ExperimentsForCreativeEditingAbtestModule.h, false));
    }

    public static boolean m21189G(VerticalAttachmentView verticalAttachmentView) {
        if (!(verticalAttachmentView.f17313r == Product.PAA || verticalAttachmentView.as == null || verticalAttachmentView.as.c() == null || !(verticalAttachmentView.as.b() instanceof PhotoItem) || verticalAttachmentView.aw == ImageFormat.GIF || verticalAttachmentView.aH == null || ((ProvidesTargetData) verticalAttachmentView.aH).s() == null)) {
            Object obj;
            ComposerStickersCapability composerStickersCapability = verticalAttachmentView.f17304i;
            TargetType targetType = ((ProvidesTargetData) verticalAttachmentView.aH).s().targetType;
            Preconditions.checkNotNull(targetType);
            if (targetType == TargetType.PAGE || composerStickersCapability.f16702a == Product.PAA) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private boolean m21190H() {
        return (this.as == null || this.as.c() == null || !(this.as.b() instanceof PhotoItem) || this.aw == ImageFormat.GIF || this.aH == null || ((ProvidesTargetData) this.aH).s() == null || !this.f17305j.m20738a(((ProvidesTargetData) this.aH).s().targetType)) ? false : true;
    }

    private boolean m21191I() {
        return this.f17320y.a(ExperimentsForCreativeEditingAbtestModule.a, false) && this.as != null && this.as.c() != null && (this.as.b() instanceof PhotoItem) && this.aw == ImageFormat.JPEG && this.aH != null && ((ProvidesTargetData) this.aH).s() != null && this.f17305j.m20738a(((ProvidesTargetData) this.aH).s().targetType);
    }

    protected final void m21214l() {
        this.aJ = ((ProvidesTargetData) this.aH).s().targetType;
        if (m21204v()) {
            this.aK = m21185A(this);
            m21207y();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 126958985);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aQ || this.ar.isPresent()) {
            setPivotX((float) i);
            setPivotY(0.0f);
            if (i > 0 && i2 > 0) {
                GlobalOnLayoutHelper.c(this.f17291S, new Runnable(this) {
                    final /* synthetic */ VerticalAttachmentView f17257a;

                    {
                        this.f17257a = r1;
                    }

                    public void run() {
                        if (!this.f17257a.aQ) {
                            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f17257a.ai, (float) this.f17257a.ax);
                            RectF d = ((CreativeEditingSwipeableController) this.f17257a.aq.get()).m11784d();
                            TaggingController taggingController = (TaggingController) this.f17257a.ar.get();
                            Preconditions.checkNotNull(d);
                            taggingController.f17159d.a((int) rectF.width(), (int) rectF.height(), TaggingController.m21127b(d, rectF));
                            taggingController.f17157b.a();
                            if (this.f17257a.as.e() != null) {
                                Rect rect = new Rect();
                                d.round(rect);
                                PhotoOverlayController photoOverlayController = this.f17257a.f17306k;
                                photoOverlayController.f9599a.m11536a(rect, this.f17257a.as.b().g());
                                this.f17257a.ac.invalidate();
                            }
                        }
                        this.f17257a.m21213j();
                        this.f17257a.m21212f();
                    }
                });
            }
            LogUtils.g(-1840398996, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1172587425, a);
    }

    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.f17291S.getLayoutParams();
        int i3 = layoutParams.topMargin + layoutParams.bottomMargin;
        int size = MeasureSpec.getSize(i) - (layoutParams.leftMargin + layoutParams.rightMargin);
        int round = Math.round(((float) size) / this.at);
        layoutParams.width = size;
        layoutParams.height = round;
        ((LayoutParams) this.f17295W.getLayoutParams()).topMargin = layoutParams.height + i3;
        super.onMeasure(i, i2);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -471685836);
        this.ag.c(Integer.valueOf(this.ah));
        if (this.f17316u != null) {
            this.f17316u.m11815b(this.f17286N);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -404827598, a);
    }

    private void m21194a(FbErrorReporter fbErrorReporter, ExecutorService executorService, UnderwoodBitmapWidthHelper underwoodBitmapWidthHelper, TaggingControllerProvider taggingControllerProvider, PhotoSequences photoSequences, CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider, Provider<CreativeEditingAnalyticsLogger> provider, ImagePipeline imagePipeline, ComposerStickersCapability composerStickersCapability, ComposerTextEditCapability composerTextEditCapability, PhotoOverlayController photoOverlayController, FaceBoxStore faceBoxStore, Lazy<MediaRotationHelper> lazy, Lazy<CreativeEditingImageHelper> lazy2, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Product product, Provider<CreativeEditingLogger> provider5, SwipeableParamsHelper swipeableParamsHelper, SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl, SwipeableFrameNuxControllerProvider swipeableFrameNuxControllerProvider, SwipeableFilterNuxControllerProvider swipeableFilterNuxControllerProvider, MediaItemFactory mediaItemFactory, QeAccessor qeAccessor, TaggingProfiles taggingProfiles, VideoCreativeEditingLogger videoCreativeEditingLogger, VideoEditGalleryPerformanceLogger videoEditGalleryPerformanceLogger, FramesAggregator framesAggregator, FrameAssetsLoader frameAssetsLoader, FramePrefsManager framePrefsManager, SwipeableParamsListBuilderProvider swipeableParamsListBuilderProvider, UnderwoodVideoTranscodingUtil underwoodVideoTranscodingUtil) {
        this.f17296a = fbErrorReporter;
        this.f17297b = executorService;
        this.f17298c = underwoodBitmapWidthHelper;
        this.f17299d = taggingControllerProvider;
        this.f17300e = photoSequences;
        this.f17301f = creativeEditingSwipeableControllerProvider;
        this.f17302g = provider;
        this.f17303h = imagePipeline;
        this.f17304i = composerStickersCapability;
        this.f17305j = composerTextEditCapability;
        this.f17306k = photoOverlayController;
        this.f17307l = faceBoxStore;
        this.f17308m = lazy;
        this.f17309n = lazy2;
        this.f17310o = provider2;
        this.f17311p = provider3;
        this.f17312q = provider4;
        this.f17313r = product;
        this.f17314s = provider5;
        this.f17315t = swipeableParamsHelper;
        this.f17316u = swipeableDraweeControllerGeneratorImpl;
        this.f17317v = swipeableFrameNuxControllerProvider;
        this.f17318w = swipeableFilterNuxControllerProvider;
        this.f17319x = mediaItemFactory;
        this.f17320y = qeAccessor;
        this.f17321z = taggingProfiles;
        this.f17276A = videoCreativeEditingLogger;
        this.f17277B = videoEditGalleryPerformanceLogger;
        this.f17278C = framesAggregator;
        this.f17279D = frameAssetsLoader;
        this.f17280E = framePrefsManager;
        this.f17281F = swipeableParamsListBuilderProvider;
        this.f17282G = underwoodVideoTranscodingUtil;
    }

    private void m21193a(Uri uri, boolean z, boolean z2) {
        CreativeEditingData.Builder builder = new CreativeEditingData.Builder(m21186C(this));
        builder.d = uri;
        this.ad.m21137a(this.as, this.as.b(), builder.a(), z, z2);
    }

    public CreativeEditingData getCreativeEditingData() {
        return m21186C(this);
    }
}
