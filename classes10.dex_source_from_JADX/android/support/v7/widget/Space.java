package android.support.v7.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.View.MeasureSpec;

/* compiled from: event_categories */
public final class Space extends View {
    public final void draw(Canvas canvas) {
    }

    private static int m14003a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(m14003a(getSuggestedMinimumWidth(), i), m14003a(getSuggestedMinimumHeight(), i2));
    }
}
