package com.facebook.events.invite;

import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.events.invite.EventsExtendedInviteActivity.C24752;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.SectionLookUpResult;
import com.facebook.widget.sectionedadapter.SectionedAdapterForRecyclerView;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;

/* compiled from: client_cap_value */
public class EventsExtendedInviteFriendsListAdapter extends SectionedAdapterForRecyclerView<EventsExtendedInviteFriendsListSectionAdapter> {
    public final void m17963a(View view, Object obj) {
        Integer num = (Integer) obj;
        if (num == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        ((TextView) view.findViewById(2131562284)).setText(new String(Character.toChars(num.intValue())));
    }

    public EventsExtendedInviteFriendsListAdapter(ImmutableList<EventsExtendedInviteFriendsListSectionAdapter> immutableList) {
        super(immutableList);
    }

    public final void m17964f(int i) {
        SectionLookUpResult e = e(i);
        EventsExtendedInviteFriendsListSectionAdapter eventsExtendedInviteFriendsListSectionAdapter = (EventsExtendedInviteFriendsListSectionAdapter) e.b;
        boolean z = true;
        Object item = eventsExtendedInviteFriendsListSectionAdapter.getItem(e.a);
        if (item instanceof SimpleUserToken) {
            SimpleUserToken simpleUserToken = (SimpleUserToken) item;
            if (simpleUserToken.a()) {
                String p = simpleUserToken.p();
                boolean contains = eventsExtendedInviteFriendsListSectionAdapter.f17604d.contains(p);
                if (contains) {
                    eventsExtendedInviteFriendsListSectionAdapter.f17604d.remove(p);
                    eventsExtendedInviteFriendsListSectionAdapter.f17610j.m18056b(eventsExtendedInviteFriendsListSectionAdapter.f17603c, 1);
                } else if (eventsExtendedInviteFriendsListSectionAdapter.f17604d.size() >= eventsExtendedInviteFriendsListSectionAdapter.f17606f) {
                    eventsExtendedInviteFriendsListSectionAdapter.f17609i.b(new ToastBuilder(2131232667));
                } else {
                    eventsExtendedInviteFriendsListSectionAdapter.f17604d.add(p);
                    eventsExtendedInviteFriendsListSectionAdapter.f17610j.m18053a(eventsExtendedInviteFriendsListSectionAdapter.f17603c, 1);
                }
                C24752 c24752 = eventsExtendedInviteFriendsListSectionAdapter.f17607g;
                if (contains) {
                    z = false;
                }
                c24752.m17869a(simpleUserToken, z, false);
            }
        }
        notifyDataSetChanged();
    }

    public final Object m17962a(int i) {
        Integer valueOf;
        SectionLookUpResult e = e(i);
        EventsExtendedInviteFriendsListSectionAdapter eventsExtendedInviteFriendsListSectionAdapter = (EventsExtendedInviteFriendsListSectionAdapter) e.b;
        int i2 = e.a;
        if (eventsExtendedInviteFriendsListSectionAdapter.f17602b && eventsExtendedInviteFriendsListSectionAdapter.getItemViewType(i2) == 0) {
            SimpleUserToken simpleUserToken = (SimpleUserToken) eventsExtendedInviteFriendsListSectionAdapter.getItem(i2);
            valueOf = !StringUtil.a(simpleUserToken.b()) ? Integer.valueOf(simpleUserToken.b().toUpperCase().codePointAt(0)) : null;
        } else {
            valueOf = null;
        }
        return valueOf;
    }
}
