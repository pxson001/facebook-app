package com.facebook.timeline.header.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.facebook.inject.Assisted;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.ProfileOverlayHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: fetchThreadList (WSH) */
public class ProfileDebugControllerOverlay extends Drawable {
    private final Paint f12009a = new Paint();
    public final TimelineHeaderUserData f12010b;
    public final TimelineHeaderRenderState f12011c;
    public final ProfileOverlayHelper f12012d;

    @Inject
    public ProfileDebugControllerOverlay(@Assisted TimelineHeaderUserData timelineHeaderUserData, TimelineHeaderRenderState timelineHeaderRenderState, ProfileOverlayHelper profileOverlayHelper) {
        this.f12010b = timelineHeaderUserData;
        this.f12011c = timelineHeaderRenderState;
        this.f12012d = profileOverlayHelper;
        this.f12009a.setStyle(Style.FILL);
        this.f12009a.setTextSize(38.0f);
        this.f12009a.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.f12009a.setStrokeWidth(1.0f);
        this.f12009a.setColor(-65536);
        this.f12009a.setTextAlign(Align.RIGHT);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        List arrayList = new ArrayList();
        TimelineHeaderUserData timelineHeaderUserData = this.f12010b;
        List arrayList2 = new ArrayList();
        arrayList2.add("Header data version = " + timelineHeaderUserData.c);
        arrayList2.add("Header state = " + timelineHeaderUserData.e.name());
        arrayList2.add("Header freshness = " + timelineHeaderUserData.f.name());
        arrayList.addAll(arrayList2);
        TimelineHeaderRenderState timelineHeaderRenderState = this.f12011c;
        arrayList2 = new ArrayList();
        arrayList2.add("Profile picture state = " + timelineHeaderRenderState.d.name());
        arrayList2.add("Cover photo state = " + timelineHeaderRenderState.e.name());
        if (timelineHeaderRenderState.b) {
            arrayList2.add("Header fetch failed.");
        }
        arrayList.addAll(arrayList2);
        ProfileOverlayHelper profileOverlayHelper = this.f12012d;
        List arrayList3 = new ArrayList();
        if (profileOverlayHelper.d) {
            for (Entry entry : profileOverlayHelper.c.entrySet()) {
                arrayList3.add(entry.getKey() + " : " + entry.getValue());
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = arrayList3;
        }
        arrayList.addAll(arrayList2);
        m12045a(canvas, arrayList, bounds.right - 20, bounds.top + 50);
    }

    private void m12045a(Canvas canvas, List<String> list, int i, int i2) {
        for (String drawText : list) {
            canvas.drawText(drawText, (float) i, (float) i2, this.f12009a);
            i2 = (int) (((float) i2) + ((-this.f12009a.ascent()) + this.f12009a.descent()));
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
