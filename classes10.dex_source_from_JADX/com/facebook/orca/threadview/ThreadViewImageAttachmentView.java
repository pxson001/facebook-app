package com.facebook.orca.threadview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentData.Orientation;
import com.facebook.messaging.attachments.ImageAttachmentUris;
import com.facebook.messaging.media.download.MediaDownloadServiceHandler;
import com.facebook.messaging.media.download.PhotoDownloadDestination;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper;
import com.facebook.messaging.media.prefetch.ThreadViewImageUriGetter;
import com.facebook.messaging.media.retry.MediaRetryQueue;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photos.size.IsAttachmentSizeControlEnabled;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.minipreview.MiniPreviewCoverPhotoProcessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: message is a payment message */
public class ThreadViewImageAttachmentView extends CustomViewGroup {
    public static final Class<?> f7560p;
    private static final CallerContext f7561q;
    private int f7562A;
    public boolean f7563B;
    public boolean f7564C;
    private Message f7565D;
    public boolean f7566E;
    private ImmutableList<ImageAttachmentData> f7567F;
    private int f7568G;
    private int f7569H;
    private int f7570I;
    private Point[] f7571J;
    private ThreadImageClickListener f7572K;
    @Inject
    AttachmentDataFactory f7573a;
    @Inject
    MediaSizeUtil f7574b;
    @Inject
    LayoutInflater f7575c;
    @Inject
    FbDraweeControllerBuilder f7576d;
    @Inject
    GatekeeperStoreImpl f7577e;
    @Inject
    Lazy<MediaDownloadServiceHandler> f7578f;
    @Inject
    MessageUtil f7579g;
    @Inject
    @IsAttachmentSizeControlEnabled
    Provider<Boolean> f7580h;
    @Inject
    ThreadViewLowDataModeUtils f7581i;
    @Inject
    MiniPreviewCoverPhotoProcessor f7582j;
    @Inject
    @ForUiThreadImmediate
    Executor f7583k;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f7584l;
    @ForNonUiThread
    @Inject
    ExecutorService f7585m;
    @Inject
    ImagePipelineWrapper f7586n;
    @Inject
    MediaRetryQueue f7587o;
    private final SparseArray<ImageRequest> f7588r;
    private ImageView f7589s;
    private Drawable f7590t;
    @Nullable
    private RoundedCornerOverlayDrawable f7591u;
    private int f7592v;
    private int f7593w;
    private int f7594x;
    private int f7595y;
    private int f7596z;

    /* compiled from: message is a payment message */
    class ImageFetchInfo {
        List<ImageRequest> f7557a;
        ImageRequest f7558b;
        boolean f7559c;

        public ImageFetchInfo() {
            this.f7557a = new ArrayList();
        }
    }

    private static <T extends View> void m7300a(Class<T> cls, T t) {
        m7301a((Object) t, t.getContext());
    }

    private static void m7301a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadViewImageAttachmentView) obj).m7298a(AttachmentDataFactory.a(injectorLike), MediaSizeUtil.a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 7909), MessageUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4188), ThreadViewLowDataModeUtils.m7358a(injectorLike), MiniPreviewCoverPhotoProcessor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), ImagePipelineWrapper.a(injectorLike), MediaRetryQueue.m3144a(injectorLike));
    }

    private void m7298a(AttachmentDataFactory attachmentDataFactory, MediaSizeUtil mediaSizeUtil, LayoutInflater layoutInflater, FbDraweeControllerBuilder fbDraweeControllerBuilder, GatekeeperStore gatekeeperStore, Lazy<MediaDownloadServiceHandler> lazy, MessageUtil messageUtil, Provider<Boolean> provider, ThreadViewLowDataModeUtils threadViewLowDataModeUtils, MiniPreviewCoverPhotoProcessor miniPreviewCoverPhotoProcessor, Executor executor, ListeningExecutorService listeningExecutorService, ExecutorService executorService, ImagePipelineWrapper imagePipelineWrapper, MediaRetryQueue mediaRetryQueue) {
        this.f7573a = attachmentDataFactory;
        this.f7574b = mediaSizeUtil;
        this.f7575c = layoutInflater;
        this.f7576d = fbDraweeControllerBuilder;
        this.f7577e = gatekeeperStore;
        this.f7578f = lazy;
        this.f7579g = messageUtil;
        this.f7580h = provider;
        this.f7581i = threadViewLowDataModeUtils;
        this.f7582j = miniPreviewCoverPhotoProcessor;
        this.f7583k = executor;
        this.f7584l = listeningExecutorService;
        this.f7585m = executorService;
        this.f7586n = imagePipelineWrapper;
        this.f7587o = mediaRetryQueue;
    }

    static {
        Class cls = ThreadViewImageAttachmentView.class;
        f7560p = cls;
        f7561q = CallerContext.a(cls, "photo_thread_view", "photo_thread_view".toString());
    }

    public ThreadViewImageAttachmentView(Context context) {
        this(context, null);
    }

    public ThreadViewImageAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadViewImageAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7588r = new SparseArray();
        m7296a(context);
    }

    private void m7296a(Context context) {
        m7300a(ThreadViewImageAttachmentView.class, (View) this);
        this.f7592v = SizeUtil.a(context, 1.0f);
        this.f7593w = this.f7574b.a();
        this.f7594x = this.f7574b.b();
        this.f7595y = this.f7574b.c();
        this.f7596z = this.f7574b.d();
        this.f7562A = this.f7574b.e();
        this.f7563B = this.f7581i.m7360a();
        setContentView(2130905891);
        this.f7589s = (ImageView) getView(2131565213);
        this.f7591u = new RoundedCornerOverlayDrawable();
        this.f7591u.c(getResources().getDimensionPixelSize(2131428585));
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(2131428581);
        this.f7591u.a(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public void setNeedsUserRequestToLoad(boolean z) {
        boolean z2 = z && this.f7581i.m7360a();
        this.f7563B = z2;
    }

    public final boolean m7316a() {
        return this.f7563B;
    }

    public void setShowAsCircle(boolean z) {
        this.f7564C = z;
    }

    public Message getMessage() {
        return this.f7565D;
    }

    public void setMessage(Message message) {
        this.f7565D = message;
        this.f7567F = this.f7573a.f(message);
        m7308c();
    }

    public void setShowForMeUser(boolean z) {
        this.f7566E = z;
    }

    public final void m7315a(final ThreadImageClickListener threadImageClickListener) {
        if (threadImageClickListener != null && !this.f7563B) {
            this.f7572K = threadImageClickListener;
            for (int i = 0; i < this.f7567F.size(); i++) {
                DraweeView b = m7306b(i);
                final ImageAttachmentData imageAttachmentData = (ImageAttachmentData) this.f7567F.get(i);
                b.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ ThreadViewImageAttachmentView f7540c;

                    public boolean onLongClick(View view) {
                        threadImageClickListener.mo243b(imageAttachmentData);
                        return true;
                    }
                });
                b.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ThreadViewImageAttachmentView f7543c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1407488479);
                        threadImageClickListener.mo242a(imageAttachmentData);
                        Logger.a(2, EntryType.UI_INPUT_END, -618697974, a);
                    }
                });
            }
        }
    }

    private void m7308c() {
        int i = 0;
        m7310d();
        this.f7571J = getImageDimensions();
        while (this.f7568G < this.f7567F.size()) {
            boolean z;
            DraweeView draweeView = (DraweeView) this.f7575c.inflate(2130905890, this, false);
            if (this.f7563B) {
                z = false;
            } else {
                z = true;
            }
            draweeView.setClickable(z);
            addView(draweeView, this.f7568G);
            this.f7568G++;
        }
        while (i < this.f7568G && i < this.f7567F.size()) {
            m7292a(i);
            i++;
        }
        while (i < this.f7568G) {
            getChildAt(i).setVisibility(8);
            i++;
        }
        if (!this.f7563B) {
            m7315a(this.f7572K);
        }
        requestLayout();
    }

    private GenericDraweeHierarchy m7286a(boolean z) {
        Drawable colorDrawable = new ColorDrawable(getResources().getColor(2131362420));
        Drawable drawable = getResources().getDrawable(2130842340);
        List arrayList = new ArrayList();
        if (!this.f7563B) {
            arrayList.add(drawable);
        }
        if (this.f7591u != null) {
            arrayList.add(this.f7591u);
        }
        drawable = null;
        if (z) {
            if (this.f7590t == null) {
                this.f7590t = getResources().getDrawable(2130844043);
            }
            drawable = new AutoRotateDrawable(this.f7590t.getConstantState().newDrawable(), 1000);
        }
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.d = 300;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.f = colorDrawable;
        GenericDraweeHierarchyBuilder e = genericDraweeHierarchyBuilder.e(ScaleType.g);
        e.s = arrayList;
        e = e;
        e.l = drawable;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = e;
        if (this.f7564C) {
            genericDraweeHierarchyBuilder2.u = RoundingParams.e();
        }
        return genericDraweeHierarchyBuilder2.u();
    }

    private void m7310d() {
        int i = 0;
        if (this.f7591u != null) {
            int i2;
            Resources resources = getResources();
            if (this.f7567F.size() == 1) {
                i2 = 0;
            } else {
                i2 = resources.getColor(2131362331);
                int i3;
                if (MessageUtil.A(this.f7565D)) {
                    i3 = i2;
                    i2 = this.f7566E ? resources.getColor(2131362327) : resources.getColor(2131362325);
                    i = i3;
                } else {
                    i3 = i2;
                    i2 = -1;
                    i = i3;
                }
            }
            this.f7591u.b(i);
            this.f7591u.a(i2);
        }
    }

    private void m7292a(int i) {
        setSingleImageParams(i);
        DraweeView b = m7306b(i);
        b.setVisibility(0);
        if (this.f7563B) {
            b.setOnClickListener(null);
        }
    }

    private Point[] getImageDimensions() {
        int size = this.f7567F.size();
        Point[] pointArr = new Point[size];
        for (int i = 0; i < size; i++) {
            if (size == 2 || size == 4) {
                pointArr[i] = new Point(this.f7593w, this.f7593w);
            } else if (size >= 3) {
                pointArr[i] = new Point(this.f7594x, this.f7594x);
            } else {
                pointArr[i] = m7304b(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }
        return pointArr;
    }

    private static boolean m7302a(ImageRequest imageRequest, ImageRequest imageRequest2) {
        if (imageRequest == null && imageRequest2 == null) {
            return true;
        }
        if (imageRequest == null || imageRequest2 == null) {
            return false;
        }
        if (Objects.equal(imageRequest.c, imageRequest2.c) && Objects.equal(imageRequest.a, imageRequest2.a)) {
            return true;
        }
        return false;
    }

    private void setSingleImageParams(final int i) {
        final ImageFetchInfo a = m7289a((ImageAttachmentData) this.f7567F.get(i), this.f7571J[i]);
        ImageRequest imageRequest = (ImageRequest) Iterables.a(a.f7557a, null);
        if (!m7302a((ImageRequest) this.f7588r.get(i), imageRequest) || !m7306b(i).b()) {
            this.f7588r.put(i, imageRequest);
            final DraweeView b = m7306b(i);
            GenericDraweeHierarchy a2 = m7286a(a.f7559c);
            if (((ImageAttachmentData) this.f7567F.get(i)).h != null) {
                m7297a(a2, ((ImageAttachmentData) this.f7567F.get(i)).h, ((float) ((ImageAttachmentData) this.f7567F.get(i)).c) / ((float) ((ImageAttachmentData) this.f7567F.get(i)).d));
            }
            b.setHierarchy(a2);
            if (this.f7563B) {
                b.setController(null);
            } else if (this.f7586n.a()) {
                Futures.a(this.f7584l.a(new Callable<ImageFetchInfo>(this) {
                    final /* synthetic */ ThreadViewImageAttachmentView f7546c;

                    public Object call() {
                        return this.f7546c.m7290a(a, i);
                    }
                }), new FutureCallback<ImageFetchInfo>(this) {
                    final /* synthetic */ ThreadViewImageAttachmentView f7549c;

                    public void onSuccess(Object obj) {
                        b.setController(this.f7549c.m7284a(b, (ImageFetchInfo) obj));
                    }

                    public void onFailure(Throwable th) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to get FbDraweeControllerBuilder from ImagePipelineWrapper.");
                        if (!ThreadViewImageAttachmentView.m7313e(this.f7549c)) {
                            ImageRequest imageRequest = a.f7558b;
                            if (imageRequest != null) {
                                stringBuilder.append("Image=");
                                stringBuilder.append(imageRequest.c);
                            }
                        }
                        BLog.b(ThreadViewImageAttachmentView.f7560p, th, stringBuilder.toString(), new Object[0]);
                    }
                }, this.f7583k);
            } else {
                b.setController(m7284a(b, a));
            }
        }
    }

    public static boolean m7313e(ThreadViewImageAttachmentView threadViewImageAttachmentView) {
        return threadViewImageAttachmentView.f7565D != null && ThreadKey.g(threadViewImageAttachmentView.f7565D.b);
    }

    private void m7295a(int i, List<ImageRequest> list) {
        if (this.f7577e.a(241, false)) {
            if (list == null) {
                list = new ArrayList();
            }
            if (i < this.f7567F.size() && ((ImageAttachmentData) this.f7567F.get(i)).e != null) {
                File a = ((MediaDownloadServiceHandler) this.f7578f.get()).a(((ImageAttachmentData) this.f7567F.get(i)).e, PhotoDownloadDestination.GALLERY);
                if (a != null) {
                    Uri fromFile = Uri.fromFile(a);
                    String str = ((ImageAttachmentData) this.f7567F.get(i)).e;
                    list.add(ImageRequest.a(fromFile));
                }
            }
        }
    }

    private void m7297a(final GenericDraweeHierarchy genericDraweeHierarchy, final String str, float f) {
        ListenableFuture a;
        if (m7313e(this)) {
            a = this.f7584l.a(new Callable<Drawable>(this) {
                final /* synthetic */ ThreadViewImageAttachmentView f7551b;

                @SuppressLint({"BadMethodUse-android.graphics.BitmapFactory.decodeByteArray"})
                public Object call() {
                    byte[] decode = Base64.decode(str, 0);
                    return new BitmapDrawable(this.f7551b.getResources(), BitmapFactory.decodeByteArray(decode, 0, decode.length));
                }
            });
        } else {
            a = this.f7582j.a(str, f);
        }
        Futures.a(a, new FutureCallback<Drawable>(this) {
            final /* synthetic */ ThreadViewImageAttachmentView f7553b;

            public void onSuccess(@Nullable Object obj) {
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    genericDraweeHierarchy.a(drawable, ScaleType.g);
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f7583k);
    }

    private synchronized FbPipelineDraweeController m7284a(DraweeView draweeView, final ImageFetchInfo imageFetchInfo) {
        ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f7576d.a(f7561q).a(imageFetchInfo.f7557a.toArray(new ImageRequest[0]))).d(imageFetchInfo.f7558b)).b(draweeView.getController())).r().a(new BaseControllerListener(this) {
            final /* synthetic */ ThreadViewImageAttachmentView f7556b;

            /* compiled from: message is a payment message */
            class C11491 implements Runnable {
                final /* synthetic */ C11507 f7554a;

                C11491(C11507 c11507) {
                    this.f7554a = c11507;
                }

                public void run() {
                    this.f7554a.f7556b.f7587o.m3147a((ImageRequest) imageFetchInfo.f7557a.get(0));
                }
            }

            public final void m7282a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                if (animatable != null) {
                    animatable.start();
                }
            }

            public final void m7283b(String str, Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to fetch image");
                if (!(ThreadViewImageAttachmentView.m7313e(this.f7556b) || imageFetchInfo.f7557a.isEmpty())) {
                    stringBuilder.append(" ");
                    stringBuilder.append(((ImageRequest) imageFetchInfo.f7557a.get(0)).c);
                }
                BLog.b(ThreadViewImageAttachmentView.f7560p, th, stringBuilder.toString(), new Object[0]);
                if (!imageFetchInfo.f7557a.isEmpty() && this.f7556b.f7587o.m3148b()) {
                    ExecutorDetour.a(this.f7556b.f7585m, new C11491(this), -1254543753);
                }
            }
        });
        return this.f7576d.s();
    }

    private ImageFetchInfo m7290a(ImageFetchInfo imageFetchInfo, int i) {
        synchronized (imageFetchInfo) {
            List arrayList = new ArrayList();
            m7295a(i, arrayList);
            for (ImageRequest a : imageFetchInfo.f7557a) {
                arrayList.add(this.f7586n.a(a, f7561q));
            }
            imageFetchInfo.f7557a = arrayList;
            imageFetchInfo.f7558b = this.f7586n.a(imageFetchInfo.f7558b, f7561q);
        }
        return imageFetchInfo;
    }

    private ResizeOptions m7287a(Point point) {
        if (point.x != 0 && point.y != 0) {
            return new ResizeOptions(point.x, point.y);
        }
        BLog.c("t8978355", "Attachment image height or image width is zero. Width=%d, Height=%d, NumOfAttachments=%d", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(this.f7567F.size())});
        return null;
    }

    private ImageFetchInfo m7289a(ImageAttachmentData imageAttachmentData, Point point) {
        ImageFetchInfo imageFetchInfo = new ImageFetchInfo();
        MediaResource mediaResource = imageAttachmentData.f;
        if (mediaResource != null) {
            List list = imageFetchInfo.f7557a;
            ImageRequestBuilder a = m7288a(mediaResource.c);
            a.d = m7287a(point);
            list.add(a.m());
            if (mediaResource.h != null) {
                list = imageFetchInfo.f7557a;
                a = m7288a(mediaResource.h.c);
                a.d = m7287a(point);
                list.add(a.m());
            }
            if (mediaResource.c()) {
                imageFetchInfo.f7559c = true;
            }
        }
        m7299a(imageAttachmentData, imageFetchInfo, point);
        List list2 = imageFetchInfo.f7557a;
        ImageRequestBuilder a2 = m7288a(m7305b(imageAttachmentData, point));
        a2.d = m7287a(point);
        list2.add(a2.m());
        return imageFetchInfo;
    }

    private void m7299a(ImageAttachmentData imageAttachmentData, ImageFetchInfo imageFetchInfo, Point point) {
        int size = this.f7567F.size();
        Uri a = ThreadViewImageUriGetter.m3136a(size, imageAttachmentData.a);
        Uri a2 = ThreadViewImageUriGetter.m3136a(size, imageAttachmentData.b);
        if (a2 != null) {
            ImageRequestBuilder a3 = m7288a(a2);
            ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
            newBuilder.d = true;
            a3.e = newBuilder.h();
            a3 = a3;
            a3.d = m7287a(point);
            ImageRequest m = a3.m();
            imageFetchInfo.f7559c = true;
            imageFetchInfo.f7557a.add(m);
            a3 = m7288a(a);
            a3.d = m7287a(point);
            imageFetchInfo.f7558b = a3.m();
        } else if (a != null) {
            List list = imageFetchInfo.f7557a;
            ImageRequestBuilder a4 = m7288a(a);
            a4.d = m7287a(point);
            list.add(a4.m());
        }
    }

    private ImageRequestBuilder m7288a(Uri uri) {
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        if (this.f7565D != null && ThreadKey.g(this.f7565D.b)) {
            a.k = false;
        }
        return a;
    }

    private Uri m7305b(ImageAttachmentData imageAttachmentData, Point point) {
        ImageAttachmentUris imageAttachmentUris = imageAttachmentData.a;
        if (imageAttachmentUris.e == null) {
            return imageAttachmentUris.a;
        }
        int i;
        int i2;
        Object obj = (this.f7567F.size() <= 1 || !((Boolean) this.f7580h.get()).booleanValue()) ? null : 1;
        if (obj != null) {
            i = point.x;
            i2 = point.y;
        } else if (!imageAttachmentData.b()) {
            i2 = (int) (1.5d * ((double) Math.max(point.x, point.y)));
            i = i2;
        } else if (imageAttachmentData.c > imageAttachmentData.d) {
            float f = ((float) imageAttachmentData.c) / ((float) imageAttachmentData.d);
            i2 = point.y;
            i = (int) (f * ((float) point.y));
        } else if (imageAttachmentData.c < imageAttachmentData.d) {
            i2 = (int) ((((float) imageAttachmentData.d) / ((float) imageAttachmentData.c)) * ((float) point.x));
            i = point.x;
        } else {
            i2 = Math.max(point.x, point.y);
            i = i2;
        }
        Builder buildUpon = imageAttachmentUris.e.buildUpon();
        buildUpon.appendQueryParameter("preview", "1");
        buildUpon.appendQueryParameter("max_height", String.valueOf(i2));
        buildUpon.appendQueryParameter("max_width", String.valueOf(i));
        if (obj != null) {
            buildUpon.appendQueryParameter("crop", "1");
        }
        return buildUpon.build();
    }

    protected void onMeasure(int i, int i2) {
        int max = Math.max(Integer.MAX_VALUE, getSuggestedMinimumHeight());
        int resolveSize = View.resolveSize(Math.max(Integer.MAX_VALUE, getSuggestedMinimumWidth()), i);
        max = View.resolveSize(max, i2);
        int size = this.f7567F.size();
        m7293a(size, resolveSize);
        if (size == 1) {
            m7294a(resolveSize, max, i, i2);
        } else if (size == 2 || size == 4) {
            m7309c(i, i2);
        } else {
            m7311d(i, i2);
        }
        setMeasuredDimension(Math.min(this.f7569H, resolveSize), Math.min(this.f7570I, max));
    }

    private void m7293a(int i, int i2) {
        int i3 = 1;
        int i4 = 0;
        int min;
        if (i == 2 || i == 4) {
            min = Math.min((i2 - this.f7592v) / 2, this.f7593w);
            if (min < this.f7593w) {
                this.f7593w = min;
            }
            i3 = 0;
        } else {
            if (i >= 3) {
                min = Math.min((i2 - (this.f7592v * 2)) / 3, this.f7594x);
                if (min < this.f7594x) {
                    this.f7594x = min;
                }
            }
            i3 = 0;
        }
        if (i3 != 0) {
            this.f7571J = getImageDimensions();
            while (i4 < this.f7568G && i4 < this.f7567F.size()) {
                setSingleImageParams(i4);
                i4++;
            }
        }
    }

    private void m7294a(int i, int i2, int i3, int i4) {
        Point b = m7304b(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(b.x, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(b.y, 1073741824);
        int max = this.f7563B ? Math.max(b.x, getResources().getDimensionPixelSize(2131428584)) : b.x;
        int max2 = this.f7563B ? Math.max(b.y, getResources().getDimensionPixelSize(2131428584)) : b.y;
        this.f7569H = View.resolveSize(max, i3);
        this.f7570I = View.resolveSize(max2, i4);
        if (!(this.f7571J != null && this.f7569H == this.f7571J[0].x && this.f7570I == this.f7571J[0].y)) {
            this.f7571J = getImageDimensions();
        }
        measureChild(getChildAt(0), makeMeasureSpec, makeMeasureSpec2);
    }

    private Point m7304b(int i, int i2) {
        int min;
        ImageAttachmentData imageAttachmentData = (ImageAttachmentData) this.f7567F.get(0);
        Orientation c = imageAttachmentData.c();
        int min2 = Math.min(this.f7562A, i);
        if (c == Orientation.PORTRAIT || c == Orientation.SQUARE) {
            min = Math.min(this.f7596z, i2);
        } else if (c == Orientation.LANDSCAPE) {
            min = Math.min(this.f7595y, i2);
        } else {
            min = Math.min(this.f7562A, i2);
        }
        if (!imageAttachmentData.b()) {
            return new Point(min2, min);
        }
        float f = ((float) min) / ((float) imageAttachmentData.d);
        float min3 = Math.min(((float) min2) / ((float) imageAttachmentData.c), f);
        if (imageAttachmentData.g) {
            min3 = Math.min(min3, 1.0f);
        }
        min2 = (int) (((float) imageAttachmentData.c) * min3);
        int i3 = (int) (((float) imageAttachmentData.d) * min3);
        min = getSuggestedMinimumWidth();
        float f2 = ((float) min) / ((float) min2);
        if (min <= min2 || f2 >= f) {
            min = min2;
        } else {
            i3 = (int) (((float) i3) * f2);
        }
        return new Point(min, i3);
    }

    private void m7309c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f7593w, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.f7593w, 1073741824);
        int size = this.f7567F.size();
        int i3 = 1;
        for (int i4 = 0; i4 < size; i4++) {
            measureChild(getChildAt(i4), makeMeasureSpec, makeMeasureSpec2);
        }
        if (size == 4) {
            i3 = 2;
        }
        this.f7570I = View.resolveSize(((i3 - 1) * this.f7592v) + (this.f7593w * i3), i2);
        this.f7569H = View.resolveSize((this.f7593w * 2) + this.f7592v, i);
    }

    private void m7311d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f7594x, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.f7594x, 1073741824);
        int size = this.f7567F.size();
        int ceil = (int) Math.ceil(((double) this.f7567F.size()) / 3.0d);
        for (int i3 = 0; i3 < size; i3++) {
            measureChild(getChildAt(i3), makeMeasureSpec, makeMeasureSpec2);
        }
        this.f7570I = View.resolveSize((this.f7594x * ceil) + (this.f7592v * (ceil - 1)), i2);
        this.f7569H = View.resolveSize((this.f7594x * 3) + (this.f7592v * 2), i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.f7567F.size();
        if (size == 1) {
            View childAt = getChildAt(0);
            Orientation c = ((ImageAttachmentData) this.f7567F.get(0)).c();
            if (c == Orientation.PORTRAIT || c == Orientation.SQUARE || c == Orientation.UNKNOWN) {
                childAt.layout(0, 0, this.f7569H, Math.min(this.f7596z, this.f7570I));
            } else if (c == Orientation.LANDSCAPE) {
                childAt.layout(0, 0, this.f7569H, Math.min(this.f7595y, this.f7570I));
            }
        } else {
            int i5 = i3 - i;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i7 < size && i5 >= this.f7571J[i7].x) {
                getChildAt(i7).layout(i8, i6, this.f7571J[i7].x + i8, (i2 + i6) + this.f7571J[i7].y);
                i8 += this.f7571J[i7].x + this.f7592v;
                i5 -= this.f7571J[i7].x + this.f7592v;
                if (i5 < this.f7571J[i7].x) {
                    i5 = i3 - i;
                    i6 += this.f7571J[i7].y + this.f7592v;
                    i8 = 0;
                }
                i7++;
            }
        }
        m7312e(i, i3);
    }

    private void m7312e(int i, int i2) {
        if (this.f7563B) {
            m7314f();
            int size = ((this.f7567F.size() - 1) / 3) + 1;
            int i3 = (i2 - i) / 2;
            size = (int) (Math.max(((double) size) / 2.0d, ((double) size) - 1.5d) * ((double) Math.max(this.f7571J[0].y, getResources().getDimensionPixelSize(2131428584))));
            int intrinsicHeight = this.f7589s.getDrawable().getIntrinsicHeight() / 2;
            this.f7589s.layout(i3 - intrinsicHeight, size - intrinsicHeight, i3 + intrinsicHeight, size + intrinsicHeight);
            this.f7589s.setVisibility(0);
            return;
        }
        this.f7589s.setVisibility(8);
    }

    private void m7314f() {
        int i = 0;
        if (this.f7571J[0].x < this.f7589s.getDrawable().getIntrinsicWidth() || this.f7571J[0].y < this.f7589s.getDrawable().getIntrinsicHeight()) {
            i = 1;
        }
        if (i != 0) {
            Drawable drawable = getResources().getDrawable(2130841379);
            drawable.setColorFilter(getResources().getColor(2131361854), Mode.SRC_ATOP);
            this.f7589s.setImageDrawable(drawable);
            return;
        }
        this.f7589s.setImageDrawable(getResources().getDrawable(2130841513));
    }

    public void setOnLoadClickListener(OnClickListener onClickListener) {
        this.f7589s.setOnClickListener(onClickListener);
    }

    private DraweeView m7306b(int i) {
        return (DraweeView) getChildAt(i);
    }

    public ImmutableList<Animatable> getAnimatables() {
        if (this.f7567F == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f7567F.size(); i++) {
            DraweeView b = m7306b(i);
            if (b != null && b.b()) {
                Animatable g = b.getController().g();
                if (g != null) {
                    builder.c(g);
                }
            }
        }
        return builder.b();
    }
}
