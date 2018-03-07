package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.SecurePendingIntent;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.progresspage.CompostActivity;
import com.facebook.photos.upload.progresspage.CompostSourceType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STICKERS */
public class OfflineFailedController {
    private static OfflineFailedController f23595f;
    private static final Object f23596g = new Object();
    private final QeAccessor f23597a;
    private final PendingStoryStore f23598b;
    private final OptimisticStoryStateCache f23599c;
    public final OfflinePostHeaderController f23600d;
    public final AbstractFbErrorReporter f23601e;

    /* compiled from: STICKERS */
    public class C20332 implements OnClickListener {
        final /* synthetic */ OfflineFailedController f23594a;

        public C20332(OfflineFailedController offlineFailedController) {
            this.f23594a = offlineFailedController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 153723934);
            Context context = view.getContext();
            try {
                SecurePendingIntent.a(context, 0, CompostActivity.a(context, CompostSourceType.OPTIMISTIC_STORY), 0).send();
            } catch (Exception e) {
                this.f23594a.f23601e.a("OfflineProgressController", e.getMessage());
            }
            LogUtils.a(1089353372, a);
        }
    }

    private static OfflineFailedController m25818b(InjectorLike injectorLike) {
        return new OfflineFailedController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PendingStoryStore.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), OfflinePostHeaderController.m4432a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public OfflineFailedController(QeAccessor qeAccessor, PendingStoryStore pendingStoryStore, OptimisticStoryStateCache optimisticStoryStateCache, OfflinePostHeaderController offlinePostHeaderController, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f23597a = qeAccessor;
        this.f23598b = pendingStoryStore;
        this.f23599c = optimisticStoryStateCache;
        this.f23600d = offlinePostHeaderController;
        this.f23601e = abstractFbErrorReporter;
    }

    public final boolean m25821a(GraphQLStory graphQLStory, boolean z) {
        if (!OfflineProgressController.m25846a(graphQLStory)) {
            boolean a = this.f23597a.a(ExperimentsForCompostAbTestModule.A, false);
            if (z && !a) {
                return false;
            }
            if (z || !a) {
                return m25819b(graphQLStory);
            }
            return false;
        } else if (z) {
            return false;
        } else {
            return m25819b(graphQLStory);
        }
    }

    public static OfflineFailedController m25817a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineFailedController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23596g) {
                OfflineFailedController offlineFailedController;
                if (a2 != null) {
                    offlineFailedController = (OfflineFailedController) a2.a(f23596g);
                } else {
                    offlineFailedController = f23595f;
                }
                if (offlineFailedController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25818b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23596g, b3);
                        } else {
                            f23595f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineFailedController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final OnClickListener m25820a(final GraphQLStory graphQLStory) {
        return new OnClickListener(this) {
            final /* synthetic */ OfflineFailedController f23593b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1740587184);
                this.f23593b.f23600d.m4436a(graphQLStory);
                Logger.a(2, EntryType.UI_INPUT_END, -156398110, a);
            }
        };
    }

    @VisibleForTesting
    private boolean m25819b(GraphQLStory graphQLStory) {
        if (StoryAttachmentHelper.j(graphQLStory)) {
            return false;
        }
        Optional d = this.f23598b.d(graphQLStory.T());
        return (this.f23599c.a(graphQLStory) != GraphQLFeedOptimisticPublishState.FAILED || !d.isPresent() || ((PendingStory) d.get()).b().b() == null || ((PendingStory) d.get()).b().b().isRetriable || ((PendingStory) d.get()).f()) ? false : true;
    }
}
