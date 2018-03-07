package com.facebook.photos.simplepicker;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.bitmaps.BitmapResizingParam;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friendsharing.souvenirs.manager.SouvenirManager;
import com.facebook.friendsharing.souvenirs.mediaitems.SouvenirsMediaItemsHelper;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemsOperator;
import com.facebook.photos.base.tagging.PrefilledTaggingActivator;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.photos.creativeediting.swipeable.common.FramesAggregator;
import com.facebook.photos.simplecamera.SimpleCamera;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.simplepicker.SimplePickerFragment.CameraButtonDelegate;
import com.facebook.photos.simplepicker.SimplePickerFragment.CursorUpdatedCallback;
import com.facebook.photos.simplepicker.controller.LegacySimplePickerGridViewControllerAdapterProvider;
import com.facebook.photos.simplepicker.controller.LegacySimplePickerRecyclerViewControllerAdapterProvider;
import com.facebook.photos.simplepicker.controller.LegacySimplePickerViewController;
import com.facebook.photos.simplepicker.controller.LegacySimplePickerViewControllerProvider;
import com.facebook.photos.simplepicker.controller.PickerSelectionController;
import com.facebook.photos.simplepicker.controller.PickerSelectionControllerProvider;
import com.facebook.photos.simplepicker.controller.PickerSelectionUpdateUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerDataLoadUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerGridViewUtil;
import com.facebook.photos.simplepicker.nux.SimplePickerNuxManagerProvider;
import com.facebook.photos.simplepicker.view.PickerGridItemView;
import com.facebook.photos.tagging.AutoTaggingHelper;
import com.facebook.photos.tagging.GridTagSuggestRunner;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.photos.thumbnailsource.ThumbnailSourceProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: simple search */
public class LegacySimplePickerFragment extends SimplePickerFragment {
    private C03652 aA;
    private LegacySimplePickerViewControllerProvider aB;
    private LegacySimplePickerGridViewControllerAdapterProvider aC;
    private LegacySimplePickerRecyclerViewControllerAdapterProvider aD;
    public final Handler ay = new MessageHandler();
    public ThumbnailSource az;

    /* compiled from: simple search */
    public class C03641 {
        final /* synthetic */ LegacySimplePickerFragment f2850a;

        C03641(LegacySimplePickerFragment legacySimplePickerFragment) {
            this.f2850a = legacySimplePickerFragment;
        }

        public final void m2918a(MediaItem mediaItem, Bitmap bitmap, int i, BitmapResizingParam bitmapResizingParam) {
            this.f2850a.ay.sendMessage(this.f2850a.ay.obtainMessage(1, new Pair(this.f2850a, new DecodedImage(this.f2850a, mediaItem, bitmap, i, this.f2850a.f2846f, bitmapResizingParam))));
        }
    }

    /* compiled from: simple search */
    public class C03652 {
        final /* synthetic */ LegacySimplePickerFragment f2851a;

        C03652(LegacySimplePickerFragment legacySimplePickerFragment) {
            this.f2851a = legacySimplePickerFragment;
        }

        public final void m2919a(List<MediaItem> list) {
            BitmapResizingParam bitmapResizingParam = new BitmapResizingParam(0, this.f2851a.f2846f, true);
            for (int i = 0; i < list.size(); i++) {
                MediaItem mediaItem = (MediaItem) list.get(i);
                if (mediaItem != null) {
                    this.f2851a.az.m3435a(mediaItem, i, mediaItem.g() == 0 ? bitmapResizingParam : new BitmapResizingParam(mediaItem.g(), this.f2851a.f2846f, true), true);
                }
            }
        }
    }

    /* compiled from: simple search */
    class C03663 implements CameraButtonDelegate {
        final /* synthetic */ LegacySimplePickerFragment f2852a;

        C03663(LegacySimplePickerFragment legacySimplePickerFragment) {
            this.f2852a = legacySimplePickerFragment;
        }

        public final boolean mo133a() {
            return this.f2852a.am || this.f2852a.f2849i;
        }
    }

    /* compiled from: simple search */
    class C03674 implements CursorUpdatedCallback {
        final /* synthetic */ LegacySimplePickerFragment f2853a;

        C03674(LegacySimplePickerFragment legacySimplePickerFragment) {
            this.f2853a = legacySimplePickerFragment;
        }

        public final void mo134a(Cursor cursor) {
            if (this.f2853a.f2841a != null) {
                this.f2853a.f2841a.mo134a(cursor);
            } else {
                this.f2853a.aw = cursor;
            }
        }
    }

    /* compiled from: simple search */
    public class DecodedImage {
        public final MediaItem f2854a;
        public final Bitmap f2855b;
        public final int f2856c;
        public final boolean f2857d;
        public final int f2858e;
        public BitmapResizingParam f2859f;
        final /* synthetic */ LegacySimplePickerFragment f2860g;

        public DecodedImage(LegacySimplePickerFragment legacySimplePickerFragment, MediaItem mediaItem, Bitmap bitmap, int i, int i2, BitmapResizingParam bitmapResizingParam) {
            this.f2860g = legacySimplePickerFragment;
            this.f2854a = mediaItem;
            this.f2855b = bitmap;
            this.f2856c = i;
            this.f2857d = bitmap == null;
            this.f2858e = i2;
            this.f2859f = bitmapResizingParam;
        }
    }

    /* compiled from: simple search */
    class MessageHandler extends Handler {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    LegacySimplePickerViewController legacySimplePickerViewController = (LegacySimplePickerViewController) ((LegacySimplePickerFragment) pair.first).f2841a;
                    if (legacySimplePickerViewController != null) {
                        DecodedImage decodedImage = (DecodedImage) pair.second;
                        for (int e = legacySimplePickerViewController.f2999b.mo153e(); e < legacySimplePickerViewController.f2999b.mo142a(); e++) {
                            PickerGridItemView pickerGridItemView = (PickerGridItemView) legacySimplePickerViewController.f2999b.mo143a(e);
                            if (pickerGridItemView.getMediaItem() == decodedImage.f2854a) {
                                if (decodedImage.f2857d) {
                                    pickerGridItemView.setMediaItemWithFailedDecoding(decodedImage.f2854a);
                                } else {
                                    LegacySimplePickerViewController.m3122a(pickerGridItemView, decodedImage);
                                    if (!ThumbnailSource.m3433a(decodedImage.f2855b, decodedImage.f2858e)) {
                                        BitmapResizingParam bitmapResizingParam;
                                        ThumbnailSource thumbnailSource = legacySimplePickerViewController.f3089c;
                                        MediaItem mediaItem = decodedImage.f2854a;
                                        int i = decodedImage.f2856c;
                                        MediaItem mediaItem2 = decodedImage.f2854a;
                                        if (legacySimplePickerViewController.f3092f == null) {
                                            legacySimplePickerViewController.f3092f = Maps.c();
                                        }
                                        if (legacySimplePickerViewController.f3092f.containsKey(Integer.valueOf(mediaItem2.g()))) {
                                            bitmapResizingParam = (BitmapResizingParam) legacySimplePickerViewController.f3092f.get(Integer.valueOf(mediaItem2.g()));
                                        } else {
                                            bitmapResizingParam = new BitmapResizingParam(mediaItem2.g(), legacySimplePickerViewController.f3091e, false);
                                            legacySimplePickerViewController.f3092f.put(Integer.valueOf(mediaItem2.g()), bitmapResizingParam);
                                        }
                                        thumbnailSource.m3435a(mediaItem, i, bitmapResizingParam, true);
                                    }
                                    legacySimplePickerViewController.f3090d.m2977a(decodedImage.f2854a, false);
                                }
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void m2924a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LegacySimplePickerFragment) obj).m2923a((ThumbnailSourceProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThumbnailSourceProvider.class), (MediaItemsOperator) GridTagSuggestRunner.a(injectorLike), SimplePickerFlowLogger.m2932a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike), IdBasedLazy.a(injectorLike, 9418), IdBasedSingletonScopeProvider.b(injectorLike, 968), AutoTaggingHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 727), (LegacySimplePickerViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacySimplePickerViewControllerProvider.class), (PickerSelectionControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PickerSelectionControllerProvider.class), IdBasedLazy.a(injectorLike, 9423), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 494), (SimplePickerBackgroundTasksControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SimplePickerBackgroundTasksControllerProvider.class), TaggableLocalMediaUtil.a(injectorLike), SimplePickerDataLoadUtil.m3139a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), SimplePickerGridViewUtil.m3142a(injectorLike), IdBasedProvider.a(injectorLike, 4251), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2088), (LegacySimplePickerRecyclerViewControllerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacySimplePickerRecyclerViewControllerAdapterProvider.class), (LegacySimplePickerGridViewControllerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacySimplePickerGridViewControllerAdapterProvider.class), Toaster.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), TagStore.a(injectorLike), FaceBoxStore.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (SimplePickerNuxManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SimplePickerNuxManagerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SouvenirsLogger.a(injectorLike), AllCapsTransformationMethod.a(injectorLike), (CreativeCamLauncher) CreativeCamLauncherImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FramesAggregator.a(injectorLike), MediaItemFactory.a(injectorLike), IdBasedLazy.a(injectorLike, 2090), SlideshowLogger.m10723a(injectorLike));
    }

    public static LegacySimplePickerFragment m2922a(@Nullable Bundle bundle, SimplePickerLauncherConfiguration simplePickerLauncherConfiguration, String str) {
        LegacySimplePickerFragment legacySimplePickerFragment = new LegacySimplePickerFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("extra_simple_picker_launcher_waterfall_id", str);
        bundle.putParcelable("extra_simple_picker_launcher_settings", simplePickerLauncherConfiguration);
        legacySimplePickerFragment.g(bundle);
        return legacySimplePickerFragment;
    }

    @Inject
    private void m2923a(ThumbnailSourceProvider thumbnailSourceProvider, MediaItemsOperator mediaItemsOperator, SimplePickerFlowLogger simplePickerFlowLogger, SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, Lazy<SimpleCamera> lazy, Lazy<SecureContextHelper> lazy2, PrefilledTaggingActivator prefilledTaggingActivator, Provider<TriState> provider, LegacySimplePickerViewControllerProvider legacySimplePickerViewControllerProvider, PickerSelectionControllerProvider pickerSelectionControllerProvider, Lazy<PickerSelectionUpdateUtil> lazy3, Lazy<TasksManager> lazy4, Lazy<FbErrorReporter> lazy5, SimplePickerBackgroundTasksControllerProvider simplePickerBackgroundTasksControllerProvider, TaggableLocalMediaUtil taggableLocalMediaUtil, SimplePickerDataLoadUtil simplePickerDataLoadUtil, ListeningExecutorService listeningExecutorService, SimplePickerGridViewUtil simplePickerGridViewUtil, Provider<Boolean> provider2, FbSharedPreferences fbSharedPreferences, Clock clock, Lazy<SouvenirManager> lazy6, LegacySimplePickerRecyclerViewControllerAdapterProvider legacySimplePickerRecyclerViewControllerAdapterProvider, LegacySimplePickerGridViewControllerAdapterProvider legacySimplePickerGridViewControllerAdapterProvider, Toaster toaster, ComposerLauncher composerLauncher, TagStore tagStore, FaceBoxStore faceBoxStore, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, SimplePickerNuxManagerProvider simplePickerNuxManagerProvider, QeAccessor qeAccessor, SouvenirsLogger souvenirsLogger, AllCapsTransformationMethod allCapsTransformationMethod, CreativeCamLauncher creativeCamLauncher, Boolean bool, ExecutorService executorService, FramesAggregator framesAggregator, MediaItemFactory mediaItemFactory, Lazy<SouvenirsMediaItemsHelper> lazy7, SlideshowLogger slideshowLogger) {
        this.az = thumbnailSourceProvider.m3438a(Integer.valueOf(simplePickerGridViewUtil.m3144a() + 6), Boolean.valueOf(true));
        this.aB = legacySimplePickerViewControllerProvider;
        this.aC = legacySimplePickerGridViewControllerAdapterProvider;
        this.aD = legacySimplePickerRecyclerViewControllerAdapterProvider;
        super.m2906a(mediaItemsOperator, simplePickerFlowLogger, sequenceLogger, interactionTTILogger, lazy, lazy2, prefilledTaggingActivator, provider, pickerSelectionControllerProvider, lazy3, lazy4, lazy5, simplePickerBackgroundTasksControllerProvider, taggableLocalMediaUtil, simplePickerDataLoadUtil, listeningExecutorService, provider2, fbSharedPreferences, clock, lazy6, toaster, composerLauncher, tagStore, faceBoxStore, activityRuntimePermissionsManagerProvider, simplePickerNuxManagerProvider, qeAccessor, souvenirsLogger, allCapsTransformationMethod, creativeCamLauncher, bool, executorService, framesAggregator, mediaItemFactory, lazy7, slideshowLogger);
    }

    public final void mo137c(Bundle bundle) {
        Class cls = LegacySimplePickerFragment.class;
        m2924a(this, getContext());
        super.mo137c(bundle);
        this.az.f3481l = new C03641(this);
        this.aA = new C03652(this);
    }

    public final View mo135a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -140670820);
        View a2 = super.mo135a(layoutInflater, viewGroup, bundle);
        C03817 b = m2908b();
        if (this.ar || this.aq) {
            this.e = this.aD.m3121a(this.ax, a2, this.as, this.az, b, this.f2842b.f().f());
        } else {
            this.e = this.aC.m3080a(a2, this.az, b, this.f2842b.f().f());
        }
        this.f2845e.mo150b(bundle);
        LegacySimplePickerViewControllerProvider legacySimplePickerViewControllerProvider = this.aB;
        PickerSelectionController pickerSelectionController = this.f2843c;
        ThumbnailSource thumbnailSource = this.az;
        if (this.f2842b.f().i()) {
            obj = this.al;
        } else {
            obj = null;
        }
        this.a = legacySimplePickerViewControllerProvider.m3123a(a2, pickerSelectionController, thumbnailSource, b, Optional.fromNullable(obj), getContext(), this.f2845e, this.f2842b.f().d(), this.f2849i, this.f2842b.f().e());
        this.f2841a.m3062a(new C03663(this));
        if (mt_() != null && mt_().containsKey("extra_simple_picker_launcher_waterfall_id")) {
            au();
        }
        LogUtils.f(-951994675, a);
        return a2;
    }

    public final void mo138G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1563378395);
        if (this.f2847g) {
            this.az.m3436a();
            this.av = new HashMap();
        }
        super.mo138G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1396423663, a);
    }

    public final void mo139H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1017211670);
        super.mo139H();
        ThumbnailSource thumbnailSource = this.az;
        for (Future cancel : thumbnailSource.f3480k) {
            cancel.cancel(true);
        }
        thumbnailSource.f3480k.clear();
        thumbnailSource.f3475f.clear();
        thumbnailSource.f3476g.clear();
        thumbnailSource.f3474e.clear();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -443517837, a);
    }

    private void au() {
        this.az.m3436a();
        this.av = new HashMap();
        SimplePickerDataLoadUtil simplePickerDataLoadUtil = this.f2844d;
        getContext();
        simplePickerDataLoadUtil.m3141a(this.f2842b.d.b, this.f2849i, this.aA, new C03674(this), this.f2841a, null);
    }

    protected final void mo136a(String str) {
        SimplePickerDataLoadUtil simplePickerDataLoadUtil = this.f2844d;
        getContext();
        simplePickerDataLoadUtil.m3141a(this.f2842b.d.b, this.f2849i, this.aA, this.f2841a, this.f2841a, str);
    }
}
