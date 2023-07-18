package PayStageAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Payloads {

    public static String getCreateDepositIntentPayloadFromString(String ref_no, String method, String amount){
        String payload = "{\n" +
                "    \"customer\": {\n" +
                "        \"address_line_1\": \"123 Main Street\",\n" +
                "        \"city\": \"Anytown\",\n" +
                "        \"country\": \"US\",\n" +
                "        \"email\": \"sefyocaste@vusra.com\",\n" +
                "        \"first_name\": \"foo c2\",\n" +
                "        \"last_name\": \"bar p2\",\n" +
                "        \"mobile\": \"+639763725969\",\n" +
                "        \"state\": \"ON\",\n" +
                "        \"zip\": 4321\n" +
                "    },\n" +
                "    \"details\": {\n" +
                "        \"reference_no\": \""+ref_no+"\",\n" +
                "        \"method\": \""+method+"\",\n" +
                "        \"currency\": \"USD\",\n" +
                "        \"amount\": "+amount+",\n" +
                "        \"redirect_url\": \"http://example.com\"\n" +
                "    }\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> getCreateCustomerDetailsFromMap(String add1, String city, String country, String email, String fname, String lname, String mobile, String state, String zip){

        Map<String, Object> payload_customer = new HashMap<>();
        payload_customer.put("customer.address_line_1", add1);
        payload_customer.put("customer.city", city);
        payload_customer.put("customer.country", country);
        payload_customer.put("customer.email", email);
        payload_customer.put("customer.first_name", fname);
        payload_customer.put("customer.last_name", lname);
        payload_customer.put("customer.mobile", mobile);
        payload_customer.put("customer.state", state);
        payload_customer.put("customer.zip", zip);

        return payload_customer;
    }

    public static Map<String, Object> getCreateDetailsFromMap(String ref_no, String method, String currency, String amount, String redURL){

        Map<String, Object> payload_details = new HashMap<>();
        payload_details.put("details.reference_no", ref_no);
        payload_details.put("details.method", method);
        payload_details.put("details.currency", currency);
        payload_details.put("details.amount", amount);
        payload_details.put("details.redirect_url", redURL);

        return payload_details;
    }


    public static Map<String, Object> getHeadersFromMap(String digest, String pk, String accept){

        Map<String, Object> headers = new HashMap<>();
        headers.put("X-GATEWAY-KEY", pk);
        headers.put("X-GATEWAY-SECRET", digest);
        headers.put("Accept", accept);

        return headers;
    }

}
