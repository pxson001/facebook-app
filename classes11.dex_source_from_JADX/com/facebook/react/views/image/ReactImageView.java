package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.FloatUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: SCROLL_TO_TAB */
public class ReactImageView extends GenericDraweeView {
    public static float[] f11444a = new float[4];
    public static final Matrix f11445b = new Matrix();
    public static final Matrix f11446c = new Matrix();
    @Nullable
    private Uri f11447d;
    @Nullable
    private Drawable f11448e;
    private int f11449f;
    private int f11450g;
    private float f11451h;
    private float f11452i = Float.NaN;
    @Nullable
    private float[] f11453j;
    public ScaleType f11454k = ScaleType.g;
    private boolean f11455l;
    private boolean f11456m;
    private final AbstractDraweeControllerBuilder f11457n;
    private final RoundedCornerPostprocessor f11458o;
    @Nullable
    private ControllerListener f11459p;
    @Nullable
    private ControllerListener f11460q;
    @Nullable
    private final Object f11461r;
    public int f11462s = -1;
    public boolean f11463t;

    /* compiled from: SCROLL_TO_TAB */
    class RoundedCornerPostprocessor extends BasePostprocessor {
        final /* synthetic */ ReactImageView f11443a;

        public RoundedCornerPostprocessor(ReactImageView reactImageView) {
            this.f11443a = reactImageView;
        }

        private void m11857a(Bitmap bitmap, float[] fArr, float[] fArr2) {
            ScalingUtils.a(ReactImageView.f11445b, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f, this.f11443a.f11454k);
            ReactImageView.f11445b.invert(ReactImageView.f11446c);
            fArr2[0] = ReactImageView.f11446c.mapRadius(fArr[0]);
            fArr2[1] = fArr2[0];
            fArr2[2] = ReactImageView.f11446c.mapRadius(fArr[1]);
            fArr2[3] = fArr2[2];
            fArr2[4] = ReactImageView.f11446c.mapRadius(fArr[2]);
            fArr2[5] = fArr2[4];
            fArr2[6] = ReactImageView.f11446c.mapRadius(fArr[3]);
            fArr2[7] = fArr2[6];
        }

        public final void m11858a(Bitmap bitmap, Bitmap bitmap2) {
            this.f11443a.m11862a(ReactImageView.f11444a);
            bitmap.setHasAlpha(true);
            if (FloatUtil.a(ReactImageView.f11444a[0], 0.0f) && FloatUtil.a(ReactImageView.f11444a[1], 0.0f) && FloatUtil.a(ReactImageView.f11444a[2], 0.0f) && FloatUtil.a(ReactImageView.f11444a[3], 0.0f)) {
                super.a(bitmap, bitmap2);
                return;
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(bitmap2, TileMode.CLAMP, TileMode.CLAMP));
            Canvas canvas = new Canvas(bitmap);
            float[] fArr = new float[8];
            m11857a(bitmap2, ReactImageView.f11444a, fArr);
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), fArr, Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    private static GenericDraweeHierarchy m11860a(Context context) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.u = RoundingParams.b(0.0f);
        return genericDraweeHierarchyBuilder.u();
    }

    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, @Nullable Object obj) {
        super(context, m11860a(context));
        this.f11457n = abstractDraweeControllerBuilder;
        this.f11458o = new RoundedCornerPostprocessor(this);
        this.f11461r = obj;
    }

    public void setShouldNotifyLoadEvents(boolean z) {
        if (z) {
            final EventDispatcher eventDispatcher = ((UIManagerModule) ((ReactContext) getContext()).b(UIManagerModule.class)).a;
            this.f11459p = new BaseControllerListener<ImageInfo>(this) {
                final /* synthetic */ ReactImageView f11442b;

                public final void m11855a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                    if (((CloseableImage) obj) != null) {
                        eventDispatcher.a(new ImageLoadEvent(this.f11442b.getId(), SystemClock.b(), 2));
                        eventDispatcher.a(new ImageLoadEvent(this.f11442b.getId(), SystemClock.b(), 3));
                    }
                }

                public final void m11854a(String str, Object obj) {
                    eventDispatcher.a(new ImageLoadEvent(this.f11442b.getId(), SystemClock.b(), 4));
                }

                public final void m11856b(String str, Throwable th) {
                    eventDispatcher.a(new ImageLoadEvent(this.f11442b.getId(), SystemClock.b(), 1));
                    eventDispatcher.a(new ImageLoadEvent(this.f11442b.getId(), SystemClock.b(), 3));
                }
            };
        } else {
            this.f11459p = null;
        }
        this.f11455l = true;
    }

    public void setBorderColor(int i) {
        this.f11449f = i;
        this.f11455l = true;
    }

    public void setOverlayColor(int i) {
        this.f11450g = i;
        this.f11455l = true;
    }

    public void setBorderWidth(float f) {
        this.f11451h = PixelUtil.a(f);
        this.f11455l = true;
    }

    public void setBorderRadius(float f) {
        if (!FloatUtil.a(this.f11452i, f)) {
            this.f11452i = f;
            this.f11455l = true;
        }
    }

    public final void m11867a(float f, int i) {
        if (this.f11453j == null) {
            this.f11453j = new float[4];
            Arrays.fill(this.f11453j, Float.NaN);
        }
        if (!FloatUtil.a(this.f11453j[i], f)) {
            this.f11453j[i] = f;
            this.f11455l = true;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        this.f11454k = scaleType;
        this.f11455l = true;
    }

    public final void m11868a(@Nullable String str, ResourceDrawableIdHelper resourceDrawableIdHelper) {
        this.f11447d = null;
        if (str != null) {
            try {
                this.f11447d = Uri.parse(str);
                if (this.f11447d.getScheme() == null) {
                    this.f11447d = null;
                }
            } catch (Exception e) {
            }
            if (this.f11447d == null) {
                this.f11447d = resourceDrawableIdHelper.m11873b(getContext(), str);
                this.f11456m = true;
            } else {
                this.f11456m = false;
            }
        }
        this.f11455l = true;
    }

    public final void m11869b(@Nullable String str, ResourceDrawableIdHelper resourceDrawableIdHelper) {
        Drawable a = resourceDrawableIdHelper.m11872a(getContext(), str);
        this.f11448e = a != null ? new AutoRotateDrawable(a, 1000) : null;
        this.f11455l = true;
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.f11463t = z;
    }

    public void setFadeDuration(int i) {
        this.f11462s = i;
    }

    private void m11862a(float[] fArr) {
        float f;
        float f2 = !CSSConstants.a(this.f11452i) ? this.f11452i : 0.0f;
        if (this.f11453j == null || CSSConstants.a(this.f11453j[0])) {
            f = f2;
        } else {
            f = this.f11453j[0];
        }
        fArr[0] = f;
        if (this.f11453j == null || CSSConstants.a(this.f11453j[1])) {
            f = f2;
        } else {
            f = this.f11453j[1];
        }
        fArr[1] = f;
        if (this.f11453j == null || CSSConstants.a(this.f11453j[2])) {
            f = f2;
        } else {
            f = this.f11453j[2];
        }
        fArr[2] = f;
        if (!(this.f11453j == null || CSSConstants.a(this.f11453j[3]))) {
            f2 = this.f11453j[3];
        }
        fArr[3] = f2;
    }

    public final void m11870c() {
        if (this.f11455l) {
            boolean a = m11863a(this.f11447d);
            if (!a || (getWidth() > 0 && getHeight() > 0)) {
                Postprocessor postprocessor;
                ResizeOptions resizeOptions;
                GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
                genericDraweeHierarchy.a(this.f11454k);
                if (this.f11448e != null) {
                    genericDraweeHierarchy.a(this.f11448e, ScaleType.e);
                }
                boolean z = (this.f11454k == ScaleType.g || this.f11454k == ScaleType.h) ? false : true;
                RoundingParams roundingParams = genericDraweeHierarchy.c;
                if (z) {
                    roundingParams.a(0.0f);
                } else {
                    m11862a(f11444a);
                    roundingParams.a(f11444a[0], f11444a[1], f11444a[2], f11444a[3]);
                }
                roundingParams.a(this.f11449f, this.f11451h);
                if (this.f11450g != 0) {
                    roundingParams.a(this.f11450g);
                } else {
                    roundingParams.a = RoundingMethod.BITMAP_ONLY;
                }
                genericDraweeHierarchy.a(roundingParams);
                int i = this.f11462s >= 0 ? this.f11462s : this.f11456m ? 0 : 300;
                genericDraweeHierarchy.a(i);
                if (z) {
                    postprocessor = this.f11458o;
                } else {
                    postprocessor = null;
                }
                if (a) {
                    resizeOptions = new ResizeOptions(getWidth(), getHeight());
                } else {
                    resizeOptions = null;
                }
                ImageRequestBuilder a2 = ImageRequestBuilder.a(this.f11447d);
                a2.j = postprocessor;
                ImageRequestBuilder imageRequestBuilder = a2;
                imageRequestBuilder.d = resizeOptions;
                ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
                imageRequestBuilder2.c = true;
                imageRequestBuilder2 = imageRequestBuilder2;
                imageRequestBuilder2.g = this.f11463t;
                ImageRequest m = imageRequestBuilder2.m();
                this.f11457n.b();
                this.f11457n.c(true).b(this.f11461r).b(getController()).c(m);
                if (this.f11459p != null && this.f11460q != null) {
                    ForwardingControllerListener forwardingControllerListener = new ForwardingControllerListener();
                    forwardingControllerListener.a(this.f11459p);
                    forwardingControllerListener.a(this.f11460q);
                    this.f11457n.a(forwardingControllerListener);
                } else if (this.f11460q != null) {
                    this.f11457n.a(this.f11460q);
                } else if (this.f11459p != null) {
                    this.f11457n.a(this.f11459p);
                }
                setController(this.f11457n.i());
                this.f11455l = false;
            }
        }
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.f11460q = controllerListener;
        this.f11455l = true;
        m11870c();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1754037013);
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            m11870c();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -156663589, a);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    private static boolean m11863a(@Nullable Uri uri) {
        return uri != null && (UriUtil.c(uri) || UriUtil.b(uri));
    }
}
