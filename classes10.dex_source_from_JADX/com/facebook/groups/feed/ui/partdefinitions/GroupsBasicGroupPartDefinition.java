package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.SubStoriesHScrollPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.treehousepromotcalltoaction.TreehousePromotCallToActionPartDefinition;
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
/* compiled from: ThreadViewFragment_ThreadSettings_NoUser */
public class GroupsBasicGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsBasicGroupPartDefinition f22437l;
    private static final Object f22438m = new Object();
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f22439a;
    private final FeedCommentsPartDefinition<FeedEnvironment> f22440b;
    private final TopLevelFooterPartSelector f22441c;
    private final GroupsBlingBarSelectorPartDefinition f22442d;
    private final SubStoriesHScrollPartDefinition f22443e;
    private final AttachmentsPartDefinition f22444f;
    private final ContentTextPartDefinition f22445g;
    private final StickerRootPartDefinition<FeedEnvironment> f22446h;
    private final GroupsHeaderPartDefinition f22447i;
    private final TreehousePromotCallToActionPartDefinition f22448j;
    private final GroupsAboveHeaderPartDefinition f22449k;

    private static GroupsBasicGroupPartDefinition m23517b(InjectorLike injectorLike) {
        return new GroupsBasicGroupPartDefinition(GroupsAboveHeaderPartDefinition.m23509a(injectorLike), GroupsHeaderPartDefinition.m23529a(injectorLike), StickerRootPartDefinition.a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), SubStoriesHScrollPartDefinition.a(injectorLike), GroupsBlingBarSelectorPartDefinition.m23520a(injectorLike), TopLevelFooterPartSelector.a(injectorLike), FeedCommentsPartDefinition.a(injectorLike), InlineCommentComposerPartDefinition.a(injectorLike), TreehousePromotCallToActionPartDefinition.a(injectorLike));
    }

    public final Object m23518a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f22449k, feedProps);
        baseMultiRowSubParts.a(this.f22447i, feedProps);
        baseMultiRowSubParts.a(this.f22446h, feedProps);
        baseMultiRowSubParts.a(this.f22445g, feedProps);
        baseMultiRowSubParts.a(this.f22444f, feedProps);
        baseMultiRowSubParts.a(this.f22448j, feedProps);
        baseMultiRowSubParts.a(this.f22443e, feedProps);
        baseMultiRowSubParts.a(this.f22442d, feedProps);
        baseMultiRowSubParts.a(this.f22441c, feedProps);
        baseMultiRowSubParts.a(this.f22440b, feedProps);
        baseMultiRowSubParts.a(this.f22439a, feedProps);
        return null;
    }

    @Inject
    public GroupsBasicGroupPartDefinition(GroupsAboveHeaderPartDefinition groupsAboveHeaderPartDefinition, GroupsHeaderPartDefinition groupsHeaderPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, SubStoriesHScrollPartDefinition subStoriesHScrollPartDefinition, GroupsBlingBarSelectorPartDefinition groupsBlingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, TreehousePromotCallToActionPartDefinition treehousePromotCallToActionPartDefinition) {
        this.f22439a = inlineCommentComposerPartDefinition;
        this.f22440b = feedCommentsPartDefinition;
        this.f22441c = topLevelFooterPartSelector;
        this.f22442d = groupsBlingBarSelectorPartDefinition;
        this.f22443e = subStoriesHScrollPartDefinition;
        this.f22444f = attachmentsPartDefinition;
        this.f22445g = contentTextPartDefinition;
        this.f22446h = stickerRootPartDefinition;
        this.f22449k = groupsAboveHeaderPartDefinition;
        this.f22447i = groupsHeaderPartDefinition;
        this.f22448j = treehousePromotCallToActionPartDefinition;
    }

    public static GroupsBasicGroupPartDefinition m23516a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsBasicGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22438m) {
                GroupsBasicGroupPartDefinition groupsBasicGroupPartDefinition;
                if (a2 != null) {
                    groupsBasicGroupPartDefinition = (GroupsBasicGroupPartDefinition) a2.a(f22438m);
                } else {
                    groupsBasicGroupPartDefinition = f22437l;
                }
                if (groupsBasicGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23517b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22438m, b3);
                        } else {
                            f22437l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsBasicGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23519a(Object obj) {
        return true;
    }
}
