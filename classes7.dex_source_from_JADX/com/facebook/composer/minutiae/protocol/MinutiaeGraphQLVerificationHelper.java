package com.facebook.composer.minutiae.protocol;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: timeline_context_item */
public class MinutiaeGraphQLVerificationHelper {
    private final AbstractFbErrorReporter f1675a;

    public static MinutiaeGraphQLVerificationHelper m1679b(InjectorLike injectorLike) {
        return new MinutiaeGraphQLVerificationHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MinutiaeGraphQLVerificationHelper(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1675a = abstractFbErrorReporter;
    }

    public final boolean m1680a(TaggableObjectEdgeModel taggableObjectEdgeModel) {
        boolean z = (taggableObjectEdgeModel.af_().d() == null || taggableObjectEdgeModel.d() == null || taggableObjectEdgeModel.d().b() == null || taggableObjectEdgeModel.af_().d() == null) ? false : true;
        if (!z) {
            m1678a("Object model has missing fields : " + taggableObjectEdgeModel.af_().d());
        }
        return z;
    }

    public final boolean m1681a(MinutiaeTaggableActivity minutiaeTaggableActivity) {
        boolean z = (minutiaeTaggableActivity.A() == null || minutiaeTaggableActivity.A().a() == null || minutiaeTaggableActivity.n() == null) ? false : true;
        if (!z) {
            m1678a("Verb model has missing fields : " + minutiaeTaggableActivity.l());
        }
        return z;
    }

    private void m1678a(String str) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f1675a;
        SoftErrorBuilder a = SoftError.a("MinutiaeGraphQLError", "Object model is invalid");
        a.d = true;
        a = a;
        a.e = 1;
        a = a;
        a.c = new IllegalStateException(str);
        abstractFbErrorReporter.a(a.g());
    }
}
