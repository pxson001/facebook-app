package com.facebook.platform.composer.privacy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil.StringProcessor;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan.Builder;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import javax.inject.Inject;

@ContextScoped
/* compiled from: results_state */
public class PlatformComposerTagExpandPrivacyHelper {
    private static PlatformComposerTagExpandPrivacyHelper f4273e;
    private static final Object f4274f = new Object();
    private TextPaint f4275a = new TextPaint(1);
    private Resources f4276b;
    private Drawable f4277c;
    private AudienceTypeaheadUtil f4278d;

    /* compiled from: results_state */
    public final class C05481 implements StringProcessor {
        public final String m4200a(Object obj) {
            return ((BaseToken) obj).b();
        }
    }

    private static PlatformComposerTagExpandPrivacyHelper m4202b(InjectorLike injectorLike) {
        return new PlatformComposerTagExpandPrivacyHelper(ResourcesMethodAutoProvider.a(injectorLike), AudienceTypeaheadUtil.b(injectorLike));
    }

    @Inject
    public PlatformComposerTagExpandPrivacyHelper(Resources resources, AudienceTypeaheadUtil audienceTypeaheadUtil) {
        this.f4277c = resources.getDrawable(2130843693);
        this.f4276b = resources;
        this.f4278d = audienceTypeaheadUtil;
    }

    public static PlatformComposerTagExpandPrivacyHelper m4201a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlatformComposerTagExpandPrivacyHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4274f) {
                PlatformComposerTagExpandPrivacyHelper platformComposerTagExpandPrivacyHelper;
                if (a2 != null) {
                    platformComposerTagExpandPrivacyHelper = (PlatformComposerTagExpandPrivacyHelper) a2.a(f4274f);
                } else {
                    platformComposerTagExpandPrivacyHelper = f4273e;
                }
                if (platformComposerTagExpandPrivacyHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4202b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4274f, b3);
                        } else {
                            f4273e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = platformComposerTagExpandPrivacyHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final SpannableStringBuilder m4204a(Context context, ImmutableList<BaseToken> immutableList, float f, int i, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int ceil = i - ((int) Math.ceil((double) (this.f4276b.getDimension(2131429357) * this.f4276b.getDisplayMetrics().density)));
        if (ceil <= 0 || immutableList == null) {
            return spannableStringBuilder;
        }
        int intrinsicWidth;
        this.f4275a.setTextSize(f);
        BaseToken b = m4203b((ImmutableList) immutableList);
        if (b != null) {
            intrinsicWidth = ceil - this.f4276b.getDrawable(b.e()).getIntrinsicWidth();
        } else {
            intrinsicWidth = ceil;
        }
        UnmodifiableListIterator listIterator = immutableList.listIterator();
        while (listIterator.hasNext()) {
            Integer valueOf;
            BaseToken baseToken = (BaseToken) listIterator.next();
            Object obj = baseToken.b() + " ";
            if (z) {
                valueOf = Integer.valueOf(this.f4276b.getColor(2131361974));
            } else if (!baseToken.a()) {
                valueOf = Integer.valueOf(this.f4276b.getColor(2131361938));
            } else if (baseToken.c) {
                valueOf = Integer.valueOf(this.f4276b.getColor(2131361920));
            } else {
                valueOf = Integer.valueOf(this.f4276b.getColor(2131361917));
            }
            this.f4275a.setColor(valueOf.intValue());
            Builder builder = new Builder();
            builder.a = baseToken;
            Builder a = builder.a(intrinsicWidth);
            a.b = this.f4275a;
            a = a;
            a.c = this.f4276b;
            a = a;
            a.e = this.f4277c;
            a = a;
            a.h = valueOf;
            BaseTokenSpan a2 = a.b(0).a(listIterator.hasNext()).a(context);
            spannableStringBuilder.append(obj);
            spannableStringBuilder.setSpan(a2, spannableStringBuilder.length() - obj.length(), spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    private static BaseToken m4203b(ImmutableList<BaseToken> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            BaseToken baseToken = (BaseToken) immutableList.get(i);
            if (baseToken.a == Type.TAG_EXPANSION) {
                return baseToken;
            }
        }
        return null;
    }
}
