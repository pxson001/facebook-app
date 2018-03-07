package com.facebook.localstats;

import com.facebook.analytics.counterlogger.CommunicationScheduler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: prompt_id */
public class LocalStatsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static LocalStatsLogger m13611a(CommunicationScheduler communicationScheduler, Set<LocalStatsValuesListener> set) {
        return new LocalStatsLoggerImpl(communicationScheduler, set, ImmutableSet.of(new LocalStatsEventDefinition("mobile_power_stats", new Builder().m609b(Integer.valueOf(7208962), Integer.valueOf(16)).m609b(Integer.valueOf(7208961), Integer.valueOf(16)).m609b(Integer.valueOf(7208963), Integer.valueOf(16)).m609b(Integer.valueOf(7208987), Integer.valueOf(16)).m609b(Integer.valueOf(7208986), Integer.valueOf(16)).m609b(Integer.valueOf(7208988), Integer.valueOf(16)).m609b(Integer.valueOf(7208964), Integer.valueOf(16)).m609b(Integer.valueOf(7208965), Integer.valueOf(16)).m609b(Integer.valueOf(7208968), Integer.valueOf(16)).m609b(Integer.valueOf(7208967), Integer.valueOf(16)).m609b(Integer.valueOf(7208966), Integer.valueOf(16)).m609b(Integer.valueOf(7208974), Integer.valueOf(16)).m609b(Integer.valueOf(7208973), Integer.valueOf(16)).m609b(Integer.valueOf(7208975), Integer.valueOf(16)).m609b(Integer.valueOf(7208976), Integer.valueOf(16)).m609b(Integer.valueOf(7208971), Integer.valueOf(16)).m609b(Integer.valueOf(7208970), Integer.valueOf(16)).m609b(Integer.valueOf(7208969), Integer.valueOf(16)).m609b(Integer.valueOf(7208978), Integer.valueOf(16)).m609b(Integer.valueOf(7208981), Integer.valueOf(16)).m609b(Integer.valueOf(7208979), Integer.valueOf(16)).m609b(Integer.valueOf(7208983), Integer.valueOf(16)).m609b(Integer.valueOf(7208984), Integer.valueOf(16)).m609b(Integer.valueOf(7208985), Integer.valueOf(16)).m610b()), new LocalStatsEventDefinition("mobile_power_attribution_stats", new Builder().m609b(Integer.valueOf(7208972), Integer.valueOf(16)).m609b(Integer.valueOf(7208980), Integer.valueOf(16)).m609b(Integer.valueOf(7208982), Integer.valueOf(16)).m610b())));
    }
}
