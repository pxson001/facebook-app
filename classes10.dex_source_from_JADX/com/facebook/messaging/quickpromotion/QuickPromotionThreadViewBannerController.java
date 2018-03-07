package com.facebook.messaging.quickpromotion;

import android.content.Context;
import android.content.Intent;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: region_topic_ids */
public final class QuickPromotionThreadViewBannerController extends QuickPromotionController {
    @Inject
    public QuickPromotionThreadViewBannerController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public final String m3591b() {
        return "3545";
    }

    public final Intent m3590b(Context context) {
        return new Intent();
    }

    protected final long m3592f() {
        return 0;
    }

    public final String m3593g() {
        return "Messenger Thread View Banner";
    }

    public final Set m3594j() {
        return ImmutableSet.of(TemplateType.ANDROID_MESSENGER_THREAD_VIEW_HEADER_BANNER, TemplateType.ANDROID_MESSENGER_THREAD_VIEW_HEADER_BUTTONLESS_BANNER, TemplateType.ANDROID_MESSENGER_THREAD_VIEW_COMPOSER_BANNER, TemplateType.ANDROID_MESSENGER_THREAD_VIEW_COMPOSER_BUTTONLESS_BANNER);
    }
}
