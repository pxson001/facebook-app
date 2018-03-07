package com.facebook.feed.rows.sections.hidden;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstonePartDefinition;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.Sponsorable;
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
/* compiled from: inline_composer_check_in_button_clicked */
public class FeedHiddenUnitGroupPartDefinition<E extends HasPositionInformation & HasPersistentState> extends BaseMultiRowGroupPartDefinition<FeedProps<NegativeFeedbackActionsUnit>, Void, E> {
    private static FeedHiddenUnitGroupPartDefinition f19916c;
    private static final Object f19917d = new Object();
    private final FeedHiddenUnitPartDefinition<NegativeFeedbackActionsUnit, E> f19918a;
    private final UserTopicTombstonePartDefinition f19919b;

    private static FeedHiddenUnitGroupPartDefinition m27697b(InjectorLike injectorLike) {
        return new FeedHiddenUnitGroupPartDefinition(FeedHiddenUnitPartDefinition.m27702a(injectorLike), UserTopicTombstonePartDefinition.m27717a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19114a(baseMultiRowSubParts, this.f19919b, (NegativeFeedbackActionsUnit) obj.f13444a).m19118a(this.f19918a, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) ((FeedProps) obj).f13444a;
        boolean z;
        if ((negativeFeedbackActionsUnit instanceof Sponsorable) && ((Sponsorable) negativeFeedbackActionsUnit).mo2895u()) {
            z = true;
        } else {
            z = false;
        }
        if (negativeFeedbackActionsUnit.mo2892r() == null || negativeFeedbackActionsUnit.mo2879o() == StoryVisibility.VISIBLE || r1) {
            return false;
        }
        return true;
    }

    @Inject
    public FeedHiddenUnitGroupPartDefinition(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, UserTopicTombstonePartDefinition userTopicTombstonePartDefinition) {
        this.f19918a = feedHiddenUnitPartDefinition;
        this.f19919b = userTopicTombstonePartDefinition;
    }

    public static FeedHiddenUnitGroupPartDefinition m27696a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedHiddenUnitGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19917d) {
                FeedHiddenUnitGroupPartDefinition feedHiddenUnitGroupPartDefinition;
                if (a2 != null) {
                    feedHiddenUnitGroupPartDefinition = (FeedHiddenUnitGroupPartDefinition) a2.mo818a(f19917d);
                } else {
                    feedHiddenUnitGroupPartDefinition = f19916c;
                }
                if (feedHiddenUnitGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27697b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19917d, b3);
                        } else {
                            f19916c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedHiddenUnitGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
