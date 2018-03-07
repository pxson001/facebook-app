package com.facebook.heisman;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.DividerDecorator;

/* compiled from: video-covImg */
public class ProfileOverlayPageRecyclerViewInitializer {
    public static void m646a(BetterRecyclerView betterRecyclerView, Adapter adapter, Context context) {
        betterRecyclerView.v = true;
        betterRecyclerView.setLayoutManager(new BetterLinearLayoutManager(context));
        DividerDecorator dividerDecorator = new DividerDecorator(context.getResources().getColor(2131361940), 1);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131427442);
        dividerDecorator.b = dimensionPixelSize;
        dividerDecorator.c = dimensionPixelSize;
        dividerDecorator.e = true;
        betterRecyclerView.a(dividerDecorator);
        betterRecyclerView.setAdapter(adapter);
    }
}
