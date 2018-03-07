package com.facebook.feed.rows.sections.hidden;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.HideableUnit;
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
/* compiled from: java.runtime.name */
public class HiddenUnitGroupPartDefinition<T extends HideableUnit> extends BaseMultiRowGroupPartDefinition<FeedProps<T>, Void, HasFeedListType> {
    private static HiddenUnitGroupPartDefinition f18673b;
    private static final Object f18674c = new Object();
    private final HiddenUnitPartDefinition f18675a;

    private static HiddenUnitGroupPartDefinition m26195b(InjectorLike injectorLike) {
        return new HiddenUnitGroupPartDefinition(HiddenUnitPartDefinition.m26199a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.m19112a(this.f18675a, (FeedProps) obj);
        return null;
    }

    @Inject
    public HiddenUnitGroupPartDefinition(HiddenUnitPartDefinition hiddenUnitPartDefinition) {
        this.f18675a = hiddenUnitPartDefinition;
    }

    public static HiddenUnitGroupPartDefinition m26193a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HiddenUnitGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18674c) {
                HiddenUnitGroupPartDefinition hiddenUnitGroupPartDefinition;
                if (a2 != null) {
                    hiddenUnitGroupPartDefinition = (HiddenUnitGroupPartDefinition) a2.mo818a(f18674c);
                } else {
                    hiddenUnitGroupPartDefinition = f18673b;
                }
                if (hiddenUnitGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26195b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18674c, b3);
                        } else {
                            f18673b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = hiddenUnitGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static boolean m26194a(FeedProps<T> feedProps) {
        return ((HideableUnit) feedProps.f13444a).mo2879o() != StoryVisibility.VISIBLE;
    }
}
