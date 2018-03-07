package com.facebook.privacy.checkup.photofeed;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.checkup.protocol.C0739x5593ba48;
import javax.inject.Inject;

/* compiled from: java.vm.version */
public class PrivacyCheckupDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    Lazy<PhotoPrivacyFeedContentRowPartDefinition> f18672a;

    public static PrivacyCheckupDeclaration m26182b(InjectorLike injectorLike) {
        return new PrivacyCheckupDeclaration(IdBasedLazy.m1808a(injectorLike, 9695));
    }

    @Inject
    PrivacyCheckupDeclaration(Lazy<PhotoPrivacyFeedContentRowPartDefinition> lazy) {
        this.f18672a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(C0739x5593ba48.class, this.f18672a);
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(PhotoAudienceSpinnerPartDefinition.a);
        listItemRowController.m16558a(PhotoPrivacyFeedHeaderPartDefinition.a);
        listItemRowController.m16558a(PhotoPrivacyFeedContentRowPartDefinition.a);
    }
}
