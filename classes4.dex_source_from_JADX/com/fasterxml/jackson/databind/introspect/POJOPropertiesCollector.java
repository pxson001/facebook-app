package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: video_log_min_bitrate_kbps */
public class POJOPropertiesCollector {
    public final MapperConfig<?> f260a;
    protected final boolean f261b;
    public final JavaType f262c;
    public final AnnotatedClass f263d;
    protected final VisibilityChecker<?> f264e;
    protected final AnnotationIntrospector f265f;
    protected final String f266g;
    protected final LinkedHashMap<String, POJOPropertyBuilder> f267h = new LinkedHashMap();
    protected LinkedList<POJOPropertyBuilder> f268i = null;
    protected LinkedList<AnnotatedMember> f269j = null;
    protected LinkedList<AnnotatedMethod> f270k = null;
    protected LinkedList<AnnotatedMethod> f271l = null;
    public HashSet<String> f272m;
    public LinkedHashMap<Object, AnnotatedMember> f273n;

    protected POJOPropertiesCollector(MapperConfig<?> mapperConfig, boolean z, JavaType javaType, AnnotatedClass annotatedClass, String str) {
        AnnotationIntrospector annotationIntrospector = null;
        this.f260a = mapperConfig;
        this.f261b = z;
        this.f262c = javaType;
        this.f263d = annotatedClass;
        if (str == null) {
            str = "set";
        }
        this.f266g = str;
        if (mapperConfig.g()) {
            annotationIntrospector = this.f260a.a();
        }
        this.f265f = annotationIntrospector;
        if (this.f265f == null) {
            this.f264e = this.f260a.c();
        } else {
            this.f264e = this.f265f.a(annotatedClass, this.f260a.c());
        }
    }

    public final MapperConfig<?> m342a() {
        return this.f260a;
    }

    public final JavaType m343b() {
        return this.f262c;
    }

    public final AnnotatedClass m344c() {
        return this.f263d;
    }

    public final List<BeanPropertyDefinition> m345d() {
        return new ArrayList(this.f267h.values());
    }

    public final Map<Object, AnnotatedMember> m346e() {
        return this.f273n;
    }

    public final AnnotatedMethod m347f() {
        if (this.f271l == null) {
            return null;
        }
        if (this.f271l.size() > 1) {
            m331b("Multiple value properties defined (" + this.f271l.get(0) + " vs " + this.f271l.get(1) + ")");
        }
        return (AnnotatedMethod) this.f271l.get(0);
    }

    public final AnnotatedMember m348g() {
        if (this.f269j == null) {
            return null;
        }
        if (this.f269j.size() > 1) {
            m331b("Multiple 'any-getters' defined (" + this.f269j.get(0) + " vs " + this.f269j.get(1) + ")");
        }
        return (AnnotatedMember) this.f269j.getFirst();
    }

    public final AnnotatedMethod m349h() {
        if (this.f270k == null) {
            return null;
        }
        if (this.f270k.size() > 1) {
            m331b("Multiple 'any-setters' defined (" + this.f270k.get(0) + " vs " + this.f270k.get(1) + ")");
        }
        return (AnnotatedMethod) this.f270k.getFirst();
    }

    public final Set<String> m350i() {
        return this.f272m;
    }

    public final ObjectIdInfo m351j() {
        if (this.f265f == null) {
            return null;
        }
        ObjectIdInfo a = this.f265f.a(this.f263d);
        if (a != null) {
            return this.f265f.a(this.f263d, a);
        }
        return a;
    }

    public final POJOPropertiesCollector m352k() {
        this.f267h.clear();
        m334m();
        m336o();
        m335n();
        m337p();
        m338q();
        m339r();
        PropertyNamingStrategy t = m341t();
        if (t != null) {
            m326a(t);
        }
        for (POJOPropertyBuilder v : this.f267h.values()) {
            v.m420v();
        }
        for (POJOPropertyBuilder v2 : this.f267h.values()) {
            v2.m401b(this.f261b);
        }
        if (this.f260a.a(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            m340s();
        }
        m333l();
        return this;
    }

    private void m333l() {
        boolean i;
        AnnotationIntrospector annotationIntrospector = this.f265f;
        Boolean h = annotationIntrospector == null ? null : annotationIntrospector.h(this.f263d);
        if (h == null) {
            i = this.f260a.i();
        } else {
            i = h.booleanValue();
        }
        String[] g = annotationIntrospector == null ? null : annotationIntrospector.g(this.f263d);
        if (i || this.f268i != null || g != null) {
            Map treeMap;
            Iterator it;
            POJOPropertyBuilder pOJOPropertyBuilder;
            int size = this.f267h.size();
            if (i) {
                treeMap = new TreeMap();
            } else {
                Object linkedHashMap = new LinkedHashMap(size + size);
            }
            for (POJOPropertyBuilder pOJOPropertyBuilder2 : this.f267h.values()) {
                treeMap.put(pOJOPropertyBuilder2.mo22a(), pOJOPropertyBuilder2);
            }
            Map linkedHashMap2 = new LinkedHashMap(size + size);
            if (g != null) {
                for (String str : g) {
                    Object a;
                    Object obj = (POJOPropertyBuilder) treeMap.get(str);
                    if (obj == null) {
                        for (POJOPropertyBuilder pOJOPropertyBuilder3 : this.f267h.values()) {
                            if (str.equals(pOJOPropertyBuilder3.f288d)) {
                                POJOPropertyBuilder pOJOPropertyBuilder4 = pOJOPropertyBuilder3;
                                a = pOJOPropertyBuilder3.mo22a();
                                obj = pOJOPropertyBuilder4;
                                break;
                            }
                        }
                    }
                    String str2 = str;
                    if (obj != null) {
                        linkedHashMap2.put(a, obj);
                    }
                }
            }
            if (this.f268i != null) {
                it = this.f268i.iterator();
                while (it.hasNext()) {
                    pOJOPropertyBuilder2 = (POJOPropertyBuilder) it.next();
                    linkedHashMap2.put(pOJOPropertyBuilder2.mo22a(), pOJOPropertyBuilder2);
                }
            }
            linkedHashMap2.putAll(treeMap);
            this.f267h.clear();
            this.f267h.putAll(linkedHashMap2);
        }
    }

    private void m334m() {
        AnnotationIntrospector annotationIntrospector = this.f265f;
        Object obj = (this.f261b || this.f260a.a(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? null : 1;
        for (AnnotatedField annotatedField : this.f263d.m()) {
            String str;
            String str2;
            boolean z;
            String b = annotatedField.b();
            if (annotationIntrospector == null) {
                str = null;
            } else if (this.f261b) {
                r4 = annotationIntrospector.n(annotatedField);
                str = r4 == null ? null : r4._simpleName;
            } else {
                r4 = annotationIntrospector.v(annotatedField);
                str = r4 == null ? null : r4._simpleName;
            }
            if ("".equals(str)) {
                str2 = b;
            } else {
                str2 = str;
            }
            boolean z2 = str2 != null;
            if (z2) {
                z = z2;
            } else {
                z = this.f264e.a(annotatedField);
            }
            if (annotationIntrospector == null || !annotationIntrospector.c(annotatedField)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (obj == null || str2 != null || z2 || !Modifier.isFinal(annotatedField.m362g())) {
                m332c(b).m394a(annotatedField, str2, z, z2);
            }
        }
    }

    private void m335n() {
        AnnotationIntrospector annotationIntrospector = this.f265f;
        if (annotationIntrospector != null) {
            int g;
            int i;
            AnnotatedParameter c;
            PropertyName v;
            String str;
            POJOPropertyBuilder c2;
            for (AnnotatedConstructor annotatedConstructor : this.f263d.j()) {
                if (this.f268i == null) {
                    this.f268i = new LinkedList();
                }
                g = annotatedConstructor.m510g();
                for (i = 0; i < g; i++) {
                    c = annotatedConstructor.m486c(i);
                    v = annotationIntrospector.v(c);
                    if (v == null) {
                        str = null;
                    } else {
                        str = v._simpleName;
                    }
                    if (str != null) {
                        c2 = m332c(str);
                        c2.m396a(c, str, true, false);
                        this.f268i.add(c2);
                    }
                }
            }
            for (AnnotatedMethod annotatedMethod : this.f263d.k()) {
                if (this.f268i == null) {
                    this.f268i = new LinkedList();
                }
                g = annotatedMethod.m474l();
                for (i = 0; i < g; i++) {
                    c = annotatedMethod.m486c(i);
                    v = annotationIntrospector.v(c);
                    if (v == null) {
                        str = null;
                    } else {
                        str = v._simpleName;
                    }
                    if (str != null) {
                        c2 = m332c(str);
                        c2.m396a(c, str, true, false);
                        this.f268i.add(c2);
                    }
                }
            }
        }
    }

    private void m336o() {
        AnnotationIntrospector annotationIntrospector = this.f265f;
        for (AnnotatedMethod annotatedMethod : this.f263d.l()) {
            int l = annotatedMethod.m474l();
            if (l == 0) {
                m327a(annotatedMethod, annotationIntrospector);
            } else if (l == 1) {
                m330b(annotatedMethod, annotationIntrospector);
            } else if (l == 2 && annotationIntrospector != null && annotationIntrospector.d(annotatedMethod)) {
                if (this.f270k == null) {
                    this.f270k = new LinkedList();
                }
                this.f270k.add(annotatedMethod);
            }
        }
    }

    private void m327a(AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        String a;
        String str;
        boolean b;
        String str2 = null;
        if (annotationIntrospector != null) {
            if (annotationIntrospector.e(annotatedMethod)) {
                if (this.f269j == null) {
                    this.f269j = new LinkedList();
                }
                this.f269j.add(annotatedMethod);
                return;
            } else if (annotationIntrospector.b(annotatedMethod)) {
                if (this.f271l == null) {
                    this.f271l = new LinkedList();
                }
                this.f271l.add(annotatedMethod);
                return;
            }
        }
        PropertyName n = annotationIntrospector == null ? null : annotationIntrospector.n(annotatedMethod);
        if (n != null) {
            str2 = n._simpleName;
        }
        if (str2 == null) {
            a = BeanUtil.m489a(annotatedMethod, annotatedMethod.b());
            if (a == null) {
                a = BeanUtil.m491b(annotatedMethod, annotatedMethod.b());
                if (a != null) {
                    str = str2;
                    b = this.f264e.b(annotatedMethod);
                } else {
                    return;
                }
            }
            str = str2;
            b = this.f264e.a(annotatedMethod);
        } else {
            String a2 = BeanUtil.m488a(annotatedMethod);
            if (a2 == null) {
                a2 = annotatedMethod.b();
            }
            if (str2.length() == 0) {
                str2 = a2;
            }
            str = str2;
            b = true;
            a = a2;
        }
        m332c(a).m395a(annotatedMethod, str, b, annotationIntrospector == null ? false : annotationIntrospector.c(annotatedMethod));
    }

    private void m330b(AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        String c;
        String str;
        boolean c2;
        String str2 = null;
        PropertyName v = annotationIntrospector == null ? null : annotationIntrospector.v(annotatedMethod);
        if (v != null) {
            str2 = v._simpleName;
        }
        if (str2 == null) {
            c = BeanUtil.m493c(annotatedMethod, this.f266g);
            if (c != null) {
                str = str2;
                c2 = this.f264e.c(annotatedMethod);
            } else {
                return;
            }
        }
        String c3 = BeanUtil.m493c(annotatedMethod, this.f266g);
        if (c3 == null) {
            c3 = annotatedMethod.b();
        }
        if (str2.length() == 0) {
            str2 = c3;
        }
        str = str2;
        c2 = true;
        c = c3;
        m332c(c).m400b(annotatedMethod, str, c2, annotationIntrospector == null ? false : annotationIntrospector.c(annotatedMethod));
    }

    private void m337p() {
        AnnotationIntrospector annotationIntrospector = this.f265f;
        if (annotationIntrospector != null) {
            for (AnnotatedMember annotatedMember : this.f263d.m()) {
                m328a(annotationIntrospector.d(annotatedMember), annotatedMember);
            }
            for (AnnotatedMember annotatedMember2 : this.f263d.l()) {
                if (annotatedMember2.m474l() == 1) {
                    m328a(annotationIntrospector.d(annotatedMember2), annotatedMember2);
                }
            }
        }
    }

    private void m328a(Object obj, AnnotatedMember annotatedMember) {
        if (obj != null) {
            if (this.f273n == null) {
                this.f273n = new LinkedHashMap();
            }
            if (((AnnotatedMember) this.f273n.put(obj, annotatedMember)) != null) {
                throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(obj) + "' (of type " + (obj == null ? "[null]" : obj.getClass().getName()) + ")");
            }
        }
    }

    private void m338q() {
        boolean z;
        Iterator it = this.f267h.entrySet().iterator();
        if (this.f260a.a(MapperFeature.INFER_PROPERTY_MUTATORS)) {
            z = false;
        } else {
            z = true;
        }
        while (it.hasNext()) {
            POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) ((Entry) it.next()).getValue();
            if (pOJOPropertyBuilder.m421w()) {
                if (pOJOPropertyBuilder.m422x()) {
                    if (pOJOPropertyBuilder.mo24c()) {
                        pOJOPropertyBuilder.m419u();
                        if (!(this.f261b || pOJOPropertyBuilder.m428d())) {
                            m329a(pOJOPropertyBuilder.mo22a());
                        }
                    } else {
                        it.remove();
                        m329a(pOJOPropertyBuilder.mo22a());
                    }
                }
                pOJOPropertyBuilder.m398a(z);
            } else {
                it.remove();
            }
        }
    }

    private void m329a(String str) {
        if (!this.f261b) {
            if (this.f272m == null) {
                this.f272m = new HashSet();
            }
            this.f272m.add(str);
        }
    }

    private void m339r() {
        Iterator it = this.f267h.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) ((Entry) it.next()).getValue();
            String y = pOJOPropertyBuilder.m423y();
            if (y != null) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(pOJOPropertyBuilder.m392a(y));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                pOJOPropertyBuilder = (POJOPropertyBuilder) it2.next();
                String a = pOJOPropertyBuilder.mo22a();
                POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) this.f267h.get(a);
                if (pOJOPropertyBuilder2 == null) {
                    this.f267h.put(a, pOJOPropertyBuilder);
                } else {
                    pOJOPropertyBuilder2.m397a(pOJOPropertyBuilder);
                }
                if (this.f268i != null) {
                    for (int i = 0; i < this.f268i.size(); i++) {
                        if (((POJOPropertyBuilder) this.f268i.get(i)).f288d == pOJOPropertyBuilder.f288d) {
                            this.f268i.set(i, pOJOPropertyBuilder);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void m326a(PropertyNamingStrategy propertyNamingStrategy) {
        POJOPropertyBuilder[] pOJOPropertyBuilderArr = (POJOPropertyBuilder[]) this.f267h.values().toArray(new POJOPropertyBuilder[this.f267h.size()]);
        this.f267h.clear();
        for (POJOPropertyBuilder pOJOPropertyBuilder : pOJOPropertyBuilderArr) {
            POJOPropertyBuilder pOJOPropertyBuilder2;
            String b;
            String a = pOJOPropertyBuilder2.mo22a();
            if (this.f261b) {
                if (pOJOPropertyBuilder2.mo25e()) {
                    pOJOPropertyBuilder2.mo29i();
                    b = propertyNamingStrategy.b(a);
                } else {
                    if (pOJOPropertyBuilder2.mo27g()) {
                        pOJOPropertyBuilder2.mo31k();
                        b = propertyNamingStrategy.a(a);
                    }
                    b = a;
                }
            } else if (pOJOPropertyBuilder2.mo26f()) {
                pOJOPropertyBuilder2.mo30j();
                b = propertyNamingStrategy.c(a);
            } else if (pOJOPropertyBuilder2.mo28h()) {
                b = propertyNamingStrategy.d(a);
            } else if (pOJOPropertyBuilder2.mo27g()) {
                pOJOPropertyBuilder2.mo31k();
                b = propertyNamingStrategy.a(a);
            } else {
                if (pOJOPropertyBuilder2.mo25e()) {
                    pOJOPropertyBuilder2.mo29i();
                    b = propertyNamingStrategy.b(a);
                }
                b = a;
            }
            if (!b.equals(pOJOPropertyBuilder2.mo22a())) {
                pOJOPropertyBuilder2 = pOJOPropertyBuilder2.m392a(b);
            }
            POJOPropertyBuilder pOJOPropertyBuilder3 = (POJOPropertyBuilder) this.f267h.get(b);
            if (pOJOPropertyBuilder3 == null) {
                this.f267h.put(b, pOJOPropertyBuilder2);
            } else {
                pOJOPropertyBuilder3.m397a(pOJOPropertyBuilder2);
            }
        }
    }

    private void m340s() {
        String str;
        Iterator it = this.f267h.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) ((Entry) it.next()).getValue();
            if (pOJOPropertyBuilder.mo35o() != null) {
                PropertyName propertyName = null;
                if (propertyName != null && propertyName.m497b()) {
                    str = propertyName._simpleName;
                    if (!str.equals(pOJOPropertyBuilder.mo22a())) {
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(pOJOPropertyBuilder.m392a(str));
                        it.remove();
                    }
                }
            }
        }
        if (linkedList != null) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                pOJOPropertyBuilder = (POJOPropertyBuilder) it.next();
                str = pOJOPropertyBuilder.mo22a();
                POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) this.f267h.get(str);
                if (pOJOPropertyBuilder2 == null) {
                    this.f267h.put(str, pOJOPropertyBuilder);
                } else {
                    pOJOPropertyBuilder2.m397a(pOJOPropertyBuilder);
                }
            }
        }
    }

    private void m331b(String str) {
        throw new IllegalArgumentException("Problem with definition of " + this.f263d + ": " + str);
    }

    private POJOPropertyBuilder m332c(String str) {
        POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) this.f267h.get(str);
        if (pOJOPropertyBuilder != null) {
            return pOJOPropertyBuilder;
        }
        pOJOPropertyBuilder = new POJOPropertyBuilder(str, this.f265f, this.f261b);
        this.f267h.put(str, pOJOPropertyBuilder);
        return pOJOPropertyBuilder;
    }

    private PropertyNamingStrategy m341t() {
        Object obj;
        if (this.f265f == null) {
            obj = null;
        } else {
            obj = this.f265f.e(this.f263d);
        }
        if (obj == null) {
            return this.f260a.k();
        }
        if (obj instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (PropertyNamingStrategy.class.isAssignableFrom(cls)) {
                if (this.f260a.l() != null) {
                    PropertyNamingStrategy propertyNamingStrategy = null;
                    if (propertyNamingStrategy != null) {
                        return propertyNamingStrategy;
                    }
                }
                return (PropertyNamingStrategy) ClassUtil.m314b(cls, this.f260a.h());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + obj.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
    }
}
