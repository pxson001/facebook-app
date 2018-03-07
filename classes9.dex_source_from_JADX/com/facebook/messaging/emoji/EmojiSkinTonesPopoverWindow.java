package com.facebook.messaging.emoji;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterTextView;

/* compiled from: mangle_accept_packets */
public class EmojiSkinTonesPopoverWindow extends PopoverWindow {
    public final Context f10966a;
    private View f10967l = LayoutInflater.from(getContext()).inflate(2130903967, null);
    public LinearLayout f10968m = ((LinearLayout) this.f10967l.findViewById(2131559223));
    public LinearLayout f10969n = ((LinearLayout) this.f10967l.findViewById(2131561167));
    private ImageView f10970o = ((ImageView) this.f10967l.findViewById(2131561168));
    private ViewStubHolder<BetterTextView> f10971p = ViewStubHolder.a((ViewStubCompat) this.f10967l.findViewById(2131561166));

    /* compiled from: mangle_accept_packets */
    class C12091 implements OnTouchListener {
        final /* synthetic */ EmojiSkinTonesPopoverWindow f10965a;

        C12091(EmojiSkinTonesPopoverWindow emojiSkinTonesPopoverWindow) {
            this.f10965a = emojiSkinTonesPopoverWindow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            EmojiSkinTonesPopoverWindow emojiSkinTonesPopoverWindow = this.f10965a;
            Object obj = null;
            if (motionEvent.getActionMasked() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int left = emojiSkinTonesPopoverWindow.f.getLeft();
                int top = emojiSkinTonesPopoverWindow.f.getTop();
                if (y < top || y >= top + emojiSkinTonesPopoverWindow.f10968m.getHeight() || x < left || x >= emojiSkinTonesPopoverWindow.f10968m.getWidth() + left) {
                    obj = 1;
                }
            } else if (motionEvent.getAction() == 4) {
                int i = 1;
            }
            if (obj == null) {
                return false;
            }
            this.f10965a.l();
            return true;
        }
    }

    public EmojiSkinTonesPopoverWindow(Context context, boolean z) {
        super(context);
        this.f10966a = context;
        a(new ColorDrawable(0));
        this.f.setPadding(0, 0, 0, 0);
        b(0.0f);
        if (z) {
            this.f10971p.f();
        }
        d(this.f10967l);
        this.f10967l.setOnTouchListener(new C12091(this));
    }

    protected final void m11380a(View view, boolean z, LayoutParams layoutParams) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        i += view.getWidth() / 2;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.g.measure(MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        int dimensionPixelSize = this.f10966a.getResources().getDimensionPixelSize(2131427874);
        int measuredWidth = this.g.getMeasuredWidth();
        int measuredHeight = this.g.getMeasuredHeight();
        layoutParams.width = measuredWidth;
        layoutParams.height = measuredHeight;
        layoutParams.gravity = 83;
        measuredHeight = view.getRootView().getHeight();
        int intrinsicWidth = this.f10970o.getDrawable().getIntrinsicWidth();
        layoutParams.y = (measuredHeight - i2) - this.f10970o.getDrawable().getIntrinsicHeight();
        layoutParams.x = i - (measuredWidth / 2);
        if (layoutParams.x < 0) {
            layoutParams.x = -dimensionPixelSize;
        } else if ((layoutParams.x + measuredWidth) - dimensionPixelSize > displayMetrics.widthPixels) {
            layoutParams.x = (displayMetrics.widthPixels - measuredWidth) + dimensionPixelSize;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f10970o.getLayoutParams();
        layoutParams2.leftMargin = (i - layoutParams.x) - (intrinsicWidth / 2);
        this.f10970o.setLayoutParams(layoutParams2);
    }
}
