package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: store_locator/?north=%s&west=%s&south=%s&east=%s&ad_id=%s&page_set_id=%s&parent_page_id=%s */
public class StdSubtypeResolver extends SubtypeResolver implements Serializable {
    private static final long serialVersionUID = 1;
    protected LinkedHashSet<NamedType> _registeredSubtypes;

    public final Collection<NamedType> mo1060a(AnnotatedMember annotatedMember, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, JavaType javaType) {
        Class d;
        Iterator it;
        NamedType namedType;
        if (javaType == null) {
            d = annotatedMember.mo940d();
        } else {
            d = javaType._class;
        }
        HashMap hashMap = new HashMap();
        if (this._registeredSubtypes != null) {
            it = this._registeredSubtypes.iterator();
            while (it.hasNext()) {
                namedType = (NamedType) it.next();
                if (d.isAssignableFrom(namedType._class)) {
                    m7228a(AnnotatedClass.m6768b(namedType._class, annotationIntrospector, mapperConfig), namedType, mapperConfig, annotationIntrospector, hashMap);
                }
            }
        }
        Collection<NamedType> c = annotationIntrospector.mo988c((Annotated) annotatedMember);
        if (c != null) {
            for (NamedType namedType2 : c) {
                m7228a(AnnotatedClass.m6768b(namedType2._class, annotationIntrospector, mapperConfig), namedType2, mapperConfig, annotationIntrospector, hashMap);
            }
        }
        m7228a(AnnotatedClass.m6768b(d, annotationIntrospector, mapperConfig), new NamedType(d, null), mapperConfig, annotationIntrospector, hashMap);
        return new ArrayList(hashMap.values());
    }

    public final Collection<NamedType> mo1059a(AnnotatedClass annotatedClass, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector) {
        HashMap hashMap = new HashMap();
        if (this._registeredSubtypes != null) {
            Class d = annotatedClass.mo940d();
            Iterator it = this._registeredSubtypes.iterator();
            while (it.hasNext()) {
                NamedType namedType = (NamedType) it.next();
                if (d.isAssignableFrom(namedType._class)) {
                    m7228a(AnnotatedClass.m6768b(namedType._class, annotationIntrospector, mapperConfig), namedType, mapperConfig, annotationIntrospector, hashMap);
                }
            }
        }
        m7228a(annotatedClass, new NamedType(annotatedClass.mo940d(), null), mapperConfig, annotationIntrospector, hashMap);
        return new ArrayList(hashMap.values());
    }

    private void m7228a(AnnotatedClass annotatedClass, NamedType namedType, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, HashMap<NamedType, NamedType> hashMap) {
        if (!namedType.c()) {
            String f = annotationIntrospector.mo1000f(annotatedClass);
            if (f != null) {
                namedType = new NamedType(namedType._class, f);
            }
        }
        if (!hashMap.containsKey(namedType)) {
            hashMap.put(namedType, namedType);
            Collection<NamedType> c = annotationIntrospector.mo988c((Annotated) annotatedClass);
            if (c != null && !c.isEmpty()) {
                for (NamedType namedType2 : c) {
                    AnnotatedClass b = AnnotatedClass.m6768b(namedType2._class, annotationIntrospector, mapperConfig);
                    m7228a(b, !namedType2.c() ? new NamedType(namedType2._class, annotationIntrospector.mo1000f(b)) : namedType2, mapperConfig, annotationIntrospector, hashMap);
                }
            }
        } else if (namedType.c() && !((NamedType) hashMap.get(namedType)).c()) {
            hashMap.put(namedType, namedType);
        }
    }
}
