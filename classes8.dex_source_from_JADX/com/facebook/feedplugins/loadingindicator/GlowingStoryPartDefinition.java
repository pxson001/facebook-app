package com.facebook.feedplugins.loadingindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
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
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_center_search_tab */
public class GlowingStoryPartDefinition<T> extends MultiRowSinglePartDefinition<T, Void, HasPositionInformation, GlowingStoryView> {
    public static final ViewType<GlowingStoryView> f12877a = new C13391();
    private static GlowingStoryPartDefinition f12878c;
    private static final Object f12879d = new Object();
    private final BackgroundPartDefinition f12880b;

    /* compiled from: friends_center_search_tab */
    final class C13391 extends ViewType<GlowingStoryView> {
        C13391() {
        }

        public final View m14626a(Context context) {
            return GlowingStoryPartDefinition.m14628a(context, null);
        }
    }

    private static GlowingStoryPartDefinition m14629b(InjectorLike injectorLike) {
        return new GlowingStoryPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m14632a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1485826074);
        ((GlowingStoryView) view).m14637a();
        Logger.a(8, EntryType.MARK_POP, 1828679043, a);
    }

    public final void m14634b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((GlowingStoryView) view).m14638b();
    }

    @Inject
    public GlowingStoryPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f12880b = backgroundPartDefinition;
    }

    public static GlowingStoryView m14628a(Context context, @Nullable ViewGroup viewGroup) {
        return (GlowingStoryView) LayoutInflater.from(context).inflate(2130904597, viewGroup, false);
    }

    public final ViewType<GlowingStoryView> m14630a() {
        return f12877a;
    }

    public final boolean m14633a(T t) {
        return true;
    }

    public final Object m14631a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12880b, LoadingStory.f12895a);
        return null;
    }

    public static GlowingStoryPartDefinition m14627a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GlowingStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12879d) {
                GlowingStoryPartDefinition glowingStoryPartDefinition;
                if (a2 != null) {
                    glowingStoryPartDefinition = (GlowingStoryPartDefinition) a2.a(f12879d);
                } else {
                    glowingStoryPartDefinition = f12878c;
                }
                if (glowingStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14629b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12879d, b3);
                        } else {
                            f12878c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = glowingStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
