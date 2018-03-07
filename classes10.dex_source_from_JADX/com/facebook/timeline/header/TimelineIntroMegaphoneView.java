package com.facebook.timeline.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.header.ui.NuxBorderDrawingHelper;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper.BordersSpec;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fragment_uuid */
public class TimelineIntroMegaphoneView extends CustomFrameLayout {
    private static final BordersSpec f11519b = new BordersSpec(true, true, true, false);
    @Inject
    public NuxBorderDrawingHelper f11520a;
    private Paint f11521c;
    private View f11522d;

    private static <T extends View> void m11561a(Class<T> cls, T t) {
        m11562a((Object) t, t.getContext());
    }

    private static void m11562a(Object obj, Context context) {
        ((TimelineIntroMegaphoneView) obj).f11520a = NuxBorderDrawingHelper.m12026a(FbInjector.get(context));
    }

    private void m11560a(NuxBorderDrawingHelper nuxBorderDrawingHelper) {
        this.f11520a = nuxBorderDrawingHelper;
    }

    public TimelineIntroMegaphoneView(Context context) {
        super(context);
        m11559a();
    }

    public TimelineIntroMegaphoneView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11559a();
    }

    public TimelineIntroMegaphoneView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11559a();
    }

    private void m11559a() {
        m11561a(TimelineIntroMegaphoneView.class, (View) this);
        setWillNotDraw(false);
        this.f11521c = new Paint(1);
        this.f11521c.setColor(getResources().getColor(2131362991));
        this.f11521c.setStrokeWidth(0.0f);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -119526577);
        super.onFinishInflate();
        this.f11522d = c(2131567914);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -658579723, a);
    }

    public void setOnDismissListener(OnClickListener onClickListener) {
        this.f11522d.setOnClickListener(onClickListener);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() - 1;
        canvas.drawLine(1.0f, (float) height, (float) (getWidth() - 1), (float) height, this.f11521c);
        this.f11520a.m12028a(this, canvas, f11519b);
    }
}
