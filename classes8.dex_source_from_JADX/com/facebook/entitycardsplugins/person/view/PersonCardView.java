package com.facebook.entitycardsplugins.person.view;

import android.content.Context;
import com.facebook.entitycardsplugins.person.presenter.PersonCardPresenter;
import com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardActionBarView;
import com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemListView;
import com.facebook.entitycardsplugins.person.widget.footer.PersonCardFooterView;
import com.facebook.entitycardsplugins.person.widget.header.PersonCardHeaderView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.presenter.ViewPresenter;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: heisman_select_page_from_pivot */
public class PersonCardView extends CustomLinearLayout implements RecyclableView {
    public PersonCardPresenter f11253a;
    public PersonCardHeaderView f11254b;
    public PersonCardActionBarView f11255c;
    public PersonCardContextItemListView f11256d;
    public PersonCardFooterView f11257e;
    public boolean f11258f = false;

    public /* bridge */ /* synthetic */ void setPresenter(ViewPresenter viewPresenter) {
        this.f11253a = (PersonCardPresenter) viewPresenter;
    }

    public PersonCardView(Context context) {
        super(context);
        setContentView(2130906181);
        setOrientation(1);
        this.f11254b = (PersonCardHeaderView) a(2131565855);
        this.f11255c = (PersonCardActionBarView) a(2131565856);
        this.f11256d = (PersonCardContextItemListView) a(2131565857);
        this.f11257e = (PersonCardFooterView) a(2131565858);
    }

    public final boolean m13238a() {
        return this.f11258f;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1274018520);
        super.onAttachedToWindow();
        this.f11258f = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 243959205, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -235522140);
        super.onDetachedFromWindow();
        this.f11258f = false;
        if (this.f11253a != null) {
            this.f11253a.m13093a(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2046330496, a);
    }
}
