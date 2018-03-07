package com.facebook.adinterfaces.external.events;

import com.facebook.graphql.enums.GraphQLBoostedPostStatus;

/* compiled from: baseDeserializer */
public class AdInterfacesExternalEvents {

    /* compiled from: baseDeserializer */
    public class BoostedPostStatusChangedEvent extends AdInterfacesEvent {
        public String f8021a;
        public GraphQLBoostedPostStatus f8022b;

        public BoostedPostStatusChangedEvent(String str, GraphQLBoostedPostStatus graphQLBoostedPostStatus) {
            this.f8021a = str;
            this.f8022b = graphQLBoostedPostStatus;
        }
    }

    /* compiled from: baseDeserializer */
    public abstract class BoostedPostStatusChangedEventSubscriber extends AdInterfacesEventSubscriber<BoostedPostStatusChangedEvent> {
        public final Class<BoostedPostStatusChangedEvent> m14179a() {
            return BoostedPostStatusChangedEvent.class;
        }
    }
}
