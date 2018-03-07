package com.facebook.fbui.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Lazy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: hashtag.user_did_remove */
public class NetworkDrawable extends Drawable {
    private static final Paint f11560a = new Paint(6);
    public DrawableState f11561b;
    private boolean f11562c;
    private boolean f11563d;
    public OnPrefetchListener f11564e;
    private final List<WeakReference<BitmapLoadedListener>> f11565f = new ArrayList();

    /* compiled from: hashtag.user_did_remove */
    public class DrawableState extends ConstantState {
        Paint f11541a;
        public final SharedDrawableState f11542b;

        DrawableState(int i, ImagePipeline imagePipeline, Executor executor, Lazy<FbErrorReporter> lazy) {
            this.f11542b = new SharedDrawableState(i, imagePipeline, executor, lazy);
        }

        DrawableState(DrawableState drawableState) {
            this.f11542b = drawableState.f11542b;
            this.f11541a = drawableState.f11541a != null ? new Paint(drawableState.f11541a) : null;
        }

        public Drawable newDrawable() {
            return new NetworkDrawable(this);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public final Bitmap m13441a() {
            return this.f11542b.f11557m;
        }

        final int m13442c() {
            return this.f11542b.f11545a;
        }
    }

    /* compiled from: hashtag.user_did_remove */
    public final class Prefetcher {
        public static final List<Drawable> f11543a = new ArrayList();
        private static final OnPrefetchListener f11544b = new C12561();

        /* compiled from: hashtag.user_did_remove */
        public interface OnPrefetchListener {
            void mo800a();
        }

        /* compiled from: hashtag.user_did_remove */
        final class C12561 implements OnPrefetchListener {
            C12561() {
            }

            public final void mo800a() {
            }
        }

        public static void m13445a(Resources resources, int i, OnPrefetchListener onPrefetchListener) {
            Drawable drawable = resources.getDrawable(i);
            if (drawable instanceof NetworkDrawable) {
                Object obj;
                NetworkDrawable networkDrawable = (NetworkDrawable) drawable;
                if (networkDrawable.f11561b.m13441a() != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    f11543a.add(drawable);
                    networkDrawable.f11564e = onPrefetchListener;
                    NetworkDrawable.m13450d(networkDrawable);
                    return;
                }
                onPrefetchListener.mo800a();
                return;
            }
            throw new RuntimeException("The drawable (" + resources.getResourceEntryName(i) + ") is not a Network Drawable");
        }
    }

    /* compiled from: hashtag.user_did_remove */
    public class SharedDrawableState extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        final int f11545a;
        public final ImagePipeline f11546b;
        public final Executor f11547c;
        public final Rect f11548d = new Rect();
        public final Lazy<FbErrorReporter> f11549e;
        public List<WeakReference<NetworkDrawable>> f11550f = new ArrayList();
        public int f11551g;
        public int f11552h;
        public String f11553i;
        public ImageRequest f11554j;
        public CallerContext f11555k;
        public int f11556l;
        public Bitmap f11557m;
        public CloseableReference<CloseableImage> f11558n;
        public DataSource<CloseableReference<CloseableImage>> f11559o;

        SharedDrawableState(int i, ImagePipeline imagePipeline, Executor executor, Lazy<FbErrorReporter> lazy) {
            this.f11545a = i;
            this.f11546b = imagePipeline;
            this.f11547c = executor;
            this.f11549e = lazy;
        }

        protected final void m13446e(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource == this.f11559o) {
                this.f11558n = (CloseableReference) dataSource.d();
                if (this.f11558n != null) {
                    this.f11557m = ((CloseableStaticBitmap) this.f11558n.a()).a();
                }
                this.f11559o = null;
                List list = this.f11550f;
                this.f11550f = null;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    NetworkDrawable networkDrawable = (NetworkDrawable) ((WeakReference) list.get(i)).get();
                    if (networkDrawable != null) {
                        NetworkDrawable.m13449c(networkDrawable);
                    }
                }
                list.clear();
                this.f11550f = list;
            }
        }

        protected final void m13447f(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource == this.f11559o) {
                this.f11559o = null;
            }
        }
    }

    public NetworkDrawable(DrawableState drawableState) {
        this.f11561b = drawableState;
    }

    public NetworkDrawable(ImagePipeline imagePipeline, Executor executor, int i, Lazy<FbErrorReporter> lazy) {
        this.f11561b = new DrawableState(i, imagePipeline, executor, lazy);
    }

    public void draw(Canvas canvas) {
        m13450d(this);
        Bitmap a = this.f11561b.m13441a();
        if (a != null) {
            canvas.drawBitmap(a, this.f11561b.f11542b.f11548d, getBounds(), m13448b());
        }
    }

    public int getIntrinsicWidth() {
        return this.f11561b.f11542b.f11551g;
    }

    public int getIntrinsicHeight() {
        return this.f11561b.f11542b.f11552h;
    }

    public Drawable mutate() {
        if (!this.f11562c && super.mutate() == this) {
            this.f11561b = new DrawableState(this.f11561b);
            this.f11562c = true;
        }
        return this;
    }

    private Paint m13448b() {
        return this.f11561b.f11541a == null ? f11560a : this.f11561b.f11541a;
    }

    public void setAlpha(int i) {
        m13448b().setAlpha(i);
    }

    public int getAlpha() {
        return m13448b().getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        m13448b().setColorFilter(colorFilter);
    }

    public int getOpacity() {
        Bitmap a = this.f11561b.m13441a();
        if (a == null || a.hasAlpha() || getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NetworkDrawable);
        String string = obtainAttributes.getString(3);
        int dimensionPixelSize = obtainAttributes.getDimensionPixelSize(1, 0);
        int dimensionPixelSize2 = obtainAttributes.getDimensionPixelSize(0, 0);
        float integer = ((float) resources.getDisplayMetrics().densityDpi) / ((float) obtainAttributes.getInteger(2, 0));
        int ceil = (int) Math.ceil((double) (((float) dimensionPixelSize) * integer));
        int ceil2 = (int) Math.ceil((double) (((float) dimensionPixelSize2) * integer));
        String string2 = obtainAttributes.getString(4);
        if (string2 == null) {
            string2 = "unknown";
        }
        String string3 = obtainAttributes.getString(5);
        if (string3 == null) {
            string3 = "network_drawable_" + resources.getResourceEntryName(this.f11561b.m13442c());
        }
        obtainAttributes.recycle();
        CallerContext a = CallerContext.a(NetworkDrawable.class, string2, string3);
        SharedDrawableState sharedDrawableState = this.f11561b.f11542b;
        sharedDrawableState.f11553i = string;
        sharedDrawableState.f11551g = ceil;
        sharedDrawableState.f11552h = ceil2;
        sharedDrawableState.f11548d.set(0, 0, ceil, ceil2);
        sharedDrawableState.f11554j = ImageRequestBuilder.a(Uri.parse(string)).m();
        sharedDrawableState.f11555k = a;
    }

    public ConstantState getConstantState() {
        return this.f11561b;
    }

    public static void m13449c(NetworkDrawable networkDrawable) {
        networkDrawable.invalidateSelf();
        if (networkDrawable.f11564e != null) {
            Prefetcher.f11543a.remove(networkDrawable);
            networkDrawable.f11564e.mo800a();
            networkDrawable.f11564e = null;
            networkDrawable.m13451e();
        }
        int size = networkDrawable.f11565f.size();
        for (int i = 0; i < size; i++) {
            BitmapLoadedListener bitmapLoadedListener = (BitmapLoadedListener) ((WeakReference) networkDrawable.f11565f.get(i)).get();
            if (bitmapLoadedListener != null) {
                bitmapLoadedListener.a(networkDrawable.f11561b.m13441a());
            }
        }
        networkDrawable.f11565f.clear();
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (z) {
            m13450d(this);
        } else {
            m13451e();
        }
        return super.setVisible(z, z2);
    }

    public static void m13450d(NetworkDrawable networkDrawable) {
        if (!networkDrawable.f11563d) {
            networkDrawable.f11563d = true;
            SharedDrawableState sharedDrawableState = networkDrawable.f11561b.f11542b;
            sharedDrawableState.f11556l++;
            if (sharedDrawableState.f11557m == null && sharedDrawableState.f11550f != null) {
                Object obj;
                sharedDrawableState.f11550f.add(new WeakReference(networkDrawable));
                if (sharedDrawableState.f11557m == null && sharedDrawableState.f11559o == null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    sharedDrawableState.f11559o = sharedDrawableState.f11546b.c(sharedDrawableState.f11554j, sharedDrawableState.f11555k);
                    sharedDrawableState.f11559o.a(sharedDrawableState, sharedDrawableState.f11547c);
                }
            }
        }
    }

    private void m13451e() {
        if (this.f11563d) {
            SharedDrawableState sharedDrawableState = this.f11561b.f11542b;
            int i = sharedDrawableState.f11556l - 1;
            sharedDrawableState.f11556l = i;
            if (i == 0 && sharedDrawableState.f11557m != null) {
                CloseableReference.c(sharedDrawableState.f11558n);
                sharedDrawableState.f11558n = null;
                sharedDrawableState.f11557m = null;
            }
            if (sharedDrawableState.f11550f != null) {
                int size = sharedDrawableState.f11550f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (equals(((WeakReference) sharedDrawableState.f11550f.get(i2)).get())) {
                        sharedDrawableState.f11550f.remove(i2);
                        break;
                    }
                }
                if (sharedDrawableState.f11550f.isEmpty() && sharedDrawableState.f11559o != null) {
                    sharedDrawableState.f11559o.g();
                    sharedDrawableState.f11559o = null;
                }
            }
            this.f11563d = false;
        }
    }

    protected void finalize() {
        if (this.f11563d) {
            setVisible(false, false);
            ((AbstractFbErrorReporter) this.f11561b.f11542b.f11549e.get()).a("NetworkDrawableNotClosed", new RuntimeException("NetworkDrawable with id: " + this.f11561b.m13442c() + " (" + this.f11561b.f11542b.f11553i + ")  wasn't hidden before it was GC'd. Please call setVisible(false, ___ )" + " in View.onDetachedFromWindow()"));
        }
    }

    public final void m13452a(BitmapLoadedListener bitmapLoadedListener) {
        Bitmap a = this.f11561b.m13441a();
        if (a == null) {
            this.f11565f.add(new WeakReference(bitmapLoadedListener));
            m13450d(this);
            return;
        }
        bitmapLoadedListener.a(a);
    }
}
