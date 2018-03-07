package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.support.v7.graphics.Palette.Swatch;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentUris;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_feature_visible */
public class MontagePhotoFragment extends AbstractMontageItemFragment {
    private static final CallerContext am = CallerContext.a(MontagePhotoFragment.class, "photo_status_thread_view", "photo_status_thread_view".toString());
    @Inject
    public MessageClassifier al;
    private DraweeView an;
    public CloseableImage ao;
    public boolean ap;
    @Inject
    public AttachmentDataFactory f12583h;
    @Inject
    public FbDraweeControllerBuilder f12584i;

    /* compiled from: is_feature_visible */
    class C14081 implements OnLayoutChangeListener {
        final /* synthetic */ MontagePhotoFragment f12580a;

        C14081(MontagePhotoFragment montagePhotoFragment) {
            this.f12580a = montagePhotoFragment;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            MontagePhotoFragment.aD(this.f12580a);
        }
    }

    /* compiled from: is_feature_visible */
    class C14092 extends BaseControllerListener {
        final /* synthetic */ MontagePhotoFragment f12581a;

        C14092(MontagePhotoFragment montagePhotoFragment) {
            this.f12581a = montagePhotoFragment;
        }

        public final void m13030a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f12581a.ao = (CloseableImage) obj;
            MontagePhotoFragment.aD(this.f12581a);
            if (animatable != null) {
                this.f12581a.ap = true;
                animatable.start();
            } else {
                this.f12581a.ap = false;
            }
            this.f12581a.aA();
            MontagePhotoFragment.aC(this.f12581a);
        }

        public final void m13031b(String str, Throwable th) {
            this.f12581a.m13026a(th);
        }
    }

    /* compiled from: is_feature_visible */
    class C14103 implements PaletteAsyncListener {
        final /* synthetic */ MontagePhotoFragment f12582a;

        C14103(MontagePhotoFragment montagePhotoFragment) {
            this.f12582a = montagePhotoFragment;
        }

        public final void mo467a(Palette palette) {
            if (this.f12582a.z()) {
                Swatch swatch;
                MontagePhotoFragment montagePhotoFragment = this.f12582a;
                Swatch d = palette.f3735b.mo110d();
                if (d == null) {
                    swatch = d;
                    int i = 0;
                    for (Swatch swatch2 : palette.m3461a()) {
                        int i2;
                        if (swatch2.f3729e > i) {
                            d = swatch2;
                            i2 = swatch2.f3729e;
                        } else {
                            i2 = i;
                            d = swatch;
                        }
                        swatch = d;
                        i = i2;
                    }
                } else {
                    swatch = d;
                }
                if (swatch != null) {
                    montagePhotoFragment.T.setBackgroundDrawable(new ColorDrawable(swatch.f3728d));
                }
            }
        }
    }

    public static void m13034a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MontagePhotoFragment montagePhotoFragment = (MontagePhotoFragment) obj;
        AttachmentDataFactory a = AttachmentDataFactory.a(fbInjector);
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        MessageClassifier a2 = MessageClassifier.a(fbInjector);
        montagePhotoFragment.f12583h = a;
        montagePhotoFragment.f12584i = b;
        montagePhotoFragment.al = a2;
    }

    public final void mo496c(@Nullable Bundle bundle) {
        super.mo496c(bundle);
        Class cls = MontagePhotoFragment.class;
        m13034a((Object) this, getContext());
    }

    protected final void mo492a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.an = (DraweeView) FindViewUtil.b(layoutInflater.inflate(2130905335, viewGroup, true), 2131563979);
        this.T.addOnLayoutChangeListener(new C14081(this));
    }

    public final void mo497d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 408806635);
        super.mo497d(bundle);
        Message message = this.f12577g.f12555b;
        if (this.al.a(message) != MessageClassification.PHOTOS) {
            IllegalStateException illegalStateException = new IllegalStateException("Created a StatusPhotoFragment for a non-photos message.");
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1616155053, a);
            throw illegalStateException;
        }
        HandlerDetour.a(this.f12572b, this.aB);
        HandlerDetour.a(this.f12572b, this.aC, 2134122628);
        DraweeView draweeView = this.an;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(jW_());
        genericDraweeHierarchyBuilder.d = 0;
        draweeView.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.c).u());
        this.an.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12584i.a(am).a(m13035a((ImageAttachmentData) this.f12583h.f(message).get(0)))).a(new C14092(this))).s());
        LogUtils.f(-229971392, a);
    }

    @Nullable
    private Bitmap m13033a(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (drawable2 instanceof ForwardingDrawable) {
            drawable2 = drawable2.getCurrent();
        }
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        if (drawable2 instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable2;
            int a = arrayDrawable.a();
            for (int i = 0; i < a; i++) {
                Bitmap a2 = m13033a(arrayDrawable.a(i));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    public static void aC(MontagePhotoFragment montagePhotoFragment) {
        Bitmap a = montagePhotoFragment.m13033a(montagePhotoFragment.an.getTopLevelDrawable());
        if (a != null) {
            Palette.m3459a(a).m3451a(new C14103(montagePhotoFragment));
        }
    }

    protected final void aq() {
        if (!this.ap) {
            m13023a(3000);
        }
    }

    protected final void ar() {
    }

    public final long as() {
        if (this.ap) {
            return 3000;
        }
        return super.as();
    }

    private ImageRequest[] m13035a(ImageAttachmentData imageAttachmentData) {
        View rootView = this.T.getRootView();
        int max = Math.max(rootView.getWidth(), rootView.getHeight());
        List arrayList = new ArrayList();
        MediaResource mediaResource = imageAttachmentData.f7731f;
        if (mediaResource != null) {
            arrayList.add(ImageRequest.a(mediaResource.c));
            if (mediaResource.h != null) {
                arrayList.add(ImageRequest.a(mediaResource.h.c));
            }
        }
        ImageAttachmentUris imageAttachmentUris = imageAttachmentData.f7727b;
        if (!(imageAttachmentUris == null || imageAttachmentUris.f7742a == null)) {
            ImageRequestBuilder a = ImageRequestBuilder.a(imageAttachmentUris.f7742a);
            ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
            newBuilder.d = true;
            a.e = newBuilder.h();
            arrayList.add(a.m());
        }
        imageAttachmentUris = imageAttachmentData.f7726a;
        if (imageAttachmentUris.f7746e != null) {
            Builder buildUpon = imageAttachmentUris.f7746e.buildUpon();
            buildUpon.appendQueryParameter("preview", "1");
            buildUpon.appendQueryParameter("max_height", String.valueOf(max));
            buildUpon.appendQueryParameter("max_width", String.valueOf(max));
            arrayList.add(ImageRequest.a(buildUpon.build()));
        } else {
            arrayList.add(ImageRequest.a(imageAttachmentUris.f7742a));
        }
        return (ImageRequest[]) arrayList.toArray(new ImageRequest[arrayList.size()]);
    }

    public static void aD(MontagePhotoFragment montagePhotoFragment) {
        int width = montagePhotoFragment.T.getWidth();
        int height = montagePhotoFragment.T.getHeight();
        if (montagePhotoFragment.ao != null && width != 0 && height != 0) {
            if (montagePhotoFragment.ao.f() > montagePhotoFragment.ao.g()) {
                montagePhotoFragment.an.setRotation(90.0f);
            } else {
                montagePhotoFragment.an.setRotation(0.0f);
                int i = height;
                height = width;
                width = i;
            }
            LayoutParamsUtil.a(montagePhotoFragment.an, height, width);
        }
    }
}
