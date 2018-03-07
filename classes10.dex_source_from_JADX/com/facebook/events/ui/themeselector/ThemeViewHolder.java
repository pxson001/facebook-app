package com.facebook.events.ui.themeselector;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: app_invite_install_button_tapped */
public class ThemeViewHolder extends ViewHolder {
    public static final CallerContext f19597p = CallerContext.a(ThemeViewHolder.class);
    public FbDraweeView f19598l;
    public String f19599m;
    public String f19600n;
    public OnClickListener f19601o = new C27891(this);

    /* compiled from: app_invite_install_button_tapped */
    class C27891 implements OnClickListener {
        final /* synthetic */ ThemeViewHolder f19596a;

        C27891(ThemeViewHolder themeViewHolder) {
            this.f19596a = themeViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -473174265);
            Intent intent = new Intent();
            intent.addFlags(65536);
            intent.putExtra("extra_selected_theme_id", this.f19596a.f19599m);
            intent.putExtra("extra_selected_theme_uri", this.f19596a.f19600n);
            Activity activity = (Activity) ContextUtils.a(this.f19596a.f19598l.getContext(), Activity.class);
            if (activity != null) {
                activity.setResult(-1, intent);
                activity.finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 803305445, a);
        }
    }

    public ThemeViewHolder(View view) {
        super(view);
        this.f19598l = (FbDraweeView) view.findViewById(2131561577);
    }
}
