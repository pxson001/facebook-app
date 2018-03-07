package com.facebook.crudolib.params;

import com.facebook.crudolib.urlencode.UrlEncodingWriter;
import java.io.Writer;

/* compiled from: no transformation requested */
public final class ParamsFormEncoder implements ParamsEncoder {
    private static ParamsFormEncoder f12242a;

    public static synchronized ParamsFormEncoder m18192a() {
        ParamsFormEncoder paramsFormEncoder;
        synchronized (ParamsFormEncoder.class) {
            if (f12242a == null) {
                f12242a = new ParamsFormEncoder();
            }
            paramsFormEncoder = f12242a;
        }
        return paramsFormEncoder;
    }

    public final void mo746a(Writer writer, ParamsCollection paramsCollection) {
        Writer urlEncodingWriter = new UrlEncodingWriter(writer);
        ParamsCollectionMap paramsCollectionMap = (ParamsCollectionMap) paramsCollection;
        int i = paramsCollectionMap.f3273c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                writer.write(38);
            }
            urlEncodingWriter.write(paramsCollectionMap.m5423b(i2));
            Object c = paramsCollectionMap.m5426c(i2);
            if (c != null) {
                writer.write(61);
                if (c instanceof String) {
                    urlEncodingWriter.write((String) c);
                } else if (c instanceof Number) {
                    NumberFormatHelper.m5729a().m5731a(urlEncodingWriter, (Number) c);
                } else if (c instanceof ParamsCollection) {
                    ((ParamsCollection) c).m5440a(urlEncodingWriter, this);
                } else {
                    throw new IllegalArgumentException("The type of '" + paramsCollectionMap.m5423b(i2) + " is " + c.getClass().toString() + " is not allowed");
                }
            }
        }
    }
}
