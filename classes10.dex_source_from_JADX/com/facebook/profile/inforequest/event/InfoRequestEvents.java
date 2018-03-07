package com.facebook.profile.inforequest.event;

import android.os.ParcelUuid;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;

/* compiled from: loading_time */
public abstract class InfoRequestEvents implements FbEvent {

    /* compiled from: loading_time */
    public class InfoRequestSentNavigationEvent extends InfoRequestEvent {
        public InfoRequestSentNavigationEvent(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }
    }

    /* compiled from: loading_time */
    public abstract class InfoRequestSentNavigationEventSubscriber extends InfoRequestEventSubscriber<InfoRequestSentNavigationEvent> {
        public InfoRequestSentNavigationEventSubscriber(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }

        public final Class<InfoRequestSentNavigationEvent> m8479a() {
            return InfoRequestSentNavigationEvent.class;
        }
    }

    /* compiled from: loading_time */
    public class SendInfoRequestEvent extends InfoRequestEvent {
        public GraphQLInfoRequestFieldType f8571b;

        public SendInfoRequestEvent(ParcelUuid parcelUuid, GraphQLInfoRequestFieldType graphQLInfoRequestFieldType) {
            super(parcelUuid);
            this.f8571b = graphQLInfoRequestFieldType;
        }
    }

    /* compiled from: loading_time */
    public abstract class SendInfoRequestEventSubscriber extends InfoRequestEventSubscriber<SendInfoRequestEvent> {
        public SendInfoRequestEventSubscriber(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }

        public final Class<SendInfoRequestEvent> m8480a() {
            return SendInfoRequestEvent.class;
        }
    }
}
