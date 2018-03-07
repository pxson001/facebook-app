package com.facebook.feedplugins.musicstory;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.feedplugins.musicstory.providers.MusicProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition.IconData;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_no_explanation_for_deactivated_target */
public class MusicProviderPartDefinition extends BaseSinglePartDefinition<MusicProvider, Void, AnyEnvironment, ImageWithTextView> {
    private static MusicProviderPartDefinition f8180d;
    private static final Object f8181e = new Object();
    private final ClickListenerPartDefinition f8182a;
    private final ImageWithTextViewDrawablePartDefinition f8183b;
    private final TextPartDefinition f8184c;

    private static MusicProviderPartDefinition m9177b(InjectorLike injectorLike) {
        return new MusicProviderPartDefinition(ClickListenerPartDefinition.a(injectorLike), ImageWithTextViewDrawablePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m9178a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MusicProvider musicProvider = (MusicProvider) obj;
        subParts.a(this.f8182a, musicProvider.mo241b());
        subParts.a(this.f8184c, musicProvider.mo240a());
        subParts.a(this.f8183b, new IconData(musicProvider.mo242c(), null));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9179a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1290554263);
        ((ImageWithTextView) view).setBackgroundResource(((MusicProvider) obj).mo243d());
        Logger.a(8, EntryType.MARK_POP, -683517607, a);
    }

    @Inject
    public MusicProviderPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition, TextPartDefinition textPartDefinition) {
        this.f8182a = clickListenerPartDefinition;
        this.f8183b = imageWithTextViewDrawablePartDefinition;
        this.f8184c = textPartDefinition;
    }

    public static MusicProviderPartDefinition m9176a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicProviderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8181e) {
                MusicProviderPartDefinition musicProviderPartDefinition;
                if (a2 != null) {
                    musicProviderPartDefinition = (MusicProviderPartDefinition) a2.a(f8181e);
                } else {
                    musicProviderPartDefinition = f8180d;
                }
                if (musicProviderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8181e, b3);
                        } else {
                            f8180d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicProviderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
