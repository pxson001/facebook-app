package com.facebook.photos.pandora.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: com.facebook.intent.action.PROFILE_PIC_UPDATED */
public class PandoraSyncTabLoadingFragment extends FbFragment {
    public final View m21655a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1847399389);
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(getContext());
        customFrameLayout.setBackgroundDrawable(new ColorDrawable(jW_().getColor(2131363277)));
        PandoraBennyLoadingSpinnerView pandoraBennyLoadingSpinnerView = new PandoraBennyLoadingSpinnerView(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        customFrameLayout.addView(pandoraBennyLoadingSpinnerView, layoutParams);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1308885481, a);
        return customFrameLayout;
    }
}
