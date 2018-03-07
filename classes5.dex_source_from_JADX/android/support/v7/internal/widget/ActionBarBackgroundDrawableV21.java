package android.support.v7.internal.widget;

import android.graphics.Outline;
import android.support.annotation.NonNull;

/* compiled from: universal_number */
class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
    public ActionBarBackgroundDrawableV21(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(@NonNull Outline outline) {
        if (this.f985a.f989d) {
            if (this.f985a.f988c != null) {
                this.f985a.f988c.getOutline(outline);
            }
        } else if (this.f985a.f986a != null) {
            this.f985a.f986a.getOutline(outline);
        }
    }
}
