package com.example.pangxiezi.single.model;


import com.example.pangxiezi.single.model.impl.PageModelIpml;

/**
 * Created by pangxiezi on 2016/3/15.
 */
public class ModelFactory {

    public ModelFactory() {
    }

    public static  ModelFactory newInstance(){
        ModelFactory factory = new ModelFactory();
        return factory;
    }

    public PageModelIpml getHomepageModelImpl(){return new PageModelIpml();}


}
