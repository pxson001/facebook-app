package com.facebook.messaging.sharedimage.gqlrequest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQuery.SubsequentPhotosQueryString;
import javax.inject.Inject;

/* compiled from: confirm_phone_code */
public class SharedMediaHistoryRequestFactory {
    public final Context f17345a;
    public int f17346b;
    public Point f17347c;

    public static SharedMediaHistoryRequestFactory m17194b(InjectorLike injectorLike) {
        return new SharedMediaHistoryRequestFactory((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public SharedMediaHistoryRequestFactory(Context context) {
        this.f17345a = context;
    }

    public final GraphQLRequest m17195a(ThreadKey threadKey, String str) {
        Resources resources = this.f17345a.getResources();
        this.f17346b = resources.getDimensionPixelSize(2131428549);
        resources.getDisplayMetrics();
        this.f17347c = new Point();
        Context context = this.f17345a;
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(this.f17347c);
        GraphQlQueryString subsequentPhotosQueryString = new SubsequentPhotosQueryString();
        subsequentPhotosQueryString.a("thread_id", String.valueOf(threadKey.i())).a("fetch_size", "100").a("width", String.valueOf(this.f17347c.x)).a("height", String.valueOf(this.f17347c.y)).a("thumbnail_size", String.valueOf(this.f17346b));
        if (!str.equals("")) {
            subsequentPhotosQueryString.a("photo_fbid", str);
        }
        return GraphQLRequest.a(subsequentPhotosQueryString).a(GraphQLCachePolicy.a).a(90);
    }
}
