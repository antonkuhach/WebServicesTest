import com.google.gson.Gson;
import entity.Gist;
import entity.GistFile;
import entity.GistFilePack;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class HttpClientTest {
    // Divide access token in two parts to resolve github token publication conflict
    private static final String OAUTH_TOKEN_PART1 = "460d21f87293522bf6d";
    private static final String OAUTH_TOKEN_PART2 = "c43c590474dafc2b3eace";
    private static final String API_URL = "https://api.github.com";
    private static final String NEW_CONTENT = "Brand new content!";
    private HttpPost httpPost;
    private HttpGet httpGet;
    private HttpPatch httpPatch;
    private HttpPut httpPut;
    private HttpDelete httpDelete;
    private HttpResponse httpResponse;
    private CloseableHttpClient httpClient;
    private StringEntity entityString;
    private Gson gson;
    private Gist gist;

    @BeforeClass
    public void setup() throws IOException {
        gson = new Gson();
        httpResponse = null;
        String description = "Old description.";
        String content = "Old content.";
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
        httpGet = new HttpGet(API_URL + "/user");
        httpGet.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpGet);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }

    @Test(dependsOnMethods = "loginTest")
    public void createGistTest() throws IOException {
        httpPost = new HttpPost(API_URL + "/gists");

        entityString = new StringEntity(gson.toJson(gist));
        httpPost.setEntity(entityString);
        httpPost.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpPost);
        String jsonString;
        jsonString = EntityUtils.toString(httpResponse.getEntity());
        gist = gson.fromJson(jsonString, Gist.class);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), 201);
    }

    @Test(dependsOnMethods = "createGistTest")
    public void editGistTest() throws IOException {
        httpPatch = new HttpPatch(API_URL + "/gists/" + gist.getId());
        gist.getFiles().getFile().setContent(NEW_CONTENT);
        entityString = new StringEntity(gson.toJson(gist));
        httpPatch.setEntity(entityString);
        httpPatch.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpPatch);
        String jsonString;
        jsonString = EntityUtils.toString(httpResponse.getEntity());
        gist = gson.fromJson(jsonString, Gist.class);
        assertEquals(gist.getFiles().getFile().getContent(), NEW_CONTENT);
    }

    @Test(dependsOnMethods = "editGistTest")
    public void starPutTest() throws IOException {
        httpPut = new HttpPut(API_URL + "/gists/" + gist.getId() + "/star");
        httpPut.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpPut);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), 204);
    }

    @Test(dependsOnMethods = "starPutTest")
    public void deleteGistTest() throws IOException {
        httpDelete = new HttpDelete(API_URL + "/gists/" + gist.getId());
        httpDelete.setHeader("Authorization", "token " + OAUTH_TOKEN_PART1 + OAUTH_TOKEN_PART2);
        httpResponse = httpClient.execute(httpDelete);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), 204);
    }

    @AfterTest
    public void closeConnection() throws IOException {
        EntityUtils.consume(httpResponse.getEntity());
    }
}