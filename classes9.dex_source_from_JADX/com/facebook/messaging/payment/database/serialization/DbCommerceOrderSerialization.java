package com.facebook.messaging.payment.database.serialization;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.CommerceOrder;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: inline-data */
public class DbCommerceOrderSerialization {
    private final ObjectMapper f12995a;
    private final AbstractFbErrorReporter f12996b;

    public static DbCommerceOrderSerialization m13284b(InjectorLike injectorLike) {
        return new DbCommerceOrderSerialization((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbCommerceOrderSerialization(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12995a = objectMapper;
        this.f12996b = abstractFbErrorReporter;
    }

    @Nullable
    public final String m13286a(@Nullable CommerceOrder commerceOrder) {
        TracerDetour.a("serializeCommerceOrder", 200818975);
        if (commerceOrder == null) {
            TracerDetour.a(587914286);
            return null;
        }
        try {
            String a = this.f12995a.a(commerceOrder);
            TracerDetour.a(-321071149);
            return a;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable th) {
            TracerDetour.a(1295736177);
        }
    }

    @Nullable
    public final CommerceOrder m13285a(@Nullable String str) {
        int i = 0;
        TracerDetour.a("deserializeCommerceOrder", 1880608235);
        if (str == null) {
            TracerDetour.a(269678540);
            return null;
        }
        CommerceOrder commerceOrder;
        try {
            commerceOrder = (CommerceOrder) this.f12995a.a(str, CommerceOrder.class);
        } catch (IOException e) {
            this.f12996b.a("DbCommerceOrderSerialization", "IO Exception when reading CommerceOrder from JSON string.");
            return i;
        } finally {
            i = -726707447;
            TracerDetour.a(-726707447);
        }
        return commerceOrder;
    }
}
