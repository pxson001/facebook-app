package com.facebook.friendsharing.suggestedcoverphotos;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger$Action;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: PsshAtomUtil */
public class CoverPhotoPickerScrollAdapter extends Adapter<CoverPhotoPickerViewHolder> {
    public static final CallerContext f24265a = CallerContext.a(CoverPhotoPickerScrollAdapter.class);
    private final ImmutableList<String> f24266b;
    public final Context f24267c;
    public final Fragment f24268d;
    public final FbDraweeControllerBuilder f24269e;
    public final SuggestedCoverPhotoEditHelperProvider f24270f;
    public final SuggestedCoverPhotosLogger f24271g;
    public final String f24272h;
    public final PromptAnalytics f24273i;
    public SuggestedCoverPhotoEditHelper f24274j;

    /* compiled from: PsshAtomUtil */
    public class CoverPhotoPickerViewHolder extends ViewHolder {
        public final /* synthetic */ CoverPhotoPickerScrollAdapter f24262l;
        public DraweeView f24263m;
        private GenericDraweeHierarchy f24264n;

        /* compiled from: PsshAtomUtil */
        public class C21131 implements OnClickListener {
            final /* synthetic */ int f24259a;
            final /* synthetic */ Uri f24260b;
            final /* synthetic */ CoverPhotoPickerViewHolder f24261c;

            public C21131(CoverPhotoPickerViewHolder coverPhotoPickerViewHolder, int i, Uri uri) {
                this.f24261c = coverPhotoPickerViewHolder;
                this.f24259a = i;
                this.f24260b = uri;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1336738139);
                if (this.f24261c.f24262l.f24274j == null) {
                    this.f24261c.f24262l.f24274j = this.f24261c.f24262l.f24270f.a(this.f24261c.f24262l.f24268d.o(), this.f24261c.f24262l.f24272h, this.f24261c.f24262l.f24273i);
                }
                SuggestedCoverPhotosLogger suggestedCoverPhotosLogger = this.f24261c.f24262l.f24271g;
                String str = this.f24261c.f24262l.f24272h;
                suggestedCoverPhotosLogger.a.a(SuggestedCoverPhotosLogger.a(str, SuggestedCoverPhotosLogger$Action.CLICK_PICKER_PHOTO.name()).a("position", this.f24259a));
                this.f24261c.f24262l.f24274j.m26503a(this.f24260b);
                Logger.a(2, EntryType.UI_INPUT_END, -1569677620, a);
            }
        }

        public CoverPhotoPickerViewHolder(CoverPhotoPickerScrollAdapter coverPhotoPickerScrollAdapter, View view) {
            this.f24262l = coverPhotoPickerScrollAdapter;
            super(view);
            this.f24263m = (DraweeView) FindViewUtil.b(view, 2131560815);
            this.f24264n = new GenericDraweeHierarchyBuilder(coverPhotoPickerScrollAdapter.f24267c.getResources()).u();
            this.f24263m.setHierarchy(this.f24264n);
        }
    }

    public final void m26498a(ViewHolder viewHolder, int i) {
        CoverPhotoPickerViewHolder coverPhotoPickerViewHolder = (CoverPhotoPickerViewHolder) viewHolder;
        Uri parse = Uri.parse((String) this.f24266b.get(i));
        int dimensionPixelSize = coverPhotoPickerViewHolder.f24262l.f24267c.getResources().getDimensionPixelSize(2131432481);
        ImageRequestBuilder a = ImageRequestBuilder.a(parse);
        a.g = true;
        a = a;
        a.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
        coverPhotoPickerViewHolder.f24263m.setController(((FbDraweeControllerBuilder) coverPhotoPickerViewHolder.f24262l.f24269e.p().a(f24265a).c(a.m())).s());
        coverPhotoPickerViewHolder.f24263m.setOnClickListener(new C21131(coverPhotoPickerViewHolder, i, parse));
    }

    @Inject
    public CoverPhotoPickerScrollAdapter(@Assisted ImmutableList<String> immutableList, @Assisted Context context, @Assisted Fragment fragment, @Assisted String str, @Assisted PromptAnalytics promptAnalytics, FbDraweeControllerBuilder fbDraweeControllerBuilder, SuggestedCoverPhotoEditHelperProvider suggestedCoverPhotoEditHelperProvider, SuggestedCoverPhotosLogger suggestedCoverPhotosLogger) {
        this.f24266b = immutableList;
        this.f24267c = context;
        this.f24268d = fragment;
        this.f24272h = str;
        this.f24273i = promptAnalytics;
        this.f24269e = fbDraweeControllerBuilder;
        this.f24270f = suggestedCoverPhotoEditHelperProvider;
        this.f24271g = suggestedCoverPhotosLogger;
    }

    public final ViewHolder m26497a(ViewGroup viewGroup, int i) {
        return new CoverPhotoPickerViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903814, viewGroup, false));
    }

    public final int aZ_() {
        return this.f24266b.size();
    }
}
