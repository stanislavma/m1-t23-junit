package cookie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieFactoryTest {

    private static FortuneCookieController cookieController;
    private static FortuneCookieFactory fortuneCookieFactory;

    @BeforeAll
    public static void beforeAll() {
        fortuneCookieFactory = new FortuneCookieFactory(
                new FortuneConfig(true),
                singletonList("positive"),
                singletonList("negative")
        );

        cookieController = new FortuneCookieController(fortuneCookieFactory);
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        cookieController.tellFortune();
        cookieController.tellFortune();

        Assertions.assertEquals(2, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        cookieController.tellFortune();
        cookieController.tellFortune();

        Assertions.assertEquals(2, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        cookieController.tellFortune();
        Assertions.assertEquals(1, fortuneCookieFactory.getCookiesBaked());

        fortuneCookieFactory.resetCookiesCreated();
        Assertions.assertEquals(0, fortuneCookieFactory.getCookiesBaked());

    }

}