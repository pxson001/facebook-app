package com.facebook.pages.common.coverphotoreposition;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImage.Builder;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.context.TimelinePageContext;
import com.facebook.pages.common.coverphotoreposition.FetchPageHeaderForCoverPhotoRepositionGraphQL.FetchPageHeaderForCoverPhotoRepositionQueryString;
import com.facebook.pages.common.coverphotoreposition.FetchPageHeaderForCoverPhotoRepositionGraphQLModels.FetchPageHeaderForCoverPhotoRepositionQueryModel;
import com.facebook.pages.common.coverphotoreposition.FetchPageHeaderForCoverPhotoRepositionGraphQLModels.FetchPageHeaderForCoverPhotoRepositionQueryModel.ProfilePictureModel;
import com.facebook.photos.upload.constants.PhotoProcessingConstantsUtils;
import com.facebook.timeline.coverphoto.activity.CoverPhotoFragment;
import com.facebook.timeline.header.coverphoto.edit.CoverPhotoEditView;
import com.facebook.timeline.header.data.TimelineHeaderPageData;
import com.facebook.timeline.profilepiccoverphotoupload.SetCoverPhotoParams;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: slow_down */
public class PagesCoverPhotoRepositionFragment extends FbFragment implements CoverPhotoFragment {
    private static final Class<?> ap = PagesCoverPhotoRepositionFragment.class;
    private String f1509a;
    private GraphQLQueryExecutor al;
    @ForUiThread
    private ExecutorService am;
    private PageEditCoverPhotoHeaderView an;
    private CoverPhotoEditView ao;
    private Dimension f1510b;
    private long f1511c = 0;
    public String f1512d;
    public TimelineContext f1513e;
    public TimelineHeaderPageData f1514f;
    private AbstractFbErrorReporter f1515g;
    private BitmapUtils f1516h;
    @LoggedInUserId
    private String f1517i;

    /* compiled from: slow_down */
    class C02071 implements FutureCallback<GraphQLResult<FetchPageHeaderForCoverPhotoRepositionQueryModel>> {
        final /* synthetic */ PagesCoverPhotoRepositionFragment f1508a;

        C02071(PagesCoverPhotoRepositionFragment pagesCoverPhotoRepositionFragment) {
            this.f1508a = pagesCoverPhotoRepositionFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                FetchPageHeaderForCoverPhotoRepositionQueryModel fetchPageHeaderForCoverPhotoRepositionQueryModel = (FetchPageHeaderForCoverPhotoRepositionQueryModel) graphQLResult.e;
                ProfilePictureModel k = fetchPageHeaderForCoverPhotoRepositionQueryModel.m2198k();
                if (k == null || k.m2190a() == null) {
                    BLog.a(PagesCoverPhotoRepositionFragment.class, "Model had empty profile picture URL");
                    return;
                }
                Builder builder = new Builder();
                builder.g = k.m2190a();
                GraphQLImage a = builder.a();
                GraphQLPage.Builder builder2 = new GraphQLPage.Builder();
                builder2.Z = String.valueOf(this.f1508a.f1512d);
                builder2 = builder2;
                builder2.aF = fetchPageHeaderForCoverPhotoRepositionQueryModel.m2197j();
                builder2 = builder2;
                builder2.bv = a;
                GraphQLPage.Builder builder3 = builder2;
                builder3.A = fetchPageHeaderForCoverPhotoRepositionQueryModel.m2194a();
                GraphQLPage a2 = builder3.a();
                this.f1508a.f1514f = new TimelineHeaderPageData(this.f1508a.f1513e);
                TimelineHeaderPageData timelineHeaderPageData = this.f1508a.f1514f;
                if (a2 != null) {
                    timelineHeaderPageData.k();
                    timelineHeaderPageData.a = a2.au();
                    timelineHeaderPageData.b = a2.bo();
                    timelineHeaderPageData.c = a2.bs();
                    timelineHeaderPageData.d = a2.bt();
                    timelineHeaderPageData.e = a2.aG();
                    timelineHeaderPageData.f = a2.F();
                    timelineHeaderPageData.d();
                }
                PagesCoverPhotoRepositionFragment.m2208b(this.f1508a);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f1508a.hn_() && this.f1508a.getContext() != null) {
                Toast.makeText(this.f1508a.getContext(), 2131230758, 1).show();
                this.f1508a.ao().setResult(0);
                this.f1508a.ao().finish();
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m2206a(Class<T> cls, T t) {
        m2207a((Object) t, t.getContext());
    }

    private static void m2207a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesCoverPhotoRepositionFragment) obj).m2205a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), BitmapUtils.a(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    private void m2209e() {
        GraphQlQueryString fetchPageHeaderForCoverPhotoRepositionQueryString = new FetchPageHeaderForCoverPhotoRepositionQueryString();
        fetchPageHeaderForCoverPhotoRepositionQueryString.a("page_id", String.valueOf(this.f1512d));
        Futures.a(this.al.a(GraphQLRequest.a(fetchPageHeaderForCoverPhotoRepositionQueryString)), new C02071(this), this.am);
    }

    public final void m2213c(Bundle bundle) {
        String str;
        long parseLong;
        ParcelUuid parcelUuid;
        super.c(bundle);
        Bundle mt_ = mt_();
        this.f1509a = mt_.getString("cover_photo_uri");
        this.f1511c = mt_.getLong("cover_photo_id");
        if (mt_.getLong("page_id", 0) == 0) {
            str = null;
        } else {
            str = String.valueOf(mt_.getLong("page_id", 0));
        }
        this.f1512d = str;
        if (this.f1509a == null || this.f1512d == null) {
            BLog.b(ap, "Missing required arguments.");
            ao().finish();
        }
        m2206a(PagesCoverPhotoRepositionFragment.class, (InjectableComponentWithContext) this);
        try {
            parseLong = Long.parseLong(this.f1517i);
        } catch (NumberFormatException e) {
            parseLong = -1;
            this.f1515g.a("timeline_invalid_meuser", "logged in user: " + this.f1517i);
        }
        if (bundle != null) {
            parcelUuid = (ParcelUuid) bundle.getParcelable("fragment_uuid");
        } else {
            parcelUuid = new ParcelUuid(SafeUUIDGenerator.a());
        }
        this.f1513e = TimelinePageContext.m2141a(parseLong, Long.parseLong(this.f1512d), null, parcelUuid, null, null);
        m2209e();
    }

    @Inject
    private void m2205a(AbstractFbErrorReporter abstractFbErrorReporter, BitmapUtils bitmapUtils, String str, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f1515g = abstractFbErrorReporter;
        this.f1516h = bitmapUtils;
        this.f1517i = str;
        this.al = graphQLQueryExecutor;
        this.am = executorService;
    }

    public static PagesCoverPhotoRepositionFragment m2204a(long j, String str, long j2) {
        PagesCoverPhotoRepositionFragment pagesCoverPhotoRepositionFragment = new PagesCoverPhotoRepositionFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("cover_photo_id", j);
        bundle.putString("cover_photo_uri", str);
        bundle.putLong("page_id", j2);
        pagesCoverPhotoRepositionFragment.g(bundle);
        return pagesCoverPhotoRepositionFragment;
    }

    public final View m2211a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -959833187);
        this.f1510b = BitmapUtils.a(this.f1509a);
        if (!PhotoProcessingConstantsUtils.a(this.f1510b)) {
            Toast.makeText(getContext(), 2131234972, 1).show();
            Activity ao = ao();
            if (ao != null) {
                ao.setResult(0);
                ao.finish();
            }
        }
        this.an = new PageEditCoverPhotoHeaderView(this.f1509a, getContext());
        if (this.f1514f != null) {
            m2208b(this);
        }
        this.ao = (CoverPhotoEditView) this.an.findViewById(2131565417);
        PageEditCoverPhotoHeaderView pageEditCoverPhotoHeaderView = this.an;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1250626728, a);
        return pageEditCoverPhotoHeaderView;
    }

    public static void m2208b(PagesCoverPhotoRepositionFragment pagesCoverPhotoRepositionFragment) {
        pagesCoverPhotoRepositionFragment.an.m2203a(pagesCoverPhotoRepositionFragment.f1514f);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1647093873);
        super.mY_();
        this.ao.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 452483404, a);
    }

    public final void m2210I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 976257584);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 705245660, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.an.m2203a(this.f1514f);
    }

    public final void m2214e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("fragment_uuid", this.f1513e.d);
    }

    public final SetCoverPhotoParams m2212a() {
        long j;
        if (this.f1513e.i()) {
            j = -1;
        } else {
            j = this.f1513e.b;
        }
        return new SetCoverPhotoParams(j, this.f1509a, this.ao.getNormalizedCropBounds(), this.f1510b, this.f1511c);
    }
}
