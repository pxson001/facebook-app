package com.facebook.events.permalink.guestlist.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: header_one_style */
public class EventsGuestListFragmentNavigationHelper {
    private final SecureContextHelper f11455a;
    private final Provider<ComponentName> f11456b;

    public static EventsGuestListFragmentNavigationHelper m13381b(InjectorLike injectorLike) {
        return new EventsGuestListFragmentNavigationHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public EventsGuestListFragmentNavigationHelper(SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider) {
        this.f11455a = secureContextHelper;
        this.f11456b = provider;
    }

    public final void m13382a(Context context, EventsGuestListInitializationModel eventsGuestListInitializationModel) {
        m13380a(context, m13378a(eventsGuestListInitializationModel));
    }

    public final void m13383a(Context context, EventsGuestListInitializationModel eventsGuestListInitializationModel, EventGuestListType eventGuestListType) {
        m13380a(context, m13379a(eventsGuestListInitializationModel, eventGuestListType));
    }

    private void m13380a(Context context, Bundle bundle) {
        Intent component = new Intent().setComponent((ComponentName) this.f11456b.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_GUEST_LIST_FRAGMENT.ordinal());
        component.putExtras(bundle);
        this.f11455a.a(component, context);
    }

    private static Bundle m13378a(EventsGuestListInitializationModel eventsGuestListInitializationModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("GUEST_LIST_INITIALIZATION_MODEL", eventsGuestListInitializationModel);
        return bundle;
    }

    public static Bundle m13379a(EventsGuestListInitializationModel eventsGuestListInitializationModel, EventGuestListType eventGuestListType) {
        Bundle a = m13378a(eventsGuestListInitializationModel);
        a.putString("EVENT_GUEST_LIST_RSVP_TYPE", eventGuestListType.toString());
        return a;
    }
}
