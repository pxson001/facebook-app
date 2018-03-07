package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.feedplugins.offline.OfflineStoryKey;
import com.facebook.feedplugins.offline.OfflineStoryPersistentState;
import com.facebook.feedplugins.offline.rows.ui.OfflineProgressView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.OfflinePostConfig;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: START_FINGERPRINTING */
public class OfflineProgressPartDefinition<E extends HasPersistentState & HasPositionInformation & HasFeedListType & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, OfflineProgressView> {
    public static final ViewType f23643a = new C20381();
    public static final Class<?> f23644b = OfflineProgressPartDefinition.class;
    private static OfflineProgressPartDefinition f23645j;
    private static final Object f23646k = new Object();
    private final OfflinePostHeaderController f23647c;
    public final AbstractFbErrorReporter f23648d;
    private final Clock f23649e;
    private final PendingStoryStore f23650f;
    private final OfflineHeaderStylePartDefinition f23651g;
    private final OfflinePostConfigCache f23652h;
    private final OfflineProgressController f23653i;

    /* compiled from: START_FINGERPRINTING */
    final class C20381 extends ViewType {
        C20381() {
        }

        public final View m25851a(Context context) {
            return new OfflineProgressView(context);
        }
    }

    /* compiled from: START_FINGERPRINTING */
    public class State {
        public final OfflineStoryPersistentState f23640a;
        public final FutureCallback<GraphQLStory> f23641b;
        public final FutureCallback<GraphQLStory> f23642c;

        public State(OfflineStoryPersistentState offlineStoryPersistentState, FutureCallback<GraphQLStory> futureCallback, FutureCallback<GraphQLStory> futureCallback2) {
            this.f23640a = offlineStoryPersistentState;
            this.f23641b = futureCallback;
            this.f23642c = futureCallback2;
        }
    }

    private static OfflineProgressPartDefinition m25855b(InjectorLike injectorLike) {
        return new OfflineProgressPartDefinition(OfflinePostHeaderController.m4432a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PendingStoryStore.a(injectorLike), OfflineHeaderStylePartDefinition.m25838a(injectorLike), OfflinePostConfigCache.a(injectorLike), OfflineProgressController.m25844a(injectorLike));
    }

    public final Object m25857a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23651g, feedProps);
        return new State((OfflineStoryPersistentState) hasPersistentState.a(new OfflineStoryKey(graphQLStory), graphQLStory), m25853a((HasInvalidate) hasPersistentState), m25853a((HasInvalidate) hasPersistentState));
    }

    public final boolean m25859a(Object obj) {
        return this.f23653i.m25850a((GraphQLStory) ((FeedProps) obj).a, false);
    }

    public final void m25860b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OfflinePostConfig a = this.f23652h.a((GraphQLStory) ((FeedProps) obj).a);
        a.b = 0;
        a.a = true;
    }

    public static OfflineProgressPartDefinition m25852a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineProgressPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23646k) {
                OfflineProgressPartDefinition offlineProgressPartDefinition;
                if (a2 != null) {
                    offlineProgressPartDefinition = (OfflineProgressPartDefinition) a2.a(f23646k);
                } else {
                    offlineProgressPartDefinition = f23645j;
                }
                if (offlineProgressPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25855b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23646k, b3);
                        } else {
                            f23645j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineProgressPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OfflineProgressPartDefinition(OfflinePostHeaderController offlinePostHeaderController, AbstractFbErrorReporter abstractFbErrorReporter, Clock clock, PendingStoryStore pendingStoryStore, OfflineHeaderStylePartDefinition offlineHeaderStylePartDefinition, OfflinePostConfigCache offlinePostConfigCache, OfflineProgressController offlineProgressController) {
        this.f23647c = offlinePostHeaderController;
        this.f23648d = abstractFbErrorReporter;
        this.f23649e = clock;
        this.f23650f = pendingStoryStore;
        this.f23651g = offlineHeaderStylePartDefinition;
        this.f23652h = offlinePostConfigCache;
        this.f23653i = offlineProgressController;
    }

    public final ViewType m25856a() {
        return f23643a;
    }

    private void m25854a(FeedProps<GraphQLStory> feedProps, State state, E e, OfflineProgressView offlineProgressView) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        Optional d = this.f23650f.d(graphQLStory.T());
        if (d.isPresent()) {
            offlineProgressView.f23719e = state.f23642c;
            if (state.f23640a.f23557a) {
                ((PendingStory) d.get()).b(this.f23649e.a());
                ((HasInvalidate) e).hL_();
                return;
            }
            OfflinePostConfig a = this.f23652h.a(graphQLStory);
            WeakReference weakReference = new WeakReference(offlineProgressView);
            this.f23647c.m4439a(graphQLStory, weakReference, 3000);
            a.b = weakReference.hashCode();
            offlineProgressView.setProgress(((PendingStory) d.get()).a(this.f23649e.a()));
            offlineProgressView.setVisibility(0);
            return;
        }
        offlineProgressView.f23720f = state.f23641b;
    }

    private FutureCallback<GraphQLStory> m25853a(final HasInvalidate hasInvalidate) {
        return new FutureCallback<GraphQLStory>(this) {
            final /* synthetic */ OfflineProgressPartDefinition f23639b;

            public void onSuccess(Object obj) {
                hasInvalidate.hL_();
            }

            public void onFailure(Throwable th) {
                this.f23639b.f23648d.a(OfflineProgressPartDefinition.f23644b.toString(), "Unexpected Error in Offline Progress", th);
            }
        };
    }
}
