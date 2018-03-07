package com.facebook.events.invite;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.invite.TypeaheadFilter.TypeaheadFilterListener;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.filter.CustomFilterable;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: char[] */
public class InviteePickerSearchModeAdapter extends FbBaseAdapter implements TypeaheadFilterListener, CustomFilterable {
    private final TypeaheadFilterProvider f17742a;
    private TypeaheadFilter f17743b;
    @Nonnull
    private List<EventInviteeToken> f17744c = Collections.emptyList();
    @Nonnull
    private List<EventInviteeToken> f17745d = Collections.emptyList();
    private ViewFactory f17746e;
    private InviteListController f17747f;

    private static InviteePickerSearchModeAdapter m18080b(InjectorLike injectorLike) {
        return new InviteePickerSearchModeAdapter((TypeaheadFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadFilterProvider.class));
    }

    @Inject
    public InviteePickerSearchModeAdapter(TypeaheadFilterProvider typeaheadFilterProvider) {
        this.f17742a = typeaheadFilterProvider;
    }

    public int getCount() {
        return this.f17745d.size();
    }

    public Object getItem(int i) {
        return this.f17745d.get(i);
    }

    public long getItemId(int i) {
        return Long.parseLong(((EventInviteeToken) this.f17745d.get(i)).g.b());
    }

    public final View m18081a(int i, ViewGroup viewGroup) {
        return this.f17746e.a(viewGroup);
    }

    public final void m18083a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f17746e.a(view, (EventInviteeToken) obj, this.f17747f.m18040a());
    }

    public final CustomFilter m18082a() {
        return this.f17743b;
    }

    public final boolean isEnabled(int i) {
        return ((EventInviteeToken) this.f17745d.get(i)).a();
    }

    public final void mo806a(List<EventInviteeToken> list) {
        this.f17745d = list;
        AdapterDetour.a(this, 1031064316);
    }
}
