package com.facebook.friendlist.listadapter;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.friendlist.data.FriendPageListItemModel;
import com.facebook.inject.InjectorLike;
import com.facebook.user.names.NameNormalizer;
import com.facebook.widget.compositeadapter.CompositeAdapter.Model;
import com.facebook.widget.itemslist.ImmutableItemsList;
import com.facebook.widget.itemslist.ImmutableItemsListIndex;
import com.facebook.widget.itemslist.StickyHeaderSectionIndexer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: actionMechanism is not set */
public class FriendListModel implements Filterable, Model, StickyHeaderSectionIndexer {
    private ImmutableItemsListIndex f20387a = ImmutableItemsListIndex.a;
    private final List<FriendPageListItemModel> f20388b = Lists.a();
    private final NameNormalizer f20389c;
    public boolean f20390d;
    public List<FriendPageListItemModel> f20391e;
    private Filter f20392f;
    public String f20393g;

    /* compiled from: actionMechanism is not set */
    class FriendFilter extends Filter {
        final /* synthetic */ FriendListModel f20385a;
        private int f20386b;

        public FriendFilter(FriendListModel friendListModel) {
            this.f20385a = friendListModel;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            String a = StringLocaleUtil.a(charSequence.toString().trim());
            FilterResults filterResults = new FilterResults();
            if (charSequence.length() == 0) {
                filterResults.count = 0;
                filterResults.values = Lists.a();
            } else {
                List a2 = Lists.a();
                List f = FriendListModel.m20655f(this.f20385a);
                if (StringUtil.a(a, this.f20385a.f20393g)) {
                    a2.addAll(this.f20385a.f20391e);
                    f = f.subList(this.f20386b, f.size());
                }
                for (FriendPageListItemModel friendPageListItemModel : r0) {
                    String a3 = StringLocaleUtil.a(friendPageListItemModel.m20577b());
                    for (String startsWith : a3.split("\\s")) {
                        if (startsWith.startsWith(a) || a3.startsWith(a)) {
                            a2.add(friendPageListItemModel);
                            break;
                        }
                    }
                }
                this.f20386b = FriendListModel.m20655f(this.f20385a).size();
                filterResults.count = a2.size();
                filterResults.values = a2;
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            String a = StringLocaleUtil.a(charSequence.toString().trim());
            this.f20385a.f20391e = (List) filterResults.values;
            this.f20385a.f20393g = a;
        }
    }

    public static FriendListModel m20653b(InjectorLike injectorLike) {
        return new FriendListModel(NameNormalizer.b(injectorLike));
    }

    @Inject
    public FriendListModel(NameNormalizer nameNormalizer) {
        this.f20389c = nameNormalizer;
        m20654e();
    }

    public final int m20656a() {
        if (m20665d()) {
            return this.f20391e.size();
        }
        return this.f20387a.d;
    }

    public final Object m20657a(int i) {
        if (m20665d()) {
            return this.f20391e.get(i);
        }
        return this.f20387a.a(i);
    }

    public final int m20662b(int i) {
        if (m20657a(i) instanceof String) {
            return FriendListItemTypes.HEADER.ordinal();
        }
        return FriendListItemTypes.FRIEND.ordinal();
    }

    public final int m20661b() {
        return FriendListItemTypes.values().length;
    }

    public Filter getFilter() {
        if (this.f20392f == null) {
            this.f20392f = new FriendFilter(this);
        }
        return this.f20392f;
    }

    public final void m20659a(List<FriendPageListItemModel> list) {
        Map c = m20663c();
        for (FriendPageListItemModel friendPageListItemModel : list) {
            if (!c.containsKey(Long.valueOf(friendPageListItemModel.m20575a()))) {
                this.f20388b.add(friendPageListItemModel);
            }
        }
        m20654e();
    }

    public final void m20658a(long j) {
        Map c = m20663c();
        if (c.containsKey(Long.valueOf(j))) {
            if (m20665d()) {
                this.f20391e.remove(c.get(Long.valueOf(j)));
            }
            this.f20388b.remove(c.get(Long.valueOf(j)));
        }
        m20654e();
    }

    private void m20654e() {
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        if (this.f20390d) {
            Object obj = "";
            for (FriendPageListItemModel friendPageListItemModel : this.f20388b) {
                if (!StringUtil.a(friendPageListItemModel.f20302d)) {
                    Builder builder3;
                    String str = friendPageListItemModel.f20302d;
                    String substring = str.substring(0, str.offsetByCodePoints(0, 1));
                    str = this.f20389c.a(substring);
                    if (str.equals(obj)) {
                        str = obj;
                        builder3 = builder2;
                    } else {
                        ImmutableItemsList immutableItemsList = new ImmutableItemsList(builder2.b(), true);
                        if (immutableItemsList.a() != 0) {
                            builder.c(immutableItemsList);
                        }
                        builder3 = ImmutableList.builder();
                        builder3.c(substring);
                    }
                    builder3.c(friendPageListItemModel);
                    builder2 = builder3;
                    obj = str;
                }
            }
            builder.c(new ImmutableItemsList(builder2.b(), true));
        } else {
            builder2.b(this.f20388b);
            builder.c(new ImmutableItemsList(builder2.b(), false));
        }
        this.f20387a = new ImmutableItemsListIndex(builder.b());
    }

    public static synchronized List m20655f(FriendListModel friendListModel) {
        List a;
        synchronized (friendListModel) {
            a = Lists.a(friendListModel.f20388b);
        }
        return a;
    }

    public final Map<Long, FriendPageListItemModel> m20663c() {
        Map hashMap = new HashMap();
        for (FriendPageListItemModel friendPageListItemModel : this.f20388b) {
            hashMap.put(Long.valueOf(friendPageListItemModel.m20575a()), friendPageListItemModel);
        }
        return hashMap;
    }

    public final void m20660a(boolean z) {
        this.f20390d = z;
        m20654e();
    }

    public final boolean m20665d() {
        return !StringUtil.a(this.f20393g);
    }

    public final boolean z_(int i) {
        return !m20665d() && this.f20387a.z_(i);
    }

    public final boolean m20664c(int i) {
        return this.f20387a.c(i);
    }

    public Object[] getSections() {
        return this.f20387a.getSections();
    }

    public int getPositionForSection(int i) {
        return this.f20387a.getPositionForSection(i);
    }

    public int getSectionForPosition(int i) {
        return this.f20387a.getSectionForPosition(i);
    }
}
