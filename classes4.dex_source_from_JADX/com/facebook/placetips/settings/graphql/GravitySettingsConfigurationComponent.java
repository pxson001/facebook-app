package com.facebook.placetips.settings.graphql;

import com.facebook.config.background.AbstractConfigurationAndLoginComponent;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.Lazy;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.AccessorFuture;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: rssi100 */
public class GravitySettingsConfigurationComponent extends AbstractConfigurationAndLoginComponent {
    public final Provider<FetchGravitySettingsMethod> f3320a;
    public final Lazy<AccessorFuture> f3321b;

    /* compiled from: rssi100 */
    class C01511 implements BatchComponent {
        final /* synthetic */ GravitySettingsConfigurationComponent f3322a;

        C01511(GravitySettingsConfigurationComponent gravitySettingsConfigurationComponent) {
            this.f3322a = gravitySettingsConfigurationComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a((ApiMethod) this.f3322a.f3320a.get(), null);
            a.f11927c = "fetch_gravity_settings_operation";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) map.get("fetch_gravity_settings_operation");
            if (gravitySettingsGraphQlFragmentModel != null) {
                GravitySettingsConfigurationComponent gravitySettingsConfigurationComponent = this.f3322a;
                Futures.a((ListenableFuture) gravitySettingsConfigurationComponent.f3321b.get(), new C01622(gravitySettingsConfigurationComponent, gravitySettingsGraphQlFragmentModel), MoreExecutors.a());
            }
        }
    }

    /* compiled from: rssi100 */
    public class C01622 implements FutureCallback<Accessor> {
        final /* synthetic */ GravitySettingsGraphQlFragmentModel f3537a;
        final /* synthetic */ GravitySettingsConfigurationComponent f3538b;

        public C01622(GravitySettingsConfigurationComponent gravitySettingsConfigurationComponent, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel) {
            this.f3538b = gravitySettingsConfigurationComponent;
            this.f3537a = gravitySettingsGraphQlFragmentModel;
        }

        public void onSuccess(Object obj) {
            ((Accessor) obj).a(this.f3537a);
        }

        public void onFailure(Throwable th) {
            throw new Error(th);
        }
    }

    @Inject
    public GravitySettingsConfigurationComponent(Provider<FetchGravitySettingsMethod> provider, Lazy<AccessorFuture> lazy) {
        this.f3320a = provider;
        this.f3321b = lazy;
    }

    public final BatchComponent mo149c() {
        return new C01511(this);
    }

    public final long co_() {
        return 14400000;
    }
}
