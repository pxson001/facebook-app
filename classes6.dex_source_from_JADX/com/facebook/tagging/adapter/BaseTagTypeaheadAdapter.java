package com.facebook.tagging.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.tagging.adapter.filters.BaseTagTypeaheadFilter.FilterResultsListener;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: did_direct_install */
public abstract class BaseTagTypeaheadAdapter extends FbBaseAdapter implements Filterable, FilterResultsListener {
    private static final CallerContext f17312b = CallerContext.a(BaseTagTypeaheadAdapter.class);
    private static final int f17313c = 2130907136;
    public TaggingProfileExclusionFilter f17314a;
    private final Context f17315d;
    public List<TaggingProfile> f17316e;
    public boolean f17317f = true;
    private OnClickListener f17318g;

    /* compiled from: did_direct_install */
    public interface TaggingProfileExclusionFilter {
        boolean mo1310a(long j);
    }

    public /* synthetic */ Object getItem(int i) {
        return m25149a(i);
    }

    public BaseTagTypeaheadAdapter(Context context) {
        this.f17315d = context;
        this.f17316e = new ArrayList();
    }

    public final void m25152a(TaggingProfile taggingProfile) {
        synchronized (this.f17316e) {
            this.f17316e.add(taggingProfile);
        }
        if (this.f17317f) {
            AdapterDetour.a(this, 1486785612);
        }
    }

    public void mo1305a() {
        synchronized (this.f17316e) {
            this.f17316e.clear();
        }
        if (this.f17317f) {
            AdapterDetour.a(this, 2085666790);
        }
    }

    public final void m25154a(Comparator<TaggingProfile> comparator) {
        synchronized (this.f17316e) {
            Collections.sort(this.f17316e, comparator);
        }
        if (this.f17317f) {
            AdapterDetour.a(this, 1752478829);
        }
    }

    public final TaggingProfile m25149a(int i) {
        return (TaggingProfile) this.f17316e.get(i);
    }

    public int getCount() {
        return this.f17316e.size();
    }

    public void notifyDataSetChanged() {
        this.f17317f = true;
        super.notifyDataSetChanged();
    }

    public void mo1304a(CharSequence charSequence, List<TaggingProfile> list) {
        if (list != null) {
            this.f17317f = false;
            mo1305a();
            for (TaggingProfile taggingProfile : list) {
                if (this.f17314a == null || !this.f17314a.mo1310a(taggingProfile.f17539b)) {
                    m25152a(taggingProfile);
                }
            }
            AdapterDetour.a(this, 1687750192);
        }
    }

    public final View m25148a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f17315d).inflate(mo1309b(i), viewGroup, false);
    }

    protected int mo1309b(int i) {
        return f17313c;
    }

    public void mo1308a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        TaggingProfile taggingProfile = (TaggingProfile) obj;
        if (this.f17318g != null) {
            view.setOnClickListener(this.f17318g);
            view.setTag(taggingProfile);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131563626);
        if (taggingProfile.f17540c != null && taggingProfile.f17542e != Type.TEXT) {
            fbDraweeView.a(Uri.parse(taggingProfile.f17540c), f17312b);
            fbDraweeView.setVisibility(0);
        } else if (taggingProfile.f17542e == Type.TEXT) {
            fbDraweeView.setVisibility(4);
        }
        if (taggingProfile.f17540c == null) {
            fbDraweeView.a(null, f17312b);
        }
        TextView textView = (TextView) view.findViewById(2131563822);
        textView.setPadding(0, 0, 0, 0);
        CharSequence i3 = taggingProfile.f17538a.i();
        if (i3 == null) {
            i3 = this.f17315d.getString(2131234442);
        }
        textView.setText(i3);
        TextView textView2 = (TextView) view.findViewById(2131567498);
        String str = taggingProfile.f17541d;
        if (StringUtil.c(str)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
        if ("".equals(str)) {
            textView.setPadding(0, (int) (12.0f * (this.f17315d.getResources().getDisplayMetrics().ydpi / 160.0f)), 0, 0);
            textView2.setVisibility(8);
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
