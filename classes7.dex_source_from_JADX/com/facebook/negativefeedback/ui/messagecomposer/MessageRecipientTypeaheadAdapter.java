package com.facebook.negativefeedback.ui.messagecomposer;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.negativefeedback.ui.messagecomposer.MessageRecipientTypeaheadFilter.FilterResultsListener;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: no_disclaimer */
public class MessageRecipientTypeaheadAdapter extends BaseAdapter implements Filterable, FilterResultsListener {
    private static final CallerContext f8114a = CallerContext.a(MessageRecipientTypeaheadAdapter.class);
    private static final int f8115b = 2130905229;
    private final Context f8116c;
    private final MessageRecipientTypeaheadFilter f8117d;
    private final List<TaggingProfile> f8118e;

    public /* synthetic */ Object getItem(int i) {
        return m9771a(i);
    }

    @Inject
    public MessageRecipientTypeaheadAdapter(Context context, MessageRecipientTypeaheadFilter messageRecipientTypeaheadFilter) {
        this.f8117d = messageRecipientTypeaheadFilter;
        this.f8116c = context;
        this.f8118e = new ArrayList();
    }

    public final void mo448a(List<TaggingProfile> list) {
        if (list != null) {
            this.f8118e.clear();
            this.f8118e.addAll(list);
            AdapterDetour.a(this, -1657784945);
        }
    }

    public int getCount() {
        return this.f8118e.size();
    }

    private TaggingProfile m9771a(int i) {
        return (TaggingProfile) this.f8118e.get(i);
    }

    public long getItemId(int i) {
        return ((TaggingProfile) this.f8118e.get(i)).b;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8116c).inflate(f8115b, viewGroup, false);
        }
        m9772a(i, view);
        return view;
    }

    private void m9772a(int i, View view) {
        TaggingProfile a = m9771a(i);
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131563626);
        if (a.c != null && a.e != Type.TEXT) {
            fbDraweeView.a(Uri.parse(a.c), f8114a);
            fbDraweeView.setVisibility(0);
        } else if (a.e == Type.TEXT) {
            fbDraweeView.setVisibility(4);
        }
        if (a.c == null) {
            fbDraweeView.a(null, f8114a);
        }
        TextView textView = (TextView) view.findViewById(2131563822);
        CharSequence i2 = a.a.i();
        if (i2 == null) {
            i2 = this.f8116c.getString(2131234442);
        }
        textView.setText(i2);
    }

    public Filter getFilter() {
        return this.f8117d;
    }
}
