package com.facebook.events.permalink.messageguests;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.EventGuestListLoadingRowView;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.messageguests.EventBasicGuestListAdapter.ViewTypes;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: bglr-gcm-scheduler */
public class EventMessageGuestsAdapter extends EventBasicGuestListAdapter {
    @Inject
    public EventMessageGuestsAdapter(Context context, @Assisted EventGuestListType eventGuestListType) {
        super(new ContextThemeWrapper(context, 2131625810));
        this.f18333g = eventGuestListType;
    }

    public final View m18951a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        if (m18680f(i) < i2) {
            m18679d(i, i2);
        }
        ViewTypes viewTypes = ViewTypes.values()[m18678c(i, i2)];
        if (view == null) {
            EventMessageGuestsRow eventMessageGuestsRow;
            switch (viewTypes) {
                case CHILD:
                    eventMessageGuestsRow = new EventMessageGuestsRow(this.f18329c);
                    break;
                case LOADING:
                    eventMessageGuestsRow = new EventGuestListLoadingRowView(this.f18329c);
                    break;
                default:
                    eventMessageGuestsRow = null;
                    break;
            }
            view2 = eventMessageGuestsRow;
        } else {
            view2 = view;
        }
        if (viewTypes == ViewTypes.CHILD) {
            ((EventMessageGuestsRow) view2).m18981a((EventUser) m18671a(i, i2), this.f18333g);
        }
        return view2;
    }
}
