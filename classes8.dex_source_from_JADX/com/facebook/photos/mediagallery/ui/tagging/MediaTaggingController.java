package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.FrameLayout;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.PhotoTagOnChangeEvent;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.mediagallery.ui.tagging.TaggingStateController.TaggingStateListener;
import com.facebook.photos.tagging.shared.FaceBoxesView;
import com.facebook.photos.tagging.shared.FaceBoxesView.FaceBoxClickListener;
import com.facebook.photos.tagging.shared.TagTypeaheadAdapter.TagTypeaheadAdapterCallback;
import com.facebook.photos.tagging.shared.VignetteOverlay;
import com.facebook.photos.tagging.shared.logging.TaggingAnalyticHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.images.zoomableimageview.SimpleZoomableImageViewListener;
import com.facebook.widget.images.zoomableimageview.ZoomableImageViewListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* compiled from: sms_auto_confirm_failure */
public abstract class MediaTaggingController implements TaggingStateListener {
    @VisibleForTesting
    FaceBoxesView f2448a;
    @VisibleForTesting
    public TagsView f2449b;
    public final TagToFaceBoxMapper f2450c;
    public final MediaMutationGenerator f2451d;
    public final TaggingStateController f2452e;
    public final FrameLayout f2453f;
    public final TaggingIntentControllerProvider f2454g;
    public final Lazy<MediaLogger> f2455h;
    public final TasksManager f2456i;
    public final ConsumptionPhotoEventBus f2457j;
    public final String f2458k;
    public MediaMetadata f2459l;
    public C03002 f2460m;
    public TagTypeaheadDialog f2461n;
    public boolean f2462o;
    public int f2463p;
    public String f2464q;
    public TaggingAnalyticHelper f2465r;

    /* compiled from: sms_auto_confirm_failure */
    class C02971 implements FaceBoxClickListener {
        final /* synthetic */ MediaTaggingController f2495a;

        C02971(MediaTaggingController mediaTaggingController) {
            this.f2495a = mediaTaggingController;
        }

        public final void m2631a(RectF rectF) {
            C03002 c03002 = this.f2495a.f2460m;
            TagToFaceBoxMapper tagToFaceBoxMapper = c03002.f2499a.f2450c;
            Preconditions.checkNotNull(rectF);
            Preconditions.checkNotNull(tagToFaceBoxMapper.f2507d.get(rectF));
            FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) tagToFaceBoxMapper.f2507d.get(rectF);
            TypeaheadController a = c03002.f2499a.mo120a();
            a.m2599a(faceBoxInfoModel, c03002.f2499a.f2450c.m2642a().f());
            MediaTaggingController.m2581o(c03002.f2499a);
            c03002.f2499a.f2461n = TagTypeaheadDialog.m2648a(c03002.f2499a.f2453f.getContext(), a, c03002.f2499a.f2455h, c03002.f2499a.f2451d, c03002.f2499a.f2459l.d(), MediaTaggingController.m2579l(c03002.f2499a), MediaTaggingController.m2582p(c03002.f2499a), c03002.f2499a.f2465r, true);
        }
    }

    /* compiled from: sms_auto_confirm_failure */
    public class C03002 {
        public final /* synthetic */ MediaTaggingController f2499a;

        /* compiled from: sms_auto_confirm_failure */
        public class C02981 implements Callable<ListenableFuture> {
            final /* synthetic */ EdgesModel f2496a;
            final /* synthetic */ C03002 f2497b;

            public C02981(C03002 c03002, EdgesModel edgesModel) {
                this.f2497b = c03002;
                this.f2496a = edgesModel;
            }

            public Object call() {
                return this.f2497b.f2499a.f2451d.a(this.f2497b.f2499a.f2459l.d(), this.f2496a.b());
            }
        }

        /* compiled from: sms_auto_confirm_failure */
        public class C02992 extends AbstractDisposableFutureCallback<OperationResult> {
            final /* synthetic */ C03002 f2498a;

            public C02992(C03002 c03002) {
                this.f2498a = c03002;
            }

            protected final void m2632a(Object obj) {
                this.f2498a.f2499a.f2457j.a(new PhotoTagOnChangeEvent());
            }

            protected final void m2633a(Throwable th) {
            }
        }

        C03002(MediaTaggingController mediaTaggingController) {
            this.f2499a = mediaTaggingController;
        }
    }

    /* compiled from: sms_auto_confirm_failure */
    class C03013 extends SimpleZoomableImageViewListener {
        final /* synthetic */ MediaTaggingController f2500a;

        C03013(MediaTaggingController mediaTaggingController) {
            this.f2500a = mediaTaggingController;
        }

        public final void m2634a(Matrix matrix) {
            if (this.f2500a.mo122c() && this.f2500a.f2462o) {
                this.f2500a.f2462o = false;
                MediaTaggingController.m2574b(this.f2500a, false);
            } else if (this.f2500a.f2449b.getVisibility() == 0) {
                this.f2500a.mo121b();
            }
            if (this.f2500a.f2461n != null && this.f2500a.f2461n.isShowing()) {
                TagTypeaheadDialog tagTypeaheadDialog = this.f2500a.f2461n;
                if (tagTypeaheadDialog.f2521g.isPresent()) {
                    ((VignetteOverlay) tagTypeaheadDialog.f2521g.get()).setTransformMatrix(matrix);
                }
            }
        }

        public final void m2635a(PointF pointF, @Nullable PointF pointF2) {
            if (this.f2500a.f2452e.f2565c && pointF2 != null) {
                this.f2500a.f2449b.m2672a();
                if (!this.f2500a.f2448a.a(pointF)) {
                    MediaTaggingController.m2573a(this.f2500a, pointF2);
                }
            }
        }

        public final void m2636b(PointF pointF, @Nullable PointF pointF2) {
            super.b(pointF, pointF2);
            if (this.f2500a.f2452e.f2565c && pointF2 != null) {
                MediaTaggingController.m2573a(this.f2500a, pointF2);
            }
        }
    }

    /* compiled from: sms_auto_confirm_failure */
    public class C03024 {
        public final /* synthetic */ MediaTaggingController f2501a;

        C03024(MediaTaggingController mediaTaggingController) {
            this.f2501a = mediaTaggingController;
        }
    }

    /* compiled from: sms_auto_confirm_failure */
    public class C03035 implements Runnable {
        final /* synthetic */ MediaTaggingController f2502a;

        public C03035(MediaTaggingController mediaTaggingController) {
            this.f2502a = mediaTaggingController;
        }

        public void run() {
            this.f2502a.mo121b();
        }
    }

    /* compiled from: sms_auto_confirm_failure */
    class C03046 implements TagTypeaheadAdapterCallback {
        final /* synthetic */ MediaTaggingController f2503a;

        C03046(MediaTaggingController mediaTaggingController) {
            this.f2503a = mediaTaggingController;
        }

        public final boolean m2637a(String str) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
            if (this.f2503a.f2459l == null || this.f2503a.f2459l.U() == null || this.f2503a.f2459l.U().a() == null || this.f2503a.f2459l.U().a().isEmpty()) {
                return false;
            }
            ImmutableList a = this.f2503a.f2459l.U().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (((EdgesModel) a.get(i)).b().c().equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean m2638b(String str) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
            if (this.f2503a.f2459l == null || this.f2503a.f2459l.U() == null || this.f2503a.f2459l.U().a() == null) {
                return false;
            }
            ImmutableList a = this.f2503a.f2459l.U().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (edgesModel.b().b() != null && edgesModel.b().b().g() == -776825814 && edgesModel.b().d().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public abstract TypeaheadController mo120a();

    abstract void mo121b();

    abstract boolean mo122c();

    public MediaTaggingController(FrameLayout frameLayout, TagToFaceBoxMapper tagToFaceBoxMapper, int i, String str, String str2, TaggingStateController taggingStateController, MediaMutationGenerator mediaMutationGenerator, TagsViewProvider tagsViewProvider, TaggingIntentControllerProvider taggingIntentControllerProvider, Lazy<MediaLogger> lazy, TasksManager tasksManager, ConsumptionPhotoEventBus consumptionPhotoEventBus, TaggingAnalyticHelper taggingAnalyticHelper) {
        this.f2450c = tagToFaceBoxMapper;
        this.f2451d = mediaMutationGenerator;
        this.f2452e = taggingStateController;
        this.f2453f = frameLayout;
        this.f2460m = m2578k();
        this.f2448a = new FaceBoxesView(this.f2453f.getContext());
        this.f2448a.i = m2577j();
        this.f2449b = tagsViewProvider.m2674a(this.f2453f.getContext(), this.f2460m);
        this.f2452e.m2667a((TaggingStateListener) this);
        this.f2454g = taggingIntentControllerProvider;
        this.f2455h = lazy;
        this.f2456i = tasksManager;
        this.f2458k = str2;
        this.f2457j = consumptionPhotoEventBus;
        if (this.f2452e.m2669b()) {
            this.f2453f.addView(this.f2448a);
            this.f2453f.addView(this.f2449b);
        }
        this.f2464q = str;
        this.f2463p = i;
        this.f2465r = taggingAnalyticHelper;
    }

    public final void m2584a(MediaMetadata mediaMetadata) {
        int i;
        Preconditions.checkNotNull(mediaMetadata);
        Object obj = null;
        if (this.f2459l == null) {
            obj = 1;
        } else if (this.f2459l.B() != null || mediaMetadata.B() != null) {
            int i2;
            if (this.f2459l.B() == null || mediaMetadata.B() == null) {
                i2 = 1;
            } else if (this.f2459l.B().a().size() != mediaMetadata.B().a().size()) {
                i2 = 1;
            } else {
                for (i = 0; i < this.f2459l.B().a().size(); i++) {
                    if (!((FaceBoxInfoModel) this.f2459l.B().a().get(i)).d().equals(((FaceBoxInfoModel) mediaMetadata.B().a().get(i)).d())) {
                        i2 = 1;
                        break;
                    }
                }
            }
        }
        Object obj2 = obj;
        Object obj3 = null;
        if (this.f2459l == null) {
            obj3 = 1;
        } else if (this.f2459l.U() != null || mediaMetadata.U() != null) {
            if (this.f2459l.U() == null || mediaMetadata.U() == null) {
                i = 1;
            } else if (this.f2459l.U().a().size() != mediaMetadata.U().a().size()) {
                i = 1;
            } else {
                for (int i3 = 0; i3 < this.f2459l.U().a().size(); i3++) {
                    if (!((EdgesModel) this.f2459l.U().a().get(i3)).b().c().equals(((EdgesModel) mediaMetadata.U().a().get(i3)).b().c())) {
                        i = 1;
                        break;
                    }
                }
            }
        }
        Object obj4 = obj3;
        boolean d = m2575d(mediaMetadata);
        this.f2459l = mediaMetadata;
        if (obj4 != null || obj2 != null || d) {
            this.f2450c.m2643a(mediaMetadata);
            if (this.f2461n != null) {
                this.f2461n.m2653a(mediaMetadata);
            }
            if (this.f2452e.f2565c) {
                m2580m();
                m2574b(this, true);
            }
        }
    }

    public final void m2588g() {
        this.f2452e.m2668b((TaggingStateListener) this);
        this.f2456i.c();
    }

    public final void mo119a(boolean z) {
        if (z) {
            m2580m();
            m2574b(this, true);
            return;
        }
        m2581o(this);
    }

    private boolean m2575d(MediaMetadata mediaMetadata) {
        if (this.f2459l == null || !m2576e(mediaMetadata)) {
            return false;
        }
        for (int i = 0; i < mediaMetadata.B().a().size(); i++) {
            FaceBoxInfoModel faceBoxInfoModel;
            FaceBoxInfoModel faceBoxInfoModel2 = (FaceBoxInfoModel) mediaMetadata.B().a().get(i);
            MediaMetadata mediaMetadata2 = this.f2459l;
            String d = faceBoxInfoModel2.d();
            int i2 = 0;
            Preconditions.checkArgument(!Strings.isNullOrEmpty(d));
            if (m2576e(mediaMetadata2)) {
                ImmutableList a = mediaMetadata2.B().a();
                int size = a.size();
                while (i2 < size) {
                    faceBoxInfoModel = (FaceBoxInfoModel) a.get(i2);
                    if (faceBoxInfoModel.d().equals(d)) {
                        break;
                    }
                    i2++;
                }
                faceBoxInfoModel = null;
            } else {
                faceBoxInfoModel = null;
            }
            FaceBoxInfoModel faceBoxInfoModel3 = faceBoxInfoModel;
            if (faceBoxInfoModel3 == null) {
                return true;
            }
            if (faceBoxInfoModel3.bf_() != null || faceBoxInfoModel2.bf_() != null) {
                if (faceBoxInfoModel2.bf_() == null || faceBoxInfoModel3.bf_() == null) {
                    return true;
                }
                if (faceBoxInfoModel2.bf_().a().size() != faceBoxInfoModel3.bf_().a().size()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m2576e(MediaMetadata mediaMetadata) {
        return (mediaMetadata == null || mediaMetadata.B() == null || mediaMetadata.B().a() == null || mediaMetadata.B().a().isEmpty()) ? false : true;
    }

    private FaceBoxClickListener m2577j() {
        return new C02971(this);
    }

    private C03002 m2578k() {
        return new C03002(this);
    }

    public final void m2589h() {
        if (this.f2461n != null && this.f2461n.isShowing()) {
            this.f2461n.dismiss();
        }
    }

    final ZoomableImageViewListener m2590i() {
        return new C03013(this);
    }

    public static void m2573a(MediaTaggingController mediaTaggingController, PointF pointF) {
        TypeaheadController a = mediaTaggingController.mo120a();
        a.m2598a(pointF);
        mediaTaggingController.f2461n = TagTypeaheadDialog.m2648a(mediaTaggingController.f2453f.getContext(), a, mediaTaggingController.f2455h, mediaTaggingController.f2451d, mediaTaggingController.f2459l.d(), m2579l(mediaTaggingController), m2582p(mediaTaggingController), mediaTaggingController.f2465r, false);
    }

    public static C03024 m2579l(MediaTaggingController mediaTaggingController) {
        return new C03024(mediaTaggingController);
    }

    private void m2580m() {
        this.f2449b.m2673a(ImmutableList.copyOf(this.f2450c.f2506c), this.f2450c.m2642a().keySet(), ImmutableBiMap.a(this.f2450c.f2508e));
        this.f2448a.setFaceBoxes(this.f2450c.m2642a().keySet());
    }

    public static void m2574b(MediaTaggingController mediaTaggingController, boolean z) {
        if (!mediaTaggingController.mo122c()) {
            mediaTaggingController.f2462o = true;
        } else if (mediaTaggingController.f2461n == null) {
            mediaTaggingController.f2448a.setVisibility(0);
            mediaTaggingController.f2449b.setVisibility(0);
            if (z) {
                GlobalOnLayoutHelper.c(mediaTaggingController.f2449b, new C03035(mediaTaggingController));
            } else {
                mediaTaggingController.mo121b();
            }
        }
    }

    public static void m2581o(MediaTaggingController mediaTaggingController) {
        mediaTaggingController.f2448a.setVisibility(8);
        mediaTaggingController.f2449b.setVisibility(8);
    }

    public static TagTypeaheadAdapterCallback m2582p(MediaTaggingController mediaTaggingController) {
        return new C03046(mediaTaggingController);
    }
}
