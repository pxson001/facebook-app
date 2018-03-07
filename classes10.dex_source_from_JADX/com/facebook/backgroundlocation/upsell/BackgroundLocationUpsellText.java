package com.facebook.backgroundlocation.upsell;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SpannableStringFormatter;
import com.facebook.common.util.SpannableStringSubstitution;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: dest_module */
public class BackgroundLocationUpsellText {
    private static BackgroundLocationUpsellText f15064c;
    private static final Object f15065d = new Object();
    private final Context f15066a;
    private final Resources f15067b;

    /* compiled from: dest_module */
    class ColorableStyleSpan extends StyleSpan {
        private final int f15063a;

        public ColorableStyleSpan(int i, int i2) {
            super(i);
            this.f15063a = i2;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f15063a);
            super.updateDrawState(textPaint);
        }
    }

    private static BackgroundLocationUpsellText m15567b(InjectorLike injectorLike) {
        return new BackgroundLocationUpsellText((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackgroundLocationUpsellText(Context context, Resources resources) {
        this.f15066a = context;
        this.f15067b = resources;
    }

    public final SpannableString m15570a(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList, int i2) {
        boolean z;
        Preconditions.checkArgument(!immutableList.isEmpty());
        if (i >= immutableList.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (immutableList.size() < 4) {
            if (i == immutableList.size()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
        }
        switch (i) {
            case 1:
                return m15559a((BackgroundLocationUpsellProfileModel) immutableList.get(0), i2);
            case 2:
                return m15560a((BackgroundLocationUpsellProfileModel) immutableList.get(0), (BackgroundLocationUpsellProfileModel) immutableList.get(1), i2);
            case 3:
                return m15561a((BackgroundLocationUpsellProfileModel) immutableList.get(0), (BackgroundLocationUpsellProfileModel) immutableList.get(1), (BackgroundLocationUpsellProfileModel) immutableList.get(2), i2);
            default:
                return m15566b(i, immutableList, i2);
        }
    }

    public static BackgroundLocationUpsellText m15563a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BackgroundLocationUpsellText b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f15065d) {
                BackgroundLocationUpsellText backgroundLocationUpsellText;
                if (a2 != null) {
                    backgroundLocationUpsellText = (BackgroundLocationUpsellText) a2.a(f15065d);
                } else {
                    backgroundLocationUpsellText = f15064c;
                }
                if (backgroundLocationUpsellText == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15567b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f15065d, b3);
                        } else {
                            f15064c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = backgroundLocationUpsellText;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final SpannableString m15569a(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        return m15570a(i, (ImmutableList) immutableList, 0);
    }

    public final SpannableString m15571a(int i, String str, int i2, int i3, int i4) {
        return SpannableStringFormatter.a(this.f15067b, i, new SpannableStringSubstitution[]{m15565a(str, i3), m15565a(this.f15067b.getString(i2), i4)});
    }

    private SpannableString m15566b(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList, int i2) {
        return SpannableStringFormatter.a(this.f15067b, 2131233830, new SpannableStringSubstitution[]{m15568b((BackgroundLocationUpsellProfileModel) immutableList.get(0), i2), m15568b((BackgroundLocationUpsellProfileModel) immutableList.get(1), i2), m15564a(i - 2, i2)});
    }

    private SpannableString m15561a(BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel, BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel2, BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel3, int i) {
        return SpannableStringFormatter.a(this.f15067b, 2131233831, new SpannableStringSubstitution[]{m15568b(backgroundLocationUpsellProfileModel, i), m15568b(backgroundLocationUpsellProfileModel2, i), m15568b(backgroundLocationUpsellProfileModel3, i)});
    }

    private SpannableString m15560a(BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel, BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel2, int i) {
        return SpannableStringFormatter.a(this.f15067b, 2131233832, new SpannableStringSubstitution[]{m15568b(backgroundLocationUpsellProfileModel, i), m15568b(backgroundLocationUpsellProfileModel2, i)});
    }

    private SpannableString m15559a(BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel, int i) {
        return SpannableStringFormatter.a(this.f15067b, 2131233833, new SpannableStringSubstitution[]{m15568b(backgroundLocationUpsellProfileModel, i)});
    }

    private SpannableStringSubstitution m15568b(BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel, int i) {
        return new SpannableStringSubstitution(backgroundLocationUpsellProfileModel.m15590d(), m15562a(i), 33);
    }

    private SpannableStringSubstitution m15564a(int i, int i2) {
        return new SpannableStringSubstitution(this.f15067b.getQuantityString(2131689571, i, new Object[]{Integer.valueOf(i)}), m15562a(i2), 33);
    }

    private SpannableStringSubstitution m15565a(String str, int i) {
        return new SpannableStringSubstitution(str, new ColorableStyleSpan(0, ContextCompat.b(this.f15066a, i)), 33);
    }

    private StyleSpan m15562a(int i) {
        return i == 0 ? new StyleSpan(1) : new ColorableStyleSpan(1, ContextCompat.b(this.f15066a, i));
    }
}
