package com.facebook.entitycards.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.presenter.ViewPresenter;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: home_%s_network_error */
public class EntityCardsErrorCardView extends CustomFrameLayout implements RecyclableView {
    private final OnClickListener f11127a = new C12071(this);
    public boolean f11128b = false;
    public EntityCardsErrorCardPresenter f11129c;

    /* compiled from: home_%s_network_error */
    class C12071 implements OnClickListener {
        final /* synthetic */ EntityCardsErrorCardView f11126a;

        C12071(EntityCardsErrorCardView entityCardsErrorCardView) {
            this.f11126a = entityCardsErrorCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 680081867);
            if (this.f11126a.f11129c != null) {
                EntityCardsErrorCardPresenter entityCardsErrorCardPresenter = this.f11126a.f11129c;
                entityCardsErrorCardPresenter.f11125b.m12958b(entityCardsErrorCardPresenter.f11124a.f11078a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 694600869, a);
        }
    }

    public /* bridge */ /* synthetic */ void setPresenter(ViewPresenter viewPresenter) {
        this.f11129c = (EntityCardsErrorCardPresenter) viewPresenter;
    }

    public EntityCardsErrorCardView(Context context) {
        super(context);
        setContentView(2130903983);
        setBackgroundResource(2130839472);
        c(2131561194).setOnClickListener(this.f11127a);
    }

    public final boolean m13068a() {
        return this.f11128b;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1333194711);
        super.onAttachedToWindow();
        this.f11128b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 100284474, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 139204307);
        super.onDetachedFromWindow();
        this.f11128b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1094887671, a);
    }
}
