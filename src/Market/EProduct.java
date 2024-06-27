package Market;


public enum EProduct {
    
    APPLE ("Яблоко"),
    BANANA("Банан"),
    CHOCO("Шоколад"),
    BAKED("Пироженое" ),
    JUICE ("Сок"),
    ICECREAM("Мороженое"),
    PIE("Пирог"),
    MARSHMALLOW("Зефир"),
    TEA("Чай"),
    HOTCHOCO ("Горячий шоколад");

    private String title;

    EProduct(String string) {
        this.title = string;
    }

    public String getTitle() {
       return title;
   }
}
