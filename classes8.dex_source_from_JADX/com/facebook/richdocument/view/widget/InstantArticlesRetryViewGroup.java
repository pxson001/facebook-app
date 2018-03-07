package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: on_login_gms_dialog_seen */
public class InstantArticlesRetryViewGroup extends RichDocumentRetryViewGroup implements TouchSpringUpdateListener {
    private static final SpringConfig f7209d = SpringConfig.b(RichDocumentUIConfig.f6537H, RichDocumentUIConfig.f6538I);
    private static final SpringConfig f7210e = SpringConfig.b(RichDocumentUIConfig.f6535F, RichDocumentUIConfig.f6536G);
    @Inject
    HamDimensions f7211a;
    @Inject
    Provider<TouchSpring> f7212b;
    @Inject
    SpringSystem f7213c;
    private ImageView f7214f;
    public final TouchSpring f7215g;
    private final Spring f7216h;
    private final FadeSpringListener f7217i;

    /* compiled from: on_login_gms_dialog_seen */
    class C08251 implements OnTouchListener {
        final /* synthetic */ InstantArticlesRetryViewGroup f7207a;

        C08251(InstantArticlesRetryViewGroup instantArticlesRetryViewGroup) {
            this.f7207a = instantArticlesRetryViewGroup;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f7207a.f7215g != null && this.f7207a.f7215g.onTouch(view, motionEvent);
        }
    }

    /* compiled from: on_login_gms_dialog_seen */
    class FadeSpringListener extends SimpleSpringListener {
        private final WeakReference<InstantArticlesRetryViewGroup> f7208a;

        public FadeSpringListener(InstantArticlesRetryViewGroup instantArticlesRetryViewGroup) {
            this.f7208a = new WeakReference(instantArticlesRetryViewGroup);
        }

        public final void m7472a(Spring spring) {
            float d = (float) spring.d();
            if (this.f7208a.get() != null) {
                InstantArticlesRetryViewGroup.m7481c((InstantArticlesRetryViewGroup) this.f7208a.get(), d);
            }
        }
    }

    private static <T extends View> void m7478a(Class<T> cls, T t) {
        m7479a((Object) t, t.getContext());
    }

    private static void m7479a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InstantArticlesRetryViewGroup) obj).m7476a(HamDimensions.m5268a(injectorLike), IdBasedProvider.a(injectorLike, 3736), SpringSystem.b(injectorLike));
    }

    public InstantArticlesRetryViewGroup(Context context) {
        this(context, null);
    }

    public InstantArticlesRetryViewGroup(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InstantArticlesRetryViewGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7478a(InstantArticlesRetryViewGroup.class, (View) this);
        this.f7215g = (TouchSpring) this.f7212b.get();
        this.f7215g.a(this);
        this.f7215g.d = true;
        this.f7215g.c = 1.0f;
        this.f7215g.a(f7209d);
        Spring c = this.f7213c.a().a(f7210e).c(0.0d);
        c.c = true;
        this.f7216h = c;
        this.f7217i = new FadeSpringListener(this);
        this.f7216h.a(this.f7217i);
    }

    public void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -85903237);
        super.onFinishInflate();
        this.f7214f = (ImageView) findViewById(2131563022);
        this.f7214f.setOnTouchListener(new C08251(this));
        int b = this.f7211a.m5276b(2131558658);
        int b2 = this.f7211a.m5276b(2131558657);
        int b3 = this.f7211a.m5276b(2131558651);
        FbTextView fbTextView = (FbTextView) findViewById(2131563019);
        FbTextView fbTextView2 = (FbTextView) findViewById(2131563020);
        FbTextView fbTextView3 = (FbTextView) findViewById(2131563021);
        LayoutParams layoutParams = (LayoutParams) fbTextView2.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, b3, layoutParams.rightMargin, layoutParams.bottomMargin);
        fbTextView2.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.f7214f.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, b3, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.f7214f.setLayoutParams(layoutParams);
        fbTextView.setTextSize(0, (float) b);
        fbTextView2.setTextSize(0, (float) b2);
        fbTextView3.setTextSize(0, (float) b2);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -430751126, a);
    }

    protected View getRetryButton() {
        return this.f7214f;
    }

    public final void mo457a() {
        this.f7216h.b(0.0d);
    }

    public final void mo458b() {
        this.f7216h.a(1.0d);
        this.f7216h.b(1.0d);
        setVisibility(0);
        setAlpha(1.0f);
    }

    public boolean isPressed() {
        return this.f7214f.isPressed();
    }

    public boolean performClick() {
        this.f7214f.performClick();
        return true;
    }

    public final void m7483a(float f) {
        m7480b(f);
    }

    private void m7480b(float f) {
        float f2 = 1.0f * f;
        this.f7214f.setScaleX(f2);
        this.f7214f.setScaleY(f2);
    }

    public static void m7481c(InstantArticlesRetryViewGroup instantArticlesRetryViewGroup, float f) {
        instantArticlesRetryViewGroup.setAlpha(f);
        if (f <= RichDocumentUIConfig.f6566s) {
            instantArticlesRetryViewGroup.setVisibility(8);
        }
    }

    private void m7476a(HamDimensions hamDimensions, Provider<TouchSpring> provider, SpringSystem springSystem) {
        this.f7211a = hamDimensions;
        this.f7212b = provider;
        this.f7213c = springSystem;
    }
}
