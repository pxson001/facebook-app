package com.facebook.contacts.pna.qps;

import android.content.Context;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.contacts.pna.PhoneNumberAcquisitionClient;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;
import com.facebook.ui.toaster.Toaster;
import java.util.concurrent.ExecutorService;

/* compiled from: platformItemFbId */
public class PhoneNumberAcquisitionQPControllerProvider extends AbstractAssistedProvider<PhoneNumberAcquisitionQPController> {
    public final PhoneNumberAcquisitionQPController m6867a(Context context, QuickPromotionViewHelper quickPromotionViewHelper, Runnable runnable, QuickPromotionDefinition quickPromotionDefinition, PhoneNumberAcquisitionQPView phoneNumberAcquisitionQPView) {
        return new PhoneNumberAcquisitionQPController((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), FbUriIntentHandler.a(this), PhoneNumberAcquisitionClient.m6847b(this), Toaster.b(this), IdBasedLazy.a(this, 882), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), context, quickPromotionViewHelper, runnable, quickPromotionDefinition, phoneNumberAcquisitionQPView);
    }
}
