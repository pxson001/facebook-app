package com.facebook.reaction.feed.pages;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.StoryPostFooterSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.components.PinnedPostHeaderComponentPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfileVideoCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfileGenericCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfilePictureOverlayCallToActionPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.feed.nodes.ReactionPagesFeedStoryNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: author_name */
public class ReactionPagesPinnedPostGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionPagesFeedStoryNode, Void, FeedEnvironment> {
    private static ReactionPagesPinnedPostGroupPartDefinition f19138m;
    private static final Object f19139n = new Object();
    private final TopLevelFooterPartSelector f19140a;
    private final BlingBarSelectorPartDefinition f19141b;
    private final StoryPostFooterSelectorPartDefinition f19142c;
    private final AttachmentsPartDefinition f19143d;
    private final SeeTranslationPartDefinition<FeedEnvironment> f19144e;
    private final TranslationOrContentSelectorPartDefinition f19145f;
    private final PagesPinnedPostHeaderPartDefinition f19146g;
    private final PinnedPostHeaderComponentPartDefinition f19147h;
    private final ExplanationSelectorPartDefinition f19148i;
    private final ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment> f19149j;
    private final CreateProfileVideoCallToActionPartDefinition<FeedEnvironment> f19150k;
    private final ProfileGenericCallToActionPartDefinition f19151l;

    private static ReactionPagesPinnedPostGroupPartDefinition m23172b(InjectorLike injectorLike) {
        return new ReactionPagesPinnedPostGroupPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), PagesPinnedPostHeaderPartDefinition.m23166a(injectorLike), PinnedPostHeaderComponentPartDefinition.a(injectorLike), TranslationOrContentSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), ProfilePictureOverlayCallToActionPartDefinition.a(injectorLike), CreateProfileVideoCallToActionPartDefinition.a(injectorLike), ProfileGenericCallToActionPartDefinition.a(injectorLike), StoryPostFooterSelectorPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike));
    }

    public final Object m23173a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps c = FeedProps.c(((ReactionPagesFeedStoryNode) obj).mo1116f());
        baseMultiRowSubParts.a(this.f19148i, c);
        SubPartsSelector.a(baseMultiRowSubParts, this.f19147h, c).a(this.f19146g, c);
        baseMultiRowSubParts.a(this.f19145f, c);
        baseMultiRowSubParts.a(this.f19144e, c);
        baseMultiRowSubParts.a(this.f19143d, c);
        baseMultiRowSubParts.a(this.f19149j, c);
        baseMultiRowSubParts.a(this.f19150k, c);
        baseMultiRowSubParts.a(this.f19151l, c);
        baseMultiRowSubParts.a(this.f19141b, c);
        baseMultiRowSubParts.a(this.f19140a, c);
        baseMultiRowSubParts.a(this.f19142c, c);
        return null;
    }

    public final boolean m23174a(Object obj) {
        return ((ReactionPagesFeedStoryNode) obj).f19133a;
    }

    @Inject
    public ReactionPagesPinnedPostGroupPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, PagesPinnedPostHeaderPartDefinition pagesPinnedPostHeaderPartDefinition, PinnedPostHeaderComponentPartDefinition pinnedPostHeaderComponentPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, CreateProfileVideoCallToActionPartDefinition createProfileVideoCallToActionPartDefinition, ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition, StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector) {
        this.f19140a = topLevelFooterPartSelector;
        this.f19141b = blingBarSelectorPartDefinition;
        this.f19142c = storyPostFooterSelectorPartDefinition;
        this.f19143d = attachmentsPartDefinition;
        this.f19144e = seeTranslationPartDefinition;
        this.f19145f = translationOrContentSelectorPartDefinition;
        this.f19146g = pagesPinnedPostHeaderPartDefinition;
        this.f19147h = pinnedPostHeaderComponentPartDefinition;
        this.f19148i = explanationSelectorPartDefinition;
        this.f19149j = profilePictureOverlayCallToActionPartDefinition;
        this.f19150k = createProfileVideoCallToActionPartDefinition;
        this.f19151l = profileGenericCallToActionPartDefinition;
    }

    public static ReactionPagesPinnedPostGroupPartDefinition m23171a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPagesPinnedPostGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19139n) {
                ReactionPagesPinnedPostGroupPartDefinition reactionPagesPinnedPostGroupPartDefinition;
                if (a2 != null) {
                    reactionPagesPinnedPostGroupPartDefinition = (ReactionPagesPinnedPostGroupPartDefinition) a2.a(f19139n);
                } else {
                    reactionPagesPinnedPostGroupPartDefinition = f19138m;
                }
                if (reactionPagesPinnedPostGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23172b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19139n, b3);
                        } else {
                            f19138m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPagesPinnedPostGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
