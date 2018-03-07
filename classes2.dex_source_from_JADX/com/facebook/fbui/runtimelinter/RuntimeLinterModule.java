package com.facebook.fbui.runtimelinter;

import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.fbui.runtimelinter.rules.MaximumViewDepthRule;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

@InjectorModule
/* compiled from: qp_controller_id */
public class RuntimeLinterModule extends AbstractLibraryModule {
    private static final Set<Product> f8518a = ImmutableSet.of(Product.FB4A);

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsRuntimeLinterEnabled
    public static Boolean m13065a(FbAppType fbAppType, FbSharedPreferences fbSharedPreferences) {
        boolean z = f8518a.contains(fbAppType.j) && fbSharedPreferences.mo286a(RuntimeLinterPrefKeys.f8520b, RuntimeLinterPrefKeys.f8521c.booleanValue());
        return Boolean.valueOf(z);
    }

    public static MaximumViewDepthRule getInstanceForTest_MaximumViewDepthRule(FbInjector fbInjector) {
        return MaximumViewDepthRule.a(fbInjector);
    }
}
