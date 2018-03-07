package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* compiled from: story */
public class JsonFactory implements Versioned, Serializable {
    protected static final int f4082a = Feature.collectDefaults();
    protected static final int f4083b = com.fasterxml.jackson.core.JsonParser.Feature.collectDefaults();
    protected static final int f4084c = com.fasterxml.jackson.core.JsonGenerator.Feature.collectDefaults();
    protected static final ThreadLocal<SoftReference<BufferRecycler>> f4085d = new ThreadLocal();
    private static final SerializableString f4086g = DefaultPrettyPrinter.f4043a;
    private static final long serialVersionUID = 8726401676402117450L;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    public ObjectCodec _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected SerializableString _rootValueSeparator;
    protected final transient CharsToNameCanonicalizer f4087e;
    protected final transient BytesToNameCanonicalizer f4088f;

    /* compiled from: story */
    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);
        
        private final boolean _defaultState;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._defaultState = z;
        }

        public final boolean enabledByDefault() {
            return this._defaultState;
        }

        public final boolean enabledIn(int i) {
            return (getMask() & i) != 0;
        }

        public final int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public JsonFactory(ObjectCodec objectCodec) {
        this.f4087e = CharsToNameCanonicalizer.m7176a();
        this.f4088f = BytesToNameCanonicalizer.m7196a();
        this._factoryFeatures = f4082a;
        this._parserFeatures = f4083b;
        this._generatorFeatures = f4084c;
        this._rootValueSeparator = f4086g;
        this._objectCodec = objectCodec;
    }

    protected JsonFactory(JsonFactory jsonFactory) {
        this.f4087e = CharsToNameCanonicalizer.m7176a();
        this.f4088f = BytesToNameCanonicalizer.m7196a();
        this._factoryFeatures = f4082a;
        this._parserFeatures = f4083b;
        this._generatorFeatures = f4084c;
        this._rootValueSeparator = f4086g;
        this._objectCodec = null;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._characterEscapes = jsonFactory._characterEscapes;
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
    }

    protected Object readResolve() {
        return new JsonFactory(this);
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final boolean m7171a(Feature feature) {
        return (this._factoryFeatures & feature.getMask()) != 0;
    }

    public final JsonFactory m7154a(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    public ObjectCodec mo1827a() {
        return this._objectCodec;
    }

    public JsonParser m7161a(File file) {
        IOContext a = m7169a((Object) file, true);
        InputStream fileInputStream = new FileInputStream(file);
        if (this._inputDecorator != null) {
            fileInputStream = this._inputDecorator.a();
        }
        return m7163a(fileInputStream, a);
    }

    public JsonParser m7162a(InputStream inputStream) {
        IOContext a = m7169a((Object) inputStream, false);
        if (this._inputDecorator != null) {
            inputStream = this._inputDecorator.a();
        }
        return m7163a(inputStream, a);
    }

    public JsonParser m7166a(byte[] bArr) {
        IOContext a = m7169a((Object) bArr, true);
        if (this._inputDecorator != null) {
            InputStream b = this._inputDecorator.b();
            if (b != null) {
                return m7163a(b, a);
            }
        }
        return m7167a(bArr, 0, bArr.length, a);
    }

    public final JsonParser m7165a(String str) {
        Reader stringReader = new StringReader(str);
        IOContext a = m7169a((Object) stringReader, true);
        if (this._inputDecorator != null) {
            stringReader = this._inputDecorator.c();
        }
        return m7164a(stringReader, a);
    }

    @Deprecated
    public final JsonParser m7173b(String str) {
        return m7165a(str);
    }

    public JsonGenerator m7157a(OutputStream outputStream, JsonEncoding jsonEncoding) {
        IOContext a = m7169a((Object) outputStream, false);
        a.f7310b = jsonEncoding;
        if (jsonEncoding == JsonEncoding.UTF8) {
            if (this._outputDecorator != null) {
                outputStream = this._outputDecorator.a();
            }
            return m7158a(outputStream, a);
        }
        Writer a2 = m7170a(outputStream, jsonEncoding, a);
        if (this._outputDecorator != null) {
            a2 = this._outputDecorator.b();
        }
        return m7160a(a2, a);
    }

    public JsonGenerator m7156a(OutputStream outputStream) {
        return m7157a(outputStream, JsonEncoding.UTF8);
    }

    public final JsonGenerator m7159a(Writer writer) {
        IOContext a = m7169a((Object) writer, false);
        if (this._outputDecorator != null) {
            writer = this._outputDecorator.b();
        }
        return m7160a(writer, a);
    }

    public final JsonGenerator m7155a(File file, JsonEncoding jsonEncoding) {
        OutputStream fileOutputStream = new FileOutputStream(file);
        IOContext a = m7169a((Object) fileOutputStream, true);
        a.f7310b = jsonEncoding;
        if (jsonEncoding == JsonEncoding.UTF8) {
            if (this._outputDecorator != null) {
                fileOutputStream = this._outputDecorator.a();
            }
            return m7158a(fileOutputStream, a);
        }
        Writer a2 = m7170a(fileOutputStream, jsonEncoding, a);
        if (this._outputDecorator != null) {
            a2 = this._outputDecorator.b();
        }
        return m7160a(a2, a);
    }

    @Deprecated
    public JsonGenerator m7172b(OutputStream outputStream) {
        return m7157a(outputStream, JsonEncoding.UTF8);
    }

    protected JsonParser m7163a(InputStream inputStream, IOContext iOContext) {
        return new ByteSourceJsonBootstrapper(iOContext, inputStream).m29645a(this._parserFeatures, this._objectCodec, this.f4088f, this.f4087e, m7171a(Feature.CANONICALIZE_FIELD_NAMES), m7171a(Feature.INTERN_FIELD_NAMES));
    }

    protected JsonParser m7164a(Reader reader, IOContext iOContext) {
        return new ReaderBasedJsonParser(iOContext, this._parserFeatures, reader, this._objectCodec, this.f4087e.m7188a(m7171a(Feature.CANONICALIZE_FIELD_NAMES), m7171a(Feature.INTERN_FIELD_NAMES)));
    }

    protected JsonParser m7167a(byte[] bArr, int i, int i2, IOContext iOContext) {
        return new ByteSourceJsonBootstrapper(iOContext, bArr, i, i2).m29645a(this._parserFeatures, this._objectCodec, this.f4088f, this.f4087e, m7171a(Feature.CANONICALIZE_FIELD_NAMES), m7171a(Feature.INTERN_FIELD_NAMES));
    }

    protected JsonGenerator m7160a(Writer writer, IOContext iOContext) {
        JsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, this._generatorFeatures, this._objectCodec, writer);
        if (this._characterEscapes != null) {
            writerBasedJsonGenerator.mo1657a(this._characterEscapes);
        }
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString != f4086g) {
            writerBasedJsonGenerator.mo1656a(serializableString);
        }
        return writerBasedJsonGenerator;
    }

    protected JsonGenerator m7158a(OutputStream outputStream, IOContext iOContext) {
        UTF8JsonGenerator uTF8JsonGenerator = new UTF8JsonGenerator(iOContext, this._generatorFeatures, this._objectCodec, outputStream);
        if (this._characterEscapes != null) {
            uTF8JsonGenerator.mo1657a(this._characterEscapes);
        }
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString != f4086g) {
            uTF8JsonGenerator.mo1656a(serializableString);
        }
        return uTF8JsonGenerator;
    }

    protected Writer m7170a(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Writer(iOContext, outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected final IOContext m7169a(Object obj, boolean z) {
        return new IOContext(m7153b(), obj, z);
    }

    public static BufferRecycler m7153b() {
        SoftReference softReference = (SoftReference) f4085d.get();
        BufferRecycler bufferRecycler = softReference == null ? null : (BufferRecycler) softReference.get();
        if (bufferRecycler != null) {
            return bufferRecycler;
        }
        bufferRecycler = new BufferRecycler();
        f4085d.set(new SoftReference(bufferRecycler));
        return bufferRecycler;
    }
}
