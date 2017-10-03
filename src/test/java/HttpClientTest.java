import com.google.gson.Gson;
import entity.Gist;
import entity.GistFile;
import entity.GistFilePack;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.testng.Assert.assertEquals;

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
    private Gson gson;
    private Gist gist;

    @BeforeTest
    public void setup() throws IOException {
        httpResponse = null;
        String description = "Brand new description!";
        String content = "Brand new content!";
        gist = new Gist();
        gist.setDescription(description);
        gist.setA(true);
        gist.setFiles(new GistFilePack());
        gist.getFiles().setFile(new GistFile());
        gist.getFiles().getFile().setContent(content);
        gson = new Gson();
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void loginTest() throws IOException {
        httpGet = new HttpGet("https://api.github.com/user");
        httpGet.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpGet);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void createGistTest() throws IOException, UnsupportedEncodingException {
        httpPost = new HttpPost("https://api.github.com/gists");
        StringEntity entityString = null;

        entityString = new StringEntity(gson.toJson(gist));
        httpPost.setEntity(entityString);
        httpPost.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpPost);
        gist.setParameters(httpResponse);
        System.out.println(gist.getId());
        assertEquals(httpResponse.getStatusLine().getStatusCode(), 201);
    }
}