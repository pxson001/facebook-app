package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.NullProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.FailingDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import java.io.IOException;
import java.io.Serializable;

/* compiled from: clickTimeout */
public abstract class SettableBeanProperty implements BeanProperty, Serializable {
    protected static final JsonDeserializer<Object> f6003a = new FailingDeserializer("No _valueDeserializer assigned");
    private static final long serialVersionUID = -1026580169193933453L;
    public final boolean _isRequired;
    public String _managedReferenceName;
    protected final NullProvider _nullProvider;
    public final String _propName;
    protected int _propertyIndex;
    protected final JavaType _type;
    protected JsonDeserializer<Object> _valueDeserializer;
    public final TypeDeserializer _valueTypeDeserializer;
    protected ViewMatcher _viewMatcher;
    public final PropertyName _wrapperName;
    protected final transient Annotations f6004b;

    public abstract SettableBeanProperty mo647a(String str);

    public abstract void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj);

    public abstract void mo649a(Object obj, Object obj2);

    public abstract SettableBeanProperty mo650b(JsonDeserializer<?> jsonDeserializer);

    public abstract AnnotatedMember mo651b();

    public abstract Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj);

    public abstract Object mo653b(Object obj, Object obj2);

    protected SettableBeanProperty(BeanPropertyDefinition beanPropertyDefinition, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations) {
        this(beanPropertyDefinition.a(), javaType, beanPropertyDefinition.b(), typeDeserializer, annotations, beanPropertyDefinition.s());
    }

    protected SettableBeanProperty(String str, JavaType javaType, PropertyName propertyName, TypeDeserializer typeDeserializer, Annotations annotations, boolean z) {
        this._propertyIndex = -1;
        if (str == null || str.length() == 0) {
            this._propName = "";
        } else {
            this._propName = InternCache.a.a(str);
        }
        this._type = javaType;
        this._wrapperName = propertyName;
        this._isRequired = z;
        this.f6004b = annotations;
        this._viewMatcher = null;
        this._nullProvider = null;
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.mo698a(this);
        }
        this._valueTypeDeserializer = typeDeserializer;
        this._valueDeserializer = f6003a;
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty) {
        this._propertyIndex = -1;
        this._propName = settableBeanProperty._propName;
        this._type = settableBeanProperty._type;
        this._wrapperName = settableBeanProperty._wrapperName;
        this._isRequired = settableBeanProperty._isRequired;
        this.f6004b = settableBeanProperty.f6004b;
        this._valueDeserializer = settableBeanProperty._valueDeserializer;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._nullProvider = settableBeanProperty._nullProvider;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
        this._viewMatcher = settableBeanProperty._viewMatcher;
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty, JsonDeserializer<?> jsonDeserializer) {
        NullProvider nullProvider = null;
        this._propertyIndex = -1;
        this._propName = settableBeanProperty._propName;
        this._type = settableBeanProperty._type;
        this._wrapperName = settableBeanProperty._wrapperName;
        this._isRequired = settableBeanProperty._isRequired;
        this.f6004b = settableBeanProperty.f6004b;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
        if (jsonDeserializer == null) {
            this._nullProvider = null;
            this._valueDeserializer = f6003a;
        } else {
            Object a = jsonDeserializer.a();
            if (a != null) {
                nullProvider = new NullProvider(this._type, a);
            }
            this._nullProvider = nullProvider;
            this._valueDeserializer = jsonDeserializer;
        }
        this._viewMatcher = settableBeanProperty._viewMatcher;
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty, String str) {
        this._propertyIndex = -1;
        this._propName = str;
        this._type = settableBeanProperty._type;
        this._wrapperName = settableBeanProperty._wrapperName;
        this._isRequired = settableBeanProperty._isRequired;
        this.f6004b = settableBeanProperty.f6004b;
        this._valueDeserializer = settableBeanProperty._valueDeserializer;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._nullProvider = settableBeanProperty._nullProvider;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
        this._viewMatcher = settableBeanProperty._viewMatcher;
    }

    public final void m10933b(String str) {
        this._managedReferenceName = str;
    }

    public final void m10927a(Class<?>[] clsArr) {
        if (clsArr == null) {
            this._viewMatcher = null;
        } else {
            this._viewMatcher = ViewMatcher.m11858a((Class[]) clsArr);
        }
    }

    public final void m10923a(int i) {
        if (this._propertyIndex != -1) {
            throw new IllegalStateException("Property '" + this._propName + "' already had index (" + this._propertyIndex + "), trying to assign " + i);
        }
        this._propertyIndex = i;
    }

    public final String m10936e() {
        return this._propName;
    }

    public final boolean m10937f() {
        return this._isRequired;
    }

    public final JavaType m10920a() {
        return this._type;
    }

    public final PropertyName m10938g() {
        return this._wrapperName;
    }

    protected final Class<?> m10939h() {
        return mo651b().i();
    }

    public final String m10940i() {
        return this._managedReferenceName;
    }

    public final boolean m10941j() {
        return (this._valueDeserializer == null || this._valueDeserializer == f6003a) ? false : true;
    }

    public final boolean m10942k() {
        return this._valueTypeDeserializer != null;
    }

    public final JsonDeserializer<Object> m10943l() {
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        if (jsonDeserializer == f6003a) {
            return null;
        }
        return jsonDeserializer;
    }

    public final TypeDeserializer m10944m() {
        return this._valueTypeDeserializer;
    }

    public final boolean m10928a(Class<?> cls) {
        return this._viewMatcher == null || this._viewMatcher.mo729a((Class) cls);
    }

    public final boolean m10945n() {
        return this._viewMatcher != null;
    }

    public int mo654c() {
        return -1;
    }

    public Object mo655d() {
        return null;
    }

    public final Object m10922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.VALUE_NULL) {
            return this._nullProvider == null ? null : this._nullProvider.m11078a(deserializationContext);
        } else {
            if (this._valueTypeDeserializer != null) {
                return this._valueDeserializer.a(jsonParser, deserializationContext, this._valueTypeDeserializer);
            }
            return this._valueDeserializer.a(jsonParser, deserializationContext);
        }
    }

    protected final void m10925a(Exception exception, Object obj) {
        if (exception instanceof IllegalArgumentException) {
            String name = obj == null ? "[NULL]" : obj.getClass().getName();
            StringBuilder append = new StringBuilder("Problem deserializing property '").append(this._propName);
            append.append("' (expected type: ").append(m10920a());
            append.append("; actual type: ").append(name).append(")");
            name = exception.getMessage();
            if (name != null) {
                append.append(", problem: ").append(name);
            } else {
                append.append(" (no error message provided)");
            }
            throw new JsonMappingException(append.toString(), null, exception);
        }
        m10919a(exception);
    }

    protected static IOException m10919a(Exception exception) {
        if (exception instanceof IOException) {
            throw ((IOException) exception);
        } else if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        } else {
            while (exception.getCause() != null) {
                exception = exception.getCause();
            }
            throw new JsonMappingException(exception.getMessage(), null, exception);
        }
    }

    public String toString() {
        return "[property '" + this._propName + "']";
    }
}
