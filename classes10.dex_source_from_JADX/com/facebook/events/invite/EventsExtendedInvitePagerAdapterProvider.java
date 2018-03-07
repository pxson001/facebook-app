package com.facebook.events.invite;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.facebook.events.invite.EventsExtendedInviteFragment.AddContactsButtonClickListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Set;

/* compiled from: clearHttpCache */
public class EventsExtendedInvitePagerAdapterProvider extends AbstractAssistedProvider<EventsExtendedInvitePagerAdapter> {
    public final EventsExtendedInvitePagerAdapter m18004a(Set<String> set, AddContactsButtonClickListener addContactsButtonClickListener, EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener, OnScrollListener onScrollListener, OnScrollListener onScrollListener2, FragmentManager fragmentManager) {
        return new EventsExtendedInvitePagerAdapter((Context) getInstance(Context.class), (EventsExtendedInvitePageHolderProvider) getOnDemandAssistedProviderForStaticDi(EventsExtendedInvitePageHolderProvider.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 4442), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), set, addContactsButtonClickListener, eventsExtendedInviteFriendSelectionChangedListener, onScrollListener, onScrollListener2, fragmentManager);
    }
}
