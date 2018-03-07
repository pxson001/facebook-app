package com.facebook.widget.text;

import android.text.style.URLSpan;
import android.view.View;

/* compiled from: com.facebook.katana.activity.media.ViewVideoActivity */
public class CustomUrlLikeSpan extends URLSpan {
    public OnUrlClickHandler f5854a;

    /* compiled from: com.facebook.katana.activity.media.ViewVideoActivity */
    public abstract class OnUrlClickHandler {
        public abstract void mo1124a();
    }

    public CustomUrlLikeSpan() {
        super("about:blank");
    }

    public void onClick(View view) {
        if (this.f5854a != null) {
            this.f5854a.mo1124a();
        }
    }
}
