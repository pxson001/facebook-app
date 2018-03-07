package com.facebook.composer.protocol;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: place_attributions */
public class ComposerService {
    public final ListeningExecutorService f7904a;
    public final Lazy<BlueServiceOperationFactory> f7905b;
    public final Lazy<GraphQLQueryExecutor> f7906c;

    /* compiled from: place_attributions */
    public class C04651 implements Function<OperationResult, String> {
        final /* synthetic */ ComposerService f7901a;

        public C04651(ComposerService composerService) {
            this.f7901a = composerService;
        }

        public Object apply(Object obj) {
            return ((OperationResult) obj).c;
        }
    }

    /* compiled from: place_attributions */
    public class C04662 implements Callable<String> {
        final /* synthetic */ ComposerService f7902a;

        public C04662(ComposerService composerService) {
            this.f7902a = composerService;
        }

        public Object call() {
            Thread.sleep(2500);
            return "DONE";
        }
    }

    /* compiled from: place_attributions */
    public class C04673 implements Callable<String> {
        final /* synthetic */ ComposerService f7903a;

        public C04673(ComposerService composerService) {
            this.f7903a = composerService;
        }

        public Object call() {
            Thread.sleep(500);
            return "DONE";
        }
    }

    @Inject
    public ComposerService(Lazy<BlueServiceOperationFactory> lazy, ListeningExecutorService listeningExecutorService, Lazy<GraphQLQueryExecutor> lazy2) {
        this.f7905b = lazy;
        this.f7904a = listeningExecutorService;
        this.f7906c = lazy2;
    }

    public final ListenableFuture<OperationResult> m11436c() {
        return BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f7905b.get(), "sync_contacts_partial", new Bundle(), ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 476863467).a();
    }
}
