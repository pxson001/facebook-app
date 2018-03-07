package com.facebook.nearby.v2.resultlist.views.itemview;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: daily_dialogue_update */
public class NearbyPlacesResultListItemHeaderView extends CustomRelativeLayout {
    private static final CallerContext f15974a = CallerContext.a(NearbyPlacesResultListItemHeaderView.class);
    private Context f15975b;
    private final FbDraweeView f15976c;
    private final TextView f15977d;
    private final TextView f15978e;
    private final TextView f15979f;
    private HeaderViewType f15980g;

    /* compiled from: daily_dialogue_update */
    public enum HeaderViewType {
        SMALL,
        MEDIUM,
        LARGE
    }

    public NearbyPlacesResultListItemHeaderView(Context context) {
        this(context, null);
    }

    public NearbyPlacesResultListItemHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesResultListItemHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905401);
        this.f15975b = context;
        this.f15977d = (TextView) a(2131564142);
        this.f15978e = (TextView) a(2131564143);
        this.f15979f = (TextView) a(2131564144);
        this.f15976c = (FbDraweeView) a(2131564140);
    }

    public final void m18793a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, HeaderViewType headerViewType) {
        Object obj;
        int i = 8;
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        Preconditions.checkNotNull(nearbyPlacesPlaceModel.m17737a());
        this.f15980g = headerViewType;
        this.f15977d.setText(nearbyPlacesPlaceModel.m17737a());
        this.f15977d.setVisibility(0);
        this.f15978e.setText(m18791b(nearbyPlacesPlaceModel.m17747k()));
        CharSequence a = m18789a(nearbyPlacesPlaceModel.m17745i());
        this.f15979f.setText(a);
        if (nearbyPlacesPlaceModel.m17740d() == null || nearbyPlacesPlaceModel.f15301a.mo919A()) {
            obj = null;
        } else {
            obj = nearbyPlacesPlaceModel.m17740d().m17807d();
        }
        m18792c(m18788a(this.f15980g));
        switch (headerViewType) {
            case SMALL:
                this.f15976c.setVisibility(obj != null ? 0 : 8);
                this.f15978e.setVisibility(0);
                this.f15979f.setVisibility(8);
                break;
            case MEDIUM:
                FbDraweeView fbDraweeView = this.f15976c;
                if (obj != null) {
                    i = 0;
                }
                fbDraweeView.setVisibility(i);
                this.f15978e.setVisibility(0);
                this.f15979f.setVisibility(0);
                break;
            case LARGE:
                this.f15976c.setVisibility(8);
                this.f15978e.setVisibility(0);
                TextView textView = this.f15979f;
                if (!StringUtil.a(a)) {
                    i = 0;
                }
                textView.setVisibility(i);
                break;
            default:
                throw new IllegalArgumentException("Undefined Header View State");
        }
        if (!StringUtil.a(obj)) {
            this.f15976c.a(Uri.parse(obj), f15974a);
        }
    }

    private int m18788a(HeaderViewType headerViewType) {
        int i;
        switch (headerViewType) {
            case SMALL:
                i = 2131430885;
                break;
            case MEDIUM:
                i = 2131430886;
                break;
            default:
                i = 0;
                break;
        }
        if (i != 0) {
            return (int) getResources().getDimension(i);
        }
        return 0;
    }

    private void m18792c(int i) {
        this.f15976c.getLayoutParams().height = i;
        this.f15976c.getLayoutParams().width = i;
        this.f15976c.requestLayout();
    }

    private String m18789a(ImmutableList<String> immutableList) {
        if (Strings.isNullOrEmpty(m18790a(immutableList, getResources().getString(2131236701), 3))) {
            return "";
        }
        return this.f15975b.getString(2131236702, new Object[]{r0});
    }

    private static String m18791b(ImmutableList<String> immutableList) {
        return m18790a(immutableList, " · ", 3);
    }

    private static String m18790a(ImmutableList<String> immutableList, String str, int i) {
        if (str == null) {
            str = "";
        }
        if (immutableList == null || immutableList.isEmpty() || i <= 0) {
            return "";
        }
        if (immutableList.size() == 1) {
            return (String) immutableList.get(0);
        }
        return StringUtil.b(str, new Object[]{immutableList.subList(0, Math.min(immutableList.size(), i))});
    }
}
