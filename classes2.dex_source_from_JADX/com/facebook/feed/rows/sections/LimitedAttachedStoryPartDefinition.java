package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.links.ActionLinkFooterPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.ThrowbackSharedStoryExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.ThrowbackSharedStoryHeaderExplanationPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfilePictureOverlayCallToActionPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchFwComponents */
public class LimitedAttachedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static LimitedAttachedStoryPartDefinition f24337k;
    private static final Object f24338l = new Object();
    private final AttachedStorySectionHelper f24339a;
    private final ThrowbackSharedStoryExplanationPartDefinition f24340b;
    private final ThrowbackSharedStoryHeaderExplanationPartDefinition f24341c;
    private final HeaderSelectorPartDefinition f24342d;
    private final StickerRootPartDefinition<FeedEnvironment> f24343e;
    private final TranslationOrContentSelectorPartDefinition f24344f;
    private final SeeTranslationPartDefinition f24345g;
    private final AttachmentsPartDefinition f24346h;
    private final ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment> f24347i;
    private final ActionLinkFooterPartDefinition f24348j;

    private static LimitedAttachedStoryPartDefinition m32660b(InjectorLike injectorLike) {
        return new LimitedAttachedStoryPartDefinition(ThrowbackSharedStoryHeaderExplanationPartDefinition.m32636a(injectorLike), ThrowbackSharedStoryExplanationPartDefinition.m32641a(injectorLike), HeaderSelectorPartDefinition.m27777a(injectorLike), StickerRootPartDefinition.m27781a(injectorLike), TranslationOrContentSelectorPartDefinition.m32663a(injectorLike), SeeTranslationPartDefinition.m32668a(injectorLike), AttachmentsPartDefinition.m27796a(injectorLike), ProfilePictureOverlayCallToActionPartDefinition.m32688a(injectorLike), ActionLinkFooterPartDefinition.m32693a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Object a = feedProps.m19803a(((GraphQLStory) feedProps.f13444a).m22326L());
        baseMultiRowSubParts.m19112a(this.f24341c, a);
        baseMultiRowSubParts.m19112a(this.f24340b, a);
        baseMultiRowSubParts.m19112a(this.f24342d, a);
        baseMultiRowSubParts.m19112a(this.f24343e, a);
        baseMultiRowSubParts.m19112a(this.f24344f, a);
        baseMultiRowSubParts.m19112a(this.f24345g, a);
        baseMultiRowSubParts.m19112a(this.f24346h, a);
        baseMultiRowSubParts.m19112a(this.f24347i, a);
        baseMultiRowSubParts.m19112a(this.f24348j, a);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return this.f24339a.m32700a((FeedProps) obj);
    }

    @Inject
    public LimitedAttachedStoryPartDefinition(ThrowbackSharedStoryHeaderExplanationPartDefinition throwbackSharedStoryHeaderExplanationPartDefinition, ThrowbackSharedStoryExplanationPartDefinition throwbackSharedStoryExplanationPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, ActionLinkFooterPartDefinition actionLinkFooterPartDefinition, GraphQLStoryUtil graphQLStoryUtil) {
        this.f24341c = throwbackSharedStoryHeaderExplanationPartDefinition;
        this.f24340b = throwbackSharedStoryExplanationPartDefinition;
        this.f24342d = headerSelectorPartDefinition;
        this.f24343e = stickerRootPartDefinition;
        this.f24344f = translationOrContentSelectorPartDefinition;
        this.f24345g = seeTranslationPartDefinition;
        this.f24346h = attachmentsPartDefinition;
        this.f24347i = profilePictureOverlayCallToActionPartDefinition;
        this.f24348j = actionLinkFooterPartDefinition;
        this.f24339a = new AttachedStorySectionHelper(graphQLStoryUtil);
    }

    public static LimitedAttachedStoryPartDefinition m32659a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LimitedAttachedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24338l) {
                LimitedAttachedStoryPartDefinition limitedAttachedStoryPartDefinition;
                if (a2 != null) {
                    limitedAttachedStoryPartDefinition = (LimitedAttachedStoryPartDefinition) a2.mo818a(f24338l);
                } else {
                    limitedAttachedStoryPartDefinition = f24337k;
                }
                if (limitedAttachedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32660b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24338l, b3);
                        } else {
                            f24337k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = limitedAttachedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
