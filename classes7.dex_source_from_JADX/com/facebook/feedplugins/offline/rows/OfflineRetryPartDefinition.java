package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.feed.util.composer.OfflinePostHeaderController.C03171;
import com.facebook.feed.util.composer.OfflinePostHeaderController.C03182;
import com.facebook.feedplugins.offline.rows.OfflineRetryController.C20421;
import com.facebook.feedplugins.offline.rows.ui.OfflineRetryView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STARS_LOWRATING_SUBMIT */
public class OfflineRetryPartDefinition<E extends HasFeedListType & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, OfflineRetryView> {
    public static final ViewType f23681a = new C20431();
    private static OfflineRetryPartDefinition f23682f;
    private static final Object f23683g = new Object();
    public final OfflinePostHeaderController f23684b;
    public final NetworkMonitor f23685c;
    private final OfflineHeaderStylePartDefinition f23686d;
    private final OfflineRetryController f23687e;

    /* compiled from: STARS_LOWRATING_SUBMIT */
    final class C20431 extends ViewType {
        C20431() {
        }

        public final View m25874a(Context context) {
            return new OfflineRetryView(context);
        }
    }

    /* compiled from: STARS_LOWRATING_SUBMIT */
    public class State {
        public final OnTouchListener f23677a;
        public final OnClickListener f23678b;
        public final OnClickListener f23679c;
        public final SelfRegistrableReceiverImpl f23680d;

        public State(OnTouchListener onTouchListener, OnClickListener onClickListener, OnClickListener onClickListener2, SelfRegistrableReceiverImpl selfRegistrableReceiverImpl) {
            this.f23677a = onTouchListener;
            this.f23678b = onClickListener;
            this.f23679c = onClickListener2;
            this.f23680d = selfRegistrableReceiverImpl;
        }
    }

    private static OfflineRetryPartDefinition m25876b(InjectorLike injectorLike) {
        return new OfflineRetryPartDefinition(OfflinePostHeaderController.m4432a(injectorLike), NetworkMonitor.a(injectorLike), PendingStoryStore.a(injectorLike), OfflineHeaderStylePartDefinition.m25838a(injectorLike), new OfflineRetryController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), PendingStoryStore.a(injectorLike), OfflinePostHeaderController.m4432a(injectorLike), FbNetworkManager.a(injectorLike), ComposerAnalyticsLogger.a(injectorLike), OfflinePostConfigCache.a(injectorLike), NetworkMonitor.a(injectorLike)));
    }

    public final Object m25878a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23686d, feedProps);
        this.f23687e.m25873c(graphQLStory);
        return new State(this.f23684b.m4435a(), new OnClickListener(this) {
            final /* synthetic */ OfflineRetryPartDefinition f23674b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1679739242);
                OfflinePostHeaderController offlinePostHeaderController = this.f23674b.f23684b;
                GraphQLStory graphQLStory = graphQLStory;
                Context context = view.getContext();
                new Builder(context).a(false).b(context.getResources().getString(2131233519)).b(2131233465, new C03182(offlinePostHeaderController)).a(2131233440, new C03171(offlinePostHeaderController, graphQLStory)).a().show();
                Logger.a(2, EntryType.UI_INPUT_END, 1162252914, a);
            }
        }, new C20421(this.f23687e, graphQLStory), this.f23685c.a(com.facebook.common.network.NetworkMonitor.State.CONNECTED, new Runnable(this) {
            final /* synthetic */ OfflineRetryPartDefinition f23676b;

            public void run() {
                this.f23676b.f23684b.m4438a(graphQLStory, RetrySource.AUTOMATIC);
            }
        }));
    }

    public final /* bridge */ /* synthetic */ void m25879a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1334394460);
        State state = (State) obj2;
        OfflineRetryView offlineRetryView = (OfflineRetryView) view;
        offlineRetryView.m25901a(state.f23677a, state.f23678b);
        offlineRetryView.m25902b(state.f23677a, state.f23679c);
        Logger.a(8, EntryType.MARK_POP, 1753728008, a);
    }

    public final boolean m25880a(Object obj) {
        return this.f23687e.m25872a((GraphQLStory) ((FeedProps) obj).a);
    }

    public final void m25881b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OfflineRetryView offlineRetryView = (OfflineRetryView) view;
        ((State) obj2).f23680d.c();
        offlineRetryView.m25901a(null, null);
        offlineRetryView.m25902b(null, null);
        offlineRetryView.setOnClickListener(null);
    }

    public static OfflineRetryPartDefinition m25875a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineRetryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23683g) {
                OfflineRetryPartDefinition offlineRetryPartDefinition;
                if (a2 != null) {
                    offlineRetryPartDefinition = (OfflineRetryPartDefinition) a2.a(f23683g);
                } else {
                    offlineRetryPartDefinition = f23682f;
                }
                if (offlineRetryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25876b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23683g, b3);
                        } else {
                            f23682f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineRetryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OfflineRetryPartDefinition(OfflinePostHeaderController offlinePostHeaderController, NetworkMonitor networkMonitor, PendingStoryStore pendingStoryStore, OfflineHeaderStylePartDefinition offlineHeaderStylePartDefinition, OfflineRetryController offlineRetryController) {
        this.f23684b = offlinePostHeaderController;
        this.f23685c = networkMonitor;
        this.f23686d = offlineHeaderStylePartDefinition;
        this.f23687e = offlineRetryController;
    }

    public final ViewType m25877a() {
        return f23681a;
    }
}
