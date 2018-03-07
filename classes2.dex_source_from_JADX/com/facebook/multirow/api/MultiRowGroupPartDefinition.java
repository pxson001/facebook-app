package com.facebook.multirow.api;

/* compiled from: native_url_interstitial */
public interface MultiRowGroupPartDefinition<Props, State, Environment extends AnyEnvironment> extends MultiRowPartWithIsNeeded<Props, Environment> {
    State mo2535a(MultiRowSubParts<Environment> multiRowSubParts, Props props, Environment environment);

    void mo2537a(Props props, State state, Environment environment, RowViewData rowViewData);

    void mo2538b(Props props, State state, Environment environment, RowViewData rowViewData);
}
