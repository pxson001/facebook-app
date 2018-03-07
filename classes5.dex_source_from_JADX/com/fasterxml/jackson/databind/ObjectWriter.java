package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/* compiled from: client_override_group_index */
public class ObjectWriter implements Versioned, Serializable {
    protected static final PrettyPrinter f5980a = new MinimalPrettyPrinter();
    private static final long serialVersionUID = -7024829992408267532L;
    protected final SerializationConfig _config;
    protected final JsonFactory _jsonFactory;
    protected final PrettyPrinter _prettyPrinter;
    protected final JsonSerializer<Object> _rootSerializer;
    protected final JavaType _rootType;
    protected final FormatSchema _schema;
    protected final SerializerFactory _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, JavaType javaType, PrettyPrinter prettyPrinter) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._jsonFactory = objectMapper._jsonFactory;
        if (javaType != null) {
            javaType = javaType.b();
        }
        this._rootType = javaType;
        this._prettyPrinter = prettyPrinter;
        this._schema = null;
        this._rootSerializer = m10792a(serializationConfig, javaType);
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._jsonFactory = objectMapper._jsonFactory;
        this._rootType = null;
        this._rootSerializer = null;
        this._prettyPrinter = null;
        this._schema = null;
    }

    private ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig, JavaType javaType, JsonSerializer<Object> jsonSerializer, PrettyPrinter prettyPrinter, FormatSchema formatSchema) {
        this._config = serializationConfig;
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._jsonFactory = objectWriter._jsonFactory;
        this._rootType = javaType;
        this._rootSerializer = jsonSerializer;
        this._prettyPrinter = prettyPrinter;
        this._schema = formatSchema;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final ObjectWriter m10798a() {
        return m10793a(new DefaultPrettyPrinter());
    }

    private ObjectWriter m10793a(PrettyPrinter prettyPrinter) {
        if (prettyPrinter == this._prettyPrinter) {
            return this;
        }
        PrettyPrinter prettyPrinter2;
        if (prettyPrinter == null) {
            prettyPrinter2 = f5980a;
        } else {
            prettyPrinter2 = prettyPrinter;
        }
        return new ObjectWriter(this, this._config, this._rootType, this._rootSerializer, prettyPrinter2, this._schema);
    }

    public final void m10800a(File file, Object obj) {
        m10796a(this._jsonFactory.a(file, JsonEncoding.UTF8), obj);
    }

    public final String m10799a(Object obj) {
        SegmentedStringWriter segmentedStringWriter = new SegmentedStringWriter(JsonFactory.b());
        try {
            m10796a(this._jsonFactory.a(segmentedStringWriter), obj);
            return segmentedStringWriter.a();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.a(e2);
        }
    }

    private DefaultSerializerProvider m10794a(SerializationConfig serializationConfig) {
        return this._serializerProvider.a(serializationConfig, this._serializerFactory);
    }

    private void m10796a(JsonGenerator jsonGenerator, Object obj) {
        m10795a(jsonGenerator);
        if (this._config.c(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m10797a(jsonGenerator, obj, this._config);
            return;
        }
        try {
            if (this._rootType == null) {
                m10794a(this._config).a(jsonGenerator, obj);
            } else {
                m10794a(this._config).a(jsonGenerator, obj, this._rootType, this._rootSerializer);
            }
            jsonGenerator.close();
        } catch (Throwable th) {
            if (null == null) {
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private final void m10797a(JsonGenerator jsonGenerator, Object obj, SerializationConfig serializationConfig) {
        Throwable th;
        Closeable closeable;
        Closeable closeable2 = (Closeable) obj;
        try {
            if (this._rootType == null) {
                m10794a(serializationConfig).a(jsonGenerator, obj);
            } else {
                m10794a(serializationConfig).a(jsonGenerator, obj, this._rootType, this._rootSerializer);
            }
            try {
                jsonGenerator.close();
            } catch (Throwable th2) {
                jsonGenerator = null;
                Closeable closeable3 = closeable2;
                th = th2;
                closeable = closeable3;
                if (jsonGenerator != null) {
                    try {
                        jsonGenerator.close();
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
            try {
                closeable2.close();
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                jsonGenerator = null;
                if (jsonGenerator != null) {
                    jsonGenerator.close();
                }
                if (closeable != null) {
                    closeable.close();
                }
                throw th;
            }
        } catch (Throwable th22) {
            Throwable th4 = th22;
            closeable = closeable2;
            th = th4;
            if (jsonGenerator != null) {
                jsonGenerator.close();
            }
            if (closeable != null) {
                closeable.close();
            }
            throw th;
        }
    }

    private JsonSerializer<Object> m10792a(SerializationConfig serializationConfig, JavaType javaType) {
        JsonSerializer<Object> jsonSerializer = null;
        if (javaType != null && this._config.c(SerializationFeature.EAGER_SERIALIZER_FETCH)) {
            try {
                jsonSerializer = m10794a(serializationConfig).a(javaType, true, null);
            } catch (JsonProcessingException e) {
            }
        }
        return jsonSerializer;
    }

    private void m10795a(JsonGenerator jsonGenerator) {
        if (this._prettyPrinter != null) {
            PrettyPrinter prettyPrinter = this._prettyPrinter;
            if (prettyPrinter == f5980a) {
                jsonGenerator.a(null);
            } else {
                if (prettyPrinter instanceof Instantiatable) {
                    prettyPrinter = (PrettyPrinter) ((Instantiatable) prettyPrinter).a();
                }
                jsonGenerator.a(prettyPrinter);
            }
        } else if (this._config.c(SerializationFeature.INDENT_OUTPUT)) {
            jsonGenerator.c();
        }
        if (this._schema != null) {
            jsonGenerator.a(this._schema);
        }
    }
}
