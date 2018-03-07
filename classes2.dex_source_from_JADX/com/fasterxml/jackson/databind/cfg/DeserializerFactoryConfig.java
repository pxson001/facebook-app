package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.Serializable;

/* compiled from: state_changed */
public class DeserializerFactoryConfig implements Serializable {
    protected static final Deserializers[] f4156a = new Deserializers[0];
    protected static final BeanDeserializerModifier[] f4157b = new BeanDeserializerModifier[0];
    protected static final AbstractTypeResolver[] f4158c = new AbstractTypeResolver[0];
    protected static final ValueInstantiators[] f4159d = new ValueInstantiators[0];
    protected static final KeyDeserializers[] f4160e = new KeyDeserializers[]{new StdKeyDeserializers()};
    private static final long serialVersionUID = 3683541151102256824L;
    protected final AbstractTypeResolver[] _abstractTypeResolvers;
    protected final Deserializers[] _additionalDeserializers;
    protected final KeyDeserializers[] _additionalKeyDeserializers;
    protected final BeanDeserializerModifier[] _modifiers;
    protected final ValueInstantiators[] _valueInstantiators;

    public DeserializerFactoryConfig() {
        this(null, null, null, null, null);
    }

    private DeserializerFactoryConfig(Deserializers[] deserializersArr, KeyDeserializers[] keyDeserializersArr, BeanDeserializerModifier[] beanDeserializerModifierArr, AbstractTypeResolver[] abstractTypeResolverArr, ValueInstantiators[] valueInstantiatorsArr) {
        if (deserializersArr == null) {
            deserializersArr = f4156a;
        }
        this._additionalDeserializers = deserializersArr;
        if (keyDeserializersArr == null) {
            keyDeserializersArr = f4160e;
        }
        this._additionalKeyDeserializers = keyDeserializersArr;
        if (beanDeserializerModifierArr == null) {
            beanDeserializerModifierArr = f4157b;
        }
        this._modifiers = beanDeserializerModifierArr;
        if (abstractTypeResolverArr == null) {
            abstractTypeResolverArr = f4158c;
        }
        this._abstractTypeResolvers = abstractTypeResolverArr;
        if (valueInstantiatorsArr == null) {
            valueInstantiatorsArr = f4159d;
        }
        this._valueInstantiators = valueInstantiatorsArr;
    }

    public final DeserializerFactoryConfig m7495a(Deserializers deserializers) {
        if (deserializers != null) {
            return new DeserializerFactoryConfig((Deserializers[]) ArrayBuilders.m7772a(this._additionalDeserializers, (Object) deserializers), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
        }
        throw new IllegalArgumentException("Can not pass null Deserializers");
    }

    public final boolean m7496a() {
        return this._additionalKeyDeserializers.length > 0;
    }

    public final boolean m7497b() {
        return this._modifiers.length > 0;
    }

    public final boolean m7498c() {
        return this._abstractTypeResolvers.length > 0;
    }

    public final boolean m7499d() {
        return this._valueInstantiators.length > 0;
    }

    public final Iterable<Deserializers> m7500e() {
        return ArrayBuilders.m7773b(this._additionalDeserializers);
    }

    public final Iterable<KeyDeserializers> m7501f() {
        return ArrayBuilders.m7773b(this._additionalKeyDeserializers);
    }

    public final Iterable<BeanDeserializerModifier> m7502g() {
        return ArrayBuilders.m7773b(this._modifiers);
    }

    public final Iterable<AbstractTypeResolver> m7503h() {
        return ArrayBuilders.m7773b(this._abstractTypeResolvers);
    }

    public final Iterable<ValueInstantiators> m7504i() {
        return ArrayBuilders.m7773b(this._valueInstantiators);
    }
}
