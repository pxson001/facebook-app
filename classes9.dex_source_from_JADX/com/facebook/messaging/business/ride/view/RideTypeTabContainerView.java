package com.facebook.messaging.business.ride.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideTypeModel;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mmsproxy */
public class RideTypeTabContainerView extends CustomFrameLayout {
    private HorizontalScrollView f9419a;
    public LinearLayout f9420b;
    private ProgressBar f9421c;
    private BetterTextView f9422d;
    public int f9423e;
    @Nullable
    public RideTypeModel f9424f;
    @Nullable
    public OnTabClickListener f9425g;

    /* compiled from: mmsproxy */
    public interface OnTabClickListener {
        void mo336a(RideTypeModel rideTypeModel);
    }

    /* compiled from: mmsproxy */
    public class TabView extends BetterButton {
        final /* synthetic */ RideTypeTabContainerView f9416a;
        public int f9417b;
        public RideTypeModel f9418c;

        @SuppressLint({"ConstructorMayLeakThis"})
        public TabView(final RideTypeTabContainerView rideTypeTabContainerView, Context context) {
            this.f9416a = rideTypeTabContainerView;
            super(context);
            m9871d();
            m9875c();
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TabView f9415b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1347523986);
                    ((TabView) this.f9415b.f9416a.f9420b.getChildAt(this.f9415b.f9416a.f9423e)).m9875c();
                    this.f9415b.m9874b();
                    this.f9415b.f9416a.f9424f = this.f9415b.f9418c;
                    this.f9415b.f9416a.f9423e = this.f9415b.f9417b;
                    if (this.f9415b.f9416a.f9425g != null) {
                        this.f9415b.f9416a.f9425g.mo336a(this.f9415b.f9418c);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 355300954, a);
                }
            });
        }

        public final void m9873a(int i, RideTypeModel rideTypeModel) {
            setText(rideTypeModel.m9605a());
            m9875c();
            this.f9418c = rideTypeModel;
            this.f9417b = i;
        }

        public final RideTypeModel m9872a() {
            return this.f9418c;
        }

        public final void m9874b() {
            setTextAppearance(getContext(), 2131626400);
        }

        public final void m9875c() {
            setTextAppearance(getContext(), 2131626399);
        }

        private void m9871d() {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131433574);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.setMargins(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            setLayoutParams(layoutParams);
            setAllCaps(false);
            m9875c();
            setBackgroundColor(getResources().getColor(2131361871));
        }
    }

    public RideTypeTabContainerView(Context context) {
        super(context);
        m9881b();
    }

    public RideTypeTabContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9881b();
    }

    public RideTypeTabContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9881b();
    }

    public final void m9886a(Bundle bundle) {
        FlatBufferModelHelper.a(bundle, "last_selected_ride_type", this.f9424f);
        bundle.putInt("last_selected_index", this.f9423e);
    }

    public final void m9889b(Bundle bundle) {
        if (bundle != null) {
            this.f9424f = (RideTypeModel) FlatBufferModelHelper.a(bundle, "last_selected_ride_type");
            this.f9423e = bundle.getInt("last_selected_index", 0);
        }
    }

    private void m9881b() {
        setContentView(2130906898);
        this.f9419a = (HorizontalScrollView) c(2131567090);
        this.f9420b = (LinearLayout) c(2131567091);
        this.f9421c = (ProgressBar) c(2131567093);
        this.f9422d = (BetterTextView) c(2131567092);
    }

    public final void m9887a(@Nullable ImmutableList<RideTypeModel> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            m9888a(getResources().getString(2131240751));
            return;
        }
        m9884e();
        setUpTabs(immutableList);
        m9882b((ImmutableList) immutableList);
    }

    @Nullable
    public RideTypeModel getSelectedRideTypeModel() {
        return this.f9424f;
    }

    private void m9884e() {
        this.f9422d.setVisibility(8);
        this.f9421c.setVisibility(4);
        this.f9420b.setVisibility(0);
    }

    public final void m9888a(String str) {
        this.f9421c.setVisibility(4);
        this.f9420b.setVisibility(4);
        this.f9422d.setVisibility(0);
        this.f9422d.setText(str);
    }

    public final void m9885a() {
        this.f9420b.setVisibility(4);
        this.f9422d.setVisibility(8);
        this.f9421c.setVisibility(0);
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.f9425g = onTabClickListener;
    }

    private void m9882b(ImmutableList<RideTypeModel> immutableList) {
        this.f9423e = this.f9424f == null ? 0 : m9876a(this.f9424f, (ImmutableList) immutableList);
        this.f9424f = (RideTypeModel) immutableList.get(this.f9423e);
        this.f9419a.scrollTo(this.f9423e, 0);
        if (this.f9425g != null) {
            TabView tabView = (TabView) this.f9420b.getChildAt(this.f9423e);
            tabView.m9874b();
            this.f9425g.mo336a(tabView.f9418c);
        }
    }

    private void setUpTabs(ImmutableList<RideTypeModel> immutableList) {
        int size = immutableList.size();
        int childCount = this.f9420b.getChildCount();
        if (childCount < size) {
            while (childCount < size) {
                this.f9420b.addView(new TabView(this, getContext()));
                childCount++;
            }
        } else if (childCount > size) {
            while (size < childCount) {
                this.f9420b.removeView(this.f9420b.getChildAt(size));
                size++;
            }
        }
        for (int i = 0; i < immutableList.size(); i++) {
            ((TabView) this.f9420b.getChildAt(i)).m9873a(i, (RideTypeModel) immutableList.get(i));
        }
    }

    private static int m9876a(RideTypeModel rideTypeModel, ImmutableList<RideTypeModel> immutableList) {
        for (int i = 0; i < immutableList.size(); i++) {
            if (rideTypeModel.m9605a().equals(((RideTypeModel) immutableList.get(i)).m9605a())) {
                return i;
            }
        }
        return 0;
    }
}
