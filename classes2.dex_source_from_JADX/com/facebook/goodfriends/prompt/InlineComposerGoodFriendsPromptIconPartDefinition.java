package com.facebook.goodfriends.prompt;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptIcon;
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

@ContextScoped
/* compiled from: mqtt/mqtt_connect_hash */
public class InlineComposerGoodFriendsPromptIconPartDefinition<V extends View & HasPromptIcon> extends BaseSinglePartDefinition<OnClickListener, GenericDraweeHierarchy, HasContext, V> {
    private static InlineComposerGoodFriendsPromptIconPartDefinition f13270a;
    private static final Object f13271b = new Object();

    private static InlineComposerGoodFriendsPromptIconPartDefinition m19529a() {
        return new InlineComposerGoodFriendsPromptIconPartDefinition();
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Resources resources = ((HasContext) anyEnvironment).getContext().getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        Drawable drawable = resources.getDrawable(2130837932);
        drawable.setColorFilter(resources.getColor(2131361938), Mode.SRC_IN);
        genericDraweeHierarchyBuilder.f14198f = drawable;
        return genericDraweeHierarchyBuilder.m20571u();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -850747279);
        m19531a((OnClickListener) obj, (GenericDraweeHierarchy) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -29044623, a);
    }

    private static void m19531a(OnClickListener onClickListener, GenericDraweeHierarchy genericDraweeHierarchy, V v) {
        DraweeView iconView = ((HasPromptIcon) v).getIconView();
        iconView.setHierarchy(genericDraweeHierarchy);
        iconView.setOnClickListener(onClickListener);
        ((HasPromptIcon) v).getShimmerContainer().setVisibility(0);
    }

    public static InlineComposerGoodFriendsPromptIconPartDefinition m19530a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerGoodFriendsPromptIconPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13271b) {
                InlineComposerGoodFriendsPromptIconPartDefinition inlineComposerGoodFriendsPromptIconPartDefinition;
                if (a3 != null) {
                    inlineComposerGoodFriendsPromptIconPartDefinition = (InlineComposerGoodFriendsPromptIconPartDefinition) a3.mo818a(f13271b);
                } else {
                    inlineComposerGoodFriendsPromptIconPartDefinition = f13270a;
                }
                if (inlineComposerGoodFriendsPromptIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19529a();
                        if (a3 != null) {
                            a3.mo822a(f13271b, a2);
                        } else {
                            f13270a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = inlineComposerGoodFriendsPromptIconPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((HasPromptIcon) view).getIconView().setOnClickListener(null);
    }
}
