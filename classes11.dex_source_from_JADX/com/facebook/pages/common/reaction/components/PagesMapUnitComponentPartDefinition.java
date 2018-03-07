package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PageMapComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionGeoRectangleFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionGeoRectangleFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitPageMapComponentFragmentModel.LocationsModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selection_region */
public class PagesMapUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageMapComponentView> {
    public static final ViewType f2070a = new C02691();
    private static PagesMapUnitComponentPartDefinition f2071c;
    private static final Object f2072d = new Object();
    private final PagesSurfaceReactionHelper<E> f2073b;

    /* compiled from: selection_region */
    final class C02691 extends ViewType {
        C02691() {
        }

        public final View m3099a(Context context) {
            return new PageMapComponentView(context);
        }
    }

    /* compiled from: selection_region */
    public class State {
        public final ArrayList<LatLng> f2064a;
        public final ReactionGeoRectangleFieldsModel f2065b;
        public final int f2066c;
        public final GraphQLPlaceType f2067d;
        public final OnClickListener f2068e;
        public final boolean f2069f;

        public State(boolean z, ArrayList<LatLng> arrayList, ReactionGeoRectangleFields reactionGeoRectangleFields, int i, GraphQLPlaceType graphQLPlaceType, OnClickListener onClickListener) {
            this.f2069f = z;
            this.f2064a = arrayList;
            this.f2065b = reactionGeoRectangleFields;
            this.f2066c = i;
            this.f2067d = graphQLPlaceType;
            this.f2068e = onClickListener;
        }
    }

    private static PagesMapUnitComponentPartDefinition m3102b(InjectorLike injectorLike) {
        return new PagesMapUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3104a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ArrayList arrayList = new ArrayList();
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        ImmutableList bq = reactionUnitComponentFields.bq();
        int size = bq.size();
        for (int i = 0; i < size; i++) {
            LatLng a = m3100a((LocationsModel) bq.get(i));
            if (a != null) {
                arrayList.add(a);
            }
        }
        Preconditions.checkState(!arrayList.isEmpty());
        return new State(reactionUnitComponentFields.be(), arrayList, reactionUnitComponentFields.bt(), reactionUnitComponentFields.di(), reactionUnitComponentFields.bV(), this.f2073b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3105a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1384968909);
        State state = (State) obj2;
        PageMapComponentView pageMapComponentView = (PageMapComponentView) view;
        pageMapComponentView.m3170a(state.f2069f, state.f2064a, state.f2065b, state.f2066c, state.f2067d);
        pageMapComponentView.setOnClickListener(state.f2068e);
        Logger.a(8, EntryType.MARK_POP, -16005859, a);
    }

    public final boolean m3106a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bq() == null || reactionUnitComponentFields.bq().isEmpty() || m3100a((LocationsModel) reactionUnitComponentFields.bq().get(0)) == null) ? false : true;
    }

    public final void m3107b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageMapComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3103a() {
        return f2070a;
    }

    public static PagesMapUnitComponentPartDefinition m3101a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesMapUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2072d) {
                PagesMapUnitComponentPartDefinition pagesMapUnitComponentPartDefinition;
                if (a2 != null) {
                    pagesMapUnitComponentPartDefinition = (PagesMapUnitComponentPartDefinition) a2.a(f2072d);
                } else {
                    pagesMapUnitComponentPartDefinition = f2071c;
                }
                if (pagesMapUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3102b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2072d, b3);
                        } else {
                            f2071c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesMapUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagesMapUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f2073b = pagesSurfaceReactionHelper;
    }

    private static LatLng m3100a(LocationsModel locationsModel) {
        if (Math.abs(locationsModel.a()) > 90.0d || Math.abs(locationsModel.b()) > 180.0d) {
            return null;
        }
        return new LatLng(locationsModel.a(), locationsModel.b());
    }
}
