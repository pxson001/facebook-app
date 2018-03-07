package com.facebook.messaging.payment.database.serialization;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: initial_pinned_location */
public class DbThemeSerialization {
    private final ObjectMapper f12999a;
    private final AbstractFbErrorReporter f13000b;

    public static DbThemeSerialization m13290b(InjectorLike injectorLike) {
        return new DbThemeSerialization((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DbThemeSerialization(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12999a = objectMapper;
        this.f13000b = abstractFbErrorReporter;
    }

    @Nullable
    public final String m13292a(@Nullable ThemeModel themeModel) {
        TracerDetour.a("serializeTheme", -462462056);
        if (themeModel == null) {
            TracerDetour.a(-1248435950);
            return null;
        }
        try {
            String a = this.f12999a.a(themeModel);
            TracerDetour.a(-1158429589);
            return a;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable th) {
            TracerDetour.a(2017965737);
        }
    }

    @Nullable
    public final ThemeModel m13291a(@Nullable String str) {
        int i = 0;
        TracerDetour.a("deserializeTheme", 1916219867);
        if (str == null) {
            TracerDetour.a(-819807041);
            return null;
        }
        ThemeModel themeModel;
        try {
            themeModel = (ThemeModel) this.f12999a.a(str, ThemeModel.class);
        } catch (IOException e) {
            this.f13000b.a("DbThemeSerialization", "IO Exception when reading Theme from JSON string.");
            return i;
        } finally {
            i = -1370078979;
            TracerDetour.a(-1370078979);
        }
        return themeModel;
    }
}
