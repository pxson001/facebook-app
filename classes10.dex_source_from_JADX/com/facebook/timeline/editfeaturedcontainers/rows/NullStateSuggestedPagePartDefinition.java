package com.facebook.timeline.editfeaturedcontainers.rows;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
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
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSuggestionModel;
import com.facebook.timeline.editfeaturedcontainers.ui.AddFeaturedEntityActivity;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: getItem call on non-invitee row is not supported */
public class NullStateSuggestedPagePartDefinition extends MultiRowSinglePartDefinition<FeaturedPageSuggestionModel, Void, AnyEnvironment, CustomLinearLayout> {
    public static final ViewType<CustomLinearLayout> f10846a = new C15711();
    private static NullStateSuggestedPagePartDefinition f10847h;
    private static final Object f10848i = new Object();
    private final ContentViewTitlePartDefinition f10849b;
    private final ContentViewSubtitlePartDefinition f10850c;
    private final ContentViewThumbnailUriPartDefinition f10851d;
    private final ClickListenerPartDefinition f10852e;
    public final RTLUtil f10853f;
    public final Provider<SecureContextHelper> f10854g;

    /* compiled from: getItem call on non-invitee row is not supported */
    final class C15711 extends ViewType<CustomLinearLayout> {
        C15711() {
        }

        public final View m10967a(Context context) {
            return (CustomLinearLayout) LayoutInflater.from(context).inflate(2130905509, null);
        }
    }

    private static NullStateSuggestedPagePartDefinition m10969b(InjectorLike injectorLike) {
        return new NullStateSuggestedPagePartDefinition(ContentViewTitlePartDefinition.a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewThumbnailUriPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), RTLUtil.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968));
    }

    public final Object m10971a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Uri uri;
        FeaturedPageSuggestionModel featuredPageSuggestionModel = (FeaturedPageSuggestionModel) obj;
        final String a = featuredPageSuggestionModel.m10857k() == null ? null : featuredPageSuggestionModel.m10857k().m10852a();
        subParts.a(2131559680, this.f10849b, a);
        subParts.a(2131559680, this.f10850c, featuredPageSuggestionModel.m10856j() == null ? null : featuredPageSuggestionModel.m10856j().m10847a());
        ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition = this.f10851d;
        if (featuredPageSuggestionModel.m10855a() == null || featuredPageSuggestionModel.m10855a().m10841j() == null || featuredPageSuggestionModel.m10855a().m10841j().b() == null) {
            uri = null;
        } else {
            uri = Uri.parse(featuredPageSuggestionModel.m10855a().m10841j().b());
        }
        subParts.a(2131559680, contentViewThumbnailUriPartDefinition, uri);
        subParts.a(this.f10852e, new OnClickListener(this) {
            final /* synthetic */ NullStateSuggestedPagePartDefinition f10845b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 572025579);
                ((SecureContextHelper) this.f10845b.f10854g.get()).a(AddFeaturedEntityActivity.m11049a(view.getContext(), a), 3, (Activity) ContextUtils.a(view.getContext(), Activity.class));
                Logger.a(2, EntryType.UI_INPUT_END, 1350521037, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10972a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1447611619);
        GlyphView glyphView = (GlyphView) ((CustomLinearLayout) view).findViewById(2131558965);
        if (this.f10853f.a()) {
            glyphView.setImageResource(2130839783);
        } else {
            glyphView.setImageResource(2130839786);
        }
        Logger.a(8, EntryType.MARK_POP, -261923548, a);
    }

    public static NullStateSuggestedPagePartDefinition m10968a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSuggestedPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10848i) {
                NullStateSuggestedPagePartDefinition nullStateSuggestedPagePartDefinition;
                if (a2 != null) {
                    nullStateSuggestedPagePartDefinition = (NullStateSuggestedPagePartDefinition) a2.a(f10848i);
                } else {
                    nullStateSuggestedPagePartDefinition = f10847h;
                }
                if (nullStateSuggestedPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10969b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10848i, b3);
                        } else {
                            f10847h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSuggestedPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NullStateSuggestedPagePartDefinition(ContentViewTitlePartDefinition contentViewTitlePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, RTLUtil rTLUtil, Provider<SecureContextHelper> provider) {
        this.f10849b = contentViewTitlePartDefinition;
        this.f10850c = contentViewSubtitlePartDefinition;
        this.f10851d = contentViewThumbnailUriPartDefinition;
        this.f10852e = clickListenerPartDefinition;
        this.f10853f = rTLUtil;
        this.f10854g = provider;
    }

    public final boolean m10973a(Object obj) {
        return true;
    }

    public final ViewType<CustomLinearLayout> m10970a() {
        return f10846a;
    }
}
