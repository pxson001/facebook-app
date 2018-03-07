package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.graphql.threads.CommerceAgentMutationsModels.AgentThreadStartMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_download_cancelled */
public final class CommerceAgentMutations {

    /* compiled from: video_download_cancelled */
    public class AgentThreadStartMutationString extends TypedGraphQLMutationString<AgentThreadStartMutationModel> {
        public AgentThreadStartMutationString() {
            super(AgentThreadStartMutationModel.class, false, "AgentThreadStartMutation", "fe49e41caaf17589f8c18e8698bbe441", "agent_thread_start", "0", "10154204803946729", RegularImmutableSet.a);
        }

        public final String m955a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
