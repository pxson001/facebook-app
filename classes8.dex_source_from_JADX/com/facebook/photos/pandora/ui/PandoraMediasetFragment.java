package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper;
import com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraMediasetFutureGenerator;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraMediasetFutureGeneratorProvider;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.katana.activity.faceweb.FacewebFragment */
public class PandoraMediasetFragment extends PandoraPhotoCollageFragment {
    @Inject
    public PandoraMediasetFutureGeneratorProvider f17660a;
    private PandoraMediasetFutureGenerator ar;
    private String as;

    public static void m21634a(Object obj, Context context) {
        ((PandoraMediasetFragment) obj).f17660a = (PandoraMediasetFutureGeneratorProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(PandoraMediasetFutureGeneratorProvider.class);
    }

    public final void mo910c(Bundle bundle) {
        super.mo910c(bundle);
        Class cls = PandoraMediasetFragment.class;
        m21634a((Object) this, getContext());
        this.as = this.s.getString("mediasetId");
    }

    protected final PandoraPhotoCollageFetchPhotosFutureGenerator mo909b() {
        if (this.ar == null) {
            InjectorLike injectorLike = this.f17660a;
            this.ar = new PandoraMediasetFutureGenerator(this.as, (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PandoraGraphQLParamImageHelper.m21385a(injectorLike), GraphQLQueryExecutor.a(injectorLike), PandoraResultConverterFunction.m21395a(injectorLike));
        }
        return this.ar;
    }

    protected final void mo908a(String str, @Nullable Uri uri) {
        Intent intent = new Intent();
        intent.putExtra(PandoraMediaSetActivity.f17658p, str);
        intent.putExtra(PandoraMediaSetActivity.f17659q, uri);
        o().setResult(-1, intent);
        o().finish();
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1209604718);
        super.mY_();
        this.an.m21640a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 728371005, a);
    }
}
