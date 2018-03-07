package com.facebook.zero.common;

import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.iorg.common.zero.annotations.IsZeroRatingCampaignEnabled;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.annotations.CurrentlyActiveTokenType;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.sdk.token.ZeroToken;
import javax.inject.Provider;

@InjectorModule
/* compiled from: ptr_client_reranking_timeout */
public class ZeroCommonModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @CurrentlyActiveTokenType
    public static FbZeroTokenType m13487a(Provider<Boolean> provider) {
        return ((Boolean) provider.get()).booleanValue() ? FbZeroTokenType.DIALTONE : FbZeroTokenType.NORMAL;
    }

    @ProviderMethod
    @IsZeroRatingCampaignEnabled
    public static Boolean m13488a(TriState triState, FbSharedPreferences fbSharedPreferences, Provider<FbZeroTokenType> provider) {
        if (triState != TriState.YES || !fbSharedPreferences.mo284a()) {
            return Boolean.FALSE;
        }
        boolean z = ZeroToken.m31486a(fbSharedPreferences.mo278a(((FbZeroTokenType) provider.get()).getCampaignIdKey(), "")) && "enabled".equals(fbSharedPreferences.mo278a(((FbZeroTokenType) provider.get()).getStatusKey(), ""));
        return Boolean.valueOf(z);
    }
}
