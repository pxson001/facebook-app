package com.facebook.tagging.data;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.QueueingListeningExecutorService;
import com.facebook.common.executors.QueueingListeningExecutorService_SearchTypeaheadNetworkExecutorMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.Builder;
import com.facebook.search.api.protocol.FetchSimpleSearchTypeaheadApiMethod;
import com.facebook.search.bootstrap.db.resolvers.BootstrapSuggestionResolver;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: details */
public class UberbarDataSource extends TagTypeaheadDataSource {
    public final Resources f17394a;
    public final QueueingListeningExecutorService f17395b;
    public final FetchSimpleSearchTypeaheadApiMethod f17396c;
    public final AbstractSingleMethodRunner f17397d;
    public final TaggingProfiles f17398e;
    private final BootstrapTagTypeaheadDataSource f17399f;

    public static UberbarDataSource m25212b(InjectorLike injectorLike) {
        return new UberbarDataSource(ResourcesMethodAutoProvider.a(injectorLike), QueueingListeningExecutorService_SearchTypeaheadNetworkExecutorMethodAutoProvider.a(injectorLike), FetchSimpleSearchTypeaheadApiMethod.m23176b(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), TaggingProfiles.m25203b(injectorLike), new BootstrapTagTypeaheadDataSource(BootstrapSuggestionResolver.m23430b(injectorLike), TaggingProfiles.m25203b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BootstrapEntitiesLoader.m23450a(injectorLike)));
    }

    @Inject
    public UberbarDataSource(Resources resources, QueueingListeningExecutorService queueingListeningExecutorService, FetchSimpleSearchTypeaheadApiMethod fetchSimpleSearchTypeaheadApiMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, TaggingProfiles taggingProfiles, BootstrapTagTypeaheadDataSource bootstrapTagTypeaheadDataSource) {
        this.f17394a = resources;
        this.f17395b = queueingListeningExecutorService;
        this.f17396c = fetchSimpleSearchTypeaheadApiMethod;
        this.f17397d = abstractSingleMethodRunner;
        this.f17398e = taggingProfiles;
        this.f17399f = bootstrapTagTypeaheadDataSource;
    }

    public final boolean mo1315a() {
        return true;
    }

    public final String mo1316b() {
        return "uberbar";
    }

    public final void mo1314a(CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SourceResultsListener sourceResultsListener) {
        if (charSequence != null && !charSequence.toString().isEmpty() && !Strings.isNullOrEmpty(str) && str.startsWith(mo1317c())) {
            final ImmutableList a = m25211a(z2, z3);
            if (!a.isEmpty()) {
                final SourceResultsListener sourceResultsListener2 = sourceResultsListener;
                this.f17399f.mo1314a(charSequence, str, z, z2, z3, z4, z5, new SourceResultsListener(this) {
                    final /* synthetic */ UberbarDataSource f17393c;

                    public final void mo1121a(CharSequence charSequence, List<TaggingProfile> list) {
                        this.f17393c.m25213a(charSequence, a, list, sourceResultsListener2);
                    }
                });
            }
        }
    }

    @VisibleForTesting
    public final void m25213a(final CharSequence charSequence, ImmutableList<Type> immutableList, List<TaggingProfile> list, final SourceResultsListener sourceResultsListener) {
        sourceResultsListener.mo1121a(charSequence, list);
        if (list.size() < 5 && charSequence != null && !immutableList.isEmpty()) {
            Builder builder = new Builder();
            builder.f15543a = GraphSearchQuery.m23091a(charSequence.toString());
            builder = builder;
            builder.f15547e = 5;
            builder = builder;
            builder.f15546d = immutableList;
            builder = builder;
            builder.f15545c = this.f17394a.getDimensionPixelSize(2131427459);
            final FetchSearchTypeaheadResultParams a = builder.m23175a();
            Futures.a(this.f17395b.a(new Callable<SearchResponse<SearchTypeaheadResult>>(this) {
                final /* synthetic */ UberbarDataSource f17387b;

                public Object call() {
                    return (SearchResponse) this.f17387b.f17397d.a(this.f17387b.f17396c, a);
                }
            }), new FutureCallback<SearchResponse<SearchTypeaheadResult>>(this) {
                final /* synthetic */ UberbarDataSource f17390c;

                public void onSuccess(Object obj) {
                    sourceResultsListener.mo1121a(charSequence, this.f17390c.f17398e.m25209b(((SearchResponse) obj).f18413b, "uberbar", TagTypeaheadDataType.OTHERS.toString(), false));
                }

                public void onFailure(Throwable th) {
                }
            });
        }
    }

    public final String mo1317c() {
        return "@";
    }

    private static ImmutableList<Type> m25211a(boolean z, boolean z2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (z) {
            builder.c(Type.USER);
        }
        if (z2) {
            builder.c(Type.PAGE);
        }
        return builder.b();
    }
}
