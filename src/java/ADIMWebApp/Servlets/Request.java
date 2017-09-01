/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADIMWebApp.Servlets;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdImage;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.IDName;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.sdk.TargetingGeoLocationCity;
import com.facebook.ads.sdk.TargetingGeoLocationRegion;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.facebook.ads.sdk.*;
import com.facebook.ads.sdk.AdAccount.APIRequestGetReachEstimate;
import com.facebook.ads.sdk.AdAccount.APIRequestGetReachFrequencyPredictions;
import com.facebook.ads.sdk.AdAccount.APIRequestGetRoas;
import com.facebook.ads.sdk.AdAccount.APIRequestGetTargetingBrowse;
import com.facebook.ads.sdk.AdAccount.APIRequestGetTargetingSearch;
import com.facebook.ads.sdk.AdAccount.APIRequestGetTargetingSentenceLines;
import com.facebook.ads.sdk.AdAccount.APIRequestGetTargetingSuggestions;
import com.facebook.ads.sdk.AdAccount.APIRequestGetUsers;
import com.facebook.ads.sdk.AdSet.APIRequestGetInsights;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Morales
 */
public class Request extends HttpServlet {
    /*
    public static final String ACCESS_TOKEN = "EAACEdEose0cBAMksAEd3n0AK3m8RcxZAzsrJ9GGC52GSCM3jBZBeinToNYAZCWmLKkCrg4ybCAxFAVb5WlGk97iRd6HGtSImSjOdSBPbuoah7YO0ZBN6vALe4S6qmP4gy8GGefI4NTgwlVvfgGozncUiXzYHtFixDQHPtORCqIM3NMYbQ5qXSkbpNnhXoEYZD";
    public static final Long ACCOUNT_ID = 1347230443L;
    public static final String APP_ID = "804111959747160";
    public static final String APP_SECRET = "2a0583a8a750e8076cc4f8f639547f67";
    
    
    */

//public  APIContext context;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        String rad = request.getParameter("radius");
        String minA = request.getParameter("minAge");
        String maxA = request.getParameter("maxAge");
        String gender = request.getParameter("gender");
        String interests = request.getParameter("interests");
        
        //aqui poner try-catch para conversiones
        
        PrintWriter out = response.getWriter();
        
        try {
            double latitude = Double.parseDouble(lat);
            double longitude = Double.parseDouble(lon);
            double radius = Double.parseDouble(rad);
            //int minAge = Integer.parseInt(minA);
            //int maxAge = Integer.parseInt(maxA);
        
    String access_token = "EAALbVee4algBAFsy1ZAEquOdOYaEShaAHjoX0xWTknNn985LhGW8IuvaZBxNE4gadDB1aN7ZBgW1EF4EV101KqiNe7LLKKpR4BquxFSLNGZB5Pa8XZAZBs7F2fKudn8tbtrZCZAhZANATbuHLrlDpIUyxKcdp23NZAsOOnUmCkfgPLgJfzQzXm2usO6CLdZCMjEqZBFqwAZCXZC1Go2PBAHkhl5kRa";
    String ad_account_id = "104947386807838";
    String app_secret = "2a0583a8a750e8076cc4f8f639547f67";
    String page_id = "233535683825159";
    APIContext context = new APIContext(access_token).enableDebug(true);

    String todo = "";
    
    Campaign campaign = new AdAccount(ad_account_id, context).createCampaign()
      .setName("My Campaign")
      .setBuyingType("AUCTION")
      .setObjective(Campaign.EnumObjective.VALUE_PAGE_LIKES)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .execute();
    String campaign_id = campaign.getId();
    
    todo = todo+ "campaign = " + campaign_id +"\n";
     todo = todo + "campaign raw = " + campaign.fetch().getRawValue()+ "\n";
    todo = todo + "campaign raw = " + campaign.getRawResponse() + "\n";
   
    //todo = todo+"algo (targeting) id = " + algo.getId() +"\n";
    //todo = todo+"algo (targeting) raw = " + algo.getRawResponse() +"\n";
    
    AdSet adSet = new AdAccount(ad_account_id, context).createAdSet()
        .setName("My AdSet")
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_PAGE_LIKES)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setBidAmount(20L)
        .setPromotedObject("{\"page_id\": " + page_id + "}")
        .setDailyBudget(1000L)
        .setCampaignId(campaign_id)
        .setTargeting(new Targeting()
            .setFieldUserOs(Arrays.asList("Android", "iOS"))
            .setFieldFlexibleSpec(Arrays.asList(
                new FlexibleTargeting()
                    .setFieldBehaviors(Arrays.asList(
                      new IDName()
                        .setFieldId("6002714895372")
                        .setFieldName("All travelers")
                    ))
            ))
            .setFieldGenders(Arrays.asList(1L))
            .setFieldAgeMin(Long.parseLong(minA))
            .setFieldAgeMax(Long.parseLong(maxA))
            .setFieldLocales(Arrays.asList(23L))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCustomLocations(Arrays.asList( 
                    new TargetingGeoLocationCustomLocation()
                        .setFieldDistanceUnit("kilometer")
                        .setFieldLatitude(latitude)
                        .setFieldLongitude(longitude)
                        .setFieldRadius((double) 1)
                ))
                .setFieldLocationTypes(Arrays.asList("recent"))
            ))
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        
        .execute();
    
    /*List<TargetingProductAudienceSpec> f = adSet.getFieldTargeting().getFieldProductAudienceSpecs();
            
    String result = "";
    for(TargetingProductAudienceSpec aud: f){
        result = result + aud.getRawResponse() + "\n";
    }*/
    
    Targeting tar = new Targeting()
            //.setFieldUserOs(Arrays.asList("Android", "iOS", "Windows"))
            /*.setFieldFlexibleSpec(Arrays.asList(
                new FlexibleTargeting()
                    .setFieldBehaviors(Arrays.asList(
                      new IDName()
                        .setFieldId("6002714895372")
                        .setFieldName("All travelers")
                    ))
            ))*/
            .setFieldGenders(Arrays.asList(1L))
            //.setFieldAgeMin(Long.parseLong(minA))
            //.setFieldAgeMax(Long.parseLong(maxA))
            .setFieldAgeMin(18L)
            .setFieldAgeMax(65L)
            //.setFieldLocales(Arrays.asList(23L))
            .setFieldGeoLocations(
              new TargetingGeoLocation()    
                .setFieldCustomLocations(Arrays.asList( 
                    new TargetingGeoLocationCustomLocation()
                        .setFieldDistanceUnit("kilometer")
                        .setFieldLatitude((double) 28.7048)
                        .setFieldLongitude((double) -106.1262)
                        .setFieldRadius((double) 1)
                ))
                //.setFieldLocationTypes(Arrays.asList("recent"))
            );    
    //APIRequestGetTargetingBrowse d = new AdAccount(ad_account_id, context).getTargetingBrowse().requestAllFields().execute().getRawResponse();
    
    APIRequestGetReachEstimate n = new AdAccount(ad_account_id, context).getReachEstimate().setTargetingSpec(tar);
    APIRequestGetReachFrequencyPredictions b = new AdAccount(ad_account_id, context).getReachFrequencyPredictions().requestExternalMinimumReachField();
    APIRequestGetTargetingSentenceLines o = new AdAccount(ad_account_id, context).getTargetingSentenceLines().setTargetingSpec(tar);
    //APIRequestGetRoas c = new AdAccount(ad_account_id, context).getRoas().
    //APIRequestGetTargetingSearch e = new AdAccount(ad_account_id, context).getTargetingSearch() este puede ser util
    //APIRequestGetTargetingSuggestions f = new AdAccount(ad_account_id, context).getTargetingSuggestions().
    //APIRequestGetUsers g = new AdAccount(ad_account_id, context).getUsers().se
//String size = "d = " + d+"\n";
    ArrayList array = new ArrayList();
    array.add(n);
    array.add(b);
    array.add(o);
    int counter = 0;
    String datos = "";
    for(Object obj:array){
        if(obj==null){
            datos = datos + " "+counter+" es nulo"; 
        }
        counter++;   
    }
    /*aqui descomentar
    datos = datos + " n reachestimate = " + n.execute().getRawResponse()+"\n";
    datos = datos + " n FrequencyPredictions = " + b.execute().getRawResponse()+"\n";
    datos = datos + " n SentenceLines = " +  o.execute().getRawResponse() +"\n";*/
    //String size = "n reachestimate = " + n.requestAllFields().g+"\n";
    
    
    
    String ad_set_id = adSet.getId();
    adSet.fetch();
    
    todo = todo+"adset fetch = " + adSet.getFieldRfPredictionId()+"\n";
    
    todo = todo+"adset insights = " + adSet.getInsights().toString()+"\n";
    todo = todo+"adset activities = " + adSet.getActivities().toString()+"\n";
    todo = todo+"adset to string = " + adSet.toString()+"\n";
    //todo = todo+"adset getFieldAttributionSpec is empty = " + adSet.getFieldAttributionSpec().isEmpty()+"\n";
    todo = todo+"adset = " + ad_set_id +"\n";
    todo = todo+"adset freccap = " + adSet.getFieldFrequencyCap() +"\n";
    todo = todo+"adset ltbudget = " + adSet.getFieldLifetimeBudget()+"\n";
    //todo = todo+"adset targeting engage specs = " + adSet.getFieldTargeting().getFieldEngagementSpecs().toString()+"\n";
    adSet.getFieldTargeting();
    
    
    out.println("<!DOCTYPE html>");
            out.println("<html>antes error</html>");
    
    //todo = todo+"specs de targeting = " + adSet.getFieldTargeting().getFieldProductAudienceSpecs().toString() +"\n";
    
    out.println("<!DOCTYPE html>");
            out.println("<html>despues error</html>");
            
    todo = todo+"adset otros = " + adSet.get().toString() +"\n";
    todo = todo +"adset raw = " + adSet.getRawResponse() + "\n";
    
    
    AdCreative creative = new AdAccount(ad_account_id, context).createAdCreative()
      .setName("My Creative")
      .setObjectId(page_id)
      .setTitle("My Page Like Ad")
      .setBody("Like My Page")
      .setImageUrl("http://www.facebookmarketingdevelopers.com/static/images/resource_1.jpg")
      .execute();
    String creative_id = creative.getId();
    
    
    todo = todo + creative.fetch().getRawValue() +"\n";
    //todo = todo + creative.get +"\n";
    
    
    todo = todo + "creative raw = " + creative.getRawValue() +"\n";
    
    Ad ad = new AdAccount(ad_account_id, context).createAd()
      .setName("My Ad")
      .setAdsetId(ad_set_id)
      .setCreative(
          new AdCreative()
            .setFieldId(creative_id)
        )
      .setStatus(Ad.EnumStatus.VALUE_ACTIVE)
      .execute();
    String ad_id = ad.getId();
    APINodeList<AdPreview> adsecond = new Ad(ad_id, context).getPreviews()
      .setAdFormat(AdPreview.EnumAdFormat.VALUE_DESKTOP_FEED_STANDARD)
      .execute();
            
            
    

            
            todo = todo+" ad fetch = " + ad.fetch().getRawResponse() + "\n";
            todo = todo +" adsecond raw = "+ adsecond.getRawResponse() + "\n";
            
            
            //JsonObject n = adsecond.getRawResponseAsJsonObject();
            //String body = n.get("body").getAsString();
            /*
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.exec(""
                +   "import sys\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/facebook-python-ads-sdk-master')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/facebook-python-ads-sdk-master/facebookads')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/facebook-python-ads-sdk-master/facebookads/adobjects')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/requests-2.18.3')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/urllib3-1.22')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/chardet-3.0.4')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/certifi-2017.7.27.1')\n" +
                    "sys.path.append('/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/idna-2.5')\n" +
                    "sys.path.insert(0, '/Users/Morales/Documents/Escuela/Verano2017/SSP/ADIM/RawCode/six-1.10.0')\n" +
                    "from facebookads.adobjects.targetingsearch import TargetingSearch\n" +
                    "from facebookads.api import FacebookAdsApi\n" +
                    "from facebookads.session import FacebookSession\n" +
                    "access_token = 'EAABhPRFt6noBAHfUA4kZADTY57ZABvdo6mhL0WjA3P1HZBC7mkflpKql0DZB3iNnm1QgVnf2gXIZAd6z8c3yXJMOGLpTLjrKffYdBhVADZB6sr2LOIhPjNPANLjZAKwS9BkTy75FPbt6Ou3ZCfqv1f1ZBFKkvrALj70v79MjKjNQ2YbUUx4u1nIsLaAwwQ9ig80zbcFK9TMQmp7D09qtUEHp3'\n" +
                    "ad_account_id = 'act_103127100394312'\n" +
                    "app_secret = '8a526b7b78a77832fa4ebc8ced0ca5d4'\n" +
                    "page_id = '233535683825159'\n" +
                    "app_id = '106914913315450'\n" +
                    "proxies = {'http': '<HTTP_PROXY>', 'https': '<HTTPS_PROXY>'} # add proxies if needed\n" +
                    "session = FacebookSession(\n" +
                    "    app_id,\n" +
                    "    app_secret,\n" +
                    "    access_token,\n" +
                    "    proxies,\n" +
                    ")\n" +
                    "api = FacebookAdsApi(session)\n" +
                    "def hello():\n" +
                    "    params = {\n" +
                    "        'q': 'baseball',\n" +
                    "        'type': 'adinterest',\n" +
                    "        'age_min':25,\n" +
                    "        'age_max':40,\n" +
                    "    }\n" +
                    "    \n" +
                    "    resp = TargetingSearch.search(params=params, api=api)\n" +
                    "    return str(resp)");

            
            PyObject someFunc = interpreter.get("hello");
            PyObject result = someFunc.__call__();
            String realResult = (String) result.__tojava__(String.class);
            */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<h1>"+datos+"</h1>");
            
            //out.println("<h1>"+ad_set_id+"</h1>");
            
            out.println("</html>");
            //ServletContext servletContext = request.getServletContext();
            //String rootPath = getRootPath(servletContext);
            
            
            /* el bueno
            String url = "https://graph.facebook.com/v2.10/search?access_token=EAABhPRFt6noBAHfUA4kZADTY57ZABvdo6mhL0WjA3P1HZBC7mkflpKql0DZB3iNnm1QgVnf2gXIZAd6z8c3yXJMOGLpTLjrKffYdBhVADZB6sr2LOIhPjNPANLjZAKwS9BkTy75FPbt6Ou3ZCfqv1f1ZBFKkvrALj70v79MjKjNQ2YbUUx4u1nIsLaAwwQ9ig80zbcFK9TMQmp7D09qtUEHp3&type=adTargetingCategory&class=interests";

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet req = new HttpGet(url);
            // add request header
            req.addHeader("User-Agent", "Mozilla/5.0");
            HttpResponse resp = client.execute(req);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<h1>"+"Response Code : "+ resp.getStatusLine().getStatusCode()+"</h1>");

            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                    result.append(line);
            }
            out.println("<h1>"+result.toString()+"</h1>");
            
            
            out.println("</html>");*/
                   
        }catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<h1>error: "+e.toString() +"</h1>");
            /*out.println("<script>");
            out.println("setInterval(frame, 5 * 1000);\n" +
                        "    function frame() {");
            out.println("window.location.href='Progress.jsp';}");   
            out.println("</script>");*/
            out.println("</html>");
            
          }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
