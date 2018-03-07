package com.facebook.messaging.composer.block;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.CustomUrlLikeSpan;
import com.facebook.widget.text.CustomUrlLikeSpan.OnUrlClickHandler;
import javax.annotation.Nullable;

/* compiled from: thread.isForUser */
public class BlockComposerView extends CustomFrameLayout {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LinkHandlingHelper> f1697a = UltralightRuntime.b;
    @Nullable
    public BlockComposerViewParams f1698b;
    private TextView f1699c;

    /* compiled from: thread.isForUser */
    class C02731 extends OnUrlClickHandler {
        final /* synthetic */ BlockComposerView f1696a;

        C02731(BlockComposerView blockComposerView) {
            this.f1696a = blockComposerView;
        }

        public final void m1672a() {
            ((LinkHandlingHelper) this.f1696a.f1697a.get()).a(this.f1696a.getContext(), this.f1696a.f1698b.f1704e);
        }
    }

    private static <T extends View> void m1676a(Class<T> cls, T t) {
        m1677a((Object) t, t.getContext());
    }

    private static void m1677a(Object obj, Context context) {
        ((BlockComposerView) obj).f1697a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 7898);
    }

    public BlockComposerView(Context context) {
        super(context);
        m1674a();
    }

    private void m1675a(com.facebook.inject.Lazy<LinkHandlingHelper> lazy) {
        this.f1697a = lazy;
    }

    public BlockComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1674a();
    }

    public BlockComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1674a();
    }

    private void m1674a() {
        m1676a(BlockComposerView.class, (View) this);
        setContentView(2130905569);
        this.f1699c = (TextView) c(2131564454);
    }

    public void setParams(@Nullable BlockComposerViewParams blockComposerViewParams) {
        if (this.f1698b == null || !this.f1698b.equals(blockComposerViewParams)) {
            this.f1698b = blockComposerViewParams;
            m1680b();
            m1678a(this.f1698b.f1704e != null);
        }
    }

    private void m1678a(boolean z) {
        m1680b();
        Resources resources = getResources();
        if (z) {
            this.f1699c.setText(getSpannableInfoMessage());
            this.f1699c.setLinkTextColor(resources.getColor(this.f1698b.f1701b));
            this.f1699c.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            this.f1699c.setText(this.f1698b.f1700a);
        }
        this.f1699c.setTextColor(resources.getColor(this.f1698b.f1701b));
        this.f1699c.setBackgroundResource(this.f1698b.f1702c);
    }

    private void m1680b() {
        if (this.f1698b == null) {
            this.f1698b = BlockComposerViewParamsFactory.m1693a(null);
        }
    }

    private SpannableString getSpannableInfoMessage() {
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(getResources().getString(this.f1698b.f1700a));
        styledStringBuilder.a("[[link_learn_more]]", getResources().getString(this.f1698b.f1703d), getLearnMoreLinkSpan(), 33);
        return styledStringBuilder.b();
    }

    private CustomUrlLikeSpan getLearnMoreLinkSpan() {
        CustomUrlLikeSpan customUrlLikeSpan = new CustomUrlLikeSpan();
        customUrlLikeSpan.a = new C02731(this);
        return customUrlLikeSpan;
    }
}
