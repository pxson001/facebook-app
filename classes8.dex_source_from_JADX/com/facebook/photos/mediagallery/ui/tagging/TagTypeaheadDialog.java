package com.facebook.photos.mediagallery.ui.tagging;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagScreen;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagSource;
import com.facebook.photos.data.TaggingProfileProvider;
import com.facebook.photos.data.TaggingProfileProvider.2;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.FaceBoxInfo;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxSuggestionsQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxSuggestionsQueryModel.EdgesModel;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.PhotosKeyboard;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController.DefaultTagSuggestionsListener;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController.C03024;
import com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory.C03171;
import com.facebook.photos.tagging.shared.TagTypeahead;
import com.facebook.photos.tagging.shared.TagTypeahead.TagTypeaheadListener;
import com.facebook.photos.tagging.shared.TagTypeaheadAdapter.TagTypeaheadAdapterCallback;
import com.facebook.photos.tagging.shared.VignetteOverlay;
import com.facebook.photos.tagging.shared.logging.TaggingAnalyticHelper;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.ui.dialogs.FbDialog;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: slideshow_data */
public class TagTypeaheadDialog extends FbDialog {
    private final Context f2515a;
    public final C03024 f2516b;
    public final TypeaheadController f2517c;
    public final MediaMutationGenerator f2518d;
    public final String f2519e;
    private final TagTypeaheadAdapterCallback f2520f;
    public final Optional<VignetteOverlay> f2521g;
    public final Lazy<MediaLogger> f2522h;
    public final TaggingAnalyticHelper f2523i;
    public TagTypeahead f2524j;
    public boolean f2525k;
    private final Runnable f2526l = new C03084(this);
    public final Runnable f2527m = new C03095(this);

    /* compiled from: slideshow_data */
    public class C03051 implements OnDismissListener {
        final /* synthetic */ TagTypeaheadDialog f2509a;

        public C03051(TagTypeaheadDialog tagTypeaheadDialog) {
            this.f2509a = tagTypeaheadDialog;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f2509a.f2524j.isShown()) {
                this.f2509a.f2524j.a(false, null);
            }
            this.f2509a.f2517c.f2482n.f2445c.clear();
            C03024 c03024 = this.f2509a.f2516b;
            c03024.f2501a.f2461n = null;
            MediaTaggingController.m2574b(c03024.f2501a, false);
        }
    }

    /* compiled from: slideshow_data */
    class C03062 implements Runnable {
        final /* synthetic */ TagTypeaheadDialog f2510a;

        C03062(TagTypeaheadDialog tagTypeaheadDialog) {
            this.f2510a = tagTypeaheadDialog;
        }

        public void run() {
            TagTypeaheadDialog.m2650c(this.f2510a);
        }
    }

    /* compiled from: slideshow_data */
    public class C03073 implements DefaultTagSuggestionsListener {
        final /* synthetic */ TagTypeaheadDialog f2511a;

        public C03073(TagTypeaheadDialog tagTypeaheadDialog) {
            this.f2511a = tagTypeaheadDialog;
        }

        public final void mo129a(ImmutableList<TaggingProfile> immutableList) {
            this.f2511a.f2524j.setDefaultTagSuggestions(immutableList);
        }
    }

    /* compiled from: slideshow_data */
    class C03084 implements Runnable {
        final /* synthetic */ TagTypeaheadDialog f2512a;

        C03084(TagTypeaheadDialog tagTypeaheadDialog) {
            this.f2512a = tagTypeaheadDialog;
        }

        public void run() {
            this.f2512a.f2524j.a(this.f2512a.f2517c.m2606g().m2676c(), 0.0f);
            this.f2512a.f2524j.b();
            this.f2512a.f2517c.mo124a(this.f2512a.f2527m, this.f2512a.f2525k);
        }
    }

    /* compiled from: slideshow_data */
    class C03095 implements Runnable {
        final /* synthetic */ TagTypeaheadDialog f2513a;

        C03095(TagTypeaheadDialog tagTypeaheadDialog) {
            this.f2513a = tagTypeaheadDialog;
        }

        public void run() {
            TagTypeaheadDialog.m2652f(this.f2513a);
        }
    }

    /* compiled from: slideshow_data */
    public class C03106 implements TagTypeaheadListener {
        final /* synthetic */ TagTypeaheadDialog f2514a;

        public C03106(TagTypeaheadDialog tagTypeaheadDialog) {
            this.f2514a = tagTypeaheadDialog;
        }

        public final void m2646a(TaggingProfile taggingProfile, int i, String str) {
            boolean z;
            TagSource tagSource;
            MediaMutationGenerator mediaMutationGenerator = this.f2514a.f2518d;
            String str2 = this.f2514a.f2519e;
            TypeaheadController typeaheadController = this.f2514a.f2517c;
            Preconditions.checkNotNull(typeaheadController.f2475g);
            mediaMutationGenerator.a(str2, taggingProfile, new PointF(typeaheadController.f2475g.centerX(), typeaheadController.f2475g.centerY()));
            TagTypeaheadDialog tagTypeaheadDialog = this.f2514a;
            if (taggingProfile.b == -1) {
                z = true;
            } else {
                z = false;
            }
            if (tagTypeaheadDialog.f2517c.m2606g().f2574a) {
                tagSource = TagSource.FACEBOX;
            } else {
                tagSource = TagSource.TAP_ANYWHERE;
            }
            ((MediaLogger) tagTypeaheadDialog.f2522h.get()).a(z, i, tagSource, TagScreen.CONSUMPTION);
            this.f2514a.f2523i.a(taggingProfile, str, this.f2514a.f2517c.f2481m.e());
            if (this.f2514a.f2517c.m2607k()) {
                this.f2514a.f2525k = false;
                this.f2514a.f2524j.setVisibility(8);
                this.f2514a.f2517c.m2608l();
                TagTypeaheadDialog.m2650c(this.f2514a);
                return;
            }
            TagTypeaheadDialog.m2651e(this.f2514a);
        }

        public final void m2645a() {
            this.f2514a.f2523i.b(this.f2514a.f2517c.f2481m.b(), this.f2514a.f2517c.f2481m.e());
            TagTypeaheadDialog.m2651e(this.f2514a);
        }

        public final void m2647b() {
            this.f2514a.f2523i.a(this.f2514a.f2517c.f2481m.b(), this.f2514a.f2517c.f2481m.e());
        }
    }

    public static TagTypeaheadDialog m2648a(Context context, TypeaheadController typeaheadController, Lazy<MediaLogger> lazy, MediaMutationGenerator mediaMutationGenerator, String str, DialogDismissListener dialogDismissListener, TagTypeaheadAdapterCallback tagTypeaheadAdapterCallback, TaggingAnalyticHelper taggingAnalyticHelper, boolean z) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dialogDismissListener);
        Preconditions.checkNotNull(typeaheadController);
        Preconditions.checkNotNull(lazy);
        Preconditions.checkNotNull(mediaMutationGenerator);
        Preconditions.checkNotNull(tagTypeaheadAdapterCallback);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        TagTypeaheadDialog tagTypeaheadDialog = new TagTypeaheadDialog(context, lazy, mediaMutationGenerator, str, dialogDismissListener, typeaheadController, tagTypeaheadAdapterCallback, taggingAnalyticHelper, z ? new VignetteOverlay(context) : null);
        PhotosKeyboard.a(tagTypeaheadDialog.getWindow());
        tagTypeaheadDialog.show();
        return tagTypeaheadDialog;
    }

    private TagTypeaheadDialog(Context context, Lazy<MediaLogger> lazy, MediaMutationGenerator mediaMutationGenerator, String str, DialogDismissListener dialogDismissListener, TypeaheadController typeaheadController, TagTypeaheadAdapterCallback tagTypeaheadAdapterCallback, TaggingAnalyticHelper taggingAnalyticHelper, @Nullable VignetteOverlay vignetteOverlay) {
        super(context, 16973840);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        this.f2515a = context;
        this.f2522h = lazy;
        this.f2518d = mediaMutationGenerator;
        this.f2519e = str;
        this.f2516b = dialogDismissListener;
        this.f2517c = typeaheadController;
        this.f2520f = tagTypeaheadAdapterCallback;
        this.f2521g = Optional.fromNullable(vignetteOverlay);
        this.f2523i = taggingAnalyticHelper;
        this.f2525k = true;
        setOnDismissListener(new C03051(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f2521g.isPresent()) {
            addContentView((View) this.f2521g.get(), new LayoutParams(-1, -1));
        }
        this.f2524j = new TagTypeahead(this.f2515a);
        this.f2524j.r = new C03106(this);
        this.f2524j.a(this.f2517c.f2481m);
        this.f2517c.m2600a((DefaultTagSuggestionsListener) new C03073(this));
        addContentView(this.f2524j, new LayoutParams(-1, -1));
        GlobalOnLayoutHelper.c(this.f2524j, new C03062(this));
    }

    public static void m2650c(TagTypeaheadDialog tagTypeaheadDialog) {
        GlobalOnLayoutHelper.c(tagTypeaheadDialog.f2524j, tagTypeaheadDialog.f2526l);
    }

    public final void m2653a(MediaMetadata mediaMetadata) {
        TypeaheadTarget g = this.f2517c.m2606g();
        if (this.f2524j.isShown() && g.f2574a) {
            ImmutableList a = mediaMetadata.B().a();
            int size = a.size();
            int i = 0;
            while (i < size) {
                FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) a.get(i);
                if (!g.f2575b.isPresent() || !faceBoxInfoModel.d().equals(g.f2575b.get())) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void onBackPressed() {
        m2651e(this);
    }

    public static void m2651e(TagTypeaheadDialog tagTypeaheadDialog) {
        tagTypeaheadDialog.f2517c.mo126c();
        tagTypeaheadDialog.f2524j.a(false, null);
        if (tagTypeaheadDialog.f2521g.isPresent()) {
            ((VignetteOverlay) tagTypeaheadDialog.f2521g.get()).setVisibility(8);
        }
        tagTypeaheadDialog.dismiss();
    }

    private void m2649a(Optional<FaceBoxInfo> optional) {
        List list = this.f2517c.m2606g().f2578e;
        if (list == null || list.isEmpty()) {
            TypeaheadController typeaheadController = this.f2517c;
            TagTypeahead tagTypeahead = this.f2524j;
            Preconditions.checkNotNull(tagTypeahead);
            FaceBoxInfoModel faceBoxInfoModel = optional.isPresent() ? (FaceBoxInfoModel) optional.get() : typeaheadController.f2483o;
            if (faceBoxInfoModel != null) {
                TaggingProfileFactory taggingProfileFactory = typeaheadController.f2480l;
                FaceBoxSuggestionsQueryModel bf_ = faceBoxInfoModel.bf_();
                if (bf_ != null && bf_.a() != null && !bf_.a().isEmpty()) {
                    Object a = Lists.a();
                    ImmutableList a2 = bf_.a();
                    int size = a2.size();
                    for (int i = 0; i < size; i++) {
                        a.add(((EdgesModel) a2.get(i)).b().c());
                    }
                    TaggingProfileProvider taggingProfileProvider = taggingProfileFactory.f2556a;
                    taggingProfileFactory.f2559d.a(taggingProfileProvider.a.a(new 2(taggingProfileProvider, a)), new C03171(taggingProfileFactory, a, tagTypeahead));
                    return;
                }
                return;
            }
            return;
        }
        this.f2524j.setTagSuggestions(list);
    }

    public static void m2652f(TagTypeaheadDialog tagTypeaheadDialog) {
        TypeaheadTarget g = tagTypeaheadDialog.f2517c.m2606g();
        tagTypeaheadDialog.f2524j.setVisibility(0);
        tagTypeaheadDialog.f2524j.a(true, tagTypeaheadDialog.f2520f, g.f2578e, new PointF(g.f2576c.x, g.f2576c.y), g.m2676c(), true);
        tagTypeaheadDialog.m2649a((Optional) Absent.INSTANCE);
        if (tagTypeaheadDialog.f2521g.isPresent()) {
            Preconditions.checkArgument(tagTypeaheadDialog.f2521g.isPresent());
            ((VignetteOverlay) tagTypeaheadDialog.f2521g.get()).setRadius(tagTypeaheadDialog.f2517c.f2473e);
            ((VignetteOverlay) tagTypeaheadDialog.f2521g.get()).setPosition(tagTypeaheadDialog.f2517c.f2472d);
            ((VignetteOverlay) tagTypeaheadDialog.f2521g.get()).setVisibility(0);
        }
    }
}
