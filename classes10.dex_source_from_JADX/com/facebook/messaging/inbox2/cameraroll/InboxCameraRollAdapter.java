package com.facebook.messaging.inbox2.cameraroll;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.cameraroll.InboxCameraRollView.C04503;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.orca.threadlist.ThreadListAdapter.C09886;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence.Wrapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: setThreadThemeResult */
public class InboxCameraRollAdapter extends Adapter<ViewHolder> implements InboxAdapter {
    public static final Equivalence<MediaResource> f2697a = new C04441();
    private final LayoutInflater f2698b;
    public ImmutableList<InboxCameraRollMediaItem> f2699c;
    public final Set<Wrapper<MediaResource>> f2700d = new HashSet();
    @Nullable
    public C04503 f2701e;

    /* compiled from: setThreadThemeResult */
    final class C04441 extends Equivalence<MediaResource> {
        C04441() {
        }

        protected final boolean doEquivalent(Object obj, Object obj2) {
            return ((MediaResource) obj).g == ((MediaResource) obj2).g;
        }

        protected final int doHash(Object obj) {
            MediaResource mediaResource = (MediaResource) obj;
            return (int) (mediaResource.g ^ (mediaResource.g >>> 32));
        }
    }

    /* compiled from: setThreadThemeResult */
    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public final void m2664a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, final int i) {
        InboxCameraRollItemView inboxCameraRollItemView = (InboxCameraRollItemView) ((ViewHolder) viewHolder).a;
        final InboxCameraRollMediaItem inboxCameraRollMediaItem = (InboxCameraRollMediaItem) this.f2699c.get(i);
        final Wrapper wrap = f2697a.wrap(inboxCameraRollMediaItem.f2712f);
        inboxCameraRollItemView.setMediaResource(inboxCameraRollMediaItem.f2712f);
        inboxCameraRollItemView.m2676a(this.f2700d.contains(wrap), false);
        inboxCameraRollItemView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InboxCameraRollAdapter f2696d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1511016814);
                boolean contains = this.f2696d.f2700d.contains(wrap);
                if (contains) {
                    this.f2696d.f2700d.remove(wrap);
                } else {
                    this.f2696d.f2700d.add(wrap);
                }
                view.setSelected(!contains);
                if (this.f2696d.f2701e != null) {
                    C04503 c04503 = this.f2696d.f2701e;
                    InboxCameraRollMediaItem inboxCameraRollMediaItem = inboxCameraRollMediaItem;
                    int i = i;
                    if (c04503.f2715a.f2733p != null) {
                        C09886 c09886 = c04503.f2715a.f2733p;
                        if (c09886.f6558c.f6573j != null) {
                            c09886.f6558c.f6573j.f6606a.bB.m2624a(inboxCameraRollMediaItem, i);
                        }
                    }
                    this.f2696d.f2701e.m2685a(this.f2696d.m2667d());
                }
                LogUtils.a(1265664408, a);
            }
        });
    }

    @Inject
    public InboxCameraRollAdapter(Context context) {
        this.f2698b = LayoutInflater.from(context);
    }

    public final int aZ_() {
        return this.f2699c == null ? 0 : this.f2699c.size();
    }

    public final int m2665b() {
        return aZ_();
    }

    public final InboxItem m2666b(int i) {
        return (InboxItem) this.f2699c.get(i);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m2663a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.f2698b.inflate(2130904861, viewGroup, false));
    }

    public final ImmutableSet<MediaResource> m2667d() {
        Builder builder = ImmutableSet.builder();
        for (Wrapper wrapper : this.f2700d) {
            builder.c(wrapper.reference);
        }
        return builder.b();
    }
}
