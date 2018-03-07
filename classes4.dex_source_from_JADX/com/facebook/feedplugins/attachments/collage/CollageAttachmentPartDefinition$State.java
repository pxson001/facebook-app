package com.facebook.feedplugins.attachments.collage;

import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.collage.CollageLayoutCalculator;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.common.collect.ImmutableList;

/* compiled from: oauth/access_token */
public class CollageAttachmentPartDefinition$State {
    public final DraweeController f6310a;
    public final CollageLayoutCalculator<StoryCollageItem> f6311b;
    public final ImmutableList<StoryCollageItem> f6312c;
    public final DraweeController[] f6313d;
    public final ImageRequest[] f6314e;
    public final OnImageClickListener<StoryCollageItem> f6315f;
    public final int f6316g;
    public final String[] f6317h;

    public CollageAttachmentPartDefinition$State(CollageLayoutCalculator<StoryCollageItem> collageLayoutCalculator, ImmutableList<StoryCollageItem> immutableList, DraweeController[] draweeControllerArr, DraweeController draweeController, ImageRequest[] imageRequestArr, OnImageClickListener<StoryCollageItem> onImageClickListener, int i, String[] strArr) {
        this.f6311b = collageLayoutCalculator;
        this.f6312c = immutableList;
        this.f6313d = draweeControllerArr;
        this.f6310a = draweeController;
        this.f6314e = imageRequestArr;
        this.f6315f = onImageClickListener;
        this.f6316g = i;
        this.f6317h = strArr;
    }
}
