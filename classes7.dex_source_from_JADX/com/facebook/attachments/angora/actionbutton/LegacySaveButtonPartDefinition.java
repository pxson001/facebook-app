package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.SavedCollectionFeedUnitMutator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.saved.common.sync.SavedEventHandler;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: usingDefaultAudience */
public class LegacySaveButtonPartDefinition extends BaseSinglePartDefinition<SaveButtonProps, State, AnyEnvironment, SaveButton> {
    private static LegacySaveButtonPartDefinition f830m;
    private static final Object f831n = new Object();
    private final AbstractFbErrorReporter f832a;
    private final FeedEventBus f833b;
    private final SavedCollectionFeedUnitMutator f834c;
    private final SaveButtonUtils f835d;
    private final AngoraCollectionUpdateRequestListener f836e;
    private final GraphQLStoryUtil f837f;
    private final Context f838g;
    private final ControllerMutationGatekeepers f839h;
    private final GraphQLQueryExecutor f840i;
    private final ExecutorService f841j;
    private final Lazy<SavedEventHandler> f842k;
    private final CollectionSaveLegacyMutationProvider f843l;

    /* compiled from: usingDefaultAudience */
    public class State {
        public final String f826a;
        public final String f827b;
        public SaveButtonListener f828c;
        public SaveButton f829d;

        public State(String str, String str2) {
            this.f826a = str;
            this.f827b = str2;
        }
    }

    private static LegacySaveButtonPartDefinition m842b(InjectorLike injectorLike) {
        return new LegacySaveButtonPartDefinition(SaveButtonUtils.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AngoraCollectionUpdateRequestListener.m717a(injectorLike), FeedEventBus.a(injectorLike), SavedCollectionFeedUnitMutator.b(injectorLike), GraphQLStoryUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), ControllerMutationGatekeepers.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10403), (CollectionSaveLegacyMutationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionSaveLegacyMutationProvider.class));
    }

    public final /* bridge */ /* synthetic */ Object m843a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m839a((SaveButtonProps) obj);
    }

    public final /* bridge */ /* synthetic */ void m844a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1378607703);
        SaveButtonProps saveButtonProps = (SaveButtonProps) obj;
        State state = (State) obj2;
        SaveButton saveButton = (SaveButton) view;
        TrackingNodes.a(saveButton, TrackingNode.SAVE_BUTTON);
        state.f829d = saveButton;
        m841a(state, saveButtonProps.f871a.jn() == GraphQLSavedState.SAVED);
        Logger.a(8, EntryType.MARK_POP, -1780435519, a);
    }

    public static LegacySaveButtonPartDefinition m840a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LegacySaveButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f831n) {
                LegacySaveButtonPartDefinition legacySaveButtonPartDefinition;
                if (a2 != null) {
                    legacySaveButtonPartDefinition = (LegacySaveButtonPartDefinition) a2.a(f831n);
                } else {
                    legacySaveButtonPartDefinition = f830m;
                }
                if (legacySaveButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m842b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f831n, b3);
                        } else {
                            f830m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = legacySaveButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LegacySaveButtonPartDefinition(SaveButtonUtils saveButtonUtils, FbErrorReporter fbErrorReporter, AngoraCollectionUpdateRequestListener angoraCollectionUpdateRequestListener, FeedEventBus feedEventBus, SavedCollectionFeedUnitMutator savedCollectionFeedUnitMutator, GraphQLStoryUtil graphQLStoryUtil, Context context, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Lazy<SavedEventHandler> lazy, CollectionSaveLegacyMutationProvider collectionSaveLegacyMutationProvider) {
        this.f835d = saveButtonUtils;
        this.f832a = fbErrorReporter;
        this.f836e = angoraCollectionUpdateRequestListener;
        this.f833b = feedEventBus;
        this.f834c = savedCollectionFeedUnitMutator;
        this.f837f = graphQLStoryUtil;
        this.f838g = context;
        this.f839h = controllerMutationGatekeepers;
        this.f840i = graphQLQueryExecutor;
        this.f841j = executorService;
        this.f842k = lazy;
        this.f843l = collectionSaveLegacyMutationProvider;
    }

    private State m839a(SaveButtonProps saveButtonProps) {
        Resources resources = this.f838g.getResources();
        final State state = new State(resources.getString(2131233592), resources.getString(2131233593));
        final SaveButtonProps saveButtonProps2 = saveButtonProps;
        state.f828c = new SaveButtonListener(this, this.f835d, this.f832a, this.f836e, this.f833b, this.f834c, this.f837f, this.f838g, this.f839h, this.f840i, this.f841j, this.f842k, this.f843l, saveButtonProps.f871a, saveButtonProps.f872b, saveButtonProps.f873c, saveButtonProps.f874d) {
            final /* synthetic */ LegacySaveButtonPartDefinition f825c;

            protected final void mo42a(boolean z) {
                LegacySaveButtonPartDefinition legacySaveButtonPartDefinition = this.f825c;
                SaveButtonProps saveButtonProps = saveButtonProps2;
                LegacySaveButtonPartDefinition.m841a(state, z);
            }
        };
        return state;
    }

    public static void m841a(State state, boolean z) {
        if (state.f828c.m795b()) {
            int i;
            ImageView imageView = state.f829d.f866a;
            if (z) {
                i = 2130843225;
            } else {
                i = 2130843224;
            }
            imageView.setImageResource(i);
            state.f829d.f866a.setContentDescription(z ? state.f827b : state.f826a);
            state.f829d.setOnClickListener(state.f828c.f729d);
            state.f829d.setVisibility(0);
            return;
        }
        state.f829d.setVisibility(8);
    }
}
