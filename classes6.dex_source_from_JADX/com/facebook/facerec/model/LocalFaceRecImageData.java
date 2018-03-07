package com.facebook.facerec.model;

import com.facebook.common.util.StringUtil;
import com.facebook.facerec.job.FaceDetectionJob;
import com.facebook.facerec.manager.FaceRecManager;
import com.facebook.facerec.manager.LegacyFaceRecManager;
import com.facebook.facerec.manager.LegacyFaceRecManager.FaceDetectionCompletedListenerImpl;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;

/* compiled from: non_group_members */
public class LocalFaceRecImageData {
    public final String f9937a = this.f9938b.f12748d;
    private final LocalPhoto f9938b;
    public final PhotoItem f9939c;
    public final List<Tag> f9940d = Lists.a();
    private final TagStore f9941e;
    private final FaceBoxStore f9942f;

    public LocalFaceRecImageData(PhotoItem photoItem, TagStore tagStore, FaceBoxStore faceBoxStore) {
        this.f9939c = photoItem;
        this.f9938b = photoItem.f12739f;
        this.f9941e = tagStore;
        this.f9942f = faceBoxStore;
    }

    public final boolean m15646a() {
        return this.f9942f.m21135c(this.f9938b);
    }

    public final ListenableFuture<List<FaceBox>> m15644a(FaceRecManager faceRecManager) {
        SettableFuture settableFuture;
        LegacyFaceRecManager legacyFaceRecManager = (LegacyFaceRecManager) faceRecManager;
        CharSequence charSequence = this.f9937a;
        int i = this.f9938b.f12749e;
        Preconditions.checkArgument(!StringUtil.a(charSequence));
        SettableFuture f = SettableFuture.f();
        if (legacyFaceRecManager.f9883a) {
            HandlerDetour.a(legacyFaceRecManager.f9927f, new FaceDetectionJob(new FaceDetectionCompletedListenerImpl(legacyFaceRecManager, f), legacyFaceRecManager.f9884b, legacyFaceRecManager.f9886d, charSequence, null, true, i), 320673903);
            settableFuture = f;
        } else {
            FutureDetour.a(f, new ArrayList(), 643355072);
            settableFuture = f;
        }
        return settableFuture;
    }

    public final List<FaceBox> m15647b() {
        return this.f9942f.m21129a(this.f9938b);
    }

    public final List<Tag> m15648c() {
        return this.f9941e.m21167b(this.f9939c);
    }

    public final void m15645a(List<FaceBox> list) {
        this.f9942f.m21131a(this.f9938b, list);
    }

    public final boolean m15649d() {
        return this.f9942f.m21136d(this.f9938b);
    }

    public final List<Tag> m15650e() {
        return ImmutableList.copyOf(this.f9940d);
    }

    public final String m15651f() {
        return this.f9937a;
    }

    public final long m15652g() {
        return this.f9938b.f12744a;
    }

    public final PhotoItem m15653h() {
        return this.f9939c;
    }
}
