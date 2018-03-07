package com.facebook.messaging.business.common.view.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Space;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.model.BusinessBottomSheetItem;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideProvidersQueryModel.MessengerCommerceModel.RideProvidersModel;
import com.facebook.messaging.business.ride.helper.RideOauthHelper;
import com.facebook.messaging.business.ride.helper.RideOauthHelper.C10612;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import java.util.ArrayList;

/* compiled from: native_sign_up */
public class BusinessBottomSheetAdapter extends Adapter<ViewHolder> {
    public Context f8816a;
    public ArrayList<BusinessBottomSheetItem> f8817b = new ArrayList();
    @Nullable
    public C10612 f8818c;

    /* compiled from: native_sign_up */
    public class LogoItemViewHolder extends ViewHolder {
        public FbDraweeView f8812l;
        public BetterTextView f8813m;
        public BetterTextView f8814n;
        public BetterTextView f8815o;

        public LogoItemViewHolder(View view) {
            super(view);
            this.f8812l = (FbDraweeView) view.findViewById(2131560067);
            this.f8813m = (BetterTextView) view.findViewById(2131560068);
            this.f8814n = (BetterTextView) view.findViewById(2131560069);
            this.f8815o = (BetterTextView) view.findViewById(2131560070);
        }
    }

    /* compiled from: native_sign_up */
    public class PaddingViewHolder extends ViewHolder {
        public PaddingViewHolder(View view) {
            super(view);
        }
    }

    public BusinessBottomSheetAdapter(Context context) {
        this.f8816a = context;
    }

    public final ViewHolder m9038a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f8816a);
        if (i == 0) {
            return new LogoItemViewHolder(from.inflate(2130903459, viewGroup, false));
        }
        if (i == 1) {
            View space = new Space(this.f8816a);
            space.setLayoutParams(new LayoutParams(-1, this.f8816a.getResources().getDimensionPixelOffset(2131430983)));
            return new PaddingViewHolder(space);
        }
        throw new IllegalArgumentException("Invalid view type for creating view holder.");
    }

    public final void m9039a(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                final BusinessBottomSheetItem businessBottomSheetItem = (BusinessBottomSheetItem) this.f8817b.get(i - 1);
                LogoItemViewHolder logoItemViewHolder = (LogoItemViewHolder) viewHolder;
                String str = businessBottomSheetItem.f8778c;
                if (Strings.isNullOrEmpty(str)) {
                    logoItemViewHolder.f8813m.setVisibility(8);
                } else {
                    logoItemViewHolder.f8813m.setVisibility(0);
                    logoItemViewHolder.f8813m.setText(str);
                }
                str = businessBottomSheetItem.f8779d;
                if (Strings.isNullOrEmpty(str)) {
                    logoItemViewHolder.f8814n.setVisibility(8);
                } else {
                    logoItemViewHolder.f8814n.setVisibility(0);
                    logoItemViewHolder.f8814n.setText(str);
                }
                str = businessBottomSheetItem.f8780e;
                if (Strings.isNullOrEmpty(str)) {
                    logoItemViewHolder.f8815o.setVisibility(8);
                } else {
                    logoItemViewHolder.f8815o.setVisibility(0);
                    logoItemViewHolder.f8815o.setText(str);
                }
                str = businessBottomSheetItem.f8776a;
                if (!Strings.isNullOrEmpty(str)) {
                    logoItemViewHolder.f8812l.a(Uri.parse(str), CallerContext.a(BusinessBottomSheetAdapter.class));
                }
                Drawable drawable = businessBottomSheetItem.f8777b;
                if (drawable != null) {
                    ((GenericDraweeHierarchy) logoItemViewHolder.f8812l.getHierarchy()).b(drawable);
                }
                logoItemViewHolder.a.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BusinessBottomSheetAdapter f8811b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1367976645);
                        if (this.f8811b.f8818c != null) {
                            int i;
                            C10612 c10612 = this.f8811b.f8818c;
                            BusinessBottomSheetAdapter businessBottomSheetAdapter = this.f8811b;
                            BusinessBottomSheetItem businessBottomSheetItem = businessBottomSheetItem;
                            int i2 = 0;
                            loop0:
                            while (i2 < businessBottomSheetAdapter.f8817b.size()) {
                                int size = businessBottomSheetAdapter.f8817b.size();
                                i = i2;
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (((BusinessBottomSheetItem) businessBottomSheetAdapter.f8817b.get(i3)).equals(businessBottomSheetItem)) {
                                        break loop0;
                                    }
                                    i++;
                                }
                                i2 = i;
                            }
                            i = -1;
                            int i4 = i;
                            c10612.f9214a.dismiss();
                            c10612.f9217d.f9229h.m9366a(c10612.f9215b, ((RideProvidersModel) c10612.f9216c.get(i4)).m9586m(), ((RideProvidersModel) c10612.f9216c.get(i4)).m9584k());
                            RideOauthHelper.m9726a(c10612.f9217d, c10612.f9215b, (RideProvidersModel) c10612.f9216c.get(i4));
                        }
                        if (businessBottomSheetItem.f8781f != null) {
                            businessBottomSheetItem.f8781f.onClick(view);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, 778451488, a);
                    }
                });
                return;
            case 1:
                return;
            default:
                throw new IllegalArgumentException("Invalid view type for binding view holder.");
        }
    }

    public final int aZ_() {
        return this.f8817b.size() + 2;
    }

    public int getItemViewType(int i) {
        Object obj;
        if (i == 0 || i == aZ_() - 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return 1;
        }
        return 0;
    }
}
