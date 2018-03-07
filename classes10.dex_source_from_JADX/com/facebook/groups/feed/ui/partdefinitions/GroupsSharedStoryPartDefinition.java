package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.FeedAttachedStoryPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: ThreadListLoader */
public class GroupsSharedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsSharedStoryPartDefinition f22507i;
    private static final Object f22508j = new Object();
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f22509a;
    private final FeedCommentsPartDefinition<FeedEnvironment> f22510b;
    private final TopLevelFooterPartSelector f22511c;
    private final GroupsBlingBarSelectorPartDefinition f22512d;
    private final FeedAttachedStoryPartDefinition f22513e;
    private final AttachmentsPartDefinition f22514f;
    private final ContentTextPartDefinition f22515g;
    private final GroupsHeaderPartDefinition f22516h;

    private static GroupsSharedStoryPartDefinition m23556b(InjectorLike injectorLike) {
        return new GroupsSharedStoryPartDefinition(GroupsHeaderPartDefinition.m23529a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), FeedAttachedStoryPartDefinition.a(injectorLike), GroupsBlingBarSelectorPartDefinition.m23520a(injectorLike), TopLevelFooterPartSelector.a(injectorLike), FeedCommentsPartDefinition.a(injectorLike), InlineCommentComposerPartDefinition.a(injectorLike));
    }

    public final Object m23557a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f22516h, feedProps);
        baseMultiRowSubParts.a(this.f22515g, feedProps);
        baseMultiRowSubParts.a(this.f22514f, feedProps);
        baseMultiRowSubParts.a(this.f22513e, feedProps);
        baseMultiRowSubParts.a(this.f22512d, feedProps);
        baseMultiRowSubParts.a(this.f22511c, feedProps);
        baseMultiRowSubParts.a(this.f22510b, feedProps);
        baseMultiRowSubParts.a(this.f22509a, feedProps);
        return null;
    }

    public final boolean m23558a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return graphQLStory.L() != null && graphQLStory.aD() == 0;
    }

    @Inject
    public GroupsSharedStoryPartDefinition(GroupsHeaderPartDefinition groupsHeaderPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, GroupsBlingBarSelectorPartDefinition groupsBlingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition) {
        this.f22509a = inlineCommentComposerPartDefinition;
        this.f22510b = feedCommentsPartDefinition;
        this.f22511c = topLevelFooterPartSelector;
        this.f22512d = groupsBlingBarSelectorPartDefinition;
        this.f22513e = feedAttachedStoryPartDefinition;
        this.f22514f = attachmentsPartDefinition;
        this.f22515g = contentTextPartDefinition;
        this.f22516h = groupsHeaderPartDefinition;
    }

    public static GroupsSharedStoryPartDefinition m23555a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsSharedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22508j) {
                GroupsSharedStoryPartDefinition groupsSharedStoryPartDefinition;
                if (a2 != null) {
                    groupsSharedStoryPartDefinition = (GroupsSharedStoryPartDefinition) a2.a(f22508j);
                } else {
                    groupsSharedStoryPartDefinition = f22507i;
                }
                if (groupsSharedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23556b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22508j, b3);
                        } else {
                            f22507i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsSharedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
