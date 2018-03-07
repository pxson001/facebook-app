package com.fasterxml.jackson.databind.deser;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.annotation.JsonFormat$Value;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonTypeInfo$As;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: client override */
public abstract class BeanDeserializerBase extends StdDeserializer<Object> implements ContextualDeserializer, ResolvableDeserializer, Serializable {
    private static final long serialVersionUID = -2038793552422727904L;
    protected SettableAnyProperty _anySetter;
    protected final Map<String, SettableBeanProperty> _backRefs;
    protected final BeanPropertyMap _beanProperties;
    protected final JavaType _beanType;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected ExternalTypeHandler _externalTypeIdHandler;
    protected final HashSet<String> _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final ValueInjector[] _injectables;
    protected final boolean _needViewProcesing;
    protected boolean _nonStandardCreation;
    protected final ObjectIdReader _objectIdReader;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected final Shape _serializationShape;
    protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
    public final ValueInstantiator _valueInstantiator;
    protected boolean _vanillaProcessing;
    protected transient HashMap<ClassKey, JsonDeserializer<Object>> f5987a;
    private final transient Annotations f5988b;

    /* compiled from: client override */
    /* synthetic */ class C05501 {
        static final /* synthetic */ int[] f5989a = new int[NumberType.values().length];

        static {
            try {
                f5989a[NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5989a[NumberType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5989a[NumberType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5989a[NumberType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public abstract JsonDeserializer<Object> mo641a(NameTransformer nameTransformer);

    public abstract BeanDeserializerBase mo642a(ObjectIdReader objectIdReader);

    public abstract BeanDeserializerBase mo643a(HashSet<String> hashSet);

    public abstract Object mo644b(JsonParser jsonParser, DeserializationContext deserializationContext);

    protected abstract Object mo645c(JsonParser jsonParser, DeserializationContext deserializationContext);

    protected abstract BeanDeserializerBase mo646e();

    protected BeanDeserializerBase(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        ValueInjector[] valueInjectorArr;
        boolean z3;
        boolean z4 = true;
        Shape shape = null;
        super(beanDescription.a);
        this.f5988b = beanDescription.c().g();
        this._beanType = beanDescription.a;
        this._valueInstantiator = beanDeserializerBuilder.f5996g;
        this._beanProperties = beanPropertyMap;
        this._backRefs = map;
        this._ignorableProps = hashSet;
        this._ignoreAllUnknown = z;
        this._anySetter = beanDeserializerBuilder.f5998i;
        List list = beanDeserializerBuilder.f5993d;
        if (list == null || list.isEmpty()) {
            valueInjectorArr = null;
        } else {
            valueInjectorArr = (ValueInjector[]) list.toArray(new ValueInjector[list.size()]);
        }
        this._injectables = valueInjectorArr;
        this._objectIdReader = beanDeserializerBuilder.f5997h;
        if (this._unwrappedPropertyHandler != null || this._valueInstantiator.mo686i() || this._valueInstantiator.mo673j() || !this._valueInstantiator.mo685h()) {
            z3 = true;
        } else {
            z3 = false;
        }
        this._nonStandardCreation = z3;
        JsonFormat$Value a = beanDescription.a(null);
        if (a != null) {
            shape = a.f5938b;
        }
        this._serializationShape = shape;
        this._needViewProcesing = z2;
        if (this._nonStandardCreation || this._injectables != null || this._needViewProcesing || this._objectIdReader == null) {
            z4 = false;
        }
        this._vanillaProcessing = z4;
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase) {
        this(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase._beanType);
        this.f5988b = beanDeserializerBase.f5988b;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._beanProperties = beanDeserializerBase._beanProperties;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = z;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, NameTransformer nameTransformer) {
        super(beanDeserializerBase._beanType);
        this.f5988b = beanDeserializerBase.f5988b;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        boolean z = nameTransformer != null || beanDeserializerBase._ignoreAllUnknown;
        this._ignoreAllUnknown = z;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        UnwrappedPropertyHandler unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        if (nameTransformer != null) {
            if (unwrappedPropertyHandler != null) {
                unwrappedPropertyHandler = unwrappedPropertyHandler.m11120a(nameTransformer);
            }
            this._beanProperties = beanDeserializerBase._beanProperties.m11017a(nameTransformer);
        } else {
            this._beanProperties = beanDeserializerBase._beanProperties;
        }
        this._unwrappedPropertyHandler = unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase._beanType);
        this.f5988b = beanDeserializerBase.f5988b;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        this._objectIdReader = objectIdReader;
        if (objectIdReader == null) {
            this._beanProperties = beanDeserializerBase._beanProperties;
            return;
        }
        this._beanProperties = beanDeserializerBase._beanProperties.m11016a(new ObjectIdValueProperty(objectIdReader, true));
    }

    private SettableBeanProperty m10828a(SettableBeanProperty settableBeanProperty) {
        String str = settableBeanProperty._managedReferenceName;
        if (str == null) {
            return settableBeanProperty;
        }
        SettableBeanProperty b;
        JsonDeserializer l = settableBeanProperty.m10943l();
        boolean z = false;
        if (l instanceof BeanDeserializerBase) {
            b = ((BeanDeserializerBase) l).m10832b(str);
        } else if (l instanceof ContainerDeserializerBase) {
            l = ((ContainerDeserializerBase) l).mo662e();
            if (l instanceof BeanDeserializerBase) {
                b = ((BeanDeserializerBase) l).m10832b(str);
                z = true;
            } else {
                throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer  (instead it's of type " + (l == null ? "NULL" : l.getClass().getName()) + ")");
            }
        } else if (l instanceof AbstractDeserializer) {
            b = ((AbstractDeserializer) l).m10823a(str);
        } else {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + l.getClass().getName());
        }
        if (b == null) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': no back reference property found from type " + settableBeanProperty.m10920a());
        }
        JavaType javaType = this._beanType;
        JavaType a = b.m10920a();
        if (a._class.isAssignableFrom(javaType._class)) {
            return new ManagedReferenceProperty(settableBeanProperty, str, b, this.f5988b, z);
        }
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': back reference type (" + a._class.getName() + ") not compatible with managed type (" + javaType._class.getName() + ")");
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, HashSet<String> hashSet) {
        super(beanDeserializerBase._beanType);
        this.f5988b = beanDeserializerBase.f5988b;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = hashSet;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._beanProperties = beanDeserializerBase._beanProperties;
    }

    public final void m10845a(DeserializationContext deserializationContext) {
        Builder builder;
        SettableBeanProperty settableBeanProperty;
        boolean z = false;
        if (this._valueInstantiator.mo673j()) {
            this._propertyBasedCreator = PropertyBasedCreator.m11087a(deserializationContext, this._valueInstantiator, this._valueInstantiator.mo672a(deserializationContext._config));
            builder = null;
            for (SettableBeanProperty settableBeanProperty2 : this._propertyBasedCreator.m11091a()) {
                if (settableBeanProperty2.m10942k()) {
                    TypeDeserializer typeDeserializer = settableBeanProperty2._valueTypeDeserializer;
                    if (typeDeserializer.mo697a() == JsonTypeInfo$As.EXTERNAL_PROPERTY) {
                        if (builder == null) {
                            builder = new Builder();
                        }
                        builder.m11037a(settableBeanProperty2, typeDeserializer);
                    }
                }
            }
        } else {
            builder = null;
        }
        Iterator it = this._beanProperties.iterator();
        UnwrappedPropertyHandler unwrappedPropertyHandler = null;
        Builder builder2 = builder;
        while (it.hasNext()) {
            SettableBeanProperty b;
            settableBeanProperty2 = (SettableBeanProperty) it.next();
            JsonDeserializer a;
            if (settableBeanProperty2.m10941j()) {
                JsonDeserializer l = settableBeanProperty2.m10943l();
                if (l instanceof ContextualDeserializer) {
                    a = ((ContextualDeserializer) l).a(deserializationContext, settableBeanProperty2);
                    if (a != l) {
                        b = settableBeanProperty2.mo650b(a);
                    }
                }
                b = settableBeanProperty2;
            } else {
                a = m10827a(deserializationContext, settableBeanProperty2);
                if (a == null) {
                    a = StdDeserializer.a(deserializationContext, settableBeanProperty2.m10920a(), settableBeanProperty2);
                }
                b = settableBeanProperty2.mo650b(a);
            }
            b = m10828a(b);
            SettableBeanProperty b2 = m10831b(deserializationContext, b);
            if (b2 != null) {
                UnwrappedPropertyHandler unwrappedPropertyHandler2;
                if (unwrappedPropertyHandler == null) {
                    unwrappedPropertyHandler2 = new UnwrappedPropertyHandler();
                } else {
                    unwrappedPropertyHandler2 = unwrappedPropertyHandler;
                }
                unwrappedPropertyHandler2.m11122a(b2);
                unwrappedPropertyHandler = unwrappedPropertyHandler2;
            } else {
                b2 = m10834c(deserializationContext, b);
                if (b2 != settableBeanProperty2) {
                    this._beanProperties.m11018b(b2);
                }
                if (b2.m10942k()) {
                    TypeDeserializer typeDeserializer2 = b2._valueTypeDeserializer;
                    if (typeDeserializer2.mo697a() == JsonTypeInfo$As.EXTERNAL_PROPERTY) {
                        if (builder2 == null) {
                            builder = new Builder();
                        } else {
                            builder = builder2;
                        }
                        builder.m11037a(b2, typeDeserializer2);
                        this._beanProperties.m11021c(b2);
                        builder2 = builder;
                    }
                }
            }
        }
        if (!(this._anySetter == null || this._anySetter.m10964b())) {
            this._anySetter = this._anySetter.m10960a(StdDeserializer.a(deserializationContext, this._anySetter.f6007c, this._anySetter.f6005a));
        }
        if (this._valueInstantiator.mo686i()) {
            JavaType k = this._valueInstantiator.mo687k();
            if (k == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._beanType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            PropertyName propertyName = null;
            this._delegateDeserializer = StdDeserializer.a(deserializationContext, k, new Std(null, k, propertyName, this.f5988b, this._valueInstantiator.mo690n(), false));
        }
        if (builder2 != null) {
            this._externalTypeIdHandler = builder2.m11036a();
            this._nonStandardCreation = true;
        }
        this._unwrappedPropertyHandler = unwrappedPropertyHandler;
        if (unwrappedPropertyHandler != null) {
            this._nonStandardCreation = true;
        }
        if (this._vanillaProcessing && !this._nonStandardCreation) {
            z = true;
        }
        this._vanillaProcessing = z;
    }

    private static JsonDeserializer<Object> m10827a(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        AnnotationIntrospector f = deserializationContext.f();
        if (f != null) {
            Object u = f.u(settableBeanProperty.mo651b());
            if (u != null) {
                Converter a = deserializationContext.a(settableBeanProperty.mo651b(), u);
                JavaType b = a.b();
                return new StdDelegatingDeserializer(a, b, deserializationContext.a(b, settableBeanProperty));
            }
        }
        return null;
    }

    public final JsonDeserializer<?> m10837a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        Annotated annotated;
        ObjectIdReader objectIdReader;
        Object[] objArr;
        BeanDeserializerBase beanDeserializerBase;
        Shape shape;
        ObjectIdReader objectIdReader2 = this._objectIdReader;
        AnnotationIntrospector f = deserializationContext.f();
        if (beanProperty == null || f == null) {
            annotated = null;
        } else {
            annotated = beanProperty.b();
        }
        if (beanProperty == null || f == null) {
            objectIdReader = objectIdReader2;
            objArr = null;
        } else {
            String[] b = f.b(annotated);
            ObjectIdInfo a = f.a(annotated);
            if (a != null) {
                SettableBeanProperty a2;
                JavaType a3;
                ObjectIdGenerator propertyBasedObjectIdGenerator;
                ObjectIdInfo a4 = f.a(annotated, a);
                Class cls = a4.f6114b;
                if (cls == PropertyGenerator.class) {
                    String str = a4.f6113a;
                    a2 = m10829a(str);
                    if (a2 == null) {
                        throw new IllegalArgumentException("Invalid Object Id definition for " + m10857f().getName() + ": can not find property with name '" + str + "'");
                    }
                    a3 = a2.m10920a();
                    propertyBasedObjectIdGenerator = new PropertyBasedObjectIdGenerator(a4.f6115c);
                } else {
                    a3 = deserializationContext.c().b(deserializationContext.a(cls), ObjectIdGenerator.class)[0];
                    propertyBasedObjectIdGenerator = deserializationContext.a(annotated, a4);
                    a2 = null;
                }
                objectIdReader = ObjectIdReader.m11079a(a3, a4.f6113a, propertyBasedObjectIdGenerator, deserializationContext.a(a3), a2);
                objArr = b;
            } else {
                objectIdReader = objectIdReader2;
                String[] strArr = b;
            }
        }
        if (objectIdReader == null || objectIdReader == this._objectIdReader) {
            beanDeserializerBase = this;
        } else {
            beanDeserializerBase = mo642a(objectIdReader);
        }
        if (!(objArr == null || objArr.length == 0)) {
            beanDeserializerBase = beanDeserializerBase.mo643a(ArrayBuilders.a(beanDeserializerBase._ignorableProps, objArr));
        }
        if (annotated != null) {
            JsonFormat$Value e = f.e(annotated);
            if (e != null) {
                shape = e.f5938b;
                if (shape == null) {
                    shape = this._serializationShape;
                }
                if (shape != Shape.ARRAY) {
                    return beanDeserializerBase.mo646e();
                }
                return beanDeserializerBase;
            }
        }
        shape = null;
        if (shape == null) {
            shape = this._serializationShape;
        }
        if (shape != Shape.ARRAY) {
            return beanDeserializerBase;
        }
        return beanDeserializerBase.mo646e();
    }

    private static SettableBeanProperty m10831b(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        AnnotatedMember b = settableBeanProperty.mo651b();
        if (b != null) {
            NameTransformer b2 = deserializationContext.f().b(b);
            if (b2 != null) {
                JsonDeserializer l = settableBeanProperty.m10943l();
                JsonDeserializer a = l.a(b2);
                if (!(a == l || a == null)) {
                    return settableBeanProperty.mo650b(a);
                }
            }
        }
        return null;
    }

    private SettableBeanProperty m10834c(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        JsonDeserializer l = settableBeanProperty.m10943l();
        if (!(l instanceof BeanDeserializerBase) || ((BeanDeserializerBase) l)._valueInstantiator.mo685h()) {
            return settableBeanProperty;
        }
        Class cls = settableBeanProperty.m10920a()._class;
        Class b = ClassUtil.b(cls);
        if (b == null || b != this._beanType._class) {
            return settableBeanProperty;
        }
        for (Constructor constructor : cls.getConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == b) {
                if (deserializationContext._config.h()) {
                    ClassUtil.a(constructor);
                }
                return new InnerClassProperty(settableBeanProperty, constructor);
            }
        }
        return settableBeanProperty;
    }

    public final boolean m10854d() {
        return true;
    }

    public final Collection<Object> m10852c() {
        Collection arrayList = new ArrayList();
        Iterator it = this._beanProperties.iterator();
        while (it.hasNext()) {
            arrayList.add(((SettableBeanProperty) it.next())._propName);
        }
        return arrayList;
    }

    public final Class<?> m10857f() {
        return this._beanType._class;
    }

    private SettableBeanProperty m10829a(String str) {
        SettableBeanProperty settableBeanProperty;
        if (this._beanProperties == null) {
            settableBeanProperty = null;
        } else {
            settableBeanProperty = this._beanProperties.m11014a(str);
        }
        if (settableBeanProperty != null || this._propertyBasedCreator == null) {
            return settableBeanProperty;
        }
        return this._propertyBasedCreator.m11088a(str);
    }

    private SettableBeanProperty m10832b(String str) {
        if (this._backRefs == null) {
            return null;
        }
        return (SettableBeanProperty) this._backRefs.get(str);
    }

    private ValueInstantiator m10835h() {
        return this._valueInstantiator;
    }

    public final Object m10841a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        if (this._objectIdReader != null) {
            JsonToken g = jsonParser.g();
            if (g != null && g.isScalarValue()) {
                return m10836y(jsonParser, deserializationContext);
            }
        }
        return typeDeserializer.mo699a(jsonParser, deserializationContext);
    }

    protected final Object m10853d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String str = this._objectIdReader.propertyName;
        if (str.equals(jsonParser.i())) {
            return mo644b(jsonParser, deserializationContext);
        }
        JsonGenerator tokenBuffer = new TokenBuffer(jsonParser.a());
        JsonGenerator jsonGenerator = null;
        while (jsonParser.g() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            if (jsonGenerator != null) {
                jsonGenerator.a(i);
                jsonParser.c();
                jsonGenerator.b(jsonParser);
            } else if (str.equals(i)) {
                jsonGenerator = new TokenBuffer(jsonParser.a());
                jsonGenerator.a(i);
                jsonParser.c();
                jsonGenerator.b(jsonParser);
                jsonGenerator.a(tokenBuffer);
                tokenBuffer = null;
            } else {
                tokenBuffer.a(i);
                jsonParser.c();
                tokenBuffer.b(jsonParser);
            }
            jsonParser.c();
        }
        if (jsonGenerator != null) {
            tokenBuffer = jsonGenerator;
        }
        tokenBuffer.g();
        JsonParser i2 = tokenBuffer.i();
        i2.c();
        return mo644b(i2, deserializationContext);
    }

    private Object m10836y(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object a = this._objectIdReader.deserializer.a(jsonParser, deserializationContext);
        Object obj = deserializationContext.a(a, this._objectIdReader.generator).f6055b;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("Could not resolve Object Id [" + a + "] (for " + this._beanType + ") -- unresolved forward-reference?");
    }

    protected final Object m10856e(JsonParser jsonParser, DeserializationContext deserializationContext) {
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

    public final Object m10858f(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._objectIdReader != null) {
            return m10836y(jsonParser, deserializationContext);
        }
        Object a;
        switch (C05501.f5989a[jsonParser.u().ordinal()]) {
            case 1:
                if (this._delegateDeserializer == null || this._valueInstantiator.mo681d()) {
                    return this._valueInstantiator.mo675a(jsonParser.x());
                }
                a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return a;
                }
                m10846a(deserializationContext, a);
                return a;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (this._delegateDeserializer == null || this._valueInstantiator.mo681d()) {
                    return this._valueInstantiator.mo676a(jsonParser.y());
                }
                a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return a;
                }
                m10846a(deserializationContext, a);
                return a;
            default:
                if (this._delegateDeserializer != null) {
                    a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
                    if (this._injectables == null) {
                        return a;
                    }
                    m10846a(deserializationContext, a);
                    return a;
                }
                throw deserializationContext.a(m10857f(), "no suitable creator method found to deserialize from JSON integer number");
        }
    }

    public final Object m10859g(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._objectIdReader != null) {
            return m10836y(jsonParser, deserializationContext);
        }
        if (this._delegateDeserializer == null || this._valueInstantiator.mo680c()) {
            return this._valueInstantiator.mo678a(deserializationContext, jsonParser.o());
        }
        Object a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        if (this._injectables == null) {
            return a;
        }
        m10846a(deserializationContext, a);
        return a;
    }

    public final Object m10860h(JsonParser jsonParser, DeserializationContext deserializationContext) {
        switch (C05501.f5989a[jsonParser.u().ordinal()]) {
            case 3:
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (this._delegateDeserializer == null || this._valueInstantiator.mo683f()) {
                    return this._valueInstantiator.mo674a(jsonParser.B());
                }
                Object a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return a;
                }
                m10846a(deserializationContext, a);
                return a;
            default:
                if (this._delegateDeserializer != null) {
                    return this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
                }
                throw deserializationContext.a(m10857f(), "no suitable creator method found to deserialize from JSON floating-point number");
        }
    }

    public final Object m10861i(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer == null || this._valueInstantiator.mo684g()) {
            return this._valueInstantiator.mo679a(jsonParser.g() == JsonToken.VALUE_TRUE);
        }
        Object a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        if (this._injectables == null) {
            return a;
        }
        m10846a(deserializationContext, a);
        return a;
    }

    public final Object m10862j(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null) {
            try {
                Object a = this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
                if (this._injectables != null) {
                    m10846a(deserializationContext, a);
                }
                return a;
            } catch (Throwable e) {
                m10847a(e, deserializationContext);
            }
        }
        throw deserializationContext.b(m10857f());
    }

    protected final void m10846a(DeserializationContext deserializationContext, Object obj) {
        for (ValueInjector a : this._injectables) {
            a.m11124a(deserializationContext, obj);
        }
    }

    protected final void m10844a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) {
        if (this._ignoreAllUnknown || (this._ignorableProps != null && this._ignorableProps.contains(str))) {
            jsonParser.f();
        } else {
            super.a(jsonParser, deserializationContext, obj, str);
        }
    }

    protected final Object m10843a(DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) {
        tokenBuffer.g();
        JsonParser i = tokenBuffer.i();
        while (i.c() != JsonToken.END_OBJECT) {
            String i2 = i.i();
            i.c();
            m10844a(i, deserializationContext, obj, i2);
        }
        return obj;
    }

    protected final void m10850b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) {
        if (this._ignorableProps != null && this._ignorableProps.contains(str)) {
            jsonParser.f();
        } else if (this._anySetter != null) {
            try {
                this._anySetter.m10962a(jsonParser, deserializationContext, obj, str);
            } catch (Throwable e) {
                m10848a(e, obj, str, deserializationContext);
            }
        } else {
            m10844a(jsonParser, deserializationContext, obj, str);
        }
    }

    protected final Object m10842a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) {
        JsonDeserializer b = m10830b(deserializationContext, obj);
        Object a;
        if (b != null) {
            if (tokenBuffer != null) {
                tokenBuffer.g();
                JsonParser i = tokenBuffer.i();
                i.c();
                a = b.a(i, deserializationContext, obj);
            } else {
                a = obj;
            }
            if (jsonParser != null) {
                return b.a(jsonParser, deserializationContext, a);
            }
            return a;
        }
        if (tokenBuffer != null) {
            a = m10843a(deserializationContext, obj, tokenBuffer);
        } else {
            a = obj;
        }
        if (jsonParser != null) {
            return a(jsonParser, deserializationContext, a);
        }
        return a;
    }

    private JsonDeserializer<Object> m10830b(DeserializationContext deserializationContext, Object obj) {
        JsonDeserializer<Object> jsonDeserializer;
        synchronized (this) {
            jsonDeserializer = this.f5987a == null ? null : (JsonDeserializer) this.f5987a.get(new ClassKey(obj.getClass()));
        }
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.a(deserializationContext.a(obj.getClass()));
            if (jsonDeserializer != null) {
                synchronized (this) {
                    if (this.f5987a == null) {
                        this.f5987a = new HashMap();
                    }
                    this.f5987a.put(new ClassKey(obj.getClass()), jsonDeserializer);
                }
            }
        }
        return jsonDeserializer;
    }

    public final void m10848a(Throwable th, Object obj, String str, DeserializationContext deserializationContext) {
        throw JsonMappingException.a(m10833b(th, deserializationContext), obj, str);
    }

    private static Throwable m10833b(Throwable th, DeserializationContext deserializationContext) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj = (deserializationContext == null || deserializationContext.a(DeserializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj == null || !(th2 instanceof JsonProcessingException)) {
                throw ((IOException) th2);
            }
        } else if (obj == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        return th2;
    }

    protected final void m10847a(Throwable th, DeserializationContext deserializationContext) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj = (deserializationContext == null || deserializationContext.a(DeserializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            throw ((IOException) th2);
        } else if (obj == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        } else {
            throw deserializationContext.a(this._beanType._class, th2);
        }
    }
}
