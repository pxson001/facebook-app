package com.facebook.events.invite;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ViewGroup;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.events.invite.EventsExtendedInviteFragment.AddContactsButtonClickListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import java.util.Set;

/* compiled from: clickX */
public class EventsExtendedInvitePageHolderProvider extends AbstractAssistedProvider<EventsExtendedInvitePageHolder> {
    public final EventsExtendedInvitePageHolder m17992a(ViewGroup viewGroup, EventsExtendedInviteContactType eventsExtendedInviteContactType, Set<String> set, int i, boolean z, ImmutableList<SimpleUserToken> immutableList, ImmutableList<SimpleUserToken> immutableList2, boolean z2, ImmutableList<SimpleUserToken> immutableList3, boolean z3, AddContactsButtonClickListener addContactsButtonClickListener, EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener, OnScrollListener onScrollListener, OnScrollListener onScrollListener2, FragmentManager fragmentManager) {
        return new EventsExtendedInvitePageHolder((EventsExtendedInviteFriendsListSectionAdapterProvider) getOnDemandAssistedProviderForStaticDi(EventsExtendedInviteFriendsListSectionAdapterProvider.class), InvitePickerPerformanceLogger.m18041a(this), InviteSessionLogger.m18047a((InjectorLike) this), InterstitialManager.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), (FragmentFactoryMap) FragmentFactoryMapImpl.a(this), IdBasedProvider.a(this, 4442), TipSeenTracker.a(this), viewGroup, eventsExtendedInviteContactType, set, i, z, immutableList, immutableList2, z2, immutableList3, z3, addContactsButtonClickListener, eventsExtendedInviteFriendSelectionChangedListener, onScrollListener, onScrollListener2, fragmentManager);
    }
}
