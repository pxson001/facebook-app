package com.facebook.feedplugins.reviews.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
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
/* compiled from: framepack_id */
public class PlaceReviewPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPlaceReviewFeedUnit>, Void, FeedEnvironment> {
    private static PlaceReviewPartDefinition f12992c;
    private static final Object f12993d = new Object();
    private final PlaceReviewAttachmentSelectorPartDefinition f12994a;
    private final PlaceReviewHeaderPartDefinition f12995b;

    private static PlaceReviewPartDefinition m14710b(InjectorLike injectorLike) {
        return new PlaceReviewPartDefinition(PlaceReviewHeaderPartDefinition.m14686a(injectorLike), PlaceReviewAttachmentSelectorPartDefinition.m14671a(injectorLike));
    }

    public final Object m14711a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12995b, feedProps);
        baseMultiRowSubParts.a(this.f12994a, feedProps);
        return null;
    }

    @Inject
    public PlaceReviewPartDefinition(PlaceReviewHeaderPartDefinition placeReviewHeaderPartDefinition, PlaceReviewAttachmentSelectorPartDefinition placeReviewAttachmentSelectorPartDefinition) {
        this.f12994a = placeReviewAttachmentSelectorPartDefinition;
        this.f12995b = placeReviewHeaderPartDefinition;
    }

    public final boolean m14712a(Object obj) {
        return true;
    }

    public static PlaceReviewPartDefinition m14709a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12993d) {
                PlaceReviewPartDefinition placeReviewPartDefinition;
                if (a2 != null) {
                    placeReviewPartDefinition = (PlaceReviewPartDefinition) a2.a(f12993d);
                } else {
                    placeReviewPartDefinition = f12992c;
                }
                if (placeReviewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14710b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12993d, b3);
                        } else {
                            f12992c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
