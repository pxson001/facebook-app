package com.facebook.facecast;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: buildNumber */
public class FullScreenRelativeLayoutWithDecorViews extends CustomRelativeLayout {
    private final View f18055a;
    private final View f18056b;
    private final Rect f18057c;

    /* compiled from: buildNumber */
    class C15271 implements OnGlobalLayoutListener {
        final /* synthetic */ FullScreenRelativeLayoutWithDecorViews f18054a;

        C15271(FullScreenRelativeLayoutWithDecorViews fullScreenRelativeLayoutWithDecorViews) {
            this.f18054a = fullScreenRelativeLayoutWithDecorViews;
        }

        public void onGlobalLayout() {
            this.f18054a.m21889a();
        }
    }

    public FullScreenRelativeLayoutWithDecorViews(Context context) {
        this(context, null);
    }

    public FullScreenRelativeLayoutWithDecorViews(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullScreenRelativeLayoutWithDecorViews(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904544);
        this.f18055a = a(2131561596);
        this.f18056b = a(2131561686);
        this.f18057c = new Rect();
        getViewTreeObserver().addOnGlobalLayoutListener(new C15271(this));
    }

    private void m21889a() {
        getWindowVisibleDisplayFrame(this.f18057c);
        LayoutParams layoutParams = (LayoutParams) this.f18055a.getLayoutParams();
        if (layoutParams.height != this.f18057c.top) {
            layoutParams.height = this.f18057c.top;
            this.f18055a.setLayoutParams(layoutParams);
        }
        int bottom = getBottom() - this.f18057c.bottom;
        layoutParams = (LayoutParams) this.f18056b.getLayoutParams();
        if (layoutParams.height != bottom) {
            layoutParams.height = bottom;
            this.f18056b.setLayoutParams(layoutParams);
        }
    }
}
