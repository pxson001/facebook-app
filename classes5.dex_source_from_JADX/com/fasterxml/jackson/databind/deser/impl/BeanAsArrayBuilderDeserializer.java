package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.util.HashSet;

/* compiled from: classmate_search */
public class BeanAsArrayBuilderDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _buildMethod;
    protected final BeanDeserializerBase _delegate;
    protected final SettableBeanProperty[] _orderedProperties;

    public BeanAsArrayBuilderDeserializer(BeanDeserializerBase beanDeserializerBase, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedMethod annotatedMethod) {
        super(beanDeserializerBase);
        this._delegate = beanDeserializerBase;
        this._orderedProperties = settableBeanPropertyArr;
        this._buildMethod = annotatedMethod;
    }

    public final JsonDeserializer<Object> mo641a(NameTransformer nameTransformer) {
        return this._delegate.a(nameTransformer);
    }

    public final BeanDeserializerBase mo642a(ObjectIdReader objectIdReader) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.mo642a(objectIdReader), this._orderedProperties, this._buildMethod);
    }

    public final BeanDeserializerBase mo643a(HashSet hashSet) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.mo643a(hashSet), this._orderedProperties, this._buildMethod);
    }

    protected final BeanDeserializerBase mo646e() {
        return this;
    }

    private Object m10990b(DeserializationContext deserializationContext, Object obj) {
        try {
            return this._buildMethod.g().invoke(obj, new Object[0]);
        } catch (Throwable e) {
            m10847a(e, deserializationContext);
            return null;
        }
    }

    public Object m10996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() != JsonToken.START_ARRAY) {
            return m10990b(deserializationContext, m10989A(jsonParser, deserializationContext));
        }
        if (!this._vanillaProcessing) {
            return m10990b(deserializationContext, m10991y(jsonParser, deserializationContext));
        }
        Object l = this._valueInstantiator.mo688l();
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int i = 0;
        int length = settableBeanPropertyArr.length;
        while (jsonParser.c() != JsonToken.END_ARRAY) {
            if (i != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty != null) {
                    try {
                        l = settableBeanProperty.mo652b(jsonParser, deserializationContext, l);
                    } catch (Throwable e) {
                        m10848a(e, l, settableBeanProperty.m10936e(), deserializationContext);
                    }
                } else {
                    jsonParser.f();
                }
                i++;
            } else if (this._ignoreAllUnknown) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    jsonParser.f();
                }
                return m10990b(deserializationContext, l);
            } else {
                throw deserializationContext.c("Unexpected JSON values; expected at most " + length + " properties (in JSON Array)");
            }
        }
        return m10990b(deserializationContext, l);
    }

    public final Object m10997a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        if (this._injectables != null) {
            m10846a(deserializationContext, obj);
        }
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int i = 0;
        int length = settableBeanPropertyArr.length;
        while (jsonParser.c() != JsonToken.END_ARRAY) {
            if (i != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty != null) {
                    try {
                        obj = settableBeanProperty.mo652b(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        m10848a(e, obj, settableBeanProperty.m10936e(), deserializationContext);
                    }
                } else {
                    jsonParser.f();
                }
                i++;
            } else if (this._ignoreAllUnknown) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    jsonParser.f();
                }
                return m10990b(deserializationContext, obj);
            } else {
                throw deserializationContext.c("Unexpected JSON values; expected at most " + length + " properties (in JSON Array)");
            }
        }
        return m10990b(deserializationContext, obj);
    }

    public final Object mo644b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m10989A(jsonParser, deserializationContext);
    }

    private Object m10991y(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._nonStandardCreation) {
            return m10992z(jsonParser, deserializationContext);
        }
        Object l = this._valueInstantiator.mo688l();
        if (this._injectables != null) {
            m10846a(deserializationContext, l);
        }
        Class e = this._needViewProcesing ? deserializationContext.e() : null;
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int i = 0;
        int length = settableBeanPropertyArr.length;
        while (jsonParser.c() != JsonToken.END_ARRAY) {
            if (i != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                i++;
                if (settableBeanProperty == null || !(e == null || settableBeanProperty.m10928a(e))) {
                    jsonParser.f();
                } else {
                    try {
                        settableBeanProperty.mo652b(jsonParser, deserializationContext, l);
                    } catch (Throwable e2) {
                        m10848a(e2, l, settableBeanProperty.m10936e(), deserializationContext);
                    }
                }
            } else if (this._ignoreAllUnknown) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    jsonParser.f();
                }
                return l;
            } else {
                throw deserializationContext.c("Unexpected JSON values; expected at most " + length + " properties (in JSON Array)");
            }
        }
        return l;
    }

    private Object m10992z(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return mo645c(jsonParser, deserializationContext);
        }
        if (this._beanType.d()) {
            throw JsonMappingException.a(jsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
        }
        throw JsonMappingException.a(jsonParser, "No suitable constructor found for type " + this._beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
    }

    protected final Object mo645c(JsonParser jsonParser, DeserializationContext deserializationContext) {
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer a = propertyBasedCreator.m11089a(jsonParser, deserializationContext, this._objectIdReader);
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int length = settableBeanPropertyArr.length;
        int i = 0;
        Object obj = null;
        while (jsonParser.c() != JsonToken.END_ARRAY) {
            SettableBeanProperty settableBeanProperty;
            if (i < length) {
                settableBeanProperty = settableBeanPropertyArr[i];
            } else {
                settableBeanProperty = null;
            }
            if (settableBeanProperty == null) {
                jsonParser.f();
            } else if (obj != null) {
                try {
                    obj = settableBeanProperty.mo652b(jsonParser, deserializationContext, obj);
                } catch (Throwable e) {
                    m10848a(e, obj, settableBeanProperty.m10936e(), deserializationContext);
                }
            } else {
                String e2 = settableBeanProperty.m10936e();
                SettableBeanProperty a2 = propertyBasedCreator.m11088a(e2);
                if (a2 != null) {
                    if (a.m11106a(a2.mo654c(), a2.m10922a(jsonParser, deserializationContext))) {
                        try {
                            obj = propertyBasedCreator.m11090a(deserializationContext, a);
                            if (obj.getClass() != this._beanType.c()) {
                                throw deserializationContext.c("Can not support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type " + this._beanType.c().getName() + ", actual type " + obj.getClass().getName());
                            }
                        } catch (Throwable e3) {
                            m10848a(e3, this._beanType.c(), e2, deserializationContext);
                        }
                    } else {
                        continue;
                    }
                } else if (!a.m11107a(e2)) {
                    a.m11103a(settableBeanProperty, settableBeanProperty.m10922a(jsonParser, deserializationContext));
                }
            }
            i++;
        }
        if (obj == null) {
            try {
                obj = propertyBasedCreator.m11090a(deserializationContext, a);
            } catch (Throwable e4) {
                m10847a(e4, deserializationContext);
                return null;
            }
        }
        return obj;
    }

    private Object m10989A(JsonParser jsonParser, DeserializationContext deserializationContext) {
        throw deserializationContext.c("Can not deserialize a POJO (of type " + this._beanType._class.getName() + ") from non-Array representation (token: " + jsonParser.g() + "): type/property designed to be serialized as JSON Array");
    }
}
