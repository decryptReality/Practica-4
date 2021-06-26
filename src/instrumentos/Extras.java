package instrumentos;

import java.util.Random;

class Extras
{
    private static Random random = new Random();

    public static boolean moneda()
    {
        return random.nextBoolean();
    }

    public static int dado(int inf, int sup)
    {
        int dif = sup - inf;
        return inf + random.nextInt(dif);
    }
    public static int dado(int sup)
    {
        return random.nextInt(sup + 1);
    }
}