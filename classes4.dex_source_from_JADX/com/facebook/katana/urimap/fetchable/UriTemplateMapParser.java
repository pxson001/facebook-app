package com.facebook.katana.urimap.fetchable;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.common.uri.UriTemplateMap.InvalidUriTemplateException;
import com.facebook.debug.log.BLog;
import com.facebook.katana.urimap.api.UriHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: suggested_facebook_user */
public class UriTemplateMapParser {
    private final FacewebUriHandlerBuilder f1572a;
    private final Map<String, String> f1573b;
    private final String f1574c;

    /* compiled from: suggested_facebook_user */
    class C00991 extends TypeReference<Map<String, String>> {
        final /* synthetic */ UriTemplateMapParser f2006b;

        C00991(UriTemplateMapParser uriTemplateMapParser) {
            this.f2006b = uriTemplateMapParser;
        }
    }

    public UriTemplateMapParser(HandlerBuilder handlerBuilder, Map<String, String> map, String str) {
        this.f1572a = handlerBuilder;
        this.f1573b = map;
        this.f1574c = str;
    }

    public final UriTemplateMap<UriHandler> m1792a(String str) {
        try {
            Object a = FbObjectMapper.i().a(str, new C00991(this));
            if (a == null || !(a instanceof Map)) {
                return null;
            }
            Map map = (Map) a;
            UriTemplateMap<UriHandler> uriTemplateMap = new UriTemplateMap();
            for (Entry entry : this.f1573b.entrySet()) {
                try {
                    uriTemplateMap.a((String) entry.getKey(), this.f1572a.m1790a((String) entry.getValue()));
                } catch (InvalidUriTemplateException e) {
                    BLog.b(this.f1574c, e, "Invalid uri template: %s", new Object[]{r2});
                    throw e;
                }
            }
            for (Entry entry2 : map.entrySet()) {
                try {
                    uriTemplateMap.a((String) entry2.getKey(), this.f1572a.m1790a((String) entry2.getValue()));
                } catch (InvalidUriTemplateException e2) {
                    BLog.b(this.f1574c, e2, "Invalid uri template: %s", new Object[]{r1});
                }
            }
            return uriTemplateMap;
        } catch (IOException e3) {
            return null;
        }
    }
}
