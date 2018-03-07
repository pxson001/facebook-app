package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: checkin_url */
public class JdkDeserializers {
    private static final HashSet<String> f6081a = new HashSet();

    /* compiled from: checkin_url */
    public class AtomicBooleanDeserializer extends StdScalarDeserializer<AtomicBoolean> {
        public static final AtomicBooleanDeserializer f6070a = new AtomicBooleanDeserializer();

        public /* synthetic */ Object m11190a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11191b(jsonParser, deserializationContext);
        }

        public AtomicBooleanDeserializer() {
            super(AtomicBoolean.class);
        }

        public AtomicBoolean m11191b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new AtomicBoolean(k(jsonParser, deserializationContext));
        }
    }

    /* compiled from: checkin_url */
    public class AtomicReferenceDeserializer extends StdScalarDeserializer<AtomicReference<?>> implements ContextualDeserializer {
        protected final JavaType _referencedType;
        protected final JsonDeserializer<?> _valueDeserializer;

        public /* synthetic */ Object m11193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11194b(jsonParser, deserializationContext);
        }

        public AtomicReferenceDeserializer(JavaType javaType) {
            this(javaType, null);
        }

        private AtomicReferenceDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
            super(AtomicReference.class);
            this._referencedType = javaType;
            this._valueDeserializer = jsonDeserializer;
        }

        public AtomicReference<?> m11194b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new AtomicReference(this._valueDeserializer.a(jsonParser, deserializationContext));
        }

        public final JsonDeserializer<?> m11192a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
            return this._valueDeserializer != null ? this : new AtomicReferenceDeserializer(this._referencedType, deserializationContext.a(this._referencedType, beanProperty));
        }
    }

    /* compiled from: checkin_url */
    public class CharsetDeserializer extends FromStringDeserializer<Charset> {
        public static final CharsetDeserializer f6071a = new CharsetDeserializer();

        public CharsetDeserializer() {
            super(Charset.class);
        }

        protected final Object m11195a(String str, DeserializationContext deserializationContext) {
            return Charset.forName(str);
        }
    }

    /* compiled from: checkin_url */
    public class CurrencyDeserializer extends FromStringDeserializer<Currency> {
        public static final CurrencyDeserializer f6072a = new CurrencyDeserializer();

        public CurrencyDeserializer() {
            super(Currency.class);
        }

        protected final Object m11196a(String str, DeserializationContext deserializationContext) {
            return Currency.getInstance(str);
        }
    }

    /* compiled from: checkin_url */
    public class FileDeserializer extends FromStringDeserializer<File> {
        public static final FileDeserializer f6073a = new FileDeserializer();

        public FileDeserializer() {
            super(File.class);
        }

        protected final Object m11197a(String str, DeserializationContext deserializationContext) {
            return new File(str);
        }
    }

    /* compiled from: checkin_url */
    public class InetAddressDeserializer extends FromStringDeserializer<InetAddress> {
        public static final InetAddressDeserializer f6074a = new InetAddressDeserializer();

        public InetAddressDeserializer() {
            super(InetAddress.class);
        }

        protected final Object m11198a(String str, DeserializationContext deserializationContext) {
            return InetAddress.getByName(str);
        }
    }

    /* compiled from: checkin_url */
    public class LocaleDeserializer extends FromStringDeserializer<Locale> {
        public static final LocaleDeserializer f6075a = new LocaleDeserializer();

        protected final /* bridge */ /* synthetic */ Object m11200a(String str, DeserializationContext deserializationContext) {
            return m11199a(str);
        }

        public LocaleDeserializer() {
            super(Locale.class);
        }

        protected static Locale m11199a(String str) {
            int indexOf = str.indexOf(95);
            if (indexOf < 0) {
                return new Locale(str);
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf(95);
            if (indexOf2 < 0) {
                return new Locale(substring, substring2);
            }
            return new Locale(substring, substring2.substring(0, indexOf2), substring2.substring(indexOf2 + 1));
        }
    }

    /* compiled from: checkin_url */
    public class PatternDeserializer extends FromStringDeserializer<Pattern> {
        public static final PatternDeserializer f6076a = new PatternDeserializer();

        public PatternDeserializer() {
            super(Pattern.class);
        }

        protected final Object m11201a(String str, DeserializationContext deserializationContext) {
            return Pattern.compile(str);
        }
    }

    /* compiled from: checkin_url */
    public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
        public static final StackTraceElementDeserializer f6077a = new StackTraceElementDeserializer();

        public /* synthetic */ Object m11202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11203b(jsonParser, deserializationContext);
        }

        public StackTraceElementDeserializer() {
            super(StackTraceElement.class);
        }

        public StackTraceElement m11203b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken g = jsonParser.g();
            if (g == JsonToken.START_OBJECT) {
                String str = "";
                String str2 = "";
                String str3 = "";
                int i = -1;
                while (true) {
                    JsonToken d = jsonParser.d();
                    if (d == JsonToken.END_OBJECT) {
                        return new StackTraceElement(str, str2, str3, i);
                    }
                    String i2 = jsonParser.i();
                    if ("className".equals(i2)) {
                        str = jsonParser.o();
                    } else if ("fileName".equals(i2)) {
                        str3 = jsonParser.o();
                    } else if ("lineNumber".equals(i2)) {
                        if (d.isNumeric()) {
                            i = jsonParser.x();
                        } else {
                            throw JsonMappingException.a(jsonParser, "Non-numeric token (" + d + ") for property 'lineNumber'");
                        }
                    } else if ("methodName".equals(i2)) {
                        str2 = jsonParser.o();
                    } else if (!"nativeMethod".equals(i2)) {
                        a(jsonParser, deserializationContext, this._valueClass, i2);
                    }
                }
            } else {
                throw deserializationContext.a(this._valueClass, g);
            }
        }
    }

    /* compiled from: checkin_url */
    public class URIDeserializer extends FromStringDeserializer<URI> {
        public static final URIDeserializer f6078a = new URIDeserializer();

        public URIDeserializer() {
            super(URI.class);
        }

        protected final Object m11204a(String str, DeserializationContext deserializationContext) {
            return URI.create(str);
        }
    }

    /* compiled from: checkin_url */
    public class URLDeserializer extends FromStringDeserializer<URL> {
        public static final URLDeserializer f6079a = new URLDeserializer();

        public URLDeserializer() {
            super(URL.class);
        }

        protected final Object m11205a(String str, DeserializationContext deserializationContext) {
            return new URL(str);
        }
    }

    /* compiled from: checkin_url */
    public class UUIDDeserializer extends FromStringDeserializer<UUID> {
        public static final UUIDDeserializer f6080a = new UUIDDeserializer();

        public UUIDDeserializer() {
            super(UUID.class);
        }

        protected final Object m11207a(String str, DeserializationContext deserializationContext) {
            return UUID.fromString(str);
        }

        protected final Object m11206a(Object obj, DeserializationContext deserializationContext) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr.length != 16) {
                    deserializationContext.c("Can only construct UUIDs from 16 byte arrays; got " + bArr.length + " bytes");
                }
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                return new UUID(dataInputStream.readLong(), dataInputStream.readLong());
            }
            super.a(obj, deserializationContext);
            return null;
        }
    }

    static {
        int i = 0;
        Class[] clsArr = new Class[]{UUID.class, URL.class, URI.class, File.class, Currency.class, Pattern.class, Locale.class, InetAddress.class, Charset.class, AtomicBoolean.class, Class.class, StackTraceElement.class};
        while (i < 12) {
            f6081a.add(clsArr[i].getName());
            i++;
        }
    }

    public static JsonDeserializer<?> m11208a(Class<?> cls, String str) {
        if (!f6081a.contains(str)) {
            return null;
        }
        if (cls == URI.class) {
            return URIDeserializer.f6078a;
        }
        if (cls == URL.class) {
            return URLDeserializer.f6079a;
        }
        if (cls == File.class) {
            return FileDeserializer.f6073a;
        }
        if (cls == UUID.class) {
            return UUIDDeserializer.f6080a;
        }
        if (cls == Currency.class) {
            return CurrencyDeserializer.f6072a;
        }
        if (cls == Pattern.class) {
            return PatternDeserializer.f6076a;
        }
        if (cls == Locale.class) {
            return LocaleDeserializer.f6075a;
        }
        if (cls == InetAddress.class) {
            return InetAddressDeserializer.f6074a;
        }
        if (cls == Charset.class) {
            return CharsetDeserializer.f6071a;
        }
        if (cls == Class.class) {
            return ClassDeserializer.f6060a;
        }
        if (cls == StackTraceElement.class) {
            return StackTraceElementDeserializer.f6077a;
        }
        if (cls == AtomicBoolean.class) {
            return AtomicBooleanDeserializer.f6070a;
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + str);
    }
}
