package com.facebook.messaging.xma;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: login_location_timestamp_ms */
public class XMASerialization {
    private final FbObjectMapper f8844a;
    private final AbstractFbErrorReporter f8845b;

    public static XMASerialization m9195a(InjectorLike injectorLike) {
        return new XMASerialization(FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public XMASerialization(FbObjectMapper fbObjectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8844a = fbObjectMapper;
        this.f8845b = abstractFbErrorReporter;
    }

    @Nullable
    public final String m9197a(@Nullable XMAModel xMAModel) {
        if (xMAModel == null) {
            return null;
        }
        try {
            return this.f8844a.a(xMAModel);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public final XMAModel m9196a(@Nullable String str) {
        Throwable e;
        if (str == null) {
            return null;
        }
        try {
            return (XMAModel) this.f8844a.a(str, XMAModel.class);
        } catch (JsonParseException e2) {
            e = e2;
            throw new IllegalArgumentException(e);
        } catch (JsonMappingException e3) {
            e = e3;
            throw new IllegalArgumentException(e);
        } catch (IOException e4) {
            this.f8845b.a("XMA", "IO Exception when reading XMA from JSON string.");
            return null;
        }
    }

    @Nullable
    public final XMAModel m9198b(@Nullable String str) {
        Throwable e;
        if (str == null) {
            return null;
        }
        try {
            return (XMAModel) ((HashMap) this.f8844a.a(str, this.f8844a.c().a(HashMap.class, String.class, XMAModel.class))).values().iterator().next();
        } catch (JsonParseException e2) {
            e = e2;
            throw new IllegalArgumentException(e);
        } catch (JsonMappingException e3) {
            e = e3;
            throw new IllegalArgumentException(e);
        } catch (IOException e4) {
            this.f8845b.a("XMA", "IO Exception when reading XMA from JSON string.");
            return null;
        }
    }
}
