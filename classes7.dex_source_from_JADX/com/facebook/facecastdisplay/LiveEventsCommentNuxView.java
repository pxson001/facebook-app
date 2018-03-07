package com.facebook.facecastdisplay;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.facecastdisplay.LiveEventsTickerView.Mode;
import com.facebook.fbui.widget.text.ImageWithTextView;
import javax.annotation.Nullable;

/* compiled from: story_message_flyout */
public class LiveEventsCommentNuxView extends ImageWithTextView {
    public LiveEventsCommentNuxView(Context context) {
        this(context, null);
    }

    public LiveEventsCommentNuxView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveEventsCommentNuxView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m3208a(Mode mode, boolean z) {
        int i;
        switch (mode) {
            case BROADCASTING:
                i = 2131232692;
                break;
            case WATCHING_LIVE:
                i = 2131232693;
                break;
            case WATCHING_VOD:
                if (!z) {
                    i = 2131232695;
                    break;
                } else {
                    i = 2131232694;
                    break;
                }
            default:
                return;
        }
        setText(i);
    }
}
