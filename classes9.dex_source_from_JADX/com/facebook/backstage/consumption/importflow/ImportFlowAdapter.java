package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.facebook.backstage.consumption.GenericDraweeViewHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: risk_screen */
public class ImportFlowAdapter extends BaseAdapter {
    private final Context f4721a;
    public ImmutableList<ImportMedia> f4722b = RegularImmutableList.a;

    public ImportFlowAdapter(Context context) {
        this.f4721a = context;
    }

    public int getCount() {
        return this.f4722b.size();
    }

    public Object getItem(int i) {
        return this.f4722b.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ImportFlowPanelView importFlowPanelView;
        if (view == null) {
            importFlowPanelView = new ImportFlowPanelView(this.f4721a);
        } else {
            importFlowPanelView = (ImportFlowPanelView) view;
        }
        m4612a(importFlowPanelView, i);
        return importFlowPanelView;
    }

    public final ImmutableList<ImportMedia> m4613a() {
        Builder builder = new Builder();
        int size = this.f4722b.size();
        for (int i = 0; i < size; i++) {
            ImportMedia importMedia = (ImportMedia) this.f4722b.get(i);
            if (importMedia.f4822b) {
                builder.c(importMedia);
            }
        }
        return builder.b();
    }

    public final void m4614a(View view, int i) {
        ImportMedia importMedia = (ImportMedia) this.f4722b.get(i);
        importMedia.f4822b = !importMedia.f4822b;
        m4612a((ImportFlowPanelView) view, i);
    }

    private void m4612a(ImportFlowPanelView importFlowPanelView, int i) {
        String f = ((ImportMedia) this.f4722b.get(i)).mo171f();
        boolean g = ((ImportMedia) this.f4722b.get(i)).mo172g();
        importFlowPanelView.f4777e.setScaleType(ScaleType.FIT_CENTER);
        importFlowPanelView.f4777e.setController(GenericDraweeViewHelper.m4529a(Uri.parse(f), importFlowPanelView.f4774b, new ResizeOptions(importFlowPanelView.f4773a.m4553c(), importFlowPanelView.f4773a.m4553c())));
        importFlowPanelView.f4776d.setVisibility(g ? 0 : 8);
        if (((ImportMedia) this.f4722b.get(i)).f4822b) {
            importFlowPanelView.f4775c.setImageResource(2130838055);
            ((GenericDraweeHierarchy) importFlowPanelView.f4777e.getHierarchy()).a(null);
            return;
        }
        importFlowPanelView.f4775c.setImageResource(2130838057);
        ((GenericDraweeHierarchy) importFlowPanelView.f4777e.getHierarchy()).a(importFlowPanelView.f4778f);
    }
}
