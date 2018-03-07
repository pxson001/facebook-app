package com.facebook.stickers.keyboard;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.search.StickerSearchContainer;

/* compiled from: education experience type should not be null */
public class StickerKeyboard extends AbstractComposerKeyboard<StickerKeyboardView> {
    public final void mo1263a(Bundle bundle) {
        StickerKeyboardView stickerKeyboardView = (StickerKeyboardView) this.f12056a;
        Bundle bundle2 = bundle.getBundle("adapter");
        if (bundle2 != null) {
            stickerKeyboardView.f16690k.f16767v = bundle2.getBundle("search");
        }
        stickerKeyboardView.f16673E = (StickerPack) bundle.getParcelable("primary_download_preview_sticker_pack");
    }

    public final void mo1266d() {
        ((StickerKeyboardView) this.f12056a).m24511e();
    }

    public final void mo1267e() {
        ((StickerKeyboardView) this.f12056a).m24511e();
    }

    public final Bundle mo1268i() {
        Bundle bundle;
        Bundle bundle2;
        StickerKeyboardView stickerKeyboardView = (StickerKeyboardView) this.f12056a;
        Bundle bundle3 = new Bundle();
        StickerTabbedPagerAdapter stickerTabbedPagerAdapter = stickerKeyboardView.f16690k;
        if (stickerTabbedPagerAdapter.f16766u != null && stickerTabbedPagerAdapter.f16766u.getVisibility() == 0) {
            Bundle bundle4;
            Bundle bundle5;
            StickerSearchContainer stickerSearchContainer = stickerTabbedPagerAdapter.f16766u;
            if (stickerSearchContainer.f16855z.getVisibility() == 0) {
                Object obj = stickerSearchContainer.f16855z.getText().toString();
                if (!StringUtil.a(obj)) {
                    bundle4 = new Bundle();
                    bundle4.putString("query", obj);
                    bundle5 = bundle4;
                    if (bundle5 != null) {
                        bundle = new Bundle();
                        bundle.putBundle("search", bundle5);
                        bundle2 = bundle;
                        if (bundle2 != null) {
                            bundle3.putBundle("adapter", bundle2);
                        }
                        bundle3.putParcelable("primary_download_preview_sticker_pack", stickerKeyboardView.f16673E);
                        return bundle3;
                    }
                }
            }
            bundle4 = null;
            bundle5 = bundle4;
            if (bundle5 != null) {
                bundle = new Bundle();
                bundle.putBundle("search", bundle5);
                bundle2 = bundle;
                if (bundle2 != null) {
                    bundle3.putBundle("adapter", bundle2);
                }
                bundle3.putParcelable("primary_download_preview_sticker_pack", stickerKeyboardView.f16673E);
                return bundle3;
            }
        }
        bundle = null;
        bundle2 = bundle;
        if (bundle2 != null) {
            bundle3.putBundle("adapter", bundle2);
        }
        bundle3.putParcelable("primary_download_preview_sticker_pack", stickerKeyboardView.f16673E);
        return bundle3;
    }

    public final boolean mo1269j() {
        return ((StickerKeyboardView) this.f12056a).f16675G;
    }

    public final View mo1265b(ViewGroup viewGroup) {
        StickerKeyboardView stickerKeyboardView = new StickerKeyboardView(viewGroup.getContext());
        stickerKeyboardView.setInterface(StickerInterface.MESSENGER);
        return stickerKeyboardView;
    }

    public final void mo1264a(ThreadKey threadKey) {
        if (threadKey == null) {
            return;
        }
        if (ThreadKey.m3499d(threadKey)) {
            ((StickerKeyboardView) this.f12056a).setInterface(StickerInterface.SMS);
        } else {
            ((StickerKeyboardView) this.f12056a).setInterface(StickerInterface.MESSENGER);
        }
    }
}
