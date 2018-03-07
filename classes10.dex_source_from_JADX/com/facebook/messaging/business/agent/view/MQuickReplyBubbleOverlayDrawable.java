package com.facebook.messaging.business.agent.view;

import android.content.Context;
import com.facebook.widget.RoundedCornerOverlayDrawable;

/* compiled from: thread_theme_picker */
public class MQuickReplyBubbleOverlayDrawable extends RoundedCornerOverlayDrawable {
    public MQuickReplyBubbleOverlayDrawable(Context context) {
        c(context.getResources().getDimensionPixelSize(2131433776));
        mutate();
        a(context.getResources().getColor(2131363820));
        b(context.getResources().getColor(2131363294));
        float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(2131433777);
        a(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }
}
