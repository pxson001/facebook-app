package com.facebook.timeline.aboutpage.summary;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLProfileFieldStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.MutualFriendsInfo;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel.StringsListContentModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory.ProfileFieldItem;
import com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory.SummaryListItem;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.timeline.aboutpage.views.ContactListCollectionItemView;
import com.facebook.timeline.aboutpage.views.ICollectionItemView;
import com.facebook.timeline.aboutpage.views.ProfileBasicFieldViewBinder;
import com.facebook.timeline.aboutpage.views.ProfileExperienceView;
import com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: MD5 */
public class CollectionSummaryItemRenderer {
    public static final int f13570a = ExtraViewTypes.values().length;
    public static final int f13571b = GraphQLTimelineAppCollectionStyle.values().length;
    private static volatile CollectionSummaryItemRenderer f13572i;
    private final CollectionsViewFactory f13573c;
    private final CollectionStyleMapper f13574d;
    private final CollectionsViewFramer f13575e;
    private final CollectionsSummaryViewDataFactory f13576f;
    private final ProfileBasicFieldViewBinder f13577g;
    public final SecureContextHelper f13578h;

    /* compiled from: MD5 */
    /* synthetic */ class C15703 {
        static final /* synthetic */ int[] f13565a = new int[GraphQLProfileFieldStyle.values().length];

        static {
            f13566b = new int[ExtraViewTypes.values().length];
            try {
                f13566b[ExtraViewTypes.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13566b[ExtraViewTypes.SECTION_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13566b[ExtraViewTypes.SECTION_FOOTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13566b[ExtraViewTypes.SECTION_FULL_FRAME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13566b[ExtraViewTypes.PROFILE_FIELD_TEXT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13566b[ExtraViewTypes.PROFILE_FIELD_TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f13566b[ExtraViewTypes.PROFILE_FIELD_EXPERIENCE_ITEM.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f13566b[ExtraViewTypes.PROFILE_FIELD_EXPERIENCE_ITEM_END.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f13566b[ExtraViewTypes.ABOUT_LIST_ITEM_FIRST.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f13566b[ExtraViewTypes.ABOUT_LIST_ITEM_MIDDLE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f13566b[ExtraViewTypes.LIST_ITEM_MIDDLE.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f13566b[ExtraViewTypes.LIST_ITEM_END.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.UPSELL.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.PAGE_TAGS.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.TEXT_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.ADDRESS.ordinal()] = 5;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.PHONE.ordinal()] = 6;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.EMAIL.ordinal()] = 7;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.LIST_OF_STRINGS.ordinal()] = 10;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.TEXT_LISTS.ordinal()] = 11;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f13565a[GraphQLProfileFieldStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 12;
            } catch (NoSuchFieldError e24) {
            }
        }
    }

    @VisibleForTesting
    /* compiled from: MD5 */
    enum ExtraViewTypes {
        LOADING(2130907476),
        PROFILE_FIELD_SECTION_HEADER,
        ABOUT_MORE_ABOUT,
        SECTION_COLLECTION_HEADER,
        SECTION_HEADER,
        SECTION_FOOTER,
        SECTION_FULL_FRAME,
        ABOUT_LIST_ITEM_FIRST(2130903585),
        ABOUT_LIST_ITEM_MIDDLE(2130903585),
        LIST_ITEM_MIDDLE(2130903587),
        LIST_ITEM_END(2130903587),
        PROFILE_FIELD_TEXT(2130906425),
        PROFILE_FIELD_TEXT_END(2130906425),
        PROFILE_FIELD_EXPERIENCE_ITEM(2130906434),
        PROFILE_FIELD_EXPERIENCE_ITEM_END(2130906434),
        INVISIBLE_PROFILE_DATA,
        UNKNOWN_TYPE;
        
        private final int mItemLayoutResId;

        private ExtraViewTypes(int i) {
            this.mItemLayoutResId = i;
        }

        public final int getItemLayoutResId() {
            return this.mItemLayoutResId;
        }
    }

    /* compiled from: MD5 */
    public class ViewHolder {
        public View f13567a;
        private View f13568b;
        private FbTextView f13569c;

        public ViewHolder(View view) {
            this.f13567a = view;
        }

        public final View m14781a() {
            if (this.f13568b == null) {
                this.f13568b = this.f13567a.findViewById(2131560343);
            }
            return this.f13568b;
        }

        public final FbTextView m14782b() {
            if (this.f13569c == null) {
                this.f13569c = (FbTextView) this.f13567a.findViewById(2131566333);
            }
            return this.f13569c;
        }
    }

    public static com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer m14785a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13572i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer.class;
        monitor-enter(r1);
        r0 = f13572i;	 Catch:{ all -> 0x003a }
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
        r0 = m14787b(r0);	 Catch:{ all -> 0x0035 }
        f13572i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13572i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer");
    }

    private static CollectionSummaryItemRenderer m14787b(InjectorLike injectorLike) {
        return new CollectionSummaryItemRenderer(CollectionsViewFactory.m14940a(injectorLike), CollectionStyleMapper.m14915a(injectorLike), CollectionsViewFramer.m13790a(injectorLike), CollectionsSummaryViewDataFactory.m14845a(injectorLike), ProfileBasicFieldViewBinder.m15030b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public CollectionSummaryItemRenderer(CollectionsViewFactory collectionsViewFactory, CollectionStyleMapper collectionStyleMapper, CollectionsViewFramer collectionsViewFramer, CollectionsSummaryViewDataFactory collectionsSummaryViewDataFactory, ProfileBasicFieldViewBinder profileBasicFieldViewBinder, SecureContextHelper secureContextHelper) {
        this.f13573c = collectionsViewFactory;
        this.f13574d = collectionStyleMapper;
        this.f13575e = collectionsViewFramer;
        this.f13576f = collectionsSummaryViewDataFactory;
        this.f13577g = profileBasicFieldViewBinder;
        this.f13578h = secureContextHelper;
    }

    public static int m14783a(Object obj) {
        if (obj == CollectionsSummaryAdapter.f13579a) {
            return f13571b + ExtraViewTypes.LOADING.ordinal();
        }
        if (obj instanceof ItemData) {
            ItemData itemData = (ItemData) obj;
            if (!GraphQLTimelineAppSectionType.ABOUT.equals(itemData.f13794n)) {
                return f13571b + ExtraViewTypes.SECTION_HEADER.ordinal();
            }
            Object obj2;
            Object obj3;
            Object obj4;
            CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel;
            int i;
            CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = itemData.f13787g;
            if (collectionWithItemsAndSuggestions.nU_() == null || collectionWithItemsAndSuggestions.nU_().m14346b() == null || collectionWithItemsAndSuggestions.nU_().m14346b().isEmpty()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 == null) {
                if (collectionWithItemsAndSuggestions.mo404q() == null || collectionWithItemsAndSuggestions.mo404q().m14409a() == null || collectionWithItemsAndSuggestions.mo404q().m14409a().isEmpty()) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 == null) {
                    obj3 = null;
                    obj4 = obj3;
                    if (itemData.f13787g instanceof CollectionWithItemsOrRequestablesModel) {
                        collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) itemData.f13787g;
                        if (collectionWithItemsOrRequestablesModel.nT_() != null || collectionWithItemsOrRequestablesModel.nT_().m14557a() == null || collectionWithItemsOrRequestablesModel.nT_().m14557a().isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = 1;
                        }
                        if (obj3 != null) {
                            i = 1;
                            if (obj4 == null || r0 != 0) {
                                return f13571b + ExtraViewTypes.SECTION_FOOTER.ordinal();
                            }
                            return f13571b + ExtraViewTypes.SECTION_FULL_FRAME.ordinal();
                        }
                    }
                    i = 0;
                    if (obj4 == null) {
                    }
                    return f13571b + ExtraViewTypes.SECTION_FOOTER.ordinal();
                }
            }
            obj3 = 1;
            obj4 = obj3;
            if (itemData.f13787g instanceof CollectionWithItemsOrRequestablesModel) {
                collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) itemData.f13787g;
                if (collectionWithItemsOrRequestablesModel.nT_() != null) {
                }
                obj3 = null;
                if (obj3 != null) {
                    i = 1;
                    if (obj4 == null) {
                    }
                    return f13571b + ExtraViewTypes.SECTION_FOOTER.ordinal();
                }
            }
            i = 0;
            if (obj4 == null) {
            }
            return f13571b + ExtraViewTypes.SECTION_FOOTER.ordinal();
        } else if (obj instanceof SummaryListItem) {
            SummaryListItem summaryListItem = (SummaryListItem) obj;
            ExtraViewTypes extraViewTypes = GraphQLTimelineAppSectionType.ABOUT.equals(summaryListItem.f13635c) ? summaryListItem.f13637e ? ExtraViewTypes.ABOUT_LIST_ITEM_FIRST : ExtraViewTypes.ABOUT_LIST_ITEM_MIDDLE : summaryListItem.f13636d ? ExtraViewTypes.LIST_ITEM_END : ExtraViewTypes.LIST_ITEM_MIDDLE;
            return extraViewTypes.ordinal() + f13571b;
        } else {
            if (obj instanceof ProfileFieldItem) {
                ProfileFieldItem profileFieldItem = (ProfileFieldItem) obj;
                ProfileFieldInfoModel profileFieldInfoModel = profileFieldItem.f13631a;
                switch (C15703.f13565a[((GraphQLProfileFieldStyle) profileFieldInfoModel.m14041b().get(0)).ordinal()]) {
                    case 1:
                        return (profileFieldItem.f13632b ? ExtraViewTypes.PROFILE_FIELD_TEXT_END.ordinal() : ExtraViewTypes.PROFILE_FIELD_TEXT.ordinal()) + f13571b;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        if (profileFieldInfoModel.m14054t() && profileFieldInfoModel.m14047m()) {
                            return (profileFieldItem.f13632b ? ExtraViewTypes.LIST_ITEM_END.ordinal() : ExtraViewTypes.LIST_ITEM_MIDDLE.ordinal()) + f13571b;
                        }
                        return (profileFieldItem.f13632b ? ExtraViewTypes.PROFILE_FIELD_TEXT_END.ordinal() : ExtraViewTypes.PROFILE_FIELD_TEXT.ordinal()) + f13571b;
                    case 11:
                        return (profileFieldItem.f13632b ? ExtraViewTypes.PROFILE_FIELD_EXPERIENCE_ITEM_END.ordinal() : ExtraViewTypes.PROFILE_FIELD_EXPERIENCE_ITEM.ordinal()) + f13571b;
                    case 12:
                        return ExtraViewTypes.UNKNOWN_TYPE.ordinal();
                }
            } else if (obj instanceof SectionItemData) {
                return ((SectionItemData) obj).f13651c.ordinal();
            }
            return ExtraViewTypes.UNKNOWN_TYPE.ordinal();
        }
    }

    public final View m14788a(Context context, int i, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        if (i < f13571b) {
            return this.f13575e.m13791a(this.f13573c.m14949a(GraphQLTimelineAppCollectionStyle.values()[i], from, context), from);
        }
        ExtraViewTypes extraViewTypes = ExtraViewTypes.values()[i - f13571b];
        View inflate;
        ViewHolder viewHolder;
        View d;
        switch (extraViewTypes) {
            case LOADING:
                return this.f13575e.m13791a(from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false), from);
            case SECTION_HEADER:
                return this.f13575e.m13792b(new CollectionCollectionHeader(context), from);
            case SECTION_FOOTER:
                return this.f13575e.m13794d(new CollectionCollectionHeader(context), from);
            case SECTION_FULL_FRAME:
                return this.f13575e.m13791a(new CollectionCollectionHeader(context), from);
            case PROFILE_FIELD_TEXT_END:
                inflate = from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false);
                viewHolder = new ViewHolder(inflate);
                viewHolder.m14781a().setVisibility(4);
                d = this.f13575e.m13794d(inflate, from);
                d.setTag(viewHolder);
                return d;
            case PROFILE_FIELD_TEXT:
                inflate = from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false);
                viewHolder = new ViewHolder(inflate);
                viewHolder.m14781a().setVisibility(0);
                d = this.f13575e.m13793c(inflate, from);
                d.setTag(viewHolder);
                return d;
            case PROFILE_FIELD_EXPERIENCE_ITEM:
                return this.f13575e.m13793c(from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false), from);
            case PROFILE_FIELD_EXPERIENCE_ITEM_END:
                return this.f13575e.m13794d(from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false), from);
            case ABOUT_LIST_ITEM_FIRST:
                inflate = from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false);
                inflate.findViewById(2131560343).setVisibility(0);
                return this.f13575e.m13792b(inflate, from);
            case ABOUT_LIST_ITEM_MIDDLE:
            case LIST_ITEM_MIDDLE:
                inflate = from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false);
                inflate.findViewById(2131560343).setVisibility(0);
                return this.f13575e.m13793c(inflate, from);
            case LIST_ITEM_END:
                inflate = from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false);
                inflate.findViewById(2131560343).setVisibility(4);
                return this.f13575e.m13794d(inflate, from);
            default:
                throw new IllegalArgumentException("Unknown view type");
        }
    }

    public final void m14790a(Object obj, View view, ProfileViewerContext profileViewerContext, MutualFriendsInfo mutualFriendsInfo) {
        boolean z = true;
        if (obj instanceof ProfileFieldItem) {
            ProfileFieldInfoModel profileFieldInfoModel = ((ProfileFieldItem) obj).f13631a;
            switch (C15703.f13565a[((GraphQLProfileFieldStyle) profileFieldInfoModel.m14041b().get(0)).ordinal()]) {
                case 1:
                    if (view.getTag() != null) {
                        this.f13577g.m15033b(((ViewHolder) view.getTag()).m14782b(), ((ViewHolder) view.getTag()).f13567a, profileFieldInfoModel);
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    if (profileFieldInfoModel.m14047m()) {
                        if (profileFieldInfoModel.m14054t()) {
                            ContactListCollectionItemView contactListCollectionItemView = (ContactListCollectionItemView) CollectionsViewFramer.m13788a(view);
                            contactListCollectionItemView.findViewById(2131560343).setVisibility(4);
                            m14789a(profileFieldInfoModel, contactListCollectionItemView);
                            return;
                        } else if (profileFieldInfoModel.m14044j() != null && !profileFieldInfoModel.m14044j().isEmpty() && view.getTag() != null) {
                            FbTextView b = ((ViewHolder) view.getTag()).m14782b();
                            ((ViewHolder) view.getTag()).f13567a.setOnClickListener(null);
                            this.f13577g.m15032a(b, profileFieldInfoModel.m14044j());
                            return;
                        } else if (view.getTag() != null) {
                            this.f13577g.m15031a(((ViewHolder) view.getTag()).m14782b(), ((ViewHolder) view.getTag()).f13567a, profileFieldInfoModel);
                            return;
                        } else {
                            return;
                        }
                    } else if (profileFieldInfoModel.m14059y() != null && view.getTag() != null) {
                        this.f13577g.m15033b(((ViewHolder) view.getTag()).m14782b(), ((ViewHolder) view.getTag()).f13567a, profileFieldInfoModel);
                        return;
                    } else {
                        return;
                    }
                case 11:
                    if (profileFieldInfoModel.m14047m() && profileFieldInfoModel.m14058x() != null) {
                        ((ProfileExperienceView) CollectionsViewFramer.m13788a(view)).m15043a(profileFieldInfoModel);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (obj instanceof SectionItemData) {
            SectionItemData sectionItemData = (SectionItemData) obj;
            this.f13573c.m14953a(sectionItemData.f13650b, sectionItemData.f13652d, CollectionsViewFramer.m13788a(view), profileViewerContext, mutualFriendsInfo);
        } else if (obj instanceof ItemData) {
            boolean z2;
            CollectionCollectionHeader collectionCollectionHeader = (CollectionCollectionHeader) CollectionsViewFramer.m13788a(view);
            boolean z3;
            if (profileViewerContext == null || !profileViewerContext.f()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (((ItemData) obj).f13796p && r2) {
                z2 = true;
            } else {
                z2 = false;
            }
            ItemData itemData = (ItemData) obj;
            if (((ItemData) obj).f13796p) {
                z = false;
            }
            collectionCollectionHeader.m15079a(itemData, z, this.f13573c.m14954a(((ItemData) obj).f13787g, profileViewerContext), z2);
        } else if (obj instanceof SummaryListItem) {
            SummaryListItem summaryListItem = (SummaryListItem) obj;
            ICollectionItemView iCollectionItemView = (ICollectionItemView) CollectionsViewFramer.m13788a(view);
            if (summaryListItem.f13633a != null) {
                iCollectionItemView.mo424a(summaryListItem.f13633a);
            } else {
                iCollectionItemView.mo425a(summaryListItem.f13634b, profileViewerContext, summaryListItem.f13635c);
            }
        } else {
            if (obj != CollectionsSummaryAdapter.f13579a) {
                z = false;
            }
            Preconditions.checkState(z);
        }
    }

    public final void m14789a(ProfileFieldInfoModel profileFieldInfoModel, ContactListCollectionItemView contactListCollectionItemView) {
        contactListCollectionItemView.findViewById(2131560344).setVisibility(8);
        FbTextView fbTextView = (FbTextView) contactListCollectionItemView.findViewById(2131560347);
        FbTextView fbTextView2 = (FbTextView) contactListCollectionItemView.findViewById(2131560348);
        if (!profileFieldInfoModel.m14047m() || profileFieldInfoModel.m14058x() == null || profileFieldInfoModel.m14058x().m14031a() == null) {
            fbTextView.setVisibility(8);
            fbTextView2.setVisibility(8);
            return;
        }
        fbTextView.setVisibility(0);
        fbTextView.setText(profileFieldInfoModel.m14058x().m14031a());
        Intent intent;
        switch (C15703.f13565a[((GraphQLProfileFieldStyle) profileFieldInfoModel.m14041b().get(0)).ordinal()]) {
            case 2:
                if (profileFieldInfoModel.m14044j() != null && !profileFieldInfoModel.m14044j().isEmpty()) {
                    fbTextView2.setVisibility(0);
                    this.f13577g.m15032a(fbTextView2, profileFieldInfoModel.m14044j());
                    return;
                }
                return;
            case 3:
                if (profileFieldInfoModel.m14045k() != null && profileFieldInfoModel.m14045k().m13971a() != null) {
                    fbTextView2.setVisibility(0);
                    fbTextView2.setText(profileFieldInfoModel.m14045k().m13971a());
                    return;
                }
                return;
            case 4:
                if (profileFieldInfoModel.m14057w().size() > 0) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(profileFieldInfoModel.m14050p()));
                    m14786a(contactListCollectionItemView, fbTextView2, StringUtil.b("\n", new Object[]{profileFieldInfoModel.m14057w()}), intent);
                    return;
                }
                return;
            case 5:
                if (profileFieldInfoModel.m14057w().size() > 0) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("geo:0,0?q=" + profileFieldInfoModel.m14057w()));
                    m14786a(contactListCollectionItemView, fbTextView2, StringUtil.b("\n", new Object[]{profileFieldInfoModel.m14057w()}), intent);
                    return;
                }
                return;
            case 6:
                if (profileFieldInfoModel.m14053s() != null && profileFieldInfoModel.m14053s().m14014a() != null) {
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse("tel:" + profileFieldInfoModel.m14053s().m14015j()));
                    m14786a(contactListCollectionItemView, fbTextView2, profileFieldInfoModel.m14053s().m14014a(), intent);
                    return;
                }
                return;
            case 7:
                if (profileFieldInfoModel.m14046l() != null && profileFieldInfoModel.m14046l().m13977a() != null) {
                    intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("mailto:" + profileFieldInfoModel.m14046l().m13977a()));
                    m14786a(contactListCollectionItemView, fbTextView2, profileFieldInfoModel.m14046l().m13977a(), intent);
                    return;
                }
                return;
            case 8:
                if (profileFieldInfoModel.m14056v() != null && profileFieldInfoModel.m14056v().m14026a() != null) {
                    fbTextView2.setVisibility(0);
                    fbTextView2.setText(profileFieldInfoModel.m14056v().m14026a());
                    return;
                }
                return;
            case 9:
                if (profileFieldInfoModel.m14056v() != null && profileFieldInfoModel.m14056v().m14026a() != null) {
                    fbTextView2.setVisibility(0);
                    fbTextView2.setText(profileFieldInfoModel.m14056v().m14026a());
                    contactListCollectionItemView.setOnLongClickListener(m14784a(profileFieldInfoModel.m14056v().m14026a()));
                    return;
                }
                return;
            case 10:
                if (profileFieldInfoModel.m14055u() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < profileFieldInfoModel.m14055u().size(); i++) {
                        stringBuilder.append(((StringsListContentModel) profileFieldInfoModel.m14055u().get(i)).m14021a());
                        stringBuilder.append("\n");
                    }
                    fbTextView2.setVisibility(0);
                    fbTextView2.setText(stringBuilder.toString());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m14786a(ContactListCollectionItemView contactListCollectionItemView, FbTextView fbTextView, String str, final Intent intent) {
        fbTextView.setVisibility(0);
        fbTextView.setText(str);
        contactListCollectionItemView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectionSummaryItemRenderer f13562b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 922907307);
                this.f13562b.f13578h.b(intent, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -778895903, a);
            }
        });
        contactListCollectionItemView.setOnLongClickListener(m14784a(str));
    }

    private OnLongClickListener m14784a(final String str) {
        return new OnLongClickListener(this) {
            final /* synthetic */ CollectionSummaryItemRenderer f13564b;

            public boolean onLongClick(View view) {
                ((ClipboardManager) view.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
                Toast.makeText(view.getContext(), view.getResources().getString(2131242365), 0).show();
                return true;
            }
        };
    }
}
