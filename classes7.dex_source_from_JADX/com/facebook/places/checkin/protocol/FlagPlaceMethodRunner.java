package com.facebook.places.checkin.protocol;

import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.places.checkin.models.FlagType;
import com.facebook.places.checkin.protocol.FlagPlaceMethod.Params;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: init_props */
public class FlagPlaceMethodRunner {
    public final FlagPlaceMethod f11092a;
    public final AbstractSingleMethodRunner f11093b;
    public final ListeningExecutorService f11094c;

    /* compiled from: init_props */
    public class C09741 implements Callable<Void> {
        final /* synthetic */ CheckinPlaceModel f11087a;
        final /* synthetic */ FlagType f11088b;
        final /* synthetic */ CrowdEntryPoint f11089c;
        final /* synthetic */ CrowdEndpoint f11090d;
        final /* synthetic */ FlagPlaceMethodRunner f11091e;

        public C09741(FlagPlaceMethodRunner flagPlaceMethodRunner, CheckinPlaceModel checkinPlaceModel, FlagType flagType, CrowdEntryPoint crowdEntryPoint, CrowdEndpoint crowdEndpoint) {
            this.f11091e = flagPlaceMethodRunner;
            this.f11087a = checkinPlaceModel;
            this.f11088b = flagType;
            this.f11089c = crowdEntryPoint;
            this.f11090d = crowdEndpoint;
        }

        public Object call() {
            this.f11091e.f11093b.a(this.f11091e.f11092a, new Params(this.f11087a, this.f11088b, this.f11089c, this.f11090d));
            return null;
        }
    }

    @Inject
    public FlagPlaceMethodRunner(FlagPlaceMethod flagPlaceMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, ListeningExecutorService listeningExecutorService) {
        this.f11092a = flagPlaceMethod;
        this.f11093b = abstractSingleMethodRunner;
        this.f11094c = listeningExecutorService;
    }
}
