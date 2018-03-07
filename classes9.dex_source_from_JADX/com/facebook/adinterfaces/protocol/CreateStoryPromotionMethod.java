package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.BudgetHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: WhisperText */
public class CreateStoryPromotionMethod implements ApiMethod<AdInterfacesBoostPostDataModel, String> {
    private AdInterfacesDataHelper f22316a;
    private BoostedComponentLogger f22317b;

    public final ApiRequest m24060a(Object obj) {
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) obj;
        Preconditions.checkNotNull(adInterfacesBoostPostDataModel);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("budget", BudgetHelper.m25098a(adInterfacesBoostPostDataModel.f21750f).toString()));
        arrayList.add(new BasicNameValuePair("currency", adInterfacesBoostPostDataModel.f21750f.m23419a()));
        arrayList.add(new BasicNameValuePair("ad_account_id", adInterfacesBoostPostDataModel.m22853i()));
        if (adInterfacesBoostPostDataModel.f21754j.f21729i != null) {
            arrayList.add(new BasicNameValuePair("audience", GraphQLBoostedPostAudienceOption.NCPP.name()));
            arrayList.add(new BasicNameValuePair("audience_id", adInterfacesBoostPostDataModel.f21754j.f21729i));
        } else {
            arrayList.add(new BasicNameValuePair("audience", adInterfacesBoostPostDataModel.f21754j.f21728h.name()));
            arrayList.add(new BasicNameValuePair("targeting", adInterfacesBoostPostDataModel.f21754j.m22843j()));
        }
        arrayList.add(new BasicNameValuePair("start_time", String.valueOf(this.f22316a.m22821a())));
        arrayList.add(new BasicNameValuePair("stop_time", String.valueOf(this.f22316a.m22826c(adInterfacesBoostPostDataModel.f21753i))));
        if (adInterfacesBoostPostDataModel.f21784e != null) {
            arrayList.add(new BasicNameValuePair("ad_conversion_pixel_id", adInterfacesBoostPostDataModel.f21784e));
        }
        if (adInterfacesBoostPostDataModel.f21755k != null) {
            arrayList.add(new BasicNameValuePair("placement", adInterfacesBoostPostDataModel.f21755k));
        }
        arrayList.add(new BasicNameValuePair("flow_id", this.f22317b.f21686e));
        if (adInterfacesBoostPostDataModel.f21787h > 0) {
            arrayList.add(new BasicNameValuePair("bid_amount", adInterfacesBoostPostDataModel.f21787h));
        }
        return new ApiRequest("createStoryPromotion", "POST", StringFormatUtil.formatStrLocaleSafe("%s/promotions", adInterfacesBoostPostDataModel.f21782c), RequestPriority.INTERACTIVE, arrayList, ApiResponseType.JSON);
    }

    @Inject
    public CreateStoryPromotionMethod(AdInterfacesDataHelper adInterfacesDataHelper, BoostedComponentLogger boostedComponentLogger) {
        this.f22316a = adInterfacesDataHelper;
        this.f22317b = boostedComponentLogger;
    }

    public final Object m24061a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().B();
    }
}
