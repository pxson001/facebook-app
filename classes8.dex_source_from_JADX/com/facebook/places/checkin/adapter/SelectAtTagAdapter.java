package com.facebook.places.checkin.adapter;

import android.content.Context;
import android.location.Location;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.utils.CheckinTextModifier;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: clauses */
public class SelectAtTagAdapter extends BaseAdapter {
    PlaceCreationAnalyticsLogger f18003a;
    public Location f18004b;
    public Locale f18005c;
    public String f18006d = "";
    public SearchResults f18007e = new SearchResults();
    public SelectAtTagRowSection f18008f;
    public AddHomeSection f18009g;
    public AddPlaceSection f18010h;
    public UseAsTextSection f18011i;
    public TextOnlySection f18012j;
    private int f18013k = 0;
    public final List<AdapterSection> f18014l = Lists.a();
    private final HashMap<RowType, AdapterSection> f18015m = new HashMap();
    public final ArrayList<Pair<RowType, Object>> f18016n = new ArrayList();
    public boolean f18017o;

    private static SelectAtTagAdapter m21978b(InjectorLike injectorLike) {
        return new SelectAtTagAdapter(LocaleMethodAutoProvider.b(injectorLike), PlaceCreationAnalyticsLogger.a(injectorLike), new SelectAtTagRowSection(LayoutInflaterMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), CheckinTextModifier.m22087a(injectorLike), LocaleMethodAutoProvider.b(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike)), AddPlaceSection.m21970b(injectorLike), AddHomeSection.m21964b(injectorLike), UseAsTextSection.m22003b(injectorLike), TextOnlySection.m21995b(injectorLike));
    }

    public static SelectAtTagAdapter m21976a(InjectorLike injectorLike) {
        return m21978b(injectorLike);
    }

    @Inject
    public SelectAtTagAdapter(Locale locale, PlaceCreationAnalyticsLogger placeCreationAnalyticsLogger, SelectAtTagRowSection selectAtTagRowSection, AddPlaceSection addPlaceSection, AddHomeSection addHomeSection, UseAsTextSection useAsTextSection, TextOnlySection textOnlySection) {
        this.f18005c = locale;
        this.f18003a = placeCreationAnalyticsLogger;
        this.f18008f = selectAtTagRowSection;
        this.f18010h = addPlaceSection;
        this.f18009g = addHomeSection;
        this.f18011i = useAsTextSection;
        this.f18012j = textOnlySection;
        this.f18014l.add(this.f18012j);
        this.f18014l.add(this.f18009g);
        this.f18014l.add(this.f18008f);
        this.f18014l.add(this.f18010h);
        this.f18014l.add(this.f18011i);
        m21979f();
    }

    private void m21979f() {
        int i = 0;
        for (AdapterSection adapterSection : this.f18014l) {
            if (adapterSection.mo1070c()) {
                m21977a(adapterSection.mo1069b(), adapterSection);
                this.f18015m.put(adapterSection.mo1069b(), adapterSection);
                i++;
            }
            m21977a(adapterSection.mo1064a(), adapterSection);
            this.f18015m.put(adapterSection.mo1064a(), adapterSection);
            i++;
        }
        this.f18013k = i;
    }

    private void m21977a(RowType rowType, AdapterSection adapterSection) {
        if (rowType == RowType.Undefined) {
            throw new RuntimeException(adapterSection.getClass().getCanonicalName() + " did not define the correct type");
        } else if (this.f18015m.get(rowType) != null) {
            throw new RuntimeException(adapterSection.getClass().getCanonicalName() + " declared a type already used: " + rowType);
        }
    }

    public int getCount() {
        return this.f18016n.size();
    }

    public Object getItem(int i) {
        return ((Pair) this.f18016n.get(i)).second;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (i >= this.f18016n.size()) {
            return -1;
        }
        return ((RowType) ((Pair) this.f18016n.get(i)).first).ordinal();
    }

    public int getViewTypeCount() {
        return this.f18013k;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return ((AdapterSection) this.f18015m.get(((Pair) this.f18016n.get(i)).first)).mo1063a(view, viewGroup, ((Pair) this.f18016n.get(i)).second);
    }

    public boolean areAllItemsEnabled() {
        int size = this.f18016n.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) this.f18016n.get(i);
            if (!((AdapterSection) this.f18015m.get(pair.first)).mo1067a(pair.second)) {
                return false;
            }
        }
        return super.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        Pair pair = (Pair) this.f18016n.get(i);
        return ((AdapterSection) this.f18015m.get(pair.first)).mo1067a(pair.second);
    }

    public void notifyDataSetChanged() {
        for (AdapterSection d : this.f18014l) {
            d.mo1071d();
        }
        this.f18016n.clear();
        for (AdapterSection d2 : this.f18014l) {
            d2.mo1065a(this.f18016n);
        }
        for (CheckinPlaceModel checkinPlaceModel : this.f18007e.b) {
            Iterator it = this.f18014l.iterator();
            while (it.hasNext() && !((AdapterSection) it.next()).mo1066a(checkinPlaceModel, this.f18016n)) {
            }
        }
        for (AdapterSection d22 : this.f18014l) {
            d22.mo1068b(this.f18016n);
        }
        super.notifyDataSetChanged();
    }
}
