package com.facebook.messaging.montage.viewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.facebook.common.util.CollectionUtil;
import com.facebook.messaging.montage.model.MontageMessageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: is_complete */
public class MontageViewerPagerAdapter extends FragmentPagerAdapter {
    private final SparseArray<WeakReference<AbstractMontageItemFragment>> f12620a = new SparseArray();
    private ImmutableList<MontageMessageInfo> f12621b;

    public MontageViewerPagerAdapter(ImmutableList<MontageMessageInfo> immutableList, FragmentManager fragmentManager) {
        super(fragmentManager);
        Preconditions.checkArgument(CollectionUtil.b(immutableList));
        this.f12621b = immutableList;
        kR_();
    }

    public final Fragment m13074a(int i) {
        Preconditions.checkElementIndex(i, b());
        return m13073a((MontageMessageInfo) this.f12621b.get(i));
    }

    private static AbstractMontageItemFragment m13073a(MontageMessageInfo montageMessageInfo) {
        AbstractMontageItemFragment montagePhotoFragment;
        switch (montageMessageInfo.f12554a) {
            case PHOTO:
                montagePhotoFragment = new MontagePhotoFragment();
                montagePhotoFragment.g(AbstractMontageItemFragment.m13016a(montageMessageInfo));
                return montagePhotoFragment;
            case VIDEO:
                montagePhotoFragment = new MontageVideoFragment();
                montagePhotoFragment.g(AbstractMontageItemFragment.m13016a(montageMessageInfo));
                return montagePhotoFragment;
            case STICKER:
                montagePhotoFragment = new MontageStickerFragment();
                montagePhotoFragment.g(AbstractMontageItemFragment.m13016a(montageMessageInfo));
                return montagePhotoFragment;
            case TEXT:
                montagePhotoFragment = new MontageTextFragment();
                montagePhotoFragment.g(AbstractMontageItemFragment.m13016a(montageMessageInfo));
                return montagePhotoFragment;
            default:
                throw new IllegalStateException("Tried to createItemFragment with ineligible message.");
        }
    }

    public final Object m13075a(ViewGroup viewGroup, int i) {
        AbstractMontageItemFragment abstractMontageItemFragment = (AbstractMontageItemFragment) super.a(viewGroup, i);
        this.f12620a.put(i, new WeakReference(abstractMontageItemFragment));
        return abstractMontageItemFragment;
    }

    public final void m13076a(ViewGroup viewGroup, int i, Object obj) {
        this.f12620a.remove(i);
        super.a(viewGroup, i, obj);
    }

    @Nullable
    public final AbstractMontageItemFragment m13078e(int i) {
        WeakReference weakReference = (WeakReference) this.f12620a.get(i);
        return weakReference == null ? null : (AbstractMontageItemFragment) weakReference.get();
    }

    public final int m13077b() {
        return this.f12621b.size();
    }
}
