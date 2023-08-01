package property;

import java.util.Random;

public class StringProperty extends Property{
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?,_-(). ";
    private static final int MAX_STRING_LENGTH = 50;
    private String value;

    public StringProperty(String name, String value) {
        super(name, PropertyType.STRING, false, false);
        this.value = value;
    }
    public StringProperty(String name) {
        super(name, PropertyType.STRING, false, true);
        value = generateRandomString();
    }

    private String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        Random randomLength = new Random();

        int length = randomLength.nextInt(MAX_STRING_LENGTH);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
