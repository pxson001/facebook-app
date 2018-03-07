package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.offline.rows.OfflineSuccessController.C20461;
import com.facebook.feedplugins.offline.rows.ui.OfflineSuccessView;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STARS_HIGHRATING_NOTHANKS */
public class OfflineSuccessPartDefinition<E extends HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, OfflineSuccessView> {
    public static final ViewType<OfflineSuccessView> f23693a = new C20471();
    private static OfflineSuccessPartDefinition f23694c;
    private static final Object f23695d = new Object();
    private final OfflineSuccessController f23696b;

    /* compiled from: STARS_HIGHRATING_NOTHANKS */
    final class C20471 extends ViewType<OfflineSuccessView> {
        C20471() {
        }

        public final View m25882a(Context context) {
            return new OfflineSuccessView(context);
        }
    }

    @Immutable
    /* compiled from: STARS_HIGHRATING_NOTHANKS */
    public class State {
        public final OnClickListener f23692a;

        public State(OnClickListener onClickListener) {
            this.f23692a = onClickListener;
        }
    }

    private static OfflineSuccessPartDefinition m25884b(InjectorLike injectorLike) {
        return new OfflineSuccessPartDefinition(new OfflineSuccessController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike)));
    }

    public final Object m25886a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        OfflineSuccessController offlineSuccessController = this.f23696b;
        Flattenable flattenable = feedProps.a;
        return new State(new C20461(offlineSuccessController));
    }

    public final /* bridge */ /* synthetic */ void m25887a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1897350338);
        State state = (State) obj2;
        OfflineSuccessView offlineSuccessView = (OfflineSuccessView) view;
        offlineSuccessView.f23725a.setText(2131239194);
        offlineSuccessView.setOnClickListener(state.f23692a);
        Logger.a(8, EntryType.MARK_POP, 1015801680, a);
    }

    public final boolean m25888a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        OfflineSuccessController offlineSuccessController = this.f23696b;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        boolean z = false;
        if (!OfflineProgressController.m25846a(graphQLStory) && offlineSuccessController.f23689a.a(ExperimentsForCompostAbTestModule.A, false) && offlineSuccessController.f23690b.b(graphQLStory)) {
            z = true;
        }
        return z;
    }

    public final void m25889b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((OfflineSuccessView) view).setOnClickListener(null);
    }

    @Inject
    public OfflineSuccessPartDefinition(OfflineSuccessController offlineSuccessController) {
        this.f23696b = offlineSuccessController;
    }

    public static OfflineSuccessPartDefinition m25883a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineSuccessPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23695d) {
                OfflineSuccessPartDefinition offlineSuccessPartDefinition;
                if (a2 != null) {
                    offlineSuccessPartDefinition = (OfflineSuccessPartDefinition) a2.a(f23695d);
                } else {
                    offlineSuccessPartDefinition = f23694c;
                }
                if (offlineSuccessPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25884b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23695d, b3);
                        } else {
                            f23694c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineSuccessPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<OfflineSuccessView> m25885a() {
        return f23693a;
    }
}
