package com.facebook.entitycardsplugins.person.widget.contextitemlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: heisman_fetch_self_profile_picture_failed */
public class PersonCardContextItemListView extends CustomFrameLayout {
    private final OnClickListener f11386a = new C12401(this);
    private final LinearLayout f11387b;
    private final View f11388c;
    private final View f11389d;
    @Nullable
    private View f11390e;
    private State f11391f;
    public PersonCardContextItemListPresenter f11392g;

    /* compiled from: heisman_fetch_self_profile_picture_failed */
    class C12401 implements OnClickListener {
        final /* synthetic */ PersonCardContextItemListView f11385a;

        C12401(PersonCardContextItemListView personCardContextItemListView) {
            this.f11385a = personCardContextItemListView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1936700300);
            if (this.f11385a.f11392g != null) {
                PersonCardContextItemListPresenter personCardContextItemListPresenter = this.f11385a.f11392g;
                personCardContextItemListPresenter.f11369a.m12958b(personCardContextItemListPresenter.f11377i.m13204r());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1700126644, a);
        }
    }

    /* compiled from: heisman_fetch_self_profile_picture_failed */
    public enum State {
        LOADING_MOVING_SPINNER,
        LOADING_STATIC_SPINNER,
        ERROR,
        READY
    }

    public PersonCardContextItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906178);
        this.f11387b = (LinearLayout) c(2131565846);
        this.f11388c = c(2131565847);
        this.f11389d = c(2131565848);
    }

    public void setPresenter(PersonCardContextItemListPresenter personCardContextItemListPresenter) {
        this.f11392g = personCardContextItemListPresenter;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -110183258);
        super.onDetachedFromWindow();
        if (this.f11392g != null) {
            this.f11392g.m13306a(this);
            this.f11392g = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2053769054, a);
    }

    public State getState() {
        return this.f11391f;
    }

    public void setState(State state) {
        int i;
        int i2 = 0;
        this.f11391f = state;
        this.f11387b.setVisibility(state == State.READY ? 0 : 8);
        View view = this.f11388c;
        if (state == State.LOADING_MOVING_SPINNER) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        view = this.f11389d;
        if (state == State.LOADING_STATIC_SPINNER) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        if (this.f11390e == null && state == State.ERROR) {
            this.f11390e = ((ViewStub) c(2131565849)).inflate();
            this.f11390e.findViewById(2131565851).setOnClickListener(this.f11386a);
        }
        if (this.f11390e != null) {
            View view2 = this.f11390e;
            if (state != State.ERROR) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final void m13315a() {
        for (int i = 0; i < this.f11387b.getChildCount(); i++) {
            this.f11387b.getChildAt(i).setVisibility(8);
        }
    }

    public int getItemViewCount() {
        return this.f11387b.getChildCount();
    }

    public final int m13313a(PlutoniumContextualItemView plutoniumContextualItemView) {
        return this.f11387b.indexOfChild(plutoniumContextualItemView);
    }

    public final PlutoniumContextualItemView m13314a(int i) {
        return (PlutoniumContextualItemView) this.f11387b.getChildAt(i);
    }
}
