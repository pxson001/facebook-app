package com.facebook.abtest.qe;

import android.content.Context;
import android.preference.Preference;
import com.facebook.abtest.qe.annotations.ForQuickExperiment;
import com.facebook.abtest.qe.preferences.QuickExperimentPreferences;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.provider.IProvidePreferences;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Provider;

@InjectorModule
/* compiled from: treehouseMembers */
public class QuickExperimentPrefsModule extends AbstractLibraryModule {

    /* compiled from: treehouseMembers */
    final class C01001 implements IProvidePreferences {
        final /* synthetic */ Provider f1698a;

        C01001(Provider provider) {
            this.f1698a = provider;
        }

        public final List<Preference> mo474a(Context context) {
            return ImmutableList.of(new QuickExperimentPreferences(context, this.f1698a));
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForQuickExperiment
    public static IProvidePreferences m2293a(Provider<Boolean> provider) {
        return new C01001(provider);
    }
}
