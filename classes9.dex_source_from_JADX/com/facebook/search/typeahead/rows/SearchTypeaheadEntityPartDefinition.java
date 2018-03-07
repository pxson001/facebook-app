package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: verify */
public class SearchTypeaheadEntityPartDefinition extends MultiRowSinglePartDefinition<EntityTypeaheadUnit, State, AnyEnvironment, ContentView> {
    public static final ViewType<ContentView> f511a = ViewType.a(2130907118);
    private static SearchTypeaheadEntityPartDefinition f512f;
    private static final Object f513g = new Object();
    private final Context f514b;
    private final TypeaheadRowTitleFormatter f515c;
    private final QeAccessor f516d;
    private final GatekeeperStoreImpl f517e;

    /* compiled from: verify */
    public class State {
        public final String f505a;
        public final int f506b;
        public final int f507c;
        public final int f508d;
        public final CharSequence f509e;
        public final CharSequence f510f;

        public State(String str, int i, int i2, int i3, CharSequence charSequence, CharSequence charSequence2) {
            this.f505a = str;
            this.f506b = i;
            this.f507c = i2;
            this.f509e = charSequence;
            this.f510f = charSequence2;
            this.f508d = i3;
        }
    }

    private static SearchTypeaheadEntityPartDefinition m612b(InjectorLike injectorLike) {
        return new SearchTypeaheadEntityPartDefinition((Context) injectorLike.getInstance(Context.class), TypeaheadRowTitleFormatter.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m615a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        String uri;
        EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) obj;
        if (entityTypeaheadUnit.d == null || entityTypeaheadUnit.d.equals(Uri.EMPTY)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            uri = entityTypeaheadUnit.d.toString();
        } else {
            uri = null;
        }
        return new State(uri, this.f514b.getResources().getDimensionPixelSize(2131431729), this.f514b.getResources().getDimensionPixelSize(2131431730), -1, m611a(this.f515c, entityTypeaheadUnit, this.f517e), m613c(entityTypeaheadUnit));
    }

    public final /* bridge */ /* synthetic */ void m616a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1469032067);
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailUri(state.f505a);
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        contentView.setThumbnailPadding(state.f506b);
        contentView.setThumbnailGravity(16);
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.e(1, 1);
        contentView.setTitleText(state.f509e);
        contentView.setTitleTextAppearance(2131625904);
        contentView.setSubtitleText(state.f510f);
        contentView.setSubtitleTextAppearance(2131625912);
        if (state.f508d != -1) {
            contentView.setPadding(state.f508d, state.f507c, state.f508d, state.f507c);
        } else {
            contentView.setPadding(contentView.getPaddingLeft(), state.f507c, contentView.getPaddingRight(), state.f507c);
        }
        Logger.a(8, EntryType.MARK_POP, 547247067, a);
    }

    public static SearchTypeaheadEntityPartDefinition m610a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEntityPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f513g) {
                SearchTypeaheadEntityPartDefinition searchTypeaheadEntityPartDefinition;
                if (a2 != null) {
                    searchTypeaheadEntityPartDefinition = (SearchTypeaheadEntityPartDefinition) a2.a(f513g);
                } else {
                    searchTypeaheadEntityPartDefinition = f512f;
                }
                if (searchTypeaheadEntityPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m612b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f513g, b3);
                        } else {
                            f512f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEntityPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchTypeaheadEntityPartDefinition(Context context, TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f514b = context;
        this.f515c = typeaheadRowTitleFormatter;
        this.f516d = qeAccessor;
        this.f517e = gatekeeperStoreImpl;
    }

    public final ViewType<ContentView> m614a() {
        return f511a;
    }

    public final boolean m617a(Object obj) {
        return true;
    }

    @Nullable
    public static String m613c(EntityTypeaheadUnit entityTypeaheadUnit) {
        if (!Strings.isNullOrEmpty(entityTypeaheadUnit.f)) {
            Object obj = 1;
            if (!(entityTypeaheadUnit.c == null || Strings.isNullOrEmpty(entityTypeaheadUnit.e))) {
                int g = entityTypeaheadUnit.c.g();
                if (g == 2645995 || g == 2479791 || g == 77195495) {
                    obj = null;
                }
            }
            if (obj != null) {
                return entityTypeaheadUnit.f;
            }
        }
        if (Strings.isNullOrEmpty(entityTypeaheadUnit.e)) {
            return null;
        }
        return entityTypeaheadUnit.e;
    }

    public static CharSequence m611a(TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, EntityTypeaheadUnit entityTypeaheadUnit, GatekeeperStoreImpl gatekeeperStoreImpl) {
        boolean z = false;
        CharSequence charSequence = entityTypeaheadUnit.b;
        GraphQLPageVerificationBadge graphQLPageVerificationBadge = entityTypeaheadUnit.h;
        boolean z2 = (GraphQLPageVerificationBadge.NOT_VERIFIED.equals(graphQLPageVerificationBadge) || GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.equals(graphQLPageVerificationBadge)) ? false : true;
        if (entityTypeaheadUnit.o && gatekeeperStoreImpl.a(SearchAbTestGatekeepers.s, false)) {
            z = true;
        }
        if (!z2 && !z && !entityTypeaheadUnit.l) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (z2) {
            typeaheadRowTitleFormatter.a(spannableStringBuilder, graphQLPageVerificationBadge);
        }
        if (z) {
            typeaheadRowTitleFormatter.b(spannableStringBuilder);
        }
        if (entityTypeaheadUnit.l) {
            boolean z3 = BuildConstants.i;
        }
        return spannableStringBuilder;
    }
}
