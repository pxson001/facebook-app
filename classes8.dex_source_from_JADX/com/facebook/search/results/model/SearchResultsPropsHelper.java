package com.facebook.search.results.model;

import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;

/* compiled from: RichDocumentPerfInfoLogger#recordTTI */
public class SearchResultsPropsHelper {
    public static boolean m27109b(SearchResultsProps<?> searchResultsProps) {
        NodeModel a;
        ModuleResultsModel moduleResultsModel = null;
        SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        if (searchResultsEdgeModel != null) {
            a = searchResultsEdgeModel.m9770a();
        } else {
            a = null;
        }
        if (a != null) {
            moduleResultsModel = a.m9731S();
        }
        return (moduleResultsModel == null || moduleResultsModel.m9710a().isEmpty()) ? false : true;
    }
}
