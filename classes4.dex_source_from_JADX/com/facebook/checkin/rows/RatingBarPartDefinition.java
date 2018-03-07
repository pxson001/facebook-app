package com.facebook.checkin.rows;

import android.content.Context;
import android.view.View;
import android.widget.RatingBar;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;

@ContextScoped
/* compiled from: new_language */
public class RatingBarPartDefinition<Environment extends AnyEnvironment> extends BaseSinglePartDefinition<GraphQLPlace, State, Environment, RatingBar> implements MultiRowPartWithIsNeeded<GraphQLPlace, AnyEnvironment> {
    private static RatingBarPartDefinition f7132a;
    private static final Object f7133b = new Object();

    /* compiled from: new_language */
    public class State {
        public final float f13695a;
        public final int f13696b;

        public State(float f, int i) {
            this.f13695a = f;
            this.f13696b = i;
        }
    }

    private static RatingBarPartDefinition m7454a() {
        return new RatingBarPartDefinition();
    }

    public final Object m7457a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLRating C = ((GraphQLPlace) obj).C();
        return new State((float) C.k(), C.j());
    }

    public final /* bridge */ /* synthetic */ void m7458a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2102061480);
        State state = (State) obj2;
        RatingBar ratingBar = (RatingBar) view;
        ratingBar.setRating(state.f13695a);
        ratingBar.setNumStars(state.f13696b);
        ratingBar.setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, -1026817139, a);
    }

    public final void m7460b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((RatingBar) view).setVisibility(8);
    }

    public static boolean m7456a(GraphQLPlace graphQLPlace) {
        return graphQLPlace.C() != null && graphQLPlace.U();
    }

    public static RatingBarPartDefinition m7455a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RatingBarPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7133b) {
                RatingBarPartDefinition ratingBarPartDefinition;
                if (a3 != null) {
                    ratingBarPartDefinition = (RatingBarPartDefinition) a3.a(f7133b);
                } else {
                    ratingBarPartDefinition = f7132a;
                }
                if (ratingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m7454a();
                        if (a3 != null) {
                            a3.a(f7133b, a2);
                        } else {
                            f7132a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = ratingBarPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
