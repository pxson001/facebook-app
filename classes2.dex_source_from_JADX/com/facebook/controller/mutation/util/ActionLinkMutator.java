package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryActionLink.Builder;
import com.facebook.graphql.model.mutator.GraphQLPageMutator;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: sampling_config_checksum */
public class ActionLinkMutator {
    private final ProfileMutator f6332a;

    public static ActionLinkMutator m10662b(InjectorLike injectorLike) {
        return new ActionLinkMutator(new ProfileMutator());
    }

    @Inject
    public ActionLinkMutator(ProfileMutator profileMutator) {
        this.f6332a = profileMutator;
    }

    public final GraphQLStoryActionLink m10663a(GraphQLStoryActionLink graphQLStoryActionLink) {
        Preconditions.checkArgument(-581184810 == graphQLStoryActionLink.m22901a().m22301g(), "Cannot toggle page like on a non-page_like action link.");
        GraphQLPage ab = graphQLStoryActionLink.ab();
        ab = GraphQLPageMutator.a(ab).a(!ab.m23463O()).a;
        Builder a = Builder.a(graphQLStoryActionLink);
        a.af = ab;
        return a.a();
    }
}
