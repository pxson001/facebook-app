package com.facebook.feedplugins.reviews.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
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
/* compiled from: friend_birthday */
public class PlaceReviewAttachmentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPlaceReviewFeedUnit>, Void, FeedEnvironment> {
    private static PlaceReviewAttachmentSelectorPartDefinition f12942c;
    private static final Object f12943d = new Object();
    private final PlaceReviewSingleItemPartDefinition f12944a;
    private final PlaceReviewHScrollPartDefinition<FeedEnvironment> f12945b;

    private static PlaceReviewAttachmentSelectorPartDefinition m14672b(InjectorLike injectorLike) {
        return new PlaceReviewAttachmentSelectorPartDefinition(PlaceReviewHScrollPartDefinition.m14679a(injectorLike), PlaceReviewSingleItemPartDefinition.m14713a(injectorLike));
    }

    public final Object m14673a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12944a, feedProps).a(this.f12945b, feedProps);
        return null;
    }

    public final boolean m14674a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return PlaceReviewSingleItemPartDefinition.m14714a(feedProps) || PlaceReviewHScrollPartDefinition.m14680a(feedProps);
    }

    @Inject
    public PlaceReviewAttachmentSelectorPartDefinition(PlaceReviewHScrollPartDefinition placeReviewHScrollPartDefinition, PlaceReviewSingleItemPartDefinition placeReviewSingleItemPartDefinition) {
        this.f12944a = placeReviewSingleItemPartDefinition;
        this.f12945b = placeReviewHScrollPartDefinition;
    }

    public static PlaceReviewAttachmentSelectorPartDefinition m14671a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12943d) {
                PlaceReviewAttachmentSelectorPartDefinition placeReviewAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    placeReviewAttachmentSelectorPartDefinition = (PlaceReviewAttachmentSelectorPartDefinition) a2.a(f12943d);
                } else {
                    placeReviewAttachmentSelectorPartDefinition = f12942c;
                }
                if (placeReviewAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14672b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12943d, b3);
                        } else {
                            f12942c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
