package com.facebook.contacts.pna.qps;

import android.content.Context;
import android.util.Patterns;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.confirmation.task.BackgroundConfirmationHelper;
import com.facebook.contacts.pna.PhoneNumberAcquisitionClient;
import com.facebook.contacts.pna.abtest.ExperimentsForPnaABTestModule;
import com.facebook.contacts.pna.graphql.AddPhoneNumberMutation.UserPhoneNumberAddCoreMutationString;
import com.facebook.contacts.pna.graphql.AddPhoneNumberMutationModels.UserPhoneNumberAddCoreMutationFragmentModel;
import com.facebook.contacts.pna.graphql.AddPhoneNumberMutationModels.UserPhoneNumberAddCoreMutationFragmentModel.Builder;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.UserPhoneNumberAddInputData;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.customrender.CustomRenderBaseController;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: platformItemId */
public class PhoneNumberAcquisitionQPController extends CustomRenderBaseController {
    public final Context f6512b;
    private final ExecutorService f6513c;
    public final FbUriIntentHandler f6514d;
    private final PhoneNumberAcquisitionClient f6515e;
    public final Toaster f6516f;
    public final Lazy<BackgroundConfirmationHelper> f6517g;
    public final QeAccessor f6518h;
    public final QuickPromotionDefinition f6519i;
    private final PhoneNumberAcquisitionQPView f6520j;

    @Inject
    public PhoneNumberAcquisitionQPController(ExecutorService executorService, FbUriIntentHandler fbUriIntentHandler, PhoneNumberAcquisitionClient phoneNumberAcquisitionClient, Toaster toaster, Lazy<BackgroundConfirmationHelper> lazy, QeAccessor qeAccessor, @Assisted Context context, @Assisted QuickPromotionViewHelper quickPromotionViewHelper, @Assisted Runnable runnable, @Assisted QuickPromotionDefinition quickPromotionDefinition, @Assisted PhoneNumberAcquisitionQPView phoneNumberAcquisitionQPView) {
        super(runnable, quickPromotionViewHelper);
        this.f6512b = context;
        this.f6513c = executorService;
        this.f6514d = fbUriIntentHandler;
        this.f6515e = phoneNumberAcquisitionClient;
        this.f6516f = toaster;
        this.f6517g = lazy;
        this.f6518h = qeAccessor;
        this.f6519i = quickPromotionDefinition;
        this.f6520j = phoneNumberAcquisitionQPView;
    }

    public final void m6865a(final String str, final String str2) {
        if (StringUtil.c(str) || !Patterns.PHONE.matcher(str).matches() || str2 == null) {
            this.f6516f.b(new ToastBuilder(2131240005));
            return;
        }
        PhoneNumberAcquisitionClient phoneNumberAcquisitionClient = this.f6515e;
        String str3 = this.f6519i.promotionId;
        UserPhoneNumberAddInputData userPhoneNumberAddInputData = new UserPhoneNumberAddInputData();
        userPhoneNumberAddInputData.a("country", str2);
        GraphQlCallInput graphQlCallInput = userPhoneNumberAddInputData;
        graphQlCallInput.a("contact_point", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("source", "phone_acquisition_promo");
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("promo_type", "acquisition");
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("qp_id", str3);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("state", Integer.valueOf(1));
        graphQlCallInput = graphQlCallInput;
        Builder builder = new Builder();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.f6506a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        GraphQLVisitableModel userPhoneNumberAddCoreMutationFragmentModel = new UserPhoneNumberAddCoreMutationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        GraphQlQueryString userPhoneNumberAddCoreMutationString = new UserPhoneNumberAddCoreMutationString();
        userPhoneNumberAddCoreMutationString.a("input", graphQlCallInput);
        Futures.a(phoneNumberAcquisitionClient.f6501a.a(GraphQLRequest.a(userPhoneNumberAddCoreMutationString).a(userPhoneNumberAddCoreMutationFragmentModel)), new FutureCallback<GraphQLResult<UserPhoneNumberAddCoreMutationFragmentModel>>(this) {
            final /* synthetic */ PhoneNumberAcquisitionQPController f6511c;

            public void onSuccess(Object obj) {
                String a = NetworkLogUrl.a(this.f6511c.f6512b, "https://m.%s");
                if (this.f6511c.f6518h.a(ExperimentsForPnaABTestModule.f6505d, false)) {
                    this.f6511c.f6514d.a(this.f6511c.f6512b, StringFormatUtil.a(FBLinks.a("confirmAccount/?normalized_contactpoint=%s&contactpoint_type=%s&iso_country_code=%s&for_phone_number_confirmation=%s&quick_promotion_id=%s"), new Object[]{str, "PHONE", str2, "true", this.f6511c.f6519i.promotionId}));
                    ((BackgroundConfirmationHelper) this.f6511c.f6517g.get()).a(Contactpoint.a(str, str2));
                } else {
                    this.f6511c.f6514d.a(this.f6511c.f6512b, a + StringFormatUtil.a("/phoneacquire/?country=%s&state=2&source=phone_acquisition_promo&promo_type=acquisition&contact_point=%s&verification_type=code_sms&activate_sms=1&qp_id=%s", new Object[]{str2, str, this.f6511c.f6519i.promotionId}));
                }
                this.f6511c.a.b();
                if (this.f6511c.a.d()) {
                    this.f6511c.c();
                }
            }

            public void onFailure(Throwable th) {
                CharSequence charSequence;
                String str = null;
                if (th instanceof GraphQLException) {
                    GraphQLError graphQLError = ((GraphQLException) th).error;
                    if (graphQLError != null) {
                        str = graphQLError.description;
                    }
                    charSequence = str;
                } else {
                    charSequence = null;
                }
                this.f6511c.f6516f.b(charSequence == null ? new ToastBuilder(2131230758) : new ToastBuilder(charSequence));
            }
        }, this.f6513c);
    }

    public final void m6866c() {
        this.f6520j.m6873a();
    }
}
