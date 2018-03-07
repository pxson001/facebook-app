package com.facebook.graphql.executor.iface;

import com.facebook.api.feedcache.memory.CommentCreateCacheVisitorFactory;
import com.facebook.api.feedcache.memory.ReactionsMutateCacheVisitorFactory;
import com.facebook.api.feedcache.memory.visitor.AddCommentCacheVisitorProvider;
import com.facebook.api.feedcache.memory.visitor.ReactionsMutateCacheVisitorProvider;
import com.facebook.feed.server.QuestionAddPollCacheVisitorFactory;
import com.facebook.feed.server.QuestionMutationCacheVisitorProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$CustomMutationVisitorFactory implements MultiBindIndexedProvider<CustomMutationVisitorFactory>, Provider<Set<CustomMutationVisitorFactory>> {
    private final InjectorLike f8394a;

    public STATICDI_MULTIBIND_PROVIDER$CustomMutationVisitorFactory(InjectorLike injectorLike) {
        this.f8394a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8394a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CommentCreateCacheVisitorFactory((AddCommentCacheVisitorProvider) injector.getOnDemandAssistedProviderForStaticDi(AddCommentCacheVisitorProvider.class));
            case 1:
                return new ReactionsMutateCacheVisitorFactory((ReactionsMutateCacheVisitorProvider) injector.getOnDemandAssistedProviderForStaticDi(ReactionsMutateCacheVisitorProvider.class));
            case 2:
                return new QuestionAddPollCacheVisitorFactory((QuestionMutationCacheVisitorProvider) injector.getOnDemandAssistedProviderForStaticDi(QuestionMutationCacheVisitorProvider.class));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
