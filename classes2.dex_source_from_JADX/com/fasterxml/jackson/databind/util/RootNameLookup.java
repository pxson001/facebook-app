package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

/* compiled from: store/apps/details */
public class RootNameLookup implements Serializable {
    private static final long serialVersionUID = 1;
    protected LRUMap<ClassKey, SerializedString> _rootNames;

    public final synchronized SerializedString m7234a(Class<?> cls, MapperConfig<?> mapperConfig) {
        SerializedString serializedString;
        String simpleName;
        ClassKey classKey = new ClassKey(cls);
        if (this._rootNames == null) {
            this._rootNames = new LRUMap(20, 200);
        } else {
            serializedString = (SerializedString) this._rootNames.get(classKey);
            if (serializedString != null) {
            }
        }
        PropertyName a = mapperConfig.mo1061a().mo970a(mapperConfig.m7260c(cls).mo949c());
        if (a == null || !a.b()) {
            simpleName = cls.getSimpleName();
        } else {
            simpleName = a.a();
        }
        serializedString = new SerializedString(simpleName);
        this._rootNames.put(classKey, serializedString);
        return serializedString;
    }

    public final SerializedString m7233a(JavaType javaType, MapperConfig<?> mapperConfig) {
        return m7234a(javaType._class, (MapperConfig) mapperConfig);
    }
}
