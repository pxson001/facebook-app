package com.facebook.messaging.widget.anchorabletoast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.async.CancellableRunnable;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: pickedFriends */
public class AnchorableToast {
    private static final Class<?> f4929a = AnchorableToast.class;
    private final Context f4930b;
    private final LayoutInflater f4931c;
    public View f4932d;
    private OnGlobalLayoutListener f4933e;
    public PopupWindow f4934f;
    private CancellableRunnable f4935g;
    public int f4936h;
    public int f4937i;
    public boolean f4938j;
    public int f4939k = 48;
    public long f4940l = 3000;

    /* compiled from: pickedFriends */
    class C06761 implements Runnable {
        final /* synthetic */ AnchorableToast f4927a;

        C06761(AnchorableToast anchorableToast) {
            this.f4927a = anchorableToast;
        }

        public void run() {
            this.f4927a.m4482a();
        }
    }

    /* compiled from: pickedFriends */
    class C06772 implements OnGlobalLayoutListener {
        final /* synthetic */ AnchorableToast f4928a;

        C06772(AnchorableToast anchorableToast) {
            this.f4928a = anchorableToast;
        }

        public void onGlobalLayout() {
            AnchorableToast anchorableToast = this.f4928a;
            if (anchorableToast.f4934f != null) {
                int[] iArr = new int[2];
                anchorableToast.f4932d.getLocationInWindow(iArr);
                if (anchorableToast.f4939k == 48) {
                    anchorableToast.f4934f.update(iArr[0], iArr[1] - anchorableToast.f4937i, anchorableToast.f4936h, anchorableToast.f4937i);
                } else {
                    anchorableToast.f4934f.update(iArr[0], iArr[1] + anchorableToast.f4932d.getHeight(), anchorableToast.f4936h, anchorableToast.f4937i);
                }
            }
        }
    }

    public static AnchorableToast m4481b(InjectorLike injectorLike) {
        return new AnchorableToast((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public AnchorableToast(Context context, LayoutInflater layoutInflater) {
        this.f4930b = context;
        this.f4931c = layoutInflater;
        this.f4937i = SizeUtil.a(context, 33.0f);
    }

    public static AnchorableToast m4479a(InjectorLike injectorLike) {
        return m4481b(injectorLike);
    }

    public final void m4483a(View view, CharSequence charSequence) {
        View inflate = this.f4931c.inflate(2130905792, new FrameLayout(this.f4930b), false);
        ((TextView) inflate.findViewById(2131564996)).setText(charSequence);
        m4480a(view, inflate);
    }

    private void m4480a(View view, View view2) {
        m4482a();
        if (view.getWindowToken() == null) {
            BLog.a(f4929a, "show called with null window token -- ignoring");
            return;
        }
        this.f4932d = view;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Drawable drawable = this.f4930b.getResources().getDrawable(2130841810);
        this.f4934f = new PopupWindow(this.f4930b);
        View frameLayout = new FrameLayout(this.f4930b);
        frameLayout.setBackgroundDrawable(drawable);
        frameLayout.addView(view2);
        this.f4936h = view.getWidth();
        if (this.f4938j) {
            frameLayout.measure(MeasureSpec.makeMeasureSpec(this.f4936h, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
            this.f4937i = frameLayout.getMeasuredHeight();
        }
        this.f4934f.setContentView(frameLayout);
        this.f4934f.setWidth(this.f4936h);
        this.f4934f.setHeight(this.f4937i);
        this.f4934f.setBackgroundDrawable(null);
        if (this.f4940l > 0) {
            this.f4934f.setAnimationStyle(16973828);
        } else {
            this.f4934f.setAnimationStyle(0);
        }
        if (this.f4939k == 48) {
            this.f4934f.showAtLocation(view, 51, iArr[0], iArr[1] - this.f4937i);
        } else if (this.f4939k == 80) {
            this.f4934f.showAtLocation(view, 51, iArr[0], iArr[1] + view.getHeight());
        }
        if (this.f4940l > 0) {
            this.f4935g = new CancellableRunnable(new C06761(this));
            view.postDelayed(this.f4935g, this.f4940l);
        }
        this.f4933e = new C06772(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f4933e);
    }

    public final void m4482a() {
        if (this.f4934f != null) {
            this.f4934f.dismiss();
            this.f4934f = null;
        }
        if (this.f4935g != null) {
            this.f4935g.a();
            this.f4935g = null;
        }
        if (this.f4933e != null) {
            this.f4932d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f4933e);
            this.f4933e = null;
        }
    }
}
