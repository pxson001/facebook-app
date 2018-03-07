package com.facebook.search.quickpromotion;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.UserSearchAwarenessSuggestionSubscribeInputData;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.search.protocol.awareness.C0774x92053e33;
import com.facebook.search.protocol.awareness.SearchAwareness;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.SearchAwarenessRootSuggestionFieldsFragmentModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interstitial_ids */
public class SearchAwarenessSuggestionUnitSubscriber {
    public static final Class<?> f19653a = SearchAwarenessSuggestionUnitSubscriber.class;
    public final GraphQLSubscriptionConnector f19654b;
    public GraphQLSubscriptionHandle f19655c;
    public SearchAwarenessController f19656d;

    /* compiled from: interstitial_ids */
    class SearchAwarenessSubscriptionFutureCallback implements FutureCallback<C0774x92053e33> {
        final /* synthetic */ SearchAwarenessSuggestionUnitSubscriber f19659a;

        public SearchAwarenessSubscriptionFutureCallback(SearchAwarenessSuggestionUnitSubscriber searchAwarenessSuggestionUnitSubscriber) {
            this.f19659a = searchAwarenessSuggestionUnitSubscriber;
        }

        public void onSuccess(@Nullable Object obj) {
            C0774x92053e33 c0774x92053e33 = (C0774x92053e33) obj;
            if (c0774x92053e33 != null && c0774x92053e33.m27390a() != null) {
                SearchAwarenessRootSuggestionFieldsFragmentModel a = c0774x92053e33.m27390a();
                if (this.f19659a.f19656d.m8755a(a)) {
                    this.f19659a.f19656d.m8753a(a, true);
                    switch (1.a[a.jF_().ordinal()]) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            if (this.f19659a.f19656d.m8754a(a.jF_())) {
                                this.f19659a.f19656d.m8756b(a.jF_());
                                return;
                            }
                            return;
                        default:
                            BLog.b(SearchAwarenessSuggestionUnitSubscriber.f19653a, "Unsupported suggestion template");
                            return;
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(SearchAwarenessSuggestionUnitSubscriber.f19653a, th.toString());
        }
    }

    @Inject
    public SearchAwarenessSuggestionUnitSubscriber(GraphQLSubscriptionConnector graphQLSubscriptionConnector) {
        this.f19654b = graphQLSubscriptionConnector;
    }

    public final void m27384a() {
        GraphQlCallInput userSearchAwarenessSuggestionSubscribeInputData = new UserSearchAwarenessSuggestionSubscribeInputData();
        GraphQlQueryString c = SearchAwareness.m27386c();
        c.m11310a("input", userSearchAwarenessSuggestionSubscribeInputData);
        try {
            this.f19655c = this.f19654b.m9386a(c, new SearchAwarenessSubscriptionFutureCallback(this));
        } catch (GraphQLSubscriptionConnectorException e) {
            BLog.b(f19653a, "Unable to subscribe to search awareness suggestions.", e);
        }
    }
}
