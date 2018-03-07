package com.facebook.pages.identity.timeline;

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
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: page_leadgen_info_update */
public class PageIdentityPinnedPostGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLStory, Void, FeedEnvironment> {
    private static PageIdentityPinnedPostGroupPartDefinition f4168m;
    private static final Object f4169n = new Object();
    private final TopLevelFooterPartSelector f4170a;
    private final BlingBarSelectorPartDefinition f4171b;
    private final StoryPostFooterSelectorPartDefinition f4172c;
    private final AttachmentsPartDefinition f4173d;
    private final SeeTranslationPartDefinition<FeedEnvironment> f4174e;
    private final TranslationOrContentSelectorPartDefinition f4175f;
    private final Lazy<PageIdentityPinnedPostHeaderPartDefinition<FeedEnvironment>> f4176g;
    private final Lazy<PinnedPostHeaderComponentPartDefinition<FeedEnvironment>> f4177h;
    private final ExplanationSelectorPartDefinition f4178i;
    private final ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment> f4179j;
    private final CreateProfileVideoCallToActionPartDefinition<FeedEnvironment> f4180k;
    private final ProfileGenericCallToActionPartDefinition f4181l;

    private static PageIdentityPinnedPostGroupPartDefinition m5151b(InjectorLike injectorLike) {
        return new PageIdentityPinnedPostGroupPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 9103), IdBasedLazy.a(injectorLike, 6036), TranslationOrContentSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), StoryPostFooterSelectorPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike), ProfilePictureOverlayCallToActionPartDefinition.a(injectorLike), CreateProfileVideoCallToActionPartDefinition.a(injectorLike), ProfileGenericCallToActionPartDefinition.a(injectorLike));
    }

    public final Object m5152a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps c = FeedProps.c((GraphQLStory) obj);
        baseMultiRowSubParts.a(this.f4178i, c);
        SubPartsSelector.a(baseMultiRowSubParts, this.f4177h, c).a(this.f4176g, c);
        baseMultiRowSubParts.a(this.f4175f, c);
        baseMultiRowSubParts.a(this.f4174e, c);
        baseMultiRowSubParts.a(this.f4173d, c);
        baseMultiRowSubParts.a(this.f4179j, c);
        baseMultiRowSubParts.a(this.f4180k, c);
        baseMultiRowSubParts.a(this.f4181l, c);
        baseMultiRowSubParts.a(this.f4171b, c);
        baseMultiRowSubParts.a(this.f4170a, c);
        baseMultiRowSubParts.a(this.f4172c, c);
        return null;
    }

    public static PageIdentityPinnedPostGroupPartDefinition m5150a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageIdentityPinnedPostGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4169n) {
                PageIdentityPinnedPostGroupPartDefinition pageIdentityPinnedPostGroupPartDefinition;
                if (a2 != null) {
                    pageIdentityPinnedPostGroupPartDefinition = (PageIdentityPinnedPostGroupPartDefinition) a2.a(f4169n);
                } else {
                    pageIdentityPinnedPostGroupPartDefinition = f4168m;
                }
                if (pageIdentityPinnedPostGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5151b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4169n, b3);
                        } else {
                            f4168m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageIdentityPinnedPostGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageIdentityPinnedPostGroupPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, Lazy<PageIdentityPinnedPostHeaderPartDefinition> lazy, Lazy<PinnedPostHeaderComponentPartDefinition> lazy2, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, CreateProfileVideoCallToActionPartDefinition createProfileVideoCallToActionPartDefinition, ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition) {
        this.f4170a = topLevelFooterPartSelector;
        this.f4171b = blingBarSelectorPartDefinition;
        this.f4172c = storyPostFooterSelectorPartDefinition;
        this.f4173d = attachmentsPartDefinition;
        this.f4174e = seeTranslationPartDefinition;
        this.f4175f = translationOrContentSelectorPartDefinition;
        this.f4176g = lazy;
        this.f4177h = lazy2;
        this.f4178i = explanationSelectorPartDefinition;
        this.f4179j = profilePictureOverlayCallToActionPartDefinition;
        this.f4180k = createProfileVideoCallToActionPartDefinition;
        this.f4181l = profileGenericCallToActionPartDefinition;
    }

    public final boolean m5153a(Object obj) {
        return true;
    }
}
