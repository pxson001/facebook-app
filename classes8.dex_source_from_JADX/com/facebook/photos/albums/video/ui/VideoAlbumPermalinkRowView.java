package com.facebook.photos.albums.video.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.LaunchVideoPlayerEvent;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: confidence_level */
public class VideoAlbumPermalinkRowView extends CustomViewGroup {
    private final CallerContext f17343a = CallerContext.a(VideoAlbumPermalinkRowView.class, "video");
    public final int f17344b = 2131558573;
    private double f17345c;
    private double f17346d;
    private int f17347e;
    public Lazy<AlbumsEventBus> f17348f;
    private final List<FbDraweeView> f17349g = new ArrayList();
    private OnClickListener f17350h = new C18421(this);

    /* compiled from: confidence_level */
    class C18421 implements OnClickListener {
        final /* synthetic */ VideoAlbumPermalinkRowView f17342a;

        C18421(VideoAlbumPermalinkRowView videoAlbumPermalinkRowView) {
            this.f17342a = videoAlbumPermalinkRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1673316466);
            VideoDetailFragmentModel videoDetailFragmentModel = (VideoDetailFragmentModel) view.getTag(this.f17342a.f17344b);
            if (videoDetailFragmentModel == null || videoDetailFragmentModel.v() == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 442103439, a);
                return;
            }
            ((AlbumsEventBus) this.f17342a.f17348f.get()).a(new LaunchVideoPlayerEvent(videoDetailFragmentModel));
            LogUtils.a(-294072406, a);
        }
    }

    public static void m21358a(Object obj, Context context) {
        ((VideoAlbumPermalinkRowView) obj).f17348f = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 9247);
    }

    public VideoAlbumPermalinkRowView(Context context) {
        super(context);
        Class cls = VideoAlbumPermalinkRowView.class;
        m21358a(this, getContext());
    }

    public final void m21359a(int i, double d, double d2) {
        if (this.f17347e != i || this.f17345c != d || this.f17346d != d2 || getChildCount() <= 0) {
            this.f17347e = i;
            this.f17345c = d;
            this.f17346d = d2;
            removeAllViews();
            this.f17349g.clear();
            Resources resources = getResources();
            GenericDraweeHierarchyBuilder f = new GenericDraweeHierarchyBuilder(resources).e(ScaleType.e).f(resources.getDrawable(2130843881));
            for (int i2 = 0; i2 < i; i2++) {
                FbDraweeView fbDraweeView = new FbDraweeView(getContext(), f.u());
                fbDraweeView.setTag(Integer.valueOf(i2));
                fbDraweeView.setOnClickListener(this.f17350h);
                addView(fbDraweeView);
                this.f17349g.add(fbDraweeView);
            }
        }
    }

    public final void m21360a(ImmutableList<VideoDetailFragmentModel> immutableList) {
        boolean z;
        if (immutableList.size() <= getChildCount()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        for (int i = 0; i < immutableList.size(); i++) {
            FbDraweeView fbDraweeView = (FbDraweeView) this.f17349g.get(i);
            VideoDetailFragmentModel videoDetailFragmentModel = (VideoDetailFragmentModel) immutableList.get(i);
            if (videoDetailFragmentModel.M() == null) {
                fbDraweeView.setVisibility(8);
            } else {
                fbDraweeView.setTag(this.f17344b, videoDetailFragmentModel);
                fbDraweeView.setVisibility(0);
                fbDraweeView.a(Uri.parse(videoDetailFragmentModel.M().b()), this.f17343a);
            }
        }
        for (int size = immutableList.size(); size < this.f17347e; size++) {
            ((FbDraweeView) this.f17349g.get(size)).setVisibility(8);
            ((FbDraweeView) this.f17349g.get(size)).setTag(this.f17344b, null);
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), (int) (this.f17346d + this.f17345c));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        double d = 0.5d + ((((double) (i3 - i)) - ((((double) this.f17347e) * this.f17345c) + (((double) (this.f17347e - 1)) * this.f17346d))) / ((double) (this.f17347e - 1)));
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int intValue = ((Integer) childAt.getTag()).intValue();
                int i6 = 0;
                if (intValue != 0) {
                    i6 = (int) ((((double) intValue) * d) + ((this.f17346d + this.f17345c) * ((double) intValue)));
                }
                childAt.measure(MeasureSpec.makeMeasureSpec((int) this.f17345c, 1073741824), MeasureSpec.makeMeasureSpec((int) this.f17345c, 1073741824));
                childAt.layout(i6, 0, (int) (((double) i6) + this.f17345c), (int) this.f17345c);
            }
        }
    }
}
