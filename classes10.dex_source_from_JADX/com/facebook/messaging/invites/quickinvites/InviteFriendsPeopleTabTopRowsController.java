package com.facebook.messaging.invites.quickinvites;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.upload.ContactUploadUpsellController;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: selected_location_filter_current_location */
public class InviteFriendsPeopleTabTopRowsController {
    public final FbSharedPreferences f2991a;
    public final Clock f2992b;
    private final ContactUploadUpsellController f2993c;

    public static InviteFriendsPeopleTabTopRowsController m2977b(InjectorLike injectorLike) {
        return new InviteFriendsPeopleTabTopRowsController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactUploadUpsellController.b(injectorLike));
    }

    @Inject
    public InviteFriendsPeopleTabTopRowsController(FbSharedPreferences fbSharedPreferences, Clock clock, ContactUploadUpsellController contactUploadUpsellController) {
        this.f2991a = fbSharedPreferences;
        this.f2992b = clock;
        this.f2993c = contactUploadUpsellController;
    }
}
