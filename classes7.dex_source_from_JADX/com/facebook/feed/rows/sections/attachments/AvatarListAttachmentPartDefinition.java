package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [FB-only] */
public class AvatarListAttachmentPartDefinition<V extends View & AngoraAttachment & AttachmentHasLargeImage> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static AvatarListAttachmentPartDefinition f20542b;
    private static final Object f20543c = new Object();
    private final AvatarAttachmentPartDefinition<FeedEnvironment, V> f20544a;

    private static AvatarListAttachmentPartDefinition m23601b(InjectorLike injectorLike) {
        return new AvatarListAttachmentPartDefinition(AvatarAttachmentPartDefinition.m23587a(injectorLike));
    }

    public final Object m23602a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        ImmutableList x = ((GraphQLStoryAttachment) feedProps.a).x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            baseMultiRowSubParts.a(this.f20544a, feedProps.b((GraphQLStoryAttachment) x.get(i)));
        }
        return null;
    }

    public final boolean m23603a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().isEmpty()) ? false : true;
    }

    @Inject
    public AvatarListAttachmentPartDefinition(AvatarAttachmentPartDefinition avatarAttachmentPartDefinition) {
        this.f20544a = avatarAttachmentPartDefinition;
    }

    public static AvatarListAttachmentPartDefinition m23600a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AvatarListAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20543c) {
                AvatarListAttachmentPartDefinition avatarListAttachmentPartDefinition;
                if (a2 != null) {
                    avatarListAttachmentPartDefinition = (AvatarListAttachmentPartDefinition) a2.a(f20543c);
                } else {
                    avatarListAttachmentPartDefinition = f20542b;
                }
                if (avatarListAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23601b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20543c, b3);
                        } else {
                            f20542b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = avatarListAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
