package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.GraphRequest.Callback;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: event_buy_tickets_continue_button_tapped */
public final class AccessTokenManager {
    private static volatile AccessTokenManager f13736a;
    public final LocalBroadcastManager f13737b;
    private final AccessTokenCache f13738c;
    public AccessToken f13739d;
    public AtomicBoolean f13740e = new AtomicBoolean(false);
    public Date f13741f = new Date(0);

    /* compiled from: event_buy_tickets_continue_button_tapped */
    class RefreshResult {
        public String f13734a;
        public int f13735b;
    }

    private AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache) {
        Validate.m25366a((Object) localBroadcastManager, "localBroadcastManager");
        Validate.m25366a((Object) accessTokenCache, "accessTokenCache");
        this.f13737b = localBroadcastManager;
        this.f13738c = accessTokenCache;
    }

    public static AccessTokenManager m14028a() {
        if (f13736a == null) {
            synchronized (AccessTokenManager.class) {
                if (f13736a == null) {
                    f13736a = new AccessTokenManager(LocalBroadcastManager.a(FacebookSdk.m14051f()), new AccessTokenCache());
                }
            }
        }
        return f13736a;
    }

    final AccessToken m14034b() {
        return this.f13739d;
    }

    final boolean m14035c() {
        AccessToken a = this.f13738c.m14020a();
        if (a == null) {
            return false;
        }
        m14030a(a, false);
        return true;
    }

    public final void m14033a(AccessToken accessToken) {
        m14030a(accessToken, true);
    }

    private void m14030a(AccessToken accessToken, boolean z) {
        Object obj = this.f13739d;
        this.f13739d = accessToken;
        this.f13740e.set(false);
        this.f13741f = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.f13738c.m14021a(accessToken);
            } else {
                this.f13738c.m14022b();
                Utility.m25351b(FacebookSdk.m14051f());
            }
        }
        if (!Utility.m25344a(obj, (Object) accessToken)) {
            Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", obj);
            intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken);
            this.f13737b.a(intent);
        }
    }

    final void m14036d() {
        Object obj = null;
        if (this.f13739d != null) {
            Long valueOf = Long.valueOf(new Date().getTime());
            if (this.f13739d.f13712i.canExtendToken() && valueOf.longValue() - this.f13741f.getTime() > 3600000 && valueOf.longValue() - this.f13739d.f13713j.getTime() > 86400000) {
                obj = 1;
            }
        }
        if (obj != null) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                m14032b(this, null);
            } else {
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new Runnable(this, null) {
                    final /* synthetic */ AccessTokenManager f13720b;

                    public void run() {
                        AccessTokenManager.m14032b(this.f13720b, null);
                    }
                }, -2081475458);
            }
        }
    }

    private static GraphRequest m14029a(AccessToken accessToken, Callback callback) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest m14031b(AccessToken accessToken, Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, HttpMethod.GET, callback);
    }

    public static void m14032b(AccessTokenManager accessTokenManager, AccessTokenRefreshCallback accessTokenRefreshCallback) {
        final AccessToken accessToken = accessTokenManager.f13739d;
        FacebookException facebookException;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                facebookException = new FacebookException("No current access token to refresh");
            }
        } else if (accessTokenManager.f13740e.compareAndSet(false, true)) {
            accessTokenManager.f13741f = new Date();
            final Set hashSet = new HashSet();
            final Set hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(m14029a(accessToken, new Callback(accessTokenManager) {
                final /* synthetic */ AccessTokenManager f13724d;

                public final void mo693a(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.f13825b;
                    if (jSONObject != null) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray != null) {
                            atomicBoolean.set(true);
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("permission");
                                    String optString2 = optJSONObject.optString("status");
                                    if (!(Utility.m25345a(optString) || Utility.m25345a(optString2))) {
                                        optString2 = optString2.toLowerCase(Locale.US);
                                        if (optString2.equals("granted")) {
                                            hashSet.add(optString);
                                        } else if (optString2.equals("declined")) {
                                            hashSet2.add(optString);
                                        } else {
                                            Log.w("AccessTokenManager", "Unexpected status: " + optString2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }), m14031b(accessToken, new Callback(accessTokenManager) {
                final /* synthetic */ AccessTokenManager f13726b;

                public final void mo693a(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.f13825b;
                    if (jSONObject != null) {
                        refreshResult.f13734a = jSONObject.optString("access_token");
                        refreshResult.f13735b = jSONObject.optInt("expires_at");
                    }
                }
            }));
            final AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
            C18674 c18674 = new GraphRequestBatch.Callback(accessTokenManager) {
                final /* synthetic */ AccessTokenManager f13733g;

                public final void mo694a() {
                    try {
                        FacebookException facebookException;
                        if (AccessTokenManager.m14028a().m14034b() == null || AccessTokenManager.m14028a().m14034b().m14014i() != accessToken.m14014i()) {
                            if (accessTokenRefreshCallback2 != null) {
                                facebookException = new FacebookException("No current access token to refresh");
                            }
                            this.f13733g.f13740e.set(false);
                        } else if (!atomicBoolean.get() && refreshResult.f13734a == null && refreshResult.f13735b == 0) {
                            if (accessTokenRefreshCallback2 != null) {
                                facebookException = new FacebookException("Failed to refresh access token");
                            }
                            this.f13733g.f13740e.set(false);
                        } else {
                            String str;
                            Collection collection;
                            Collection collection2;
                            Date date;
                            if (refreshResult.f13734a != null) {
                                str = refreshResult.f13734a;
                            } else {
                                str = accessToken.m14008b();
                            }
                            String h = accessToken.m14013h();
                            String i = accessToken.m14014i();
                            if (atomicBoolean.get()) {
                                collection = hashSet;
                            } else {
                                collection = accessToken.m14010d();
                            }
                            if (atomicBoolean.get()) {
                                collection2 = hashSet2;
                            } else {
                                collection2 = accessToken.m14011e();
                            }
                            AccessTokenSource f = accessToken.m14012f();
                            if (refreshResult.f13735b != 0) {
                                date = new Date(((long) refreshResult.f13735b) * 1000);
                            } else {
                                date = accessToken.m14009c();
                            }
                            AccessTokenManager.m14028a().m14033a(new AccessToken(str, h, i, collection, collection2, f, date, new Date()));
                            this.f13733g.f13740e.set(false);
                            if (accessTokenRefreshCallback2 == null) {
                            }
                        }
                    } catch (Throwable th) {
                        this.f13733g.f13740e.set(false);
                    }
                }
            };
            if (!graphRequestBatch.f13822f.contains(c18674)) {
                graphRequestBatch.f13822f.add(c18674);
            }
            GraphRequestAsyncTask b = GraphRequest.m14088b(graphRequestBatch);
        } else if (accessTokenRefreshCallback != null) {
            facebookException = new FacebookException("Refresh already in progress");
        }
    }
}
