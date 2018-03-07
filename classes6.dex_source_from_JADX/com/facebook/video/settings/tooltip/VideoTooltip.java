package com.facebook.video.settings.tooltip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.fbui.buttonbar.ButtonBar;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.settings.VideoAutoPlaySettingsActivity;

/* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate */
public class VideoTooltip extends PopoverWindow {
    public ImageBlockLayout f19643a;
    public FbTextView f19644l;
    public FbTextView f19645m;
    public ButtonBar f19646n;
    public Button f19647o;
    public Button f19648p;
    public Button f19649q;
    public ImageView f19650r;
    public ImageView f19651s;
    public int f19652t;
    public int f19653u;
    public int f19654v;
    public int f19655w;
    public boolean f19656x;
    private final Runnable f19657y;
    public Handler f19658z;

    /* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate */
    class C14631 implements Runnable {
        final /* synthetic */ VideoTooltip f19638a;

        C14631(VideoTooltip videoTooltip) {
            this.f19638a = videoTooltip;
        }

        public void run() {
            this.f19638a.l();
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate */
    public class C14642 implements OnClickListener {
        final /* synthetic */ VideoTooltip f19639a;

        public C14642(VideoTooltip videoTooltip) {
            this.f19639a = videoTooltip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 296793321);
            this.f19639a.l();
            Logger.a(2, EntryType.UI_INPUT_END, -1696903529, a);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate */
    public enum Action {
        POSITIVE_BUTTON,
        NEUTRAL_BUTTON,
        NEGATIVE_BUTTON
    }

    /* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate */
    final class TooltipButtonClickListener implements OnClickListener {
        final /* synthetic */ VideoTooltip f19640a;
        private final com.facebook.video.settings.AutoplayRolloutNuxController.TooltipButtonClickListener f19641b;
        private final Action f19642c;

        public TooltipButtonClickListener(VideoTooltip videoTooltip, com.facebook.video.settings.AutoplayRolloutNuxController.TooltipButtonClickListener tooltipButtonClickListener, Action action) {
            this.f19640a = videoTooltip;
            this.f19641b = tooltipButtonClickListener;
            this.f19642c = action;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1339964088);
            this.f19640a.l();
            com.facebook.video.settings.AutoplayRolloutNuxController.TooltipButtonClickListener tooltipButtonClickListener = this.f19641b;
            switch (this.f19642c) {
                case POSITIVE_BUTTON:
                    tooltipButtonClickListener.f19606b.f19609c.a(VideoAutoPlaySettingsActivity.m28314a(tooltipButtonClickListener.f19605a), tooltipButtonClickListener.f19605a);
                    tooltipButtonClickListener.f19606b.m28312d();
                    break;
                case NEUTRAL_BUTTON:
                    tooltipButtonClickListener.f19606b.m28312d();
                    break;
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1777339107, a);
        }
    }

    public VideoTooltip(Context context, int i) {
        this(context, m28370a(context, i), 2130907701);
    }

    private VideoTooltip(Context context, int i, int i2) {
        super(context, m28370a(context, i));
        this.f19657y = new C14631(this);
        Context context2 = getContext();
        this.f19658z = new Handler(Looper.getMainLooper());
        this.f19656x = false;
        this.f19655w = 3000;
        Resources resources = context2.getResources();
        this.f19652t = resources.getDimensionPixelSize(2131430813);
        this.f19653u = resources.getDimensionPixelSize(2131429217);
        this.f19654v = resources.getDimensionPixelSize(2131429218);
        a(new ColorDrawable(0));
        this.f.setPadding(0, 0, 0, 0);
        b(0.0f);
        d(false);
        this.g.setOnClickListener(new C14642(this));
        View inflate = LayoutInflater.from(context2).inflate(i2, null);
        this.f19643a = (ImageBlockLayout) inflate.findViewById(2131568388);
        this.f19644l = (FbTextView) inflate.findViewById(2131568389);
        this.f19645m = (FbTextView) inflate.findViewById(2131568390);
        this.f19646n = (ButtonBar) inflate.findViewById(2131568391);
        this.f19647o = (Button) inflate.findViewById(2131568392);
        this.f19648p = (Button) inflate.findViewById(2131568393);
        this.f19649q = (Button) inflate.findViewById(2131568394);
        this.f19650r = (ImageView) inflate.findViewById(2131568395);
        this.f19651s = (ImageView) inflate.findViewById(2131568396);
        d(inflate);
    }

    private static int m28370a(Context context, int i) {
        if (i == 1) {
            return 2131625687;
        }
        if (i == 2) {
            return 2131625688;
        }
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773493, typedValue, true);
        return typedValue.resourceId;
    }

    public final void m28372a(int i) {
        this.f19644l.setText(i);
        this.f19644l.setVisibility(i > 0 ? 0 : 8);
    }

    public final void m28376a(CharSequence charSequence, com.facebook.video.settings.AutoplayRolloutNuxController.TooltipButtonClickListener tooltipButtonClickListener) {
        this.f19647o.setText(charSequence);
        this.f19647o.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.f19647o.setOnClickListener(new TooltipButtonClickListener(this, tooltipButtonClickListener, Action.POSITIVE_BUTTON));
        m28371a();
    }

    public final void m28378b(CharSequence charSequence, com.facebook.video.settings.AutoplayRolloutNuxController.TooltipButtonClickListener tooltipButtonClickListener) {
        this.f19648p.setText(charSequence);
        this.f19648p.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.f19648p.setOnClickListener(new TooltipButtonClickListener(this, tooltipButtonClickListener, Action.NEUTRAL_BUTTON));
        m28371a();
    }

    private void m28371a() {
        int i;
        int i2 = 0;
        if (this.f19647o.getVisibility() == 0 || this.f19649q.getVisibility() == 0 || this.f19648p.getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        ButtonBar buttonBar = this.f19646n;
        if (i == 0) {
            i2 = 8;
        }
        buttonBar.setVisibility(i2);
    }

    public final void m28377b(int i) {
        this.f19645m.setText(i);
        this.f19645m.setVisibility(i > 0 ? 0 : 8);
    }

    public final void m28379d() {
        super.d();
        if (!this.r) {
            if (this.f19656x) {
                HandlerDetour.a(this.f19658z, this.f19657y);
            }
            if (this.f19655w > 0) {
                HandlerDetour.b(this.f19658z, this.f19657y, (long) this.f19655w, -1572076392);
                this.f19656x = true;
            }
        }
    }

    public final void m28380l() {
        super.l();
        if (this.f19656x) {
            HandlerDetour.a(this.f19658z, this.f19657y);
            this.f19656x = false;
        }
    }

    public final void m28373a(View view) {
        f(view);
    }

    public final void m28375a(Position position) {
        if (position == Position.CENTER) {
            throw new IllegalStateException("Tooltips should be anchored to a view.");
        }
        super.a(position);
    }

    protected final void m28374a(View view, boolean z, LayoutParams layoutParams) {
        ImageView imageView;
        ((FrameLayout.LayoutParams) this.f19651s.getLayoutParams()).leftMargin = 0;
        ((FrameLayout.LayoutParams) this.f19650r.getLayoutParams()).leftMargin = 0;
        ((FrameLayout.LayoutParams) this.f.getLayoutParams()).leftMargin = 0;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.g.measure(MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        int measuredWidth = this.g.getMeasuredWidth();
        int measuredHeight = this.g.getMeasuredHeight();
        layoutParams.width = -1;
        layoutParams.height = measuredHeight;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        Object obj = measuredHeight <= iArr[1] ? 1 : null;
        Object obj2 = (iArr[1] + height) + measuredHeight <= displayMetrics.heightPixels ? 1 : null;
        Position i = i();
        if (obj2 == null || !(i == Position.BELOW || (i == Position.ABOVE && obj == null))) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        if (obj2 != null) {
            layoutParams.y = (iArr[1] + height) - this.f19653u;
            layoutParams.windowAnimations = 2131624757;
            layoutParams2.gravity = 48;
            layoutParams.gravity = 48;
            this.f19650r.setVisibility(0);
            this.f19651s.setVisibility(4);
            measuredHeight = 0;
            imageView = this.f19650r;
        } else {
            layoutParams.y = (displayMetrics.heightPixels - iArr[1]) - this.f19652t;
            layoutParams.windowAnimations = 2131624758;
            layoutParams2.gravity = 80;
            layoutParams.gravity = 80;
            this.f19650r.setVisibility(4);
            this.f19651s.setVisibility(0);
            imageView = this.f19651s;
        }
        int i2 = width - (measuredWidth / 2);
        if (i2 < 0) {
            height = 0;
        } else if (i2 + measuredWidth > displayMetrics.widthPixels) {
            height = displayMetrics.widthPixels - measuredWidth;
        } else {
            height = i2;
        }
        layoutParams3.leftMargin = height;
        this.f.setLayoutParams(layoutParams3);
        layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.leftMargin = (width - (this.f19654v / 2)) - height;
        int paddingLeft = this.f19643a.getPaddingLeft() / 2;
        height = this.f19643a.getPaddingRight() / 2;
        if (layoutParams2.leftMargin < paddingLeft) {
            layoutParams2.leftMargin = paddingLeft;
        } else if (layoutParams2.leftMargin + this.f19654v > measuredWidth - height) {
            layoutParams2.leftMargin = (measuredWidth - height) - this.f19654v;
        }
        imageView.setLayoutParams(layoutParams2);
        this.f.a(displayMetrics.widthPixels / 2, measuredHeight);
    }
}
