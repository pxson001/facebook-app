package com.facebook.privacy.audience;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;

/* compiled from: photo_checkup/?source=%s&checkup_type=%s */
public class PostPrivacyUpsellDialogFragmentControllerProvider extends AbstractAssistedProvider<PostPrivacyUpsellDialogFragmentController> {
    public final PostPrivacyUpsellDialogFragmentController m15173a(PostPrivacyUpsellDialogController$EntryPoint postPrivacyUpsellDialogController$EntryPoint) {
        return new PostPrivacyUpsellDialogFragmentController(postPrivacyUpsellDialogController$EntryPoint, IdBasedLazy.m1808a(this, 9686));
    }
}
