package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwillMessageAndPostPartDefinition */
public class ThrowbackPrivacyLabelPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Spannable, HasPositionInformation, ContentTextView> {
    public static final ViewType f12483a = new C13101();
    private static ThrowbackPrivacyLabelPartDefinition f12484e;
    private static final Object f12485f = new Object();
    private final BackgroundPartDefinition f12486b;
    private final DefaultPrivacyScopeResourceResolver f12487c;
    private final GlyphColorizer f12488d;

    /* compiled from: goodwillMessageAndPostPartDefinition */
    final class C13101 extends ViewType {
        C13101() {
        }

        public final View m14370a(Context context) {
            return new ContentTextView(context);
        }
    }

    private static ThrowbackPrivacyLabelPartDefinition m14375b(InjectorLike injectorLike) {
        return new ThrowbackPrivacyLabelPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPrivacyScopeResourceResolver.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m14377a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        subParts.a(this.f12486b, m14374b(feedProps));
        return m14371a(graphQLGoodwillThrowbackPromotionFeedUnit, this.f12487c, this.f12488d);
    }

    public final /* bridge */ /* synthetic */ void m14378a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1944446989);
        ContentTextView contentTextView = (ContentTextView) view;
        contentTextView.setText((Spannable) obj2);
        contentTextView.setTextSize((float) SizeUtil.c(contentTextView.getContext().getResources(), 2131427400));
        contentTextView.setTextColor(contentTextView.getResources().getColor(2131362053));
        Logger.a(8, EntryType.MARK_POP, 161051999, a);
    }

    public final boolean m14379a(Object obj) {
        return m14373a((FeedProps) obj);
    }

    @Inject
    public ThrowbackPrivacyLabelPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GlyphColorizer glyphColorizer) {
        this.f12486b = backgroundPartDefinition;
        this.f12487c = defaultPrivacyScopeResourceResolver;
        this.f12488d = glyphColorizer;
    }

    public static ThrowbackPrivacyLabelPartDefinition m14372a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPrivacyLabelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12485f) {
                ThrowbackPrivacyLabelPartDefinition throwbackPrivacyLabelPartDefinition;
                if (a2 != null) {
                    throwbackPrivacyLabelPartDefinition = (ThrowbackPrivacyLabelPartDefinition) a2.a(f12485f);
                } else {
                    throwbackPrivacyLabelPartDefinition = f12484e;
                }
                if (throwbackPrivacyLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14375b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12485f, b3);
                        } else {
                            f12484e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPrivacyLabelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14376a() {
        return f12483a;
    }

    public static StylingData m14374b(FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps) {
        return new StylingData(feedProps, PaddingStyle.a, Position.MIDDLE);
    }

    public static Spannable m14371a(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GlyphColorizer glyphColorizer) {
        CharSequence j = graphQLGoodwillThrowbackPromotionFeedUnit.D().j();
        int a = defaultPrivacyScopeResourceResolver.a(graphQLGoodwillThrowbackPromotionFeedUnit.D().s());
        if (a > 0) {
            j = "  " + j;
        }
        Spannable spannableString = new SpannableString(j);
        if (a > 0) {
            Drawable a2 = glyphColorizer.a(a, -7235677);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(a2, 1), 0, 1, 18);
        }
        return spannableString;
    }

    public static boolean m14373a(FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        return (graphQLGoodwillThrowbackPromotionFeedUnit.D() == null || TextUtils.isEmpty(graphQLGoodwillThrowbackPromotionFeedUnit.D().j())) ? false : true;
    }
}
