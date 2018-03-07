package com.facebook.directinstall.appdetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.SecureContextHelper;
import com.facebook.directinstall.appdetails.analytics.AppDetailsLogger;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: onDrawFrame */
public class ScreenshotItemsAdapter extends Adapter<ViewHolder> {
    private static final CallerContext f8722a = CallerContext.b(ScreenshotItemsAdapter.class, "network_image");
    public Context f8723b;
    public SecureContextHelper f8724c;
    public List<ScreenshotItem> f8725d;
    public ArrayList<Uri> f8726e;
    public DirectInstallAppData f8727f;
    public Map<String, Object> f8728g;
    public AppDetailsLogger f8729h;

    /* compiled from: onDrawFrame */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements OnClickListener {
        ScreenshotItemsAdapter f8720l;
        final /* synthetic */ ScreenshotItemsAdapter f8721m;

        public ViewHolder(ScreenshotItemsAdapter screenshotItemsAdapter, ScreenshotItemsAdapter screenshotItemsAdapter2, View view) {
            this.f8721m = screenshotItemsAdapter;
            super(view);
            this.f8720l = screenshotItemsAdapter2;
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            ArrayList arrayList;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2084812490);
            ScreenshotItemsAdapter screenshotItemsAdapter = this.f8720l;
            if (screenshotItemsAdapter.f8726e != null) {
                arrayList = screenshotItemsAdapter.f8726e;
            } else if (screenshotItemsAdapter.f8725d == null) {
                arrayList = null;
            } else {
                screenshotItemsAdapter.f8726e = new ArrayList();
                int aZ_ = screenshotItemsAdapter.aZ_();
                for (int i = 0; i < aZ_; i++) {
                    screenshotItemsAdapter.f8726e.add(((ScreenshotItem) screenshotItemsAdapter.f8725d.get(i)).f8717a);
                }
                arrayList = screenshotItemsAdapter.f8726e;
            }
            ArrayList arrayList2 = arrayList;
            int d = d();
            this.f8721m.f8729h.m12508a(this.f8721m.f8727f.f8768b.f8773a, this.f8721m.f8727f.f8768b.f8777e, d, this.f8721m.f8728g);
            Intent intent = new Intent(this.f8720l.f8723b, ScreenshotFullscreenActivity.class);
            intent.putParcelableArrayListExtra("screenshot_url_list", arrayList2);
            intent.putExtra("screenshot_current_position", d);
            DirectInstallIntentUtils.m12553a(intent, this.f8721m.f8727f);
            DirectInstallIntentUtils.m12554a(intent, ImmutableMap.copyOf(this.f8721m.f8728g));
            this.f8720l.f8724c.a(intent, this.f8720l.f8723b);
            Logger.a(2, EntryType.UI_INPUT_END, 2128851040, a);
        }
    }

    public final void m12504a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ScreenshotItem screenshotItem = (ScreenshotItem) this.f8725d.get(i);
        FbDraweeView fbDraweeView = (FbDraweeView) ((ViewHolder) viewHolder).a;
        int i2 = fbDraweeView.getLayoutParams().height;
        fbDraweeView.setLayoutParams(new LayoutParams((int) Math.round((((double) screenshotItem.f8718b) / ((double) screenshotItem.f8719c)) * ((double) i2)), i2));
        fbDraweeView.a(screenshotItem.f8717a, f8722a);
    }

    @Inject
    public ScreenshotItemsAdapter(@Assisted Context context, @Assisted DirectInstallAppData directInstallAppData, @Assisted Map<String, Object> map, @Assisted List<ScreenshotItem> list, SecureContextHelper secureContextHelper, AppDetailsLogger appDetailsLogger) {
        this.f8723b = context;
        this.f8724c = secureContextHelper;
        this.f8725d = list;
        this.f8727f = directInstallAppData;
        this.f8728g = map;
        this.f8729h = appDetailsLogger;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m12503a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, this, (FbDraweeView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906959, viewGroup, false));
    }

    public final int aZ_() {
        return this.f8725d.size();
    }
}
