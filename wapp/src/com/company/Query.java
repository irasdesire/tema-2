package com.company;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Query {
    public int id;
    public String name = "", countryCode;
    public float lat, lon;
    Query(String[] params) throws UnsupportedEncodingException {
        id = Integer.parseInt(params[0]);
        for (int i = 1; i <= params.length - 4; i++)
            name += params[i] + " ";
        name = name.replaceFirst(".$","");
        name = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
        lat = Float.parseFloat(params[params.length - 3]);
        lon = Float.parseFloat(params[params.length - 2]);
        countryCode = params[params.length - 1];
    }
}
