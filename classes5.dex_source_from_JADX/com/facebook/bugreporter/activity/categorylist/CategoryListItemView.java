package com.facebook.bugreporter.activity.categorylist;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.util.TriState;
import com.facebook.widget.CustomViewGroup;

/* compiled from: android.media.metadata.ART */
public class CategoryListItemView extends CustomViewGroup {
    public final TextView f10712a = ((TextView) getView(2131560268));
    public final TriState f10713b;
    public CategoryInfo f10714c;

    public CategoryListItemView(Context context, TriState triState) {
        super(context);
        setContentView(2130903527);
        this.f10713b = triState;
    }
}
