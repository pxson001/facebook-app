package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.Annotations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: clickable_link_url */
public class BeanDeserializerBuilder {
    protected final BeanDescription f5990a;
    protected final boolean f5991b;
    protected final Map<String, SettableBeanProperty> f5992c = new LinkedHashMap();
    public List<ValueInjector> f5993d;
    protected HashMap<String, SettableBeanProperty> f5994e;
    protected HashSet<String> f5995f;
    public ValueInstantiator f5996g;
    public ObjectIdReader f5997h;
    public SettableAnyProperty f5998i;
    public boolean f5999j;
    public AnnotatedMethod f6000k;
    protected Value f6001l;

    public BeanDeserializerBuilder(BeanDescription beanDescription, DeserializationConfig deserializationConfig) {
        this.f5990a = beanDescription;
        this.f5991b = deserializationConfig.a(MapperFeature.DEFAULT_VIEW_INCLUSION);
    }

    public final void m10884a(SettableBeanProperty settableBeanProperty) {
        this.f5992c.put(settableBeanProperty._propName, settableBeanProperty);
    }

    public final void m10894b(SettableBeanProperty settableBeanProperty) {
        SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) this.f5992c.put(settableBeanProperty._propName, settableBeanProperty);
        if (settableBeanProperty2 != null && settableBeanProperty2 != settableBeanProperty) {
            throw new IllegalArgumentException("Duplicate property '" + settableBeanProperty._propName + "' for " + this.f5990a.a);
        }
    }

    public final void m10890a(String str, SettableBeanProperty settableBeanProperty) {
        if (this.f5994e == null) {
            this.f5994e = new HashMap(4);
        }
        this.f5994e.put(str, settableBeanProperty);
        if (this.f5992c != null) {
            this.f5992c.remove(settableBeanProperty._propName);
        }
    }

    public final void m10889a(String str, JavaType javaType, Annotations annotations, AnnotatedMember annotatedMember, Object obj) {
        if (this.f5993d == null) {
            this.f5993d = new ArrayList();
        }
        this.f5993d.add(new ValueInjector(str, javaType, annotations, annotatedMember, obj));
    }

    public final void m10888a(String str) {
        if (this.f5995f == null) {
            this.f5995f = new HashSet();
        }
        this.f5995f.add(str);
    }

    public final void m10896c(SettableBeanProperty settableBeanProperty) {
        m10894b(settableBeanProperty);
    }

    public final void m10883a(SettableAnyProperty settableAnyProperty) {
        if (this.f5998i == null || settableAnyProperty == null) {
            this.f5998i = settableAnyProperty;
            return;
        }
        throw new IllegalStateException("_anySetter already set to non-null");
    }

    public final void m10891a(boolean z) {
        this.f5999j = z;
    }

    public final void m10885a(ValueInstantiator valueInstantiator) {
        this.f5996g = valueInstantiator;
    }

    public final void m10886a(ObjectIdReader objectIdReader) {
        this.f5997h = objectIdReader;
    }

    public final void m10887a(AnnotatedMethod annotatedMethod, Value value) {
        this.f6000k = annotatedMethod;
        this.f6001l = value;
    }

    public final SettableBeanProperty m10892b(String str) {
        return (SettableBeanProperty) this.f5992c.get(str);
    }

    public final SettableAnyProperty m10882a() {
        return this.f5998i;
    }

    public final ValueInstantiator m10893b() {
        return this.f5996g;
    }

    public final List<ValueInjector> m10895c() {
        return this.f5993d;
    }

    public final ObjectIdReader m10897d() {
        return this.f5997h;
    }

    public final AnnotatedMethod m10898e() {
        return this.f6000k;
    }

    public final JsonDeserializer<?> m10899f() {
        Collection<SettableBeanProperty> values = this.f5992c.values();
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(values);
        beanPropertyMap.m11015a();
        boolean z = !this.f5991b;
        if (!z) {
            for (SettableBeanProperty n : values) {
                if (n.m10945n()) {
                    z = true;
                    break;
                }
            }
        }
        if (this.f5997h != null) {
            beanPropertyMap = beanPropertyMap.m11016a(new ObjectIdValueProperty(this.f5997h, true));
        }
        return new BeanDeserializer(this, this.f5990a, beanPropertyMap, this.f5994e, this.f5995f, this.f5999j, z);
    }

    public final AbstractDeserializer m10900g() {
        return new AbstractDeserializer(this, this.f5990a, this.f5994e);
    }

    public final JsonDeserializer<?> m10881a(JavaType javaType, String str) {
        if (this.f6000k == null) {
            throw new IllegalArgumentException("Builder class " + this.f5990a.b().getName() + " does not have build method '" + str + "()'");
        }
        Class o = this.f6000k.o();
        if (javaType._class.isAssignableFrom(o)) {
            Collection<SettableBeanProperty> values = this.f5992c.values();
            BeanPropertyMap beanPropertyMap = new BeanPropertyMap(values);
            beanPropertyMap.m11015a();
            boolean z = !this.f5991b;
            if (!z) {
                for (SettableBeanProperty n : values) {
                    if (n.m10945n()) {
                        z = true;
                        break;
                    }
                }
            }
            if (this.f5997h != null) {
                beanPropertyMap = beanPropertyMap.m11016a(new ObjectIdValueProperty(this.f5997h, true));
            }
            return new BuilderBasedDeserializer(this, this.f5990a, beanPropertyMap, this.f5994e, this.f5995f, this.f5999j, z);
        }
        throw new IllegalArgumentException("Build method '" + this.f6000k.m() + " has bad return type (" + o.getName() + "), not compatible with POJO type (" + javaType._class.getName() + ")");
    }
}
