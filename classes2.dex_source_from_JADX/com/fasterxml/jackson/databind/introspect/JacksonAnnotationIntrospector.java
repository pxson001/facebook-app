package com.fasterxml.jackson.databind.introspect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: story_id */
public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    private static final long serialVersionUID = 1;

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final boolean mo979a(Annotation annotation) {
        return annotation.annotationType().getAnnotation(JacksonAnnotationsInside.class) != null;
    }

    public final PropertyName mo970a(AnnotatedClass annotatedClass) {
        JsonRootName jsonRootName = (JsonRootName) annotatedClass.mo936a(JsonRootName.class);
        if (jsonRootName == null) {
            return null;
        }
        return new PropertyName(jsonRootName.value());
    }

    public final String[] mo985b(Annotated annotated) {
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) annotated.mo936a(JsonIgnoreProperties.class);
        return jsonIgnoreProperties == null ? null : jsonIgnoreProperties.a();
    }

    public final Boolean mo982b(AnnotatedClass annotatedClass) {
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) annotatedClass.mo936a(JsonIgnoreProperties.class);
        return jsonIgnoreProperties == null ? null : Boolean.valueOf(jsonIgnoreProperties.b());
    }

    public final Boolean mo986c(AnnotatedClass annotatedClass) {
        JsonIgnoreType jsonIgnoreType = (JsonIgnoreType) annotatedClass.mo936a(JsonIgnoreType.class);
        return jsonIgnoreType == null ? null : Boolean.valueOf(jsonIgnoreType.a());
    }

    public final Object mo990d(AnnotatedClass annotatedClass) {
        JsonFilter jsonFilter = (JsonFilter) annotatedClass.mo936a(JsonFilter.class);
        if (jsonFilter != null) {
            String value = jsonFilter.value();
            if (value.length() > 0) {
                return value;
            }
        }
        return null;
    }

    public final Object mo996e(AnnotatedClass annotatedClass) {
        JsonNaming jsonNaming = (JsonNaming) annotatedClass.mo936a(JsonNaming.class);
        return jsonNaming == null ? null : jsonNaming.value();
    }

    public final VisibilityChecker<?> mo973a(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) annotatedClass.mo936a(JsonAutoDetect.class);
        return jsonAutoDetect == null ? visibilityChecker : visibilityChecker.mo1027a(jsonAutoDetect);
    }

    public final ReferenceProperty mo969a(AnnotatedMember annotatedMember) {
        JsonManagedReference jsonManagedReference = (JsonManagedReference) annotatedMember.mo936a(JsonManagedReference.class);
        if (jsonManagedReference != null) {
            return ReferenceProperty.a(jsonManagedReference.value());
        }
        JsonBackReference jsonBackReference = (JsonBackReference) annotatedMember.mo936a(JsonBackReference.class);
        if (jsonBackReference != null) {
            return ReferenceProperty.b(jsonBackReference.value());
        }
        return null;
    }

    public final NameTransformer mo981b(AnnotatedMember annotatedMember) {
        JsonUnwrapped jsonUnwrapped = (JsonUnwrapped) annotatedMember.mo936a(JsonUnwrapped.class);
        if (jsonUnwrapped == null || !jsonUnwrapped.a()) {
            return null;
        }
        return NameTransformer.a(jsonUnwrapped.prefix(), jsonUnwrapped.suffix());
    }

    public final boolean mo989c(AnnotatedMember annotatedMember) {
        return m6870C(annotatedMember);
    }

    public final Boolean mo995e(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.mo936a(JsonProperty.class);
        if (jsonProperty != null) {
            return Boolean.valueOf(jsonProperty.a());
        }
        return null;
    }

    public final Object mo991d(AnnotatedMember annotatedMember) {
        JacksonInject jacksonInject = (JacksonInject) annotatedMember.mo936a(JacksonInject.class);
        if (jacksonInject == null) {
            return null;
        }
        Object value = jacksonInject.value();
        if (value.length() != 0) {
            return value;
        }
        if (!(annotatedMember instanceof AnnotatedMethod)) {
            return annotatedMember.mo940d().getName();
        }
        AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
        if (annotatedMethod.l() == 0) {
            return annotatedMember.mo940d().getName();
        }
        return annotatedMethod.a(0).getName();
    }

    public final TypeResolverBuilder<?> mo974a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return m6871a((MapperConfig) mapperConfig, (Annotated) annotatedClass, javaType);
    }

    public final TypeResolverBuilder<?> mo975a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.mo924l()) {
            return null;
        }
        return m6871a((MapperConfig) mapperConfig, (Annotated) annotatedMember, javaType);
    }

    public final TypeResolverBuilder<?> mo980b(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.mo924l()) {
            return m6871a((MapperConfig) mapperConfig, (Annotated) annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container type (got " + javaType + ")");
    }

    public final List<NamedType> mo988c(Annotated annotated) {
        JsonSubTypes jsonSubTypes = (JsonSubTypes) annotated.mo936a(JsonSubTypes.class);
        if (jsonSubTypes == null) {
            return null;
        }
        Type[] a = jsonSubTypes.a();
        List<NamedType> arrayList = new ArrayList(a.length);
        for (Type type : a) {
            arrayList.add(new NamedType(type.value(), type.name()));
        }
        return arrayList;
    }

    public final String mo1000f(AnnotatedClass annotatedClass) {
        JsonTypeName jsonTypeName = (JsonTypeName) annotatedClass.mo936a(JsonTypeName.class);
        return jsonTypeName == null ? null : jsonTypeName.value();
    }

    public final Object mo999f(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class using = jsonSerialize.using();
            if (using != None.class) {
                return using;
            }
        }
        JsonRawValue jsonRawValue = (JsonRawValue) annotated.mo936a(JsonRawValue.class);
        if (jsonRawValue == null || !jsonRawValue.a()) {
            return null;
        }
        return new RawSerializer(annotated.mo940d());
    }

    public final Object mo1002g(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class keyUsing = jsonSerialize.keyUsing();
            if (keyUsing != None.class) {
                return keyUsing;
            }
        }
        return null;
    }

    public final Object mo1005h(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class contentUsing = jsonSerialize.contentUsing();
            if (contentUsing != None.class) {
                return contentUsing;
            }
        }
        return null;
    }

    public final JsonInclude$Include mo968a(Annotated annotated, JsonInclude$Include jsonInclude$Include) {
        JsonInclude jsonInclude = (JsonInclude) annotated.mo936a(JsonInclude.class);
        if (jsonInclude != null) {
            return jsonInclude.value();
        }
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize == null) {
            return jsonInclude$Include;
        }
        switch (1.a[jsonSerialize.include().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return JsonInclude$Include.ALWAYS;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return JsonInclude$Include.NON_NULL;
            case 3:
                return JsonInclude$Include.NON_DEFAULT;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return JsonInclude$Include.NON_EMPTY;
            default:
                return jsonInclude$Include;
        }
    }

    public final Class<?> mo1007i(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class<?> as = jsonSerialize.as();
            if (as != NoClass.class) {
                return as;
            }
        }
        return null;
    }

    public final Class<?> mo1010j(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class<?> keyAs = jsonSerialize.keyAs();
            if (keyAs != NoClass.class) {
                return keyAs;
            }
        }
        return null;
    }

    public final Class<?> mo1013k(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class<?> contentAs = jsonSerialize.contentAs();
            if (contentAs != NoClass.class) {
                return contentAs;
            }
        }
        return null;
    }

    public final Typing mo1014l(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        return jsonSerialize == null ? null : jsonSerialize.typing();
    }

    public final Object mo1015m(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class converter = jsonSerialize.converter();
            if (converter != Converter.None.class) {
                return converter;
            }
        }
        return null;
    }

    public final Object mo1006h(AnnotatedMember annotatedMember) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotatedMember.mo936a(JsonSerialize.class);
        if (jsonSerialize != null) {
            Class contentConverter = jsonSerialize.contentConverter();
            if (contentConverter != Converter.None.class) {
                return contentConverter;
            }
        }
        return null;
    }

    public final Class<?>[] mo993d(Annotated annotated) {
        JsonView jsonView = (JsonView) annotated.mo936a(JsonView.class);
        return jsonView == null ? null : jsonView.a();
    }

    public final Boolean mo1001g(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(annotatedMember.m6800b(JsonTypeId.class));
    }

    public final ObjectIdInfo mo971a(Annotated annotated) {
        JsonIdentityInfo jsonIdentityInfo = (JsonIdentityInfo) annotated.mo936a(JsonIdentityInfo.class);
        if (jsonIdentityInfo == null || jsonIdentityInfo.generator() == ObjectIdGenerators.None.class) {
            return null;
        }
        return new ObjectIdInfo(jsonIdentityInfo.property(), jsonIdentityInfo.scope(), jsonIdentityInfo.generator());
    }

    public final ObjectIdInfo mo972a(Annotated annotated, ObjectIdInfo objectIdInfo) {
        JsonIdentityReference jsonIdentityReference = (JsonIdentityReference) annotated.mo936a(JsonIdentityReference.class);
        if (jsonIdentityReference != null) {
            return objectIdInfo.a(jsonIdentityReference.a());
        }
        return objectIdInfo;
    }

    public final Value mo998f(AnnotatedMember annotatedMember) {
        return mo998f(annotatedMember);
    }

    public final Value mo994e(Annotated annotated) {
        JsonFormat jsonFormat = (JsonFormat) annotated.mo936a(JsonFormat.class);
        return jsonFormat == null ? null : new Value(jsonFormat);
    }

    public final String[] mo1003g(AnnotatedClass annotatedClass) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotatedClass.mo936a(JsonPropertyOrder.class);
        return jsonPropertyOrder == null ? null : jsonPropertyOrder.a();
    }

    public final Boolean mo1004h(AnnotatedClass annotatedClass) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotatedClass.mo936a(JsonPropertyOrder.class);
        return jsonPropertyOrder == null ? null : Boolean.valueOf(jsonPropertyOrder.b());
    }

    public final PropertyName mo1016n(Annotated annotated) {
        String a = annotated instanceof AnnotatedField ? mo976a((AnnotatedField) annotated) : annotated instanceof AnnotatedMethod ? mo977a((AnnotatedMethod) annotated) : null;
        if (a == null) {
            return null;
        }
        if (a.length() == 0) {
            return PropertyName.a;
        }
        return new PropertyName(a);
    }

    public final String mo976a(AnnotatedField annotatedField) {
        JsonProperty jsonProperty = (JsonProperty) annotatedField.mo936a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (annotatedField.m6800b(JsonSerialize.class) || annotatedField.m6800b(JsonView.class)) {
            return "";
        }
        return null;
    }

    public final String mo977a(AnnotatedMethod annotatedMethod) {
        JsonGetter jsonGetter = (JsonGetter) annotatedMethod.mo936a(JsonGetter.class);
        if (jsonGetter != null) {
            return jsonGetter.value();
        }
        JsonProperty jsonProperty = (JsonProperty) annotatedMethod.mo936a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (annotatedMethod.m6800b(JsonSerialize.class) || annotatedMethod.m6800b(JsonView.class)) {
            return "";
        }
        return null;
    }

    public final boolean mo984b(AnnotatedMethod annotatedMethod) {
        JsonValue jsonValue = (JsonValue) annotatedMethod.mo936a(JsonValue.class);
        return jsonValue != null && jsonValue.a();
    }

    public final Object mo1017o(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class using = jsonDeserialize.using();
            if (using != JsonDeserializer.None.class) {
                return using;
            }
        }
        return null;
    }

    public final Object mo1018p(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class keyUsing = jsonDeserialize.keyUsing();
            if (keyUsing != KeyDeserializer.None.class) {
                return keyUsing;
            }
        }
        return null;
    }

    public final Object mo1019q(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class contentUsing = jsonDeserialize.contentUsing();
            if (contentUsing != JsonDeserializer.None.class) {
                return contentUsing;
            }
        }
        return null;
    }

    public final Class<?> mo1020r(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class<?> as = jsonDeserialize.as();
            if (as != NoClass.class) {
                return as;
            }
        }
        return null;
    }

    public final Class<?> mo1021s(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class<?> keyAs = jsonDeserialize.keyAs();
            if (keyAs != NoClass.class) {
                return keyAs;
            }
        }
        return null;
    }

    public final Class<?> mo1022t(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class<?> contentAs = jsonDeserialize.contentAs();
            if (contentAs != NoClass.class) {
                return contentAs;
            }
        }
        return null;
    }

    public final Object mo1023u(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class converter = jsonDeserialize.converter();
            if (converter != Converter.None.class) {
                return converter;
            }
        }
        return null;
    }

    public final Object mo1009i(AnnotatedMember annotatedMember) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotatedMember.mo936a(JsonDeserialize.class);
        if (jsonDeserialize != null) {
            Class contentConverter = jsonDeserialize.contentConverter();
            if (contentConverter != Converter.None.class) {
                return contentConverter;
            }
        }
        return null;
    }

    public final Object mo1008i(AnnotatedClass annotatedClass) {
        JsonValueInstantiator jsonValueInstantiator = (JsonValueInstantiator) annotatedClass.mo936a(JsonValueInstantiator.class);
        return jsonValueInstantiator == null ? null : jsonValueInstantiator.value();
    }

    public final Class<?> mo1011j(AnnotatedClass annotatedClass) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotatedClass.mo936a(JsonDeserialize.class);
        if (jsonDeserialize == null || jsonDeserialize.builder() == NoClass.class) {
            return null;
        }
        return jsonDeserialize.builder();
    }

    public final JsonPOJOBuilder.Value mo1012k(AnnotatedClass annotatedClass) {
        JsonPOJOBuilder jsonPOJOBuilder = (JsonPOJOBuilder) annotatedClass.mo936a(JsonPOJOBuilder.class);
        return jsonPOJOBuilder == null ? null : new JsonPOJOBuilder.Value(jsonPOJOBuilder);
    }

    public final PropertyName mo1024v(Annotated annotated) {
        String b = annotated instanceof AnnotatedField ? mo983b((AnnotatedField) annotated) : annotated instanceof AnnotatedMethod ? mo987c((AnnotatedMethod) annotated) : annotated instanceof AnnotatedParameter ? mo978a((AnnotatedParameter) annotated) : null;
        if (b == null) {
            return null;
        }
        if (b.length() == 0) {
            return PropertyName.a;
        }
        return new PropertyName(b);
    }

    public final String mo987c(AnnotatedMethod annotatedMethod) {
        JsonSetter jsonSetter = (JsonSetter) annotatedMethod.mo936a(JsonSetter.class);
        if (jsonSetter != null) {
            return jsonSetter.value();
        }
        JsonProperty jsonProperty = (JsonProperty) annotatedMethod.mo936a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (annotatedMethod.m6800b(JsonDeserialize.class) || annotatedMethod.m6800b(JsonView.class) || annotatedMethod.m6800b(JsonBackReference.class) || annotatedMethod.m6800b(JsonManagedReference.class)) {
            return "";
        }
        return null;
    }

    public final String mo983b(AnnotatedField annotatedField) {
        JsonProperty jsonProperty = (JsonProperty) annotatedField.mo936a(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (annotatedField.m6800b(JsonDeserialize.class) || annotatedField.m6800b(JsonView.class) || annotatedField.m6800b(JsonBackReference.class) || annotatedField.m6800b(JsonManagedReference.class)) {
            return "";
        }
        return null;
    }

    public final String mo978a(AnnotatedParameter annotatedParameter) {
        if (annotatedParameter != null) {
            JsonProperty jsonProperty = (JsonProperty) annotatedParameter.mo936a(JsonProperty.class);
            if (jsonProperty != null) {
                return jsonProperty.value();
            }
        }
        return null;
    }

    public final boolean mo992d(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.m6800b(JsonAnySetter.class);
    }

    public final boolean mo997e(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.m6800b(JsonAnyGetter.class);
    }

    public final boolean mo1025w(Annotated annotated) {
        return annotated.m6800b(JsonCreator.class);
    }

    private static boolean m6870C(Annotated annotated) {
        JsonIgnore jsonIgnore = (JsonIgnore) annotated.mo936a(JsonIgnore.class);
        return jsonIgnore != null && jsonIgnore.a();
    }

    private TypeResolverBuilder<?> m6871a(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) {
        TypeResolverBuilder a;
        TypeIdResolver typeIdResolver;
        JsonTypeInfo jsonTypeInfo = (JsonTypeInfo) annotated.mo936a(JsonTypeInfo.class);
        JsonTypeResolver jsonTypeResolver = (JsonTypeResolver) annotated.mo936a(JsonTypeResolver.class);
        if (jsonTypeResolver != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            a = mapperConfig.m7256a(annotated, jsonTypeResolver.value());
        } else if (jsonTypeInfo == null) {
            return null;
        } else {
            if (jsonTypeInfo.use() == Id.NONE) {
                return StdTypeResolverBuilder.b();
            }
            a = m6872c();
        }
        JsonTypeIdResolver jsonTypeIdResolver = (JsonTypeIdResolver) annotated.mo936a(JsonTypeIdResolver.class);
        if (jsonTypeIdResolver == null) {
            typeIdResolver = null;
        } else {
            typeIdResolver = mapperConfig.m7259b(annotated, jsonTypeIdResolver.value());
        }
        a = a.a(jsonTypeInfo.use(), typeIdResolver);
        As include = jsonTypeInfo.include();
        if (include == As.EXTERNAL_PROPERTY && (annotated instanceof AnnotatedClass)) {
            include = As.PROPERTY;
        }
        TypeResolverBuilder a2 = a.a(include).a(jsonTypeInfo.property());
        Class defaultImpl = jsonTypeInfo.defaultImpl();
        if (defaultImpl != JsonTypeInfo.None.class) {
            a2 = a2.a(defaultImpl);
        }
        return a2.a(jsonTypeInfo.a());
    }

    private static StdTypeResolverBuilder m6872c() {
        return new StdTypeResolverBuilder();
    }

    private static StdTypeResolverBuilder m6873d() {
        return StdTypeResolverBuilder.b();
    }
}
