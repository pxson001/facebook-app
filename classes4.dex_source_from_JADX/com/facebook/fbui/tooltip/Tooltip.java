package com.facebook.fbui.tooltip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: outgoing_like_message */
public class Tooltip extends PopoverWindow {
    public static final OnTouchListener f5768a = new C02501();
    public ImageBlockLayout f5769l;
    public FbTextView f5770m;
    public FbTextView f5771n;
    public ImageView f5772o;
    public ImageView f5773p;
    public int f5774q;
    public int f5775r;
    public int f5776s;
    public int f5777t;
    public boolean f5778u;
    private Runnable f5779v;
    public Handler f5780w;

    /* compiled from: outgoing_like_message */
    final class C02501 implements OnTouchListener {
        C02501() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                return false;
            }
            TextView textView = (TextView) view;
            CharSequence text = textView.getText();
            if (!(text instanceof Spanned)) {
                return false;
            }
            Spanned spanned = (Spanned) text;
            int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            if (y < layout.getLineTop(0) || y >= layout.getLineBottom(layout.getLineCount() - 1)) {
                return false;
            }
            y = layout.getLineForVertical(y);
            if (((float) x) < layout.getLineLeft(y) || ((float) x) > layout.getLineRight(y)) {
                return false;
            }
            x = layout.getOffsetForHorizontal(y, (float) x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spanned.getSpans(x, x, ClickableSpan.class);
            if (clickableSpanArr.length == 0) {
                return false;
            }
            if (action == 1) {
                clickableSpanArr[0].onClick(textView);
            }
            return true;
        }
    }

    /* compiled from: outgoing_like_message */
    class C02522 implements Runnable {
        final /* synthetic */ Tooltip f5843a;

        C02522(Tooltip tooltip) {
            this.f5843a = tooltip;
        }

        public void run() {
            this.f5843a.mo542l();
        }
    }

    /* compiled from: outgoing_like_message */
    public class C02533 implements OnClickListener {
        final /* synthetic */ Tooltip f5844a;

        public C02533(Tooltip tooltip) {
            this.f5844a = tooltip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1002896882);
            this.f5844a.mo542l();
            Logger.a(2, EntryType.UI_INPUT_END, -1645191728, a);
        }
    }

    public Tooltip(Context context) {
        this(context, 1);
    }

    public Tooltip(Context context, int i) {
        this(context, m6249a(context, i), 2130904280);
    }

    public Tooltip(Context context, int i, int i2) {
        super(context, m6249a(context, i));
        this.f5779v = new C02522(this);
        Context context2 = getContext();
        this.f5780w = new Handler(Looper.getMainLooper());
        this.f5778u = false;
        this.f5777t = 3000;
        Resources resources = context2.getResources();
        this.f5774q = resources.getDimensionPixelSize(2131429216);
        this.f5775r = resources.getDimensionPixelSize(2131429217);
        this.f5776s = resources.getDimensionPixelSize(2131429218);
        m6277a(new ColorDrawable(0));
        this.f5797f.setPadding(0, 0, 0, 0);
        m6286b(0.0f);
        m6292d(false);
        this.f5798g.setOnClickListener(new C02533(this));
        View inflate = LayoutInflater.from(context2).inflate(i2, null);
        this.f5769l = (ImageBlockLayout) inflate.findViewById(2131561857);
        this.f5770m = (FbTextView) inflate.findViewById(2131561858);
        this.f5771n = (FbTextView) inflate.findViewById(2131561859);
        this.f5772o = (ImageView) inflate.findViewById(2131561860);
        this.f5773p = (ImageView) inflate.findViewById(2131561861);
        m6291d(inflate);
        this.f5771n.setOnTouchListener(f5768a);
    }

    private static int m6249a(Context context, int i) {
        if (i == 1) {
            return 2131624495;
        }
        if (i == 2) {
            return 2131624496;
        }
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130772493, typedValue, true);
        return typedValue.resourceId;
    }

    public void m6256a(CharSequence charSequence) {
        this.f5770m.setText(charSequence);
        this.f5770m.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void m6251a(int i) {
        this.f5770m.setText(i);
        this.f5770m.setVisibility(i > 0 ? 0 : 8);
    }

    public void m6259b(CharSequence charSequence) {
        this.f5771n.setText(charSequence);
        this.f5771n.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void m6257b(int i) {
        this.f5771n.setText(i);
        this.f5771n.setVisibility(i > 0 ? 0 : 8);
    }

    public final void m6258b(Drawable drawable) {
        this.f5769l.setThumbnailDrawable(drawable);
    }

    public final void m6255a(OnTooltipClickListener onTooltipClickListener) {
        this.f5798g.setOnClickListener(new 4(this, onTooltipClickListener));
    }

    public void mo542l() {
        super.mo542l();
        if (this.f5778u) {
            HandlerDetour.a(this.f5780w, this.f5779v);
            this.f5778u = false;
        }
    }

    public final void mo538a(View view) {
        m6297f(view);
    }

    public final void mo540a(Position position) {
        if (position == Position.CENTER) {
            throw new IllegalStateException("Tooltips should be anchored to a view.");
        }
        super.mo540a(position);
    }

    private void m6250a() {
        ((LayoutParams) this.f5773p.getLayoutParams()).leftMargin = 0;
        ((LayoutParams) this.f5772o.getLayoutParams()).leftMargin = 0;
        ((LayoutParams) this.f5797f.getLayoutParams()).leftMargin = 0;
    }

    public final void mo541d() {
        if (this.f5793b || !Boolean.getBoolean("suppress_non_modal_tooltip")) {
            super.mo541d();
            if (!this.f5809r) {
                if (this.f5778u) {
                    HandlerDetour.a(this.f5780w, this.f5779v);
                }
                if (this.f5777t > 0) {
                    HandlerDetour.b(this.f5780w, this.f5779v, (long) this.f5777t, 1740878761);
                    this.f5778u = true;
                }
            }
        }
    }

    protected void mo539a(View view, boolean z, WindowManager.LayoutParams layoutParams) {
        ImageView imageView;
        m6250a();
        int n = m6304n();
        int o = m6305o();
        int p = m6306p();
        int q = m6307q();
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f5798g.measure(MeasureSpec.makeMeasureSpec((displayMetrics.widthPixels - n) - o, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec((displayMetrics.heightPixels - p) - q, Integer.MIN_VALUE));
        int measuredWidth = this.f5798g.getMeasuredWidth();
        int measuredHeight = this.f5798g.getMeasuredHeight();
        int height = view.getRootView().getHeight();
        layoutParams.width = measuredWidth;
        layoutParams.height = measuredHeight;
        LayoutParams layoutParams2 = (LayoutParams) this.f5797f.getLayoutParams();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        int height2 = view.getHeight();
        int i = iArr[0] + this.f5799h;
        int i2 = iArr[1] + this.f5800i;
        width = (width / 2) + i;
        Object obj = measuredHeight <= i2 - p ? 1 : null;
        Object obj2 = (i2 + height2) + measuredHeight <= displayMetrics.heightPixels - q ? 1 : null;
        Position i3 = m6300i();
        if (obj2 == null || !(i3 == Position.BELOW || (i3 == Position.ABOVE && obj == null))) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        LayoutParams layoutParams3 = (LayoutParams) this.f5797f.getLayoutParams();
        if (obj2 != null) {
            layoutParams.y = (i2 + height2) - this.f5775r;
            layoutParams.windowAnimations = 2131624757;
            layoutParams2.gravity = 51;
            layoutParams.gravity = 51;
            this.f5772o.setVisibility(0);
            this.f5773p.setVisibility(4);
            measuredHeight = 0;
            imageView = this.f5772o;
        } else {
            layoutParams.y = (height - i2) - this.f5774q;
            layoutParams.windowAnimations = 2131624758;
            layoutParams2.gravity = 83;
            layoutParams.gravity = 83;
            this.f5772o.setVisibility(4);
            this.f5773p.setVisibility(0);
            imageView = this.f5773p;
        }
        int i4 = width - (measuredWidth / 2);
        if (i4 >= n) {
            if (i4 + measuredWidth > displayMetrics.widthPixels - o) {
                n = (displayMetrics.widthPixels - o) - measuredWidth;
            } else {
                n = i4;
            }
        }
        layoutParams.width = layoutParams.width + n;
        layoutParams3.leftMargin = n;
        this.f5797f.setLayoutParams(layoutParams3);
        layoutParams2 = (LayoutParams) imageView.getLayoutParams();
        layoutParams2.leftMargin = (width - (this.f5776s / 2)) - n;
        p = this.f5769l.getPaddingLeft() / 2;
        n = this.f5769l.getPaddingRight() / 2;
        if (layoutParams2.leftMargin < p) {
            layoutParams2.leftMargin = p;
        } else if (layoutParams2.leftMargin + this.f5776s > measuredWidth - n) {
            layoutParams2.leftMargin = (measuredWidth - n) - this.f5776s;
        }
        imageView.setLayoutParams(layoutParams2);
        this.f5797f.m6320a(layoutParams2.leftMargin + (this.f5776s / 2), measuredHeight);
    }
}
