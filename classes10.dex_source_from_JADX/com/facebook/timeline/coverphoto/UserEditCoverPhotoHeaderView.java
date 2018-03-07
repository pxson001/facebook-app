package com.facebook.timeline.coverphoto;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.timeline.header.TimelineHeaderAdapterFactory;
import com.facebook.timeline.header.TimelineHeaderDataLoggerProvider;
import com.facebook.timeline.header.TimelineHeaderMultiAdapter;
import com.facebook.timeline.header.coverphoto.edit.CoverPhotoEditView;
import com.facebook.timeline.header.ui.CaspianTimelineStandardHeader;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_info_settings */
public class UserEditCoverPhotoHeaderView extends FrameLayout {
    @Inject
    public ScreenUtil f10370a;
    @Inject
    public TimelineHeaderAdapterFactory f10371b;
    @Inject
    public TimelineHeaderDataLoggerProvider f10372c;
    private final String f10373d;
    @Nullable
    public CoverPhotoEditView f10374e;
    public BetterRecyclerView f10375f;
    public TimelineHeaderMultiAdapter f10376g;
    public LoadingIndicatorView f10377h;
    public CaspianTimelineStandardHeader f10378i;
    public View f10379j;

    /* compiled from: group_info_settings */
    public class C15261 implements OnGlobalLayoutListener {
        final /* synthetic */ UserEditCoverPhotoHeaderView f10369a;

        public C15261(UserEditCoverPhotoHeaderView userEditCoverPhotoHeaderView) {
            this.f10369a = userEditCoverPhotoHeaderView;
        }

        public void onGlobalLayout() {
            if (this.f10369a.f10378i == null) {
                this.f10369a.f10378i = this.f10369a.f10376g.m11451e();
            }
            if (this.f10369a.f10378i != null) {
                this.f10369a.m10494a();
                if (this.f10369a.f10377h != null) {
                    this.f10369a.removeView(this.f10369a.f10377h);
                    this.f10369a.f10377h = null;
                }
                if (this.f10369a.f10379j == null) {
                    UserEditCoverPhotoHeaderView userEditCoverPhotoHeaderView = this.f10369a;
                    userEditCoverPhotoHeaderView.f10379j = new View(userEditCoverPhotoHeaderView.getContext());
                    userEditCoverPhotoHeaderView.f10379j.setClickable(true);
                    userEditCoverPhotoHeaderView.f10379j.setBackgroundResource(2131363013);
                    userEditCoverPhotoHeaderView.f10379j.setLayoutParams(new LayoutParams(-1, -1));
                    UserEditCoverPhotoHeaderView.m10493c(userEditCoverPhotoHeaderView);
                    userEditCoverPhotoHeaderView.addView(userEditCoverPhotoHeaderView.f10379j);
                }
                UserEditCoverPhotoHeaderView.m10493c(this.f10369a);
            }
        }
    }

    public static void m10492a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        UserEditCoverPhotoHeaderView userEditCoverPhotoHeaderView = (UserEditCoverPhotoHeaderView) obj;
        ScreenUtil a = ScreenUtil.a(fbInjector);
        TimelineHeaderAdapterFactory a2 = TimelineHeaderAdapterFactory.m11419a(fbInjector);
        TimelineHeaderDataLoggerProvider timelineHeaderDataLoggerProvider = (TimelineHeaderDataLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineHeaderDataLoggerProvider.class);
        userEditCoverPhotoHeaderView.f10370a = a;
        userEditCoverPhotoHeaderView.f10371b = a2;
        userEditCoverPhotoHeaderView.f10372c = timelineHeaderDataLoggerProvider;
    }

    public UserEditCoverPhotoHeaderView(String str, Context context) {
        super(context);
        this.f10373d = str;
        Class cls = UserEditCoverPhotoHeaderView.class;
        m10492a(this, getContext());
        LayoutInflater from = LayoutInflater.from(context);
        this.f10375f = (BetterRecyclerView) from.inflate(2130907451, this, false);
        this.f10375f.setLayoutManager(new NotScrollingBetterLinearLayoutManager(getContext()));
        addView(this.f10375f);
        this.f10377h = (LoadingIndicatorView) from.inflate(2130907468, this, false);
        this.f10377h.setClickable(true);
        this.f10377h.a();
        this.f10377h.setBackgroundResource(2131361980);
        addView(this.f10377h);
    }

    public final void m10494a() {
        if (this.f10374e == null) {
            ViewStub viewStub = (ViewStub) this.f10378i.findViewById(2131564399);
            viewStub.setLayoutResource(2130907439);
            this.f10374e = (CoverPhotoEditView) viewStub.inflate();
        }
        this.f10374e.m11761a(this.f10373d, this.f10370a.c(), this.f10378i.c);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f10378i == null) {
            this.f10378i = this.f10376g.m11451e();
        }
        if (this.f10378i != null) {
            this.f10378i.onConfigurationChanged(configuration);
            m10494a();
            m10493c(this);
        }
    }

    public static void m10493c(UserEditCoverPhotoHeaderView userEditCoverPhotoHeaderView) {
        int measuredHeight = userEditCoverPhotoHeaderView.f10378i.getMeasuredHeight();
        LayoutParams layoutParams = (LayoutParams) userEditCoverPhotoHeaderView.f10379j.getLayoutParams();
        if (measuredHeight != layoutParams.topMargin) {
            layoutParams.topMargin = measuredHeight;
            userEditCoverPhotoHeaderView.requestLayout();
        }
    }
}
