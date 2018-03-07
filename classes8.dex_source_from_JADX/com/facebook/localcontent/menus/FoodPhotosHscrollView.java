package com.facebook.localcontent.menus;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: ec_initial_card_action_bar_configured */
public class FoodPhotosHscrollView extends CustomLinearLayout {
    private RecyclerView f14983a;
    private FrameLayout f14984b;

    public FoodPhotosHscrollView(Context context) {
        super(context);
        m17435a();
    }

    public FoodPhotosHscrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m17435a();
    }

    protected FoodPhotosHscrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17435a();
    }

    private void m17435a() {
        setContentView(2130904400);
        setOrientation(1);
        this.f14983a = (RecyclerView) a(2131562116);
        this.f14984b = (FrameLayout) a(2131562117);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.b(0);
        this.f14983a.setLayoutManager(linearLayoutManager);
    }

    public void setSeeMoreOnClickListener(OnClickListener onClickListener) {
        this.f14984b.setOnClickListener(onClickListener);
    }

    public void setRecyclerOnScrollListener(OnScrollListener onScrollListener) {
        this.f14983a.setOnScrollListener(onScrollListener);
    }

    public void setRecyclerAdapter(Adapter adapter) {
        this.f14983a.setAdapter(adapter);
    }
}
