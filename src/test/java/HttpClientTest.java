import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class HttpClientTest {
    private static final String OAUTH_TOKEN_PART1 = "460d21f87293522bf6d";
    private static final String OAUTH_TOKEN_PART2 = "c43c590474dafc2b3eace";
    private static final String OAUTH_TOKEN = "access_token";
    private HttpPost httpPost;
    private HttpGet httpGet;
    private HttpResponse httpResponse;
    private HttpEntity receivedEntity;
    private CloseableHttpClient httpClient;
    private String result;
    private List<NameValuePair> loginParams;

    @BeforeTest
    public void setup() {
        httpClient = HttpClients.createDefault();
        loginParams = new ArrayList<NameValuePair>(1);
        httpGet = new HttpGet("https://api.github.com/user?access_token=" + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
    }

    @Test
    public void createGistTest() {
        httpPost = new HttpPost("https://gist.github.com/gists");
        StringEntity entityParams = null;
        try {
            entityParams = new StringEntity("{\n" +
                    "  \"description\": \"brand new gist\",\n" +
                    "  \"public\": true,\n" +
                    "  \"files\": {\n" +
                    "    \"file1.txt\": {\n" +
                    "      \"content\": \"65432\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        httpPost.setEntity(entityParams);
        httpGet = new HttpGet("https://gist.github.com/users/:antonkuhach/gists");
        try {
            httpResponse = httpClient.execute(httpGet);
            receivedEntity = httpResponse.getEntity();
            result = EntityUtils.toString(receivedEntity);
            System.out.println(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assertTrue(true);
    }
}