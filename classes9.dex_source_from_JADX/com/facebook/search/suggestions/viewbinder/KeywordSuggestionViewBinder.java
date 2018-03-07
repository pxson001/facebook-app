package com.facebook.search.suggestions.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.facebook.search.util.keyword.KeywordSpanFactory;
import com.facebook.search.util.keyword.KeywordSuggestionHighlightingUtil;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: view_attribution_link */
public class KeywordSuggestionViewBinder {
    private static final CallerContext f361a = CallerContext.a(KeywordSuggestionViewBinder.class, "search_typeahead");
    private static final KeywordSpanFactory f362b = new C00351();
    private static final KeywordSpanFactory f363c = new C00362();
    private static final KeywordSpanFactory f364d = new C00373();
    private static KeywordSuggestionViewBinder f365o;
    private static final Object f366p = new Object();
    private final Resources f367e;
    private final GlyphColorizer f368f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<KeywordSuggestionHighlightingUtil> f369g = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GraphSearchTitleSearchBoxSupplier> f370h = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<TypeaheadRowTitleFormatter> f371i = UltralightRuntime.b;
    private final QeAccessor f372j;
    private final GatekeeperStoreImpl f373k;
    public final boolean f374l;
    private final ImmutableList<KeywordSpanFactory> f375m;
    private final ImmutableList<KeywordSpanFactory> f376n;

    /* compiled from: view_attribution_link */
    final class C00351 implements KeywordSpanFactory {
        C00351() {
        }

        public final Object m490a() {
            return new StyleSpan(1);
        }
    }

    /* compiled from: view_attribution_link */
    final class C00362 implements KeywordSpanFactory {
        C00362() {
        }

        public final Object m491a() {
            return new ForegroundColorSpan(-11508323);
        }
    }

    /* compiled from: view_attribution_link */
    final class C00373 implements KeywordSpanFactory {
        C00373() {
        }

        public final Object m492a() {
            return new BackgroundColorSpan(-789000);
        }
    }

    private static KeywordSuggestionViewBinder m497b(InjectorLike injectorLike) {
        KeywordSuggestionViewBinder keywordSuggestionViewBinder = new KeywordSuggestionViewBinder(ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 10946);
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 10835);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 10943);
        keywordSuggestionViewBinder.f369g = b;
        keywordSuggestionViewBinder.f370h = a;
        keywordSuggestionViewBinder.f371i = b2;
        return keywordSuggestionViewBinder;
    }

    public static KeywordSuggestionViewBinder m493a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            KeywordSuggestionViewBinder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f366p) {
                KeywordSuggestionViewBinder keywordSuggestionViewBinder;
                if (a2 != null) {
                    keywordSuggestionViewBinder = (KeywordSuggestionViewBinder) a2.a(f366p);
                } else {
                    keywordSuggestionViewBinder = f365o;
                }
                if (keywordSuggestionViewBinder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m497b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f366p, b3);
                        } else {
                            f365o = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = keywordSuggestionViewBinder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public KeywordSuggestionViewBinder(Resources resources, GlyphColorizer glyphColorizer, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f367e = resources;
        this.f368f = glyphColorizer;
        this.f374l = !TextUtils.equals(qeAccessor.a(ExperimentsForSearchAbTestModule.bz, "0"), "0");
        this.f372j = qeAccessor;
        this.f373k = gatekeeperStoreImpl;
        this.f375m = RegularImmutableList.a;
        this.f376n = ImmutableList.of(f362b);
    }

    public final void m503a(ContentView contentView, KeywordTypeaheadUnit keywordTypeaheadUnit) {
        Context context = contentView.getContext();
        if (StringUtil.a(keywordTypeaheadUnit.a()) || (CollectionUtil.b(keywordTypeaheadUnit.f()) && keywordTypeaheadUnit.f().get(0) == GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS)) {
            contentView.setShowThumbnail(false);
        } else {
            m496a(contentView, m501a(contentView.getContext(), keywordTypeaheadUnit.g, keywordTypeaheadUnit.x()));
            contentView.setShowThumbnail(true);
        }
        contentView.setTitleText(m498b(keywordTypeaheadUnit));
        int i = keywordTypeaheadUnit.g.equals(KeywordType.escape) ? keywordTypeaheadUnit.x() ? 2131625910 : 2131625908 : keywordTypeaheadUnit.g.equals(KeywordType.escape_pps_style) ? 2131625909 : keywordTypeaheadUnit.x() ? 2131625905 : 2131625904;
        contentView.setTitleTextAppearance(i);
        contentView.setTitleGravity(contentView.getLocaleGravity());
        CharSequence a = m494a(context, keywordTypeaheadUnit);
        if (a != null) {
            contentView.setSubtitleTextAppearance(keywordTypeaheadUnit.x() ? 2131625913 : 2131625911);
            contentView.setSubtitleGravity(contentView.getLocaleGravity());
            contentView.setSubtitleText(a);
            contentView.setMaxLinesFromThumbnailSize(false);
            contentView.e(1, 1);
            return;
        }
        contentView.setSubtitleText(null);
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.e(1, 0);
    }

    public final void m502a(ContentView contentView, Spanned spanned, Drawable drawable) {
        m496a(contentView, drawable);
        contentView.setTitleText(spanned);
        contentView.setTitleTextAppearance(2131625904);
        contentView.setTitleGravity(contentView.getLocaleGravity());
    }

    private CharSequence m498b(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        boolean z = false;
        CharSequence c = m499c(keywordTypeaheadUnit);
        if (keywordTypeaheadUnit.z && this.f373k.a(SearchAbTestGatekeepers.s, false)) {
            z = true;
        }
        if (!z) {
            return c;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c);
        ((TypeaheadRowTitleFormatter) this.f371i.get()).b(spannableStringBuilder);
        return spannableStringBuilder;
    }

    private CharSequence m499c(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        if (keywordTypeaheadUnit.g.equals(KeywordType.escape)) {
            return new SpannableString(Html.fromHtml(this.f367e.getString(2131237438, new Object[]{m495a()})));
        } else if (keywordTypeaheadUnit.g.equals(KeywordType.escape_pps_style)) {
            return new SpannableString(Html.fromHtml(this.f367e.getString(2131237439, new Object[]{m495a()})));
        } else if (keywordTypeaheadUnit.x()) {
            return keywordTypeaheadUnit.a();
        } else {
            return ((KeywordSuggestionHighlightingUtil) this.f369g.get()).a(keywordTypeaheadUnit.a(), m495a(), this.f375m, this.f376n);
        }
    }

    @Nullable
    private CharSequence m494a(Context context, KeywordTypeaheadUnit keywordTypeaheadUnit) {
        if (Strings.isNullOrEmpty(keywordTypeaheadUnit.r) && Strings.isNullOrEmpty(keywordTypeaheadUnit.q)) {
            return null;
        }
        CharSequence string;
        if (keywordTypeaheadUnit.x) {
            string = this.f367e.getString(2131236534);
        } else {
            string = " ";
        }
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(string);
        if (!Strings.isNullOrEmpty(keywordTypeaheadUnit.r)) {
            int i;
            KeywordType keywordType = keywordTypeaheadUnit.g;
            if (this.f374l && keywordType != null && KeywordSuggestionAppearanceResolver.f360k.contains(keywordType)) {
                i = KeywordSuggestionAppearanceResolver.f359j;
            } else {
                Integer num = (Integer) KeywordSuggestionAppearanceResolver.f356g.get(keywordType);
                i = num != null ? num.intValue() : KeywordSuggestionAppearanceResolver.f357h;
            }
            Object textAppearanceSpan = new TextAppearanceSpan(context, i);
            if (keywordTypeaheadUnit.x()) {
                textAppearanceSpan = new TextAppearanceSpan(textAppearanceSpan.getFamily(), textAppearanceSpan.getTextStyle(), textAppearanceSpan.getTextSize(), textAppearanceSpan.getTextColor().withAlpha(153), textAppearanceSpan.getLinkTextColor());
            }
            separatedSpannableStringBuilder.a(keywordTypeaheadUnit.r, textAppearanceSpan, 17);
        }
        if (!Strings.isNullOrEmpty(keywordTypeaheadUnit.q)) {
            separatedSpannableStringBuilder.a(keywordTypeaheadUnit.q);
        }
        return separatedSpannableStringBuilder;
    }

    public final Drawable m501a(Context context, KeywordType keywordType, boolean z) {
        int intValue = (this.f374l && keywordType != null && KeywordSuggestionAppearanceResolver.f360k.contains(keywordType)) ? KeywordSuggestionAppearanceResolver.f358i : KeywordSuggestionAppearanceResolver.f351b.containsKey(keywordType) ? ((Integer) KeywordSuggestionAppearanceResolver.f351b.get(keywordType)).intValue() : KeywordSuggestionAppearanceResolver.f352c;
        int i = intValue;
        GlyphColorizer glyphColorizer = this.f368f;
        if (this.f374l && keywordType != null && KeywordSuggestionAppearanceResolver.f360k.contains(keywordType)) {
            intValue = -12953448;
        } else {
            Integer num = (Integer) KeywordSuggestionAppearanceResolver.f355f.get(keywordType);
            intValue = num != null ? num.intValue() : -12953448;
        }
        return m500a(context, glyphColorizer.a(i, intValue), z);
    }

    public final Drawable m500a(Context context, Drawable drawable, boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(this.f367e.getDrawable(2130841016));
        arrayList.add(drawable);
        if (z) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130773624, typedValue, true);
            arrayList.add(this.f368f.a(this.f367e.getDrawable(2130841015), (typedValue.data & 16777215) | -1728053248));
        }
        return new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
    }

    private void m496a(ContentView contentView, Drawable drawable) {
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        contentView.setThumbnailDrawable(drawable);
        contentView.setThumbnailPadding(this.f367e.getDimensionPixelSize(2131431729));
        contentView.setPadding(contentView.getPaddingLeft(), this.f367e.getDimensionPixelSize(2131431730), contentView.getPaddingRight(), this.f367e.getDimensionPixelSize(2131431730));
        contentView.setThumbnailGravity(16);
    }

    private String m495a() {
        return ((GraphSearchTitleSearchBoxSupplier) this.f370h.get()).a.e != null ? ((GraphSearchTitleSearchBoxSupplier) this.f370h.get()).a.e.getText().toString() : "";
    }
}
