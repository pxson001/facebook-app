package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView.ScaleType;

/* compiled from: ServicesSectionUpdateMutation */
public class AttachmentDisplayInfo {
    public final Uri f23330a;
    public final ScaleType f23331b;
    public final boolean f23332c;
    @Nullable
    public final CharSequence f23333d;

    public AttachmentDisplayInfo(Builder builder) {
        this.f23330a = builder.a;
        this.f23331b = builder.b;
        this.f23332c = builder.c;
        this.f23333d = builder.d;
    }
}
