package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.pillsblingbar.ui.SeenByPillsBlingBarPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: ThreadViewByParticipantsLoader */
public class GroupsBlingBarSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsBlingBarSelectorPartDefinition f22450c;
    private static final Object f22451d = new Object();
    private final SeenByBlingBarPartDefinition f22452a;
    private final SeenByPillsBlingBarPartDefinition f22453b;

    private static GroupsBlingBarSelectorPartDefinition m23521b(InjectorLike injectorLike) {
        return new GroupsBlingBarSelectorPartDefinition(SeenByPillsBlingBarPartDefinition.a(injectorLike), SeenByBlingBarPartDefinition.m23568a(injectorLike));
    }

    public final Object m23522a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f22453b, feedProps).a(this.f22452a, feedProps);
        return null;
    }

    @Inject
    public GroupsBlingBarSelectorPartDefinition(SeenByPillsBlingBarPartDefinition seenByPillsBlingBarPartDefinition, SeenByBlingBarPartDefinition seenByBlingBarPartDefinition) {
        this.f22452a = seenByBlingBarPartDefinition;
        this.f22453b = seenByPillsBlingBarPartDefinition;
    }

    public final boolean m23523a(Object obj) {
        return true;
    }

    public static GroupsBlingBarSelectorPartDefinition m23520a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsBlingBarSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22451d) {
                GroupsBlingBarSelectorPartDefinition groupsBlingBarSelectorPartDefinition;
                if (a2 != null) {
                    groupsBlingBarSelectorPartDefinition = (GroupsBlingBarSelectorPartDefinition) a2.a(f22451d);
                } else {
                    groupsBlingBarSelectorPartDefinition = f22450c;
                }
                if (groupsBlingBarSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23521b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22451d, b3);
                        } else {
                            f22450c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsBlingBarSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
