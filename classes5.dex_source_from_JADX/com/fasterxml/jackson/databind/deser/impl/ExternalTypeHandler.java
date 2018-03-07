package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: className */
public class ExternalTypeHandler {
    private final ExtTypedProperty[] f6030a;
    private final HashMap<String, Integer> f6031b;
    private final String[] f6032c;
    private final TokenBuffer[] f6033d;

    /* compiled from: className */
    public class Builder {
        private final ArrayList<ExtTypedProperty> f6025a = new ArrayList();
        private final HashMap<String, Integer> f6026b = new HashMap();

        public final void m11037a(SettableBeanProperty settableBeanProperty, TypeDeserializer typeDeserializer) {
            Integer valueOf = Integer.valueOf(this.f6025a.size());
            this.f6025a.add(new ExtTypedProperty(settableBeanProperty, typeDeserializer));
            this.f6026b.put(settableBeanProperty._propName, valueOf);
            this.f6026b.put(typeDeserializer.mo694b(), valueOf);
        }

        public final ExternalTypeHandler m11036a() {
            return new ExternalTypeHandler((ExtTypedProperty[]) this.f6025a.toArray(new ExtTypedProperty[this.f6025a.size()]), this.f6026b, null, null);
        }
    }

    /* compiled from: className */
    public final class ExtTypedProperty {
        public final SettableBeanProperty f6027a;
        private final TypeDeserializer f6028b;
        public final String f6029c;

        public ExtTypedProperty(SettableBeanProperty settableBeanProperty, TypeDeserializer typeDeserializer) {
            this.f6027a = settableBeanProperty;
            this.f6028b = typeDeserializer;
            this.f6029c = typeDeserializer.mo694b();
        }

        public final boolean m11039a(String str) {
            return str.equals(this.f6029c);
        }

        public final boolean m11038a() {
            return this.f6028b.mo696d() != null;
        }

        public final String m11040b() {
            Class d = this.f6028b.mo696d();
            if (d == null) {
                return null;
            }
            return this.f6028b.mo695c().mo717a(null, d);
        }

        public final String m11041c() {
            return this.f6029c;
        }

        public final SettableBeanProperty m11042d() {
            return this.f6027a;
        }
    }

    protected ExternalTypeHandler(ExtTypedProperty[] extTypedPropertyArr, HashMap<String, Integer> hashMap, String[] strArr, TokenBuffer[] tokenBufferArr) {
        this.f6030a = extTypedPropertyArr;
        this.f6031b = hashMap;
        this.f6032c = strArr;
        this.f6033d = tokenBufferArr;
    }

    private ExternalTypeHandler(ExternalTypeHandler externalTypeHandler) {
        this.f6030a = externalTypeHandler.f6030a;
        this.f6031b = externalTypeHandler.f6031b;
        int length = this.f6030a.length;
        this.f6032c = new String[length];
        this.f6033d = new TokenBuffer[length];
    }

    public final ExternalTypeHandler m11045a() {
        return new ExternalTypeHandler(this);
    }

    public final boolean m11048a(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) {
        Object obj2 = null;
        Integer num = (Integer) this.f6031b.get(str);
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        if (!this.f6030a[intValue].m11039a(str)) {
            return false;
        }
        String o = jsonParser.o();
        if (!(obj == null || this.f6033d[intValue] == null)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            m11044a(jsonParser, deserializationContext, obj, intValue, o);
            this.f6033d[intValue] = null;
        } else {
            this.f6032c[intValue] = o;
        }
        return true;
    }

    public final boolean m11049b(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) {
        boolean z = false;
        Integer num = (Integer) this.f6031b.get(str);
        if (num == null) {
            return false;
        }
        boolean z2;
        int intValue = num.intValue();
        if (this.f6030a[intValue].m11039a(str)) {
            this.f6032c[intValue] = jsonParser.o();
            jsonParser.f();
            if (obj == null || this.f6033d[intValue] == null) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
            tokenBuffer.b(jsonParser);
            this.f6033d[intValue] = tokenBuffer;
            if (!(obj == null || this.f6032c[intValue] == null)) {
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            String str2 = this.f6032c[intValue];
            this.f6032c[intValue] = null;
            m11044a(jsonParser, deserializationContext, obj, intValue, str2);
            this.f6033d[intValue] = null;
        }
        return true;
    }

    public final Object m11047a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        int length = this.f6030a.length;
        for (int i = 0; i < length; i++) {
            String str = this.f6032c[i];
            String str2;
            if (str == null) {
                TokenBuffer tokenBuffer = this.f6033d[i];
                if (tokenBuffer != null) {
                    JsonToken j = tokenBuffer.j();
                    if (j != null && j.isScalarValue()) {
                        JsonParser a = tokenBuffer.a(jsonParser);
                        a.c();
                        SettableBeanProperty settableBeanProperty = this.f6030a[i].f6027a;
                        Object a2 = TypeDeserializer.m11380a(a, deserializationContext, settableBeanProperty.m10920a());
                        if (a2 != null) {
                            settableBeanProperty.mo649a(obj, a2);
                        } else if (this.f6030a[i].m11038a()) {
                            str = this.f6030a[i].m11040b();
                        } else {
                            throw deserializationContext.c("Missing external type id property '" + this.f6030a[i].f6029c + "'");
                        }
                    }
                    str2 = str;
                    m11044a(jsonParser, deserializationContext, obj, i, str2);
                } else {
                    continue;
                }
            } else if (this.f6033d[i] == null) {
                throw deserializationContext.c("Missing property '" + this.f6030a[i].f6027a._propName + "' for external type id '" + this.f6030a[i].f6029c);
            } else {
                str2 = str;
                m11044a(jsonParser, deserializationContext, obj, i, str2);
            }
        }
        return obj;
    }

    public final Object m11046a(JsonParser jsonParser, DeserializationContext deserializationContext, PropertyValueBuffer propertyValueBuffer, PropertyBasedCreator propertyBasedCreator) {
        int i;
        int length = this.f6030a.length;
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = this.f6032c[i2];
            if (str == null) {
                if (this.f6033d[i2] == null) {
                    continue;
                } else if (this.f6030a[i2].m11038a()) {
                    str = this.f6030a[i2].m11040b();
                } else {
                    throw deserializationContext.c("Missing external type id property '" + this.f6030a[i2].f6029c + "'");
                }
            } else if (this.f6033d[i2] == null) {
                throw deserializationContext.c("Missing property '" + this.f6030a[i2].f6027a._propName + "' for external type id '" + this.f6030a[i2].f6029c);
            }
            objArr[i2] = m11043a(jsonParser, deserializationContext, i2, str);
        }
        for (i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty = this.f6030a[i].f6027a;
            if (propertyBasedCreator.m11088a(settableBeanProperty._propName) != null) {
                propertyValueBuffer.m11106a(settableBeanProperty.mo654c(), objArr[i]);
            }
        }
        Object a = propertyBasedCreator.m11090a(deserializationContext, propertyValueBuffer);
        for (i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty2 = this.f6030a[i].f6027a;
            if (propertyBasedCreator.m11088a(settableBeanProperty2._propName) == null) {
                settableBeanProperty2.mo649a(a, objArr[i]);
            }
        }
        return a;
    }

    private Object m11043a(JsonParser jsonParser, DeserializationContext deserializationContext, int i, String str) {
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
        tokenBuffer.d();
        tokenBuffer.b(str);
        JsonParser a = this.f6033d[i].a(jsonParser);
        a.c();
        tokenBuffer.b(a);
        tokenBuffer.e();
        JsonParser a2 = tokenBuffer.a(jsonParser);
        a2.c();
        return this.f6030a[i].f6027a.m10922a(a2, deserializationContext);
    }

    private void m11044a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, int i, String str) {
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
        tokenBuffer.d();
        tokenBuffer.b(str);
        JsonParser a = this.f6033d[i].a(jsonParser);
        a.c();
        tokenBuffer.b(a);
        tokenBuffer.e();
        JsonParser a2 = tokenBuffer.a(jsonParser);
        a2.c();
        this.f6030a[i].f6027a.mo648a(a2, deserializationContext, obj);
    }
}
