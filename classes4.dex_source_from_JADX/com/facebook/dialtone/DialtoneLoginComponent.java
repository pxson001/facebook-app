package com.facebook.dialtone;

import com.facebook.auth.component.LoginComponent;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: sms_permanent_contact_people_tab_loaded_today */
public class DialtoneLoginComponent implements LoginComponent {
    public final DialtoneFetchQuotaMethod f2043a;
    public final DialtoneController f2044b;

    /* compiled from: sms_permanent_contact_people_tab_loaded_today */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ DialtoneLoginComponent f2045a;

        public MyBatchComponent(DialtoneLoginComponent dialtoneLoginComponent) {
            this.f2045a = dialtoneLoginComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Iterable<BatchOperation> iterable = RegularImmutableList.a;
            if (!this.f2045a.f2044b.b() || !this.f2045a.f2044b.k()) {
                return iterable;
            }
            Builder a = BatchOperation.m12541a(this.f2045a.f2043a, null);
            a.f11927c = "fetchDialtoneQuota";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            FetchDialtonePhotoQuotaModel fetchDialtonePhotoQuotaModel = (FetchDialtonePhotoQuotaModel) map.get("fetchDialtoneQuota");
            if (fetchDialtonePhotoQuotaModel != null) {
                DialtonePhotoQuotaModel a = fetchDialtonePhotoQuotaModel.a();
                if (a != null) {
                    this.f2045a.f2044b.a(a);
                }
            }
        }
    }

    @Inject
    public DialtoneLoginComponent(DialtoneFetchQuotaMethod dialtoneFetchQuotaMethod, DialtoneController dialtoneController) {
        this.f2043a = dialtoneFetchQuotaMethod;
        this.f2044b = dialtoneController;
    }

    public final BatchComponent mo143a() {
        return new MyBatchComponent(this);
    }
}
