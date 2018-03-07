package com.facebook.contacts.upload;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: tapped_follow_switcher_see_first */
public class ContactUploadUpsellController {
    public final FbSharedPreferences f2114a;
    public final Clock f2115b;
    private final ContactUploadStatusHelper f2116c;

    public static ContactUploadUpsellController m2089b(InjectorLike injectorLike) {
        return new ContactUploadUpsellController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactUploadStatusHelper.b(injectorLike));
    }

    @Inject
    public ContactUploadUpsellController(FbSharedPreferences fbSharedPreferences, Clock clock, ContactUploadStatusHelper contactUploadStatusHelper) {
        this.f2114a = fbSharedPreferences;
        this.f2115b = clock;
        this.f2116c = contactUploadStatusHelper;
    }
}
