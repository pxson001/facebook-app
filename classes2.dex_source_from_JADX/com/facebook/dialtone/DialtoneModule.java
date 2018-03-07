package com.facebook.dialtone;

import com.facebook.dialtone.common.IsDialtoneEnabled;
import com.facebook.dialtone.common.IsDialtoneFacewebFeatureEnabled;
import com.facebook.dialtone.common.IsDialtoneFeedCapFeatureEnabled;
import com.facebook.dialtone.common.IsDialtonePhotoCapFeatureEnabled;
import com.facebook.dialtone.common.IsDialtonePhotoFeatureEnabled;
import com.facebook.dialtone.common.IsUserEligibleForDialtone;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: num_days_until_show_weekend_photo_reminder_prompt_again */
public class DialtoneModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsDialtoneEnabled
    public static Boolean m17668a(DialtoneController dialtoneController) {
        return Boolean.valueOf(dialtoneController.mo1221b());
    }

    @ProviderMethod
    @IsUserEligibleForDialtone
    public static Boolean m17669b(DialtoneController dialtoneController) {
        return Boolean.valueOf(dialtoneController.mo1213a());
    }

    @ProviderMethod
    @IsDialtonePhotoFeatureEnabled
    public static Boolean m17670c(DialtoneController dialtoneController) {
        return Boolean.valueOf(dialtoneController.mo1231j());
    }

    @ProviderMethod
    @IsDialtonePhotoCapFeatureEnabled
    public static Boolean m17671d(DialtoneController dialtoneController) {
        return Boolean.valueOf(dialtoneController.mo1232k());
    }

    @ProviderMethod
    @IsDialtoneFeedCapFeatureEnabled
    static Boolean m17672e(DialtoneController dialtoneController) {
        return Boolean.valueOf(dialtoneController.mo1233l());
    }

    @ProviderMethod
    @IsDialtoneFacewebFeatureEnabled
    static Boolean m17673f(DialtoneController dialtoneController) {
        return Boolean.valueOf(dialtoneController.mo1234m());
    }
}
