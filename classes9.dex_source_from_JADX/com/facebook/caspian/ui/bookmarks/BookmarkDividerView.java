package com.facebook.caspian.ui.bookmarks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: reason_key */
public class BookmarkDividerView extends FbTextView {
    private final Paint f5753a;
    private final int f5754b;
    private final int f5755c;
    private boolean f5756d;
    private boolean f5757e;
    private float f5758f;

    public BookmarkDividerView(Context context) {
        this(context, null);
    }

    public BookmarkDividerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BookmarkDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f5753a = new Paint();
        this.f5753a.setColor(resources.getColor(2131361940));
        this.f5753a.setStrokeWidth((float) resources.getDimensionPixelSize(2131427582));
        CustomFontHelper.a(this, FontFamily.ROBOTO, FontWeight.MEDIUM, getTypeface());
        this.f5754b = resources.getDimensionPixelSize(2131427581);
        this.f5755c = resources.getDimensionPixelSize(2131427580);
    }

    public void setExtraPaddingEnabled(boolean z) {
        if (this.f5756d != z) {
            this.f5756d = z;
            m5979a();
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f5757e = i3 == 0;
        m5979a();
    }

    private void m5979a() {
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i;
            int strokeWidth = this.f5757e ? (int) this.f5753a.getStrokeWidth() : this.f5755c;
            if (this.f5756d) {
                i = this.f5754b;
            } else {
                i = 0;
            }
            layoutParams.height = strokeWidth + i;
            setLayoutParams(layoutParams);
            if (this.f5756d) {
                strokeWidth = this.f5754b;
            } else {
                strokeWidth = 0;
            }
            setPadding(getPaddingLeft(), strokeWidth, getPaddingRight(), 0);
        }
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1558509895);
        super.onMeasure(i, i2);
        this.f5758f = ((float) (this.f5756d ? this.f5754b : 0)) + (this.f5753a.getStrokeWidth() / 2.0f);
        LogUtils.g(-1985304879, a);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine((float) getPaddingLeft(), this.f5758f, (float) (getWidth() - getPaddingRight()), this.f5758f, this.f5753a);
    }
}
