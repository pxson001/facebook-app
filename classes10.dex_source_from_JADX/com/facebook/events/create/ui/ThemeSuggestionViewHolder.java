package com.facebook.events.create.ui;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.create.EventCreationNikumanActivity.C22502;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: composer_button */
public class ThemeSuggestionViewHolder extends ViewHolder {
    private static final CallerContext f16431r = CallerContext.a(ThemeSuggestionViewHolder.class);
    private FbDraweeView f16432l;
    private FbTextView f16433m;
    public String f16434n;
    public String f16435o;
    private OnClickListener f16436p = new C22911(this);
    public C22502 f16437q;

    /* compiled from: composer_button */
    class C22911 implements OnClickListener {
        final /* synthetic */ ThemeSuggestionViewHolder f16430a;

        C22911(ThemeSuggestionViewHolder themeSuggestionViewHolder) {
            this.f16430a = themeSuggestionViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1130002454);
            if (this.f16430a.f16437q != null) {
                this.f16430a.f16437q.m16498a(this.f16430a.f16434n, this.f16430a.f16435o);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 894575395, a);
        }
    }

    public ThemeSuggestionViewHolder(View view) {
        super(view);
        this.f16432l = (FbDraweeView) view.findViewById(2131561577);
        this.f16433m = (FbTextView) view.findViewById(2131567767);
    }

    public final void m16878a(String str, String str2, String str3, C22502 c22502, boolean z) {
        this.f16434n = str;
        this.f16435o = str3;
        this.f16432l.a(Uri.parse(str2), f16431r);
        this.f16432l.setOnClickListener(this.f16436p);
        this.f16437q = c22502;
        if (z) {
            this.f16433m.setVisibility(0);
        } else {
            this.f16433m.setVisibility(8);
        }
    }
}
