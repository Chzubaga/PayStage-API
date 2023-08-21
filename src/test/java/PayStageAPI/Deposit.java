package PayStageAPI;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Deposit {
    @Test
    public void dixonPayDeposit() throws IOException {

        System.out.println(System.getProperty("env")+ " env value");
        String env = System.getProperty("env") == null ? "dev" : System.getProperty("env");
        Map<String,String> data = JsonUtils.getJsonDataAsMap(""+env+"/envApiData.json");
        String endpoint = data.get("env");
        String digest = data.get("digest");
        String pk = data.get("pk");
        String Accept = data.get("accept");

        String refno = Payloads.GenenrateRandomRefNo();
        String method = "credit_debit_card";
        String currency = "USD";
        String amount = "10";

        Map<String, Object> headers = Payloads.getHeadersFromMap(digest,pk,Accept);
        String payload = Payloads.getCreateDepositIntentPayloadFromString(refno,method,amount,currency);


        Response response = RestUtils.sendPost(endpoint,payload,headers);
        Assert.assertEquals(response.statusCode(),201);

    }

}
