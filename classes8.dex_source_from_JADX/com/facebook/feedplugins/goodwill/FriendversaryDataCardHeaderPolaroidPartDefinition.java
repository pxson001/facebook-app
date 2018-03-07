package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_item_tapped */
public class FriendversaryDataCardHeaderPolaroidPartDefinition<E extends HasPositionInformation & HasPrefetcher> extends DualPhotoBasePartDefinition<GraphQLGoodwillThrowbackPromotionFeedUnit, E> {
    private static FriendversaryDataCardHeaderPolaroidPartDefinition f12277b;
    private static final Object f12278c = new Object();

    private static FriendversaryDataCardHeaderPolaroidPartDefinition m14242b(InjectorLike injectorLike) {
        return new FriendversaryDataCardHeaderPolaroidPartDefinition(FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m14243a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        DualPhotoViewConfig dualPhotoViewConfig = new DualPhotoViewConfig();
        dualPhotoViewConfig.f12216a = -4.3f;
        dualPhotoViewConfig.f12217b = 9.3f;
        dualPhotoViewConfig.f12218c = 52;
        dualPhotoViewConfig.f12219d = 4;
        dualPhotoViewConfig.f12220e = 4;
        dualPhotoViewConfig.f12221f = 16;
        dualPhotoViewConfig.f12222g = 20;
        dualPhotoViewConfig.f12223h = 12;
        dualPhotoViewConfig.f12224i = 0;
        ImmutableList u = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit).u();
        return m14186a(hasPositionInformation, ((GraphQLStoryAttachment) u.get(0)).r().S().b(), ((GraphQLStoryAttachment) u.get(1)).r().S().b(), dualPhotoViewConfig);
    }

    public final boolean m14244a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (graphQLGoodwillThrowbackPromotionFeedUnit == null) {
            return false;
        }
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (g == null || g.u() == null || g.u().size() < 2) {
            return false;
        }
        ImmutableList u = g.u();
        for (int i = 0; i < 2; i++) {
            GraphQLMedia r = ((GraphQLStoryAttachment) u.get(i)).r();
            if (r == null || r.S() == null || r.S().b() == null) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public FriendversaryDataCardHeaderPolaroidPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(fbDraweeControllerBuilder);
    }

    public static FriendversaryDataCardHeaderPolaroidPartDefinition m14241a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardHeaderPolaroidPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12278c) {
                FriendversaryDataCardHeaderPolaroidPartDefinition friendversaryDataCardHeaderPolaroidPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardHeaderPolaroidPartDefinition = (FriendversaryDataCardHeaderPolaroidPartDefinition) a2.a(f12278c);
                } else {
                    friendversaryDataCardHeaderPolaroidPartDefinition = f12277b;
                }
                if (friendversaryDataCardHeaderPolaroidPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14242b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12278c, b3);
                        } else {
                            f12277b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardHeaderPolaroidPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
