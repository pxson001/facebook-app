package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.pages.common.reaction.components.PageAlbumCoverPhotoPartDefinition.Props;
import com.facebook.pages.common.reaction.components.PageAlbumCoverPhotoPartDefinition.ResourceIdCoverPhoto;
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PagePhotoAlbumComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsInlineSproutsOpen */
public class PageCreatePhotoAlbumUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PagePhotoAlbumComponentView> {
    public static final ViewType f1905a = new C02491();
    private static PageCreatePhotoAlbumUnitComponentPartDefinition f1906e;
    private static final Object f1907f = new Object();
    private final PageAlbumCoverPhotoPartDefinition f1908b;
    private final TextPartDefinition f1909c;
    private final PagesSurfaceReactionHelper<E> f1910d;

    /* compiled from: setIsInlineSproutsOpen */
    final class C02491 extends ViewType {
        C02491() {
        }

        public final View m2950a(Context context) {
            PagePhotoAlbumComponentView pagePhotoAlbumComponentView = new PagePhotoAlbumComponentView(context);
            BetterTextView betterTextView = (BetterTextView) FindViewUtil.b(pagePhotoAlbumComponentView, 2131565635);
            betterTextView.setEllipsize(null);
            betterTextView.setSingleLine(false);
            return pagePhotoAlbumComponentView;
        }
    }

    /* compiled from: setIsInlineSproutsOpen */
    public class State {
        public final OnClickListener f1904a;

        public State(OnClickListener onClickListener) {
            this.f1904a = onClickListener;
        }
    }

    private static PageCreatePhotoAlbumUnitComponentPartDefinition m2952b(InjectorLike injectorLike) {
        return new PageCreatePhotoAlbumUnitComponentPartDefinition(PageAlbumCoverPhotoPartDefinition.m2924a(injectorLike), TextPartDefinition.a(injectorLike), PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2954a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        subParts.a(2131565634, this.f1908b, new Props(new ResourceIdCoverPhoto(2130837631, 1.0f, ScaleType.CENTER_INSIDE)));
        subParts.a(2131565635, this.f1909c, ((HasContext) canLaunchReactionIntent).getContext().getResources().getString(2131234349));
        subParts.a(2131565636, this.f1909c, "");
        return new State(this.f1910d.m3152a(reactionUnitComponentNode.b.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2955a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -370154696);
        ((PagePhotoAlbumComponentView) view).setOnClickListener(((State) obj2).f1904a);
        Logger.a(8, EntryType.MARK_POP, 611843093, a);
    }

    public final void m2957b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PagePhotoAlbumComponentView) view).setOnClickListener(null);
    }

    public static PageCreatePhotoAlbumUnitComponentPartDefinition m2951a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageCreatePhotoAlbumUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1907f) {
                PageCreatePhotoAlbumUnitComponentPartDefinition pageCreatePhotoAlbumUnitComponentPartDefinition;
                if (a2 != null) {
                    pageCreatePhotoAlbumUnitComponentPartDefinition = (PageCreatePhotoAlbumUnitComponentPartDefinition) a2.a(f1907f);
                } else {
                    pageCreatePhotoAlbumUnitComponentPartDefinition = f1906e;
                }
                if (pageCreatePhotoAlbumUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2952b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1907f, b3);
                        } else {
                            f1906e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageCreatePhotoAlbumUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageCreatePhotoAlbumUnitComponentPartDefinition(PageAlbumCoverPhotoPartDefinition pageAlbumCoverPhotoPartDefinition, TextPartDefinition textPartDefinition, PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1908b = pageAlbumCoverPhotoPartDefinition;
        this.f1909c = textPartDefinition;
        this.f1910d = pagesSurfaceReactionHelper;
    }

    public final ViewType m2953a() {
        return f1905a;
    }

    public final boolean m2956a(Object obj) {
        return true;
    }
}
