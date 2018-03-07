package com.facebook.user.names;

import com.facebook.inject.Lazy;
import com.facebook.user.model.Name;
import com.facebook.user.names.NameSplitter.NameTokenizer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: readAttributes */
public class ContactNameLookupBuilder {
    private static final Class<?> f3752a = ContactNameLookupBuilder.class;
    private static final int[] f3753b = new int[]{4352, 4353, 0, 4354, 0, 0, 4355, 4356, 4357, 0, 0, 0, 0, 0, 0, 0, 4358, 4359, 4360, 0, 4361, 4362, 4363, 4364, 4365, 4366, 4367, 4368, 4369, 4370};
    private final NameNormalizer f3754c;
    private final ContactLocaleUtils f3755d;
    private final Lazy<NameSplitter> f3756e;
    public final Set<String> f3757f;
    private final StringBuilder f3758g = new StringBuilder();
    private String[] f3759h = null;
    public boolean f3760i = true;

    @Inject
    public ContactNameLookupBuilder(Normalizer normalizer, ContactLocaleUtils contactLocaleUtils, Lazy<NameSplitter> lazy) {
        this.f3754c = normalizer;
        this.f3755d = contactLocaleUtils;
        this.f3756e = lazy;
        this.f3757f = Sets.a();
    }

    public final void m4204a(ImmutableList<String> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f3757f.add(m4200b((String) immutableList.get(i)));
        }
    }

    public final void m4203a(@Nullable Name name) {
        if (name != null && name.g() != null) {
            m4198a(name.g(), (String[]) m4199b(name).toArray(new String[0]), ((NameSplitter) this.f3756e.get()).m14103a(0));
        }
    }

    private void m4198a(String str, String[] strArr, int i) {
        int i2;
        boolean z;
        int i3 = 4;
        int length = strArr.length;
        this.f3759h = strArr;
        for (i2 = 0; i2 < this.f3759h.length; i2++) {
            this.f3759h[i2] = m4200b(this.f3759h[i2]);
        }
        int i4 = length > 4 ? 1 : 0;
        if (i4 != 0) {
            m4194a(length);
            Arrays.sort(this.f3759h, 0, length, new 1(this));
            String str2 = this.f3759h[0];
            for (i2 = 4; i2 < length; i2++) {
                this.f3759h[0] = this.f3759h[i2];
                m4201b(4);
            }
            this.f3759h[0] = str2;
        } else {
            i3 = length;
        }
        if (i4 == 0) {
            z = true;
        } else {
            z = false;
        }
        m4195a(0, i3, z);
        m4202b(str, i);
        m4197a(str, i);
    }

    private ImmutableSet<String> m4199b(Name name) {
        Builder builder = ImmutableSet.builder();
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(builder);
        String[] strArr = new String[10];
        NameSplitter nameSplitter = (NameSplitter) this.f3756e.get();
        String i = name.i();
        int i2 = 0;
        if (i != null) {
            NameTokenizer nameTokenizer = new NameTokenizer(i);
            if (nameTokenizer.f3764d != nameTokenizer.f3765e) {
                if (nameSplitter.f13237d.contains(nameTokenizer.f3761a[nameTokenizer.f3764d].toUpperCase(nameSplitter.f13242i))) {
                    nameTokenizer.f3764d++;
                }
                int i3 = nameTokenizer.f3764d;
                while (i3 < nameTokenizer.f3765e) {
                    int i4 = i2 + 1;
                    strArr[i2] = nameTokenizer.f3761a[i3];
                    i3++;
                    i2 = i4;
                }
            }
        }
        int i5 = i2;
        for (int i6 = 0; i6 < i5; i6++) {
            builder.c(strArr[i6]);
        }
        if (name.d()) {
            builder.c(name.c());
        }
        if (name.b()) {
            builder.c(name.a());
        }
        return builder.b();
    }

    private void m4197a(String str, int i) {
        if (i == 5) {
            m4196a(str);
        }
    }

    private void m4196a(String str) {
        int i = 0;
        int length = str.length();
        this.f3758g.setLength(0);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            i2 = str.codePointAt(i2);
            if (i2 != 32) {
                if (i2 < 4352 || ((i2 > 4370 && i2 < 12593) || ((i2 > 12622 && i2 < 44032) || i2 > 55203))) {
                    break;
                }
                if (i2 < 44032) {
                    if (i2 >= 12593) {
                        if (i2 - 12593 >= 30) {
                            break;
                        }
                        i2 = f3753b[i2 - 12593];
                        if (i2 == 0) {
                            break;
                        }
                    }
                } else {
                    i2 = ((i2 - 44032) / 588) + 4352;
                }
                this.f3758g.appendCodePoint(i2);
                i++;
            }
            if (i3 >= length) {
                break;
            }
            i2 = i3;
        }
        if (i > 1) {
            this.f3757f.add(m4200b(this.f3758g.toString()));
        }
    }

    private String m4200b(String str) {
        return this.f3754c.m11655a(str);
    }

    private void m4195a(int i, int i2, boolean z) {
        if (i == i2) {
            m4194a(i2);
            return;
        }
        String str = this.f3759h[i];
        int i3 = i;
        while (i3 < i2) {
            this.f3759h[i] = this.f3759h[i3];
            this.f3759h[i3] = str;
            int i4 = i + 1;
            boolean z2 = z && i3 == i;
            m4195a(i4, i2, z2);
            this.f3759h[i3] = this.f3759h[i];
            this.f3759h[i] = str;
            i3++;
        }
    }

    private void m4194a(int i) {
        int i2 = 0;
        if (this.f3760i) {
            this.f3758g.setLength(0);
            while (i2 < i) {
                if (i2 != 0) {
                    this.f3758g.append('.');
                }
                this.f3758g.append(this.f3759h[i2]);
                i2++;
            }
            this.f3757f.add(this.f3758g.toString());
        }
        m4201b(i);
    }

    private void m4201b(int i) {
        int i2 = 0;
        this.f3758g.setLength(0);
        while (i2 < i) {
            this.f3758g.append(this.f3759h[i2]);
            i2++;
        }
        this.f3757f.add(this.f3758g.toString());
    }

    private void m4202b(String str, int i) {
        Iterator b = this.f3755d.m14090b(str, i);
        if (b != null) {
            while (b.hasNext()) {
                this.f3757f.add(m4200b((String) b.next()));
            }
        }
    }
}
