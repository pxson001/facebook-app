package com.facebook.gametime.ui.components.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;

/* compiled from: StartupRetryManager */
public class HeadToHeadTextView extends View {
    public final TextLayoutBuilder f25297a = new TextLayoutBuilder().b((int) getResources().getDimension(2131427400)).b(true).a(this.f25305i);
    public Layout f25298b;
    public Layout f25299c;
    public Layout f25300d;
    public final int f25301e;
    public float f25302f;
    public float f25303g;
    private final float f25304h = getResources().getDimension(2131431388);
    private final float f25305i = getResources().getDimension(2131427449);

    public HeadToHeadTextView(Context context) {
        super(context);
        setBackgroundDrawable(new ColorDrawable(ContextCompat.b(context, 2131361920)));
        this.f25301e = ContextCompat.b(context, 2131361974);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size2 = (int) (this.f25297a.b() + (2.0f * this.f25305i));
        }
        setMeasuredDimension(size, size2);
    }

    protected void onDraw(Canvas canvas) {
        float f = this.f25304h;
        float width = (((float) canvas.getWidth()) - this.f25302f) / 2.0f;
        float width2 = (((float) canvas.getWidth()) - this.f25304h) - this.f25303g;
        canvas.translate(f, this.f25305i);
        this.f25299c.draw(canvas);
        canvas.translate(width - f, 0.0f);
        this.f25298b.draw(canvas);
        canvas.translate(width2 - width, 0.0f);
        this.f25300d.draw(canvas);
    }
}
