package com.facebook.backstage.consumption.reply;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.backstage.consumption.stack.FlyingEmojiView;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ride_request_fbid */
public class AnimatingEmojiView extends FbTextView {
    @Inject
    public SpringSystem f4857a;
    private final Spring f4858b;
    private SeenByUser f4859c;

    /* compiled from: ride_request_fbid */
    class C05011 implements SpringListener {
        final /* synthetic */ AnimatingEmojiView f4856a;

        C05011(AnimatingEmojiView animatingEmojiView) {
            this.f4856a = animatingEmojiView;
        }

        public final void m4733a(Spring spring) {
            this.f4856a.setScaleX((float) spring.d());
            this.f4856a.setScaleY((float) spring.d());
        }

        public final void m4734b(Spring spring) {
        }

        public final void m4735c(Spring spring) {
        }

        public final void m4736d(Spring spring) {
        }
    }

    private static <T extends View> void m4738a(Class<T> cls, T t) {
        m4739a((Object) t, t.getContext());
    }

    private static void m4739a(Object obj, Context context) {
        ((AnimatingEmojiView) obj).f4857a = SpringSystem.b(FbInjector.get(context));
    }

    public AnimatingEmojiView(Context context) {
        this(context, null);
    }

    public AnimatingEmojiView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimatingEmojiView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4738a(AnimatingEmojiView.class, (View) this);
        this.f4858b = this.f4857a.a().a(SpringConfig.a(40.0d, 5.0d)).a(0.0d).b(0.0d).l();
        this.f4858b.a(new C05011(this));
    }

    private void m4737a(SpringSystem springSystem) {
        this.f4857a = springSystem;
    }

    public void setUser(SeenByUser seenByUser) {
        this.f4859c = seenByUser;
        setText(seenByUser.f5111a);
    }

    public final void m4740a() {
        setVisibility(0);
        this.f4858b.b(1.0d);
    }

    public final void m4742b() {
        this.f4858b.a(0.5d);
        this.f4858b.b(1.0d);
    }

    public final void m4741a(ViewGroup viewGroup) {
        FlyingEmojiView flyingEmojiView = (FlyingEmojiView) LayoutInflater.from(getContext()).inflate(2130904382, null);
        viewGroup.addView(flyingEmojiView);
        flyingEmojiView.m4871a((View) this, this.f4859c);
        flyingEmojiView.m4870a();
    }
}
