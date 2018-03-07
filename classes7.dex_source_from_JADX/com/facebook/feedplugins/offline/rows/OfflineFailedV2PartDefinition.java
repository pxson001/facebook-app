package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.offline.rows.OfflineFailedController.C20332;
import com.facebook.feedplugins.offline.rows.ui.OfflineFailedV2View;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: STATUS */
public class OfflineFailedV2PartDefinition<E extends HasPositionInformation & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, OfflineFailedV2View> {
    public static final ViewType f23618a = new C20361();
    private static OfflineFailedV2PartDefinition f23619c;
    private static final Object f23620d = new Object();
    private final OfflineFailedController f23621b;

    /* compiled from: STATUS */
    final class C20361 extends ViewType {
        C20361() {
        }

        public final View m25830a(Context context) {
            return new OfflineFailedV2View(context);
        }
    }

    /* compiled from: STATUS */
    public class State {
        public final OnClickListener f23615a;
        public final OnTouchListener f23616b;
        public final OnClickListener f23617c;

        public State(OnClickListener onClickListener, OnTouchListener onTouchListener, OnClickListener onClickListener2) {
            this.f23615a = onClickListener;
            this.f23616b = onTouchListener;
            this.f23617c = onClickListener2;
        }
    }

    private static OfflineFailedV2PartDefinition m25832b(InjectorLike injectorLike) {
        return new OfflineFailedV2PartDefinition(OfflineFailedController.m25817a(injectorLike));
    }

    public final Object m25834a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(this.f23621b.m25820a((GraphQLStory) ((FeedProps) obj).a), null, new C20332(this.f23621b));
    }

    public final /* bridge */ /* synthetic */ void m25835a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1018858108);
        State state = (State) obj2;
        OfflineFailedV2View offlineFailedV2View = (OfflineFailedV2View) view;
        offlineFailedV2View.setCancelButtonListeners(state.f23615a);
        offlineFailedV2View.setTextOnClickListener(state.f23617c);
        Logger.a(8, EntryType.MARK_POP, -1846923951, a);
    }

    public final boolean m25836a(Object obj) {
        return this.f23621b.m25821a((GraphQLStory) ((FeedProps) obj).a, true);
    }

    public final void m25837b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OfflineFailedV2View offlineFailedV2View = (OfflineFailedV2View) view;
        offlineFailedV2View.setCancelButtonListeners(null);
        offlineFailedV2View.setTextOnClickListener(null);
    }

    @Inject
    public OfflineFailedV2PartDefinition(OfflineFailedController offlineFailedController) {
        this.f23621b = offlineFailedController;
    }

    public static OfflineFailedV2PartDefinition m25831a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineFailedV2PartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23620d) {
                OfflineFailedV2PartDefinition offlineFailedV2PartDefinition;
                if (a2 != null) {
                    offlineFailedV2PartDefinition = (OfflineFailedV2PartDefinition) a2.a(f23620d);
                } else {
                    offlineFailedV2PartDefinition = f23619c;
                }
                if (offlineFailedV2PartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25832b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23620d, b3);
                        } else {
                            f23619c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineFailedV2PartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m25833a() {
        return f23618a;
    }
}
