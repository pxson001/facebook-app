package com.facebook.today.ui.components.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: travel_in */
public class LargeMapUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, FbStaticMapView> {
    public static final ViewType f1279a = new C01231();
    private static LargeMapUnitComponentPartDefinition f1280c;
    private static final Object f1281d = new Object();
    private final BasicReactionActionPartDefinition f1282b;

    /* compiled from: travel_in */
    final class C01231 extends ViewType {
        C01231() {
        }

        public final View m1434a(Context context) {
            FbStaticMapView fbStaticMapView = new FbStaticMapView(context);
            fbStaticMapView.setLayoutParams(new LayoutParams(-1, context.getResources().getDimensionPixelSize(2131433007)));
            fbStaticMapView.setCenteredMapPinDrawable(context.getResources().getDrawable(2130841143));
            return fbStaticMapView;
        }
    }

    /* compiled from: travel_in */
    public class State {
        public final StaticMapOptions f1278a;

        public State(StaticMapOptions staticMapOptions) {
            this.f1278a = staticMapOptions;
        }
    }

    private static LargeMapUnitComponentPartDefinition m1436b(InjectorLike injectorLike) {
        return new LargeMapUnitComponentPartDefinition(BasicReactionActionPartDefinition.a(injectorLike));
    }

    public final Object m1438a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        if (reactionUnitComponentFields.v() != null) {
            subParts.a(this.f1282b, new Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.c, reactionUnitComponentNode.d));
        }
        StaticMapOptions staticMapOptions = new StaticMapOptions("notifications");
        staticMapOptions.a(reactionUnitComponentFields.bn().a(), reactionUnitComponentFields.bn().b());
        staticMapOptions.a(reactionUnitComponentFields.di());
        return new State(staticMapOptions);
    }

    public final /* bridge */ /* synthetic */ void m1439a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1889105209);
        State state = (State) obj2;
        FbStaticMapView fbStaticMapView = (FbStaticMapView) view;
        fbStaticMapView.setReportButtonVisibility(8);
        fbStaticMapView.setMapOptions(state.f1278a);
        fbStaticMapView.setEnabled(true);
        Logger.a(8, EntryType.MARK_POP, 1132096448, a);
    }

    public final boolean m1440a(Object obj) {
        return ((ReactionUnitComponentNode) obj).b.bn() != null;
    }

    public static LargeMapUnitComponentPartDefinition m1435a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LargeMapUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1281d) {
                LargeMapUnitComponentPartDefinition largeMapUnitComponentPartDefinition;
                if (a2 != null) {
                    largeMapUnitComponentPartDefinition = (LargeMapUnitComponentPartDefinition) a2.a(f1281d);
                } else {
                    largeMapUnitComponentPartDefinition = f1280c;
                }
                if (largeMapUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1436b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1281d, b3);
                        } else {
                            f1280c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = largeMapUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LargeMapUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f1282b = basicReactionActionPartDefinition;
    }

    public final ViewType<FbStaticMapView> m1437a() {
        return f1279a;
    }
}
