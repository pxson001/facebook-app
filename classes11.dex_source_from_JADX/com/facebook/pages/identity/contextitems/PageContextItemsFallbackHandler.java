package com.facebook.pages.identity.contextitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel.ItemLinksModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel.ItemLinksModel.Builder;
import com.facebook.graphql.model.GraphQLEntityCardContextItem;
import com.facebook.graphql.model.GraphQLEntityCardContextItemLink;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: photo_set_grid_source */
public class PageContextItemsFallbackHandler {
    private final Context f3835a;
    private final UriIntentMapper f3836b;
    private final SecureContextHelper f3837c;

    public static PageContextItemsFallbackHandler m4773b(InjectorLike injectorLike) {
        return new PageContextItemsFallbackHandler((Context) injectorLike.getInstance(Context.class), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public PageContextItemsFallbackHandler(Context context, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper) {
        this.f3835a = context;
        this.f3836b = uriIntentMapper;
        this.f3837c = secureContextHelper;
    }

    public final void m4774a(ContextItemFieldsModel contextItemFieldsModel) {
        if (contextItemFieldsModel.c() != null) {
            ImmutableList c = contextItemFieldsModel.c();
            int size = c.size();
            int i = 0;
            while (i < size) {
                if (!m4772a((ItemLinksModel) c.get(i))) {
                    i++;
                } else {
                    return;
                }
            }
        }
        String a = contextItemFieldsModel.a();
        if (a != null) {
            Intent a2 = this.f3836b.a(this.f3835a, a);
            if (a2 == null) {
                a2 = new Intent("android.intent.action.VIEW");
                a2.setData(Uri.parse(a));
                this.f3837c.b(a2, this.f3835a);
            } else if (FacebookUriUtil.a(Uri.parse(a))) {
                this.f3837c.b(a2, this.f3835a);
            } else {
                this.f3837c.a(a2, this.f3835a);
            }
        }
    }

    public final void m4775a(GraphQLEntityCardContextItem graphQLEntityCardContextItem) {
        if (graphQLEntityCardContextItem.k() != null) {
            ImmutableList k = graphQLEntityCardContextItem.k();
            int size = k.size();
            int i = 0;
            while (i < size) {
                GraphQLEntityCardContextItemLink graphQLEntityCardContextItemLink = (GraphQLEntityCardContextItemLink) k.get(i);
                Builder builder = new Builder();
                builder.a = graphQLEntityCardContextItemLink.a();
                builder = builder;
                builder.b = graphQLEntityCardContextItemLink.j();
                builder = builder;
                builder.c = graphQLEntityCardContextItemLink.k();
                if (!m4772a(builder.a())) {
                    i++;
                } else {
                    return;
                }
            }
        }
        String a = graphQLEntityCardContextItem.a();
        if (a != null) {
            Intent a2 = this.f3836b.a(this.f3835a, a);
            if (a2 != null) {
                this.f3837c.a(a2, this.f3835a);
                return;
            }
            a2 = new Intent("android.intent.action.VIEW");
            a2.setData(Uri.parse(a));
            this.f3837c.b(a2, this.f3835a);
        }
    }

    private boolean m4772a(ItemLinksModel itemLinksModel) {
        Intent data;
        if (itemLinksModel.a() != null) {
            ImmutableList a = itemLinksModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                data = new Intent("android.intent.action.VIEW").setData(Uri.parse((String) a.get(i)));
                if (IntentResolver.b(this.f3835a, data)) {
                    this.f3837c.b(data, this.f3835a);
                    return true;
                }
            }
        }
        if (itemLinksModel.b() != null) {
            data = this.f3835a.getPackageManager().getLaunchIntentForPackage(itemLinksModel.b());
            if (data != null) {
                this.f3837c.b(data, this.f3835a);
                return true;
            }
        }
        return false;
    }
}
