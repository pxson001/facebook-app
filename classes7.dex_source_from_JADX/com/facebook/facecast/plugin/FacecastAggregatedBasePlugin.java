package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.CollectionUtil;
import com.facebook.facecast.FacecastStateManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: broadcast_target_type */
public class FacecastAggregatedBasePlugin extends FacecastBasePlugin {
    private final List<FacecastBasePlugin> f18169c = new ArrayList();

    public FacecastAggregatedBasePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean mo1409a() {
        for (FacecastBasePlugin a : this.f18169c) {
            if (a.mo1409a()) {
                return true;
            }
        }
        return super.mo1409a();
    }

    protected void hE_() {
        int i;
        super.hE_();
        if (!this.f18167c || this.f18165a == null || CollectionUtil.a(this.f18168d)) {
            i = -1;
        } else {
            View view = (View) this.f18168d.get(this.f18168d.size() - 1);
            i = 0;
            while (i < this.f18165a.getChildCount()) {
                if (view == this.f18165a.getChildAt(i)) {
                    break;
                }
                i++;
            }
            i = -1;
        }
        int i2 = i;
        int childCount = i2 == -1 ? this.f18165a.getChildCount() : i2 + 1;
        for (int size = this.f18169c.size() - 1; size >= 0; size--) {
            ((FacecastBasePlugin) this.f18169c.get(size)).m21948a(this.f18165a, this.f18166b, childCount);
        }
    }

    protected void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        for (FacecastBasePlugin c : this.f18169c) {
            c.m21950c();
        }
    }

    public final void m21955a(FacecastBasePlugin facecastBasePlugin) {
        m21956a(facecastBasePlugin, null);
    }

    protected final void m21956a(FacecastBasePlugin facecastBasePlugin, @Nullable FacecastBasePlugin facecastBasePlugin2) {
        int indexOf = this.f18169c.indexOf(facecastBasePlugin2);
        if (indexOf == -1) {
            this.f18169c.add(facecastBasePlugin);
        } else {
            this.f18169c.add(indexOf, facecastBasePlugin);
        }
        if (this.f18167c) {
            if (facecastBasePlugin2 != null) {
                int i = 0;
                if (!facecastBasePlugin2.f18167c || facecastBasePlugin2.f18165a == null || CollectionUtil.a(facecastBasePlugin2.f18168d)) {
                    i = -1;
                } else {
                    View view = (View) facecastBasePlugin2.f18168d.get(0);
                    while (i < facecastBasePlugin2.f18165a.getChildCount()) {
                        if (view == facecastBasePlugin2.f18165a.getChildAt(i)) {
                            break;
                        }
                        i++;
                    }
                    i = -1;
                }
                indexOf = i;
            } else {
                indexOf = -1;
            }
            if (indexOf == -1) {
                facecastBasePlugin.m21948a(this.f18165a, this.f18166b, -1);
            } else {
                facecastBasePlugin.m21948a(this.f18165a, this.f18166b, indexOf);
            }
        }
    }

    protected final void m21957a(FacecastBasePlugin... facecastBasePluginArr) {
        for (FacecastBasePlugin a : facecastBasePluginArr) {
            m21955a(a);
        }
    }
}
