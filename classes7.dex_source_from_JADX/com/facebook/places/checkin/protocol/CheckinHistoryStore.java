package com.facebook.places.checkin.protocol;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.facebook.places.db.PlacesModelTable;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinHistoryMostRecentQueryModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: inspiration */
public class CheckinHistoryStore {
    private static final Class<?> f11034a = CheckinHistoryStore.class;
    private FbObjectMapper f11035b;
    private PlacesModelTable f11036c;
    private DefaultAndroidThreadUtil f11037d;

    @Inject
    public CheckinHistoryStore(FbObjectMapper fbObjectMapper, PlacesModelTable placesModelTable, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f11035b = fbObjectMapper;
        this.f11036c = placesModelTable;
        this.f11037d = defaultAndroidThreadUtil;
    }

    public final void m13017a(CheckinHistoryMostRecentQueryModel checkinHistoryMostRecentQueryModel) {
        this.f11037d.b();
        Preconditions.checkState(checkinHistoryMostRecentQueryModel != null);
        m13015a(2, (Object) checkinHistoryMostRecentQueryModel);
    }

    public final CheckinHistoryMostRecentQueryModel m13016a() {
        this.f11037d.b();
        return (CheckinHistoryMostRecentQueryModel) m13014a(2, CheckinHistoryMostRecentQueryModel.class);
    }

    private <T> void m13015a(int i, T t) {
        try {
            this.f11036c.m13074a(i, this.f11035b.a(t));
        } catch (JsonProcessingException e) {
            BLog.b(f11034a, "failed to serialize model", e);
        }
    }

    private <T> T m13014a(int i, Class<T> cls) {
        T t = null;
        try {
            String a = this.f11036c.m13073a(i);
            if (a != null) {
                t = this.f11035b.a(a, cls);
            }
        } catch (Throwable e) {
            BLog.b(f11034a, "failed to de-serialize model", e);
        }
        return t;
    }
}
