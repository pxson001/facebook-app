package com.facebook.events.invite;

import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import java.util.Set;

/* compiled from: click_through */
public class EventsExtendedInviteFriendsListSectionAdapterProvider extends AbstractAssistedProvider<EventsExtendedInviteFriendsListSectionAdapter> {
    public final EventsExtendedInviteFriendsListSectionAdapter m17970a(String str, boolean z, int i, ImmutableList<SimpleUserToken> immutableList, Set<String> set, EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener, InviteSubSessionTypes inviteSubSessionTypes) {
        return new EventsExtendedInviteFriendsListSectionAdapter(InviteSessionLogger.m18047a((InjectorLike) this), Toaster.b(this), str, z, i, immutableList, set, eventsExtendedInviteFriendSelectionChangedListener, inviteSubSessionTypes);
    }
}
