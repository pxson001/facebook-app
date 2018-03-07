package com.fasterxml.jackson.dataformat.smile;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.smile.SmileParser.Feature;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* compiled from: can_viewer_delete */
public class SmileFactory extends JsonFactory {
    static final int f6273g = Feature.collectDefaults();
    static final int f6274h = SmileGenerator.Feature.collectDefaults();
    private static final long serialVersionUID = -1696783009312472365L;
    protected boolean _cfgDelegateToTextual;
    protected int _smileGeneratorFeatures;
    protected int _smileParserFeatures;

    protected final /* synthetic */ JsonParser m11876a(InputStream inputStream, IOContext iOContext) {
        return m11868b(inputStream, iOContext);
    }

    protected final /* synthetic */ JsonParser m11879a(byte[] bArr, int i, int i2, IOContext iOContext) {
        return m11869b(bArr, i, i2, iOContext);
    }

    public SmileFactory() {
        this(null);
    }

    public SmileFactory(ObjectCodec objectCodec) {
        super(objectCodec);
        this._smileParserFeatures = f6273g;
        this._smileGeneratorFeatures = f6274h;
    }

    private SmileFactory(SmileFactory smileFactory, ObjectCodec objectCodec) {
        super(smileFactory);
        this._cfgDelegateToTextual = smileFactory._cfgDelegateToTextual;
        this._smileParserFeatures = smileFactory._smileParserFeatures;
        this._smileGeneratorFeatures = smileFactory._smileGeneratorFeatures;
    }

    protected Object readResolve() {
        return new SmileFactory(this, this._objectCodec);
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final JsonParser m11874a(File file) {
        return m11868b(new FileInputStream(file), a(file, true));
    }

    public final JsonParser m11875a(InputStream inputStream) {
        return m11868b(inputStream, a(inputStream, false));
    }

    public final JsonParser m11878a(byte[] bArr) {
        return m11869b(bArr, 0, bArr.length, a(bArr, true));
    }

    public final JsonGenerator m11871a(OutputStream outputStream, JsonEncoding jsonEncoding) {
        return m11867b(outputStream, a(outputStream, false));
    }

    public final JsonGenerator m11870a(OutputStream outputStream) {
        return m11867b(outputStream, a(outputStream, false));
    }

    @Deprecated
    public final JsonGenerator m11881b(OutputStream outputStream) {
        return m11867b(outputStream, a(outputStream, false));
    }

    private SmileParser m11868b(InputStream inputStream, IOContext iOContext) {
        return new SmileParserBootstrapper(iOContext, inputStream).m12000a(this._parserFeatures, this._smileParserFeatures, a(JsonFactory.Feature.INTERN_FIELD_NAMES), this._objectCodec, this.f);
    }

    protected final JsonParser m11877a(Reader reader, IOContext iOContext) {
        if (this._cfgDelegateToTextual) {
            return super.a(reader, iOContext);
        }
        throw new UnsupportedOperationException("Can not create generator for non-byte-based target");
    }

    private SmileParser m11869b(byte[] bArr, int i, int i2, IOContext iOContext) {
        return new SmileParserBootstrapper(iOContext, bArr, i, i2).m12000a(this._parserFeatures, this._smileParserFeatures, a(JsonFactory.Feature.INTERN_FIELD_NAMES), this._objectCodec, this.f);
    }

    protected final JsonGenerator m11873a(Writer writer, IOContext iOContext) {
        if (this._cfgDelegateToTextual) {
            return super.a(writer, iOContext);
        }
        throw new UnsupportedOperationException("Can not create generator for non-byte-based target");
    }

    protected final JsonGenerator m11872a(OutputStream outputStream, IOContext iOContext) {
        return m11867b(outputStream, iOContext);
    }

    protected final Writer m11880a(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) {
        if (this._cfgDelegateToTextual) {
            return super.a(outputStream, jsonEncoding, iOContext);
        }
        throw new UnsupportedOperationException("Can not create generator for non-byte-based target");
    }

    private SmileGenerator m11867b(OutputStream outputStream, IOContext iOContext) {
        int i = this._smileGeneratorFeatures;
        SmileGenerator smileGenerator = new SmileGenerator(iOContext, this._generatorFeatures, i, this._objectCodec, outputStream);
        if ((SmileGenerator.Feature.WRITE_HEADER.getMask() & i) != 0) {
            smileGenerator.m11944l();
        } else if ((SmileGenerator.Feature.CHECK_SHARED_STRING_VALUES.getMask() & i) != 0) {
            throw new JsonGenerationException("Inconsistent settings: WRITE_HEADER disabled, but CHECK_SHARED_STRING_VALUES enabled; can not construct generator due to possible data loss (either enable WRITE_HEADER, or disable CHECK_SHARED_STRING_VALUES to resolve)");
        } else if ((SmileGenerator.Feature.ENCODE_BINARY_AS_7BIT.getMask() & i) == 0) {
            throw new JsonGenerationException("Inconsistent settings: WRITE_HEADER disabled, but ENCODE_BINARY_AS_7BIT disabled; can not construct generator due to possible data loss (either enable WRITE_HEADER, or ENCODE_BINARY_AS_7BIT to resolve)");
        }
        return smileGenerator;
    }
}
