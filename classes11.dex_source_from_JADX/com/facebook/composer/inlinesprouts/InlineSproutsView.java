package com.facebook.composer.inlinesprouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewStub;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.feed.util.composer.sprout.SproutAdapter;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listview.BetterListView;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invite_more */
public class InlineSproutsView extends CustomFrameLayout {
    @Inject
    SpringSystem f6605a;
    @Inject
    SoftInputDetector f6606b;
    private Spring f6607c;
    private boolean f6608d;
    public BetterListView f6609e;
    public View f6610f;
    private ViewStub f6611g;
    private ExpandAnimation f6612h;
    private OnMeasuredListener f6613i;
    private StateChangeListener f6614j;
    private OnKeyboardStateChangeListener f6615k;
    private final SimpleSpringListener f6616l = new C08351(this);
    private final OnLayoutChangeListener f6617m = new C08362(this);

    /* compiled from: invite_more */
    public interface OnMeasuredListener {
        void mo185a();
    }

    /* compiled from: invite_more */
    public interface OnKeyboardStateChangeListener {
        void mo211a();

        void mo212b();
    }

    /* compiled from: invite_more */
    public interface StateChangeListener {
        void mo213a();
    }

    /* compiled from: invite_more */
    class C08351 extends SimpleSpringListener {
        final /* synthetic */ InlineSproutsView f6603a;

        C08351(InlineSproutsView inlineSproutsView) {
            this.f6603a = inlineSproutsView;
        }

        public final void m8048a(Spring spring) {
            this.f6603a.f6609e.setScaleY((float) spring.d());
        }

        public final void m8049b(Spring spring) {
            InlineSproutsView.m8059g(this.f6603a);
        }
    }

    /* compiled from: invite_more */
    class C08362 implements OnLayoutChangeListener {
        final /* synthetic */ InlineSproutsView f6604a;

        C08362(InlineSproutsView inlineSproutsView) {
            this.f6604a = inlineSproutsView;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            InlineSproutsView.m8057e(this.f6604a);
            this.f6604a.f6609e.removeOnLayoutChangeListener(this);
        }
    }

    /* compiled from: invite_more */
    public enum ExpandAnimation {
        NO_ANIMATION,
        FROM_TOP,
        FROM_BOTTOM
    }

    private static <T extends View> void m8052a(Class<T> cls, T t) {
        m8053a((Object) t, t.getContext());
    }

    private static void m8053a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InlineSproutsView) obj).m8051a(SpringSystem.b(fbInjector), SoftInputDetector.a(fbInjector));
    }

    private void m8051a(SpringSystem springSystem, SoftInputDetector softInputDetector) {
        this.f6605a = springSystem;
        this.f6606b = softInputDetector;
    }

    public InlineSproutsView(Context context) {
        super(context);
        m8054b();
    }

    public InlineSproutsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m8054b();
    }

    public InlineSproutsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8054b();
    }

    private void m8054b() {
        m8052a(InlineSproutsView.class, (View) this);
        setContentView(2130904914);
        this.f6611g = (ViewStub) c(2131563170);
        this.f6609e = (BetterListView) c(2131563171);
        this.f6608d = this.f6606b.f;
        this.f6607c = this.f6605a.a().a(SpringConfig.a(40.0d, 7.0d)).a(0.0d).b(0.0d).l().a(this.f6616l);
    }

    public final void m8061a(int i) {
        this.f6611g.setLayoutResource(i);
        this.f6610f = this.f6611g.inflate();
    }

    public void setCollapsedClickListener(OnClickListener onClickListener) {
        this.f6610f.setOnClickListener(onClickListener);
    }

    public void setStateChangeListener(StateChangeListener stateChangeListener) {
        this.f6614j = stateChangeListener;
    }

    public void setOnKeyboardStateChangeListener(OnKeyboardStateChangeListener onKeyboardStateChangeListener) {
        this.f6615k = onKeyboardStateChangeListener;
    }

    public void setOnMeasuredListener(OnMeasuredListener onMeasuredListener) {
        this.f6613i = onMeasuredListener;
    }

    public void setSproutAdapter(SproutAdapter sproutAdapter) {
        this.f6609e.setAdapter(sproutAdapter);
    }

    public void setSproutItemClickListener(OnItemClickListener onItemClickListener) {
        this.f6609e.setOnItemClickListener(onItemClickListener);
    }

    public final void m8060a() {
        this.f6610f.setVisibility(0);
        this.f6609e.setVisibility(8);
    }

    public final void m8062a(ExpandAnimation expandAnimation) {
        this.f6610f.setVisibility(8);
        this.f6609e.setVisibility(0);
        this.f6612h = expandAnimation;
        if (expandAnimation == ExpandAnimation.FROM_BOTTOM) {
            this.f6609e.addOnLayoutChangeListener(this.f6617m);
        } else if (expandAnimation == ExpandAnimation.FROM_TOP) {
            m8057e(this);
        } else {
            m8059g(this);
        }
    }

    public int getCollapsedMeasuredHeight() {
        return this.f6610f.getMeasuredHeight();
    }

    @VisibleForTesting
    View getCollapsedStateView() {
        return this.f6610f;
    }

    @VisibleForTesting
    View getExpandedListView() {
        return this.f6609e;
    }

    public static void m8057e(InlineSproutsView inlineSproutsView) {
        if (inlineSproutsView.f6612h == ExpandAnimation.FROM_TOP) {
            inlineSproutsView.f6609e.setPivotY(0.0f);
        } else {
            inlineSproutsView.f6609e.setPivotY((float) inlineSproutsView.f6609e.getHeight());
        }
        Spring spring = inlineSproutsView.f6607c;
        spring.c = false;
        spring.a(0.0d).b(1.0d);
    }

    protected void onMeasure(int i, int i2) {
        m8058f();
        super.onMeasure(i, i2);
        if (this.f6613i != null) {
            this.f6613i.mo185a();
        }
    }

    private void m8058f() {
        if (this.f6615k != null && this.f6608d != this.f6606b.f) {
            this.f6608d = this.f6606b.f;
            if (this.f6608d) {
                this.f6615k.mo211a();
            } else {
                this.f6615k.mo212b();
            }
        }
    }

    public static void m8059g(InlineSproutsView inlineSproutsView) {
        if (inlineSproutsView.f6614j != null) {
            inlineSproutsView.f6614j.mo213a();
        }
    }
}
