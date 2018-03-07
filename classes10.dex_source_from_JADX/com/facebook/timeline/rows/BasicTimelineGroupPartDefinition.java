package com.facebook.timeline.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AttributionPartDefinition;
import com.facebook.feed.rows.sections.StoryPostFooterSelectorPartDefinition;
import com.facebook.feed.rows.sections.TimelineStoryTextSelectorPartDefinition;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.creativeediting.FrameCallToActionPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfilePictureCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfileVideoCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfileGenericCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfilePictureOverlayCallToActionPartDefinition;
import com.facebook.feedplugins.profile.introcard.favphotos.ViewAllFavPhotosPartDefinition;
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
/* compiled from: extras_event_action_mechanism */
public class BasicTimelineGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static BasicTimelineGroupPartDefinition f12584t;
    private static final Object f12585u = new Object();
    private final TopLevelFooterPartSelector f12586a;
    private final BlingBarSelectorPartDefinition f12587b;
    private final StoryPostFooterSelectorPartDefinition f12588c;
    private final ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment> f12589d;
    private final CreateProfilePictureCallToActionPartDefinition<FeedEnvironment> f12590e;
    private final CreateProfileVideoCallToActionPartDefinition<FeedEnvironment> f12591f;
    private final AttachmentsPartDefinition f12592g;
    private final MinutiaeAttachmentGroupPartDefinition f12593h;
    private final SeeTranslationPartDefinition<FeedEnvironment> f12594i;
    private final TimelineStoryTextSelectorPartDefinition f12595j;
    private final StickerRootPartDefinition<FeedEnvironment> f12596k;
    private final TimelineHeaderSelectorPartDefinition f12597l;
    private final ExplanationSelectorPartDefinition f12598m;
    private final AttributionPartDefinition f12599n;
    private final FeedCommentsPartDefinition<FeedEnvironment> f12600o;
    private final ViewAllFavPhotosPartDefinition f12601p;
    private final ProfileGenericCallToActionPartDefinition f12602q;
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f12603r;
    private final FrameCallToActionPartDefinition<FeedEnvironment> f12604s;

    private static BasicTimelineGroupPartDefinition m12565b(InjectorLike injectorLike) {
        return new BasicTimelineGroupPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), TimelineHeaderSelectorPartDefinition.m12573a(injectorLike), StickerRootPartDefinition.a(injectorLike), TimelineStoryTextSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), MinutiaeAttachmentGroupPartDefinition.a(injectorLike), ProfilePictureOverlayCallToActionPartDefinition.a(injectorLike), CreateProfilePictureCallToActionPartDefinition.a(injectorLike), CreateProfileVideoCallToActionPartDefinition.a(injectorLike), StoryPostFooterSelectorPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike), AttributionPartDefinition.a(injectorLike), FeedCommentsPartDefinition.a(injectorLike), ViewAllFavPhotosPartDefinition.a(injectorLike), ProfileGenericCallToActionPartDefinition.a(injectorLike), FrameCallToActionPartDefinition.a(injectorLike), InlineCommentComposerPartDefinition.a(injectorLike));
    }

    public final Object m12566a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12599n, feedProps);
        baseMultiRowSubParts.a(this.f12598m, feedProps);
        baseMultiRowSubParts.a(this.f12597l, feedProps);
        baseMultiRowSubParts.a(this.f12596k, feedProps);
        baseMultiRowSubParts.a(this.f12593h, feedProps);
        baseMultiRowSubParts.a(this.f12595j, feedProps);
        baseMultiRowSubParts.a(this.f12594i, feedProps);
        baseMultiRowSubParts.a(this.f12592g, feedProps);
        baseMultiRowSubParts.a(this.f12589d, feedProps);
        baseMultiRowSubParts.a(this.f12590e, feedProps);
        baseMultiRowSubParts.a(this.f12591f, feedProps);
        baseMultiRowSubParts.a(this.f12602q, feedProps);
        baseMultiRowSubParts.a(this.f12604s, feedProps);
        baseMultiRowSubParts.a(this.f12587b, feedProps);
        baseMultiRowSubParts.a(this.f12586a, feedProps);
        baseMultiRowSubParts.a(this.f12588c, feedProps);
        baseMultiRowSubParts.a(this.f12600o, feedProps);
        baseMultiRowSubParts.a(this.f12603r, feedProps);
        baseMultiRowSubParts.a(this.f12601p, feedProps);
        return null;
    }

    public static BasicTimelineGroupPartDefinition m12564a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicTimelineGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12585u) {
                BasicTimelineGroupPartDefinition basicTimelineGroupPartDefinition;
                if (a2 != null) {
                    basicTimelineGroupPartDefinition = (BasicTimelineGroupPartDefinition) a2.a(f12585u);
                } else {
                    basicTimelineGroupPartDefinition = f12584t;
                }
                if (basicTimelineGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12565b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12585u, b3);
                        } else {
                            f12584t = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicTimelineGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BasicTimelineGroupPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, TimelineHeaderSelectorPartDefinition timelineHeaderSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, TimelineStoryTextSelectorPartDefinition timelineStoryTextSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, MinutiaeAttachmentGroupPartDefinition minutiaeAttachmentGroupPartDefinition, ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, CreateProfilePictureCallToActionPartDefinition createProfilePictureCallToActionPartDefinition, CreateProfileVideoCallToActionPartDefinition createProfileVideoCallToActionPartDefinition, StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, AttributionPartDefinition attributionPartDefinition, FeedCommentsPartDefinition feedCommentsPartDefinition, ViewAllFavPhotosPartDefinition viewAllFavPhotosPartDefinition, ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition, FrameCallToActionPartDefinition frameCallToActionPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition) {
        this.f12586a = topLevelFooterPartSelector;
        this.f12587b = blingBarSelectorPartDefinition;
        this.f12588c = storyPostFooterSelectorPartDefinition;
        this.f12589d = profilePictureOverlayCallToActionPartDefinition;
        this.f12590e = createProfilePictureCallToActionPartDefinition;
        this.f12591f = createProfileVideoCallToActionPartDefinition;
        this.f12592g = attachmentsPartDefinition;
        this.f12593h = minutiaeAttachmentGroupPartDefinition;
        this.f12594i = seeTranslationPartDefinition;
        this.f12595j = timelineStoryTextSelectorPartDefinition;
        this.f12596k = stickerRootPartDefinition;
        this.f12597l = timelineHeaderSelectorPartDefinition;
        this.f12598m = explanationSelectorPartDefinition;
        this.f12599n = attributionPartDefinition;
        this.f12600o = feedCommentsPartDefinition;
        this.f12601p = viewAllFavPhotosPartDefinition;
        this.f12602q = profileGenericCallToActionPartDefinition;
        this.f12604s = frameCallToActionPartDefinition;
        this.f12603r = inlineCommentComposerPartDefinition;
    }

    public final boolean m12567a(Object obj) {
        return true;
    }
}
