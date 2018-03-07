package com.facebook.pages.common.messaging.ui;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.inject.Assisted;
import com.facebook.user.model.UserCustomTag;
import javax.inject.Inject;

/* compiled from: share_call_to_action */
public class TagItemViewHolder {
    private final TextView f1665a;
    private final LayoutInflater f1666b;
    private final GradientDrawable f1667c = ((GradientDrawable) this.f1665a.getBackground());
    private final int f1668d;

    @Inject
    public TagItemViewHolder(Resources resources, LayoutInflater layoutInflater, @Assisted ViewGroup viewGroup) {
        this.f1666b = layoutInflater;
        this.f1668d = resources.getDimensionPixelSize(2131427380);
        this.f1665a = (TextView) this.f1666b.inflate(2130907629, viewGroup, false);
    }

    public final void m2469a(UserCustomTag userCustomTag) {
        this.f1665a.setText(userCustomTag.b);
        this.f1665a.setTextColor(userCustomTag.c);
        this.f1667c.setColor(userCustomTag.d);
        this.f1667c.setStroke(this.f1668d, userCustomTag.e);
    }

    public final View m2468a() {
        return this.f1665a;
    }
}
