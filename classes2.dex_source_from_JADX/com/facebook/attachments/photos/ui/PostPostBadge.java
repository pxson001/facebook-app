package com.facebook.attachments.photos.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: graph_search_scoped_entity_type */
public class PostPostBadge extends View {
    private Drawable f21947a;
    private Drawable f21948b;
    private Drawable f21949c;
    private Paint f21950d;
    private Rect f21951e;
    private Rect f21952f;
    private String f21953g;
    private int f21954h;
    private int f21955i;
    private Paint f21956j;
    private String f21957k = null;
    private final Rect f21958l = new Rect();

    public PostPostBadge(Context context) {
        super(context);
        m29752a();
    }

    public PostPostBadge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29752a();
    }

    public PostPostBadge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29752a();
    }

    private void m29752a() {
        Resources resources = getResources();
        float f = resources.getDisplayMetrics().density;
        this.f21950d = new Paint();
        this.f21950d.setAntiAlias(true);
        this.f21950d.setTextAlign(Align.LEFT);
        this.f21950d.setColor(resources.getColor(2131361864));
        this.f21950d.setTextSize(resources.getDimension(2131427402));
        this.f21956j = new Paint();
        this.f21956j.setAntiAlias(true);
        this.f21956j.setTextAlign(Align.CENTER);
        this.f21956j.setFakeBoldText(true);
        this.f21956j.setColor(resources.getColor(2131361864));
        this.f21956j.setTextSize(resources.getDimension(2131427397));
        this.f21951e = new Rect();
        int i = (int) (4.0f * f);
        this.f21954h = (int) (2.0f * f);
        this.f21955i = (int) (f * 16.0f);
        this.f21948b = resources.getDrawable(2130840302);
        this.f21949c = resources.getDrawable(2130840300);
        this.f21952f = new Rect();
        this.f21949c.getPadding(this.f21952f);
        Rect rect = this.f21952f;
        rect.left += i;
        rect = this.f21952f;
        rect.right += i;
        rect = this.f21952f;
        rect.top += i;
        rect = this.f21952f;
        rect.bottom += i;
    }

    public final void m29754a(int i, int i2) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m29753a(2131233614, 2130840303, i2);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m29753a(2131233615, 2130840301, i2);
                return;
            default:
                return;
        }
    }

    private void m29753a(int i, int i2, int i3) {
        this.f21953g = getResources().getString(i);
        this.f21950d.getTextBounds(this.f21953g, 0, this.f21953g.length(), this.f21951e);
        setContentDescription(this.f21953g);
        this.f21947a = getResources().getDrawable(i2);
        this.f21947a.setBounds(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.f21947a.getIntrinsicWidth(), getPaddingTop() + this.f21947a.getIntrinsicHeight());
        setBadgeNumber(i3);
    }

    private void setBadgeNumber(int i) {
        if (i != 0) {
            this.f21957k = Integer.toString(i);
        } else {
            this.f21957k = "";
        }
        this.f21956j.getTextBounds(this.f21957k, 0, this.f21957k.length(), this.f21958l);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(((((this.f21947a.getIntrinsicWidth() + this.f21951e.width()) + this.f21952f.left) + this.f21952f.right) + getPaddingLeft()) + getPaddingRight(), this.f21947a.getIntrinsicHeight());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1345913738);
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = ((((i2 - getPaddingTop()) - getPaddingBottom()) - this.f21951e.height()) - this.f21952f.top) - this.f21952f.bottom;
        this.f21949c.setBounds(this.f21947a.getBounds().right, (paddingTop / 2) + getPaddingTop(), i - getPaddingRight(), i2 - ((paddingTop / 2) + getPaddingTop()));
        this.f21948b.setBounds((this.f21947a.getBounds().right - this.f21954h) - this.f21955i, this.f21947a.getBounds().top + this.f21954h, this.f21947a.getBounds().right - this.f21954h, (this.f21947a.getBounds().top + this.f21954h) + this.f21955i);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 776316649, a);
    }

    protected void onDraw(Canvas canvas) {
        this.f21947a.draw(canvas);
        this.f21949c.draw(canvas);
        canvas.drawText(this.f21953g, (float) (this.f21949c.getBounds().left + this.f21952f.left), ((float) (this.f21949c.getBounds().bottom - this.f21952f.bottom)) - (this.f21950d.descent() / 2.0f), this.f21950d);
        if (this.f21957k != null && !this.f21957k.isEmpty()) {
            this.f21948b.draw(canvas);
            canvas.drawText(this.f21957k, (float) this.f21948b.getBounds().centerX(), ((float) this.f21948b.getBounds().centerY()) - (this.f21956j.ascent() / 3.0f), this.f21956j);
        }
    }
}
