package com.facebook.messaging.composer.triggers;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import javax.inject.Inject;

/* compiled from: messenger_inbox_unit_type */
public class ContentSearchResultItemView extends CustomFrameLayout {
    private static final SpringConfig f9819b = new SpringConfig(1000.0d, 50.0d);
    private static final SpringConfig f9820c = new SpringConfig(120.0d, 10.0d);
    @Inject
    public SpringSystem f9821a;
    private Spring f9822d;
    public FbDraweeView f9823e;
    private ViewStubHolder<View> f9824f;

    /* compiled from: messenger_inbox_unit_type */
    class PressSpringListener extends SimpleSpringListener {
        final /* synthetic */ ContentSearchResultItemView f9818a;

        public PressSpringListener(ContentSearchResultItemView contentSearchResultItemView) {
            this.f9818a = contentSearchResultItemView;
        }

        public final void m10385a(Spring spring) {
            float d = 1.0f - (((float) spring.d()) * 0.15f);
            this.f9818a.setScaleX(d);
            this.f9818a.setScaleY(d);
        }
    }

    private static <T extends View> void m10388a(Class<T> cls, T t) {
        m10389a((Object) t, t.getContext());
    }

    private static void m10389a(Object obj, Context context) {
        ((ContentSearchResultItemView) obj).f9821a = SpringSystem.b(FbInjector.get(context));
    }

    public ContentSearchResultItemView(Context context) {
        super(context);
        m10386a();
    }

    public ContentSearchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10386a();
    }

    public ContentSearchResultItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10386a();
    }

    private void m10386a() {
        m10388a(ContentSearchResultItemView.class, (View) this);
        setContentView(2130903791);
        this.f9823e = (FbDraweeView) findViewById(2131560774);
        this.f9824f = ViewStubHolder.a((ViewStubCompat) findViewById(2131560775));
        this.f9822d = this.f9821a.a().a(f9819b).a(new PressSpringListener(this));
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
        if (z) {
            this.f9822d.a(f9819b).b(1.0d);
        } else {
            this.f9822d.a(f9820c).b(0.0d);
        }
    }

    public void setHierarchy(GenericDraweeHierarchy genericDraweeHierarchy) {
        this.f9823e.setHierarchy(genericDraweeHierarchy);
    }

    public FbDraweeView getDraweeView() {
        return this.f9823e;
    }

    public void setShowErrorVisible(boolean z) {
        if (z) {
            this.f9824f.f();
        } else {
            this.f9824f.e();
        }
    }

    private void m10387a(SpringSystem springSystem) {
        this.f9821a = springSystem;
    }
}
