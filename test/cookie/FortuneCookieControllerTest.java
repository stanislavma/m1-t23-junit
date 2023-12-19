package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieControllerTest {

    static FortuneCookieController goodCookieController;
    static FortuneCookieController badCookieController;

    @BeforeAll
    public static void beforeAll() {
        FortuneCookieFactory  positiveFortuneCookieFactory = new FortuneCookieFactory(
                new FortuneConfig(true),
                singletonList("positive"),
                singletonList("negative")
        );

        FortuneCookieFactory  negativeFortuneCookieFactory = new FortuneCookieFactory(
                new FortuneConfig(false),
                singletonList("positive"),
                singletonList("negative")
        );

        goodCookieController = new FortuneCookieController(positiveFortuneCookieFactory);
        badCookieController = new FortuneCookieController(negativeFortuneCookieFactory);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        FortuneCookie fortuneCookie = goodCookieController.tellFortune();

        Assertions.assertEquals("positive", fortuneCookie.getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        FortuneCookie fortuneCookie = badCookieController.tellFortune();

        Assertions.assertEquals("negative", fortuneCookie.getFortuneText());
    }

}
