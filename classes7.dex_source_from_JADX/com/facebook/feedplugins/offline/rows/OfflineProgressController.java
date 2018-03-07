package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
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
/* compiled from: START_UPLOAD_CONTACTS */
public class OfflineProgressController {
    private static OfflineProgressController f23629h;
    private static final Object f23630i = new Object();
    private final QeAccessor f23631a;
    private final OptimisticStoryStateCache f23632b;
    private final PendingStoryStore f23633c;
    private final OfflinePostHeaderController f23634d;
    private final Clock f23635e;
    public final SecureContextHelper f23636f;
    private final OfflineFailedController f23637g;

    /* compiled from: START_UPLOAD_CONTACTS */
    public class C20371 implements OnClickListener {
        final /* synthetic */ GraphQLStory f23627a;
        final /* synthetic */ OfflineProgressController f23628b;

        public C20371(OfflineProgressController offlineProgressController, GraphQLStory graphQLStory) {
            this.f23628b = offlineProgressController;
            this.f23627a = graphQLStory;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -663386928);
            if (OfflineProgressController.m25846a(this.f23627a)) {
                Logger.a(2, EntryType.UI_INPUT_END, -298333600, a);
                return;
            }
            Context context = view.getContext();
            this.f23628b.f23636f.a(CompostActivity.a(context, CompostSourceType.OPTIMISTIC_STORY), context);
            LogUtils.a(-1689411695, a);
        }
    }

    private static OfflineProgressController m25847b(InjectorLike injectorLike) {
        return new OfflineProgressController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), PendingStoryStore.a(injectorLike), OfflinePostHeaderController.m4432a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), OfflineFailedController.m25817a(injectorLike));
    }

    @Inject
    public OfflineProgressController(QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, PendingStoryStore pendingStoryStore, OfflinePostHeaderController offlinePostHeaderController, Clock clock, SecureContextHelper secureContextHelper, OfflineFailedController offlineFailedController) {
        this.f23631a = qeAccessor;
        this.f23632b = optimisticStoryStateCache;
        this.f23633c = pendingStoryStore;
        this.f23634d = offlinePostHeaderController;
        this.f23635e = clock;
        this.f23636f = secureContextHelper;
        this.f23637g = offlineFailedController;
    }

    public static OfflineProgressController m25844a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineProgressController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23630i) {
                OfflineProgressController offlineProgressController;
                if (a2 != null) {
                    offlineProgressController = (OfflineProgressController) a2.a(f23630i);
                } else {
                    offlineProgressController = f23629h;
                }
                if (offlineProgressController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25847b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23630i, b3);
                        } else {
                            f23629h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineProgressController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m25846a(GraphQLStory graphQLStory) {
        return !StoryAttachmentHelper.b(graphQLStory);
    }

    public final boolean m25850a(GraphQLStory graphQLStory, boolean z) {
        if (m25846a(graphQLStory)) {
            if (z) {
                return false;
            }
            return m25848b(graphQLStory, z);
        } else if (z && !m25845a()) {
            return false;
        } else {
            if (z || !m25845a()) {
                return m25848b(graphQLStory, z);
            }
            return false;
        }
    }

    @VisibleForTesting
    private boolean m25848b(GraphQLStory graphQLStory, boolean z) {
        Object obj = (StoryAttachmentHelper.j(graphQLStory) || StoryAttachmentHelper.l(graphQLStory)) ? 1 : null;
        if (obj != null) {
            return false;
        }
        GraphQLFeedOptimisticPublishState a = this.f23632b.a(graphQLStory);
        Optional d = this.f23633c.d(graphQLStory.T());
        if (a == GraphQLFeedOptimisticPublishState.DELETED || a == GraphQLFeedOptimisticPublishState.RETRYING_IN_BACKGROUND || a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return false;
        }
        if (!d.isPresent()) {
            if (a != GraphQLFeedOptimisticPublishState.SUCCESS) {
                m25849d(graphQLStory);
            }
            return false;
        } else if (a != GraphQLFeedOptimisticPublishState.POSTING || ((PendingStory) d.get()).d()) {
            return (a == GraphQLFeedOptimisticPublishState.SUCCESS || this.f23637g.m25821a(graphQLStory, z) || (!z && (!((PendingStory) d.get()).d() || ((PendingStory) d.get()).a(this.f23635e.a()) >= 1000))) ? false : true;
        } else {
            m25849d(graphQLStory);
            return false;
        }
    }

    private boolean m25845a() {
        return this.f23631a.a(ExperimentsForCompostAbTestModule.A, false);
    }

    private void m25849d(GraphQLStory graphQLStory) {
        this.f23634d.m4437a(graphQLStory, 3000);
    }
}
