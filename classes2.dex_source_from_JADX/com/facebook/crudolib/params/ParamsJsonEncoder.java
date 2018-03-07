package com.facebook.crudolib.params;

import java.io.Writer;
import javax.annotation.Nullable;

/* compiled from: tail_fetch_timeout_seconds */
public final class ParamsJsonEncoder implements ParamsEncoder {
    private static ParamsJsonEncoder f3284a;

    public static synchronized ParamsJsonEncoder m5454a() {
        ParamsJsonEncoder paramsJsonEncoder;
        synchronized (ParamsJsonEncoder.class) {
            if (f3284a == null) {
                f3284a = new ParamsJsonEncoder();
            }
            paramsJsonEncoder = f3284a;
        }
        return paramsJsonEncoder;
    }

    private void m5460b(Writer writer, ParamsCollectionMap paramsCollectionMap) {
        int i = paramsCollectionMap.f3273c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                writer.write(44);
            }
            String b = paramsCollectionMap.m5423b(i2);
            m5457a(writer, b);
            writer.write(58);
            m5458a(writer, b, paramsCollectionMap.m5426c(i2));
        }
    }

    public final void mo746a(Writer writer, ParamsCollection paramsCollection) {
        if (paramsCollection instanceof ParamsCollectionMap) {
            m5456a(writer, (ParamsCollectionMap) paramsCollection);
        } else {
            m5455a(writer, (ParamsCollectionArray) paramsCollection);
        }
    }

    private void m5456a(Writer writer, ParamsCollectionMap paramsCollectionMap) {
        writer.write(123);
        m5460b(writer, paramsCollectionMap);
        writer.write(125);
    }

    private void m5455a(Writer writer, ParamsCollectionArray paramsCollectionArray) {
        writer.write(91);
        m5459b(writer, paramsCollectionArray);
        writer.write(93);
    }

    public final void m5463b(Writer writer, ParamsCollection paramsCollection) {
        if (paramsCollection instanceof ParamsCollectionMap) {
            m5460b(writer, (ParamsCollectionMap) paramsCollection);
        } else {
            m5459b(writer, (ParamsCollectionArray) paramsCollection);
        }
    }

    private void m5459b(Writer writer, ParamsCollectionArray paramsCollectionArray) {
        int j = paramsCollectionArray.m11506j();
        for (int i = 0; i < j; i++) {
            if (i > 0) {
                writer.write(44);
            }
            m5458a(writer, null, paramsCollectionArray.m11501b(i));
        }
    }

    private void m5458a(Writer writer, @Nullable String str, @Nullable Object obj) {
        if (obj == null) {
            writer.write("null");
        } else if (obj instanceof String) {
            m5457a(writer, (String) obj);
        } else if (obj instanceof Number) {
            NumberFormatHelper.m5729a().m5731a(writer, (Number) obj);
        } else if (obj instanceof Boolean) {
            writer.write(((Boolean) obj).booleanValue() ? "true" : "false");
        } else if (obj instanceof ParamsCollection) {
            m5461c(writer, (ParamsCollection) obj);
        } else {
            String str2 = "";
            if (str != null) {
                str2 = " (found in key '" + str + "')";
            }
            throw new IllegalArgumentException("The type " + obj.getClass().toString() + " is not supported" + str2);
        }
    }

    private void m5461c(Writer writer, ParamsCollection paramsCollection) {
        int b = paramsCollection.m5441b(ParamsJsonEncoder.class, 0);
        Class cls = paramsCollection.m5442b(this).getClass();
        if (cls.equals(ParamsJsonEncoder.class) && b == 0) {
            paramsCollection.m5440a(writer, this);
        } else if ((b & 1) != 0) {
            writer.write(34);
            Writer jsonEncodingWriter = new JsonEncodingWriter(writer);
            try {
                paramsCollection.m5440a(jsonEncodingWriter, this);
                writer.write(34);
            } finally {
                jsonEncodingWriter.flush();
            }
        } else {
            throw new IllegalStateException("Unsupported encoder=" + cls + ", flags=" + b + " combination");
        }
    }

    private static void m5457a(Writer writer, String str) {
        writer.write(34);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            JsonEncodingWriter.m5728a(writer, str.charAt(i));
        }
        writer.write(34);
    }
}
