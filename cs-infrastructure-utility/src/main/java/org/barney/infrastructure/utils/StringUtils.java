package org.barney.infrastructure.utils;

import org.springframework.util.ObjectUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringUtils extends org.springframework.util.StringUtils {
    private static Charset ENCODING = StandardCharsets.UTF_8;

    public static final String EMPTY = "";

    public static void setGlobalCharset(Charset charset) {
        ENCODING = charset;
    }

    public static Charset charset() {
        return ENCODING;
    }

    public static String getTraceString(Throwable throwable) {
        if (ObjectUtils.isEmpty(throwable)) {
            return EMPTY;
        }
        StringWriter stackTrace = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stackTrace));
        stackTrace.flush();
        return stackTrace.toString();
    }

    public static boolean isNotEmpty(String str) {
        return hasLength(str);
    }

    public static boolean isBlank(final CharSequence cs) {
        return !hasText(cs);
    }

    public static boolean hasNotLenght(String str) {
        return str == null || !str.isEmpty();
    }

    public static boolean hasNotLength(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static String defaultString(String nullableStr, String defaultStr) {
        return !hasLength(nullableStr) ? defaultStr : nullableStr;
    }

    public static String firstCharToLower(String str) {
        if (hasNotLenght(str)) {
            return str;
        }
        char first = str.charAt(0);
        if (first >= 'A' && first < 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    public static String underScoreToLowerCamelCase(String userScoreStr) {
        if (userScoreStr == null) {
            return EMPTY;
        }
        char[] chars = userScoreStr.toCharArray();
        boolean meetUnderScore = false;
        int scoreCount = 0;
        for (int i = 0, j = chars.length; i < j; i++) {
            if (chars[i] == '_') {
                meetUnderScore = true;
                ++scoreCount;
                continue;
            }
            if (meetUnderScore) {
                meetUnderScore = false;
                int a = chars[i];
                if (a >= 'a' && a <= 'z') {
                    chars[i] = (char) (a - 32);
                }
            }
        }
        char[] newChars = new char[chars.length - scoreCount];
        int scoreIndex = 0;
        for (int i = 0, j = newChars.length; i < j; ) {
            if (chars[scoreIndex] != '_') {
                newChars[i] = chars[scoreIndex];
                ++scoreIndex;
                ++i;
            } else {
                do {
                    ++scoreIndex;
                } while (chars[scoreIndex] == '_');
            }
        }

        return new String(newChars);
    }
}
