package com.facebook.commerce.storefront.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;

/* compiled from: could_not_create_intent_for_activity */
public class GridItemViewHolder extends ViewHolder {
    public GridProductItemView f15785l;
    private Context f15786m;
    public AbstractFbErrorReporter f15787n;

    public GridItemViewHolder(GridProductItemView gridProductItemView, Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(gridProductItemView);
        this.f15787n = abstractFbErrorReporter;
        this.f15785l = gridProductItemView;
        this.f15786m = context;
    }
}
