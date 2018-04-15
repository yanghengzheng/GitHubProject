import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class Demo {

    @Test
    public void testJson(){
        when().get("http://127.0.0.1:8000/testhome.json")
                .then()
                    .body("lotto.lottoId",equalTo(5))
                .body("lotto.winners.winnerId",hasItems(54,23));
    }
}
