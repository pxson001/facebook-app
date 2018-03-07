package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.inject.Lazy;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.FaceBoxInfo;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController.DefaultTagSuggestionsListener;
import com.facebook.photos.mediagallery.ui.tagging.FaceBoxInfoUtils.C02951;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper.SelectedFaceParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GoodFriendsTaggingTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: smsId */
public abstract class TypeaheadController {
    final TypeaheadAnimationHelper f2469a;
    SelectedFaceParams f2470b;
    Matrix f2471c = new Matrix();
    public PointF f2472d;
    public float f2473e;
    @VisibleForTesting
    Optional<List<FaceBoxInfo>> f2474f = Optional.fromNullable(null);
    @VisibleForTesting
    public RectF f2475g;
    @VisibleForTesting
    final RectF f2476h = new RectF();
    PointF f2477i;
    @VisibleForTesting
    TypeaheadTarget f2478j;
    private final FaceBoxInfoUtils f2479k;
    public final TaggingProfileFactory f2480l;
    public final TagTypeaheadDataSource f2481m;
    public final DefaultSuggestionController f2482n;
    @Nullable
    public FaceBoxInfoModel f2483o;

    /* compiled from: smsId */
    public class C03191 implements DefaultTagSuggestionsListener {
        final /* synthetic */ TypeaheadController f2573a;

        public C03191(TypeaheadController typeaheadController) {
            this.f2573a = typeaheadController;
        }

        public final void mo129a(ImmutableList<TaggingProfile> immutableList) {
            this.f2573a.f2478j.setTagSuggestions(immutableList);
        }
    }

    abstract SelectedFaceParams mo123a();

    public abstract void mo124a(@Nullable Runnable runnable, boolean z);

    abstract SelectedFaceParams mo125b();

    public abstract void mo126c();

    abstract void mo127d();

    abstract void mo128e();

    public TypeaheadController(TypeaheadAnimationHelper typeaheadAnimationHelper, FaceBoxInfoUtils faceBoxInfoUtils, TaggingProfileFactory taggingProfileFactory, Lazy<TagTypeaheadDataSource> lazy, DefaultSuggestionController defaultSuggestionController, int i, String str, @Nullable String str2, GroupMembersTaggingTypeaheadDataSourceProvider groupMembersTaggingTypeaheadDataSourceProvider, Lazy<GoodFriendsTaggingTypeaheadDataSource> lazy2, QeAccessor qeAccessor) {
        this.f2479k = faceBoxInfoUtils;
        this.f2469a = typeaheadAnimationHelper;
        this.f2480l = taggingProfileFactory;
        if (i == 69076575 && qeAccessor.a(ExperimentsForTaggingABTestModule.d, false)) {
            this.f2481m = groupMembersTaggingTypeaheadDataSourceProvider.a(Long.valueOf(Long.parseLong(str)));
        } else if ("good_friends".equals(str2)) {
            this.f2481m = (TagTypeaheadDataSource) lazy2.get();
        } else {
            this.f2481m = (TagTypeaheadDataSource) lazy.get();
        }
        this.f2482n = defaultSuggestionController;
    }

    public final void m2599a(FaceBoxInfo faceBoxInfo, Collection<FaceBoxInfo> collection) {
        Preconditions.checkNotNull(faceBoxInfo);
        Preconditions.checkNotNull(collection);
        mo127d();
        FaceBoxInfoUtils faceBoxInfoUtils = this.f2479k;
        Preconditions.checkNotNull(collection);
        List a = Lists.a(collection);
        Collections.sort(a, new C02951(faceBoxInfoUtils));
        this.f2474f = Optional.of(a);
        this.f2483o = faceBoxInfo;
        this.f2475g = FaceBoxInfoUtils.m2616a((FaceBoxInfoModel) faceBoxInfo);
        this.f2470b = mo123a();
        mo128e();
        this.f2478j = new TypeaheadTarget(faceBoxInfo.d(), Lists.a(), m2595n(), m2596o(), true);
    }

    public final void m2598a(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        mo127d();
        this.f2475g = new RectF(pointF.x, pointF.y, pointF.x, pointF.y);
        this.f2470b = mo125b();
        mo128e();
        this.f2478j = new TypeaheadTarget(null, Lists.a(), m2595n(), m2596o(), false);
        m2600a((DefaultTagSuggestionsListener) new C03191(this));
    }

    public final void m2600a(DefaultTagSuggestionsListener defaultTagSuggestionsListener) {
        this.f2482n.m2570a(defaultTagSuggestionsListener);
    }

    public final TypeaheadTarget m2606g() {
        Preconditions.checkNotNull(this.f2478j);
        return this.f2478j;
    }

    public final boolean m2607k() {
        return this.f2474f.isPresent() && ((List) this.f2474f.get()).size() > 1;
    }

    public final void m2608l() {
        Preconditions.checkState(m2607k());
        Preconditions.checkNotNull(this.f2483o);
        int indexOf = ((List) this.f2474f.get()).indexOf(this.f2483o);
        if (indexOf != -1) {
            this.f2483o = (FaceBoxInfoModel) ((List) this.f2474f.get()).get(indexOf + 1 < ((List) this.f2474f.get()).size() ? indexOf + 1 : 0);
            ((List) this.f2474f.get()).remove(indexOf);
            this.f2475g = FaceBoxInfoUtils.m2616a(this.f2483o);
            mo128e();
            this.f2478j = new TypeaheadTarget(this.f2483o.d(), Lists.a(), m2595n(), m2596o(), true);
        }
    }

    private PointF m2595n() {
        Preconditions.checkNotNull(this.f2477i);
        return new PointF(this.f2476h.centerX(), this.f2476h.bottom);
    }

    private PointF m2596o() {
        Preconditions.checkNotNull(this.f2477i);
        return new PointF(this.f2477i.x, this.f2477i.y + (this.f2470b.b / 2.0f));
    }
}
