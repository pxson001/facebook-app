package com.facebook.friendsharing.gif.activity;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.friendsharing.gif.model.GifModelContainer;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SELECT_FIELD_ERROR */
public class GifPickerAdapter extends Adapter<GifViewHolder> {
    private static final String f23878a = GifPickerAdapter.class.getSimpleName();
    private final Context f23879b;
    public ImmutableList<GifModelContainer> f23880c;
    private final FbDraweeControllerBuilder f23881d;
    private final Lazy<FbErrorReporter> f23882e;
    public final GifPickerFragment f23883f;

    public final void m26012a(ViewHolder viewHolder, final int i) {
        final GifViewHolder gifViewHolder = (GifViewHolder) viewHolder;
        gifViewHolder.m26044w().getLayoutParams().width = this.f23879b.getResources().getDisplayMetrics().widthPixels / 2;
        gifViewHolder.m26044w().setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GifPickerAdapter f23875b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2056814748);
                GifPickerFragment gifPickerFragment = this.f23875b.f23883f;
                String a2 = ((GifModelContainer) this.f23875b.f23880c.get(i)).m26051a().m26056a().m26050a();
                gifPickerFragment.f23905g.a(gifPickerFragment.am, ComposerConfiguration.a(gifPickerFragment.al).setInitialShareParams(Builder.a(a2.substring(0, a2.lastIndexOf(47) + 1) + "giphy.gif").b()).a(), 1240, gifPickerFragment);
                GifPickerAnalyticsLogger gifPickerAnalyticsLogger = gifPickerFragment.f23902d;
                gifPickerAnalyticsLogger.f23884a.a(new HoneyClientEvent("gif_picker_launch_composer").b("session_id", gifPickerFragment.am));
                Logger.a(2, EntryType.UI_INPUT_END, -130357393, a);
            }
        });
        if (gifViewHolder.m26046y().getVisibility() != 0) {
            gifViewHolder.m26046y().setVisibility(0);
        }
        try {
            gifViewHolder.m26045x().setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f23881d.a(CallerContext.a(GifPickerAdapter.class)).b(gifViewHolder.m26045x().getController())).a(((GifModelContainer) this.f23880c.get(i)).m26051a().m26056a().m26050a()).a(new BaseControllerListener(this) {
                final /* synthetic */ GifPickerAdapter f23877b;

                public final void m26010a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                    if (gifViewHolder.f23918n.getVisibility() != 4) {
                        gifViewHolder.f23918n.setVisibility(4);
                    }
                    if (animatable != null) {
                        animatable.start();
                    }
                }
            })).s());
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f23882e.get()).a(f23878a, "Problem with DraweeView ", e);
        }
    }

    @Inject
    public GifPickerAdapter(FbDraweeControllerBuilder fbDraweeControllerBuilder, Lazy<FbErrorReporter> lazy, @Assisted Context context, @Assisted ImmutableList<GifModelContainer> immutableList, @Assisted OnSelect onSelect) {
        this.f23881d = fbDraweeControllerBuilder;
        this.f23882e = lazy;
        this.f23879b = context;
        this.f23880c = immutableList;
        this.f23883f = onSelect;
    }

    public final ViewHolder m26011a(ViewGroup viewGroup, int i) {
        return new GifViewHolder(((LayoutInflater) this.f23879b.getSystemService("layout_inflater")).inflate(2130907122, viewGroup, false));
    }

    public final int aZ_() {
        return this.f23880c.size();
    }
}
