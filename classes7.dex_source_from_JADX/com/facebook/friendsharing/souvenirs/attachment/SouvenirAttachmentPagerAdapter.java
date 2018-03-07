package com.facebook.friendsharing.souvenirs.attachment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.util.SouvenirLocalImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.simplepicker.SimplePickerFragment.20;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Required UniversalFeedbackUIController not set */
public class SouvenirAttachmentPagerAdapter extends PagerAdapter {
    public final 20 f23998a;
    private final Context f23999b;
    private final SouvenirsViewStateProvider f24000c;
    public final ImmutableList<SouvenirModel> f24001d;
    private final SparseArray<ViewPageState> f24002e = new SparseArray();

    /* compiled from: Required UniversalFeedbackUIController not set */
    class ViewPageState {
        public final SouvenirsView f23995a;
        private final SouvenirsViewState f23996b;
        private boolean f23997c;

        public ViewPageState(SouvenirsView souvenirsView, SouvenirsViewState souvenirsViewState) {
            this.f23995a = souvenirsView;
            this.f23996b = souvenirsViewState;
        }

        public static void m26109a(ViewPageState viewPageState) {
            if (!viewPageState.f23997c) {
                viewPageState.f23995a.m26120a(viewPageState.f23996b);
                viewPageState.f23997c = true;
            }
        }

        public static void m26110b(ViewPageState viewPageState) {
            if (viewPageState.f23997c) {
                viewPageState.f23995a.m26119a();
                viewPageState.f23997c = false;
            }
        }
    }

    @Inject
    public SouvenirAttachmentPagerAdapter(@Assisted Delegate delegate, @Assisted ImmutableList<SouvenirModel> immutableList, Context context, SouvenirsViewStateProvider souvenirsViewStateProvider) {
        this.f23998a = delegate;
        this.f24001d = immutableList;
        this.f23999b = context;
        this.f24000c = souvenirsViewStateProvider;
    }

    public final Object m26111a(ViewGroup viewGroup, final int i) {
        OnClickListener c20781 = new OnClickListener(this) {
            final /* synthetic */ SouvenirAttachmentPagerAdapter f23994b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -934224515);
                this.f23994b.f23998a.a(i, (SouvenirModel) this.f23994b.f24001d.get(i));
                Logger.a(2, EntryType.UI_INPUT_END, 1515713007, a);
            }
        };
        SouvenirsViewStateProvider souvenirsViewStateProvider = this.f24000c;
        SouvenirsViewState souvenirsViewState = new SouvenirsViewState((SouvenirModel) this.f24001d.get(i), c20781, FbDraweeControllerBuilder.b(souvenirsViewStateProvider), SouvenirLocalImageRequest.m26452a(souvenirsViewStateProvider));
        souvenirsViewState.m26122a(this.f23999b, false, null);
        SouvenirsView souvenirsView = new SouvenirsView(this.f23999b);
        float dimension = this.f23999b.getResources().getDimension(2131432487);
        float dimension2 = this.f23999b.getResources().getDimension(2131432488);
        if (null == null) {
            souvenirsView.c(2131567530).setVisibility(8);
        }
        souvenirsView.f24014i = Float.valueOf(0.55f);
        souvenirsView.f24015j = Float.valueOf(dimension);
        souvenirsView.f24016k = Float.valueOf(dimension2);
        viewGroup.addView(souvenirsView);
        this.f24002e.put(i, new ViewPageState(souvenirsView, souvenirsViewState));
        return souvenirsView;
    }

    public final void m26114a(ViewGroup viewGroup, int i, Object obj) {
        ViewPageState viewPageState = (ViewPageState) this.f24002e.get(i);
        ViewPageState.m26110b(viewPageState);
        SouvenirsView souvenirsView = (SouvenirsView) obj;
        Preconditions.checkState(souvenirsView == viewPageState.f23995a);
        viewGroup.removeView(souvenirsView);
        this.f24002e.remove(i);
    }

    public final int m26116b() {
        return this.f24001d.size();
    }

    public final boolean m26115a(View view, Object obj) {
        return view == obj;
    }

    public final void m26113a(View view, int i, Object obj) {
        super.a(view, i, obj);
        ViewPageState.m26109a((ViewPageState) this.f24002e.get(i));
    }

    public final void m26112a(int i, float f) {
        ViewPageState.m26109a((ViewPageState) this.f24002e.get(i));
        int indexOfKey = this.f24002e.indexOfKey(i + 1);
        if (f <= 0.0f) {
            if (i > 0) {
                ViewPageState viewPageState = (ViewPageState) this.f24002e.get(i - 1);
                if (viewPageState != null) {
                    ViewPageState.m26110b(viewPageState);
                }
            }
            if (indexOfKey > 0) {
                ViewPageState.m26110b((ViewPageState) this.f24002e.valueAt(indexOfKey));
                return;
            }
            return;
        }
        ViewPageState.m26109a((ViewPageState) this.f24002e.valueAt(indexOfKey));
    }
}
