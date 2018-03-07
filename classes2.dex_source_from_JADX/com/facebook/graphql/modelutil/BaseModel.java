package com.facebook.graphql.modelutil;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.debug.fieldusage.FieldAccessQueryContext;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.debug.fieldusage.FieldAccessTracker;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.Flattenable.VirtualFlattenableResolver;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.graphql.typecodes.GraphQLTypeCodes;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: see_more */
public abstract class BaseModel implements MutableFlattenable, Cloneable {
    public FieldAccessTracker a_;
    public MutableFlatBuffer f5823b;
    public int f5824c;
    private final int f5825d;

    /* compiled from: see_more */
    public abstract class Builder {
        public MutableFlatBuffer f15736a;
        public int f15737b;
        public FieldAccessTracker f15738c;

        public static void m22419a(Builder builder, BaseModel baseModel) {
            builder.f15738c = baseModel.a_;
            baseModel.m9959i();
        }

        protected Builder() {
        }
    }

    public final /* synthetic */ FieldAccessTracker m9942a(FieldAccessQueryTracker fieldAccessQueryTracker) {
        return m9940b(fieldAccessQueryTracker);
    }

    protected BaseModel(int i) {
        this.f5825d = i;
    }

    public Object clone() {
        return super.clone();
    }

    public final BaseModel m9957f() {
        try {
            return (BaseModel) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Class doesn't support clone:" + getClass().getSimpleName());
        }
    }

    public final void mo1412a(MutableFlatBuffer mutableFlatBuffer, int i) {
        mo1406a(mutableFlatBuffer, i, null);
    }

    public void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        this.f5823b = mutableFlatBuffer;
        this.f5824c = i;
        FieldAccessQueryTracker b = FieldAccessQueryContext.m9557b(mutableFlatBuffer);
        if (b == null && obj != null) {
            b = FieldAccessQueryContext.m9557b(obj);
            if (b != null && (obj instanceof JsonParser)) {
                b.a(FieldAccessQueryContext.m9553a(((JsonParser) obj).mo1779j()));
                FieldAccessQueryContext.m9556a(mutableFlatBuffer, b);
            }
        }
        if (b != null) {
            m9940b(b);
        }
    }

    @Nullable
    public final MutableFlatBuffer w_() {
        return this.f5823b;
    }

    public final int u_() {
        return this.f5824c;
    }

    public final int A_() {
        if (this instanceof GraphQLVisitableModel) {
            return GraphQLTypeCodes.a(ObjectType.m22303a(((GraphQLVisitableModel) this).jK_()));
        }
        return -1;
    }

    public int describeContents() {
        return 0;
    }

    private FieldAccessTracker m9940b(FieldAccessQueryTracker fieldAccessQueryTracker) {
        String stringBuilder;
        int i = this.f5825d;
        Object[] toArray = fieldAccessQueryTracker.c.toArray();
        int i2 = 0;
        for (Object obj : toArray) {
            i2 += ((String) obj).length() + 1;
        }
        if (i2 > 0) {
            StringBuilder stringBuilder2 = new StringBuilder(i2);
            stringBuilder2.append(toArray[0]);
            for (int i3 = 1; i3 < toArray.length; i3++) {
                stringBuilder2.append(".").append(toArray[i3]);
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "";
        }
        this.a_ = new FieldAccessTracker(i, stringBuilder, this);
        FieldAccessTracker fieldAccessTracker = this.a_;
        fieldAccessQueryTracker.b.add(fieldAccessTracker);
        fieldAccessTracker.j = fieldAccessQueryTracker;
        return this.a_;
    }

    private void m9941d(List<? extends BaseModel> list, int i) {
        if (this.a_ != null) {
            for (BaseModel a : list) {
                m9939a(a, i);
            }
        }
    }

    public final FieldAccessTracker B_() {
        return this.a_;
    }

    private void mo2908a(int i) {
        if (this.a_ != null) {
            m9949a(i >> 3, i & 7);
        }
    }

    public final void m9949a(int i, int i2) {
        if (this.a_ != null) {
            FieldAccessTracker fieldAccessTracker = this.a_;
            if (fieldAccessTracker.a) {
                byte[] bArr = fieldAccessTracker.b;
                bArr[i] = (byte) (bArr[i] | (1 << i2));
            }
        }
    }

    private void m9939a(BaseModel baseModel, int i) {
        if (baseModel != null) {
            FieldAccessTracker fieldAccessTracker = baseModel.a_;
            if (fieldAccessTracker != null && this.a_ != null) {
                fieldAccessTracker.i = this.a_;
                fieldAccessTracker.h = null;
                fieldAccessTracker.k = i;
            }
        }
    }

    public final void m9958h() {
        if (this.a_ != null) {
            this.a_.a = false;
        }
    }

    public final void m9959i() {
        if (this.a_ != null) {
            this.a_.a = true;
        }
    }

    public final <T> T m9947a(T t, int i, Class<? extends Flattenable> cls) {
        mo2908a(i);
        if (this.f5823b == null || t != null) {
            return t;
        }
        T d = this.f5823b.m21551d(this.f5824c, i, cls);
        m9939a((BaseModel) d, i);
        return d;
    }

    public final <T> T m9946a(T t, int i, VirtualFlattenableResolver virtualFlattenableResolver) {
        mo2908a(i);
        if (this.f5823b == null || t != null) {
            return t;
        }
        T a = this.f5823b.m21526a(this.f5824c, i, virtualFlattenableResolver);
        m9939a((BaseModel) a, i);
        return a;
    }

    public final <T> ImmutableList<T> m9944a(List<T> list, int i, Class<? extends Flattenable> cls) {
        Collection collection;
        mo2908a(i);
        if (this.f5823b == null || list != null) {
            Object obj = list;
        } else {
            list = ImmutableListHelper.m21626a(this.f5823b.m21556e(this.f5824c, i, cls));
            m9941d(list, i);
            collection = list;
        }
        if (collection == null) {
            collection = RegularImmutableList.f535a;
        }
        if (!(collection instanceof ImmutableList)) {
            collection = ImmutableListHelper.m21625a(collection);
        }
        return (ImmutableList) collection;
    }

    public final String m9948a(String str, int i) {
        mo2908a(i);
        if (this.f5823b == null || str != null) {
            return str;
        }
        return this.f5823b.m21547c(this.f5824c, i);
    }

    public final ImmutableList<String> m9943a(List<String> list, int i) {
        Collection a;
        mo2908a(i);
        if (this.f5823b == null || list != null) {
            Object obj = list;
        } else {
            a = ImmutableListHelper.m21626a(this.f5823b.m21558f(this.f5824c, i));
        }
        if (a == null) {
            a = RegularImmutableList.f535a;
        }
        if (!(a instanceof ImmutableList)) {
            a = ImmutableListHelper.m21625a(a);
        }
        return (ImmutableList) a;
    }

    public final ImmutableList<Integer> m9952b(List<Integer> list, int i) {
        Collection a;
        mo2908a(i);
        if (this.f5823b == null || list != null) {
            Object obj = list;
        } else {
            a = ImmutableListHelper.m21626a(this.f5823b.m21552d(this.f5824c, i));
        }
        if (a == null) {
            a = RegularImmutableList.f535a;
        }
        if (!(a instanceof ImmutableList)) {
            a = ImmutableListHelper.m21625a(a);
        }
        return (ImmutableList) a;
    }

    public final ImmutableList<Long> m9955c(List<Long> list, int i) {
        Collection a;
        mo2908a(i);
        if (this.f5823b == null || list != null) {
            Object obj = list;
        } else {
            a = ImmutableListHelper.m21626a(this.f5823b.m21555e(this.f5824c, i));
        }
        if (a == null) {
            a = RegularImmutableList.f535a;
        }
        if (!(a instanceof ImmutableList)) {
            a = ImmutableListHelper.m21625a(a);
        }
        return (ImmutableList) a;
    }

    public final <T extends Enum> T m9945a(T t, int i, Class<T> cls, T t2) {
        T t3;
        mo2908a(i);
        if (this.f5823b == null || t != null) {
            t3 = t;
        } else {
            t3 = this.f5823b.m21532a(this.f5824c, i, (Class) cls);
        }
        return t3 == null ? t2 : t3;
    }

    public final <T extends Enum> T m9954b(T t, int i, Class<T> cls, T t2) {
        T valueOf;
        mo2908a(i);
        if (this.f5823b != null && t == null) {
            String b = this.f5823b.m21542b(this.f5824c, i);
            if (b == null) {
                return t2;
            }
            try {
                valueOf = Enum.valueOf(cls, StringLocaleUtil.m21641b(b));
            } catch (Throwable e) {
                BLog.a(getClass(), "Falling back to unset enum value", e);
            }
            if (valueOf == null) {
                return valueOf;
            }
            return t2;
        }
        valueOf = t;
        if (valueOf == null) {
            return t2;
        }
        return valueOf;
    }

    public final <T extends Enum> ImmutableList<T> m9953b(List<T> list, int i, Class<T> cls) {
        Collection a;
        mo2908a(i);
        if (this.f5823b == null || list != null) {
            Object obj = list;
        } else {
            a = ImmutableListHelper.m21626a(this.f5823b.m21543b(this.f5824c, i, (Class) cls));
        }
        if (a == null) {
            a = RegularImmutableList.f535a;
        }
        if (!(a instanceof ImmutableList)) {
            a = ImmutableListHelper.m21625a(a);
        }
        return (ImmutableList) a;
    }

    public final <T extends Enum> ImmutableList<T> m9956c(List<T> list, int i, Class<T> cls) {
        Collection a;
        mo2908a(i);
        if (this.f5823b == null || list != null) {
            Object obj = list;
        } else {
            a = ImmutableListHelper.m21626a(this.f5823b.m21549c(this.f5824c, i, cls));
        }
        if (a == null) {
            a = RegularImmutableList.f535a;
        }
        if (!(a instanceof ImmutableList)) {
            a = ImmutableListHelper.m21625a(a);
        }
        return (ImmutableList) a;
    }
}
