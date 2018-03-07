package com.facebook.messaging.attribution;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewStub;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.attachments.IsInlineVideoPlayerSupported;
import com.facebook.messaging.sharing.mediapreview.MediaSharePreviewPlayableView;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listview.EmptyListViewItem;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: outgoing_transactions_creation_time_index */
public class MediaResourceView extends CustomFrameLayout {
    private static final CallerContext f7834c = CallerContext.a(MediaResourceView.class, "media_resource_view", "media_resource_view".toString());
    @Inject
    FbDraweeControllerBuilder f7835a;
    @Inject
    @IsInlineVideoPlayerSupported
    Provider<Boolean> f7836b;
    private MediaResource f7837d;
    private EmptyListViewItem f7838e;
    @Nullable
    private FbDraweeView f7839f;
    @Nullable
    private MediaSharePreviewPlayableView f7840g;
    private int f7841h = -1;

    /* compiled from: outgoing_transactions_creation_time_index */
    class C08731 extends BaseControllerListener {
        final /* synthetic */ MediaResourceView f7832a;

        C08731(MediaResourceView mediaResourceView) {
            this.f7832a = mediaResourceView;
        }

        public final void m8069a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* compiled from: outgoing_transactions_creation_time_index */
    /* synthetic */ class C08742 {
        static final /* synthetic */ int[] f7833a = new int[Type.values().length];

        static {
            try {
                f7833a[Type.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7833a[Type.AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7833a[Type.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: outgoing_transactions_creation_time_index */
    enum PreviewType {
        PHOTO,
        AUDIO_OR_VIDEO
    }

    private static <T extends View> void m8073a(Class<T> cls, T t) {
        m8074a((Object) t, t.getContext());
    }

    private static void m8074a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MediaResourceView) obj).m8072a(FbDraweeControllerBuilder.b(fbInjector), IdBasedProvider.a(fbInjector, 4102));
    }

    public MediaResourceView(Context context) {
        super(context);
        m8071a(context, null);
    }

    public MediaResourceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m8071a(context, attributeSet);
    }

    public MediaResourceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8071a(context, attributeSet);
    }

    private void m8071a(Context context, AttributeSet attributeSet) {
        m8073a(MediaResourceView.class, (View) this);
        setContentView(2130905186);
        this.f7838e = (EmptyListViewItem) c(2131560407);
        this.f7838e.a(true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MediaResourceView);
            this.f7841h = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }
    }

    public void setMediaResource(MediaResource mediaResource) {
        this.f7837d = mediaResource;
        if (this.f7837d != null) {
            m8070a();
            return;
        }
        if (this.f7839f != null) {
            this.f7839f.setVisibility(8);
        }
        if (this.f7840g != null) {
            this.f7840g.setVisibility(8);
        }
    }

    private void m8072a(FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<Boolean> provider) {
        this.f7835a = fbDraweeControllerBuilder;
        this.f7836b = provider;
    }

    private void m8070a() {
        this.f7838e.setVisibility(8);
        Type type = this.f7837d.d;
        PreviewType previewType = getPreviewType();
        if (previewType == PreviewType.PHOTO) {
            if (this.f7839f == null) {
                this.f7839f = (FbDraweeView) ((ViewStub) c(2131563740)).inflate();
            } else {
                this.f7839f.setVisibility(0);
            }
            this.f7839f.setAspectRatio(((float) this.f7837d.j) / ((float) this.f7837d.k));
            FbDraweeControllerBuilder a = this.f7835a.a(f7834c);
            ImageRequestBuilder a2 = ImageRequestBuilder.a(getUriForPhotoPreview());
            a2.d = new ResizeOptions(960, 960);
            this.f7839f.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) a.c(a2.m())).a(new C08731(this))).s());
        } else if (previewType == PreviewType.AUDIO_OR_VIDEO) {
            if (this.f7840g == null) {
                this.f7840g = (MediaSharePreviewPlayableView) ((ViewStub) c(2131563741)).inflate();
            } else {
                this.f7840g.setVisibility(0);
            }
            this.f7840g.m17397a(this.f7837d, 2130905843);
        } else {
            throw new IllegalArgumentException(StringFormatUtil.a("Unrecognized MediaResource.Type: %s", new Object[]{type}));
        }
    }

    private PreviewType getPreviewType() {
        switch (C08742.f7833a[this.f7837d.d.ordinal()]) {
            case 1:
                return PreviewType.PHOTO;
            case 2:
                return PreviewType.AUDIO_OR_VIDEO;
            case 3:
                return ((Boolean) this.f7836b.get()).booleanValue() ? PreviewType.AUDIO_OR_VIDEO : PreviewType.PHOTO;
            default:
                throw new IllegalArgumentException(StringFormatUtil.a("Unrecognized MediaResource.Type: %s", new Object[]{this.f7837d.d}));
        }
    }

    private Uri getUriForPhotoPreview() {
        switch (C08742.f7833a[this.f7837d.d.ordinal()]) {
            case 1:
                return this.f7837d.c;
            case 3:
                return this.f7837d.f;
            default:
                throw new IllegalArgumentException(StringFormatUtil.a("MediaResource type does not support thumbnail: %s", new Object[]{this.f7837d.d}));
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f7841h != -1) {
            i2 = MeasureSpec.makeMeasureSpec(this.f7841h, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
