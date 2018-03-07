package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.FeedAttachedStoryPartDefinition;
import com.facebook.feed.rows.sections.offline.OfflineAnimationGroupPartDefinition;
import com.facebook.feed.rows.sections.offline.OfflineAnimationGroupPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.offline.OfflineAnimationGroupPartDefinition.Props;
import com.facebook.feed.rows.sections.offline.OfflineFooterSelector;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineFailedPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineFailedV2PartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineProgressPartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineProgressV2PartDefinition;
import com.facebook.feedplugins.offline.rows.OfflineRetryPartDefinition;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
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
/* compiled from: ThreadListLoader FETCH_THREAD_LIST */
public class GroupsOfflineGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsOfflineGroupPartDefinition f22486p;
    private static final Object f22487q = new Object();
    private final OfflineProgressPartDefinition<FeedEnvironment> f22488a;
    private final OfflineProgressV2PartDefinition<FeedEnvironment> f22489b;
    private final OfflineRetryPartDefinition f22490c;
    private final OfflineFailedPartDefinition f22491d;
    private final OfflineFailedV2PartDefinition f22492e;
    private final OfflineAnimationGroupPartDefinition<FeedEnvironment> f22493f;
    public final GroupsHeaderPartDefinition<FeedEnvironment> f22494g;
    public final ContentTextPartDefinition f22495h;
    public final AttachmentsPartDefinition f22496i;
    public final GroupsBlingBarSelectorPartDefinition f22497j;
    private final OfflineFooterSelector f22498k;
    public final FeedAttachedStoryPartDefinition f22499l;
    public final FeedCommentsPartDefinition<FeedEnvironment> f22500m;
    public final InlineCommentComposerPartDefinition<FeedEnvironment> f22501n;
    private final OptimisticStoryStateCache f22502o;

    /* compiled from: ThreadListLoader FETCH_THREAD_LIST */
    public class C32611 implements Callbacks<FeedEnvironment> {
        final /* synthetic */ GroupsOfflineGroupPartDefinition f22485a;

        public C32611(GroupsOfflineGroupPartDefinition groupsOfflineGroupPartDefinition) {
            this.f22485a = groupsOfflineGroupPartDefinition;
        }

        public final void m23546a(BaseMultiRowSubParts baseMultiRowSubParts, FeedProps feedProps, HasPersistentState hasPersistentState) {
            baseMultiRowSubParts.a(this.f22485a.f22494g, feedProps);
            baseMultiRowSubParts.a(this.f22485a.f22495h, feedProps);
            baseMultiRowSubParts.a(this.f22485a.f22496i, feedProps);
            baseMultiRowSubParts.a(this.f22485a.f22497j, feedProps);
            baseMultiRowSubParts.a(this.f22485a.f22499l, feedProps);
            baseMultiRowSubParts.a(this.f22485a.f22500m, feedProps);
            baseMultiRowSubParts.a(this.f22485a.f22501n, feedProps);
        }
    }

    private static GroupsOfflineGroupPartDefinition m23548b(InjectorLike injectorLike) {
        return new GroupsOfflineGroupPartDefinition(OfflineAnimationGroupPartDefinition.a(injectorLike), OfflineProgressPartDefinition.a(injectorLike), OfflineProgressV2PartDefinition.a(injectorLike), OfflineRetryPartDefinition.a(injectorLike), OfflineFailedPartDefinition.a(injectorLike), OfflineFailedV2PartDefinition.a(injectorLike), GroupsHeaderPartDefinition.m23529a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), GroupsBlingBarSelectorPartDefinition.m23520a(injectorLike), OfflineFooterSelector.a(injectorLike), FeedAttachedStoryPartDefinition.a(injectorLike), FeedCommentsPartDefinition.a(injectorLike), InlineCommentComposerPartDefinition.a(injectorLike), OptimisticStoryStateCache.a(injectorLike));
    }

    public final Object m23549a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f22489b, feedProps).a(this.f22488a, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f22490c, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f22492e, feedProps).a(this.f22491d, feedProps);
        baseMultiRowSubParts.a(this.f22493f, new Props(feedProps, new C32611(this)));
        baseMultiRowSubParts.a(this.f22498k, feedProps);
        return null;
    }

    public final boolean m23550a(Object obj) {
        GraphQLFeedOptimisticPublishState a = this.f22502o.a((GraphQLStory) ((FeedProps) obj).a);
        return (a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || a == GraphQLFeedOptimisticPublishState.DELETED) ? false : true;
    }

    public static GroupsOfflineGroupPartDefinition m23547a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsOfflineGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22487q) {
                GroupsOfflineGroupPartDefinition groupsOfflineGroupPartDefinition;
                if (a2 != null) {
                    groupsOfflineGroupPartDefinition = (GroupsOfflineGroupPartDefinition) a2.a(f22487q);
                } else {
                    groupsOfflineGroupPartDefinition = f22486p;
                }
                if (groupsOfflineGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23548b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22487q, b3);
                        } else {
                            f22486p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsOfflineGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsOfflineGroupPartDefinition(OfflineAnimationGroupPartDefinition offlineAnimationGroupPartDefinition, OfflineProgressPartDefinition offlineProgressPartDefinition, OfflineProgressV2PartDefinition offlineProgressV2PartDefinition, OfflineRetryPartDefinition offlineRetryPartDefinition, OfflineFailedPartDefinition offlineFailedPartDefinition, OfflineFailedV2PartDefinition offlineFailedV2PartDefinition, GroupsHeaderPartDefinition groupsHeaderPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, GroupsBlingBarSelectorPartDefinition groupsBlingBarSelectorPartDefinition, OfflineFooterSelector offlineFooterSelector, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f22493f = offlineAnimationGroupPartDefinition;
        this.f22494g = groupsHeaderPartDefinition;
        this.f22495h = contentTextPartDefinition;
        this.f22496i = attachmentsPartDefinition;
        this.f22497j = groupsBlingBarSelectorPartDefinition;
        this.f22499l = feedAttachedStoryPartDefinition;
        this.f22500m = feedCommentsPartDefinition;
        this.f22501n = inlineCommentComposerPartDefinition;
        this.f22498k = offlineFooterSelector;
        this.f22488a = offlineProgressPartDefinition;
        this.f22489b = offlineProgressV2PartDefinition;
        this.f22490c = offlineRetryPartDefinition;
        this.f22491d = offlineFailedPartDefinition;
        this.f22492e = offlineFailedV2PartDefinition;
        this.f22502o = optimisticStoryStateCache;
    }
}
