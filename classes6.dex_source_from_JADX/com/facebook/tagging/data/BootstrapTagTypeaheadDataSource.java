package com.facebook.tagging.data;

import com.facebook.qe.api.QeAccessor;
import com.facebook.search.bootstrap.db.model.EntityDbModel;
import com.facebook.search.bootstrap.db.resolvers.BootstrapSuggestionResolver;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import javax.inject.Inject;

/* compiled from: deviceId */
public class BootstrapTagTypeaheadDataSource extends TagTypeaheadDataSource {
    public final BootstrapSuggestionResolver f17378a;
    public final TaggingProfiles f17379b;
    private final BootstrapEntitiesLoader f17380c;
    public final int f17381d;

    @Inject
    public BootstrapTagTypeaheadDataSource(BootstrapSuggestionResolver bootstrapSuggestionResolver, TaggingProfiles taggingProfiles, QeAccessor qeAccessor, BootstrapEntitiesLoader bootstrapEntitiesLoader) {
        this.f17378a = bootstrapSuggestionResolver;
        this.f17379b = taggingProfiles;
        this.f17381d = qeAccessor.a(ExperimentsForTaggingABTestModule.f17307f, 1000);
        this.f17380c = bootstrapEntitiesLoader;
    }

    public final boolean mo1315a() {
        return true;
    }

    public final String mo1316b() {
        return "bootstrap";
    }

    public final String mo1317c() {
        return "@";
    }

    public final void mo1314a(final CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, final SourceResultsListener sourceResultsListener) {
        if (charSequence != null && str != null && str.startsWith(mo1317c())) {
            this.f17380c.m23465a();
            Futures.a(this.f17378a.m23432a(charSequence.toString(), this.f17381d, RegularImmutableList.a), new FutureCallback<List<EntityDbModel>>(this) {
                final /* synthetic */ BootstrapTagTypeaheadDataSource f17377c;

                public void onSuccess(Object obj) {
                    sourceResultsListener.mo1121a(charSequence, this.f17377c.f17379b.m25208a((List) obj, "db_bootstrap", TagTypeaheadDataType.OTHERS.toString(), false));
                }

                public void onFailure(Throwable th) {
                }
            });
        }
    }
}
