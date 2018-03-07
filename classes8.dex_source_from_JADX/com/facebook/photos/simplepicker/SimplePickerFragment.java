package com.facebook.photos.simplepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.friendsharing.souvenirs.manager.SouvenirManager;
import com.facebook.friendsharing.souvenirs.mediaitems.SouvenirsMediaItemsHelper;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.creativecam.CreativeCamResult;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.simplecamera.SimpleCameraCallback;
import com.facebook.ipc.simplepicker.SimplePickerConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.ipc.slideshow.SlideshowEditConfiguration;
import com.facebook.ipc.slideshow.SlideshowEditConfigurationSpec$Action;
import com.facebook.ipc.slideshow.SlideshowEditConfigurationSpec$Source;
import com.facebook.ipc.slideshow.SlideshowEditIntentCreator;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.base.media.MediaItemsOperator;
import com.facebook.photos.base.media.MediaItemsOperator.SelectMode;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.base.tagging.PrefilledTaggingActivator;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.stickers.ui.StickerEditActivity;
import com.facebook.photos.creativeediting.swipeable.common.FramesAggregator;
import com.facebook.photos.experiments.ExperimentsForPhotosExperimentsModule;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.photos.simplecamera.SimpleCamera;
import com.facebook.photos.simplecamera.SimpleCamera.4;
import com.facebook.photos.simplecamera.SimpleCamera.CameraType;
import com.facebook.photos.simplepicker.SimplePickerBackgroundTasksController.C03681;
import com.facebook.photos.simplepicker.SimplePickerBackgroundTasksController.C03692;
import com.facebook.photos.simplepicker.SimplePickerBackgroundTasksController.C03703;
import com.facebook.photos.simplepicker.SimplePickerBackgroundTasksController.C03714;
import com.facebook.photos.simplepicker.SimplePickerBackgroundTasksController.C03735;
import com.facebook.photos.simplepicker.abtest.ExperimentsForSimplePickerModule;
import com.facebook.photos.simplepicker.controller.PickerSelectionController;
import com.facebook.photos.simplepicker.controller.PickerSelectionControllerProvider;
import com.facebook.photos.simplepicker.controller.PickerSelectionUpdateUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerDataLoadUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerSlideshowEntrypointController;
import com.facebook.photos.simplepicker.controller.SimplePickerViewController;
import com.facebook.photos.simplepicker.controller.SimplePickerViewControllerAdapter;
import com.facebook.photos.simplepicker.controller.SlideshowErrorMessageController;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences.LaunchSequence;
import com.facebook.photos.simplepicker.nux.SimplePickerInterstitialControllers;
import com.facebook.photos.simplepicker.nux.SimplePickerNux;
import com.facebook.photos.simplepicker.nux.SimplePickerNuxManager;
import com.facebook.photos.simplepicker.nux.SimplePickerNuxManagerProvider;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.simplepicker.view.SlideshowEntrypointView.CollageSlideshowSwitchListener;
import com.facebook.photos.taggablegallery.ProductionVideoGalleryActivity;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants.Source;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.NavigationEventListener;
import com.facebook.photos.tagging.AutoTaggingHelper;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.sequencelogger.NoOpSequence;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: simple_search_loader_filter_value */
public abstract class SimplePickerFragment extends FbFragment {
    private static final String[] aA = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String ay = SimplePickerFragment.class.getSimpleName();
    private static final String[] az = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public SimplePickerViewController f2841a;
    public SimplePickerCallback aB;
    private boolean aC;
    public OnClickListener aD;
    public SimplePickerFlowLogger aE;
    private MediaItemsOperator aF;
    private AutoTaggingHelper aG;
    public CreativeCamLauncher aH;
    private AllCapsTransformationMethod aI;
    public SimplePickerSlideshowEntrypointController aJ;
    public SlideshowErrorMessageController aK;
    public Lazy<SecureContextHelper> aL;
    public Lazy<SimpleCamera> aM;
    private PickerSelectionControllerProvider aN;
    public Lazy<PickerSelectionUpdateUtil> aO;
    private SimplePickerBackgroundTasksControllerProvider aP;
    private Lazy<TasksManager> aQ;
    public TaggableLocalMediaUtil aR;
    private FbSharedPreferences aS;
    private Clock aT;
    private Lazy<SouvenirManager> aU;
    private ActivityRuntimePermissionsManager aV;
    public boolean aW = false;
    public String aX;
    private boolean aY = false;
    public ListeningExecutorService aZ;
    protected PickerLongPressProgressBar al;
    protected boolean am;
    protected SequenceLogger an;
    protected InteractionTTILogger ao;
    protected Sequence<LaunchSequence> ap;
    protected boolean aq;
    protected boolean ar;
    protected ImmutableList<SouvenirModel> as = null;
    public boolean at;
    @Nullable
    protected ComposerSlideshowData au;
    protected Map<MediaItem, Boolean> av;
    protected Cursor aw;
    protected final AnonymousClass20 ax = new Object(this) {
        final /* synthetic */ SimplePickerFragment f2898a;

        {
            this.f2898a = r1;
        }

        public final void m2967a(int i, SouvenirModel souvenirModel) {
            this.f2898a.bv.a(i, souvenirModel);
            ImmutableList a = ((SouvenirsMediaItemsHelper) this.f2898a.bA.get()).a(souvenirModel);
            Action action = this.f2898a.f2842b.b;
            switch (AnonymousClass21.f2901c[action.ordinal()]) {
                case 6:
                    SimplePickerFragment.m2895b(this.f2898a, a);
                    return;
                case 8:
                    SimplePickerFragment.m2891a(this.f2898a, a, true);
                    return;
                default:
                    throw new IllegalStateException("Invalid action for simplepicker with a souvenir: " + action.toString());
            }
        }

        public final void m2968b(int i, SouvenirModel souvenirModel) {
            this.f2898a.bv.b(i, souvenirModel);
        }
    };
    public SimplePickerLauncherConfiguration f2842b;
    public Lazy<SouvenirsMediaItemsHelper> bA;
    public String ba;
    private Boolean bb;
    public Toaster bc;
    private TitleBarButtonSpec bd;
    private TitleBarButtonSpec be;
    private TitleBarButtonSpec bf;
    private Fb4aTitleBar bg;
    private OnActionButtonClickListener bh;
    private OnActionButtonClickListener bi;
    private OnActionButtonClickListener bj;
    private OnActionButtonClickListener bk;
    public boolean bl;
    public Lazy<FbErrorReporter> bm;
    public SlideshowLogger bn;
    private SimplePickerNuxManagerProvider bo;
    private SimplePickerNuxManager bp;
    private QeAccessor bq;
    private ComposerLauncher br;
    private TagStore bs;
    private FaceBoxStore bt;
    private boolean bu;
    public SouvenirsLogger bv;
    @ForUiThread
    public ExecutorService bw;
    public FramesAggregator bx;
    public ImmutableList<FramePack> by;
    public MediaItemFactory bz;
    public PickerSelectionController f2843c;
    protected SimplePickerDataLoadUtil f2844d;
    public SimplePickerViewControllerAdapter f2845e;
    protected int f2846f;
    protected boolean f2847g = false;
    protected boolean f2848h = false;
    protected boolean f2849i;

    /* compiled from: simple_search_loader_filter_value */
    public interface CameraButtonDelegate {
        boolean mo133a();
    }

    /* compiled from: simple_search_loader_filter_value */
    public interface CursorUpdatedCallback {
        void mo134a(Cursor cursor);
    }

    /* compiled from: simple_search_loader_filter_value */
    class C03751 implements RuntimePermissionsListener {
        final /* synthetic */ SimplePickerFragment f2897a;

        C03751(SimplePickerFragment simplePickerFragment) {
            this.f2897a = simplePickerFragment;
        }

        public final void m2964a() {
        }

        public final void m2965a(String[] strArr, String[] strArr2) {
            this.f2897a.bc.b(new ToastBuilder(this.f2897a.getContext().getString(2131234426)));
        }

        public final void m2966b() {
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    /* synthetic */ class AnonymousClass21 {
        static final /* synthetic */ int[] f2899a = new int[SupportedMediaType.values().length];
        static final /* synthetic */ int[] f2900b = new int[MediaType.values().length];
        static final /* synthetic */ int[] f2901c = new int[Action.values().length];

        static {
            try {
                f2901c[Action.LAUNCH_PROFILE_PIC_EDIT_GALLERY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2901c[Action.LAUNCH_PROFILE_PIC_CROPPER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2901c[Action.LAUNCH_AD_IMAGE_CROPPER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2901c[Action.LAUNCH_GENERIC_CROPPER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2901c[Action.LAUNCH_COVER_PIC_CROPPER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2901c[Action.LAUNCH_COMPOSER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2901c[Action.LAUNCH_STICKER_EDITOR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2901c[Action.NONE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2900b[MediaType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2900b[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2899a[SupportedMediaType.PHOTO_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f2899a[SupportedMediaType.VIDEO_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class C03762 implements OnClickListener {
        final /* synthetic */ SimplePickerFragment f2902a;

        C03762(SimplePickerFragment simplePickerFragment) {
            this.f2902a = simplePickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2002655570);
            this.f2902a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1740033196, a);
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class C03773 implements CollageSlideshowSwitchListener {
        final /* synthetic */ SimplePickerFragment f2903a;

        C03773(SimplePickerFragment simplePickerFragment) {
            this.f2903a = simplePickerFragment;
        }

        public final void mo140a(boolean z) {
            if (z) {
                this.f2903a.bn.m10731c();
            } else {
                this.f2903a.bn.m10732d();
            }
            this.f2903a.at = z;
            this.f2903a.f2841a.m3061a(SimplePickerFragment.az(this.f2903a));
            SimplePickerFragment.aC(this.f2903a);
            this.f2903a.aK.m3157a(z, this.f2903a.f2843c.m3129a());
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class C03784 implements MediaItemsOperator {
        final /* synthetic */ SimplePickerFragment f2904a;

        C03784(SimplePickerFragment simplePickerFragment) {
            this.f2904a = simplePickerFragment;
        }

        public final void m2972a(MediaItem mediaItem, SelectMode selectMode) {
            this.f2904a.aJ.m3152a(this.f2904a.f2843c.m3129a());
        }

        public final void m2971a() {
        }

        public final void m2973b() {
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class C03795 implements MediaItemsOperator {
        final /* synthetic */ SimplePickerFragment f2905a;

        C03795(SimplePickerFragment simplePickerFragment) {
            this.f2905a = simplePickerFragment;
        }

        public final void m2975a(MediaItem mediaItem, SelectMode selectMode) {
            this.f2905a.aK.m3157a(this.f2905a.at, this.f2905a.f2843c.m3129a());
        }

        public final void m2974a() {
        }

        public final void m2976b() {
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    public class C03806 {
        public final /* synthetic */ SimplePickerFragment f2906a;

        public C03806(SimplePickerFragment simplePickerFragment) {
            this.f2906a = simplePickerFragment;
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    public class C03817 {
        final /* synthetic */ SimplePickerFragment f2907a;

        C03817(SimplePickerFragment simplePickerFragment) {
            this.f2907a = simplePickerFragment;
        }

        public final void m2977a(MediaItem mediaItem, boolean z) {
            if (!this.f2907a.f2848h) {
                this.f2907a.av.put(mediaItem, Boolean.valueOf(z));
                int size = this.f2907a.av.size();
                if (size == 12 || size >= this.f2907a.f2841a.f2999b.mo149b()) {
                    this.f2907a.f2848h = true;
                    this.f2907a.m2910e();
                }
            }
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    public class C03828 {
        final /* synthetic */ SimplePickerFragment f2908a;

        public C03828(SimplePickerFragment simplePickerFragment) {
            this.f2908a = simplePickerFragment;
        }

        public final void m2978a() {
            SimplePickerFragment.m2890a(this.f2908a, CameraType.IMAGE, true);
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    public class C03839 extends AbstractDisposableFutureCallback<ImmutableList<FramePack>> {
        final /* synthetic */ SimplePickerFragment f2909a;

        public C03839(SimplePickerFragment simplePickerFragment) {
            this.f2909a = simplePickerFragment;
        }

        protected final void m2979a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            int i = (immutableList == null || immutableList.isEmpty() || ((FramePackModel) immutableList.get(0)).c().isEmpty()) ? 0 : 1;
            this.f2909a.aE.m2947g(i != 0 ? ((FramePackModel) immutableList.get(0)).d() : "");
            if (i != 0) {
                this.f2909a.by = immutableList;
                this.f2909a.f2845e.mo147a((FramePackModel) immutableList.get(0));
            }
        }

        protected final void m2980a(Throwable th) {
            this.f2909a.aE.m2943d();
            BLog.b(SimplePickerFragment.ay, "failed to fetch frames");
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class GridSpacingItemDecoration extends ItemDecoration {
        private final int f2910a;

        public GridSpacingItemDecoration(int i) {
            this.f2910a = i;
        }

        public final void m2981a(Rect rect, View view, RecyclerView recyclerView, State state) {
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(2131429468);
            int d = RecyclerView.d(view) - this.f2910a;
            if (d >= 0) {
                int i = ((GridLayoutManager) recyclerView.getLayoutManager()).c;
                int i2 = d % i;
                d /= i;
                if (this.f2910a == 1 || d > 0) {
                    rect.top = dimensionPixelSize;
                }
                rect.left = (i2 * dimensionPixelSize) / i;
                rect.right = dimensionPixelSize - (((i2 + 1) * dimensionPixelSize) / i);
            }
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class NavigationEventListenerImpl implements NavigationEventListener {
        final /* synthetic */ SimplePickerFragment f2911a;

        public NavigationEventListenerImpl(SimplePickerFragment simplePickerFragment) {
            this.f2911a = simplePickerFragment;
        }

        public final void mo141a(PhotoItem photoItem, boolean z) {
            if (z) {
                if (this.f2911a.bl) {
                    this.f2911a.aE.m2940b(photoItem.l().toString());
                }
                this.f2911a.f2843c.m3133a((MediaItem) photoItem);
            }
            this.f2911a.f2841a.m3064b();
            FragmentManager s = this.f2911a.s();
            TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = (TaggablePhotoGalleryFragment) s.a("GALLERY_FRAGMENT");
            s.a().a(taggablePhotoGalleryFragment).a(8194).b();
            if (taggablePhotoGalleryFragment != null && taggablePhotoGalleryFragment.az) {
                this.f2911a.aW = true;
                this.f2911a.mo136a(null);
            }
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class ProgressBarSpringListener extends SimpleSpringListener {
        final /* synthetic */ SimplePickerFragment f2912a;

        public ProgressBarSpringListener(SimplePickerFragment simplePickerFragment) {
            this.f2912a = simplePickerFragment;
        }

        public final void m2984b(Spring spring) {
            if (spring.d() == 1.0d) {
                MediaItem mediaItem = this.f2912a.al.f3315e;
                switch (AnonymousClass21.f2900b[mediaItem.m().ordinal()]) {
                    case 1:
                        if (!((PhotoItem) mediaItem).c) {
                            SimplePickerFragment.m2888a(this.f2912a, mediaItem.d());
                            return;
                        }
                        return;
                    case 2:
                        ((SecureContextHelper) this.f2912a.aL.get()).a(new Intent(this.f2912a.ao(), ProductionVideoGalleryActivity.class).putExtra("extra_session_id", this.f2912a.aX).putExtra("extra_source", Source.SIMPLEPICKER.ordinal()).putExtra("extra_video_item", mediaItem).putExtra("extra_video_uri", Uri.fromFile(new File(mediaItem.e()))), 1000, this.f2912a);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    public class SimplePickerCallback implements SimpleCameraCallback {
        final /* synthetic */ SimplePickerFragment f2913a;

        public SimplePickerCallback(SimplePickerFragment simplePickerFragment) {
            this.f2913a = simplePickerFragment;
        }

        public final void m2986a(ImmutableList<MediaItem> immutableList, boolean z) {
            m2985a(immutableList, z, "camera");
        }

        public final void m2987b(ImmutableList<MediaItem> immutableList, boolean z) {
            m2985a(immutableList, z, "upload");
        }

        private void m2985a(ImmutableList<MediaItem> immutableList, boolean z, String str) {
            this.f2913a.aE.m2936a(immutableList.size());
            if (this.f2913a.f2842b != null) {
                if (this.f2913a.f2842b.d.k() || !immutableList.isEmpty()) {
                    switch (AnonymousClass21.f2901c[this.f2913a.f2842b.b.ordinal()]) {
                        case 1:
                            if (!SimplePickerFragment.m2897c((ImmutableList) immutableList)) {
                                this.f2913a.ba = str;
                                SimplePickerFragment.m2889a(this.f2913a, (MediaItem) immutableList.get(0), this.f2913a.f2842b.c);
                                return;
                            }
                            break;
                        case 2:
                            if (!SimplePickerFragment.m2897c((ImmutableList) immutableList)) {
                                SimplePickerFragment.m2892a(this.f2913a, immutableList, false, false, EntryPoint.PROFILE.name(), str);
                                return;
                            }
                            break;
                        case 3:
                            SimplePickerFragment.m2892a(this.f2913a, immutableList, false, true, EntryPoint.ADS.name(), str);
                            return;
                        case 4:
                            SimplePickerFragment.m2892a(this.f2913a, immutableList, false, false, EntryPoint.GENERIC.name(), str);
                            return;
                        case 5:
                            SimplePickerFragment.m2892a(this.f2913a, immutableList, true, false, EntryPoint.PROFILE.name(), str);
                            return;
                        case 6:
                            if (!this.f2913a.hn_() || !this.f2913a.y) {
                                return;
                            }
                            if (this.f2913a.at) {
                                SimplePickerFragment.m2899e(this.f2913a, immutableList);
                                return;
                            } else {
                                SimplePickerFragment.m2895b(this.f2913a, immutableList);
                                return;
                            }
                        case 7:
                            SimplePickerFragment.m2900f(this.f2913a, immutableList);
                            this.f2913a.ao().finish();
                            return;
                        default:
                            if (this.f2913a.at) {
                                SimplePickerFragment.m2898d(this.f2913a, immutableList);
                                return;
                            }
                            break;
                    }
                    SimplePickerFragment.m2891a(this.f2913a, (ImmutableList) immutableList, z);
                    return;
                }
                SimplePickerFragment.aG(this.f2913a);
            }
        }
    }

    /* compiled from: simple_search_loader_filter_value */
    class SimplePickerGridLayoutManager extends GridLayoutManager {
        private final int f2914t;
        private final int f2915u;
        private final int f2916v;

        public SimplePickerGridLayoutManager(Context context, int i) {
            super(context, i);
            this.f2914t = i;
            Resources resources = context.getResources();
            this.f2915u = resources.getDimensionPixelSize(2131429470);
            this.f2916v = resources.getDimensionPixelSize(2131429468);
        }

        public final void m2988c(Recycler recycler, State state) {
            a(Math.max(this.f2914t, (w() + this.f2916v) / (this.f2915u + this.f2916v)));
            super.c(recycler, state);
        }
    }

    protected abstract void mo136a(String str);

    static /* synthetic */ void m2892a(SimplePickerFragment simplePickerFragment, ImmutableList immutableList, boolean z, boolean z2, String str, String str2) {
        if (immutableList.size() != 1) {
            BLog.b(ay, "Number of photo selected for cropping is not one");
            return;
        }
        float f;
        float f2;
        Dimension dimension;
        boolean z3;
        if (z || z2) {
            f = 0.5f;
        } else {
            f = 0.9f;
        }
        if (z2) {
            f2 = 1.910828f;
        } else if (z) {
            f2 = 1.7777778f;
        } else {
            f2 = 1.0f;
        }
        MediaItem mediaItem = (MediaItem) immutableList.get(0);
        Context context = simplePickerFragment.getContext();
        Builder a = new Builder().a(mediaItem.f(), mediaItem.b().mId).a(EditFeature.CROP).b(EditFeature.DOODLE).b(EditFeature.TEXT).b(EditFeature.STICKER).b(EditFeature.FILTER).a(CropMode.ZOOM_CROP);
        EditGalleryZoomCropParams.Builder builder = new EditGalleryZoomCropParams.Builder();
        builder.c = f;
        builder = builder;
        builder.d = f2;
        EditGalleryZoomCropParams.Builder builder2 = builder;
        if (z || z2) {
            dimension = EditGalleryZoomCropParams.b;
        } else {
            dimension = EditGalleryZoomCropParams.a;
        }
        builder2.e = dimension;
        a.m = builder2.a();
        Builder builder3 = a;
        builder3.f = true;
        Builder builder4 = builder3;
        if (z2 || z) {
            z3 = false;
        } else {
            z3 = true;
        }
        builder4.n = z3;
        ((SecureContextHelper) simplePickerFragment.aL.get()).a(EditGalleryIntentCreator.a(context, str, builder4.a()), 1241, simplePickerFragment);
    }

    protected final void m2906a(MediaItemsOperator mediaItemsOperator, SimplePickerFlowLogger simplePickerFlowLogger, SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, Lazy<SimpleCamera> lazy, Lazy<SecureContextHelper> lazy2, PrefilledTaggingActivator prefilledTaggingActivator, Provider<TriState> provider, PickerSelectionControllerProvider pickerSelectionControllerProvider, Lazy<PickerSelectionUpdateUtil> lazy3, Lazy<TasksManager> lazy4, Lazy<FbErrorReporter> lazy5, SimplePickerBackgroundTasksControllerProvider simplePickerBackgroundTasksControllerProvider, TaggableLocalMediaUtil taggableLocalMediaUtil, SimplePickerDataLoadUtil simplePickerDataLoadUtil, ListeningExecutorService listeningExecutorService, Provider<Boolean> provider2, FbSharedPreferences fbSharedPreferences, Clock clock, Lazy<SouvenirManager> lazy6, Toaster toaster, ComposerLauncher composerLauncher, TagStore tagStore, FaceBoxStore faceBoxStore, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, SimplePickerNuxManagerProvider simplePickerNuxManagerProvider, QeAccessor qeAccessor, SouvenirsLogger souvenirsLogger, AllCapsTransformationMethod allCapsTransformationMethod, CreativeCamLauncher creativeCamLauncher, Boolean bool, ExecutorService executorService, FramesAggregator framesAggregator, MediaItemFactory mediaItemFactory, Lazy<SouvenirsMediaItemsHelper> lazy7, SlideshowLogger slideshowLogger) {
        this.aF = mediaItemsOperator;
        this.aE = simplePickerFlowLogger;
        this.an = sequenceLogger;
        this.ao = interactionTTILogger;
        this.ap = sequenceLogger.e(SimplePickerSequences.f3186a);
        if (this.ap == null) {
            this.ap = new NoOpSequence();
        }
        this.aM = lazy;
        this.aL = lazy2;
        this.aG = prefilledTaggingActivator;
        this.bl = provider.get() == TriState.YES;
        this.aN = pickerSelectionControllerProvider;
        this.aO = lazy3;
        this.aP = simplePickerBackgroundTasksControllerProvider;
        this.aQ = lazy4;
        this.bm = lazy5;
        this.aR = taggableLocalMediaUtil;
        this.f2844d = simplePickerDataLoadUtil;
        this.aZ = listeningExecutorService;
        this.aS = fbSharedPreferences;
        this.aC = ((Boolean) provider2.get()).booleanValue();
        this.aT = clock;
        this.aU = lazy6;
        this.aV = activityRuntimePermissionsManagerProvider.a(o());
        this.bc = toaster;
        this.br = composerLauncher;
        this.bs = tagStore;
        this.bt = faceBoxStore;
        this.bo = simplePickerNuxManagerProvider;
        this.bq = qeAccessor;
        this.bv = souvenirsLogger;
        this.aI = allCapsTransformationMethod;
        this.aH = creativeCamLauncher;
        this.bb = bool;
        this.bw = executorService;
        this.bx = framesAggregator;
        this.bz = mediaItemFactory;
        this.bA = lazy7;
        this.bn = slideshowLogger;
        this.f2846f = jW_().getDimensionPixelSize(2131429470);
    }

    public void mo137c(Bundle bundle) {
        super.c(bundle);
        SequenceLoggerDetour.b(this.ap, "LaunchFragmentAndDi", 820790238);
        this.aV.a(az, new C03751(this));
        this.bs.a(this.aX);
        this.bt.a(this.aX);
        this.bu = false;
        if (bundle != null) {
            SimpleCamera simpleCamera = (SimpleCamera) this.aM.get();
            Uri uri = (Uri) bundle.getParcelable("fb_captured_media_uri");
            if (uri != null) {
                Preconditions.checkNotNull(uri);
                simpleCamera.g = uri;
            }
            this.f2842b = (SimplePickerLauncherConfiguration) bundle.getParcelable("fb_simple_picker_fragment_conf");
        }
        if (this.f2842b == null && this.s != null && this.s.containsKey("extra_simple_picker_launcher_settings")) {
            this.f2842b = (SimplePickerLauncherConfiguration) this.s.getParcelable("extra_simple_picker_launcher_settings");
        }
        if (this.s != null && this.s.containsKey("extra_simple_picker_launcher_waterfall_id")) {
            this.f2849i = this.s.getBoolean("extra_should_merge_camera_roll", false);
            SimplePickerLauncherConfiguration simplePickerLauncherConfiguration = this.f2842b;
            String string = this.s.getString("extra_simple_picker_launcher_waterfall_id");
            OnClickListener c03762 = new C03762(this);
            this.f2842b = simplePickerLauncherConfiguration;
            this.at = this.f2842b.d.v;
            this.aX = string;
            this.aD = c03762;
            this.aB = new SimplePickerCallback(this);
            this.bv.c = this.aX;
            this.bn.f9007b = this.aX;
        }
    }

    public View mo135a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1782227250);
        SequenceLoggerDetour.a(this.ap, "InflateViews", -1224326525);
        View inflate = layoutInflater.inflate(2130907113, viewGroup, false);
        View findViewById = inflate.findViewById(2131564987);
        if (this.f2849i) {
            findViewById.setPadding(0, 0, 0, 0);
        }
        ViewStub viewStub = (ViewStub) inflate.findViewById(2131567464);
        SimplePickerConfiguration simplePickerConfiguration = this.f2842b.d;
        if (simplePickerConfiguration.j && this.bq.a(ExperimentsForSouvenirAbtestModule.o, false)) {
            this.as = ((SouvenirManager) this.aU.get()).a();
        }
        boolean z = (this.as == null || this.as.isEmpty()) ? false : true;
        this.aq = z;
        this.ar = this.bq.a(ExperimentsForSimplePickerModule.f2920d, false);
        if (this.ar || this.aq) {
            this.bv.a();
            ((ViewGroup) inflate).removeView(findViewById);
            view = (RecyclerView) viewStub.inflate();
            view.setLayoutManager(new SimplePickerGridLayoutManager(getContext(), 1));
            view.a(new GridSpacingItemDecoration(this.aq ? 1 : 0));
            view.setItemAnimator(null);
            i = ((LayoutParams) view.getLayoutParams()).topMargin;
        } else {
            view = findViewById;
            i = 0;
        }
        m2896c(inflate);
        this.aE.f2880a = this.aX;
        this.f2843c = this.aN.m3135a(simplePickerConfiguration, new C03806(this));
        this.f2843c.m3130a(this.aF);
        this.f2843c.m3130a((MediaItemsOperator) new MediaItemsOperator(this) {
            final /* synthetic */ SimplePickerFragment f2893a;

            {
                this.f2893a = r1;
            }

            public final void m2959a(MediaItem mediaItem, SelectMode selectMode) {
                SimplePickerFragment.aC(this.f2893a);
            }

            public final void m2958a() {
            }

            public final void m2960b() {
            }
        });
        this.f2843c.m3130a((MediaItemsOperator) new MediaItemsOperator(this) {
            final /* synthetic */ SimplePickerFragment f2894a;

            {
                this.f2894a = r1;
            }

            public final void m2962a(MediaItem mediaItem, SelectMode selectMode) {
                if (selectMode == SelectMode.SELECT && SimplePickerFragment.aE(this.f2894a)) {
                    this.f2894a.as();
                }
            }

            public final void m2961a() {
            }

            public final void m2963b() {
            }
        });
        if (simplePickerConfiguration.s) {
            this.f2843c.m3130a(m2885a(inflate, view));
            this.f2843c.m3130a(m2894b(inflate));
        }
        if (bundle != null) {
            this.f2843c.m3132a(ImmutableList.copyOf(bundle.getParcelableArrayList("selected_media_items")));
        } else {
            this.f2843c.m3132a(simplePickerConfiguration.d);
        }
        if (simplePickerConfiguration.i && this.bq.a(ExperimentsForComposerAbTestModule.Q, false)) {
            z = true;
        } else {
            z = false;
        }
        this.bp = this.bo.m3185a(inflate, z, this.aq, i, simplePickerConfiguration.s, simplePickerConfiguration.t, this.aJ, this.aX);
        SequenceLoggerDetour.b(this.ap, "InflateViews", -242644186);
        if (this.aC) {
            inflate.findViewById(2131567458).setBackgroundResource(2131361920);
            inflate.findViewById(2131560407).setBackgroundResource(2131361981);
            ((FbTextView) inflate.findViewById(2131567468)).setTextColor(jW_().getColor(2131361956));
        }
        if (this.f2849i) {
            inflate.findViewById(2131558563).setVisibility(8);
        }
        LogUtils.f(1985248685, a);
        return inflate;
    }

    private MediaItemsOperator m2885a(View view, View view2) {
        if (this.aJ == null) {
            this.aJ = new SimplePickerSlideshowEntrypointController(this.f2842b.d, view, view2, this.aq, new C03773(this));
        }
        return new C03784(this);
    }

    private MediaItemsOperator m2894b(View view) {
        if (this.aK == null) {
            this.aK = new SlideshowErrorMessageController(view, this.f2842b.d);
        }
        return new C03795(this);
    }

    protected final C03817 m2908b() {
        return new C03817(this);
    }

    protected final void m2910e() {
        this.f2848h = true;
        int i = 0;
        for (Boolean booleanValue : this.av.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        SequenceLoggerDetour.b(this.ap, "RenderThumbnails", null, ImmutableBiMap.b("NumMemoryCachedMedia", Integer.toString(i)), 796832160);
        this.an.b(SimplePickerSequences.f3186a);
        this.ao.b("OpenMediaPicker");
        aq();
        SimplePickerBackgroundTasksController a = this.aP.m2930a(this.bp);
        ExecutorDetour.a(a.f2870c, new C03681(a), -44144476);
        ExecutorDetour.a(a.f2870c, new C03692(a), 391706976);
        ExecutorDetour.a(a.f2870c, new C03703(a), 1975601222);
        long a2 = a.f2876i.a(PhotosPrefKeys.h, -1);
        long a3 = a.f2879l.a();
        if ((a2 == -1 || a3 - a2 > 86400000) && a.f2875h != null && a.f2875h.a(609, false)) {
            ExecutorDetour.a(a.f2870c, new C03714(a, a3), 1541250712);
        }
        if (a.f2876i.a(ComposerPrefKeys.t, -1) == -1) {
            ExecutorDetour.a(a.f2870c, new C03735(a), -1788045662);
        }
        this.aS.edit().a(PhotosPrefKeys.b, this.aT.a()).commit();
    }

    public final void aq() {
        if (!this.aY) {
            AutoTaggingHelper autoTaggingHelper = this.aG;
            if (1 != 0 && this.f2842b.d.f) {
                this.aY = true;
                autoTaggingHelper = this.aG;
                String str = this.aX;
                autoTaggingHelper.b();
                autoTaggingHelper.c.b = str;
            }
        }
    }

    public final void m2911e(Bundle bundle) {
        FragmentManager s = s();
        TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = (TaggablePhotoGalleryFragment) s.a("GALLERY_FRAGMENT");
        if (taggablePhotoGalleryFragment != null) {
            s.a().a(taggablePhotoGalleryFragment).c();
        }
        super.e(bundle);
        Uri uri = ((SimpleCamera) this.aM.get()).g;
        if (uri != null) {
            bundle.putParcelable("fb_captured_media_uri", uri);
        }
        bundle.putParcelable("fb_simple_picker_fragment_conf", this.f2842b);
        bundle.putParcelableArrayList("selected_media_items", new ArrayList(aA()));
        this.f2845e.mo145a(bundle);
        this.bu = true;
    }

    public final void m2905a(int i, int i2, Intent intent) {
        if (i2 != -1 && aE(this)) {
            this.f2843c.m3132a(RegularImmutableList.a);
            aC(this);
        }
        switch (i) {
            case 1000:
                if (i2 == -1) {
                    MediaItem mediaItem = (MediaItem) intent.getParcelableExtra("extra_video_item");
                    if (this.bl) {
                        this.aE.m2940b(mediaItem.l().toString());
                    }
                    this.f2843c.m3133a(mediaItem);
                    return;
                }
                return;
            case 1240:
                ao().setResult(i2, intent);
                ao().finish();
                if (i2 == 0 && this.aE != null) {
                    this.aE.m2939b();
                    return;
                }
                return;
            case 1241:
                if (i2 == -1) {
                    ao().setResult(-1, intent);
                    ao().finish();
                    return;
                }
                return;
            case 1242:
                if (i2 == -1) {
                    intent.putExtra("profile_photo_method_extra", this.ba);
                    intent.putExtra("camera_roll", true);
                    ao().setResult(-1, intent);
                    ao().finish();
                    return;
                }
                return;
            case 1243:
                SimplePickerSource simplePickerSource = this.f2842b.d.e;
                if (i2 == -1 && SimplePickerSource.PROFILEPIC.equals(simplePickerSource)) {
                    CreativeCamResult creativeCamResult = (CreativeCamResult) intent.getParcelableExtra("creative_cam_result_extra");
                    if (this.f2842b != null) {
                        Object obj;
                        Preconditions.checkNotNull(creativeCamResult);
                        ImmutableMap.Builder builder = ImmutableMap.builder();
                        if (creativeCamResult.b == null) {
                            obj = null;
                        } else {
                            obj = creativeCamResult.b.getPath();
                        }
                        builder.b(obj, creativeCamResult.c);
                        MediaItem a = this.bz.a(creativeCamResult.b, FallbackMediaId.CREATIVECAM_MEDIA);
                        Preconditions.checkNotNull(a);
                        ImmutableList of = ImmutableList.of(a);
                        if (this.aB != null) {
                            this.aB.m2986a(of, false);
                        }
                    }
                    return;
                } else if (i2 == -1 && !SimplePickerSource.COMPOSER_ADD_MORE_MEDIA.equals(simplePickerSource)) {
                    m2887a((CreativeCamResult) intent.getParcelableExtra("creative_cam_result_extra"));
                    return;
                } else if (i2 != 0) {
                    ao().setResult(i2, intent);
                    ao().finish();
                    return;
                } else {
                    return;
                }
            case 1244:
                if (i2 == -1) {
                    this.au = (ComposerSlideshowData) intent.getParcelableExtra("extra_slideshow_data");
                    m2891a(this, ImmutableList.copyOf(intent.getParcelableArrayListExtra("extra_media_items")), true);
                    return;
                }
                return;
            case 2002:
            case 2003:
                CameraType a2 = SimpleCamera.a(i);
                if (i2 == -1) {
                    this.aE.m2946f(a2.toString());
                    ((SimpleCamera) this.aM.get()).a(a2, intent, this.aB);
                } else {
                    this.aE.m2945e(a2.toString());
                }
                return;
            default:
                return;
        }
    }

    public void mo138G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -151805020);
        super.G();
        SequenceLoggerDetour.a(this.ap, "LoadMediaItems", 769970302);
        this.f2841a.m3061a(az(this));
        if (this.f2847g) {
            mo136a(null);
        } else if (this.aw != null) {
            this.f2841a.mo134a(this.aw);
        }
        if (!this.f2842b.d.e.equals(SimplePickerSource.COMPOSER_ADD_MORE_MEDIA)) {
            this.aF.b();
        }
        if (this.f2847g) {
            ImmutableList a2 = this.f2843c.m3129a();
            ImmutableList a3 = ((PickerSelectionUpdateUtil) this.aO.get()).m3136a(a2);
            if (a2.size() != a3.size()) {
                this.f2843c.m3132a(a3);
                if (a3.isEmpty()) {
                    aC(this);
                }
            }
            this.f2847g = false;
        }
        this.aW = false;
        this.bp.m3183a();
        if (this.f2841a.m3063a() && !this.f2849i) {
            this.aE.m2941c();
            Futures.a(this.bx.a(), new C03839(this), this.bw);
        }
        if (this.f2841a.m3063a() || this.f2849i) {
            this.f2845e.mo148a(new C03828(this));
        }
        LogUtils.f(1583005797, a);
    }

    public void mo139H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -518391490);
        super.H();
        SimplePickerViewController simplePickerViewController = this.f2841a;
        if (simplePickerViewController.f2999b != null) {
            simplePickerViewController.f2999b.mo151c();
        }
        this.f2847g = true;
        ((TasksManager) this.aQ.get()).c();
        ((TasksManager) this.f2844d.f3129c.get()).c();
        this.aR.e = null;
        if (this.f2842b.d.e != SimplePickerSource.COMPOSER_ADD_MORE_MEDIA) {
            this.aF.a();
        }
        simplePickerViewController = this.f2841a;
        if (simplePickerViewController.f2999b != null) {
            simplePickerViewController.f2999b.mo152d();
        }
        this.f2845e.mo147a(null);
        SimplePickerNuxManager simplePickerNuxManager = this.bp;
        for (SimplePickerInterstitialControllers simplePickerInterstitialControllers : SimplePickerInterstitialControllers.values()) {
            ((SimplePickerNux) simplePickerNuxManager.f3203d.a(simplePickerInterstitialControllers.interstitialId, SimplePickerNux.class)).d();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -189364146, a);
    }

    private SupportedMediaType ay() {
        return this.f2841a != null ? this.f2841a.f3007j : az(this);
    }

    public static SupportedMediaType az(SimplePickerFragment simplePickerFragment) {
        if (simplePickerFragment.at) {
            return SupportedMediaType.PHOTO_ONLY_EXCLUDING_GIFS;
        }
        return simplePickerFragment.f2842b.d.b;
    }

    private void m2896c(View view) {
        Preconditions.checkNotNull(this.f2842b);
        this.bg = (Fb4aTitleBar) FindViewUtil.b(view, 2131558563);
        this.bg.setTitle(2131234396);
        this.al = (PickerLongPressProgressBar) view.findViewById(2131559418);
        this.al.m3261a(new ProgressBarSpringListener(this));
        this.bh = new OnActionButtonClickListener(this) {
            final /* synthetic */ SimplePickerFragment f2882a;

            {
                this.f2882a = r1;
            }

            public final void m2948a(View view) {
                this.f2882a.as();
            }
        };
        this.bi = new OnActionButtonClickListener(this) {
            final /* synthetic */ SimplePickerFragment f2883a;

            {
                this.f2883a = r1;
            }

            public final void m2949a(View view) {
                if (!this.f2883a.at) {
                    this.f2883a.bc.b(new ToastBuilder(2131234406, new Object[]{Integer.valueOf(this.f2883a.f2842b.d.q)}));
                }
            }
        };
        this.bg.a(this.aD);
        if (this.f2842b.d.l) {
            switch (AnonymousClass21.f2899a[ay().ordinal()]) {
                case 1:
                    m2893a(this.bg, false, false, true, false);
                    return;
                case 2:
                    m2893a(this.bg, false, false, false, true);
                    return;
                default:
                    m2893a(this.bg, false, false, true, true);
                    return;
            }
        }
        m2893a(this.bg, true, true, false, false);
    }

    private void m2893a(Fb4aTitleBar fb4aTitleBar, boolean z, boolean z2, boolean z3, boolean z4) {
        TitleBarButtonSpec.Builder a;
        this.am = z3;
        if ((this.f2842b.d.h && this.bq.a(ExperimentsForPhotosExperimentsModule.d, false)) || this.at || this.f2842b.f) {
            a = TitleBarButtonSpec.a();
            a.g = b(2131234400);
            this.bd = a.a();
        } else {
            a = TitleBarButtonSpec.a();
            a.g = b(2131234399);
            this.bd = a.a();
        }
        a = TitleBarButtonSpec.a();
        a.b = jW_().getDrawable(2130843386);
        a = a;
        a.j = jW_().getString(2131234417);
        this.be = a.a();
        a = TitleBarButtonSpec.a();
        a.b = jW_().getDrawable(2130843390);
        a = a;
        a.j = jW_().getString(2131234418);
        this.bf = a.a();
        this.bj = new OnActionButtonClickListener(this) {
            final /* synthetic */ SimplePickerFragment f2884a;

            {
                this.f2884a = r1;
            }

            public final void m2950a(View view) {
                SimplePickerFragment.m2890a(this.f2884a, CameraType.IMAGE, false);
            }
        };
        this.bk = new OnActionButtonClickListener(this) {
            final /* synthetic */ SimplePickerFragment f2885a;

            {
                this.f2885a = r1;
            }

            public final void m2951a(View view) {
                SimplePickerFragment.m2890a(this.f2885a, CameraType.VIDEO, false);
            }
        };
        if (z) {
            fb4aTitleBar.setActionButtonOnClickListener(z2 ? this.bh : this.bi);
            this.bd.t = z2;
            fb4aTitleBar.setPrimaryButton(this.bd);
            return;
        }
        if (z3) {
            fb4aTitleBar.setActionButtonOnClickListener(this.bj);
            fb4aTitleBar.setPrimaryButton(this.be);
        }
        if (z4) {
            fb4aTitleBar.setSecondaryActionButtonOnClickListener(this.bk);
            fb4aTitleBar.setSecondaryButton(this.bf);
        }
    }

    public static void m2890a(SimplePickerFragment simplePickerFragment, final CameraType cameraType, final boolean z) {
        simplePickerFragment.aV.a(aA, new AbstractRuntimePermissionsListener(simplePickerFragment) {
            final /* synthetic */ SimplePickerFragment f2888c;

            public final void m2952a() {
                SimplePickerFragment simplePickerFragment = this.f2888c;
                CameraType cameraType = cameraType;
                boolean z = z;
                simplePickerFragment.aE.m2944d(cameraType.toString());
                if (CameraType.IMAGE.equals(cameraType) && simplePickerFragment.f2841a.m3063a()) {
                    CreativeCamSource creativeCamSource;
                    CreativeCamLaunchConfig.Builder builder = new CreativeCamLaunchConfig.Builder();
                    builder.b = false;
                    builder = builder;
                    builder.f = SupportedMediaType.PHOTO_ONLY;
                    builder = builder;
                    builder.h = simplePickerFragment.by;
                    CreativeCamLaunchConfig.Builder builder2 = builder;
                    String c = (simplePickerFragment.by == null || simplePickerFragment.by.isEmpty()) ? null : z ? ((FrameModel) ((FramePackModel) simplePickerFragment.by.get(0)).c().get(0)).c() : Filter.PassThrough.name();
                    builder2.i = c;
                    builder2 = builder2;
                    if (z) {
                        creativeCamSource = CreativeCamSource.SIMPLEPICKER_LIVECAM_CELL;
                    } else {
                        creativeCamSource = CreativeCamSource.SIMPLEPICKER_CAMERA_BUTTON;
                    }
                    builder2.l = creativeCamSource;
                    builder2 = builder2;
                    if (simplePickerFragment.f2842b.d.o) {
                        builder2.b = true;
                        builder = builder2;
                        builder.e = true;
                        builder.d = true;
                    }
                    simplePickerFragment.aH.a(simplePickerFragment, 1243, builder2.a(), simplePickerFragment.aX, null);
                    return;
                }
                int i;
                Intent b = ((SimpleCamera) simplePickerFragment.aM.get()).b(cameraType);
                SecureContextHelper secureContextHelper = (SecureContextHelper) simplePickerFragment.aL.get();
                simplePickerFragment.aM.get();
                switch (4.a[cameraType.ordinal()]) {
                    case 1:
                        i = 2003;
                        break;
                    default:
                        i = 2002;
                        break;
                }
                secureContextHelper.b(b, i, simplePickerFragment);
            }

            public final void m2953a(String[] strArr, String[] strArr2) {
                this.f2888c.bc.b(new ToastBuilder(this.f2888c.getContext().getString(2131234427)));
            }
        });
    }

    public final void as() {
        final ImmutableList aA = aA();
        ((TasksManager) this.aQ.get()).a(SimplePickerTaskId.FETCH_TAGGING_DATA, aF(), new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ SimplePickerFragment f2890b;

            protected final void m2954a(Object obj) {
                if (this.f2890b.aB != null) {
                    this.f2890b.aB.m2987b(aA, this.f2890b.aW);
                }
            }

            protected final void m2955a(Throwable th) {
                ((AbstractFbErrorReporter) this.f2890b.bm.get()).a(SimplePickerFragment.ay, "Unable to fetch tagging data");
            }
        });
    }

    private ImmutableList<MediaItem> aA() {
        return this.f2843c.m3129a();
    }

    public static void m2888a(SimplePickerFragment simplePickerFragment, final MediaIdKey mediaIdKey) {
        if (!simplePickerFragment.f2848h) {
            SequenceLoggerDetour.e(simplePickerFragment.ap, "GalleryLaunched", -819322685);
        }
        simplePickerFragment.aq();
        ((TasksManager) simplePickerFragment.aQ.get()).a(SimplePickerTaskId.FETCH_TAGGING_DATA, simplePickerFragment.aF(), new AbstractDisposableFutureCallback(simplePickerFragment) {
            final /* synthetic */ SimplePickerFragment f2892b;

            protected final void m2956a(Object obj) {
                TaggablePhotoGalleryFragment taggablePhotoGalleryFragment = new TaggablePhotoGalleryFragment();
                taggablePhotoGalleryFragment.m3423a(mediaIdKey, this.f2892b.f2842b.d.c, new NavigationEventListenerImpl(this.f2892b), Source.SIMPLEPICKER, this.f2892b.aX);
                this.f2892b.s().a().a(2131567458, taggablePhotoGalleryFragment, "GALLERY_FRAGMENT").a(4097).c();
            }

            protected final void m2957a(Throwable th) {
                ((AbstractFbErrorReporter) this.f2892b.bm.get()).a(SimplePickerFragment.ay, "Unable to fetch tagging data");
            }
        });
    }

    public static void aC(SimplePickerFragment simplePickerFragment) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ImmutableList aA = simplePickerFragment.aA();
        boolean isEmpty = aA.isEmpty();
        SimplePickerConfiguration simplePickerConfiguration = simplePickerFragment.f2842b.d;
        SupportedMediaType ay = simplePickerFragment.ay();
        if (ay != SupportedMediaType.VIDEO_ONLY && isEmpty && simplePickerConfiguration.l) {
            z = true;
        } else {
            z = false;
        }
        if (ay != SupportedMediaType.PHOTO_ONLY && isEmpty && simplePickerConfiguration.l) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (isEmpty && simplePickerConfiguration.l) {
            z3 = false;
        } else {
            z3 = true;
        }
        Object obj;
        if (!simplePickerFragment.at || aA.size() < simplePickerConfiguration.t || aA.size() > simplePickerConfiguration.u) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj2;
        if (simplePickerFragment.at || aA.size() < simplePickerConfiguration.q) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if ((!isEmpty || simplePickerConfiguration.k()) && !(r6 == null && r3 == null)) {
            z4 = true;
        } else {
            z4 = false;
        }
        simplePickerFragment.m2893a(simplePickerFragment.bg, z3, z4, z, z2);
    }

    public static boolean aE(SimplePickerFragment simplePickerFragment) {
        if (simplePickerFragment.f2842b == null || simplePickerFragment.f2842b.d == null) {
            return false;
        }
        SimplePickerSource simplePickerSource = simplePickerFragment.f2842b.d.e;
        if (simplePickerSource == SimplePickerSource.PROFILEPIC || simplePickerSource == SimplePickerSource.COVERPHOTO || simplePickerSource == SimplePickerSource.HOLIDAY_CARDS) {
            return true;
        }
        return false;
    }

    private Callable<ListenableFuture> aF() {
        return new Callable<ListenableFuture>(this) {
            final /* synthetic */ SimplePickerFragment f2896a;

            /* compiled from: simple_search_loader_filter_value */
            class C03741 implements Runnable {
                final /* synthetic */ AnonymousClass19 f2895a;

                C03741(AnonymousClass19 anonymousClass19) {
                    this.f2895a = anonymousClass19;
                }

                public void run() {
                    this.f2895a.f2896a.aR.c();
                }
            }

            {
                this.f2896a = r1;
            }

            public Object call() {
                return this.f2896a.aZ.a(new C03741(this));
            }
        };
    }

    public static void m2891a(SimplePickerFragment simplePickerFragment, ImmutableList immutableList, boolean z) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("extra_media_items", new ArrayList(immutableList));
        intent.putExtra("are_media_items_modified", z);
        if (simplePickerFragment.at) {
            intent.putExtra("extra_slideshow_data", simplePickerFragment.au);
        }
        if (m2897c(immutableList)) {
            intent.setData(Uri.fromFile(new File(((MediaItem) immutableList.get(0)).e())));
        }
        if (simplePickerFragment.ao() != null) {
            simplePickerFragment.ao().setResult(-1, intent);
            simplePickerFragment.ao().finish();
            return;
        }
        ((AbstractFbErrorReporter) simplePickerFragment.bm.get()).a(ay, "Hosting Activity is null");
    }

    public static void aG(SimplePickerFragment simplePickerFragment) {
        ((Activity) Preconditions.checkNotNull(simplePickerFragment.ao())).setResult(0);
        simplePickerFragment.ao().finish();
    }

    private ComposerConfiguration.Builder aH() {
        return ComposerConfiguration.a(this.f2842b.a);
    }

    private void m2886a(ComposerConfiguration composerConfiguration) {
        this.br.a(this.aX, composerConfiguration, 1240, this);
    }

    public static void m2895b(SimplePickerFragment simplePickerFragment, ImmutableList immutableList) {
        simplePickerFragment.m2886a(simplePickerFragment.aH().setInitialAttachments(ComposerAttachment.a(immutableList)).a());
    }

    private void m2887a(CreativeCamResult creativeCamResult) {
        Preconditions.checkNotNull(creativeCamResult);
        ComposerConfiguration.Builder aH = aH();
        if (creativeCamResult != null) {
            ComposerAttachment.Builder a = ComposerAttachment.Builder.a(this.bz.a(creativeCamResult.b, FallbackMediaId.CREATIVECAM_MEDIA));
            a.e = creativeCamResult.c;
            aH.setInitialAttachments(ImmutableList.of(Preconditions.checkNotNull(a.a()))).setUseOptimisticPosting(true);
        }
        m2886a(aH.a());
    }

    public static boolean m2897c(ImmutableList<MediaItem> immutableList) {
        return immutableList.size() == 1 && (immutableList.get(0) instanceof VideoItem);
    }

    public static void m2889a(SimplePickerFragment simplePickerFragment, @Nullable MediaItem mediaItem, ExpirationState expirationState) {
        Intent a;
        boolean z = true;
        if (expirationState == null) {
            expirationState = ExpirationState.b;
        }
        Builder a2 = new Builder().a(mediaItem.f(), mediaItem.d().toString()).a(EditFeature.CROP).a(CropMode.ZOOM_CROP);
        a2.f = true;
        a2 = a2;
        a2.h = false;
        a2 = a2;
        a2.i = simplePickerFragment.aI.getTransformation(simplePickerFragment.b(2131234496), null).toString();
        a2 = a2;
        a2.k = expirationState;
        EditGalleryLaunchConfiguration a3 = a2.a();
        if (simplePickerFragment.bq.a(ExperimentsForTimelineAbTestModule.o, false)) {
            if (!(simplePickerFragment.bq.a(ExperimentsForTimelineAbTestModule.h, false) && mediaItem.b().mType == Type.Photo)) {
                z = false;
            }
            Context context = simplePickerFragment.getContext();
            StagingGroundLaunchConfig.Builder a4 = new StagingGroundLaunchConfig.Builder().a(mediaItem.f(), mediaItem.d().toString());
            a4.d = EntryPoint.PROFILE.name();
            a4 = a4;
            a4.f = expirationState.d;
            a4 = a4;
            a4.p = false;
            a4 = a4;
            a4.r = simplePickerFragment.bq.a(ExperimentsForTimelineAbTestModule.k, false);
            a4 = a4;
            a4.s = simplePickerFragment.bq.a(ExperimentsForTimelineAbTestModule.l, false);
            StagingGroundLaunchConfig.Builder builder = a4;
            builder.t = z;
            a = StagingGroundIntentFactory.a(context, builder.a(), a3);
        } else {
            a = EditGalleryIntentCreator.a(simplePickerFragment.ao(), EntryPoint.PROFILE.name(), a3);
        }
        ((SecureContextHelper) simplePickerFragment.aL.get()).a(a, 1242, simplePickerFragment);
    }

    public static void m2898d(SimplePickerFragment simplePickerFragment, ImmutableList immutableList) {
        ((SecureContextHelper) simplePickerFragment.aL.get()).a(SlideshowEditIntentCreator.m1400a(simplePickerFragment.ao(), SlideshowEditConfiguration.newBuilder().setMediaItems(immutableList).setSource(SlideshowEditConfigurationSpec$Source.SIMPLE_PICKER).setSessionId(simplePickerFragment.aX).m1394a()), 1244, simplePickerFragment);
    }

    public static void m2899e(SimplePickerFragment simplePickerFragment, ImmutableList immutableList) {
        ((SecureContextHelper) simplePickerFragment.aL.get()).a(SlideshowEditIntentCreator.m1400a(simplePickerFragment.ao(), SlideshowEditConfiguration.newBuilder().setMediaItems(immutableList).setSource(SlideshowEditConfigurationSpec$Source.SIMPLE_PICKER).setSessionId(simplePickerFragment.aX).setActionWhenDone(SlideshowEditConfigurationSpec$Action.LAUNCH_COMPOSER).setComposerConfiguration(simplePickerFragment.aH().a()).m1394a()), 1240, simplePickerFragment);
    }

    public static void m2900f(SimplePickerFragment simplePickerFragment, ImmutableList immutableList) {
        boolean z = true;
        if (immutableList.size() != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        MediaItem mediaItem = (MediaItem) immutableList.get(0);
        Preconditions.checkArgument(mediaItem instanceof PhotoItem);
        Intent intent = new Intent(simplePickerFragment.ao(), StickerEditActivity.class);
        intent.putExtra("composer_session_id", simplePickerFragment.aX);
        intent.putExtra("input_image_path_extra", mediaItem);
        ((SecureContextHelper) simplePickerFragment.aL.get()).a(intent, simplePickerFragment.ao());
    }

    public final void m2903I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -55053545);
        if (!(this.bu || this.f2842b == null || this.f2842b.d == null || this.f2842b.d.e == SimplePickerSource.COMPOSER_ADD_MORE_MEDIA)) {
            this.bs.b(this.aX);
            this.bt.b(this.aX);
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1214843583, a);
    }
}
