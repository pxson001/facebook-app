package com.facebook.timeline.stagingground;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLInterfaces.ImageOverlayWithSwipeableOverlays;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.heisman.swipeable.SwipeableOverlays;
import com.facebook.heisman.swipeable.SwipeableOverlaysRequestFactory;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.Listener;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesCirclePageIndicatorController;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGeneratorImpl;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: facepile */
public class StagingGroundSwipeableController {
    @Inject
    public volatile Provider<GraphQLQueryExecutor> f14886a = UltralightRuntime.a;
    @Inject
    public volatile Provider<SwipeableOverlaysRequestFactory> f14887b = UltralightRuntime.a;
    @Inject
    public CreativeEditingSwipeableControllerProvider f14888c;
    @Inject
    public Provider<SwipeableDraweeControllerGeneratorImpl> f14889d;
    @Inject
    public SwipeableParamsListBuilderProvider f14890e;
    @Inject
    @ForUiThread
    public Executor f14891f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f14892g = UltralightRuntime.b;
    public final CreativeEditingSwipeableLayout f14893h;
    public final SwipeableFramesCirclePageIndicatorController f14894i;
    public final StagingGroundSwipeEventListener f14895j = new StagingGroundSwipeEventListener();
    @Nullable
    public CreativeEditingSwipeableController f14896k;
    @Nullable
    private ImageOverlayFieldsModel f14897l;
    @Nullable
    public ImageOverlayWithSwipeableOverlaysModel f14898m;
    @Nullable
    public ImmutableList<Frame> f14899n;
    @Nullable
    public FutureAndCallbackHolder<ImageOverlayWithSwipeableOverlaysModel> f14900o;
    public boolean f14901p;

    /* compiled from: facepile */
    public class C10932 extends AbstractDisposableFutureCallback<ImageOverlayWithSwipeableOverlaysModel> {
        final /* synthetic */ String f14880a;
        final /* synthetic */ View f14881b;
        final /* synthetic */ StagingGroundSwipeableController f14882c;

        public C10932(StagingGroundSwipeableController stagingGroundSwipeableController, String str, View view) {
            this.f14882c = stagingGroundSwipeableController;
            this.f14880a = str;
            this.f14881b = view;
        }

        protected final void m18751a(Object obj) {
            ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel = (ImageOverlayWithSwipeableOverlaysModel) obj;
            this.f14882c.f14900o = null;
            this.f14882c.f14898m = imageOverlayWithSwipeableOverlaysModel;
            StagingGroundSwipeableController stagingGroundSwipeableController = this.f14882c;
            ImmutableList a = StagingGroundSwipeableController.m18761a(imageOverlayWithSwipeableOverlaysModel, this.f14880a);
            StagingGroundSwipeableController stagingGroundSwipeableController2 = this.f14882c;
            int width = this.f14881b.getWidth();
            int height = this.f14881b.getHeight();
            Preconditions.checkState(stagingGroundSwipeableController2.f14896k != null, "Called appendFrames before setupSwipeableFrames");
            stagingGroundSwipeableController2.f14896k.m11781b(a, new C10943(stagingGroundSwipeableController2, width, height), null);
        }

        protected final void m18752a(Throwable th) {
            this.f14882c.f14900o = null;
            Toast.makeText(this.f14881b.getContext(), this.f14881b.getResources().getString(2131230758), 1).show();
            if (!(th instanceof IOException)) {
                ((AbstractFbErrorReporter) this.f14882c.f14892g.get()).a("timeline_staging_ground", StringFormatUtil.formatStrLocaleSafe("Could not fetch profile pic frames"), th);
            }
        }
    }

    /* compiled from: facepile */
    public class C10943 implements Listener {
        final /* synthetic */ int f14883a;
        final /* synthetic */ int f14884b;
        final /* synthetic */ StagingGroundSwipeableController f14885c;

        public C10943(StagingGroundSwipeableController stagingGroundSwipeableController, int i, int i2) {
            this.f14885c = stagingGroundSwipeableController;
            this.f14883a = i;
            this.f14884b = i2;
        }

        public final void mo509a(FrameModel frameModel) {
            if (!this.f14885c.f14901p) {
                this.f14885c.f14899n = ImmutableList.builder().b(this.f14885c.f14899n).c(frameModel).b();
                this.f14885c.f14894i.m11700a(false, this.f14885c.f14890e.m11726a(this.f14883a, this.f14884b).m11725c(this.f14885c.f14899n).m11724b(), this.f14885c.m18763a().c());
            }
        }
    }

    /* compiled from: facepile */
    class StagingGroundSwipeEventListener implements EventListener {
        public final void mo490a(String str) {
        }

        public final void mo491a(String str, int i) {
        }

        public final void mo493b(String str, int i) {
        }

        public final void mo494c(String str, int i) {
        }

        public final void mo495d(String str, int i) {
        }

        public final void mo496e(String str, int i) {
        }

        public final void mo492a(String str, SwipeableParams swipeableParams, int i) {
        }
    }

    @Inject
    public StagingGroundSwipeableController(@Assisted CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, @Assisted SwipeableFramesHScrollCirclePageIndicator swipeableFramesHScrollCirclePageIndicator) {
        this.f14893h = (CreativeEditingSwipeableLayout) Preconditions.checkNotNull(creativeEditingSwipeableLayout);
        this.f14894i = new SwipeableFramesCirclePageIndicatorController(swipeableFramesHScrollCirclePageIndicator);
    }

    public final void m18764a(@Nullable final ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel, final ImageOverlayFieldsModel imageOverlayFieldsModel, final View view) {
        this.f14897l = imageOverlayFieldsModel;
        this.f14898m = imageOverlayWithSwipeableOverlaysModel;
        view.post(new Runnable(this) {
            final /* synthetic */ StagingGroundSwipeableController f14879d;

            public void run() {
                ImmutableList a;
                StagingGroundSwipeableController stagingGroundSwipeableController = this.f14879d;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                StagingGroundSwipeableController stagingGroundSwipeableController2 = this.f14879d;
                ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel = imageOverlayWithSwipeableOverlaysModel;
                ImageOverlayFieldsModel imageOverlayFieldsModel = imageOverlayFieldsModel;
                if (imageOverlayWithSwipeableOverlaysModel != null) {
                    a = StagingGroundSwipeableController.m18761a(imageOverlayWithSwipeableOverlaysModel, null);
                } else {
                    a = ImmutableList.of(FrameConversions.m8018a(imageOverlayFieldsModel.c(), imageOverlayFieldsModel.d().a()));
                }
                StagingGroundSwipeableController.m18762a(stagingGroundSwipeableController, measuredWidth, measuredHeight, a, imageOverlayFieldsModel.c());
                if (imageOverlayWithSwipeableOverlaysModel == null) {
                    stagingGroundSwipeableController = this.f14879d;
                    View view = view;
                    String c = imageOverlayFieldsModel.c();
                    ListenableFuture a2 = GraphQLQueryExecutor.a(((GraphQLQueryExecutor) stagingGroundSwipeableController.f14886a.get()).a(((SwipeableOverlaysRequestFactory) stagingGroundSwipeableController.f14887b.get()).m8036a(c)));
                    FutureCallback c10932 = new C10932(stagingGroundSwipeableController, c, view);
                    Futures.a(a2, c10932, stagingGroundSwipeableController.f14891f);
                    stagingGroundSwipeableController.f14900o = new FutureAndCallbackHolder(a2, c10932);
                }
            }
        });
    }

    public static ImmutableList<Frame> m18761a(ImageOverlayWithSwipeableOverlays imageOverlayWithSwipeableOverlays, @Nullable String str) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = SwipeableOverlays.m8033a(imageOverlayWithSwipeableOverlays);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) a.get(i);
            if (!Objects.equal(str, imageOverlayFieldsModel.c())) {
                builder.c(FrameConversions.m8018a(imageOverlayFieldsModel.c(), imageOverlayFieldsModel.d().a()));
            }
        }
        return builder.b();
    }

    final void m18765a(Provider<GraphQLQueryExecutor> provider, Provider<SwipeableOverlaysRequestFactory> provider2, CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider, Provider<SwipeableDraweeControllerGeneratorImpl> provider3, SwipeableParamsListBuilderProvider swipeableParamsListBuilderProvider, Executor executor, com.facebook.inject.Lazy<FbErrorReporter> lazy) {
        this.f14886a = provider;
        this.f14887b = provider2;
        this.f14888c = creativeEditingSwipeableControllerProvider;
        this.f14889d = provider3;
        this.f14890e = swipeableParamsListBuilderProvider;
        this.f14891f = executor;
        this.f14892g = lazy;
    }

    public static void m18762a(StagingGroundSwipeableController stagingGroundSwipeableController, int i, int i2, ImmutableList immutableList, String str) {
        LayoutParams layoutParams = stagingGroundSwipeableController.f14893h.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        stagingGroundSwipeableController.f14893h.setLayoutParams(layoutParams);
        stagingGroundSwipeableController.f14893h.requestLayout();
        stagingGroundSwipeableController.f14899n = immutableList;
        ImmutableList b = stagingGroundSwipeableController.f14890e.m11726a(i, i2).m11725c(immutableList).m11724b();
        stagingGroundSwipeableController.f14896k = stagingGroundSwipeableController.f14888c.a(stagingGroundSwipeableController.f14895j, (SwipeableDraweeControllerGeneratorImpl) stagingGroundSwipeableController.f14889d.get(), null, "-1");
        stagingGroundSwipeableController.f14896k.m11774a(stagingGroundSwipeableController.f14893h, i, i2, true);
        stagingGroundSwipeableController.f14896k.m11777a(b, str);
        stagingGroundSwipeableController.f14894i.m11700a(true, b, str);
        stagingGroundSwipeableController.f14896k.m11773a(stagingGroundSwipeableController.f14894i.f9761c);
        stagingGroundSwipeableController.f14896k.m11782b(true);
    }

    public final ImageOverlayFieldsModel m18763a() {
        if (this.f14898m == null || this.f14896k == null) {
            return this.f14897l;
        }
        return SwipeableOverlays.m8032a(this.f14898m, this.f14896k.m11786g());
    }
}
