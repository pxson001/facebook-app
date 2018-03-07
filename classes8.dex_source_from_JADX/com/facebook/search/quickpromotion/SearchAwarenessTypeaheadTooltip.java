package com.facebook.search.quickpromotion;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;

/* compiled from: TDATA;>;)V */
public class SearchAwarenessTypeaheadTooltip extends Tooltip {
    public FrameLayout f22474a;
    public BetterTextView f22475l;
    public BetterTextView f22476m;
    public GlyphView f22477n;
    public GlyphView f22478o;
    public boolean f22479p;

    /* compiled from: TDATA;>;)V */
    public class C23961 implements OnClickListener {
        final /* synthetic */ SearchAwarenessTypeaheadTooltip f22473a;

        public C23961(SearchAwarenessTypeaheadTooltip searchAwarenessTypeaheadTooltip) {
            this.f22473a = searchAwarenessTypeaheadTooltip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -277679721);
            this.f22473a.l();
            Logger.a(2, EntryType.UI_INPUT_END, 1710245406, a);
        }
    }

    public SearchAwarenessTypeaheadTooltip(Context context) {
        this(context, 1, 2130906968);
    }

    private SearchAwarenessTypeaheadTooltip(Context context, int i, int i2) {
        super(context, i);
        View inflate = LayoutInflater.from(getContext()).inflate(i2, null);
        this.f22474a = (FrameLayout) inflate.findViewById(2131567259);
        this.f22475l = (BetterTextView) inflate.findViewById(2131567261);
        this.f22476m = (BetterTextView) inflate.findViewById(2131567262);
        this.f22477n = (GlyphView) inflate.findViewById(2131567263);
        this.f22478o = (GlyphView) inflate.findViewById(2131559781);
        d(inflate);
        this.f22478o.setOnClickListener(new C23961(this));
        this.g.setOnClickListener(null);
    }

    public final void m25959f(View view) {
        if (!m25953c()) {
            super.f(view);
            this.f22479p = true;
        }
    }

    public final void m25956a(CharSequence charSequence) {
        this.f22475l.setText(charSequence);
        this.f22475l.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public final void m25954a(int i) {
        this.f22475l.setText(i);
        this.f22475l.setVisibility(i > 0 ? 0 : 8);
    }

    public final void m25958b(CharSequence charSequence) {
        this.f22476m.setText(charSequence);
        this.f22476m.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public final void m25957b(int i) {
        this.f22476m.setText(i);
        this.f22476m.setVisibility(i > 0 ? 0 : 8);
    }

    protected final void m25955a(View view, boolean z, LayoutParams layoutParams) {
        if (m25953c()) {
            this.f22474a.setVisibility(8);
            return;
        }
        this.f22474a.setVisibility(0);
        ((FrameLayout.LayoutParams) this.f22477n.getLayoutParams()).leftMargin = 0;
        int n = n();
        int o = o();
        int p = p();
        int q = q();
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        p = (displayMetrics.heightPixels - p) - q;
        this.g.measure(MeasureSpec.makeMeasureSpec((displayMetrics.widthPixels - n) - o, 1073741824), MeasureSpec.makeMeasureSpec(p, Integer.MIN_VALUE));
        q = this.g.getMeasuredWidth();
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        layoutParams.width = q;
        layoutParams.y = height + iArr[1];
        layoutParams.height = p - layoutParams.y;
        this.f22474a.setMinimumHeight(p - layoutParams.y);
        layoutParams.windowAnimations = 2131624757;
        layoutParams.gravity = 51;
        this.f22477n.setVisibility(0);
        p = width - (q / 2);
        if (p < n) {
            p = n;
        } else if (p + q > displayMetrics.widthPixels - o) {
            p = (displayMetrics.widthPixels - o) - q;
        }
        layoutParams.width = layoutParams.width + p;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f22477n.getLayoutParams();
        layoutParams2.leftMargin = (width - (this.f22477n.getMeasuredWidth() / 2)) - p;
        this.f22477n.setLayoutParams(layoutParams2);
    }

    private boolean m25953c() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }
}
