package com.tuyendev.custom.component;

import com.tuyendev.custom.api.RandomTextAPI;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

// "RandomText" is the Component Type
@FacesComponent(RandomTextComponent.COMPONENT_TYPE)
public class RandomTextComponent extends UIComponentBase {

    /** Component family of {@link RandomTextComponent}. */
    public static final String COMPONENT_FAMILY = "RandomText";

    /** Component type of {@link RandomTextComponent}. */
    public static final String COMPONENT_TYPE = "RandomText";

    /** Attribute name constant for textType. */
    private static final String ATTR_TEXT_TYPE = "textType";

    /** Default value for the textType attribute. */
    private static final String ATTR_TEXT_TYPE_DEFAULT = "lorem";

    /** Attribute name constant for outputTag. */
    private static final String ATTR_OUTPUT_TAG = "outputTag";

    /** Default value for the outputTag attribute. */
    private static final String ATTR_OUTPUT_TAG_DEFAULT = "p";

    /** Attribute name constant for count. */
    private static final String ATTR_COUNT = "count";

    /** Default value for the count attribute. */
    private static final Integer ATTR_COUNT_DEFAULT = 10;

    /** Attribute name constant for minWords. */
    private static final String ATTR_MIN_WORDS = "minWords";

    /** Default value for the minWords attribute. */
    private static final Integer ATTR_MIN_WORDS_DEFAULT = 5;

    /** Attribute name constant for maxWords. */
    private static final String ATTR_MAX_WORDS = "maxWords";

    /** Default value for the maxWords attribute. */
    private static final Integer ATTR_MAX_WORDS_DEFAULT = 10;

    @Override
    public String getFamily() {
        return RandomTextComponent.COMPONENT_FAMILY;
    }

    // LOGIC
    public String getRandomText() throws IOException {
        RandomTextAPI api = new RandomTextAPI();
        return api.getRandomText(
                RandomTextAPI.TextType.valueOf(getTextType()),
                RandomTextAPI.OutputTag.valueOf(getOutputTag()),
                getCount(),
                getMinWords(),
                getMaxWords());
    }

    // ATTRIBUTES
    public String getTextType() {
        return (String) getStateHelper().eval(ATTR_TEXT_TYPE, ATTR_TEXT_TYPE_DEFAULT);
    }

    public void setTextType(String textType) {
        getStateHelper().put(ATTR_TEXT_TYPE, textType);
    }

    public String getOutputTag() {
        return (String) getStateHelper().eval(ATTR_OUTPUT_TAG, ATTR_OUTPUT_TAG_DEFAULT);
    }

    public void setOutputTag(String outputTag) {
        getStateHelper().put(ATTR_OUTPUT_TAG, outputTag);
    }

    public Integer getCount() {
        return (Integer) getStateHelper().eval(ATTR_COUNT, ATTR_COUNT_DEFAULT);
    }

    public void setCount(Integer count) {
        getStateHelper().put(ATTR_COUNT, count);
    }

    public Integer getMinWords() {
        return (Integer) getStateHelper().eval(ATTR_MIN_WORDS, ATTR_MIN_WORDS_DEFAULT);
    }

    public void setMinWords(Integer minWords) {
        getStateHelper().put(ATTR_MIN_WORDS, minWords);
    }

    public Integer getMaxWords() {
        return (Integer) getStateHelper().eval(ATTR_MAX_WORDS, ATTR_MAX_WORDS_DEFAULT);
    }

    public void setMaxWords(Integer maxWords) {
        getStateHelper().put(ATTR_MAX_WORDS, maxWords);
    }
}