package android.support.design.widget;

import android.widget.ImageButton;

/* compiled from: publish_method */
public class VisibilityAwareImageButton extends ImageButton {
    public int f7028a;

    public void setVisibility(int i) {
        m10133a(i, true);
    }

    private void m10133a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f7028a = i;
        }
    }
}
