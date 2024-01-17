package com.services.user.Utilities;

import java.util.Random;

public class GuidGenerator {

    private static final int ID_LENGTH = 16;
    private static final long MAX_RANDOM_VALUE = (long) Math.pow(10, ID_LENGTH);

    public static String generate()
    {
        Random random = new Random();
        long randomValue = random.nextLong() % MAX_RANDOM_VALUE;
        return String.format("%016d", Math.abs(randomValue));
    
    }
    
}
