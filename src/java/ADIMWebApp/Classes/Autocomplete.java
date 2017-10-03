/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADIMWebApp.Classes;

import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.APIRequestGetTargetingSearch;
import com.facebook.ads.sdk.AdAccountTargetingUnified;
import com.google.gson.JsonObject;
import facebook4j.internal.org.json.JSONObject;



/**
 *
 * @author Morales
 */
public class Autocomplete {
    
    private String query;

    public JsonObject Autocomplete(String query, AdAccount fb_account) throws APIException {
        this.query = query;
        APIRequestGetTargetingSearch search = fb_account.getTargetingSearch().setQ(query).setParam("locale", 23);
        APINodeList<AdAccountTargetingUnified> results = search.execute();
        return results.getRawResponseAsJsonObject();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
