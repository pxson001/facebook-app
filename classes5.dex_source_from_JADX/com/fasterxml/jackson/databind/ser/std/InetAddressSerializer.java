package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.net.InetAddress;

/* compiled from: can_viewer_promote_local_awareness */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> {
    public static final InetAddressSerializer f6197a = new InetAddressSerializer();

    public final /* bridge */ /* synthetic */ void m11666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        m11665a((InetAddress) obj, jsonGenerator);
    }

    public final void m11667a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        obj = (InetAddress) obj;
        typeSerializer.mo705a(obj, jsonGenerator, InetAddress.class);
        m11665a(obj, jsonGenerator);
        typeSerializer.mo710d(obj, jsonGenerator);
    }

    public InetAddressSerializer() {
        super(InetAddress.class);
    }

    private static void m11665a(InetAddress inetAddress, JsonGenerator jsonGenerator) {
        String trim = inetAddress.toString().trim();
        int indexOf = trim.indexOf(47);
        if (indexOf >= 0) {
            if (indexOf == 0) {
                trim = trim.substring(1);
            } else {
                trim = trim.substring(0, indexOf);
            }
        }
        jsonGenerator.b(trim);
    }
}
