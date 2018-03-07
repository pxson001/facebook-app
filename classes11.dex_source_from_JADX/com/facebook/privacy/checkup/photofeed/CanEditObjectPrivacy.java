package com.facebook.privacy.checkup.photofeed;

import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import javax.annotation.Nullable;

/* compiled from: StoreLocatorNearbyLocationsQuery */
public interface CanEditObjectPrivacy extends AnyEnvironment {
    @Nullable
    PrivacyOptionFieldsWithExplanation mo289a();

    PrivacyOptionFieldsWithExplanation mo290a(String str);

    void mo291a(String str, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation);

    void mo292a(boolean z);
}
