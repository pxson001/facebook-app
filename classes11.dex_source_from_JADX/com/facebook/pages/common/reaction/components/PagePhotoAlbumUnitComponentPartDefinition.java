package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
import com.facebook.pages.common.reaction.components.PageAlbumCoverPhotoPartDefinition.CoverPhoto;
import com.facebook.pages.common.reaction.components.PageAlbumCoverPhotoPartDefinition.Props;
import com.facebook.pages.common.reaction.components.PageAlbumCoverPhotoPartDefinition.ResourceIdCoverPhoto;
import com.facebook.pages.common.reaction.components.PageAlbumCoverPhotoPartDefinition.UriCoverPhoto;
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PagePhotoAlbumComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitPagePhotoAlbumComponentFragmentModel.AlbumModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: session_start_time_ms */
public class PagePhotoAlbumUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PagePhotoAlbumComponentView> {
    public static final CallerContext f1993a = CallerContext.a(PagePhotoAlbumUnitComponentPartDefinition.class, "pages_public_view");
    public static final ViewType f1994b = new C02601();
    private static PagePhotoAlbumUnitComponentPartDefinition f1995f;
    private static final Object f1996g = new Object();
    private final PageAlbumCoverPhotoPartDefinition f1997c;
    private final TextPartDefinition f1998d;
    private final PagesSurfaceReactionHelper<E> f1999e;

    /* compiled from: session_start_time_ms */
    final class C02601 extends ViewType {
        C02601() {
        }

        public final View m3037a(Context context) {
            return new PagePhotoAlbumComponentView(context);
        }
    }

    /* compiled from: session_start_time_ms */
    public class State {
        public final OnClickListener f1992a;

        public State(OnClickListener onClickListener) {
            this.f1992a = onClickListener;
        }
    }

    private static PagePhotoAlbumUnitComponentPartDefinition m3040b(InjectorLike injectorLike) {
        return new PagePhotoAlbumUnitComponentPartDefinition(PageAlbumCoverPhotoPartDefinition.m2924a(injectorLike), TextPartDefinition.a(injectorLike), PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3042a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CoverPhoto uriCoverPhoto;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        int i = 0;
        AlbumModel x = reactionUnitComponentNode.b.x();
        int i2 = (x.b() == null || x.b().c() == null || StringUtil.a(x.b().c().a())) ? 0 : 1;
        if (i2 != 0) {
            uriCoverPhoto = new UriCoverPhoto(x.b().c().a(), f1993a, 1.0f, ScaleType.CENTER_CROP);
        } else {
            uriCoverPhoto = new ResourceIdCoverPhoto(2130839460, 1.0f, ScaleType.CENTER_CROP);
        }
        subParts.a(2131565634, this.f1997c, new Props(uriCoverPhoto));
        if (x.go_() == null || StringUtil.a(x.go_().a())) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        subParts.a(2131565635, this.f1998d, i2 != 0 ? x.go_().a() : "");
        if (x.d() != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            i = x.d().a();
        }
        subParts.a(2131565636, this.f1998d, m3039a(i, ((HasContext) canLaunchReactionIntent).getContext()));
        return new State(this.f1999e.m3152a(reactionUnitComponentNode.b.v(), canLaunchReactionIntent, reactionUnitComponentNode.d, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3043a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2022102197);
        ((PagePhotoAlbumComponentView) view).setOnClickListener(((State) obj2).f1992a);
        Logger.a(8, EntryType.MARK_POP, -1456446267, a);
    }

    public final boolean m3044a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode == null || reactionUnitComponentNode.b == null || reactionUnitComponentNode.b.x() == null) ? false : true;
    }

    public final void m3045b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PagePhotoAlbumComponentView) view).setOnClickListener(null);
    }

    public static PagePhotoAlbumUnitComponentPartDefinition m3038a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagePhotoAlbumUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1996g) {
                PagePhotoAlbumUnitComponentPartDefinition pagePhotoAlbumUnitComponentPartDefinition;
                if (a2 != null) {
                    pagePhotoAlbumUnitComponentPartDefinition = (PagePhotoAlbumUnitComponentPartDefinition) a2.a(f1996g);
                } else {
                    pagePhotoAlbumUnitComponentPartDefinition = f1995f;
                }
                if (pagePhotoAlbumUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3040b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1996g, b3);
                        } else {
                            f1995f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagePhotoAlbumUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagePhotoAlbumUnitComponentPartDefinition(PageAlbumCoverPhotoPartDefinition pageAlbumCoverPhotoPartDefinition, TextPartDefinition textPartDefinition, PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1997c = pageAlbumCoverPhotoPartDefinition;
        this.f1998d = textPartDefinition;
        this.f1999e = pagesSurfaceReactionHelper;
    }

    public final ViewType m3041a() {
        return f1994b;
    }

    private static String m3039a(int i, Context context) {
        if (i == 0) {
            return context.getResources().getString(2131234347);
        }
        if (i > 0) {
            return context.getResources().getQuantityString(2131689584, i, new Object[]{Integer.valueOf(i)});
        }
        throw new IllegalArgumentException("Invalid album size " + i);
    }
}
