package org.maples.gem.admin.utility;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ParseUtils {
    private static final String CODE = "VHKLMNRSTU";

    public static Map<String, String> parse(String name) {
        Map<String, String> result = new HashMap<>();

        Matcher matcher = Pattern.compile("^.*?\\W?([VHKLMNRSTUBCDEF]+)\\W?.*$").matcher(name);
        if (matcher.matches()) {
            result.put("code", matcher.group(1));
        }

        matcher = Pattern.compile("^.*(\\d+\\.\\d+).*$").matcher(name);
        if (matcher.matches()) {
            result.put("weight", matcher.group(1));
        }

        matcher = Pattern.compile("^\\s*([^VHKLMNRSTUBCDEF\\s]+).*$").matcher(name);
        if (matcher.matches()) {
            result.put("name", matcher.group(1));
        }

        if (result.containsKey("code")) {
            result.put("cost", String.valueOf(decode(result.get("code"))));
        }

        return result;
    }

    public static String encode(int value) {
        String valueString = String.valueOf(value);
        char suffix = ' ';
        switch (valueString.length()) {
            case 2:
                suffix = 'B';
                valueString = StringUtils.strip(valueString.substring(0, 1), "0");
                break;
            case 3:
                suffix = 'C';
                valueString = StringUtils.strip(valueString.substring(0, 2), "0");
                break;
            case 4:
                suffix = 'D';
                valueString = StringUtils.strip(valueString.substring(0, 3), "0");
                break;
            case 5:
                suffix = 'E';
                valueString = StringUtils.strip(valueString.substring(0, 4), "0");
                break;
            case 6:
                suffix = 'F';
                valueString = StringUtils.strip(valueString.substring(0, 5), "0");
                break;
            default:
                break;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < valueString.length(); i++) {
            builder.append(CODE.charAt(Integer.parseInt(Character.toString(valueString.charAt(i)))));
        }

        Random random = new Random();
        if (suffix != ' ' && random.nextInt(10000) > 6666) {
            builder.append(suffix).append(CODE.charAt(random.nextInt(10)));
        } else {
            builder.append(suffix);
        }

        return builder.toString();
    }

    public static int decode(String value) {
        StringBuilder builder = new StringBuilder();

        char[] chars = value.trim().toCharArray();
        Map<Character, Integer> config = new HashMap<>();
        config.put('V', 0);
        config.put('H', 1);
        config.put('K', 2);
        config.put('L', 3);
        config.put('M', 4);
        config.put('N', 5);
        config.put('R', 6);
        config.put('S', 7);
        config.put('T', 8);
        config.put('U', 9);

        for (char c : chars) {
            if (config.containsKey(c)) {
                builder.append(config.get(c));
                continue;
            } else if (c == 'B') {
                int count = 2 - builder.length();
                for (int i = 0; i < count; i++) {
                    builder.append(0);
                }
            } else if (c == 'C') {
                int count = 3 - builder.length();
                for (int i = 0; i < count; i++) {
                    builder.append(0);
                }
            } else if (c == 'D') {
                int count = 4 - builder.length();
                for (int i = 0; i < count; i++) {
                    builder.append(0);
                }
            } else if (c == 'E') {
                int count = 5 - builder.length();
                for (int i = 0; i < count; i++) {
                    builder.append(0);
                }
            } else if (c == 'F') {
                int count = 6 - builder.length();
                for (int i = 0; i < count; i++) {
                    builder.append(0);
                }
            }
            break;
        }
        return Integer.parseInt(builder.toString());
    }
}
