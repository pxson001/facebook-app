package com.facebook.facecastdisplay;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio/mp4a-latm */
public class LiveVideoStatusView extends CustomLinearLayout {
    @Inject
    public NumberTruncationUtil f18973a;
    @Inject
    public GatekeeperStoreImpl f18974b;
    protected final BetterTextView f18975c;
    private final View f18976d;
    private final TextView f18977e;
    public final ObjectAnimator f18978f;
    private final GlyphWithTextView f18979g;
    private final GlyphWithTextView f18980h;
    private final Runnable f18981i;
    private final TextView f18982j;
    private int f18983k;
    public int f18984l;
    private boolean f18985m;
    private IndicatorType f18986n;

    /* compiled from: audio/mp4a-latm */
    class C16481 implements OnClickListener {
        final /* synthetic */ LiveVideoStatusView f18968a;

        C16481(LiveVideoStatusView liveVideoStatusView) {
            this.f18968a = liveVideoStatusView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -665243385);
            this.f18968a.m22562a(true);
            Logger.a(2, EntryType.UI_INPUT_END, -5410684, a);
        }
    }

    /* compiled from: audio/mp4a-latm */
    class C16492 implements Runnable {
        final /* synthetic */ LiveVideoStatusView f18969a;

        C16492(LiveVideoStatusView liveVideoStatusView) {
            this.f18969a = liveVideoStatusView;
        }

        public void run() {
            LiveVideoStatusView.m22559e(this.f18969a);
        }
    }

    /* compiled from: audio/mp4a-latm */
    public enum IndicatorType {
        LIVE,
        BROADCAST_COMMERCIAL_BREAK,
        VIEWER_COMMERCIAL_BREAK
    }

    private static <T extends View> void m22556a(Class<T> cls, T t) {
        m22557a((Object) t, t.getContext());
    }

    private static void m22557a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LiveVideoStatusView liveVideoStatusView = (LiveVideoStatusView) obj;
        NumberTruncationUtil a = NumberTruncationUtil.a(fbInjector);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        liveVideoStatusView.f18973a = a;
        liveVideoStatusView.f18974b = a2;
    }

    public LiveVideoStatusView(Context context) {
        this(context, null);
    }

    public LiveVideoStatusView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveVideoStatusView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18986n = IndicatorType.LIVE;
        m22556a(LiveVideoStatusView.class, (View) this);
        setContentView(2130905101);
        this.f18976d = a(2131563492);
        this.f18977e = (TextView) a(2131563529);
        Drawable background = this.f18976d.getBackground();
        background.setAlpha(255);
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofInt("alpha", new int[]{179});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(background, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration(700);
        ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(2);
        this.f18978f = ofPropertyValuesHolder;
        this.f18975c = (BetterTextView) a(2131563525);
        this.f18979g = (GlyphWithTextView) a(2131563526);
        this.f18980h = (GlyphWithTextView) a(2131563528);
        this.f18982j = (TextView) a(2131563524);
        if (m22560f()) {
            a(2131563492).setOnClickListener(new C16481(this));
        }
        this.f18981i = new C16492(this);
    }

    public final void m22561a() {
        this.f18983k = 0;
        setViewerCount(this.f18983k);
    }

    public void setIsLiveNow(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public void setViewerCount(int i) {
        this.f18983k = i;
        this.f18984l = Math.max(this.f18983k, this.f18984l);
        if (i > 0) {
            CharSequence a = this.f18973a.a(i, 1);
            this.f18979g.setText(a);
            this.f18980h.setText(a);
            m22558b(false);
            return;
        }
        this.f18979g.setVisibility(8);
        this.f18980h.setVisibility(8);
    }

    public void setIndicatorType(IndicatorType indicatorType) {
        this.f18986n = indicatorType;
        m22558b(true);
    }

    private void m22558b(boolean z) {
        switch (this.f18986n) {
            case LIVE:
                this.f18976d.setVisibility(0);
                this.f18977e.setVisibility(8);
                this.f18980h.setVisibility(8);
                if (this.f18983k > 0) {
                    this.f18979g.setVisibility(0);
                    return;
                }
                return;
            case BROADCAST_COMMERCIAL_BREAK:
                this.f18976d.setVisibility(8);
                this.f18979g.setVisibility(8);
                this.f18977e.setText(getResources().getString(2131232724));
                this.f18977e.setVisibility(0);
                if (this.f18983k > 0) {
                    this.f18980h.setVisibility(0);
                    if (z) {
                        this.f18980h.setAlpha(0.0f);
                        this.f18980h.animate().alpha(1.0f).setDuration(300);
                        this.f18977e.setAlpha(0.0f);
                        this.f18977e.animate().alpha(1.0f).setDuration(300);
                        return;
                    }
                    return;
                }
                return;
            case VIEWER_COMMERCIAL_BREAK:
                this.f18976d.setVisibility(8);
                this.f18979g.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public static void m22559e(LiveVideoStatusView liveVideoStatusView) {
        final int width = liveVideoStatusView.f18975c.getWidth();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new AnimatorUpdateListener(liveVideoStatusView) {
            final /* synthetic */ LiveVideoStatusView f18971b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveVideoStatusView.setTimerWidth(this.f18971b, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) width)));
            }
        });
        ofFloat.start();
    }

    private boolean m22560f() {
        return !this.f18974b.a(582, false);
    }

    public ObjectAnimator getLiveAnimator() {
        return this.f18978f;
    }

    public int getMaxViewersDisplayed() {
        return this.f18984l;
    }

    public final void m22563b() {
        if (m22560f()) {
            setTimerWidth(this, 0);
        }
        this.f18975c.setVisibility(0);
        setTimeElapsed(0);
    }

    public final void m22562a(boolean z) {
        setTimerWidth(this, -2);
        this.f18975c.setVisibility(0);
        this.f18975c.removeCallbacks(this.f18981i);
        if (z) {
            this.f18975c.postDelayed(this.f18981i, 3000);
        }
    }

    public final void m22564c() {
        this.f18975c.post(this.f18981i);
    }

    public static void setTimerWidth(LiveVideoStatusView liveVideoStatusView, int i) {
        liveVideoStatusView.f18975c.getLayoutParams().width = i;
        liveVideoStatusView.f18975c.requestLayout();
        liveVideoStatusView.f18975c.invalidate();
    }

    public void setTimeElapsed(long j) {
        this.f18975c.setText(FacecastUiUtil.m3100a(j));
    }

    public final void m22565d() {
        this.f18975c.setText("");
    }

    public void setIsSmall(boolean z) {
        if (this.f18985m != z) {
            this.f18985m = z;
            float dimension = getResources().getDimension(this.f18985m ? 2131428227 : 2131428226);
            this.f18982j.setTextSize(0, dimension);
            this.f18979g.setTextSize(0, dimension);
            int dimensionPixelSize = getResources().getDimensionPixelSize(this.f18985m ? 2131428229 : 2131428228);
            m22553a(this.f18976d, dimensionPixelSize);
            m22553a(this.f18979g, dimensionPixelSize);
            dimensionPixelSize = getResources().getDimensionPixelOffset(this.f18985m ? 2131428231 : 2131428230);
            this.f18976d.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.f18979g.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            dimensionPixelSize = getResources().getDimensionPixelOffset(this.f18985m ? 2131428235 : 2131428234);
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            ((MarginLayoutParams) this.f18979g.getLayoutParams()).setMargins(getResources().getDimensionPixelOffset(this.f18985m ? 2131428233 : 2131428232), 0, 0, 0);
            GlyphWithTextView glyphWithTextView = this.f18979g;
            if (this.f18985m) {
                dimensionPixelSize = 2130839858;
            } else {
                dimensionPixelSize = 2130839857;
            }
            glyphWithTextView.setImageResource(dimensionPixelSize);
        }
    }

    private static void m22553a(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }
}
