package com.creditmantri.Sulekha.api;


import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class Sulekha {
    public Integer sulekha(JSONObject data) throws IOException, RuntimeException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://vaasal.creditmantri.in/authenticate");
        get.setHeader("api-version","v1");
        get.setHeader("source", "sample");
        HttpResponse res = httpClient.execute(get);
        Sulekha obj = new Sulekha();
        String authKey = obj.printHeaders (res.getAllHeaders());
    //System.out.println(authKey);

        try {

            URL url = new URL("http://vaasal.creditmantri.in/vendor/leads");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("source","sulekha");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("api-version","v1");
            conn.setRequestProperty("key",authKey);
            conn.setConnectTimeout(50000);
            OutputStream os = conn.getOutputStream();
            os.write(data.toString().getBytes());
            os.flush();

            if (conn.getResponseCode()!=200) {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(
                        (conn.getErrorStream())));
                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br1.readLine()) != null) {
                    System.out.println(output);
                }
                return conn.getResponseCode();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String temp="",output="";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                temp+=output;
            }
            System.out.println(temp);
            conn.disconnect();
            return org.apache.http.HttpStatus.SC_OK;
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
    public String printHeaders(Header[] res) {
        Header[] headers = res;
        String name;
        String authKey = null;
        for (Header header: headers) {
            //System.out.println("Key: "+header.getName());
            name = header.getName();
            if (name.matches("key")) {
                authKey = header.getValue();
                //System.out.println("Value: "+header.getValue());
            }
        }
        return authKey;
    }

}
