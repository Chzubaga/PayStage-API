package PayStageAPI;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Payloads {

    public static String getCreateDepositIntentPayloadFromString(String ref_no, String method, String amount, String currency){
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
                "        \"currency\": \""+currency+"\",\n" +
                "        \"amount\": "+amount+",\n" +
                "        \"redirect_url\": \"http://example.com\"\n" +
                "    }\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> getHeadersFromMap(String digest, String pk, String accept){

        Map<String, Object> headers = new HashMap<>();
        headers.put("X-GATEWAY-KEY", pk);
        headers.put("X-GATEWAY-SECRET", digest);
        headers.put("Accept", accept);

        return headers;
    }

    public static String GenenrateRandomRefNo(){
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String refno = "autotest-" + generatedString;
//        System.out.println("autotest-" + generatedString);

        return refno;
    }

}
