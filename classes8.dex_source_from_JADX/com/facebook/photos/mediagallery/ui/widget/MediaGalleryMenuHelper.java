package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.file.FileUtils;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.iolite.Closeables;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Product;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaGalleryMenuOptions;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.negativefeedback.ui.NegativeFeedbackDialogFragment;
import com.facebook.photos.albums.ProfilePicCoverPhotoEditHelper;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEvent;
import com.facebook.photos.mediagallery.MediaGalleryModule.DefaultMediaGalleryMenuOptions;
import com.facebook.photos.mediagallery.MediaMetadataHelper;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.mediagallery.ui.widget.EditCaptionDialog.Factory;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryActionsGenerator.C03271;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryActionsGenerator.C03282;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryActionsGenerator.C03293;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryActionsGenerator.C03304;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryActionsGenerator.C03315;
import com.facebook.photos.mediagallery.util.MediaGalleryPrivacyUtil;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: single_category_fragment */
public class MediaGalleryMenuHelper {
    public static final CallerContext f2781a = CallerContext.a(MediaGalleryMenuHelper.class, "set_cover_photo");
    public static final String f2782b = MediaGalleryMenuHelper.class.getSimpleName();
    public final Provider<String> f2783c;
    public final UriIntentMapper f2784d;
    public final SecureContextHelper f2785e;
    public final TasksManager<Integer> f2786f;
    public final TasksManager<String> f2787g;
    public final MediaMutationGenerator f2788h;
    public final Toaster f2789i;
    public final AbstractFbErrorReporter f2790j;
    private final DefaultMediaGalleryMenuOptions f2791k;
    public final EditPrivacyIntentBuilder f2792l;
    public final Lazy<ConsumptionPhotoEventBus> f2793m;
    public final MediaGalleryPrivacyUtil f2794n;
    public final MediaLogger f2795o;
    public final Lazy<ProfilePicCoverPhotoEditHelper> f2796p;
    public final ActivityRuntimePermissionsManager f2797q;
    public final Provider<Product> f2798r;
    public final FragmentActivity f2799s;
    public final MediaGalleryIntentFactory f2800t;
    public final MediaMetadataHelper f2801u;
    public final ExecutorService f2802v;
    public final Context f2803w;
    public final QeAccessor f2804x;
    public final Factory f2805y;
    public Menu f2806z;

    /* compiled from: single_category_fragment */
    public class Builder {
        public final /* synthetic */ MediaGalleryMenuHelper f2772a;
        public final List<Integer> f2773b = Lists.a();
        public Menu f2774c;
        public FbFragment f2775d;
        public MediaMetadata f2776e;
        @Nullable
        public String f2777f;
        @Nullable
        public String f2778g;
        public C03481 f2779h;
        public MediaGalleryActionsGenerator f2780i;

        /* compiled from: single_category_fragment */
        public class AnonymousClass14 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
            final /* synthetic */ Context f2720a;
            final /* synthetic */ Builder f2721b;

            /* compiled from: single_category_fragment */
            class C03431 extends FbAsyncTask<CloseableReference<CloseableImage>, Void, Uri> {
                final /* synthetic */ AnonymousClass14 f2719a;

                C03431(AnonymousClass14 anonymousClass14) {
                    this.f2719a = anonymousClass14;
                }

                protected final Object m2799a(Object[] objArr) {
                    CloseableReference[] closeableReferenceArr = (CloseableReference[]) objArr;
                    CloseableReference closeableReference = null;
                    try {
                        Bitmap a = ((CloseableBitmap) closeableReferenceArr[0].a()).a();
                        if (a.isRecycled()) {
                            this.f2719a.f2721b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + non-jpeg) bitmap is recycled");
                            CloseableReference.c(closeableReferenceArr[0]);
                            return null;
                        }
                        Object a2 = this.f2719a.f2721b.f2780i.mo130a().m2687a(a, null);
                        return a2;
                    } catch (Throwable e) {
                        this.f2719a.f2721b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + non-jpeg) " + e.getMessage(), e);
                        return closeableReference;
                    } finally {
                        closeableReference = closeableReferenceArr[0];
                        CloseableReference.c(closeableReference);
                    }
                }

                protected void onPostExecute(Object obj) {
                    Uri uri = (Uri) obj;
                    if (uri == null) {
                        this.f2719a.f2721b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + non-jpeg) No temp uri");
                        Builder.m2850q(this.f2719a.f2721b);
                        return;
                    }
                    Builder.m2830a(this.f2719a.f2721b, uri, this.f2719a.f2720a);
                }
            }

            public AnonymousClass14(Builder builder, Context context) {
                this.f2721b = builder;
                this.f2720a = context;
            }

            protected final void m2800e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (dataSource.b()) {
                    CloseableReference closeableReference = (CloseableReference) dataSource.d();
                    if (closeableReference == null || (closeableReference.a() instanceof CloseableBitmap)) {
                        new C03431(this).executeOnExecutor(this.f2721b.f2772a.f2802v, new CloseableReference[]{closeableReference});
                        return;
                    }
                    CloseableReference.c(closeableReference);
                }
            }

            protected final void m2801f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f2721b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + non-jpeg)", dataSource.e());
                Builder.m2850q(this.f2721b);
            }
        }

        /* compiled from: single_category_fragment */
        public class AnonymousClass16 extends AbstractDisposableFutureCallback<DefaultTextWithEntitiesLongFields> {
            final /* synthetic */ MediaMetadata f2724a;
            final /* synthetic */ Builder f2725b;

            public AnonymousClass16(Builder builder, MediaMetadata mediaMetadata) {
                this.f2725b = builder;
                this.f2724a = mediaMetadata;
            }

            protected final void m2805a(Object obj) {
                this.f2725b.f2772a.f2788h.a(this.f2724a.d(), (DefaultTextWithEntitiesLongFields) obj);
            }

            protected final void m2806a(Throwable th) {
                this.f2725b.f2772a.f2790j.b(MediaGalleryMenuHelper.f2782b + "_dialog_failed", th);
            }
        }

        /* compiled from: single_category_fragment */
        public class AnonymousClass17 extends AbstractDisposableFutureCallback<String> {
            final /* synthetic */ MediaMetadata f2728a;
            final /* synthetic */ String f2729b;
            final /* synthetic */ String f2730c;
            final /* synthetic */ Builder f2731d;

            /* compiled from: single_category_fragment */
            class C03451 implements Callable<ListenableFuture<Object>> {
                final /* synthetic */ AnonymousClass17 f2726a;

                C03451(AnonymousClass17 anonymousClass17) {
                    this.f2726a = anonymousClass17;
                }

                public Object call() {
                    return this.f2726a.f2731d.f2772a.f2788h.a(this.f2726a.f2728a.d());
                }
            }

            /* compiled from: single_category_fragment */
            class C03462 extends AbstractDisposableFutureCallback<Object> {
                final /* synthetic */ AnonymousClass17 f2727a;

                C03462(AnonymousClass17 anonymousClass17) {
                    this.f2727a = anonymousClass17;
                }

                protected final void m2807a(Object obj) {
                    ((ConsumptionPhotoEventBus) this.f2727a.f2731d.f2772a.f2793m.get()).a(new DeletePhotoEvent(this.f2727a.f2729b, this.f2727a.f2730c, Long.parseLong(this.f2727a.f2728a.d()), false));
                }

                protected final void m2808a(Throwable th) {
                    this.f2727a.f2731d.f2772a.f2789i.b(new ToastBuilder(2131235622));
                }
            }

            public AnonymousClass17(Builder builder, MediaMetadata mediaMetadata, String str, String str2) {
                this.f2731d = builder;
                this.f2728a = mediaMetadata;
                this.f2729b = str;
                this.f2730c = str2;
            }

            protected final void m2809a(Object obj) {
                this.f2731d.f2772a.f2787g.a(this.f2728a.d(), new C03451(this), new C03462(this));
            }

            protected final void m2810a(Throwable th) {
                this.f2731d.f2772a.f2790j.b(MediaGalleryMenuHelper.f2782b + "_dialog_failed", th);
            }
        }

        /* compiled from: single_category_fragment */
        public class C03481 {
            public final /* synthetic */ Builder f2738a;

            public C03481(Builder builder) {
                this.f2738a = builder;
            }
        }

        /* compiled from: single_category_fragment */
        public class AnonymousClass23 extends AbstractDisposableFutureCallback<Void> {
            final /* synthetic */ MediaMetadata f2744a;
            final /* synthetic */ Builder f2745b;

            /* compiled from: single_category_fragment */
            class C03491 implements Callable<ListenableFuture<OperationResult>> {
                final /* synthetic */ AnonymousClass23 f2742a;

                C03491(AnonymousClass23 anonymousClass23) {
                    this.f2742a = anonymousClass23;
                }

                public Object call() {
                    ImmutableList a = this.f2742a.f2744a.U().a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        if (edgesModel.b() != null && edgesModel.b().c().equals(this.f2742a.f2745b.f2772a.f2783c.get())) {
                            return this.f2742a.f2745b.f2772a.f2788h.a(this.f2742a.f2744a.d(), edgesModel.b());
                        }
                    }
                    throw new IllegalStateException("viewer's tag can't be found in tag list");
                }
            }

            /* compiled from: single_category_fragment */
            class C03502 extends AbstractDisposableFutureCallback<OperationResult> {
                final /* synthetic */ AnonymousClass23 f2743a;

                C03502(AnonymousClass23 anonymousClass23) {
                    this.f2743a = anonymousClass23;
                }

                protected final void m2816a(Object obj) {
                    this.f2743a.f2745b.f2772a.f2795o.b();
                }

                protected final void m2817a(Throwable th) {
                    this.f2743a.f2745b.f2772a.f2795o.c();
                }
            }

            public AnonymousClass23(Builder builder, MediaMetadata mediaMetadata) {
                this.f2745b = builder;
                this.f2744a = mediaMetadata;
            }

            protected final void m2818a(Object obj) {
                this.f2745b.f2772a.f2787g.a(this.f2744a.d(), new C03491(this), new C03502(this));
            }

            protected final void m2819a(Throwable th) {
                this.f2745b.f2772a.f2790j.b(MediaGalleryMenuHelper.f2782b + "_dialog_failed", th);
            }
        }

        public Builder(MediaGalleryMenuHelper mediaGalleryMenuHelper) {
            this.f2772a = mediaGalleryMenuHelper;
        }

        public final Menu m2851a() {
            for (Integer intValue : this.f2773b) {
                switch (intValue.intValue()) {
                    case 2000:
                        m2836d();
                        break;
                    case 2001:
                        m2838e();
                        break;
                    case 2002:
                        m2840f();
                        break;
                    case 2003:
                        m2841g();
                        break;
                    case 2004:
                        m2842h();
                        break;
                    case 2005:
                        m2843i();
                        break;
                    case 2006:
                        m2844j();
                        break;
                    case 2007:
                        m2845k();
                        break;
                    case 2008:
                        m2846l();
                        break;
                    case 2010:
                        m2847m();
                        break;
                    default:
                        break;
                }
            }
            return this.f2774c;
        }

        private void m2836d() {
            this.f2774c.removeItem(2000);
            if (this.f2776e.t()) {
                this.f2775d.getContext();
                m2829a(2000, 2131235658, 2130839815, m2832b(this.f2776e), this.f2774c);
            }
        }

        private void m2838e() {
            Object obj;
            this.f2774c.removeItem(2001);
            if (this.f2776e.s()) {
                MediaMetadataHelper mediaMetadataHelper = this.f2772a.f2801u;
                if (MediaMetadataHelper.a(this.f2776e)) {
                    obj = 1;
                    if (obj == null) {
                        m2829a(2001, 2131235654, 2130840058, m2828a(this.f2775d, this.f2776e), this.f2774c);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                m2829a(2001, 2131235654, 2130840058, m2828a(this.f2775d, this.f2776e), this.f2774c);
            }
        }

        private void m2840f() {
            Object obj;
            this.f2774c.removeItem(2002);
            if (this.f2776e.p()) {
                Object obj2;
                MediaMetadataHelper mediaMetadataHelper = this.f2772a.f2801u;
                MediaMetadata mediaMetadata = this.f2776e;
                if (mediaMetadata.N() == null || Strings.isNullOrEmpty(mediaMetadata.N().c()) || !Objects.equal(mediaMetadata.N().c(), mediaMetadataHelper.a.get())) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    obj = 1;
                    if (obj == null) {
                        m2829a(2002, 2131235650, 2130840013, m2826a(this.f2775d.ao(), this.f2776e), this.f2774c);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                m2829a(2002, 2131235650, 2130840013, m2826a(this.f2775d.ao(), this.f2776e), this.f2774c);
            }
        }

        private void m2841g() {
            this.f2774c.removeItem(2003);
            if (this.f2776e.o()) {
                m2829a(2003, 2131235653, 2130840135, m2827a(this.f2775d.getContext(), this.f2776e, this.f2777f, this.f2778g), this.f2774c);
            }
        }

        private void m2842h() {
            this.f2774c.removeItem(2004);
            if (this.f2776e.q()) {
                m2829a(2004, 2131235648, 2130840097, m2835d(this.f2775d.getContext(), this.f2776e), this.f2774c);
            }
        }

        private void m2843i() {
            this.f2774c.removeItem(2005);
            if (this.f2776e.k() != null) {
                m2829a(2005, 2131235649, 2130840016, m2837e(this.f2775d.getContext(), this.f2776e), this.f2774c);
            }
        }

        private void m2844j() {
            this.f2774c.removeItem(2006);
            if (this.f2776e.q()) {
                m2829a(2006, 2131235656, 2130839834, m2834c(this.f2776e), this.f2774c);
            }
        }

        private void m2845k() {
            Object obj;
            this.f2774c.removeItem(2007);
            if (this.f2776e.r()) {
                MediaMetadataHelper mediaMetadataHelper = this.f2772a.f2801u;
                if (MediaMetadataHelper.a(this.f2776e)) {
                    obj = 1;
                    if (obj == null) {
                        m2829a(2007, 2131235655, 2130840019, m2831b(this.f2775d.getContext(), this.f2776e), this.f2774c);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                m2829a(2007, 2131235655, 2130840019, m2831b(this.f2775d.getContext(), this.f2776e), this.f2774c);
            }
        }

        private void m2846l() {
            Object obj;
            this.f2774c.removeItem(2008);
            if (this.f2776e.w()) {
                Object obj2;
                MediaMetadataHelper mediaMetadataHelper = this.f2772a.f2801u;
                TagInfoQueryModel U = this.f2776e.U();
                if (U == null || U.a() == null) {
                    obj2 = null;
                } else {
                    ImmutableList a = U.a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        NodeModel b = ((EdgesModel) a.get(i)).b();
                        if (b != null && Objects.equal(b.c(), mediaMetadataHelper.a.get())) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    obj = 1;
                    if (obj == null) {
                        m2829a(2008, 2131235659, 2130840849, m2833c(this.f2775d.getContext(), this.f2776e), this.f2774c);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                m2829a(2008, 2131235659, 2130840849, m2833c(this.f2775d.getContext(), this.f2776e), this.f2774c);
            }
        }

        private void m2847m() {
            this.f2774c.removeItem(2010);
            MediaGalleryPrivacyUtil mediaGalleryPrivacyUtil = this.f2772a.f2794n;
            MediaMetadata mediaMetadata = this.f2776e;
            Object obj = 1;
            Preconditions.checkNotNull(mediaMetadata);
            if ((mediaMetadata.R() == null || !mediaMetadata.R().a()) && (mediaMetadata.x() == null || mediaMetadata.x().bl_() == null || !mediaMetadata.x().bl_().a())) {
                obj = null;
            }
            if (obj != null) {
                int i;
                mediaGalleryPrivacyUtil = this.f2772a.f2794n;
                mediaMetadata = this.f2776e;
                Preconditions.checkNotNull(mediaMetadata);
                if (mediaMetadata.R() != null && mediaMetadata.R().a()) {
                    i = 2131235651;
                } else if (mediaMetadata.x() == null || mediaMetadata.x().bl_() == null || !mediaMetadata.x().bl_().a()) {
                    i = 2131235651;
                } else {
                    i = 2131235652;
                }
                m2829a(2010, i, 2130840056, m2839f(this.f2775d.getContext(), this.f2776e), this.f2774c);
            }
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2832b(final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2747b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    NegativeFeedbackDialogFragment.a(mediaMetadata.d(), NegativeFeedbackExperienceLocation.PHOTO_VIEWER.stringValueOf()).a(this.f2747b.f2772a.f2799s.kO_(), "dialog_from_photo_viewer");
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2828a(final FbFragment fbFragment, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2750c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    Intent b;
                    if (this.f2750c.f2772a.f2804x.a(ExperimentsForTimelineAbTestModule.o, false)) {
                        b = this.f2750c.f2772a.f2800t.m2793b(mediaMetadata);
                    } else {
                        b = this.f2750c.f2772a.f2800t.m2792a(mediaMetadata);
                    }
                    this.f2750c.f2772a.f2785e.a(b, 5001, fbFragment);
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2826a(final Context context, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2753c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    TasksManager tasksManager = this.f2753c.f2772a.f2786f;
                    Integer valueOf = Integer.valueOf(2002);
                    Factory factory = this.f2753c.f2772a.f2805y;
                    EditCaptionDialog editCaptionDialog = new EditCaptionDialog((Context) Preconditions.checkNotNull(context));
                    MediaMetadata mediaMetadata = (MediaMetadata) Preconditions.checkNotNull(mediaMetadata);
                    editCaptionDialog.f2587f = SettableFuture.f();
                    if (mediaMetadata == null) {
                        editCaptionDialog.f2584c.setText("");
                    } else {
                        editCaptionDialog.f2584c.setText(MentionsSpannableStringBuilder.a(mediaMetadata.M(), editCaptionDialog.f2585d.getResources(), editCaptionDialog.f2582a));
                    }
                    editCaptionDialog.f2586e = editCaptionDialog.f2584c.getEncodedText();
                    Window window = editCaptionDialog.getWindow();
                    LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.width = -1;
                    window.setAttributes(attributes);
                    editCaptionDialog.show();
                    tasksManager.a(valueOf, editCaptionDialog.f2587f, new AnonymousClass16(this.f2753c, mediaMetadata));
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2827a(Context context, MediaMetadata mediaMetadata, @Nullable String str, @Nullable String str2) {
            final Context context2 = context;
            final MediaMetadata mediaMetadata2 = mediaMetadata;
            final String str3 = str;
            final String str4 = str2;
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2758e;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    int i;
                    boolean z = false;
                    TasksManager tasksManager = this.f2758e.f2772a.f2786f;
                    Integer valueOf = Integer.valueOf(2003);
                    MediaGalleryActionsGenerator mediaGalleryActionsGenerator = this.f2758e.f2780i;
                    Context context = context2;
                    if (mediaMetadata2.I() && this.f2758e.f2772a.f2804x.a(ExperimentsForMediaGalleryAbTestModule.j, false)) {
                        z = true;
                    }
                    SettableFuture f = SettableFuture.f();
                    com.facebook.fbui.dialog.AlertDialog.Builder builder = new com.facebook.fbui.dialog.AlertDialog.Builder(context);
                    if (z) {
                        i = 2131235616;
                    } else {
                        i = 2131235615;
                    }
                    builder = builder.a(i);
                    if (z) {
                        i = 2131235618;
                    } else {
                        i = 2131235617;
                    }
                    builder.b(i).b(2131235620, new C03282(mediaGalleryActionsGenerator, f)).a(2131235619, new C03271(mediaGalleryActionsGenerator, f)).b();
                    tasksManager.a(valueOf, f, new AnonymousClass17(this.f2758e, mediaMetadata2, str3, str4));
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2834c(final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2761b;

                /* compiled from: single_category_fragment */
                class C03551 implements RuntimePermissionsListener {
                    final /* synthetic */ C03566 f2759a;

                    C03551(C03566 c03566) {
                        this.f2759a = c03566;
                    }

                    public final void m2820a() {
                        C03481 c03481 = this.f2759a.f2761b.f2779h;
                        MediaMetadata mediaMetadata = mediaMetadata;
                        c03481.f2738a.f2780i.mo131a(mediaMetadata, c03481.f2738a.m2855c(mediaMetadata.d()), c03481.f2738a.m2853b());
                    }

                    public final void m2821a(String[] strArr, String[] strArr2) {
                        this.f2759a.f2761b.f2772a.f2789i.b(new ToastBuilder(2131235646));
                    }

                    public final void m2822b() {
                        this.f2759a.f2761b.f2772a.f2789i.b(new ToastBuilder(2131235646));
                    }
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f2761b.f2772a.f2797q.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new C03551(this));
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2831b(final Context context, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2764c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    ((ProfilePicCoverPhotoEditHelper) this.f2764c.f2772a.f2796p.get()).a(Long.parseLong(mediaMetadata.d()), (FragmentActivity) ContextUtils.a(context, FragmentActivity.class), Long.parseLong((String) this.f2764c.f2772a.f2783c.get()), new PhotoFetchInfo(FetchCause.USER_INITIATED, MediaGalleryMenuHelper.f2781a));
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2833c(final Context context, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2767c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    TasksManager tasksManager = this.f2767c.f2772a.f2786f;
                    Integer valueOf = Integer.valueOf(2008);
                    MediaGalleryActionsGenerator mediaGalleryActionsGenerator = this.f2767c.f2780i;
                    Context context = context;
                    SettableFuture f = SettableFuture.f();
                    new com.facebook.fbui.dialog.AlertDialog.Builder(context).a(2131235660).b(2131235661).b(2131230727, new C03315(mediaGalleryActionsGenerator, f)).a(new C03304(mediaGalleryActionsGenerator, f)).a(2131230729, new C03293(mediaGalleryActionsGenerator, f)).b();
                    tasksManager.a(valueOf, f, new AnonymousClass23(this.f2767c, mediaMetadata));
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2835d(final Context context, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2771c;

                /* compiled from: single_category_fragment */
                class C03591 implements RuntimePermissionsListener {
                    final /* synthetic */ C03609 f2768a;

                    C03591(C03609 c03609) {
                        this.f2768a = c03609;
                    }

                    public final void m2823a() {
                        C03481 c03481 = this.f2768a.f2771c.f2779h;
                        c03481.f2738a.f2780i.mo132b(mediaMetadata, c03481.f2738a.m2852a(c03481.f2738a.f2772a.f2803w), c03481.f2738a.m2854b(c03481.f2738a.f2772a.f2803w));
                    }

                    public final void m2824a(String[] strArr, String[] strArr2) {
                        this.f2768a.f2771c.f2772a.f2789i.b(new ToastBuilder(2131235646));
                    }

                    public final void m2825b() {
                        this.f2768a.f2771c.f2772a.f2789i.b(new ToastBuilder(2131235646));
                    }
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f2771c.f2772a.f2797q.a(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new C03591(this));
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2837e(final Context context, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2709c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    Intent a = this.f2709c.f2772a.f2784d.a(context, StringFormatUtil.formatStrLocaleSafe(this.f2709c.f2772a.f2798r.get() == Product.PAA ? FBLinks.ae : FBLinks.aL, mediaMetadata.k().c()));
                    if (a != null) {
                        this.f2709c.f2772a.f2785e.a(a, context);
                    }
                    return true;
                }
            };
        }

        @VisibleForTesting
        private OnMenuItemClickListener m2839f(final Context context, final MediaMetadata mediaMetadata) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ Builder f2712c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    MediaGalleryPrivacyUtil mediaGalleryPrivacyUtil = this.f2712c.f2772a.f2794n;
                    MediaMetadata mediaMetadata = mediaMetadata;
                    GraphQLStory graphQLStory = null;
                    if (mediaMetadata != null) {
                        if (mediaMetadata.R() != null && mediaMetadata.z() != null && mediaMetadata.R().a()) {
                            graphQLStory = PhotosMetadataConversionHelper.a(mediaMetadata.z());
                        } else if (!(mediaMetadata.x() == null || mediaMetadata.x().bl_() == null || !mediaMetadata.x().bl_().a())) {
                            graphQLStory = PhotosMetadataConversionHelper.a(mediaMetadata.x());
                        }
                    }
                    GraphQLStory graphQLStory2 = graphQLStory;
                    Preconditions.checkNotNull(graphQLStory2);
                    this.f2712c.f2772a.f2785e.a(this.f2712c.f2772a.f2792l.a(graphQLStory2), context);
                    return true;
                }
            };
        }

        @VisibleForTesting
        public final AbstractDisposableFutureCallback<Uri> m2852a(final Context context) {
            return new AbstractDisposableFutureCallback<Uri>(this) {
                final /* synthetic */ Builder f2714b;

                protected final void m2794a(Object obj) {
                    Builder.m2830a(this.f2714b, (Uri) obj, context);
                }

                protected final void m2795a(Throwable th) {
                    this.f2714b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ legacy) " + th.getMessage(), th);
                    Builder.m2850q(this.f2714b);
                }
            };
        }

        @VisibleForTesting
        public final DataSubscriber<CloseableReference<PooledByteBuffer>> m2854b(final Context context) {
            return new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
                final /* synthetic */ Builder f2718b;

                public final void m2797e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    if (dataSource.b()) {
                        final CloseableReference closeableReference = (CloseableReference) dataSource.d();
                        PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
                        if (ImageFormatChecker.b(pooledByteBufferInputStream) == ImageFormat.JPEG) {
                            pooledByteBufferInputStream.reset();
                            new FbAsyncTask<InputStream, Void, Uri>(this) {
                                final /* synthetic */ AnonymousClass13 f2716b;

                                protected final Object m2796a(Object[] objArr) {
                                    Object obj = null;
                                    InputStream inputStream = ((InputStream[]) objArr)[0];
                                    try {
                                        obj = this.f2716b.f2718b.f2780i.mo130a().m2688a(inputStream, null);
                                    } catch (Throwable e) {
                                        this.f2716b.f2718b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + jpeg) " + e.getMessage(), e);
                                    } finally {
                                        Closeables.a(inputStream);
                                        CloseableReference.c(closeableReference);
                                    }
                                    return obj;
                                }

                                protected void onPostExecute(Object obj) {
                                    Uri uri = (Uri) obj;
                                    if (uri == null) {
                                        this.f2716b.f2718b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + jpeg) No temp uri");
                                        Builder.m2850q(this.f2716b.f2718b);
                                        return;
                                    }
                                    Builder.m2830a(this.f2716b.f2718b, uri, context);
                                }
                            }.executeOnExecutor(this.f2718b.f2772a.f2802v, new InputStream[]{pooledByteBufferInputStream});
                            return;
                        }
                        Closeables.a(pooledByteBufferInputStream);
                        CloseableReference.c(closeableReference);
                        FrescoMediaGalleryActionsGenerator a = this.f2718b.f2780i.mo130a();
                        MediaMetadata mediaMetadata = this.f2718b.f2776e;
                        this.f2718b.m2852a(context);
                        a.m2693b(mediaMetadata, new AnonymousClass14(this.f2718b, context));
                    }
                }

                protected final void m2798f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    this.f2718b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not share file (w/ Fresco + jpeg)", dataSource.e());
                    Builder.m2850q(this.f2718b);
                }
            };
        }

        public static void m2830a(Builder builder, Uri uri, Context context) {
            Preconditions.checkNotNull(uri);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/jpeg");
            intent.putExtra("android.intent.extra.STREAM", uri);
            builder.f2772a.f2785e.b(Intent.createChooser(intent, context.getString(2131235647)), context);
        }

        @VisibleForTesting
        public final DataSubscriber<CloseableReference<PooledByteBuffer>> m2853b() {
            return new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
                final /* synthetic */ Builder f2735a;

                {
                    this.f2735a = r1;
                }

                public final void m2812e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    if (dataSource.b()) {
                        final CloseableReference closeableReference = (CloseableReference) dataSource.d();
                        final PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
                        if (ImageFormatChecker.b(pooledByteBufferInputStream) == ImageFormat.JPEG) {
                            pooledByteBufferInputStream.reset();
                            new FbAsyncTask<InputStream, Void, Uri>(this) {
                                final /* synthetic */ AnonymousClass18 f2734c;

                                protected final Object m2811a(Object[] objArr) {
                                    InputStream inputStream = ((InputStream[]) objArr)[0];
                                    try {
                                        Context context = this.f2734c.f2735a.f2775d.getContext();
                                        if (context == null) {
                                            cancel(true);
                                            return null;
                                        }
                                        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Facebook");
                                        FileUtils.a(file);
                                        Uri a = this.f2734c.f2735a.f2780i.mo130a().m2688a(inputStream, new File(file, StringFormatUtil.formatStrLocaleSafe("%s_%d.jpg", "FB_IMG", Long.valueOf(new Date().getTime()))));
                                        MediaScannerConnection.scanFile(context, new String[]{r5.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
                                        Closeables.a(pooledByteBufferInputStream);
                                        CloseableReference.c(closeableReference);
                                        return a;
                                    } catch (Throwable e) {
                                        this.f2734c.f2735a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + jpeg) " + e.getMessage(), e);
                                    } finally {
                                        Closeables.a(pooledByteBufferInputStream);
                                        CloseableReference.c(closeableReference);
                                    }
                                }

                                protected void onPostExecute(Object obj) {
                                    Uri uri = (Uri) obj;
                                    if (!isCancelled()) {
                                        if (uri == null) {
                                            this.f2734c.f2735a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + jpeg) No temp uri");
                                            Builder.m2849p(this.f2734c.f2735a);
                                            return;
                                        }
                                        Builder.m2848o(this.f2734c.f2735a);
                                    }
                                }
                            }.executeOnExecutor(this.f2735a.f2772a.f2802v, new InputStream[]{pooledByteBufferInputStream});
                            return;
                        }
                        Closeables.a(pooledByteBufferInputStream);
                        CloseableReference.c(closeableReference);
                        FrescoMediaGalleryActionsGenerator a = this.f2735a.f2780i.mo130a();
                        MediaMetadata mediaMetadata = this.f2735a.f2776e;
                        this.f2735a.m2855c(this.f2735a.f2776e.d());
                        a.m2691a(mediaMetadata, (DataSubscriber) new BaseDataSubscriber<CloseableReference<CloseableImage>>(this.f2735a) {
                            final /* synthetic */ Builder f2723a;

                            /* compiled from: single_category_fragment */
                            class C03441 extends FbAsyncTask<CloseableReference<CloseableImage>, Void, Uri> {
                                final /* synthetic */ AnonymousClass15 f2722a;

                                C03441(AnonymousClass15 anonymousClass15) {
                                    this.f2722a = anonymousClass15;
                                }

                                protected final Object m2802a(Object[] objArr) {
                                    CloseableReference[] closeableReferenceArr = (CloseableReference[]) objArr;
                                    CloseableReference closeableReference = null;
                                    try {
                                        Context context = this.f2722a.f2723a.f2775d.getContext();
                                        Bitmap a = ((CloseableBitmap) closeableReferenceArr[0].a()).a();
                                        if (context == null || a.isRecycled()) {
                                            if (a.isRecycled()) {
                                                this.f2722a.f2723a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + non-jpeg) bitmap is recycled");
                                            }
                                            cancel(true);
                                            return closeableReference;
                                        }
                                        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Facebook");
                                        FileUtils.a(file);
                                        Object a2 = this.f2722a.f2723a.f2780i.mo130a().m2687a(a, new File(file, StringFormatUtil.formatStrLocaleSafe("%s_%d.jpg", "FB_IMG", Long.valueOf(new Date().getTime()))));
                                        MediaScannerConnection.scanFile(context, new String[]{r5.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
                                        CloseableReference.c(closeableReferenceArr[0]);
                                        return a2;
                                    } catch (Throwable e) {
                                        this.f2722a.f2723a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + non-jpeg) " + e.getMessage(), e);
                                        return closeableReference;
                                    } finally {
                                        closeableReference = closeableReferenceArr[0];
                                        CloseableReference.c(closeableReference);
                                    }
                                }

                                protected void onPostExecute(Object obj) {
                                    Uri uri = (Uri) obj;
                                    if (!isCancelled()) {
                                        if (uri == null) {
                                            this.f2722a.f2723a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + non-jpeg) No temp uri");
                                            Builder.m2849p(this.f2722a.f2723a);
                                            return;
                                        }
                                        Builder.m2848o(this.f2722a.f2723a);
                                    }
                                }
                            }

                            {
                                this.f2723a = r1;
                            }

                            protected final void m2803e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                if (dataSource.b()) {
                                    CloseableReference closeableReference = (CloseableReference) dataSource.d();
                                    if (closeableReference == null || (closeableReference.a() instanceof CloseableBitmap)) {
                                        new C03441(this).executeOnExecutor(this.f2723a.f2772a.f2802v, new CloseableReference[]{closeableReference});
                                        return;
                                    }
                                    CloseableReference.c(closeableReference);
                                }
                            }

                            protected final void m2804f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                this.f2723a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + non-jpeg)", dataSource.e());
                                Builder.m2849p(this.f2723a);
                            }
                        });
                    }
                }

                public final void m2813f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    this.f2735a.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ Fresco + jpeg)", dataSource.e());
                    Builder.m2849p(this.f2735a);
                }
            };
        }

        public final AbstractDisposableFutureCallback<File> m2855c(final String str) {
            return new AbstractDisposableFutureCallback<File>(this) {
                final /* synthetic */ Builder f2737b;

                protected final void m2814a(Object obj) {
                    this.f2737b.f2772a.f2795o.c(str);
                    Builder.m2848o(this.f2737b);
                }

                protected final void m2815a(Throwable th) {
                    this.f2737b.f2772a.f2790j.a(MediaGalleryMenuHelper.f2782b, "Could not save file (w/ legacy) " + th.getMessage(), th);
                    Builder.m2849p(this.f2737b);
                }
            };
        }

        public static void m2848o(Builder builder) {
            builder.f2772a.f2799s.runOnUiThread(new Runnable(builder) {
                final /* synthetic */ Builder f2739a;

                {
                    this.f2739a = r1;
                }

                public void run() {
                    this.f2739a.f2772a.f2789i.b(new ToastBuilder(2131235614));
                }
            });
        }

        public static void m2849p(Builder builder) {
            builder.f2772a.f2799s.runOnUiThread(new Runnable(builder) {
                final /* synthetic */ Builder f2740a;

                {
                    this.f2740a = r1;
                }

                public void run() {
                    this.f2740a.f2772a.f2789i.b(new ToastBuilder(2131235613));
                }
            });
        }

        public static void m2850q(Builder builder) {
            builder.f2772a.f2799s.runOnUiThread(new Runnable(builder) {
                final /* synthetic */ Builder f2741a;

                {
                    this.f2741a = r1;
                }

                public void run() {
                    this.f2741a.f2772a.f2789i.b(new ToastBuilder(2131235645));
                }
            });
        }

        private static void m2829a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, Menu menu) {
            if (menu.findItem(i) == null) {
                MenuItem add = menu.add(0, i, 0, i2);
                add.setIcon(i3);
                add.setOnMenuItemClickListener(onMenuItemClickListener);
            }
        }
    }

    public static MediaGalleryMenuHelper m2856b(InjectorLike injectorLike) {
        return new MediaGalleryMenuHelper(IdBasedProvider.a(injectorLike, 4443), IdBasedProvider.a(injectorLike, 7304), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TasksManager.a(injectorLike), TasksManager.a(injectorLike), MediaMutationGenerator.a(injectorLike), Toaster.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), EditPrivacyIntentBuilder.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2971), MediaGalleryPrivacyUtil.a(injectorLike), MediaLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 9245), FragmentActivityMethodAutoProvider.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), IdBasedProvider.a(injectorLike, 873), MediaGalleryIntentFactory.m2790a(injectorLike), MediaMetadataHelper.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Factory.m2677a(injectorLike));
    }

    @Inject
    public MediaGalleryMenuHelper(Provider<String> provider, Provider<MediaGalleryMenuOptions> provider2, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, TasksManager tasksManager, TasksManager tasksManager2, MediaMutationGenerator mediaMutationGenerator, Toaster toaster, FbErrorReporter fbErrorReporter, EditPrivacyIntentBuilder editPrivacyIntentBuilder, Lazy<ConsumptionPhotoEventBus> lazy, MediaGalleryPrivacyUtil mediaGalleryPrivacyUtil, MediaLogger mediaLogger, Lazy<ProfilePicCoverPhotoEditHelper> lazy2, FragmentActivity fragmentActivity, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Provider<Product> provider3, MediaGalleryIntentFactory mediaGalleryIntentFactory, MediaMetadataHelper mediaMetadataHelper, ExecutorService executorService, Context context, QeAccessor qeAccessor, Factory factory) {
        this.f2783c = provider;
        this.f2784d = uriIntentMapper;
        this.f2785e = secureContextHelper;
        this.f2786f = tasksManager;
        this.f2787g = tasksManager2;
        this.f2788h = mediaMutationGenerator;
        this.f2789i = toaster;
        this.f2790j = fbErrorReporter;
        this.f2791k = (DefaultMediaGalleryMenuOptions) provider2.get();
        this.f2792l = editPrivacyIntentBuilder;
        this.f2793m = lazy;
        this.f2794n = mediaGalleryPrivacyUtil;
        this.f2795o = mediaLogger;
        this.f2796p = lazy2;
        this.f2799s = fragmentActivity;
        this.f2798r = provider3;
        this.f2797q = activityRuntimePermissionsManagerProvider.a(this.f2799s);
        this.f2800t = mediaGalleryIntentFactory;
        this.f2801u = mediaMetadataHelper;
        this.f2802v = executorService;
        this.f2803w = context;
        this.f2804x = qeAccessor;
        this.f2805y = factory;
    }

    public final void m2857a(FbFragment fbFragment, Menu menu, @Nullable MediaMetadata mediaMetadata, @Nullable String str, @Nullable String str2, MediaGalleryActionsGenerator mediaGalleryActionsGenerator) {
        if (mediaMetadata == null) {
            menu.clear();
            return;
        }
        Builder builder = new Builder(this);
        builder.f2775d = fbFragment;
        builder = builder;
        builder.f2774c = menu;
        builder = builder;
        builder.f2776e = mediaMetadata;
        builder = builder;
        builder.f2777f = str;
        builder = builder;
        builder.f2778g = str2;
        builder = builder;
        builder.f2780i = mediaGalleryActionsGenerator;
        if (builder.f2779h == null) {
            builder.f2779h = new C03481(builder);
        }
        Builder builder2 = builder;
        ImmutableList a = this.f2791k.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            int intValue = ((Integer) a.get(i)).intValue();
            if (!builder2.f2773b.contains(Integer.valueOf(intValue))) {
                builder2.f2773b.add(Integer.valueOf(intValue));
            }
        }
        if (this.f2806z != null) {
            this.f2806z.clear();
        }
        this.f2806z = builder2.m2851a();
    }
}
