package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLUser;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: feedUnit */
public class ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition extends MultiRowSinglePartDefinition<ThrowbackFriendversaryAggregatedFriendListProps, State, HasPositionInformation, ContentViewWithButton> {
    public static final ViewType f13602a = new C14441();
    private static ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition f13603e;
    private static final Object f13604f = new Object();
    public final FbUriIntentHandler f13605b;
    public final Resources f13606c;
    public final GlyphColorizer f13607d;

    /* compiled from: feedUnit */
    final class C14441 extends ViewType {
        C14441() {
        }

        public final View m15340a(Context context) {
            return new ContentViewWithButton(context);
        }
    }

    /* compiled from: feedUnit */
    public class State {
        public final String f13596a;
        public final String f13597b;
        public final String f13598c;
        public final String f13599d;
        public final String f13600e;
        public final OnClickListener f13601f;

        public State(String str, String str2, String str3, String str4, String str5, OnClickListener onClickListener) {
            this.f13596a = str;
            this.f13597b = str2;
            this.f13600e = str5;
            this.f13598c = str3;
            this.f13599d = str4;
            this.f13601f = onClickListener;
        }
    }

    private static ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition m15342b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition(FbUriIntentHandler.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m15344a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String b;
        String string;
        String str;
        ThrowbackFriendversaryAggregatedFriendListProps throwbackFriendversaryAggregatedFriendListProps = (ThrowbackFriendversaryAggregatedFriendListProps) obj;
        final GraphQLUser graphQLUser = throwbackFriendversaryAggregatedFriendListProps.f13627b;
        String ar = graphQLUser.ar();
        String a = throwbackFriendversaryAggregatedFriendListProps.m15355b() != null ? throwbackFriendversaryAggregatedFriendListProps.m15355b().a() : null;
        if (graphQLUser.aI() != null) {
            b = graphQLUser.aI().b();
        } else {
            b = null;
        }
        if (graphQLUser.ar() != null) {
            string = this.f13606c.getString(2131239660, new Object[]{graphQLUser.ar()});
        } else {
            string = null;
        }
        if (TextUtils.isEmpty(graphQLUser.ar())) {
            str = null;
        } else {
            str = this.f13606c.getString(2131239658, new Object[]{graphQLUser.ar()});
        }
        return new State(ar, a, string, str, b, new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition f13595b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1202579234);
                this.f13595b.f13605b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.V, graphQLUser.P()));
                Logger.a(2, EntryType.UI_INPUT_END, 680473264, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m15345a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2095363168);
        State state = (State) obj2;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setTitleText(state.f13596a);
        contentViewWithButton.setThumbnailUri(state.f13600e);
        contentViewWithButton.setThumbnailSize(ThumbnailSize.LARGE);
        contentViewWithButton.setActionButtonDrawable(this.f13607d.a(2130839685, -5066062));
        contentViewWithButton.setActionButtonBackground(this.f13606c.getDrawable(2130839797));
        contentViewWithButton.setContentDescription(state.f13598c);
        contentViewWithButton.setActionButtonContentDescription(state.f13599d);
        contentViewWithButton.setSubtitleText(state.f13597b);
        contentViewWithButton.setSubtitleTextAppearance(2131626279);
        contentViewWithButton.setActionButtonOnClickListener(state.f13601f);
        Logger.a(8, EntryType.MARK_POP, 647215003, a);
    }

    public final boolean m15346a(Object obj) {
        return ((ThrowbackFriendversaryAggregatedFriendListProps) obj).f13627b != null;
    }

    public final void m15347b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        super.b((ThrowbackFriendversaryAggregatedFriendListProps) obj, (State) obj2, (HasPositionInformation) anyEnvironment, contentViewWithButton);
        contentViewWithButton.setActionButtonOnClickListener(null);
    }

    public static ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition m15341a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13604f) {
                ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition throwbackFriendversaryAggregatedFriendListFriendPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryAggregatedFriendListFriendPartDefinition = (ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition) a2.a(f13604f);
                } else {
                    throwbackFriendversaryAggregatedFriendListFriendPartDefinition = f13603e;
                }
                if (throwbackFriendversaryAggregatedFriendListFriendPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15342b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13604f, b3);
                        } else {
                            f13603e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryAggregatedFriendListFriendPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition(FbUriIntentHandler fbUriIntentHandler, Resources resources, GlyphColorizer glyphColorizer) {
        this.f13605b = fbUriIntentHandler;
        this.f13606c = resources;
        this.f13607d = glyphColorizer;
    }

    public final ViewType m15343a() {
        return f13602a;
    }
}
