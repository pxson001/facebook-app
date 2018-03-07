package com.facebook.timeline.header.favphotos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.FavoritePhotoModel;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fhbfoxfvfgfhfcnsexjefjcnjacucksswjxrhhhwinfhfhbymaxbyfxxxfkb */
public class TimelineHeaderFavoritePhotosView extends CustomLinearLayout {
    @Inject
    AllCapsTransformationMethod f11721a;
    @Inject
    TimelineHeaderFeaturedPhotosMosaicBinder f11722b;
    private FbTextView f11723c;
    private TimelineHeaderFeaturedPhotosMosaicView f11724d;

    private static <T extends View> void m11819a(Class<T> cls, T t) {
        m11820a((Object) t, t.getContext());
    }

    private static void m11820a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineHeaderFavoritePhotosView) obj).m11818a(AllCapsTransformationMethod.b(fbInjector), TimelineHeaderFeaturedPhotosMosaicBinder.m11829b(fbInjector));
    }

    private void m11818a(AllCapsTransformationMethod allCapsTransformationMethod, TimelineHeaderFeaturedPhotosMosaicBinder timelineHeaderFeaturedPhotosMosaicBinder) {
        this.f11721a = allCapsTransformationMethod;
        this.f11722b = timelineHeaderFeaturedPhotosMosaicBinder;
    }

    public TimelineHeaderFavoritePhotosView(Context context) {
        super(context);
        m11821b();
    }

    public TimelineHeaderFavoritePhotosView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11821b();
    }

    public void setEditClickListener(OnClickListener onClickListener) {
        this.f11723c.setOnClickListener(onClickListener);
    }

    public void setMosaicEditFavPhotosClickListener(OnClickListener onClickListener) {
        this.f11724d.setOnClickListener(onClickListener);
        this.f11724d.f11747l = true;
    }

    public void setEditable(boolean z) {
        this.f11723c.setVisibility(z ? 0 : 8);
    }

    public final void m11824a(ImmutableList<? extends FavoritePhoto> immutableList) {
        int i = 0;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            builder.c(((FavoritePhotoModel) immutableList.get(i2)).b());
        }
        ImmutableList b = builder.b();
        List arrayList = new ArrayList();
        size = immutableList.size();
        while (i < size) {
            arrayList.add(((FavoritePhotoModel) immutableList.get(i)).a());
            i++;
        }
        this.f11722b.m11830a(this.f11724d, b, arrayList);
    }

    public final void m11823a() {
        this.f11724d.removeAllViews();
    }

    private void m11821b() {
        m11819a(TimelineHeaderFavoritePhotosView.class, (View) this);
        setContentView(2130907456);
        setOrientation(1);
        this.f11723c = (FbTextView) findViewById(2131567939);
        this.f11723c.setTransformationMethod(this.f11721a);
        this.f11723c.setVisibility(8);
        m11822c();
    }

    private void m11822c() {
        this.f11724d = (TimelineHeaderFeaturedPhotosMosaicView) findViewById(2131567938);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429958);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131429957);
        this.f11724d.m11834a(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, 0);
    }
}
