package com.facebook.timeline.favmediapicker.rows.parts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.media.data.LocalMediaData.Builder;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.timeline.favmediapicker.models.CameraRollData;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import com.facebook.timeline.favmediapicker.ui.FavoriteMediaPickerActivity;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_settings_report_problem */
public class CameraRollPartDefinition extends MultiRowSinglePartDefinition<CameraRollData, Void, FavoriteMediaPickerEnvironment, HScrollRecyclerView> {
    public static final CacheableEntity f11047a = new C15981();
    public static final CallerContext f11048b = CallerContext.a(CameraRollPartDefinition.class, "favorite_media_picker");
    private static CameraRollPartDefinition f11049i;
    private static final Object f11050j = new Object();
    public final OpenCameraPartDefinition f11051c;
    public final ClickablePhotoPartDefinition f11052d;
    private final PersistentRecyclerPartDefinition<Object, FavoriteMediaPickerEnvironment> f11053e;
    private final ViewPaddingPartDefinition f11054f;
    public final PageStyleFactory f11055g;
    public final Resources f11056h;

    /* compiled from: friends_nearby_settings_report_problem */
    final class C15981 implements CacheableEntity {
        C15981() {
        }

        public final String m11220g() {
            return "camera_roll_key";
        }
    }

    /* compiled from: friends_nearby_settings_report_problem */
    public class C16003 implements OnClickListener {
        final /* synthetic */ Uri f11045a;
        final /* synthetic */ CameraRollPartDefinition f11046b;

        public C16003(CameraRollPartDefinition cameraRollPartDefinition, Uri uri) {
            this.f11046b = cameraRollPartDefinition;
            this.f11045a = uri;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2010642064);
            FavoriteMediaPickerActivity favoriteMediaPickerActivity = (FavoriteMediaPickerActivity) ContextUtils.a(view.getContext(), FavoriteMediaPickerActivity.class);
            if (favoriteMediaPickerActivity != null) {
                CameraRollPartDefinition cameraRollPartDefinition = this.f11046b;
                Uri uri = this.f11045a;
                Intent intent = new Intent();
                PhotoItemBuilder photoItemBuilder = new PhotoItemBuilder();
                photoItemBuilder.f = new Builder().a(new MediaData.Builder().a(uri.toString()).a(Type.Photo).a(uri).a()).a();
                PhotoItem a2 = photoItemBuilder.a();
                ArrayList arrayList = new ArrayList();
                arrayList.add(a2);
                intent.putParcelableArrayListExtra("extra_media_items", arrayList);
                favoriteMediaPickerActivity.setResult(-1, intent);
                favoriteMediaPickerActivity.finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 523161415, a);
        }
    }

    private static CameraRollPartDefinition m11225b(InjectorLike injectorLike) {
        return new CameraRollPartDefinition(OpenCameraPartDefinition.m11243a(injectorLike), ClickablePhotoPartDefinition.m11235a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m11228a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CameraRollData cameraRollData = (CameraRollData) obj;
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f11053e;
        final List list = cameraRollData.f11016a;
        subParts.a(persistentRecyclerPartDefinition, new Props(this.f11055g.a((this.f11056h.getDimension(2131433945) / this.f11056h.getDisplayMetrics().density) + 8.0f, PaddingStyle.Builder.c().i(), true), 0, new SimpleCallbacks<FavoriteMediaPickerEnvironment>(this) {
            final /* synthetic */ CameraRollPartDefinition f11044b;

            public final void m11222a(PageSubParts<FavoriteMediaPickerEnvironment> pageSubParts) {
                pageSubParts.a(this.f11044b.f11051c, null);
                for (MediaModel mediaModel : list) {
                    CameraRollPartDefinition cameraRollPartDefinition = this.f11044b;
                    Uri uri = mediaModel.d;
                    FbDraweePartDefinition.Props.Builder builder = new FbDraweePartDefinition.Props.Builder();
                    builder.c = CameraRollPartDefinition.f11048b;
                    pageSubParts.a(this.f11044b.f11052d, new ClickablePhotoPartDefinition.Props(builder.a(uri).a(), new C16003(cameraRollPartDefinition, uri)));
                }
            }

            public final void m11223c(int i) {
            }

            public final int m11221a() {
                return list.size() + 1;
            }
        }, f11047a.g(), f11047a));
        subParts.a(this.f11054f, m11226c());
        return null;
    }

    public final /* bridge */ /* synthetic */ void m11229a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1418517789);
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        CustomViewUtils.b(hScrollRecyclerView, new ColorDrawable(ContextCompat.b(hScrollRecyclerView.getContext(), 2131361920)));
        Logger.a(8, EntryType.MARK_POP, 1637798073, a);
    }

    public static CameraRollPartDefinition m11224a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CameraRollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11050j) {
                CameraRollPartDefinition cameraRollPartDefinition;
                if (a2 != null) {
                    cameraRollPartDefinition = (CameraRollPartDefinition) a2.a(f11050j);
                } else {
                    cameraRollPartDefinition = f11049i;
                }
                if (cameraRollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11225b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11050j, b3);
                        } else {
                            f11049i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = cameraRollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CameraRollPartDefinition(OpenCameraPartDefinition openCameraPartDefinition, ClickablePhotoPartDefinition clickablePhotoPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ViewPaddingPartDefinition viewPaddingPartDefinition, PageStyleFactory pageStyleFactory, Resources resources) {
        this.f11051c = openCameraPartDefinition;
        this.f11052d = clickablePhotoPartDefinition;
        this.f11053e = persistentRecyclerPartDefinition;
        this.f11054f = viewPaddingPartDefinition;
        this.f11055g = pageStyleFactory;
        this.f11056h = resources;
    }

    public final ViewType<HScrollRecyclerView> m11227a() {
        return HScrollRecyclerViewRowType.b;
    }

    public final boolean m11230a(Object obj) {
        return true;
    }

    private PaddingData m11226c() {
        int dimensionPixelSize = this.f11056h.getDimensionPixelSize(2131433946);
        return new PaddingData(dimensionPixelSize, 0, dimensionPixelSize, this.f11056h.getDimensionPixelSize(2131433947));
    }
}
