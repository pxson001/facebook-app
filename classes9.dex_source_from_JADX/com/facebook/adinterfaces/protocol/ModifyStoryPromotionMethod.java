package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesConstants.CampaignStatus;
import com.facebook.adinterfaces.ui.BudgetHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.BooleanApiResult;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: Video Home prefetch no badging metadata query failed */
public class ModifyStoryPromotionMethod implements ApiMethod<AdInterfacesBoostPostDataModel, BooleanApiResult> {
    private final AdInterfacesDataHelper f22400a;
    private final AdInterfacesErrorReporter f22401b;
    private final BoostedComponentLogger f22402c;

    public final ApiRequest m24244a(Object obj) {
        AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) obj;
        if (adInterfacesBoostPostDataModel == null) {
            m24243a();
            return null;
        } else if (adInterfacesBoostPostDataModel.f21780a == null) {
            m24243a();
            return null;
        } else if (adInterfacesBoostPostDataModel.f21780a.m23713l() == null) {
            m24243a();
            return null;
        } else if (adInterfacesBoostPostDataModel.f21783d == null) {
            m24243a();
            return null;
        } else {
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("format", "json"));
            arrayList.add(new BasicNameValuePair("status_update_action", adInterfacesBoostPostDataModel.f21783d.getCampaignStatusString()));
            if (adInterfacesBoostPostDataModel.f21783d == CampaignStatus.UPDATE_BUDGET || adInterfacesBoostPostDataModel.f21783d == CampaignStatus.RESUME) {
                arrayList.add(new BasicNameValuePair("stop_time", String.valueOf(this.f22400a.m22823b(adInterfacesBoostPostDataModel.f21780a.m23713l().m23678u()))));
            }
            if (adInterfacesBoostPostDataModel.f21783d == CampaignStatus.UPDATE_BUDGET) {
                if (adInterfacesBoostPostDataModel.f21750f == null) {
                    m24243a();
                    return null;
                } else if (adInterfacesBoostPostDataModel.f21750f == null) {
                    m24243a();
                    return null;
                } else {
                    arrayList.add(new BasicNameValuePair("budget", BudgetHelper.m25098a(adInterfacesBoostPostDataModel.f21750f).toString()));
                }
            }
            if (adInterfacesBoostPostDataModel.f21755k != null) {
                arrayList.add(new BasicNameValuePair("placement", adInterfacesBoostPostDataModel.f21755k));
            }
            arrayList.add(new BasicNameValuePair("flow_id", this.f22402c.f21686e));
            return new ApiRequest("modifyStoryPromotionCampaign", "POST", adInterfacesBoostPostDataModel.f21780a.m23713l().m23674q(), RequestPriority.INTERACTIVE, arrayList, ApiResponseType.JSON);
        }
    }

    @Inject
    public ModifyStoryPromotionMethod(AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter, BoostedComponentLogger boostedComponentLogger) {
        this.f22400a = adInterfacesDataHelper;
        this.f22401b = adInterfacesErrorReporter;
        this.f22402c = boostedComponentLogger;
    }

    public final Object m24245a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return new BooleanApiResult(apiResponse.c().F());
    }

    private void m24243a() {
        this.f22401b.m22726a(getClass(), "Insufficient data to modify promotion");
    }
}
