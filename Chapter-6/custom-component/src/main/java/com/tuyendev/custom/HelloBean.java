package com.tuyendev.custom;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@SessionScoped
@ManagedBean(name = "example")
public class HelloBean implements Serializable {

    private String  textType    ;
    private String  outputTag   ;
    private Integer count       ;
    private Integer minWords    ;
    private Integer maxWords    ;

    @PostConstruct
    public void init(){
        textType = "gibberish";
        outputTag = "p";
        count = 10;
        minWords = 5;
        maxWords = 10;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    public String getOutputTag() {
        return outputTag;
    }

    public void setOutputTag(String outputTag) {
        this.outputTag = outputTag;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMinWords() {
        return minWords;
    }

    public void setMinWords(Integer minWords) {
        this.minWords = minWords;
    }

    public Integer getMaxWords() {
        return maxWords;
    }

    public void setMaxWords(Integer maxWords) {
        this.maxWords = maxWords;
    }
}
