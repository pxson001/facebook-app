package com.facebook.feedplugins.placetips;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;

/* compiled from: friend_suggestions_cancel */
public class PlaceTipsFeedUnitView extends SegmentedLinearLayout {
    public final ImageBlockLayout f12919a = ((ImageBlockLayout) a(2131566045));
    @Nullable
    public TextView f12920b = null;
    private final TextWithEntitiesView f12921c = ((TextWithEntitiesView) a(2131566047));
    private final TextWithEntitiesView f12922d = ((TextWithEntitiesView) a(2131566046));
    @Nullable
    private View f12923e;

    public PlaceTipsFeedUnitView(Context context) {
        super(context);
        setContentView(2130906282);
        setOrientation(1);
        setBackgroundResource(2130842675);
        setShowSegmentedDividers(2);
        setSegmentedDivider(getResources().getDrawable(2130842673));
    }

    public void setPlaceTipOnClickListener(OnClickListener onClickListener) {
        this.f12919a.setOnClickListener(onClickListener);
    }

    public void setFooterView(@Nullable View view) {
        if (this.f12923e != null) {
            removeView(this.f12923e);
        }
        this.f12923e = view;
        if (this.f12923e != null) {
            addView(view);
        }
    }

    public void setTitle(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        this.f12922d.setTextWithEntities(defaultTextWithEntitiesLongFields);
    }

    public void setSourceText(@Nullable PresenceSourceType presenceSourceType) {
        if (presenceSourceType != null) {
            if (this.f12920b == null) {
                this.f12920b = new TextView(getContext());
                this.f12920b.setTextColor(-16777216);
                this.f12919a.addView(this.f12920b, 0);
            }
            this.f12920b.setText(StringFormatUtil.formatStrLocaleSafe("[%s]", presenceSourceType));
        } else if (this.f12920b != null) {
            this.f12919a.removeView(this.f12920b);
            this.f12920b = null;
        }
    }

    public void setSubText(@Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        PlaceTipsUtils.m14663a(this.f12921c, defaultTextWithEntitiesLongFields);
    }

    public void setIconImage(@Nullable String str) {
        if (str != null) {
            this.f12919a.setThumbnailUri(str);
        } else {
            this.f12919a.setThumbnailResource(2130842687);
        }
    }

    public final void m14662a() {
        setFooterView(null);
    }
}
