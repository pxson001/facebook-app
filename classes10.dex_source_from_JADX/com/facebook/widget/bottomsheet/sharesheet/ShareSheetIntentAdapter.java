package com.facebook.widget.bottomsheet.sharesheet;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.groups.logging.GroupJoinableLinksLogger;
import com.facebook.messaging.groups.sharesheet.GroupShareSheetCreator;
import com.facebook.messaging.groups.sharesheet.GroupShareSheetCreator.C04182;
import com.facebook.messaging.groups.sharesheet.GroupShareSheetCreator.C04182.C04171;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.recyclerview.BetterRecyclerView.ViewHolder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

/* compiled from: extra_action_on_fragment_create */
public class ShareSheetIntentAdapter extends Adapter<ViewHolder<ImageWithTextView>> implements AdapterCompatibleWithListView<ViewHolder<ImageWithTextView>> {
    public final ShareSheetIntentLauncher f12981a;
    public final Context f12982b;
    public final Intent f12983c;
    public ImmutableList<ShareSheetIntentAction> f12984d;
    @Nullable
    public C04182 f12985e;

    /* compiled from: extra_action_on_fragment_create */
    public class C18131 implements OnClickListener {
        final /* synthetic */ ShareSheetIntentAdapter f12977a;

        public C18131(ShareSheetIntentAdapter shareSheetIntentAdapter) {
            this.f12977a = shareSheetIntentAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 557947559);
            ShareSheetIntentAction shareSheetIntentAction = (ShareSheetIntentAction) view.getTag();
            if (this.f12977a.f12985e != null) {
                C04182 c04182 = this.f12977a.f12985e;
                ActivityInfo activityInfo = shareSheetIntentAction.f12980c;
                ((GroupJoinableLinksLogger) c04182.f2508a.f2522h.get()).m2494c(c04182.f2508a.f2525k, activityInfo.packageName);
                if (c04182.f2508a.f2525k.d()) {
                    GroupShareSheetCreator.m2535a(c04182.f2508a, activityInfo, c04182.f2508a.f2525k.I);
                    c04182.f2508a.f2523i.m2548a(((GroupAdminController) c04182.f2508a.f2520f.get()).m2346c(c04182.f2508a.f2525k), c04182.f2508a.f2525k.Q);
                } else {
                    GroupShareSheetCreator.m2537a(c04182.f2508a, new C04171(c04182, activityInfo));
                }
            } else {
                this.f12977a.f12981a.m13020a(this.f12977a.f12982b, this.f12977a.f12983c, shareSheetIntentAction.f12980c);
            }
            LogUtils.a(-2098685755, a);
        }
    }

    @Immutable
    /* compiled from: extra_action_on_fragment_create */
    public class ShareSheetIntentAction {
        public final Drawable f12978a;
        public final CharSequence f12979b;
        public final ActivityInfo f12980c;

        public ShareSheetIntentAction(Drawable drawable, CharSequence charSequence, ActivityInfo activityInfo) {
            this.f12978a = drawable;
            this.f12979b = charSequence;
            this.f12980c = activityInfo;
        }
    }

    public final void m13018a(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        m13016e();
        ShareSheetIntentAction shareSheetIntentAction = (ShareSheetIntentAction) this.f12984d.get(i);
        ImageWithTextView imageWithTextView = (ImageWithTextView) viewHolder2.l;
        imageWithTextView.setImageDrawable(shareSheetIntentAction.f12978a);
        imageWithTextView.setText(shareSheetIntentAction.f12979b);
        imageWithTextView.setTag(shareSheetIntentAction);
    }

    @Inject
    public ShareSheetIntentAdapter(@Assisted Context context, @Assisted Intent intent, ShareSheetIntentLauncher shareSheetIntentLauncher) {
        this.f12982b = (Context) Preconditions.checkNotNull(context);
        this.f12983c = (Intent) Preconditions.checkNotNull(intent);
        this.f12981a = shareSheetIntentLauncher;
    }

    public final RecyclerView.ViewHolder m13017a(ViewGroup viewGroup, int i) {
        Preconditions.checkNotNull(this.f12982b, "Adapter has not been initialized. Please call init()");
        ImageWithTextView imageWithTextView = (ImageWithTextView) LayoutInflater.from(this.f12982b).inflate(2130907077, viewGroup, false);
        imageWithTextView.setOnClickListener(new C18131(this));
        return new ViewHolder(imageWithTextView);
    }

    private void m13016e() {
        if (this.f12984d == null) {
            PackageManager packageManager = this.f12982b.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(this.f12983c, 65536);
            Builder builder = ImmutableList.builder();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                builder.c(new ShareSheetIntentAction(resolveInfo.loadIcon(packageManager), resolveInfo.loadLabel(packageManager), resolveInfo.activityInfo));
            }
            this.f12984d = builder.b();
        }
    }

    public final int aZ_() {
        m13016e();
        return this.f12984d.size();
    }

    public final int iy_() {
        return 1;
    }

    public Object getItem(int i) {
        m13016e();
        return this.f12984d.get(i);
    }
}
