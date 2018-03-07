package com.facebook.feedplugins.graphqlstory.followup;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: in_app_browser_debug_overlay */
public class FollowUpGroupPartDefinition<E extends HasPersistentState & HasInvalidate & HasMenuButtonProvider> extends BaseMultiRowGroupPartDefinition<GraphQLStory, Void, E> {
    private static FollowUpGroupPartDefinition f20285c;
    private static final Object f20286d = new Object();
    private final MomentsUpsellImpressionHelper f20287a;
    private final FollowUpPartDefinition<E> f20288b;

    private static FollowUpGroupPartDefinition m27959b(InjectorLike injectorLike) {
        return new FollowUpGroupPartDefinition(MomentsUpsellImpressionHelper.m27962a(injectorLike), FollowUpPartDefinition.m27980a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.m19112a(this.f20288b, (GraphQLStory) obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        if (PropertyHelper.m21288b(graphQLStory) == null) {
            return false;
        }
        List v = ((ScrollableItemListFeedUnit) PropertyHelper.m21288b(graphQLStory)).mo2882v();
        if (v == null || v.isEmpty()) {
            return false;
        }
        return !this.f20287a.m27966a(graphQLStory);
    }

    @Inject
    public FollowUpGroupPartDefinition(MomentsUpsellImpressionHelper momentsUpsellImpressionHelper, FollowUpPartDefinition followUpPartDefinition) {
        this.f20287a = momentsUpsellImpressionHelper;
        this.f20288b = followUpPartDefinition;
    }

    public static FollowUpGroupPartDefinition m27958a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowUpGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20286d) {
                FollowUpGroupPartDefinition followUpGroupPartDefinition;
                if (a2 != null) {
                    followUpGroupPartDefinition = (FollowUpGroupPartDefinition) a2.mo818a(f20286d);
                } else {
                    followUpGroupPartDefinition = f20285c;
                }
                if (followUpGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27959b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20286d, b3);
                        } else {
                            f20285c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followUpGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
