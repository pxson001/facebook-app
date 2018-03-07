package com.facebook.tagging.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.adapter.filters.MentionsTagTypeaheadFilter;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfileSectionHeader;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: dialtone_optin_interstitial */
public final class MentionsTagTypeaheadAdapter extends MultiSourceTagTypeaheadAdapter {
    public final GroupMembersTaggingTypeaheadDataSourceProvider f17327b;
    private final Comparator<TaggingProfile> f17328c = new GroupMembersComparator(this);
    public boolean f17329d = false;
    public QeAccessor f17330e;
    public GroupMembersTaggingTypeaheadDataSource f17331f;
    public Context f17332g;

    /* compiled from: dialtone_optin_interstitial */
    class GroupMembersComparator implements Comparator<TaggingProfile> {
        final /* synthetic */ MentionsTagTypeaheadAdapter f17320a;

        private static int m25156a(TaggingProfile taggingProfile) {
            boolean isGroupTagTypeaheadDataType = TagTypeaheadDataType.valueOf(taggingProfile.f17545h).isGroupTagTypeaheadDataType();
            return taggingProfile instanceof TaggingProfileSectionHeader ? isGroupTagTypeaheadDataType ? 0 : 2 : isGroupTagTypeaheadDataType ? 1 : 3;
        }

        public GroupMembersComparator(MentionsTagTypeaheadAdapter mentionsTagTypeaheadAdapter) {
            this.f17320a = mentionsTagTypeaheadAdapter;
        }

        public int compare(Object obj, Object obj2) {
            TaggingProfile taggingProfile = (TaggingProfile) obj2;
            int a = m25156a((TaggingProfile) obj);
            int a2 = m25156a(taggingProfile);
            if (a == a2) {
                return 0;
            }
            return a < a2 ? -1 : 1;
        }
    }

    /* compiled from: dialtone_optin_interstitial */
    public enum ViewType {
        ITEM_VIEW,
        SECTION_HEADER_VIEW
    }

    public static MentionsTagTypeaheadAdapter m25172d(InjectorLike injectorLike) {
        return new MentionsTagTypeaheadAdapter((Context) injectorLike.getInstance(Context.class), new MentionsTagTypeaheadFilter(DefaultAndroidThreadUtil.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 11099), IdBasedProvider.a(injectorLike, 11097), IdBasedProvider.a(injectorLike, 775), IdBasedProvider.a(injectorLike, 11101)), (GroupMembersTaggingTypeaheadDataSourceProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupMembersTaggingTypeaheadDataSourceProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MentionsTagTypeaheadAdapter(Context context, MentionsTagTypeaheadFilter mentionsTagTypeaheadFilter, GroupMembersTaggingTypeaheadDataSourceProvider groupMembersTaggingTypeaheadDataSourceProvider, QeAccessor qeAccessor) {
        super(context, mentionsTagTypeaheadFilter);
        this.f17327b = groupMembersTaggingTypeaheadDataSourceProvider;
        this.f17330e = qeAccessor;
        this.f17332g = context;
    }

    public final void m25175a(TagTypeaheadDataSource tagTypeaheadDataSource) {
        m25164a(tagTypeaheadDataSource, false);
    }

    public final void mo1304a(CharSequence charSequence, List<TaggingProfile> list) {
        if (this.f17329d) {
            m25168b(false);
            mo1305a();
            ImmutableList a = m25170a((List) list);
            if (!(this.f17331f == null || CollectionUtil.a(a))) {
                ImmutableList d = this.f17331f.mo1319d();
                int size = d.size();
                for (int i = 0; i < size; i++) {
                    TagTypeaheadDataType valueOf = TagTypeaheadDataType.valueOf((String) d.get(i));
                    if (a.size() != 0) {
                        int size2 = a.size();
                        int i2 = 0;
                        Object obj = null;
                        while (i2 < size2) {
                            Object obj2;
                            TaggingProfile taggingProfile = (TaggingProfile) a.get(i2);
                            if (valueOf.toString().equals(taggingProfile.f17545h) && m25169c(taggingProfile)) {
                                obj2 = 1;
                            } else {
                                obj2 = obj;
                            }
                            i2++;
                            obj = obj2;
                        }
                        if (obj != null) {
                            m25169c(new TaggingProfileSectionHeader(this.f17332g.getString(valueOf.getCustomizedNameResourceId()), null, valueOf.toString()));
                        }
                    }
                }
            }
            m25154a(this.f17328c);
            m25168b(true);
            return;
        }
        super.mo1304a(charSequence, (List) list);
    }

    public final int getItemViewType(int i) {
        return m25171c(i).ordinal();
    }

    private ViewType m25171c(int i) {
        return m25173d(i) ? ViewType.SECTION_HEADER_VIEW : ViewType.ITEM_VIEW;
    }

    public final int getViewTypeCount() {
        return ViewType.values().length;
    }

    protected final int mo1309b(int i) {
        if (i == ViewType.SECTION_HEADER_VIEW.ordinal()) {
            return 2130907373;
        }
        return 2130907137;
    }

    public final void mo1308a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (ViewType.values()[i2]) {
            case ITEM_VIEW:
                super.mo1308a(i, obj, view, i2, viewGroup);
                return;
            case SECTION_HEADER_VIEW:
                TaggingProfileSectionHeader taggingProfileSectionHeader = (TaggingProfileSectionHeader) obj;
                ((TextView) view.findViewById(2131558927)).setText(taggingProfileSectionHeader.f17547a);
                TextView textView = (TextView) view.findViewById(2131558926);
                if (Strings.isNullOrEmpty(taggingProfileSectionHeader.f17548b)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setVisibility(0);
                textView.setText(taggingProfileSectionHeader.f17548b);
                return;
            default:
                return;
        }
    }

    private boolean m25173d(int i) {
        return m25149a(i) instanceof TaggingProfileSectionHeader;
    }

    private ImmutableList m25170a(List<TaggingProfile> list) {
        Builder builder = new Builder();
        if (CollectionUtil.a(list)) {
            return builder.b();
        }
        builder.b(list);
        if (!this.f17326f) {
            for (int i = 0; i < getCount(); i++) {
                if (!m25173d(i)) {
                    builder.c(m25149a(i));
                }
            }
        }
        return builder.b();
    }
}
