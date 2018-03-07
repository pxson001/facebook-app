package com.facebook.facerec.recog;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.facerec.manager.LocalSuggestionsStore;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.tagging.model.TaggingProfile;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: no_profile_image_urls */
public class FaceRecResponse {
    private final LocalSuggestionsStore f9950a;
    public final Map<String, List<TaggingProfile>> f9951b = Maps.c();

    public FaceRecResponse(LocalSuggestionsStore localSuggestionsStore) {
        this.f9950a = localSuggestionsStore;
    }

    public final FaceRecResponse m15665a(ApiResponse apiResponse, AbstractFbErrorReporter abstractFbErrorReporter) {
        JsonNode c = apiResponse.c();
        if (c == null) {
            abstractFbErrorReporter.a("FaceRecResponse", "ResponseNode was null: " + apiResponse.c.toString());
        } else {
            Map c2 = Maps.c();
            Map c3 = Maps.c();
            Iterator H = c.H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                String str = (String) entry.getKey();
                c = (JsonNode) entry.getValue();
                JsonNode b = c.b("error");
                if (b != null) {
                    abstractFbErrorReporter.a("FaceRecResponse crop error", b.b("type") + ": " + b.b("message"));
                } else {
                    c = c.b("tags");
                    if (c == null) {
                        abstractFbErrorReporter.a("FaceRecResponse crop error", "No error and no suggestions");
                    } else if (c.e() != 1) {
                        abstractFbErrorReporter.a("FaceRecResponse crop error", "Got " + c.e() + " faceboxes for a crop");
                    } else {
                        c = c.a(0).b("suggestions");
                        if (c == null) {
                            abstractFbErrorReporter.a("FaceRecResponse crop error", "No suggestions included for crop");
                        } else {
                            Map c4 = Maps.c();
                            List a = Lists.a();
                            Iterator G = c.G();
                            while (G.hasNext()) {
                                c = (JsonNode) G.next();
                                JsonNode b2 = c.b("id");
                                if (b2 == null || Strings.isNullOrEmpty(b2.B())) {
                                    abstractFbErrorReporter.a("FaceRecResponse crop error", "No id included in the suggestion");
                                } else {
                                    a.add(b2.B());
                                    c = c.b("score");
                                    if (c != null) {
                                        c4.put(Long.valueOf(b2.D()), Double.valueOf(c.y()));
                                    }
                                }
                            }
                            c3.put(str, a);
                            c2.put(str, c4);
                        }
                    }
                }
            }
            c3 = this.f9950a.m15643a(c3);
            for (String str2 : c3.keySet()) {
                this.f9951b.put(str2, c3.get(str2));
                new StringBuilder("Suggestions for crop: ").append(str2);
                Map map = (Map) c2.get(str2);
                for (TaggingProfile taggingProfile : (List) c3.get(str2)) {
                    new StringBuilder().append(taggingProfile.m25529a()).append(", Score: ").append(map.get(Long.valueOf(taggingProfile.m25530b())));
                }
            }
        }
        return this;
    }
}
