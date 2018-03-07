package com.facebook.messaging.payment.database.serialization;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PlatformItemModel;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: inline */
public class DbPlatformItemSerialization {
    private final ObjectMapper f12997a;
    private final AbstractFbErrorReporter f12998b;

    public static DbPlatformItemSerialization m13287b(InjectorLike injectorLike) {
        return new DbPlatformItemSerialization((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbPlatformItemSerialization(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12997a = objectMapper;
        this.f12998b = abstractFbErrorReporter;
    }

    @Nullable
    public final String m13289a(@Nullable PlatformItemModel platformItemModel) {
        TracerDetour.a("serializePlatformItem", 1736359065);
        if (platformItemModel == null) {
            TracerDetour.a(-1751309066);
            return null;
        }
        try {
            String a = this.f12997a.a(platformItemModel);
            TracerDetour.a(526372890);
            return a;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable th) {
            TracerDetour.a(-1595363953);
        }
    }

    @Nullable
    public final PlatformItemModel m13288a(@Nullable String str) {
        int i = 0;
        TracerDetour.a("deserializePlatformItem", -542339172);
        if (str == null) {
            TracerDetour.a(440985525);
            return null;
        }
        PlatformItemModel platformItemModel;
        try {
            platformItemModel = (PlatformItemModel) this.f12997a.a(str, PlatformItemModel.class);
        } catch (IOException e) {
            this.f12998b.a("DbPlatformItemSerialization", "IO Exception when reading PlatformItem from JSON string.");
            return i;
        } finally {
            i = 941432831;
            TracerDetour.a(941432831);
        }
        return platformItemModel;
    }
}
