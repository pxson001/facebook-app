package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AttachmentCallToActionPartDefinition;
import com.facebook.feed.rows.sections.AttributionPartDefinition;
import com.facebook.feed.rows.sections.SubStoriesHScrollPartDefinition;
import com.facebook.feed.rows.sections.TrendingPartDefinition;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.attachments.videos.VideoViewCountPartDefinition;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.creativeediting.FrameCallToActionPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.momentscalltoaction.MomentsCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfilePictureCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfileVideoCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfileGenericCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfilePictureOverlayCallToActionPartDefinition;
import com.facebook.feedplugins.treehousepromotcalltoaction.TreehousePromotCallToActionPartDefinition;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.permalink.rows.SeenByPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_sticker */
public class PermalinkBasicGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkBasicGroupPartDefinition f19873w;
    private static final Object f19874x = new Object();
    private final PermalinkFooterGroupPartSelector f19875a;
    private final SeenByPartDefinition f19876b;
    private final SubStoriesHScrollPartDefinition f19877c;
    private final VideoViewCountPartDefinition f19878d;
    private final PermalinkProfilePhotoPromptPartDefinition f19879e;
    private final AttachmentsPartDefinition f19880f;
    private final AttachmentCallToActionPartDefinition f19881g;
    private final MinutiaeAttachmentGroupPartDefinition f19882h;
    private final ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment> f19883i;
    private final CreateProfilePictureCallToActionPartDefinition<FeedEnvironment> f19884j;
    private final CreateProfileVideoCallToActionPartDefinition<FeedEnvironment> f19885k;
    private final ProfileGenericCallToActionPartDefinition f19886l;
    private final MomentsCallToActionPartDefinition<FeedEnvironment> f19887m;
    private final SeeTranslationPartDefinition f19888n;
    private final PermalinkTextSelectorPartDefinition f19889o;
    private final StickerRootPartDefinition<FeedEnvironment> f19890p;
    private final DefaultHeaderSelectorPartDefinition f19891q;
    private final ExplanationSelectorPartDefinition f19892r;
    private final TrendingPartDefinition f19893s;
    private final AttributionPartDefinition f19894t;
    private final TreehousePromotCallToActionPartDefinition f19895u;
    private final FrameCallToActionPartDefinition<FeedEnvironment> f19896v;

    private static PermalinkBasicGroupPartDefinition m23112b(InjectorLike injectorLike) {
        return new PermalinkBasicGroupPartDefinition(AttachmentCallToActionPartDefinition.a(injectorLike), TrendingPartDefinition.a(injectorLike), ExplanationSelectorPartDefinition.a(injectorLike), DefaultHeaderSelectorPartDefinition.a(injectorLike), StickerRootPartDefinition.a(injectorLike), PermalinkTextSelectorPartDefinition.m23182a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), MinutiaeAttachmentGroupPartDefinition.a(injectorLike), ProfilePictureOverlayCallToActionPartDefinition.a(injectorLike), CreateProfilePictureCallToActionPartDefinition.a(injectorLike), CreateProfileVideoCallToActionPartDefinition.a(injectorLike), ProfileGenericCallToActionPartDefinition.a(injectorLike), MomentsCallToActionPartDefinition.m25786a(injectorLike), PermalinkProfilePhotoPromptPartDefinition.m23128a(injectorLike), VideoViewCountPartDefinition.m23983a(injectorLike), SubStoriesHScrollPartDefinition.a(injectorLike), SeenByPartDefinition.a(injectorLike), AttributionPartDefinition.m23480a(injectorLike), PermalinkFooterGroupPartSelector.m23119a(injectorLike), TreehousePromotCallToActionPartDefinition.m25979a(injectorLike), FrameCallToActionPartDefinition.a(injectorLike));
    }

    public final Object m23113a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean as;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        baseMultiRowSubParts.a(this.f19894t, feedProps);
        baseMultiRowSubParts.a(this.f19893s, feedProps);
        baseMultiRowSubParts.a(this.f19892r, feedProps);
        baseMultiRowSubParts.a(this.f19891q, feedProps);
        baseMultiRowSubParts.a(this.f19890p, feedProps);
        baseMultiRowSubParts.a(this.f19882h, feedProps);
        baseMultiRowSubParts.a(this.f19889o, feedProps);
        baseMultiRowSubParts.a(this.f19888n, feedProps);
        baseMultiRowSubParts.a(this.f19880f, feedProps);
        baseMultiRowSubParts.a(this.f19881g, feedProps);
        baseMultiRowSubParts.a(this.f19883i, feedProps);
        baseMultiRowSubParts.a(this.f19884j, feedProps);
        baseMultiRowSubParts.a(this.f19885k, feedProps);
        baseMultiRowSubParts.a(this.f19886l, feedProps);
        if (MomentsCallToActionPartDefinition.m25789c(graphQLStory)) {
            as = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory)).as();
        } else {
            as = false;
        }
        if (as) {
            baseMultiRowSubParts.a(this.f19887m, feedProps);
        }
        baseMultiRowSubParts.a(this.f19895u, feedProps);
        baseMultiRowSubParts.a(this.f19896v, feedProps);
        baseMultiRowSubParts.a(this.f19879e, feedProps);
        baseMultiRowSubParts.a(this.f19878d, feedProps);
        baseMultiRowSubParts.a(this.f19877c, feedProps);
        baseMultiRowSubParts.a(this.f19875a, feedProps);
        baseMultiRowSubParts.a(this.f19876b, feedProps);
        return null;
    }

    public static PermalinkBasicGroupPartDefinition m23111a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkBasicGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19874x) {
                PermalinkBasicGroupPartDefinition permalinkBasicGroupPartDefinition;
                if (a2 != null) {
                    permalinkBasicGroupPartDefinition = (PermalinkBasicGroupPartDefinition) a2.a(f19874x);
                } else {
                    permalinkBasicGroupPartDefinition = f19873w;
                }
                if (permalinkBasicGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23112b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19874x, b3);
                        } else {
                            f19873w = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkBasicGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PermalinkBasicGroupPartDefinition(AttachmentCallToActionPartDefinition attachmentCallToActionPartDefinition, TrendingPartDefinition trendingPartDefinition, ExplanationSelectorPartDefinition explanationSelectorPartDefinition, DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, PermalinkTextSelectorPartDefinition permalinkTextSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, MinutiaeAttachmentGroupPartDefinition minutiaeAttachmentGroupPartDefinition, ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, CreateProfilePictureCallToActionPartDefinition createProfilePictureCallToActionPartDefinition, CreateProfileVideoCallToActionPartDefinition createProfileVideoCallToActionPartDefinition, ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition, MomentsCallToActionPartDefinition momentsCallToActionPartDefinition, PermalinkProfilePhotoPromptPartDefinition permalinkProfilePhotoPromptPartDefinition, VideoViewCountPartDefinition videoViewCountPartDefinition, SubStoriesHScrollPartDefinition subStoriesHScrollPartDefinition, SeenByPartDefinition seenByPartDefinition, AttributionPartDefinition attributionPartDefinition, PermalinkFooterGroupPartSelector permalinkFooterGroupPartSelector, TreehousePromotCallToActionPartDefinition treehousePromotCallToActionPartDefinition, FrameCallToActionPartDefinition frameCallToActionPartDefinition) {
        this.f19881g = attachmentCallToActionPartDefinition;
        this.f19875a = permalinkFooterGroupPartSelector;
        this.f19876b = seenByPartDefinition;
        this.f19877c = subStoriesHScrollPartDefinition;
        this.f19878d = videoViewCountPartDefinition;
        this.f19879e = permalinkProfilePhotoPromptPartDefinition;
        this.f19880f = attachmentsPartDefinition;
        this.f19882h = minutiaeAttachmentGroupPartDefinition;
        this.f19883i = profilePictureOverlayCallToActionPartDefinition;
        this.f19884j = createProfilePictureCallToActionPartDefinition;
        this.f19885k = createProfileVideoCallToActionPartDefinition;
        this.f19886l = profileGenericCallToActionPartDefinition;
        this.f19887m = momentsCallToActionPartDefinition;
        this.f19888n = seeTranslationPartDefinition;
        this.f19889o = permalinkTextSelectorPartDefinition;
        this.f19890p = stickerRootPartDefinition;
        this.f19891q = defaultHeaderSelectorPartDefinition;
        this.f19892r = explanationSelectorPartDefinition;
        this.f19893s = trendingPartDefinition;
        this.f19894t = attributionPartDefinition;
        this.f19895u = treehousePromotCallToActionPartDefinition;
        this.f19896v = frameCallToActionPartDefinition;
    }

    public final boolean m23114a(Object obj) {
        return true;
    }
}
