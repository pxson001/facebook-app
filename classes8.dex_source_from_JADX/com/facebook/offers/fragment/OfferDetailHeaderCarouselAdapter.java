package com.facebook.offers.fragment;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.offers.graphql.OfferQueriesInterfaces.PhotoData;
import com.facebook.offers.graphql.OfferQueriesModels.PhotoDataModel;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import java.util.List;

/* compiled from: custom_cta_check_setup_deeplink */
public class OfferDetailHeaderCarouselAdapter extends Adapter<ViewHolder> implements AdapterCompatibleWithListView<ViewHolder> {
    public static final CallerContext f16189a = CallerContext.a(OfferDetailHeaderCarouselAdapter.class);
    private final Context f16190b;
    private final boolean f16191c;
    public List<? extends PhotoData> f16192d;

    /* compiled from: custom_cta_check_setup_deeplink */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public FbDraweeView f16187l;
        final /* synthetic */ OfferDetailHeaderCarouselAdapter f16188m;

        public ViewHolder(OfferDetailHeaderCarouselAdapter offerDetailHeaderCarouselAdapter, FbDraweeView fbDraweeView) {
            this.f16188m = offerDetailHeaderCarouselAdapter;
            super(fbDraweeView);
            this.f16187l = fbDraweeView;
        }
    }

    public final void m18999a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).f16187l.a(Uri.parse(((PhotoDataModel) this.f16192d.get(i)).m19350a().m19151a()), f16189a);
    }

    public OfferDetailHeaderCarouselAdapter(Context context, boolean z) {
        this.f16190b = context;
        this.f16191c = z;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m18998a(ViewGroup viewGroup, int i) {
        FbDraweeView fbDraweeView = (FbDraweeView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905527, viewGroup, false);
        if (this.f16191c) {
            fbDraweeView.setHierarchy(GenericDraweeHierarchyBuilder.a(this.f16190b.getResources()).f(this.f16190b.getResources().getDrawable(2130841765)).e(ScaleType.g).u());
        }
        return new ViewHolder(this, fbDraweeView);
    }

    public final int aZ_() {
        return this.f16192d.size();
    }

    public final int iy_() {
        return 1;
    }

    public Object getItem(int i) {
        return this.f16192d.get(i);
    }
}
