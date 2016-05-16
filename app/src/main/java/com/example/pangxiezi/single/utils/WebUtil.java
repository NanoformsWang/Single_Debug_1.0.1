package com.example.pangxiezi.single.utils;

import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by pangxiezi on 2016/3/17.
 */
public class WebUtil {
    public static void setWebView(WebView webView,String data){
    webView.loadDataWithBaseURL("about:blank",getNewContent(data), "text/html","UTF-8",null);}

    private static  String getNewContent(String htmltext){

        Document doc= Jsoup.parse(htmltext);
        Elements elements=doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width","100%").attr("height","auto");
        }
        return doc.toString();
    }
}
