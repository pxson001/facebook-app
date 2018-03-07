package com.facebook.timeline.header.externalLinks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.FlowLayout;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: fileordoc */
public class IntroCardExternalLinksView extends CustomLinearLayout {
    @Inject
    public AllCapsTransformationMethod f11697a;
    private FlowLayout f11698b;
    private LazyView<FbTextView> f11699c;

    private static <T extends View> void m11771a(Class<T> cls, T t) {
        m11772a((Object) t, t.getContext());
    }

    private static void m11772a(Object obj, Context context) {
        ((IntroCardExternalLinksView) obj).f11697a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    private void m11770a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f11697a = allCapsTransformationMethod;
    }

    public IntroCardExternalLinksView(Context context) {
        super(context);
        m11773c();
    }

    public IntroCardExternalLinksView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11773c();
    }

    private void m11773c() {
        m11771a(IntroCardExternalLinksView.class, (View) this);
        setContentView(2130907455);
        setOrientation(1);
        this.f11698b = (FlowLayout) findViewById(2131567936);
        this.f11699c = new LazyView((ViewStub) findViewById(2131567937));
    }

    public final void m11774a() {
        this.f11698b.removeAllViews();
    }

    public final void m11776a(IntroCardExternalLinkView introCardExternalLinkView) {
        this.f11698b.addView(introCardExternalLinkView);
    }

    public final void m11775a(OnClickListener onClickListener) {
        FbTextView fbTextView = (FbTextView) this.f11699c.a();
        fbTextView.setTransformationMethod(this.f11697a);
        fbTextView.setOnClickListener(onClickListener);
    }

    public final void m11777b() {
        this.f11699c.c();
    }
}
