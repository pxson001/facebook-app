package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: checkBoxLabel */
public class ThrowableDeserializer extends BeanDeserializer {
    private static final long serialVersionUID = 1;

    public ThrowableDeserializer(BeanDeserializer beanDeserializer) {
        super(beanDeserializer);
        this._vanillaProcessing = false;
    }

    private ThrowableDeserializer(BeanDeserializer beanDeserializer, NameTransformer nameTransformer) {
        super((BeanDeserializerBase) beanDeserializer, nameTransformer);
    }

    public final JsonDeserializer<Object> mo641a(NameTransformer nameTransformer) {
        return getClass() != ThrowableDeserializer.class ? this : new ThrowableDeserializer(this, nameTransformer);
    }

    public final Object mo644b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int i = 0;
        if (this._propertyBasedCreator != null) {
            return mo645c(jsonParser, deserializationContext);
        }
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        if (this._beanType.d()) {
            throw JsonMappingException.a(jsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
        }
        boolean c = this._valueInstantiator.mo680c();
        boolean h = this._valueInstantiator.mo685h();
        if (c || h) {
            int i2 = 0;
            Object[] objArr = null;
            Object obj = null;
            while (jsonParser.g() != JsonToken.END_OBJECT) {
                int i3;
                Object obj2;
                Object[] objArr2;
                String i4 = jsonParser.i();
                SettableBeanProperty a = this._beanProperties.m11014a(i4);
                jsonParser.c();
                if (a == null) {
                    if ("message".equals(i4) && c) {
                        obj = this._valueInstantiator.mo678a(deserializationContext, jsonParser.o());
                        if (objArr != null) {
                            for (int i5 = 0; i5 < i2; i5 += 2) {
                                ((SettableBeanProperty) objArr[i5]).mo649a(obj, objArr[i5 + 1]);
                            }
                            i3 = i2;
                            obj2 = obj;
                            objArr2 = null;
                        }
                    } else if (this._ignorableProps != null && this._ignorableProps.contains(i4)) {
                        jsonParser.f();
                        i3 = i2;
                        objArr2 = objArr;
                        obj2 = obj;
                    } else if (this._anySetter != null) {
                        this._anySetter.m10962a(jsonParser, deserializationContext, obj, i4);
                        i3 = i2;
                        objArr2 = objArr;
                        obj2 = obj;
                    } else {
                        m10844a(jsonParser, deserializationContext, obj, i4);
                    }
                    i3 = i2;
                    objArr2 = objArr;
                    obj2 = obj;
                } else if (obj != null) {
                    a.mo648a(jsonParser, deserializationContext, obj);
                    i3 = i2;
                    objArr2 = objArr;
                    obj2 = obj;
                } else {
                    if (objArr == null) {
                        i3 = this._beanProperties._size;
                        objArr = new Object[(i3 + i3)];
                    }
                    int i6 = i2 + 1;
                    objArr[i2] = a;
                    i3 = i6 + 1;
                    objArr[i6] = a.m10922a(jsonParser, deserializationContext);
                    objArr2 = objArr;
                    obj2 = obj;
                }
                jsonParser.c();
                obj = obj2;
                objArr = objArr2;
                i2 = i3;
            }
            if (obj != null) {
                return obj;
            }
            if (c) {
                obj = this._valueInstantiator.mo678a(deserializationContext, null);
            } else {
                obj = this._valueInstantiator.mo688l();
            }
            if (objArr == null) {
                return obj;
            }
            while (i < i2) {
                ((SettableBeanProperty) objArr[i]).mo649a(obj, objArr[i + 1]);
                i += 2;
            }
            return obj;
        }
        throw new JsonMappingException("Can not deserialize Throwable of type " + this._beanType + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
    }
}
