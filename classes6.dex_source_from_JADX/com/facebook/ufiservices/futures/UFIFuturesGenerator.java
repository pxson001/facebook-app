package com.facebook.ufiservices.futures;

import android.content.Context;
import android.os.Bundle;
import com.facebook.api.ufiservices.AddPhotoAttachmentParams;
import com.facebook.api.ufiservices.common.AddCommentParams.Builder;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: current_location_prediction */
public class UFIFuturesGenerator {
    private static UFIFuturesGenerator f18232f;
    private static final Object f18233g = new Object();
    private final GraphQLActorCacheImpl f18234a;
    private final DefaultBlueServiceOperationFactory f18235b;
    private final Provider<ViewerContext> f18236c;
    public final FeedbackGraphQLGenerator f18237d;
    public final QuickPerformanceLogger f18238e;

    /* compiled from: current_location_prediction */
    /* synthetic */ class C13353 {
        static final /* synthetic */ int[] f18231a = new int[MediaType.values().length];

        static {
            try {
                f18231a[MediaType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18231a[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18231a[MediaType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static UFIFuturesGenerator m26752b(InjectorLike injectorLike) {
        return new UFIFuturesGenerator(GraphQLActorCacheImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 372), FeedbackGraphQLGenerator.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UFIFuturesGenerator(GraphQLActorCache graphQLActorCache, BlueServiceOperationFactory blueServiceOperationFactory, Provider<ViewerContext> provider, FeedbackGraphQLGenerator feedbackGraphQLGenerator, QuickPerformanceLogger quickPerformanceLogger) {
        this.f18234a = graphQLActorCache;
        this.f18235b = blueServiceOperationFactory;
        this.f18236c = provider;
        this.f18237d = feedbackGraphQLGenerator;
        this.f18238e = quickPerformanceLogger;
    }

    public final ListenableFuture<GraphQLComment> m26754a(final String str, PendingCommentInputEntry pendingCommentInputEntry, Builder builder, boolean z) {
        this.f18238e.e(3735581, str.hashCode());
        ListenableFuture<GraphQLComment> b = m26753b(str, pendingCommentInputEntry, builder, z);
        Futures.a(b, new FutureCallback<GraphQLComment>(this) {
            final /* synthetic */ UFIFuturesGenerator f18227b;

            public void onSuccess(@Nullable Object obj) {
                if (((GraphQLComment) obj) == null) {
                    this.f18227b.f18238e.b(3735581, str.hashCode(), (short) 160);
                } else {
                    this.f18227b.f18238e.b(3735581, str.hashCode(), (short) 2);
                }
            }

            public void onFailure(Throwable th) {
                this.f18227b.f18238e.b(3735581, str.hashCode(), (short) 3);
            }
        }, MoreExecutors.a());
        return b;
    }

    public static UFIFuturesGenerator m26751a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UFIFuturesGenerator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18233g) {
                UFIFuturesGenerator uFIFuturesGenerator;
                if (a2 != null) {
                    uFIFuturesGenerator = (UFIFuturesGenerator) a2.a(f18233g);
                } else {
                    uFIFuturesGenerator = f18232f;
                }
                if (uFIFuturesGenerator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26752b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18233g, b3);
                        } else {
                            f18232f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = uFIFuturesGenerator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private ListenableFuture<GraphQLComment> m26753b(String str, PendingCommentInputEntry pendingCommentInputEntry, final Builder builder, final boolean z) {
        Bundle bundle = new Bundle();
        ListenableFuture listenableFuture = null;
        if (pendingCommentInputEntry.f17976f == null) {
            if (pendingCommentInputEntry.f17977g != null) {
                builder.g = String.valueOf(pendingCommentInputEntry.f17977g.b);
            }
            return this.f18237d.a(builder.a(), z);
        }
        AddPhotoAttachmentParams.Builder a;
        switch (C13353.f18231a[pendingCommentInputEntry.f17976f.l().ordinal()]) {
            case 1:
                a = AddPhotoAttachmentParams.m10322a();
                a.f7155b = str;
                a = a;
                a.f7154a = pendingCommentInputEntry.f17976f;
                a = a;
                a.f7156c = m26750a();
                bundle.putParcelable("addPhotoAttachmentParams", a.m10321a());
                listenableFuture = BlueServiceOperationFactoryDetour.a(this.f18235b, "feed_add_photo", bundle, -2138915626).a();
                break;
            case 2:
                a = AddPhotoAttachmentParams.m10322a();
                a.f7155b = str;
                a = a;
                a.f7154a = pendingCommentInputEntry.f17976f;
                a = a;
                a.f7156c = m26750a();
                bundle.putParcelable("addVideoAttachmentParams", a.m10321a());
                listenableFuture = BlueServiceOperationFactoryDetour.a(this.f18235b, "feed_add_video", bundle, -635722511).a();
                break;
            case 3:
                return this.f18237d.a(builder.a(), z);
        }
        return Futures.b(listenableFuture, new AsyncFunction<OperationResult, GraphQLComment>(this) {
            final /* synthetic */ UFIFuturesGenerator f18230c;

            public final ListenableFuture m26749a(Object obj) {
                builder.g = ((OperationResult) obj).c;
                return this.f18230c.f18237d.a(builder.a(), z);
            }
        });
    }

    private ViewerContext m26750a() {
        ViewerContext viewerContext = (ViewerContext) this.f18236c.get();
        return viewerContext.mIsPageContext ? viewerContext : null;
    }
}
