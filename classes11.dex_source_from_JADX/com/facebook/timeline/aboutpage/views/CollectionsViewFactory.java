package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.MutualFriendsInfo;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodeIdFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionMediaset;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionRequestableField;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionRequestableFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionMediasetModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Ljava/util/HashSet */
public class CollectionsViewFactory {
    private static volatile CollectionsViewFactory f13797g;
    private final IFeedIntentBuilder f13798a;
    private final AbstractFbErrorReporter f13799b;
    private final StandardCollectionSizes f13800c;
    private final CollectionStyleMapper f13801d;
    private final CollectionsUriIntentBuilder f13802e;
    private final ListCollectionItemDataFactory f13803f;

    /* compiled from: Ljava/util/HashSet */
    /* synthetic */ class C16041 {
        static final /* synthetic */ int[] f13780a = new int[GraphQLTimelineAppCollectionStyle.values().length];

        static {
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.ABOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.CONTACT_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.LIST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.NOTES.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.PHOTOS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.GRID.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.REVIEW_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.MAP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.FEED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f13780a[GraphQLTimelineAppCollectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* compiled from: Ljava/util/HashSet */
    public class ItemData {
        @Nullable
        public final String f13781a;
        @Nullable
        public final String f13782b;
        @Nullable
        public final String f13783c;
        @Nullable
        public final String f13784d;
        @Nullable
        public final DefaultImageFields f13785e;
        public final String f13786f;
        public final CollectionWithItemsAndSuggestions f13787g;
        @Nullable
        public final CollectionsAppSectionMediasetModel f13788h;
        @Nullable
        public final CollectionsAppSectionRequestableFieldsModel f13789i;
        public final String f13790j;
        public final String f13791k;
        @Nullable
        public final Bundle f13792l;
        @Nullable
        public final String f13793m;
        @Nullable
        public final GraphQLTimelineAppSectionType f13794n;
        @Nullable
        public final ProfileViewerContext f13795o;
        public final boolean f13796p;

        public ItemData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable DefaultImageFields defaultImageFields, String str5, @Nullable CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, @Nullable CollectionsAppSectionMediasetModel collectionsAppSectionMediasetModel, @Nullable CollectionsAppSectionRequestableFieldsModel collectionsAppSectionRequestableFieldsModel, @Nullable String str6, String str7, @Nullable Bundle bundle, @Nullable String str8, @Nullable GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, @Nullable ProfileViewerContext profileViewerContext, boolean z) {
            this.f13781a = str;
            this.f13782b = str2;
            this.f13783c = str3;
            this.f13784d = str4;
            this.f13785e = defaultImageFields;
            this.f13786f = str5;
            this.f13787g = collectionWithItemsAndSuggestions;
            this.f13788h = collectionsAppSectionMediasetModel;
            this.f13789i = collectionsAppSectionRequestableFieldsModel;
            this.f13790j = str6;
            this.f13791k = str7;
            this.f13792l = bundle;
            this.f13793m = str8;
            this.f13794n = graphQLTimelineAppSectionType;
            this.f13795o = profileViewerContext;
            this.f13796p = z;
        }
    }

    public static com.facebook.timeline.aboutpage.views.CollectionsViewFactory m14940a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13797g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.views.CollectionsViewFactory.class;
        monitor-enter(r1);
        r0 = f13797g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14947b(r0);	 Catch:{ all -> 0x0035 }
        f13797g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13797g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.views.CollectionsViewFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.views.CollectionsViewFactory");
    }

    private static CollectionsViewFactory m14947b(InjectorLike injectorLike) {
        return new CollectionsViewFactory((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StandardCollectionSizes.m13827a(injectorLike), CollectionStyleMapper.m14915a(injectorLike), CollectionsUriIntentBuilder.m13782a(injectorLike), ListCollectionItemDataFactory.m14997a(injectorLike));
    }

    @Inject
    public CollectionsViewFactory(IFeedIntentBuilder iFeedIntentBuilder, AbstractFbErrorReporter abstractFbErrorReporter, StandardCollectionSizes standardCollectionSizes, CollectionStyleMapper collectionStyleMapper, CollectionsUriIntentBuilder collectionsUriIntentBuilder, ListCollectionItemDataFactory listCollectionItemDataFactory) {
        this.f13798a = iFeedIntentBuilder;
        this.f13799b = abstractFbErrorReporter;
        this.f13800c = standardCollectionSizes;
        this.f13801d = collectionStyleMapper;
        this.f13802e = collectionsUriIntentBuilder;
        this.f13803f = listCollectionItemDataFactory;
    }

    public final View m14949a(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, LayoutInflater layoutInflater, Context context) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(2130903594, null);
        View b = m14946b(graphQLTimelineAppCollectionStyle, layoutInflater, context);
        b.setTag("collectionsViewFactory_inner_view");
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(2131560382);
        if (relativeLayout != null) {
            relativeLayout.addView(b);
        }
        return viewGroup;
    }

    private View m14946b(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, LayoutInflater layoutInflater, Context context) {
        StandardCollectionSizes standardCollectionSizes;
        switch (C16041.f13780a[graphQLTimelineAppCollectionStyle.ordinal()]) {
            case 1:
                standardCollectionSizes = this.f13800c;
                return new LinearCollectionView(context, layoutInflater, 2130903585, 6);
            case 2:
                standardCollectionSizes = this.f13800c;
                return new LinearCollectionView(context, layoutInflater, 2130903587, 6);
            case 3:
                return new ListCollectionView(context);
            case 4:
                standardCollectionSizes = this.f13800c;
                return new LinearCollectionView(context, layoutInflater, 2130903593, 2);
            case 5:
                return TableCollectionView.m15050a(context, layoutInflater, 2130903595);
            case 6:
                return TableCollectionView.m15050a(context, layoutInflater, 2130903588);
            case 7:
                standardCollectionSizes = this.f13800c;
                return new LinearCollectionView(context, layoutInflater, 2130903598, 4);
            default:
                throw new IllegalArgumentException(StringFormatUtil.a("Unrecognized view type %s in createCollectionView", new Object[]{graphQLTimelineAppCollectionStyle}));
        }
    }

    public static View m14938a(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        switch (C16041.f13780a[graphQLTimelineAppCollectionStyle.ordinal()]) {
            case 2:
                return layoutInflater.inflate(2130903587, viewGroup, false);
            case 4:
                return layoutInflater.inflate(2130903593, null, false);
            default:
                throw new IllegalArgumentException("Unrecognized view type in createcollectionItemView");
        }
    }

    public final TextView m14950a(Exception exception, Context context, String str, String str2) {
        this.f13799b.a(str2 + "_" + exception.getClass().getName(), exception.getMessage(), exception);
        CharSequence charSequence = "";
        if (BuildConstants.i) {
            charSequence = charSequence + exception.toString() + " rendering ";
            if (str != null) {
                charSequence = charSequence + str;
            }
        }
        TextView textView = new TextView(context);
        textView.setTag("error_view");
        textView.setTextColor(Color.rgb(200, 0, 0));
        textView.setText(charSequence);
        return textView;
    }

    public static boolean m14945a(View view) {
        return (view instanceof TextView) && view.getTag() != null && view.getTag().equals("error_view");
    }

    public final void m14952a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, List<?> list, View view, ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo, CollectionsAppSection collectionsAppSection, CollectionsAppSectionMediaset collectionsAppSectionMediaset, CollectionsAppSectionRequestableFields collectionsAppSectionRequestableFields) {
        GraphQLTimelineAppCollectionStyle a = m14939a(collectionWithItemsAndSuggestions.mo396d());
        View findViewWithTag = view.findViewWithTag("collectionsViewFactory_inner_view");
        if (findViewWithTag != null) {
            CollectionTitleBarView collectionTitleBarView = (CollectionTitleBarView) view.findViewById(2131560345);
            if (collectionTitleBarView != null) {
                String d = collectionWithItemsAndSuggestions.nS_() == null ? collectionsAppSection.mo390d() : collectionWithItemsAndSuggestions.nS_();
                String str = null;
                if (collectionWithItemsAndSuggestions.nU_() != null && collectionWithItemsAndSuggestions.nU_().m14342a() > 0) {
                    str = String.valueOf(collectionWithItemsAndSuggestions.nU_().m14342a());
                }
                collectionTitleBarView.setHasCurateButton(m14954a(collectionWithItemsAndSuggestions, profileViewerContext));
                collectionTitleBarView.setTitleIsLink(true);
                collectionTitleBarView.m14934a(collectionWithItemsAndSuggestions, d, str, collectionsAppSection.nQ_(), CollectionsUriIntentBuilder.m13783a((CollectionsNodeIdFields) collectionWithItemsAndSuggestions, profileViewerContext.a(), collectionsAppSection.mo389c()), null, this.f13802e.m13786a(collectionWithItemsAndSuggestions, collectionsAppSection.nP_(), a), collectionsAppSection.mo388b(), collectionsAppSection.nP_());
            }
            m14944a(collectionWithItemsAndSuggestions, view);
            List a2 = m14942a(a, (CollectionsAppSectionRequestableFieldsModel) collectionsAppSectionRequestableFields);
            if (collectionsAppSectionMediaset != null) {
                findViewWithTag.setTag(2131558841, collectionsAppSectionMediaset.m14542b());
            }
            m14943a(a, findViewWithTag, list, a2, collectionsAppSection.nP_(), profileViewerContext, mutualFriendsInfo);
        }
    }

    public final void m14951a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel, View view, ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo, TimelineAppSectionUrlBuilder timelineAppSectionUrlBuilder, String str) {
        if (collectionsAppSectionWithItemsOrRequestablesModel != null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j() != null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a() != null) {
            CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0);
            GraphQLTimelineAppCollectionStyle a = m14939a(collectionWithItemsAndSuggestions.mo396d());
            View findViewWithTag = view.findViewWithTag("collectionsViewFactory_inner_view");
            if (findViewWithTag != null) {
                List a2;
                CollectionTitleBarView collectionTitleBarView = (CollectionTitleBarView) view.findViewById(2131560345);
                if (collectionTitleBarView != null) {
                    String d;
                    collectionTitleBarView.setHasCurateButton(m14954a(collectionWithItemsAndSuggestions, profileViewerContext));
                    collectionTitleBarView.setTitleIsLink(true);
                    if (collectionsAppSectionWithItemsOrRequestablesModel.m14587n() == null) {
                        d = collectionsAppSectionWithItemsOrRequestablesModel.mo390d();
                    } else {
                        d = collectionsAppSectionWithItemsOrRequestablesModel.m14587n().m14392a();
                    }
                    collectionTitleBarView.m14934a(collectionWithItemsAndSuggestions, d, null, collectionsAppSectionWithItemsOrRequestablesModel.nQ_(), timelineAppSectionUrlBuilder.m14872a(collectionsAppSectionWithItemsOrRequestablesModel, profileViewerContext, false), TimelineAppSectionUrlBuilder.m14866a(collectionsAppSectionWithItemsOrRequestablesModel, str), this.f13802e.m13786a(collectionWithItemsAndSuggestions, collectionsAppSectionWithItemsOrRequestablesModel.nP_(), a), collectionsAppSectionWithItemsOrRequestablesModel.mo388b(), collectionsAppSectionWithItemsOrRequestablesModel.nP_());
                }
                m14944a(collectionWithItemsAndSuggestions, view);
                List a3 = m14942a(a, collectionWithItemsAndSuggestions.nT_());
                if (collectionWithItemsAndSuggestions.m14527g() != null) {
                    findViewWithTag.setTag(2131558841, collectionWithItemsAndSuggestions.m14527g().m14542b());
                }
                if (GraphQLTimelineAppCollectionStyle.LIST.equals(a)) {
                    a2 = ListCollectionItemDataFactory.m14998a(collectionWithItemsAndSuggestions, collectionsAppSectionWithItemsOrRequestablesModel.nP_());
                } else {
                    a2 = collectionWithItemsAndSuggestions.nU_().m14346b();
                }
                m14943a(a, findViewWithTag, a2, a3, collectionsAppSectionWithItemsOrRequestablesModel.nP_(), profileViewerContext, mutualFriendsInfo);
            }
        }
    }

    private GraphQLTimelineAppCollectionStyle m14939a(Iterable<GraphQLTimelineAppCollectionStyle> iterable) {
        return this.f13801d.m14916a((Iterable) iterable);
    }

    private static void m14944a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, View view) {
        int i = ((collectionWithItemsAndSuggestions.nU_() == null || collectionWithItemsAndSuggestions.nU_().m14346b().isEmpty()) && collectionWithItemsAndSuggestions.mo404q() != null && collectionWithItemsAndSuggestions.mo404q().m14409a() != null && collectionWithItemsAndSuggestions.mo404q().m14409a().isEmpty()) ? 1 : 0;
        View findViewById = view.findViewById(2131560381);
        if (i != 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private static List<? extends CollectionsAppSectionRequestableField> m14942a(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, CollectionsAppSectionRequestableFields collectionsAppSectionRequestableFields) {
        if ((GraphQLTimelineAppCollectionStyle.ABOUT.equals(graphQLTimelineAppCollectionStyle) || GraphQLTimelineAppCollectionStyle.CONTACT_LIST.equals(graphQLTimelineAppCollectionStyle)) && collectionsAppSectionRequestableFields != null) {
            return collectionsAppSectionRequestableFields.m14557a();
        }
        return null;
    }

    public final void m14953a(ItemData itemData, ImmutableList<?> immutableList, View view, ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo) {
        GraphQLTimelineAppCollectionStyle a = m14939a(itemData.f13787g.mo396d());
        View findViewWithTag = view.findViewWithTag("collectionsViewFactory_inner_view");
        if (findViewWithTag != null) {
            CollectionTitleBarView collectionTitleBarView = (CollectionTitleBarView) view.findViewById(2131560345);
            if (collectionTitleBarView != null) {
                collectionTitleBarView.f13770b = m14954a(itemData.f13787g, profileViewerContext);
                collectionTitleBarView.f13772d = true;
                collectionTitleBarView.m14935a(itemData);
            }
            m14944a(itemData.f13787g, view);
            List a2 = m14942a(a, itemData.f13789i);
            if (itemData.f13788h != null) {
                findViewWithTag.setTag(2131558841, itemData.f13788h.m14542b());
            }
            m14943a(a, findViewWithTag, immutableList, a2, itemData.f13794n, profileViewerContext, mutualFriendsInfo);
        }
    }

    private void m14943a(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, View view, List<?> list, @Nullable List<CollectionsAppSectionRequestableField> list2, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo) {
        switch (C16041.f13780a[graphQLTimelineAppCollectionStyle.ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 7:
                ((LinearCollectionView) view).m14992a(list, list2, profileViewerContext, graphQLTimelineAppSectionType);
                return;
            case 3:
                ((ListCollectionView) view).m15014a(list, profileViewerContext, mutualFriendsInfo, graphQLTimelineAppSectionType, this.f13798a);
                return;
            case 5:
            case 6:
                ((TableCollectionView) view).m15053a((List) list, profileViewerContext, graphQLTimelineAppSectionType);
                return;
            default:
                throw new IllegalArgumentException("Unrecognized view type in innerBindCollectionView");
        }
    }

    public final int m14948a(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle) {
        switch (C16041.f13780a[graphQLTimelineAppCollectionStyle.ordinal()]) {
            case 1:
                return 6;
            case 2:
                return 6;
            case 3:
            case 7:
                return 4;
            case 4:
                return 2;
            case 5:
            case 6:
                return 2 * this.f13800c.f13056a;
            default:
                throw new IllegalArgumentException("Unrecognized view type");
        }
    }

    public final int m14955b(GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle) {
        switch (C16041.f13780a[graphQLTimelineAppCollectionStyle.ordinal()]) {
            case 4:
                return 1;
            case 5:
            case 6:
                return this.f13800c.f13056a;
            default:
                return m14948a(graphQLTimelineAppCollectionStyle);
        }
    }

    public static String m14941a(AppCollectionItemModel appCollectionItemModel, GraphQLLinkExtractor graphQLLinkExtractor) {
        String a = graphQLLinkExtractor.a(appCollectionItemModel.nH_().m14371b(), new Object[]{appCollectionItemModel.nH_().m14374g(), null});
        return a != null ? a : appCollectionItemModel.m14300m();
    }

    public static View m14937a(Context context, int i) {
        View view = new View(context);
        view.setLayoutParams(new LayoutParams(-1, i));
        view.setBackgroundResource(2131364003);
        return view;
    }

    public final boolean m14954a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, ProfileViewerContext profileViewerContext) {
        if (collectionWithItemsAndSuggestions == null) {
            return false;
        }
        GraphQLTimelineAppCollectionStyle a = this.f13801d.m14916a(collectionWithItemsAndSuggestions.mo396d());
        if ((collectionWithItemsAndSuggestions.mo399n() && a == GraphQLTimelineAppCollectionStyle.LIST) || (a == GraphQLTimelineAppCollectionStyle.ABOUT && profileViewerContext.f())) {
            return true;
        }
        return false;
    }
}
