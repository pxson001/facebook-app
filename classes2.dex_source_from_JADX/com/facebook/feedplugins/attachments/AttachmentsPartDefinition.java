package com.facebook.feedplugins.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.attachments.AttachmentStyleMap;
import com.facebook.feed.rows.attachments.AttachmentStyleMapImpl;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.text.ObjectionableContentMessagePartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: initLoader in  */
public class AttachmentsPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static AttachmentsPartDefinition f20079d;
    private static final Object f20080e = new Object();
    public final GraphQLStoryUtil f20081a;
    public final AttachmentStyleMap f20082b;
    private final ObjectionableContentMessagePartDefinition f20083c;

    private static AttachmentsPartDefinition m27797b(InjectorLike injectorLike) {
        return new AttachmentsPartDefinition(GraphQLStoryUtil.m9565a(injectorLike), AttachmentStyleMapImpl.m27800a(injectorLike), ObjectionableContentMessagePartDefinition.m27805a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        List<GraphQLStoryAttachment> x = ((GraphQLStory) feedProps.f13444a).m22367x();
        for (GraphQLStoryAttachment graphQLStoryAttachment : x) {
            Object a = feedProps.m19803a(graphQLStoryAttachment);
            if (this.f20081a.m9601k(a)) {
                ImmutableList w = graphQLStoryAttachment.m23984w();
                for (int i = 0; i < w.size(); i++) {
                    MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) this.f20082b.mo3126a((GraphQLStoryAttachmentStyle) w.get(i));
                    if (multiRowPartWithIsNeeded != null && baseMultiRowSubParts.m19112a(multiRowPartWithIsNeeded, a)) {
                        break;
                    }
                }
            }
        }
        if (!x.isEmpty()) {
            baseMultiRowSubParts.m19112a(this.f20083c, feedProps.m19803a((Flattenable) x.get(0)));
        }
        return null;
    }

    public final boolean mo2536a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return !GraphQLStoryAttachmentUtil.m28049a(StoryAttachmentHelper.m28042o(graphQLStory), GraphQLStoryAttachmentStyle.MINUTIAE_UNIT) && StoryAttachmentHelper.m28029a(graphQLStory);
    }

    @Inject
    public AttachmentsPartDefinition(GraphQLStoryUtil graphQLStoryUtil, AttachmentStyleMap attachmentStyleMap, ObjectionableContentMessagePartDefinition objectionableContentMessagePartDefinition) {
        this.f20081a = graphQLStoryUtil;
        this.f20082b = attachmentStyleMap;
        this.f20083c = objectionableContentMessagePartDefinition;
    }

    public static AttachmentsPartDefinition m27796a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20080e) {
                AttachmentsPartDefinition attachmentsPartDefinition;
                if (a2 != null) {
                    attachmentsPartDefinition = (AttachmentsPartDefinition) a2.mo818a(f20080e);
                } else {
                    attachmentsPartDefinition = f20079d;
                }
                if (attachmentsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27797b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20080e, b3);
                        } else {
                            f20079d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
