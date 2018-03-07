package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodfrineds_picker_close */
public class ThrowbackPromotedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackPromotedStoryPartDefinition f12493i;
    private static final Object f12494j = new Object();
    private final AttachmentsPartDefinition f12495a;
    private final ThrowbackResharedPhotoAttachmentPartDefinition f12496b;
    private final ThrowbackResharedVideoAttachmentPartDefinition f12497c;
    private final ThrowbackPromotedStorySeeOriginalPartDefinitionProvider f12498d;
    private final SeeTranslationPartDefinition<FeedEnvironment> f12499e;
    private final TranslationOrContentSelectorPartDefinition f12500f;
    private final ThrowbackPromotedStoryHeaderPartDefinition f12501g;
    private final ThrowbackToEdgeStoryConverter f12502h;

    private static ThrowbackPromotedStoryPartDefinition m14386b(InjectorLike injectorLike) {
        return new ThrowbackPromotedStoryPartDefinition((ThrowbackPromotedStorySeeOriginalPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThrowbackPromotedStorySeeOriginalPartDefinitionProvider.class), ThrowbackPromotedStoryHeaderPartDefinition.m14380a(injectorLike), TranslationOrContentSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), ThrowbackResharedPhotoAttachmentPartDefinition.m14394a(injectorLike), ThrowbackResharedVideoAttachmentPartDefinition.m14399a(injectorLike), AttachmentsPartDefinition.a(injectorLike), ThrowbackToEdgeStoryConverter.m14417a(injectorLike));
    }

    public final Object m14387a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (graphQLGoodwillThrowbackPromotionFeedUnit.E() == null || graphQLGoodwillThrowbackPromotionFeedUnit.E().a() == null || graphQLGoodwillThrowbackPromotionFeedUnit.E().a().isEmpty()) {
            graphQLStory = null;
        } else {
            graphQLStory = (GraphQLStory) graphQLGoodwillThrowbackPromotionFeedUnit.E().a().get(0);
            PropertyHelper.a(graphQLStory, null);
        }
        Builder builder = new Builder();
        builder.o = graphQLGoodwillThrowbackPromotionFeedUnit.g();
        builder = builder;
        builder.ay = graphQLGoodwillThrowbackPromotionFeedUnit.I();
        builder = builder;
        builder.l = graphQLStory;
        Builder builder2 = builder;
        GraphQLTextWithEntities.Builder builder3 = new GraphQLTextWithEntities.Builder();
        builder3.i = Integer.toString(graphQLGoodwillThrowbackPromotionFeedUnit.L());
        builder2.am = builder3.a();
        graphQLStory = builder2.a();
        PropertyHelper.a(graphQLStory).m = true;
        GraphQLStory graphQLStory2 = graphQLStory;
        GraphQLStory L = graphQLStory2.L();
        FeedProps a = FeedProps.c(graphQLStory2).a(L);
        if (m14385a(graphQLGoodwillThrowbackPromotionFeedUnit)) {
            graphQLStory2 = L.L();
            Builder a2 = Builder.a(graphQLStory2);
            a2.d = graphQLGoodwillThrowbackPromotionFeedUnit.H();
            FeedProps a3 = FeedProps.c(L).a(a2.a());
            baseMultiRowSubParts.a(this.f12498d.m14392a(graphQLGoodwillThrowbackPromotionFeedUnit.F()), a3);
            baseMultiRowSubParts.a(this.f12501g, a3);
            baseMultiRowSubParts.a(this.f12500f, a3);
            baseMultiRowSubParts.a(this.f12499e, a3);
            if (StoryAttachmentHelper.o(graphQLStory2) != null) {
                a = a3.a(StoryAttachmentHelper.o(graphQLStory2));
                String F = graphQLGoodwillThrowbackPromotionFeedUnit.F();
                if ("reshare_photo".equals(F)) {
                    baseMultiRowSubParts.a(this.f12496b, a);
                } else if ("reshare_video".equals(F)) {
                    baseMultiRowSubParts.a(this.f12497c, a);
                }
            }
        } else {
            baseMultiRowSubParts.a(this.f12501g, a);
            baseMultiRowSubParts.a(this.f12500f, a);
            baseMultiRowSubParts.a(this.f12499e, a);
            baseMultiRowSubParts.a(this.f12495a, a);
        }
        return null;
    }

    public final boolean m14388a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (!GoodwillFeedUnitHelper.b(graphQLGoodwillThrowbackPromotionFeedUnit) || !GoodwillFeedUnitHelper.e(graphQLGoodwillThrowbackPromotionFeedUnit)) {
            return false;
        }
        if (m14385a(graphQLGoodwillThrowbackPromotionFeedUnit)) {
            int i;
            if (GoodwillFeedUnitHelper.h(graphQLGoodwillThrowbackPromotionFeedUnit) != 1 || ((GraphQLStory) graphQLGoodwillThrowbackPromotionFeedUnit.E().a().get(0)).L() == null) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public ThrowbackPromotedStoryPartDefinition(ThrowbackPromotedStorySeeOriginalPartDefinitionProvider throwbackPromotedStorySeeOriginalPartDefinitionProvider, ThrowbackPromotedStoryHeaderPartDefinition throwbackPromotedStoryHeaderPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, ThrowbackResharedPhotoAttachmentPartDefinition throwbackResharedPhotoAttachmentPartDefinition, ThrowbackResharedVideoAttachmentPartDefinition throwbackResharedVideoAttachmentPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, ThrowbackToEdgeStoryConverter throwbackToEdgeStoryConverter) {
        this.f12498d = throwbackPromotedStorySeeOriginalPartDefinitionProvider;
        this.f12502h = throwbackToEdgeStoryConverter;
        this.f12495a = attachmentsPartDefinition;
        this.f12496b = throwbackResharedPhotoAttachmentPartDefinition;
        this.f12497c = throwbackResharedVideoAttachmentPartDefinition;
        this.f12499e = seeTranslationPartDefinition;
        this.f12500f = translationOrContentSelectorPartDefinition;
        this.f12501g = throwbackPromotedStoryHeaderPartDefinition;
    }

    public static ThrowbackPromotedStoryPartDefinition m14384a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12494j) {
                ThrowbackPromotedStoryPartDefinition throwbackPromotedStoryPartDefinition;
                if (a2 != null) {
                    throwbackPromotedStoryPartDefinition = (ThrowbackPromotedStoryPartDefinition) a2.a(f12494j);
                } else {
                    throwbackPromotedStoryPartDefinition = f12493i;
                }
                if (throwbackPromotedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14386b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12494j, b3);
                        } else {
                            f12493i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static boolean m14385a(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit) {
        String F = graphQLGoodwillThrowbackPromotionFeedUnit.F();
        return "reshare_status_update".equals(F) || "reshare_photo".equals(F) || "reshare_video".equals(F);
    }
}
