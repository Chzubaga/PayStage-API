package PayStageAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class DepositDixon {
    @Test
    public void createDepositIntent(){

        String endpoint = "https://api-develop.paystage.net/deposit/intent";
        String digest = "129455db9b759ede77fd1c2d89730478";
        String pk = "pk_FHmnhpf8iX8CeZd385tt8RwoqYguL42G";
        String Accept = "application/json";

        String add1 = "123 Main Street";
        String city = "Anytown";
        String country = "US";
        String email = "sefyocaste@vusra.com";
        String fname = "foo c2";
        String lname = "bar p2";
        String mobile = "+639763725969";
        String state = "ON";
        String zip = "4321";

        String refno = "2023-creddebt-0718xx02";
        String method = "credit_debit_card";
        String currency = "USD";
        String amount = "10";
        String red_url = "http://example.com";


        Map<String, Object> headers = Payloads.getHeadersFromMap(digest,pk,Accept);

        String payload = Payloads.getCreateDepositIntentPayloadFromString(refno,method,amount);

        Map<String, Object> payload_customer = Payloads.getCreateCustomerDetailsFromMap(add1,city, country,email,fname,lname,mobile,state,zip);

        Map<String, Object> payload_details = Payloads.getCreateDetailsFromMap(refno,method,currency,amount,red_url);




        Response response = RestUtils.sendPost(endpoint,payload,headers);
        Assert.assertEquals(response.statusCode(),201);
    }



}
