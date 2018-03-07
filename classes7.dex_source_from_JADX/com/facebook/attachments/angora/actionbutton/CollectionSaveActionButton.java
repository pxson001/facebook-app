package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.components.fb.view.ComponentViewTagFinder;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.SavedCollectionFeedUnitMutator;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.nux.NuxBubbleManager.Nux;
import com.facebook.nux.interstitial.SaveNuxBubbleDelegate;
import com.facebook.saved.common.sync.SavedEventHandler;
import com.google.common.base.Optional;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: verifiedViewCount( */
public class CollectionSaveActionButton<E extends HasInvalidate> implements AngoraActionButton<E> {
    private static final SparseArray<Object> f754a = new C00711(1);
    private static final String f755b = CollectionSaveActionButton.class.getSimpleName();
    private static CollectionSaveActionButton f756x;
    private static final Object f757y = new Object();
    public final FeedNuxBubbleManager f758c;
    public final OnClickListener f759d = new C00722(this);
    private final Provider<SaveNuxBubbleDelegate> f760e;
    private final SaveButtonUtils f761f;
    private final PendingStoryStore f762g;
    private final AbstractFbErrorReporter f763h;
    public final FlatSaveButtonPartDefinition f764i;
    private final SinglePartDefinition f765j;
    private final OptimisticStoryStateCache f766k;
    private final FeedEventBus f767l;
    private final SavedCollectionFeedUnitMutator f768m;
    private final AngoraCollectionUpdateRequestListener f769n;
    private final GraphQLStoryUtil f770o;
    private final ActionButtonComponent f771p;
    private final SinglePartDefinition f772q;
    public final DefaultAndroidThreadUtil f773r;
    private final ControllerMutationGatekeepers f774s;
    private final GraphQLQueryExecutor f775t;
    private final ExecutorService f776u;
    private final Lazy<SavedEventHandler> f777v;
    private final CollectionSaveLegacyMutationProvider f778w;

    /* compiled from: verifiedViewCount( */
    final class C00711 extends SparseArray<Object> {
        C00711(int i) {
            super(i);
            append(2131558647, Boolean.valueOf(true));
        }
    }

    /* compiled from: verifiedViewCount( */
    class C00722 implements OnClickListener {
        final /* synthetic */ CollectionSaveActionButton f725a;

        C00722(CollectionSaveActionButton collectionSaveActionButton) {
            this.f725a = collectionSaveActionButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 986553375);
            this.f725a.f758c.a();
            Logger.a(2, EntryType.UI_INPUT_END, 134186351, a);
        }
    }

    /* compiled from: verifiedViewCount( */
    public class CollectionSaveActionButtonComponentPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, ComponentView> {
        public final /* synthetic */ CollectionSaveActionButton f752a;

        public CollectionSaveActionButtonComponentPartDefinition(CollectionSaveActionButton collectionSaveActionButton) {
            this.f752a = collectionSaveActionButton;
        }

        public final /* bridge */ /* synthetic */ void m797a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, -67763212);
            final FeedProps feedProps = (FeedProps) obj;
            final ComponentView componentView = (ComponentView) view;
            this.f752a.f773r.b(new Runnable(this) {
                final /* synthetic */ CollectionSaveActionButtonComponentPartDefinition f751c;

                public void run() {
                    CollectionSaveActionButton.m806a(this.f751c.f752a, ComponentViewTagFinder.m1264a(componentView, 2131558647), feedProps);
                }
            });
            Logger.a(8, EntryType.MARK_POP, 734959861, a);
        }

        public final void m798b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            this.f752a.f758c.a(ComponentViewTagFinder.m1264a((ComponentView) view, 2131558647));
        }
    }

    /* compiled from: verifiedViewCount( */
    class CollectionsSaveActionButtonPartDefinition<V extends View & AttachmentHasButton> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
        final /* synthetic */ CollectionSaveActionButton f753a;

        public CollectionsSaveActionButtonPartDefinition(CollectionSaveActionButton collectionSaveActionButton) {
            this.f753a = collectionSaveActionButton;
        }

        public final Object m800a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            FeedProps feedProps = (FeedProps) obj;
            subParts.a(this.f753a.f764i, new SaveButtonProps(CollectionSaveActionButton.m808b((GraphQLStoryAttachment) feedProps.a), CurationSurface.NATIVE_STORY, AttachmentProps.e(feedProps), this.f753a.f759d, true));
            return null;
        }

        public final /* bridge */ /* synthetic */ void m801a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, 945778092);
            m799a((FeedProps) obj, view);
            Logger.a(8, EntryType.MARK_POP, -155638848, a);
        }

        private void m799a(FeedProps<GraphQLStoryAttachment> feedProps, V v) {
            CollectionSaveActionButton.m806a(this.f753a, ((AttachmentHasButton) v).getActionButton(), (FeedProps) feedProps);
        }

        public final void m802b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            this.f753a.f758c.a(((AttachmentHasButton) view).getActionButton());
        }
    }

    private static CollectionSaveActionButton m807b(InjectorLike injectorLike) {
        return new CollectionSaveActionButton(FeedNuxBubbleManager.a(injectorLike), IdBasedProvider.a(injectorLike, 2848), SaveButtonUtils.a(injectorLike), PendingStoryStore.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FlatSaveButtonPartDefinition.m819a(injectorLike), OptimisticStoryStateCache.a(injectorLike), AngoraCollectionUpdateRequestListener.m717a(injectorLike), FeedEventBus.a(injectorLike), SavedCollectionFeedUnitMutator.a(injectorLike), GraphQLStoryUtil.a(injectorLike), ActionButtonComponent.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), ControllerMutationGatekeepers.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10403), (CollectionSaveLegacyMutationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionSaveLegacyMutationProvider.class));
    }

    public static CollectionSaveActionButton m803a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CollectionSaveActionButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f757y) {
                CollectionSaveActionButton collectionSaveActionButton;
                if (a2 != null) {
                    collectionSaveActionButton = (CollectionSaveActionButton) a2.a(f757y);
                } else {
                    collectionSaveActionButton = f756x;
                }
                if (collectionSaveActionButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m807b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f757y, b3);
                        } else {
                            f756x = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = collectionSaveActionButton;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CollectionSaveActionButton(FeedNuxBubbleManager feedNuxBubbleManager, Provider<SaveNuxBubbleDelegate> provider, SaveButtonUtils saveButtonUtils, PendingStoryStore pendingStoryStore, FbErrorReporter fbErrorReporter, FlatSaveButtonPartDefinition flatSaveButtonPartDefinition, OptimisticStoryStateCache optimisticStoryStateCache, AngoraCollectionUpdateRequestListener angoraCollectionUpdateRequestListener, FeedEventBus feedEventBus, SavedCollectionFeedUnitMutator savedCollectionFeedUnitMutator, GraphQLStoryUtil graphQLStoryUtil, ActionButtonComponent actionButtonComponent, AndroidThreadUtil androidThreadUtil, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Lazy<SavedEventHandler> lazy, CollectionSaveLegacyMutationProvider collectionSaveLegacyMutationProvider) {
        this.f758c = feedNuxBubbleManager;
        this.f760e = provider;
        this.f761f = saveButtonUtils;
        this.f762g = pendingStoryStore;
        this.f763h = fbErrorReporter;
        this.f764i = flatSaveButtonPartDefinition;
        this.f765j = new CollectionsSaveActionButtonPartDefinition(this);
        this.f766k = optimisticStoryStateCache;
        this.f769n = angoraCollectionUpdateRequestListener;
        this.f767l = feedEventBus;
        this.f768m = savedCollectionFeedUnitMutator;
        this.f770o = graphQLStoryUtil;
        this.f771p = actionButtonComponent;
        this.f772q = new CollectionSaveActionButtonComponentPartDefinition(this);
        this.f773r = androidThreadUtil;
        this.f774s = controllerMutationGatekeepers;
        this.f775t = graphQLQueryExecutor;
        this.f776u = executorService;
        this.f777v = lazy;
        this.f778w = collectionSaveLegacyMutationProvider;
    }

    public final <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> m810a() {
        return this.f765j;
    }

    private Component m804a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLNode b = m808b((GraphQLStoryAttachment) feedProps.a());
        Object obj = b.jn() == GraphQLSavedState.SAVED ? 1 : null;
        final E e2 = e;
        final FeedProps<GraphQLStoryAttachment> feedProps2 = feedProps;
        return this.f771p.a(componentContext).m732a(true).m737j(obj != null ? 2130843225 : 2130843224).m738k(0).m739l(obj != null ? 2131233593 : 2131233592).m729a(f754a).m730a(new SaveButtonListener(this, this.f761f, this.f763h, this.f769n, this.f767l, this.f768m, this.f770o, componentContext, this.f774s, this.f775t, this.f776u, this.f777v, this.f778w, b, CurationSurface.NATIVE_STORY, AttachmentProps.e(feedProps), this.f759d) {
            final /* synthetic */ CollectionSaveActionButton f748c;

            protected final void mo42a(boolean z) {
                e2.a(new FeedProps[]{feedProps2});
            }
        }.f729d).d();
    }

    public final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> m811b() {
        return this.f772q;
    }

    @Nullable
    public static GraphQLNode m808b(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, -908457779);
        return a == null ? null : a.J();
    }

    public static void m806a(CollectionSaveActionButton collectionSaveActionButton, View view, FeedProps feedProps) {
        if (AttachmentProps.c(feedProps) != null) {
            GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -908457779);
            if (a == null || a.J() == null || a.J().gK() == null || a.J().gK().n() == null) {
                collectionSaveActionButton.f763h.b(f755b, "Missing information in SaveActionLink");
                return;
            }
            GraphQLStory c = AttachmentProps.c(feedProps);
            Optional d = collectionSaveActionButton.f762g.d(c.T());
            if (collectionSaveActionButton.f766k.a(c) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                collectionSaveActionButton.m805a(view, a);
            } else if (collectionSaveActionButton.f766k.a(c) != GraphQLFeedOptimisticPublishState.SUCCESS) {
            } else {
                if (!d.isPresent() || !((PendingStory) d.get()).f()) {
                    collectionSaveActionButton.m805a(view, a);
                }
            }
        }
    }

    private void m805a(View view, GraphQLStoryActionLink graphQLStoryActionLink) {
        SaveNuxBubbleDelegate saveNuxBubbleDelegate = (SaveNuxBubbleDelegate) this.f760e.get();
        saveNuxBubbleDelegate.b = new SaveNuxItemInfo(graphQLStoryActionLink);
        this.f758c.a(new Nux(2130904333, graphQLStoryActionLink.J().gK().n(), view, saveNuxBubbleDelegate, true, 17));
    }
}
