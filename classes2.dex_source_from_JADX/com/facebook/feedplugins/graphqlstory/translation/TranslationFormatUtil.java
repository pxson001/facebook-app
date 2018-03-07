package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.ui.emoji.EmojiUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: feedback_section */
public class TranslationFormatUtil {
    private static TranslationFormatUtil f24371d;
    private static final Object f24372e = new Object();
    private final EmojiUtil f24373a;
    private final LinkifyUtil f24374b;
    private final Resources f24375c;

    private static TranslationFormatUtil m32685b(InjectorLike injectorLike) {
        return new TranslationFormatUtil(EmojiUtil.m27878a(injectorLike), LinkifyUtil.m26532a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public TranslationFormatUtil(EmojiUtil emojiUtil, LinkifyUtil linkifyUtil, Resources resources) {
        this.f24373a = emojiUtil;
        this.f24374b = linkifyUtil;
        this.f24375c = resources;
    }

    public final SpannableStringBuilder m32686a(GraphQLTextWithEntities graphQLTextWithEntities) {
        Spannable a = this.f24374b.m26547a(LinkifyUtilConverter.m29874c(graphQLTextWithEntities), true, null);
        CharSequence a2 = (a == null || a.length() == 0) ? graphQLTextWithEntities.mo2911a() : LinkifyUtil.m26533a(a);
        Editable spannableStringBuilder = new SpannableStringBuilder(a2);
        this.f24373a.m27887a(spannableStringBuilder, this.f24375c.getDimensionPixelSize(2131427402));
        return spannableStringBuilder;
    }

    public final String m32687a(GraphQLStory graphQLStory) {
        if (graphQLStory.aL() == null || graphQLStory.aL().m24912o() != GraphQLTranslatabilityType.SEE_CONVERSION) {
            return StringFormatUtil.formatStrLocaleSafe(this.f24375c.getString(2131233619), graphQLStory.aL().m24908k());
        }
        return this.f24375c.getString(2131233620);
    }

    public static TranslationFormatUtil m32684a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TranslationFormatUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24372e) {
                TranslationFormatUtil translationFormatUtil;
                if (a2 != null) {
                    translationFormatUtil = (TranslationFormatUtil) a2.mo818a(f24372e);
                } else {
                    translationFormatUtil = f24371d;
                }
                if (translationFormatUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32685b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24372e, b3);
                        } else {
                            f24371d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = translationFormatUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
