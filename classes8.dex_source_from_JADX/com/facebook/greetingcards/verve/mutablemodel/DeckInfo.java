package com.facebook.greetingcards.verve.mutablemodel;

import android.support.v4.util.SparseArrayCompat;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.VerveMediaInfoSupplier;
import com.facebook.greetingcards.verve.VerveViewSupplier;
import com.facebook.greetingcards.verve.model.VMColor;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMSlideValue;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.model.VMViewType;
import com.facebook.greetingcards.verve.render.VerveViewRecycler;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.HashSet;
import javax.annotation.Nullable;

/* compiled from: viewer_blacklist_page_from_gravity */
public class DeckInfo {
    public final VMDeck f346a;
    public final VerveViewSupplier f347b;
    public final VerveActionListener f348c;
    public final VerveMediaInfoSupplier f349d;
    public final VerveViewRecycler f350e;
    public final float f351f;
    private final SparseArrayCompat<ImmutableList<VMView>> f352g = new SparseArrayCompat();
    public final SparseArrayCompat<VMColor> f353h = new SparseArrayCompat();
    public final SparseArrayCompat<VMView> f354i = new SparseArrayCompat();

    public DeckInfo(VMDeck vMDeck, VerveViewSupplier verveViewSupplier, VerveActionListener verveActionListener, VerveMediaInfoSupplier verveMediaInfoSupplier, float f) {
        this.f346a = vMDeck;
        this.f347b = verveViewSupplier;
        this.f348c = verveActionListener;
        this.f349d = verveMediaInfoSupplier;
        this.f351f = f;
        this.f350e = new VerveViewRecycler(verveViewSupplier);
    }

    public final ImmutableList<VMView> m318b(int i) {
        ImmutableList<VMView> immutableList = (ImmutableList) this.f352g.a(i);
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<VMView> b = m316b((VMSlide) this.f346a.slides.get(i));
        this.f352g.b(i, b);
        this.f353h.b(i, m311a((VMSlide) this.f346a.slides.get(i)));
        int size = b.size();
        for (int i2 = 0; i2 < size; i2++) {
            VMView vMView = (VMView) b.get(i2);
            this.f354i.b(vMView.f340a, vMView);
        }
        return b;
    }

    private VMColor m311a(VMSlide vMSlide) {
        if (vMSlide.bgColor != null) {
            return vMSlide.bgColor;
        }
        if (vMSlide.master || vMSlide.className == null) {
            return null;
        }
        return ((VMSlide) this.f346a.slides.get(m317c(vMSlide))).bgColor;
    }

    private ImmutableList<VMView> m316b(VMSlide vMSlide) {
        if (vMSlide.className == null || vMSlide.master) {
            return m314a(vMSlide.views, null, this.f351f);
        }
        int i;
        int c = m317c(vMSlide);
        VMSlide vMSlide2 = (VMSlide) this.f346a.slides.get(c);
        ImmutableList a = m314a(((VMSlide) this.f346a.slides.get(c)).views, vMSlide.values, Math.min(vMSlide.m275b() / vMSlide2.m275b(), vMSlide.m276c() / vMSlide2.m276c()) * this.f351f);
        ImmutableList a2 = m314a(vMSlide.views, null, this.f351f);
        int i2 = 0;
        Builder builder = new Builder();
        builder.b(a);
        HashSet hashSet = new HashSet();
        int size = a.size();
        for (i = 0; i < size; i++) {
            hashSet.add(((VMView) a.get(i)).name);
        }
        i = a2.size();
        while (i2 < i) {
            VMView vMView = (VMView) a2.get(i2);
            if (!hashSet.contains(vMView.name)) {
                builder.c(vMView);
            }
            i2++;
        }
        return builder.b();
    }

    private ImmutableList<VMView> m314a(ImmutableList<VMView> immutableList, @Nullable ImmutableList<VMSlideValue> immutableList2, float f) {
        if (immutableList == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            VMView vMView;
            VMView vMView2 = (VMView) immutableList.get(i);
            VMView.Builder a = VMView.m289p().m286a(vMView2);
            if (vMView2.m308o() == VMViewType.GROUP || vMView2.m308o() == VMViewType.SEQUENCE) {
                a.f320m = m314a(vMView2.subviews, immutableList2, f);
            }
            a.m285a(f);
            VMSlideValue a2 = m312a(immutableList2, vMView2.valueName);
            if (a2 != null) {
                if (a.f313f.equalsIgnoreCase(VMViewType.PLACEHOLDER.toString()) && a2.m282a() != null) {
                    a.f313f = a2.m282a().toString();
                }
                if (a2.src != null) {
                    a.f316i = a2.src;
                }
                if (a2.text != null) {
                    a.f322o = a2.text;
                }
                if (a2.title != null) {
                    a.f332y = a2.title;
                }
                if (a2.duration != null) {
                    a.f304C = a2.duration;
                }
                if (a2.subviews != null) {
                    a.f320m = a2.subviews;
                }
                if (a2.f299a != null) {
                    a.f305D = a2.f299a;
                }
            }
            vMView2 = m315b(this.f346a.styles, vMView2.styleName);
            String str = this.f346a.theme;
            if (vMView2 == null || vMView2.statesMap == null) {
                vMView = null;
            } else {
                vMView = (VMView) vMView2.statesMap.get(str);
            }
            VMView vMView3 = vMView;
            if (vMView3 != null) {
                a.m288b(vMView3);
            }
            if (vMView2 != null) {
                a.m288b(vMView2);
            }
            builder.c(a.m287a());
        }
        return builder.b();
    }

    @Nullable
    private static VMSlideValue m312a(ImmutableList<VMSlideValue> immutableList, String str) {
        if (immutableList == null) {
            return null;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            VMSlideValue vMSlideValue = (VMSlideValue) immutableList.get(i);
            if (Objects.equal(str, vMSlideValue.name)) {
                return vMSlideValue;
            }
        }
        return null;
    }

    private static ImmutableList<VMView> m313a(ImmutableList<VMView> immutableList) {
        if (immutableList == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            VMView vMView = (VMView) immutableList.get(i);
            if (vMView.m308o() == VMViewType.GROUP) {
                builder.b(m313a(vMView.subviews));
            } else {
                builder.c(vMView);
            }
        }
        return builder.b();
    }

    private int m317c(VMSlide vMSlide) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < this.f346a.slides.size()) {
            int i4;
            VMSlide vMSlide2 = (VMSlide) this.f346a.slides.get(i3);
            if (vMSlide2.master && Objects.equal(vMSlide.className, vMSlide2.className)) {
                int i5;
                int i6 = 0;
                boolean[] zArr = new boolean[vMSlide.m274a().size()];
                ImmutableList a = m313a(m318b(i3));
                int size = a.size();
                int i7 = 0;
                while (i7 < size) {
                    VMView vMView = (VMView) a.get(i7);
                    if (vMView.valueName != null) {
                        Object obj;
                        ImmutableList a2 = vMSlide.m274a();
                        int size2 = a2.size();
                        int i8 = 0;
                        for (int i9 = 0; i9 < size2; i9++) {
                            VMSlideValue vMSlideValue = (VMSlideValue) a2.get(i9);
                            if (Objects.equal(vMView.valueName, vMSlideValue.name) && vMView.m308o() == vMSlideValue.m282a()) {
                                obj = 1;
                                zArr[i8] = true;
                                break;
                            }
                            i8++;
                        }
                        obj = null;
                        if (obj == null) {
                            i5 = i6 + 1000;
                            i7++;
                            i6 = i5;
                        }
                    }
                    i5 = i6;
                    i7++;
                    i6 = i5;
                }
                for (i5 = 0; i5 < vMSlide.m274a().size(); i5++) {
                    if (!zArr[i5]) {
                        i6++;
                    }
                }
                if (i6 < i) {
                    i4 = i6;
                    i = i3;
                    i3++;
                    i2 = i;
                    i = i4;
                }
            }
            i4 = i;
            i = i2;
            i3++;
            i2 = i;
            i = i4;
        }
        if (i2 != -1) {
            return i2;
        }
        throw new RuntimeException("No master slide with className " + vMSlide.className);
    }

    @Nullable
    private static VMView m315b(ImmutableList<VMView> immutableList, String str) {
        if (str == null) {
            return null;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            VMView vMView = (VMView) immutableList.get(i);
            if (str.equals(vMView.name)) {
                return vMView;
            }
        }
        return null;
    }
}
