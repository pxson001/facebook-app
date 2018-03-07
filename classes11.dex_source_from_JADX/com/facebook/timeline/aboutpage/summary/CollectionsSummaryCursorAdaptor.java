package com.facebook.timeline.aboutpage.summary;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.enums.GraphQLProfileFieldStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.MultiCollectionFragment.Adapter;
import com.facebook.timeline.aboutpage.MutualFriendsInfo;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.AboutPageUserFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer.ViewHolder;
import com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ContactListCollectionItemView;
import com.facebook.timeline.aboutpage.views.ProfileBasicFieldViewBinder;
import com.facebook.timeline.aboutpage.views.ProfileExperienceView;
import com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: LookNowStoryQuery */
public class CollectionsSummaryCursorAdaptor extends CursorAdapter implements Adapter {
    public static final PositionInCard[] f13607A = PositionInCard.values();
    private static final int f13608B = ((f13609x.length + f13610y.length) + ExtraViewTypes.LOADING.ordinal());
    public static final GraphQLTimelineAppCollectionStyle[] f13609x = GraphQLTimelineAppCollectionStyle.values();
    public static final GraphQLProfileFieldStyle[] f13610y = GraphQLProfileFieldStyle.values();
    public static final ExtraViewTypes[] f13611z = ExtraViewTypes.values();
    private final CollectionSummaryItemRenderer f13612j;
    private final CollectionsViewFactory f13613k;
    private final CollectionsViewFramer f13614l;
    private final ProfileViewerContext f13615m;
    private final CollectionsAnalyticsLogger f13616n;
    public final CollectionStyleMapper f13617o;
    private final TimelineAppSectionUrlBuilder f13618p;
    private boolean f13619q;
    private final ProfileBasicFieldViewBinder f13620r;
    private final CollectionsQeHelper f13621s;
    private final SparseArrayCompat<MutableFlattenable> f13622t = new SparseArrayCompat();
    private final SparseArrayCompat<Long> f13623u = new SparseArrayCompat();
    private final MutualFriendsInfo f13624v = new MutualFriendsInfo();
    private String f13625w;

    /* compiled from: LookNowStoryQuery */
    /* synthetic */ class C15721 {
        static final /* synthetic */ int[] f13606c = new int[GraphQLProfileFieldStyle.values().length];

        static {
            try {
                f13606c[GraphQLProfileFieldStyle.UPSELL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.PAGE_TAGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.TEXT_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.ADDRESS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.PHONE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.EMAIL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.LIST_OF_STRINGS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.TEXT_LISTS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f13606c[GraphQLProfileFieldStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            f13605b = new int[ExtraViewTypes.values().length];
            try {
                f13605b[ExtraViewTypes.INVISIBLE_PROFILE_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f13605b[ExtraViewTypes.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f13605b[ExtraViewTypes.PROFILE_FIELD_SECTION_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f13605b[ExtraViewTypes.SECTION_COLLECTION_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f13605b[ExtraViewTypes.ABOUT_MORE_ABOUT.ordinal()] = 5;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f13605b[ExtraViewTypes.ABOUT_LIST_ITEM_MIDDLE.ordinal()] = 6;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f13605b[ExtraViewTypes.LIST_ITEM_MIDDLE.ordinal()] = 7;
            } catch (NoSuchFieldError e19) {
            }
            f13604a = new int[PositionInCard.values().length];
            try {
                f13604a[PositionInCard.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f13604a[PositionInCard.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f13604a[PositionInCard.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f13604a[PositionInCard.FULL_CARD.ordinal()] = 4;
            } catch (NoSuchFieldError e23) {
            }
        }
    }

    /* compiled from: LookNowStoryQuery */
    public enum PositionInCard {
        FULL_CARD,
        FIRST,
        MIDDLE,
        LAST
    }

    /* compiled from: LookNowStoryQuery */
    public class ViewTypeUtil {
        public static int m14803a(PositionInCard positionInCard, int i) {
            return (CollectionsSummaryCursorAdaptor.f13607A.length * i) + positionInCard.ordinal();
        }

        public static PositionInCard m14804a(int i) {
            return CollectionsSummaryCursorAdaptor.f13607A[i % CollectionsSummaryCursorAdaptor.f13607A.length];
        }

        public static int m14805b(int i) {
            return i / CollectionsSummaryCursorAdaptor.f13607A.length;
        }
    }

    public int getViewTypeCount() {
        return ((f13609x.length + f13610y.length) + f13611z.length) * f13607A.length;
    }

    @Inject
    public CollectionsSummaryCursorAdaptor(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, @Assisted CollectionsAnalyticsLogger collectionsAnalyticsLogger, CollectionSummaryItemRenderer collectionSummaryItemRenderer, CollectionsViewFactory collectionsViewFactory, CollectionsViewFramer collectionsViewFramer, CollectionStyleMapper collectionStyleMapper, TimelineAppSectionUrlBuilder timelineAppSectionUrlBuilder, ProfileBasicFieldViewBinder profileBasicFieldViewBinder, CollectionsQeHelper collectionsQeHelper) {
        super(context, null, 0);
        this.f13615m = profileViewerContext;
        this.f13616n = collectionsAnalyticsLogger;
        this.f13612j = collectionSummaryItemRenderer;
        this.f13613k = collectionsViewFactory;
        this.f13614l = collectionsViewFramer;
        this.f13617o = collectionStyleMapper;
        this.f13618p = timelineAppSectionUrlBuilder;
        this.f13619q = false;
        this.f13620r = profileBasicFieldViewBinder;
        this.f13621s = collectionsQeHelper;
    }

    public final void mo405a(boolean z) {
        this.f13619q = z;
        AdapterDetour.a(this, 1142996843);
    }

    public final Cursor m14816b(Cursor cursor) {
        if (cursor == null) {
            return super.b(null);
        }
        if (this.f13625w == null && cursor.getCount() > 0) {
            ModelCursor modelCursor = (ModelCursor) cursor;
            Preconditions.checkState(modelCursor.moveToPosition(0));
            MutableFlattenable a = m14811a(modelCursor);
            if (a instanceof AboutPageUserFields) {
                AboutPageUserFields aboutPageUserFields = (AboutPageUserFields) a;
                this.f13625w = aboutPageUserFields.mo381a();
                if (aboutPageUserFields.mo383l() != null) {
                    this.f13624v.f13048a = aboutPageUserFields.mo383l().m14634a();
                    this.f13624v.f13049b = aboutPageUserFields.mo383l().m14638b();
                }
            } else {
                this.f13625w = "";
                StringBuilder stringBuilder = new StringBuilder();
                if (modelCursor.moveToFirst()) {
                    int columnIndexOrThrow = modelCursor.getColumnIndexOrThrow("class");
                    do {
                        stringBuilder.append("{type:'");
                        String string = modelCursor.getString(columnIndexOrThrow);
                        stringBuilder.append(string.substring(string.lastIndexOf(46))).append("'},\n");
                        if (!modelCursor.moveToNext()) {
                            break;
                        }
                    } while (modelCursor.getPosition() < 10);
                }
                BLog.c(CollectionsSummaryCursorAdaptor.class, "Got unexpected first row.\n[%s]", new Object[]{stringBuilder.toString()});
            }
        }
        return super.b(cursor);
    }

    public int getCount() {
        int count = super.getCount();
        if (this.f13619q) {
            return count + 1;
        }
        return count;
    }

    private View m14807a(LayoutInflater layoutInflater, View view, PositionInCard positionInCard) {
        switch (positionInCard) {
            case FIRST:
                return this.f13614l.m13792b(view, layoutInflater);
            case MIDDLE:
                return this.f13614l.m13793c(view, layoutInflater);
            case LAST:
                return this.f13614l.m13794d(view, layoutInflater);
            default:
                return this.f13614l.m13791a(view, layoutInflater);
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ModelCursor modelCursor = (ModelCursor) a();
        if (modelCursor != null && i < modelCursor.getCount()) {
            return super.getView(i, view, viewGroup);
        }
        int itemViewType = getItemViewType(i);
        int b = ViewTypeUtil.m14805b(itemViewType);
        PositionInCard a = ViewTypeUtil.m14804a(itemViewType);
        Preconditions.checkState(b == f13608B);
        LayoutInflater from = LayoutInflater.from(this.d);
        return m14807a(from, m14808a(from, viewGroup), a);
    }

    public final View m14813a(Context context, Cursor cursor, ViewGroup viewGroup) {
        boolean z = false;
        LayoutInflater from = LayoutInflater.from(context);
        int itemViewType = getItemViewType(cursor.getPosition());
        int b = ViewTypeUtil.m14805b(itemViewType);
        PositionInCard a = ViewTypeUtil.m14804a(itemViewType);
        if (b >= f13609x.length + f13610y.length) {
            ExtraViewTypes extraViewTypes = ExtraViewTypes.values()[(b - f13609x.length) - f13610y.length];
            switch (extraViewTypes) {
                case INVISIBLE_PROFILE_DATA:
                    return new View(context);
                case LOADING:
                    return m14807a(from, m14808a(from, viewGroup), a);
                case PROFILE_FIELD_SECTION_HEADER:
                case SECTION_COLLECTION_HEADER:
                case ABOUT_MORE_ABOUT:
                    return m14807a(from, new CollectionCollectionHeader(context), a);
                case ABOUT_LIST_ITEM_MIDDLE:
                case LIST_ITEM_MIDDLE:
                    int i;
                    View inflate = from.inflate(extraViewTypes.getItemLayoutResId(), viewGroup, false);
                    View findViewById = inflate.findViewById(2131560343);
                    if (a == PositionInCard.LAST) {
                        i = 4;
                    }
                    findViewById.setVisibility(i);
                    return m14807a(from, inflate, a);
                default:
                    return this.f13612j.m14788a(this.d, extraViewTypes.ordinal(), viewGroup);
            }
        } else if (b >= f13609x.length) {
            GraphQLProfileFieldStyle graphQLProfileFieldStyle = f13610y[b - f13609x.length];
            if (a == PositionInCard.LAST) {
                z = true;
            }
            return m14809a(from, viewGroup, graphQLProfileFieldStyle, z);
        } else {
            return this.f13614l.m13791a(this.f13613k.m14949a(GraphQLTimelineAppCollectionStyle.values()[b], from, context), from);
        }
    }

    private static View m14808a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(ExtraViewTypes.LOADING.getItemLayoutResId(), viewGroup, false);
    }

    private View m14810a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2130906425, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        if (z) {
            viewHolder.m14781a().setVisibility(4);
            inflate = this.f13614l.m13794d(inflate, layoutInflater);
        } else {
            viewHolder.m14781a().setVisibility(0);
            inflate = this.f13614l.m13793c(inflate, layoutInflater);
        }
        inflate.setTag(viewHolder);
        return inflate;
    }

    private View m14809a(LayoutInflater layoutInflater, ViewGroup viewGroup, GraphQLProfileFieldStyle graphQLProfileFieldStyle, boolean z) {
        Object a;
        ProfileFieldInfoModel profileFieldInfoModel = (ProfileFieldInfoModel) m14811a((ModelCursor) a());
        View inflate;
        switch (C15721.f13606c[graphQLProfileFieldStyle.ordinal()]) {
            case 1:
                a = m14810a(layoutInflater, viewGroup, z);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                if (!profileFieldInfoModel.m14054t() || !profileFieldInfoModel.m14047m()) {
                    a = m14810a(layoutInflater, viewGroup, z);
                    break;
                }
                inflate = layoutInflater.inflate(2130903587, viewGroup, false);
                if (!z) {
                    inflate.findViewById(2131560343).setVisibility(0);
                    a = this.f13614l.m13793c(inflate, layoutInflater);
                    break;
                }
                inflate.findViewById(2131560343).setVisibility(4);
                a = this.f13614l.m13794d(inflate, layoutInflater);
                break;
                break;
            case 11:
                inflate = layoutInflater.inflate(2130906434, viewGroup, false);
                if (!z) {
                    a = this.f13614l.m13793c(inflate, layoutInflater);
                    break;
                }
                a = this.f13614l.m13794d(inflate, layoutInflater);
                break;
            default:
                throw new IllegalArgumentException("Unknown view type " + graphQLProfileFieldStyle);
        }
        return (View) Preconditions.checkNotNull(a);
    }

    private void m14812a(View view, ProfileFieldInfoModel profileFieldInfoModel, GraphQLProfileFieldStyle graphQLProfileFieldStyle) {
        switch (C15721.f13606c[graphQLProfileFieldStyle.ordinal()]) {
            case 1:
                if (view.getTag() != null) {
                    this.f13620r.m15033b(((ViewHolder) view.getTag()).m14782b(), ((ViewHolder) view.getTag()).f13567a, profileFieldInfoModel);
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
                    if (profileFieldInfoModel.m14054t() && (CollectionsViewFramer.m13788a(view) instanceof ContactListCollectionItemView)) {
                        ContactListCollectionItemView contactListCollectionItemView = (ContactListCollectionItemView) CollectionsViewFramer.m13788a(view);
                        contactListCollectionItemView.findViewById(2131560343).setVisibility(4);
                        this.f13612j.m14789a(profileFieldInfoModel, contactListCollectionItemView);
                        return;
                    } else if (profileFieldInfoModel.m14044j() != null && !profileFieldInfoModel.m14044j().isEmpty() && view.getTag() != null) {
                        FbTextView b = ((ViewHolder) view.getTag()).m14782b();
                        ((ViewHolder) view.getTag()).f13567a.setOnClickListener(null);
                        this.f13620r.m15032a(b, profileFieldInfoModel.m14044j());
                        return;
                    } else if (view.getTag() != null) {
                        this.f13620r.m15031a(((ViewHolder) view.getTag()).m14782b(), ((ViewHolder) view.getTag()).f13567a, profileFieldInfoModel);
                        return;
                    } else {
                        return;
                    }
                } else if (profileFieldInfoModel.m14059y() != null && view.getTag() != null) {
                    this.f13620r.m15033b(((ViewHolder) view.getTag()).m14782b(), ((ViewHolder) view.getTag()).f13567a, profileFieldInfoModel);
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
    }

    private <T extends MutableFlattenable> T m14811a(ModelCursor modelCursor) {
        if (!this.f13621s.m13766f()) {
            return (MutableFlattenable) modelCursor.d();
        }
        int position = modelCursor.getPosition();
        long c = modelCursor.c();
        Long l = (Long) this.f13623u.a(position);
        if (l != null && l.longValue() == c) {
            return (MutableFlattenable) Preconditions.checkNotNull(this.f13622t.a(position));
        }
        MutableFlattenable mutableFlattenable = (MutableFlattenable) modelCursor.d();
        this.f13622t.a(position, mutableFlattenable);
        this.f13623u.a(position, Long.valueOf(c));
        return mutableFlattenable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m14814a(android.view.View r13, android.database.Cursor r14) {
        /*
        r12 = this;
        r2 = 0;
        r5 = 0;
        r0 = r14;
        r0 = (com.facebook.graphql.cursor.ModelCursor) r0;
        r0 = r12.m14811a(r0);
        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
        r1 = r14.getPosition();
        r1 = r12.getItemViewType(r1);
        r1 = com.facebook.timeline.aboutpage.summary.CollectionsSummaryCursorAdaptor.ViewTypeUtil.m14805b(r1);
        r3 = f13609x;
        r3 = r3.length;
        r4 = f13610y;
        r4 = r4.length;
        r3 = r3 + r4;
        if (r1 < r3) goto L_0x00e4;
    L_0x0020:
        r3 = com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer.ExtraViewTypes.values();
        r4 = f13609x;
        r4 = r4.length;
        r1 = r1 - r4;
        r4 = f13610y;
        r4 = r4.length;
        r1 = r1 - r4;
        r4 = r3[r1];
        r1 = com.facebook.timeline.aboutpage.summary.CollectionsSummaryCursorAdaptor.C15721.f13605b;
        r3 = r4.ordinal();
        r1 = r1[r3];
        switch(r1) {
            case 3: goto L_0x004f;
            case 4: goto L_0x0072;
            case 5: goto L_0x0072;
            case 6: goto L_0x00a6;
            case 7: goto L_0x00c5;
            default: goto L_0x0039;
        };
    L_0x0039:
        r0 = r2;
    L_0x003a:
        if (r0 == 0) goto L_0x004e;
    L_0x003c:
        if (r2 == 0) goto L_0x004e;
    L_0x003e:
        r1 = r12.f13616n;
        r3 = r12.f13615m;
        r9 = r3.a;
        r3 = r9;
        r4 = r12.f13615m;
        r4 = com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger.m13739a(r4);
        r1.m13741a(r3, r4, r0, r2);
    L_0x004e:
        return;
    L_0x004f:
        r1 = com.facebook.timeline.aboutpage.CollectionsViewFramer.m13788a(r13);
        r1 = (com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader) r1;
        r0 = (com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel) r0;
        r9 = 0;
        r10 = r1.f13959a;
        r10.f13770b = r9;
        r10 = r1.f13959a;
        r10.f13772d = r9;
        r10 = r1.f13959a;
        r11 = r0.m14085a();
        if (r11 == 0) goto L_0x0069;
    L_0x0068:
        r9 = 1;
    L_0x0069:
        r10.f13771c = r9;
        r9 = r1.f13959a;
        r9.m14932a(r0);
        r0 = r2;
        goto L_0x003a;
    L_0x0072:
        r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel) r0;
        r3 = r0.nQ_();
        r1 = r0.m14583j();
        r1 = r1.m14562a();
        r1 = r1.get(r5);
        r1 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel) r1;
        r2 = r1.mo398j();
        r1 = com.facebook.timeline.aboutpage.summary.CollectionSummaryItemRenderer.ExtraViewTypes.SECTION_COLLECTION_HEADER;
        if (r4 != r1) goto L_0x0099;
    L_0x008e:
        r1 = com.facebook.timeline.aboutpage.CollectionsViewFramer.m13788a(r13);
        r1 = (com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader) r1;
        r1.m15077a(r0);
        r0 = r3;
        goto L_0x003a;
    L_0x0099:
        r1 = com.facebook.timeline.aboutpage.CollectionsViewFramer.m13788a(r13);
        r1 = (com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader) r1;
        r4 = r12.f13615m;
        r1.m15078a(r0, r4);
        r0 = r3;
        goto L_0x003a;
    L_0x00a6:
        r1 = com.facebook.timeline.aboutpage.CollectionsViewFramer.m13788a(r13);
        r1 = (com.facebook.timeline.aboutpage.views.AboutCollectionItemView) r1;
        r3 = r0 instanceof com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
        if (r3 == 0) goto L_0x00b9;
    L_0x00b0:
        r0 = (com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel) r0;
        r3 = com.facebook.graphql.enums.GraphQLTimelineAppSectionType.ABOUT;
        r1.mo424a(r0);
        r0 = r2;
        goto L_0x003a;
    L_0x00b9:
        r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel) r0;
        r3 = r12.f13615m;
        r4 = com.facebook.graphql.enums.GraphQLTimelineAppSectionType.ABOUT;
        r1.mo425a(r0, r3, r4);
        r0 = r2;
        goto L_0x003a;
    L_0x00c5:
        r1 = com.facebook.timeline.aboutpage.CollectionsViewFramer.m13788a(r13);
        r1 = (com.facebook.timeline.aboutpage.views.ContactListCollectionItemView) r1;
        r3 = r0 instanceof com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
        if (r3 == 0) goto L_0x00d9;
    L_0x00cf:
        r0 = (com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel) r0;
        r3 = com.facebook.graphql.enums.GraphQLTimelineAppSectionType.CONTACT;
        r1.mo424a(r0);
        r0 = r2;
        goto L_0x003a;
    L_0x00d9:
        r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel) r0;
        r3 = r12.f13615m;
        r4 = com.facebook.graphql.enums.GraphQLTimelineAppSectionType.CONTACT;
        r1.mo425a(r0, r3, r4);
        goto L_0x0039;
    L_0x00e4:
        r3 = f13609x;
        r3 = r3.length;
        if (r1 < r3) goto L_0x00f9;
    L_0x00e9:
        r0 = (com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel) r0;
        r3 = f13610y;
        r4 = f13609x;
        r4 = r4.length;
        r1 = r1 - r4;
        r1 = r3[r1];
        r12.m14812a(r13, r0, r1);
        r0 = r2;
        goto L_0x003a;
    L_0x00f9:
        r1 = r0;
        r1 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel) r1;
        r8 = r1.nQ_();
        r0 = r1.m14588o();
        if (r0 == 0) goto L_0x0139;
    L_0x0106:
        r0 = r1.m14588o();
        r0 = r0.m14562a();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0139;
    L_0x0114:
        r0 = r1.m14588o();
        r0 = r0.m14562a();
        r0 = r0.get(r5);
        r0 = (com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel) r0;
        r0 = r0.mo398j();
        r7 = r0;
    L_0x0127:
        r0 = r12.f13613k;
        r3 = r12.f13615m;
        r4 = r12.f13624v;
        r5 = r12.f13618p;
        r6 = r12.f13625w;
        r2 = r13;
        r0.m14951a(r1, r2, r3, r4, r5, r6);
        r2 = r7;
        r0 = r8;
        goto L_0x003a;
    L_0x0139:
        r7 = r2;
        goto L_0x0127;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.summary.CollectionsSummaryCursorAdaptor.a(android.view.View, android.database.Cursor):void");
    }

    public int getItemViewType(int i) {
        ModelCursor modelCursor = (ModelCursor) a();
        if (modelCursor == null || i >= modelCursor.getCount()) {
            return ViewTypeUtil.m14803a(PositionInCard.FULL_CARD, f13608B);
        }
        PositionInCard positionInCard;
        Preconditions.checkState(modelCursor.moveToPosition(i));
        int f = modelCursor.f();
        if ((f & 2) == 2) {
            positionInCard = PositionInCard.FIRST;
        } else if ((f & 4) == 4) {
            positionInCard = PositionInCard.MIDDLE;
        } else if ((f & 8) == 8) {
            positionInCard = PositionInCard.LAST;
        } else {
            positionInCard = PositionInCard.FULL_CARD;
        }
        PositionInCard positionInCard2 = positionInCard;
        return ViewTypeUtil.m14803a(positionInCard2, m14806a(i, positionInCard2));
    }

    private int m14806a(int i, PositionInCard positionInCard) {
        if (i == 0) {
            return (f13609x.length + f13610y.length) + ExtraViewTypes.INVISIBLE_PROFILE_DATA.ordinal();
        }
        ModelCursor modelCursor = (ModelCursor) a();
        if (this.f13619q && i >= modelCursor.getCount()) {
            return f13608B;
        }
        modelCursor.moveToPosition(i);
        BaseModel baseModel = (BaseModel) m14811a(modelCursor);
        if (baseModel instanceof ProfileFieldInfoModel) {
            ProfileFieldInfoModel profileFieldInfoModel = (ProfileFieldInfoModel) baseModel;
            return ((GraphQLProfileFieldStyle) profileFieldInfoModel.m14041b().get(0)).ordinal() + f13609x.length;
        } else if ((baseModel instanceof AppCollectionItemModel) || (baseModel instanceof CollectionsAppSectionRequestableFieldModel)) {
            int i2;
            if ((modelCursor.f() & 16) == 16) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                return (f13609x.length + f13610y.length) + ExtraViewTypes.ABOUT_LIST_ITEM_MIDDLE.ordinal();
            }
            return (f13609x.length + f13610y.length) + ExtraViewTypes.LIST_ITEM_MIDDLE.ordinal();
        } else if (baseModel instanceof CollectionsAppSectionWithItemsOrRequestablesModel) {
            switch (positionInCard) {
                case FIRST:
                    return (f13609x.length + f13610y.length) + ExtraViewTypes.SECTION_COLLECTION_HEADER.ordinal();
                case LAST:
                    return (f13609x.length + f13610y.length) + ExtraViewTypes.ABOUT_MORE_ABOUT.ordinal();
                default:
                    GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle;
                    CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel = (CollectionsAppSectionWithItemsOrRequestablesModel) baseModel;
                    if (collectionsAppSectionWithItemsOrRequestablesModel == null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().isEmpty() || collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0) == null) {
                        graphQLTimelineAppCollectionStyle = GraphQLTimelineAppCollectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    } else {
                        graphQLTimelineAppCollectionStyle = this.f13617o.m14916a(((CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0)).mo396d());
                    }
                    return graphQLTimelineAppCollectionStyle.ordinal();
            }
        } else if (baseModel instanceof ProfileFieldSectionInfoModel) {
            return (f13609x.length + f13610y.length) + ExtraViewTypes.PROFILE_FIELD_SECTION_HEADER.ordinal();
        } else {
            return (f13609x.length + f13610y.length) + ExtraViewTypes.UNKNOWN_TYPE.ordinal();
        }
    }
}
