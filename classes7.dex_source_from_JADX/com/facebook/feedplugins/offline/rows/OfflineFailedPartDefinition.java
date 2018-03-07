package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.publish.PostFailureDialogController;
import com.facebook.composer.publish.PostFailureDialogControllerProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.feedplugins.offline.rows.ui.OfflineFailedView;
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
/* compiled from: STATUS_CONNECTING */
public class OfflineFailedPartDefinition<E extends HasPositionInformation & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, OfflineFailedView> {
    public static final ViewType f23607a = new C20341();
    private static final PaddingStyle f23608b = PaddingStyle.q;
    private static OfflineFailedPartDefinition f23609g;
    private static final Object f23610h = new Object();
    private final OfflinePostHeaderController f23611c;
    private final PostFailureDialogControllerProvider f23612d;
    private final OfflineHeaderStylePartDefinition f23613e;
    private final OfflineFailedController f23614f;

    /* compiled from: STATUS_CONNECTING */
    final class C20341 extends ViewType {
        C20341() {
        }

        public final View m25822a(Context context) {
            return new OfflineFailedView(context);
        }
    }

    /* compiled from: STATUS_CONNECTING */
    public class State {
        public final OnClickListener f23604a;
        public final OnTouchListener f23605b;
        public final OnClickListener f23606c;

        public State(OnClickListener onClickListener, OnTouchListener onTouchListener, OnClickListener onClickListener2) {
            this.f23604a = onClickListener;
            this.f23605b = onTouchListener;
            this.f23606c = onClickListener2;
        }
    }

    private static OfflineFailedPartDefinition m25824b(InjectorLike injectorLike) {
        return new OfflineFailedPartDefinition(OfflinePostHeaderController.m4432a(injectorLike), (PostFailureDialogControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PostFailureDialogControllerProvider.class), OfflineHeaderStylePartDefinition.m25838a(injectorLike), OfflineFailedController.m25817a(injectorLike));
    }

    public final Object m25826a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23613e, feedProps);
        final PostFailureDialogController a = this.f23612d.a(graphQLStory.T());
        OnClickListener c20352 = new OnClickListener(this) {
            final /* synthetic */ OfflineFailedPartDefinition f23603b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1097376384);
                a.a();
                Logger.a(2, EntryType.UI_INPUT_END, 1284602069, a);
            }
        };
        return new State(this.f23614f.m25820a(graphQLStory), this.f23611c.m4435a(), c20352);
    }

    public final /* bridge */ /* synthetic */ void m25827a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1407107337);
        State state = (State) obj2;
        OfflineFailedView offlineFailedView = (OfflineFailedView) view;
        offlineFailedView.setErrorListener(state.f23606c);
        offlineFailedView.m25893a(state.f23605b, state.f23604a);
        Logger.a(8, EntryType.MARK_POP, 1193561124, a);
    }

    public final boolean m25828a(Object obj) {
        return this.f23614f.m25821a((GraphQLStory) ((FeedProps) obj).a, false);
    }

    public final void m25829b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OfflineFailedView offlineFailedView = (OfflineFailedView) view;
        offlineFailedView.setErrorListener(null);
        offlineFailedView.m25893a(null, null);
    }

    public static OfflineFailedPartDefinition m25823a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineFailedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23610h) {
                OfflineFailedPartDefinition offlineFailedPartDefinition;
                if (a2 != null) {
                    offlineFailedPartDefinition = (OfflineFailedPartDefinition) a2.a(f23610h);
                } else {
                    offlineFailedPartDefinition = f23609g;
                }
                if (offlineFailedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25824b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23610h, b3);
                        } else {
                            f23609g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineFailedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OfflineFailedPartDefinition(OfflinePostHeaderController offlinePostHeaderController, PostFailureDialogControllerProvider postFailureDialogControllerProvider, OfflineHeaderStylePartDefinition offlineHeaderStylePartDefinition, OfflineFailedController offlineFailedController) {
        this.f23611c = offlinePostHeaderController;
        this.f23612d = postFailureDialogControllerProvider;
        this.f23613e = offlineHeaderStylePartDefinition;
        this.f23614f = offlineFailedController;
    }

    public final ViewType m25825a() {
        return f23607a;
    }
}
