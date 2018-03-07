package com.facebook.katana.urimap.fetchable;

import android.content.Context;
import com.facebook.auth.component.persistent.AbstractPersistentComponent;
import com.facebook.common.build.BuildConstants;
import com.facebook.config.background.ConfigurationComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.util.Fb4aUtilsModule;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: supported_display_styles */
public class FacewebUriComponent extends AbstractPersistentComponent implements ConfigurationComponent {
    public final FetchFacewebUriMapMethod f1566a;
    public final UriTemplateMapParser f1567b;
    public final Context f1568c;

    /* compiled from: supported_display_styles */
    class FacewebMappingFetchBatchComponent implements BatchComponent {
        final /* synthetic */ FacewebUriComponent f1614a;

        public FacewebMappingFetchBatchComponent(FacewebUriComponent facewebUriComponent) {
            this.f1614a = facewebUriComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f1614a.f1566a, null);
            a.f11927c = "fetchFacewebUriMap";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            String str;
            String str2 = (String) map.get("fetchFacewebUriMap");
            if (!BuildConstants.j || str2 == null) {
                str = str2;
            } else {
                str = str2.replace("fb:\\/\\/", "fb-work:\\/\\/");
            }
            FacewebUriMap.m1793b(this.f1614a.f1568c).mo113a(this.f1614a.f1568c, true, null, str, this.f1614a.f1567b.m1792a(str));
        }
    }

    public static FacewebUriComponent m1780b(InjectorLike injectorLike) {
        return new FacewebUriComponent(new FetchFacewebUriMapMethod(Fb4aUtilsModule.m1785a()), C0085x28de9b83.m1788b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FacewebUriComponent(FetchFacewebUriMapMethod fetchFacewebUriMapMethod, UriTemplateMapParser uriTemplateMapParser, Context context) {
        this.f1566a = fetchFacewebUriMapMethod;
        this.f1567b = uriTemplateMapParser;
        this.f1568c = context;
    }

    public final boolean cn_() {
        return FacewebUriMap.m1793b(this.f1568c).f1585g.m1843c(null);
    }

    public final BatchComponent mo95c() {
        return new FacewebMappingFetchBatchComponent(this);
    }

    public final BatchComponent mo101b() {
        return new FacewebMappingFetchBatchComponent(this);
    }

    public final long co_() {
        return 604800000;
    }
}
