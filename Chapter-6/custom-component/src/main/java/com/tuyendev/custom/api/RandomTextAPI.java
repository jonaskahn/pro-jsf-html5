package com.tuyendev.custom.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Simple API for obtaining random text from an online REST service.
 *
 * @see <a href="http://www.randomtext.me">RandomText</a>
 */
public class RandomTextAPI {

    /**
     * Enumeration containing the type of text to return.
     */
    public enum TextType {

        /** Return gibberish text. */
        gibberish,
        /** Return lorem ipsum text. */
        lorem
    };

    /**
     * Enumeration containing the type of formatting to return.
     */
    public enum OutputTag {

        /** Return the output as paragraphs. */
        p,
        /** Return the output as items in an unordered list. */
        ul
    }

    /**
     * URL to the REST service with five parameters.
     */
    private static final String API_URL = "http://www.randomtext.me/api/%s/%s-%d/%d-%d";

    /**
     * Property in the JSON output that we will extract and return.
     */
    private static final String PROPERTY_CONTAINING_OUTPUT = "text_out";

    /**
     * Google's JSON parser for parsing the result from the service.
     */
    private JsonParser jsonParser = new JsonParser();

    /**
     * Gets a random text from the RandomText.me web service.
     *
     * @param type Type of random text to return, {@link TextType#gibberish} or
     * {@link TextType#lorem}
     * @param output Type of output to produce, {@link OutputTag#p} (paragraph
     * tags) or {@link OutputTag#ul} (a list)
     * @param outputCount Number of outputs to produce (i.e. number of
     * paragraphs or list items)
     * @param wordCountLower Lowest number of words in a single paragraph or
     * list item
     * @param wordCountUpper Highest number of words in a single paragraph or
     * list item
     * @return Random text formatted as {@code type} and {@code output}
     * @throws IOException
     */
    public String getRandomText(TextType type, OutputTag output, int outputCount, int wordCountLower, int wordCountUpper) throws IOException {

        // Generate URL based on method inptu
        String url = String.format(API_URL, type, output, outputCount, wordCountLower, wordCountUpper);

        // Prepare request to the randomtext.me
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        // Process response by reading the content into a StringBuilder
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder apiResult = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            apiResult.append(line);
        }

        // Use the GSON Library to parse the JSON response from randomtext.me
        JsonElement jsonElement = jsonParser.parse(apiResult.toString());
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return jsonObject.get(PROPERTY_CONTAINING_OUTPUT).getAsString();
    }
}
