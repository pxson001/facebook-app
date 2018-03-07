package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.Serializable;

/* compiled from: sso */
public final class SerializerFactoryConfig implements Serializable {
    protected static final Serializers[] f4185a = new Serializers[0];
    protected static final BeanSerializerModifier[] f4186b = new BeanSerializerModifier[0];
    private static final long serialVersionUID = 1;
    protected final Serializers[] _additionalKeySerializers;
    protected final Serializers[] _additionalSerializers;
    protected final BeanSerializerModifier[] _modifiers;

    public SerializerFactoryConfig() {
        this(null, null, null);
    }

    private SerializerFactoryConfig(Serializers[] serializersArr, Serializers[] serializersArr2, BeanSerializerModifier[] beanSerializerModifierArr) {
        if (serializersArr == null) {
            serializersArr = f4185a;
        }
        this._additionalSerializers = serializersArr;
        if (serializersArr2 == null) {
            serializersArr2 = f4185a;
        }
        this._additionalKeySerializers = serializersArr2;
        if (beanSerializerModifierArr == null) {
            beanSerializerModifierArr = f4186b;
        }
        this._modifiers = beanSerializerModifierArr;
    }

    public final SerializerFactoryConfig m7720a(Serializers serializers) {
        if (serializers != null) {
            return new SerializerFactoryConfig((Serializers[]) ArrayBuilders.m7772a(this._additionalSerializers, (Object) serializers), this._additionalKeySerializers, this._modifiers);
        }
        throw new IllegalArgumentException("Can not pass null Serializers");
    }

    public final SerializerFactoryConfig m7719a(BeanSerializerModifier beanSerializerModifier) {
        if (beanSerializerModifier == null) {
            throw new IllegalArgumentException("Can not pass null modifier");
        }
        return new SerializerFactoryConfig(this._additionalSerializers, this._additionalKeySerializers, (BeanSerializerModifier[]) ArrayBuilders.m7772a(this._modifiers, (Object) beanSerializerModifier));
    }

    public final boolean m7721a() {
        return this._additionalKeySerializers.length > 0;
    }

    public final boolean m7722b() {
        return this._modifiers.length > 0;
    }

    public final Iterable<Serializers> m7723c() {
        return ArrayBuilders.m7773b(this._additionalSerializers);
    }

    public final Iterable<Serializers> m7724d() {
        return ArrayBuilders.m7773b(this._additionalKeySerializers);
    }

    public final Iterable<BeanSerializerModifier> m7725e() {
        return ArrayBuilders.m7773b(this._modifiers);
    }
}
