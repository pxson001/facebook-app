package com.facebook.redspace.debug;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ListAdapter;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStoreDebugHelper;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcherDebugHelper;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.ImmutableBiMap.Builder;
import java.util.Map;

@ContextScoped
/* compiled from: Place Search / Local */
public class RedSpaceFriendsDebugWriter {
    private static RedSpaceFriendsDebugWriter f11919d;
    private static final Object f11920e = new Object();
    private final ObjectWriter f11921a;
    @Inject
    public RedSpaceOptimisticBadgeStoreDebugHelper f11922b;
    @Inject
    public RedSpaceTabUnseenCountFetcherDebugHelper f11923c;

    /* compiled from: Place Search / Local */
    public interface FriendSectionDeterminator {
        RedSpaceFriendsSection mo339a(int i);
    }

    private static RedSpaceFriendsDebugWriter m12363b(InjectorLike injectorLike) {
        RedSpaceFriendsDebugWriter redSpaceFriendsDebugWriter = new RedSpaceFriendsDebugWriter((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
        RedSpaceTabUnseenCountFetcherDebugHelper a = RedSpaceTabUnseenCountFetcherDebugHelper.a(injectorLike);
        redSpaceFriendsDebugWriter.f11922b = RedSpaceOptimisticBadgeStoreDebugHelper.a(injectorLike);
        redSpaceFriendsDebugWriter.f11923c = a;
        return redSpaceFriendsDebugWriter;
    }

    @Inject
    private RedSpaceFriendsDebugWriter(ObjectMapper objectMapper) {
        this.f11921a = objectMapper.g().a();
    }

    public final Map<String, String> m12365a(int i, int i2, ListAdapter listAdapter, @Nullable RedSpaceFriendsCollection redSpaceFriendsCollection, @Nullable RedSpaceFriendsCollection redSpaceFriendsCollection2, FriendSectionDeterminator friendSectionDeterminator, RedSpaceOptimisticBadgeStore redSpaceOptimisticBadgeStore, RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher) {
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 && i <= i2 && i < listAdapter.getCount()) {
            Object item = listAdapter.getItem(i);
            if (item instanceof RedSpaceFeedProfileFragmentModel) {
                stringBuilder.append("\nSection: ");
                stringBuilder.append(friendSectionDeterminator.mo339a(i).isTop() ? "TOP" : "OTHERS");
                stringBuilder.append("\nFriend: ");
                stringBuilder.append(m12364a((RedSpaceFeedProfileFragmentModel) item));
            } else if (item != null) {
                stringBuilder.append("\n");
                stringBuilder.append(item.getClass().getName());
                stringBuilder.append(":\n");
                try {
                    stringBuilder.append(this.f11921a.a(item));
                } catch (JsonProcessingException e) {
                    stringBuilder.append("Exception:");
                    stringBuilder.append(e.toString());
                }
            }
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (redSpaceFriendsCollection != null) {
            stringBuilder2.append("\nTOP:\n");
            m12362a(stringBuilder2, redSpaceFriendsCollection);
        }
        if (redSpaceFriendsCollection2 != null) {
            stringBuilder2.append("\nOTHERS:\n");
            m12362a(stringBuilder2, redSpaceFriendsCollection2);
        }
        return new Builder().a("VisibleFriends", stringBuilder.toString()).a("FriendsDataStore", stringBuilder2.toString()).a("OptimisticBadgeStore", RedSpaceOptimisticBadgeStoreDebugHelper.a(redSpaceOptimisticBadgeStore)).a("BadgeFetcher", this.f11923c.a(redSpaceTabUnseenCountFetcher)).b();
    }

    public static RedSpaceFriendsDebugWriter m12361a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceFriendsDebugWriter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11920e) {
                RedSpaceFriendsDebugWriter redSpaceFriendsDebugWriter;
                if (a2 != null) {
                    redSpaceFriendsDebugWriter = (RedSpaceFriendsDebugWriter) a2.a(f11920e);
                } else {
                    redSpaceFriendsDebugWriter = f11919d;
                }
                if (redSpaceFriendsDebugWriter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12363b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11920e, b3);
                        } else {
                            f11919d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceFriendsDebugWriter;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final String m12364a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        StringBuilder stringBuilder = new StringBuilder();
        if (redSpaceFeedProfileFragmentModel.n() != null) {
            stringBuilder.append(redSpaceFeedProfileFragmentModel.n().s_());
        }
        stringBuilder.append("\nGraphQL response:\n");
        try {
            stringBuilder.append(this.f11921a.a(redSpaceFeedProfileFragmentModel));
        } catch (JsonProcessingException e) {
            stringBuilder.append("ID: ").append(redSpaceFeedProfileFragmentModel.k());
        }
        return stringBuilder.toString();
    }

    private void m12362a(StringBuilder stringBuilder, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        for (int i = 0; i < redSpaceFriendsCollection.m12222d(); i++) {
            stringBuilder.append(redSpaceFriendsCollection.m12213a(i).k());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\nPageInfo:\n");
        try {
            stringBuilder.append(this.f11921a.a(redSpaceFriendsCollection.m12221c()));
        } catch (JsonProcessingException e) {
            stringBuilder.append("\nNextPage: ").append(redSpaceFriendsCollection.m12218a());
        }
    }
}
