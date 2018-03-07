package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeModifier;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: string */
public class ObjectMapper extends ObjectCodec implements Versioned, Serializable {
    protected static final ClassIntrospector f4004a = BasicClassIntrospector.f4015e;
    protected static final AnnotationIntrospector f4005b = new JacksonAnnotationIntrospector();
    protected static final VisibilityChecker<?> f4006c = Std.f4042a;
    public static final PrettyPrinter f4007d = new DefaultPrettyPrinter();
    protected static final BaseSettings f4008e = new BaseSettings(f4004a, f4005b, f4006c, null, TypeFactory.f4051a, null, StdDateFormat.f4065f, null, Locale.getDefault(), TimeZone.getTimeZone("GMT"), Base64Variants.f4073b);
    private static final JavaType f4009f = SimpleType.m6679h(JsonNode.class);
    private static final long serialVersionUID = 1;
    public DeserializationConfig _deserializationConfig;
    protected DefaultDeserializationContext _deserializationContext;
    protected InjectableValues _injectableValues;
    protected final JsonFactory _jsonFactory;
    protected final HashMap<ClassKey, Class<?>> _mixInAnnotations;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    protected final RootNameLookup _rootNames;
    public SerializationConfig _serializationConfig;
    protected SerializerFactory _serializerFactory;
    protected DefaultSerializerProvider _serializerProvider;
    protected SubtypeResolver _subtypeResolver;
    public TypeFactory _typeFactory;

    public final /* synthetic */ Iterator mo911b(JsonParser jsonParser, Class cls) {
        return m6665c(jsonParser, cls);
    }

    private Object m6620a(JsonParser jsonParser, DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<Object> jsonDeserializer) {
        String str = deserializationConfig._rootName;
        if (str == null) {
            str = this._rootNames.m7233a(javaType, (MapperConfig) deserializationConfig).mo1050a();
        }
        if (jsonParser.mo1794g() != JsonToken.START_OBJECT) {
            throw JsonMappingException.a(jsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + str + "'), but " + jsonParser.mo1794g());
        } else if (jsonParser.mo1766c() != JsonToken.FIELD_NAME) {
            throw JsonMappingException.a(jsonParser, "Current token not FIELD_NAME (to contain expected root name '" + str + "'), but " + jsonParser.mo1794g());
        } else {
            String i = jsonParser.mo1778i();
            if (str.equals(i)) {
                jsonParser.mo1766c();
                Object a = jsonDeserializer.mo1797a(jsonParser, deserializationContext);
                if (jsonParser.mo1766c() == JsonToken.END_OBJECT) {
                    return a;
                }
                throw JsonMappingException.a(jsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + str + "'), but " + jsonParser.mo1794g());
            }
            throw JsonMappingException.a(jsonParser, "Root name '" + i + "' does not match expected ('" + str + "') for type " + javaType);
        }
    }

    public ObjectMapper() {
        this(null, null, null);
    }

    public ObjectMapper(JsonFactory jsonFactory) {
        this(jsonFactory, null, null);
    }

    private ObjectMapper(JsonFactory jsonFactory, DefaultSerializerProvider defaultSerializerProvider, DefaultDeserializationContext defaultDeserializationContext) {
        this._mixInAnnotations = new HashMap();
        this._rootDeserializers = new ConcurrentHashMap(64, 0.6f, 2);
        if (jsonFactory == null) {
            this._jsonFactory = new MappingJsonFactory(this);
        } else {
            this._jsonFactory = jsonFactory;
            if (jsonFactory.mo1827a() == null) {
                this._jsonFactory._objectCodec = this;
            }
        }
        this._subtypeResolver = new StdSubtypeResolver();
        this._rootNames = new RootNameLookup();
        this._typeFactory = TypeFactory.f4051a;
        this._serializationConfig = new SerializationConfig(f4008e, this._subtypeResolver, this._mixInAnnotations);
        this._deserializationConfig = new DeserializationConfig(f4008e, this._subtypeResolver, this._mixInAnnotations);
        if (defaultSerializerProvider == null) {
            defaultSerializerProvider = new Impl();
        }
        this._serializerProvider = defaultSerializerProvider;
        if (defaultDeserializationContext == null) {
            defaultDeserializationContext = new DefaultDeserializationContext.Impl(BeanDeserializerFactory.f4146c);
        }
        this._deserializationContext = defaultDeserializationContext;
        this._serializerFactory = BeanSerializerFactory.f4161c;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final ObjectMapper m6641a(Module module) {
        if (module.mo1138a() == null) {
            throw new IllegalArgumentException("Module without defined name");
        } else if (module.version() == null) {
            throw new IllegalArgumentException("Module without defined version");
        } else {
            module.mo1139a(new SetupContext(this) {
                final /* synthetic */ ObjectMapper f4190b;

                public final void mo1140a(Deserializers deserializers) {
                    DeserializerFactory a = this._deserializationContext._factory.mo1092a(deserializers);
                    this._deserializationContext = this._deserializationContext.mo1076a(a);
                }

                public final void mo1142a(Serializers serializers) {
                    this._serializerFactory = this._serializerFactory.mo1101a(serializers);
                }

                public final void mo1141a(BeanSerializerModifier beanSerializerModifier) {
                    this._serializerFactory = this._serializerFactory.mo1100a(beanSerializerModifier);
                }

                public final void mo1143a(TypeModifier typeModifier) {
                    this.m6643a(this._typeFactory.m7113a(typeModifier));
                }
            });
            return this;
        }
    }

    private SerializationConfig m6627i() {
        return this._serializationConfig;
    }

    public final void mo909a(JsonGenerator jsonGenerator, Object obj) {
        SerializationConfig serializationConfig = this._serializationConfig;
        if (serializationConfig.m7246c(SerializationFeature.INDENT_OUTPUT)) {
            jsonGenerator.mo1125c();
        }
        if (serializationConfig.m7246c(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m6625b(jsonGenerator, obj, serializationConfig);
            return;
        }
        mo902a(serializationConfig).m7294a(jsonGenerator, obj);
        if (serializationConfig.m7246c(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    private <T> MappingIterator<T> m6626c(JsonParser jsonParser, JavaType javaType) {
        DeserializationContext a = m6645a(jsonParser, this._deserializationConfig);
        return new MappingIterator(javaType, jsonParser, a, mo901a(a, javaType), false, null);
    }

    private DeserializationConfig m6628j() {
        return this._deserializationConfig;
    }

    public final <T extends TreeNode> T mo906a(JsonParser jsonParser) {
        DeserializationConfig deserializationConfig = this._deserializationConfig;
        if (jsonParser.mo1794g() == null && jsonParser.mo1766c() == null) {
            return null;
        }
        JsonNode jsonNode = (JsonNode) mo903a(deserializationConfig, jsonParser, f4009f);
        if (jsonNode != null) {
            return jsonNode;
        }
        m6667d();
        return NullNode.a;
    }

    public final <T> T mo907a(JsonParser jsonParser, TypeReference<?> typeReference) {
        return mo903a(this._deserializationConfig, jsonParser, this._typeFactory.m7105a((TypeReference) typeReference));
    }

    public final <T> T m6648a(JsonParser jsonParser, JavaType javaType) {
        return mo903a(this._deserializationConfig, jsonParser, javaType);
    }

    public final <T> T mo908a(JsonParser jsonParser, Class<T> cls) {
        return mo903a(this._deserializationConfig, jsonParser, this._typeFactory.m7109a((Type) cls));
    }

    public final ObjectMapper m6639a(PropertyAccessor propertyAccessor, Visibility visibility) {
        this._deserializationConfig = this._deserializationConfig.m7278a(propertyAccessor, visibility);
        this._serializationConfig = this._serializationConfig.m7239a(propertyAccessor, visibility);
        return this;
    }

    public final ObjectMapper m6638a(JsonInclude$Include jsonInclude$Include) {
        this._serializationConfig = this._serializationConfig.m7238a(jsonInclude$Include);
        return this;
    }

    public final TypeFactory m6666c() {
        return this._typeFactory;
    }

    public final ObjectMapper m6643a(TypeFactory typeFactory) {
        this._typeFactory = typeFactory;
        this._deserializationConfig = this._deserializationConfig.m7280a(typeFactory);
        this._serializationConfig = this._serializationConfig.m7241a(typeFactory);
        return this;
    }

    public final JsonFactory mo910b() {
        return this._jsonFactory;
    }

    @Deprecated
    public final JsonFactory mo905a() {
        return this._jsonFactory;
    }

    public final ObjectMapper m6642a(SerializationFeature serializationFeature, boolean z) {
        this._serializationConfig = z ? this._serializationConfig.m7240a(serializationFeature) : this._serializationConfig.m7244b(serializationFeature);
        return this;
    }

    public final ObjectMapper m6640a(DeserializationFeature deserializationFeature, boolean z) {
        this._deserializationConfig = z ? this._deserializationConfig.m7279a(deserializationFeature) : this._deserializationConfig.m7282b(deserializationFeature);
        return this;
    }

    public final JsonNodeFactory m6667d() {
        return this._deserializationConfig._nodeFactory;
    }

    public final <T> MappingIterator<T> m6665c(JsonParser jsonParser, Class<T> cls) {
        return m6626c(jsonParser, this._typeFactory.m7109a((Type) cls));
    }

    public final JsonNode m6635a(InputStream inputStream) {
        JsonNode jsonNode = (JsonNode) mo904b(this._jsonFactory.m7162a(inputStream), f4009f);
        return jsonNode == null ? NullNode.a : jsonNode;
    }

    public final JsonNode m6636a(String str) {
        JsonNode jsonNode = (JsonNode) mo904b(this._jsonFactory.m7165a(str), f4009f);
        return jsonNode == null ? NullNode.a : jsonNode;
    }

    public final JsonNode m6637a(byte[] bArr) {
        JsonNode jsonNode = (JsonNode) mo904b(this._jsonFactory.m7166a(bArr), f4009f);
        return jsonNode == null ? NullNode.a : jsonNode;
    }

    public final JsonNode m6634a(File file) {
        JsonNode jsonNode = (JsonNode) mo904b(this._jsonFactory.m7161a(file), f4009f);
        return jsonNode == null ? NullNode.a : jsonNode;
    }

    public final ObjectNode m6668e() {
        return this._deserializationConfig._nodeFactory.m5233c();
    }

    public final ArrayNode m6669f() {
        return this._deserializationConfig._nodeFactory.m5232b();
    }

    public final JsonParser m6631a(TreeNode treeNode) {
        return new TreeTraversingParser((JsonNode) treeNode, this);
    }

    public final <T> T m6650a(TreeNode treeNode, Class<T> cls) {
        try {
            if (cls == Object.class || !cls.isAssignableFrom(treeNode.getClass())) {
                treeNode = mo908a(m6631a(treeNode), (Class) cls);
            }
            return treeNode;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    public final <T> T m6652a(File file, Class<T> cls) {
        return mo904b(this._jsonFactory.m7161a(file), this._typeFactory.m7109a((Type) cls));
    }

    public final <T> T m6657a(String str, Class<T> cls) {
        return mo904b(this._jsonFactory.m7165a(str), this._typeFactory.m7109a((Type) cls));
    }

    public final <T> T m6655a(String str, TypeReference typeReference) {
        return mo904b(this._jsonFactory.m7165a(str), this._typeFactory.m7105a(typeReference));
    }

    public final <T> T m6656a(String str, JavaType javaType) {
        return mo904b(this._jsonFactory.m7165a(str), javaType);
    }

    public final <T> T m6653a(InputStream inputStream, Class<T> cls) {
        return mo904b(this._jsonFactory.m7162a(inputStream), this._typeFactory.m7109a((Type) cls));
    }

    public final <T> T m6658a(byte[] bArr, Class<T> cls) {
        return mo904b(this._jsonFactory.m7166a(bArr), this._typeFactory.m7109a((Type) cls));
    }

    public final void m6661a(File file, Object obj) {
        m6624b(this._jsonFactory.m7155a(file, JsonEncoding.UTF8), obj);
    }

    public final String m6659a(Object obj) {
        Writer segmentedStringWriter = new SegmentedStringWriter(JsonFactory.m7153b());
        try {
            m6624b(this._jsonFactory.m7159a(segmentedStringWriter), obj);
            return segmentedStringWriter.a();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.a(e2);
        }
    }

    public final ObjectWriter m6670g() {
        return new ObjectWriter(this, this._serializationConfig);
    }

    public final ObjectWriter m6644a(PrettyPrinter prettyPrinter) {
        if (prettyPrinter == null) {
            prettyPrinter = ObjectWriter.a;
        }
        return new ObjectWriter(this, this._serializationConfig, null, prettyPrinter);
    }

    public final ObjectWriter m6671h() {
        return new ObjectWriter(this, this._serializationConfig, null, f4007d);
    }

    public final <T> T m6654a(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        return m6621a(obj, this._typeFactory.m7109a((Type) cls));
    }

    private Object m6621a(Object obj, JavaType javaType) {
        Class c = javaType.m6708c();
        if (c == Object.class || javaType.m6726p() || !c.isAssignableFrom(obj.getClass())) {
            JsonGenerator tokenBuffer = new TokenBuffer(this);
            try {
                mo902a(m6627i().m7244b(SerializationFeature.WRAP_ROOT_VALUE)).m7294a(tokenBuffer, obj);
                JsonParser i = tokenBuffer.m7668i();
                DeserializationConfig j = m6628j();
                JsonToken b = m6623b(i);
                if (b == JsonToken.VALUE_NULL) {
                    obj = mo901a(m6645a(i, j), javaType).mo1798a();
                } else if (b == JsonToken.END_ARRAY || b == JsonToken.END_OBJECT) {
                    obj = null;
                } else {
                    DeserializationContext a = m6645a(i, j);
                    obj = mo901a(a, javaType).mo1797a(i, a);
                }
                i.close();
            } catch (Throwable e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        return obj;
    }

    protected DefaultSerializerProvider mo902a(SerializationConfig serializationConfig) {
        return this._serializerProvider.mo1067a(serializationConfig, this._serializerFactory);
    }

    private static PrettyPrinter m6629k() {
        return f4007d;
    }

    private void m6624b(JsonGenerator jsonGenerator, Object obj) {
        SerializationConfig i = m6627i();
        if (i.m7246c(SerializationFeature.INDENT_OUTPUT)) {
            jsonGenerator.mo1125c();
        }
        if (i.m7246c(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m6622a(jsonGenerator, obj, i);
            return;
        }
        Object obj2 = null;
        try {
            mo902a(i).m7294a(jsonGenerator, obj);
            obj2 = 1;
            jsonGenerator.close();
        } catch (Throwable th) {
            if (obj2 == null) {
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private final void m6622a(JsonGenerator jsonGenerator, Object obj, SerializationConfig serializationConfig) {
        Throwable th;
        Closeable closeable;
        JsonGenerator jsonGenerator2 = null;
        Closeable closeable2 = (Closeable) obj;
        try {
            mo902a(serializationConfig).m7294a(jsonGenerator, obj);
            try {
                jsonGenerator.close();
                try {
                    closeable2.close();
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    if (jsonGenerator2 != null) {
                        try {
                            jsonGenerator2.close();
                        } catch (IOException e) {
                        }
                    }
                    if (closeable != null) {
                        try {
                            closeable.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                closeable = closeable2;
                th = th4;
                if (jsonGenerator2 != null) {
                    jsonGenerator2.close();
                }
                if (closeable != null) {
                    closeable.close();
                }
                throw th;
            }
        } catch (Throwable th32) {
            jsonGenerator2 = jsonGenerator;
            Closeable closeable3 = closeable2;
            th = th32;
            closeable = closeable3;
            if (jsonGenerator2 != null) {
                jsonGenerator2.close();
            }
            if (closeable != null) {
                closeable.close();
            }
            throw th;
        }
    }

    private final void m6625b(JsonGenerator jsonGenerator, Object obj, SerializationConfig serializationConfig) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = (Closeable) obj;
        try {
            mo902a(serializationConfig).m7294a(jsonGenerator, obj);
            if (serializationConfig.m7246c(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
            }
            closeable = null;
            try {
                closeable2.close();
            } catch (Throwable th2) {
                th = th2;
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            closeable = closeable2;
            th = th4;
            if (closeable != null) {
                closeable.close();
            }
            throw th;
        }
    }

    public DefaultDeserializationContext m6645a(JsonParser jsonParser, DeserializationConfig deserializationConfig) {
        return this._deserializationContext.mo1075a(deserializationConfig, jsonParser, this._injectableValues);
    }

    protected Object mo903a(DeserializationConfig deserializationConfig, JsonParser jsonParser, JavaType javaType) {
        Object a;
        JsonToken b = m6623b(jsonParser);
        if (b == JsonToken.VALUE_NULL) {
            a = mo901a(m6645a(jsonParser, deserializationConfig), javaType).mo1798a();
        } else if (b == JsonToken.END_ARRAY || b == JsonToken.END_OBJECT) {
            a = null;
        } else {
            DeserializationContext a2 = m6645a(jsonParser, deserializationConfig);
            JsonDeserializer a3 = mo901a(a2, javaType);
            if (deserializationConfig.m7283b()) {
                a = m6620a(jsonParser, a2, deserializationConfig, javaType, a3);
            } else {
                a = a3.mo1797a(jsonParser, a2);
            }
        }
        jsonParser.mo1796n();
        return a;
    }

    protected Object mo904b(JsonParser jsonParser, JavaType javaType) {
        try {
            Object a;
            JsonToken b = m6623b(jsonParser);
            if (b == JsonToken.VALUE_NULL) {
                a = mo901a(m6645a(jsonParser, m6628j()), javaType).mo1798a();
            } else if (b == JsonToken.END_ARRAY || b == JsonToken.END_OBJECT) {
                a = null;
            } else {
                DeserializationConfig j = m6628j();
                DeserializationContext a2 = m6645a(jsonParser, j);
                JsonDeserializer a3 = mo901a(a2, javaType);
                if (j.m7283b()) {
                    a = m6620a(jsonParser, a2, j, javaType, a3);
                } else {
                    a = a3.mo1797a(jsonParser, a2);
                }
            }
            jsonParser.mo1796n();
            return a;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException e) {
            }
        }
    }

    private static JsonToken m6623b(JsonParser jsonParser) {
        JsonToken g = jsonParser.mo1794g();
        if (g == null) {
            g = jsonParser.mo1766c();
            if (g == null) {
                throw JsonMappingException.a(jsonParser, "No content to map due to end-of-input");
            }
        }
        return g;
    }

    protected JsonDeserializer<Object> mo901a(DeserializationContext deserializationContext, JavaType javaType) {
        JsonDeserializer<Object> jsonDeserializer = (JsonDeserializer) this._rootDeserializers.get(javaType);
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.m7380a(javaType);
            if (jsonDeserializer == null) {
                throw new JsonMappingException("Can not find a deserializer for type " + javaType);
            }
            this._rootDeserializers.put(javaType, jsonDeserializer);
        }
        return jsonDeserializer;
    }
}
