package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.PagerTitleStripIcs.SingleLineAllCapsTransform;
import android.support.v4.view.ViewPager.Decor;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;

/* compiled from: video_broadcast_response */
public class PagerTitleStrip extends ViewGroup implements Decor {
    private static final int[] f314n = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] f315o = new int[]{16843660};
    private static final PagerTitleStripImpl f316q;
    ViewPager f317a;
    public TextView f318b;
    public TextView f319c;
    public TextView f320d;
    public int f321e;
    private int f322f;
    public float f323g;
    public int f324h;
    private int f325i;
    private boolean f326j;
    private boolean f327k;
    private final PageListener f328l;
    private WeakReference<PagerAdapter> f329m;
    public int f330p;

    /* compiled from: video_broadcast_response */
    class PageListener extends DataSetObserver implements ViewPager$OnAdapterChangeListener, OnPageChangeListener {
        final /* synthetic */ PagerTitleStrip f347a;
        private int f348b;

        public PageListener(PagerTitleStrip pagerTitleStrip) {
            this.f347a = pagerTitleStrip;
        }

        public final void m392a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.f347a.mo65a(i, f, false);
        }

        public final void e_(int i) {
            float f = 0.0f;
            if (this.f348b == 0) {
                this.f347a.m388a(this.f347a.f317a.k, this.f347a.f317a.getAdapter());
                if (this.f347a.f323g >= 0.0f) {
                    f = this.f347a.f323g;
                }
                this.f347a.mo65a(this.f347a.f317a.k, f, true);
            }
        }

        public final void m394b(int i) {
            this.f348b = i;
        }

        public final void mo68a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            this.f347a.m389a(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            float f = 0.0f;
            this.f347a.m388a(this.f347a.f317a.k, this.f347a.f317a.getAdapter());
            if (this.f347a.f323g >= 0.0f) {
                f = this.f347a.f323g;
            }
            this.f347a.mo65a(this.f347a.f317a.k, f, true);
        }
    }

    /* compiled from: video_broadcast_response */
    interface PagerTitleStripImpl {
        void mo69a(TextView textView);
    }

    /* compiled from: video_broadcast_response */
    class PagerTitleStripImplBase implements PagerTitleStripImpl {
        PagerTitleStripImplBase() {
        }

        public final void mo69a(TextView textView) {
            textView.setSingleLine();
        }
    }

    /* compiled from: video_broadcast_response */
    class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        public final void mo69a(TextView textView) {
            textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
        }

        PagerTitleStripImplIcs() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f316q = new PagerTitleStripImplIcs();
        } else {
            f316q = new PagerTitleStripImplBase();
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        f316q.mo69a(textView);
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        this.f322f = -1;
        this.f323g = -1.0f;
        this.f328l = new PageListener(this);
        View textView = new TextView(context);
        this.f318b = textView;
        addView(textView);
        textView = new TextView(context);
        this.f319c = textView;
        addView(textView);
        textView = new TextView(context);
        this.f320d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f314n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f318b.setTextAppearance(context, resourceId);
            this.f319c.setTextAppearance(context, resourceId);
            this.f320d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.f318b.setTextSize(0, f);
            this.f319c.setTextSize(0, f);
            this.f320d.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.f318b.setTextColor(dimensionPixelSize);
            this.f319c.setTextColor(dimensionPixelSize);
            this.f320d.setTextColor(dimensionPixelSize);
        }
        this.f325i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f321e = this.f319c.getTextColors().getDefaultColor();
        this.f330p = ((int) (255.0f * 0.6f)) & 255;
        int i = (this.f330p << 24) | (this.f321e & 16777215);
        this.f318b.setTextColor(i);
        this.f320d.setTextColor(i);
        this.f318b.setEllipsize(TruncateAt.END);
        this.f319c.setEllipsize(TruncateAt.END);
        this.f320d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, f315o);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f318b);
            setSingleLineAllCaps(this.f319c);
            setSingleLineAllCaps(this.f320d);
        } else {
            this.f318b.setSingleLine();
            this.f319c.setSingleLine();
            this.f320d.setSingleLine();
        }
        this.f324h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f324h = i;
        requestLayout();
    }

    public void setTextColor(int i) {
        this.f321e = i;
        this.f319c.setTextColor(i);
        int i2 = (this.f330p << 24) | (this.f321e & 16777215);
        this.f318b.setTextColor(i2);
        this.f320d.setTextColor(i2);
    }

    public void setGravity(int i) {
        this.f325i = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1742965227);
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.a(this.f328l);
            viewPager.ag = this.f328l;
            this.f317a = viewPager;
            m389a(this.f329m != null ? (PagerAdapter) this.f329m.get() : null, adapter);
            LogUtils.g(252045266, a);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1912603647, a);
        throw illegalStateException;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1948103952);
        super.onDetachedFromWindow();
        if (this.f317a != null) {
            m389a(this.f317a.getAdapter(), null);
            this.f317a.a(null);
            this.f317a.ag = null;
            this.f317a = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1022400533, a);
    }

    final void m388a(int i, PagerAdapter pagerAdapter) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int b = pagerAdapter != null ? pagerAdapter.b() : 0;
        this.f326j = true;
        if (i <= 0 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.J_(i - 1);
        }
        this.f318b.setText(charSequence);
        TextView textView = this.f319c;
        if (pagerAdapter == null || i >= b) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.J_(i);
        }
        textView.setText(charSequence);
        if (i + 1 < b && pagerAdapter != null) {
            charSequence2 = pagerAdapter.J_(i + 1);
        }
        this.f320d.setText(charSequence2);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        b = MeasureSpec.makeMeasureSpec((int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f), Integer.MIN_VALUE);
        height = MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
        this.f318b.measure(b, height);
        this.f319c.measure(b, height);
        this.f320d.measure(b, height);
        this.f322f = i;
        if (!this.f327k) {
            mo65a(i, this.f323g, false);
        }
        this.f326j = false;
    }

    public void requestLayout() {
        if (!this.f326j) {
            super.requestLayout();
        }
    }

    final void m389a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.b(this.f328l);
            this.f329m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.a(this.f328l);
            this.f329m = new WeakReference(pagerAdapter2);
        }
        if (this.f317a != null) {
            this.f322f = -1;
            this.f323g = -1.0f;
            m388a(this.f317a.k, pagerAdapter2);
            requestLayout();
        }
    }

    void mo65a(int i, float f, boolean z) {
        if (i != this.f322f) {
            m388a(i, this.f317a.getAdapter());
        } else if (!z && f == this.f323g) {
            return;
        }
        this.f327k = true;
        int measuredWidth = this.f318b.getMeasuredWidth();
        int measuredWidth2 = this.f319c.getMeasuredWidth();
        int measuredWidth3 = this.f320d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.f318b.getBaseline();
        measuredWidth2 = this.f319c.getBaseline();
        i2 = this.f320d.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.f320d.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.f318b.getMeasuredHeight() + baseline, this.f319c.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.f325i & 112) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                measuredWidth2 += height;
                baseline = height + max;
                break;
            case 80:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                measuredWidth2 += height;
                baseline = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                measuredWidth2 += paddingTop;
                baseline = paddingTop + max;
                break;
        }
        this.f319c.layout(i3, measuredWidth2, i4, this.f319c.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i3 - this.f324h) - measuredWidth);
        this.f318b.layout(measuredWidth2, i2, measuredWidth + measuredWidth2, this.f318b.getMeasuredHeight() + i2);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.f324h + i4);
        this.f320d.layout(measuredWidth2, baseline, measuredWidth2 + measuredWidth3, this.f320d.getMeasuredHeight() + baseline);
        this.f323g = f;
        this.f327k = false;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        mode = getMinHeight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (((float) size) * 0.8f), Integer.MIN_VALUE);
        i3 = MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        this.f318b.measure(makeMeasureSpec, i3);
        this.f319c.measure(makeMeasureSpec, i3);
        this.f320d.measure(makeMeasureSpec, i3);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(mode, this.f319c.getMeasuredHeight() + paddingTop));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.f317a != null) {
            if (this.f323g >= 0.0f) {
                f = this.f323g;
            }
            mo65a(this.f322f, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
