package com.facebook.richdocument;

import android.content.Context;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;

@ContextScoped
/* compiled from: privacy_view */
public class RichDocumentInfo {
    private static RichDocumentInfo f5111i;
    private static final Object f5112j = new Object();
    private final ObjectMapper f5113a;
    public String f5114b;
    public String f5115c;
    public JsonNode f5116d;
    public boolean f5117e;
    public String f5118f;
    public RichDocumentStyleModel f5119g;
    public int f5120h;

    private static RichDocumentInfo m5103b(InjectorLike injectorLike) {
        return new RichDocumentInfo((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RichDocumentInfo(ObjectMapper objectMapper) {
        this.f5113a = objectMapper;
    }

    public final void m5105b(String str) {
        this.f5116d = null;
        if (!StringUtil.c(str)) {
            try {
                this.f5116d = this.f5113a.a(str);
            } catch (IOException e) {
            }
        }
    }

    public final String m5104b() {
        if (this.f5116d != null) {
            return this.f5116d.toString();
        }
        return null;
    }

    public static RichDocumentInfo m5102a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentInfo b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5112j) {
                RichDocumentInfo richDocumentInfo;
                if (a2 != null) {
                    richDocumentInfo = (RichDocumentInfo) a2.a(f5112j);
                } else {
                    richDocumentInfo = f5111i;
                }
                if (richDocumentInfo == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5103b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5112j, b3);
                        } else {
                            f5111i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentInfo;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final RichDocumentStyleModel m5106f() {
        return this.f5119g;
    }
}
