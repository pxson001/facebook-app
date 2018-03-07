package com.facebook.greetingcards.render;

import android.content.res.Resources;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.greetingcards.verve.model.VMAction;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMSlideValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: xma_leave_converation */
public class TemplateHelper {
    private final Resources f222a;

    @Inject
    public TemplateHelper(Resources resources) {
        this.f222a = resources;
    }

    public final VMDeck m272a(VMDeck vMDeck, GreetingCard greetingCard, float f, float f2, ImmutableList<String> immutableList) {
        int size = (greetingCard.b.size() + (greetingCard.a != null ? 1 : 0)) + (greetingCard.c != null ? 1 : 0);
        Builder builder = ImmutableList.builder();
        if (greetingCard.a != null) {
            ImmutableList immutableList2;
            Slide slide = greetingCard.a;
            String str = "Front";
            if (greetingCard.b.isEmpty() && greetingCard.c == null) {
                immutableList2 = immutableList;
            } else {
                immutableList2 = null;
            }
            builder.c(m268a(slide, 0, size, str, immutableList2, f, f2));
        }
        int i = 0;
        while (i < greetingCard.b.size()) {
            builder.c(m268a((Slide) greetingCard.b.get(i), i + 1, size, "Moment", null, f, f2));
            i++;
        }
        if (greetingCard.c != null) {
            builder.c(m268a(greetingCard.c, i + 1, size, "Back", immutableList, f, f2));
        }
        builder.b(vMDeck.slides);
        return new VMDeck(ImmutableList.of(Float.valueOf(f), Float.valueOf(f2)), builder.b(), vMDeck.resources, m271a(0), vMDeck.styles, greetingCard.e != null ? greetingCard.e : "Theme 1", vMDeck.bgColor);
    }

    private VMSlide m268a(Slide slide, int i, int i2, String str, ImmutableList<String> immutableList, float f, float f2) {
        return new VMSlide(m271a(i), ImmutableList.of(Float.valueOf(f), Float.valueOf(f2)), null, m270a(i, i == i2 + -1), false, str, m269a(slide, "Front".equals(str), immutableList), null);
    }

    private ImmutableList<VMSlideValue> m269a(Slide slide, boolean z, ImmutableList<String> immutableList) {
        int i = 0;
        Builder builder = ImmutableList.builder();
        if (!(slide.a == null || slide.a.isEmpty())) {
            builder.c(VMSlideValue.a("title", slide.a));
        }
        if (!(slide.b == null || slide.b.isEmpty())) {
            builder.c(VMSlideValue.a("body", slide.b));
        }
        for (int i2 = 0; i2 < slide.c.size(); i2++) {
            builder.c(VMSlideValue.a("media" + (i2 + 1), ((CardPhoto) slide.c.get(i2)).a.toString(), ((CardPhoto) slide.c.get(i2)).e));
        }
        if (z) {
            builder.c(VMSlideValue.a("swipe_up", this.f222a.getString(2131241474)));
        }
        if (immutableList != null) {
            while (i < immutableList.size()) {
                builder.c(VMSlideValue.b("button" + (i + 1), ((String) immutableList.get(i)).toUpperCase()));
                i++;
            }
        }
        return builder.b();
    }

    private static ImmutableMap<String, VMAction> m270a(int i, boolean z) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        if (i > 0) {
            builder.b("swipe-down", new VMAction("select-slide", m271a(i - 1)));
        }
        if (!z) {
            builder.b("swipe-up", new VMAction("select-slide", m271a(i + 1)));
        }
        return builder.b();
    }

    private static String m271a(int i) {
        return "Slide " + (i + 1);
    }
}
