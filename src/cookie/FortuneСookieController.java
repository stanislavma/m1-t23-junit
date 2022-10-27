package cookie;

public class FortuneСookieController {

    private final FortuneCookieFactory fortuneCookieFactory;

    public FortuneСookieController(FortuneCookieFactory fortuneCookieFactory) {
        this.fortuneCookieFactory = fortuneCookieFactory;
    }

    public FortuneCookie tellFortune() {
        return this.fortuneCookieFactory.bakeFortuneCookie();
    }
}