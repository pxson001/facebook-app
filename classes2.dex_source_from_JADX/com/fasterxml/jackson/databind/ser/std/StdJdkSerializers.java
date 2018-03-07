package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: stack_stories_behind_nsp */
public class StdJdkSerializers {

    /* compiled from: stack_stories_behind_nsp */
    public final class AtomicReferenceSerializer extends StdSerializer<AtomicReference<?>> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            serializerProvider.m7314a(((AtomicReference) obj).get(), jsonGenerator);
        }

        public AtomicReferenceSerializer() {
            super(AtomicReference.class, (byte) 0);
        }
    }

    /* compiled from: stack_stories_behind_nsp */
    public final class AtomicBooleanSerializer extends StdScalarSerializer<AtomicBoolean> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1119a(((AtomicBoolean) obj).get());
        }

        public AtomicBooleanSerializer() {
            super(AtomicBoolean.class, (byte) 0);
        }
    }

    /* compiled from: stack_stories_behind_nsp */
    public final class AtomicIntegerSerializer extends StdScalarSerializer<AtomicInteger> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1121b(((AtomicInteger) obj).get());
        }

        public AtomicIntegerSerializer() {
            super(AtomicInteger.class, (byte) 0);
        }
    }

    /* compiled from: stack_stories_behind_nsp */
    public final class AtomicLongSerializer extends StdScalarSerializer<AtomicLong> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1111a(((AtomicLong) obj).get());
        }

        public AtomicLongSerializer() {
            super(AtomicLong.class, (byte) 0);
        }
    }

    /* compiled from: stack_stories_behind_nsp */
    public final class FileSerializer extends StdScalarSerializer<File> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1123b(((File) obj).getAbsolutePath());
        }

        public FileSerializer() {
            super(File.class);
        }
    }

    /* compiled from: stack_stories_behind_nsp */
    public final class ClassSerializer extends StdScalarSerializer<Class<?>> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1123b(((Class) obj).getName());
        }

        public ClassSerializer() {
            super(Class.class, (byte) 0);
        }
    }

    public static Collection<Entry<Class<?>, Object>> m7622a() {
        HashMap hashMap = new HashMap();
        ToStringSerializer toStringSerializer = ToStringSerializer.f4164a;
        hashMap.put(URL.class, toStringSerializer);
        hashMap.put(URI.class, toStringSerializer);
        hashMap.put(Currency.class, toStringSerializer);
        hashMap.put(UUID.class, toStringSerializer);
        hashMap.put(Pattern.class, toStringSerializer);
        hashMap.put(Locale.class, toStringSerializer);
        hashMap.put(Locale.class, toStringSerializer);
        hashMap.put(AtomicReference.class, AtomicReferenceSerializer.class);
        hashMap.put(AtomicBoolean.class, AtomicBooleanSerializer.class);
        hashMap.put(AtomicInteger.class, AtomicIntegerSerializer.class);
        hashMap.put(AtomicLong.class, AtomicLongSerializer.class);
        hashMap.put(File.class, FileSerializer.class);
        hashMap.put(Class.class, ClassSerializer.class);
        hashMap.put(Void.TYPE, NullSerializer.class);
        return hashMap.entrySet();
    }
}
