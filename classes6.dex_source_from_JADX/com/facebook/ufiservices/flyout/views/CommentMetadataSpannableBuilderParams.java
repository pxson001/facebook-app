package com.facebook.ufiservices.flyout.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.google.common.base.Preconditions;

/* compiled from: custom_ringtone */
public class CommentMetadataSpannableBuilderParams {
    public final Context f18144a;
    public CommentMetadataSpannableBuilder$Delegate f18145b;
    public Drawable f18146c;
    public String f18147d;

    public CommentMetadataSpannableBuilderParams(Context context) {
        Preconditions.checkNotNull(context);
        this.f18144a = context;
    }

    public final Resources m26695b() {
        return this.f18144a.getResources();
    }
}
