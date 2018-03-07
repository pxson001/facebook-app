package com.facebook.timeline.header.ui;

import android.content.Context;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: fetchThread- */
public class ProfileVideoNuxView extends CustomFrameLayout {
    public ImageView f12013a = ((ImageView) c(2131566420));
    public ImageView f12014b = ((ImageView) c(2131566419));
    public ImageView f12015c = ((ImageView) c(2131566418));
    public RotateAnimation f12016d = new RotateAnimation(0.0f, 12.0f, 1, 1.0f, 1, 1.0f);
    public FbTextView f12017e = ((FbTextView) c(2131566421));

    public ProfileVideoNuxView(Context context) {
        super(context);
        setContentView(2130906488);
        this.f12016d.setDuration(500);
        this.f12016d.setRepeatCount(-1);
        this.f12016d.setRepeatMode(2);
        this.f12013a.startAnimation(this.f12016d);
        this.f12017e.setText(2131234997);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1716489100);
        super.onDetachedFromWindow();
        if (this.f12013a.getDrawable() != null) {
            this.f12013a.getDrawable().setVisible(false, false);
        }
        if (this.f12014b.getDrawable() != null) {
            this.f12014b.getDrawable().setVisible(false, false);
        }
        if (this.f12015c.getBackground() != null) {
            this.f12015c.getBackground().setVisible(false, false);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -91794236, a);
    }
}
