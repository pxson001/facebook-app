package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.popover.PopoverListViewWindow;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.feedplugins.offline.OfflineStoryKey;
import com.facebook.feedplugins.offline.OfflineStoryPersistentState;
import com.facebook.feedplugins.offline.rows.ui.MediaUploadProgressView;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.OfflinePostConfig;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Builder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STICKER_ADDED */
public class MediaUploadProgressPartDefinition<E extends HasPositionInformation & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, MediaUploadProgressView> {
    public static final ViewType f23579a = new C20301();
    public static final Class<?> f23580b = MediaUploadProgressPartDefinition.class;
    private static final PaddingStyle f23581c = PaddingStyle.q;
    private static MediaUploadProgressPartDefinition f23582l;
    private static final Object f23583m = new Object();
    private final BackgroundPartDefinition f23584d;
    public final OfflinePostHeaderController f23585e;
    public final AbstractFbErrorReporter f23586f;
    private final Clock f23587g;
    private final PendingStoryStore f23588h;
    private final QeAccessor f23589i;
    private final OfflinePostConfigCache f23590j;
    private final OptimisticStoryStateCache f23591k;

    /* compiled from: STICKER_ADDED */
    final class C20301 extends ViewType {
        C20301() {
        }

        public final View m25806a(Context context) {
            return new MediaUploadProgressView(context);
        }
    }

    /* compiled from: STICKER_ADDED */
    public class MenuCancelListener implements OnMenuItemClickListener {
        private final OfflinePostHeaderController f23566a;
        public Optional<PendingStory> f23567b;

        public MenuCancelListener(OfflinePostHeaderController offlinePostHeaderController) {
            this.f23566a = offlinePostHeaderController;
        }

        public final boolean m25807a(MenuItem menuItem) {
            if (this.f23567b.isPresent()) {
                GraphQLStory a = ((PendingStory) this.f23567b.get()).a();
                if (2131568618 == menuItem.getItemId()) {
                    this.f23566a.m4436a(a);
                } else if (2131568619 == menuItem.getItemId()) {
                    OfflinePostHeaderController offlinePostHeaderController = this.f23566a;
                    UploadOperation d = ((UploadManager) offlinePostHeaderController.f3790d.get()).d(a.T());
                    if (d != null) {
                        Builder builder = new Builder(d);
                        builder.U = offlinePostHeaderController.f3793g.a(ExperimentsForComposerAbTestModule.Y, -1);
                        builder.aa = true;
                        ((UploadManager) offlinePostHeaderController.f3790d.get()).d(builder.a());
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: STICKER_ADDED */
    public class MenuOnClickListener implements OnClickListener {
        private final QeAccessor f23568a;
        private final GraphQLStory f23569b;
        private final PendingStoryStore f23570c;

        public MenuOnClickListener(QeAccessor qeAccessor, GraphQLStory graphQLStory, PendingStoryStore pendingStoryStore) {
            this.f23568a = qeAccessor;
            this.f23569b = graphQLStory;
            this.f23570c = pendingStoryStore;
        }

        public void onClick(View view) {
            PopoverMenuWindow popoverMenuWindow;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1970250247);
            MediaUploadProgressView mediaUploadProgressView = (MediaUploadProgressView) view.getParent().getParent();
            PopoverListViewWindow popoverListViewWindow = mediaUploadProgressView.f23703g;
            boolean z = StoryAttachmentHelper.j(this.f23569b) && this.f23568a.a(ExperimentsForComposerAbTestModule.X, false);
            if (popoverListViewWindow == null) {
                popoverListViewWindow = new PopoverListViewWindow(view.getContext());
                if (z) {
                    popoverListViewWindow.b(2131820552);
                } else {
                    popoverListViewWindow.b(2131820551);
                }
                mediaUploadProgressView.f23703g = popoverListViewWindow;
                popoverMenuWindow = popoverListViewWindow;
            } else {
                popoverMenuWindow = popoverListViewWindow;
            }
            if (z) {
                boolean z2;
                MenuItem findItem = popoverMenuWindow.c().findItem(2131568619);
                findItem.setTitle(this.f23568a.a(ExperimentsForComposerAbTestModule.Z, String.valueOf(findItem.getTitle())));
                Optional d = this.f23570c.d(this.f23569b.T());
                if (d.isPresent() && ((PendingStory) d.get()).c.k) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                findItem.setEnabled(z2);
            }
            popoverMenuWindow.p = mediaUploadProgressView.f23706j;
            if (popoverMenuWindow.r) {
                popoverMenuWindow.l();
            } else {
                popoverMenuWindow.f((GlyphView) view);
            }
            LogUtils.a(1420749435, a);
        }
    }

    /* compiled from: STICKER_ADDED */
    public class MenuOnTouchListener implements OnTouchListener {
        public int f23571a;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            GlyphView glyphView = (GlyphView) view;
            if (motionEvent.getAction() == 0) {
                glyphView.setGlyphColor(this.f23571a);
            } else if (1 == motionEvent.getAction()) {
                glyphView.setGlyphColor(null);
            }
            return false;
        }
    }

    /* compiled from: STICKER_ADDED */
    public class State {
        public final OfflineStoryPersistentState f23572a;
        public final MenuCancelListener f23573b;
        public final MenuOnClickListener f23574c;
        public final MenuOnTouchListener f23575d;
        public final Optional<PendingStory> f23576e;
        public final FutureCallback<GraphQLStory> f23577f;
        public final FutureCallback<GraphQLStory> f23578g;

        public State(OfflineStoryPersistentState offlineStoryPersistentState, MenuCancelListener menuCancelListener, MenuOnClickListener menuOnClickListener, MenuOnTouchListener menuOnTouchListener, Optional<PendingStory> optional, FutureCallback<GraphQLStory> futureCallback, FutureCallback<GraphQLStory> futureCallback2) {
            this.f23572a = offlineStoryPersistentState;
            this.f23573b = menuCancelListener;
            this.f23574c = menuOnClickListener;
            this.f23575d = menuOnTouchListener;
            this.f23576e = optional;
            this.f23577f = futureCallback;
            this.f23578g = futureCallback2;
        }
    }

    private static MediaUploadProgressPartDefinition m25811b(InjectorLike injectorLike) {
        return new MediaUploadProgressPartDefinition(BackgroundPartDefinition.a(injectorLike), OfflinePostHeaderController.m4432a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PendingStoryStore.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), OfflinePostConfigCache.a(injectorLike), OptimisticStoryStateCache.a(injectorLike));
    }

    public final Object m25813a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23584d, new StylingData(feedProps, f23581c));
        FutureCallback a = m25809a((HasInvalidate) hasPositionInformation);
        FutureCallback a2 = m25809a((HasInvalidate) hasPositionInformation);
        OfflineStoryPersistentState offlineStoryPersistentState = (OfflineStoryPersistentState) ((HasPersistentState) hasPositionInformation).a(new OfflineStoryKey(graphQLStory), graphQLStory);
        Optional d = this.f23588h.d(graphQLStory.T());
        return new State(offlineStoryPersistentState, new MenuCancelListener(this.f23585e), new MenuOnClickListener(this.f23589i, graphQLStory, this.f23588h), new MenuOnTouchListener(), d, a, a2);
    }

    public final boolean m25815a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (!StoryAttachmentHelper.j(graphQLStory) && !StoryAttachmentHelper.l(graphQLStory)) {
            return false;
        }
        GraphQLFeedOptimisticPublishState a = this.f23591k.a(graphQLStory);
        if (a == GraphQLFeedOptimisticPublishState.DELETED || a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return false;
        }
        Optional d = this.f23588h.d(graphQLStory.T());
        if (d.isPresent()) {
            return a != GraphQLFeedOptimisticPublishState.SUCCESS && ((PendingStory) d.get()).a(this.f23587g.a()) < 1000;
        } else {
            if (a != GraphQLFeedOptimisticPublishState.SUCCESS) {
                this.f23585e.m4437a(graphQLStory, 3000);
            }
            return false;
        }
    }

    public final void m25816b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FeedProps feedProps = (FeedProps) obj;
        MediaUploadProgressView mediaUploadProgressView = (MediaUploadProgressView) view;
        if (mediaUploadProgressView.f23703g != null) {
            mediaUploadProgressView.f23703g.p = null;
        }
        mediaUploadProgressView.f23704h.setOnClickListener(null);
        mediaUploadProgressView.f23704h.setOnTouchListener(null);
        OfflinePostConfig a = this.f23590j.a((GraphQLStory) feedProps.a);
        a.b = 0;
        a.a = true;
    }

    public static MediaUploadProgressPartDefinition m25808a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaUploadProgressPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23583m) {
                MediaUploadProgressPartDefinition mediaUploadProgressPartDefinition;
                if (a2 != null) {
                    mediaUploadProgressPartDefinition = (MediaUploadProgressPartDefinition) a2.a(f23583m);
                } else {
                    mediaUploadProgressPartDefinition = f23582l;
                }
                if (mediaUploadProgressPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25811b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23583m, b3);
                        } else {
                            f23582l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaUploadProgressPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m25810a(FeedProps<GraphQLStory> feedProps, State state, E e, MediaUploadProgressView mediaUploadProgressView) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (state.f23576e.isPresent()) {
            state.f23573b.f23567b = state.f23576e;
            MenuCancelListener menuCancelListener = state.f23573b;
            OnTouchListener onTouchListener = state.f23575d;
            OnClickListener onClickListener = state.f23574c;
            Optional optional = state.f23576e;
            menuCancelListener.f23567b = optional;
            mediaUploadProgressView.f23706j = menuCancelListener;
            mediaUploadProgressView.f23705i = optional;
            onTouchListener.f23571a = mediaUploadProgressView.getResources().getColor(17170444);
            mediaUploadProgressView.f23704h.setOnClickListener(onClickListener);
            mediaUploadProgressView.f23704h.setOnTouchListener(onTouchListener);
            mediaUploadProgressView.setVisibility(0);
            mediaUploadProgressView.f23699c = state.f23578g;
            if (state.f23572a.f23557a) {
                ((PendingStory) state.f23576e.get()).b(this.f23587g.a());
                ((HasInvalidate) e).hL_();
                return;
            }
            OfflinePostConfig a = this.f23590j.a(graphQLStory);
            WeakReference weakReference = new WeakReference(mediaUploadProgressView);
            this.f23585e.m4439a(graphQLStory, weakReference, 3000);
            a.b = weakReference.hashCode();
            if (state.f23576e.isPresent()) {
                mediaUploadProgressView.setProgress(((PendingStory) state.f23576e.get()).a(this.f23587g.a()));
                return;
            }
            return;
        }
        mediaUploadProgressView.f23700d = state.f23577f;
    }

    @Inject
    public MediaUploadProgressPartDefinition(BackgroundPartDefinition backgroundPartDefinition, OfflinePostHeaderController offlinePostHeaderController, AbstractFbErrorReporter abstractFbErrorReporter, Clock clock, PendingStoryStore pendingStoryStore, QeAccessor qeAccessor, OfflinePostConfigCache offlinePostConfigCache, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f23584d = backgroundPartDefinition;
        this.f23585e = offlinePostHeaderController;
        this.f23586f = abstractFbErrorReporter;
        this.f23587g = clock;
        this.f23588h = pendingStoryStore;
        this.f23589i = qeAccessor;
        this.f23590j = offlinePostConfigCache;
        this.f23591k = optimisticStoryStateCache;
    }

    public final ViewType m25812a() {
        return f23579a;
    }

    private FutureCallback<GraphQLStory> m25809a(final HasInvalidate hasInvalidate) {
        return new FutureCallback<GraphQLStory>(this) {
            final /* synthetic */ MediaUploadProgressPartDefinition f23565b;

            public void onSuccess(Object obj) {
                hasInvalidate.hL_();
            }

            public void onFailure(Throwable th) {
                this.f23565b.f23586f.a(MediaUploadProgressPartDefinition.f23580b.toString(), "Unexpected Error in Offline Progress", th);
            }
        };
    }
}
