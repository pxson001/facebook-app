package com.facebook.attachments.videos.ui;

import android.content.Context;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: profile_overlay */
public class BaseVideoAttachmentView extends CustomRelativeLayout {
    public BaseVideoAttachmentView(Context context) {
        super(context);
    }

    public static boolean m10453a(float f, int i, int i2) {
        if (f > 0.0f) {
            if ((((float) i) - f) / ((float) i2) > 0.5f) {
                return true;
            }
            return false;
        } else if ((((float) i2) + f) / ((float) i) <= 0.85f) {
            return false;
        } else {
            return true;
        }
    }
}
