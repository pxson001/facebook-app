package com.facebook.productionprompts.common;

import android.content.Intent;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.inject.InjectorLike;
import com.facebook.productionprompts.events.PromptCancelFlowEvent;
import com.facebook.productionprompts.events.PromptCompleteFlowEvent;
import com.facebook.productionprompts.events.PromptsEventBus;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.ClipboardPromptObject;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_extend_access_token */
public class PromptActivityResultHandler extends BaseController implements ActivityResultCallback {
    private final PromptsEventBus f9713a;

    public static PromptActivityResultHandler m14725a(InjectorLike injectorLike) {
        return new PromptActivityResultHandler(PromptsEventBus.m14730a(injectorLike));
    }

    @Inject
    public PromptActivityResultHandler(PromptsEventBus promptsEventBus) {
        this.f9713a = promptsEventBus;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (m14727b(i, i2, intent)) {
            String stringExtra = intent.getStringExtra("prompt_object_class_name_extra");
            PromptAnalytics promptAnalytics = (PromptAnalytics) intent.getParcelableExtra("prompt_entry_point_analytics_extra");
            if (i2 == -1) {
                this.f9713a.mo651a(new PromptCompleteFlowEvent(m14726a(stringExtra), promptAnalytics, intent.getBooleanExtra("did_use_prompt_extra", false)));
            } else if (i2 == 0) {
                this.f9713a.mo651a(new PromptCancelFlowEvent(m14726a(stringExtra), promptAnalytics));
            }
        }
    }

    private static Class<? extends PromptObject> m14726a(String str) {
        if (ProductionPromptObject.class.getSimpleName().equals(str)) {
            return ProductionPromptObject.class;
        }
        if (PhotoReminderPromptObject.class.getSimpleName().equals(str)) {
            return PhotoReminderPromptObject.class;
        }
        if (ClipboardPromptObject.class.getSimpleName().equals(str)) {
            return ClipboardPromptObject.class;
        }
        if (SouvenirPromptObject.class.getSimpleName().equals(str)) {
            return SouvenirPromptObject.class;
        }
        return PromptObject.class;
    }

    @VisibleForTesting
    private boolean m14727b(int i, int i2, @Nullable Intent intent) {
        Object obj;
        if (i == 1756 || i == 8371 || i == 8372 || i == 8373 || i == 127) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            obj = (i2 == -1 || i2 == 0) ? 1 : null;
            if (obj != null) {
                obj = (intent != null && intent.hasExtra("prompt_entry_point_analytics_extra") && intent.hasExtra("prompt_object_class_name_extra")) ? 1 : null;
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
