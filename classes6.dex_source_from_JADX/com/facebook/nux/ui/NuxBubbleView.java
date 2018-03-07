package com.facebook.nux.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: profile_wizard_nux_start */
public class NuxBubbleView extends CustomFrameLayout {
    private static final SpringConfig f12271e = SpringConfig.a(40.0d, 7.0d);
    protected boolean f12272a;
    public State f12273b;
    public Listener f12274c;
    public ViewHelperViewAnimator f12275d;
    public SpringSystem f12276f;
    private Spring f12277g;
    private int f12278h;
    private int f12279i;
    private int f12280j;
    public LayoutInflater f12281k;
    private TextView f12282l;
    private TextView f12283m;
    private LinearLayout f12284n;
    private ImageView f12285o;
    public SizeChangeListener f12286p;
    private final OnGlobalLayoutListener f12287q;

    /* compiled from: profile_wizard_nux_start */
    public interface Listener {
        void mo901a();

        void mo902b();
    }

    /* compiled from: profile_wizard_nux_start */
    class C07971 implements OnGlobalLayoutListener {
        final /* synthetic */ NuxBubbleView f12268a;

        C07971(NuxBubbleView nuxBubbleView) {
            this.f12268a = nuxBubbleView;
        }

        public void onGlobalLayout() {
            this.f12268a.m19184e();
            this.f12268a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: profile_wizard_nux_start */
    class C07982 extends SimpleSpringListener {
        final /* synthetic */ NuxBubbleView f12269a;

        C07982(NuxBubbleView nuxBubbleView) {
            this.f12269a = nuxBubbleView;
        }

        public final void m19169b(Spring spring) {
            if (this.f12269a.f12273b == State.DISMISSING) {
                this.f12269a.f12274c.mo902b();
            }
        }
    }

    /* compiled from: profile_wizard_nux_start */
    class BubbleSpringListener extends SimpleSpringListener {
        final /* synthetic */ NuxBubbleView f12270a;

        public BubbleSpringListener(NuxBubbleView nuxBubbleView) {
            this.f12270a = nuxBubbleView;
        }

        public final void m19170a(Spring spring) {
            this.f12270a.m19173a((float) spring.d());
        }
    }

    /* compiled from: profile_wizard_nux_start */
    public interface SizeChangeListener {
        void m19171a();
    }

    /* compiled from: profile_wizard_nux_start */
    enum State {
        GONE,
        REVEALING,
        DISMISSING
    }

    private static <T extends View> void m19175a(Class<T> cls, T t) {
        m19176a((Object) t, t.getContext());
    }

    private static void m19176a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NuxBubbleView nuxBubbleView = (NuxBubbleView) obj;
        SpringSystem b = SpringSystem.b(fbInjector);
        LayoutInflater b2 = LayoutInflaterMethodAutoProvider.b(fbInjector);
        ViewHelperViewAnimatorFactory a = ViewHelperViewAnimatorFactory.a(fbInjector);
        nuxBubbleView.f12276f = b;
        nuxBubbleView.f12281k = b2;
        nuxBubbleView.f12275d = a.a(nuxBubbleView);
    }

    public void setListener(Listener listener) {
        this.f12274c = listener;
    }

    public NuxBubbleView(Context context) {
        this(context, null);
    }

    public NuxBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12273b = State.GONE;
        this.f12274c = null;
        m19175a(NuxBubbleView.class, (View) this);
        this.f12281k.inflate(2130905516, this, true);
        this.f12282l = (TextView) c(2131564297);
        this.f12283m = (TextView) c(2131564298);
        this.f12284n = (LinearLayout) c(2131564296);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NuxBubbleView);
        this.f12278h = obtainStyledAttributes.getInt(2, 0);
        setNubPosition(this.f12278h);
        this.f12279i = obtainStyledAttributes.getInt(3, 0);
        this.f12280j = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        LayoutParams layoutParams = (LayoutParams) this.f12285o.getLayoutParams();
        switch (this.f12279i) {
            case 1:
                layoutParams.gravity |= 3;
                layoutParams.leftMargin = this.f12280j;
                break;
            case 2:
                layoutParams.gravity |= 5;
                layoutParams.rightMargin = this.f12280j;
                break;
            default:
                layoutParams.gravity |= 1;
                break;
        }
        int i = obtainStyledAttributes.getInt(1, 1);
        int paddingTop = this.f12284n.getPaddingTop();
        switch (i) {
            case 0:
                this.f12284n.setBackgroundDrawable(getResources().getDrawable(2130843701));
                c(2131564299).setBackgroundDrawable(getResources().getDrawable(2130843703));
                c(2131564300).setBackgroundDrawable(getResources().getDrawable(2130843702));
                break;
            default:
                this.f12284n.setBackgroundDrawable(getResources().getDrawable(2130843704));
                c(2131564299).setBackgroundDrawable(getResources().getDrawable(2130843706));
                c(2131564300).setBackgroundDrawable(getResources().getDrawable(2130843705));
                break;
        }
        this.f12284n.setPadding(this.f12284n.getPaddingLeft(), paddingTop, this.f12284n.getPaddingRight(), this.f12284n.getPaddingBottom());
        this.f12283m.setText(ResourceUtils.a(context, obtainStyledAttributes, 0));
        obtainStyledAttributes.recycle();
        this.f12287q = new C07971(this);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12274c != null && this.f12285o.getVisibility() == 0) {
            this.f12274c.mo901a();
        }
    }

    public void setNubPosition(int i) {
        this.f12278h = i;
        switch (this.f12278h) {
            case 1:
                this.f12285o = (ImageView) c(2131564299);
                getBubbleLayoutParams().gravity = 49;
                return;
            default:
                this.f12285o = (ImageView) c(2131564300);
                getBubbleLayoutParams().gravity = 81;
                return;
        }
    }

    public final void m19180a(ViewGroup viewGroup) {
        viewGroup.addView(this);
    }

    public final void m19183b(ViewGroup viewGroup) {
        viewGroup.removeView(this);
    }

    public void setBubbleTitle(String str) {
        this.f12282l.setText(str);
        this.f12282l.setVisibility(0);
    }

    public void setBubbleBody(CharSequence charSequence) {
        this.f12283m.setText(charSequence);
    }

    public void setBubbleParams(LayoutParams layoutParams) {
        this.f12284n.setLayoutParams(layoutParams);
    }

    public void setPointerParams(LayoutParams layoutParams) {
        this.f12285o.setLayoutParams(layoutParams);
    }

    public LayoutParams getBubbleLayoutParams() {
        return (LayoutParams) this.f12284n.getLayoutParams();
    }

    public LayoutParams getPointerLayoutParams() {
        return (LayoutParams) this.f12285o.getLayoutParams();
    }

    public int getPointerHeight() {
        return this.f12285o.getMeasuredHeight();
    }

    public int getPointerWidth() {
        return this.f12285o.getMeasuredWidth();
    }

    public final void m19181a(LayoutParams layoutParams) {
        this.f12285o.setLayoutParams(layoutParams);
        this.f12285o.requestLayout();
    }

    public int getNubRightMargin() {
        switch (this.f12279i) {
            case 1:
                return getWidth() - this.f12280j;
            case 2:
                return this.f12280j;
            default:
                return getWidth() / 2;
        }
    }

    public int getBubbleRightPadding() {
        return this.f12284n.getPaddingRight();
    }

    public void setSizeChangeListener(@Nullable SizeChangeListener sizeChangeListener) {
        this.f12286p = sizeChangeListener;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1654665741);
        super.onSizeChanged(i, i2, i3, i4);
        float f = this.f12278h == 1 ? 0.0f : (float) i2;
        switch (this.f12279i) {
            case 0:
                this.f12275d.a(((float) i) / 2.0f, f);
                break;
            case 1:
                this.f12275d.a((float) this.f12280j, f);
                break;
            case 2:
                this.f12275d.a((float) (i - this.f12280j), f);
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported nub alignment");
                LogUtils.g(-807160241, a);
                throw illegalArgumentException;
        }
        if (this.f12286p != null) {
            this.f12286p.m19171a();
        }
        LogUtils.g(-653876150, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -867745886);
        super.onAttachedToWindow();
        this.f12272a = true;
        if (this.f12277g != null) {
            this.f12277g.a();
        }
        this.f12277g = m19178h();
        this.f12277g.a(0.0d);
        this.f12277g.l();
        m19182b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1864402054, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1761245601);
        super.onDetachedFromWindow();
        this.f12272a = false;
        if (this.f12277g != null) {
            this.f12277g.a();
            this.f12277g = null;
        }
        getViewTreeObserver().removeGlobalOnLayoutListener(this.f12287q);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1845226698, a);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f12284n.setOnTouchListener(onTouchListener);
    }

    public final void m19179a() {
        this.f12284n.setOnTouchListener(null);
    }

    public final void m19182b() {
        this.f12273b = State.REVEALING;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.removeGlobalOnLayoutListener(this.f12287q);
        viewTreeObserver.addOnGlobalLayoutListener(this.f12287q);
    }

    public final void m19184e() {
        this.f12273b = State.REVEALING;
        if (this.f12272a) {
            this.f12277g.b(1.0d);
            this.f12284n.setVisibility(0);
            this.f12285o.setVisibility(0);
            return;
        }
        m19173a(1.0f);
    }

    public final void m19185f() {
        this.f12273b = State.DISMISSING;
        if (this.f12272a) {
            this.f12277g.b(0.0d);
        } else {
            m19173a(0.0f);
        }
    }

    public final boolean m19186g() {
        if (this.f12277g == null) {
            return true;
        }
        if (!this.f12277g.k() || Math.abs(this.f12277g.d()) >= this.f12277g.l) {
            return false;
        }
        return true;
    }

    private void m19173a(float f) {
        this.f12275d.e((float) SpringUtil.a((double) f, 0.0d, 0.949999988079071d));
        float a = (float) SpringUtil.a((double) f, 0.0d, 2.0d);
        this.f12275d.a(a);
        this.f12275d.c(a);
    }

    private Spring m19178h() {
        Spring a = this.f12276f.a().a(f12271e).a(new BubbleSpringListener(this));
        if (this.f12274c != null) {
            a.a(new C07982(this));
        }
        return a;
    }
}
