package com.facebook.appirater.api;

import com.facebook.appirater.Appirater;
import com.facebook.appirater.InternalStarRatingController;
import com.facebook.config.background.AbstractConfigurationAndLoginComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: rtc_initial_bitrate_uni */
public class InternalStarRatingConfigComponent extends AbstractConfigurationAndLoginComponent {
    private final Appirater f3265a;
    public final InternalStarRatingController f3266b;
    public final AppRaterShouldAskUserApiMethod f3267c;
    private final BatchComponent f3268d = new C01491(this);

    /* compiled from: rtc_initial_bitrate_uni */
    class C01491 implements BatchComponent {
        final /* synthetic */ InternalStarRatingConfigComponent f3275a;

        C01491(InternalStarRatingConfigComponent internalStarRatingConfigComponent) {
            this.f3275a = internalStarRatingConfigComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f3275a.f3267c, null);
            a.f11927c = "isr_ping_operation";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            FetchISRConfigResult fetchISRConfigResult = (FetchISRConfigResult) map.get("isr_ping_operation");
            if (fetchISRConfigResult != null && fetchISRConfigResult.a()) {
                InternalStarRatingController internalStarRatingController = this.f3275a.f3266b;
                internalStarRatingController.f7402q = fetchISRConfigResult;
                internalStarRatingController.f7388c.m7711a(fetchISRConfigResult);
            }
        }
    }

    @Inject
    public InternalStarRatingConfigComponent(Appirater appirater, InternalStarRatingController internalStarRatingController, AppRaterShouldAskUserApiMethod appRaterShouldAskUserApiMethod) {
        this.f3265a = appirater;
        this.f3266b = internalStarRatingController;
        this.f3267c = appRaterShouldAskUserApiMethod;
    }

    public final BatchComponent mo149c() {
        if (!this.f3266b.m7703a()) {
            return null;
        }
        this.f3265a.m7685a();
        if (this.f3266b.m7705e()) {
            return this.f3268d;
        }
        return null;
    }

    public final long co_() {
        return 7200000;
    }
}
