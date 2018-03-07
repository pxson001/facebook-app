package com.facebook.privacy.audience;

import com.facebook.auth.component.AbstractLoginComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.privacy.protocol.FetchAudienceInfoForLoginMethod;
import com.facebook.privacy.protocol.FetchAudienceInfoModels$FetchAudienceInfoModel;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: sms_perm_granted */
public class AudienceInfoLoginComponent extends AbstractLoginComponent {
    public final FetchAudienceInfoForLoginMethod f2046a;
    public final AudienceEducatorManager f2047b;

    /* compiled from: sms_perm_granted */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ AudienceInfoLoginComponent f2076a;

        public MyBatchComponent(AudienceInfoLoginComponent audienceInfoLoginComponent) {
            this.f2076a = audienceInfoLoginComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f2076a.f2046a, null);
            a.f11927c = "fetchViewerLoginAudienceInfo";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            FetchAudienceInfoModels$FetchAudienceInfoModel fetchAudienceInfoModels$FetchAudienceInfoModel = (FetchAudienceInfoModels$FetchAudienceInfoModel) map.get("fetchViewerLoginAudienceInfo");
            if (fetchAudienceInfoModels$FetchAudienceInfoModel != null) {
                this.f2076a.f2047b.m2136a(fetchAudienceInfoModels$FetchAudienceInfoModel.m2226a());
            }
        }
    }

    @Inject
    public AudienceInfoLoginComponent(FetchAudienceInfoForLoginMethod fetchAudienceInfoForLoginMethod, AudienceEducatorManager audienceEducatorManager) {
        this.f2046a = fetchAudienceInfoForLoginMethod;
        this.f2047b = audienceEducatorManager;
    }

    public final BatchComponent mo143a() {
        return new MyBatchComponent(this);
    }
}
