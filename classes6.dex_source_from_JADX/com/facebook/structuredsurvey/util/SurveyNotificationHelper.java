package com.facebook.structuredsurvey.util;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQueryModels.SurveyIntegrationPointQueryModel;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQuery.FetchNotificationForSurveyString;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.ActorsModel;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.AggregatedRangesModel;
import com.facebook.structuredsurvey.graphql.SurveyNotificationQueryModels.FetchNotificationForSurveyModel.TitleForSummaryModel.RangesModel;
import com.facebook.text.CustomFontUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dismiss_survey_id */
public class SurveyNotificationHelper {
    public static final String f17188a = ("NaRF:" + SurveyNotificationHelper.class.getSimpleName());
    public final AbstractFbErrorReporter f17189b;
    private final ExecutorService f17190c;
    private final CustomFontUtil f17191d;
    private final Lazy<GraphQLQueryExecutor> f17192e;
    public final Lazy<StructuredSurveyController> f17193f;
    public SurveyNotificationWrapper f17194g;

    public static SurveyNotificationHelper m24940b(InjectorLike injectorLike) {
        return new SurveyNotificationHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 3480), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), CustomFontUtil.a(injectorLike));
    }

    public final void m24942a(String str, SurveyIntegrationPointQueryModel surveyIntegrationPointQueryModel, String str2, @Nullable Runnable runnable, boolean z) {
        final SurveyIntegrationPointQueryModel surveyIntegrationPointQueryModel2 = surveyIntegrationPointQueryModel;
        final String str3 = str2;
        final Runnable runnable2 = runnable;
        final boolean z2 = z;
        Futures.a(((GraphQLQueryExecutor) this.f17192e.get()).a(GraphQLRequest.a((FetchNotificationForSurveyString) new FetchNotificationForSurveyString().a("node_id", str))), new FutureCallback<GraphQLResult<FetchNotificationForSurveyModel>>(this) {
            final /* synthetic */ SurveyNotificationHelper f17187e;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.d() != null) {
                    FetchNotificationForSurveyModel fetchNotificationForSurveyModel = (FetchNotificationForSurveyModel) graphQLResult.d();
                    ImmutableList a = fetchNotificationForSurveyModel.m24872a();
                    if (a != null && !a.isEmpty() && fetchNotificationForSurveyModel.m24876j() != null && fetchNotificationForSurveyModel.m24878l() != null) {
                        this.f17187e.f17194g = new SurveyNotificationWrapper(SurveyNotificationHelper.m24937a(this.f17187e, fetchNotificationForSurveyModel.m24878l()), ((ActorsModel) a.get(0)).m24838a() != null ? ((ActorsModel) a.get(0)).m24838a().m24833a() : null, fetchNotificationForSurveyModel.m24876j().m24845a(), ((FetchNotificationForSurveyModel) graphQLResult.d()).m24877k());
                        try {
                            ((StructuredSurveyController) this.f17187e.f17193f.get()).a(surveyIntegrationPointQueryModel2, str3, runnable2, z2, true);
                        } catch (Throwable e) {
                            this.f17187e.f17189b.a(SurveyNotificationHelper.f17188a, "NaRF:IntegrationPoint Model Init Failed", e);
                            SurveyNotificationHelper.m24941e(this.f17187e);
                            ((StructuredSurveyController) this.f17187e.f17193f.get()).l();
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                this.f17187e.f17189b.a(SurveyNotificationHelper.f17188a, "NaRF:Fetching Notification From Server Failed", th);
                SurveyNotificationHelper.m24941e(this.f17187e);
                ((StructuredSurveyController) this.f17187e.f17193f.get()).l();
            }
        }, this.f17190c);
    }

    @Inject
    public SurveyNotificationHelper(FbErrorReporter fbErrorReporter, Lazy<GraphQLQueryExecutor> lazy, Lazy<StructuredSurveyController> lazy2, ExecutorService executorService, CustomFontUtil customFontUtil) {
        this.f17189b = fbErrorReporter;
        this.f17192e = lazy;
        this.f17190c = executorService;
        this.f17191d = customFontUtil;
        this.f17193f = lazy2;
    }

    public static Spannable m24937a(SurveyNotificationHelper surveyNotificationHelper, TitleForSummaryModel titleForSummaryModel) {
        Object k = titleForSummaryModel.m24868k();
        Spannable spannableStringBuilder = new SpannableStringBuilder(k);
        CharacterStyle a = CustomFontUtil.a();
        spannableStringBuilder.setSpan(CharacterStyle.wrap(CustomFontUtil.b()), 0, k.length(), 33);
        int i = 0;
        if (!(titleForSummaryModel.m24867j() == null || titleForSummaryModel.m24867j().isEmpty())) {
            ImmutableList j = titleForSummaryModel.m24867j();
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                RangesModel rangesModel = (RangesModel) j.get(i2);
                m24939a(spannableStringBuilder, a, titleForSummaryModel.m24868k(), new CodePointRange(rangesModel.m24862j(), rangesModel.m24858a()));
            }
        }
        if (!(titleForSummaryModel.m24866a() == null || titleForSummaryModel.m24866a().isEmpty())) {
            ImmutableList a2 = titleForSummaryModel.m24866a();
            int size2 = a2.size();
            while (i < size2) {
                AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) a2.get(i);
                m24939a(spannableStringBuilder, a, titleForSummaryModel.m24868k(), new CodePointRange(aggregatedRangesModel.m24854j(), aggregatedRangesModel.m24850a()));
                i++;
            }
        }
        return spannableStringBuilder;
    }

    public static void m24939a(SpannableStringBuilder spannableStringBuilder, CharacterStyle characterStyle, String str, CodePointRange codePointRange) {
        UTF16Range a = RangeConverter.a(str, codePointRange);
        spannableStringBuilder.setSpan(CharacterStyle.wrap(characterStyle), a.a, a.c(), 17);
    }

    public static void m24941e(SurveyNotificationHelper surveyNotificationHelper) {
        surveyNotificationHelper.f17194g = null;
    }
}
