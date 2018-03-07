package com.facebook.resources.impl.model;

import com.facebook.user.gender.Gender;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: th_flt */
public class StringResources {
    private final FbstrLanguagePack f3069a;
    private Map<Integer, String> f3070b = Maps.m843e();
    private Map<Integer, Plural> f3071c = Maps.m843e();
    private Map<Integer, String[]> f3072d = Maps.m843e();
    private Gender f3073e = Gender.UNKNOWN;

    /* compiled from: th_flt */
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String str, int i) {
            super("No resource found for resource '" + i + "' of type '" + str + "'");
        }
    }

    public StringResources(FbstrLanguagePack fbstrLanguagePack) {
        this.f3069a = fbstrLanguagePack;
    }

    public final String m5062a(int i, Gender gender) {
        m5061a(gender);
        if (this.f3070b.containsKey(Integer.valueOf(i))) {
            return (String) this.f3070b.get(Integer.valueOf(i));
        }
        String a = this.f3069a.f3074a.mo696a(i, gender);
        if (a == null) {
            throw new ResourceNotFoundException("string", i);
        }
        this.f3070b.put(Integer.valueOf(i), a);
        return a;
    }

    public final String m5063a(int i, Gender gender, PluralCategory pluralCategory) {
        Plural plural;
        m5061a(gender);
        if (this.f3071c.containsKey(Integer.valueOf(i))) {
            plural = (Plural) this.f3071c.get(Integer.valueOf(i));
        } else {
            plural = this.f3069a.f3075b.mo697a(i, gender);
            if (plural != null) {
                this.f3071c.put(Integer.valueOf(i), plural);
            }
        }
        if (plural != null && plural.a(pluralCategory)) {
            return plural.b(pluralCategory);
        }
        if (plural != null && plural.a(PluralCategory.OTHER)) {
            return plural.b(PluralCategory.OTHER);
        }
        throw new ResourceNotFoundException("plural", i);
    }

    public final String[] m5064b(int i, Gender gender) {
        m5061a(gender);
        if (this.f3072d.containsKey(Integer.valueOf(i))) {
            return (String[]) this.f3072d.get(Integer.valueOf(i));
        }
        String[] a = this.f3069a.f3076c.mo698a(i, gender);
        if (a == null) {
            throw new ResourceNotFoundException("string array", i);
        }
        this.f3072d.put(Integer.valueOf(i), a);
        return a;
    }

    private void m5061a(Gender gender) {
        if (this.f3073e != gender) {
            this.f3070b.clear();
            this.f3071c.clear();
            this.f3072d.clear();
            this.f3073e = gender;
        }
    }
}
