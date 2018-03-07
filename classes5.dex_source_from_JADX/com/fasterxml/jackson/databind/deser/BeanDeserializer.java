package com.fasterxml.jackson.databind.deser;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

/* compiled from: clientPackageName */
public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    /* compiled from: clientPackageName */
    /* synthetic */ class C05491 {
        static final /* synthetic */ int[] f5986a = new int[JsonToken.values().length];

        static {
            try {
                f5986a[JsonToken.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5986a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5986a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5986a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5986a[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5986a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5986a[JsonToken.START_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5986a[JsonToken.FIELD_NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5986a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public BeanDeserializer(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(beanDeserializerBuilder, beanDescription, beanPropertyMap, map, hashSet, z, z2);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase) {
        super(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, NameTransformer nameTransformer) {
        super(beanDeserializerBase, nameTransformer);
    }

    private BeanDeserializer(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase, objectIdReader);
    }

    private BeanDeserializer(BeanDeserializerBase beanDeserializerBase, HashSet<String> hashSet) {
        super(beanDeserializerBase, (HashSet) hashSet);
    }

    public JsonDeserializer<Object> mo641a(NameTransformer nameTransformer) {
        return getClass() != BeanDeserializer.class ? this : new BeanDeserializer((BeanDeserializerBase) this, nameTransformer);
    }

    public final BeanDeserializerBase mo642a(ObjectIdReader objectIdReader) {
        return new BeanDeserializer((BeanDeserializerBase) this, objectIdReader);
    }

    public final BeanDeserializerBase mo643a(HashSet hashSet) {
        return new BeanDeserializer((BeanDeserializerBase) this, hashSet);
    }

    protected final BeanDeserializerBase mo646e() {
        return new BeanAsArrayDeserializer(this, this._beanProperties.m11019b());
    }

    public final Object m10876a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g != JsonToken.START_OBJECT) {
            return m10866a(jsonParser, deserializationContext, g);
        }
        if (this._vanillaProcessing) {
            jsonParser.c();
            return m10871y(jsonParser, deserializationContext);
        }
        jsonParser.c();
        if (this._objectIdReader != null) {
            return m10853d(jsonParser, deserializationContext);
        }
        return mo644b(jsonParser, deserializationContext);
    }

    private final Object m10866a(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) {
        if (jsonToken == null) {
            return m10869b(deserializationContext);
        }
        switch (C05491.f5986a[jsonToken.ordinal()]) {
            case 1:
                return m10859g(jsonParser, deserializationContext);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return m10858f(jsonParser, deserializationContext);
            case 3:
                return m10860h(jsonParser, deserializationContext);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return jsonParser.D();
            case 5:
            case 6:
                return m10861i(jsonParser, deserializationContext);
            case 7:
                return m10862j(jsonParser, deserializationContext);
            case 8:
            case 9:
                if (this._vanillaProcessing) {
                    return m10871y(jsonParser, deserializationContext);
                }
                if (this._objectIdReader != null) {
                    return m10853d(jsonParser, deserializationContext);
                }
                return mo644b(jsonParser, deserializationContext);
            default:
                throw deserializationContext.b(m10857f());
        }
    }

    private Object m10869b(DeserializationContext deserializationContext) {
        throw deserializationContext.c(m10857f());
    }

    public final Object m10877a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        if (this._injectables != null) {
            m10846a(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            return m10868b(jsonParser, deserializationContext, obj);
        }
        if (this._externalTypeIdHandler != null) {
            return m10870c(jsonParser, deserializationContext, obj);
        }
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
        }
        if (this._needViewProcesing) {
            Class e = deserializationContext.e();
            if (e != null) {
                return m10867a(jsonParser, deserializationContext, obj, e);
            }
        }
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a = this._beanProperties.m11014a(i);
            if (a != null) {
                try {
                    a.mo648a(jsonParser, deserializationContext, obj);
                } catch (Throwable e2) {
                    m10848a(e2, obj, i, deserializationContext);
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(i)) {
                jsonParser.f();
            } else if (this._anySetter != null) {
                this._anySetter.m10962a(jsonParser, deserializationContext, obj, i);
            } else {
                m10844a(jsonParser, deserializationContext, obj, i);
            }
            g = jsonParser.c();
        }
        return obj;
    }

    private final Object m10871y(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object l = this._valueInstantiator.mo688l();
        while (jsonParser.g() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a = this._beanProperties.m11014a(i);
            if (a != null) {
                try {
                    a.mo648a(jsonParser, deserializationContext, l);
                } catch (Throwable e) {
                    m10848a(e, l, i, deserializationContext);
                }
            } else {
                m10850b(jsonParser, deserializationContext, l, i);
            }
            jsonParser.c();
        }
        return l;
    }

    public Object mo644b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!this._nonStandardCreation) {
            Object l = this._valueInstantiator.mo688l();
            if (this._injectables != null) {
                m10846a(deserializationContext, l);
            }
            if (this._needViewProcesing) {
                Class e = deserializationContext.e();
                if (e != null) {
                    return m10867a(jsonParser, deserializationContext, l, e);
                }
            }
            while (jsonParser.g() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                SettableBeanProperty a = this._beanProperties.m11014a(i);
                if (a != null) {
                    try {
                        a.mo648a(jsonParser, deserializationContext, l);
                    } catch (Throwable e2) {
                        m10848a(e2, l, i, deserializationContext);
                    }
                } else if (this._ignorableProps != null && this._ignorableProps.contains(i)) {
                    jsonParser.f();
                } else if (this._anySetter != null) {
                    try {
                        this._anySetter.m10962a(jsonParser, deserializationContext, l, i);
                    } catch (Throwable e22) {
                        m10848a(e22, l, i, deserializationContext);
                    }
                } else {
                    m10844a(jsonParser, deserializationContext, l, i);
                }
                jsonParser.c();
            }
            return l;
        } else if (this._unwrappedPropertyHandler != null) {
            return m10872z(jsonParser, deserializationContext);
        } else {
            if (this._externalTypeIdHandler != null) {
                return m10864B(jsonParser, deserializationContext);
            }
            return m10856e(jsonParser, deserializationContext);
        }
    }

    protected final Object mo645c(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonParser jsonParser2 = null;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer a = propertyBasedCreator.m11089a(jsonParser, deserializationContext, this._objectIdReader);
        JsonToken g = jsonParser.g();
        TokenBuffer tokenBuffer = jsonParser2;
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a2 = propertyBasedCreator.m11088a(i);
            if (a2 != null) {
                if (a.m11106a(a2.mo654c(), a2.m10922a(jsonParser, deserializationContext))) {
                    Object a3;
                    jsonParser.c();
                    try {
                        a3 = propertyBasedCreator.m11090a(deserializationContext, a);
                    } catch (Throwable e) {
                        m10848a(e, this._beanType.c(), i, deserializationContext);
                    }
                    if (a3.getClass() != this._beanType.c()) {
                        return m10842a(jsonParser, deserializationContext, a3, tokenBuffer);
                    }
                    if (tokenBuffer != null) {
                        a3 = m10843a(deserializationContext, a3, tokenBuffer);
                    }
                    return a(jsonParser, deserializationContext, a3);
                }
            } else if (!a.m11107a(i)) {
                a2 = this._beanProperties.m11014a(i);
                if (a2 != null) {
                    a.m11103a(a2, a2.m10922a(jsonParser, deserializationContext));
                } else if (this._ignorableProps != null && this._ignorableProps.contains(i)) {
                    jsonParser.f();
                } else if (this._anySetter != null) {
                    a.m11102a(this._anySetter, i, this._anySetter.m10961a(jsonParser, deserializationContext));
                } else {
                    if (tokenBuffer == null) {
                        tokenBuffer = new TokenBuffer(jsonParser.a());
                    }
                    tokenBuffer.a(i);
                    tokenBuffer.b(jsonParser);
                }
            }
            g = jsonParser.c();
        }
        try {
            Object a4 = propertyBasedCreator.m11090a(deserializationContext, a);
        } catch (Throwable e2) {
            m10847a(e2, deserializationContext);
            JsonParser jsonParser3 = jsonParser2;
        }
        if (tokenBuffer == null) {
            return a4;
        }
        if (a4.getClass() != this._beanType.c()) {
            return m10842a(jsonParser2, deserializationContext, a4, tokenBuffer);
        }
        return m10843a(deserializationContext, a4, tokenBuffer);
    }

    private Object m10867a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) {
        JsonToken g = jsonParser.g();
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a = this._beanProperties.m11014a(i);
            if (a != null) {
                if (a.m10928a((Class) cls)) {
                    try {
                        a.mo648a(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        m10848a(e, obj, i, deserializationContext);
                    }
                } else {
                    jsonParser.f();
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(i)) {
                jsonParser.f();
            } else if (this._anySetter != null) {
                this._anySetter.m10962a(jsonParser, deserializationContext, obj, i);
            } else {
                m10844a(jsonParser, deserializationContext, obj, i);
            }
            g = jsonParser.c();
        }
        return obj;
    }

    private Object m10872z(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return m10863A(jsonParser, deserializationContext);
        }
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
        tokenBuffer.f();
        Object l = this._valueInstantiator.mo688l();
        if (this._injectables != null) {
            m10846a(deserializationContext, l);
        }
        Class e = this._needViewProcesing ? deserializationContext.e() : null;
        while (jsonParser.g() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a = this._beanProperties.m11014a(i);
            if (a != null) {
                if (e == null || a.m10928a(e)) {
                    try {
                        a.mo648a(jsonParser, deserializationContext, l);
                    } catch (Throwable e2) {
                        m10848a(e2, l, i, deserializationContext);
                    }
                } else {
                    jsonParser.f();
                }
            } else if (this._ignorableProps == null || !this._ignorableProps.contains(i)) {
                tokenBuffer.a(i);
                tokenBuffer.b(jsonParser);
                if (this._anySetter != null) {
                    try {
                        this._anySetter.m10962a(jsonParser, deserializationContext, l, i);
                    } catch (Throwable e22) {
                        m10848a(e22, l, i, deserializationContext);
                    }
                }
            } else {
                jsonParser.f();
            }
            jsonParser.c();
        }
        tokenBuffer.g();
        this._unwrappedPropertyHandler.m11121a(deserializationContext, l, tokenBuffer);
        return l;
    }

    private Object m10868b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
        }
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
        tokenBuffer.f();
        Class e = this._needViewProcesing ? deserializationContext.e() : null;
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            SettableBeanProperty a = this._beanProperties.m11014a(i);
            jsonParser.c();
            if (a != null) {
                if (e == null || a.m10928a(e)) {
                    try {
                        a.mo648a(jsonParser, deserializationContext, obj);
                    } catch (Throwable e2) {
                        m10848a(e2, obj, i, deserializationContext);
                    }
                } else {
                    jsonParser.f();
                }
            } else if (this._ignorableProps == null || !this._ignorableProps.contains(i)) {
                tokenBuffer.a(i);
                tokenBuffer.b(jsonParser);
                if (this._anySetter != null) {
                    this._anySetter.m10962a(jsonParser, deserializationContext, obj, i);
                }
            } else {
                jsonParser.f();
            }
            g = jsonParser.c();
        }
        tokenBuffer.g();
        this._unwrappedPropertyHandler.m11121a(deserializationContext, obj, tokenBuffer);
        return obj;
    }

    private Object m10863A(JsonParser jsonParser, DeserializationContext deserializationContext) {
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer a = propertyBasedCreator.m11089a(jsonParser, deserializationContext, this._objectIdReader);
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
        tokenBuffer.f();
        JsonToken g = jsonParser.g();
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a2 = propertyBasedCreator.m11088a(i);
            if (a2 != null) {
                if (a.m11106a(a2.mo654c(), a2.m10922a(jsonParser, deserializationContext))) {
                    g = jsonParser.c();
                    try {
                        Object a3 = propertyBasedCreator.m11090a(deserializationContext, a);
                        while (g == JsonToken.FIELD_NAME) {
                            jsonParser.c();
                            tokenBuffer.b(jsonParser);
                            g = jsonParser.c();
                        }
                        tokenBuffer.g();
                        if (a3.getClass() == this._beanType.c()) {
                            return this._unwrappedPropertyHandler.m11121a(deserializationContext, a3, tokenBuffer);
                        }
                        tokenBuffer.close();
                        throw deserializationContext.c("Can not create polymorphic instances with unwrapped values");
                    } catch (Throwable e) {
                        m10848a(e, this._beanType.c(), i, deserializationContext);
                    }
                } else {
                    continue;
                }
            } else if (!a.m11107a(i)) {
                a2 = this._beanProperties.m11014a(i);
                if (a2 != null) {
                    a.m11103a(a2, a2.m10922a(jsonParser, deserializationContext));
                } else if (this._ignorableProps == null || !this._ignorableProps.contains(i)) {
                    tokenBuffer.a(i);
                    tokenBuffer.b(jsonParser);
                    if (this._anySetter != null) {
                        a.m11102a(this._anySetter, i, this._anySetter.m10961a(jsonParser, deserializationContext));
                    }
                } else {
                    jsonParser.f();
                }
            }
            g = jsonParser.c();
        }
        try {
            return this._unwrappedPropertyHandler.m11121a(deserializationContext, propertyBasedCreator.m11090a(deserializationContext, a), tokenBuffer);
        } catch (Throwable e2) {
            m10847a(e2, deserializationContext);
            return null;
        }
    }

    private Object m10864B(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._propertyBasedCreator != null) {
            return m10865C(jsonParser, deserializationContext);
        }
        return m10870c(jsonParser, deserializationContext, this._valueInstantiator.mo688l());
    }

    private Object m10870c(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Class e = this._needViewProcesing ? deserializationContext.e() : null;
        ExternalTypeHandler a = this._externalTypeIdHandler.m11045a();
        while (jsonParser.g() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a2 = this._beanProperties.m11014a(i);
            if (a2 != null) {
                if (jsonParser.g().isScalarValue()) {
                    a.m11048a(jsonParser, deserializationContext, i, obj);
                }
                if (e == null || a2.m10928a(e)) {
                    try {
                        a2.mo648a(jsonParser, deserializationContext, obj);
                    } catch (Throwable e2) {
                        m10848a(e2, obj, i, deserializationContext);
                    }
                } else {
                    jsonParser.f();
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(i)) {
                jsonParser.f();
            } else if (!a.m11049b(jsonParser, deserializationContext, i, obj)) {
                if (this._anySetter != null) {
                    try {
                        this._anySetter.m10962a(jsonParser, deserializationContext, obj, i);
                    } catch (Throwable e22) {
                        m10848a(e22, obj, i, deserializationContext);
                    }
                } else {
                    m10844a(jsonParser, deserializationContext, obj, i);
                }
            }
            jsonParser.c();
        }
        return a.m11047a(jsonParser, deserializationContext, obj);
    }

    private Object m10865C(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object obj = null;
        ExternalTypeHandler a = this._externalTypeIdHandler.m11045a();
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer a2 = propertyBasedCreator.m11089a(jsonParser, deserializationContext, this._objectIdReader);
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.a());
        tokenBuffer.f();
        JsonToken g = jsonParser.g();
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            jsonParser.c();
            SettableBeanProperty a3 = propertyBasedCreator.m11088a(i);
            if (a3 != null) {
                if (a.m11049b(jsonParser, deserializationContext, i, a2)) {
                    continue;
                } else {
                    if (a2.m11106a(a3.mo654c(), a3.m10922a(jsonParser, deserializationContext))) {
                        g = jsonParser.c();
                        try {
                            obj = propertyBasedCreator.m11090a(deserializationContext, a2);
                            while (g == JsonToken.FIELD_NAME) {
                                jsonParser.c();
                                tokenBuffer.b(jsonParser);
                                g = jsonParser.c();
                            }
                            if (obj.getClass() == this._beanType.c()) {
                                return a.m11047a(jsonParser, deserializationContext, obj);
                            }
                            throw deserializationContext.c("Can not create polymorphic instances with unwrapped values");
                        } catch (Throwable e) {
                            m10848a(e, this._beanType.c(), i, deserializationContext);
                        }
                    } else {
                        continue;
                    }
                }
            } else if (!a2.m11107a(i)) {
                a3 = this._beanProperties.m11014a(i);
                if (a3 != null) {
                    a2.m11103a(a3, a3.m10922a(jsonParser, deserializationContext));
                } else if (!a.m11049b(jsonParser, deserializationContext, i, obj)) {
                    if (this._ignorableProps != null && this._ignorableProps.contains(i)) {
                        jsonParser.f();
                    } else if (this._anySetter != null) {
                        a2.m11102a(this._anySetter, i, this._anySetter.m10961a(jsonParser, deserializationContext));
                    }
                }
            }
            g = jsonParser.c();
        }
        try {
            return a.m11046a(jsonParser, deserializationContext, a2, propertyBasedCreator);
        } catch (Throwable e2) {
            m10847a(e2, deserializationContext);
            return obj;
        }
    }
}
