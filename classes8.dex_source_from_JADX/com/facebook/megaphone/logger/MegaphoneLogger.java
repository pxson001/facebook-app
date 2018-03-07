package com.facebook.megaphone.logger;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.megaphone.api.LogMegaphoneParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tsid */
public class MegaphoneLogger {
    private final Provider<BlueServiceOperationFactory> f1311a;

    @Inject
    public MegaphoneLogger(Provider<BlueServiceOperationFactory> provider) {
        this.f1311a = provider;
    }

    public final void m1539a(GraphQLMegaphone graphQLMegaphone, String str) {
        Map c = Maps.c();
        if (graphQLMegaphone.t() != null) {
            c.put("tracking", graphQLMegaphone.t());
        }
        Parcelable logMegaphoneParams = new LogMegaphoneParams(graphQLMegaphone.k(), str, c);
        Bundle bundle = new Bundle();
        bundle.putParcelable("logMegaphoneParams", logMegaphoneParams);
        BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f1311a.get(), "log_megaphone", bundle, 1546748447).a();
    }
}
