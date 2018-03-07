package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.FeedAttachedStoryPartDefinition;
import com.facebook.feed.rows.sections.SubStoriesHScrollPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.rows.partdefinitions.ApprovalBarPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ThreadListFragment_no_listener */
public class ModerationGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ModerationGroupPartDefinition f22521g;
    private static final Object f22522h = new Object();
    private final ApprovalBarPartDefinition f22523a;
    private final SubStoriesHScrollPartDefinition f22524b;
    private final FeedAttachedStoryPartDefinition f22525c;
    private final AttachmentsPartDefinition f22526d;
    private final ContentTextPartDefinition f22527e;
    private final GroupsHeaderPartDefinition f22528f;

    private static ModerationGroupPartDefinition m23564b(InjectorLike injectorLike) {
        return new ModerationGroupPartDefinition(GroupsHeaderPartDefinition.m23529a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), FeedAttachedStoryPartDefinition.a(injectorLike), SubStoriesHScrollPartDefinition.a(injectorLike), ApprovalBarPartDefinition.a(injectorLike));
    }

    public final Object m23565a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f22528f, feedProps);
        baseMultiRowSubParts.a(this.f22527e, feedProps);
        baseMultiRowSubParts.a(this.f22526d, feedProps);
        baseMultiRowSubParts.a(this.f22525c, feedProps);
        baseMultiRowSubParts.a(this.f22524b, feedProps);
        baseMultiRowSubParts.a(this.f22523a, feedProps);
        return null;
    }

    @Inject
    public ModerationGroupPartDefinition(GroupsHeaderPartDefinition groupsHeaderPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, SubStoriesHScrollPartDefinition subStoriesHScrollPartDefinition, ApprovalBarPartDefinition approvalBarPartDefinition) {
        this.f22523a = approvalBarPartDefinition;
        this.f22524b = subStoriesHScrollPartDefinition;
        this.f22525c = feedAttachedStoryPartDefinition;
        this.f22526d = attachmentsPartDefinition;
        this.f22527e = contentTextPartDefinition;
        this.f22528f = groupsHeaderPartDefinition;
    }

    public static ModerationGroupPartDefinition m23563a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ModerationGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22522h) {
                ModerationGroupPartDefinition moderationGroupPartDefinition;
                if (a2 != null) {
                    moderationGroupPartDefinition = (ModerationGroupPartDefinition) a2.a(f22522h);
                } else {
                    moderationGroupPartDefinition = f22521g;
                }
                if (moderationGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23564b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22522h, b3);
                        } else {
                            f22521g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = moderationGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23566a(Object obj) {
        return true;
    }
}
