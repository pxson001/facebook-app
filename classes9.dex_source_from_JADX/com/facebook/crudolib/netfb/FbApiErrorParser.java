package com.facebook.crudolib.netfb;

import android.util.JsonReader;
import android.util.JsonToken;
import com.facebook.crudolib.json.TranslatorHelper;
import com.facebook.crudolib.netfb.FbApiException.ErrorDomain;
import java.io.StringReader;
import javax.annotation.Nullable;

/* compiled from: TimelineRefresherQuery */
public class FbApiErrorParser {
    public int f24078a;
    @Nullable
    public String f24079b;
    @Nullable
    public String f24080c;
    public boolean f24081d;
    @Nullable
    public Integer f24082e;
    @Nullable
    public String f24083f;
    public boolean f24084g;
    public boolean f24085h;
    public int f24086i;
    @Nullable
    public String f24087j;
    @Nullable
    public String f24088k;
    @Nullable
    public String f24089l;
    public boolean f24090m;

    public static void m26034a(String str) {
        FbApiErrorParser fbApiErrorParser = new FbApiErrorParser();
        try {
            fbApiErrorParser.m26033a(new JsonReader(new StringReader(str)));
            fbApiErrorParser.m26032a();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void m26033a(JsonReader jsonReader) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            boolean z;
            String nextName = jsonReader.nextName();
            boolean z2;
            if (this.f24085h) {
                z2 = true;
                if ("code".equals(nextName)) {
                    this.f24086i = TranslatorHelper.m25952a(jsonReader, 1);
                    this.f24090m = true;
                } else if ("description".equals(nextName)) {
                    this.f24089l = TranslatorHelper.m25953a(jsonReader);
                } else if ("message".equals(nextName)) {
                    this.f24087j = TranslatorHelper.m25953a(jsonReader);
                } else if ("error_data".equals(nextName)) {
                    this.f24088k = TranslatorHelper.m25953a(jsonReader);
                } else {
                    z2 = false;
                }
                z = z2;
            } else {
                z2 = true;
                if ("error_code".equals(nextName)) {
                    this.f24078a = TranslatorHelper.m25952a(jsonReader, 1);
                    this.f24081d = true;
                } else if ("error_msg".equals(nextName)) {
                    this.f24079b = TranslatorHelper.m25953a(jsonReader);
                } else if ("error_data".equals(nextName)) {
                    this.f24080c = TranslatorHelper.m25953a(jsonReader);
                } else if ("error".equals(nextName)) {
                    if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                        Integer num;
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            num = null;
                        } else {
                            num = Integer.valueOf(jsonReader.nextInt());
                        }
                        this.f24082e = num;
                        this.f24084g = true;
                    } else {
                        this.f24085h = true;
                        jsonReader.beginObject();
                    }
                } else if ("error_description".equals(nextName)) {
                    this.f24083f = TranslatorHelper.m25953a(jsonReader);
                } else {
                    z2 = false;
                }
                z = z2;
            }
            if (!z) {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private void m26032a() {
        FbApiException fbApiException = this.f24081d ? new FbApiException(this.f24078a, this.f24079b, this.f24080c, ErrorDomain.API_EC_DOMAIN) : this.f24084g ? new FbApiException(this.f24082e.intValue(), this.f24083f, null, ErrorDomain.API_EC_DOMAIN) : this.f24085h ? (!this.f24090m || this.f24089l == null) ? this.f24087j != null ? new FbApiException(this.f24086i, this.f24087j, this.f24088k, ErrorDomain.API_EC_DOMAIN) : new FbApiException(1, null, null, ErrorDomain.API_EC_DOMAIN) : new FbApiException(this.f24086i, this.f24089l, null, ErrorDomain.GRAPHQL_KERROR_DOMAIN) : null;
        FbApiException fbApiException2 = fbApiException;
        if (fbApiException2 != null) {
            throw fbApiException2;
        }
    }
}
