package com.facebook.search.quickpromotion;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fig.button.FigButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: TEXT_CAPTION_MEDIUM */
public class SearchAwarenessFormattedTooltip extends Tooltip {
    public BetterTextView f22365a;
    public BetterTextView f22366l;
    public CustomLinearLayout f22367m;
    public FigButton f22368n;
    public FigButton f22369o;
    public GlyphView f22370p;
    public View f22371q;
    public DefaultAndroidThreadUtil f22372r;
    public WindowManager f22373s;
    public float f22374t = 0.0f;
    private boolean f22375u;

    /* compiled from: TEXT_CAPTION_MEDIUM */
    public class C23762 implements OnClickListener {
        final /* synthetic */ OnClickListener f22360a;
        final /* synthetic */ SearchAwarenessFormattedTooltip f22361b;

        public C23762(SearchAwarenessFormattedTooltip searchAwarenessFormattedTooltip, OnClickListener onClickListener) {
            this.f22361b = searchAwarenessFormattedTooltip;
            this.f22360a = onClickListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 168266719);
            this.f22360a.onClick(view);
            Logger.a(2, EntryType.UI_INPUT_END, -335432535, a);
        }
    }

    /* compiled from: TEXT_CAPTION_MEDIUM */
    public class C23773 implements OnClickListener {
        final /* synthetic */ OnClickListener f22362a;
        final /* synthetic */ SearchAwarenessFormattedTooltip f22363b;

        public C23773(SearchAwarenessFormattedTooltip searchAwarenessFormattedTooltip, OnClickListener onClickListener) {
            this.f22363b = searchAwarenessFormattedTooltip;
            this.f22362a = onClickListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 340852031);
            this.f22362a.onClick(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1164027117, a);
        }
    }

    /* compiled from: TEXT_CAPTION_MEDIUM */
    public class C23784 implements Runnable {
        final /* synthetic */ SearchAwarenessFormattedTooltip f22364a;

        public C23784(SearchAwarenessFormattedTooltip searchAwarenessFormattedTooltip) {
            this.f22364a = searchAwarenessFormattedTooltip;
        }

        public void run() {
            this.f22364a.f22373s.removeView(this.f22364a.f22371q);
        }
    }

    @Inject
    public SearchAwarenessFormattedTooltip(Context context, DefaultAndroidThreadUtil defaultAndroidThreadUtil, QeAccessor qeAccessor, Boolean bool) {
        super(context);
        this.f22375u = bool.booleanValue();
        Context context2 = getContext();
        LayoutInflater from = LayoutInflater.from(context2);
        View inflate = from.inflate(2130906964, null);
        this.f22365a = (BetterTextView) inflate.findViewById(2131567246);
        this.f22366l = (BetterTextView) inflate.findViewById(2131567247);
        this.f22370p = (GlyphView) inflate.findViewById(2131567244);
        this.f22367m = (CustomLinearLayout) inflate.findViewById(2131567248);
        this.f22368n = (FigButton) inflate.findViewById(2131567250);
        this.f22369o = (FigButton) inflate.findViewById(2131567249);
        d(inflate);
        this.f22371q = from.inflate(2130906963, null);
        this.f22372r = defaultAndroidThreadUtil;
        this.f22373s = (WindowManager) context2.getSystemService("window");
        boolean a = qeAccessor.a(ExperimentsForSearchAbTestModule.as, false);
        if (a) {
            this.g.setOnClickListener(null);
        }
        this.f22367m.setVisibility(a ? 0 : 8);
    }

    public final void m25866a(CharSequence charSequence) {
        this.f22365a.setText(charSequence);
        this.f22365a.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public final void m25864a(int i) {
        this.f22365a.setText(i);
        this.f22365a.setVisibility(i > 0 ? 0 : 8);
    }

    public final void m25868b(CharSequence charSequence) {
        this.f22366l.setText(charSequence);
        this.f22366l.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public final void m25867b(int i) {
        this.f22366l.setText(i);
        this.f22366l.setVisibility(i > 0 ? 0 : 8);
    }

    public final void m25869f(final View view) {
        this.f22372r.b(new Runnable(this) {
            final /* synthetic */ SearchAwarenessFormattedTooltip f22359b;

            public void run() {
                this.f22359b.f22373s.addView(this.f22359b.f22371q, SearchAwarenessFormattedTooltip.m25863g(this.f22359b, view));
            }
        });
        super.f(view);
    }

    public static LayoutParams m25863g(SearchAwarenessFormattedTooltip searchAwarenessFormattedTooltip, View view) {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.token = view.getWindowToken();
        layoutParams.type = 1000;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int i = (displayMetrics.widthPixels - searchAwarenessFormattedTooltip.A) - searchAwarenessFormattedTooltip.C;
        int i2 = (displayMetrics.heightPixels - searchAwarenessFormattedTooltip.B) - searchAwarenessFormattedTooltip.D;
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        layoutParams.y = height + iArr[1];
        layoutParams.width = i;
        layoutParams.height = i2 - layoutParams.y;
        layoutParams.alpha = searchAwarenessFormattedTooltip.f22374t;
        layoutParams.gravity = 51;
        layoutParams.flags = 8;
        return layoutParams;
    }

    public final void m25870l() {
        super.l();
        this.f22372r.b(new C23784(this));
    }

    protected final void m25865a(View view, boolean z, LayoutParams layoutParams) {
        ((FrameLayout.LayoutParams) this.f22370p.getLayoutParams()).leftMargin = 0;
        int i = this.A;
        int i2 = this.C;
        int i3 = this.B;
        int i4 = this.D;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.g.measure(MeasureSpec.makeMeasureSpec((displayMetrics.widthPixels - i) - i2, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec((displayMetrics.heightPixels - i3) - i4, Integer.MIN_VALUE));
        i4 = this.g.getMeasuredWidth();
        i3 = this.g.getMeasuredHeight();
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        layoutParams.width = i4;
        layoutParams.y = height + iArr[1];
        layoutParams.height = i3;
        layoutParams.gravity = 51;
        i3 = width - (i4 / 2);
        if (i3 >= i) {
            i = i3 + i4 > displayMetrics.widthPixels - i2 ? (displayMetrics.widthPixels - i2) - i4 : i3;
        }
        layoutParams.width = i + layoutParams.width;
        this.f22373s.updateViewLayout(this.f22371q, m25863g(this, view));
        if (this.f22375u) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f22370p.getLayoutParams();
            layoutParams2.leftMargin = width - (this.f22370p.getMeasuredWidth() / 2);
            layoutParams2.gravity = 8388611;
            this.f22370p.setLayoutParams(layoutParams2);
        }
    }
}
