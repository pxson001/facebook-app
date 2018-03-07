package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.multirow.api.ViewType;

/* compiled from: gravity_end_scan_session_success */
public abstract class DualPhotoBasePartDefinition<FeedUnit extends Flattenable, E extends HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<FeedUnit>, State, E, DualPhotoView> {
    public static final ViewType f12199a = new C12991();
    public final CallerContext f12200b = CallerContext.a(getClass(), "native_newsfeed");
    private final FbDraweeControllerBuilder f12201c;

    /* compiled from: gravity_end_scan_session_success */
    final class C12991 extends ViewType {
        C12991() {
        }

        public final View m14185a(Context context) {
            return new DualPhotoView(context);
        }
    }

    /* compiled from: gravity_end_scan_session_success */
    public class State {
        public DraweeController f12196a;
        public DraweeController f12197b;
        public DualPhotoViewConfig f12198c;

        public State(DraweeController draweeController, DraweeController draweeController2, DualPhotoViewConfig dualPhotoViewConfig) {
            this.f12196a = draweeController;
            this.f12197b = draweeController2;
            this.f12198c = dualPhotoViewConfig;
        }
    }

    public DualPhotoBasePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f12201c = fbDraweeControllerBuilder;
    }

    public final ViewType m14187a() {
        return f12199a;
    }

    public final State m14186a(E e, String str, String str2, DualPhotoViewConfig dualPhotoViewConfig) {
        ImageRequest a = ImageRequest.a(str);
        ImageRequest a2 = ImageRequest.a(str2);
        ((HasPrefetcher) e).a(a, this.f12200b);
        ((HasPrefetcher) e).a(a2, this.f12200b);
        return new State(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12201c.c(a)).a(true)).a(this.f12200b).s(), ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12201c.c(a2)).a(true)).a(this.f12200b).s(), dualPhotoViewConfig);
    }
}
