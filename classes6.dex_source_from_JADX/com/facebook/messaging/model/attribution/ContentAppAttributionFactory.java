package com.facebook.messaging.model.attribution;

import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AppAttributionInfoModel;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AppAttributionInfoModel.MessengerAppAttributionVisibilityModel;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AttachmentAttributionModel.AttributionAppScopedIdsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel.BlobAttachmentsModel;
import com.facebook.messaging.platform.MessengerPlatformConfigManager;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user_generated */
public class ContentAppAttributionFactory {
    private final PlatformPackageUtilities f1930a;
    private final MessengerPlatformConfigManager f1931b;

    public static ContentAppAttributionFactory m3276b(InjectorLike injectorLike) {
        return new ContentAppAttributionFactory(PlatformPackageUtilities.m6010b(injectorLike), MessengerPlatformConfigManager.m3651a(injectorLike));
    }

    @Inject
    public ContentAppAttributionFactory(PlatformPackageUtilities platformPackageUtilities, MessengerPlatformConfigManager messengerPlatformConfigManager) {
        this.f1930a = platformPackageUtilities;
        this.f1931b = messengerPlatformConfigManager;
    }

    @Nullable
    public final ContentAppAttribution m3278a(BlobAttachmentsModel blobAttachmentsModel) {
        if (blobAttachmentsModel.m2118v() == null) {
            return null;
        }
        Builder builder = ImmutableMap.builder();
        ImmutableList w = blobAttachmentsModel.m2119w();
        int size = w.size();
        for (int i = 0; i < size; i++) {
            AttributionAppScopedIdsModel attributionAppScopedIdsModel = (AttributionAppScopedIdsModel) w.get(i);
            if (!(attributionAppScopedIdsModel.m793b() == null || attributionAppScopedIdsModel.m792a() == null)) {
                builder.b(attributionAppScopedIdsModel.m793b(), attributionAppScopedIdsModel.m792a());
            }
        }
        ContentAppAttributionBuilder a = m3274a(ContentAppAttribution.newBuilder(), blobAttachmentsModel.m2118v());
        a.f1923b = blobAttachmentsModel.m2118v().m785k();
        a = a;
        a.f1927f = blobAttachmentsModel.m2120x();
        a = a;
        a.f1922a = blobAttachmentsModel.m2116t();
        return a.m3269a(builder.b()).m3273i();
    }

    public final ContentAppAttribution m3279a(ContentAppAttribution contentAppAttribution, AppAttributionInfoModel appAttributionInfoModel) {
        return m3274a(ContentAppAttribution.newBuilder().m3268a(contentAppAttribution), appAttributionInfoModel).m3273i();
    }

    private ContentAppAttributionBuilder m3274a(ContentAppAttributionBuilder contentAppAttributionBuilder, AppAttributionInfoModel appAttributionInfoModel) {
        contentAppAttributionBuilder.f1924c = appAttributionInfoModel.m787m();
        if (appAttributionInfoModel.m784j() != null) {
            contentAppAttributionBuilder.f1926e = appAttributionInfoModel.m784j().m764a();
        }
        MessengerAppAttributionVisibilityModel l = appAttributionInfoModel.m786l();
        AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
        newBuilder.f1909a = l.m771a();
        newBuilder = newBuilder;
        newBuilder.f1911c = l.m772j();
        newBuilder = newBuilder;
        newBuilder.f1912d = l.m773k();
        newBuilder = newBuilder;
        newBuilder.f1913e = l.m772j();
        contentAppAttributionBuilder.f1929h = newBuilder.m3267h();
        return contentAppAttributionBuilder;
    }

    public final ContentAppAttribution m3277a(Intent intent, String str) {
        String stringExtra;
        String a;
        int i = -1;
        int intExtra = intent.getIntExtra("com.facebook.orca.extra.PROTOCOL_VERSION", i);
        if (intExtra == i) {
            String stringExtra2 = intent.getStringExtra("com.facebook.orca.extra.PROTOCOL_VERSION");
            if (stringExtra2 != null) {
                try {
                    i = Integer.parseInt(stringExtra2);
                } catch (NumberFormatException e) {
                }
                if (!this.f1931b.m3654a(20141218, i)) {
                    return null;
                }
                stringExtra = intent.getStringExtra("com.facebook.orca.extra.APPLICATION_ID");
                if (stringExtra == null) {
                    return null;
                }
                a = this.f1930a.m6012a(str);
                if (a == null) {
                    return null;
                }
                return ContentAppAttribution.newBuilder().m3270b(stringExtra).m3271d(a).m3272f(m3275a(intent.getStringExtra("com.facebook.orca.extra.METADATA"))).m3273i();
            }
        }
        i = intExtra;
        if (!this.f1931b.m3654a(20141218, i)) {
            return null;
        }
        stringExtra = intent.getStringExtra("com.facebook.orca.extra.APPLICATION_ID");
        if (stringExtra == null) {
            return null;
        }
        a = this.f1930a.m6012a(str);
        if (a == null) {
            return null;
        }
        return ContentAppAttribution.newBuilder().m3270b(stringExtra).m3271d(a).m3272f(m3275a(intent.getStringExtra("com.facebook.orca.extra.METADATA"))).m3273i();
    }

    @Nullable
    private static String m3275a(@Nullable String str) {
        return (str == null || str.length() > 262144) ? null : str;
    }
}
