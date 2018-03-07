package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.video.videohome.adapter.VideoHomeGuideAdapter;
import com.facebook.video.videohome.protocol.VideoHomeQueryInterfaces.VideoHomeCreatorYouShouldFollow;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomeCreatorYouShouldFollowModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signed_pre_key */
public class VideoHomeVideoChannelRecommendationSquarePartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, VideoHomeCreatorYouShouldFollow, AnyEnvironment, View> {
    public static final ViewType<View> f3248a = ViewType.a(2130907733);
    public static final CallerContext f3249b = CallerContext.a(VideoHomeGuideAdapter.class, "video_home");
    private static VideoHomeVideoChannelRecommendationSquarePartDefinition f3250f;
    private static final Object f3251g = new Object();
    private final NumberTruncationUtil f3252c;
    private final TextPartDefinition f3253d;
    private final Resources f3254e;

    private static VideoHomeVideoChannelRecommendationSquarePartDefinition m3096b(InjectorLike injectorLike) {
        return new VideoHomeVideoChannelRecommendationSquarePartDefinition(NumberTruncationUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m3098a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        VideoHomeCreatorYouShouldFollowModel db = ((ReactionUnitComponentNode) obj).b.db();
        if (db != null) {
            if (!(db.fp_() == null || db.fp_().a() == null)) {
                subParts.a(2131568437, this.f3253d, db.fp_().a());
            }
            if (db.d() != null) {
                subParts.a(2131568438, this.f3253d, this.f3254e.getString(2131237311, new Object[]{this.f3252c.a(db.d().a())}));
            }
        }
        return db;
    }

    public final /* bridge */ /* synthetic */ void m3099a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2087367370);
        VideoHomeCreatorYouShouldFollowModel videoHomeCreatorYouShouldFollowModel = (VideoHomeCreatorYouShouldFollowModel) obj2;
        if (!(videoHomeCreatorYouShouldFollowModel == null || videoHomeCreatorYouShouldFollowModel.g() == null)) {
            DefaultImageFields b = videoHomeCreatorYouShouldFollowModel.g().b();
            if (!(b == null || b.b() == null)) {
                ((FbDraweeView) FindViewUtil.b(view, 2131568436)).a(Uri.parse(b.b()), f3249b);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -652620660, a);
    }

    @Inject
    public VideoHomeVideoChannelRecommendationSquarePartDefinition(NumberTruncationUtil numberTruncationUtil, Resources resources, TextPartDefinition textPartDefinition) {
        this.f3252c = numberTruncationUtil;
        this.f3254e = resources;
        this.f3253d = textPartDefinition;
    }

    public static VideoHomeVideoChannelRecommendationSquarePartDefinition m3095a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVideoChannelRecommendationSquarePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3251g) {
                VideoHomeVideoChannelRecommendationSquarePartDefinition videoHomeVideoChannelRecommendationSquarePartDefinition;
                if (a2 != null) {
                    videoHomeVideoChannelRecommendationSquarePartDefinition = (VideoHomeVideoChannelRecommendationSquarePartDefinition) a2.a(f3251g);
                } else {
                    videoHomeVideoChannelRecommendationSquarePartDefinition = f3250f;
                }
                if (videoHomeVideoChannelRecommendationSquarePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3096b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3251g, b3);
                        } else {
                            f3250f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVideoChannelRecommendationSquarePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m3100a(Object obj) {
        return true;
    }

    public final ViewType<View> m3097a() {
        return f3248a;
    }
}
