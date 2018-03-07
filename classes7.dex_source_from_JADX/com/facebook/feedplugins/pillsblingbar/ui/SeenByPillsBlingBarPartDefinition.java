package com.facebook.feedplugins.pillsblingbar.ui;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SOUVENIR_UNIQUE_ID */
public class SeenByPillsBlingBarPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, PillsBlingBarView> {
    private static SeenByPillsBlingBarPartDefinition f23735c;
    private static final Object f23736d = new Object();
    private final PillsBlingBarPartDefinition f23737a;
    private final PillsBlingBarSeenByBinderPartDefinition f23738b;

    private static SeenByPillsBlingBarPartDefinition m25909b(InjectorLike injectorLike) {
        return new SeenByPillsBlingBarPartDefinition(PillsBlingBarPartDefinition.a(injectorLike), PillsBlingBarSeenByBinderPartDefinition.m25903a(injectorLike));
    }

    public final Object m25911a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23737a, feedProps);
        subParts.a(this.f23738b, graphQLStory);
        return null;
    }

    public final boolean m25912a(Object obj) {
        return this.f23737a.a((FeedProps) obj);
    }

    @Inject
    public SeenByPillsBlingBarPartDefinition(PillsBlingBarPartDefinition pillsBlingBarPartDefinition, PillsBlingBarSeenByBinderPartDefinition pillsBlingBarSeenByBinderPartDefinition) {
        this.f23737a = pillsBlingBarPartDefinition;
        this.f23738b = pillsBlingBarSeenByBinderPartDefinition;
    }

    public final ViewType m25910a() {
        return this.f23737a.a();
    }

    public static SeenByPillsBlingBarPartDefinition m25908a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeenByPillsBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23736d) {
                SeenByPillsBlingBarPartDefinition seenByPillsBlingBarPartDefinition;
                if (a2 != null) {
                    seenByPillsBlingBarPartDefinition = (SeenByPillsBlingBarPartDefinition) a2.a(f23736d);
                } else {
                    seenByPillsBlingBarPartDefinition = f23735c;
                }
                if (seenByPillsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25909b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23736d, b3);
                        } else {
                            f23735c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seenByPillsBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
