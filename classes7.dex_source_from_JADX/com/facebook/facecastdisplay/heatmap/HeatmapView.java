package com.facebook.facecastdisplay.heatmap;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.facecastdisplay.MomentsOfInterestDownloader;
import com.facebook.facecastdisplay.MomentsOfInterestDownloader.FetchMomentsOfInterestGraphlQLCallback;
import com.facebook.facecastdisplay.MomentsOfInterestDownloader.MomentsOfInterestDownloaderListener;
import com.facebook.facecastdisplay.heatmap.model.DataPoint;
import com.facebook.facecastdisplay.heatmap.model.DataSet;
import com.facebook.facecastdisplay.heatmap.view.GraphView;
import com.facebook.facecastdisplay.protocol.FetchMomentsOfInterestQuery.FetchMomentsOfInterestQueryString;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: assisted_onboarding */
public class HeatmapView extends GraphView implements MomentsOfInterestDownloaderListener {
    @Inject
    public MomentsOfInterestDownloader f19081a;

    private static <T extends View> void m22642a(Class<T> cls, T t) {
        m22643a((Object) t, t.getContext());
    }

    private static void m22643a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((HeatmapView) obj).f19081a = new MomentsOfInterestDownloader((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    public HeatmapView(Context context) {
        this(context, null);
    }

    public HeatmapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeatmapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22642a(HeatmapView.class, (View) this);
    }

    public void setVideoId(String str) {
        this.f19081a.f19002f = str;
        this.f19081a.f19001e = this;
        MomentsOfInterestDownloader momentsOfInterestDownloader = this.f19081a;
        momentsOfInterestDownloader.m22579b();
        if (TextUtils.isEmpty(momentsOfInterestDownloader.f19002f)) {
            momentsOfInterestDownloader.f19000d.a(MomentsOfInterestDownloader.f18997a + "_startFetching", "Tried to fetch without a story id.");
            return;
        }
        GraphQlQueryString fetchMomentsOfInterestQueryString = new FetchMomentsOfInterestQueryString();
        fetchMomentsOfInterestQueryString.a("targetID", momentsOfInterestDownloader.f19002f);
        momentsOfInterestDownloader.f19003g = momentsOfInterestDownloader.f18998b.a(GraphQLRequest.a(fetchMomentsOfInterestQueryString).a(GraphQLCachePolicy.a).a(600));
        Futures.a(momentsOfInterestDownloader.f19003g, new FetchMomentsOfInterestGraphlQLCallback(momentsOfInterestDownloader), momentsOfInterestDownloader.f18999c);
    }

    public final void mo1450a() {
        this.f19081a.m22579b();
        m22638a(false);
    }

    public final void mo1451a(ImmutableList<Integer> immutableList) {
        if (!immutableList.isEmpty()) {
            float f;
            DataSet dataSet = new DataSet();
            dataSet.f19085a.clear();
            dataSet.f19086b = 0.0f;
            if (dataSet.m22648b()) {
                f = 0.0f;
            } else {
                f = ((DataPoint) dataSet.f19085a.get(dataSet.f19085a.size() - 1)).f19082a;
            }
            float f2 = f;
            for (Number number : immutableList) {
                float floatValue = number.floatValue();
                if (number.floatValue() >= 0.0f) {
                    f2 = floatValue;
                }
                DataPoint dataPoint = new DataPoint(f2);
                if (dataPoint.f19082a > dataSet.f19086b) {
                    dataSet.f19086b = dataPoint.f19082a;
                }
                f = dataPoint.f19082a;
                dataSet.f19085a.add(dataPoint);
                f2 = f;
            }
            this.f19062a = dataSet;
        }
    }

    private void m22641a(MomentsOfInterestDownloader momentsOfInterestDownloader) {
        this.f19081a = momentsOfInterestDownloader;
    }
}
