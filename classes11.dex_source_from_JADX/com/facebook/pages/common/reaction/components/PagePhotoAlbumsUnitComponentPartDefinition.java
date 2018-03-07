package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.profile.TimelinePhotoEditMode;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.reaction.ui.PagePhotoAlbumsComponentView;
import com.facebook.photos.intent.PhotosViewIntentBuilder;
import com.facebook.photos.intent.PhotosViewIntentProvider;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitOpenAlbumActionsFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitOpenAlbumActionsFragmentModel.AlbumModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: service_id */
public class PagePhotoAlbumsUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PagePhotoAlbumsComponentView> {
    public static final ViewType f2015a = new C02611();
    private static PagePhotoAlbumsUnitComponentPartDefinition f2016e;
    private static final Object f2017f = new Object();
    private final AdminedPagesRamCache f2018b;
    public final PhotosViewIntentProvider f2019c;
    private final Provider<ViewerContextManager> f2020d;

    /* compiled from: service_id */
    final class C02611 extends ViewType {
        C02611() {
        }

        public final View m3046a(Context context) {
            return new PagePhotoAlbumsComponentView(context);
        }
    }

    /* compiled from: service_id */
    public class Album {
        public final String f2009a;
        public final String f2010b;
        public final String f2011c;
        public final String f2012d;
        public final OnClickListener f2013e;

        public Album(String str, String str2, String str3, String str4, OnClickListener onClickListener) {
            this.f2009a = str;
            this.f2010b = str2;
            this.f2011c = str3;
            this.f2012d = str4;
            this.f2013e = onClickListener;
        }
    }

    /* compiled from: service_id */
    public class State {
        public final List<Album> f2014a;

        public State(List<Album> list) {
            this.f2014a = list;
        }
    }

    private static PagePhotoAlbumsUnitComponentPartDefinition m3053b(InjectorLike injectorLike) {
        return new PagePhotoAlbumsUnitComponentPartDefinition(AdminedPagesRamCache.a(injectorLike), PhotosViewIntentProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 375));
    }

    public final Object m3056a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(m3051a((ReactionUnitComponentNode) obj, 3, (CanLaunchReactionIntent) anyEnvironment));
    }

    public final /* bridge */ /* synthetic */ void m3057a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 186040300);
        ((PagePhotoAlbumsComponentView) view).m3182a(((State) obj2).f2014a);
        Logger.a(8, EntryType.MARK_POP, -747832801, a);
    }

    public final boolean m3058a(Object obj) {
        ImmutableList bG = ((ReactionUnitComponentNode) obj).b.bG();
        if (bG.size() < 3) {
            return false;
        }
        int size = bG.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitOpenAlbumActionsFragmentModel reactionUnitOpenAlbumActionsFragmentModel = (ReactionUnitOpenAlbumActionsFragmentModel) bG.get(i);
            if (reactionUnitOpenAlbumActionsFragmentModel.a() == null || StringUtil.a(reactionUnitOpenAlbumActionsFragmentModel.a().c()) || reactionUnitOpenAlbumActionsFragmentModel.a().b() == null || reactionUnitOpenAlbumActionsFragmentModel.a().b().c() == null || StringUtil.a(reactionUnitOpenAlbumActionsFragmentModel.a().b().c().a()) || reactionUnitOpenAlbumActionsFragmentModel.b() == null || StringUtil.a(reactionUnitOpenAlbumActionsFragmentModel.b().b())) {
                return false;
            }
        }
        return true;
    }

    public final void m3059b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        for (View onClickListener : ((PagePhotoAlbumsComponentView) view).f2219b) {
            onClickListener.setOnClickListener(null);
        }
    }

    public static PagePhotoAlbumsUnitComponentPartDefinition m3048a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagePhotoAlbumsUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2017f) {
                PagePhotoAlbumsUnitComponentPartDefinition pagePhotoAlbumsUnitComponentPartDefinition;
                if (a2 != null) {
                    pagePhotoAlbumsUnitComponentPartDefinition = (PagePhotoAlbumsUnitComponentPartDefinition) a2.a(f2017f);
                } else {
                    pagePhotoAlbumsUnitComponentPartDefinition = f2016e;
                }
                if (pagePhotoAlbumsUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3053b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2017f, b3);
                        } else {
                            f2016e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagePhotoAlbumsUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagePhotoAlbumsUnitComponentPartDefinition(AdminedPagesRamCache adminedPagesRamCache, PhotosViewIntentBuilder photosViewIntentBuilder, Provider<ViewerContextManager> provider) {
        this.f2018b = adminedPagesRamCache;
        this.f2019c = photosViewIntentBuilder;
        this.f2020d = provider;
    }

    public final ViewType m3055a() {
        return f2015a;
    }

    private OnClickListener m3047a(E e, String str, String str2, String str3, String str4, ViewerContext viewerContext, ArrayList<String> arrayList, ComposerTargetData composerTargetData) {
        final String str5 = str3;
        final E e2 = e;
        final ViewerContext viewerContext2 = viewerContext;
        final String str6 = str4;
        final ArrayList<String> arrayList2 = arrayList;
        final ComposerTargetData composerTargetData2 = composerTargetData;
        final String str7 = str;
        final String str8 = str2;
        return new OnClickListener(this) {
            final /* synthetic */ PagePhotoAlbumsUnitComponentPartDefinition f2008i;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1665758868);
                Builder builder = new Builder();
                builder.o = str5;
                GraphQLAlbum a2 = builder.a();
                Intent a3 = this.f2008i.f2019c.a(((HasContext) e2).getContext(), a2.u());
                FlatBufferModelHelper.a(a3, "extra_album_selected", a2);
                a3.putExtra("extra_photo_tab_mode_params", new TimelinePhotoTabModeParams(TimelinePhotoEditMode.VIEWING_MODE, Long.parseLong(viewerContext2.mUserId)));
                a3.putExtra("is_page", true);
                a3.putExtra("owner_id", Long.parseLong(str6));
                a3.putExtra("pick_hc_pic", false);
                a3.putExtra("pick_pic_lite", false);
                a3.putExtra("disable_adding_photos_to_albums", false);
                if (viewerContext2.mIsPageContext) {
                    a3.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext2);
                    if (!arrayList2.isEmpty()) {
                        a3.putStringArrayListExtra("extra_pages_admin_permissions", arrayList2);
                    }
                    a3.putExtra("extra_composer_target_data", composerTargetData2);
                }
                e2.a(str7, str8, new ReactionAttachmentIntent(str6, UnitInteractionType.ALBUM_TAP, a3));
                Logger.a(2, EntryType.UI_INPUT_END, -1074672777, a);
            }
        };
    }

    private ArrayList<String> m3050a(String str) {
        ArrayList<String> arrayList = new ArrayList();
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) this.f2018b.b(str);
        if (adminedPagesPrefetchNode != null && adminedPagesPrefetchNode.b.isPresent()) {
            ImmutableList g = adminedPagesPrefetchNode.a.g();
            int size = g.size();
            for (int i = 0; i < size; i++) {
                arrayList.add((String) g.get(i));
            }
        }
        return arrayList;
    }

    private ComposerTargetData m3052b(String str) {
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.PAGE);
        builder.f = true;
        ComposerTargetData.Builder builder2 = builder;
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) this.f2018b.b(str);
        if (adminedPagesPrefetchNode == null) {
            return builder2.a();
        }
        String a;
        String d = adminedPagesPrefetchNode.a.d();
        if (d != null) {
            builder2.c = d;
        }
        if (adminedPagesPrefetchNode.a.km_() != null) {
            a = adminedPagesPrefetchNode.a.km_().a();
        } else {
            a = null;
        }
        if (a != null) {
            builder2.d = a;
        }
        return builder2.a();
    }

    private static String m3049a(int i, Context context) {
        if (i == 0) {
            return context.getResources().getString(2131234347);
        }
        if (i > 0) {
            return context.getResources().getQuantityString(2131689584, i, new Object[]{Integer.valueOf(i)});
        }
        throw new IllegalArgumentException("Invalid album size " + i);
    }

    private ViewerContext m3054c(String str) {
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) this.f2018b.b(str);
        ViewerContext d = ((ViewerContextManager) this.f2020d.get()).d();
        if (adminedPagesPrefetchNode == null || !adminedPagesPrefetchNode.b.isPresent() || d.mIsPageContext) {
            return d;
        }
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.c = d.mSessionCookiesString;
        newBuilder = newBuilder;
        newBuilder.f = d.mSessionKey;
        newBuilder = newBuilder;
        newBuilder.e = d.mSessionSecret;
        ViewerContextBuilder viewerContextBuilder = newBuilder;
        viewerContextBuilder.a = str;
        newBuilder = viewerContextBuilder;
        newBuilder.b = (String) adminedPagesPrefetchNode.b.get();
        viewerContextBuilder = newBuilder;
        viewerContextBuilder.g = adminedPagesPrefetchNode.a.d();
        return viewerContextBuilder.h();
    }

    private List<Album> m3051a(ReactionUnitComponentNode reactionUnitComponentNode, int i, E e) {
        ImmutableList bG = reactionUnitComponentNode.f().bG();
        List<Album> arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            int a;
            String b = ((ReactionUnitOpenAlbumActionsFragmentModel) bG.get(i2)).b().b();
            AlbumModel a2 = ((ReactionUnitOpenAlbumActionsFragmentModel) bG.get(i2)).a();
            String c = a2.c();
            Object obj = (a2.gn_() == null || StringUtil.a(a2.gn_().a())) ? null : 1;
            String a3 = obj != null ? a2.gn_().a() : "";
            if ((a2.d() != null ? 1 : null) != null) {
                a = a2.d().a();
            } else {
                a = 0;
            }
            arrayList.add(new Album(c, a2.b().c().a(), a3, m3049a(a, ((HasContext) e).getContext()), m3047a(e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l(), c, b, m3054c(b), m3050a(c), m3052b(b))));
        }
        return arrayList;
    }
}
