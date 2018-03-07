package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodwill.feed.rows.ThrowbackPromotionFeedUnitEdge.ThrowbackPromotionFeedUnit;
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
/* compiled from: fetch tagged media count  */
public class ThrowbackFeedPromotionSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<ThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackFeedPromotionSelectorPartDefinition f13550c;
    private static final Object f13551d = new Object();
    private final ThrowbackPromotionPhotoStoryGroupPartDefinition f13552a;
    private final ThrowbackPromotionFriendversaryGroupPartDefinition f13553b;

    private static ThrowbackFeedPromotionSelectorPartDefinition m15314b(InjectorLike injectorLike) {
        return new ThrowbackFeedPromotionSelectorPartDefinition(ThrowbackPromotionPhotoStoryGroupPartDefinition.m15446a(injectorLike), ThrowbackPromotionFriendversaryGroupPartDefinition.m15438a(injectorLike));
    }

    public final Object m15315a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f13553b, feedProps).a(this.f13552a, feedProps);
        return null;
    }

    @Inject
    public ThrowbackFeedPromotionSelectorPartDefinition(ThrowbackPromotionPhotoStoryGroupPartDefinition throwbackPromotionPhotoStoryGroupPartDefinition, ThrowbackPromotionFriendversaryGroupPartDefinition throwbackPromotionFriendversaryGroupPartDefinition) {
        this.f13552a = throwbackPromotionPhotoStoryGroupPartDefinition;
        this.f13553b = throwbackPromotionFriendversaryGroupPartDefinition;
    }

    public final boolean m15316a(Object obj) {
        return true;
    }

    public static ThrowbackFeedPromotionSelectorPartDefinition m15313a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFeedPromotionSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13551d) {
                ThrowbackFeedPromotionSelectorPartDefinition throwbackFeedPromotionSelectorPartDefinition;
                if (a2 != null) {
                    throwbackFeedPromotionSelectorPartDefinition = (ThrowbackFeedPromotionSelectorPartDefinition) a2.a(f13551d);
                } else {
                    throwbackFeedPromotionSelectorPartDefinition = f13550c;
                }
                if (throwbackFeedPromotionSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15314b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13551d, b3);
                        } else {
                            f13550c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFeedPromotionSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
