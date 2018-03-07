package com.facebook.privacy.checkup.ui;

import android.content.Context;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepAdapter.PrivacyCheckupActionCallbackInterface;

/* compiled from: ScrollView can host only one direct child */
public class PrivacyCheckupStepAdapterProvider extends AbstractAssistedProvider<PrivacyCheckupStepAdapter> {
    public final PrivacyCheckupStepAdapter m11576a(PrivacyCheckupActionCallbackInterface privacyCheckupActionCallbackInterface, PrivacyCheckupStepData privacyCheckupStepData) {
        return new PrivacyCheckupStepAdapter(LayoutInflaterMethodAutoProvider.b(this), ResourcesMethodAutoProvider.a(this), (Context) getInstance(Context.class), PrivacyCheckupAnalyticsLogger.m11461b(this), privacyCheckupActionCallbackInterface, privacyCheckupStepData);
    }
}
