package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.offline.rows.OfflineProgressController.C20371;
import com.facebook.feedplugins.offline.rows.ui.OfflineProgressV2View;
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
import com.facebook.photos.upload.compost.CompostNetworkMonitor;
import com.facebook.photos.upload.compost.CompostNetworkMonitor.CompostNetworkListener;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: START */
public class OfflineProgressV2PartDefinition<E extends HasPersistentState & HasPositionInformation & HasFeedListType & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, OfflineProgressV2View> {
    public static final ViewType f23657a = new C20401();
    private static OfflineProgressV2PartDefinition f23658e;
    private static final Object f23659f = new Object();
    private final OfflineProgressController f23660b;
    private final FbNetworkManager f23661c;
    public final CompostNetworkMonitor f23662d;

    /* compiled from: START */
    final class C20401 extends ViewType {
        C20401() {
        }

        public final View m25861a(Context context) {
            return new OfflineProgressV2View(context);
        }
    }

    @Immutable
    /* compiled from: START */
    public class State {
        public final OnClickListener f23656a;

        public State(OnClickListener onClickListener) {
            this.f23656a = onClickListener;
        }
    }

    private static OfflineProgressV2PartDefinition m25865b(InjectorLike injectorLike) {
        return new OfflineProgressV2PartDefinition(OfflineProgressController.m25844a(injectorLike), FbNetworkManager.a(injectorLike), CompostNetworkMonitor.b(injectorLike));
    }

    public final Object m25867a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(new C20371(this.f23660b, (GraphQLStory) ((FeedProps) obj).a));
    }

    public final /* bridge */ /* synthetic */ void m25868a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1685550634);
        FeedProps feedProps = (FeedProps) obj;
        State state = (State) obj2;
        final OfflineProgressV2View offlineProgressV2View = (OfflineProgressV2View) view;
        this.f23662d.a(new CompostNetworkListener(this) {
            final /* synthetic */ OfflineProgressV2PartDefinition f23655b;

            public final void m25862a() {
                OfflineProgressV2PartDefinition.m25864a(this.f23655b, offlineProgressV2View);
            }
        });
        m25864a(this, offlineProgressV2View);
        offlineProgressV2View.setOnClickListener(state.f23656a);
        if (OfflineProgressController.m25846a((GraphQLStory) feedProps.a)) {
            offlineProgressV2View.a(2131564390).setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 1338190463, a);
    }

    public final boolean m25869a(Object obj) {
        return this.f23660b.m25850a((GraphQLStory) ((FeedProps) obj).a, true);
    }

    public final void m25870b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OfflineProgressV2View offlineProgressV2View = (OfflineProgressV2View) view;
        this.f23662d.d();
        offlineProgressV2View.setOnClickListener(null);
    }

    public static OfflineProgressV2PartDefinition m25863a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineProgressV2PartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23659f) {
                OfflineProgressV2PartDefinition offlineProgressV2PartDefinition;
                if (a2 != null) {
                    offlineProgressV2PartDefinition = (OfflineProgressV2PartDefinition) a2.a(f23659f);
                } else {
                    offlineProgressV2PartDefinition = f23658e;
                }
                if (offlineProgressV2PartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25865b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23659f, b3);
                        } else {
                            f23658e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineProgressV2PartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OfflineProgressV2PartDefinition(OfflineProgressController offlineProgressController, FbNetworkManager fbNetworkManager, CompostNetworkMonitor compostNetworkMonitor) {
        this.f23660b = offlineProgressController;
        this.f23661c = fbNetworkManager;
        this.f23662d = compostNetworkMonitor;
    }

    public static void m25864a(OfflineProgressV2PartDefinition offlineProgressV2PartDefinition, OfflineProgressV2View offlineProgressV2View) {
        int[] iArr;
        int i;
        if (offlineProgressV2PartDefinition.f23661c.d()) {
            iArr = new int[]{2131239189, 2131239190, 2131239191, 2131239192};
            i = 500;
            offlineProgressV2View.setAnimated(false);
        } else {
            iArr = new int[]{2131239187, 2131239186};
            i = 2000;
            offlineProgressV2View.setAnimated(true);
        }
        offlineProgressV2View.m25897a(iArr, i);
    }

    public final ViewType m25866a() {
        return f23657a;
    }
}
