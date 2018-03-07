package com.facebook.graphql.executor;

import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: messenger_chat_heads_full_screen_toggle */
public interface GraphQLMutex {
    GraphQLMutex mo2714a(Set<String> set);

    GraphQLResult mo2715a(GraphQLResult graphQLResult);

    ImmutableSet<String> mo2716a();

    boolean mo2717a(GraphQLRequestLock graphQLRequestLock);

    GraphQLResult mo2718b(GraphQLResult graphQLResult);
}
