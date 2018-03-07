package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.build.BuildConstants;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegateProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: messenger_thread_customizations_viewer */
public abstract class QuickPromotionMegaphoneController extends QuickPromotionController {
    public static final String f13675a = (BuildConstants.j ? "3332" : "1822");

    protected QuickPromotionMegaphoneController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        super(quickPromotionControllerDelegateProvider);
    }

    public String mo1173b() {
        return "1822";
    }

    public final Intent mo1683b(Context context) {
        return new Intent();
    }

    public final long mo1684f() {
        return 0;
    }

    public final String mo1685g() {
        return "Megaphone";
    }

    public final Set<TemplateType> mo1686j() {
        return ImmutableSet.of(TemplateType.STANDARD_MEGAPHONE, TemplateType.BRANDED_MEGAPHONE, TemplateType.SURVEY_MEGAPHONE, TemplateType.CUSTOM_RENDERED);
    }
}
