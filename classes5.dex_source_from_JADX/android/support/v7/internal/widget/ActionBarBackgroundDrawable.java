package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: unknown_add_a_category */
public class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer f985a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f985a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f985a.f989d) {
            if (this.f985a.f986a != null) {
                this.f985a.f986a.draw(canvas);
            }
            if (this.f985a.f987b != null && this.f985a.f990e) {
                this.f985a.f987b.draw(canvas);
            }
        } else if (this.f985a.f988c != null) {
            this.f985a.f988c.draw(canvas);
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
