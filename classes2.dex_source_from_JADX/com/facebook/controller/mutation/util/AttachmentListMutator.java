package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;

/* compiled from: samplernintegration */
public class AttachmentListMutator {
    private final ActionLinkListMutator f6333a;
    private final AttachmentTargetMutator f6334b;

    public static AttachmentListMutator m10672b(InjectorLike injectorLike) {
        return new AttachmentListMutator(ActionLinkListMutator.m10664a(injectorLike), AttachmentTargetMutator.m10674a(injectorLike));
    }

    @Inject
    public AttachmentListMutator(ActionLinkListMutator actionLinkListMutator, AttachmentTargetMutator attachmentTargetMutator) {
        this.f6333a = actionLinkListMutator;
        this.f6334b = attachmentTargetMutator;
    }

    public static ImmutableList<GraphQLStoryAttachment> m10671a(List<GraphQLStoryAttachment> list, GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(graphQLStoryAttachment);
        Builder builder = new Builder();
        for (Object obj : list) {
            Object obj2;
            if (obj2.equals(graphQLStoryAttachment)) {
                obj2 = graphQLStoryAttachment;
            }
            builder.m1069c(obj2);
        }
        return builder.m1068b();
    }

    public final ImmutableList<GraphQLStoryAttachment> m10673a(List<GraphQLStoryAttachment> list, GraphQLSavedState graphQLSavedState) {
        Builder builder = ImmutableList.builder();
        for (GraphQLStoryAttachment graphQLStoryAttachment : list) {
            GraphQLStoryAttachment.Builder a = GraphQLStoryAttachment.Builder.a(graphQLStoryAttachment);
            a.d = this.f6333a.m10668a(graphQLStoryAttachment.m23971j(), graphQLSavedState);
            a.r = m10673a(graphQLStoryAttachment.m23985x(), graphQLSavedState);
            builder.m1069c(a.a());
        }
        return builder.m1068b();
    }
}
