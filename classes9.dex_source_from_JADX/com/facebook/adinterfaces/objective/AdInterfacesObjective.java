package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: [applinks]katana_and_wakizashi_not_installed */
public interface AdInterfacesObjective<E extends AdInterfacesDataModel> {
    public static final AdInterfacesComponentStatus f21830a;
    public static final AdInterfacesComponentStatus f21831b;
    public static final AdInterfacesComponentStatus f21832c;
    public static final AdInterfacesComponentStatus f21833d;
    public static final AdInterfacesComponentStatus f21834e;
    public static final AdInterfacesComponentStatus f21835f = new C25211();

    /* compiled from: [applinks]katana_and_wakizashi_not_installed */
    final class C25211 implements AdInterfacesComponentStatus {
        C25211() {
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            return AdInterfacesDataHelper.m22811g(baseAdInterfacesData) && AdInterfacesDataHelper.m22815k(baseAdInterfacesData);
        }
    }

    ImmutableList<AdInterfacesComponent<?, ? super E>> mo968a();

    void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback);

    static {
        AdInterfacesComponentStatusBuilder newBuilder = AdInterfacesComponentStatusBuilder.newBuilder();
        newBuilder.f21828a = ImmutableList.of(AdInterfacesStatus.INACTIVE, AdInterfacesStatus.NEVER_BOOSTED, AdInterfacesStatus.ACTIVE, AdInterfacesStatus.PAUSED, AdInterfacesStatus.EXTENDABLE, AdInterfacesStatus.CREATING, AdInterfacesStatus.FINISHED, AdInterfacesStatus.PENDING, AdInterfacesStatus.REJECTED);
        f21830a = newBuilder.m22909a();
        AdInterfacesComponentStatusBuilder newBuilder2 = AdInterfacesComponentStatusBuilder.newBuilder();
        newBuilder2.f21828a = ImmutableList.of(AdInterfacesStatus.INACTIVE, AdInterfacesStatus.NEVER_BOOSTED, AdInterfacesStatus.ACTIVE, AdInterfacesStatus.PAUSED, AdInterfacesStatus.EXTENDABLE, AdInterfacesStatus.CREATING, AdInterfacesStatus.FINISHED, AdInterfacesStatus.PENDING, AdInterfacesStatus.REJECTED, AdInterfacesStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        f21831b = newBuilder2.m22909a();
        AdInterfacesComponentStatusBuilder newBuilder3 = AdInterfacesComponentStatusBuilder.newBuilder();
        newBuilder3.f21828a = ImmutableList.of(AdInterfacesStatus.INACTIVE, AdInterfacesStatus.NEVER_BOOSTED, AdInterfacesStatus.REJECTED, AdInterfacesStatus.FINISHED, AdInterfacesStatus.PAUSED);
        f21832c = newBuilder3.m22909a();
        newBuilder3 = AdInterfacesComponentStatusBuilder.newBuilder();
        newBuilder3.f21828a = ImmutableList.of(AdInterfacesStatus.CREATING, AdInterfacesStatus.ACTIVE, AdInterfacesStatus.PENDING, AdInterfacesStatus.PAUSED);
        f21833d = newBuilder3.m22909a();
        AdInterfacesComponentStatusBuilder newBuilder4 = AdInterfacesComponentStatusBuilder.newBuilder();
        newBuilder4.f21828a = ImmutableList.of(AdInterfacesStatus.INACTIVE, AdInterfacesStatus.NEVER_BOOSTED, AdInterfacesStatus.ACTIVE, AdInterfacesStatus.PAUSED, AdInterfacesStatus.EXTENDABLE, AdInterfacesStatus.FINISHED, AdInterfacesStatus.PENDING, AdInterfacesStatus.REJECTED);
        f21834e = newBuilder4.m22909a();
    }
}
