import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.hasItems;

public class Xueqiu {
    @Test

    public void testSearch(){

        //信任https的任何证书
        useRelaxedHTTPSValidation();

        //given开头表示输入数据
        given().log().all()
                .queryParam("code","sogo")
                .header("Cookie","device_id=6960309afb60a7b975125eb5d2170c74; Hm_lvt_1db88642e346389874251b5a1eded6e3=1523691620; __utmc=1; __utmz=1.1523691620.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utma=1.901344950.1523691620.1523691620.1523764157.2; __utmt=1; remember=1; remember.sig=K4F3faYzmVuqC0iXIERCQf55g2Y; xq_a_token=2694ff2ca73c88dd2a2a744e2ed78089544efbfc; xq_a_token.sig=POWayKpHNsdsuyUlqBGKRXUpegQ; xq_r_token=97444dc59f7391198352535ccc8cf3e64b026c3a; xq_r_token.sig=fvRdoF-DHRvXffYKO3jUUr43kWU; xq_is_login=1; xq_is_login.sig=J3LxgPVPUzbBg3Kee_PquUfih7Q; u=9575305315; u.sig=PikCS3nZsdBwO-z5cuOotue0yaY; __utmb=1.4.10.1523764157; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1523764492")
                .when()
                .get("http://xueqiu.com/stock/search.json")
                .then()
                .log().all()
                .statusCode(200)
                .body("stocks.name",hasItems("搜狗"))
                .body("stocks.code",hasItems("sogo"));
    }

    @Test
    public void testLogin(){
        given()
                .header("")
    }

}

