package com.facebook.richdocument.ham;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.DisplayMetrics;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placeholderSrc */
public class HamDimensions {
    private static final int[] f5297a = new int[]{640, 750, 1242};
    private static final List<DimenHolder> f5298b = new C06941();
    private static HamDimensions f5299d;
    private static final Object f5300e = new Object();
    public final Map<Integer, Float> f5301c = new HashMap();

    /* compiled from: placeholderSrc */
    final class C06941 extends ArrayList<DimenHolder> {
        C06941() {
            add(new DimenHolder(2131558648, new int[]{16, 16, 26}));
            add(new DimenHolder(2131558649, new int[]{32, 32, 52}));
            add(new DimenHolder(2131558650, new int[]{46, 46, 74}));
            add(new DimenHolder(2131558651, new int[]{64, 64, 102}));
            add(new DimenHolder(2131558652, new int[]{96, 96, 154}));
            add(new DimenHolder(2131558653, new int[]{34, 40, 64}));
            add(new DimenHolder(2131558654, new int[]{34, 40, 64}));
            add(new DimenHolder(2131558655, new int[]{34, 40, 64}));
            add(new DimenHolder(2131558656, new int[]{34, 34, 50}));
            add(new DimenHolder(2131558657, new int[]{24, 24, 39}));
            add(new DimenHolder(2131558658, new int[]{60, 60, 78}));
            add(new DimenHolder(2131558659, new int[]{38, 38, 58}));
            add(new DimenHolder(2131558660, new int[]{46, 46, 60}));
            add(new DimenHolder(2131558661, new int[]{38, 38, 58}));
            add(new DimenHolder(2131558662, new int[]{34, 34, 50}));
            add(new DimenHolder(2131558663, new int[]{46, 46, 60}));
            add(new DimenHolder(2131558664, new int[]{24, 24, 40}));
            add(new DimenHolder(2131558665, new int[]{20, 20, 32}));
            add(new DimenHolder(2131558666, new int[]{24, 24, 40}));
            add(new DimenHolder(2131558667, new int[]{24, 24, 40}));
            add(new DimenHolder(2131558668, new int[]{34, 34, 50}));
            add(new DimenHolder(2131558669, new int[]{38, 38, 58}));
            add(new DimenHolder(2131558670, new int[]{56, 56, 74}));
            add(new DimenHolder(2131558671, new int[]{30, 30, 45}));
            add(new DimenHolder(2131558672, new int[]{26, 26, 38}));
            add(new DimenHolder(2131558673, new int[]{30, 30, 45}));
            add(new DimenHolder(2131558674, new int[]{48, 48, 78}));
            add(new DimenHolder(2131558675, new int[]{28, 28, 48}));
            add(new DimenHolder(2131558676, new int[]{72, 72, 102}));
            add(new DimenHolder(2131558677, new int[]{48, 48, 78}));
            add(new DimenHolder(2131558678, new int[]{56, 56, 81}));
            add(new DimenHolder(2131558679, new int[]{48, 48, 78}));
            add(new DimenHolder(2131558680, new int[]{48, 48, 78}));
            add(new DimenHolder(2131558681, new int[]{64, 64, 92}));
            add(new DimenHolder(2131558682, new int[]{28, 28, 46}));
            add(new DimenHolder(2131558683, new int[]{28, 28, 46}));
            add(new DimenHolder(2131558684, new int[]{32, 32, 57}));
            add(new DimenHolder(2131558685, new int[]{32, 32, 57}));
            add(new DimenHolder(2131558686, new int[]{48, 48, 78}));
            add(new DimenHolder(2131558687, new int[]{44, 44, 72}));
            add(new DimenHolder(2131558688, new int[]{64, 64, 92}));
            add(new DimenHolder(2131558689, new int[]{42, 42, 60}));
            add(new DimenHolder(2131558690, new int[]{34, 34, 54}));
            add(new DimenHolder(2131558691, new int[]{36, 36, 51}));
            add(new DimenHolder(2131558692, new int[]{1, 1, 1}));
            add(new DimenHolder(2131558693, new int[]{1, 1, 1}));
            add(new DimenHolder(2131558694, new int[]{1, 1, 2}));
            add(new DimenHolder(2131558695, new int[]{1, 1, 2}));
            add(new DimenHolder(2131558696, new int[]{1, 1, 1}));
            add(new DimenHolder(2131558697, new int[]{1, 1, 2}));
            add(new DimenHolder(2131558698, new int[]{1, 1, 2}));
            add(new DimenHolder(2131558699, HamDimensions.m5274e(12)));
            add(new DimenHolder(2131558700, HamDimensions.m5274e(20)));
            add(new DimenHolder(2131558701, HamDimensions.m5274e(13)));
            add(new DimenHolder(2131558702, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558703, HamDimensions.m5274e(17)));
            add(new DimenHolder(2131558704, HamDimensions.m5274e(29)));
            add(new DimenHolder(2131558705, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558706, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558707, HamDimensions.m5274e(24)));
            add(new DimenHolder(2131558708, HamDimensions.m5274e(24)));
            add(new DimenHolder(2131558709, HamDimensions.m5274e(26)));
            add(new DimenHolder(2131558710, HamDimensions.m5274e(26)));
            add(new DimenHolder(2131558711, HamDimensions.m5274e(26)));
            add(new DimenHolder(2131558712, HamDimensions.m5274e(26)));
            add(new DimenHolder(2131558713, HamDimensions.m5274e(35)));
            add(new DimenHolder(2131558714, HamDimensions.m5274e(32)));
            add(new DimenHolder(2131558715, HamDimensions.m5274e(27)));
            add(new DimenHolder(2131558716, HamDimensions.m5274e(65)));
            add(new DimenHolder(2131558717, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558718, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558719, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558720, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558721, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558722, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558723, HamDimensions.m5274e(30)));
            add(new DimenHolder(2131558724, HamDimensions.m5274e(22)));
            add(new DimenHolder(2131558725, HamDimensions.m5274e(10)));
        }
    }

    /* compiled from: placeholderSrc */
    class DimenHolder {
        final int f5295a;
        final int[] f5296b;

        public DimenHolder(int i, int[] iArr) {
            this.f5296b = iArr;
            this.f5295a = i;
        }
    }

    private static HamDimensions m5272b(InjectorLike injectorLike) {
        return new HamDimensions((Context) injectorLike.getInstance(Context.class));
    }

    public static HamDimensions m5268a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HamDimensions b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5300e) {
                HamDimensions hamDimensions;
                if (a2 != null) {
                    hamDimensions = (HamDimensions) a2.a(f5300e);
                } else {
                    hamDimensions = f5299d;
                }
                if (hamDimensions == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5272b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5300e, b3);
                        } else {
                            f5299d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hamDimensions;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public HamDimensions(Context context) {
        m5271a(context);
    }

    private void m5271a(Context context) {
        int i = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (min < f5297a[0]) {
            m5269a(0, (((float) min) * 1.0f) / ((float) f5297a[0]));
        } else if (min >= f5297a[f5297a.length - 1]) {
            i = f5297a.length - 1;
            m5269a(i, (((float) min) * 1.0f) / ((float) f5297a[i]));
        } else {
            int length = f5297a.length;
            while (i < length - 1) {
                int i2 = i + 1;
                int i3 = f5297a[i];
                int i4 = f5297a[i2];
                if (min == i3) {
                    m5269a(i, 1.0f);
                    break;
                }
                if (min > i3 && min < i4) {
                    m5270a(i, i2, (((float) (min - i3)) * 1.0f) / ((float) (i4 - i3)));
                }
                i++;
            }
        }
        float floatValue = ((Float) this.f5301c.get(Integer.valueOf(2131558648))).floatValue();
        float floatValue2 = ((Float) this.f5301c.get(Integer.valueOf(2131558651))).floatValue();
        this.f5301c.put(Integer.valueOf(2131558726), Float.valueOf(((Float) this.f5301c.get(Integer.valueOf(2131558652))).floatValue() + floatValue));
        this.f5301c.put(Integer.valueOf(2131558727), Float.valueOf(floatValue + floatValue2));
        m5273b();
    }

    private void m5273b() {
        float floatValue = ((Float) this.f5301c.get(Integer.valueOf(2131558650))).floatValue();
        float floatValue2 = ((Float) this.f5301c.get(Integer.valueOf(2131558648))).floatValue();
        this.f5301c.put(Integer.valueOf(2131558728), Float.valueOf(floatValue * 2.0f));
        this.f5301c.put(Integer.valueOf(2131558729), Float.valueOf(floatValue2 * 1.5f));
    }

    public final float m5275a(int i) {
        if (i == 0) {
            return 0.0f;
        }
        if (!m5277c(i)) {
            throw new NotFoundException("id not found");
        } else if (this.f5301c.containsKey(Integer.valueOf(i))) {
            return ((Float) this.f5301c.get(Integer.valueOf(i))).floatValue();
        } else {
            return 0.0f;
        }
    }

    public final int m5276b(int i) {
        if (i == 0) {
            return 0;
        }
        if (!m5277c(i)) {
            throw new NotFoundException("id not found");
        } else if (this.f5301c.containsKey(Integer.valueOf(i))) {
            return Math.round(((Float) this.f5301c.get(Integer.valueOf(i))).floatValue());
        } else {
            return 0;
        }
    }

    public final boolean m5277c(int i) {
        return this.f5301c.containsKey(Integer.valueOf(i));
    }

    private void m5269a(int i, float f) {
        for (DimenHolder dimenHolder : f5298b) {
            this.f5301c.put(Integer.valueOf(dimenHolder.f5295a), Float.valueOf(((float) dimenHolder.f5296b[i]) * f));
        }
    }

    private void m5270a(int i, int i2, float f) {
        for (DimenHolder dimenHolder : f5298b) {
            this.f5301c.put(Integer.valueOf(dimenHolder.f5295a), Float.valueOf((((float) dimenHolder.f5296b[i]) * (1.0f - f)) + (((float) dimenHolder.f5296b[i2]) * f)));
        }
    }

    public static int[] m5274e(int i) {
        int i2 = 0;
        int[] iArr = new int[f5297a.length];
        int i3 = f5297a[0];
        while (i2 < f5297a.length) {
            iArr[i2] = (f5297a[i2] * i) / i3;
            i2++;
        }
        return iArr;
    }
}
