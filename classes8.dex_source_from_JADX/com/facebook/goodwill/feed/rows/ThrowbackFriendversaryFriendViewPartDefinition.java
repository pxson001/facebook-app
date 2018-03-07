package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.timeline.intent.ModelBundle;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb928eec0717d56ef31ffab0984bbccd */
public class ThrowbackFriendversaryFriendViewPartDefinition extends MultiRowSinglePartDefinition<GraphQLUser, State, HasPositionInformation, ContentViewWithButton> {
    public static final ViewType f13706a = new C14551();
    private static ThrowbackFriendversaryFriendViewPartDefinition f13707f;
    private static final Object f13708g = new Object();
    public final FbUriIntentHandler f13709b;
    public final Resources f13710c;
    public final GlyphColorizer f13711d;
    private final ClickListenerPartDefinition f13712e;

    /* compiled from: fb928eec0717d56ef31ffab0984bbccd */
    final class C14551 extends ViewType {
        C14551() {
        }

        public final View m15393a(Context context) {
            return new ContentViewWithButton(context);
        }
    }

    /* compiled from: fb928eec0717d56ef31ffab0984bbccd */
    public class State {
        public final String f13700a;
        public final String f13701b;
        public final String f13702c;
        public final String f13703d;
        public final String f13704e;
        public final OnClickListener f13705f;

        public State(String str, String str2, String str3, String str4, String str5, OnClickListener onClickListener) {
            this.f13700a = str;
            this.f13701b = str2;
            this.f13704e = str5;
            this.f13702c = str3;
            this.f13703d = str4;
            this.f13705f = onClickListener;
        }
    }

    private static ThrowbackFriendversaryFriendViewPartDefinition m15395b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryFriendViewPartDefinition(FbUriIntentHandler.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m15397a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String b;
        String string;
        String string2;
        final GraphQLUser graphQLUser = (GraphQLUser) obj;
        String ar = graphQLUser.ar();
        String a = graphQLUser.o() != null ? graphQLUser.o().a() : null;
        if (graphQLUser.aI() != null) {
            b = graphQLUser.aI().b();
        } else {
            b = null;
        }
        if (graphQLUser.ar() != null) {
            string = this.f13710c.getString(2131239660, new Object[]{graphQLUser.ar()});
        } else {
            string = null;
        }
        if (graphQLUser.ar() != null) {
            string2 = this.f13710c.getString(2131239658, new Object[]{graphQLUser.ar()});
        } else {
            string2 = null;
        }
        OnClickListener c14562 = new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryFriendViewPartDefinition f13696b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1224839357);
                this.f13696b.f13709b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.V, graphQLUser.P()));
                Logger.a(2, EntryType.UI_INPUT_END, -110538761, a);
            }
        };
        subParts.a(this.f13712e, new OnClickListener(this) {
            final /* synthetic */ ThrowbackFriendversaryFriendViewPartDefinition f13699c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 402132663);
                ThrowbackFriendversaryFriendViewPartDefinition throwbackFriendversaryFriendViewPartDefinition = this.f13699c;
                GraphQLUser graphQLUser = graphQLUser;
                String str = b;
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, graphQLUser.P());
                Bundle bundle = new Bundle();
                ModelBundle.a(bundle, String.valueOf(graphQLUser.P()), str, graphQLUser.ar(), null, null);
                throwbackFriendversaryFriendViewPartDefinition.f13709b.a(view.getContext(), formatStrLocaleSafe, bundle);
                Logger.a(2, EntryType.UI_INPUT_END, 1882184634, a);
            }
        });
        return new State(ar, a, string, string2, b, c14562);
    }

    public final /* bridge */ /* synthetic */ void m15398a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 486430920);
        State state = (State) obj2;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setTitleText(state.f13700a);
        contentViewWithButton.setThumbnailUri(state.f13704e);
        contentViewWithButton.setThumbnailSize(ThumbnailSize.LARGE);
        contentViewWithButton.setActionButtonDrawable(this.f13711d.a(2130839685, -5066062));
        contentViewWithButton.setActionButtonBackground(this.f13710c.getDrawable(2130839797));
        contentViewWithButton.setContentDescription(state.f13702c);
        contentViewWithButton.setActionButtonContentDescription(state.f13703d);
        contentViewWithButton.setFocusable(true);
        contentViewWithButton.setSubtitleText(state.f13701b);
        contentViewWithButton.setSubtitleTextAppearance(2131626279);
        contentViewWithButton.setActionButtonBackground(null);
        contentViewWithButton.setActionButtonOnClickListener(state.f13705f);
        Logger.a(8, EntryType.MARK_POP, 382394339, a);
    }

    public final void m15400b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ContentViewWithButton) view).setActionButtonOnClickListener(null);
    }

    public static ThrowbackFriendversaryFriendViewPartDefinition m15394a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryFriendViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13708g) {
                ThrowbackFriendversaryFriendViewPartDefinition throwbackFriendversaryFriendViewPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryFriendViewPartDefinition = (ThrowbackFriendversaryFriendViewPartDefinition) a2.a(f13708g);
                } else {
                    throwbackFriendversaryFriendViewPartDefinition = f13707f;
                }
                if (throwbackFriendversaryFriendViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15395b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13708g, b3);
                        } else {
                            f13707f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryFriendViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackFriendversaryFriendViewPartDefinition(FbUriIntentHandler fbUriIntentHandler, Resources resources, GlyphColorizer glyphColorizer, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f13709b = fbUriIntentHandler;
        this.f13710c = resources;
        this.f13711d = glyphColorizer;
        this.f13712e = clickListenerPartDefinition;
    }

    public final ViewType m15396a() {
        return f13706a;
    }

    public final boolean m15399a(Object obj) {
        return true;
    }
}
