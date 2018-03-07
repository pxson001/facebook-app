package com.facebook.privacy.audience;

import com.facebook.config.background.AbstractConfigurationComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.privacy.protocol.FetchAudienceInfoMethod;
import com.facebook.privacy.protocol.FetchAudienceInfoModels$FetchAudienceInfoModel;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: rows_visited_count */
public class AudienceInfoFetchComponent extends AbstractConfigurationComponent {
    public final FetchAudienceInfoMethod f3323a;
    public final AudienceEducatorManager f3324b;

    /* compiled from: rows_visited_count */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ AudienceInfoFetchComponent f3325a;

        public MyBatchComponent(AudienceInfoFetchComponent audienceInfoFetchComponent) {
            this.f3325a = audienceInfoFetchComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f3325a.f3323a, null);
            a.f11927c = "fetchViewerAudienceInfo";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            FetchAudienceInfoModels$FetchAudienceInfoModel fetchAudienceInfoModels$FetchAudienceInfoModel = (FetchAudienceInfoModels$FetchAudienceInfoModel) map.get("fetchViewerAudienceInfo");
            if (fetchAudienceInfoModels$FetchAudienceInfoModel != null) {
                this.f3325a.f3324b.m2141b(fetchAudienceInfoModels$FetchAudienceInfoModel.m2226a());
            }
        }
    }

    @Inject
    public AudienceInfoFetchComponent(FetchAudienceInfoMethod fetchAudienceInfoMethod, AudienceEducatorManager audienceEducatorManager) {
        this.f3323a = fetchAudienceInfoMethod;
        this.f3324b = audienceEducatorManager;
    }

    public final long co_() {
        return 86400000;
    }

    public final BatchComponent mo101b() {
        return new MyBatchComponent(this);
    }
}
