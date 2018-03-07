package com.facebook.contacts.graphql;

import com.facebook.graphql.enums.GraphQLUserChatContextType;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/* compiled from: photo_ids */
public class ChatContextGraphQLHelper {
    public static final ImmutableSet<GraphQLUserChatContextType> f8143a;
    public static final ImmutableSet<GraphQLUserChatContextType> f8144b;
    private static final ImmutableSet<GraphQLUserChatContextType> f8145c = ImmutableSet.copyOf(GraphQLUserChatContextType.values());
    private static final ImmutableSet<GraphQLUserChatContextType> f8146d = ImmutableSet.of(GraphQLUserChatContextType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
    private static final ImmutableSet<GraphQLUserChatContextType> f8147e = ImmutableSet.of(GraphQLUserChatContextType.NEARBY, GraphQLUserChatContextType.TRAVELING, GraphQLUserChatContextType.NEIGHBOURHOOD);

    static {
        ImmutableSet copyOf = ImmutableSet.copyOf(Sets.c(f8145c, f8146d));
        f8143a = copyOf;
        f8144b = ImmutableSet.copyOf(Sets.c(copyOf, f8147e));
    }
}
