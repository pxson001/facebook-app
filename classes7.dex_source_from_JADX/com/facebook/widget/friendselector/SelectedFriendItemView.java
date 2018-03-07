package com.facebook.widget.friendselector;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.widget.RoundedDrawParams;
import com.facebook.widget.RoundedDrawParams.Builder;
import com.facebook.widget.RoundedFrameLayout;
import com.facebook.widget.RoundedViewHelper;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import javax.inject.Inject;

/* compiled from: days_to_expire */
public class SelectedFriendItemView extends RoundedFrameLayout {
    private static final CallerContext f16112c = CallerContext.a(SelectedFriendItemView.class);
    private static final SpringConfig f16113d = SpringConfig.a(80.0d, 9.0d);
    @Inject
    AnimationUtil f16114a;
    @Inject
    SpringSystem f16115b;
    private Spring f16116e;
    public boolean f16117f;
    private FbDraweeView f16118g;
    private GlyphView f16119h;
    private TextView f16120i;

    /* compiled from: days_to_expire */
    class C12721 extends SimpleSpringListener {
        final /* synthetic */ SelectedFriendItemView f16111a;

        C12721(SelectedFriendItemView selectedFriendItemView) {
            this.f16111a = selectedFriendItemView;
        }

        public final void m20131a(Spring spring) {
            this.f16111a.m20134a((float) spring.d());
        }

        public final void m20133c(Spring spring) {
            this.f16111a.f16117f = false;
            this.f16111a.f16114a.a(this.f16111a);
        }

        public final void m20132b(Spring spring) {
            this.f16111a.f16117f = true;
            this.f16111a.f16114a.b(this.f16111a);
        }
    }

    private static <T extends View> void m20137a(Class<T> cls, T t) {
        m20138a((Object) t, t.getContext());
    }

    private static void m20138a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SelectedFriendItemView) obj).m20135a(AnimationUtil.a(fbInjector), SpringSystem.b(fbInjector));
    }

    private void m20135a(AnimationUtil animationUtil, SpringSystem springSystem) {
        this.f16114a = animationUtil;
        this.f16115b = springSystem;
    }

    public SelectedFriendItemView(Context context) {
        super(context, null);
        m20140e();
    }

    public SelectedFriendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20140e();
    }

    private void m20140e() {
        m20137a(SelectedFriendItemView.class, (View) this);
        setContentView(2130907063);
        RoundedDrawParams roundedDrawParams = this.a.b;
        Builder builder = new Builder();
        builder.a = roundedDrawParams.a;
        builder = builder;
        builder.b = roundedDrawParams.b;
        builder = builder;
        builder.c = roundedDrawParams.c;
        builder = builder;
        builder.d = roundedDrawParams.d;
        builder = builder;
        builder.e = roundedDrawParams.e;
        builder = builder;
        builder.f = roundedDrawParams.f;
        builder = builder;
        builder.g = roundedDrawParams.g;
        builder = builder;
        builder.h = roundedDrawParams.h;
        builder = builder;
        builder.i = roundedDrawParams.i;
        Builder builder2 = builder;
        builder2.a = true;
        roundedDrawParams = builder2.a();
        this.a.b();
        this.a = new RoundedViewHelper(this, roundedDrawParams);
        invalidate();
        this.f16116e = this.f16115b.a();
        this.f16116e.a(f16113d);
        this.f16116e.a(new C12721(this));
        this.f16118g = (FbDraweeView) c(2131567398);
        this.f16119h = (GlyphView) c(2131558934);
        this.f16120i = (TextView) c(2131567399);
    }

    public void setToken(BaseToken baseToken) {
        if (baseToken.f() > 0) {
            this.f16119h.setImageDrawable(getResources().getDrawable(baseToken.f()));
            this.f16119h.setVisibility(0);
            this.f16118g.setVisibility(8);
        } else if (baseToken.h() > 0 || baseToken.i() == null) {
            if (baseToken.h() > 0) {
                this.f16119h.setImageResource(baseToken.h());
            } else {
                this.f16119h.setBackgroundDrawable(new BitmapDrawable(getResources(), baseToken.j()));
            }
            this.f16118g.setVisibility(8);
            this.f16119h.setVisibility(0);
        } else {
            this.f16118g.a(Uri.parse(baseToken.i()), f16112c);
            this.f16118g.setVisibility(0);
            this.f16119h.setVisibility(8);
        }
        if (baseToken.g() > 0 && this.f16119h.getVisibility() == 0) {
            this.f16119h.setGlyphColor(getResources().getColor(baseToken.g()));
        }
        m20134a(1.0f);
        setContentDescription(baseToken.b());
    }

    public final void m20141a() {
        this.f16116e.c = false;
        m20134a(0.0f);
        this.f16116e.a(0.0d).b(1.0d);
    }

    private void m20134a(float f) {
        setScaleX(f);
        setScaleY(f);
        setAlpha(f);
    }

    public final void m20142a(int i) {
        this.f16120i.setText("+" + i);
        setContentDescription(getContext().getString(2131232671, new Object[]{Integer.valueOf(i)}));
        this.f16120i.setVisibility(0);
        this.f16118g.setVisibility(8);
        this.f16119h.setVisibility(8);
    }

    public final void m20143b() {
        this.f16120i.setVisibility(8);
        this.f16118g.setVisibility(0);
        this.f16119h.setVisibility(0);
    }
}
