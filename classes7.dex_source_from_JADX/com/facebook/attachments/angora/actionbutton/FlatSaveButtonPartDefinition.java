package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.SavedCollectionFeedUnitMutator;
import com.facebook.fbui.widget.text.GlyphWithTextView;
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
import com.facebook.saved.common.sync.SavedEventHandler;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vbox */
public class FlatSaveButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<SaveButtonProps, State, AnyEnvironment, V> {
    private static FlatSaveButtonPartDefinition f795m;
    private static final Object f796n = new Object();
    private final AbstractFbErrorReporter f797a;
    private final FeedEventBus f798b;
    private final SavedCollectionFeedUnitMutator f799c;
    private final SaveButtonUtils f800d;
    private final AngoraCollectionUpdateRequestListener f801e;
    private final GraphQLStoryUtil f802f;
    private final Context f803g;
    private final ControllerMutationGatekeepers f804h;
    private final GraphQLQueryExecutor f805i;
    private final ExecutorService f806j;
    private final Lazy<SavedEventHandler> f807k;
    private final CollectionSaveLegacyMutationProvider f808l;

    /* compiled from: vbox */
    public class State {
        public final String f791a;
        public final String f792b;
        public SaveButtonListener f793c;
        public GenericActionButtonView f794d;

        public State(String str, String str2) {
            this.f791a = str;
            this.f792b = str2;
        }
    }

    private static FlatSaveButtonPartDefinition m822b(InjectorLike injectorLike) {
        return new FlatSaveButtonPartDefinition(SaveButtonUtils.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AngoraCollectionUpdateRequestListener.m717a(injectorLike), FeedEventBus.a(injectorLike), SavedCollectionFeedUnitMutator.b(injectorLike), GraphQLStoryUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), ControllerMutationGatekeepers.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10403), (CollectionSaveLegacyMutationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionSaveLegacyMutationProvider.class));
    }

    public final /* bridge */ /* synthetic */ void m824a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 339015143);
        m820a((SaveButtonProps) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -656089885, a);
    }

    public final void m825b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((State) obj2).f794d = null;
        if (((AttachmentHasButton) view).getActionButton() != null) {
            ((AttachmentHasButton) view).getActionButton().a();
        }
    }

    public static FlatSaveButtonPartDefinition m819a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FlatSaveButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f796n) {
                FlatSaveButtonPartDefinition flatSaveButtonPartDefinition;
                if (a2 != null) {
                    flatSaveButtonPartDefinition = (FlatSaveButtonPartDefinition) a2.a(f796n);
                } else {
                    flatSaveButtonPartDefinition = f795m;
                }
                if (flatSaveButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m822b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f796n, b3);
                        } else {
                            f795m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = flatSaveButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FlatSaveButtonPartDefinition(SaveButtonUtils saveButtonUtils, FbErrorReporter fbErrorReporter, AngoraCollectionUpdateRequestListener angoraCollectionUpdateRequestListener, FeedEventBus feedEventBus, SavedCollectionFeedUnitMutator savedCollectionFeedUnitMutator, GraphQLStoryUtil graphQLStoryUtil, Context context, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Lazy<SavedEventHandler> lazy, CollectionSaveLegacyMutationProvider collectionSaveLegacyMutationProvider) {
        this.f800d = saveButtonUtils;
        this.f797a = fbErrorReporter;
        this.f801e = angoraCollectionUpdateRequestListener;
        this.f798b = feedEventBus;
        this.f799c = savedCollectionFeedUnitMutator;
        this.f802f = graphQLStoryUtil;
        this.f803g = context;
        this.f804h = controllerMutationGatekeepers;
        this.f806j = executorService;
        this.f805i = graphQLQueryExecutor;
        this.f807k = lazy;
        this.f808l = collectionSaveLegacyMutationProvider;
    }

    private State m818a(SaveButtonProps saveButtonProps) {
        Resources resources = this.f803g.getResources();
        final State state = new State(resources.getString(2131233592), resources.getString(2131233593));
        final SaveButtonProps saveButtonProps2 = saveButtonProps;
        state.f793c = new SaveButtonListener(this, this.f800d, this.f797a, this.f801e, this.f798b, this.f799c, this.f802f, this.f803g, this.f804h, this.f805i, this.f806j, this.f807k, this.f808l, saveButtonProps.f871a, saveButtonProps.f872b, saveButtonProps.f873c, saveButtonProps.f874d) {
            final /* synthetic */ FlatSaveButtonPartDefinition f790c;

            protected final void mo42a(boolean z) {
                FlatSaveButtonPartDefinition flatSaveButtonPartDefinition = this.f790c;
                FlatSaveButtonPartDefinition.m821a(saveButtonProps2, state, z);
            }
        };
        return state;
    }

    private void m820a(SaveButtonProps saveButtonProps, State state, V v) {
        TrackingNodes.a(v, TrackingNode.SAVE_BUTTON);
        state.f794d = ((AttachmentHasButton) v).getActionButton();
        m821a(saveButtonProps, state, saveButtonProps.f871a.jn() == GraphQLSavedState.SAVED);
    }

    public static void m821a(SaveButtonProps saveButtonProps, State state, boolean z) {
        if (state.f793c.m795b()) {
            state.f794d.setVisibility(0);
            state.f794d.g = saveButtonProps.f875e;
            state.f794d.setPadding(0, 0, 0, 0);
            GlyphWithTextView glyphWithTextView = state.f794d.a;
            glyphWithTextView.setCompoundDrawablePadding(0);
            glyphWithTextView.setOnClickListener(state.f793c.f729d);
            glyphWithTextView.setImageResource(z ? 2130843225 : 2130843224);
            glyphWithTextView.setContentDescription(z ? state.f792b : state.f791a);
            return;
        }
        state.f794d.setVisibility(8);
    }
}
