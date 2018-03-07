package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionGeoRectangleFieldsModel;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

@ContextScoped
/* compiled from: animatedImageParams */
public class ReactionMapPartDefinition extends BaseSinglePartDefinition<Props, State, HasContext, FbStaticMapView> {
    private static ReactionMapPartDefinition f19431b;
    private static final Object f19432c = new Object();
    private final FbZeroFeatureVisibilityHelper f19433a;

    /* compiled from: animatedImageParams */
    public class Props {
        public final DefaultLocationFields f19427a;
        public final ReactionGeoRectangleFieldsModel f19428b;

        public Props(DefaultLocationFields defaultLocationFields, ReactionGeoRectangleFieldsModel reactionGeoRectangleFieldsModel) {
            this.f19427a = defaultLocationFields;
            this.f19428b = reactionGeoRectangleFieldsModel;
        }
    }

    /* compiled from: animatedImageParams */
    public class State {
        public final boolean f19429a;
        public final StaticMapOptions f19430b;

        public State(boolean z, StaticMapOptions staticMapOptions) {
            this.f19429a = z;
            this.f19430b = staticMapOptions;
        }
    }

    private static ReactionMapPartDefinition m23416b(InjectorLike injectorLike) {
        return new ReactionMapPartDefinition(FbZeroFeatureVisibilityHelper.a(injectorLike));
    }

    public final Object m23417a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        StaticMapOptions staticMapOptions = new StaticMapOptions("local_serps");
        staticMapOptions.a(props.f19427a.a(), props.f19427a.b());
        if (props.f19428b != null) {
            staticMapOptions.a(new RectF((float) props.f19428b.d(), (float) props.f19428b.b(), (float) props.f19428b.a(), (float) props.f19428b.c()));
        } else {
            staticMapOptions.a(16);
        }
        return new State(this.f19433a.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL), staticMapOptions);
    }

    public final /* bridge */ /* synthetic */ void m23418a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 353822925);
        State state = (State) obj2;
        FbStaticMapView fbStaticMapView = (FbStaticMapView) view;
        if (state.f19429a) {
            fbStaticMapView.setVisibility(8);
        } else {
            fbStaticMapView.setVisibility(0);
            fbStaticMapView.setReportButtonVisibility(8);
            fbStaticMapView.setMapOptions(state.f19430b);
        }
        Logger.a(8, EntryType.MARK_POP, -1765106309, a);
    }

    @Inject
    public ReactionMapPartDefinition(FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f19433a = fbZeroFeatureVisibilityHelper;
    }

    public static ReactionMapPartDefinition m23415a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionMapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19432c) {
                ReactionMapPartDefinition reactionMapPartDefinition;
                if (a2 != null) {
                    reactionMapPartDefinition = (ReactionMapPartDefinition) a2.a(f19432c);
                } else {
                    reactionMapPartDefinition = f19431b;
                }
                if (reactionMapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23416b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19432c, b3);
                        } else {
                            f19431b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionMapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
