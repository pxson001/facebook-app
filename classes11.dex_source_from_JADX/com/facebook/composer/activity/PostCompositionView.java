package com.facebook.composer.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.actionitem.ActionItemListController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.ContentWrappingLinearLayoutManager;
import com.facebook.widget.recyclerview.DividerDecorator;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(15)
/* compiled from: invite_suggestions */
public class PostCompositionView extends CustomFrameLayout {
    @Inject
    public SpringSystem f6214a;
    private Spring f6215b;
    public OnHideListener f6216c = null;
    private BetterRecyclerView f6217d;
    public boolean f6218e;
    public int f6219f;

    /* compiled from: invite_suggestions */
    public interface OnHideListener {
        void mo183a();
    }

    /* compiled from: invite_suggestions */
    class C07741 implements OnClickListener {
        final /* synthetic */ PostCompositionView f6212a;

        C07741(PostCompositionView postCompositionView) {
            this.f6212a = postCompositionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -708064448);
            this.f6212a.m7656a();
            Logger.a(2, EntryType.UI_INPUT_END, 2069494353, a);
        }
    }

    /* compiled from: invite_suggestions */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ PostCompositionView f6213a;

        public SpringListener(PostCompositionView postCompositionView) {
            this.f6213a = postCompositionView;
        }

        public final void m7645a(Spring spring) {
            float d = (float) spring.d();
            if (this.f6213a.f6218e) {
                this.f6213a.setAlpha(d);
            }
            this.f6213a.setY((float) this.f6213a.f6219f);
        }

        public final void m7646b(Spring spring) {
            if (spring.g(0.0d)) {
                this.f6213a.setVisibility(8);
            }
            this.f6213a.f6218e = false;
        }
    }

    private static <T extends View> void m7648a(Class<T> cls, T t) {
        m7649a((Object) t, t.getContext());
    }

    private static void m7649a(Object obj, Context context) {
        ((PostCompositionView) obj).f6214a = SpringSystem.b(FbInjector.get(context));
    }

    public PostCompositionView(Context context) {
        super(context);
        m7653b();
    }

    public PostCompositionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7653b();
    }

    public PostCompositionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7653b();
    }

    private void m7653b() {
        m7648a(PostCompositionView.class, (View) this);
        setContentView(2130906347);
        this.f6217d = (BetterRecyclerView) c(2131566185);
        this.f6217d.a(new DividerDecorator(getResources().getColor(2131361940), getResources().getDimensionPixelSize(2131429703)));
        m7655f();
        setVisibility(8);
    }

    public void setOnHideListener(@Nullable OnHideListener onHideListener) {
        this.f6216c = onHideListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 387112705);
        super.onAttachedToWindow();
        m7654e();
        this.f6215b.a(new SpringListener(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1163602218, a);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f6219f == 0) {
            this.f6219f = ((View) getParent()).findViewById(2131560528).getBottom();
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - this.f6219f);
        setY((float) this.f6219f);
    }

    private void m7654e() {
        setOnClickListener(new C07741(this));
    }

    private void m7655f() {
        this.f6215b = this.f6214a.a().a(SpringConfig.a(40.0d, 7.0d)).a(0.0d).b(0.0d).l();
    }

    public final void m7657a(ActionItemListController actionItemListController, boolean z) {
        actionItemListController.f5934f = this.f6217d;
        actionItemListController.f5933e = new ContentWrappingLinearLayoutManager(actionItemListController.f5929a);
        actionItemListController.f5933e.b(1);
        actionItemListController.f5934f.setLayoutManager(actionItemListController.f5933e);
        actionItemListController.f5934f.setAdapter(actionItemListController.f5931c);
        if (z) {
            this.f6218e = true;
            Spring spring = this.f6215b;
            spring.c = false;
            spring.b(1.0d);
        } else {
            this.f6215b.a(1.0d).l();
        }
        setVisibility(0);
    }

    public final void m7656a() {
        this.f6218e = true;
        Spring spring = this.f6215b;
        spring.c = true;
        spring.b(0.0d);
        if (this.f6216c != null) {
            this.f6216c.mo183a();
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1200859583);
        if (this.f6215b != null) {
            this.f6215b.m();
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 592733719, a);
    }

    private void m7647a(SpringSystem springSystem) {
        this.f6214a = springSystem;
    }
}
