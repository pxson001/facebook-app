package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import javax.annotation.Nullable;

/* compiled from: messenger_animated_sticker_previews_android */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public GenericDraweeView(Context context) {
        super(context);
        m20508a(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20508a(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20508a(context, attributeSet);
    }

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20508a(context, attributeSet);
    }

    protected void m20508a(Context context, @Nullable AttributeSet attributeSet) {
        GenericDraweeHierarchyBuilder a = GenericDraweeHierarchyInflater.m20549a(context, attributeSet);
        setAspectRatio(a.f14197e);
        setHierarchy(a.m20571u());
    }
}
