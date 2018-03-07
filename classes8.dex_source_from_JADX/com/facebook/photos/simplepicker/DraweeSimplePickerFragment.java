package com.facebook.photos.simplepicker;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.facebook.photos.simplepicker.controller.DraweeSimplePickerGridViewControllerAdapterProvider;
import com.facebook.photos.simplepicker.controller.DraweeSimplePickerRecyclerViewControllerAdapterProvider;
import com.facebook.photos.simplepicker.controller.DraweeSimplePickerViewControllerProvider;
import com.facebook.photos.simplepicker.controller.PickerSelectionController;
import com.facebook.photos.simplepicker.controller.PickerSelectionControllerProvider;
import com.facebook.photos.simplepicker.controller.PickerSelectionUpdateUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerDataLoadUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerGridViewUtil;
import com.facebook.photos.simplepicker.nux.SimplePickerNuxManagerProvider;
import com.facebook.photos.tagging.AutoTaggingHelper;
import com.facebook.photos.tagging.GridTagSuggestRunner;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
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
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: simple_search */
public class DraweeSimplePickerFragment extends SimplePickerFragment {
    private DraweeSimplePickerRecyclerViewControllerAdapterProvider aA;
    private DraweeSimplePickerViewControllerProvider ay;
    private DraweeSimplePickerGridViewControllerAdapterProvider az;

    /* compiled from: simple_search */
    class C03621 implements CameraButtonDelegate {
        final /* synthetic */ DraweeSimplePickerFragment f2839a;

        C03621(DraweeSimplePickerFragment draweeSimplePickerFragment) {
            this.f2839a = draweeSimplePickerFragment;
        }

        public final boolean mo133a() {
            return this.f2839a.am;
        }
    }

    /* compiled from: simple_search */
    class C03632 implements CursorUpdatedCallback {
        final /* synthetic */ DraweeSimplePickerFragment f2840a;

        C03632(DraweeSimplePickerFragment draweeSimplePickerFragment) {
            this.f2840a = draweeSimplePickerFragment;
        }

        public final void mo134a(Cursor cursor) {
            if (this.f2840a.f2841a != null) {
                this.f2840a.f2841a.mo134a(cursor);
            } else {
                this.f2840a.aw = cursor;
            }
        }
    }

    public static void m2914a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DraweeSimplePickerFragment) obj).m2913a((MediaItemsOperator) GridTagSuggestRunner.a(injectorLike), SimplePickerFlowLogger.m2932a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike), IdBasedLazy.a(injectorLike, 9418), IdBasedSingletonScopeProvider.b(injectorLike, 968), AutoTaggingHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 727), (DraweeSimplePickerViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DraweeSimplePickerViewControllerProvider.class), (PickerSelectionControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PickerSelectionControllerProvider.class), IdBasedLazy.a(injectorLike, 9423), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 494), (SimplePickerBackgroundTasksControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SimplePickerBackgroundTasksControllerProvider.class), TaggableLocalMediaUtil.a(injectorLike), SimplePickerDataLoadUtil.m3139a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), SimplePickerGridViewUtil.m3142a(injectorLike), IdBasedProvider.a(injectorLike, 4251), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2088), (DraweeSimplePickerRecyclerViewControllerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DraweeSimplePickerRecyclerViewControllerAdapterProvider.class), (DraweeSimplePickerGridViewControllerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DraweeSimplePickerGridViewControllerAdapterProvider.class), Toaster.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), TagStore.a(injectorLike), FaceBoxStore.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (SimplePickerNuxManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SimplePickerNuxManagerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SouvenirsLogger.a(injectorLike), AllCapsTransformationMethod.a(injectorLike), (CreativeCamLauncher) CreativeCamLauncherImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FramesAggregator.a(injectorLike), MediaItemFactory.a(injectorLike), IdBasedLazy.a(injectorLike, 2090), SlideshowLogger.m10723a(injectorLike));
    }

    public static DraweeSimplePickerFragment m2912a(@Nullable Bundle bundle, SimplePickerLauncherConfiguration simplePickerLauncherConfiguration, String str) {
        DraweeSimplePickerFragment draweeSimplePickerFragment = new DraweeSimplePickerFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("extra_simple_picker_launcher_waterfall_id", str);
        bundle.putParcelable("extra_simple_picker_launcher_settings", simplePickerLauncherConfiguration);
        draweeSimplePickerFragment.g(bundle);
        return draweeSimplePickerFragment;
    }

    @Inject
    private void m2913a(MediaItemsOperator mediaItemsOperator, SimplePickerFlowLogger simplePickerFlowLogger, SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, Lazy<SimpleCamera> lazy, Lazy<SecureContextHelper> lazy2, PrefilledTaggingActivator prefilledTaggingActivator, Provider<TriState> provider, DraweeSimplePickerViewControllerProvider draweeSimplePickerViewControllerProvider, PickerSelectionControllerProvider pickerSelectionControllerProvider, Lazy<PickerSelectionUpdateUtil> lazy3, Lazy<TasksManager> lazy4, Lazy<FbErrorReporter> lazy5, SimplePickerBackgroundTasksControllerProvider simplePickerBackgroundTasksControllerProvider, TaggableLocalMediaUtil taggableLocalMediaUtil, SimplePickerDataLoadUtil simplePickerDataLoadUtil, ListeningExecutorService listeningExecutorService, SimplePickerGridViewUtil simplePickerGridViewUtil, Provider<Boolean> provider2, FbSharedPreferences fbSharedPreferences, Clock clock, Lazy<SouvenirManager> lazy6, DraweeSimplePickerRecyclerViewControllerAdapterProvider draweeSimplePickerRecyclerViewControllerAdapterProvider, DraweeSimplePickerGridViewControllerAdapterProvider draweeSimplePickerGridViewControllerAdapterProvider, Toaster toaster, ComposerLauncher composerLauncher, TagStore tagStore, FaceBoxStore faceBoxStore, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, SimplePickerNuxManagerProvider simplePickerNuxManagerProvider, QeAccessor qeAccessor, SouvenirsLogger souvenirsLogger, AllCapsTransformationMethod allCapsTransformationMethod, CreativeCamLauncher creativeCamLauncher, Boolean bool, ExecutorService executorService, FramesAggregator framesAggregator, MediaItemFactory mediaItemFactory, Lazy<SouvenirsMediaItemsHelper> lazy7, SlideshowLogger slideshowLogger) {
        super.m2906a(mediaItemsOperator, simplePickerFlowLogger, sequenceLogger, interactionTTILogger, lazy, lazy2, prefilledTaggingActivator, provider, pickerSelectionControllerProvider, lazy3, lazy4, lazy5, simplePickerBackgroundTasksControllerProvider, taggableLocalMediaUtil, simplePickerDataLoadUtil, listeningExecutorService, provider2, fbSharedPreferences, clock, lazy6, toaster, composerLauncher, tagStore, faceBoxStore, activityRuntimePermissionsManagerProvider, simplePickerNuxManagerProvider, qeAccessor, souvenirsLogger, allCapsTransformationMethod, creativeCamLauncher, bool, executorService, framesAggregator, mediaItemFactory, lazy7, slideshowLogger);
        this.ay = draweeSimplePickerViewControllerProvider;
        this.az = draweeSimplePickerGridViewControllerAdapterProvider;
        this.aA = draweeSimplePickerRecyclerViewControllerAdapterProvider;
    }

    public final void mo137c(Bundle bundle) {
        Class cls = DraweeSimplePickerFragment.class;
        m2914a(this, getContext());
        super.mo137c(bundle);
    }

    public final View mo135a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1956265483);
        View a2 = super.mo135a(layoutInflater, viewGroup, bundle);
        C03817 b = m2908b();
        if (this.ar || this.aq) {
            this.e = this.aA.m3059a(this.ax, a2, this.as, b, this.f2842b.f().f());
        } else {
            this.e = this.az.m3020a(a2, b, this.f2842b.f().f());
        }
        this.f2845e.mo150b(bundle);
        DraweeSimplePickerViewControllerProvider draweeSimplePickerViewControllerProvider = this.ay;
        PickerSelectionController pickerSelectionController = this.f2843c;
        if (this.f2842b.f().i()) {
            obj = this.al;
        } else {
            obj = null;
        }
        this.a = draweeSimplePickerViewControllerProvider.m3065a(a2, pickerSelectionController, Optional.fromNullable(obj), getContext(), this.f2845e, this.f2842b.f().d(), this.f2849i, this.f2842b.f().e());
        this.f2841a.f3009l = new C03621(this);
        if (mt_() != null && mt_().containsKey("extra_simple_picker_launcher_waterfall_id")) {
            this.av = new HashMap();
            SimplePickerDataLoadUtil simplePickerDataLoadUtil = this.f2844d;
            getContext();
            simplePickerDataLoadUtil.m3141a(this.f2842b.f().g(), this.f2849i, null, new C03632(this), this.f2841a, null);
        }
        LogUtils.f(2105852904, a);
        return a2;
    }

    protected final void mo136a(String str) {
        SimplePickerDataLoadUtil simplePickerDataLoadUtil = this.f2844d;
        getContext();
        simplePickerDataLoadUtil.m3141a(this.f2842b.d.b, this.f2849i, null, this.f2841a, this.f2841a, str);
    }
}
