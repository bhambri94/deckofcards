package tests;

import com.decks.constants.MethodType;
import com.decks.constants.Services;
import com.decks.response.GoResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.decks.requet.GoRequest;
import com.decks.types.ExpectedResponseTypes;

public class SampleTest {

    @Test
    public void generateANewPack(){
        System.out.println("*************Hello generateANewPack new test*************");
        GoRequest request = new GoRequest.Builder("/api/deck/new/", MethodType.GET)
                .build();
        GoResponse response = request.execute(Services.DeckOfCards, ExpectedResponseTypes.OK);
        System.out.print("Generate a new pack Response: ");
        System.out.println(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success")); //Asserting if we got a new pack
        Assert.assertEquals(200,response.getHttpStatusCode()); //Asserting 200 response code
    }

    @Test
    public void DrawACard(){
        System.out.println("*************Hello DrawACard new test*************");
        GoRequest request = new GoRequest.Builder("/api/deck/new/", MethodType.GET)
                .build();
        GoResponse response = request.execute(Services.DeckOfCards, ExpectedResponseTypes.OK);
        System.out.println(response.jsonPath().getBoolean("success"));
        String deckId = response.jsonPath().getString("deck_id");
        request = new GoRequest.Builder("/api/deck/"+deckId+"/draw", MethodType.GET)
                .build();
        System.out.print("Generate a new Card Response : ");
        response = request.execute(Services.DeckOfCards, ExpectedResponseTypes.OK);
        Assert.assertEquals(200,response.getHttpStatusCode()); //Asserting 200 response code
        Assert.assertEquals(51,response.jsonPath().getInt("remaining")); //Asserting remaining cards from deck
        System.out.println(response.jsonPath().getString("cards"));

    }
}
