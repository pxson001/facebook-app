package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: quick_experiment_pairs.txt */
public final class EventUpdateExtendedViewerWatchStatusInputData extends GraphQlMutationCallInput {

    /* compiled from: quick_experiment_pairs.txt */
    public final class Context extends GraphQlCallInput {

        /* compiled from: quick_experiment_pairs.txt */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4406a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4407b(String str) {
                a("mechanism", str);
                return this;
            }
        }

        public final Context m4408a(List<EventActionHistory> list) {
            a("event_action_history", list);
            return this;
        }
    }

    /* compiled from: quick_experiment_pairs.txt */
    public enum WatchStatus implements JsonSerializable {
        WATCHED("WATCHED"),
        UNWATCHED("UNWATCHED"),
        GOING("GOING"),
        DECLINED("DECLINED");
        
        protected final String serverValue;

        private WatchStatus(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }

    public final EventUpdateExtendedViewerWatchStatusInputData m4412b(String str) {
        a("event_id", str);
        return this;
    }

    public final EventUpdateExtendedViewerWatchStatusInputData m4410a(WatchStatus watchStatus) {
        a("watch_status", watchStatus);
        return this;
    }

    public final EventUpdateExtendedViewerWatchStatusInputData m4411a(List<String> list) {
        a("tracking", list);
        return this;
    }

    public final EventUpdateExtendedViewerWatchStatusInputData m4409a(Context context) {
        a("context", context);
        return this;
    }
}
