package com.facebook.timeline.header.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: fetchThreadsAndMessages */
public class LoadMoreItemsView extends CustomFrameLayout {
    public final LazyView<ImageView> f11982a = new LazyView((ViewStub) c(2131567968));
    public final LazyView<BetterTextView> f11983b = new LazyView((ViewStub) c(2131567969));
    public final Animation f11984c = AnimationUtils.loadAnimation(getContext(), 2130840060);
    public final Drawable f11985d;
    public final Drawable f11986e;
    public int f11987f;
    public int f11988g;
    public int f11989h;
    @Nullable
    public String f11990i;

    public LoadMoreItemsView(Context context, @Nullable String str) {
        super(context);
        setContentView(2130907465);
        this.f11990i = str;
        this.f11984c.setDuration(1000);
        if (this.f11990i == null) {
            this.f11985d = getResources().getDrawable(2130843591);
        } else {
            this.f11985d = null;
        }
        this.f11986e = getResources().getDrawable(2130840061);
        setBackgroundResource(2131361864);
        this.f11987f = getResources().getDimensionPixelSize(2131429864);
        this.f11988g = getResources().getDimensionPixelSize(2131429865);
        this.f11989h = getResources().getDimensionPixelSize(2131429867);
        setContentDescription(getResources().getString(2131235009));
    }

    public final boolean m12025a(boolean z, OnClickListener onClickListener) {
        if (z) {
            this.f11983b.c();
            ((ImageView) this.f11982a.a()).setVisibility(0);
            ((ImageView) this.f11982a.a()).setImageDrawable(this.f11986e);
            ((ImageView) this.f11982a.a()).startAnimation(this.f11984c);
            setOnClickListener(null);
            setBackgroundResource(2131361864);
            setPadding(0, this.f11987f, 0, this.f11988g);
            return true;
        }
        if (this.f11990i == null) {
            this.f11983b.c();
            ((ImageView) this.f11982a.a()).setVisibility(0);
            ((ImageView) this.f11982a.a()).setImageDrawable(this.f11985d);
            setPadding(0, 0, 0, this.f11988g);
        } else {
            ((BetterTextView) this.f11983b.a()).setVisibility(0);
            this.f11982a.c();
            ((BetterTextView) this.f11983b.a()).setText(this.f11990i);
            setPadding(0, 0, 0, this.f11989h);
        }
        if (this.f11982a.b()) {
            ((ImageView) this.f11982a.a()).clearAnimation();
        }
        setOnClickListener(onClickListener);
        setBackgroundResource(2130843621);
        return true;
    }
}
