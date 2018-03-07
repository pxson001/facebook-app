package com.facebook.photos.pandora.common.ui.views;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLVideo;

/* compiled from: com.facebook.search.results.environment */
public class ThumbnailEntry {
    public final Drawable f17566a;
    public Rect f17567b;
    public final DraweeHolder f17568c;
    public String f17569d;
    public Uri f17570e;
    public GraphQLPhoto f17571f;
    public GraphQLVideo f17572g;
    public CharSequence f17573h;

    ThumbnailEntry(DraweeHolder draweeHolder) {
        this.f17568c = draweeHolder;
        this.f17566a = draweeHolder.h();
    }
}
