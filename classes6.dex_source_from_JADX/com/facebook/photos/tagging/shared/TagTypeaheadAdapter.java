package com.facebook.photos.tagging.shared;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.Filter.FilterResults;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.tagging.model.TaggingProfileSectionHeader;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: has_limited_objects */
public class TagTypeaheadAdapter extends ArrayAdapter<TaggingProfile> {
    private static final CallerContext f13359a = CallerContext.a(TagTypeaheadAdapter.class, "photo_tag_friends");
    public final TagTypeaheadDataSource f13360b;
    public TagTypeaheadAdapterCallback f13361c;
    public List<TaggingProfile> f13362d;
    private Filter f13363e = new TagTypeaheadFilter(this);
    public boolean f13364f;
    public DefaultAndroidThreadUtil f13365g;
    public FilterListener f13366h;

    /* compiled from: has_limited_objects */
    public interface TagTypeaheadAdapterCallback {
        boolean m21014a(String str);

        boolean m21015b(String str);
    }

    /* compiled from: has_limited_objects */
    class TagTypeaheadFilter extends Filter {
        final /* synthetic */ TagTypeaheadAdapter f13358a;

        /* compiled from: has_limited_objects */
        class C08631 implements SourceResultsListener {
            final /* synthetic */ TagTypeaheadFilter f13357a;

            C08631(TagTypeaheadFilter tagTypeaheadFilter) {
                this.f13357a = tagTypeaheadFilter;
            }

            public final void mo1121a(final CharSequence charSequence, List<TaggingProfile> list) {
                final FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                filterResults.count = list == null ? 0 : list.size();
                this.f13357a.f13358a.f13365g.b(new Runnable(this) {
                    final /* synthetic */ C08631 f13356c;

                    public void run() {
                        this.f13356c.f13357a.publishResults(charSequence, filterResults);
                    }
                });
            }
        }

        public TagTypeaheadFilter(TagTypeaheadAdapter tagTypeaheadAdapter) {
            this.f13358a = tagTypeaheadAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            if (StringUtil.a(charSequence)) {
                filterResults = new FilterResults();
                filterResults.values = new ArrayList();
                filterResults.count = 0;
                return filterResults;
            } else if (this.f13358a.f13360b.mo1315a()) {
                String charSequence2;
                TagTypeaheadDataSource tagTypeaheadDataSource = this.f13358a.f13360b;
                if (charSequence != null) {
                    charSequence2 = charSequence.toString();
                } else {
                    charSequence2 = "";
                }
                tagTypeaheadDataSource.mo1314a(charSequence, charSequence2, true, true, true, true, true, new C08631(this));
                return null;
            } else {
                List a = this.f13358a.f13360b.mo1318a(charSequence, true, true, true, true);
                filterResults = new FilterResults();
                filterResults.values = a;
                filterResults.count = a.size();
                return filterResults;
            }
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (!this.f13358a.f13364f) {
                return;
            }
            if (!this.f13358a.m21037d() || filterResults != null) {
                if (this.f13358a.f13366h != null) {
                    this.f13358a.f13366h.onFilterComplete(filterResults.count);
                }
                this.f13358a.setNotifyOnChange(false);
                this.f13358a.clear();
                if (StringUtil.a(charSequence)) {
                    this.f13358a.m21029e();
                    AdapterDetour.a(this.f13358a, -1600373290);
                } else if (filterResults == null || filterResults.count <= 0 || filterResults.values == null) {
                    this.f13358a.setNotifyOnChange(true);
                    AdapterDetour.b(this.f13358a, 212534798);
                } else {
                    TagTypeaheadAdapter.m21026b(this.f13358a, (List) filterResults.values);
                    AdapterDetour.a(this.f13358a, -1089856536);
                }
            }
        }
    }

    /* compiled from: has_limited_objects */
    public enum ViewType {
        ITEM_VIEW,
        SECTION_HEADER_VIEW
    }

    public TagTypeaheadAdapter(Context context, TagTypeaheadDataSource tagTypeaheadDataSource, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        super(context, 2130907368, new ArrayList());
        this.f13360b = tagTypeaheadDataSource;
        this.f13365g = defaultAndroidThreadUtil;
    }

    public final void m21033a(@Nullable TagTypeaheadAdapterCallback tagTypeaheadAdapterCallback) {
        this.f13361c = tagTypeaheadAdapterCallback;
    }

    public final void m21034a(List<TaggingProfile> list) {
        this.f13362d = list;
    }

    public final void m21031a() {
        this.f13363e.filter("");
    }

    public final void m21035b() {
        this.f13364f = true;
    }

    public final void m21036c() {
        this.f13364f = false;
    }

    public int getItemViewType(int i) {
        return m21019a(i).ordinal();
    }

    private ViewType m21019a(int i) {
        return getItem(i) instanceof TaggingProfileSectionHeader ? ViewType.SECTION_HEADER_VIEW : ViewType.ITEM_VIEW;
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (ViewType.values()[getItemViewType(i)].equals(ViewType.ITEM_VIEW)) {
            return m21024b(i, view, viewGroup);
        }
        return m21018a(i, view, viewGroup);
    }

    private View m21018a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130907367, viewGroup, false);
        }
        ((TextView) view.findViewById(2131567821)).setText(((TaggingProfileSectionHeader) getItem(i)).f17547a);
        view.setOnClickListener(null);
        return view;
    }

    private View m21024b(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130907368, viewGroup, false);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131567822);
        TextView textView = (TextView) view.findViewById(2131567823);
        TaggingProfile taggingProfile = (TaggingProfile) getItem(i);
        if (taggingProfile.f17540c != null && taggingProfile.f17542e != Type.TEXT) {
            fbDraweeView.a(Uri.parse(taggingProfile.f17540c), f13359a);
            fbDraweeView.setVisibility(0);
        } else if (taggingProfile.f17542e == Type.TEXT) {
            fbDraweeView.setVisibility(4);
        }
        if (taggingProfile.f17540c == null) {
            fbDraweeView.a(null, f13359a);
        }
        textView.setText(taggingProfile.f17538a.i());
        return view;
    }

    public Filter getFilter() {
        return this.f13363e;
    }

    public final boolean m21037d() {
        return this.f13360b.mo1315a();
    }

    public final void m21032a(FilterListener filterListener) {
        this.f13366h = filterListener;
    }

    private void m21029e() {
        if (this.f13362d != null && !this.f13362d.isEmpty()) {
            for (TaggingProfile taggingProfile : this.f13362d) {
                if (m21023a(taggingProfile)) {
                    add(taggingProfile);
                }
            }
        }
    }

    public static void m21026b(TagTypeaheadAdapter tagTypeaheadAdapter, List list) {
        ImmutableList<String> d = tagTypeaheadAdapter.f13360b.mo1319d();
        boolean z = d.size() > 1;
        for (String valueOf : d) {
            tagTypeaheadAdapter.m21022a(list, TagTypeaheadDataType.valueOf(valueOf), z);
        }
    }

    private void m21022a(List<TaggingProfile> list, TagTypeaheadDataType tagTypeaheadDataType, boolean z) {
        Object obj = null;
        for (TaggingProfile taggingProfile : list) {
            if (taggingProfile != null) {
                Object obj2;
                if (m21023a(taggingProfile) && tagTypeaheadDataType.toString().equals(taggingProfile.f17545h)) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null && r1 == null && z) {
                    String string = getContext().getString(tagTypeaheadDataType.getCustomizedNameResourceId());
                    add(new TaggingProfileSectionHeader(string, string, tagTypeaheadDataType.toString()));
                    obj = 1;
                }
                if (obj2 != null) {
                    add(taggingProfile);
                }
            }
        }
    }

    private boolean m21023a(TaggingProfile taggingProfile) {
        if (taggingProfile == null) {
            return false;
        }
        boolean b = this.f13361c != null ? Type.TEXT.equals(taggingProfile.f17542e) ? this.f13361c.m21015b(taggingProfile.m25532i()) : this.f13361c.m21014a(String.valueOf(taggingProfile.f17539b)) : false;
        if (b) {
            return false;
        }
        return true;
    }
}
