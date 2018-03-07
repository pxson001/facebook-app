package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.feedback.reactions.socialcontext.SocialContextHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: glTexParameter */
public class PillsBlingBarView extends CustomLinearLayout {
    public static final ViewType f22227a = new C09001();
    private Segment f22228A;
    private Segment f22229B;
    private Segment f22230C;
    private Segment f22231D;
    private Segment f22232E;
    private Segment f22233F;
    private Segment f22234G;
    @Inject
    NumberTruncationUtil f22235b;
    @Inject
    RTLUtil f22236c;
    @Inject
    Provider<TokenPileDrawable> f22237d;
    @Inject
    TokenPileHelper f22238e;
    @Inject
    @PillsBlingBarTextSize
    Provider<Integer> f22239f;
    @Inject
    SocialContextHelper f22240g;
    private final Resources f22241h;
    private float f22242i;
    private float f22243j;
    private final float[] f22244k;
    private Paint f22245l;
    private int f22246m;
    private int f22247n;
    private int f22248o;
    private float f22249p;
    public boolean f22250q;
    private boolean f22251r;
    private OnClickListener f22252s;
    private TokenPileDrawable f22253t;
    private GraphQLFeedback f22254u;
    private int f22255v;
    private Segment[] f22256w;
    private int f22257x;
    private int f22258y;
    private int f22259z;

    /* compiled from: glTexParameter */
    final class C09001 extends ViewType {
        C09001() {
        }

        public final View mo1995a(Context context) {
            return new PillsBlingBarView(context);
        }
    }

    /* compiled from: glTexParameter */
    public class Segment {
        public static final Segment f22269a = new Segment();
        public int f22270b;
        public int f22271c;
        public OnClickListener f22272d;

        public final int m30203a() {
            return this.f22270b;
        }

        public final int m30206b() {
            return this.f22271c;
        }

        public final OnClickListener m30207c() {
            return this.f22272d;
        }

        public final void m30205a(OnClickListener onClickListener) {
            this.f22272d = onClickListener;
        }

        public void mo3249a(Canvas canvas) {
        }
    }

    /* compiled from: glTexParameter */
    public class TextSegment extends Segment {
        public String f22276e;
        private Paint f22277f;
        private final float f22278g;

        public TextSegment(String str, int i, float f, int i2, Paint paint) {
            this.f22276e = str;
            this.b = i;
            this.c = i2;
            this.f22277f = paint;
            this.f22278g = f;
        }

        public final void mo3249a(Canvas canvas) {
            canvas.drawText(this.f22276e, 0.0f, this.f22278g, this.f22277f);
        }

        public final String m30210d() {
            return this.f22276e;
        }
    }

    /* compiled from: glTexParameter */
    public class TokenPileSegment extends Segment {
        private TokenPileDrawable f22289e;

        public TokenPileSegment(int i, int i2, TokenPileDrawable tokenPileDrawable) {
            this.c = i;
            this.b = i2;
            this.f22289e = tokenPileDrawable;
        }

        public final void mo3249a(Canvas canvas) {
            this.f22289e.draw(canvas);
        }
    }

    private static <T extends View> void m30166a(Class<T> cls, T t) {
        m30167a((Object) t, t.getContext());
    }

    private static void m30167a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PillsBlingBarView) obj).m30164a(NumberTruncationUtil.m9609a(injectorLike), RTLUtil.m6553a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1788), TokenPileHelper.m30171a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4415), SocialContextHelper.m9606b(injectorLike));
    }

    public PillsBlingBarView(Context context) {
        this(context, null);
    }

    public PillsBlingBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PillsBlingBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22244k = new float[2];
        m30166a(PillsBlingBarView.class, (View) this);
        setWillNotDraw(false);
        this.f22241h = context.getResources();
        this.f22243j = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        m30161a();
        m30162a(this.f22241h);
        TrackingNodes.m27141a((View) this, TrackingNode.BLINGBOX);
    }

    private void m30162a(Resources resources) {
        this.f22245l = new Paint();
        this.f22245l.setTextSize((float) resources.getDimensionPixelSize(((Integer) this.f22239f.get()).intValue() != 0 ? ((Integer) this.f22239f.get()).intValue() : 2131427400));
        setTextColor(resources.getColor(2131361937));
        this.f22245l.setTextAlign(Align.LEFT);
        this.f22245l.setAntiAlias(true);
        this.f22245l.setLinearText(true);
        this.f22242i = this.f22245l.descent() - this.f22245l.ascent();
        this.f22247n = resources.getDimensionPixelSize(2131430647);
        this.f22248o = resources.getDimensionPixelSize(2131430648);
        this.f22246m = resources.getDimensionPixelSize(2131430644);
    }

    private void m30161a() {
        this.f22228A = Segment.f22269a;
        this.f22229B = Segment.f22269a;
        this.f22230C = Segment.f22269a;
        this.f22231D = Segment.f22269a;
        this.f22232E = Segment.f22269a;
        this.f22233F = Segment.f22269a;
        this.f22234G = Segment.f22269a;
    }

    public void setLikesCount(GraphQLFeedback graphQLFeedback) {
        m30165a(graphQLFeedback, GraphQLHelper.m22522p(graphQLFeedback));
    }

    public void setReactorsCount(GraphQLFeedback graphQLFeedback) {
        m30165a(graphQLFeedback, GraphQLHelper.m22523q(graphQLFeedback));
    }

    private void m30165a(GraphQLFeedback graphQLFeedback, int i) {
        if (this.f22230C.f22271c != i) {
            this.f22255v = i;
            this.f22230C = i == 0 ? Segment.f22269a : m30160a(i, 2131689642);
        }
        this.f22254u = graphQLFeedback;
        this.f22228A = m30159a(i, graphQLFeedback);
        this.f22229B = i == 0 ? Segment.f22269a : m30168b(i, graphQLFeedback);
        m30169b();
    }

    public void setCommentsCount(int i) {
        if (this.f22231D.f22271c != i) {
            this.f22231D = i == 0 ? Segment.f22269a : m30160a(i, 2131689643);
            m30169b();
        }
    }

    public void setSharesCount(int i) {
        if (this.f22232E.f22271c != i) {
            this.f22232E = i == 0 ? Segment.f22269a : m30160a(i, 2131689647);
            m30169b();
        }
    }

    public void setViewsCount(int i) {
        if (this.f22233F.f22271c != i) {
            this.f22233F = i == 0 ? Segment.f22269a : m30160a(i, 2131689644);
            m30169b();
        }
    }

    public void setSeenByCount(int i) {
        if (this.f22234G.f22271c != i) {
            this.f22234G = i == 0 ? Segment.f22269a : m30160a(i, 2131689645);
            m30169b();
        }
        setSeenByClickListener(this.f22252s);
    }

    public void setSeenByClickListener(OnClickListener onClickListener) {
        this.f22252s = onClickListener;
        if (this.f22234G != Segment.f22269a) {
            this.f22234G.f22272d = onClickListener;
        }
    }

    private void m30169b() {
        invalidate();
        requestLayout();
    }

    public void setTextColor(int i) {
        this.f22245l.setColor(i);
    }

    public void setClipTokens(boolean z) {
        this.f22250q = z;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
        if (this.f22229B.f22271c <= 0 || m30158a(this.f22229B) > ((measuredWidth - m30158a(this.f22228A)) - m30158a(this.f22231D)) - m30158a(this.f22232E)) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int i4 = 1 << i3;
        if (this.f22255v > 0) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.f22258y = i3;
        Segment[] segmentArr = new Segment[]{this.f22228A, this.f22229B, this.f22230C, this.f22231D, this.f22232E, this.f22233F, this.f22234G};
        i3 = measuredWidth;
        int i5 = 0;
        for (int i6 = 0; i6 < 7; i6++) {
            Segment segment = segmentArr[i6];
            if (((1 << i6) & i4) == 0 && segment.f22271c > 0 && segment.f22270b + this.f22247n <= i3) {
                i5 |= 1 << i6;
                i3 -= segment.f22270b + this.f22247n;
            }
        }
        i3 += this.f22247n;
        this.f22256w = segmentArr;
        this.f22257x = i5;
        this.f22259z = i3;
        setMeasuredDimension(View.resolveSize(MeasureSpec.getSize(i), i), View.resolveSize(((this.f22257x == 0 ? 0 : this.f22246m) + getPaddingTop()) + getPaddingBottom(), i2));
        this.f22249p = ((float) (this.f22246m - this.f22248o)) / 2.0f;
    }

    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        boolean a = this.f22236c.m6557a();
        int i2 = !a ? 0 : -1;
        if (a) {
            i = 0;
        } else {
            i = 1;
        }
        canvas.save();
        canvas.translate(!a ? (float) getPaddingStart() : (float) (getMeasuredWidth() - getPaddingStart()), ((float) getPaddingTop()) + this.f22249p);
        int i3 = 0;
        while (i3 < this.f22256w.length) {
            if ((this.f22257x & (1 << i3)) > 0) {
                Segment segment = this.f22256w[i3];
                int i4 = (a && i3 == 0) ? 0 : this.f22247n;
                i4 += segment.f22270b;
                canvas.translate((float) (i4 * i2), 0.0f);
                segment.mo3249a(canvas);
                canvas.translate((float) (i4 * i), 0.0f);
            }
            if (i3 == this.f22258y) {
                canvas.translate((float) (this.f22259z * i2), 0.0f);
                canvas.translate((float) (this.f22259z * i), 0.0f);
            }
            i3++;
        }
        canvas.restore();
    }

    @VisibleForTesting
    public int getReactionsCount() {
        return this.f22255v;
    }

    @VisibleForTesting
    public int getCommentsCount() {
        return this.f22231D.f22271c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -580796130);
        switch (motionEvent.getAction()) {
            case 0:
                this.f22244k[0] = motionEvent.getX();
                this.f22244k[1] = motionEvent.getY();
                this.f22251r = false;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (!this.f22251r) {
                    m30163a(motionEvent);
                    sendAccessibilityEvent(1);
                    break;
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (Math.abs(this.f22244k[0] - motionEvent.getX()) > this.f22243j || Math.abs(this.f22244k[1] - motionEvent.getY()) > this.f22243j) {
                    this.f22251r = true;
                    break;
                }
        }
        LogUtils.a(1340442477, a);
        return true;
    }

    private void m30163a(MotionEvent motionEvent) {
        int i;
        boolean a = this.f22236c.m6557a();
        int i2 = !a ? 0 : -1;
        if (a) {
            i = 0;
        } else {
            i = 1;
        }
        int paddingStart = !a ? getPaddingStart() : getMeasuredWidth() - getPaddingStart();
        int i3 = 0;
        while (i3 < this.f22256w.length) {
            if ((this.f22257x & (1 << i3)) == (1 << i3)) {
                Segment segment = this.f22256w[i3];
                int i4 = (a && i3 == 0) ? 0 : this.f22247n;
                i4 += segment.f22270b;
                paddingStart += i4 * i2;
                if (motionEvent.getX() <= ((float) paddingStart) || motionEvent.getX() >= ((float) (segment.f22270b + paddingStart))) {
                    paddingStart += i4 * i;
                } else {
                    if (segment.f22272d != null) {
                        segment.f22272d.onClick(this);
                        return;
                    }
                    callOnClick();
                }
            }
            if (i3 == this.f22258y) {
                paddingStart = (paddingStart + (this.f22259z * i2)) + (this.f22259z * i);
            }
            i3++;
        }
        callOnClick();
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        ImmutableList of = ImmutableList.of(m30160a(this.f22255v, GraphQLHelper.m22523q(this.f22254u) == GraphQLHelper.m22522p(this.f22254u) ? 2131689522 : 2131689646), this.f22231D, this.f22232E, this.f22233F, this.f22234G);
        List text = accessibilityEvent.getText();
        int size = of.size();
        for (int i = 0; i < size; i++) {
            Segment segment = (Segment) of.get(i);
            if (segment.f22271c > 0 && (segment instanceof TextSegment)) {
                text.add(((TextSegment) segment).f22276e);
            }
        }
    }

    private Segment m30159a(int i, GraphQLFeedback graphQLFeedback) {
        if (this.f22253t == null) {
            this.f22253t = (TokenPileDrawable) this.f22237d.get();
        }
        this.f22253t.m30215a(this.f22238e.m30174a(graphQLFeedback));
        this.f22253t.m30216a(this.f22250q);
        return new TokenPileSegment(i, this.f22253t.getIntrinsicWidth(), this.f22253t);
    }

    private Segment m30168b(int i, GraphQLFeedback graphQLFeedback) {
        String b = this.f22240g.m9607b(graphQLFeedback);
        if (Strings.isNullOrEmpty(b)) {
            return Segment.f22269a;
        }
        return new TextSegment(b, (int) (this.f22245l.measureText(b) + 0.5f), (((float) (this.f22248o / 2)) + (this.f22242i / 2.0f)) - this.f22245l.descent(), i, this.f22245l);
    }

    private TextSegment m30160a(int i, int i2) {
        String a = this.f22235b.m9623a(i);
        if (i > 0 && i2 > 0) {
            a = this.f22241h.getQuantityString(i2, i, new Object[]{a});
        }
        return new TextSegment(a, (int) (this.f22245l.measureText(a) + 0.5f), (((float) (this.f22248o / 2)) + (this.f22242i / 2.0f)) - this.f22245l.descent(), i, this.f22245l);
    }

    private int m30158a(Segment segment) {
        if (segment.f22271c <= 0) {
            return 0;
        }
        return segment.f22270b + this.f22247n;
    }

    private void m30164a(NumberTruncationUtil numberTruncationUtil, RTLUtil rTLUtil, Provider<TokenPileDrawable> provider, TokenPileHelper tokenPileHelper, Provider<Integer> provider2, SocialContextHelper socialContextHelper) {
        this.f22235b = numberTruncationUtil;
        this.f22236c = rTLUtil;
        this.f22237d = provider;
        this.f22238e = tokenPileHelper;
        this.f22239f = provider2;
        this.f22240g = socialContextHelper;
    }
}
