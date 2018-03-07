package com.facebook.composer.privacy.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
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
/* compiled from: tapped_photos_of_page */
public class TagExpandPrivacyHelper {
    private static TagExpandPrivacyHelper f2051e;
    private static final Object f2052f = new Object();
    private TextPaint f2053a = new TextPaint(1);
    private Resources f2054b;
    private Drawable f2055c;
    private AudienceTypeaheadUtil f2056d;

    private static TagExpandPrivacyHelper m1993b(InjectorLike injectorLike) {
        return new TagExpandPrivacyHelper(ResourcesMethodAutoProvider.a(injectorLike), AudienceTypeaheadUtil.b(injectorLike));
    }

    @Inject
    public TagExpandPrivacyHelper(Resources resources, AudienceTypeaheadUtil audienceTypeaheadUtil) {
        this.f2055c = resources.getDrawable(2130843693);
        this.f2054b = resources;
        this.f2056d = audienceTypeaheadUtil;
    }

    public static TagExpandPrivacyHelper m1991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TagExpandPrivacyHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2052f) {
                TagExpandPrivacyHelper tagExpandPrivacyHelper;
                if (a2 != null) {
                    tagExpandPrivacyHelper = (TagExpandPrivacyHelper) a2.a(f2052f);
                } else {
                    tagExpandPrivacyHelper = f2051e;
                }
                if (tagExpandPrivacyHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1993b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2052f, b3);
                        } else {
                            f2051e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = tagExpandPrivacyHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final SpannableStringBuilder m1994a(Context context, ImmutableList<BaseToken> immutableList, float f, int i, boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int ceil = i - ((int) Math.ceil((double) (this.f2054b.getDimension(2131429357) * this.f2054b.getDisplayMetrics().density)));
        if (ceil <= 0 || immutableList == null) {
            return spannableStringBuilder;
        }
        int intrinsicWidth;
        this.f2053a.setTextSize(f);
        if (z2) {
            this.f2053a.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
        BaseToken a = m1992a((ImmutableList) immutableList);
        if (a != null) {
            intrinsicWidth = ceil - this.f2054b.getDrawable(a.e()).getIntrinsicWidth();
        } else {
            intrinsicWidth = ceil;
        }
        UnmodifiableListIterator listIterator = immutableList.listIterator();
        while (listIterator.hasNext()) {
            BaseToken baseToken = (BaseToken) listIterator.next();
            Object obj = baseToken.b() + " ";
            Integer num = null;
            if (z) {
                num = Integer.valueOf(this.f2054b.getColor(2131361974));
                this.f2053a.setColor(this.f2054b.getColor(2131361974));
            } else if (!baseToken.a()) {
                this.f2053a.setColor(this.f2054b.getColor(2131361938));
            } else if (baseToken.r()) {
                this.f2053a.setColor(this.f2054b.getColor(2131361864));
            } else {
                this.f2053a.setColor(this.f2054b.getColor(2131361917));
            }
            Builder builder = new Builder();
            builder.a = baseToken;
            Builder a2 = builder.a(intrinsicWidth);
            a2.b = this.f2053a;
            a2 = a2;
            a2.c = this.f2054b;
            a2 = a2;
            a2.e = this.f2055c;
            a2 = a2;
            a2.h = num;
            BaseTokenSpan a3 = a2.b(0).a(listIterator.hasNext()).a(context);
            spannableStringBuilder.append(obj);
            spannableStringBuilder.setSpan(a3, spannableStringBuilder.length() - obj.length(), spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    private static BaseToken m1992a(ImmutableList<BaseToken> immutableList) {
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
