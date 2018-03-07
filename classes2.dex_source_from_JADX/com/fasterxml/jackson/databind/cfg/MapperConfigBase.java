package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.Map;

/* compiled from: stop_upload */
public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {
    private static final int f4130a = MapperConfig.m7252a(MapperFeature.class);
    private static final long serialVersionUID = -8378230381628000111L;
    protected final Map<ClassKey, Class<?>> _mixInAnnotations;
    public final String _rootName;
    public final SubtypeResolver _subtypeResolver;
    public final Class<?> _view;

    protected MapperConfigBase(BaseSettings baseSettings, SubtypeResolver subtypeResolver, Map<ClassKey, Class<?>> map) {
        super(baseSettings, f4130a);
        this._mixInAnnotations = map;
        this._subtypeResolver = subtypeResolver;
        this._rootName = null;
        this._view = null;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase) {
        super(mapperConfigBase);
        this._mixInAnnotations = mapperConfigBase._mixInAnnotations;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, BaseSettings baseSettings) {
        super(baseSettings, mapperConfigBase._mapperFeatures);
        this._mixInAnnotations = mapperConfigBase._mixInAnnotations;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, int i) {
        super(mapperConfigBase._base, i);
        this._mixInAnnotations = mapperConfigBase._mixInAnnotations;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
    }

    public final SubtypeResolver m7249s() {
        return this._subtypeResolver;
    }

    public final String m7250t() {
        return this._rootName;
    }

    public final Class<?> m7251u() {
        return this._view;
    }

    public final Class<?> mo1064d(Class<?> cls) {
        return this._mixInAnnotations == null ? null : (Class) this._mixInAnnotations.get(new ClassKey(cls));
    }
}
