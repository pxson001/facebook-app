package com.facebook.privacy.service;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyMethod;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams;
import com.facebook.privacy.protocol.EditObjectsPrivacyMethod;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams;
import com.facebook.privacy.protocol.EditReviewPrivacyMethod;
import com.facebook.privacy.protocol.EditReviewPrivacyParams;
import com.facebook.privacy.protocol.FetchAudienceInfoMethod;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.FetchAudienceInfoModel;
import com.facebook.privacy.protocol.FetchComposerPrivacyGuardrailInfoMethod;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsMethod;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionMethod;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionParams;
import com.facebook.privacy.protocol.ReportAAATuxActionMethod;
import com.facebook.privacy.protocol.ReportAAATuxActionParams;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionMethod;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionParams;
import com.facebook.privacy.protocol.ReportNASActionMethod;
import com.facebook.privacy.protocol.ReportNASActionParams;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsMethod;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams;
import com.facebook.privacy.protocol.ReportStickyGuardrailActionMethod;
import com.facebook.privacy.protocol.ReportStickyGuardrailActionParams;
import com.facebook.privacy.protocol.ReportStickyUpsellActionMethod;
import com.facebook.privacy.protocol.ReportStickyUpsellActionParams;
import com.facebook.privacy.protocol.SetComposerStickyPrivacyMethod;
import com.facebook.privacy.protocol.SetComposerStickyPrivacyParams;
import com.facebook.privacy.protocol.SetPrivacyEducationStateMethod;
import com.facebook.privacy.protocol.SetPrivacyEducationStateParams;
import javax.inject.Inject;

/* compiled from: fax_work */
public final class PrivacyServiceHandler implements BlueServiceHandler {
    public final ApiMethodRunnerImpl f15258a;
    public final Lazy<PrivacyOptionsResultFactory> f15259b;
    public final Lazy<FetchComposerPrivacyOptionsMethod> f15260c;
    public final Lazy<EditReviewPrivacyMethod> f15261d;
    public final Lazy<SetPrivacyEducationStateMethod> f15262e;
    public final Lazy<ReportAAATuxActionMethod> f15263f;
    public final Lazy<ReportAAAOnlyMeActionMethod> f15264g;
    public final Lazy<SetComposerStickyPrivacyMethod> f15265h;
    public final Lazy<ReportNASActionMethod> f15266i;
    public final Lazy<FetchComposerPrivacyGuardrailInfoMethod> f15267j;
    public final Lazy<ReportStickyGuardrailActionMethod> f15268k;
    public final Lazy<ReportStickyUpsellActionMethod> f15269l;
    public final Lazy<FetchAudienceInfoMethod> f15270m;
    public final Lazy<ReportInlinePrivacySurveyActionMethod> f15271n;
    public final Lazy<ReportPrivacyCheckupActionsMethod> f15272o;
    public final Lazy<EditObjectsPrivacyMethod> f15273p;
    public final Lazy<BulkEditAlbumPhotoPrivacyMethod> f15274q;

    public static PrivacyServiceHandler m22913b(InjectorLike injectorLike) {
        return new PrivacyServiceHandler(ApiMethodRunnerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 3113), IdBasedLazy.a(injectorLike, 3108), IdBasedLazy.a(injectorLike, 9706), IdBasedLazy.a(injectorLike, 9715), IdBasedLazy.a(injectorLike, 9708), IdBasedLazy.a(injectorLike, 9707), IdBasedLazy.a(injectorLike, 9714), IdBasedLazy.a(injectorLike, 9710), IdBasedLazy.a(injectorLike, 3112), IdBasedLazy.a(injectorLike, 9712), IdBasedLazy.a(injectorLike, 9713), IdBasedLazy.a(injectorLike, 3111), IdBasedLazy.a(injectorLike, 9709), IdBasedLazy.a(injectorLike, 9711), IdBasedLazy.a(injectorLike, 9705), IdBasedLazy.a(injectorLike, 9704));
    }

    public final OperationResult m22914a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_privacy_options".equals(str)) {
            return OperationResult.a(((PrivacyOptionsResultFactory) this.f15259b.get()).a((GraphQLViewer) this.f15258a.a((ApiMethod) this.f15260c.get(), null), true));
        } else if ("feed_edit_privacy".equals(str)) {
            return OperationResult.a;
        } else {
            if ("feed_edit_review_privacy".equals(str)) {
                return OperationResult.a((String) this.f15258a.a((ApiMethod) this.f15261d.get(), (EditReviewPrivacyParams) operationParams.c.getParcelable("editReviewPrivacyParams")));
            } else if ("set_privacy_education_state".equals(str)) {
                this.f15258a.a((ApiMethod) this.f15262e.get(), (SetPrivacyEducationStateParams) operationParams.c.getParcelable("params"));
                return OperationResult.a;
            } else if ("report_aaa_tux_action".equals(str)) {
                this.f15258a.a((ApiMethod) this.f15263f.get(), (ReportAAATuxActionParams) operationParams.c.getParcelable("params"));
                return OperationResult.a;
            } else if ("report_aaa_only_me_action".equals(str)) {
                this.f15258a.a((ApiMethod) this.f15264g.get(), (ReportAAAOnlyMeActionParams) operationParams.c.getParcelable("params"));
                return OperationResult.a;
            } else if ("set_composer_sticky_privacy".equals(str)) {
                this.f15258a.a((ApiMethod) this.f15265h.get(), (SetComposerStickyPrivacyParams) operationParams.c.getParcelable("params"));
                return OperationResult.a;
            } else if ("report_nas_action".equals(str)) {
                this.f15258a.a((ApiMethod) this.f15266i.get(), (ReportNASActionParams) operationParams.c.getParcelable("params"));
                return OperationResult.a;
            } else if ("fetch_sticky_guardrail".equals(str)) {
                return OperationResult.a((GraphQLViewer) this.f15258a.a((ApiMethod) this.f15267j.get(), null));
            } else {
                if ("report_sticky_guardrail_action".equals(str)) {
                    this.f15258a.a((ApiMethod) this.f15268k.get(), (ReportStickyGuardrailActionParams) operationParams.c.getParcelable("params"));
                    return OperationResult.a;
                } else if ("report_sticky_upsell_action".equals(str)) {
                    this.f15258a.a((ApiMethod) this.f15269l.get(), (ReportStickyUpsellActionParams) operationParams.c.getParcelable("params"));
                    return OperationResult.a;
                } else if ("fetch_audience_info".equals(str)) {
                    return OperationResult.a((FetchAudienceInfoModel) this.f15258a.a((ApiMethod) this.f15270m.get(), null));
                } else {
                    if ("report_inline_privacy_survey_action".equals(str)) {
                        this.f15258a.a((ApiMethod) this.f15271n.get(), (ReportInlinePrivacySurveyActionParams) operationParams.c.getParcelable("params"));
                        return OperationResult.a;
                    } else if ("report_privacy_checkup_action".equals(str)) {
                        this.f15258a.a((ApiMethod) this.f15272o.get(), (ReportPrivacyCheckupActionsParams) operationParams.c.getParcelable("params"));
                        return OperationResult.a;
                    } else if ("edit_objects_privacy_operation_type".equals(str)) {
                        this.f15258a.a((ApiMethod) this.f15273p.get(), (EditObjectsPrivacyParams) operationParams.c.getParcelable("params"));
                        return OperationResult.a;
                    } else if ("bulk_edit_album_privacy_operation_type".equals(str)) {
                        this.f15258a.a((ApiMethod) this.f15274q.get(), (BulkEditAlbumPhotoPrivacyParams) operationParams.c.getParcelable("params"));
                        return OperationResult.a;
                    } else {
                        throw new Exception("Unknown type");
                    }
                }
            }
        }
    }

    @Inject
    public PrivacyServiceHandler(ApiMethodRunner apiMethodRunner, Lazy<FetchComposerPrivacyOptionsMethod> lazy, Lazy<PrivacyOptionsResultFactory> lazy2, Lazy<EditReviewPrivacyMethod> lazy3, Lazy<SetPrivacyEducationStateMethod> lazy4, Lazy<ReportAAATuxActionMethod> lazy5, Lazy<ReportAAAOnlyMeActionMethod> lazy6, Lazy<SetComposerStickyPrivacyMethod> lazy7, Lazy<ReportNASActionMethod> lazy8, Lazy<FetchComposerPrivacyGuardrailInfoMethod> lazy9, Lazy<ReportStickyGuardrailActionMethod> lazy10, Lazy<ReportStickyUpsellActionMethod> lazy11, Lazy<FetchAudienceInfoMethod> lazy12, Lazy<ReportInlinePrivacySurveyActionMethod> lazy13, Lazy<ReportPrivacyCheckupActionsMethod> lazy14, Lazy<EditObjectsPrivacyMethod> lazy15, Lazy<BulkEditAlbumPhotoPrivacyMethod> lazy16) {
        this.f15258a = apiMethodRunner;
        this.f15260c = lazy;
        this.f15259b = lazy2;
        this.f15261d = lazy3;
        this.f15262e = lazy4;
        this.f15263f = lazy5;
        this.f15264g = lazy6;
        this.f15265h = lazy7;
        this.f15266i = lazy8;
        this.f15267j = lazy9;
        this.f15268k = lazy10;
        this.f15269l = lazy11;
        this.f15270m = lazy12;
        this.f15271n = lazy13;
        this.f15272o = lazy14;
        this.f15273p = lazy15;
        this.f15274q = lazy16;
    }
}
