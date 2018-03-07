package com.facebook.messaging.quickpromotion;

import android.content.Context;
import android.content.Intent;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: register */
public final class QuickPromotionThreadListBannerController extends QuickPromotionController {
    @Inject
    public QuickPromotionThreadListBannerController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final String m3586b() {
        return "3543";
    }

    public final Intent m3585b(Context context) {
        return new Intent();
    }

    protected final long m3587f() {
        return 0;
    }

    public final String m3588g() {
        return "Messenger Thread List Banner";
    }

    public final Set m3589j() {
        return ImmutableSet.of(TemplateType.ANDROID_MESSENGER_THREAD_LIST_HEADER_BANNER, TemplateType.ANDROID_MESSENGER_THREAD_LIST_HEADER_BUTTONLESS_BANNER);
    }
}
