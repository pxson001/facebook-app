package com.facebook.groups.widget.membersbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: primary_spec */
public class ExtraPogView extends CustomFrameLayout {
    @Inject
    public Resources f6028a;
    private final int f6029b = 999;
    private MemberBarSelectionListener f6030c;
    public BetterTextView f6031d;
    public int f6032e;
    public int f6033f;
    public int f6034g;
    public int f6035h;
    public final Paint f6036i = new Paint();

    /* compiled from: primary_spec */
    class C05421 implements OnClickListener {
        final /* synthetic */ ExtraPogView f6026a;

        C05421(ExtraPogView extraPogView) {
            this.f6026a = extraPogView;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 1335433613, Logger.a(2, EntryType.UI_INPUT_START, 703410210));
        }
    }

    /* compiled from: primary_spec */
    class C05432 implements OnClickListener {
        final /* synthetic */ ExtraPogView f6027a;

        C05432(ExtraPogView extraPogView) {
            this.f6027a = extraPogView;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 1764075662, Logger.a(2, EntryType.UI_INPUT_START, -1286332153));
        }
    }

    public static void m7823a(Object obj, Context context) {
        ((ExtraPogView) obj).f6028a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public ExtraPogView(Context context, MemberBarSelectionListener memberBarSelectionListener) {
        super(context);
        this.f6030c = memberBarSelectionListener;
        Class cls = ExtraPogView.class;
        m7823a(this, getContext());
        setClickable(true);
        setContentView(2130905205);
        setWillNotDraw(false);
        this.f6035h = this.f6028a.getDimensionPixelSize(2131432015);
        this.f6036i.setAntiAlias(true);
        this.f6034g = this.f6028a.getDimensionPixelOffset(2131432019);
        this.f6032e = this.f6035h;
        this.f6033f = this.f6035h + this.f6034g;
        setMinimumHeight(this.f6032e);
        setMinimumWidth(this.f6033f);
        this.f6031d = (BetterTextView) c(2131563790);
    }

    public final void m7824a() {
        this.f6036i.setColor(this.f6028a.getColor(2131361871));
        this.f6036i.setStyle(Style.FILL);
        Drawable drawable = this.f6028a.getDrawable(2130841196);
        drawable.setColorFilter(new PorterDuffColorFilter(this.f6028a.getColor(2131363508), Mode.SRC_ATOP));
        this.f6031d.setBackgroundDrawable(drawable);
        setOnClickListener(new C05421(this));
        invalidate();
    }

    public void setTypeShowCount(int i) {
        String num;
        this.f6036i.setColor(this.f6028a.getColor(2131363530));
        this.f6036i.setStrokeWidth(this.f6028a.getDimension(2131427380));
        this.f6036i.setStyle(Style.STROKE);
        BetterTextView betterTextView = this.f6031d;
        Integer valueOf = Integer.valueOf(i);
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            num = intValue < 10000 ? valueOf.toString() : intValue < 1000000 ? StringFormatUtil.formatStrLocaleSafe("%.0fk", Double.valueOf((double) Math.round(((double) intValue) / 1000.0d))) : StringFormatUtil.formatStrLocaleSafe("%.2fm", Double.valueOf(((double) Math.round(((double) intValue) / 10000.0d)) / 100.0d));
        } else {
            num = valueOf == null ? "" : valueOf.toString();
        }
        betterTextView.setText(num);
        setOnClickListener(new C05432(this));
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f6033f, this.f6032e);
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (((float) this.f6035h) / 2.0f) - (this.f6036i.getStrokeWidth() / 2.0f), this.f6036i);
        drawChild(canvas, this.f6031d, getDrawingTime());
    }
}
